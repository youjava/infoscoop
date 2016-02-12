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

package org.infoscoop.api.rest.v1.response.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import java.util.List;
import java.util.Map;

public class Provisioning{

	public interface ProvDefault extends Default{}
	public interface Create extends Update{}
	public interface Update{}

	@NotBlank(groups = { Create.class, Update.class })
	@Size(min = 1, max = 150, groups = { Create.class, Update.class })
	@Pattern(regexp = "^[a-zA-Z0-9\\-_\\~\\.@]+$", groups = { Create.class, Update.class })
	public String uid;

	@NotBlank(groups = { Create.class })
	@Size(min = 8, max = 32, groups = { Create.class, Update.class })
	@Pattern(regexp = "^[a-zA-Z0-9!#\\$%&'\\-\\+\\*_\\?]+$", groups = { Create.class, Update.class })
	public String password;

	@NotBlank(groups = { Create.class })
	@Email(groups = { Create.class, Update.class })
	@Size(min = 1, max = 150, groups = { Create.class, Update.class })
	public String email;

	@JsonProperty("given_name")
	@NotBlank(groups = { Create.class })
	@Size(max = 128, groups = { Create.class, Update.class })
	public String givenName;

	@JsonProperty("family_name")
	@NotNull(groups = { Create.class })
	@Size(max = 128, groups = { Create.class, Update.class })
	public String familyName;

	@Size(max = 255, groups = { Create.class, Update.class })
	public String name;

	@JsonProperty("default_square_id")
	@Size(max = 64, groups = { Create.class, Update.class })
	public String defaultSquareId;

	@JsonProperty("belong_square")
	public List<Map<String, String>> belongSquare;

	public List<Map<String, String>> attrs;

}