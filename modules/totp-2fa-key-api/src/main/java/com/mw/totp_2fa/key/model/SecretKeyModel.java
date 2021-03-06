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

package com.mw.totp_2fa.key.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the SecretKey service. Represents a row in the &quot;totp_SecretKey&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.mw.totp_2fa.key.model.impl.SecretKeyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.mw.totp_2fa.key.model.impl.SecretKeyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecretKey
 * @see com.mw.totp_2fa.key.model.impl.SecretKeyImpl
 * @see com.mw.totp_2fa.key.model.impl.SecretKeyModelImpl
 * @generated
 */
@ProviderType
public interface SecretKeyModel extends BaseModel<SecretKey>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a secret key model instance should use the {@link SecretKey} interface instead.
	 */

	/**
	 * Returns the primary key of this secret key.
	 *
	 * @return the primary key of this secret key
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this secret key.
	 *
	 * @param primaryKey the primary key of this secret key
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this secret key.
	 *
	 * @return the uuid of this secret key
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this secret key.
	 *
	 * @param uuid the uuid of this secret key
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the secret key ID of this secret key.
	 *
	 * @return the secret key ID of this secret key
	 */
	public long getSecretKeyId();

	/**
	 * Sets the secret key ID of this secret key.
	 *
	 * @param secretKeyId the secret key ID of this secret key
	 */
	public void setSecretKeyId(long secretKeyId);

	/**
	 * Returns the company ID of this secret key.
	 *
	 * @return the company ID of this secret key
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this secret key.
	 *
	 * @param companyId the company ID of this secret key
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this secret key.
	 *
	 * @return the user ID of this secret key
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this secret key.
	 *
	 * @param userId the user ID of this secret key
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this secret key.
	 *
	 * @return the user uuid of this secret key
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this secret key.
	 *
	 * @param userUuid the user uuid of this secret key
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the secret key of this secret key.
	 *
	 * @return the secret key of this secret key
	 */
	@AutoEscape
	public String getSecretKey();

	/**
	 * Sets the secret key of this secret key.
	 *
	 * @param secretKey the secret key of this secret key
	 */
	public void setSecretKey(String secretKey);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(SecretKey secretKey);

	@Override
	public int hashCode();

	@Override
	public CacheModel<SecretKey> toCacheModel();

	@Override
	public SecretKey toEscapedModel();

	@Override
	public SecretKey toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}