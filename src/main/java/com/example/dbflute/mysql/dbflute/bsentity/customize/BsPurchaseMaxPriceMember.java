/*
 * Copyright 2004-2013 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.dbflute.mysql.dbflute.bsentity.customize;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.Entity;
import com.example.dbflute.mysql.dbflute.exentity.customize.*;

/**
 * The entity of PurchaseMaxPriceMember. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, PURCHASE_MAX_PRICE, MEMBER_STATUS_NAME
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     
 * 
 * [foreign table]
 *     
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer memberId = entity.getMemberId();
 * String memberName = entity.getMemberName();
 * Integer purchaseMaxPrice = entity.getPurchaseMaxPrice();
 * String memberStatusName = entity.getMemberStatusName();
 * entity.setMemberId(memberId);
 * entity.setMemberName(memberName);
 * entity.setPurchaseMaxPrice(purchaseMaxPrice);
 * entity.setMemberStatusName(memberStatusName);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPurchaseMaxPriceMember implements Entity, Serializable, Cloneable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** (会員ID)MEMBER_ID: {INT(11), refers to member.MEMBER_ID} */
    protected Integer _memberId;

    /** (会員名称)MEMBER_NAME: {VARCHAR(200), refers to member.MEMBER_NAME} */
    protected String _memberName;

    /** PURCHASE_MAX_PRICE: {INT(11)} */
    protected Integer _purchaseMaxPrice;

    /** (会員ステータス名称)MEMBER_STATUS_NAME: {VARCHAR(50), refers to member_status.MEMBER_STATUS_NAME} */
    protected String _memberStatusName;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this entity. (NotNull) */
    protected final EntityModifiedProperties __modifiedProperties = newModifiedProperties();

    /** Is the entity created by DBFlute select process? */
    protected boolean __createdBySelect;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "PurchaseMaxPriceMember";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "purchaseMaxPriceMember";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return com.example.dbflute.mysql.dbflute.bsentity.customize.dbmeta.PurchaseMaxPriceMemberDbm.getInstance();
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        return false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    /**
     * {@inheritDoc}
     */
    public Set<String> modifiedProperties() {
        return __modifiedProperties.getPropertyNames();
    }

    /**
     * {@inheritDoc}
     */
    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    protected EntityModifiedProperties newModifiedProperties() {
        return new EntityModifiedProperties();
    }

    // ===================================================================================
    //                                                                     Birthplace Mark
    //                                                                     ===============
    /**
     * {@inheritDoc}
     */
    public void markAsSelect() {
        __createdBySelect = true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean createdBySelect() {
        return __createdBySelect;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * Determine the object is equal with this. <br />
     * If primary-keys or columns of the other are same as this one, returns true.
     * @param other The other entity. (NullAllowed: if null, returns false fixedly)
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsPurchaseMaxPriceMember)) { return false; }
        BsPurchaseMaxPriceMember otherEntity = (BsPurchaseMaxPriceMember)other;
        if (!xSV(getMemberId(), otherEntity.getMemberId())) { return false; }
        if (!xSV(getMemberName(), otherEntity.getMemberName())) { return false; }
        if (!xSV(getPurchaseMaxPrice(), otherEntity.getPurchaseMaxPrice())) { return false; }
        if (!xSV(getMemberStatusName(), otherEntity.getMemberStatusName())) { return false; }
        return true;
    }
    protected boolean xSV(Object value1, Object value2) { // isSameValue()
        return InternalUtil.isSameValue(value1, value2);
    }

    /**
     * Calculate the hash-code from primary-keys or columns.
     * @return The hash-code from primary-key or columns.
     */
    public int hashCode() {
        int result = 17;
        result = xCH(result, getTableDbName());
        result = xCH(result, getMemberId());
        result = xCH(result, getMemberName());
        result = xCH(result, getPurchaseMaxPrice());
        result = xCH(result, getMemberStatusName());
        return result;
    }
    protected int xCH(int result, Object value) { // calculateHashcode()
        return InternalUtil.calculateHashcode(result, value);
    }

    /**
     * {@inheritDoc}
     */
    public int instanceHash() {
        return super.hashCode();
    }

    /**
     * Convert to display string of entity's data. (no relation data)
     * @return The display string of all columns and relation existences. (NotNull)
     */
    public String toString() {
        return buildDisplayString(InternalUtil.toClassTitle(this), true, true);
    }

    /**
     * {@inheritDoc}
     */
    public String toStringWithRelation() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    public String buildDisplayString(String name, boolean column, boolean relation) {
        StringBuilder sb = new StringBuilder();
        if (name != null) { sb.append(name).append(column || relation ? ":" : ""); }
        if (column) { sb.append(buildColumnString()); }
        if (relation) { sb.append(buildRelationString()); }
        sb.append("@").append(Integer.toHexString(hashCode()));
        return sb.toString();
    }
    protected String buildColumnString() {
        StringBuilder sb = new StringBuilder();
        String delimiter = ", ";
        sb.append(delimiter).append(getMemberId());
        sb.append(delimiter).append(getMemberName());
        sb.append(delimiter).append(getPurchaseMaxPrice());
        sb.append(delimiter).append(getMemberStatusName());
        if (sb.length() > delimiter.length()) {
            sb.delete(0, delimiter.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        return "";
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public PurchaseMaxPriceMember clone() {
        try {
            return (PurchaseMaxPriceMember)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (会員ID)MEMBER_ID: {INT(11), refers to member.MEMBER_ID} <br />
     * 会員を識別するID。連番として基本的に自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMSによって変わる。<br />
     * // unique key of this result
     * @return The value of the column 'MEMBER_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getMemberId() {
        return _memberId;
    }

    /**
     * [set] (会員ID)MEMBER_ID: {INT(11), refers to member.MEMBER_ID} <br />
     * 会員を識別するID。連番として基本的に自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMSによって変わる。<br />
     * // unique key of this result
     * @param memberId The value of the column 'MEMBER_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemberId(Integer memberId) {
        __modifiedProperties.addPropertyName("memberId");
        this._memberId = memberId;
    }

    /**
     * [get] (会員名称)MEMBER_NAME: {VARCHAR(200), refers to member.MEMBER_NAME} <br />
     * 会員のフルネームの名称。
     * @return The value of the column 'MEMBER_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getMemberName() {
        return _memberName;
    }

    /**
     * [set] (会員名称)MEMBER_NAME: {VARCHAR(200), refers to member.MEMBER_NAME} <br />
     * 会員のフルネームの名称。
     * @param memberName The value of the column 'MEMBER_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemberName(String memberName) {
        __modifiedProperties.addPropertyName("memberName");
        this._memberName = memberName;
    }

    /**
     * [get] PURCHASE_MAX_PRICE: {INT(11)} <br />
     * // max of purchase price
     * @return The value of the column 'PURCHASE_MAX_PRICE'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getPurchaseMaxPrice() {
        return _purchaseMaxPrice;
    }

    /**
     * [set] PURCHASE_MAX_PRICE: {INT(11)} <br />
     * // max of purchase price
     * @param purchaseMaxPrice The value of the column 'PURCHASE_MAX_PRICE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setPurchaseMaxPrice(Integer purchaseMaxPrice) {
        __modifiedProperties.addPropertyName("purchaseMaxPrice");
        this._purchaseMaxPrice = purchaseMaxPrice;
    }

    /**
     * [get] (会員ステータス名称)MEMBER_STATUS_NAME: {VARCHAR(50), refers to member_status.MEMBER_STATUS_NAME} <br />
     * @return The value of the column 'MEMBER_STATUS_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getMemberStatusName() {
        return _memberStatusName;
    }

    /**
     * [set] (会員ステータス名称)MEMBER_STATUS_NAME: {VARCHAR(50), refers to member_status.MEMBER_STATUS_NAME} <br />
     * @param memberStatusName The value of the column 'MEMBER_STATUS_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemberStatusName(String memberStatusName) {
        __modifiedProperties.addPropertyName("memberStatusName");
        this._memberStatusName = memberStatusName;
    }
}
