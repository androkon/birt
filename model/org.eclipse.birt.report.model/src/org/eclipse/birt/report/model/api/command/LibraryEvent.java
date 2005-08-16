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

package org.eclipse.birt.report.model.api.command;

import org.eclipse.birt.report.model.api.activity.NotificationEvent;
import org.eclipse.birt.report.model.elements.Library;

/**
 * Indicates that the library is added, dropped or shifted.
 */

public class LibraryEvent extends NotificationEvent
{

	/**
	 * New library is added.
	 */

	public static final int ADD = 1;

	/**
	 * Library is dropped.
	 */

	public static final int DROP = 2;

	/**
	 * The library is shifted downwards or forwards.
	 */
	
	public static final int SHIFT = 3;

	/**
	 * The type of change. One of {@link #ADD}, or {@link #DROP}.
	 */

	private int action;

	/**
	 * The library causing the event.
	 */

	private Library library;

	/**
	 * Constructs the event with the added or dropped library and action.
	 * 
	 * @param library
	 *            the library causing this event
	 * @param action
	 *            th etype of change
	 */

	public LibraryEvent( Library library, int action )
	{
		this.library = library;
		this.action = action;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.api.activity.NotificationEvent#getEventType()
	 */

	public int getEventType( )
	{
		return LIBRARY_EVENT;
	}

	/**
	 * Returns the type of change.
	 * 
	 * @return the type of change.
	 */

	public int getAction( )
	{
		return action;
	}

	/**
	 * Returns the library causing this event.
	 * 
	 * @return the library causing this event
	 */

	public Library getLibrary( )
	{
		return library;
	}
}
