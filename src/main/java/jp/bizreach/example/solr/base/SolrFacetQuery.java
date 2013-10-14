package jp.bizreach.example.solr.base;

public interface SolrFacetQuery<SQB extends SolrQueryBean> {

    void query(SQB sqb);

}
