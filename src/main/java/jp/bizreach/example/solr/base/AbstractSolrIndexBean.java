package jp.bizreach.example.solr.base;

import java.util.ArrayList;
import java.util.List;

public class AbstractSolrIndexBean {

    protected <ELEMENT> List<ELEMENT> newMultiValuedList() {
        return new ArrayList<ELEMENT>();
    }

}
