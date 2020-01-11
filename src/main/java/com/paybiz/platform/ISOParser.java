package com.paybiz.platform;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.json.JSONObject;

public class ISOParser {

	public static JSONObject parse(String message) throws IOException, ISOException {


		GenericPackager packager = new GenericPackager("src/main/resources/basic.xml");
		ISOMsg isoMsg = new ISOMsg();
		isoMsg.setPackager(packager);
		isoMsg.unpack(message.getBytes());
		
		 JSONObject output = new JSONObject();
		
		output.put("MTI", new Integer(isoMsg.getMTI()));
		
		for (int i=1;i<=isoMsg.getMaxField();i++) {
			if (isoMsg.hasField(i)) {
				output.put(Integer.toString(i), isoMsg.getString(i));
			}
		}
		
		return output;

	}
	
}
