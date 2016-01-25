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
 * ShokujiHiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokujiHiyoDiv extends Panel {
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
    @JsonProperty("panelShokuji")
    private panelShokujiDiv panelShokuji;

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
     * getpanelShokuji
     * @return panelShokuji
     */
    @JsonProperty("panelShokuji")
    public panelShokujiDiv getPanelShokuji() {
        return panelShokuji;
    }

    /*
     * setpanelShokuji
     * @param panelShokuji panelShokuji
     */
    @JsonProperty("panelShokuji")
    public void setPanelShokuji(panelShokujiDiv panelShokuji) {
        this.panelShokuji = panelShokuji;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public panelShoikujiListDiv getPanelShoikujiList() {
        return this.getPanelShokuji().getPanelShoikujiList();
    }

    @JsonIgnore
    public void  setPanelShoikujiList(panelShoikujiListDiv panelShoikujiList) {
        this.getPanelShokuji().setPanelShoikujiList(panelShoikujiList);
    }

    @JsonIgnore
    public DataGrid<dgdShokuji_Row> getDgdShokuji() {
        return this.getPanelShokuji().getPanelShoikujiList().getDgdShokuji();
    }

    @JsonIgnore
    public void  setDgdShokuji(DataGrid<dgdShokuji_Row> dgdShokuji) {
        this.getPanelShokuji().getPanelShoikujiList().setDgdShokuji(dgdShokuji);
    }

    @JsonIgnore
    public panelGokeiSetDiv getPanelGokeiSet() {
        return this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet();
    }

    @JsonIgnore
    public void  setPanelGokeiSet(panelGokeiSetDiv panelGokeiSet) {
        this.getPanelShokuji().getPanelShoikujiList().setPanelGokeiSet(panelGokeiSet);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyoTotalNissuGokei() {
        return this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().getTxtShokujiTeikyoTotalNissuGokei();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyoTotalNissuGokei(TextBoxNum txtShokujiTeikyoTotalNissuGokei) {
        this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().setTxtShokujiTeikyoTotalNissuGokei(txtShokujiTeikyoTotalNissuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtnichigakuHyojunFutangakuGokei() {
        return this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().getTxtnichigakuHyojunFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtnichigakuHyojunFutangakuGokei(TextBoxNum txtnichigakuHyojunFutangakuGokei) {
        this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().setTxtnichigakuHyojunFutangakuGokei(txtnichigakuHyojunFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtgetsugakuHyojunFutangakuGokei() {
        return this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().getTxtgetsugakuHyojunFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtgetsugakuHyojunFutangakuGokei(TextBoxNum txtgetsugakuHyojunFutangakuGokei) {
        this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().setTxtgetsugakuHyojunFutangakuGokei(txtgetsugakuHyojunFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyohiTotalGokei() {
        return this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().getTxtShokujiTeikyohiTotalGokei();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyohiTotalGokei(TextBoxNum txtShokujiTeikyohiTotalGokei) {
        this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().setTxtShokujiTeikyohiTotalGokei(txtShokujiTeikyohiTotalGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtshokujiTeikyohiSeikyugakuGokei() {
        return this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().getTxtshokujiTeikyohiSeikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtshokujiTeikyohiSeikyugakuGokei(TextBoxNum txtshokujiTeikyohiSeikyugakuGokei) {
        this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().setTxtshokujiTeikyohiSeikyugakuGokei(txtshokujiTeikyohiSeikyugakuGokei);
    }

    @JsonIgnore
    public Label getLblFree() {
        return this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().getLblFree();
    }

    @JsonIgnore
    public void  setLblFree(Label lblFree) {
        this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().setLblFree(lblFree);
    }

    @JsonIgnore
    public Button getBtnCloseGokei() {
        return this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().getBtnCloseGokei();
    }

    @JsonIgnore
    public void  setBtnCloseGokei(Button btnCloseGokei) {
        this.getPanelShokuji().getPanelShoikujiList().getPanelGokeiSet().setBtnCloseGokei(btnCloseGokei);
    }

    @JsonIgnore
    public panelDetail1Div getPanelDetail1() {
        return this.getPanelShokuji().getPanelDetail1();
    }

    @JsonIgnore
    public void  setPanelDetail1(panelDetail1Div panelDetail1) {
        this.getPanelShokuji().setPanelDetail1(panelDetail1);
    }

    @JsonIgnore
    public TextBoxNum getTxtKihonNissu() {
        return this.getPanelShokuji().getPanelDetail1().getTxtKihonNissu();
    }

    @JsonIgnore
    public void  setTxtKihonNissu(TextBoxNum txtKihonNissu) {
        this.getPanelShokuji().getPanelDetail1().setTxtKihonNissu(txtKihonNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKihonTanka() {
        return this.getPanelShokuji().getPanelDetail1().getTxtKihonTanka();
    }

    @JsonIgnore
    public void  setTxtKihonTanka(TextBoxNum txtKihonTanka) {
        this.getPanelShokuji().getPanelDetail1().setTxtKihonTanka(txtKihonTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtKihonKingaku() {
        return this.getPanelShokuji().getPanelDetail1().getTxtKihonKingaku();
    }

    @JsonIgnore
    public void  setTxtKihonKingaku(TextBoxNum txtKihonKingaku) {
        this.getPanelShokuji().getPanelDetail1().setTxtKihonKingaku(txtKihonKingaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetuSyokuNissu() {
        return this.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu();
    }

    @JsonIgnore
    public void  setTxtTokubetuSyokuNissu(TextBoxNum txtTokubetuSyokuNissu) {
        this.getPanelShokuji().getPanelDetail1().setTxtTokubetuSyokuNissu(txtTokubetuSyokuNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetuSyokuTanka() {
        return this.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuTanka();
    }

    @JsonIgnore
    public void  setTxtTokubetuSyokuTanka(TextBoxNum txtTokubetuSyokuTanka) {
        this.getPanelShokuji().getPanelDetail1().setTxtTokubetuSyokuTanka(txtTokubetuSyokuTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokubetuSyokuKinngaku() {
        return this.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku();
    }

    @JsonIgnore
    public void  setTxtTokubetuSyokuKinngaku(TextBoxNum txtTokubetuSyokuKinngaku) {
        this.getPanelShokuji().getPanelDetail1().setTxtTokubetuSyokuKinngaku(txtTokubetuSyokuKinngaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyoTotalNissu() {
        return this.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyoTotalNissu(TextBoxNum txtShokujiTeikyoTotalNissu) {
        this.getPanelShokuji().getPanelDetail1().setTxtShokujiTeikyoTotalNissu(txtShokujiTeikyoTotalNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyohiTotal() {
        return this.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyohiTotal();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyohiTotal(TextBoxNum txtShokujiTeikyohiTotal) {
        this.getPanelShokuji().getPanelDetail1().setTxtShokujiTeikyohiTotal(txtShokujiTeikyohiTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtnichigakuHyojunFutangaku() {
        return this.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku();
    }

    @JsonIgnore
    public void  setTxtnichigakuHyojunFutangaku(TextBoxNum txtnichigakuHyojunFutangaku) {
        this.getPanelShokuji().getPanelDetail1().setTxtnichigakuHyojunFutangaku(txtnichigakuHyojunFutangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtgetsugakuHyojunFutangaku() {
        return this.getPanelShokuji().getPanelDetail1().getTxtgetsugakuHyojunFutangaku();
    }

    @JsonIgnore
    public void  setTxtgetsugakuHyojunFutangaku(TextBoxNum txtgetsugakuHyojunFutangaku) {
        this.getPanelShokuji().getPanelDetail1().setTxtgetsugakuHyojunFutangaku(txtgetsugakuHyojunFutangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtshokujiTeikyohiSeikyugaku() {
        return this.getPanelShokuji().getPanelDetail1().getTxtshokujiTeikyohiSeikyugaku();
    }

    @JsonIgnore
    public void  setTxtshokujiTeikyohiSeikyugaku(TextBoxNum txtshokujiTeikyohiSeikyugaku) {
        this.getPanelShokuji().getPanelDetail1().setTxtshokujiTeikyohiSeikyugaku(txtshokujiTeikyohiSeikyugaku);
    }

    @JsonIgnore
    public HorizontalLine getHlThree() {
        return this.getPanelShokuji().getPanelDetail1().getHlThree();
    }

    @JsonIgnore
    public void  setHlThree(HorizontalLine hlThree) {
        this.getPanelShokuji().getPanelDetail1().setHlThree(hlThree);
    }

    @JsonIgnore
    public TextBoxNum getTxtTensuKingaku() {
        return this.getPanelShokuji().getPanelDetail1().getTxtTensuKingaku();
    }

    @JsonIgnore
    public void  setTxtTensuKingaku(TextBoxNum txtTensuKingaku) {
        this.getPanelShokuji().getPanelDetail1().setTxtTensuKingaku(txtTensuKingaku);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikyukubun() {
        return this.getPanelShokuji().getPanelDetail1().getTxtShikyukubun();
    }

    @JsonIgnore
    public void  setTxtShikyukubun(TextBoxCode txtShikyukubun) {
        this.getPanelShokuji().getPanelDetail1().setTxtShikyukubun(txtShikyukubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiKingaku() {
        return this.getPanelShokuji().getPanelDetail1().getTxtShiharaiKingaku();
    }

    @JsonIgnore
    public void  setTxtShiharaiKingaku(TextBoxNum txtShiharaiKingaku) {
        this.getPanelShokuji().getPanelDetail1().setTxtShiharaiKingaku(txtShiharaiKingaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZougenten() {
        return this.getPanelShokuji().getPanelDetail1().getTxtZougenten();
    }

    @JsonIgnore
    public void  setTxtZougenten(TextBoxNum txtZougenten) {
        this.getPanelShokuji().getPanelDetail1().setTxtZougenten(txtZougenten);
    }

    @JsonIgnore
    public panelDetail2Div getPanelDetail2() {
        return this.getPanelShokuji().getPanelDetail2();
    }

    @JsonIgnore
    public void  setPanelDetail2(panelDetail2Div panelDetail2) {
        this.getPanelShokuji().setPanelDetail2(panelDetail2);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCodeShurui() {
        return this.getPanelShokuji().getPanelDetail2().getTxtServiceCodeShurui();
    }

    @JsonIgnore
    public void  setTxtServiceCodeShurui(TextBoxCode txtServiceCodeShurui) {
        this.getPanelShokuji().getPanelDetail2().setTxtServiceCodeShurui(txtServiceCodeShurui);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceItemCode() {
        return this.getPanelShokuji().getPanelDetail2().getTxtServiceItemCode();
    }

    @JsonIgnore
    public void  setTxtServiceItemCode(TextBoxCode txtServiceItemCode) {
        this.getPanelShokuji().getPanelDetail2().setTxtServiceItemCode(txtServiceItemCode);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getPanelShokuji().getPanelDetail2().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getPanelShokuji().getPanelDetail2().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyi() {
        return this.getPanelShokuji().getPanelDetail2().getTxtTanyi();
    }

    @JsonIgnore
    public void  setTxtTanyi(TextBoxNum txtTanyi) {
        this.getPanelShokuji().getPanelDetail2().setTxtTanyi(txtTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisuuNisuu() {
        return this.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu();
    }

    @JsonIgnore
    public void  setTxtKaisuuNisuu(TextBoxNum txtKaisuuNisuu) {
        this.getPanelShokuji().getPanelDetail2().setTxtKaisuuNisuu(txtKaisuuNisuu);
    }

    @JsonIgnore
    public TextBoxNum getBtnKinngaku() {
        return this.getPanelShokuji().getPanelDetail2().getBtnKinngaku();
    }

    @JsonIgnore
    public void  setBtnKinngaku(TextBoxNum btnKinngaku) {
        this.getPanelShokuji().getPanelDetail2().setBtnKinngaku(btnKinngaku);
    }

    @JsonIgnore
    public Button getBtnCloseDown() {
        return this.getPanelShokuji().getPanelDetail2().getBtnCloseDown();
    }

    @JsonIgnore
    public void  setBtnCloseDown(Button btnCloseDown) {
        this.getPanelShokuji().getPanelDetail2().setBtnCloseDown(btnCloseDown);
    }

    // </editor-fold>
}
