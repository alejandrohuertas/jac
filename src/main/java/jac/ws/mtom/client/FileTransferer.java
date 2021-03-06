
package jac.ws.mtom.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FileTransferer", targetNamespace = "http://server.mtom.ws.jac/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FileTransferer {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return boolean
     */
    @WebMethod
    @WebResult(targetNamespace="")
    @RequestWrapper(localName = "upload", targetNamespace = "http://server.mtom.ws.jac/", className = "jac.ws.mtom.client.Upload")
    @ResponseWrapper(localName = "uploadResponse", targetNamespace = "http://server.mtom.ws.jac/", className = "jac.ws.mtom.client.UploadResponse")
    @Action(input = "http://server.mtom.ws.jac/FileTransferer/uploadRequest", output = "http://server.mtom.ws.jac/FileTransferer/uploadResponse")
    public Boolean upload(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        byte[] arg1);

}
