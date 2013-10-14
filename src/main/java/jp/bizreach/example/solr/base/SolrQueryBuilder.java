package jp.bizreach.example.solr.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * Solrクエリ文字列生成クラス<br />
 *
 * qフィールドに投げる検索クエリ文字列を生成します
 *
 * @author nishiyama
 *
 */
public class SolrQueryBuilder {

    private static final String VALUE_SEPARATOR = "_";

    private static final Pattern BOOLEAN_PHRASE_PART = Pattern.compile("\"(.+?)\"");

    /**
     * セット範囲検索のワイルドカード
     *
     */
    private static final String SET_RANGE_SEARCH_RIGHT_WILDCARD = "?????";

    /**
     * セット範囲検索のワイルドカード
     *
     */
    private static final String SET_RANGE_SEARCH_LEFT_WILDCARD = "\\*";

    /**
     * グループにラップします
     * @param query
     * @return
     */
    public static String wrapGroupQuery(String query) {
        return "(" + query + ")";
    }

    /**
     * ここの条件をつなげます
     * @param queryList
     * @return
     */
    public static String concatEachCondition(List<String> queryList) {
        return concatEachCondition(queryList, SolrQueryLogicalOperator.AND);
    }

    public static String concatEachCondition(List<String> queryList, SolrQueryLogicalOperator operator) {
        StringBuilder queryBuilder = new StringBuilder();
        if (isNotEmptyStrict(queryList)) {
            for (int i = 0; i < queryList.size(); i++) {
                if (i != 0) {
                    queryBuilder.append(" ");
                    queryBuilder.append(operator.name());
                    queryBuilder.append(" ");
                }
                queryBuilder.append(queryList.get(i));
            }
        } else {
            //何もクエリがない場合
            queryBuilder.append("*:*");
        }
        return queryBuilder.toString();
    }

    /**
     * フリーワードのスプリットして返却します
     * @param freewordSet
     * @return
     */
    public static String[] splitFreeWords(String freewordSet) {
        if (StringUtils.isBlank(freewordSet)) {
            throw new IllegalArgumentException();
        }
        String strFreewords = normalizeFreeword(freewordSet);
        return strFreewords.split(" ");
    }

    /**
     * フリーワードの正規化
     * @param freewordSet
     * @return
     */
    public static String normalizeFreeword(String freewordSet) {
        if (freewordSet == null) {
            throw new IllegalArgumentException();
        }
        return freewordSet.replaceAll("　", " ").replaceAll(" +", " ").replaceAll("^ +", "").replaceAll(" +$", "")
                .trim();
    }

    /**
     * 論理演算子してのEqual検索用
     *
     * @param solrFieldName
     * @param query
     * @param operator
     * @return
     */
    public static String queryBuilderEqualWithOperator(String solrFieldName, String query,
            SolrQueryLogicalOperator operator) {
        StringBuilder queryBuilder = new StringBuilder();
        if (StringUtils.isNotEmpty(query)) {
            if (operator != null) {
                queryBuilder.append(operator.name());
                queryBuilder.append(" ");
            }
            queryBuilder.append(solrFieldName);
            queryBuilder.append(":");
            queryBuilder.append(query);
        }
        return queryBuilder.toString();
    }
    
    public static String queryBuilderForPrefixSearch(String solrFieldName, String query) {
        if (solrFieldName == null) {
            return StringUtils.EMPTY;
        }
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(solrFieldName);
        queryBuilder.append(":");
        queryBuilder.append(query).append("*");
        
        return queryBuilder.toString();
    }
    
    public static String queryBuilderForSuffixSearch(String solrFieldName, String query) {
        if (solrFieldName == null) {
            return StringUtils.EMPTY;
        }
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(solrFieldName);
        queryBuilder.append(":");
        queryBuilder.append("*").append(query);
        
        return queryBuilder.toString();
    }

    public static String queryBuilderForContainsSearch(String solrFieldName, String query) {
        if (solrFieldName == null) {
            return StringUtils.EMPTY;
        }
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(solrFieldName);
        queryBuilder.append(":");
        queryBuilder.append("*").append(query).append("*");
        
        return queryBuilder.toString();
    }

