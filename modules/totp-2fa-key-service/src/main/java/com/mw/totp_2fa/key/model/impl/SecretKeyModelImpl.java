/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mw.totp_2fa.key.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.mw.totp_2fa.key.model.SecretKey;
import com.mw.totp_2fa.key.model.SecretKeyModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SecretKey service. Represents a row in the &quot;totp_SecretKey&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link SecretKeyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SecretKeyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecretKeyImpl
 * @see SecretKey
 * @see SecretKeyModel
 * @generated
 */
@ProviderType
public class SecretKeyModelImpl extends BaseModelImpl<SecretKey>
	implements SecretKeyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a secret key model instance should use the {@link SecretKey} interface instead.
	 */
	public static final String TABLE_NAME = "totp_SecretKey";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "secretKeyId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "secretKey", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("secretKeyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("secretKey", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table totp_SecretKey (uuid_ VARCHAR(75) null,secretKeyId LONG not null primary key,companyId LONG,userId LONG,secretKey VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table totp_SecretKey";
	public static final String ORDER_BY_JPQL = " ORDER BY secretKey.secretKeyId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY totp_SecretKey.secretKeyId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.mw.totp_2fa.key.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.mw.totp_2fa.key.model.SecretKey"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.mw.totp_2fa.key.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.mw.totp_2fa.key.model.SecretKey"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.mw.totp_2fa.key.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.mw.totp_2fa.key.model.SecretKey"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long USERID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long SECRETKEYID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.mw.totp_2fa.key.service.util.ServiceProps.get(
				"lock.expiration.time.com.mw.totp_2fa.key.model.SecretKey"));

	public SecretKeyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _secretKeyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSecretKeyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _secretKeyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SecretKey.class;
	}

	@Override
	public String getModelClassName() {
		return SecretKey.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("secretKeyId", getSecretKeyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("secretKey", getSecretKey());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long secretKeyId = (Long)attributes.get("secretKeyId");

		if (secretKeyId != null) {
			setSecretKeyId(secretKeyId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String secretKey = (String)attributes.get("secretKey");

		if (secretKey != null) {
			setSecretKey(secretKey);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getSecretKeyId() {
		return _secretKeyId;
	}

	@Override
	public void setSecretKeyId(long secretKeyId) {
		_secretKeyId = secretKeyId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getSecretKey() {
		if (_secretKey == null) {
			return "";
		}
		else {
			return _secretKey;
		}
	}

	@Override
	public void setSecretKey(String secretKey) {
		_secretKey = secretKey;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SecretKey.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SecretKey toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SecretKey)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SecretKeyImpl secretKeyImpl = new SecretKeyImpl();

		secretKeyImpl.setUuid(getUuid());
		secretKeyImpl.setSecretKeyId(getSecretKeyId());
		secretKeyImpl.setCompanyId(getCompanyId());
		secretKeyImpl.setUserId(getUserId());
		secretKeyImpl.setSecretKey(getSecretKey());

		secretKeyImpl.resetOriginalValues();

		return secretKeyImpl;
	}

	@Override
	public int compareTo(SecretKey secretKey) {
		long primaryKey = secretKey.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SecretKey)) {
			return false;
		}

		SecretKey secretKey = (SecretKey)obj;

		long primaryKey = secretKey.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		SecretKeyModelImpl secretKeyModelImpl = this;

		secretKeyModelImpl._originalUuid = secretKeyModelImpl._uuid;

		secretKeyModelImpl._originalCompanyId = secretKeyModelImpl._companyId;

		secretKeyModelImpl._setOriginalCompanyId = false;

		secretKeyModelImpl._originalUserId = secretKeyModelImpl._userId;

		secretKeyModelImpl._setOriginalUserId = false;

		secretKeyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SecretKey> toCacheModel() {
		SecretKeyCacheModel secretKeyCacheModel = new SecretKeyCacheModel();

		secretKeyCacheModel.uuid = getUuid();

		String uuid = secretKeyCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			secretKeyCacheModel.uuid = null;
		}

		secretKeyCacheModel.secretKeyId = getSecretKeyId();

		secretKeyCacheModel.companyId = getCompanyId();

		secretKeyCacheModel.userId = getUserId();

		secretKeyCacheModel.secretKey = getSecretKey();

		String secretKey = secretKeyCacheModel.secretKey;

		if ((secretKey != null) && (secretKey.length() == 0)) {
			secretKeyCacheModel.secretKey = null;
		}

		return secretKeyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", secretKeyId=");
		sb.append(getSecretKeyId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", secretKey=");
		sb.append(getSecretKey());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.mw.totp_2fa.key.model.SecretKey");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secretKeyId</column-name><column-value><![CDATA[");
		sb.append(getSecretKeyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secretKey</column-name><column-value><![CDATA[");
		sb.append(getSecretKey());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = SecretKey.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			SecretKey.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _secretKeyId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _secretKey;
	private long _columnBitmask;
	private SecretKey _escapedModel;
}