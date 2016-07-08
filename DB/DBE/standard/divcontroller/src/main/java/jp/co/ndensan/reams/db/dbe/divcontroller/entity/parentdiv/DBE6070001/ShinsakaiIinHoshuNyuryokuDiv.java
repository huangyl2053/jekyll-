package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiIinHoshuNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinHoshuNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiIinKensakuJoken")
    private ShinsakaiIinKensakuJokenDiv ShinsakaiIinKensakuJoken;
    @JsonProperty("ShinsakaiIin")
    private ShinsakaiIinDiv ShinsakaiIin;
    @JsonProperty("ShinsakaiJisseki")
    private ShinsakaiJissekiDiv ShinsakaiJisseki;
    @JsonProperty("ShinsakaiMessage")
    private ShinsakaiMessageDiv ShinsakaiMessage;
    @JsonProperty("HiddenColumnState")
    private RString HiddenColumnState;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiIinKensakuJoken
     * @return ShinsakaiIinKensakuJoken
     */
    @JsonProperty("ShinsakaiIinKensakuJoken")
    public ShinsakaiIinKensakuJokenDiv getShinsakaiIinKensakuJoken() {
        return ShinsakaiIinKensakuJoken;
    }

    /*
     * setShinsakaiIinKensakuJoken
     * @param ShinsakaiIinKensakuJoken ShinsakaiIinKensakuJoken
     */
    @JsonProperty("ShinsakaiIinKensakuJoken")
    public void setShinsakaiIinKensakuJoken(ShinsakaiIinKensakuJokenDiv ShinsakaiIinKensakuJoken) {
        this.ShinsakaiIinKensakuJoken = ShinsakaiIinKensakuJoken;
    }

    /*
     * getShinsakaiIin
     * @return ShinsakaiIin
     */
    @JsonProperty("ShinsakaiIin")
    public ShinsakaiIinDiv getShinsakaiIin() {
        return ShinsakaiIin;
    }

    /*
     * setShinsakaiIin
     * @param ShinsakaiIin ShinsakaiIin
     */
    @JsonProperty("ShinsakaiIin")
    public void setShinsakaiIin(ShinsakaiIinDiv ShinsakaiIin) {
        this.ShinsakaiIin = ShinsakaiIin;
    }

    /*
     * getShinsakaiJisseki
     * @return ShinsakaiJisseki
     */
    @JsonProperty("ShinsakaiJisseki")
    public ShinsakaiJissekiDiv getShinsakaiJisseki() {
        return ShinsakaiJisseki;
    }

    /*
     * setShinsakaiJisseki
     * @param ShinsakaiJisseki ShinsakaiJisseki
     */
    @JsonProperty("ShinsakaiJisseki")
    public void setShinsakaiJisseki(ShinsakaiJissekiDiv ShinsakaiJisseki) {
        this.ShinsakaiJisseki = ShinsakaiJisseki;
    }

    /*
     * getShinsakaiMessage
     * @return ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public ShinsakaiMessageDiv getShinsakaiMessage() {
        return ShinsakaiMessage;
    }

    /*
     * setShinsakaiMessage
     * @param ShinsakaiMessage ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public void setShinsakaiMessage(ShinsakaiMessageDiv ShinsakaiMessage) {
        this.ShinsakaiMessage = ShinsakaiMessage;
    }

    /*
     * getHiddenColumnState
     * @return HiddenColumnState
     */
    @JsonProperty("HiddenColumnState")
    public RString getHiddenColumnState() {
        return HiddenColumnState;
    }

    /*
     * setHiddenColumnState
     * @param HiddenColumnState HiddenColumnState
     */
    @JsonProperty("HiddenColumnState")
    public void setHiddenColumnState(RString HiddenColumnState) {
        this.HiddenColumnState = HiddenColumnState;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShinsaIinmei() {
        return this.getShinsakaiIinKensakuJoken().getTxtShinsaIinmei();
    }

    @JsonIgnore
    public void  setTxtShinsaIinmei(TextBox txtShinsaIinmei) {
        this.getShinsakaiIinKensakuJoken().setTxtShinsaIinmei(txtShinsaIinmei);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaNameMatchType() {
        return this.getShinsakaiIinKensakuJoken().getDdlHihokenshaNameMatchType();
    }

    @JsonIgnore
    public void  setDdlHihokenshaNameMatchType(DropDownList ddlHihokenshaNameMatchType) {
        this.getShinsakaiIinKensakuJoken().setDdlHihokenshaNameMatchType(ddlHihokenshaNameMatchType);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKensakuNendo() {
        return this.getShinsakaiIinKensakuJoken().getTxtKensakuNendo();
    }

    @JsonIgnore
    public void  setTxtKensakuNendo(TextBoxDateRange txtKensakuNendo) {
        this.getShinsakaiIinKensakuJoken().setTxtKensakuNendo(txtKensakuNendo);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum() {
        return this.getShinsakaiIinKensakuJoken().getTextBoxNum();
    }

    @JsonIgnore
    public void  setTextBoxNum(TextBoxNum TextBoxNum) {
        this.getShinsakaiIinKensakuJoken().setTextBoxNum(TextBoxNum);
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiSearchClear() {
        return this.getShinsakaiIinKensakuJoken().getBtnKyufuJissekiSearchClear();
    }

    @JsonIgnore
    public void  setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.getShinsakaiIinKensakuJoken().setBtnKyufuJissekiSearchClear(btnKyufuJissekiSearchClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getShinsakaiIinKensakuJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getShinsakaiIinKensakuJoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIin_Row> getDgShinsakaiIin() {
        return this.getShinsakaiIin().getDgShinsakaiIin();
    }

    @JsonIgnore
    public void  setDgShinsakaiIin(DataGrid<dgShinsakaiIin_Row> dgShinsakaiIin) {
        this.getShinsakaiIin().setDgShinsakaiIin(dgShinsakaiIin);
    }

    @JsonIgnore
    public TextBoxCode getTxtShisakaiIinCode() {
        return this.getShinsakaiJisseki().getTxtShisakaiIinCode();
    }

    @JsonIgnore
    public void  setTxtShisakaiIinCode(TextBoxCode txtShisakaiIinCode) {
        this.getShinsakaiJisseki().setTxtShisakaiIinCode(txtShisakaiIinCode);
    }

    @JsonIgnore
    public TextBox getTxtShisakaiIinName() {
        return this.getShinsakaiJisseki().getTxtShisakaiIinName();
    }

    @JsonIgnore
    public void  setTxtShisakaiIinName(TextBox txtShisakaiIinName) {
        this.getShinsakaiJisseki().setTxtShisakaiIinName(txtShisakaiIinName);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiJisseki_Row> getDgShinsakaiJisseki() {
        return this.getShinsakaiJisseki().getDgShinsakaiJisseki();
    }

    @JsonIgnore
    public void  setDgShinsakaiJisseki(DataGrid<dgShinsakaiJisseki_Row> dgShinsakaiJisseki) {
        this.getShinsakaiJisseki().setDgShinsakaiJisseki(dgShinsakaiJisseki);
    }

    @JsonIgnore
    public ShinsakaiJissekiMeisaiDiv getShinsakaiJissekiMeisai() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai();
    }

    @JsonIgnore
    public void  setShinsakaiJissekiMeisai(ShinsakaiJissekiMeisaiDiv ShinsakaiJissekiMeisai) {
        this.getShinsakaiJisseki().setShinsakaiJissekiMeisai(ShinsakaiJissekiMeisai);
    }

    @JsonIgnore
    public RadioButton getRadHoshuKubun() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getRadHoshuKubun();
    }

    @JsonIgnore
    public void  setRadHoshuKubun(RadioButton radHoshuKubun) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setRadHoshuKubun(radHoshuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJissekiNengappi() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtJissekiNengappi();
    }

    @JsonIgnore
    public void  setTxtJissekiNengappi(TextBoxFlexibleDate txtJissekiNengappi) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtJissekiNengappi(txtJissekiNengappi);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiBango() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtGogitaiBango();
    }

    @JsonIgnore
    public void  setTxtGogitaiBango(TextBox txtGogitaiBango) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtGogitaiBango(txtGogitaiBango);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaisaiBango() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaisaiBango(TextBox txtShinsakaiKaisaiBango) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtShinsakaiKaisaiBango(txtShinsakaiKaisaiBango);
    }

    @JsonIgnore
    public TextBox getTxtGogitaichoKubun() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtGogitaichoKubun();
    }

    @JsonIgnore
    public void  setTxtGogitaichoKubun(TextBox txtGogitaichoKubun) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtGogitaichoKubun(txtGogitaichoKubun);
    }

    @JsonIgnore
    public TextBox getTxtShukketsu() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtShukketsu();
    }

    @JsonIgnore
    public void  setTxtShukketsu(TextBox txtShukketsu) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtShukketsu(txtShukketsu);
    }

    @JsonIgnore
    public TextBoxTime getTxtShussekiJikan() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtShussekiJikan();
    }

    @JsonIgnore
    public void  setTxtShussekiJikan(TextBoxTime txtShussekiJikan) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtShussekiJikan(txtShussekiJikan);
    }

    @JsonIgnore
    public TextBoxTime getTxtTaisekiJikan() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtTaisekiJikan();
    }

    @JsonIgnore
    public void  setTxtTaisekiJikan(TextBoxTime txtTaisekiJikan) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtTaisekiJikan(txtTaisekiJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtShinsaHoshugaku() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku();
    }

    @JsonIgnore
    public void  setTxtShinsaHoshugaku(TextBoxNum txtShinsaHoshugaku) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtShinsaHoshugaku(txtShinsaHoshugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaHoshu() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtSonotaHoshu();
    }

    @JsonIgnore
    public void  setTxtSonotaHoshu(TextBoxNum txtSonotaHoshu) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtSonotaHoshu(txtSonotaHoshu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshuZeiritsu() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu();
    }

    @JsonIgnore
    public void  setTxtHoshuZeiritsu(TextBoxNum txtHoshuZeiritsu) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtHoshuZeiritsu(txtHoshuZeiritsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKotsuhito() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtKotsuhito();
    }

    @JsonIgnore
    public void  setTxtKotsuhito(TextBoxNum txtKotsuhito) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtKotsuhito(txtKotsuhito);
    }

    @JsonIgnore
    public TextBoxNum getTxtKojozeikaku() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtKojozeikaku();
    }

    @JsonIgnore
    public void  setTxtKojozeikaku(TextBoxNum txtKojozeikaku) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtKojozeikaku(txtKojozeikaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZeibikigoShiharaigaku() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku();
    }

    @JsonIgnore
    public void  setTxtZeibikigoShiharaigaku(TextBoxNum txtZeibikigoShiharaigaku) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtZeibikigoShiharaigaku(txtZeibikigoShiharaigaku);
    }

    @JsonIgnore
    public TextBox getTxtShiharaiMemo() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getTxtShiharaiMemo();
    }

    @JsonIgnore
    public void  setTxtShiharaiMemo(TextBox txtShiharaiMemo) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setTxtShiharaiMemo(txtShiharaiMemo);
    }

    @JsonIgnore
    public RadioButton getRadGinkoFurikomi() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getRadGinkoFurikomi();
    }

    @JsonIgnore
    public void  setRadGinkoFurikomi(RadioButton radGinkoFurikomi) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setRadGinkoFurikomi(radGinkoFurikomi);
    }

    @JsonIgnore
    public Button getBtnToroku() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getBtnToroku();
    }

    @JsonIgnore
    public void  setBtnToroku(Button btnToroku) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setBtnToroku(btnToroku);
    }

    @JsonIgnore
    public Button getBtnNyuryokuToriyameru() {
        return this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().getBtnNyuryokuToriyameru();
    }

    @JsonIgnore
    public void  setBtnNyuryokuToriyameru(Button btnNyuryokuToriyameru) {
        this.getShinsakaiJisseki().getShinsakaiJissekiMeisai().setBtnNyuryokuToriyameru(btnNyuryokuToriyameru);
    }

    // </editor-fold>
}
