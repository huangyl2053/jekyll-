package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonProperty("txtKyufuJissekiKihonSakuseiKubun")
    private TextBox txtKyufuJissekiKihonSakuseiKubun;
    @JsonProperty("txtKyufuJissekiKihonYokaigodo")
    private TextBox txtKyufuJissekiKihonYokaigodo;
    @JsonProperty("txtYukoKaishiYMD")
    private TextBoxDate txtYukoKaishiYMD;
    @JsonProperty("lblYukoKikan")
    private Label lblYukoKikan;
    @JsonProperty("txtYukoShuryoYMD")
    private TextBoxDate txtYukoShuryoYMD;
    @JsonProperty("txtKyufuJissekiKihonShinsaYM")
    private TextBoxDate txtKyufuJissekiKihonShinsaYM;
    @JsonProperty("txtKyufuJissekiKihonKeikokuKubun")
    private TextBox txtKyufuJissekiKihonKeikokuKubun;
    @JsonProperty("btnKyufuJissekiKihonGokei")
    private Button btnKyufuJissekiKihonGokei;
    @JsonProperty("KyufuJissekiKihonHihokensha")
    private KyufuJissekiKihonHihokenshaDiv KyufuJissekiKihonHihokensha;
    @JsonProperty("KyufuJissekiKihonKokiKorei")
    private KyufuJissekiKihonKokiKoreiDiv KyufuJissekiKihonKokiKorei;
    @JsonProperty("KyufuJissekiKihonKokuho")
    private KyufuJissekiKihonKokuhoDiv KyufuJissekiKihonKokuho;
    @JsonProperty("KyufuJissekiKihonKingaku")
    private KyufuJissekiKihonKingakuDiv KyufuJissekiKihonKingaku;
    @JsonProperty("KyufuJissekiKihonKyotakuServiceKeikaku")
    private KyufuJissekiKihonKyotakuServiceKeikakuDiv KyufuJissekiKihonKyotakuServiceKeikaku;
    @JsonProperty("KyufuJissekiKihonServiceKikan")
    private KyufuJissekiKihonServiceKikanDiv KyufuJissekiKihonServiceKikan;
    @JsonProperty("KyufuJissekiKihonShisetsuNyutaisho")
    private KyufuJissekiKihonShisetsuNyutaishoDiv KyufuJissekiKihonShisetsuNyutaisho;
    @JsonProperty("KyufuJissekiKihonKyufuritsu")
    private KyufuJissekiKihonKyufuritsuDiv KyufuJissekiKihonKyufuritsu;
    @JsonProperty("KyufuJissekiKihonKohi")
    private KyufuJissekiKihonKohiDiv KyufuJissekiKihonKohi;
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
    @JsonProperty("KyufuJissekiKihonGokeiPanel")
    private KyufuJissekiKihonGokeiPanelDiv KyufuJissekiKihonGokeiPanel;
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
     * gettxtKyufuJissekiKihonSakuseiKubun
     * @return txtKyufuJissekiKihonSakuseiKubun
     */
    @JsonProperty("txtKyufuJissekiKihonSakuseiKubun")
    public TextBox getTxtKyufuJissekiKihonSakuseiKubun() {
        return txtKyufuJissekiKihonSakuseiKubun;
    }

    /*
     * settxtKyufuJissekiKihonSakuseiKubun
     * @param txtKyufuJissekiKihonSakuseiKubun txtKyufuJissekiKihonSakuseiKubun
     */
    @JsonProperty("txtKyufuJissekiKihonSakuseiKubun")
    public void setTxtKyufuJissekiKihonSakuseiKubun(TextBox txtKyufuJissekiKihonSakuseiKubun) {
        this.txtKyufuJissekiKihonSakuseiKubun = txtKyufuJissekiKihonSakuseiKubun;
    }

    /*
     * gettxtKyufuJissekiKihonYokaigodo
     * @return txtKyufuJissekiKihonYokaigodo
     */
    @JsonProperty("txtKyufuJissekiKihonYokaigodo")
    public TextBox getTxtKyufuJissekiKihonYokaigodo() {
        return txtKyufuJissekiKihonYokaigodo;
    }

    /*
     * settxtKyufuJissekiKihonYokaigodo
     * @param txtKyufuJissekiKihonYokaigodo txtKyufuJissekiKihonYokaigodo
     */
    @JsonProperty("txtKyufuJissekiKihonYokaigodo")
    public void setTxtKyufuJissekiKihonYokaigodo(TextBox txtKyufuJissekiKihonYokaigodo) {
        this.txtKyufuJissekiKihonYokaigodo = txtKyufuJissekiKihonYokaigodo;
    }

    /*
     * gettxtYukoKaishiYMD
     * @return txtYukoKaishiYMD
     */
    @JsonProperty("txtYukoKaishiYMD")
    public TextBoxDate getTxtYukoKaishiYMD() {
        return txtYukoKaishiYMD;
    }

    /*
     * settxtYukoKaishiYMD
     * @param txtYukoKaishiYMD txtYukoKaishiYMD
     */
    @JsonProperty("txtYukoKaishiYMD")
    public void setTxtYukoKaishiYMD(TextBoxDate txtYukoKaishiYMD) {
        this.txtYukoKaishiYMD = txtYukoKaishiYMD;
    }

    /*
     * getlblYukoKikan
     * @return lblYukoKikan
     */
    @JsonProperty("lblYukoKikan")
    public Label getLblYukoKikan() {
        return lblYukoKikan;
    }

    /*
     * setlblYukoKikan
     * @param lblYukoKikan lblYukoKikan
     */
    @JsonProperty("lblYukoKikan")
    public void setLblYukoKikan(Label lblYukoKikan) {
        this.lblYukoKikan = lblYukoKikan;
    }

    /*
     * gettxtYukoShuryoYMD
     * @return txtYukoShuryoYMD
     */
    @JsonProperty("txtYukoShuryoYMD")
    public TextBoxDate getTxtYukoShuryoYMD() {
        return txtYukoShuryoYMD;
    }

    /*
     * settxtYukoShuryoYMD
     * @param txtYukoShuryoYMD txtYukoShuryoYMD
     */
    @JsonProperty("txtYukoShuryoYMD")
    public void setTxtYukoShuryoYMD(TextBoxDate txtYukoShuryoYMD) {
        this.txtYukoShuryoYMD = txtYukoShuryoYMD;
    }

    /*
     * gettxtKyufuJissekiKihonShinsaYM
     * @return txtKyufuJissekiKihonShinsaYM
     */
    @JsonProperty("txtKyufuJissekiKihonShinsaYM")
    public TextBoxDate getTxtKyufuJissekiKihonShinsaYM() {
        return txtKyufuJissekiKihonShinsaYM;
    }

    /*
     * settxtKyufuJissekiKihonShinsaYM
     * @param txtKyufuJissekiKihonShinsaYM txtKyufuJissekiKihonShinsaYM
     */
    @JsonProperty("txtKyufuJissekiKihonShinsaYM")
    public void setTxtKyufuJissekiKihonShinsaYM(TextBoxDate txtKyufuJissekiKihonShinsaYM) {
        this.txtKyufuJissekiKihonShinsaYM = txtKyufuJissekiKihonShinsaYM;
    }

    /*
     * gettxtKyufuJissekiKihonKeikokuKubun
     * @return txtKyufuJissekiKihonKeikokuKubun
     */
    @JsonProperty("txtKyufuJissekiKihonKeikokuKubun")
    public TextBox getTxtKyufuJissekiKihonKeikokuKubun() {
        return txtKyufuJissekiKihonKeikokuKubun;
    }

    /*
     * settxtKyufuJissekiKihonKeikokuKubun
     * @param txtKyufuJissekiKihonKeikokuKubun txtKyufuJissekiKihonKeikokuKubun
     */
    @JsonProperty("txtKyufuJissekiKihonKeikokuKubun")
    public void setTxtKyufuJissekiKihonKeikokuKubun(TextBox txtKyufuJissekiKihonKeikokuKubun) {
        this.txtKyufuJissekiKihonKeikokuKubun = txtKyufuJissekiKihonKeikokuKubun;
    }

    /*
     * getbtnKyufuJissekiKihonGokei
     * @return btnKyufuJissekiKihonGokei
     */
    @JsonProperty("btnKyufuJissekiKihonGokei")
    public Button getBtnKyufuJissekiKihonGokei() {
        return btnKyufuJissekiKihonGokei;
    }

    /*
     * setbtnKyufuJissekiKihonGokei
     * @param btnKyufuJissekiKihonGokei btnKyufuJissekiKihonGokei
     */
    @JsonProperty("btnKyufuJissekiKihonGokei")
    public void setBtnKyufuJissekiKihonGokei(Button btnKyufuJissekiKihonGokei) {
        this.btnKyufuJissekiKihonGokei = btnKyufuJissekiKihonGokei;
    }

    /*
     * getKyufuJissekiKihonHihokensha
     * @return KyufuJissekiKihonHihokensha
     */
    @JsonProperty("KyufuJissekiKihonHihokensha")
    public KyufuJissekiKihonHihokenshaDiv getKyufuJissekiKihonHihokensha() {
        return KyufuJissekiKihonHihokensha;
    }

    /*
     * setKyufuJissekiKihonHihokensha
     * @param KyufuJissekiKihonHihokensha KyufuJissekiKihonHihokensha
     */
    @JsonProperty("KyufuJissekiKihonHihokensha")
    public void setKyufuJissekiKihonHihokensha(KyufuJissekiKihonHihokenshaDiv KyufuJissekiKihonHihokensha) {
        this.KyufuJissekiKihonHihokensha = KyufuJissekiKihonHihokensha;
    }

    /*
     * getKyufuJissekiKihonKokiKorei
     * @return KyufuJissekiKihonKokiKorei
     */
    @JsonProperty("KyufuJissekiKihonKokiKorei")
    public KyufuJissekiKihonKokiKoreiDiv getKyufuJissekiKihonKokiKorei() {
        return KyufuJissekiKihonKokiKorei;
    }

    /*
     * setKyufuJissekiKihonKokiKorei
     * @param KyufuJissekiKihonKokiKorei KyufuJissekiKihonKokiKorei
     */
    @JsonProperty("KyufuJissekiKihonKokiKorei")
    public void setKyufuJissekiKihonKokiKorei(KyufuJissekiKihonKokiKoreiDiv KyufuJissekiKihonKokiKorei) {
        this.KyufuJissekiKihonKokiKorei = KyufuJissekiKihonKokiKorei;
    }

    /*
     * getKyufuJissekiKihonKokuho
     * @return KyufuJissekiKihonKokuho
     */
    @JsonProperty("KyufuJissekiKihonKokuho")
    public KyufuJissekiKihonKokuhoDiv getKyufuJissekiKihonKokuho() {
        return KyufuJissekiKihonKokuho;
    }

    /*
     * setKyufuJissekiKihonKokuho
     * @param KyufuJissekiKihonKokuho KyufuJissekiKihonKokuho
     */
    @JsonProperty("KyufuJissekiKihonKokuho")
    public void setKyufuJissekiKihonKokuho(KyufuJissekiKihonKokuhoDiv KyufuJissekiKihonKokuho) {
        this.KyufuJissekiKihonKokuho = KyufuJissekiKihonKokuho;
    }

    /*
     * getKyufuJissekiKihonKingaku
     * @return KyufuJissekiKihonKingaku
     */
    @JsonProperty("KyufuJissekiKihonKingaku")
    public KyufuJissekiKihonKingakuDiv getKyufuJissekiKihonKingaku() {
        return KyufuJissekiKihonKingaku;
    }

    /*
     * setKyufuJissekiKihonKingaku
     * @param KyufuJissekiKihonKingaku KyufuJissekiKihonKingaku
     */
    @JsonProperty("KyufuJissekiKihonKingaku")
    public void setKyufuJissekiKihonKingaku(KyufuJissekiKihonKingakuDiv KyufuJissekiKihonKingaku) {
        this.KyufuJissekiKihonKingaku = KyufuJissekiKihonKingaku;
    }

    /*
     * getKyufuJissekiKihonKyotakuServiceKeikaku
     * @return KyufuJissekiKihonKyotakuServiceKeikaku
     */
    @JsonProperty("KyufuJissekiKihonKyotakuServiceKeikaku")
    public KyufuJissekiKihonKyotakuServiceKeikakuDiv getKyufuJissekiKihonKyotakuServiceKeikaku() {
        return KyufuJissekiKihonKyotakuServiceKeikaku;
    }

    /*
     * setKyufuJissekiKihonKyotakuServiceKeikaku
     * @param KyufuJissekiKihonKyotakuServiceKeikaku KyufuJissekiKihonKyotakuServiceKeikaku
     */
    @JsonProperty("KyufuJissekiKihonKyotakuServiceKeikaku")
    public void setKyufuJissekiKihonKyotakuServiceKeikaku(KyufuJissekiKihonKyotakuServiceKeikakuDiv KyufuJissekiKihonKyotakuServiceKeikaku) {
        this.KyufuJissekiKihonKyotakuServiceKeikaku = KyufuJissekiKihonKyotakuServiceKeikaku;
    }

    /*
     * getKyufuJissekiKihonServiceKikan
     * @return KyufuJissekiKihonServiceKikan
     */
    @JsonProperty("KyufuJissekiKihonServiceKikan")
    public KyufuJissekiKihonServiceKikanDiv getKyufuJissekiKihonServiceKikan() {
        return KyufuJissekiKihonServiceKikan;
    }

    /*
     * setKyufuJissekiKihonServiceKikan
     * @param KyufuJissekiKihonServiceKikan KyufuJissekiKihonServiceKikan
     */
    @JsonProperty("KyufuJissekiKihonServiceKikan")
    public void setKyufuJissekiKihonServiceKikan(KyufuJissekiKihonServiceKikanDiv KyufuJissekiKihonServiceKikan) {
        this.KyufuJissekiKihonServiceKikan = KyufuJissekiKihonServiceKikan;
    }

    /*
     * getKyufuJissekiKihonShisetsuNyutaisho
     * @return KyufuJissekiKihonShisetsuNyutaisho
     */
    @JsonProperty("KyufuJissekiKihonShisetsuNyutaisho")
    public KyufuJissekiKihonShisetsuNyutaishoDiv getKyufuJissekiKihonShisetsuNyutaisho() {
        return KyufuJissekiKihonShisetsuNyutaisho;
    }

    /*
     * setKyufuJissekiKihonShisetsuNyutaisho
     * @param KyufuJissekiKihonShisetsuNyutaisho KyufuJissekiKihonShisetsuNyutaisho
     */
    @JsonProperty("KyufuJissekiKihonShisetsuNyutaisho")
    public void setKyufuJissekiKihonShisetsuNyutaisho(KyufuJissekiKihonShisetsuNyutaishoDiv KyufuJissekiKihonShisetsuNyutaisho) {
        this.KyufuJissekiKihonShisetsuNyutaisho = KyufuJissekiKihonShisetsuNyutaisho;
    }

    /*
     * getKyufuJissekiKihonKyufuritsu
     * @return KyufuJissekiKihonKyufuritsu
     */
    @JsonProperty("KyufuJissekiKihonKyufuritsu")
    public KyufuJissekiKihonKyufuritsuDiv getKyufuJissekiKihonKyufuritsu() {
        return KyufuJissekiKihonKyufuritsu;
    }

    /*
     * setKyufuJissekiKihonKyufuritsu
     * @param KyufuJissekiKihonKyufuritsu KyufuJissekiKihonKyufuritsu
     */
    @JsonProperty("KyufuJissekiKihonKyufuritsu")
    public void setKyufuJissekiKihonKyufuritsu(KyufuJissekiKihonKyufuritsuDiv KyufuJissekiKihonKyufuritsu) {
        this.KyufuJissekiKihonKyufuritsu = KyufuJissekiKihonKyufuritsu;
    }

    /*
     * getKyufuJissekiKihonKohi
     * @return KyufuJissekiKihonKohi
     */
    @JsonProperty("KyufuJissekiKihonKohi")
    public KyufuJissekiKihonKohiDiv getKyufuJissekiKihonKohi() {
        return KyufuJissekiKihonKohi;
    }

    /*
     * setKyufuJissekiKihonKohi
     * @param KyufuJissekiKihonKohi KyufuJissekiKihonKohi
     */
    @JsonProperty("KyufuJissekiKihonKohi")
    public void setKyufuJissekiKihonKohi(KyufuJissekiKihonKohiDiv KyufuJissekiKihonKohi) {
        this.KyufuJissekiKihonKohi = KyufuJissekiKihonKohi;
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
     * getKyufuJissekiKihonGokeiPanel
     * @return KyufuJissekiKihonGokeiPanel
     */
    @JsonProperty("KyufuJissekiKihonGokeiPanel")
    public KyufuJissekiKihonGokeiPanelDiv getKyufuJissekiKihonGokeiPanel() {
        return KyufuJissekiKihonGokeiPanel;
    }

    /*
     * setKyufuJissekiKihonGokeiPanel
     * @param KyufuJissekiKihonGokeiPanel KyufuJissekiKihonGokeiPanel
     */
    @JsonProperty("KyufuJissekiKihonGokeiPanel")
    public void setKyufuJissekiKihonGokeiPanel(KyufuJissekiKihonGokeiPanelDiv KyufuJissekiKihonGokeiPanel) {
        this.KyufuJissekiKihonGokeiPanel = KyufuJissekiKihonGokeiPanel;
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
    public TextBox getTxtKyufuJissekiKihonKokiKoreiHokenshaNo() {
        return this.getKyufuJissekiKihonKokiKorei().getTxtKyufuJissekiKihonKokiKoreiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiKihonKokiKoreiHokenshaNo(TextBox txtKyufuJissekiKihonKokiKoreiHokenshaNo) {
        this.getKyufuJissekiKihonKokiKorei().setTxtKyufuJissekiKihonKokiKoreiHokenshaNo(txtKyufuJissekiKihonKokiKoreiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo() {
        return this.getKyufuJissekiKihonKokiKorei().getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiKihonKokiKoreiHihokenshaNo(TextBox txtKyufuJissekiKihonKokiKoreiHihokenshaNo) {
        this.getKyufuJissekiKihonKokiKorei().setTxtKyufuJissekiKihonKokiKoreiHihokenshaNo(txtKyufuJissekiKihonKokiKoreiHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKokuhoHokenshaNo() {
        return this.getKyufuJissekiKihonKokuho().getTxtKyufuJissekiKihonKokuhoHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiKihonKokuhoHokenshaNo(TextBox txtKyufuJissekiKihonKokuhoHokenshaNo) {
        this.getKyufuJissekiKihonKokuho().setTxtKyufuJissekiKihonKokuhoHokenshaNo(txtKyufuJissekiKihonKokuhoHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKokuhoHihokenshashoNo() {
        return this.getKyufuJissekiKihonKokuho().getTxtKyufuJissekiKihonKokuhoHihokenshashoNo();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiKihonKokuhoHihokenshashoNo(TextBox txtKyufuJissekiKihonKokuhoHihokenshashoNo) {
        this.getKyufuJissekiKihonKokuho().setTxtKyufuJissekiKihonKokuhoHihokenshashoNo(txtKyufuJissekiKihonKokuhoHihokenshashoNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKokuhoKojinNo() {
        return this.getKyufuJissekiKihonKokuho().getTxtKyufuJissekiKihonKokuhoKojinNo();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiKihonKokuhoKojinNo(TextBox txtKyufuJissekiKihonKokuhoKojinNo) {
        this.getKyufuJissekiKihonKokuho().setTxtKyufuJissekiKihonKokuhoKojinNo(txtKyufuJissekiKihonKokuhoKojinNo);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTankasu() {
        return this.getKyufuJissekiKihonKingaku().getTxtServiceTankasu();
    }

    @JsonIgnore
    public void  setTxtServiceTankasu(TextBoxNum txtServiceTankasu) {
        this.getKyufuJissekiKihonKingaku().setTxtServiceTankasu(txtServiceTankasu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoSeikyuGaku() {
        return this.getKyufuJissekiKihonKingaku().getTxtHokenryoSeikyuGaku();
    }

    @JsonIgnore
    public void  setTxtHokenryoSeikyuGaku(TextBoxNum txtHokenryoSeikyuGaku) {
        this.getKyufuJissekiKihonKingaku().setTxtHokenryoSeikyuGaku(txtHokenryoSeikyuGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanGaku() {
        return this.getKyufuJissekiKihonKingaku().getTxtRiyoshaFutanGaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGaku(TextBoxNum txtRiyoshaFutanGaku) {
        this.getKyufuJissekiKihonKingaku().setTxtRiyoshaFutanGaku(txtRiyoshaFutanGaku);
    }

    // </editor-fold>
}