    /**
     * フィールドに値が存在するかどうか判定するクエリーを作成します
     * @param solrFieldName
     * @return
     */
    public static String queryBuilderForExists(String solrFieldName) {
        if (solrFieldName == null) {
            return StringUtils.EMPTY;
        }
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(solrFieldName);
        queryBuilder.append(":");
        queryBuilder.append("*");

        return queryBuilder.toString();
    }

    /**
     * 範囲検索クエリ構築
     *
     * @param solrFieldName
     * @param from
     * @param to
     * @return
     */
    public static String queryBuilderForRangeSearch(String solrFieldName, Date from, Date to) {
        String toStr = null;
        String fromStr = null;
        if (from == null) {
            fromStr = "*";
        } else {
            fromStr = formatYMDHmsForSolrByJST(from);
        }

        if (to == null) {
            toStr = "*";
        } else {
            toStr = formatYMDHmsForSolrByJST(to);
        }
        return queryBuilderForRangeSearch(solrFieldName, fromStr, toStr);
    }

    /**
     * 範囲検索クエリ構築
     *
     * @param solrFieldName
     * @param from
     * @param to
     * @return
     */
    public static String queryBuilderForRangeSearch(String solrFieldName, Long from, Long to) {
        String toStr = null;
        String fromStr = null;
        if (from == null) {
            fromStr = "*";
        } else {
            fromStr = from.toString();
        }

        if (to == null) {
            toStr = "*";
        } else {
            toStr = to.toString();
        }
        return queryBuilderForRangeSearch(solrFieldName, fromStr, toStr);
    }

    /**
     * 範囲検索クエリ構築
     *
     * @param solrFieldName
     * @param from
     * @param to
     * @return
     */
    public static String queryBuilderForRangeSearch(String solrFieldName, Integer from, Integer to) {
        String toStr = null;
        String fromStr = null;
        if (from == null) {
            fromStr = "*";
        } else {
            fromStr = from.toString();
        }

        if (to == null) {
            toStr = "*";
        } else {
            toStr = to.toString();
        }
        return queryBuilderForRangeSearch(solrFieldName, fromStr, toStr);
    }

    /**
     * 範囲検索クエリ構築
     *
     * @param solrFieldName
     * @param from
     * @param to
     * @return
     */
    public static String queryBuilderForRangeSearch(String solrFieldName, String from, String to) {
        if (StringUtils.isEmpty(from)) {
            from = "*";
        }
        if (StringUtils.isEmpty(to)) {
            to = "*";
        }
        return solrFieldName + ":[" + from + " TO " + to + "]";
    }

    /**
     * セット範囲検索
     * @param solrFieldName
     * @param cd
     * @param from
     * @param to
     * @return
     */
    public static String queryBuilderForSetRangeSearch(String solrFieldName, String cd, String from, String to,
            int paddingLength, String paddingStr) {
        if (StringUtils.isNotEmpty(cd)) {
            if (StringUtils.isEmpty(from)) {
                from = SET_RANGE_SEARCH_LEFT_WILDCARD;
            }
            if (StringUtils.isEmpty(to)) {
                to = SET_RANGE_SEARCH_RIGHT_WILDCARD;
            }

            if (!from.contains("*")) {
                from = StringUtils.leftPad(from, paddingLength, paddingStr);
            }

            if (!to.contains("?")) {
                to = StringUtils.leftPad(to, paddingLength, paddingStr);
            }
            return solrFieldName + ":[" + cd + VALUE_SEPARATOR + from + " TO " + cd + VALUE_SEPARATOR + to + "]";
        }
        return "";
    }

    /**
     * セット範囲検索 InScope
     * @param solrFieldName
     * @param solrSetRangeSearchBeanList
     * @param paddingLength
     * @param paddingStr
     * @return
     */
    public static String queryBuilderForSetRangeSearchInScope(String solrFieldName,
            Collection<SolrSetRangeSearchBean> beanList, int paddingLength, String paddingStr) {
        StringBuilder queryBuilder = new StringBuilder();
        if (beanList != null) {
            for (SolrSetRangeSearchBean bean : beanList) {
                if (queryBuilder.length() > 0) {
                    queryBuilder.append(" ");
                    queryBuilder.append(SolrQueryLogicalOperator.OR.name());
                    queryBuilder.append(" ");
                }
                queryBuilder.append(queryBuilderForSetRangeSearch(solrFieldName, bean.getCd(), bean.getFrom(),
                        bean.getTo(), paddingLength, paddingStr));
            }

            if (queryBuilder.length() > 0) {
                queryBuilder.insert(0, "(");
                queryBuilder.append(")");
            }
        }
        return queryBuilder.toString();

    }

