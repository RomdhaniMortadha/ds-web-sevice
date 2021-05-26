package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.service.DsEligebiltyService;

import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Endpoint
public class DsEligeblityEndPoint {
	
	public static final String nameSpace = "http://www.tekup.de/soap/models/whitetest" ;
	@Autowired
	private DsEligebiltyService service;

	@PayloadRoot(namespace = nameSpace, localPart = "StudentRequest")
	@ResponsePayload
	public WhiteTestResponse getLoanStatus(@RequestPayload StudentRequest StudentRequest) {
		//call a service
		return service.checkEligebilty(StudentRequest);
	}

}
