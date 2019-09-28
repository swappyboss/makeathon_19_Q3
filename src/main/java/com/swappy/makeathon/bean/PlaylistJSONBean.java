package com.swappy.makeathon.bean;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.hibernate.cfg.SetSimpleValueTypeSecondPass;

public class PlaylistJSONBean {
	
	private Integer templateId;
	private LocalDateTime startTime;
	private double durationInSeconds;
	private PlaylistJSONContentBean topLeft;
	private PlaylistJSONContentBean topMiddle;
	private PlaylistJSONContentBean topRight;
	private PlaylistJSONContentBean centreLeft;
	private PlaylistJSONContentBean centreMiddle;
	private PlaylistJSONContentBean centreRight;
	private PlaylistJSONContentBean bottomLeft;
	private PlaylistJSONContentBean bottomMiddle;
	private PlaylistJSONContentBean bottomRight;
	
//	public void setStartTime(LocalDateTime startTime) {
//		this.startTime = startTime;
//	}
//	public LocalDateTime getStartTime() {
//		return this.startTime;
//	}
//	
//	public static void main(String[] args) {
//		 PlaylistJSONBean bean = new PlaylistJSONBean();
//		 bean.setStartTime(LocalDateTime.of(2019, Month.SEPTEMBER, 27, 22, 52, 50));
//		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//		 System.out.println(formatter.format(bean.getStartTime()));
//	}
	
}
