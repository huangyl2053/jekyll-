package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028;
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
 * panelDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelShobyoName")
    private panelShobyoNameDiv panelShobyoName;
    @JsonProperty("panelOshinTuyin")
    private panelOshinTuyinDiv panelOshinTuyin;
    @JsonProperty("panelJiryoutensu")
    private panelJiryoutensuDiv panelJiryoutensu;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelShobyoName
     * @return panelShobyoName
     */
    @JsonProperty("panelShobyoName")
    public panelShobyoNameDiv getPanelShobyoName() {
        return panelShobyoName;
    }

    /*
     * setpanelShobyoName
     * @param panelShobyoName panelShobyoName
     */
    @JsonProperty("panelShobyoName")
    public void setPanelShobyoName(panelShobyoNameDiv panelShobyoName) {
        this.panelShobyoName = panelShobyoName;
    }

    /*
     * getpanelOshinTuyin
     * @return panelOshinTuyin
     */
    @JsonProperty("panelOshinTuyin")
    public panelOshinTuyinDiv getPanelOshinTuyin() {
        return panelOshinTuyin;
    }

    /*
     * setpanelOshinTuyin
     * @param panelOshinTuyin panelOshinTuyin
     */
    @JsonProperty("panelOshinTuyin")
    public void setPanelOshinTuyin(panelOshinTuyinDiv panelOshinTuyin) {
        this.panelOshinTuyin = panelOshinTuyin;
    }

    /*
     * getpanelJiryoutensu
     * @return panelJiryoutensu
     */
    @JsonProperty("panelJiryoutensu")
    public panelJiryoutensuDiv getPanelJiryoutensu() {
        return panelJiryoutensu;
    }

    /*
     * setpanelJiryoutensu
     * @param panelJiryoutensu panelJiryoutensu
     */
    @JsonProperty("panelJiryoutensu")
    public void setPanelJiryoutensu(panelJiryoutensuDiv panelJiryoutensu) {
        this.panelJiryoutensu = panelJiryoutensu;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShoteiShikkanShobyoName1() {
        return this.getPanelShobyoName().getTxtShoteiShikkanShobyoName1();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoName1(TextBox txtShoteiShikkanShobyoName1) {
        this.getPanelShobyoName().setTxtShoteiShikkanShobyoName1(txtShoteiShikkanShobyoName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoteiShikkanShobyoKaishiYMD1() {
        return this.getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD1();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoKaishiYMD1(TextBoxDate txtShoteiShikkanShobyoKaishiYMD1) {
        this.getPanelShobyoName().setTxtShoteiShikkanShobyoKaishiYMD1(txtShoteiShikkanShobyoKaishiYMD1);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName1() {
        return this.getPanelShobyoName().getTxtKinkyuShobyoName1();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName1(TextBox txtKinkyuShobyoName1) {
        this.getPanelShobyoName().setTxtKinkyuShobyoName1(txtKinkyuShobyoName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuChiryoKaishiYMD1() {
        return this.getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD1();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKaishiYMD1(TextBoxDate txtKinkyuChiryoKaishiYMD1) {
        this.getPanelShobyoName().setTxtKinkyuChiryoKaishiYMD1(txtKinkyuChiryoKaishiYMD1);
    }

    @JsonIgnore
    public TextBox getTxtShoteiShikkanShobyoName2() {
        return this.getPanelShobyoName().getTxtShoteiShikkanShobyoName2();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoName2(TextBox txtShoteiShikkanShobyoName2) {
        this.getPanelShobyoName().setTxtShoteiShikkanShobyoName2(txtShoteiShikkanShobyoName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoteiShikkanShobyoKaishiYMD2() {
        return this.getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD2();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoKaishiYMD2(TextBoxDate txtShoteiShikkanShobyoKaishiYMD2) {
        this.getPanelShobyoName().setTxtShoteiShikkanShobyoKaishiYMD2(txtShoteiShikkanShobyoKaishiYMD2);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName2() {
        return this.getPanelShobyoName().getTxtKinkyuShobyoName2();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName2(TextBox txtKinkyuShobyoName2) {
        this.getPanelShobyoName().setTxtKinkyuShobyoName2(txtKinkyuShobyoName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuChiryoKaishiYMD2() {
        return this.getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD2();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKaishiYMD2(TextBoxDate txtKinkyuChiryoKaishiYMD2) {
        this.getPanelShobyoName().setTxtKinkyuChiryoKaishiYMD2(txtKinkyuChiryoKaishiYMD2);
    }

    @JsonIgnore
    public TextBox getTxtShoteiShikkanShobyoName3() {
        return this.getPanelShobyoName().getTxtShoteiShikkanShobyoName3();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoName3(TextBox txtShoteiShikkanShobyoName3) {
        this.getPanelShobyoName().setTxtShoteiShikkanShobyoName3(txtShoteiShikkanShobyoName3);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoteiShikkanShobyoKaishiYMD3() {
        return this.getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD3();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoKaishiYMD3(TextBoxDate txtShoteiShikkanShobyoKaishiYMD3) {
        this.getPanelShobyoName().setTxtShoteiShikkanShobyoKaishiYMD3(txtShoteiShikkanShobyoKaishiYMD3);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName3() {
        return this.getPanelShobyoName().getTxtKinkyuShobyoName3();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName3(TextBox txtKinkyuShobyoName3) {
        this.getPanelShobyoName().setTxtKinkyuShobyoName3(txtKinkyuShobyoName3);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuChiryoKaishiYMD3() {
        return this.getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD3();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKaishiYMD3(TextBoxDate txtKinkyuChiryoKaishiYMD3) {
        this.getPanelShobyoName().setTxtKinkyuChiryoKaishiYMD3(txtKinkyuChiryoKaishiYMD3);
    }

    @JsonIgnore
    public Label getLblOshin() {
        return this.getPanelOshinTuyin().getLblOshin();
    }

    @JsonIgnore
    public void  setLblOshin(Label lblOshin) {
        this.getPanelOshinTuyin().setLblOshin(lblOshin);
    }

    @JsonIgnore
    public TextBoxNum getTxtOshinNissu() {
        return this.getPanelOshinTuyin().getTxtOshinNissu();
    }

    @JsonIgnore
    public void  setTxtOshinNissu(TextBoxNum txtOshinNissu) {
        this.getPanelOshinTuyin().setTxtOshinNissu(txtOshinNissu);
    }

    @JsonIgnore
    public TextBox getTxtOshinIryoKikanName() {
        return this.getPanelOshinTuyin().getTxtOshinIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtOshinIryoKikanName(TextBox txtOshinIryoKikanName) {
        this.getPanelOshinTuyin().setTxtOshinIryoKikanName(txtOshinIryoKikanName);
    }

    @JsonIgnore
    public Label getLblTsuin() {
        return this.getPanelOshinTuyin().getLblTsuin();
    }

    @JsonIgnore
    public void  setLblTsuin(Label lblTsuin) {
        this.getPanelOshinTuyin().setLblTsuin(lblTsuin);
    }

    @JsonIgnore
    public TextBoxNum getTxtTsuyinNissu() {
        return this.getPanelOshinTuyin().getTxtTsuyinNissu();
    }

    @JsonIgnore
    public void  setTxtTsuyinNissu(TextBoxNum txtTsuyinNissu) {
        this.getPanelOshinTuyin().setTxtTsuyinNissu(txtTsuyinNissu);
    }

    @JsonIgnore
    public TextBox getTxtTsuinKikanName() {
        return this.getPanelOshinTuyin().getTxtTsuinKikanName();
    }

    @JsonIgnore
    public void  setTxtTsuinKikanName(TextBox txtTsuinKikanName) {
        this.getPanelOshinTuyin().setTxtTsuinKikanName(txtTsuinKikanName);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTekiyou() {
        return this.getPanelOshinTuyin().getTxtTekiyou();
    }

    @JsonIgnore
    public void  setTxtTekiyou(TextBoxMultiLine txtTekiyou) {
        this.getPanelOshinTuyin().setTxtTekiyou(txtTekiyou);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoteiShikkanTanisu() {
        return this.getPanelJiryoutensu().getTxtShoteiShikkanTanisu();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanTanisu(TextBoxNum txtShoteiShikkanTanisu) {
        this.getPanelJiryoutensu().setTxtShoteiShikkanTanisu(txtShoteiShikkanTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoteiShikkanNissu() {
        return this.getPanelJiryoutensu().getTxtShoteiShikkanNissu();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanNissu(TextBoxNum txtShoteiShikkanNissu) {
        this.getPanelJiryoutensu().setTxtShoteiShikkanNissu(txtShoteiShikkanNissu);
    }

    @JsonIgnore
    public Button getBtnCal1() {
        return this.getPanelJiryoutensu().getBtnCal1();
    }

    @JsonIgnore
    public void  setBtnCal1(Button btnCal1) {
        this.getPanelJiryoutensu().setBtnCal1(btnCal1);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoteiShikkanSubTotal() {
        return this.getPanelJiryoutensu().getTxtShoteiShikkanSubTotal();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanSubTotal(TextBoxNum txtShoteiShikkanSubTotal) {
        this.getPanelJiryoutensu().setTxtShoteiShikkanSubTotal(txtShoteiShikkanSubTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuChiryoKanriTanisu() {
        return this.getPanelJiryoutensu().getTxtKinkyuChiryoKanriTanisu();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKanriTanisu(TextBoxNum txtKinkyuChiryoKanriTanisu) {
        this.getPanelJiryoutensu().setTxtKinkyuChiryoKanriTanisu(txtKinkyuChiryoKanriTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuChiryoKanriNissu() {
        return this.getPanelJiryoutensu().getTxtKinkyuChiryoKanriNissu();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKanriNissu(TextBoxNum txtKinkyuChiryoKanriNissu) {
        this.getPanelJiryoutensu().setTxtKinkyuChiryoKanriNissu(txtKinkyuChiryoKanriNissu);
    }

    @JsonIgnore
    public Button getBtnCal2() {
        return this.getPanelJiryoutensu().getBtnCal2();
    }

    @JsonIgnore
    public void  setBtnCal2(Button btnCal2) {
        this.getPanelJiryoutensu().setBtnCal2(btnCal2);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuChiryoKanriSubTotal() {
        return this.getPanelJiryoutensu().getTxtKinkyuChiryoKanriSubTotal();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKanriSubTotal(TextBoxNum txtKinkyuChiryoKanriSubTotal) {
        this.getPanelJiryoutensu().setTxtKinkyuChiryoKanriSubTotal(txtKinkyuChiryoKanriSubTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtRehabilitationTanisu() {
        return this.getPanelJiryoutensu().getTxtRehabilitationTanisu();
    }

    @JsonIgnore
    public void  setTxtRehabilitationTanisu(TextBoxNum txtRehabilitationTanisu) {
        this.getPanelJiryoutensu().setTxtRehabilitationTanisu(txtRehabilitationTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShujutsuTanisu() {
        return this.getPanelJiryoutensu().getTxtShujutsuTanisu();
    }

    @JsonIgnore
    public void  setTxtShujutsuTanisu(TextBoxNum txtShujutsuTanisu) {
        this.getPanelJiryoutensu().setTxtShujutsuTanisu(txtShujutsuTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshasenChiryoTanisu() {
        return this.getPanelJiryoutensu().getTxtHoshasenChiryoTanisu();
    }

    @JsonIgnore
    public void  setTxtHoshasenChiryoTanisu(TextBoxNum txtHoshasenChiryoTanisu) {
        this.getPanelJiryoutensu().setTxtHoshasenChiryoTanisu(txtHoshasenChiryoTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShochiTanisu() {
        return this.getPanelJiryoutensu().getTxtShochiTanisu();
    }

    @JsonIgnore
    public void  setTxtShochiTanisu(TextBoxNum txtShochiTanisu) {
        this.getPanelJiryoutensu().setTxtShochiTanisu(txtShochiTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMasuiTanisu() {
        return this.getPanelJiryoutensu().getTxtMasuiTanisu();
    }

    @JsonIgnore
    public void  setTxtMasuiTanisu(TextBoxNum txtMasuiTanisu) {
        this.getPanelJiryoutensu().setTxtMasuiTanisu(txtMasuiTanisu);
    }

    @JsonIgnore
    public Button getBtnCal3() {
        return this.getPanelJiryoutensu().getBtnCal3();
    }

    @JsonIgnore
    public void  setBtnCal3(Button btnCal3) {
        this.getPanelJiryoutensu().setBtnCal3(btnCal3);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuteiJiryoGoukei() {
        return this.getPanelJiryoutensu().getTxtTokuteiJiryoGoukei();
    }

    @JsonIgnore
    public void  setTxtTokuteiJiryoGoukei(TextBoxNum txtTokuteiJiryoGoukei) {
        this.getPanelJiryoutensu().setTxtTokuteiJiryoGoukei(txtTokuteiJiryoGoukei);
    }

    // </editor-fold>
}
