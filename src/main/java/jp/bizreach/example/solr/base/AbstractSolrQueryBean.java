package jp.bizreach.example.solr.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery.SortClause;

public abstract class AbstractSolrQueryBean implements SolrQueryBean {

    protected String orQuery;

    /**
     * セット範囲検索のレンジは5桁でパディングされています
     *
     * 言語CD →  EN_XXXXA
     */
    protected static final int SET_RANGE_SEARCH_PADDING_LENGTH = 5;

    /**
     * セット範囲検索のレンジパディング文字列
     */
    protected static final String PADDING_STR = "0";

    /**
     * ソート条件保存用BeanList
     */
    protected List<SortClause> solrSortClauseList = new ArrayList<SortClause>();

    @Override
    public boolean isUseSort() {
        return !this.solrSortClauseList.isEmpty();
    }

    @Override
    public List<SortClause> getSolrSortClauseList() {
        return solrSortClauseList;
    }

    /**
     * クエリ文字列取得
     * @return
     */
    public String getQueryStr() {
        return SolrQueryBuilder.concatEachCondition(getQueryList());
    }

    public String getOrQueryStr() {
        return SolrQueryBuilder.concatEachCondition(getQueryList(), SolrQueryLogicalOperator.OR);
    }

    /**
     * OR検索(1Queryで一つしか設定できません)
     */
    public void orScopeQuery(AbstractSolrQueryBean orBean) {
        orQuery = "(" + orBean.getOrQueryStr() + ")";
    }

    @Override
    public String getMinimumQueryString() {
        if (getQueryList() != null && getQueryList().size() > 0) {
            return getQueryList().get(0);
        }
        return getQueryStr();
    }

    @Override
    public String getQueryString() {
        return getQueryStr();
    }

}
