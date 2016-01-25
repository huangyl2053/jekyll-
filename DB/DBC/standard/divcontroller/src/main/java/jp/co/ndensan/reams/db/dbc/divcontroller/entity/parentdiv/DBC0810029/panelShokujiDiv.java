package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810029;
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
 * panelShokuji のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShokujiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelShoikujiList")
    private panelShoikujiListDiv panelShoikujiList;
    @JsonProperty("panelDetail1")
    private panelDetail1Div panelDetail1;
    @JsonProperty("panelDetail2")
    private panelDetail2Div panelDetail2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelShoikujiList
     * @return panelShoikujiList
     */
    @JsonProperty("panelShoikujiList")
    public panelShoikujiListDiv getPanelShoikujiList() {
        return panelShoikujiList;
    }

    /*
     * setpanelShoikujiList
     * @param panelShoikujiList panelShoikujiList
     */
    @JsonProperty("panelShoikujiList")
    public void setPanelShoikujiList(panelShoikujiListDiv panelShoikujiList) {
        this.panelShoikujiList = panelShoikujiList;
    }

    /*
     * getpanelDetail1
     * @return panelDetail1
     */
    @JsonProperty("panelDetail1")
    public panelDetail1Div getPanelDetail1() {
        return panelDetail1;
    }

    /*
     * setpanelDetail1
     * @param panelDetail1 panelDetail1
     */
    @JsonProperty("panelDetail1")
    public void setPanelDetail1(panelDetail1Div panelDetail1) {
        this.panelDetail1 = panelDetail1;
    }

    /*
     * getpanelDetail2
     * @return panelDetail2
     */
    @JsonProperty("panelDetail2")
    public panelDetail2Div getPanelDetail2() {
        return panelDetail2;
    }

    /*
     * setpanelDetail2
     * @param panelDetail2 panelDetail2
     */
    @JsonProperty("panelDetail2")
    public void setPanelDetail2(panelDetail2Div panelDetail2) {
        this.panelDetail2 = panelDetail2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgdShokuji_Row> getDgdShokuji() {
        return this.getPanelShoikujiList().getDgdShokuji();
    }

    @JsonIgnore
    public void  setDgdShokuji(DataGrid<dgdShokuji_Row> dgdShokuji) {
        this.getPanelShoikujiList().setDgdShokuji(dgdShokuji);
    }

    @JsonIgnore
    public panelGokeiSetDiv getPanelGokeiSet() {
        return this.getPanelShoikujiList().getPanelGokeiSet();
    }

    @JsonIgnore
    public void  setPanelGokeiSet(panelGokeiSetDiv panelGokeiSet) {
        this.getPanelShoikujiList().setPanelGokeiSet(panelGokeiSet);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyoTotalNissuGokei() {
        return this.getPanelShoikujiList().getPanelGokeiSet().getTxtShokujiTeikyoTotalNissuGokei();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyoTotalNissuGokei(TextBoxNum txtShokujiTeikyoTotalNissuGokei) {
        this.getPanelShoikujiList().getPanelGokeiSet().setTxtShokujiTeikyoTotalNissuGokei(txtShokujiTeikyoTotalNissuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtnichigakuHyojunFutangakuGokei() {
        return this.getPanelShoikujiList().getPanelGokeiSet().getTxtnichigakuHyojunFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtnichigakuHyojunFutangakuGokei(TextBoxNum txtnichigakuHyojunFutangakuGokei) {
        this.getPanelShoikujiList().getPanelGokeiSet().setTxtnichigakuHyojunFutangakuGokei(txtnichigakuHyojunFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtgetsugakuHyojunFutangakuGokei() {
        return this.getPanelShoikujiList().getPanelGokeiSet().getTxtgetsugakuHyojunFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtgetsugakuHyojunFutangakuGokei(TextBoxNum txtgetsugakuHyojunFutangakuGokei) {
        this.getPanelShoikujiList().getPanelGokeiSet().setTxtgetsugakuHyojunFutangakuGokei(txtgetsugakuHyojunFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyohiTotalGokei() {
        return this.getPanelShoikujiList().getPanelGokeiSet().getTxtShokujiTeikyohiTotalGokei();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyohiTotalGokei(TextBoxNum txtShokujiTeikyohiTotalGokei) {
        this.getPanelShoikujiList().getPanelGokeiSet().setTxtShokujiTeikyohiTotalGokei(txtShokujiTeikyohiTotalGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtshokujiTeikyohiSeikyugakuGokei() {
        return this.getPanelShoikujiList().getPanelGokeiSet().getTxtshokujiTeikyohiSeikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtshokujiTeikyohiSeikyugakuGokei(TextBoxNum txtshokujiTeikyohiSeikyugakuGokei) {
        this.getPanelShoikujiList().getPanelGokeiSet().setTxtshokujiTeikyohiSeikyugakuGokei(txtshokujiTeikyohiSeikyugakuGokei);
    }

    @JsonIgnore
    public Label getLblFree() {
        return this.getPanelShoikujiList().getPanelGokeiSet().getLblFree();
    }

    @JsonIgnore
    public void  setLblFree(Label lblFree) {
        this.getPanelShoikujiList().getPanelGokeiSet().setLblFree(lblFree);
    }

    @JsonIgnore
    public Button getBtnCloseGokei() {
        return this.getPanelShoikujiList().getPanelGokeiSet().getBtnCloseGokei();
    }

    @JsonIgnore
    public void  setBtnCloseGokei(Button btnCloseGokei) {
        this.getPanelShoikujiList().getPanelGokeiSet().setBtnCloseGokei(btnCloseGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtKihonNissu() {
        return this.getPanelDetail1().getTxtKihonNissu();
    }

    @JsonIgnore
    public void  setTxtKihonNissu(TextBoxNum txtKihonNissu) {
        this.getPanelDetail1().setTxtKihonNissu(txtKihonNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKihonTanka() {
        return this.getPanelDetail1().getTxtKihonTanka();
    }

    @JsonIgnore
    public void  setTxtKihonTanka(TextBoxNum txtKihonTanka) {
        this.getPanelDetail1().setTxtKihonTanka(txtKihonTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtKihonKingaku() {
        return this.getPanelDetail1().getTxtKihonKingaku();
    }

    @JsonIgnore
    public void  setTxtKihonKingaku(TextBoxNum txtKihonKingaku) {
        this.getPanelDetail1().setTxtKihonKingaku(txtKihonKingaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetuSyokuNissu() {
        return this.getPanelDetail1().getTxtTokubetuSyokuNissu();
    }

    @JsonIgnore
    public void  setTxtTokubetuSyokuNissu(TextBoxNum txtTokubetuSyokuNissu) {
        this.getPanelDetail1().setTxtTokubetuSyokuNissu(txtTokubetuSyokuNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetuSyokuTanka() {
        return this.getPanelDetail1().getTxtTokubetuSyokuTanka();
    }

    @JsonIgnore
    public void  setTxtTokubetuSyokuTanka(TextBoxNum txtTokubetuSyokuTanka) {
        this.getPanelDetail1().setTxtTokubetuSyokuTanka(txtTokubetuSyokuTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetuSyokuKinngaku() {
        return this.getPanelDetail1().getTxtTokubetuSyokuKinngaku();
    }

    @JsonIgnore
    public void  setTxtTokubetuSyokuKinngaku(TextBoxNum txtTokubetuSyokuKinngaku) {
        this.getPanelDetail1().setTxtTokubetuSyokuKinngaku(txtTokubetuSyokuKinngaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyoTotalNissu() {
        return this.getPanelDetail1().getTxtShokujiTeikyoTotalNissu();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyoTotalNissu(TextBoxNum txtShokujiTeikyoTotalNissu) {
        this.getPanelDetail1().setTxtShokujiTeikyoTotalNissu(txtShokujiTeikyoTotalNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyohiTotal() {
        return this.getPanelDetail1().getTxtShokujiTeikyohiTotal();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyohiTotal(TextBoxNum txtShokujiTeikyohiTotal) {
        this.getPanelDetail1().setTxtShokujiTeikyohiTotal(txtShokujiTeikyohiTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtnichigakuHyojunFutangaku() {
        return this.getPanelDetail1().getTxtnichigakuHyojunFutangaku();
    }

    @JsonIgnore
    public void  setTxtnichigakuHyojunFutangaku(TextBoxNum txtnichigakuHyojunFutangaku) {
        this.getPanelDetail1().setTxtnichigakuHyojunFutangaku(txtnichigakuHyojunFutangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtgetsugakuHyojunFutangaku() {
        return this.getPanelDetail1().getTxtgetsugakuHyojunFutangaku();
    }

    @JsonIgnore
    public void  setTxtgetsugakuHyojunFutangaku(TextBoxNum txtgetsugakuHyojunFutangaku) {
        this.getPanelDetail1().setTxtgetsugakuHyojunFutangaku(txtgetsugakuHyojunFutangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtshokujiTeikyohiSeikyugaku() {
        return this.getPanelDetail1().getTxtshokujiTeikyohiSeikyugaku();
    }

    @JsonIgnore
    public void  setTxtshokujiTeikyohiSeikyugaku(TextBoxNum txtshokujiTeikyohiSeikyugaku) {
        this.getPanelDetail1().setTxtshokujiTeikyohiSeikyugaku(txtshokujiTeikyohiSeikyugaku);
    }

    @JsonIgnore
    public HorizontalLine getHlThree() {
        return this.getPanelDetail1().getHlThree();
    }

    @JsonIgnore
    public void  setHlThree(HorizontalLine hlThree) {
        this.getPanelDetail1().setHlThree(hlThree);
    }

    @JsonIgnore
    public TextBoxNum getTxtTensuKingaku() {
        return this.getPanelDetail1().getTxtTensuKingaku();
    }

    @JsonIgnore
    public void  setTxtTensuKingaku(TextBoxNum txtTensuKingaku) {
        this.getPanelDetail1().setTxtTensuKingaku(txtTensuKingaku);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikyukubun() {
        return this.getPanelDetail1().getTxtShikyukubun();
    }

    @JsonIgnore
    public void  setTxtShikyukubun(TextBoxCode txtShikyukubun) {
        this.getPanelDetail1().setTxtShikyukubun(txtShikyukubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiKingaku() {
        return this.getPanelDetail1().getTxtShiharaiKingaku();
    }

    @JsonIgnore
    public void  setTxtShiharaiKingaku(TextBoxNum txtShiharaiKingaku) {
        this.getPanelDetail1().setTxtShiharaiKingaku(txtShiharaiKingaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZougenten() {
        return this.getPanelDetail1().getTxtZougenten();
    }

    @JsonIgnore
    public void  setTxtZougenten(TextBoxNum txtZougenten) {
        this.getPanelDetail1().setTxtZougenten(txtZougenten);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCodeShurui() {
        return this.getPanelDetail2().getTxtServiceCodeShurui();
    }

    @JsonIgnore
    public void  setTxtServiceCodeShurui(TextBoxCode txtServiceCodeShurui) {
        this.getPanelDetail2().setTxtServiceCodeShurui(txtServiceCodeShurui);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceItemCode() {
        return this.getPanelDetail2().getTxtServiceItemCode();
    }

    @JsonIgnore
    public void  setTxtServiceItemCode(TextBoxCode txtServiceItemCode) {
        this.getPanelDetail2().setTxtServiceItemCode(txtServiceItemCode);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getPanelDetail2().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getPanelDetail2().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyi() {
        return this.getPanelDetail2().getTxtTanyi();
    }

    @JsonIgnore
    public void  setTxtTanyi(TextBoxNum txtTanyi) {
        this.getPanelDetail2().setTxtTanyi(txtTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisuuNisuu() {
        return this.getPanelDetail2().getTxtKaisuuNisuu();
    }

    @JsonIgnore
    public void  setTxtKaisuuNisuu(TextBoxNum txtKaisuuNisuu) {
        this.getPanelDetail2().setTxtKaisuuNisuu(txtKaisuuNisuu);
    }

    @JsonIgnore
    public TextBoxNum getBtnKinngaku() {
        return this.getPanelDetail2().getBtnKinngaku();
    }

    @JsonIgnore
    public void  setBtnKinngaku(TextBoxNum btnKinngaku) {
        this.getPanelDetail2().setBtnKinngaku(btnKinngaku);
    }

    @JsonIgnore
    public Button getBtnCloseDown() {
        return this.getPanelDetail2().getBtnCloseDown();
    }

    @JsonIgnore
    public void  setBtnCloseDown(Button btnCloseDown) {
        this.getPanelDetail2().setBtnCloseDown(btnCloseDown);
    }

    // </editor-fold>
}
