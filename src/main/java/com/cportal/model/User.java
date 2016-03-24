package com.cportal.model;
 
public class User {
    private String regName;
    private String regComp;
    private String regEmail;
    private String regMobile;
    private String regPwd;
    private String reRegPwd;
    private String captcha;
    
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getRegComp() {
		return regComp;
	}
	public void setRegComp(String regComp) {
		this.regComp = regComp;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	public String getRegMobile() {
		return regMobile;
	}
	public void setRegMobile(String regMobile) {
		this.regMobile = regMobile;
	}
	public String getRegPwd() {
		return regPwd;
	}
	public void setRegPwd(String regPwd) {
		this.regPwd = regPwd;
	}
	public String getReRegPwd() {
		return reRegPwd;
	}
	public void setReRegPwd(String reRegPwd) {
		this.reRegPwd = reRegPwd;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
}