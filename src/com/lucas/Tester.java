package com.lucas;

import java.io.IOException;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class Tester {
	public String doPatch(String uri) throws ClientProtocolException, IOException {
		HttpPatch patch = new HttpPatch(uri);
		CloseableHttpClient http = HttpClientBuilder.create().build();
		
		String jsonPayload = "";
		// Teste
		patch.setEntity(new StringEntity(jsonPayload, ContentType.APPLICATION_JSON));
		
		HttpResponse response = http.execute(patch);

		String out = response.getEntity().toString();
		
		return out;
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String out = new Tester().doPatch("http://www.google.com.br");
		System.out.println(out);
	}
}
