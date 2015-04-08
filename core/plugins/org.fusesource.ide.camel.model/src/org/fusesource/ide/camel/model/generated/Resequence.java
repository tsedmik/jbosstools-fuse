/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.fusesource.ide.camel.model.generated;

import java.util.Map;

import org.apache.camel.model.language.ExpressionDefinition;
import org.apache.camel.model.config.ResequencerConfig;
import org.apache.camel.model.ResequenceDefinition;
import org.apache.camel.model.ProcessorDefinition;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.fusesource.ide.camel.model.AbstractNode;
import org.fusesource.ide.camel.model.ExpressionPropertyDescriptor;
import org.fusesource.ide.camel.model.RouteContainer;
import org.fusesource.ide.camel.model.util.Objects;
import org.fusesource.ide.commons.properties.BooleanPropertyDescriptor;
import org.fusesource.ide.commons.properties.ComplexPropertyDescriptor;
import org.fusesource.ide.commons.properties.ComplexUnionPropertyDescriptor;
import org.fusesource.ide.commons.properties.EnumPropertyDescriptor;
import org.fusesource.ide.commons.properties.ListPropertyDescriptor;
import org.fusesource.ide.commons.properties.UnionTypeValue;

/**
 * The Node class from Camel's ResequenceDefinition
 *
 * NOTE - this file is auto-generated using Velocity.
 *
 * DO NOT EDIT!
 */
public class Resequence extends AbstractNode {

    public static final String PROPERTY_CUSTOMID = "Resequence.CustomId";
    public static final String PROPERTY_INHERITERRORHANDLER = "Resequence.InheritErrorHandler";
    public static final String PROPERTY_EXPRESSION = "Resequence.Expression";
    public static final String PROPERTY_RESEQUENCERCONFIG = "Resequence.ResequencerConfig";

    private Boolean customId;
    private Boolean inheritErrorHandler;
    private ExpressionDefinition expression;
    private ResequencerConfig resequencerConfig;

    public Resequence() {
    }

    public Resequence(ResequenceDefinition definition, RouteContainer parent) {
        super(parent);
        loadPropertiesFromCamelDefinition(definition);
        loadChildrenFromCamelDefinition(definition);
    }

    @Override
    public String getIconName() {
        return "resequence.png";
    }

    @Override
    public String getDocumentationFileName() {
        return "resequenceEIP";
    }

    @Override
    public String getCategoryName() {
        return "Routing";
    }

    /**
     * @return the customId
     */
    public Boolean getCustomId() {
        return this.customId;
    }

    /**
     * @param customId the customId to set
     */
    public void setCustomId(Boolean customId) {
        Boolean oldValue = this.customId;
        this.customId = customId;
        if (!isSame(oldValue, customId)) {
            firePropertyChange(PROPERTY_CUSTOMID, oldValue, customId);
        }
    }

    /**
     * @return the inheritErrorHandler
     */
    public Boolean getInheritErrorHandler() {
        return this.inheritErrorHandler;
    }

    /**
     * @param inheritErrorHandler the inheritErrorHandler to set
     */
    public void setInheritErrorHandler(Boolean inheritErrorHandler) {
        Boolean oldValue = this.inheritErrorHandler;
        this.inheritErrorHandler = inheritErrorHandler;
        if (!isSame(oldValue, inheritErrorHandler)) {
            firePropertyChange(PROPERTY_INHERITERRORHANDLER, oldValue, inheritErrorHandler);
        }
    }

    /**
     * @return the expression
     */
    public ExpressionDefinition getExpression() {
        return this.expression;
    }

    /**
     * @param expression the expression to set
     */
    public void setExpression(ExpressionDefinition expression) {
        ExpressionDefinition oldValue = this.expression;
        this.expression = expression;
        if (!isSame(oldValue, expression)) {
            firePropertyChange(PROPERTY_EXPRESSION, oldValue, expression);
        }
    }

    /**
     * @return the resequencerConfig
     */
    public ResequencerConfig getResequencerConfig() {
        return this.resequencerConfig;
    }

    /**
     * @param resequencerConfig the resequencerConfig to set
     */
    public void setResequencerConfig(ResequencerConfig resequencerConfig) {
        ResequencerConfig oldValue = this.resequencerConfig;
        this.resequencerConfig = resequencerConfig;
        if (!isSame(oldValue, resequencerConfig)) {
            firePropertyChange(PROPERTY_RESEQUENCERCONFIG, oldValue, resequencerConfig);
        }
    }

