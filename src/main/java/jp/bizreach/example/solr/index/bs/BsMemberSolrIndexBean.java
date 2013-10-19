package jp.bizreach.example.solr.index.bs;

import java.io.Serializable;
import java.util.Date;
import jp.bizreach.example.solr.base.AbstractSolrIndexBean;
import org.apache.solr.client.solrj.beans.Field;
import java.util.List;


/**
 * Solr Index登録用BeanのBaseクラス<br />
 * indexd=true もしくは stored=trueが必要
 * string, tint, tlong, tdate, tdouble, text_ja, text_cjkのみに対応しています
 * @author FreeGen
 * @author nishiyama
 */
public class BsMemberSolrIndexBean extends AbstractSolrIndexBean implements Serializable {

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
	protected List<Long> purchaseId;

	/** product_id (tlong) */
	@Field("product_id")
	protected List<Long> productId;

	/** product_name (string) */
	@Field("product_name")
	protected List<String> productName;

	/** product_category_code (string) */
	@Field("product_category_code")
	protected List<String> productCategoryCode;

	/** product_category_name (string) */
	@Field("product_category_name")
	protected List<String> productCategoryName;

	/** purchase_name (text_cjk) */
	@Field("purchase_name")
	protected List<String> purchaseName;


	// ===================================================================================
	//                                                                            Accessor
	//                                                                            ========
    public Long getId() {
		return this.id;
    }

	public void setId(Long value) {
		this.id = value;
    }

    public Long getMemberId() {
		return this.memberId;
    }

	public void setMemberId(Long value) {
		this.memberId = value;
    }

    public String getMemberStatusCd() {
		return this.memberStatusCd;
    }

	public void setMemberStatusCd(String value) {
		this.memberStatusCd = value;
    }

    public String getMemberName() {
		return this.memberName;
    }

	public void setMemberName(String value) {
		this.memberName = value;
    }

    public String getMemberAccount() {
		return this.memberAccount;
    }

	public void setMemberAccount(String value) {
		this.memberAccount = value;
    }

    public Date getBirthdate() {
		return this.birthdate;
    }

	public void setBirthdate(Date value) {
		this.birthdate = value;
    }

    public Date getFormalizedDatetime() {
		return this.formalizedDatetime;
    }

	public void setFormalizedDatetime(Date value) {
		this.formalizedDatetime = value;
    }

    public List<Long> getPurchaseId() {
		if (this.purchaseId == null) { this.purchaseId = newMultiValuedList(); }
		return this.purchaseId;
    }

	public void setPurchaseId(List<Long> value) {
		this.purchaseId = value;
    }

	public void addPurchaseId(Long value) {
		getPurchaseId().add(value);
	}
    public List<Long> getProductId() {
		if (this.productId == null) { this.productId = newMultiValuedList(); }
		return this.productId;
    }

	public void setProductId(List<Long> value) {
		this.productId = value;
    }

	public void addProductId(Long value) {
		getProductId().add(value);
	}
    public List<String> getProductName() {
		if (this.productName == null) { this.productName = newMultiValuedList(); }
		return this.productName;
    }

	public void setProductName(List<String> value) {
		this.productName = value;
    }

	public void addProductName(String value) {
		getProductName().add(value);
	}
    public List<String> getProductCategoryCode() {
		if (this.productCategoryCode == null) { this.productCategoryCode = newMultiValuedList(); }
		return this.productCategoryCode;
    }

	public void setProductCategoryCode(List<String> value) {
		this.productCategoryCode = value;
    }

	public void addProductCategoryCode(String value) {
		getProductCategoryCode().add(value);
	}
    public List<String> getProductCategoryName() {
		if (this.productCategoryName == null) { this.productCategoryName = newMultiValuedList(); }
		return this.productCategoryName;
    }

	public void setProductCategoryName(List<String> value) {
		this.productCategoryName = value;
    }

	public void addProductCategoryName(String value) {
		getProductCategoryName().add(value);
	}
    public List<String> getPurchaseName() {
		if (this.purchaseName == null) { this.purchaseName = newMultiValuedList(); }
		return this.purchaseName;
    }

	public void setPurchaseName(List<String> value) {
		this.purchaseName = value;
    }

	public void addPurchaseName(String value) {
		getPurchaseName().add(value);
	}
}
