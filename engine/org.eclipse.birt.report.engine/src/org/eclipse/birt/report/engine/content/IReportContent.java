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

package org.eclipse.birt.report.engine.content;

import java.util.List;

import org.eclipse.birt.report.engine.api.TOCNode;
import org.eclipse.birt.report.engine.ir.Report;

/**
 * The object represents the report content as a whole.
 * 
 * @version $Revision: 1.7 $ $Date: 2005/11/14 10:55:59 $
 */
public interface IReportContent
{

	/**
	 * get the report design used to create this report content.
	 * 
	 * @return the report design.
	 */
	public Report getDesign( );

	/**
	 * get the error list which occurs in the generation.
	 * 
	 * @return error list.
	 */
	public List getErrors( );

	/**
	 * get the TOC structure constructed in the generation.
	 * 
	 * @return the TOC structure.
	 */
	public TOCNode getTOC( );

	/**
	 * find the named style.
	 * 
	 * @param styleClass
	 *            style name.
	 * @return style named with the name, null if not exists.
	 */
	public IStyle findStyle( String styleClass );

	/**
	 * create a anction content. The action content can only be use in this
	 * report content.
	 * 
	 * @return the action content.
	 */
	public IHyperlinkAction createActionContent( );

	/**
	 * create a style. the style can only be used in this report.
	 * 
	 * @return style created.
	 */
	public IStyle createStyle( );

	/**
	 * create a cell content. the content can only be used in this report.
	 * 
	 * @return cell content.
	 */
	public ICellContent createCellContent( );

	/**
	 * create a container content. the content can only be used in this report.
	 * 
	 * @return the container content.
	 */
	public IContainerContent createContainerContent( );

	/**
	 * create a page content. the page content can only be used in this report.
	 * 
	 * @return the page content.
	 */
	public IPageContent createPageContent( );

	/**
	 * create an table content. the table content can only be used in this
	 * report.
	 * 
	 * @return the table.
	 */
	public ITableContent createTableContent( );

	/**
	 * create the table header. the table header can only be used in this
	 * report.
	 * 
	 * @return the table header.
	 */
	public ITableBandContent createTableHeader( );

	/**
	 * create the table footer. the table footer can only be used in this
	 * report.
	 * 
	 * @return the table footer.
	 */
	public ITableBandContent createTableFooter( );

	/**
	 * create the table body. the table body can only be used in this report.
	 * 
	 * @return the table body.
	 */
	public ITableBandContent createTableBody( );

	/**
	 * create the row content. the row can only be used in this report.
	 * 
	 * @return the row content.
	 */
	public IRowContent createRowContent( );

	/**
	 * create the text content. the text can only be used in this report.
	 * 
	 * @return the text content.
	 */
	public ITextContent createTextContent( );

	/**
	 * create the text content, copy the properties from the template content.
	 * the text can only be used in this report.
	 * 
	 * @param content
	 *            the content template.
	 * @return the text content.
	 */
	public ITextContent createTextContent( IContent conent );

	/**
	 * create the foreign content. the foreign content can only be used in this
	 * report.
	 * 
	 * @return the foreign content
	 */
	public IForeignContent createForeignContent( );

	/**
	 * create the image content. the image can only be used in this report.
	 * 
	 * @return the image content.
	 */
	public IImageContent createImageContent( );

	/**
	 * create the image content, copy the properties from the template content.
	 * the image can only be used in this report.
	 * 
	 * @param content
	 *            the content template.
	 * @return the image content.
	 */
	public IImageContent createImageContent( IContent conent );

	/**
	 * create the label content. the label can only be used in this report.
	 * 
	 * @return the label content.
	 */
	public ILabelContent createLabelContent( );

	/**
	 * create the label content, copy the properties from the template content.
	 * the label can only be used in this report.
	 * 
	 * @param content
	 *            the content template.
	 * @return the label content.
	 */
	public ILabelContent createLabelContent( IContent conent );

	/**
	 * create the data content. the data can only be used in this report.
	 * 
	 * @return the data content.
	 */
	public IDataContent createDataContent( );

	/**
	 * create the data content, copy the properties from the template content.
	 * the data can only be used in this report.
	 * 
	 * @param content
	 *            the content template.
	 * @return the data content.
	 */
	public IDataContent createDataContent( IContent conent );
	
}