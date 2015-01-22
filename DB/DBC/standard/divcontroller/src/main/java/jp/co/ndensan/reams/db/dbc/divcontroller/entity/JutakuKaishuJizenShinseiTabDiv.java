package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IJutakuKaishuJizenShinseiTabDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiReasonForTabDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuJizenShinseiDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tabJizenShinseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJizenShinseiContentsDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJizenShinseiPayMethodDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJizenShinseiResultDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethodDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuJizenShinseiTab のクラスファイル
 *
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiTabDiv extends Panel implements IJutakuKaishuJizenShinseiTabDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("tabJizenShinsei")
    private tabJizenShinseiDiv tabJizenShinsei;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabJizenShinsei")
    public tabJizenShinseiDiv getTabJizenShinsei() {
        return tabJizenShinsei;
    }

    @JsonProperty("tabJizenShinsei")
    public void setTabJizenShinsei(tabJizenShinseiDiv tabJizenShinsei) {
        this.tabJizenShinsei = tabJizenShinsei;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplJizenShinseiContentsDiv getTplJizenShinseiContents() {
        return this.getTabJizenShinsei().getTplJizenShinseiContents();
    }

    @JsonIgnore
    public void setTplJizenShinseiContents(tplJizenShinseiContentsDiv tplJizenShinseiContents) {
        this.getTabJizenShinsei().setTplJizenShinseiContents(tplJizenShinseiContents);
    }

    @JsonIgnore
    public TextBox getTxtJutakuOwner() {
        return this.getTabJizenShinsei().getTplJizenShinseiContents().getTxtJutakuOwner();
    }

    @JsonIgnore
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.getTabJizenShinsei().getTplJizenShinseiContents().setTxtJutakuOwner(txtJutakuOwner);
    }

    @JsonIgnore
    public TextBox getTxtRelationWithHihokensha() {
        return this.getTabJizenShinsei().getTplJizenShinseiContents().getTxtRelationWithHihokensha();
    }

    @JsonIgnore
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.getTabJizenShinsei().getTplJizenShinseiContents().setTxtRelationWithHihokensha(txtRelationWithHihokensha);
    }

    @JsonIgnore
    public DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> getDgJutakuKaishuJizenShinseiDetail() {
        return this.getTabJizenShinsei().getTplJizenShinseiContents().getDgJutakuKaishuJizenShinseiDetail();
    }

    @JsonIgnore
    public void setDgJutakuKaishuJizenShinseiDetail(DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> dgJutakuKaishuJizenShinseiDetail) {
        this.getTabJizenShinsei().getTplJizenShinseiContents().setDgJutakuKaishuJizenShinseiDetail(dgJutakuKaishuJizenShinseiDetail);
    }

    @JsonIgnore
    public ShinseishaInfoDiv getJutakuKaishuJizenShinseisha() {
        return this.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuJizenShinseisha();
    }

    @JsonIgnore
    public JutakuKaishuJizenShinseiReasonForTabDiv getJutakuKaishuJizenShinseiReasonForTab() {
        return this.getTabJizenShinsei().getTplJizenShinseiContents().getJutakuKaishuJizenShinseiReasonForTab();
    }

    @JsonIgnore
    public void setJutakuKaishuJizenShinseiReasonForTab(JutakuKaishuJizenShinseiReasonForTabDiv JutakuKaishuJizenShinseiReasonForTab) {
        this.getTabJizenShinsei().getTplJizenShinseiContents().setJutakuKaishuJizenShinseiReasonForTab(JutakuKaishuJizenShinseiReasonForTab);
    }

    @JsonIgnore
    public tplJizenShinseiResultDiv getTplJizenShinseiResult() {
        return this.getTabJizenShinsei().getTplJizenShinseiResult();
    }

    @JsonIgnore
    public void setTplJizenShinseiResult(tplJizenShinseiResultDiv tplJizenShinseiResult) {
        this.getTabJizenShinsei().setTplJizenShinseiResult(tplJizenShinseiResult);
    }

    @JsonIgnore
    public KyufugakuSummaryDiv getJutakuKaishuJizenShinseiKyufugakuSummary() {
        return this.getTabJizenShinsei().getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary();
    }

    @JsonIgnore
    public HorizontalLine getHl() {
        return this.getTabJizenShinsei().getTplJizenShinseiResult().getHl();
    }

    @JsonIgnore
    public void setHl(HorizontalLine hl) {
        this.getTabJizenShinsei().getTplJizenShinseiResult().setHl(hl);
    }

    @JsonIgnore
    public TextBoxDate getTxtJudgeDate() {
        return this.getTabJizenShinsei().getTplJizenShinseiResult().getTxtJudgeDate();
    }

    @JsonIgnore
    public void setTxtJudgeDate(TextBoxDate txtJudgeDate) {
        this.getTabJizenShinsei().getTplJizenShinseiResult().setTxtJudgeDate(txtJudgeDate);
    }

    @JsonIgnore
    public RadioButton getRadJudgeKubun() {
        return this.getTabJizenShinsei().getTplJizenShinseiResult().getRadJudgeKubun();
    }

    @JsonIgnore
    public void setRadJudgeKubun(RadioButton radJudgeKubun) {
        this.getTabJizenShinsei().getTplJizenShinseiResult().setRadJudgeKubun(radJudgeKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShoninCondition() {
        return this.getTabJizenShinsei().getTplJizenShinseiResult().getTxtShoninCondition();
    }

    @JsonIgnore
    public void setTxtShoninCondition(TextBoxMultiLine txtShoninCondition) {
        this.getTabJizenShinsei().getTplJizenShinseiResult().setTxtShoninCondition(txtShoninCondition);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushoninReason() {
        return this.getTabJizenShinsei().getTplJizenShinseiResult().getTxtFushoninReason();
    }

    @JsonIgnore
    public void setTxtFushoninReason(TextBoxMultiLine txtFushoninReason) {
        this.getTabJizenShinsei().getTplJizenShinseiResult().setTxtFushoninReason(txtFushoninReason);
    }

    @JsonIgnore
    public CheckBoxList getChkResetInfo() {
        return this.getTabJizenShinsei().getTplJizenShinseiResult().getChkResetInfo();
    }

    @JsonIgnore
    public void setChkResetInfo(CheckBoxList chkResetInfo) {
        this.getTabJizenShinsei().getTplJizenShinseiResult().setChkResetInfo(chkResetInfo);
    }

    @JsonIgnore
    public tplJizenShinseiPayMethodDiv getTplJizenShinseiPayMethod() {
        return this.getTabJizenShinsei().getTplJizenShinseiPayMethod();
    }

    @JsonIgnore
    public void setTplJizenShinseiPayMethod(tplJizenShinseiPayMethodDiv tplJizenShinseiPayMethod) {
        this.getTabJizenShinsei().setTplJizenShinseiPayMethod(tplJizenShinseiPayMethod);
    }

    @JsonIgnore
    public PaymentMethodDiv getPaymentMethod() {
        return this.getTabJizenShinsei().getTplJizenShinseiPayMethod().getPaymentMethod();
    }

    //--------------- この行より下にコードを追加してください -------------------
}
