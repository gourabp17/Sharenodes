package com.cportal.ui.model;

import java.util.LinkedList;


public class CompanyBroadcast {
	public String broadcasterPath;
	public String broadcasterName;
	public String broadcastHeader;
	public String broadcastMsg;
	public String getbroadcasterPath() {
		return broadcasterPath;
	}
	public void setbroadcasterPath(String broadcasterPath) {
		this.broadcasterPath = broadcasterPath;
	}
	public String getBroadcasterName() {
		return broadcasterName;
	}
	public void setBroadcasterName(String broadcasterName) {
		this.broadcasterName = broadcasterName;
	}
	public String getBroadcastHeader() {
		return broadcastHeader;
	}
	public void setBroadcastHeader(String broadcastHeader) {
		this.broadcastHeader = broadcastHeader;
	}
	public String getBroadcastMsg() {
		return broadcastMsg;
	}
	public void setBroadcastMsg(String broadcastMsg) {
		this.broadcastMsg = broadcastMsg;
	}
	public LinkedList<CompanyBroadcast> getList() {
		// TODO Auto-generated method stub
		LinkedList<CompanyBroadcast> list = new LinkedList<CompanyBroadcast>();
		CompanyBroadcast cb= new CompanyBroadcast();
		cb.setbroadcasterPath("myphoto");
		cb.setBroadcasterName("Paul");
		cb.setBroadcastHeader("header");
		cb.setBroadcastMsg("Hello this is the message");
		CompanyBroadcast cb2= new CompanyBroadcast();
		cb2.setbroadcasterPath("myphoto2");
		cb2.setBroadcasterName("Paul");
		cb2.setBroadcastHeader("header");
		cb2.setBroadcastMsg("Hello this is the message");
		CompanyBroadcast cb3= new CompanyBroadcast();
		cb3.setbroadcasterPath("myphoto3");
		cb3.setBroadcasterName("Paul");
		cb3.setBroadcastHeader("header");
		cb3.setBroadcastMsg("Anim pariatur cliche reprehenderit,							enim eiusmod high life accusamus terry richardson ad squid. 3							wolf moon officia aute, non cupidatat skateboard dolor brunch.							Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon							tempor, sunt aliqua put a bird on it squid single-origin coffee							nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,							craft beer labore wes anderson cred nesciunt sapiente ea							proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat							craft beer farm-to-table, raw denim aesthetic synth nesciunt you							probably haven't heard of them accusamus labore sustainable VHS.");
		list.add(cb);
		list.add(cb2);
		list.add(cb3);
		return list;	}
	
	
}
