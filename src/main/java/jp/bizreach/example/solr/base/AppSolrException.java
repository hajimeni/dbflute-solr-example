package jp.bizreach.example.solr.base;

public class AppSolrException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AppSolrException() {
        super();
    }

    public AppSolrException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public AppSolrException(String arg0) {
        super(arg0);
    }

    public AppSolrException(Throwable arg0) {
        super(arg0);
    }

}
