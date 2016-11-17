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
 * panelKinkyujiShiseturyoyoDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKinkyujiShiseturyoyoDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelShobyoName")
    private panelShobyoNameDiv panelShobyoName;
    @JsonProperty("panelOshinTsuyin")
    private panelOshinTsuyinDiv panelOshinTsuyin;
    @JsonProperty("panelJiryoTensuu")
    private panelJiryoTensuuDiv panelJiryoTensuu;
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
     * getpanelOshinTsuyin
     * @return panelOshinTsuyin
     */
    @JsonProperty("panelOshinTsuyin")
    public panelOshinTsuyinDiv getPanelOshinTsuyin() {
        return panelOshinTsuyin;
    }

    /*
     * setpanelOshinTsuyin
     * @param panelOshinTsuyin panelOshinTsuyin
     */
    @JsonProperty("panelOshinTsuyin")
    public void setPanelOshinTsuyin(panelOshinTsuyinDiv panelOshinTsuyin) {
        this.panelOshinTsuyin = panelOshinTsuyin;
    }

    /*
     * getpanelJiryoTensuu
     * @return panelJiryoTensuu
     */
    @JsonProperty("panelJiryoTensuu")
    public panelJiryoTensuuDiv getPanelJiryoTensuu() {
        return panelJiryoTensuu;
    }

    /*
     * setpanelJiryoTensuu
     * @param panelJiryoTensuu panelJiryoTensuu
     */
    @JsonProperty("panelJiryoTensuu")
    public void setPanelJiryoTensuu(panelJiryoTensuuDiv panelJiryoTensuu) {
        this.panelJiryoTensuu = panelJiryoTensuu;
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
    public TextBox getTxtKinkyuShobyoName1() {
        return this.getPanelShobyoName().getTxtKinkyuShobyoName1();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName1(TextBox txtKinkyuShobyoName1) {
        this.getPanelShobyoName().setTxtKinkyuShobyoName1(txtKinkyuShobyoName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuJiryoStartYMD1() {
        return this.getPanelShobyoName().getTxtKinkyuJiryoStartYMD1();
    }

    @JsonIgnore
    public void  setTxtKinkyuJiryoStartYMD1(TextBoxDate txtKinkyuJiryoStartYMD1) {
        this.getPanelShobyoName().setTxtKinkyuJiryoStartYMD1(txtKinkyuJiryoStartYMD1);
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
    public TextBoxDate getTxtKinkyuJiryoStartYMD2() {
        return this.getPanelShobyoName().getTxtKinkyuJiryoStartYMD2();
    }

    @JsonIgnore
    public void  setTxtKinkyuJiryoStartYMD2(TextBoxDate txtKinkyuJiryoStartYMD2) {
        this.getPanelShobyoName().setTxtKinkyuJiryoStartYMD2(txtKinkyuJiryoStartYMD2);
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
    public TextBoxDate getTxtKinkyuJiryoStartYMD3() {
        return this.getPanelShobyoName().getTxtKinkyuJiryoStartYMD3();
    }

    @JsonIgnore
    public void  setTxtKinkyuJiryoStartYMD3(TextBoxDate txtKinkyuJiryoStartYMD3) {
        this.getPanelShobyoName().setTxtKinkyuJiryoStartYMD3(txtKinkyuJiryoStartYMD3);
    }

    @JsonIgnore
    public Label getLblOshin() {
        return this.getPanelOshinTsuyin().getLblOshin();
    }

    @JsonIgnore
    public void  setLblOshin(Label lblOshin) {
        this.getPanelOshinTsuyin().setLblOshin(lblOshin);
    }

    @JsonIgnore
    public TextBoxNum getTxtOshinNissu() {
        return this.getPanelOshinTsuyin().getTxtOshinNissu();
    }

    @JsonIgnore
    public void  setTxtOshinNissu(TextBoxNum txtOshinNissu) {
        this.getPanelOshinTsuyin().setTxtOshinNissu(txtOshinNissu);
    }

    @JsonIgnore
    public TextBox getTxtOshinYiryokikanName() {
        return this.getPanelOshinTsuyin().getTxtOshinYiryokikanName();
    }

    @JsonIgnore
    public void  setTxtOshinYiryokikanName(TextBox txtOshinYiryokikanName) {
        this.getPanelOshinTsuyin().setTxtOshinYiryokikanName(txtOshinYiryokikanName);
    }

    @JsonIgnore
    public Label getLblTuyin() {
        return this.getPanelOshinTsuyin().getLblTuyin();
    }

    @JsonIgnore
    public void  setLblTuyin(Label lblTuyin) {
        this.getPanelOshinTsuyin().setLblTuyin(lblTuyin);
    }

    @JsonIgnore
    public TextBoxNum getTxtTuyinNissu() {
        return this.getPanelOshinTsuyin().getTxtTuyinNissu();
    }

    @JsonIgnore
    public void  setTxtTuyinNissu(TextBoxNum txtTuyinNissu) {
        this.getPanelOshinTsuyin().setTxtTuyinNissu(txtTuyinNissu);
    }

    @JsonIgnore
    public TextBox getTxtTuyinYiryokikanName() {
        return this.getPanelOshinTsuyin().getTxtTuyinYiryokikanName();
    }

    @JsonIgnore
    public void  setTxtTuyinYiryokikanName(TextBox txtTuyinYiryokikanName) {
        this.getPanelOshinTsuyin().setTxtTuyinYiryokikanName(txtTuyinYiryokikanName);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTikiyo() {
        return this.getPanelOshinTsuyin().getTxtTikiyo();
    }

    @JsonIgnore
    public void  setTxtTikiyo(TextBoxMultiLine txtTikiyo) {
        this.getPanelOshinTsuyin().setTxtTikiyo(txtTikiyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtkinkyuChiryoKanriTanisu() {
        return this.getPanelJiryoTensuu().getTxtkinkyuChiryoKanriTanisu();
    }

    @JsonIgnore
    public void  setTxtkinkyuChiryoKanriTanisu(TextBoxNum txtkinkyuChiryoKanriTanisu) {
        this.getPanelJiryoTensuu().setTxtkinkyuChiryoKanriTanisu(txtkinkyuChiryoKanriTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtkinkyuChiryoKanriNissu() {
        return this.getPanelJiryoTensuu().getTxtkinkyuChiryoKanriNissu();
    }

    @JsonIgnore
    public void  setTxtkinkyuChiryoKanriNissu(TextBoxNum txtkinkyuChiryoKanriNissu) {
        this.getPanelJiryoTensuu().setTxtkinkyuChiryoKanriNissu(txtkinkyuChiryoKanriNissu);
    }

    @JsonIgnore
    public Button getBtnKeisan() {
        return this.getPanelJiryoTensuu().getBtnKeisan();
    }

    @JsonIgnore
    public void  setBtnKeisan(Button btnKeisan) {
        this.getPanelJiryoTensuu().setBtnKeisan(btnKeisan);
    }

    @JsonIgnore
    public TextBoxNum getTxtkinkyuChiryoKanriSubTotal() {
        return this.getPanelJiryoTensuu().getTxtkinkyuChiryoKanriSubTotal();
    }

    @JsonIgnore
    public void  setTxtkinkyuChiryoKanriSubTotal(TextBoxNum txtkinkyuChiryoKanriSubTotal) {
        this.getPanelJiryoTensuu().setTxtkinkyuChiryoKanriSubTotal(txtkinkyuChiryoKanriSubTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtrehabilitationTanisu() {
        return this.getPanelJiryoTensuu().getTxtrehabilitationTanisu();
    }

    @JsonIgnore
    public void  setTxtrehabilitationTanisu(TextBoxNum txtrehabilitationTanisu) {
        this.getPanelJiryoTensuu().setTxtrehabilitationTanisu(txtrehabilitationTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtshujutsuTanisu() {
        return this.getPanelJiryoTensuu().getTxtshujutsuTanisu();
    }

    @JsonIgnore
    public void  setTxtshujutsuTanisu(TextBoxNum txtshujutsuTanisu) {
        this.getPanelJiryoTensuu().setTxtshujutsuTanisu(txtshujutsuTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshasenChiryoTanisu() {
        return this.getPanelJiryoTensuu().getTxtHoshasenChiryoTanisu();
    }

    @JsonIgnore
    public void  setTxtHoshasenChiryoTanisu(TextBoxNum txtHoshasenChiryoTanisu) {
        this.getPanelJiryoTensuu().setTxtHoshasenChiryoTanisu(txtHoshasenChiryoTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShochiTanisu() {
        return this.getPanelJiryoTensuu().getTxtShochiTanisu();
    }

    @JsonIgnore
    public void  setTxtShochiTanisu(TextBoxNum txtShochiTanisu) {
        this.getPanelJiryoTensuu().setTxtShochiTanisu(txtShochiTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMasuiTanisu() {
        return this.getPanelJiryoTensuu().getTxtMasuiTanisu();
    }

    @JsonIgnore
    public void  setTxtMasuiTanisu(TextBoxNum txtMasuiTanisu) {
        this.getPanelJiryoTensuu().setTxtMasuiTanisu(txtMasuiTanisu);
    }

    @JsonIgnore
    public Button getBtnCal() {
        return this.getPanelJiryoTensuu().getBtnCal();
    }

    @JsonIgnore
    public void  setBtnCal(Button btnCal) {
        this.getPanelJiryoTensuu().setBtnCal(btnCal);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuShisetsuRyoyohiTotalTanisu() {
        return this.getPanelJiryoTensuu().getTxtKinkyuShisetsuRyoyohiTotalTanisu();
    }

    @JsonIgnore
    public void  setTxtKinkyuShisetsuRyoyohiTotalTanisu(TextBoxNum txtKinkyuShisetsuRyoyohiTotalTanisu) {
        this.getPanelJiryoTensuu().setTxtKinkyuShisetsuRyoyohiTotalTanisu(txtKinkyuShisetsuRyoyohiTotalTanisu);
    }

    // </editor-fold>
}
