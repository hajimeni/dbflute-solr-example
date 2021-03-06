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
package com.example.dbflute.mysql.dbflute.cbean.cq.ciq;

import java.util.Map;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.ConditionOption;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import com.example.dbflute.mysql.dbflute.cbean.*;
import com.example.dbflute.mysql.dbflute.cbean.cq.bs.*;
import com.example.dbflute.mysql.dbflute.cbean.cq.*;

/**
 * The condition-query for in-line of purchase.
 * @author DBFlute(AutoGenerator)
 */
public class PurchaseCIQ extends AbstractBsPurchaseCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsPurchaseCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public PurchaseCIQ(ConditionQuery childQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsPurchaseCQ myCQ) {
        super(childQuery, sqlClause, aliasName, nestLevel);
        _myCQ = myCQ;
        _foreignPropertyName = _myCQ.xgetForeignPropertyName(); // accept foreign property name
        _relationPath = _myCQ.xgetRelationPath(); // accept relation path
        _inline = true;
    }

    // ===================================================================================
    //                                                             Override about Register
    //                                                             =======================
    @Override
    protected void reflectRelationOnUnionQuery(ConditionQuery bq, ConditionQuery uq) {
        String msg = "InlineView must not need UNION method: " + bq + " : " + uq;
        throw new IllegalConditionBeanOperationException(msg);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col) {
        regIQ(k, v, cv, col);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col, ConditionOption op) {
        regIQ(k, v, cv, col, op);
    }

    @Override
    protected void registerWhereClause(String wc) {
        registerInlineWhereClause(wc);
    }

    @Override
    protected boolean isInScopeRelationSuppressLocalAliasName() {
        if (_onClause) {
            throw new IllegalConditionBeanOperationException("InScopeRelation on OnClause is unsupported.");
        }
        return true;
    }

    // ===================================================================================
    //                                                                Override about Query
    //                                                                ====================
    protected ConditionValue getCValuePurchaseId() { return _myCQ.getPurchaseId(); }
    public String keepPurchaseId_ExistsReferrer_PurchaseSelfAsOne(PurchaseCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepPurchaseId_NotExistsReferrer_PurchaseSelfAsOne(PurchaseCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepPurchaseId_InScopeRelation_PurchaseSelf(PurchaseCQ sq)
    { return _myCQ.keepPurchaseId_InScopeRelation_PurchaseSelf(sq); }
    public String keepPurchaseId_InScopeRelation_PurchaseSelfAsOne(PurchaseCQ sq)
    { return _myCQ.keepPurchaseId_InScopeRelation_PurchaseSelfAsOne(sq); }
    public String keepPurchaseId_NotInScopeRelation_PurchaseSelf(PurchaseCQ sq)
    { return _myCQ.keepPurchaseId_NotInScopeRelation_PurchaseSelf(sq); }
    public String keepPurchaseId_NotInScopeRelation_PurchaseSelfAsOne(PurchaseCQ sq)
    { return _myCQ.keepPurchaseId_NotInScopeRelation_PurchaseSelfAsOne(sq); }
    protected ConditionValue getCValueMemberId() { return _myCQ.getMemberId(); }
    public String keepMemberId_InScopeRelation_Member(MemberCQ sq)
    { return _myCQ.keepMemberId_InScopeRelation_Member(sq); }
    public String keepMemberId_NotInScopeRelation_Member(MemberCQ sq)
    { return _myCQ.keepMemberId_NotInScopeRelation_Member(sq); }
    protected ConditionValue getCValueProductId() { return _myCQ.getProductId(); }
    public String keepProductId_InScopeRelation_Product(ProductCQ sq)
    { return _myCQ.keepProductId_InScopeRelation_Product(sq); }
    public String keepProductId_NotInScopeRelation_Product(ProductCQ sq)
    { return _myCQ.keepProductId_NotInScopeRelation_Product(sq); }
    protected ConditionValue getCValuePurchaseDatetime() { return _myCQ.getPurchaseDatetime(); }
    protected ConditionValue getCValuePurchaseCount() { return _myCQ.getPurchaseCount(); }
    protected ConditionValue getCValuePurchasePrice() { return _myCQ.getPurchasePrice(); }
    protected ConditionValue getCValuePaymentCompleteFlg() { return _myCQ.getPaymentCompleteFlg(); }
    protected ConditionValue getCValueRegisterDatetime() { return _myCQ.getRegisterDatetime(); }
    protected ConditionValue getCValueRegisterUser() { return _myCQ.getRegisterUser(); }
    protected ConditionValue getCValueUpdateDatetime() { return _myCQ.getUpdateDatetime(); }
    protected ConditionValue getCValueUpdateUser() { return _myCQ.getUpdateUser(); }
    protected ConditionValue getCValueVersionNo() { return _myCQ.getVersionNo(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) { return null; }
    public String keepScalarCondition(PurchaseCQ subQuery)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(PurchaseCQ subQuery)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(PurchaseCQ subQuery)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object parameterValue)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(PurchaseCQ subQuery)
    { throwIICBOE("MyselfExists"); return null;}
    public String keepMyselfInScope(PurchaseCQ subQuery)
    { throwIICBOE("MyselfInScope"); return null;}

    protected void throwIICBOE(String name) { // throwInlineIllegalConditionBeanOperationException()
        throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported.");
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return PurchaseCB.class.getName(); }
    protected String xinCQ() { return PurchaseCQ.class.getName(); }
}
