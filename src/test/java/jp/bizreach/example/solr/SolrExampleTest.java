package jp.bizreach.example.solr;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import jp.bizreach.example.solr.base.SolrPagingResultBean;
import jp.bizreach.example.solr.bean.ex.MemberSolrBean;
import jp.bizreach.example.solr.client.ex.MemberSolrClient;
import jp.bizreach.example.solr.condition.ex.MemberSolrConditionBean;
import jp.bizreach.example.solr.query.ex.MemberSolrQueryBean;

import org.seasar.dbflute.helper.HandyDate;
import org.seasar.dbflute.unit.seasar.ContainerTestCase;

public class SolrExampleTest extends ContainerTestCase {

    @Resource
    private MemberSolrClient memberSolrClient;
    
    public void test_select() {
        assertNotNull(memberSolrClient);
        MemberSolrConditionBean sqb = new MemberSolrConditionBean();
        sqb.query().setMemberName_PrefixSearch("S");
        sqb.query().setBirthdate_RangeSearchFrom(new HandyDate(new Date()).addYear(-50).getDate());
        sqb.query().setProductName_PrefixSearch("Glass");
        
        SolrPagingResultBean<MemberSolrBean> selectPage = memberSolrClient.selectPage(sqb);
        
        log("RecordCount:" + selectPage.getAllRecordCount());
        List<MemberSolrBean> selectedList = selectPage.getSelectedList();
        for (MemberSolrBean bean : selectedList) {
            log(bean.getMemberName());
        }
        
    }
}
