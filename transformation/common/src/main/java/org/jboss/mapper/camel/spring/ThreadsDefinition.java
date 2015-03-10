//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.26 at 02:37:57 PM EST 
//


package org.jboss.mapper.camel.spring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for threadsDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="threadsDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://camel.apache.org/schema/spring}output">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="executorServiceRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="poolSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maxPoolSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="keepAliveTime" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="timeUnit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maxQueueSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="threadName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rejectedPolicy" type="{http://camel.apache.org/schema/spring}threadPoolRejectedPolicy" />
 *       &lt;attribute name="callerRunsWhenRejected" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute processContents='skip' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "threadsDefinition")
public class ThreadsDefinition
    extends Output
{

    @XmlAttribute(name = "executorServiceRef")
    protected String executorServiceRef;
    @XmlAttribute(name = "poolSize")
    protected Integer poolSize;
    @XmlAttribute(name = "maxPoolSize")
    protected Integer maxPoolSize;
    @XmlAttribute(name = "keepAliveTime")
    protected Long keepAliveTime;
    @XmlAttribute(name = "timeUnit")
    protected String timeUnit;
    @XmlAttribute(name = "maxQueueSize")
    protected Integer maxQueueSize;
    @XmlAttribute(name = "threadName")
    protected String threadName;
    @XmlAttribute(name = "rejectedPolicy")
    protected ThreadPoolRejectedPolicy rejectedPolicy;
    @XmlAttribute(name = "callerRunsWhenRejected")
    protected Boolean callerRunsWhenRejected;

    /**
     * Gets the value of the executorServiceRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutorServiceRef() {
        return executorServiceRef;
    }

    /**
     * Sets the value of the executorServiceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutorServiceRef(String value) {
        this.executorServiceRef = value;
    }

    /**
     * Gets the value of the poolSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPoolSize() {
        return poolSize;
    }

    /**
     * Sets the value of the poolSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPoolSize(Integer value) {
        this.poolSize = value;
    }

    /**
     * Gets the value of the maxPoolSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    /**
     * Sets the value of the maxPoolSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxPoolSize(Integer value) {
        this.maxPoolSize = value;
    }

    /**
     * Gets the value of the keepAliveTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getKeepAliveTime() {
        return keepAliveTime;
    }

    /**
     * Sets the value of the keepAliveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setKeepAliveTime(Long value) {
        this.keepAliveTime = value;
    }

    /**
     * Gets the value of the timeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeUnit() {
        return timeUnit;
    }

    /**
     * Sets the value of the timeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeUnit(String value) {
        this.timeUnit = value;
    }

    /**
     * Gets the value of the maxQueueSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxQueueSize() {
        return maxQueueSize;
    }

    /**
     * Sets the value of the maxQueueSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxQueueSize(Integer value) {
        this.maxQueueSize = value;
    }

    /**
     * Gets the value of the threadName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreadName() {
        return threadName;
    }

    /**
     * Sets the value of the threadName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreadName(String value) {
        this.threadName = value;
    }

    /**
     * Gets the value of the rejectedPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link ThreadPoolRejectedPolicy }
     *     
     */
    public ThreadPoolRejectedPolicy getRejectedPolicy() {
        return rejectedPolicy;
    }

    /**
     * Sets the value of the rejectedPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreadPoolRejectedPolicy }
     *     
     */
    public void setRejectedPolicy(ThreadPoolRejectedPolicy value) {
        this.rejectedPolicy = value;
    }

    /**
     * Gets the value of the callerRunsWhenRejected property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCallerRunsWhenRejected() {
        return callerRunsWhenRejected;
    }

    /**
     * Sets the value of the callerRunsWhenRejected property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCallerRunsWhenRejected(Boolean value) {
        this.callerRunsWhenRejected = value;
    }

}
