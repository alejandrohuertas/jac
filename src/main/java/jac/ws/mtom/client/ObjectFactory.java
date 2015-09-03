
package jac.ws.mtom.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jac.ws.mtom.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UploadResponse_QNAME = new QName("http://server.mtom.ws.jac/", "uploadResponse");
    private final static QName _Upload_QNAME = new QName("http://server.mtom.ws.jac/", "upload");
    private final static QName _UploadArg1_QNAME = new QName("", "arg1");
	private static final QName _UploadResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jac.ws.mtom.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadResponse }
     * 
     */
    public UploadResponse createUploadResponse() {
        return new UploadResponse();
    }

    /**
     * Create an instance of {@link Upload }
     * 
     */
    public Upload createUpload() {
        return new Upload();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.mtom.ws.jac/", name = "uploadResponse")
    public JAXBElement<UploadResponse> createUploadResponse(UploadResponse value) {
        return new JAXBElement<UploadResponse>(_UploadResponse_QNAME, UploadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upload }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.mtom.ws.jac/", name = "upload")
    public JAXBElement<Upload> createUpload(Upload value) {
        return new JAXBElement<Upload>(_Upload_QNAME, Upload.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "arg1", scope = Upload.class)
    public JAXBElement<byte[]> createUploadArg1(byte[] value) {
        return new JAXBElement<byte[]>(_UploadArg1_QNAME, byte[].class, Upload.class, ((byte[]) value));
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "return", scope = UploadResponse.class)
    public JAXBElement<Boolean> createDownloadResponseReturn(Boolean value) {
        return new JAXBElement<Boolean>(_UploadResponseReturn_QNAME, Boolean.class, UploadResponse.class, ((Boolean) value));
    }

}
