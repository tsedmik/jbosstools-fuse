//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.26 at 02:37:57 PM EST 
//


package org.jboss.mapper.camel.spring;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for expressionNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="expressionNode">
 *   &lt;complexContent>
 *     &lt;extension base="{http://camel.apache.org/schema/spring}processorDefinition">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}expressionDefinition"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}constant"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}el"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}groovy"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}header"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}jxpath"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}javaScript"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}jsonpath"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}language"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}method"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}mvel"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}ognl"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}php"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}property"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}python"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}ref"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}ruby"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}simple"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}spel"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}sql"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}tokenize"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}vtdxml"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}xtokenize"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}xpath"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}xquery"/>
 *         &lt;/choice>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://camel.apache.org/schema/spring}aop"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}aggregate"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}bean"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}doCatch"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}when"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}choice"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}otherwise"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}convertBodyTo"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}delay"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}dynamicRouter"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}enrich"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}filter"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}doFinally"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}idempotentConsumer"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}inOnly"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}inOut"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}intercept"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}interceptFrom"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}interceptToEndpoint"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}loadBalance"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}log"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}loop"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}marshal"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}multicast"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}onCompletion"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}onException"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}pipeline"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}policy"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}pollEnrich"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}process"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}recipientList"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}removeHeader"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}removeHeaders"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}removeProperty"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}resequence"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}rollback"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}route"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}routingSlip"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}sample"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}setBody"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}setExchangePattern"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}setFaultBody"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}setHeader"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}setOutHeader"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}setProperty"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}sort"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}split"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}stop"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}threads"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}throttle"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}throwException"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}to"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}transacted"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}transform"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}doTry"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}unmarshal"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}validate"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}wireTap"/>
 *           &lt;element ref="{http://camel.apache.org/schema/spring}restBinding"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='skip' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "expressionNode", propOrder = {
    "expressionDefinition",
    "constant",
    "el",
    "groovy",
    "header",
    "jxpath",
    "javaScript",
    "jsonpath",
    "language",
    "method",
    "mvel",
    "ognl",
    "php",
    "property",
    "python",
    "ref",
    "ruby",
    "simple",
    "spel",
    "sql",
    "tokenize",
    "vtdxml",
    "xtokenize",
    "xpath",
    "xquery",
    "aopOrAggregateOrBean"
})
@XmlSeeAlso({
    SplitDefinition.class,
    DelayDefinition.class,
    LoopDefinition.class,
    ThrottleDefinition.class,
    FilterDefinition.class,
    IdempotentConsumerDefinition.class,
    WhenDefinition.class,
    NoOutputExpressionNode.class
})
public class ExpressionNode
    extends ProcessorDefinition
{

    protected Expression expressionDefinition;
    protected ConstantExpression constant;
    protected ElExpression el;
    protected GroovyExpression groovy;
    protected HeaderExpression header;
    protected JxPathExpression jxpath;
    protected JavaScriptExpression javaScript;
    protected JsonPathExpression jsonpath;
    protected LanguageExpression language;
    protected MethodCallExpression method;
    protected MvelExpression mvel;
    protected OgnlExpression ognl;
    protected PhpExpression php;
    @XmlElement(nillable = true)
    protected Object property;
    protected PythonExpression python;
    protected RefExpression ref;
    protected RubyExpression ruby;
    protected SimpleExpression simple;
    protected SpELExpression spel;
    protected SqlExpression sql;
    protected TokenizerExpression tokenize;
    protected VtdXmlExpression vtdxml;
    protected XmlTokenizerExpression xtokenize;
    protected XPathExpression xpath;
    protected XQueryExpression xquery;
    @XmlElements({
        @XmlElement(name = "aop", type = AopDefinition.class),
        @XmlElement(name = "aggregate", type = AggregateDefinition.class),
        @XmlElement(name = "bean", type = BeanDefinition.class),
        @XmlElement(name = "doCatch", type = CatchDefinition.class),
        @XmlElement(name = "when", type = WhenDefinition.class),
        @XmlElement(name = "choice", type = ChoiceDefinition.class),
        @XmlElement(name = "otherwise", type = OtherwiseDefinition.class),
        @XmlElement(name = "convertBodyTo", type = ConvertBodyDefinition.class),
        @XmlElement(name = "delay", type = DelayDefinition.class),
        @XmlElement(name = "dynamicRouter", type = DynamicRouterDefinition.class),
        @XmlElement(name = "enrich", type = EnrichDefinition.class),
        @XmlElement(name = "filter", type = FilterDefinition.class),
        @XmlElement(name = "doFinally", type = FinallyDefinition.class),
        @XmlElement(name = "idempotentConsumer", type = IdempotentConsumerDefinition.class),
        @XmlElement(name = "inOnly", type = InOnlyDefinition.class),
        @XmlElement(name = "inOut", type = InOutDefinition.class),
        @XmlElement(name = "intercept", type = InterceptDefinition.class),
        @XmlElement(name = "interceptFrom", type = InterceptFromDefinition.class),
        @XmlElement(name = "interceptToEndpoint", type = InterceptSendToEndpointDefinition.class),
        @XmlElement(name = "loadBalance", type = LoadBalanceDefinition.class),
        @XmlElement(name = "log", type = LogDefinition.class),
        @XmlElement(name = "loop", type = LoopDefinition.class),
        @XmlElement(name = "marshal", type = MarshalDefinition.class),
        @XmlElement(name = "multicast", type = MulticastDefinition.class),
        @XmlElement(name = "onCompletion", type = OnCompletionDefinition.class),
        @XmlElement(name = "onException", type = OnExceptionDefinition.class),
        @XmlElement(name = "pipeline", type = PipelineDefinition.class),
        @XmlElement(name = "policy", type = PolicyDefinition.class),
        @XmlElement(name = "pollEnrich", type = PollEnrichDefinition.class),
        @XmlElement(name = "process", type = ProcessDefinition.class),
        @XmlElement(name = "recipientList", type = RecipientListDefinition.class),
        @XmlElement(name = "removeHeader", type = RemoveHeaderDefinition.class),
        @XmlElement(name = "removeHeaders", type = RemoveHeadersDefinition.class),
        @XmlElement(name = "removeProperty", type = RemovePropertyDefinition.class),
        @XmlElement(name = "resequence", type = ResequenceDefinition.class),
        @XmlElement(name = "rollback", type = RollbackDefinition.class),
        @XmlElement(name = "route", type = RouteDefinition.class),
        @XmlElement(name = "routingSlip", type = RoutingSlipDefinition.class),
        @XmlElement(name = "sample", type = SamplingDefinition.class),
        @XmlElement(name = "setBody", type = SetBodyDefinition.class),
        @XmlElement(name = "setExchangePattern", type = SetExchangePatternDefinition.class),
        @XmlElement(name = "setFaultBody", type = SetFaultBodyDefinition.class),
        @XmlElement(name = "setHeader", type = SetHeaderDefinition.class),
        @XmlElement(name = "setOutHeader", type = SetOutHeaderDefinition.class),
        @XmlElement(name = "setProperty", type = SetPropertyDefinition.class),
        @XmlElement(name = "sort", type = SortDefinition.class),
        @XmlElement(name = "split", type = SplitDefinition.class),
        @XmlElement(name = "stop", type = StopDefinition.class),
        @XmlElement(name = "threads", type = ThreadsDefinition.class),
        @XmlElement(name = "throttle", type = ThrottleDefinition.class),
        @XmlElement(name = "throwException", type = ThrowExceptionDefinition.class),
        @XmlElement(name = "to", type = ToDefinition.class),
        @XmlElement(name = "transacted", type = TransactedDefinition.class),
        @XmlElement(name = "transform", type = TransformDefinition.class),
        @XmlElement(name = "doTry", type = TryDefinition.class),
        @XmlElement(name = "unmarshal", type = UnmarshalDefinition.class),
        @XmlElement(name = "validate", type = ValidateDefinition.class),
        @XmlElement(name = "wireTap", type = WireTapDefinition.class),
        @XmlElement(name = "restBinding", type = RestBindingDefinition.class)
    })
    protected List<ProcessorDefinition> aopOrAggregateOrBean;

    /**
     * Gets the value of the expressionDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getExpressionDefinition() {
        return expressionDefinition;
    }

    /**
     * Sets the value of the expressionDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setExpressionDefinition(Expression value) {
        this.expressionDefinition = value;
    }

    /**
     * Gets the value of the constant property.
     * 
     * @return
     *     possible object is
     *     {@link ConstantExpression }
     *     
     */
    public ConstantExpression getConstant() {
        return constant;
    }

    /**
     * Sets the value of the constant property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstantExpression }
     *     
     */
    public void setConstant(ConstantExpression value) {
        this.constant = value;
    }

    /**
     * Gets the value of the el property.
     * 
     * @return
     *     possible object is
     *     {@link ElExpression }
     *     
     */
    public ElExpression getEl() {
        return el;
    }

    /**
     * Sets the value of the el property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElExpression }
     *     
     */
    public void setEl(ElExpression value) {
        this.el = value;
    }

    /**
     * Gets the value of the groovy property.
     * 
     * @return
     *     possible object is
     *     {@link GroovyExpression }
     *     
     */
    public GroovyExpression getGroovy() {
        return groovy;
    }

    /**
     * Sets the value of the groovy property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroovyExpression }
     *     
     */
    public void setGroovy(GroovyExpression value) {
        this.groovy = value;
    }

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderExpression }
     *     
     */
    public HeaderExpression getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderExpression }
     *     
     */
    public void setHeader(HeaderExpression value) {
        this.header = value;
    }

    /**
     * Gets the value of the jxpath property.
     * 
     * @return
     *     possible object is
     *     {@link JxPathExpression }
     *     
     */
    public JxPathExpression getJxpath() {
        return jxpath;
    }

    /**
     * Sets the value of the jxpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JxPathExpression }
     *     
     */
    public void setJxpath(JxPathExpression value) {
        this.jxpath = value;
    }

    /**
     * Gets the value of the javaScript property.
     * 
     * @return
     *     possible object is
     *     {@link JavaScriptExpression }
     *     
     */
    public JavaScriptExpression getJavaScript() {
        return javaScript;
    }

    /**
     * Sets the value of the javaScript property.
     * 
     * @param value
     *     allowed object is
     *     {@link JavaScriptExpression }
     *     
     */
    public void setJavaScript(JavaScriptExpression value) {
        this.javaScript = value;
    }

    /**
     * Gets the value of the jsonpath property.
     * 
     * @return
     *     possible object is
     *     {@link JsonPathExpression }
     *     
     */
    public JsonPathExpression getJsonpath() {
        return jsonpath;
    }

    /**
     * Sets the value of the jsonpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JsonPathExpression }
     *     
     */
    public void setJsonpath(JsonPathExpression value) {
        this.jsonpath = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link LanguageExpression }
     *     
     */
    public LanguageExpression getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguageExpression }
     *     
     */
    public void setLanguage(LanguageExpression value) {
        this.language = value;
    }

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link MethodCallExpression }
     *     
     */
    public MethodCallExpression getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link MethodCallExpression }
     *     
     */
    public void setMethod(MethodCallExpression value) {
        this.method = value;
    }

    /**
     * Gets the value of the mvel property.
     * 
     * @return
     *     possible object is
     *     {@link MvelExpression }
     *     
     */
    public MvelExpression getMvel() {
        return mvel;
    }

    /**
     * Sets the value of the mvel property.
     * 
     * @param value
     *     allowed object is
     *     {@link MvelExpression }
     *     
     */
    public void setMvel(MvelExpression value) {
        this.mvel = value;
    }

    /**
     * Gets the value of the ognl property.
     * 
     * @return
     *     possible object is
     *     {@link OgnlExpression }
     *     
     */
    public OgnlExpression getOgnl() {
        return ognl;
    }

    /**
     * Sets the value of the ognl property.
     * 
     * @param value
     *     allowed object is
     *     {@link OgnlExpression }
     *     
     */
    public void setOgnl(OgnlExpression value) {
        this.ognl = value;
    }

    /**
     * Gets the value of the php property.
     * 
     * @return
     *     possible object is
     *     {@link PhpExpression }
     *     
     */
    public PhpExpression getPhp() {
        return php;
    }

    /**
     * Sets the value of the php property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhpExpression }
     *     
     */
    public void setPhp(PhpExpression value) {
        this.php = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setProperty(Object value) {
        this.property = value;
    }

    /**
     * Gets the value of the python property.
     * 
     * @return
     *     possible object is
     *     {@link PythonExpression }
     *     
     */
    public PythonExpression getPython() {
        return python;
    }

    /**
     * Sets the value of the python property.
     * 
     * @param value
     *     allowed object is
     *     {@link PythonExpression }
     *     
     */
    public void setPython(PythonExpression value) {
        this.python = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link RefExpression }
     *     
     */
    public RefExpression getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefExpression }
     *     
     */
    public void setRef(RefExpression value) {
        this.ref = value;
    }

    /**
     * Gets the value of the ruby property.
     * 
     * @return
     *     possible object is
     *     {@link RubyExpression }
     *     
     */
    public RubyExpression getRuby() {
        return ruby;
    }

    /**
     * Sets the value of the ruby property.
     * 
     * @param value
     *     allowed object is
     *     {@link RubyExpression }
     *     
     */
    public void setRuby(RubyExpression value) {
        this.ruby = value;
    }

    /**
     * Gets the value of the simple property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleExpression }
     *     
     */
    public SimpleExpression getSimple() {
        return simple;
    }

    /**
     * Sets the value of the simple property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleExpression }
     *     
     */
    public void setSimple(SimpleExpression value) {
        this.simple = value;
    }

    /**
     * Gets the value of the spel property.
     * 
     * @return
     *     possible object is
     *     {@link SpELExpression }
     *     
     */
    public SpELExpression getSpel() {
        return spel;
    }

    /**
     * Sets the value of the spel property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpELExpression }
     *     
     */
    public void setSpel(SpELExpression value) {
        this.spel = value;
    }

    /**
     * Gets the value of the sql property.
     * 
     * @return
     *     possible object is
     *     {@link SqlExpression }
     *     
     */
    public SqlExpression getSql() {
        return sql;
    }

    /**
     * Sets the value of the sql property.
     * 
     * @param value
     *     allowed object is
     *     {@link SqlExpression }
     *     
     */
    public void setSql(SqlExpression value) {
        this.sql = value;
    }

    /**
     * Gets the value of the tokenize property.
     * 
     * @return
     *     possible object is
     *     {@link TokenizerExpression }
     *     
     */
    public TokenizerExpression getTokenize() {
        return tokenize;
    }

    /**
     * Sets the value of the tokenize property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenizerExpression }
     *     
     */
    public void setTokenize(TokenizerExpression value) {
        this.tokenize = value;
    }

    /**
     * Gets the value of the vtdxml property.
     * 
     * @return
     *     possible object is
     *     {@link VtdXmlExpression }
     *     
     */
    public VtdXmlExpression getVtdxml() {
        return vtdxml;
    }

    /**
     * Sets the value of the vtdxml property.
     * 
     * @param value
     *     allowed object is
     *     {@link VtdXmlExpression }
     *     
     */
    public void setVtdxml(VtdXmlExpression value) {
        this.vtdxml = value;
    }

    /**
     * Gets the value of the xtokenize property.
     * 
     * @return
     *     possible object is
     *     {@link XmlTokenizerExpression }
     *     
     */
    public XmlTokenizerExpression getXtokenize() {
        return xtokenize;
    }

    /**
     * Sets the value of the xtokenize property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlTokenizerExpression }
     *     
     */
    public void setXtokenize(XmlTokenizerExpression value) {
        this.xtokenize = value;
    }

    /**
     * Gets the value of the xpath property.
     * 
     * @return
     *     possible object is
     *     {@link XPathExpression }
     *     
     */
    public XPathExpression getXpath() {
        return xpath;
    }

    /**
     * Sets the value of the xpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link XPathExpression }
     *     
     */
    public void setXpath(XPathExpression value) {
        this.xpath = value;
    }

    /**
     * Gets the value of the xquery property.
     * 
     * @return
     *     possible object is
     *     {@link XQueryExpression }
     *     
     */
    public XQueryExpression getXquery() {
        return xquery;
    }

    /**
     * Sets the value of the xquery property.
     * 
     * @param value
     *     allowed object is
     *     {@link XQueryExpression }
     *     
     */
    public void setXquery(XQueryExpression value) {
        this.xquery = value;
    }

    /**
     * Gets the value of the aopOrAggregateOrBean property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aopOrAggregateOrBean property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAopOrAggregateOrBean().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AopDefinition }
     * {@link AggregateDefinition }
     * {@link BeanDefinition }
     * {@link CatchDefinition }
     * {@link WhenDefinition }
     * {@link ChoiceDefinition }
     * {@link OtherwiseDefinition }
     * {@link ConvertBodyDefinition }
     * {@link DelayDefinition }
     * {@link DynamicRouterDefinition }
     * {@link EnrichDefinition }
     * {@link FilterDefinition }
     * {@link FinallyDefinition }
     * {@link IdempotentConsumerDefinition }
     * {@link InOnlyDefinition }
     * {@link InOutDefinition }
     * {@link InterceptDefinition }
     * {@link InterceptFromDefinition }
     * {@link InterceptSendToEndpointDefinition }
     * {@link LoadBalanceDefinition }
     * {@link LogDefinition }
     * {@link LoopDefinition }
     * {@link MarshalDefinition }
     * {@link MulticastDefinition }
     * {@link OnCompletionDefinition }
     * {@link OnExceptionDefinition }
     * {@link PipelineDefinition }
     * {@link PolicyDefinition }
     * {@link PollEnrichDefinition }
     * {@link ProcessDefinition }
     * {@link RecipientListDefinition }
     * {@link RemoveHeaderDefinition }
     * {@link RemoveHeadersDefinition }
     * {@link RemovePropertyDefinition }
     * {@link ResequenceDefinition }
     * {@link RollbackDefinition }
     * {@link RouteDefinition }
     * {@link RoutingSlipDefinition }
     * {@link SamplingDefinition }
     * {@link SetBodyDefinition }
     * {@link SetExchangePatternDefinition }
     * {@link SetFaultBodyDefinition }
     * {@link SetHeaderDefinition }
     * {@link SetOutHeaderDefinition }
     * {@link SetPropertyDefinition }
     * {@link SortDefinition }
     * {@link SplitDefinition }
     * {@link StopDefinition }
     * {@link ThreadsDefinition }
     * {@link ThrottleDefinition }
     * {@link ThrowExceptionDefinition }
     * {@link ToDefinition }
     * {@link TransactedDefinition }
     * {@link TransformDefinition }
     * {@link TryDefinition }
     * {@link UnmarshalDefinition }
     * {@link ValidateDefinition }
     * {@link WireTapDefinition }
     * {@link RestBindingDefinition }
     * 
     * 
     */
    public List<ProcessorDefinition> getAopOrAggregateOrBean() {
        if (aopOrAggregateOrBean == null) {
            aopOrAggregateOrBean = new ArrayList<ProcessorDefinition>();
        }
        return this.aopOrAggregateOrBean;
    }

}
