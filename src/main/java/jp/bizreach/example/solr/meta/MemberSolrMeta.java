package jp.bizreach.example.solr.meta;

import jp.bizreach.example.solr.base.AbstractSolrClient;

/**
 * Solr検索ClientのBaseクラス
 * string, tint, tlong, tdate, tdouble, text_ja, text_cjkのみに対応しています
 * @author FreeGen
 */
public class MemberSolrMeta extends AbstractSolrClient {

    // ===================================================================================
    //                                                                       SolrFieldName
    //                                                                       =============

	/** id */
	public static final String FIELD_id = "id";

	/** member_id */
	public static final String FIELD_member_id = "member_id";

	/** member_status_cd */
	public static final String FIELD_member_status_cd = "member_status_cd";

	/** member_name */
	public static final String FIELD_member_name = "member_name";

	/** member_account */
	public static final String FIELD_member_account = "member_account";

	/** birthdate */
	public static final String FIELD_birthdate = "birthdate";

	/** formalized_datetime */
	public static final String FIELD_formalized_datetime = "formalized_datetime";

	/** purchase_id */
	public static final String FIELD_purchase_id = "purchase_id";

	/** product_id */
	public static final String FIELD_product_id = "product_id";

	/** product_name */
	public static final String FIELD_product_name = "product_name";

	/** product_category_code */
	public static final String FIELD_product_category_code = "product_category_code";

	/** product_category_name */
	public static final String FIELD_product_category_name = "product_category_name";

	/** purchase_name */
	public static final String FIELD_purchase_name = "purchase_name";


    // ===================================================================================
    //                                                                         Field Names
    //                                                                         ===========

	public static final String[] STORED_FIELD_NAMES = {
 FIELD_id
, FIELD_member_id
, FIELD_member_status_cd
, FIELD_member_name
, FIELD_member_account
, FIELD_birthdate
, FIELD_formalized_datetime
, FIELD_purchase_id
, FIELD_product_id
, FIELD_product_name
, FIELD_product_category_code
, FIELD_product_category_name
	};

}
