package com.example.netty.learning.time;

import java.util.Date;

public class UnixTime {

	private final long value;
	
	public UnixTime() {
		this(System.currentTimeMillis() / 1000L + 2208988800L);
	}

	public UnixTime(long value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public long value() {
		return value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new Date((value() - 2208988800L) * 1000L).toString();
	}
	
}
