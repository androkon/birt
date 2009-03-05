/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.model.api.elements.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.birt.report.model.api.ComputedColumnHandle;
import org.eclipse.birt.report.model.api.SimpleValueHandle;
import org.eclipse.birt.report.model.api.StructureHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.birt.report.model.api.metadata.PropertyValueException;
import org.eclipse.birt.report.model.api.util.StringUtil;
import org.eclipse.birt.report.model.core.DesignElement;
import org.eclipse.birt.report.model.core.Module;
import org.eclipse.birt.report.model.core.PropertyStructure;

/**
 * Represents one computed column. A computed column is a ��virtual�� column
 * produced as an expression of other columns within the data set.
 * <p>
 * This is a managed object, meaning that all changes should be made though the
 * command layer so that they can be undone and redone. Each computed column has
 * the following properties:
 * 
 * <p>
 * <dl>
 * <dt><strong>Column Name </strong></dt>
 * <dd>a computed column has a required column name.</dd>
 * 
 * <dt><strong>Expression </strong></dt>
 * <dd>expression of the computation for the column.</dd>
 * </dl>
 * 
 */

public class ComputedColumn extends PropertyStructure
{

	/**
	 * Name of this structure. Matches the definition in the meta-data
	 * dictionary.
	 */

	public static final String COMPUTED_COLUMN_STRUCT = "ComputedColumn"; //$NON-NLS-1$

	/**
	 * Name of the column name member.
	 */

	public static final String NAME_MEMBER = "name"; //$NON-NLS-1$

	/**
	 * DisplayName of the column name member.
	 */

	public static final String DISPLAY_NAME_MEMBER = "displayName"; //$NON-NLS-1$

	/**
	 * Name of the column name member.
	 * 
	 * @deprecated using {@link #NAME_MEMBER} instead.
	 */

	public static final String COLUMN_NAME_MEMBER = "columnName"; //$NON-NLS-1$

	/**
	 * Name of the expression member.
	 */

	public static final String EXPRESSION_MEMBER = "expression"; //$NON-NLS-1$

	/**
	 * Name of the data-type member.
	 */

	public static final String DATA_TYPE_MEMBER = "dataType"; //$NON-NLS-1$

	/**
	 * Name of the aggregateOn member.
	 */

	public static final String AGGREGATEON_MEMBER = "aggregateOn"; //$NON-NLS-1$

	/**
	 * Name of the aggregateOn member.
	 * 
	 * @deprecated
	 */

	public static final String AGGREGRATEON_MEMBER = "aggregrateOn"; //$NON-NLS-1$

	/**
	 * Name of the aggregateOn member.
	 */
	public static final String AGGREGATEON_FUNCTION_MEMBER = "aggregateFunction"; //$NON-NLS-1$

	/**
	 * Name of arguments of function member.
	 */
	public static final String ARGUMENTS_MEMBER = "arguments"; //$NON-NLS-1$

	/**
	 * Name of the filter member.
	 */
	public static final String FILTER_MEMBER = "filterExpr"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.core.IStructure#getStructName()
	 */

	public String getStructName( )
	{
		return COMPUTED_COLUMN_STRUCT;
	}

	/**
	 * Returns the column name.
	 * 
	 * @return the column name
	 * @deprecated using {@link #getName()} instead.
	 */

	public String getColumnName( )
	{
		return getName( );
	}

	/**
	 * Returns the column name.
	 * 
	 * @return the column name
	 */

	public String getName( )
	{
		return (String) getProperty( null, NAME_MEMBER );
	}

	/**
	 * Returns column display name.
	 * 
	 * @return column display name.
	 */

	public String getDisplayName( )
	{
		return (String) getProperty( null, ComputedColumn.DISPLAY_NAME_MEMBER );
	}

	/**
	 * Sets the column display name.
	 * 
	 * @param columnDisplayName
	 *            the column display name to set.
	 * 
	 */

	public void setDisplayName( String columnDisplayName )
	{
		setProperty( ComputedColumn.DISPLAY_NAME_MEMBER, columnDisplayName );
	}

	/**
	 * Sets the column name.
	 * 
	 * @param columnName
	 *            the column name to set
	 * @deprecated using {@link #setName(String)} instead.
	 */

