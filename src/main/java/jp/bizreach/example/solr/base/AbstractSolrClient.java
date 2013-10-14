package jp.bizreach.example.solr.base;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.LBHttpSolrServer;

public abstract class AbstractSolrClient {

    private String[] selectServerUrls;

    private String masterServerUrl;

    private LBHttpSolrServer selectLbSolrServer;

    private HttpSolrServer masterSolrServer;

    public void initialize() {
        createSelectSolrServer();
        createMasterSolrServer();
    }

    /**
     * MasterSolrServer生成
     */
    private void createMasterSolrServer() {
        masterSolrServer = new HttpSolrServer(masterServerUrl);
        masterSolrServer.setSoTimeout(60000); // socket read timeout
        masterSolrServer.setConnectionTimeout(60000);
        masterSolrServer.setDefaultMaxConnectionsPerHost(100);
        masterSolrServer.setMaxTotalConnections(100);
        masterSolrServer.setFollowRedirects(false);
    }

    /**
     * Select用SlaveServer生成
     */
    private void createSelectSolrServer() {
        try {
            if (selectServerUrls == null || selectServerUrls.length == 0) {
                selectServerUrls = new String[]{masterServerUrl};
            }
            selectLbSolrServer = new LBHttpSolrServer(selectServerUrls);
            selectLbSolrServer.setSoTimeout(10000); // socket read timeout
            selectLbSolrServer.setConnectionTimeout(10000);
            selectLbSolrServer.setAliveCheckInterval(60 * 1000); //time in milliseconds
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Solrアクセス用LBサーバー作成時に失敗しました", e);
        }
    }

    /**
     * SolrへのOptimize
     */
    public void optimize() {
        HttpSolrServer server = getMasterSolrServer();
        try {
            server.optimize(false, false); // 処理完了を待たない
        } catch (SolrServerException e) {
            throw new IllegalStateException("Solr Optimize にエラーが発生しました", e);
        } catch (IOException e) {
            throw new IllegalStateException("Solr Optimize にエラーが発生しました", e);
        }
    }

    /**
     * selectServerUrlsを取得します。
     * @return selectServerUrls
     */
    public String[] getSelectServerUrls() {
        return selectServerUrls;
    }

    /**
     * selectServerUrlsを設定します。
     * @param selectServerUrls selectServerUrls
     */
    public void setSelectServerUrls(String... selectServerUrls) {
        this.selectServerUrls = selectServerUrls;
    }

    /**
     * masterServerUrlを取得します。
     * @return masterServerUrl
     */
    public String getMasterServerUrl() {
        return masterServerUrl;
    }

    /**
     * masterServerUrlを設定します。
     * @param masterServerUrl masterServerUrl
     */
    public void setMasterServerUrl(String masterServerUrl) {
        this.masterServerUrl = masterServerUrl;
    }

    /**
     * selectLbSolrServerを取得します。
     * @return selectLbSolrServer
     */
    public LBHttpSolrServer getSelectSolrServer() {
        return selectLbSolrServer;
    }

    /**
     * masterSolrServerを取得します。
     * @return masterSolrServer
     */
    public HttpSolrServer getMasterSolrServer() {
        return masterSolrServer;
    }

}
