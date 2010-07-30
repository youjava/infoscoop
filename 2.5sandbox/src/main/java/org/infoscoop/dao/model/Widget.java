package org.infoscoop.dao.model;

// Generated 2010/03/29 15:54:59 by Hibernate Tools 3.3.0.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * IsWidgets generated by hbm2java
 */
@Entity
@Table(name = "is_widgets", uniqueConstraints = @UniqueConstraint(columnNames = {
		"UID", "tabId", "widgetId", "deleteDate" }))
public class Widget implements java.io.Serializable {

	private Integer id;
	private String uid;
	private String defaultUid;
	private String tabId;
	private String widgetId;
	private Integer column;
	private String siblingId;
	private String parentId;
	private String menuId;
	private String href;
	private String title;
	private String type;
	private Integer isStatic;
	private Integer ignoreHeader;
	private long createDate;
	private long deleteDate;
	private Set<UserPref> userPrefs = new HashSet<UserPref>(0);
	
	private Map<String, UserPref> userPrefsMap;

	public Widget() {
	}

	public Widget(String uid, String tabId, String widgetId, String menuId,
			int createDate, int deleteDate) {
		this.uid = uid;
		this.tabId = tabId;
		this.widgetId = widgetId;
		this.menuId = menuId;
		this.createDate = createDate;
		this.deleteDate = deleteDate;
	}

	public Widget(String uid, String defaultUid, String tabId,
			String widgetId, Integer column, String siblingId, String parentId,
			String menuId, String href, String title, String type,
			Integer isStatic, Integer ignoreHeader, int createDate,
			int deleteDate, Set<UserPref> isUserprefses) {
		this.uid = uid;
		this.defaultUid = defaultUid;
		this.tabId = tabId;
		this.widgetId = widgetId;
		this.column = column;
		this.siblingId = siblingId;
		this.parentId = parentId;
		this.menuId = menuId;
		this.href = href;
		this.title = title;
		this.type = type;
		this.isStatic = isStatic;
		this.ignoreHeader = ignoreHeader;
		this.createDate = createDate;
		this.deleteDate = deleteDate;
		this.userPrefs = isUserprefses;
	}
	
	public Widget(String tabId, Long deleteDate, String widgetId, String uid) {
		this.tabId = tabId;
		this.deleteDate = deleteDate;
		this.widgetId = widgetId;
		this.uid = uid;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "UID", nullable = false, length = 75)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "defaultUid", length = 150)
	public String getDefaultUid() {
		return this.defaultUid;
	}

	public void setDefaultUid(String defaultUid) {
		this.defaultUid = defaultUid;
	}

	@Column(name = "tabId", nullable = false, length = 32)
	public String getTabId() {
		return this.tabId;
	}

	public void setTabId(String tabId) {
		this.tabId = tabId;
	}

	@Column(name = "widgetId", nullable = false, length = 128)
	public String getWidgetId() {
		return this.widgetId;
	}

	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
	}

	@Column(name = "COLUMN")
	public Integer getColumn() {
		return this.column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	@Column(name = "siblingId", length = 256)
	public String getSiblingId() {
		return this.siblingId;
	}

	public void setSiblingId(String siblingId) {
		this.siblingId = siblingId;
	}

	@Column(name = "parentId", length = 256)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "menuId", nullable = false, length = 256)
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Column(name = "href", length = 1024)
	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Column(name = "title", length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "type", length = 1024)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "isStatic")
	public Integer getIsStatic() {
		return this.isStatic;
	}

	public void setIsStatic(Integer isStatic) {
		this.isStatic = isStatic;
	}

	@Column(name = "ignoreHeader")
	public Integer getIgnoreHeader() {
		return this.ignoreHeader;
	}

	public void setIgnoreHeader(Integer ignoreHeader) {
		this.ignoreHeader = ignoreHeader;
	}

	@Column(name = "createDate", nullable = false)
	public long getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	@Column(name = "deleteDate", nullable = false)
	public long getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(long deleteDate) {
		this.deleteDate = deleteDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "widget")
	public Set<UserPref> getUserPrefs() {
		return this.userPrefs;
	}

	public void setUserPrefs(Set<UserPref> isUserprefses) {
		this.userPrefs = isUserprefses;
	}
	
	public void setIgnoreHeader(boolean ignoreHeader){
		this.ignoreHeader = new Integer(ignoreHeader ? 1 : 0);
	}
	
	@Transient
	public boolean isIgnoreHeader() {
		if (getIgnoreHeader() == null) {
			return false;
		} else {
			return getIgnoreHeader().intValue() == 1;
		}
	}
	
	@Transient
	public Map<String,UserPref> getUserPrefsMap() {
		if (userPrefsMap == null) {
			for (UserPref userPref : userPrefs) {
				userPrefsMap.put(userPref.getId().getName(), userPref);
			}
		}
		
		return userPrefsMap;
	}
	
	public void setUserPref( String name,String value ) {
		Map<String,UserPref> userPrefs = getUserPrefsMap();
		if( value == null )
			value = "";
		
		UserPref userPref;
		if( userPrefs.containsKey( name )) {
			userPref = userPrefs.get( name );
		} else {
			userPref = new UserPref(new UserprefId(getId(), name), this);
			userPrefs.put( name,userPref );
		}
		userPref.setValue(value);
	}
	
	public void removeUserPref( String name ) {
		Map<String, UserPref> userPrefs = getUserPrefsMap();
		userPrefs.remove(name);
	}
	
	public void setUserPrefsJSON( JSONObject userPrefsJson ) {
		Map<String,UserPref> userPrefs = getUserPrefsMap();
		for( Iterator<String> keys=userPrefsJson.keys();keys.hasNext(); ) {
			String key = keys.next();
			try {
				String value = userPrefsJson.getString( key );
				if( value == null )
					value = "";
				
				UserPref userPref = userPrefs.get( key );
				if( userPref == null ) {
					userPref = new UserPref(new UserprefId(getId(), key), this);
					userPrefs.put( key,userPref );
				}
				
				userPref.setValue(value);
			} catch( JSONException ex ) {
				throw new RuntimeException( ex );
			}
		}
	}
	
	public JSONObject toJSONObject() throws JSONException{
		JSONObject json = new JSONObject();
		json.put("id", this.getWidgetId());
		json.put("column", ( this.getColumn() == null ? "":this.getColumn().toString()));
		json.put("tabId", this.getTabId());
		json.put("href", this.getHref());
		json.put("title", this.getTitle());
		json.put("siblingId", this.getSiblingId());
		json.put("parentId", this.getParentId());
		json.put("menuId", this.getMenuId());
		json.put("type", this.getType());

		JSONObject userPrefsJson = new JSONObject();
		JSONArray longUserPrefsJson = new JSONArray();
		Map<String,UserPref> userPrefs = getUserPrefsMap();
		for( String key : userPrefs.keySet() ) {
			UserPref userPref = userPrefs.get( key );
			if( userPref == null )
				continue;
			
			try {
				if( !userPref.hasLongValue() ) {
					userPrefsJson.put( key,userPrefs.get( key ).getId().getValue());
				} else {
					// longValue not returned
					userPrefsJson.put( key,false );
					longUserPrefsJson.put( key );
				}
			} catch( JSONException ex ) {
				throw new RuntimeException( ex );
			}
		}
		json.put("property",userPrefsJson );
		json.put("longProperty",longUserPrefsJson );

		json.put("createDate", this.getCreateDate());
		json.put("deleteDate", this.getDeleteDate());
		json.put("ignoreHeader", this.isIgnoreHeader());
		
		return json;
	}
}