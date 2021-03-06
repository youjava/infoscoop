/* infoScoop OpenSource
 * Copyright (C) 2010 Beacon IT Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0-standalone.html>.
 */

package org.infoscoop.account;

public class PrincipalDef {
	private String label;
	private String type;

	/**
	 * Definition of principal.
	 * @param type used for ISPrincipal#type
	 * @param label is describe ISPrincipal type when you set access control on administrator tool.
	 */
	public PrincipalDef(String type, String label){
		this.type = type;
		this.label = label;
	}

	public String getType(){
		return this.type;
	}
	public String getLabel(){
		return this.label;
	}

}
