package jp.bizreach.example.solr.bean.bs;

import java.io.Serializable;
import java.util.Date;
import jp.bizreach.example.solr.base.AbstractSolrBean;
import org.apache.solr.client.solrj.beans.Field;

/**
 * Solr検索結果保存用BeanのBaseクラス
 * string, tint, tlong, tdate, tdouble, text_ja, text_cjkのみに対応しています
 * @author FreeGen
 * @author nishiyama
 */
public class BsMemberSolrBean extends AbstractSolrBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** id (tlong) */
    @Field("id")
    protected Long id;

    /** member_id (tlong) */
    @Field("member_id")
    protected Long memberId;

    /** member_status_cd (string) */
    @Field("member_status_cd")
    protected String memberStatusCd;

    /** member_name (string) */
    @Field("member_name")
    protected String memberName;

    /** member_account (string) */
    @Field("member_account")
    protected String memberAccount;

    /** birthdate (tdate) */
    @Field("birthdate")
    protected Date birthdate;

    /** formalized_datetime (tdate) */
    @Field("formalized_datetime")
    protected Date formalizedDatetime;

    /** purchase_id (tlong) */
    @Field("purchase_id")
    protected Long[] purchaseId;

    /** product_id (tlong) */
    @Field("product_id")
    protected Long[] productId;

    /** product_name (string) */
    @Field("product_name")
    protected String[] productName;

    /** product_category_code (string) */
    @Field("product_category_code")
    protected String[] productCategoryCode;

    /** product_category_name (string) */
    @Field("product_category_name")
    protected String[] productCategoryName;

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Long getId() {
        return id;
    }

    public void setId(Long value) {
        id = value;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long value) {
        memberId = value;
    }

    public String getMemberStatusCd() {
        return memberStatusCd;
    }

    public void setMemberStatusCd(String value) {
        memberStatusCd = value;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String value) {
        memberName = value;
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String value) {
        memberAccount = value;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date value) {
        birthdate = value;
    }

    public Date getFormalizedDatetime() {
        return formalizedDatetime;
    }

    public void setFormalizedDatetime(Date value) {
        formalizedDatetime = value;
    }

    public Long[] getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long[] value) {
        purchaseId = value;
    }

    public Long[] getProductId() {
        return productId;
    }

    public void setProductId(Long[] value) {
        productId = value;
    }

    public String[] getProductName() {
        return productName;
    }

    public void setProductName(String[] value) {
        productName = value;
    }

    public String[] getProductCategoryCode() {
        return productCategoryCode;
    }

    public void setProductCategoryCode(String[] value) {
        productCategoryCode = value;
    }

    public String[] getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String[] value) {
        productCategoryName = value;
    }


    // ===================================================================================
    //                                                                            toString
    //                                                                            ========
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("id").append("=").append(this.getId()).append(",");
		sb.append("memberId").append("=").append(this.getMemberId()).append(",");
		sb.append("memberStatusCd").append("=").append(this.getMemberStatusCd()).append(",");
		sb.append("memberName").append("=").append(this.getMemberName()).append(",");
		sb.append("memberAccount").append("=").append(this.getMemberAccount()).append(",");
		sb.append("birthdate").append("=").append(this.getBirthdate()).append(",");
		sb.append("formalizedDatetime").append("=").append(this.getFormalizedDatetime()).append(",");
		sb.append("purchaseId").append("=").append(this.getPurchaseId()).append(",");
		sb.append("productId").append("=").append(this.getProductId()).append(",");
		sb.append("productName").append("=").append(this.getProductName()).append(",");
		sb.append("productCategoryCode").append("=").append(this.getProductCategoryCode()).append(",");
		sb.append("productCategoryName").append("=").append(this.getProductCategoryName()).append(",");
		sb.append("]");
		return sb.toString();
	}
	
}
