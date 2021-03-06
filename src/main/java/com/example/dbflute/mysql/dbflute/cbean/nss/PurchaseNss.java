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
package com.example.dbflute.mysql.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import com.example.dbflute.mysql.dbflute.cbean.cq.PurchaseCQ;

/**
 * The nest select set-upper of purchase.
 * @author DBFlute(AutoGenerator)
 */
public class PurchaseNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected PurchaseCQ _query;
    public PurchaseNss(PurchaseCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * (会員)member by my MEMBER_ID, named 'member'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMember() {
        _query.doNss(new PurchaseCQ.NssCall() { public ConditionQuery qf() { return _query.queryMember(); }});
        return new MemberNss(_query.queryMember());
    }
    /**
     * With nested relation columns to select clause. <br />
     * (商品)product by my PRODUCT_ID, named 'product'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public ProductNss withProduct() {
        _query.doNss(new PurchaseCQ.NssCall() { public ConditionQuery qf() { return _query.queryProduct(); }});
        return new ProductNss(_query.queryProduct());
    }
    /**
     * With nested relation columns to select clause. <br />
     * (購入)purchase by my PURCHASE_ID, named 'purchaseSelf'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public PurchaseNss withPurchaseSelf() {
        _query.doNss(new PurchaseCQ.NssCall() { public ConditionQuery qf() { return _query.queryPurchaseSelf(); }});
        return new PurchaseNss(_query.queryPurchaseSelf());
    }
    /**
     * With nested relation columns to select clause. <br />
     * (会員住所情報)member_address by my MEMBER_ID, named 'memberAddressAsSkipRelation'.
     * @param targetDate The bind parameter of fixed condition for targetDate. (NotNull)
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberAddressNss withMemberAddressAsSkipRelation(final java.util.Date targetDate) {
        _query.doNss(new PurchaseCQ.NssCall() { public ConditionQuery qf() { return _query.queryMemberAddressAsSkipRelation(targetDate); }});
        return new MemberAddressNss(_query.queryMemberAddressAsSkipRelation(targetDate));
    }

    /**
     * With nested relation columns to select clause. <br />
     * (購入)purchase by PURCHASE_ID, named 'purchaseSelfAsOne'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public PurchaseNss withPurchaseSelfAsOne() {
        _query.doNss(new PurchaseCQ.NssCall() { public ConditionQuery qf() { return _query.queryPurchaseSelfAsOne(); }});
        return new PurchaseNss(_query.queryPurchaseSelfAsOne());
    }
}
