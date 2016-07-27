package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.IKyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.KyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJisseki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
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
    @JsonProperty("lblShukeijoho")
    private Label lblShukeijoho;
    @JsonProperty("dgKyufuJissekiShukei")
    private DataGrid<dgKyufuJissekiShukei_Row> dgKyufuJissekiShukei;
    @JsonProperty("lblMeisaijoho")
    private Label lblMeisaijoho;
    @JsonProperty("dgKyufuJissekiMeisai")
    private DataGrid<dgKyufuJissekiMeisai_Row> dgKyufuJissekiMeisai;
    @JsonProperty("lblMeisaiJohoJushochitokurei")
    private Label lblMeisaiJohoJushochitokurei;
    @JsonProperty("dgKyufuJissekiMeisaiJustoku")
    private DataGrid<dgKyufuJissekiMeisaiJustoku_Row> dgKyufuJissekiMeisaiJustoku;
    @JsonProperty("linButtonArea3")
    private HorizontalLine linButtonArea3;
    @JsonProperty("btnJigetsu")
    private Button btnJigetsu;
    @JsonProperty("btnZengetsu")
    private Button btnZengetsu;
    @JsonProperty("btnAtoJigyosha")
    private Button btnAtoJigyosha;
    @JsonProperty("btnMaeJigyosha")
    private Button btnMaeJigyosha;
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
     * getlblShukeijoho
     * @return lblShukeijoho
     */
    @JsonProperty("lblShukeijoho")
    public Label getLblShukeijoho() {
        return lblShukeijoho;
    }

    /*
     * setlblShukeijoho
     * @param lblShukeijoho lblShukeijoho
     */
    @JsonProperty("lblShukeijoho")
    public void setLblShukeijoho(Label lblShukeijoho) {
        this.lblShukeijoho = lblShukeijoho;
    }

    /*
     * getdgKyufuJissekiShukei
     * @return dgKyufuJissekiShukei
     */
    @JsonProperty("dgKyufuJissekiShukei")
    public DataGrid<dgKyufuJissekiShukei_Row> getDgKyufuJissekiShukei() {
        return dgKyufuJissekiShukei;
    }

    /*
     * setdgKyufuJissekiShukei
     * @param dgKyufuJissekiShukei dgKyufuJissekiShukei
     */
    @JsonProperty("dgKyufuJissekiShukei")
    public void setDgKyufuJissekiShukei(DataGrid<dgKyufuJissekiShukei_Row> dgKyufuJissekiShukei) {
        this.dgKyufuJissekiShukei = dgKyufuJissekiShukei;
    }

    /*
     * getlblMeisaijoho
     * @return lblMeisaijoho
     */
    @JsonProperty("lblMeisaijoho")
    public Label getLblMeisaijoho() {
        return lblMeisaijoho;
    }

    /*
     * setlblMeisaijoho
     * @param lblMeisaijoho lblMeisaijoho
     */
    @JsonProperty("lblMeisaijoho")
    public void setLblMeisaijoho(Label lblMeisaijoho) {
        this.lblMeisaijoho = lblMeisaijoho;
    }

    /*
     * getdgKyufuJissekiMeisai
     * @return dgKyufuJissekiMeisai
     */
    @JsonProperty("dgKyufuJissekiMeisai")
    public DataGrid<dgKyufuJissekiMeisai_Row> getDgKyufuJissekiMeisai() {
        return dgKyufuJissekiMeisai;
    }

    /*
     * setdgKyufuJissekiMeisai
     * @param dgKyufuJissekiMeisai dgKyufuJissekiMeisai
     */
    @JsonProperty("dgKyufuJissekiMeisai")
    public void setDgKyufuJissekiMeisai(DataGrid<dgKyufuJissekiMeisai_Row> dgKyufuJissekiMeisai) {
        this.dgKyufuJissekiMeisai = dgKyufuJissekiMeisai;
    }

    /*
     * getlblMeisaiJohoJushochitokurei
     * @return lblMeisaiJohoJushochitokurei
     */
    @JsonProperty("lblMeisaiJohoJushochitokurei")
    public Label getLblMeisaiJohoJushochitokurei() {
        return lblMeisaiJohoJushochitokurei;
    }

    /*
     * setlblMeisaiJohoJushochitokurei
     * @param lblMeisaiJohoJushochitokurei lblMeisaiJohoJushochitokurei
     */
    @JsonProperty("lblMeisaiJohoJushochitokurei")
    public void setLblMeisaiJohoJushochitokurei(Label lblMeisaiJohoJushochitokurei) {
        this.lblMeisaiJohoJushochitokurei = lblMeisaiJohoJushochitokurei;
    }

    /*
     * getdgKyufuJissekiMeisaiJustoku
     * @return dgKyufuJissekiMeisaiJustoku
     */
    @JsonProperty("dgKyufuJissekiMeisaiJustoku")
    public DataGrid<dgKyufuJissekiMeisaiJustoku_Row> getDgKyufuJissekiMeisaiJustoku() {
        return dgKyufuJissekiMeisaiJustoku;
    }

    /*
     * setdgKyufuJissekiMeisaiJustoku
     * @param dgKyufuJissekiMeisaiJustoku dgKyufuJissekiMeisaiJustoku
     */
    @JsonProperty("dgKyufuJissekiMeisaiJustoku")
    public void setDgKyufuJissekiMeisaiJustoku(DataGrid<dgKyufuJissekiMeisaiJustoku_Row> dgKyufuJissekiMeisaiJustoku) {
        this.dgKyufuJissekiMeisaiJustoku = dgKyufuJissekiMeisaiJustoku;
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
     * getbtnJigetsu
     * @return btnJigetsu
     */
    @JsonProperty("btnJigetsu")
    public Button getBtnJigetsu() {
        return btnJigetsu;
    }

    /*
     * setbtnJigetsu
     * @param btnJigetsu btnJigetsu
     */
    @JsonProperty("btnJigetsu")
    public void setBtnJigetsu(Button btnJigetsu) {
        this.btnJigetsu = btnJigetsu;
    }

    /*
     * getbtnZengetsu
     * @return btnZengetsu
     */
    @JsonProperty("btnZengetsu")
    public Button getBtnZengetsu() {
        return btnZengetsu;
    }

    /*
     * setbtnZengetsu
     * @param btnZengetsu btnZengetsu
     */
    @JsonProperty("btnZengetsu")
    public void setBtnZengetsu(Button btnZengetsu) {
        this.btnZengetsu = btnZengetsu;
    }

    /*
     * getbtnAtoJigyosha
     * @return btnAtoJigyosha
     */
    @JsonProperty("btnAtoJigyosha")
    public Button getBtnAtoJigyosha() {
        return btnAtoJigyosha;
    }

    /*
     * setbtnAtoJigyosha
     * @param btnAtoJigyosha btnAtoJigyosha
     */
    @JsonProperty("btnAtoJigyosha")
    public void setBtnAtoJigyosha(Button btnAtoJigyosha) {
        this.btnAtoJigyosha = btnAtoJigyosha;
    }

    /*
     * getbtnMaeJigyosha
     * @return btnMaeJigyosha
     */
    @JsonProperty("btnMaeJigyosha")
    public Button getBtnMaeJigyosha() {
        return btnMaeJigyosha;
    }

    /*
     * setbtnMaeJigyosha
     * @param btnMaeJigyosha btnMaeJigyosha
     */
    @JsonProperty("btnMaeJigyosha")
    public void setBtnMaeJigyosha(Button btnMaeJigyosha) {
        this.btnMaeJigyosha = btnMaeJigyosha;
    }

    /*
     * getccdKyufuJissekiHeader
     * @return ccdKyufuJissekiHeader
     */
    @JsonProperty("ccdKyufuJissekiHeader")
    public IKyufuJissekiHeaderDiv getCcdKyufuJissekiHeader() {
        return ccdKyufuJissekiHeader;
    }

    // </editor-fold>
}
