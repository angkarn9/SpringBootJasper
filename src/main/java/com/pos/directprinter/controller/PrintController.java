package com.pos.directprinter.controller;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pos.directprinter.model.JsonResponse;
import com.pos.directprinter.service.CallPrinter;

@RestController
public class PrintController {
	private static ResourceBundle resConfig = null;
	private final static Logger logger = Logger.getLogger(PrintController.class);
	
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public ResponseEntity<?> print(){
	    try{
			JsonResponse jsonRes = new JsonResponse();
			jsonRes.setStatusCode("200");
			CallPrinter.printSlip("TEST");
	        return new ResponseEntity<>(jsonRes, HttpStatus.OK);
	    }catch(Exception ex){
	        String errorMessage;
	        errorMessage = ex + " <== error";
	        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	    }
	}
}