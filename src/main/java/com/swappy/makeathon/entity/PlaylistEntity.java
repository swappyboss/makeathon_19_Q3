package com.swappy.makeathon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "playlist_entity")
public class PlaylistEntity {
	
	@Id
	private String deviceId;
	
	@Column(length = 2000)
	@Lob
	private String jsonPlaylist;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getJsonPlaylist() {
		return jsonPlaylist;
	}

	public void setJsonPlaylist(String jsonPlaylist) {
		this.jsonPlaylist = jsonPlaylist;
	}
	
	public PlaylistEntity() {}
	
	public PlaylistEntity(String deviceId, String jsonPlaylist) {
		super();
		this.deviceId = deviceId;
		this.jsonPlaylist = jsonPlaylist;
	}

}
