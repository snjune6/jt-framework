package com.link.jk.jkframework.comm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JavaScript {

	private String message;
	private String location;
	private String method;
	private String src;
	private String[] methods;

	public JavaScript() {
		this.src = "";
		this.message = "";
		this.location = "";
		this.method = "";
		this.methods = null;
	}

	public JavaScript(String message) {
		this.src = "";
		this.message = message;
		this.location = "";
		this.method = "";
		this.methods = null;
	}

	public JavaScript(String message, String location) {
		this.src = "";
		this.message = message;
		this.location = location;
		this.method = "";
		this.methods = null;
	}

	public JavaScript(String message, String[] methods) {
		this.src = "";
		this.message = message;
		this.location = "";
		this.method = "";
		this.methods = methods;
	}

	public JavaScript(String[] methods) {
		this.src = "";
		this.message = "";
		this.location = "";
		this.method = "";
		this.methods = methods;
	}

	public JavaScript(String message, String location, String method, String[] methods) {
		this.src = "";
		this.message = message;
		this.location = location;
		this.method = method;
		this.methods = methods;
	}
}
