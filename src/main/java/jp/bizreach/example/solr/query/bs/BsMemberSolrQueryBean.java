package jp.bizreach.example.solr.query.bs;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Date;

import jp.bizreach.example.solr.base.AbstractSolrQueryBean;
import jp.bizreach.example.solr.base.SolrQueryBuilder;
import jp.bizreach.example.solr.base.SolrQueryLogicalOperator;
import jp.bizreach.example.solr.base.SolrSetRangeSearchBean;
import jp.bizreach.example.solr.meta.MemberSolrMeta;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrQuery.SortClause;

/**
 * Solr検索クエリ生成用のQueryBeanのBaseクラス
 * string, tint, tlong, tdate, tdouble, text_ja, text_cjkのみに対応しています
 * @author FreeGen
 */
public class BsMemberSolrQueryBean extends AbstractSolrQueryBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** Query Attribute for id (tlong) */
    protected String idQuery;

    /** Query Attribute for member_id (tlong) */
    protected String memberIdQuery;

    /** Query Attribute for member_status_cd (string) */
    protected String memberStatusCdQuery;

    /** Query Attribute for member_name (string) */
    protected String memberNameQuery;

    /** Query Attribute for member_account (string) */
    protected String memberAccountQuery;

    /** Query Attribute for birthdate (tdate) */
    protected String birthdateQuery;

    /** Query Attribute for formalized_datetime (tdate) */
    protected String formalizedDatetimeQuery;

    /** Query Attribute for purchase_id (tlong) */
    protected String purchaseIdQuery;

    /** Query Attribute for product_id (tlong) */
    protected String productIdQuery;

    /** Query Attribute for product_name (string) */
    protected String productNameQuery;

    /** Query Attribute for product_category_code (string) */
    protected String productCategoryCodeQuery;

    /** Query Attribute for product_category_name (string) */
    protected String productCategoryNameQuery;

    /** Query Attribute for purchase_name (text_cjk) */
    protected String purchaseNameQuery;

    // =====================================================================================
    //                                                                            Conditions
    //                                                                            ==========
    // ===========================================================
    // Query Setter for id (tlong)
    //                                                  ==========

	/**
	 * ExistsQuery( q=id:* )
	 */
	public void setId_Exists() {
		this.idQuery = SolrQueryBuilder.queryBuilderForExists("id");
	}

	public void setId_Equal(Long query) {
		if (query != null) {
			setId_Equal(query, null);
		}
	}

	public void setId_Equal(Long query, SolrQueryLogicalOperator operator) {
		if (query != null) {
			this.idQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("id", query.toString(), operator);
		}
	}

	public void setId_NotEqual(Long query) {
		if (query != null) {
			setId_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setId_InScope(Collection<Long> queryList) {
		this.setId_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setId_InScope(Collection<Long> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchLongList("id", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.idQuery = convertedQuery;
		}
	}

	public void setId_NotInScope(Collection<Long> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchLongList("id", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.idQuery = convertedQuery;
		}
	}

	public void setId_RangeSearchFrom(Long from) {
		if (from != null) {
			setId_RangeSearch(from, null);
		}
	}

	public void setId_RangeSearchTo(Long to) {
		if (to != null) {
			setId_RangeSearch(null, to);
		}
	}

	public void setId_RangeSearch(Long from, Long to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("id", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.idQuery = convertedQuery;
		}
	}

	public void addOrderBy_Id_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_id, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_Id_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_id, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for member_id (tlong)
    //                                                  ==========

	/**
	 * ExistsQuery( q=member_id:* )
	 */
	public void setMemberId_Exists() {
		this.memberIdQuery = SolrQueryBuilder.queryBuilderForExists("member_id");
	}

	public void setMemberId_Equal(Long query) {
		if (query != null) {
			setMemberId_Equal(query, null);
		}
	}

	public void setMemberId_Equal(Long query, SolrQueryLogicalOperator operator) {
		if (query != null) {
			this.memberIdQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("member_id", query.toString(), operator);
		}
	}

	public void setMemberId_NotEqual(Long query) {
		if (query != null) {
			setMemberId_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setMemberId_InScope(Collection<Long> queryList) {
		this.setMemberId_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setMemberId_InScope(Collection<Long> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchLongList("member_id", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberIdQuery = convertedQuery;
		}
	}

	public void setMemberId_NotInScope(Collection<Long> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchLongList("member_id", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberIdQuery = convertedQuery;
		}
	}

	public void setMemberId_RangeSearchFrom(Long from) {
		if (from != null) {
			setMemberId_RangeSearch(from, null);
		}
	}

	public void setMemberId_RangeSearchTo(Long to) {
		if (to != null) {
			setMemberId_RangeSearch(null, to);
		}
	}

	public void setMemberId_RangeSearch(Long from, Long to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("member_id", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberIdQuery = convertedQuery;
		}
	}

	public void addOrderBy_MemberId_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_member_id, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_MemberId_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_member_id, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for member_status_cd (string)
    //                                                  ==========

	/**
	 * ExistsQuery( q=member_status_cd:* )
	 */
	public void setMemberStatusCd_Exists() {
		this.memberStatusCdQuery = SolrQueryBuilder.queryBuilderForExists("member_status_cd");
	}

	public void setMemberStatusCd_Equal(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setMemberStatusCd_Equal(query, null);
		}
	}

	public void setMemberStatusCd_NotEqual(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setMemberStatusCd_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setMemberStatusCd_Equal(String query, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("member_status_cd", query, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberStatusCdQuery = convertedQuery;
		}
	}

	public void setMemberStatusCd_InScope(Collection<String> queryList) {
		this.setMemberStatusCd_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setMemberStatusCd_InScope(Collection<String> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("member_status_cd", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberStatusCdQuery = convertedQuery;
		}
	}

	public void setMemberStatusCd_NotInScope(Collection<String> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("member_status_cd", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberStatusCdQuery = convertedQuery;
		}
	}
	
	public void setMemberStatusCd_PrefixSearch(String query) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForPrefixSearch("member_status_cd", query);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberStatusCdQuery = convertedQuery;
		}
	}

	public void setMemberStatusCd_RangeSearchFrom(String from) {
		if (StringUtils.isNotEmpty(from)) {
			setMemberStatusCd_RangeSearch(from, null);
		}
	}

	public void setMemberStatusCd_RangeSearchTo(String to) {
		if (StringUtils.isNotEmpty(to)) {
			setMemberStatusCd_RangeSearch(null, to);
		}
	}

	public void setMemberStatusCd_RangeSearch(String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("member_status_cd", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberStatusCdQuery = convertedQuery;
		}
	}

	public void setMemberStatusCd_SetRangeSearch(String cd, String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearch("member_status_cd", cd, from, to, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberStatusCdQuery = convertedQuery;
		}
	}

	public void setMemberStatusCd_SetRangeSearchInScope(Collection<SolrSetRangeSearchBean> beanList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearchInScope("member_status_cd", beanList, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberStatusCdQuery = convertedQuery;
		}
	}

	public void addOrderBy_MemberStatusCd_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_member_status_cd, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_MemberStatusCd_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_member_status_cd, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for member_name (string)
    //                                                  ==========

	/**
	 * ExistsQuery( q=member_name:* )
	 */
	public void setMemberName_Exists() {
		this.memberNameQuery = SolrQueryBuilder.queryBuilderForExists("member_name");
	}

	public void setMemberName_Equal(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setMemberName_Equal(query, null);
		}
	}

	public void setMemberName_NotEqual(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setMemberName_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setMemberName_Equal(String query, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("member_name", query, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberNameQuery = convertedQuery;
		}
	}

	public void setMemberName_InScope(Collection<String> queryList) {
		this.setMemberName_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setMemberName_InScope(Collection<String> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("member_name", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberNameQuery = convertedQuery;
		}
	}

	public void setMemberName_NotInScope(Collection<String> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("member_name", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberNameQuery = convertedQuery;
		}
	}
	
	public void setMemberName_PrefixSearch(String query) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForPrefixSearch("member_name", query);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberNameQuery = convertedQuery;
		}
	}

	public void setMemberName_RangeSearchFrom(String from) {
		if (StringUtils.isNotEmpty(from)) {
			setMemberName_RangeSearch(from, null);
		}
	}

	public void setMemberName_RangeSearchTo(String to) {
		if (StringUtils.isNotEmpty(to)) {
			setMemberName_RangeSearch(null, to);
		}
	}

	public void setMemberName_RangeSearch(String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("member_name", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberNameQuery = convertedQuery;
		}
	}

	public void setMemberName_SetRangeSearch(String cd, String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearch("member_name", cd, from, to, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberNameQuery = convertedQuery;
		}
	}

	public void setMemberName_SetRangeSearchInScope(Collection<SolrSetRangeSearchBean> beanList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearchInScope("member_name", beanList, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberNameQuery = convertedQuery;
		}
	}

	public void addOrderBy_MemberName_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_member_name, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_MemberName_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_member_name, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for member_account (string)
    //                                                  ==========

	/**
	 * ExistsQuery( q=member_account:* )
	 */
	public void setMemberAccount_Exists() {
		this.memberAccountQuery = SolrQueryBuilder.queryBuilderForExists("member_account");
	}

	public void setMemberAccount_Equal(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setMemberAccount_Equal(query, null);
		}
	}

	public void setMemberAccount_NotEqual(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setMemberAccount_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setMemberAccount_Equal(String query, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("member_account", query, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberAccountQuery = convertedQuery;
		}
	}

	public void setMemberAccount_InScope(Collection<String> queryList) {
		this.setMemberAccount_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setMemberAccount_InScope(Collection<String> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("member_account", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberAccountQuery = convertedQuery;
		}
	}

	public void setMemberAccount_NotInScope(Collection<String> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("member_account", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberAccountQuery = convertedQuery;
		}
	}
	
	public void setMemberAccount_PrefixSearch(String query) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForPrefixSearch("member_account", query);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberAccountQuery = convertedQuery;
		}
	}

	public void setMemberAccount_RangeSearchFrom(String from) {
		if (StringUtils.isNotEmpty(from)) {
			setMemberAccount_RangeSearch(from, null);
		}
	}

	public void setMemberAccount_RangeSearchTo(String to) {
		if (StringUtils.isNotEmpty(to)) {
			setMemberAccount_RangeSearch(null, to);
		}
	}

	public void setMemberAccount_RangeSearch(String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("member_account", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberAccountQuery = convertedQuery;
		}
	}

	public void setMemberAccount_SetRangeSearch(String cd, String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearch("member_account", cd, from, to, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberAccountQuery = convertedQuery;
		}
	}

	public void setMemberAccount_SetRangeSearchInScope(Collection<SolrSetRangeSearchBean> beanList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearchInScope("member_account", beanList, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.memberAccountQuery = convertedQuery;
		}
	}

	public void addOrderBy_MemberAccount_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_member_account, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_MemberAccount_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_member_account, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for birthdate (tdate)
    //                                                  ==========

	/**
	 * ExistsQuery( q=birthdate:* )
	 */
	public void setBirthdate_Exists() {
		this.birthdateQuery = SolrQueryBuilder.queryBuilderForExists("birthdate");
	}

	public void setBirthdate_RangeSearchFrom(Date from) {
		if (from != null) {
			setBirthdate_RangeSearch(from, null);
		}
	}

	public void setBirthdate_RangeSearchTo(Date to) {
		if (to != null) {
			setBirthdate_RangeSearch(null, to);
		}
	}

	public void setBirthdate_RangeSearch(Date from, Date to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("birthdate", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.birthdateQuery = convertedQuery;
		}
	}

	public void addOrderBy_Birthdate_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_birthdate, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_Birthdate_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_birthdate, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for formalized_datetime (tdate)
    //                                                  ==========

	/**
	 * ExistsQuery( q=formalized_datetime:* )
	 */
	public void setFormalizedDatetime_Exists() {
		this.formalizedDatetimeQuery = SolrQueryBuilder.queryBuilderForExists("formalized_datetime");
	}

	public void setFormalizedDatetime_RangeSearchFrom(Date from) {
		if (from != null) {
			setFormalizedDatetime_RangeSearch(from, null);
		}
	}

	public void setFormalizedDatetime_RangeSearchTo(Date to) {
		if (to != null) {
			setFormalizedDatetime_RangeSearch(null, to);
		}
	}

	public void setFormalizedDatetime_RangeSearch(Date from, Date to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("formalized_datetime", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.formalizedDatetimeQuery = convertedQuery;
		}
	}

	public void addOrderBy_FormalizedDatetime_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_formalized_datetime, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_FormalizedDatetime_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_formalized_datetime, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for purchase_id (tlong)
    //                                                  ==========

	/**
	 * ExistsQuery( q=purchase_id:* )
	 */
	public void setPurchaseId_Exists() {
		this.purchaseIdQuery = SolrQueryBuilder.queryBuilderForExists("purchase_id");
	}

	public void setPurchaseId_Equal(Long query) {
		if (query != null) {
			setPurchaseId_Equal(query, null);
		}
	}

	public void setPurchaseId_Equal(Long query, SolrQueryLogicalOperator operator) {
		if (query != null) {
			this.purchaseIdQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("purchase_id", query.toString(), operator);
		}
	}

	public void setPurchaseId_NotEqual(Long query) {
		if (query != null) {
			setPurchaseId_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setPurchaseId_InScope(Collection<Long> queryList) {
		this.setPurchaseId_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setPurchaseId_InScope(Collection<Long> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchLongList("purchase_id", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.purchaseIdQuery = convertedQuery;
		}
	}

	public void setPurchaseId_NotInScope(Collection<Long> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchLongList("purchase_id", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.purchaseIdQuery = convertedQuery;
		}
	}

	public void setPurchaseId_RangeSearchFrom(Long from) {
		if (from != null) {
			setPurchaseId_RangeSearch(from, null);
		}
	}

	public void setPurchaseId_RangeSearchTo(Long to) {
		if (to != null) {
			setPurchaseId_RangeSearch(null, to);
		}
	}

	public void setPurchaseId_RangeSearch(Long from, Long to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("purchase_id", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.purchaseIdQuery = convertedQuery;
		}
	}

	public void addOrderBy_PurchaseId_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_purchase_id, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_PurchaseId_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_purchase_id, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for product_id (tlong)
    //                                                  ==========

	/**
	 * ExistsQuery( q=product_id:* )
	 */
	public void setProductId_Exists() {
		this.productIdQuery = SolrQueryBuilder.queryBuilderForExists("product_id");
	}

	public void setProductId_Equal(Long query) {
		if (query != null) {
			setProductId_Equal(query, null);
		}
	}

	public void setProductId_Equal(Long query, SolrQueryLogicalOperator operator) {
		if (query != null) {
			this.productIdQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("product_id", query.toString(), operator);
		}
	}

	public void setProductId_NotEqual(Long query) {
		if (query != null) {
			setProductId_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setProductId_InScope(Collection<Long> queryList) {
		this.setProductId_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setProductId_InScope(Collection<Long> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchLongList("product_id", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productIdQuery = convertedQuery;
		}
	}

	public void setProductId_NotInScope(Collection<Long> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchLongList("product_id", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productIdQuery = convertedQuery;
		}
	}

	public void setProductId_RangeSearchFrom(Long from) {
		if (from != null) {
			setProductId_RangeSearch(from, null);
		}
	}

	public void setProductId_RangeSearchTo(Long to) {
		if (to != null) {
			setProductId_RangeSearch(null, to);
		}
	}

	public void setProductId_RangeSearch(Long from, Long to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("product_id", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productIdQuery = convertedQuery;
		}
	}

	public void addOrderBy_ProductId_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_product_id, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_ProductId_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_product_id, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for product_name (string)
    //                                                  ==========

	/**
	 * ExistsQuery( q=product_name:* )
	 */
	public void setProductName_Exists() {
		this.productNameQuery = SolrQueryBuilder.queryBuilderForExists("product_name");
	}

	public void setProductName_Equal(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setProductName_Equal(query, null);
		}
	}

	public void setProductName_NotEqual(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setProductName_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setProductName_Equal(String query, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("product_name", query, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productNameQuery = convertedQuery;
		}
	}

	public void setProductName_InScope(Collection<String> queryList) {
		this.setProductName_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setProductName_InScope(Collection<String> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("product_name", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productNameQuery = convertedQuery;
		}
	}

	public void setProductName_NotInScope(Collection<String> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("product_name", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productNameQuery = convertedQuery;
		}
	}
	
	public void setProductName_PrefixSearch(String query) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForPrefixSearch("product_name", query);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productNameQuery = convertedQuery;
		}
	}

	public void setProductName_RangeSearchFrom(String from) {
		if (StringUtils.isNotEmpty(from)) {
			setProductName_RangeSearch(from, null);
		}
	}

	public void setProductName_RangeSearchTo(String to) {
		if (StringUtils.isNotEmpty(to)) {
			setProductName_RangeSearch(null, to);
		}
	}

	public void setProductName_RangeSearch(String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("product_name", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productNameQuery = convertedQuery;
		}
	}

	public void setProductName_SetRangeSearch(String cd, String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearch("product_name", cd, from, to, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productNameQuery = convertedQuery;
		}
	}

	public void setProductName_SetRangeSearchInScope(Collection<SolrSetRangeSearchBean> beanList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearchInScope("product_name", beanList, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productNameQuery = convertedQuery;
		}
	}

	public void addOrderBy_ProductName_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_product_name, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_ProductName_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_product_name, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for product_category_code (string)
    //                                                  ==========

	/**
	 * ExistsQuery( q=product_category_code:* )
	 */
	public void setProductCategoryCode_Exists() {
		this.productCategoryCodeQuery = SolrQueryBuilder.queryBuilderForExists("product_category_code");
	}

	public void setProductCategoryCode_Equal(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setProductCategoryCode_Equal(query, null);
		}
	}

	public void setProductCategoryCode_NotEqual(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setProductCategoryCode_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setProductCategoryCode_Equal(String query, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("product_category_code", query, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryCodeQuery = convertedQuery;
		}
	}

	public void setProductCategoryCode_InScope(Collection<String> queryList) {
		this.setProductCategoryCode_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setProductCategoryCode_InScope(Collection<String> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("product_category_code", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryCodeQuery = convertedQuery;
		}
	}

	public void setProductCategoryCode_NotInScope(Collection<String> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("product_category_code", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryCodeQuery = convertedQuery;
		}
	}
	
	public void setProductCategoryCode_PrefixSearch(String query) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForPrefixSearch("product_category_code", query);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryCodeQuery = convertedQuery;
		}
	}

	public void setProductCategoryCode_RangeSearchFrom(String from) {
		if (StringUtils.isNotEmpty(from)) {
			setProductCategoryCode_RangeSearch(from, null);
		}
	}

	public void setProductCategoryCode_RangeSearchTo(String to) {
		if (StringUtils.isNotEmpty(to)) {
			setProductCategoryCode_RangeSearch(null, to);
		}
	}

	public void setProductCategoryCode_RangeSearch(String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("product_category_code", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryCodeQuery = convertedQuery;
		}
	}

	public void setProductCategoryCode_SetRangeSearch(String cd, String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearch("product_category_code", cd, from, to, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryCodeQuery = convertedQuery;
		}
	}

	public void setProductCategoryCode_SetRangeSearchInScope(Collection<SolrSetRangeSearchBean> beanList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearchInScope("product_category_code", beanList, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryCodeQuery = convertedQuery;
		}
	}

	public void addOrderBy_ProductCategoryCode_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_product_category_code, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_ProductCategoryCode_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_product_category_code, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for product_category_name (string)
    //                                                  ==========

	/**
	 * ExistsQuery( q=product_category_name:* )
	 */
	public void setProductCategoryName_Exists() {
		this.productCategoryNameQuery = SolrQueryBuilder.queryBuilderForExists("product_category_name");
	}

	public void setProductCategoryName_Equal(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setProductCategoryName_Equal(query, null);
		}
	}

	public void setProductCategoryName_NotEqual(String query) {
		if (StringUtils.isNotEmpty(query)) {
			setProductCategoryName_Equal(query, SolrQueryLogicalOperator.NOT);
		}
	}

	public void setProductCategoryName_Equal(String query, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderEqualWithOperator("product_category_name", query, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryNameQuery = convertedQuery;
		}
	}

	public void setProductCategoryName_InScope(Collection<String> queryList) {
		this.setProductCategoryName_InScope(queryList, SolrQueryLogicalOperator.OR);
	}

	public void setProductCategoryName_InScope(Collection<String> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("product_category_name", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryNameQuery = convertedQuery;
		}
	}

	public void setProductCategoryName_NotInScope(Collection<String> queryList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSearchWordList("product_category_name", queryList, SolrQueryLogicalOperator.NOT);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryNameQuery = convertedQuery;
		}
	}
	
	public void setProductCategoryName_PrefixSearch(String query) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForPrefixSearch("product_category_name", query);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryNameQuery = convertedQuery;
		}
	}

	public void setProductCategoryName_RangeSearchFrom(String from) {
		if (StringUtils.isNotEmpty(from)) {
			setProductCategoryName_RangeSearch(from, null);
		}
	}

	public void setProductCategoryName_RangeSearchTo(String to) {
		if (StringUtils.isNotEmpty(to)) {
			setProductCategoryName_RangeSearch(null, to);
		}
	}

	public void setProductCategoryName_RangeSearch(String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForRangeSearch("product_category_name", from, to);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryNameQuery = convertedQuery;
		}
	}

	public void setProductCategoryName_SetRangeSearch(String cd, String from, String to) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearch("product_category_name", cd, from, to, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryNameQuery = convertedQuery;
		}
	}

	public void setProductCategoryName_SetRangeSearchInScope(Collection<SolrSetRangeSearchBean> beanList) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForSetRangeSearchInScope("product_category_name", beanList, SET_RANGE_SEARCH_PADDING_LENGTH, PADDING_STR);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.productCategoryNameQuery = convertedQuery;
		}
	}

	public void addOrderBy_ProductCategoryName_Desc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_product_category_name, ORDER.desc);
		solrSortClauseList.add(clause);
	}

	public void addOrderBy_ProductCategoryName_Asc() {
		SortClause clause = new SortClause(MemberSolrMeta.FIELD_product_category_name, ORDER.asc);
		solrSortClauseList.add(clause);
	}


    // ===========================================================
    // Query Setter for purchase_name (text_cjk)
    //                                                  ==========

	/**
	 * ExistsQuery( q=purchase_name:* )
	 */
	public void setPurchaseName_Exists() {
		this.purchaseNameQuery = SolrQueryBuilder.queryBuilderForExists("purchase_name");
	}

	public void setPurchaseName_FreewordSearch(String queryStrs, SolrQueryLogicalOperator operator) {
		String convertedQuery = SolrQueryBuilder.queryBuilderForFreewordSearch("purchase_name", queryStrs, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.purchaseNameQuery = convertedQuery;
		}
	}

	public void setPurchaseName_FreewordSearch(Collection<String> queryList, SolrQueryLogicalOperator operator) {
		String convertedQuery  = SolrQueryBuilder.queryBuilderForSearchWordList("purchase_name", queryList, operator);
		if (StringUtils.isNotEmpty(convertedQuery)) {
			this.purchaseNameQuery = convertedQuery;
		}
	}


    // =====================================================================================
    //                                                                          Query Getter
    //                                                                          ============

	@Override
	public List<String> getQueryList() {
		List<String> queryList = new ArrayList<String>();
		if (StringUtils.isNotEmpty(idQuery)) {
			queryList.add(idQuery);
		}

		if (StringUtils.isNotEmpty(memberIdQuery)) {
			queryList.add(memberIdQuery);
		}

		if (StringUtils.isNotEmpty(memberStatusCdQuery)) {
			queryList.add(memberStatusCdQuery);
		}

		if (StringUtils.isNotEmpty(memberNameQuery)) {
			queryList.add(memberNameQuery);
		}

		if (StringUtils.isNotEmpty(memberAccountQuery)) {
			queryList.add(memberAccountQuery);
		}

		if (StringUtils.isNotEmpty(birthdateQuery)) {
			queryList.add(birthdateQuery);
		}

		if (StringUtils.isNotEmpty(formalizedDatetimeQuery)) {
			queryList.add(formalizedDatetimeQuery);
		}

		if (StringUtils.isNotEmpty(purchaseIdQuery)) {
			queryList.add(purchaseIdQuery);
		}

		if (StringUtils.isNotEmpty(productIdQuery)) {
			queryList.add(productIdQuery);
		}

		if (StringUtils.isNotEmpty(productNameQuery)) {
			queryList.add(productNameQuery);
		}

		if (StringUtils.isNotEmpty(productCategoryCodeQuery)) {
			queryList.add(productCategoryCodeQuery);
		}

		if (StringUtils.isNotEmpty(productCategoryNameQuery)) {
			queryList.add(productCategoryNameQuery);
		}

		if (StringUtils.isNotEmpty(purchaseNameQuery)) {
			queryList.add(purchaseNameQuery);
		}

		if (StringUtils.isNotEmpty(orQuery)) {
			queryList.add(orQuery);
		}
		return queryList;
	}
}
