package com.paybiz.platform;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class ISOBuilder {

	public static String build(Map<Integer, String> input, String Mti) throws IOException, ISOException {

		GenericPackager packager = new GenericPackager("src/main/resources/basic.xml");
		Logger logger = Logger.getLogger("log");
		logger.setLevel(Level.INFO);

		ISOMsg isoMsg = new ISOMsg();
		isoMsg.setPackager(packager);
		isoMsg.setMTI(Mti);

		Iterator<Map.Entry<Integer, String>> itr = input.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<Integer, String> entry = itr.next();
			isoMsg.set(entry.getKey(), entry.getValue());
		}

		byte[] result = isoMsg.pack();

		return new String(result);
	}
}