	public void setColumnName( String columnName )
	{
		setName( columnName );
	}

	/**
	 * Sets the column name
	 * 
	 * @param name
	 *            the column name to set.
	 */

	public void setName( String name )
	{
		setProperty( NAME_MEMBER, name );
	}

	/**
	 * Returns the expression to compute.
	 * 
	 * @return the expression to compute
	 */

	public String getExpression( )
	{
		return getStringProperty( null, EXPRESSION_MEMBER );
	}

	/**
	 * Sets the expression.
	 * 
	 * @param expression
	 *            the expression to set
	 */

	public void setExpression( String expression )
	{
		setProperty( EXPRESSION_MEMBER, expression );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.model.core.Structure#handle(org.eclipse.birt.
	 * report.model.api.SimpleValueHandle, int)
	 */

	public StructureHandle handle( SimpleValueHandle valueHandle, int index )
	{
		return new ComputedColumnHandle( valueHandle, index );
	}

	/**
	 * Validates this structure. The following are the rules:
	 * <ul>
	 * <li>The column name is required.
	 * </ul>
	 * 
	 * @see org.eclipse.birt.report.model.core.Structure#validate(Module,
	 *      org.eclipse.birt.report.model.core.DesignElement)
	 */

	public List validate( Module module, DesignElement element )
	{
		List list = super.validate( module, element );

		String columnName = getName( );
		if ( StringUtil.isBlank( columnName ) )
		{
			list.add( new PropertyValueException( element, getDefn( )
					.getMember( NAME_MEMBER ), columnName,
					PropertyValueException.DESIGN_EXCEPTION_VALUE_REQUIRED ) );
		}

		return list;
	}

	/**
	 * Returns the data type of this column. The possible values are defined in
	 * {@link org.eclipse.birt.report.model.api.elements.DesignChoiceConstants},
	 * and they are:
	 * <ul>
	 * <li>COLUMN_DATA_TYPE_ANY
	 * <li>COLUMN_DATA_TYPE_INTEGER
	 * <li>COLUMN_DATA_TYPE_STRING
	 * <li>COLUMN_DATA_TYPE_DATETIME
	 * <li>COLUMN_DATA_TYPE_DECIMAL
	 * <li>COLUMN_DATA_TYPE_FLOAT
	 * <li>COLUMN_DATA_TYPE_STRUCTURE
	 * <li>COLUMN_DATA_TYPE_TABLE
	 * </ul>
	 * 
	 * @return the data type of this column.
	 */

	public String getDataType( )
	{
		return (String) getProperty( null, DATA_TYPE_MEMBER );
	}

	/**
	 * Sets the data type of this column. The allowed values are defined in
	 * {@link org.eclipse.birt.report.model.api.elements.DesignChoiceConstants},
	 * and they are:
	 * <ul>
	 * <li>COLUMN_DATA_TYPE_ANY
	 * <li>COLUMN_DATA_TYPE_INTEGER
	 * <li>COLUMN_DATA_TYPE_STRING
	 * <li>COLUMN_DATA_TYPE_DATETIME
	 * <li>COLUMN_DATA_TYPE_DECIMAL
	 * <li>COLUMN_DATA_TYPE_FLOAT
	 * <li>COLUMN_DATA_TYPE_STRUCTURE
	 * <li>COLUMN_DATA_TYPE_TABLE
	 * </ul>
	 * 
	 * @param dataType
	 *            the data type to set
	 */

	public void setDataType( String dataType )
	{
		setProperty( DATA_TYPE_MEMBER, dataType );
	}

	/**
	 * Returns the aggregrateOn expression to compute.
	 * 
	 * @return the aggregrateOn expression to compute.
	 * 
	 * @deprecated by {@link #getAggregateOn()}
	 */

	public String getAggregrateOn( )
	{
		return getAggregateOn( );
	}

	/**
	 * Sets the aggregateOn expression.
	 * 
	 * @param aggregateOn
	 *            the aggregateOn expression to set
	 * @deprecated by {@link #setAggregateOn(String)}
	 * 
	 */

	public void setAggregrateOn( String aggregateOn )
	{
		setAggregateOn( aggregateOn );
	}

	/**
	 * Returns the aggregateOn expression to compute.
	 * 
	 * @return the aggregateOn expression to compute.
	 * 
	 */

