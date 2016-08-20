package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader.IKyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010011.KyufuJissekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * KinkyujiShisetsuRyoyohiShokai のクラスファイル
 *
 * @author 自動生成
 */
public class KinkyujiShisetsuRyoyohiShokaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuJisseki")
    private KyufuJissekiDiv KyufuJisseki;
    @JsonProperty("KyufuJissekiTekiyoPanel")
    private KyufuJissekiTekiyoPanelDiv KyufuJissekiTekiyoPanel;

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
     * getKyufuJissekiTekiyoPanel
     * @return KyufuJissekiTekiyoPanel
     */
    @JsonProperty("KyufuJissekiTekiyoPanel")
    public KyufuJissekiTekiyoPanelDiv getKyufuJissekiTekiyoPanel() {
        return KyufuJissekiTekiyoPanel;
    }

    /*
     * setKyufuJissekiTekiyoPanel
     * @param KyufuJissekiTekiyoPanel KyufuJissekiTekiyoPanel
     */
    @JsonProperty("KyufuJissekiTekiyoPanel")
    public void setKyufuJissekiTekiyoPanel(KyufuJissekiTekiyoPanelDiv KyufuJissekiTekiyoPanel) {
        this.KyufuJissekiTekiyoPanel = KyufuJissekiTekiyoPanel;
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
    public DataGrid<dgKinkyujiShisetsuRyoyohi_Row> getDgKinkyujiShisetsuRyoyohi() {
        return null; //this.getKyufuJisseki().getDgKinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public void setDgKinkyujiShisetsuRyoyohi(DataGrid<dgKinkyujiShisetsuRyoyohi_Row> dgKinkyujiShisetsuRyoyohi) {
        // this.getKyufuJisseki().setDgKinkyujiShisetsuRyoyohi(dgKinkyujiShisetsuRyoyohi);
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
    public Button getBtnJigetsu() {
        return this.getKyufuJisseki().getBtnJigetsu();
    }

    @JsonIgnore
    public void setBtnJigetsu(Button btnJigetsu) {
        this.getKyufuJisseki().setBtnJigetsu(btnJigetsu);
    }

    @JsonIgnore
    public Button getBtnZengetsu() {
        return this.getKyufuJisseki().getBtnZengetsu();
    }

    @JsonIgnore
    public void setBtnZengetsu(Button btnZengetsu) {
        this.getKyufuJisseki().setBtnZengetsu(btnZengetsu);
    }

    @JsonIgnore
    public Button getBtnAtoJigyosha() {
        return this.getKyufuJisseki().getBtnAtoJigyosha();
    }

    @JsonIgnore
    public void setBtnAtoJigyosha(Button btnAtoJigyosha) {
        this.getKyufuJisseki().setBtnAtoJigyosha(btnAtoJigyosha);
    }

    @JsonIgnore
    public Button getBtnMaeJigyosha() {
        return this.getKyufuJisseki().getBtnMaeJigyosha();
    }

    @JsonIgnore
    public void setBtnMaeJigyosha(Button btnMaeJigyosha) {
        this.getKyufuJisseki().setBtnMaeJigyosha(btnMaeJigyosha);
    }

    @JsonIgnore
    public IKyufuJissekiHeaderDiv getCcdKyufuJissekiHeader() {
        return null;//this.getKyufuJisseki().getCcdKyufuJissekiHeader();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTekiyo() {
        return this.getKyufuJissekiTekiyoPanel().getTxtTekiyo();
    }

    @JsonIgnore
    public void setTxtTekiyo(TextBoxMultiLine txtTekiyo) {
        this.getKyufuJissekiTekiyoPanel().setTxtTekiyo(txtTekiyo);
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiTekiyoClose() {
        return this.getKyufuJissekiTekiyoPanel().getBtnKyufuJissekiTekiyoClose();
    }

    @JsonIgnore
    public void setBtnKyufuJissekiTekiyoClose(Button btnKyufuJissekiTekiyoClose) {
        this.getKyufuJissekiTekiyoPanel().setBtnKyufuJissekiTekiyoClose(btnKyufuJissekiTekiyoClose);
    }

    // </editor-fold>
}
