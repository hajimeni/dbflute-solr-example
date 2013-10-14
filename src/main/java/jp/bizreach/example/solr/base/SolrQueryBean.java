package jp.bizreach.example.solr.base;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery.SortClause;

public interface SolrQueryBean {

    String getQueryString();

    List<String> getQueryList();

    List<SortClause> getSolrSortClauseList();

    public abstract String getMinimumQueryString();

    public abstract boolean isUseSort();

}
