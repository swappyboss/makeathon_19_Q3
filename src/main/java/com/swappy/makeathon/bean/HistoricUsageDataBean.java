package com.swappy.makeathon.bean;

public class HistoricUsageDataBean {
	private String usageType;
	private String fileId;
	private String fileName;
	private Double duration;
	
	public String getUsageType() {
		return usageType;
	}
	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	
}