    public static String queryBuilderForSetRangeSearchAndScope(String solrFieldName,
            Collection<SolrSetRangeSearchBean> beanList, int paddingLength, String paddingStr) {
        StringBuilder queryBuilder = new StringBuilder();
        if (beanList != null) {
            for (SolrSetRangeSearchBean bean : beanList) {
                if (queryBuilder.length() > 0) {
                    queryBuilder.append(" ");
                    queryBuilder.append(SolrQueryLogicalOperator.AND.name());
                    queryBuilder.append(" ");
                }
                queryBuilder.append(queryBuilderForSetRangeSearch(solrFieldName, bean.getCd(), bean.getFrom(),
                        bean.getTo(), paddingLength, paddingStr));
            }

            if (queryBuilder.length() > 0) {
                queryBuilder.insert(0, "(");
                queryBuilder.append(")");
            }
        }
        return queryBuilder.toString();

    }

    /**
     * フリーワード検索クエリ構築
     * ダブルコーテーションによるフレーズ検索対応
     *
     * @param solrFieldName
     * @param queryStrs
     * @param operator
     * @return
     */
    public static String queryBuilderForFreewordSearch(String solrFieldName, String queryStrs,
            SolrQueryLogicalOperator operator) {
        if (StringUtils.isNotBlank(queryStrs)) {
            List<String> queryList = createSearchWordList(queryStrs);
            return queryBuilderForSearchWordList(solrFieldName, queryList, operator);
        }
        return "";
    }

    public static String queryBuilderForFreewordSearchSupportIgnore(String solrFieldName, String queryStrs,
            SolrQueryLogicalOperator operator) {
        if (StringUtils.isNotBlank(queryStrs)) {
            List<String> queryList = createSearchWordList(queryStrs);
            if (operator == SolrQueryLogicalOperator.AND) {
                List<String> plusQuerys = new ArrayList<String>();
                List<String> minusQuerys = new ArrayList<String>();
                for (String query : queryList) {
                    if (query.startsWith("\"-") && query.endsWith("\"") && query.length() >= 4) {
                        minusQuerys.add("\"" + query.substring(2, query.length() - 1) + "\"");
                    } else {
                        plusQuerys.add(query);
                    }
                }

                if (minusQuerys.size() > 0 && plusQuerys.size() > 0) {
                    // プラス検索とマイナス検索があった場合、NOT検索を発動させる
                    return queryBuilderForSearchWordListAndNot(solrFieldName, plusQuerys, minusQuerys);
                }
            }

            return queryBuilderForSearchWordList(solrFieldName, queryList, operator);
        }
        return "";
    }

    /**
     * 検索ワードリストクエリ構築
     *
     * @param solrFieldName
     * @param queryList
     * @param operator
     * @return
     */
    public static String queryBuilderForSearchLongList(String solrFieldName, Collection<Long> queryList,
            SolrQueryLogicalOperator operator) {
        List<String> queryStrList = new ArrayList<String>();
        if (isNotEmptyStrict(queryList)) {
            for (Long num : queryList) {
                queryStrList.add(num.toString());
            }
        }
        return queryBuilderForSearchWordList(solrFieldName, queryStrList, operator);
    }

    /**
     * 検索ワードリストクエリ構築
     *
     * @param solrFieldName
     * @param queryList
     * @param operator
     * @return
     */
    public static String queryBuilderForSearchIntegerList(String solrFieldName, Collection<Integer> queryList,
            SolrQueryLogicalOperator operator) {
        List<String> queryStrList = new ArrayList<String>();
        if (isNotEmptyStrict(queryList)) {
            for (Integer integer : queryList) {
                queryStrList.add(integer.toString());
            }
        }
        return queryBuilderForSearchWordList(solrFieldName, queryStrList, operator);
    }

