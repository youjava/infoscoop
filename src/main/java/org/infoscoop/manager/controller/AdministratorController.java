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

package org.infoscoop.manager.controller;

import javax.servlet.http.HttpServletRequest;

import org.infoscoop.service.PortalAdminsService;
import org.infoscoop.util.spring.TextView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/administrator")
public class AdministratorController implements ControllerInterface{
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public void index(HttpServletRequest request) throws Exception {
		String json = PortalAdminsService.getHandle().getPortalAdminsJson(request);
		request.setAttribute("portalAdminsJson", json);
	}
	
	@RequestMapping(value="/getPortalAdminsJson", method=RequestMethod.GET)
	public TextView getPortalAdminsJson(HttpServletRequest request)
			throws Exception {
		String json = PortalAdminsService.getHandle().getPortalAdminsJson(request);
		
		TextView view = new TextView();
		view.setResponseBody(json.toString());
		view.setContentType("application/json; charset=UTF-8");
		return view;
	}
	
	public String getRoleName() {
		return "admins";
	}
}
