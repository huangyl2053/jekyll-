package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader.IKyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuteiShinryohiMain のクラスファイル
 *
 * @author 自動生成
 */
public class TokuteiShinryohiMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuJisseki")
    private KyufuJissekiDiv KyufuJisseki;
    @JsonProperty("TekiyoPanelPanel")
    private TekiyoPanelPanelDiv TekiyoPanelPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyufuJisseki
     * @return KyufuJisseki
     */
    @JsonProperty("KyufuJisseki")
    public KyufuJissekiDiv getKyufuJisseki() {
        return KyufuJisseki;
    }

    /*
     * setKyufuJisseki
     * @param KyufuJisseki KyufuJisseki
     */
    @JsonProperty("KyufuJisseki")
    public void setKyufuJisseki(KyufuJissekiDiv KyufuJisseki) {
        this.KyufuJisseki = KyufuJisseki;
    }

    /*
     * getTekiyoPanelPanel
     * @return TekiyoPanelPanel
     */
    @JsonProperty("TekiyoPanelPanel")
    public TekiyoPanelPanelDiv getTekiyoPanelPanel() {
        return TekiyoPanelPanel;
    }

    /*
     * setTekiyoPanelPanel
     * @param TekiyoPanelPanel TekiyoPanelPanel
     */
    @JsonProperty("TekiyoPanelPanel")
    public void setTekiyoPanelPanel(TekiyoPanelPanelDiv TekiyoPanelPanel) {
        this.TekiyoPanelPanel = TekiyoPanelPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getLinButtonArea1() {
        return this.getKyufuJisseki().getLinButtonArea1();
    }

    @JsonIgnore
    public void setLinButtonArea1(HorizontalLine linButtonArea1) {
        this.getKyufuJisseki().setLinButtonArea1(linButtonArea1);
    }

    @JsonIgnore
    public Button getBtnKihon() {
        return this.getKyufuJisseki().getBtnKihon();
    }

    @JsonIgnore
    public void setBtnKihon(Button btnKihon) {
        this.getKyufuJisseki().setBtnKihon(btnKihon);
    }

    @JsonIgnore
    public Button getBtnMeisaiShukei() {
        return this.getKyufuJisseki().getBtnMeisaiShukei();
    }

    @JsonIgnore
    public void setBtnMeisaiShukei(Button btnMeisaiShukei) {
        this.getKyufuJisseki().setBtnMeisaiShukei(btnMeisaiShukei);
    }

    @JsonIgnore
    public Button getBtnKinkyujiShisetsuRyoyo() {
        return this.getKyufuJisseki().getBtnKinkyujiShisetsuRyoyo();
    }

    @JsonIgnore
    public void setBtnKinkyujiShisetsuRyoyo(Button btnKinkyujiShisetsuRyoyo) {
        this.getKyufuJisseki().setBtnKinkyujiShisetsuRyoyo(btnKinkyujiShisetsuRyoyo);
    }

    @JsonIgnore
    public Button getBtnShoteiShikkanShisetsuRyoyo() {
        return this.getKyufuJisseki().getBtnShoteiShikkanShisetsuRyoyo();
    }

    @JsonIgnore
    public void setBtnShoteiShikkanShisetsuRyoyo(Button btnShoteiShikkanShisetsuRyoyo) {
        this.getKyufuJisseki().setBtnShoteiShikkanShisetsuRyoyo(btnShoteiShikkanShisetsuRyoyo);
    }

    @JsonIgnore
    public Button getBtnShokuji() {
        return this.getKyufuJisseki().getBtnShokuji();
    }

    @JsonIgnore
    public void setBtnShokuji(Button btnShokuji) {
        this.getKyufuJisseki().setBtnShokuji(btnShokuji);
    }

    @JsonIgnore
    public Button getBtnFukushiYoguKonyu() {
        return this.getKyufuJisseki().getBtnFukushiYoguKonyu();
    }

    @JsonIgnore
    public void setBtnFukushiYoguKonyu(Button btnFukushiYoguKonyu) {
        this.getKyufuJisseki().setBtnFukushiYoguKonyu(btnFukushiYoguKonyu);
    }

    @JsonIgnore
    public Button getBtnTokuteiNyushosha() {
        return this.getKyufuJisseki().getBtnTokuteiNyushosha();
    }

    @JsonIgnore
    public void setBtnTokuteiNyushosha(Button btnTokuteiNyushosha) {
        this.getKyufuJisseki().setBtnTokuteiNyushosha(btnTokuteiNyushosha);
    }

    @JsonIgnore
    public Button getBtnKogakuKaigoService() {
        return this.getKyufuJisseki().getBtnKogakuKaigoService();
    }

    @JsonIgnore
    public void setBtnKogakuKaigoService(Button btnKogakuKaigoService) {
        this.getKyufuJisseki().setBtnKogakuKaigoService(btnKogakuKaigoService);
    }

    @JsonIgnore
    public Button getBtnTokuteiShinryo() {
        return this.getKyufuJisseki().getBtnTokuteiShinryo();
    }

    @JsonIgnore
    public void setBtnTokuteiShinryo(Button btnTokuteiShinryo) {
        this.getKyufuJisseki().setBtnTokuteiShinryo(btnTokuteiShinryo);
    }

    @JsonIgnore
    public Button getBtnKyotakuServiceKeikaku() {
        return this.getKyufuJisseki().getBtnKyotakuServiceKeikaku();
    }

    @JsonIgnore
    public void setBtnKyotakuServiceKeikaku(Button btnKyotakuServiceKeikaku) {
        this.getKyufuJisseki().setBtnKyotakuServiceKeikaku(btnKyotakuServiceKeikaku);
    }

    @JsonIgnore
    public Button getBtnJutakuKaishu() {
        return this.getKyufuJisseki().getBtnJutakuKaishu();
    }

    @JsonIgnore
    public void setBtnJutakuKaishu(Button btnJutakuKaishu) {
        this.getKyufuJisseki().setBtnJutakuKaishu(btnJutakuKaishu);
    }

    @JsonIgnore
    public Button getBtnCareManagement() {
        return this.getKyufuJisseki().getBtnCareManagement();
    }

    @JsonIgnore
    public void setBtnCareManagement(Button btnCareManagement) {
        this.getKyufuJisseki().setBtnCareManagement(btnCareManagement);
    }

    @JsonIgnore
    public Button getBtnShafukuKeigen() {
        return this.getKyufuJisseki().getBtnShafukuKeigen();
    }

    @JsonIgnore
    public void setBtnShafukuKeigen(Button btnShafukuKeigen) {
        this.getKyufuJisseki().setBtnShafukuKeigen(btnShafukuKeigen);
    }

    @JsonIgnore
    public HorizontalLine getLinButtonArea2() {
        return this.getKyufuJisseki().getLinButtonArea2();
    }

    @JsonIgnore
    public void setLinButtonArea2(HorizontalLine linButtonArea2) {
        this.getKyufuJisseki().setLinButtonArea2(linButtonArea2);
    }

    @JsonIgnore
    public TokuteiShinryohiFromH1504PanelDiv getTokuteiShinryohiFromH1504Panel() {
        return this.getKyufuJisseki().getTokuteiShinryohiFromH1504Panel();
    }

    @JsonIgnore
    public void setTokuteiShinryohiFromH1504Panel(TokuteiShinryohiFromH1504PanelDiv TokuteiShinryohiFromH1504Panel) {
        this.getKyufuJisseki().setTokuteiShinryohiFromH1504Panel(TokuteiShinryohiFromH1504Panel);
    }

    @JsonIgnore
    public Label getLblTitle1() {
        return this.getKyufuJisseki().getTokuteiShinryohiFromH1504Panel().getLblTitle1();
    }

    @JsonIgnore
    public void setLblTitle1(Label lblTitle1) {
        this.getKyufuJisseki().getTokuteiShinryohiFromH1504Panel().setLblTitle1(lblTitle1);
    }

    @JsonIgnore
    public DataGrid<dgTokuteiShinryohiFromH1504_Row> getDgTokuteiShinryohiFromH1504() {
        return this.getKyufuJisseki().getTokuteiShinryohiFromH1504Panel().getDgTokuteiShinryohiFromH1504();
    }

    @JsonIgnore
    public void setDgTokuteiShinryohiFromH1504(DataGrid<dgTokuteiShinryohiFromH1504_Row> dgTokuteiShinryohiFromH1504) {
        this.getKyufuJisseki().getTokuteiShinryohiFromH1504Panel().setDgTokuteiShinryohiFromH1504(dgTokuteiShinryohiFromH1504);
    }

    @JsonIgnore
    public TokuteiShinryohiToH1503PanelDiv getTokuteiShinryohiToH1503Panel() {
        return this.getKyufuJisseki().getTokuteiShinryohiToH1503Panel();
    }

    @JsonIgnore
    public void setTokuteiShinryohiToH1503Panel(TokuteiShinryohiToH1503PanelDiv TokuteiShinryohiToH1503Panel) {
        this.getKyufuJisseki().setTokuteiShinryohiToH1503Panel(TokuteiShinryohiToH1503Panel);
    }

    @JsonIgnore
    public Label getLblTitle2() {
        return this.getKyufuJisseki().getTokuteiShinryohiToH1503Panel().getLblTitle2();
    }

    @JsonIgnore
    public void setLblTitle2(Label lblTitle2) {
        this.getKyufuJisseki().getTokuteiShinryohiToH1503Panel().setLblTitle2(lblTitle2);
    }

    @JsonIgnore
    public DataGrid<dgTokuteiShinryohiToH1503_Row> getDgTokuteiShinryohiToH1503() {
        return this.getKyufuJisseki().getTokuteiShinryohiToH1503Panel().getDgTokuteiShinryohiToH1503();
    }

    @JsonIgnore
    public void setDgTokuteiShinryohiToH1503(DataGrid<dgTokuteiShinryohiToH1503_Row> dgTokuteiShinryohiToH1503) {
        this.getKyufuJisseki().getTokuteiShinryohiToH1503Panel().setDgTokuteiShinryohiToH1503(dgTokuteiShinryohiToH1503);
    }

    @JsonIgnore
    public HorizontalLine getLinButtonArea3() {
        return this.getKyufuJisseki().getLinButtonArea3();
    }

    @JsonIgnore
    public void setLinButtonArea3(HorizontalLine linButtonArea3) {
        this.getKyufuJisseki().setLinButtonArea3(linButtonArea3);
    }

    @JsonIgnore
    public IKyufuJissekiHeaderDiv getCcdKyufuJissekiHeader() {
        return this.getKyufuJisseki().getCcdKyufuJissekiHeader();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTekiyo() {
        return this.getTekiyoPanelPanel().getTxtTekiyo();
    }

    @JsonIgnore
    public void setTxtTekiyo(TextBoxMultiLine txtTekiyo) {
        this.getTekiyoPanelPanel().setTxtTekiyo(txtTekiyo);
    }

    @JsonIgnore
    public Button getBtnTekiyoClose() {
        return this.getTekiyoPanelPanel().getBtnTekiyoClose();
    }

    @JsonIgnore
    public void setBtnTekiyoClose(Button btnTekiyoClose) {
        this.getTekiyoPanelPanel().setBtnTekiyoClose(btnTekiyoClose);
    }

    // </editor-fold>
}
