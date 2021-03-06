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

package org.infoscoop.dao;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infoscoop.dao.model.Searchengine;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SearchEngineDAO extends HibernateDaoSupport{
	public static final int SEARCHENGINE_FLAG_TEMP = 1;
	public static final int SEARCHENGINE_FLAG_NOT_TEMP = 0;

	private static Log log = LogFactory.getLog(SearchEngineDAO.class);
	
	private SearchEngineDAO(){
		
	}

	/**
	 * Get the data.
	 * 
	 * @param res
	 * @return
	 * @throws DataResourceException
	 */
	public Searchengine select(int tempFlag) {
		return (Searchengine) super.getHibernateTemplate().get(Searchengine.class, new Integer(tempFlag));
	}
	
	public Searchengine selectTemp() {
		return (Searchengine)select(SEARCHENGINE_FLAG_TEMP);
	}
	public Searchengine selectEntity() {
		return (Searchengine)select(SEARCHENGINE_FLAG_NOT_TEMP);
	}
	
	/**
	 * Update the data.
	 * 
	 * @param res
	 * @param node
	 * @throws DataResourceException
	 */
	public void update(Searchengine entity) {
		super.getHibernateTemplate().saveOrUpdate(entity);
	}
	
}
