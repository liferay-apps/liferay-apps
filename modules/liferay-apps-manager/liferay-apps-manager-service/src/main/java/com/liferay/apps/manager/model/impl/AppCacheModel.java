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

package com.liferay.apps.manager.model.impl;

import com.liferay.apps.manager.model.App;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing App in entity cache.
 *
 * @author LifeDev
 * @generated
 */
public class AppCacheModel
	implements CacheModel<App>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppCacheModel)) {
			return false;
		}

		AppCacheModel appCacheModel = (AppCacheModel)object;

		if ((appId == appCacheModel.appId) &&
			(mvccVersion == appCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, appId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", appId=");
		sb.append(appId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", iconUrl=");
		sb.append(iconUrl);
		sb.append(", link=");
		sb.append(link);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public App toEntityModel() {
		AppImpl appImpl = new AppImpl();

		appImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			appImpl.setUuid("");
		}
		else {
			appImpl.setUuid(uuid);
		}

		appImpl.setAppId(appId);
		appImpl.setGroupId(groupId);
		appImpl.setCompanyId(companyId);
		appImpl.setUserId(userId);

		if (userName == null) {
			appImpl.setUserName("");
		}
		else {
			appImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			appImpl.setCreateDate(null);
		}
		else {
			appImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appImpl.setModifiedDate(null);
		}
		else {
			appImpl.setModifiedDate(new Date(modifiedDate));
		}

		appImpl.setStatus(status);
		appImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			appImpl.setStatusByUserName("");
		}
		else {
			appImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			appImpl.setStatusDate(null);
		}
		else {
			appImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			appImpl.setName("");
		}
		else {
			appImpl.setName(name);
		}

		if (description == null) {
			appImpl.setDescription("");
		}
		else {
			appImpl.setDescription(description);
		}

		if (iconUrl == null) {
			appImpl.setIconUrl("");
		}
		else {
			appImpl.setIconUrl(iconUrl);
		}

		if (link == null) {
			appImpl.setLink("");
		}
		else {
			appImpl.setLink(link);
		}

		appImpl.resetOriginalValues();

		return appImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		appId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		iconUrl = objectInput.readUTF();
		link = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(appId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (iconUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iconUrl);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long appId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String name;
	public String description;
	public String iconUrl;
	public String link;

}