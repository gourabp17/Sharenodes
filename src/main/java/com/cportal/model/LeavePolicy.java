package com.cportal.model;

import java.util.Calendar;

public class LeavePolicy {
 String cName;
 String cEmail;
 String current_year;
 String holidaylist;
 double el;
 double cl;
 double sl;
 String leave_unit;
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public String getcEmail() {
	return cEmail;
}
public void setcEmail(String cEmail) {
	this.cEmail = cEmail;
}
public String getCurrent_year() {
	return current_year;
}
public void setCurrent_year() {
	Calendar now = Calendar.getInstance();   // Gets the current date and time
	int year = now.get(Calendar.YEAR);
	this.current_year = Integer.toString(year);
}
public String getHolidaylist() {
	return holidaylist;
}
public void setHolidaylist(String holidaylist) {
	this.holidaylist = holidaylist;
}
public double getEl() {
	return el;
}
public void setEl(double d) {
	this.el = d;
}
public double getCl() {
	return cl;
}
public void setCl(double d) {
	this.cl = d;
}
public double getSl() {
	return sl;
}
public void setSl(double d) {
	this.sl = d;
}
public String getLeave_unit() {
	return leave_unit;
}
public void setLeave_unit(String leave_unit) {
	this.leave_unit = leave_unit;
}
}
