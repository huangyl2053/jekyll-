package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader.IKyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader.KyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuServiceKeikakuhi のクラスファイル
 *
 * @author 自動生成
 */
public class KyotakuServiceKeikakuhiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linButtonArea1")
    private HorizontalLine linButtonArea1;
    @JsonProperty("btnKihon")
    private Button btnKihon;
    @JsonProperty("btnMeisaiShukei")
    private Button btnMeisaiShukei;
    @JsonProperty("btnKinkyujiShisetsuRyoyo")
    private Button btnKinkyujiShisetsuRyoyo;
    @JsonProperty("btnShoteiShikkanShisetsuRyoyo")
    private Button btnShoteiShikkanShisetsuRyoyo;
    @JsonProperty("btnShokuji")
    private Button btnShokuji;
    @JsonProperty("btnFukushiYoguKonyu")
    private Button btnFukushiYoguKonyu;
    @JsonProperty("btnTokuteiNyushosha")
    private Button btnTokuteiNyushosha;
    @JsonProperty("btnKogakuKaigoService")
    private Button btnKogakuKaigoService;
    @JsonProperty("btnTokuteiShinryo")
    private Button btnTokuteiShinryo;
    @JsonProperty("btnKyotakuServiceKeikaku")
    private Button btnKyotakuServiceKeikaku;
    @JsonProperty("btnJutakuKaishu")
    private Button btnJutakuKaishu;
    @JsonProperty("btnCareManagement")
    private Button btnCareManagement;
    @JsonProperty("btnShafukuKeigen")
    private Button btnShafukuKeigen;
    @JsonProperty("linButtonArea2")
    private HorizontalLine linButtonArea2;
    @JsonProperty("ServiceKeikakuhiFromH2104Panel")
    private ServiceKeikakuhiFromH2104PanelDiv ServiceKeikakuhiFromH2104Panel;
    @JsonProperty("ServiceKeikakuhiToH2103Panel")
    private ServiceKeikakuhiToH2103PanelDiv ServiceKeikakuhiToH2103Panel;
    @JsonProperty("linButtonArea3")
    private HorizontalLine linButtonArea3;
    @JsonProperty("ccdKyufuJissekiHeader")
    private KyufuJissekiHeaderDiv ccdKyufuJissekiHeader;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinButtonArea1
     * @return linButtonArea1
     */
    @JsonProperty("linButtonArea1")
    public HorizontalLine getLinButtonArea1() {
        return linButtonArea1;
    }

    /*
     * setlinButtonArea1
     * @param linButtonArea1 linButtonArea1
     */
    @JsonProperty("linButtonArea1")
    public void setLinButtonArea1(HorizontalLine linButtonArea1) {
        this.linButtonArea1 = linButtonArea1;
    }

    /*
     * getbtnKihon
     * @return btnKihon
     */
    @JsonProperty("btnKihon")
    public Button getBtnKihon() {
        return btnKihon;
    }

    /*
     * setbtnKihon
     * @param btnKihon btnKihon
     */
    @JsonProperty("btnKihon")
    public void setBtnKihon(Button btnKihon) {
        this.btnKihon = btnKihon;
    }

    /*
     * getbtnMeisaiShukei
     * @return btnMeisaiShukei
     */
    @JsonProperty("btnMeisaiShukei")
    public Button getBtnMeisaiShukei() {
        return btnMeisaiShukei;
    }

    /*
     * setbtnMeisaiShukei
     * @param btnMeisaiShukei btnMeisaiShukei
     */
    @JsonProperty("btnMeisaiShukei")
    public void setBtnMeisaiShukei(Button btnMeisaiShukei) {
        this.btnMeisaiShukei = btnMeisaiShukei;
    }

    /*
     * getbtnKinkyujiShisetsuRyoyo
     * @return btnKinkyujiShisetsuRyoyo
     */
    @JsonProperty("btnKinkyujiShisetsuRyoyo")
    public Button getBtnKinkyujiShisetsuRyoyo() {
        return btnKinkyujiShisetsuRyoyo;
    }

    /*
     * setbtnKinkyujiShisetsuRyoyo
     * @param btnKinkyujiShisetsuRyoyo btnKinkyujiShisetsuRyoyo
     */
    @JsonProperty("btnKinkyujiShisetsuRyoyo")
    public void setBtnKinkyujiShisetsuRyoyo(Button btnKinkyujiShisetsuRyoyo) {
        this.btnKinkyujiShisetsuRyoyo = btnKinkyujiShisetsuRyoyo;
    }

    /*
     * getbtnShoteiShikkanShisetsuRyoyo
     * @return btnShoteiShikkanShisetsuRyoyo
     */
    @JsonProperty("btnShoteiShikkanShisetsuRyoyo")
    public Button getBtnShoteiShikkanShisetsuRyoyo() {
        return btnShoteiShikkanShisetsuRyoyo;
    }

    /*
     * setbtnShoteiShikkanShisetsuRyoyo
     * @param btnShoteiShikkanShisetsuRyoyo btnShoteiShikkanShisetsuRyoyo
     */
    @JsonProperty("btnShoteiShikkanShisetsuRyoyo")
    public void setBtnShoteiShikkanShisetsuRyoyo(Button btnShoteiShikkanShisetsuRyoyo) {
        this.btnShoteiShikkanShisetsuRyoyo = btnShoteiShikkanShisetsuRyoyo;
    }

    /*
     * getbtnShokuji
     * @return btnShokuji
     */
    @JsonProperty("btnShokuji")
    public Button getBtnShokuji() {
        return btnShokuji;
    }

    /*
     * setbtnShokuji
     * @param btnShokuji btnShokuji
     */
    @JsonProperty("btnShokuji")
    public void setBtnShokuji(Button btnShokuji) {
        this.btnShokuji = btnShokuji;
    }

    /*
     * getbtnFukushiYoguKonyu
     * @return btnFukushiYoguKonyu
     */
    @JsonProperty("btnFukushiYoguKonyu")
    public Button getBtnFukushiYoguKonyu() {
        return btnFukushiYoguKonyu;
    }

    /*
     * setbtnFukushiYoguKonyu
     * @param btnFukushiYoguKonyu btnFukushiYoguKonyu
     */
    @JsonProperty("btnFukushiYoguKonyu")
    public void setBtnFukushiYoguKonyu(Button btnFukushiYoguKonyu) {
        this.btnFukushiYoguKonyu = btnFukushiYoguKonyu;
    }

    /*
     * getbtnTokuteiNyushosha
     * @return btnTokuteiNyushosha
     */
    @JsonProperty("btnTokuteiNyushosha")
    public Button getBtnTokuteiNyushosha() {
        return btnTokuteiNyushosha;
    }

    /*
     * setbtnTokuteiNyushosha
     * @param btnTokuteiNyushosha btnTokuteiNyushosha
     */
    @JsonProperty("btnTokuteiNyushosha")
    public void setBtnTokuteiNyushosha(Button btnTokuteiNyushosha) {
        this.btnTokuteiNyushosha = btnTokuteiNyushosha;
    }

    /*
     * getbtnKogakuKaigoService
     * @return btnKogakuKaigoService
     */
    @JsonProperty("btnKogakuKaigoService")
    public Button getBtnKogakuKaigoService() {
        return btnKogakuKaigoService;
    }

    /*
     * setbtnKogakuKaigoService
     * @param btnKogakuKaigoService btnKogakuKaigoService
     */
    @JsonProperty("btnKogakuKaigoService")
    public void setBtnKogakuKaigoService(Button btnKogakuKaigoService) {
        this.btnKogakuKaigoService = btnKogakuKaigoService;
    }

    /*
     * getbtnTokuteiShinryo
     * @return btnTokuteiShinryo
     */
    @JsonProperty("btnTokuteiShinryo")
    public Button getBtnTokuteiShinryo() {
        return btnTokuteiShinryo;
    }

    /*
     * setbtnTokuteiShinryo
     * @param btnTokuteiShinryo btnTokuteiShinryo
     */
    @JsonProperty("btnTokuteiShinryo")
    public void setBtnTokuteiShinryo(Button btnTokuteiShinryo) {
        this.btnTokuteiShinryo = btnTokuteiShinryo;
    }

    /*
     * getbtnKyotakuServiceKeikaku
     * @return btnKyotakuServiceKeikaku
     */
    @JsonProperty("btnKyotakuServiceKeikaku")
    public Button getBtnKyotakuServiceKeikaku() {
        return btnKyotakuServiceKeikaku;
    }

    /*
     * setbtnKyotakuServiceKeikaku
     * @param btnKyotakuServiceKeikaku btnKyotakuServiceKeikaku
     */
    @JsonProperty("btnKyotakuServiceKeikaku")
    public void setBtnKyotakuServiceKeikaku(Button btnKyotakuServiceKeikaku) {
        this.btnKyotakuServiceKeikaku = btnKyotakuServiceKeikaku;
    }

    /*
     * getbtnJutakuKaishu
     * @return btnJutakuKaishu
     */
    @JsonProperty("btnJutakuKaishu")
    public Button getBtnJutakuKaishu() {
        return btnJutakuKaishu;
    }

    /*
     * setbtnJutakuKaishu
     * @param btnJutakuKaishu btnJutakuKaishu
     */
    @JsonProperty("btnJutakuKaishu")
    public void setBtnJutakuKaishu(Button btnJutakuKaishu) {
        this.btnJutakuKaishu = btnJutakuKaishu;
    }

    /*
     * getbtnCareManagement
     * @return btnCareManagement
     */
    @JsonProperty("btnCareManagement")
    public Button getBtnCareManagement() {
        return btnCareManagement;
    }

    /*
     * setbtnCareManagement
     * @param btnCareManagement btnCareManagement
     */
    @JsonProperty("btnCareManagement")
    public void setBtnCareManagement(Button btnCareManagement) {
        this.btnCareManagement = btnCareManagement;
    }

    /*
     * getbtnShafukuKeigen
     * @return btnShafukuKeigen
     */
    @JsonProperty("btnShafukuKeigen")
    public Button getBtnShafukuKeigen() {
        return btnShafukuKeigen;
    }

    /*
     * setbtnShafukuKeigen
     * @param btnShafukuKeigen btnShafukuKeigen
     */
    @JsonProperty("btnShafukuKeigen")
    public void setBtnShafukuKeigen(Button btnShafukuKeigen) {
        this.btnShafukuKeigen = btnShafukuKeigen;
    }

    /*
     * getlinButtonArea2
     * @return linButtonArea2
     */
    @JsonProperty("linButtonArea2")
    public HorizontalLine getLinButtonArea2() {
        return linButtonArea2;
    }

    /*
     * setlinButtonArea2
     * @param linButtonArea2 linButtonArea2
     */
    @JsonProperty("linButtonArea2")
    public void setLinButtonArea2(HorizontalLine linButtonArea2) {
        this.linButtonArea2 = linButtonArea2;
    }

    /*
     * getServiceKeikakuhiFromH2104Panel
     * @return ServiceKeikakuhiFromH2104Panel
     */
    @JsonProperty("ServiceKeikakuhiFromH2104Panel")
    public ServiceKeikakuhiFromH2104PanelDiv getServiceKeikakuhiFromH2104Panel() {
        return ServiceKeikakuhiFromH2104Panel;
    }

    /*
     * setServiceKeikakuhiFromH2104Panel
     * @param ServiceKeikakuhiFromH2104Panel ServiceKeikakuhiFromH2104Panel
     */
    @JsonProperty("ServiceKeikakuhiFromH2104Panel")
    public void setServiceKeikakuhiFromH2104Panel(ServiceKeikakuhiFromH2104PanelDiv ServiceKeikakuhiFromH2104Panel) {
        this.ServiceKeikakuhiFromH2104Panel = ServiceKeikakuhiFromH2104Panel;
    }

    /*
     * getServiceKeikakuhiToH2103Panel
     * @return ServiceKeikakuhiToH2103Panel
     */
    @JsonProperty("ServiceKeikakuhiToH2103Panel")
    public ServiceKeikakuhiToH2103PanelDiv getServiceKeikakuhiToH2103Panel() {
        return ServiceKeikakuhiToH2103Panel;
    }

    /*
     * setServiceKeikakuhiToH2103Panel
     * @param ServiceKeikakuhiToH2103Panel ServiceKeikakuhiToH2103Panel
     */
    @JsonProperty("ServiceKeikakuhiToH2103Panel")
    public void setServiceKeikakuhiToH2103Panel(ServiceKeikakuhiToH2103PanelDiv ServiceKeikakuhiToH2103Panel) {
        this.ServiceKeikakuhiToH2103Panel = ServiceKeikakuhiToH2103Panel;
    }

    /*
     * getlinButtonArea3
     * @return linButtonArea3
     */
    @JsonProperty("linButtonArea3")
    public HorizontalLine getLinButtonArea3() {
        return linButtonArea3;
    }

    /*
     * setlinButtonArea3
     * @param linButtonArea3 linButtonArea3
     */
    @JsonProperty("linButtonArea3")
    public void setLinButtonArea3(HorizontalLine linButtonArea3) {
        this.linButtonArea3 = linButtonArea3;
    }

    /*
     * getccdKyufuJissekiHeader
     * @return ccdKyufuJissekiHeader
     */
    @JsonProperty("ccdKyufuJissekiHeader")
    public IKyufuJissekiHeaderDiv getCcdKyufuJissekiHeader() {
        return ccdKyufuJissekiHeader;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTitle1() {
        return this.getServiceKeikakuhiFromH2104Panel().getLblTitle1();
    }

    @JsonIgnore
    public void setLblTitle1(Label lblTitle1) {
        this.getServiceKeikakuhiFromH2104Panel().setLblTitle1(lblTitle1);
    }

    @JsonIgnore
    public DataGrid<dgServiceKeikakuhiFromH2104_Row> getDgServiceKeikakuhiFromH2104() {
        return this.getServiceKeikakuhiFromH2104Panel().getDgServiceKeikakuhiFromH2104();
    }

    @JsonIgnore
    public void setDgServiceKeikakuhiFromH2104(DataGrid<dgServiceKeikakuhiFromH2104_Row> dgServiceKeikakuhiFromH2104) {
        this.getServiceKeikakuhiFromH2104Panel().setDgServiceKeikakuhiFromH2104(dgServiceKeikakuhiFromH2104);
    }

    @JsonIgnore
    public Label getLblTitle2() {
        return this.getServiceKeikakuhiToH2103Panel().getLblTitle2();
    }

    @JsonIgnore
    public void setLblTitle2(Label lblTitle2) {
        this.getServiceKeikakuhiToH2103Panel().setLblTitle2(lblTitle2);
    }

    @JsonIgnore
    public DataGrid<dgServiceKeikakuhiToH2103_Row> getDgServiceKeikakuhiToH2103() {
        return this.getServiceKeikakuhiToH2103Panel().getDgServiceKeikakuhiToH2103();
    }

    @JsonIgnore
    public void setDgServiceKeikakuhiToH2103(DataGrid<dgServiceKeikakuhiToH2103_Row> dgServiceKeikakuhiToH2103) {
        this.getServiceKeikakuhiToH2103Panel().setDgServiceKeikakuhiToH2103(dgServiceKeikakuhiToH2103);
    }

    // </editor-fold>
}
