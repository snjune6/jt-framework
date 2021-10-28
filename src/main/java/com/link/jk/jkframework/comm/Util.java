package com.link.jk.jkframework.comm;

import java.sql.Timestamp;

public class Util {



	public static void echo(Object object) {
		System.out.println(object);
	}

	public static Timestamp getJkTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}


}
