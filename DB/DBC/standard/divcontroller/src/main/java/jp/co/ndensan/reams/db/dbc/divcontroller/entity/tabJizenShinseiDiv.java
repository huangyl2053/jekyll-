package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IKyufugakuSummaryDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiReasonForTabDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuJizenShinseiDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJizenShinseiContentsDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJizenShinseiPayMethodDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJizenShinseiResultDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethodDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabJizenShinsei のクラスファイル
 *
 * @author 自動生成
 */
public class tabJizenShinseiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("tplJizenShinseiContents")
    private tplJizenShinseiContentsDiv tplJizenShinseiContents;
    @JsonProperty("tplJizenShinseiResult")
    private tplJizenShinseiResultDiv tplJizenShinseiResult;
    @JsonProperty("tplJizenShinseiPayMethod")
    private tplJizenShinseiPayMethodDiv tplJizenShinseiPayMethod;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplJizenShinseiContents")
    public tplJizenShinseiContentsDiv getTplJizenShinseiContents() {
        return tplJizenShinseiContents;
    }

    @JsonProperty("tplJizenShinseiContents")
    public void setTplJizenShinseiContents(tplJizenShinseiContentsDiv tplJizenShinseiContents) {
        this.tplJizenShinseiContents = tplJizenShinseiContents;
    }

    @JsonProperty("tplJizenShinseiResult")
    public tplJizenShinseiResultDiv getTplJizenShinseiResult() {
        return tplJizenShinseiResult;
    }

    @JsonProperty("tplJizenShinseiResult")
    public void setTplJizenShinseiResult(tplJizenShinseiResultDiv tplJizenShinseiResult) {
        this.tplJizenShinseiResult = tplJizenShinseiResult;
    }

    @JsonProperty("tplJizenShinseiPayMethod")
    public tplJizenShinseiPayMethodDiv getTplJizenShinseiPayMethod() {
        return tplJizenShinseiPayMethod;
    }

    @JsonProperty("tplJizenShinseiPayMethod")
    public void setTplJizenShinseiPayMethod(tplJizenShinseiPayMethodDiv tplJizenShinseiPayMethod) {
        this.tplJizenShinseiPayMethod = tplJizenShinseiPayMethod;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtJutakuOwner() {
        return this.getTplJizenShinseiContents().getTxtJutakuOwner();
    }

    @JsonIgnore
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.getTplJizenShinseiContents().setTxtJutakuOwner(txtJutakuOwner);
    }

    @JsonIgnore
    public TextBox getTxtRelationWithHihokensha() {
        return this.getTplJizenShinseiContents().getTxtRelationWithHihokensha();
    }

    @JsonIgnore
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.getTplJizenShinseiContents().setTxtRelationWithHihokensha(txtRelationWithHihokensha);
    }

    @JsonIgnore
    public DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> getDgJutakuKaishuJizenShinseiDetail() {
        return this.getTplJizenShinseiContents().getDgJutakuKaishuJizenShinseiDetail();
    }

    @JsonIgnore
    public void setDgJutakuKaishuJizenShinseiDetail(DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> dgJutakuKaishuJizenShinseiDetail) {
        this.getTplJizenShinseiContents().setDgJutakuKaishuJizenShinseiDetail(dgJutakuKaishuJizenShinseiDetail);
    }

    @JsonIgnore
    public IShinseishaInfoDiv getJutakuKaishuJizenShinseisha() {
        return this.getTplJizenShinseiContents().getJutakuKaishuJizenShinseisha();
    }

    @JsonIgnore
    public JutakuKaishuJizenShinseiReasonForTabDiv getJutakuKaishuJizenShinseiReasonForTab() {
        return this.getTplJizenShinseiContents().getJutakuKaishuJizenShinseiReasonForTab();
    }

    @JsonIgnore
    public void setJutakuKaishuJizenShinseiReasonForTab(JutakuKaishuJizenShinseiReasonForTabDiv JutakuKaishuJizenShinseiReasonForTab) {
        this.getTplJizenShinseiContents().setJutakuKaishuJizenShinseiReasonForTab(JutakuKaishuJizenShinseiReasonForTab);
    }

    @JsonIgnore
    public IKyufugakuSummaryDiv getJutakuKaishuJizenShinseiKyufugakuSummary() {
        return this.getTplJizenShinseiResult().getJutakuKaishuJizenShinseiKyufugakuSummary();
    }

    @JsonIgnore
    public HorizontalLine getHl() {
        return this.getTplJizenShinseiResult().getHl();
    }

    @JsonIgnore
    public void setHl(HorizontalLine hl) {
        this.getTplJizenShinseiResult().setHl(hl);
    }

    @JsonIgnore
    public TextBoxDate getTxtJudgeDate() {
        return this.getTplJizenShinseiResult().getTxtJudgeDate();
    }

    @JsonIgnore
    public void setTxtJudgeDate(TextBoxDate txtJudgeDate) {
        this.getTplJizenShinseiResult().setTxtJudgeDate(txtJudgeDate);
    }

    @JsonIgnore
    public RadioButton getRadJudgeKubun() {
        return this.getTplJizenShinseiResult().getRadJudgeKubun();
    }

    @JsonIgnore
    public void setRadJudgeKubun(RadioButton radJudgeKubun) {
        this.getTplJizenShinseiResult().setRadJudgeKubun(radJudgeKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShoninCondition() {
        return this.getTplJizenShinseiResult().getTxtShoninCondition();
    }

    @JsonIgnore
    public void setTxtShoninCondition(TextBoxMultiLine txtShoninCondition) {
        this.getTplJizenShinseiResult().setTxtShoninCondition(txtShoninCondition);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushoninReason() {
        return this.getTplJizenShinseiResult().getTxtFushoninReason();
    }

    @JsonIgnore
    public void setTxtFushoninReason(TextBoxMultiLine txtFushoninReason) {
        this.getTplJizenShinseiResult().setTxtFushoninReason(txtFushoninReason);
    }

    @JsonIgnore
    public CheckBoxList getChkResetInfo() {
        return this.getTplJizenShinseiResult().getChkResetInfo();
    }

    @JsonIgnore
    public void setChkResetInfo(CheckBoxList chkResetInfo) {
        this.getTplJizenShinseiResult().setChkResetInfo(chkResetInfo);
    }

    @JsonIgnore
    public PaymentMethodDiv getPaymentMethod() {
        return this.getTplJizenShinseiPayMethod().getPaymentMethod();
    }

}
