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

package org.infoscoop.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infoscoop.context.UserContext;
import org.infoscoop.dao.LogoDAO;
import org.infoscoop.dao.model.Logo;
import org.infoscoop.util.SpringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class LogoService {
	private static Log log = LogFactory.getLog(LogoService.class);

	private LogoDAO logoDAO;

	public static LogoService getHandle(){
		return (LogoService) SpringUtil.getBean("LogoService");
	}

	public LogoDAO getLogoDAO() {
		return logoDAO;
	}

	public void setLogoDAO(LogoDAO logoDAO) {
		this.logoDAO = logoDAO;
	}

	public void saveLogo(byte[] image) {
		String squareId = UserContext.instance().getUserInfo().getCurrentSquareId();

		Logo logo = this.logoDAO.getBySquareId(squareId);

		if(logo != null) {
			// update
			logo.setLogo(image);
			this.logoDAO.update(logo);
		} else {
			// insert
			this.logoDAO.insert(squareId, image);
		}
	}

	public byte[] getLogo() {
		String squareId = UserContext.instance().getUserInfo().getCurrentSquareId();
		Logo logo = this.logoDAO.getBySquareId(squareId);

		if(logo != null)
			return logo.getLogo();

		return new byte[0];
	}

	public static class LogoImageException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public LogoImageException() {
			this( null );
		}
		public LogoImageException( Throwable cause ) {
			this("unexcepted error","ams_gadgetResourceUnknownError",cause );
		}
		public LogoImageException( String message,String id ) {
			this( message,id,null );
		}
		public LogoImageException( String message,String id,Throwable cause ) {
			super( message,cause );

			this.id = id;
		}

		private String id;
		public String getId() { return id; }

		public JSONObject toJSON() {
			JSONObject json = new JSONObject();
			try {
				json.put("message",getId() );
			} catch( JSONException ex ) {
				// ignore
			}

			return json;
		}
	}
}