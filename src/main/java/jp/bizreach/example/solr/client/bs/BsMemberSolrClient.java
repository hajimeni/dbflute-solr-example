package jp.bizreach.example.solr.client.bs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jp.bizreach.example.solr.base.AppSolrException;
import jp.bizreach.example.solr.base.SolrFacetResultBean;
import jp.bizreach.example.solr.base.SolrPagingResultBean;
import jp.bizreach.example.solr.base.AbstractSolrClient;
import jp.bizreach.example.solr.bean.ex.MemberSolrBean;
import jp.bizreach.example.solr.condition.ex.MemberSolrConditionBean;
import jp.bizreach.example.solr.index.ex.MemberSolrIndexBean;
import jp.bizreach.example.solr.query.ex.MemberSolrQueryBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.LBHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.seasar.dbflute.cbean.PagingResultBean;

/**
 * Solr検索ClientのBaseクラス
 * string, tint, tlong, tdate, tdouble, text_ja, text_cjkのみに対応しています
 * @author FreeGen
 */
public class BsMemberSolrClient extends AbstractSolrClient {

	Log logger = LogFactory.getLog(BsMemberSolrClient.class);

	/**
	 * Solrへの件数取得クエリ発行
	 */
	public int selectCount(MemberSolrConditionBean conditionBean) {
		if (conditionBean == null) {
			throw new IllegalArgumentException("conditionBeanがnullです");
		}

		SolrQuery query = conditionBean.buildSolrQuery();

		query.setStart(0);
		query.setRows(0);

		if (logger.isDebugEnabled()) {
			logger.debug(conditionBean);
		}

		SolrServer solrServer = getSelectSolrServer();
		int numFound;
		try {
			QueryResponse rsp = solrServer.query(query, METHOD.POST);
			numFound = (int) rsp.getResults().getNumFound();
		} catch (SolrServerException e) {
			throw new AppSolrException("Solrアクセス時（Select）にエラーが発生しました", e);
		}

		return numFound;
	}

	/**
	 * Solrへの検索クエリ発行
	 * @param conditionBean
	 * @return
	 */
	public SolrPagingResultBean<MemberSolrBean> selectPage(MemberSolrConditionBean conditionBean) {
		if (conditionBean == null) {
			throw new IllegalArgumentException("conditionBeanがnullです");
		}

		SolrQuery query = conditionBean.buildSolrQuery();

		if (logger.isDebugEnabled()) {
			logger.debug(conditionBean);
		}

		SolrServer solrServer = getSelectSolrServer();

		SolrPagingResultBean<MemberSolrBean> pagingResult = new SolrPagingResultBean<MemberSolrBean>();
		try {
			QueryResponse rsp = solrServer.query(query, METHOD.POST);
			List<MemberSolrBean> selectList = rsp.getBeans(MemberSolrBean.class);
			pagingResult.setSelectedList(selectList);
			pagingResult.setPageRangeSize(5);
			pagingResult.setPageSize(conditionBean.getPageSize());
			pagingResult.setCurrentPageNumber(conditionBean.getPageNumer());
			long numFound = rsp.getResults().getNumFound();
			pagingResult.setAllRecordCount((int) numFound);
			pagingResult.setQueryTime(rsp.getQTime());
			pagingResult.setQueryString(query.toString());
		} catch (SolrServerException e) {
			throw new AppSolrException("Solrアクセス時（Select）にエラーが発生しました", e);
		}

		return pagingResult;
	}

	/**
	 * Solrへのファセットクエリー発行<br />
	 * facet.queryにクエリーを複数指定します。<br />
	 *
	 * @param conditionBean Query文字列をKeyにしたMapです。QueryBeanのgetQueryString()を利用して比較してください。
	 */
	public SolrFacetResultBean selectFacetQuery(MemberSolrConditionBean conditionBean) {
		if (conditionBean == null) {
			throw new IllegalArgumentException("conditionBeanがnullです");
		}

		if (!conditionBean.isFacetQuery()) {
			throw new IllegalArgumentException("conditionBeanにFacetQueryが設定されていません");
		}

		SolrQuery query = conditionBean.buildSolrQuery();

		query.setStart(0);
		query.setRows(0);

		if (logger.isDebugEnabled()) {
			logger.debug(conditionBean);
		}

		SolrFacetResultBean resultBean = new SolrFacetResultBean();

		SolrServer solrServer = getSelectSolrServer();
		try {
			QueryResponse rsp = solrServer.query(query, METHOD.POST);
			resultBean.setFacetResult(rsp.getFacetQuery());
			resultBean.setQueryString(query.toString());
			resultBean.setQueryTime(rsp.getQTime());
			return resultBean;
		} catch (SolrServerException e) {
			throw new AppSolrException("Solrアクセス時（Select）にエラーが発生しました", e);
		}
	}

