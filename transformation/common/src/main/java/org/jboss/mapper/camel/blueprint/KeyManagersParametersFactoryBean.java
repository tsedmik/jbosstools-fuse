//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.13 at 12:09:41 PM EST 
//


package org.jboss.mapper.camel.blueprint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for keyManagersParametersFactoryBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="keyManagersParametersFactoryBean">
 *   &lt;complexContent>
 *     &lt;extension base="{http://camel.apache.org/schema/blueprint}abstractKeyManagersParametersFactoryBean">
 *       &lt;sequence>
 *         &lt;element name="keyStore" type="{http://camel.apache.org/schema/blueprint}keyStoreParametersFactoryBean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "keyManagersParametersFactoryBean", propOrder = {
    "keyStore"
})
public class KeyManagersParametersFactoryBean
    extends AbstractKeyManagersParametersFactoryBean
{

    protected KeyStoreParametersFactoryBean keyStore;

    /**
     * Gets the value of the keyStore property.
     * 
     * @return
     *     possible object is
     *     {@link KeyStoreParametersFactoryBean }
     *     
     */
    public KeyStoreParametersFactoryBean getKeyStore() {
        return keyStore;
    }

    /**
     * Sets the value of the keyStore property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyStoreParametersFactoryBean }
     *     
     */
    public void setKeyStore(KeyStoreParametersFactoryBean value) {
        this.keyStore = value;
    }

}
