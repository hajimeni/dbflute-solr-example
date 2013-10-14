package jp.bizreach.example.solr.base;

public interface SolrResultBean {

    long getQueryTime();

    void setQueryTime(long qtime);

    String getQueryString();

    void setQueryString(String query);
}
