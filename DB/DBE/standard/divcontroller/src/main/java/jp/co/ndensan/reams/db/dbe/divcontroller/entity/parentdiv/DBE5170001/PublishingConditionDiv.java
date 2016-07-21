package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PublishingCondition のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublishingConditionDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShutsuryokuJun")
    private TextBox txtShutsuryokuJun;
    @JsonProperty("ddlShutsuryokuStyleZenken")
    private DropDownList ddlShutsuryokuStyleZenken;
    @JsonProperty("radShutsuryokuStyleZenken")
    private RadioButton radShutsuryokuStyleZenken;
    @JsonProperty("radSakuseiJokenType")
    private RadioButton radSakuseiJokenType;
    @JsonProperty("txtShiryoNoStart")
    private TextBoxNum txtShiryoNoStart;
    @JsonProperty("txtSiryoNoEnd")
    private TextBoxNum txtSiryoNoEnd;
    @JsonProperty("PublishingConditionForJimukyoku")
    private PublishingConditionForJimukyokuDiv PublishingConditionForJimukyoku;
    @JsonProperty("PublishingConditionForShinsakaiIin")
    private PublishingConditionForShinsakaiIinDiv PublishingConditionForShinsakaiIin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShutsuryokuJun
     * @return txtShutsuryokuJun
     */
    @JsonProperty("txtShutsuryokuJun")
    public TextBox getTxtShutsuryokuJun() {
        return txtShutsuryokuJun;
    }

    /*
     * settxtShutsuryokuJun
     * @param txtShutsuryokuJun txtShutsuryokuJun
     */
    @JsonProperty("txtShutsuryokuJun")
    public void setTxtShutsuryokuJun(TextBox txtShutsuryokuJun) {
        this.txtShutsuryokuJun = txtShutsuryokuJun;
    }

    /*
     * getddlShutsuryokuStyleZenken
     * @return ddlShutsuryokuStyleZenken
     */
    @JsonProperty("ddlShutsuryokuStyleZenken")
    public DropDownList getDdlShutsuryokuStyleZenken() {
        return ddlShutsuryokuStyleZenken;
    }

    /*
     * setddlShutsuryokuStyleZenken
     * @param ddlShutsuryokuStyleZenken ddlShutsuryokuStyleZenken
     */
    @JsonProperty("ddlShutsuryokuStyleZenken")
    public void setDdlShutsuryokuStyleZenken(DropDownList ddlShutsuryokuStyleZenken) {
        this.ddlShutsuryokuStyleZenken = ddlShutsuryokuStyleZenken;
    }

    /*
     * getradShutsuryokuStyleZenken
     * @return radShutsuryokuStyleZenken
     */
    @JsonProperty("radShutsuryokuStyleZenken")
    public RadioButton getRadShutsuryokuStyleZenken() {
        return radShutsuryokuStyleZenken;
    }

    /*
     * setradShutsuryokuStyleZenken
     * @param radShutsuryokuStyleZenken radShutsuryokuStyleZenken
     */
    @JsonProperty("radShutsuryokuStyleZenken")
    public void setRadShutsuryokuStyleZenken(RadioButton radShutsuryokuStyleZenken) {
        this.radShutsuryokuStyleZenken = radShutsuryokuStyleZenken;
    }

    /*
     * getradSakuseiJokenType
     * @return radSakuseiJokenType
     */
    @JsonProperty("radSakuseiJokenType")
    public RadioButton getRadSakuseiJokenType() {
        return radSakuseiJokenType;
    }

    /*
     * setradSakuseiJokenType
     * @param radSakuseiJokenType radSakuseiJokenType
     */
    @JsonProperty("radSakuseiJokenType")
    public void setRadSakuseiJokenType(RadioButton radSakuseiJokenType) {
        this.radSakuseiJokenType = radSakuseiJokenType;
    }

    /*
     * gettxtShiryoNoStart
     * @return txtShiryoNoStart
     */
    @JsonProperty("txtShiryoNoStart")
    public TextBoxNum getTxtShiryoNoStart() {
        return txtShiryoNoStart;
    }

    /*
     * settxtShiryoNoStart
     * @param txtShiryoNoStart txtShiryoNoStart
     */
    @JsonProperty("txtShiryoNoStart")
    public void setTxtShiryoNoStart(TextBoxNum txtShiryoNoStart) {
        this.txtShiryoNoStart = txtShiryoNoStart;
    }

    /*
     * gettxtSiryoNoEnd
     * @return txtSiryoNoEnd
     */
    @JsonProperty("txtSiryoNoEnd")
    public TextBoxNum getTxtSiryoNoEnd() {
        return txtSiryoNoEnd;
    }

    /*
     * settxtSiryoNoEnd
     * @param txtSiryoNoEnd txtSiryoNoEnd
     */
    @JsonProperty("txtSiryoNoEnd")
    public void setTxtSiryoNoEnd(TextBoxNum txtSiryoNoEnd) {
        this.txtSiryoNoEnd = txtSiryoNoEnd;
    }

    /*
     * getPublishingConditionForJimukyoku
     * @return PublishingConditionForJimukyoku
     */
    @JsonProperty("PublishingConditionForJimukyoku")
    public PublishingConditionForJimukyokuDiv getPublishingConditionForJimukyoku() {
        return PublishingConditionForJimukyoku;
    }

    /*
     * setPublishingConditionForJimukyoku
     * @param PublishingConditionForJimukyoku PublishingConditionForJimukyoku
     */
    @JsonProperty("PublishingConditionForJimukyoku")
    public void setPublishingConditionForJimukyoku(PublishingConditionForJimukyokuDiv PublishingConditionForJimukyoku) {
        this.PublishingConditionForJimukyoku = PublishingConditionForJimukyoku;
    }

    /*
     * getPublishingConditionForShinsakaiIin
     * @return PublishingConditionForShinsakaiIin
     */
    @JsonProperty("PublishingConditionForShinsakaiIin")
    public PublishingConditionForShinsakaiIinDiv getPublishingConditionForShinsakaiIin() {
        return PublishingConditionForShinsakaiIin;
    }

    /*
     * setPublishingConditionForShinsakaiIin
     * @param PublishingConditionForShinsakaiIin PublishingConditionForShinsakaiIin
     */
    @JsonProperty("PublishingConditionForShinsakaiIin")
    public void setPublishingConditionForShinsakaiIin(PublishingConditionForShinsakaiIinDiv PublishingConditionForShinsakaiIin) {
        this.PublishingConditionForShinsakaiIin = PublishingConditionForShinsakaiIin;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkPrintChoyoJimu() {
        return this.getPublishingConditionForJimukyoku().getChkPrintChoyoJimu();
    }

    @JsonIgnore
    public void  setChkPrintChoyoJimu(CheckBoxList chkPrintChoyoJimu) {
        this.getPublishingConditionForJimukyoku().setChkPrintChoyoJimu(chkPrintChoyoJimu);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getPublishingConditionForJimukyoku().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getPublishingConditionForJimukyoku().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChohyoShinsakaiJimu() {
        return this.getPublishingConditionForJimukyoku().getChkPrintChohyoShinsakaiJimu();
    }

    @JsonIgnore
    public void  setChkPrintChohyoShinsakaiJimu(CheckBoxList chkPrintChohyoShinsakaiJimu) {
        this.getPublishingConditionForJimukyoku().setChkPrintChohyoShinsakaiJimu(chkPrintChohyoShinsakaiJimu);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getPublishingConditionForJimukyoku().getSpSpace3();
    }

    @JsonIgnore
    public void  setSpSpace3(Space spSpace3) {
        this.getPublishingConditionForJimukyoku().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChoyoJimu2() {
        return this.getPublishingConditionForJimukyoku().getChkPrintChoyoJimu2();
    }

    @JsonIgnore
    public void  setChkPrintChoyoJimu2(CheckBoxList chkPrintChoyoJimu2) {
        this.getPublishingConditionForJimukyoku().setChkPrintChoyoJimu2(chkPrintChoyoJimu2);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChohyoIin() {
        return this.getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin();
    }

    @JsonIgnore
    public void  setChkPrintChohyoIin(CheckBoxList chkPrintChohyoIin) {
        this.getPublishingConditionForShinsakaiIin().setChkPrintChohyoIin(chkPrintChohyoIin);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getPublishingConditionForShinsakaiIin().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getPublishingConditionForShinsakaiIin().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChohyoShinsakaiIin() {
        return this.getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin();
    }

    @JsonIgnore
    public void  setChkPrintChohyoShinsakaiIin(CheckBoxList chkPrintChohyoShinsakaiIin) {
        this.getPublishingConditionForShinsakaiIin().setChkPrintChohyoShinsakaiIin(chkPrintChohyoShinsakaiIin);
    }

    @JsonIgnore
    public Space getSpSpace4() {
        return this.getPublishingConditionForShinsakaiIin().getSpSpace4();
    }

    @JsonIgnore
    public void  setSpSpace4(Space spSpace4) {
        this.getPublishingConditionForShinsakaiIin().setSpSpace4(spSpace4);
    }

    @JsonIgnore
    public CheckBoxList getChkPrintChohyoIin2() {
        return this.getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin2();
    }

    @JsonIgnore
    public void  setChkPrintChohyoIin2(CheckBoxList chkPrintChohyoIin2) {
        this.getPublishingConditionForShinsakaiIin().setChkPrintChohyoIin2(chkPrintChohyoIin2);
    }

    // </editor-fold>
}
