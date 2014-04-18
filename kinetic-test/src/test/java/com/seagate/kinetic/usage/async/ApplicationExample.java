package com.seagate.kinetic.usage.async;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import kinetic.client.ClientConfiguration;
import kinetic.client.Entry;
import kinetic.client.EntryMetadata;
import kinetic.client.KineticClient;
import kinetic.client.KineticClientFactory;
import kinetic.client.KineticException;

/**
 * 
 * put async example.
 * <p>
 * 
 * @author Chenchong(Emma) Li
 * 
 */
public class ApplicationExample {

	private static int limit = 50;
	private static int putCount = 1000;

	public static void main(String[] args) throws KineticException,
			InterruptedException {
		Logger logger = Logger.getLogger(ApplicationExample.class.getName());

		if (2 == args.length) {
			limit = Integer.parseInt(args[0]);
			putCount = Integer.parseInt(args[1]);
		}

		ClientConfiguration clientConfig = new ClientConfiguration();
		KineticClient client = null;

		clientConfig.setHost("localhost");
		clientConfig.setPort(8123);
		client = KineticClientFactory.createInstance(clientConfig);

		byte[] value = "value".getBytes();
		byte[] newVersion = "0".getBytes();

		List<byte[]> keys = new ArrayList<byte[]>();

		// generate key
		for (int i = 0; i < putCount; i++) {
			byte[] key = ("key" + i).getBytes();
			keys.add(key);
		}

		// put entry
		EntryMetadata emd = new EntryMetadata();
		PutAsyncUsage putAsync = new PutAsyncUsage(limit);
		for (int j = 0; j < putCount; j++) {
			byte[] key = keys.get(j);
			Entry entry = new Entry(key, value, emd);
			putAsync.Put(entry, newVersion, client);
		}

		// clean up
		EntryMetadata emdD = new EntryMetadata();
		emdD.setVersion("0".getBytes());
		for (int k = 0; k < keys.size(); k++) {
			Entry entry = new Entry(keys.get(k), value, emdD);
			logger.info("delete key=" + new String(entry.getKey()));
			client.delete(entry);
		}

		client.close();
	}
}
