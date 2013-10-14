package jp.bizreach.example.solr.condition.bs;

import jp.bizreach.example.solr.base.SolrFacetQuery;
import jp.bizreach.example.solr.base.AbstractSolrConditionBean;
import jp.bizreach.example.solr.base.SolrQueryBean;
import jp.bizreach.example.solr.base.SolrQueryBuilder;
import jp.bizreach.example.solr.base.SolrSpecifyBean;
import jp.bizreach.example.solr.meta.MemberSolrMeta;
import jp.bizreach.example.solr.query.ex.MemberSolrQueryBean;
import jp.bizreach.example.solr.specify.ex.MemberSolrSpecifyBean;

/**
 * Solr検索条件生成用のConditionBeanのBaseクラス
 * string, tint, tlong, tdate, tdouble, text_ja, text_cjkのみに対応しています
 * @author FreeGen
 */
public class BsMemberSolrConditionBean extends AbstractSolrConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
	protected MemberSolrQueryBean queryBean;

	protected MemberSolrSpecifyBean specifyBean;

	public MemberSolrQueryBean query() {
		if (this.queryBean == null) {
			this.queryBean = new MemberSolrQueryBean();
		}
		return this.queryBean;
	}

	public MemberSolrSpecifyBean specify() {
		this.setSpecified(true);
		if (this.specifyBean == null) {
			this.specifyBean = new MemberSolrSpecifyBean();
		}
		return this.specifyBean;
	}

	@Override
	public String[] getAllFields() {
		return MemberSolrMeta.STORED_FIELD_NAMES;
	}

	@Override
	protected SolrQueryBean getQueryBean() {
		return this.query();
	}

	@Override
	protected SolrSpecifyBean getSpecifyBean() {
		return this.specify();
	}

	public void addFacetQuery(SolrFacetQuery<MemberSolrQueryBean> facetQuery) {
		MemberSolrQueryBean sqb = new MemberSolrQueryBean();
		facetQuery.query(sqb);
		this.addFacetQuery(sqb);
	}

	/**
	 * クエリー条件表示
	 * @return
	 */
	@Override
	public String toDisplayCondition() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n /======== Solr Condition \n");
		sb.append("  ==== [query = ");
		sb.append(SolrQueryBuilder.concatEachCondition(getQueryBean().getQueryList())).append(" ]\n");
		sb.append("  ==== [pageNumber = ").append(getPageNumer()).append(" , pageSize = ").append(getPageSize())
				.append(" ]\n");
		sb.append("  ==== [field = ").append(getSpecifyBean().toString()).append(" ]\n");
		sb.append("  ==== [facet = ").append(getFacetQueryDisplayString()).append(" ]\n");
		sb.append(" ========/");

		return sb.toString();
	}

}
