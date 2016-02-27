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
 * panelKinkyujiShoteishikkan のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKinkyujiShoteishikkanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgdKinkyujiShoteiList")
    private DataGrid<dgdKinkyujiShoteiList_Row> dgdKinkyujiShoteiList;
    @JsonProperty("panelDetail")
    private panelDetailDiv panelDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgdKinkyujiShoteiList
     * @return dgdKinkyujiShoteiList
     */
    @JsonProperty("dgdKinkyujiShoteiList")
    public DataGrid<dgdKinkyujiShoteiList_Row> getDgdKinkyujiShoteiList() {
        return dgdKinkyujiShoteiList;
    }

    /*
     * setdgdKinkyujiShoteiList
     * @param dgdKinkyujiShoteiList dgdKinkyujiShoteiList
     */
    @JsonProperty("dgdKinkyujiShoteiList")
    public void setDgdKinkyujiShoteiList(DataGrid<dgdKinkyujiShoteiList_Row> dgdKinkyujiShoteiList) {
        this.dgdKinkyujiShoteiList = dgdKinkyujiShoteiList;
    }

    /*
     * getpanelDetail
     * @return panelDetail
     */
    @JsonProperty("panelDetail")
    public panelDetailDiv getPanelDetail() {
        return panelDetail;
    }

    /*
     * setpanelDetail
     * @param panelDetail panelDetail
     */
    @JsonProperty("panelDetail")
    public void setPanelDetail(panelDetailDiv panelDetail) {
        this.panelDetail = panelDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public panelShobyoNameDiv getPanelShobyoName() {
        return this.getPanelDetail().getPanelShobyoName();
    }

    @JsonIgnore
    public void  setPanelShobyoName(panelShobyoNameDiv panelShobyoName) {
        this.getPanelDetail().setPanelShobyoName(panelShobyoName);
    }

    @JsonIgnore
    public TextBox getTxtShoteiShikkanShobyoName1() {
        return this.getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoName1();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoName1(TextBox txtShoteiShikkanShobyoName1) {
        this.getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoName1(txtShoteiShikkanShobyoName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoteiShikkanShobyoKaishiYMD1() {
        return this.getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD1();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoKaishiYMD1(TextBoxDate txtShoteiShikkanShobyoKaishiYMD1) {
        this.getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoKaishiYMD1(txtShoteiShikkanShobyoKaishiYMD1);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName1() {
        return this.getPanelDetail().getPanelShobyoName().getTxtKinkyuShobyoName1();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName1(TextBox txtKinkyuShobyoName1) {
        this.getPanelDetail().getPanelShobyoName().setTxtKinkyuShobyoName1(txtKinkyuShobyoName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuChiryoKaishiYMD1() {
        return this.getPanelDetail().getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD1();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKaishiYMD1(TextBoxDate txtKinkyuChiryoKaishiYMD1) {
        this.getPanelDetail().getPanelShobyoName().setTxtKinkyuChiryoKaishiYMD1(txtKinkyuChiryoKaishiYMD1);
    }

    @JsonIgnore
    public TextBox getTxtShoteiShikkanShobyoName2() {
        return this.getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoName2();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoName2(TextBox txtShoteiShikkanShobyoName2) {
        this.getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoName2(txtShoteiShikkanShobyoName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoteiShikkanShobyoKaishiYMD2() {
        return this.getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD2();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoKaishiYMD2(TextBoxDate txtShoteiShikkanShobyoKaishiYMD2) {
        this.getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoKaishiYMD2(txtShoteiShikkanShobyoKaishiYMD2);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName2() {
        return this.getPanelDetail().getPanelShobyoName().getTxtKinkyuShobyoName2();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName2(TextBox txtKinkyuShobyoName2) {
        this.getPanelDetail().getPanelShobyoName().setTxtKinkyuShobyoName2(txtKinkyuShobyoName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuChiryoKaishiYMD2() {
        return this.getPanelDetail().getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD2();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKaishiYMD2(TextBoxDate txtKinkyuChiryoKaishiYMD2) {
        this.getPanelDetail().getPanelShobyoName().setTxtKinkyuChiryoKaishiYMD2(txtKinkyuChiryoKaishiYMD2);
    }

    @JsonIgnore
    public TextBox getTxtShoteiShikkanShobyoName3() {
        return this.getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoName3();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoName3(TextBox txtShoteiShikkanShobyoName3) {
        this.getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoName3(txtShoteiShikkanShobyoName3);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoteiShikkanShobyoKaishiYMD3() {
        return this.getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD3();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoKaishiYMD3(TextBoxDate txtShoteiShikkanShobyoKaishiYMD3) {
        this.getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoKaishiYMD3(txtShoteiShikkanShobyoKaishiYMD3);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName3() {
        return this.getPanelDetail().getPanelShobyoName().getTxtKinkyuShobyoName3();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName3(TextBox txtKinkyuShobyoName3) {
        this.getPanelDetail().getPanelShobyoName().setTxtKinkyuShobyoName3(txtKinkyuShobyoName3);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuChiryoKaishiYMD3() {
        return this.getPanelDetail().getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD3();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKaishiYMD3(TextBoxDate txtKinkyuChiryoKaishiYMD3) {
        this.getPanelDetail().getPanelShobyoName().setTxtKinkyuChiryoKaishiYMD3(txtKinkyuChiryoKaishiYMD3);
    }

    @JsonIgnore
    public panelOshinTuyinDiv getPanelOshinTuyin() {
        return this.getPanelDetail().getPanelOshinTuyin();
    }

    @JsonIgnore
    public void  setPanelOshinTuyin(panelOshinTuyinDiv panelOshinTuyin) {
        this.getPanelDetail().setPanelOshinTuyin(panelOshinTuyin);
    }

    @JsonIgnore
    public Label getLblOshin() {
        return this.getPanelDetail().getPanelOshinTuyin().getLblOshin();
    }

    @JsonIgnore
    public void  setLblOshin(Label lblOshin) {
        this.getPanelDetail().getPanelOshinTuyin().setLblOshin(lblOshin);
    }

    @JsonIgnore
    public TextBoxNum getTxtOshinNissu() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtOshinNissu();
    }

    @JsonIgnore
    public void  setTxtOshinNissu(TextBoxNum txtOshinNissu) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtOshinNissu(txtOshinNissu);
    }

    @JsonIgnore
    public TextBox getTxtOshinIryoKikanName() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtOshinIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtOshinIryoKikanName(TextBox txtOshinIryoKikanName) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtOshinIryoKikanName(txtOshinIryoKikanName);
    }

    @JsonIgnore
    public Label getLblTsuin() {
        return this.getPanelDetail().getPanelOshinTuyin().getLblTsuin();
    }

    @JsonIgnore
    public void  setLblTsuin(Label lblTsuin) {
        this.getPanelDetail().getPanelOshinTuyin().setLblTsuin(lblTsuin);
    }

    @JsonIgnore
    public TextBoxNum getTxtTsuyinNissu() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtTsuyinNissu();
    }

    @JsonIgnore
    public void  setTxtTsuyinNissu(TextBoxNum txtTsuyinNissu) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtTsuyinNissu(txtTsuyinNissu);
    }

    @JsonIgnore
    public TextBox getTxtTsuinKikanName() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtTsuinKikanName();
    }

    @JsonIgnore
    public void  setTxtTsuinKikanName(TextBox txtTsuinKikanName) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtTsuinKikanName(txtTsuinKikanName);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTekiyou() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtTekiyou();
    }

    @JsonIgnore
    public void  setTxtTekiyou(TextBoxMultiLine txtTekiyou) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtTekiyou(txtTekiyou);
    }

    @JsonIgnore
    public panelJiryoutensuDiv getPanelJiryoutensu() {
        return this.getPanelDetail().getPanelJiryoutensu();
    }

    @JsonIgnore
    public void  setPanelJiryoutensu(panelJiryoutensuDiv panelJiryoutensu) {
        this.getPanelDetail().setPanelJiryoutensu(panelJiryoutensu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoteiShikkanTanisu() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtShoteiShikkanTanisu();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanTanisu(TextBoxNum txtShoteiShikkanTanisu) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtShoteiShikkanTanisu(txtShoteiShikkanTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoteiShikkanNissu() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtShoteiShikkanNissu();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanNissu(TextBoxNum txtShoteiShikkanNissu) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtShoteiShikkanNissu(txtShoteiShikkanNissu);
    }

    @JsonIgnore
    public Button getBtnCal1() {
        return this.getPanelDetail().getPanelJiryoutensu().getBtnCal1();
    }

    @JsonIgnore
    public void  setBtnCal1(Button btnCal1) {
        this.getPanelDetail().getPanelJiryoutensu().setBtnCal1(btnCal1);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoteiShikkanSubTotal() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtShoteiShikkanSubTotal();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanSubTotal(TextBoxNum txtShoteiShikkanSubTotal) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtShoteiShikkanSubTotal(txtShoteiShikkanSubTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuChiryoKanriTanisu() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtKinkyuChiryoKanriTanisu();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKanriTanisu(TextBoxNum txtKinkyuChiryoKanriTanisu) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtKinkyuChiryoKanriTanisu(txtKinkyuChiryoKanriTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuChiryoKanriNissu() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtKinkyuChiryoKanriNissu();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKanriNissu(TextBoxNum txtKinkyuChiryoKanriNissu) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtKinkyuChiryoKanriNissu(txtKinkyuChiryoKanriNissu);
    }

    @JsonIgnore
    public Button getBtnCal2() {
        return this.getPanelDetail().getPanelJiryoutensu().getBtnCal2();
    }

    @JsonIgnore
    public void  setBtnCal2(Button btnCal2) {
        this.getPanelDetail().getPanelJiryoutensu().setBtnCal2(btnCal2);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuChiryoKanriSubTotal() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtKinkyuChiryoKanriSubTotal();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKanriSubTotal(TextBoxNum txtKinkyuChiryoKanriSubTotal) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtKinkyuChiryoKanriSubTotal(txtKinkyuChiryoKanriSubTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtRehabilitationTanisu() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtRehabilitationTanisu();
    }

    @JsonIgnore
    public void  setTxtRehabilitationTanisu(TextBoxNum txtRehabilitationTanisu) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtRehabilitationTanisu(txtRehabilitationTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShujutsuTanisu() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtShujutsuTanisu();
    }

    @JsonIgnore
    public void  setTxtShujutsuTanisu(TextBoxNum txtShujutsuTanisu) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtShujutsuTanisu(txtShujutsuTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshasenChiryoTanisu() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtHoshasenChiryoTanisu();
    }

    @JsonIgnore
    public void  setTxtHoshasenChiryoTanisu(TextBoxNum txtHoshasenChiryoTanisu) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtHoshasenChiryoTanisu(txtHoshasenChiryoTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShochiTanisu() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtShochiTanisu();
    }

    @JsonIgnore
    public void  setTxtShochiTanisu(TextBoxNum txtShochiTanisu) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtShochiTanisu(txtShochiTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMasuiTanisu() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtMasuiTanisu();
    }

    @JsonIgnore
    public void  setTxtMasuiTanisu(TextBoxNum txtMasuiTanisu) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtMasuiTanisu(txtMasuiTanisu);
    }

    @JsonIgnore
    public Button getBtnCal3() {
        return this.getPanelDetail().getPanelJiryoutensu().getBtnCal3();
    }

    @JsonIgnore
    public void  setBtnCal3(Button btnCal3) {
        this.getPanelDetail().getPanelJiryoutensu().setBtnCal3(btnCal3);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuteiJiryoGoukei() {
        return this.getPanelDetail().getPanelJiryoutensu().getTxtTokuteiJiryoGoukei();
    }

    @JsonIgnore
    public void  setTxtTokuteiJiryoGoukei(TextBoxNum txtTokuteiJiryoGoukei) {
        this.getPanelDetail().getPanelJiryoutensu().setTxtTokuteiJiryoGoukei(txtTokuteiJiryoGoukei);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getPanelDetail().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getPanelDetail().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelDetail().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelDetail().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPanelDetail().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPanelDetail().setBtnClear(btnClear);
    }

    // </editor-fold>
}