    /**
     * 検索ワードリストクエリ構築
     * 例 NOT： candidate_id: Not (1000 OR 10002 OR 10004)
     * 例 OR： candidate_id: (1000 OR 10002 OR 10004)
     * 例 AND： candidate_id: (1000 AND 10002 AND 10004)
     *
     * @param solrFieldName
     * @param queryList
     * @param operator
     * @return
     */
    public static String queryBuilderForSearchWordList(String solrFieldName, Collection<String> queryList,
            SolrQueryLogicalOperator operator) {
        StringBuilder queryBuilder = new StringBuilder();
        SolrQueryLogicalOperator partOperator = operator;
        if (isNotEmptyStrict(queryList)) {
            if (SolrQueryLogicalOperator.NOT.equals(operator)) {
                queryBuilder.append(SolrQueryLogicalOperator.NOT.name());
                queryBuilder.append(" ");
                partOperator = SolrQueryLogicalOperator.OR;
            }
            queryBuilder.append(solrFieldName);
            queryBuilder.append(": ");
            queryBuilder.append(queryBuilderForSearchWordListPart(queryList, partOperator));
        }
        return queryBuilder.toString();
    }

    public static String queryBuilderForSearchWordListAndNot(String solrFieldName, Collection<String> andQueryList,
            Collection<String> notQueryList) {
        StringBuilder queryBuilder = new StringBuilder();
        if (isNotEmptyStrict(andQueryList) && isNotEmptyStrict(notQueryList)) {
            queryBuilder.append(solrFieldName);
            queryBuilder.append(": ");
            queryBuilder.append(queryBuilderForSearchWordListPartRaw(andQueryList, SolrQueryLogicalOperator.AND));
            queryBuilder.append(" NOT");
            queryBuilder.append(queryBuilderForSearchWordListPartRaw(notQueryList, SolrQueryLogicalOperator.NOT));
        }
        return queryBuilder.toString();
    }

