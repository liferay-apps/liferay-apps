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

package com.liferay.apps.manager.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the App service. Represents a row in the &quot;App&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.apps.manager.model.impl.AppModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.apps.manager.model.impl.AppImpl</code>.
 * </p>
 *
 * @author LifeDev
 * @see App
 * @generated
 */
@ProviderType
public interface AppModel
	extends BaseModel<App>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel, TrashedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a app model instance should use the {@link App} interface instead.
	 */

	/**
	 * Returns the primary key of this app.
	 *
	 * @return the primary key of this app
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this app.
	 *
	 * @param primaryKey the primary key of this app
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this app.
	 *
	 * @return the mvcc version of this app
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this app.
	 *
	 * @param mvccVersion the mvcc version of this app
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this app.
	 *
	 * @return the uuid of this app
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this app.
	 *
	 * @param uuid the uuid of this app
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the app ID of this app.
	 *
	 * @return the app ID of this app
	 */
	public long getAppId();

	/**
	 * Sets the app ID of this app.
	 *
	 * @param appId the app ID of this app
	 */
	public void setAppId(long appId);

	/**
	 * Returns the group ID of this app.
	 *
	 * @return the group ID of this app
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this app.
	 *
	 * @param groupId the group ID of this app
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this app.
	 *
	 * @return the company ID of this app
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this app.
	 *
	 * @param companyId the company ID of this app
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this app.
	 *
	 * @return the user ID of this app
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this app.
	 *
	 * @param userId the user ID of this app
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this app.
	 *
	 * @return the user uuid of this app
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this app.
	 *
	 * @param userUuid the user uuid of this app
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this app.
	 *
	 * @return the user name of this app
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this app.
	 *
	 * @param userName the user name of this app
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this app.
	 *
	 * @return the create date of this app
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this app.
	 *
	 * @param createDate the create date of this app
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this app.
	 *
	 * @return the modified date of this app
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this app.
	 *
	 * @param modifiedDate the modified date of this app
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this app.
	 *
	 * @return the status of this app
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this app.
	 *
	 * @param status the status of this app
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this app.
	 *
	 * @return the status by user ID of this app
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this app.
	 *
	 * @param statusByUserId the status by user ID of this app
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this app.
	 *
	 * @return the status by user uuid of this app
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this app.
	 *
	 * @param statusByUserUuid the status by user uuid of this app
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this app.
	 *
	 * @return the status by user name of this app
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this app.
	 *
	 * @param statusByUserName the status by user name of this app
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this app.
	 *
	 * @return the status date of this app
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this app.
	 *
	 * @param statusDate the status date of this app
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the name of this app.
	 *
	 * @return the name of this app
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this app.
	 *
	 * @param name the name of this app
	 */
	public void setName(String name);

	/**
	 * Returns the description of this app.
	 *
	 * @return the description of this app
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this app.
	 *
	 * @param description the description of this app
	 */
	public void setDescription(String description);

	/**
	 * Returns the icon url of this app.
	 *
	 * @return the icon url of this app
	 */
	@AutoEscape
	public String getIconUrl();

	/**
	 * Sets the icon url of this app.
	 *
	 * @param iconUrl the icon url of this app
	 */
	public void setIconUrl(String iconUrl);

	/**
	 * Returns the link of this app.
	 *
	 * @return the link of this app
	 */
	@AutoEscape
	public String getLink();

	/**
	 * Sets the link of this app.
	 *
	 * @param link the link of this app
	 */
	public void setLink(String link);

	/**
	 * Returns the trash entry created when this app was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this app.
	 *
	 * @return the trash entry created when this app was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException;

	/**
	 * Returns the class primary key of the trash entry for this app.
	 *
	 * @return the class primary key of the trash entry for this app
	 */
	@Override
	public long getTrashEntryClassPK();

	/**
	 * Returns the trash handler for this app.
	 *
	 * @return the trash handler for this app
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler();

	/**
	 * Returns <code>true</code> if this app is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this app is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash();

	/**
	 * Returns <code>true</code> if the parent of this app is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this app is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer();

	@Override
	public boolean isInTrashExplicitly();

	@Override
	public boolean isInTrashImplicitly();

	/**
	 * Returns <code>true</code> if this app is approved.
	 *
	 * @return <code>true</code> if this app is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this app is denied.
	 *
	 * @return <code>true</code> if this app is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this app is a draft.
	 *
	 * @return <code>true</code> if this app is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this app is expired.
	 *
	 * @return <code>true</code> if this app is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this app is inactive.
	 *
	 * @return <code>true</code> if this app is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this app is incomplete.
	 *
	 * @return <code>true</code> if this app is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this app is pending.
	 *
	 * @return <code>true</code> if this app is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this app is scheduled.
	 *
	 * @return <code>true</code> if this app is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public App cloneWithOriginalValues();

}