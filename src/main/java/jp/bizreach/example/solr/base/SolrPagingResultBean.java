package jp.bizreach.example.solr.base;

import org.seasar.dbflute.cbean.PagingResultBean;

/**
 * Solrの戻り用クラス
 * @author nishiyama
 *
 * @param <ENTITY>
 */
public class SolrPagingResultBean<ENTITY> extends PagingResultBean<ENTITY> implements SolrResultBean {

    private static final long serialVersionUID = 1L;

    /** クエリー実行時間 */
    private long queryTime;

    /** 実際に発行されたクエリー文字列 */
    private String query;

    /**
     * クエリー実行時間を取得します。
     * @return クエリー実行時間
     */
    public long getQueryTime() {
        return queryTime;
    }

    /**
     * クエリー実行時間を設定します。
     * @param queryTime クエリー実行時間
     */
    public void setQueryTime(long queryTime) {
        this.queryTime = queryTime;
    }

    /**
     * 実際に発行されたクエリー文字列を取得します。
     * @return 実際に発行されたクエリー文字列
     */
    @Override
    public String getQueryString() {
        return query;
    }

    /**
     * 実際に発行されたクエリー文字列を設定します。
     * @param query 実際に発行されたクエリー文字列
     */
    @Override
    public void setQueryString(String query) {
        this.query = query;
    }

}
