package com.ohgiraffers.listener.section02.session;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class MemberDTO implements HttpSessionBindingListener {
	
	private String name;
	private String job;
	private double height;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(String name, String job, double height) {
		super();
		this.name = name;
		this.job = job;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", job=" + job + ", height=" + height + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		/* 해당 클래스로 생성한 인스턴스가 session에 바인딩(setAttribute)되는 경우 동작 */
		System.out.println("value bound!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		/* 해당 클래스로 생성한 인스턴스가 session에 바인딩 해제(removeAttribute 또는 세션 만료)되는 경우 동작 */
		System.out.println("value unbound!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

}
