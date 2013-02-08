package com.nationwide.techcon.models.adapters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UTCDateAdapter extends XmlAdapter<String, Date> {
	
	private SimpleDateFormat sdf;
	
	public UTCDateAdapter() {
		super();
		this.sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		this.sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		this.sdf.setLenient(false);
	}

	@Override
	public Date unmarshal(String v) throws Exception {
		return sdf.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return sdf.format(v);
	}

}
