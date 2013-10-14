package jp.bizreach.example.solr.base;

public class SolrSetRangeSearchBean {

    private String cd;
    private String from;
    private String to;

    public SolrSetRangeSearchBean(String cd, String from, String to) {
        this.cd = cd;
        this.from = from;
        this.to = to;
    }

    /**
     * cdを取得します。
     * @return cd
     */
    public String getCd() {
        return cd;
    }

    /**
     * fromを取得します。
     * @return from
     */
    public String getFrom() {
        return from;
    }

    /**
     * toを取得します。
     * @return to
     */
    public String getTo() {
        return to;
    }

}
