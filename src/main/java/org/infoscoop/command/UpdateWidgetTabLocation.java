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

package org.infoscoop.command;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infoscoop.command.util.XMLCommandUtil;
import org.infoscoop.dao.TabDAO;
import org.infoscoop.dao.WidgetDAO;
import org.infoscoop.dao.model.Widget;

/**
 * The command class to update an infomation of tab that a widget belongs to.
 * 
 * @author nishiumi
 */
public class UpdateWidgetTabLocation extends XMLCommandProcessor {

    private Log log = LogFactory.getLog(this.getClass());

    /**
     * create a new object of UpdateWidgetLocation.
     */
    public UpdateWidgetTabLocation() {

    }

    /**
     * update an infomation of tab that a widget belongs to.
     * 
     * @param uid
     *            a userId that is target of operation.
     * @param el
     *            The element of request command. Attributes of "widgetId", "targetColumn", and "sibling" are necessary for the Element.<BR>
     *            <BR>
     *             example of input element：<BR>
     * 
     * <pre>
     *  &lt;command type=&quot;UpdateWidgetTabLocation&quot; id=&quot;UpdateWidgetTabLocation_w_4&quot; widgetId=&quot;w_4&quot; /&gt;
     * </pre>
     */

	public void execute() {
		
        String commandId = super.commandXml.getAttribute("id").trim();
        String widgetId = super.commandXml.getAttribute("widgetId").trim();
        String tabIdFrom = super.commandXml.getAttribute("tabIdFrom").trim();
        String tabIdTo = super.commandXml.getAttribute("tabIdTo").trim();
        
        if(log.isInfoEnabled()){
        	String logMsg = "uid:[" + uid + "]: processXML: tabIdFrom:[" + tabIdFrom
					+ "], tabIdTo:[" + tabIdTo + "], widgetId:[" + widgetId + "]";
        	log.info(logMsg);
        }
        if (widgetId == null || widgetId == "") {
            String reason = "It's an unjust widgetId．widgetId:[" + widgetId + "]";
            this.result = XMLCommandUtil.createResultElement(uid, "processXML",
                    log, commandId, false, reason);
            return;
        }
        
        TabDAO tabDAO = TabDAO.newInstance();
        WidgetDAO widgetDAO = WidgetDAO.newInstance();
        
        Widget widget = widgetDAO.getWidget( uid,tabIdFrom,widgetId);
        if (widget == null) {
            String reason = "Not found the information of the widget(wigetID) that is origin of movement．widgetId:["
                    + widgetId + "]";
            this.result =  XMLCommandUtil.createResultElement(uid, "processXML",
                    log, commandId, false, reason);
            return;
        }
        Widget oldNextSibling = tabDAO.getWidgetBySibling( uid,tabIdFrom,widgetId );            	
        if(oldNextSibling != null){
        	oldNextSibling.setSiblingid(widget.getSiblingid());
//        	widgetDAO.updateWidget(oldNextSibling);
        }
        
        widget.setTabid( tabIdTo );
        
        this.result = XMLCommandUtil.createResultElement(uid, "processXML", log,
                commandId, true, null);
	}
}
