package org.infoscoop.dao.model;

// Generated 2010/03/29 15:54:59 by Hibernate Tools 3.3.0.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * IsGadgetIcons generated by hbm2java
 */
@Entity
@Table(name = "is_gadget_icons", uniqueConstraints = @UniqueConstraint(columnNames = "type"))
public class GadgetIcon implements java.io.Serializable {

	private Integer id;
	private String type;
	private String url;

	public GadgetIcon() {
	}

	public GadgetIcon(String type, String url) {
		this.type = type;
		this.url = url;
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

	@Column(name = "type", unique = true, nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "url", nullable = false, length = 1024)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}