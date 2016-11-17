package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027;
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
 * panelKinkyujiShisetuRyoyohi のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKinkyujiShisetuRyoyohiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgdKinkyujiShiseturyoyo")
    private DataGrid<dgdKinkyujiShiseturyoyo_Row> dgdKinkyujiShiseturyoyo;
    @JsonProperty("panelKinkyujiShiseturyoyoDetail")
    private panelKinkyujiShiseturyoyoDetailDiv panelKinkyujiShiseturyoyoDetail;

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
     * getdgdKinkyujiShiseturyoyo
     * @return dgdKinkyujiShiseturyoyo
     */
    @JsonProperty("dgdKinkyujiShiseturyoyo")
    public DataGrid<dgdKinkyujiShiseturyoyo_Row> getDgdKinkyujiShiseturyoyo() {
        return dgdKinkyujiShiseturyoyo;
    }

    /*
     * setdgdKinkyujiShiseturyoyo
     * @param dgdKinkyujiShiseturyoyo dgdKinkyujiShiseturyoyo
     */
    @JsonProperty("dgdKinkyujiShiseturyoyo")
    public void setDgdKinkyujiShiseturyoyo(DataGrid<dgdKinkyujiShiseturyoyo_Row> dgdKinkyujiShiseturyoyo) {
        this.dgdKinkyujiShiseturyoyo = dgdKinkyujiShiseturyoyo;
    }

    /*
     * getpanelKinkyujiShiseturyoyoDetail
     * @return panelKinkyujiShiseturyoyoDetail
     */
    @JsonProperty("panelKinkyujiShiseturyoyoDetail")
    public panelKinkyujiShiseturyoyoDetailDiv getPanelKinkyujiShiseturyoyoDetail() {
        return panelKinkyujiShiseturyoyoDetail;
    }

    /*
     * setpanelKinkyujiShiseturyoyoDetail
     * @param panelKinkyujiShiseturyoyoDetail panelKinkyujiShiseturyoyoDetail
     */
    @JsonProperty("panelKinkyujiShiseturyoyoDetail")
    public void setPanelKinkyujiShiseturyoyoDetail(panelKinkyujiShiseturyoyoDetailDiv panelKinkyujiShiseturyoyoDetail) {
        this.panelKinkyujiShiseturyoyoDetail = panelKinkyujiShiseturyoyoDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public panelShobyoNameDiv getPanelShobyoName() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName();
    }

    @JsonIgnore
    public void  setPanelShobyoName(panelShobyoNameDiv panelShobyoName) {
        this.getPanelKinkyujiShiseturyoyoDetail().setPanelShobyoName(panelShobyoName);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName1() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuShobyoName1();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName1(TextBox txtKinkyuShobyoName1) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuShobyoName1(txtKinkyuShobyoName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuJiryoStartYMD1() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuJiryoStartYMD1();
    }

    @JsonIgnore
    public void  setTxtKinkyuJiryoStartYMD1(TextBoxDate txtKinkyuJiryoStartYMD1) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuJiryoStartYMD1(txtKinkyuJiryoStartYMD1);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName2() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuShobyoName2();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName2(TextBox txtKinkyuShobyoName2) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuShobyoName2(txtKinkyuShobyoName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuJiryoStartYMD2() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuJiryoStartYMD2();
    }

    @JsonIgnore
    public void  setTxtKinkyuJiryoStartYMD2(TextBoxDate txtKinkyuJiryoStartYMD2) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuJiryoStartYMD2(txtKinkyuJiryoStartYMD2);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName3() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuShobyoName3();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName3(TextBox txtKinkyuShobyoName3) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuShobyoName3(txtKinkyuShobyoName3);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuJiryoStartYMD3() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuJiryoStartYMD3();
    }

    @JsonIgnore
    public void  setTxtKinkyuJiryoStartYMD3(TextBoxDate txtKinkyuJiryoStartYMD3) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuJiryoStartYMD3(txtKinkyuJiryoStartYMD3);
    }

    @JsonIgnore
    public panelOshinTsuyinDiv getPanelOshinTsuyin() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin();
    }

    @JsonIgnore
    public void  setPanelOshinTsuyin(panelOshinTsuyinDiv panelOshinTsuyin) {
        this.getPanelKinkyujiShiseturyoyoDetail().setPanelOshinTsuyin(panelOshinTsuyin);
    }

    @JsonIgnore
    public Label getLblOshin() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getLblOshin();
    }

    @JsonIgnore
    public void  setLblOshin(Label lblOshin) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setLblOshin(lblOshin);
    }

    @JsonIgnore
    public TextBoxNum getTxtOshinNissu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtOshinNissu();
    }

    @JsonIgnore
    public void  setTxtOshinNissu(TextBoxNum txtOshinNissu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtOshinNissu(txtOshinNissu);
    }

    @JsonIgnore
    public TextBox getTxtOshinYiryokikanName() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtOshinYiryokikanName();
    }

    @JsonIgnore
    public void  setTxtOshinYiryokikanName(TextBox txtOshinYiryokikanName) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtOshinYiryokikanName(txtOshinYiryokikanName);
    }

    @JsonIgnore
    public Label getLblTuyin() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getLblTuyin();
    }

    @JsonIgnore
    public void  setLblTuyin(Label lblTuyin) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setLblTuyin(lblTuyin);
    }

    @JsonIgnore
    public TextBoxNum getTxtTuyinNissu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtTuyinNissu();
    }

    @JsonIgnore
    public void  setTxtTuyinNissu(TextBoxNum txtTuyinNissu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtTuyinNissu(txtTuyinNissu);
    }

    @JsonIgnore
    public TextBox getTxtTuyinYiryokikanName() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtTuyinYiryokikanName();
    }

    @JsonIgnore
    public void  setTxtTuyinYiryokikanName(TextBox txtTuyinYiryokikanName) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtTuyinYiryokikanName(txtTuyinYiryokikanName);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTikiyo() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtTikiyo();
    }

    @JsonIgnore
    public void  setTxtTikiyo(TextBoxMultiLine txtTikiyo) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtTikiyo(txtTikiyo);
    }

    @JsonIgnore
    public panelJiryoTensuuDiv getPanelJiryoTensuu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu();
    }

    @JsonIgnore
    public void  setPanelJiryoTensuu(panelJiryoTensuuDiv panelJiryoTensuu) {
        this.getPanelKinkyujiShiseturyoyoDetail().setPanelJiryoTensuu(panelJiryoTensuu);
    }

    @JsonIgnore
    public TextBoxNum getTxtkinkyuChiryoKanriTanisu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtkinkyuChiryoKanriTanisu();
    }

    @JsonIgnore
    public void  setTxtkinkyuChiryoKanriTanisu(TextBoxNum txtkinkyuChiryoKanriTanisu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtkinkyuChiryoKanriTanisu(txtkinkyuChiryoKanriTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtkinkyuChiryoKanriNissu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtkinkyuChiryoKanriNissu();
    }

    @JsonIgnore
    public void  setTxtkinkyuChiryoKanriNissu(TextBoxNum txtkinkyuChiryoKanriNissu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtkinkyuChiryoKanriNissu(txtkinkyuChiryoKanriNissu);
    }

    @JsonIgnore
    public Button getBtnKeisan() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getBtnKeisan();
    }

    @JsonIgnore
    public void  setBtnKeisan(Button btnKeisan) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setBtnKeisan(btnKeisan);
    }

    @JsonIgnore
    public TextBoxNum getTxtkinkyuChiryoKanriSubTotal() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtkinkyuChiryoKanriSubTotal();
    }

    @JsonIgnore
    public void  setTxtkinkyuChiryoKanriSubTotal(TextBoxNum txtkinkyuChiryoKanriSubTotal) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtkinkyuChiryoKanriSubTotal(txtkinkyuChiryoKanriSubTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtrehabilitationTanisu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtrehabilitationTanisu();
    }

    @JsonIgnore
    public void  setTxtrehabilitationTanisu(TextBoxNum txtrehabilitationTanisu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtrehabilitationTanisu(txtrehabilitationTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtshujutsuTanisu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtshujutsuTanisu();
    }

    @JsonIgnore
    public void  setTxtshujutsuTanisu(TextBoxNum txtshujutsuTanisu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtshujutsuTanisu(txtshujutsuTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshasenChiryoTanisu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtHoshasenChiryoTanisu();
    }

    @JsonIgnore
    public void  setTxtHoshasenChiryoTanisu(TextBoxNum txtHoshasenChiryoTanisu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtHoshasenChiryoTanisu(txtHoshasenChiryoTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShochiTanisu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtShochiTanisu();
    }

    @JsonIgnore
    public void  setTxtShochiTanisu(TextBoxNum txtShochiTanisu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtShochiTanisu(txtShochiTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMasuiTanisu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtMasuiTanisu();
    }

    @JsonIgnore
    public void  setTxtMasuiTanisu(TextBoxNum txtMasuiTanisu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtMasuiTanisu(txtMasuiTanisu);
    }

    @JsonIgnore
    public Button getBtnCal() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getBtnCal();
    }

    @JsonIgnore
    public void  setBtnCal(Button btnCal) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setBtnCal(btnCal);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuShisetsuRyoyohiTotalTanisu() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtKinkyuShisetsuRyoyohiTotalTanisu();
    }

    @JsonIgnore
    public void  setTxtKinkyuShisetsuRyoyohiTotalTanisu(TextBoxNum txtKinkyuShisetsuRyoyohiTotalTanisu) {
        this.getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtKinkyuShisetsuRyoyohiTotalTanisu(txtKinkyuShisetsuRyoyohiTotalTanisu);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getPanelKinkyujiShiseturyoyoDetail().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelKinkyujiShiseturyoyoDetail().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPanelKinkyujiShiseturyoyoDetail().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPanelKinkyujiShiseturyoyoDetail().setBtnClear(btnClear);
    }

    // </editor-fold>
}
