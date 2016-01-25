package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810028;
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
 * KinkyujiShoteiShikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class KinkyujiShoteiShikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
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
    @JsonProperty("panelKinkyujiShoteishikkan")
    private panelKinkyujiShoteishikkanDiv panelKinkyujiShoteishikkan;

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
     * getpanelKinkyujiShoteishikkan
     * @return panelKinkyujiShoteishikkan
     */
    @JsonProperty("panelKinkyujiShoteishikkan")
    public panelKinkyujiShoteishikkanDiv getPanelKinkyujiShoteishikkan() {
        return panelKinkyujiShoteishikkan;
    }

    /*
     * setpanelKinkyujiShoteishikkan
     * @param panelKinkyujiShoteishikkan panelKinkyujiShoteishikkan
     */
    @JsonProperty("panelKinkyujiShoteishikkan")
    public void setPanelKinkyujiShoteishikkan(panelKinkyujiShoteishikkanDiv panelKinkyujiShoteishikkan) {
        this.panelKinkyujiShoteishikkan = panelKinkyujiShoteishikkan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgdKinkyujiShoteiList_Row> getDgdKinkyujiShoteiList() {
        return this.getPanelKinkyujiShoteishikkan().getDgdKinkyujiShoteiList();
    }

    @JsonIgnore
    public void  setDgdKinkyujiShoteiList(DataGrid<dgdKinkyujiShoteiList_Row> dgdKinkyujiShoteiList) {
        this.getPanelKinkyujiShoteishikkan().setDgdKinkyujiShoteiList(dgdKinkyujiShoteiList);
    }

    @JsonIgnore
    public panelDetailDiv getPanelDetail() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail();
    }

    @JsonIgnore
    public void  setPanelDetail(panelDetailDiv panelDetail) {
        this.getPanelKinkyujiShoteishikkan().setPanelDetail(panelDetail);
    }

    @JsonIgnore
    public panelShobyoNameDiv getPanelShobyoName() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName();
    }

    @JsonIgnore
    public void  setPanelShobyoName(panelShobyoNameDiv panelShobyoName) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().setPanelShobyoName(panelShobyoName);
    }

    @JsonIgnore
    public TextBox getTxtShoteiShikkanShobyoName1() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoName1();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoName1(TextBox txtShoteiShikkanShobyoName1) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoName1(txtShoteiShikkanShobyoName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoteiShikkanShobyoKaishiYMD1() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD1();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoKaishiYMD1(TextBoxDate txtShoteiShikkanShobyoKaishiYMD1) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoKaishiYMD1(txtShoteiShikkanShobyoKaishiYMD1);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName1() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtKinkyuShobyoName1();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName1(TextBox txtKinkyuShobyoName1) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtKinkyuShobyoName1(txtKinkyuShobyoName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuChiryoKaishiYMD1() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD1();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKaishiYMD1(TextBoxDate txtKinkyuChiryoKaishiYMD1) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtKinkyuChiryoKaishiYMD1(txtKinkyuChiryoKaishiYMD1);
    }

    @JsonIgnore
    public TextBox getTxtShoteiShikkanShobyoName2() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoName2();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoName2(TextBox txtShoteiShikkanShobyoName2) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoName2(txtShoteiShikkanShobyoName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoteiShikkanShobyoKaishiYMD2() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD2();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoKaishiYMD2(TextBoxDate txtShoteiShikkanShobyoKaishiYMD2) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoKaishiYMD2(txtShoteiShikkanShobyoKaishiYMD2);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName2() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtKinkyuShobyoName2();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName2(TextBox txtKinkyuShobyoName2) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtKinkyuShobyoName2(txtKinkyuShobyoName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuChiryoKaishiYMD2() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD2();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKaishiYMD2(TextBoxDate txtKinkyuChiryoKaishiYMD2) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtKinkyuChiryoKaishiYMD2(txtKinkyuChiryoKaishiYMD2);
    }

    @JsonIgnore
    public TextBox getTxtShoteiShikkanShobyoName3() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoName3();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoName3(TextBox txtShoteiShikkanShobyoName3) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoName3(txtShoteiShikkanShobyoName3);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoteiShikkanShobyoKaishiYMD3() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD3();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanShobyoKaishiYMD3(TextBoxDate txtShoteiShikkanShobyoKaishiYMD3) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtShoteiShikkanShobyoKaishiYMD3(txtShoteiShikkanShobyoKaishiYMD3);
    }

    @JsonIgnore
    public TextBox getTxtKinkyuShobyoName3() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtKinkyuShobyoName3();
    }

    @JsonIgnore
    public void  setTxtKinkyuShobyoName3(TextBox txtKinkyuShobyoName3) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtKinkyuShobyoName3(txtKinkyuShobyoName3);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinkyuChiryoKaishiYMD3() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD3();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKaishiYMD3(TextBoxDate txtKinkyuChiryoKaishiYMD3) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelShobyoName().setTxtKinkyuChiryoKaishiYMD3(txtKinkyuChiryoKaishiYMD3);
    }

    @JsonIgnore
    public panelOshinTuyinDiv getPanelOshinTuyin() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin();
    }

    @JsonIgnore
    public void  setPanelOshinTuyin(panelOshinTuyinDiv panelOshinTuyin) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().setPanelOshinTuyin(panelOshinTuyin);
    }

    @JsonIgnore
    public Label getLblOshin() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().getLblOshin();
    }

    @JsonIgnore
    public void  setLblOshin(Label lblOshin) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().setLblOshin(lblOshin);
    }

    @JsonIgnore
    public TextBoxNum getTxtOshinNissu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().getTxtOshinNissu();
    }

    @JsonIgnore
    public void  setTxtOshinNissu(TextBoxNum txtOshinNissu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().setTxtOshinNissu(txtOshinNissu);
    }

    @JsonIgnore
    public TextBox getTxtOshinIryoKikanName() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().getTxtOshinIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtOshinIryoKikanName(TextBox txtOshinIryoKikanName) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().setTxtOshinIryoKikanName(txtOshinIryoKikanName);
    }

    @JsonIgnore
    public Label getLblTsuin() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().getLblTsuin();
    }

    @JsonIgnore
    public void  setLblTsuin(Label lblTsuin) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().setLblTsuin(lblTsuin);
    }

    @JsonIgnore
    public TextBoxNum getTxtTsuyinNissu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().getTxtTsuyinNissu();
    }

    @JsonIgnore
    public void  setTxtTsuyinNissu(TextBoxNum txtTsuyinNissu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().setTxtTsuyinNissu(txtTsuyinNissu);
    }

    @JsonIgnore
    public TextBox getTxtTsuinKikanName() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().getTxtTsuinKikanName();
    }

    @JsonIgnore
    public void  setTxtTsuinKikanName(TextBox txtTsuinKikanName) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().setTxtTsuinKikanName(txtTsuinKikanName);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTekiyou() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().getTxtTekiyou();
    }

    @JsonIgnore
    public void  setTxtTekiyou(TextBoxMultiLine txtTekiyou) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelOshinTuyin().setTxtTekiyou(txtTekiyou);
    }

    @JsonIgnore
    public panelJiryoutensuDiv getPanelJiryoutensu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu();
    }

    @JsonIgnore
    public void  setPanelJiryoutensu(panelJiryoutensuDiv panelJiryoutensu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().setPanelJiryoutensu(panelJiryoutensu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoteiShikkanTanisu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtShoteiShikkanTanisu();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanTanisu(TextBoxNum txtShoteiShikkanTanisu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtShoteiShikkanTanisu(txtShoteiShikkanTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoteiShikkanNissu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtShoteiShikkanNissu();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanNissu(TextBoxNum txtShoteiShikkanNissu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtShoteiShikkanNissu(txtShoteiShikkanNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShoteiShikkanSubTotal() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtShoteiShikkanSubTotal();
    }

    @JsonIgnore
    public void  setTxtShoteiShikkanSubTotal(TextBoxNum txtShoteiShikkanSubTotal) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtShoteiShikkanSubTotal(txtShoteiShikkanSubTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuChiryoKanriTanisu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtKinkyuChiryoKanriTanisu();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKanriTanisu(TextBoxNum txtKinkyuChiryoKanriTanisu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtKinkyuChiryoKanriTanisu(txtKinkyuChiryoKanriTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuChiryoKanriNissu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtKinkyuChiryoKanriNissu();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKanriNissu(TextBoxNum txtKinkyuChiryoKanriNissu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtKinkyuChiryoKanriNissu(txtKinkyuChiryoKanriNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyuChiryoKanriSubTotal() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtKinkyuChiryoKanriSubTotal();
    }

    @JsonIgnore
    public void  setTxtKinkyuChiryoKanriSubTotal(TextBoxNum txtKinkyuChiryoKanriSubTotal) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtKinkyuChiryoKanriSubTotal(txtKinkyuChiryoKanriSubTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtRehabilitationTanisu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtRehabilitationTanisu();
    }

    @JsonIgnore
    public void  setTxtRehabilitationTanisu(TextBoxNum txtRehabilitationTanisu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtRehabilitationTanisu(txtRehabilitationTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShujutsuTanisu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtShujutsuTanisu();
    }

    @JsonIgnore
    public void  setTxtShujutsuTanisu(TextBoxNum txtShujutsuTanisu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtShujutsuTanisu(txtShujutsuTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshasenChiryoTanisu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtHoshasenChiryoTanisu();
    }

    @JsonIgnore
    public void  setTxtHoshasenChiryoTanisu(TextBoxNum txtHoshasenChiryoTanisu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtHoshasenChiryoTanisu(txtHoshasenChiryoTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShochiTanisu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtShochiTanisu();
    }

    @JsonIgnore
    public void  setTxtShochiTanisu(TextBoxNum txtShochiTanisu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtShochiTanisu(txtShochiTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMasuiTanisu() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtMasuiTanisu();
    }

    @JsonIgnore
    public void  setTxtMasuiTanisu(TextBoxNum txtMasuiTanisu) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtMasuiTanisu(txtMasuiTanisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuteiJiryoGoukei() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().getTxtTokuteiJiryoGoukei();
    }

    @JsonIgnore
    public void  setTxtTokuteiJiryoGoukei(TextBoxNum txtTokuteiJiryoGoukei) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().getPanelJiryoutensu().setTxtTokuteiJiryoGoukei(txtTokuteiJiryoGoukei);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPanelKinkyujiShoteishikkan().getPanelDetail().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelKinkyujiShoteishikkan().getPanelDetail().setBtnClose(btnClose);
    }

    // </editor-fold>
}
