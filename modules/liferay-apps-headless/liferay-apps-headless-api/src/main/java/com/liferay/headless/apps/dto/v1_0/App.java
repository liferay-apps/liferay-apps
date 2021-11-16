package com.liferay.headless.apps.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Koshelenko
 * @generated
 */
@Generated("")
@GraphQLName(description = "An app", value = "App")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "App")
public class App implements Serializable {

	public static App toDTO(String json) {
		return ObjectMapperUtil.readValue(App.class, json);
	}

	public static App unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(App.class, json);
	}

	@Schema(description = "An application description")
	public String getAppDescription() {
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	@JsonIgnore
	public void setAppDescription(
		UnsafeSupplier<String, Exception> appDescriptionUnsafeSupplier) {

		try {
			appDescription = appDescriptionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "An application description")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String appDescription;

	@Schema(description = "Application ID")
	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	@JsonIgnore
	public void setAppId(UnsafeSupplier<Long, Exception> appIdUnsafeSupplier) {
		try {
			appId = appIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Application ID")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long appId;

	@Schema(description = "An application link")
	public String getAppLink() {
		return appLink;
	}

	public void setAppLink(String appLink) {
		this.appLink = appLink;
	}

	@JsonIgnore
	public void setAppLink(
		UnsafeSupplier<String, Exception> appLinkUnsafeSupplier) {

		try {
			appLink = appLinkUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "An application link")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String appLink;

	@Schema(description = "An application name")
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@JsonIgnore
	public void setAppName(
		UnsafeSupplier<String, Exception> appNameUnsafeSupplier) {

		try {
			appName = appNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "An application name")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String appName;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof App)) {
			return false;
		}

		App app = (App)object;

		return Objects.equals(toString(), app.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (appDescription != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"appDescription\": ");

			sb.append("\"");

			sb.append(_escape(appDescription));

			sb.append("\"");
		}

		if (appId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"appId\": ");

			sb.append(appId);
		}

		if (appLink != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"appLink\": ");

			sb.append("\"");

			sb.append(_escape(appLink));

			sb.append("\"");
		}

		if (appName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"appName\": ");

			sb.append("\"");

			sb.append(_escape(appName));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.liferay.headless.apps.dto.v1_0.App",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}