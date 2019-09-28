package com.swappy.makeathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swappy.makeathon.bean.HistoricUsageDataBean;
import com.swappy.makeathon.service.PlaylistService;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;
	
	@PostMapping(value = "/savePlaylist")
	public String savePlaylist(@RequestBody String playlistString) {
		
		return "The playlist for device id " + playlistService.savePlaylist(playlistString) + " has been saved successfully";
	}
	
	@GetMapping(value = "/fetchPlaylist")
	public String getPlaylist(@RequestParam String deviceId) {
		
		return playlistService.getPlaylist(deviceId);
	}
	
	@GetMapping(value = "/fetchUsageHistory")
	public List<HistoricUsageDataBean> fetchUsageHistory(@RequestParam String deviceId){
		return playlistService.fetchUsageHistory(deviceId);
	}

}
