package com.swappy.makeathon.bean;

import org.json.JSONObject;

//import java.util.List;

public class PlaylistBean {
	
	private Integer deviceId;
//	private List<PlaylistJSONBean> jsonPlaylist;
	private JSONObject jsonPlaylist;

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public JSONObject getJsonPlaylist() {
		return jsonPlaylist;
	}

	public void setJsonPlaylist(JSONObject jsonPlaylist) {
		this.jsonPlaylist = jsonPlaylist;
	}
//	
//	public static void main(String[] args) {
//		PlaylistBean playlistBean = new PlaylistBean();
//		playlistBean.setDeviceId(1234);
//		playlistBean.setJsonPlaylist(new JSONObject("{ \"test1\" : \"1234\", \"test2\" : \"4567\" }"));
//		System.out.println(playlistBean.getJsonPlaylist().toString());
//	}

}