    /**
     * 検索Word Listクエリの構築
     * 例：(1000 OR 10002 OR 10004)
     *
     * @param queryList
     * @param operator
     * @return
     */
    private static String queryBuilderForSearchWordListPart(Collection<String> queryList,
            SolrQueryLogicalOperator operator) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("(");
        boolean isNotfirst = false;
        for (String query : queryList) {
            if (StringUtils.isNotEmpty(query)) {
                if (isNotfirst) {
                    queryBuilder.append(operator.name());
                }
                queryBuilder.append(" ");
                queryBuilder.append(query);
                queryBuilder.append(" ");
                isNotfirst = true;
            }
        }
        queryBuilder.append(")");
        return queryBuilder.toString();
    }

    private static String queryBuilderForSearchWordListPartRaw(Collection<String> queryList,
            SolrQueryLogicalOperator operator) {
        StringBuilder queryBuilder = new StringBuilder();
        boolean isNotfirst = false;
        for (String query : queryList) {
            if (StringUtils.isNotEmpty(query)) {
                if (isNotfirst) {
                    queryBuilder.append(operator.name());
                }
                queryBuilder.append(" ");
                queryBuilder.append(query);
                queryBuilder.append(" ");
                isNotfirst = true;
            }
        }
        return queryBuilder.toString();
    }

    /**
     * 検索文字列作成
     *
     * 検索窓に入れたワードを検索フレーズ、単語単位のリストにします
     * フレーズ検索（""ダブルコーテーション）にも対応しています
     *
     * "fund manager" ゴールドマンサックス ⇒ "fund manager", "ゴールドマンサックス"
     *
     * @param str
     * @return
     */
    public static List<String> createSearchWordList(final String str) {
        if (StringUtils.isBlank(str)) {
            throw new IllegalArgumentException("空白文字列、又はnullが入力されました");
        }
        String normalizedStr = normalizeFreeword(str);
        List<String> excludedPhraseList = getExcludedPhraseList(normalizedStr);
        List<String> phraseList = getPhraseList(normalizedStr);
        List<String> arrayList = new ArrayList<String>();
        if (isNotEmptyStrict(excludedPhraseList)) {
            arrayList.addAll(excludedPhraseList);
        }
        if (isNotEmptyStrict(phraseList)) {
            arrayList.addAll(phraseList);
        }
        return arrayList;
    }

    /**
     * 連結した値を持つフィールドの検索値を生成する<br />
     * <pre>
     * 例：求職者が、企業1をブロックしいているラベル
     *    BLK_CMP_1
     * </pre>
     * @param args
     * @return
     */
    public static String createCombinationQueryValue(Object... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("nullもしくは空の配列が入力されました");
        }
        return StringUtils.join(args, VALUE_SEPARATOR);
    }

    /**
     * 2値を連結し、後方値をlpadした値を持つフィールドの検索値を生成する<br />
     * <pre>
     * 例：求職者クラスの下限年収
     *  　　RG_01000
     * </pre>
     * @param value1 前方値
     * @param value2 後方値
     * @param lpadLength lpadの桁数
     * @param lpadChar lpad実行で挿入する文字列
     * @return
     */
    public static String createDoubleQueryValue(String value1, String value2, int lpadLength, Character lpadChar) {
        if (value1 == null || value2 == null) {
            throw new IllegalArgumentException("valueにnullが入力されました");
        }
        Character c = lpadChar == null ? '0' : lpadChar;

        return value1 + VALUE_SEPARATOR + StringUtils.leftPad(value2, lpadLength, c.toString());
    }

    /**
     * フレーズ以外の部分をリスト化して取得します
     * @param str
     * @return
     */
    public static List<String> getExcludedPhraseList(String str) {
        Matcher phrasePartMatcher = BOOLEAN_PHRASE_PART.matcher(str);
        String exceptPhraseWord = phrasePartMatcher.replaceAll("").trim();
        exceptPhraseWord = exceptPhraseWord.replaceAll("\"", "");
        exceptPhraseWord = normalizeFreeword(exceptPhraseWord);
        String[] splitedArray = exceptPhraseWord.split(" ");
        List<String> excludedPhraseList = new ArrayList<String>();
        for (int i = 0; i < splitedArray.length; i++) {
            excludedPhraseList.add("\"" + splitedArray[i] + "\"");
        }
        return excludedPhraseList;
    }

    /**
     * フレーズ部分をリスト化して取得します
     * @param str
     * @return
     */
    public static List<String> getPhraseList(String str) {
        Matcher phrasePartMatcher = BOOLEAN_PHRASE_PART.matcher(str);
        List<String> phraseList = new ArrayList<String>();
        while (phrasePartMatcher.find()) {
            String phraseStr = phrasePartMatcher.group();
            phraseList.add("\"" + phraseStr.replaceAll("\"", "").trim() + "\"");
        }
        return phraseList;
    }

    /**
     * 厳しいListのチェック
     * @param collection
     * @return
     */
    private static <E> boolean isNotEmptyStrict(Collection<E> collection) {
        return !isEmptyStrict(collection);
    }

    /**
     * 厳しいListのチェック
     * @param collection
     * @return
     */
    private static <E> boolean isEmptyStrict(Collection<E> collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }

        // String型のListは内容の空チェックを行い、その他の場合はnullチェックを行います。
        if (collection instanceof List<?>) {
            if (((List<?>) collection).get(0) instanceof String) {
                for (E s : collection) {
                    if (StringUtils.isNotEmpty(String.class.cast(s))) {
                        return false;
                    }
                }
                return true;
            } else {
                for (E s : collection) {
                    if (s != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    /**
     * Solr向けDate型の検索文字列フォーマットに変換します。DateがJSTの場合に使います
     *
     * @param date
     * @return
     */
    public static String formatYMDHmsForSolrByJST(Date date) {
        return formatYMDHmsForSolr(date, -9);
    }

    /**
     * Solr向けのUTC形式でDate型の検索文字列フォーマットに変換します
     *
     * @param date 変換したい文字列
     * @param timeZoneDiff タイムゾーンごとにUTCにする為の時差(例：JSTなら-9でUTCになるので-9をいれる)
     * @return
     */
    public static String formatYMDHmsForSolr(Date date, int timeZoneDiff) {
        return DateFormatUtils.format(DateUtils.addHours(date, timeZoneDiff), "yyyy-MM-dd'T'HH:mm:ss.000'Z'");
    }

}
