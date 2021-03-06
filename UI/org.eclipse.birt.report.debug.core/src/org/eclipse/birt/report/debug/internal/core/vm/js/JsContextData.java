/*******************************************************************************
 * Copyright (c) 2007 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.debug.internal.core.vm.js;

import java.util.Stack;

import org.eclipse.birt.report.debug.internal.core.vm.VMContextData;
import org.eclipse.birt.report.debug.internal.core.vm.VMStackFrame;

/**
 * JsContextData
 */
public class JsContextData implements VMContextData
{

	int currentLineNo;
	String currentName;

	boolean breakOnStart;

	boolean breakNextLine;
	int targetFrmaeDepth = -1;

	private Stack frameStack;

	public JsContextData( )
	{
		frameStack = new Stack( );
	}

	public void setBreakOnStart( boolean val )
	{
		this.breakOnStart = val;
	}

	public void breakNextLine( int targetFrameDepth )
	{
		this.breakNextLine = true;
		this.targetFrmaeDepth = targetFrameDepth;
	}

	public int frameCount( )
	{
		return frameStack.size( );
	}

	public VMStackFrame getCurrentFrame( )
	{
		if ( frameStack.size( ) > 0 )
		{
			return (VMStackFrame) frameStack.peek( );
		}
		return null;
	}

	public VMStackFrame getFrame( int idx )
	{
		return (VMStackFrame) frameStack.get( idx );
	}

	public VMStackFrame popFrame( )
	{
		return (VMStackFrame) frameStack.pop( );
	}

	public void pushFrame( VMStackFrame frame )
	{
		frameStack.push( frame );
	}

}
