package com.swappy.makeathon.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swappy.makeathon.bean.HistoricUsageDataBean;
import com.swappy.makeathon.entity.HistoricUsageDataEntity;
import com.swappy.makeathon.entity.HistoricUsageDataKey;
import com.swappy.makeathon.entity.PlaylistEntity;
import com.swappy.makeathon.repository.HistoricUsageRepository;
import com.swappy.makeathon.repository.PlaylistRepository;

@Service
public class PlaylistService {
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private HistoricUsageRepository historicUsageRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public static final String[] POSITION_ARRAY = {"topLeft","topMiddle", "topRight", 
													"centreLeft", "centreMiddle", "centreRight",
													"bottomLeft","bottomMiddle","bottomRight"};
	
	public static final String FILE_DETAIL_URL = "http://192.168.225.208:8081/storage/getFileDetail/";
	
	public String savePlaylist(String playlistString) {
		
		JSONObject playlist = new JSONObject(playlistString);
		
		JSONArray jsonPlaylist = playlist.getJSONArray("jsonPlaylist");
		String deviceId = playlist.getString("deviceId");
		
		PlaylistEntity playlistEntity = new PlaylistEntity(deviceId, jsonPlaylist.toString());
		
		JSONObject jsonTemplateObject;
		
		for (int i=0; i<jsonPlaylist.length(); i++ ) {
			jsonTemplateObject = jsonPlaylist.getJSONObject(i);
			Double duration = jsonTemplateObject.getDouble("durationInSeconds");
			
			for (String position : POSITION_ARRAY) {
				if (jsonTemplateObject.has(position)) {
					JSONObject positionObject = jsonTemplateObject.getJSONObject(position);
					
					String contentType = positionObject.getString("contentType");
					
					HistoricUsageDataKey key = new HistoricUsageDataKey();
					key.setDeviceId(deviceId);
					
					if (contentType.equals("text")) {
						key.setUsageKey("text");
					}else if(contentType.equals("image")) {
						key.setUsageKey(""+positionObject.getInt("fileId"));
					}
					if(key.getUsageKey() == null) {
						continue;
					}
					
					HistoricUsageDataEntity usageDataEntity = new HistoricUsageDataEntity();
					usageDataEntity.setDataKey(key);
					usageDataEntity.setUsageType(positionObject.getString("contentType"));
					if(historicUsageRepository.existsById(key)) {
						usageDataEntity.setDuration(historicUsageRepository.getOne(key).getDuration() + duration);
					}else {
						usageDataEntity.setDuration(duration);
					}
					historicUsageRepository.save(usageDataEntity);
				}
			}
			
		}
		
		return playlistRepository.save(playlistEntity).getDeviceId();
	}
	
	public String getPlaylist(String deviceId) {
		return playlistRepository.getOne(deviceId).getJsonPlaylist();
	}
	
	public List<HistoricUsageDataBean> fetchUsageHistory(String deviceId){
		List<HistoricUsageDataEntity> historicUsageDataEntityList = historicUsageRepository.findByDataKey_DeviceId(deviceId);
		List<HistoricUsageDataBean> historicUsageDataBeanList = new ArrayList<HistoricUsageDataBean>();
		
		for(HistoricUsageDataEntity dataEntity : historicUsageDataEntityList) {
			HistoricUsageDataBean dataBean = new HistoricUsageDataBean();
			dataBean.setDuration(dataEntity.getDuration());
			dataBean.setUsageType(dataEntity.getUsageType());
			
			if (dataBean.getUsageType().equals("image")) {
				
				Integer fileId = Integer.parseInt(dataEntity.getDataKey().getUsageKey());
				dataBean.setFileId(dataEntity.getDataKey().getUsageKey());
				
				String fileDetails = restTemplate.getForObject(FILE_DETAIL_URL+fileId, String.class);
				
				System.out.println("Swappy - " + fileDetails);
				
				JSONObject fileDetailsJSON = new JSONObject(fileDetails);
				
				dataBean.setFileName(fileDetailsJSON.getString("fileName"));
			}else {
				dataBean.setFileName("Text");
			}
			historicUsageDataBeanList.add(dataBean);
		}
		
		return historicUsageDataBeanList;
	}
	
}
