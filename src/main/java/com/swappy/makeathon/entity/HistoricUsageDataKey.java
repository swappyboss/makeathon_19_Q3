package com.swappy.makeathon.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HistoricUsageDataKey implements Serializable{
	
	private String deviceId;
	
	private String usageKey;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getUsageKey() {
		return usageKey;
	}

	public void setUsageKey(String usageKey) {
		this.usageKey = usageKey;
	}
	
}