	public String getAggregateOn( )
	{
		List aggres = getAggregateOnList( );
		if ( aggres == null || aggres.isEmpty( ) )
			return null;

		return (String) aggres.get( 0 );
	}

	/**
	 * Returns the list containing levels to be aggregated on.
	 * 
	 * @return the list containing levels to be aggregated on
	 */

	public List getAggregateOnList( )
	{
		List value = (List) getProperty( null, AGGREGATEON_MEMBER );
		if ( value == null )
			return Collections.EMPTY_LIST;

		return value;
	}

	/**
	 * Sets the aggregateOn expression.
	 * 
	 * @param aggregateOn
	 *            the aggregateOn expression to set
	 */

	public void setAggregateOn( String aggregateOn )
	{
		if ( aggregateOn == null )
		{
			setProperty( AGGREGATEON_MEMBER, null );
			return;
		}
		List value = new ArrayList( );
		value.add( aggregateOn );
		setProperty( AGGREGATEON_MEMBER, value );
	}

	/**
	 * Adds an aggregate level to the list.
	 * 
	 * @param aggreValue
	 *            the aggregate name. For listing elements, this can be "All" or
	 *            the name of a single group.
	 */

	public void addAggregateOn( String aggreValue )
	{
		List aggregationOn = (List) getProperty( null, AGGREGATEON_MEMBER );
		if ( aggregationOn == null )
			aggregationOn = new ArrayList( );

		aggregationOn.add( aggreValue );
		propValues.put( AGGREGATEON_MEMBER, aggregationOn );
	}

	/**
	 * Removes an aggregate level from the list.
	 * 
	 * @param aggreValue
	 *            the aggregate name. For listing elements, this can be "All" or
	 *            the name of a single group.
	 */

	public void removeAggregateOn( String aggreValue )
	{
		List aggregationOn = (List) getProperty( null, AGGREGATEON_MEMBER );
		if ( aggregationOn == null )
			return;

		aggregationOn.remove( aggreValue );
	}

	/**
	 * Returns the expression used to define this computed column.
	 * 
	 * @return the expression used to define this computed column
	 */

	public String getAggregateFunction( )
	{
		return (String) getProperty( null,
				ComputedColumn.AGGREGATEON_FUNCTION_MEMBER );
	}

	/**
	 * Returns the expression used to define this computed column.
	 * 
	 * @return the expression used to define this computed column
	 */

	public String getFilterExpression( )
	{
		return (String) getProperty( null, ComputedColumn.FILTER_MEMBER );
	}

	/**
	 * Sets the expression used to define this computed column.
	 * 
	 * @param expression
	 *            the expression to set
	 * @throws SemanticException
	 *             value required exception
	 */

	public void setAggregateFunction( String expression )
	{
		setProperty( ComputedColumn.AGGREGATEON_FUNCTION_MEMBER, expression );
	}

	/**
	 * Sets the expression used to define this computed column.
	 * 
	 * @param expression
	 *            the expression to set
	 * @throws SemanticException
	 *             value required exception
	 */

	public void setFilterExpression( String expression )
	{
		setProperty( ComputedColumn.FILTER_MEMBER, expression );
	}

	/**
	 * Sets the expression used to define this computed column.
	 * 
	 * @param expression
	 *            the expression to set
	 * @throws SemanticException
	 *             value required exception
	 */

	public void clearAggregateOnList( )
	{
		setProperty( AGGREGATEON_MEMBER, null );
	}

	/**
	 * Adds an argument to list.
	 * 
	 * @param argument
	 *            the aggregate function argument
	 */

	public void addArgument( AggregationArgument argument )
	{
		List arguments = (List) getProperty( null, ARGUMENTS_MEMBER );
		if ( arguments == null )
		{
			arguments = new ArrayList( );
			propValues.put( ARGUMENTS_MEMBER, arguments );
		}

		arguments.add( argument );
	}

	/**
	 * Removes an argument from list.
	 * 
	 * @param argument
	 *            the aggregate function argument
	 */

	public void removeArgument( AggregationArgument argument )
	{
		List arguments = (List) getProperty( null, ARGUMENTS_MEMBER );
		if ( arguments == null )
			return;

		arguments.remove( argument );
	}
}
