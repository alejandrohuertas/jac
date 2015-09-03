package jac.ws.mtom.client;

import javax.xml.ws.soap.MTOMFeature;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A client program that demonstrates how to use MTOM to optimize binary data
 * transfer with JAX-WS web services.
 * 
 *
 */
public class WebServiceAppClient {

	private FileTransfererService service; 
	private FileTransferer port;
	
	@Autowired
	Logger logger;
	
	public WebServiceAppClient(){
		service= new FileTransfererService();
		port= service.getFileTransfererPort(new MTOMFeature(10240));
	}
	public boolean sendFile(String fileName, byte[] fileBytes){

		// uploads a file

		return  port.upload(fileName, fileBytes);
		
		
	}
}