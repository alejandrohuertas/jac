
package jac.ws.mtom.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uploadResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uploadResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadResponse", propOrder = { "_return" })
public class UploadResponse {
	@XmlElementRef(name = "return", type = JAXBElement.class, required = false)
	protected JAXBElement<Boolean> _return;

	/**
	 * Gets the value of the return property.
	 * 
	 * @return  object is {@link Boolean}
	 * 
	 */
	public JAXBElement<Boolean> getReturn() {
		return _return;
	}

	/**
	 * Sets the value of the return property.
	 * 
	 * @param value
	 *           
	 * 
	 */
	public void setReturn(JAXBElement<Boolean> value) {
		this._return = value;
	}

}
