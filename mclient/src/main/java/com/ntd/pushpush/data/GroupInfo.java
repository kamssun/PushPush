package com.ntd.pushpush.data;

import java.util.HashSet;
import java.util.Set;

/**
 * TGroup entity. @author MyEclipse Persistence Tools
 */

public class GroupInfo implements java.io.Serializable {

	// Fields

	private String contactsGroupId;
	private String contactsGroupName;
	private String remark;
	private Set TContactsGroups = new HashSet(0);

	// Constructors

	/** default constructor */
	public GroupInfo() {
	}

	/** minimal constructor */
	public GroupInfo(String contactsGroupId, String contactsGroupName) {
		this.contactsGroupId = contactsGroupId;
		this.contactsGroupName = contactsGroupName;
	}

	/** full constructor */
	public GroupInfo(String contactsGroupId, String contactsGroupName,
			String remark, Set TContactsGroups) {
		this.contactsGroupId = contactsGroupId;
		this.contactsGroupName = contactsGroupName;
		this.remark = remark;
		this.TContactsGroups = TContactsGroups;
	}

	// Property accessors

	public String getContactsGroupId() {
		return this.contactsGroupId;
	}

	public void setContactsGroupId(String contactsGroupId) {
		this.contactsGroupId = contactsGroupId;
	}

	public String getContactsGroupName() {
		return this.contactsGroupName;
	}

	public void setContactsGroupName(String contactsGroupName) {
		this.contactsGroupName = contactsGroupName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getTContactsGroups() {
		return this.TContactsGroups;
	}

	public void setTContactsGroups(Set TContactsGroups) {
		this.TContactsGroups = TContactsGroups;
	}

}