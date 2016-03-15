package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011;
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
 * PtnTotal のクラスファイル 
 * 
 * @author 自動生成
 */
public class PtnTotalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PnlCondition")
    private PnlConditionDiv PnlCondition;
    @JsonProperty("PnlData")
    private PnlDataDiv PnlData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPnlCondition
     * @return PnlCondition
     */
    @JsonProperty("PnlCondition")
    public PnlConditionDiv getPnlCondition() {
        return PnlCondition;
    }

    /*
     * setPnlCondition
     * @param PnlCondition PnlCondition
     */
    @JsonProperty("PnlCondition")
    public void setPnlCondition(PnlConditionDiv PnlCondition) {
        this.PnlCondition = PnlCondition;
    }

    /*
     * getPnlData
     * @return PnlData
     */
    @JsonProperty("PnlData")
    public PnlDataDiv getPnlData() {
        return PnlData;
    }

    /*
     * setPnlData
     * @param PnlData PnlData
     */
    @JsonProperty("PnlData")
    public void setPnlData(PnlDataDiv PnlData) {
        this.PnlData = PnlData;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRdoBango() {
        return this.getPnlCondition().getRdoBango();
    }

    @JsonIgnore
    public void  setRdoBango(RadioButton rdoBango) {
        this.getPnlCondition().setRdoBango(rdoBango);
    }

    @JsonIgnore
    public TextBoxNum getTxtJigyosyakeyakuNo() {
        return this.getPnlCondition().getTxtJigyosyakeyakuNo();
    }

    @JsonIgnore
    public void  setTxtJigyosyakeyakuNo(TextBoxNum txtJigyosyakeyakuNo) {
        this.getPnlCondition().setTxtJigyosyakeyakuNo(txtJigyosyakeyakuNo);
    }

    @JsonIgnore
    public RadioButton getRdoMeisyo() {
        return this.getPnlCondition().getRdoMeisyo();
    }

    @JsonIgnore
    public void  setRdoMeisyo(RadioButton rdoMeisyo) {
        this.getPnlCondition().setRdoMeisyo(rdoMeisyo);
    }

    @JsonIgnore
    public RadioButton getRdoJyusyo() {
        return this.getPnlCondition().getRdoJyusyo();
    }

    @JsonIgnore
    public void  setRdoJyusyo(RadioButton rdoJyusyo) {
        this.getPnlCondition().setRdoJyusyo(rdoJyusyo);
    }

    @JsonIgnore
    public TextBoxKana getTxtMeisyoKana() {
        return this.getPnlCondition().getTxtMeisyoKana();
    }

    @JsonIgnore
    public void  setTxtMeisyoKana(TextBoxKana txtMeisyoKana) {
        this.getPnlCondition().setTxtMeisyoKana(txtMeisyoKana);
    }

    @JsonIgnore
    public CheckBoxList getChkMeisyoKana() {
        return this.getPnlCondition().getChkMeisyoKana();
    }

    @JsonIgnore
    public void  setChkMeisyoKana(CheckBoxList chkMeisyoKana) {
        this.getPnlCondition().setChkMeisyoKana(chkMeisyoKana);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubin() {
        return this.getPnlCondition().getTxtYubin();
    }

    @JsonIgnore
    public void  setTxtYubin(TextBoxYubinNo txtYubin) {
        this.getPnlCondition().setTxtYubin(txtYubin);
    }

    @JsonIgnore
    public TextBox getTxtMeisyoKanji() {
        return this.getPnlCondition().getTxtMeisyoKanji();
    }

    @JsonIgnore
    public void  setTxtMeisyoKanji(TextBox txtMeisyoKanji) {
        this.getPnlCondition().setTxtMeisyoKanji(txtMeisyoKanji);
    }

    @JsonIgnore
    public CheckBoxList getChkMeisyoKanji() {
        return this.getPnlCondition().getChkMeisyoKanji();
    }

    @JsonIgnore
    public void  setChkMeisyoKanji(CheckBoxList chkMeisyoKanji) {
        this.getPnlCondition().setChkMeisyoKanji(chkMeisyoKanji);
    }

    @JsonIgnore
    public TextBox getTxtJyusyoKanji() {
        return this.getPnlCondition().getTxtJyusyoKanji();
    }

    @JsonIgnore
    public void  setTxtJyusyoKanji(TextBox txtJyusyoKanji) {
        this.getPnlCondition().setTxtJyusyoKanji(txtJyusyoKanji);
    }

    @JsonIgnore
    public CheckBoxList getChkJyusyoKanji() {
        return this.getPnlCondition().getChkJyusyoKanji();
    }

    @JsonIgnore
    public void  setChkJyusyoKanji(CheckBoxList chkJyusyoKanji) {
        this.getPnlCondition().setChkJyusyoKanji(chkJyusyoKanji);
    }

    @JsonIgnore
    public DropDownList getDdlKeiyakuSyurui() {
        return this.getPnlCondition().getDdlKeiyakuSyurui();
    }

    @JsonIgnore
    public void  setDdlKeiyakuSyurui(DropDownList ddlKeiyakuSyurui) {
        this.getPnlCondition().setDdlKeiyakuSyurui(ddlKeiyakuSyurui);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxCount() {
        return this.getPnlCondition().getTxtMaxCount();
    }

    @JsonIgnore
    public void  setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.getPnlCondition().setTxtMaxCount(txtMaxCount);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPnlCondition().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPnlCondition().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getPnlCondition().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getPnlCondition().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public DataGrid<dgKeiyakuJigyosya_Row> getDgKeiyakuJigyosya() {
        return this.getPnlData().getDgKeiyakuJigyosya();
    }

    @JsonIgnore
    public void  setDgKeiyakuJigyosya(DataGrid<dgKeiyakuJigyosya_Row> dgKeiyakuJigyosya) {
        this.getPnlData().setDgKeiyakuJigyosya(dgKeiyakuJigyosya);
    }

    @JsonIgnore
    public Button getBtnSearchAgain() {
        return this.getPnlData().getBtnSearchAgain();
    }

    @JsonIgnore
    public void  setBtnSearchAgain(Button btnSearchAgain) {
        this.getPnlData().setBtnSearchAgain(btnSearchAgain);
    }

    // </editor-fold>
}
