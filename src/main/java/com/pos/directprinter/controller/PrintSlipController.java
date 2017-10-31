package com.pos.directprinter.controller;

import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pos.directprinter.model.JsonResponse;
import com.pos.directprinter.model.Slip;
import com.pos.directprinter.service.PrinterService;

@RestController
public class PrintSlipController {
//	private final static Logger logger = Logger.getLogger(PrintSlipController.class);
	
	@RequestMapping(value = "/printslip", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> printSlip(@RequestBody List<Slip> slips){
	    try{
			PrinterService service = new PrinterService();
			Resource resource = new ClassPathResource("jrxml/slip.jasper");
			
			service.execute(slips, resource.getFile());
			
			JsonResponse jsonResp = new JsonResponse();
			jsonResp.setDesc("กำลังพิมพ์ Slip ออกทางเครื่องพิมพ์...");
	        return new ResponseEntity<>(jsonResp, HttpStatus.OK);
	    }catch(Exception ex){
	        String errorMessage;
	        errorMessage = ex + " <== error";
	        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	    }
	}
}