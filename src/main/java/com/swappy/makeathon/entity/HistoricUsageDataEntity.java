package com.swappy.makeathon.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class HistoricUsageDataEntity {
	
	@EmbeddedId
	private HistoricUsageDataKey dataKey;
	@NotNull
	private Double duration=0.0;
	private String usageType;
	
	public HistoricUsageDataKey getDataKey() {
		return dataKey;
	}
	public void setDataKey(HistoricUsageDataKey dataKey) {
		this.dataKey = dataKey;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public String getUsageType() {
		return usageType;
	}
	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}
}
