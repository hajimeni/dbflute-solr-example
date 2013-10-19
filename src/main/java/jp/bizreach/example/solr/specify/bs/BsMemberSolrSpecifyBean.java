package jp.bizreach.example.solr.specify.bs;

import jp.bizreach.example.solr.base.AbstractSolrSpecifyBean;
import jp.bizreach.example.solr.meta.MemberSolrMeta;


/**
 * Solr検索のフィールド絞り込み保存用BeanのBaseクラス
 * string, tint, tlong, tdate, tdouble, text_ja, text_cjkのみに対応しています
 * @author FreeGen
 * @author nishiyama
 */
public class BsMemberSolrSpecifyBean extends AbstractSolrSpecifyBean {

    // ===================================================================================
    //                                                                        SpricyColumn
    //                                                                        ============
    public void fieldId() {
		this.addSpecifyField(MemberSolrMeta.FIELD_id);
    }

    public void fieldMemberId() {
		this.addSpecifyField(MemberSolrMeta.FIELD_member_id);
    }

    public void fieldMemberStatusCd() {
		this.addSpecifyField(MemberSolrMeta.FIELD_member_status_cd);
    }

    public void fieldMemberName() {
		this.addSpecifyField(MemberSolrMeta.FIELD_member_name);
    }

    public void fieldMemberAccount() {
		this.addSpecifyField(MemberSolrMeta.FIELD_member_account);
    }

    public void fieldBirthdate() {
		this.addSpecifyField(MemberSolrMeta.FIELD_birthdate);
    }

    public void fieldFormalizedDatetime() {
		this.addSpecifyField(MemberSolrMeta.FIELD_formalized_datetime);
    }

    public void fieldPurchaseId() {
		this.addSpecifyField(MemberSolrMeta.FIELD_purchase_id);
    }

    public void fieldProductId() {
		this.addSpecifyField(MemberSolrMeta.FIELD_product_id);
    }

    public void fieldProductName() {
		this.addSpecifyField(MemberSolrMeta.FIELD_product_name);
    }

    public void fieldProductCategoryCode() {
		this.addSpecifyField(MemberSolrMeta.FIELD_product_category_code);
    }

    public void fieldProductCategoryName() {
		this.addSpecifyField(MemberSolrMeta.FIELD_product_category_name);
    }

}
