package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakujyokenHissu")
    private KensakujyokenHissuDiv KensakujyokenHissu;
    @JsonProperty("KensakujyokenNini")
    private KensakujyokenNiniDiv KensakujyokenNini;
    @JsonProperty("txtMaxDisp")
    private TextBoxNum txtMaxDisp;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnSearch")
    private Button btnSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakujyokenHissu
     * @return KensakujyokenHissu
     */
    @JsonProperty("KensakujyokenHissu")
    public KensakujyokenHissuDiv getKensakujyokenHissu() {
        return KensakujyokenHissu;
    }

    /*
     * setKensakujyokenHissu
     * @param KensakujyokenHissu KensakujyokenHissu
     */
    @JsonProperty("KensakujyokenHissu")
    public void setKensakujyokenHissu(KensakujyokenHissuDiv KensakujyokenHissu) {
        this.KensakujyokenHissu = KensakujyokenHissu;
    }

    /*
     * getKensakujyokenNini
     * @return KensakujyokenNini
     */
    @JsonProperty("KensakujyokenNini")
    public KensakujyokenNiniDiv getKensakujyokenNini() {
        return KensakujyokenNini;
    }

    /*
     * setKensakujyokenNini
     * @param KensakujyokenNini KensakujyokenNini
     */
    @JsonProperty("KensakujyokenNini")
    public void setKensakujyokenNini(KensakujyokenNiniDiv KensakujyokenNini) {
        this.KensakujyokenNini = KensakujyokenNini;
    }

    /*
     * gettxtMaxDisp
     * @return txtMaxDisp
     */
    @JsonProperty("txtMaxDisp")
    public TextBoxNum getTxtMaxDisp() {
        return txtMaxDisp;
    }

    /*
     * settxtMaxDisp
     * @param txtMaxDisp txtMaxDisp
     */
    @JsonProperty("txtMaxDisp")
    public void setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.txtMaxDisp = txtMaxDisp;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getCblShinseiKubun() {
        return this.getKensakujyokenHissu().getCblShinseiKubun();
    }

    @JsonIgnore
    public void  setCblShinseiKubun(CheckBoxList cblShinseiKubun) {
        this.getKensakujyokenHissu().setCblShinseiKubun(cblShinseiKubun);
    }

    @JsonIgnore
    public CheckBoxList getCblHakkoUmu() {
        return this.getKensakujyokenHissu().getCblHakkoUmu();
    }

    @JsonIgnore
    public void  setCblHakkoUmu(CheckBoxList cblHakkoUmu) {
        this.getKensakujyokenHissu().setCblHakkoUmu(cblHakkoUmu);
    }

    @JsonIgnore
    public RadioButton getRadMinashiNigo() {
        return this.getKensakujyokenHissu().getRadMinashiNigo();
    }

    @JsonIgnore
    public void  setRadMinashiNigo(RadioButton radMinashiNigo) {
        this.getKensakujyokenHissu().setRadMinashiNigo(radMinashiNigo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikaNissu() {
        return this.getKensakujyokenHissu().getTxtKeikaNissu();
    }

    @JsonIgnore
    public void  setTxtKeikaNissu(TextBoxNum txtKeikaNissu) {
        this.getKensakujyokenHissu().setTxtKeikaNissu(txtKeikaNissu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMikomiDate() {
        return this.getKensakujyokenNini().getTxtMikomiDate();
    }

    @JsonIgnore
    public void  setTxtMikomiDate(TextBoxDateRange txtMikomiDate) {
        this.getKensakujyokenNini().setTxtMikomiDate(txtMikomiDate);
    }

    @JsonIgnore
    public DropDownList getDdlEnkiRiyu() {
        return this.getKensakujyokenNini().getDdlEnkiRiyu();
    }

    @JsonIgnore
    public void  setDdlEnkiRiyu(DropDownList ddlEnkiRiyu) {
        this.getKensakujyokenNini().setDdlEnkiRiyu(ddlEnkiRiyu);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getKensakujyokenNini().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getKensakujyokenNini().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getKensakujyokenNini().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getKensakujyokenNini().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public CheckBoxList getCblNinteiChosa() {
        return this.getKensakujyokenNini().getCblNinteiChosa();
    }

    @JsonIgnore
    public void  setCblNinteiChosa(CheckBoxList cblNinteiChosa) {
        this.getKensakujyokenNini().setCblNinteiChosa(cblNinteiChosa);
    }

    @JsonIgnore
    public CheckBoxList getCblIkenshoJyuryo() {
        return this.getKensakujyokenNini().getCblIkenshoJyuryo();
    }

    @JsonIgnore
    public void  setCblIkenshoJyuryo(CheckBoxList cblIkenshoJyuryo) {
        this.getKensakujyokenNini().setCblIkenshoJyuryo(cblIkenshoJyuryo);
    }

    @JsonIgnore
    public CheckBoxList getCblIchijiHantei() {
        return this.getKensakujyokenNini().getCblIchijiHantei();
    }

    @JsonIgnore
    public void  setCblIchijiHantei(CheckBoxList cblIchijiHantei) {
        this.getKensakujyokenNini().setCblIchijiHantei(cblIchijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getCblShinsakaiWaritsuke() {
        return this.getKensakujyokenNini().getCblShinsakaiWaritsuke();
    }

    @JsonIgnore
    public void  setCblShinsakaiWaritsuke(CheckBoxList cblShinsakaiWaritsuke) {
        this.getKensakujyokenNini().setCblShinsakaiWaritsuke(cblShinsakaiWaritsuke);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getKensakujyokenNini().getCcdHokenshaList();
    }

    // </editor-fold>
}
