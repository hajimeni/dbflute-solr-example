package jp.bizreach.example.solr.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public abstract class AbstractSolrSpecifyBean implements SolrSpecifyBean {

    private List<String> spcifyFieldList = new ArrayList<String>();

    protected void addSpecifyField(String fieldName) {
        this.spcifyFieldList.add(fieldName);
    }

    protected void clearSpecify() {
        this.spcifyFieldList.clear();
    }

    /* (非 Javadoc)
     * @see jp.bizreach.b2.common.solr.specify.SolrSpecifyBean#getSpecifyFiledList()
     */
    @Override
    public List<String> getSpecifyFiledList() {
        return this.spcifyFieldList;
    }

    /* (非 Javadoc)
     * @see jp.bizreach.b2.common.solr.specify.SolrSpecifyBean#getSpecifyFields()
     */
    @Override
    public String[] getSpecifyFields() {
        return this.spcifyFieldList.toArray(new String[] {});
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" { ");
        sb.append(StringUtils.join(spcifyFieldList, ","));
        sb.append(" } ");

        return sb.toString();
    }
}
