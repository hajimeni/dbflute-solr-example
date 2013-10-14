package jp.bizreach.example.solr.base;
import java.util.Map;

public class SolrFacetResultBean implements SolrResultBean {
    /** クエリー実行時間 */
    private long queryTime;

    /** 実際に発行されたクエリー文字列 */
    private String query;

    /** ファセット結果 */
    private Map<String, Integer> facetResult;

    /**
     * クエリー実行時間を取得します。
     * @return クエリー実行時間
     */
    @Override
    public long getQueryTime() {
        return queryTime;
    }

    /**
     * クエリー実行時間を設定します。
     * @param qtime クエリー実行時間
     */
    @Override
    public void setQueryTime(long qtime) {
        this.queryTime = qtime;
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

    /**
     * ファセット結果を取得します。
     * @return ファセット結果
     */
    public Map<String, Integer> getFacetResult() {
        return facetResult;
    }

    /**
     * ファセット結果を設定します。
     * @param facetResult ファセット結果
     */
    public void setFacetResult(Map<String, Integer> facetResult) {
        this.facetResult = facetResult;
    }
}
