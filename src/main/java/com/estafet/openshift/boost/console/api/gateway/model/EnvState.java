package com.estafet.openshift.boost.console.api.gateway.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EnvState {

	private String name;

	private State build;

	private State promote;

	private State test;

	private State goLive;

	private State backOut;

	private List<AppState> apps = new ArrayList<AppState>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getBuild() {
		return build;
	}

	public void setBuild(State build) {
		this.build = build;
	}

	public State getPromote() {
		return promote;
	}

	public void setPromote(State promote) {
		this.promote = promote;
	}

	public State getTest() {
		return test;
	}

	public void setTest(State test) {
		this.test = test;
	}

	public State getGoLive() {
		return goLive;
	}

	public void setGoLive(State goLive) {
		this.goLive = goLive;
	}

	public State getBackOut() {
		return backOut;
	}

	public void setBackOut(State backOut) {
		this.backOut = backOut;
	}

	public List<AppState> getApps() {
		return apps;
	}

	public void setApps(List<AppState> apps) {
		this.apps = apps;
	}
	
	public AppState appState(String name) {
		for (AppState appState : apps) {
			if (appState.getName().equals(name)) {
				return appState;
			}
		}
		throw new RuntimeException("Cannot find state for app - " + name);
	}

	@Override
	public String toString() {
		return "EnvState [name=" + name + ", build=" + build + ", promote=" + promote + ", test=" + test + ", goLive="
				+ goLive + ", backOut=" + backOut + ", apps=" + apps + "]";
	}
	
}
