package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027;
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
 * KinkyujiShisetuRyoyohiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KinkyujiShisetuRyoyohiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelCcd")
    private panelCcdDiv panelCcd;
    @JsonProperty("panelHead")
    private panelHeadDiv panelHead;
    @JsonProperty("panelKinkyujiShisetuRyoyohi")
    private panelKinkyujiShisetuRyoyohiDiv panelKinkyujiShisetuRyoyohi;
    @JsonProperty("RowId")
    private RString RowId;
    @JsonProperty("hdnShomeishoKanryoFlag")
    private RString hdnShomeishoKanryoFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelCcd
     * @return panelCcd
     */
    @JsonProperty("panelCcd")
    public panelCcdDiv getPanelCcd() {
        return panelCcd;
    }

    /*
     * setpanelCcd
     * @param panelCcd panelCcd
     */
    @JsonProperty("panelCcd")
    public void setPanelCcd(panelCcdDiv panelCcd) {
        this.panelCcd = panelCcd;
    }

    /*
     * getpanelHead
     * @return panelHead
     */
    @JsonProperty("panelHead")
    public panelHeadDiv getPanelHead() {
        return panelHead;
    }

    /*
     * setpanelHead
     * @param panelHead panelHead
     */
    @JsonProperty("panelHead")
    public void setPanelHead(panelHeadDiv panelHead) {
        this.panelHead = panelHead;
    }

    /*
     * getpanelKinkyujiShisetuRyoyohi
     * @return panelKinkyujiShisetuRyoyohi
     */
    @JsonProperty("panelKinkyujiShisetuRyoyohi")
    public panelKinkyujiShisetuRyoyohiDiv getPanelKinkyujiShisetuRyoyohi() {
        return panelKinkyujiShisetuRyoyohi;
    }

    /*
     * setpanelKinkyujiShisetuRyoyohi
     * @param panelKinkyujiShisetuRyoyohi panelKinkyujiShisetuRyoyohi
     */
    @JsonProperty("panelKinkyujiShisetuRyoyohi")
    public void setPanelKinkyujiShisetuRyoyohi(panelKinkyujiShisetuRyoyohiDiv panelKinkyujiShisetuRyoyohi) {
        this.panelKinkyujiShisetuRyoyohi = panelKinkyujiShisetuRyoyohi;
    }

    /*
     * getRowId
     * @return RowId
     */
    @JsonProperty("RowId")
    public RString getRowId() {
        return RowId;
    }

    /*
     * setRowId
     * @param RowId RowId
     */
    @JsonProperty("RowId")
    public void setRowId(RString RowId) {
        this.RowId = RowId;
    }

    /*
     * gethdnShomeishoKanryoFlag
     * @return hdnShomeishoKanryoFlag
     */
    @JsonProperty("hdnShomeishoKanryoFlag")
    public RString getHdnShomeishoKanryoFlag() {
        return hdnShomeishoKanryoFlag;
    }

    /*
     * sethdnShomeishoKanryoFlag
     * @param hdnShomeishoKanryoFlag hdnShomeishoKanryoFlag
     */
    @JsonProperty("hdnShomeishoKanryoFlag")
    public void setHdnShomeishoKanryoFlag(RString hdnShomeishoKanryoFlag) {
        this.hdnShomeishoKanryoFlag = hdnShomeishoKanryoFlag;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getPanelKinkyujiShisetuRyoyohi().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getPanelKinkyujiShisetuRyoyohi().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgdKinkyujiShiseturyoyo_Row> getDgdKinkyujiShiseturyoyo() {
        return this.getPanelKinkyujiShisetuRyoyohi().getDgdKinkyujiShiseturyoyo();
    }

    @JsonIgnore
    public void  setDgdKinkyujiShiseturyoyo(DataGrid<dgdKinkyujiShiseturyoyo_Row> dgdKinkyujiShiseturyoyo) {
        this.getPanelKinkyujiShisetuRyoyohi().setDgdKinkyujiShiseturyoyo(dgdKinkyujiShiseturyoyo);
    }

    @JsonIgnore
    public panelKinkyujiShiseturyoyoDetailDiv getPanelKinkyujiShiseturyoyoDetail() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail();
    }

    @JsonIgnore
    public void  setPanelKinkyujiShiseturyoyoDetail(panelKinkyujiShiseturyoyoDetailDiv panelKinkyujiShiseturyoyoDetail) {
        this.getPanelKinkyujiShisetuRyoyohi().setPanelKinkyujiShiseturyoyoDetail(panelKinkyujiShiseturyoyoDetail);
    }

    @JsonIgnore
    public panelShobyoNameDiv getPanelShobyoName() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName();
    }

    @JsonIgnore
    public void  setPanelShobyoName(panelShobyoNameDiv panelShobyoName) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().setPanelShobyoName(panelShobyoName);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName1() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuShobyoName1();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName1(TextBox txtKinkyuShobyoName1) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuShobyoName1(txtKinkyuShobyoName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuJiryoStartYMD1() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuJiryoStartYMD1();
    }

    @JsonIgnore
    public void  setTxtKinkyuJiryoStartYMD1(TextBoxDate txtKinkyuJiryoStartYMD1) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuJiryoStartYMD1(txtKinkyuJiryoStartYMD1);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName2() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuShobyoName2();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName2(TextBox txtKinkyuShobyoName2) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuShobyoName2(txtKinkyuShobyoName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuJiryoStartYMD2() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuJiryoStartYMD2();
    }

    @JsonIgnore
    public void  setTxtKinkyuJiryoStartYMD2(TextBoxDate txtKinkyuJiryoStartYMD2) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuJiryoStartYMD2(txtKinkyuJiryoStartYMD2);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName3() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuShobyoName3();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName3(TextBox txtKinkyuShobyoName3) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuShobyoName3(txtKinkyuShobyoName3);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuJiryoStartYMD3() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().getTxtKinkyuJiryoStartYMD3();
    }

    @JsonIgnore
    public void  setTxtKinkyuJiryoStartYMD3(TextBoxDate txtKinkyuJiryoStartYMD3) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelShobyoName().setTxtKinkyuJiryoStartYMD3(txtKinkyuJiryoStartYMD3);
    }

    @JsonIgnore
    public panelOshinTsuyinDiv getPanelOshinTsuyin() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin();
    }

    @JsonIgnore
    public void  setPanelOshinTsuyin(panelOshinTsuyinDiv panelOshinTsuyin) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().setPanelOshinTsuyin(panelOshinTsuyin);
    }

    @JsonIgnore
    public Label getLblOshin() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getLblOshin();
    }

    @JsonIgnore
    public void  setLblOshin(Label lblOshin) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setLblOshin(lblOshin);
    }

    @JsonIgnore
    public TextBoxNum getTxtOshinNissu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtOshinNissu();
    }

    @JsonIgnore
    public void  setTxtOshinNissu(TextBoxNum txtOshinNissu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtOshinNissu(txtOshinNissu);
    }

    @JsonIgnore
    public TextBox getTxtOshinYiryokikanName() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtOshinYiryokikanName();
    }

    @JsonIgnore
    public void  setTxtOshinYiryokikanName(TextBox txtOshinYiryokikanName) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtOshinYiryokikanName(txtOshinYiryokikanName);
    }

    @JsonIgnore
    public Label getLblTuyin() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getLblTuyin();
    }

    @JsonIgnore
    public void  setLblTuyin(Label lblTuyin) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setLblTuyin(lblTuyin);
    }

    @JsonIgnore
    public TextBoxNum getTxtTuyinNissu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtTuyinNissu();
    }

    @JsonIgnore
    public void  setTxtTuyinNissu(TextBoxNum txtTuyinNissu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtTuyinNissu(txtTuyinNissu);
    }

    @JsonIgnore
    public TextBox getTxtTuyinYiryokikanName() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtTuyinYiryokikanName();
    }

    @JsonIgnore
    public void  setTxtTuyinYiryokikanName(TextBox txtTuyinYiryokikanName) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtTuyinYiryokikanName(txtTuyinYiryokikanName);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTikiyo() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().getTxtTikiyo();
    }

    @JsonIgnore
    public void  setTxtTikiyo(TextBoxMultiLine txtTikiyo) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelOshinTsuyin().setTxtTikiyo(txtTikiyo);
    }

    @JsonIgnore
    public panelJiryoTensuuDiv getPanelJiryoTensuu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu();
    }

    @JsonIgnore
    public void  setPanelJiryoTensuu(panelJiryoTensuuDiv panelJiryoTensuu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().setPanelJiryoTensuu(panelJiryoTensuu);
    }

    @JsonIgnore
    public TextBoxNum getTxtkinkyuChiryoKanriTanisu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtkinkyuChiryoKanriTanisu();
    }

    @JsonIgnore
    public void  setTxtkinkyuChiryoKanriTanisu(TextBoxNum txtkinkyuChiryoKanriTanisu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtkinkyuChiryoKanriTanisu(txtkinkyuChiryoKanriTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtkinkyuChiryoKanriNissu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtkinkyuChiryoKanriNissu();
    }

    @JsonIgnore
    public void  setTxtkinkyuChiryoKanriNissu(TextBoxNum txtkinkyuChiryoKanriNissu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtkinkyuChiryoKanriNissu(txtkinkyuChiryoKanriNissu);
    }

    @JsonIgnore
    public Button getBtnKeisan() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getBtnKeisan();
    }

    @JsonIgnore
    public void  setBtnKeisan(Button btnKeisan) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setBtnKeisan(btnKeisan);
    }

    @JsonIgnore
    public TextBoxNum getTxtkinkyuChiryoKanriSubTotal() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtkinkyuChiryoKanriSubTotal();
    }

    @JsonIgnore
    public void  setTxtkinkyuChiryoKanriSubTotal(TextBoxNum txtkinkyuChiryoKanriSubTotal) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtkinkyuChiryoKanriSubTotal(txtkinkyuChiryoKanriSubTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtrehabilitationTanisu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtrehabilitationTanisu();
    }

    @JsonIgnore
    public void  setTxtrehabilitationTanisu(TextBoxNum txtrehabilitationTanisu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtrehabilitationTanisu(txtrehabilitationTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtshujutsuTanisu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtshujutsuTanisu();
    }

    @JsonIgnore
    public void  setTxtshujutsuTanisu(TextBoxNum txtshujutsuTanisu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtshujutsuTanisu(txtshujutsuTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshasenChiryoTanisu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtHoshasenChiryoTanisu();
    }

    @JsonIgnore
    public void  setTxtHoshasenChiryoTanisu(TextBoxNum txtHoshasenChiryoTanisu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtHoshasenChiryoTanisu(txtHoshasenChiryoTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShochiTanisu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtShochiTanisu();
    }

    @JsonIgnore
    public void  setTxtShochiTanisu(TextBoxNum txtShochiTanisu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtShochiTanisu(txtShochiTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMasuiTanisu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtMasuiTanisu();
    }

    @JsonIgnore
    public void  setTxtMasuiTanisu(TextBoxNum txtMasuiTanisu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtMasuiTanisu(txtMasuiTanisu);
    }

    @JsonIgnore
    public Button getBtnCal() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getBtnCal();
    }

    @JsonIgnore
    public void  setBtnCal(Button btnCal) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setBtnCal(btnCal);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuShisetsuRyoyohiTotalTanisu() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().getTxtKinkyuShisetsuRyoyohiTotalTanisu();
    }

    @JsonIgnore
    public void  setTxtKinkyuShisetsuRyoyohiTotalTanisu(TextBoxNum txtKinkyuShisetsuRyoyohiTotalTanisu) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getPanelJiryoTensuu().setTxtKinkyuShisetsuRyoyohiTotalTanisu(txtKinkyuShisetsuRyoyohiTotalTanisu);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPanelKinkyujiShisetuRyoyohi().getPanelKinkyujiShiseturyoyoDetail().setBtnClear(btnClear);
    }

    // </editor-fold>
}
