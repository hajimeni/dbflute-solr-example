package jp.bizreach.example.solr.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;

/**
 * Solrの検索条件生成用抽象クラス
 * @author nishiyama
 *
 */
public abstract class AbstractSolrConditionBean implements SolrConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** フィールド絞り込みフラグ */
    protected boolean specified;

    /** fq使用フラグ */
    private boolean useFilterQuery;

    protected List<SolrQueryBean> facetQueryList = new ArrayList<SolrQueryBean>();

    // ===================================================================================
    //                                                                           Paging
    //                                                                           =========
    /** デフォルトページサイズ */
    private static final Integer DEFAULT_PAGE_SIZE = 1000;

    /**
     * ページサイズ
     */
    protected Integer pageSize;

    /**
     * ページ
     */
    protected Integer pageNumber;

    public void paging(Integer pageSize, Integer pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public Integer getPageNumer() {
        if (pageNumber != null) {
            return pageNumber;
        }
        return 1;
    }

    public Integer getPageStart() {
        return getPageSize() * (getPageNumer() - 1);
    }

    public Integer getPageSize() {
        if (pageSize != null) {
            return pageSize;
        }
        return DEFAULT_PAGE_SIZE;
    }

    // ===================================================================================
    //                                                                           Abstract
    //                                                                           =========
    protected abstract SolrQueryBean getQueryBean();

    protected abstract SolrSpecifyBean getSpecifyBean();

    public abstract String[] getAllFields();

    public abstract String toDisplayCondition();

    // ===================================================================================
    //                                                                           Query Info
    //                                                                           =========
    public boolean isUseSort() {
        return this.getQueryBean().isUseSort();
    }

    public List<SortClause> getSolrSortClauseList() {
        return this.getQueryBean().getSolrSortClauseList();
    }

    public String getMinimumQuery() {
        return getQueryBean().getMinimumQueryString();
    }

    public String[] getQueryArray() {
        return getQueryBean().getQueryList().toArray(new String[] {});
    }

    public String getQueryString() {
        return getQueryBean().getQueryString();
    }

    // ===================================================================================
    //                                                                           Specify Info
    //                                                                           =========
    public String[] getSpecifyFields() {
        return this.getSpecifyBean().getSpecifyFields();
    }

    // ===================================================================================
    //                                                                           Info
    //                                                                           =========

    public SolrQuery buildSolrQuery() {
        SolrQuery query = new SolrQuery();

        if (this.isSpecified()) {
            query.setFields(this.getSpecifyFields());
        } else {
            query.setFields(this.getAllFields());
        }
        if (this.isUseFilterQuery()) {
            query.setQuery(this.getMinimumQuery());
            query.setFilterQueries(this.getQueryArray());
        } else {
            query.setQuery(this.getQueryString());
        }
        if (this.isUseSort()) {
            for (SortClause sortClause : this.getSolrSortClauseList()) {
                query.addSort(sortClause);
            }
        }
        for (SolrQueryBean queryBean : this.getFacetQueryList()) {
            query.addFacetQuery(queryBean.getQueryString());
        }

        query.setStart(this.getPageStart());
        query.setRows(this.getPageSize());

        return query;
    }

    public String getFacetQueryDisplayString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" { ");
        for (SolrQueryBean qb : facetQueryList) {
            sb.append(" fq = ").append(qb.getQueryString()).append(",");
        }
        sb.append(" } ");

        return sb.toString();
    }

    public List<SolrQueryBean> getFacetQueryList() {
        return facetQueryList;
    }

    @Override
    public String toString() {
        return toDisplayCondition();
    }

    public void addFacetQuery(SolrQueryBean queryBean) {
        this.facetQueryList.add(queryBean);
    }

    // ===================================================================================
    //                                                                           Accessor
    //                                                                           =========
    protected void setSpecified(boolean specified) {
        this.specified = specified;
    }

    public boolean isSpecified() {
        return specified;
    }

    public boolean isUseFilterQuery() {
        return useFilterQuery;
    }

    public void setUseFilterQuery(boolean useFilterQuery) {
        this.useFilterQuery = useFilterQuery;
    }

    public boolean isFacetQuery() {
        return this.facetQueryList != null && this.facetQueryList.size() > 0;
    }

}