	public <RESULT_BEAN> SolrPagingResultBean<RESULT_BEAN> selectPage(MemberSolrConditionBean conditionBean,
			Class<RESULT_BEAN> clazz) {
		if (conditionBean == null) {
			throw new IllegalArgumentException("conditionBeanがnullです");
		}

		SolrQuery query = conditionBean.buildSolrQuery();

		SolrServer solrServer = getSelectSolrServer();

		if (logger.isDebugEnabled()) {
			logger.debug(conditionBean);
		}
		SolrPagingResultBean<RESULT_BEAN> pagingResult = new SolrPagingResultBean<RESULT_BEAN>();
		try {
			QueryResponse rsp = solrServer.query(query, METHOD.POST);
			List<RESULT_BEAN> selectList = rsp.getBeans(clazz);

			pagingResult.setSelectedList(selectList);
			pagingResult.setPageRangeSize(5);
			pagingResult.setPageSize(conditionBean.getPageSize());
			pagingResult.setCurrentPageNumber(conditionBean.getPageNumer());
			long numFound = rsp.getResults().getNumFound();
			pagingResult.setAllRecordCount((int) numFound);
			pagingResult.setQueryTime(rsp.getQTime());
			pagingResult.setQueryString(query.toString());
		} catch (SolrServerException e) {
			throw new AppSolrException("Solrアクセス時（Select）にエラーが発生しました", e);
		}

		return pagingResult;
	}

	/**
	 * すべてのIndexを削除します。
	 */
	public void deleteAllIndex() {
		HttpSolrServer solrServer = getMasterSolrServer();
		try {
			solrServer.deleteByQuery("*:*");
		} catch (SolrServerException e) {
			throw new AppSolrException("SolrIndex削除(" + "*:*" + ")時にエラーが発生しました。", e);
		} catch (IOException e) {
			throw new AppSolrException("SolrIndex削除(" + "*:*" + ")時にエラーが発生しました。", e);
		}
	}

	public void deleteById(Object id) {
		HttpSolrServer solrServer = getMasterSolrServer();
		try {
			solrServer.deleteByQuery("id:" + id);
		} catch (SolrServerException e) {
			throw new AppSolrException("SolrIndex削除(" + "id:" + id + ")時にエラーが発生しました。", e);
		} catch (IOException e) {
			throw new AppSolrException("SolrIndex削除(" + "id:" + id + ")時にエラーが発生しました。", e);
		}
	}

	public void addSolrIndexBeans(List<MemberSolrIndexBean> beans) {
		if (beans == null || beans.isEmpty()) {
			return;
		}
		HttpSolrServer solrServer = getMasterSolrServer();
		try {
			solrServer.addBeans(beans);
		} catch (SolrServerException e) {
			throw new AppSolrException("SolrIndex登録時にエラーが発生しました。", e);
		} catch (IOException e) {
			throw new AppSolrException("SolrIndex登録時にエラーが発生しました。", e);
		}
	}

	public void commit() {
		HttpSolrServer solrServer = getMasterSolrServer();
		try {
			solrServer.commit();
		} catch (SolrServerException e) {
			throw new AppSolrException("SolrIndex Commit時にエラーが発生しました。", e);
		} catch (IOException e) {
			throw new AppSolrException("SolrIndex Commit時にエラーが発生しました。", e);
		}
	}

    // ===================================================================================
    //                                                            Gettter of SolrFieldName
    //                                                            ========================
	public String[] getSolrFieldNames() {
		String[] fieldNames = {
				"id"
, "member_id"
, "member_status_cd"
, "member_name"
, "member_account"
, "birthdate"
, "purchase_id"
, "product_id"
, "product_name"
, "product_category_code"
, "product_category_name"
		};
		return fieldNames;
	}

}