    @Override
    protected void addCustomProperties(Map<String, PropertyDescriptor> descriptors) {
        super.addCustomProperties(descriptors);

        PropertyDescriptor descCustomId = new BooleanPropertyDescriptor(PROPERTY_CUSTOMID, Messages.propertyLabelResequenceCustomId);
        PropertyDescriptor descInheritErrorHandler = new BooleanPropertyDescriptor(PROPERTY_INHERITERRORHANDLER, Messages.propertyLabelResequenceInheritErrorHandler);
        PropertyDescriptor descExpression = new ExpressionPropertyDescriptor(PROPERTY_EXPRESSION, Messages.propertyLabelResequenceExpression);
        PropertyDescriptor descResequencerConfig = new ComplexUnionPropertyDescriptor(PROPERTY_RESEQUENCERCONFIG, Messages.propertyLabelResequenceResequencerConfig, ResequencerConfig.class, new UnionTypeValue[] {
                new UnionTypeValue("batch-config", org.apache.camel.model.config.BatchResequencerConfig.class),
                new UnionTypeValue("stream-config", org.apache.camel.model.config.StreamResequencerConfig.class),
        });

        descriptors.put(PROPERTY_CUSTOMID, descCustomId);
        descriptors.put(PROPERTY_INHERITERRORHANDLER, descInheritErrorHandler);
        descriptors.put(PROPERTY_EXPRESSION, descExpression);
        descriptors.put(PROPERTY_RESEQUENCERCONFIG, descResequencerConfig);
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource\#setPropertyValue(java.lang.Object, java.lang.Object)
     */
    @Override
    public void setPropertyValue(Object id, Object value) {
        if (PROPERTY_CUSTOMID.equals(id)) {
            setCustomId(Objects.convertTo(value, Boolean.class));
            return;
        }
        if (PROPERTY_INHERITERRORHANDLER.equals(id)) {
            setInheritErrorHandler(Objects.convertTo(value, Boolean.class));
            return;
        }
        if (PROPERTY_EXPRESSION.equals(id)) {
            setExpression(Objects.convertTo(value, ExpressionDefinition.class));
            return;
        }
        if (PROPERTY_RESEQUENCERCONFIG.equals(id)) {
            setResequencerConfig(Objects.convertTo(value, ResequencerConfig.class));
            return;
        }
        super.setPropertyValue(id, value);
    }

    /* (non-Javadoc)
     * @see org.fusesource.ide.camel.model.AbstractNode\#getPropertyValue(java.lang.Object)
     */
    @Override
    public Object getPropertyValue(Object id) {
        if (PROPERTY_CUSTOMID.equals(id)) {
            return this.getCustomId();
        }
        if (PROPERTY_INHERITERRORHANDLER.equals(id)) {
            return Objects.<Boolean>getField(this, "inheritErrorHandler");
        }
        if (PROPERTY_EXPRESSION.equals(id)) {
            return this.getExpression();
        }
        if (PROPERTY_RESEQUENCERCONFIG.equals(id)) {
            return this.getResequencerConfig();
        }
        return super.getPropertyValue(id);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ProcessorDefinition createCamelDefinition() {
        ResequenceDefinition answer = new ResequenceDefinition();

        answer.setCustomId(toXmlPropertyValue(PROPERTY_CUSTOMID, this.getCustomId()));
        answer.setInheritErrorHandler(toXmlPropertyValue(PROPERTY_INHERITERRORHANDLER, Objects.<Boolean>getField(this, "inheritErrorHandler")));
        answer.setExpression(toXmlPropertyValue(PROPERTY_EXPRESSION, this.getExpression()));
        answer.setResequencerConfig(toXmlPropertyValue(PROPERTY_RESEQUENCERCONFIG, this.getResequencerConfig()));

        super.savePropertiesToCamelDefinition(answer);
        return answer;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class<?> getCamelDefinitionClass() {
        return ResequenceDefinition.class;
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected void loadPropertiesFromCamelDefinition(ProcessorDefinition processor) {
        super.loadPropertiesFromCamelDefinition(processor);

        if (processor instanceof ResequenceDefinition) {
            ResequenceDefinition node = (ResequenceDefinition) processor;

            this.setCustomId(node.getCustomId());
            this.setInheritErrorHandler(Objects.<Boolean>getField(node, "inheritErrorHandler"));
            this.setExpression(node.getExpression());
            this.setResequencerConfig(node.getResequencerConfig());
        } else {
            throw new IllegalArgumentException("ProcessorDefinition not an instanceof ResequenceDefinition. Was " + processor.getClass().getName());
        }
    }

}
