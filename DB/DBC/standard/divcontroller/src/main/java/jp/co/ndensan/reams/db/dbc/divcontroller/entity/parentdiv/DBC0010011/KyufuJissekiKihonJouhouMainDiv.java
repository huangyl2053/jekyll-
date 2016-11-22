package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader.IKyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader.KyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * KyufuJissekiKihonJouhouMain のクラスファイル
 *
 * @author 自動生成
 */
public class KyufuJissekiKihonJouhouMainDiv extends Panel {

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
    @JsonProperty("btnMaeJigyosha")
    private Button btnMaeJigyosha;
    @JsonProperty("btnAtoJigyosha")
    private Button btnAtoJigyosha;
    @JsonProperty("btnZengetsu")
    private Button btnZengetsu;
    @JsonProperty("btnJigetsu")
    private Button btnJigetsu;
    @JsonProperty("KyufuJissekiKihonGokeiPanel")
    private KyufuJissekiKihonGokeiPanelDiv KyufuJissekiKihonGokeiPanel;
    @JsonProperty("ccdKyufuJissekiHeader")
    private KyufuJissekiHeaderDiv ccdKyufuJissekiHeader;
    @JsonProperty("hdnStartOrder")
    private RString hdnStartOrder;
    @JsonProperty("hdnEndOrder")
    private RString hdnEndOrder;
    @JsonProperty("hdnCurrentOrder")
    private RString hdnCurrentOrder;

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
     * gethdnStartOrder
     * @return hdnStartOrder
     */
    @JsonProperty("hdnStartOrder")
    public RString getHdnStartOrder() {
        return hdnStartOrder;
    }

    /*
     * sethdnStartOrder
     * @param hdnStartOrder hdnStartOrder
     */
    @JsonProperty("hdnStartOrder")
    public void setHdnStartOrder(RString hdnStartOrder) {
        this.hdnStartOrder = hdnStartOrder;
    }

    /*
     * gethdnEndOrder
     * @return hdnEndOrder
     */
    @JsonProperty("hdnEndOrder")
    public RString getHdnEndOrder() {
        return hdnEndOrder;
    }

    /*
     * sethdnEndOrder
     * @param hdnEndOrder hdnEndOrder
     */
    @JsonProperty("hdnEndOrder")
    public void setHdnEndOrder(RString hdnEndOrder) {
        this.hdnEndOrder = hdnEndOrder;
    }

    /*
     * gethdnCurrentOrder
     * @return hdnCurrentOrder
     */
    @JsonProperty("hdnCurrentOrder")
    public RString getHdnCurrentOrder() {
        return hdnCurrentOrder;
    }

    /*
     * sethdnCurrentOrder
     * @param hdnCurrentOrder hdnCurrentOrder
     */
    @JsonProperty("hdnCurrentOrder")
    public void setHdnCurrentOrder(RString hdnCurrentOrder) {
        this.hdnCurrentOrder = hdnCurrentOrder;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei() {
        return this.getKyufuJissekiKihonHihokensha().getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKyusochiNyushoshaTokurei(TextBox txtKyufuJissekiKihonKyusochiNyushoshaTokurei) {
        this.getKyufuJissekiKihonHihokensha().setTxtKyufuJissekiKihonKyusochiNyushoshaTokurei(txtKyufuJissekiKihonKyusochiNyushoshaTokurei);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonRojinHokenShichosonNo() {
        return this.getKyufuJissekiKihonHihokensha().getTxtKyufuJissekiKihonRojinHokenShichosonNo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonRojinHokenShichosonNo(TextBox txtKyufuJissekiKihonRojinHokenShichosonNo) {
        this.getKyufuJissekiKihonHihokensha().setTxtKyufuJissekiKihonRojinHokenShichosonNo(txtKyufuJissekiKihonRojinHokenShichosonNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonRojinHokenJukyushaNo() {
        return this.getKyufuJissekiKihonHihokensha().getTxtKyufuJissekiKihonRojinHokenJukyushaNo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonRojinHokenJukyushaNo(TextBox txtKyufuJissekiKihonRojinHokenJukyushaNo) {
        this.getKyufuJissekiKihonHihokensha().setTxtKyufuJissekiKihonRojinHokenJukyushaNo(txtKyufuJissekiKihonRojinHokenJukyushaNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKokiKoreiHokenshaNo() {
        return this.getKyufuJissekiKihonKokiKorei().getTxtKyufuJissekiKihonKokiKoreiHokenshaNo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKokiKoreiHokenshaNo(TextBox txtKyufuJissekiKihonKokiKoreiHokenshaNo) {
        this.getKyufuJissekiKihonKokiKorei().setTxtKyufuJissekiKihonKokiKoreiHokenshaNo(txtKyufuJissekiKihonKokiKoreiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo() {
        return this.getKyufuJissekiKihonKokiKorei().getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKokiKoreiHihokenshaNo(TextBox txtKyufuJissekiKihonKokiKoreiHihokenshaNo) {
        this.getKyufuJissekiKihonKokiKorei().setTxtKyufuJissekiKihonKokiKoreiHihokenshaNo(txtKyufuJissekiKihonKokiKoreiHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKokuhoHokenshaNo() {
        return this.getKyufuJissekiKihonKokuho().getTxtKyufuJissekiKihonKokuhoHokenshaNo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKokuhoHokenshaNo(TextBox txtKyufuJissekiKihonKokuhoHokenshaNo) {
        this.getKyufuJissekiKihonKokuho().setTxtKyufuJissekiKihonKokuhoHokenshaNo(txtKyufuJissekiKihonKokuhoHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKokuhoHihokenshashoNo() {
        return this.getKyufuJissekiKihonKokuho().getTxtKyufuJissekiKihonKokuhoHihokenshashoNo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKokuhoHihokenshashoNo(TextBox txtKyufuJissekiKihonKokuhoHihokenshashoNo) {
        this.getKyufuJissekiKihonKokuho().setTxtKyufuJissekiKihonKokuhoHihokenshashoNo(txtKyufuJissekiKihonKokuhoHihokenshashoNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKokuhoKojinNo() {
        return this.getKyufuJissekiKihonKokuho().getTxtKyufuJissekiKihonKokuhoKojinNo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKokuhoKojinNo(TextBox txtKyufuJissekiKihonKokuhoKojinNo) {
        this.getKyufuJissekiKihonKokuho().setTxtKyufuJissekiKihonKokuhoKojinNo(txtKyufuJissekiKihonKokuhoKojinNo);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTankasu() {
        return this.getKyufuJissekiKihonKingaku().getTxtServiceTankasu();
    }

    @JsonIgnore
    public void setTxtServiceTankasu(TextBoxNum txtServiceTankasu) {
        this.getKyufuJissekiKihonKingaku().setTxtServiceTankasu(txtServiceTankasu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoSeikyuGaku() {
        return this.getKyufuJissekiKihonKingaku().getTxtHokenryoSeikyuGaku();
    }

    @JsonIgnore
    public void setTxtHokenryoSeikyuGaku(TextBoxNum txtHokenryoSeikyuGaku) {
        this.getKyufuJissekiKihonKingaku().setTxtHokenryoSeikyuGaku(txtHokenryoSeikyuGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanGaku() {
        return this.getKyufuJissekiKihonKingaku().getTxtRiyoshaFutanGaku();
    }

    @JsonIgnore
    public void setTxtRiyoshaFutanGaku(TextBoxNum txtRiyoshaFutanGaku) {
        this.getKyufuJissekiKihonKingaku().setTxtRiyoshaFutanGaku(txtRiyoshaFutanGaku);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun() {
        return this.getKyufuJissekiKihonKyotakuServiceKeikaku().getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun(TextBox txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun) {
        this.getKyufuJissekiKihonKyotakuServiceKeikaku().setTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun(txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonJigyoshoNo() {
        return this.getKyufuJissekiKihonKyotakuServiceKeikaku().getTxtKyufuJissekiKihonJigyoshoNo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonJigyoshoNo(TextBox txtKyufuJissekiKihonJigyoshoNo) {
        this.getKyufuJissekiKihonKyotakuServiceKeikaku().setTxtKyufuJissekiKihonJigyoshoNo(txtKyufuJissekiKihonJigyoshoNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonJigyoshoName() {
        return this.getKyufuJissekiKihonKyotakuServiceKeikaku().getTxtKyufuJissekiKihonJigyoshoName();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonJigyoshoName(TextBox txtKyufuJissekiKihonJigyoshoName) {
        this.getKyufuJissekiKihonKyotakuServiceKeikaku().setTxtKyufuJissekiKihonJigyoshoName(txtKyufuJissekiKihonJigyoshoName);
    }

    @JsonIgnore
    public TextBoxDate getTxtKyufuJissekiKihonKaishiYMD() {
        return this.getKyufuJissekiKihonServiceKikan().getTxtKyufuJissekiKihonKaishiYMD();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKaishiYMD(TextBoxDate txtKyufuJissekiKihonKaishiYMD) {
        this.getKyufuJissekiKihonServiceKikan().setTxtKyufuJissekiKihonKaishiYMD(txtKyufuJissekiKihonKaishiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKyufuJissekiKihonChushiYMD() {
        return this.getKyufuJissekiKihonServiceKikan().getTxtKyufuJissekiKihonChushiYMD();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonChushiYMD(TextBoxDate txtKyufuJissekiKihonChushiYMD) {
        this.getKyufuJissekiKihonServiceKikan().setTxtKyufuJissekiKihonChushiYMD(txtKyufuJissekiKihonChushiYMD);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonChushiRiyu() {
        return this.getKyufuJissekiKihonServiceKikan().getTxtKyufuJissekiKihonChushiRiyu();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonChushiRiyu(TextBox txtKyufuJissekiKihonChushiRiyu) {
        this.getKyufuJissekiKihonServiceKikan().setTxtKyufuJissekiKihonChushiRiyu(txtKyufuJissekiKihonChushiRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtKyufuJissekiKihonNyushoYMD() {
        return this.getKyufuJissekiKihonShisetsuNyutaisho().getTxtKyufuJissekiKihonNyushoYMD();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonNyushoYMD(TextBoxDate txtKyufuJissekiKihonNyushoYMD) {
        this.getKyufuJissekiKihonShisetsuNyutaisho().setTxtKyufuJissekiKihonNyushoYMD(txtKyufuJissekiKihonNyushoYMD);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonNyushoJitsuNissu() {
        return this.getKyufuJissekiKihonShisetsuNyutaisho().getTxtKyufuJissekiKihonNyushoJitsuNissu();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonNyushoJitsuNissu(TextBox txtKyufuJissekiKihonNyushoJitsuNissu) {
        this.getKyufuJissekiKihonShisetsuNyutaisho().setTxtKyufuJissekiKihonNyushoJitsuNissu(txtKyufuJissekiKihonNyushoJitsuNissu);
    }

    @JsonIgnore
    public TextBoxDate getTxtKyufuJissekiKihonTaishoYMD() {
        return this.getKyufuJissekiKihonShisetsuNyutaisho().getTxtKyufuJissekiKihonTaishoYMD();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonTaishoYMD(TextBoxDate txtKyufuJissekiKihonTaishoYMD) {
        this.getKyufuJissekiKihonShisetsuNyutaisho().setTxtKyufuJissekiKihonTaishoYMD(txtKyufuJissekiKihonTaishoYMD);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonGaihakuNissu() {
        return this.getKyufuJissekiKihonShisetsuNyutaisho().getTxtKyufuJissekiKihonGaihakuNissu();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonGaihakuNissu(TextBox txtKyufuJissekiKihonGaihakuNissu) {
        this.getKyufuJissekiKihonShisetsuNyutaisho().setTxtKyufuJissekiKihonGaihakuNissu(txtKyufuJissekiKihonGaihakuNissu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonNyushoMaeJokyo() {
        return this.getKyufuJissekiKihonShisetsuNyutaisho().getTxtKyufuJissekiKihonNyushoMaeJokyo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonNyushoMaeJokyo(TextBox txtKyufuJissekiKihonNyushoMaeJokyo) {
        this.getKyufuJissekiKihonShisetsuNyutaisho().setTxtKyufuJissekiKihonNyushoMaeJokyo(txtKyufuJissekiKihonNyushoMaeJokyo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonNyushoAtoJokyo() {
        return this.getKyufuJissekiKihonShisetsuNyutaisho().getTxtKyufuJissekiKihonNyushoAtoJokyo();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonNyushoAtoJokyo(TextBox txtKyufuJissekiKihonNyushoAtoJokyo) {
        this.getKyufuJissekiKihonShisetsuNyutaisho().setTxtKyufuJissekiKihonNyushoAtoJokyo(txtKyufuJissekiKihonNyushoAtoJokyo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonHokenKyufuRitsu() {
        return this.getKyufuJissekiKihonKyufuritsu().getTxtKyufuJissekiKihonHokenKyufuRitsu();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonHokenKyufuRitsu(TextBox txtKyufuJissekiKihonHokenKyufuRitsu) {
        this.getKyufuJissekiKihonKyufuritsu().setTxtKyufuJissekiKihonHokenKyufuRitsu(txtKyufuJissekiKihonHokenKyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKohi1KyufuRitsu() {
        return this.getKyufuJissekiKihonKyufuritsu().getTxtKyufuJissekiKihonKohi1KyufuRitsu();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKohi1KyufuRitsu(TextBox txtKyufuJissekiKihonKohi1KyufuRitsu) {
        this.getKyufuJissekiKihonKyufuritsu().setTxtKyufuJissekiKihonKohi1KyufuRitsu(txtKyufuJissekiKihonKohi1KyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKohi2KyufuRitsu() {
        return this.getKyufuJissekiKihonKyufuritsu().getTxtKyufuJissekiKihonKohi2KyufuRitsu();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKohi2KyufuRitsu(TextBox txtKyufuJissekiKihonKohi2KyufuRitsu) {
        this.getKyufuJissekiKihonKyufuritsu().setTxtKyufuJissekiKihonKohi2KyufuRitsu(txtKyufuJissekiKihonKohi2KyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKohi3KyufuRitsu() {
        return this.getKyufuJissekiKihonKyufuritsu().getTxtKyufuJissekiKihonKohi3KyufuRitsu();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKohi3KyufuRitsu(TextBox txtKyufuJissekiKihonKohi3KyufuRitsu) {
        this.getKyufuJissekiKihonKyufuritsu().setTxtKyufuJissekiKihonKohi3KyufuRitsu(txtKyufuJissekiKihonKohi3KyufuRitsu);
    }

    @JsonIgnore
    public Label getLblKyufuJissekiKihonKohi1() {
        return this.getKyufuJissekiKihonKohi().getLblKyufuJissekiKihonKohi1();
    }

    @JsonIgnore
    public void setLblKyufuJissekiKihonKohi1(Label lblKyufuJissekiKihonKohi1) {
        this.getKyufuJissekiKihonKohi().setLblKyufuJissekiKihonKohi1(lblKyufuJissekiKihonKohi1);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKohiFutanshaNo1() {
        return this.getKyufuJissekiKihonKohi().getTxtKyufuJissekiKihonKohiFutanshaNo1();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKohiFutanshaNo1(TextBox txtKyufuJissekiKihonKohiFutanshaNo1) {
        this.getKyufuJissekiKihonKohi().setTxtKyufuJissekiKihonKohiFutanshaNo1(txtKyufuJissekiKihonKohiFutanshaNo1);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKohiJukyushaNo1() {
        return this.getKyufuJissekiKihonKohi().getTxtKyufuJissekiKihonKohiJukyushaNo1();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKohiJukyushaNo1(TextBox txtKyufuJissekiKihonKohiJukyushaNo1) {
        this.getKyufuJissekiKihonKohi().setTxtKyufuJissekiKihonKohiJukyushaNo1(txtKyufuJissekiKihonKohiJukyushaNo1);
    }

    @JsonIgnore
    public Label getLblKyufuJissekiKihonKohi2() {
        return this.getKyufuJissekiKihonKohi().getLblKyufuJissekiKihonKohi2();
    }

    @JsonIgnore
    public void setLblKyufuJissekiKihonKohi2(Label lblKyufuJissekiKihonKohi2) {
        this.getKyufuJissekiKihonKohi().setLblKyufuJissekiKihonKohi2(lblKyufuJissekiKihonKohi2);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKohiFutanshaNo2() {
        return this.getKyufuJissekiKihonKohi().getTxtKyufuJissekiKihonKohiFutanshaNo2();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKohiFutanshaNo2(TextBox txtKyufuJissekiKihonKohiFutanshaNo2) {
        this.getKyufuJissekiKihonKohi().setTxtKyufuJissekiKihonKohiFutanshaNo2(txtKyufuJissekiKihonKohiFutanshaNo2);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKohiJukyushaNo2() {
        return this.getKyufuJissekiKihonKohi().getTxtKyufuJissekiKihonKohiJukyushaNo2();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKohiJukyushaNo2(TextBox txtKyufuJissekiKihonKohiJukyushaNo2) {
        this.getKyufuJissekiKihonKohi().setTxtKyufuJissekiKihonKohiJukyushaNo2(txtKyufuJissekiKihonKohiJukyushaNo2);
    }

    @JsonIgnore
    public Label getLblKyufuJissekiKihonKohi3() {
        return this.getKyufuJissekiKihonKohi().getLblKyufuJissekiKihonKohi3();
    }

    @JsonIgnore
    public void setLblKyufuJissekiKihonKohi3(Label lblKyufuJissekiKihonKohi3) {
        this.getKyufuJissekiKihonKohi().setLblKyufuJissekiKihonKohi3(lblKyufuJissekiKihonKohi3);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKohiFutanshaNo3() {
        return this.getKyufuJissekiKihonKohi().getTxtKyufuJissekiKihonKohiFutanshaNo3();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKohiFutanshaNo3(TextBox txtKyufuJissekiKihonKohiFutanshaNo3) {
        this.getKyufuJissekiKihonKohi().setTxtKyufuJissekiKihonKohiFutanshaNo3(txtKyufuJissekiKihonKohiFutanshaNo3);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiKihonKohiJukyushaNo3() {
        return this.getKyufuJissekiKihonKohi().getTxtKyufuJissekiKihonKohiJukyushaNo3();
    }

    @JsonIgnore
    public void setTxtKyufuJissekiKihonKohiJukyushaNo3(TextBox txtKyufuJissekiKihonKohiJukyushaNo3) {
        this.getKyufuJissekiKihonKohi().setTxtKyufuJissekiKihonKohiJukyushaNo3(txtKyufuJissekiKihonKohiJukyushaNo3);
    }

    @JsonIgnore
    public tblKihonGokeiDiv getTblKihonGokei() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei();
    }

    @JsonIgnore
    public void setTblKihonGokei(tblKihonGokeiDiv tblKihonGokei) {
        this.getKyufuJissekiKihonGokeiPanel().setTblKihonGokei(tblKihonGokei);
    }

    @JsonIgnore
    public Label getLblHoken() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblHoken();
    }

    @JsonIgnore
    public Label getLblKohi1() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKohi1();
    }

    @JsonIgnore
    public Label getLblKohi2() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKohi2();
    }

    @JsonIgnore
    public Label getLblKohi3() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKohi3();
    }

    @JsonIgnore
    public Label getLblHokenKetteiMae() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblHokenKetteiMae();
    }

    @JsonIgnore
    public Label getLblHokenKetteiGo() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblHokenKetteiGo();
    }

    @JsonIgnore
    public Label getLblKohi1KetteiMae() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKohi1KetteiMae();
    }

    @JsonIgnore
    public Label getLblKohi1KetteiGo() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKohi1KetteiGo();
    }

    @JsonIgnore
    public Label getLblKohi2KetteiMae() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKohi2KetteiMae();
    }

    @JsonIgnore
    public Label getLblKohi1Ketteigo() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKohi1Ketteigo();
    }

    @JsonIgnore
    public Label getLblKohi3KetteiMae() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKohi3KetteiMae();
    }

    @JsonIgnore
    public Label getLblKohi3KetteiGo() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKohi3KetteiGo();
    }

    @JsonIgnore
    public Label getLblServiceTankasu() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblServiceTankasu();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenServiceTanisu() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeHokenServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenServiceTanisu() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoHokenServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1ServiceTanisu() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi1ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1ServiceTanisu() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi1ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2ServiceTanisu() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi2ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2ServiceTanisu() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi2ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3ServiceTanisu() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi3ServiceTanisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3ServiceTanisu() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi3ServiceTanisu();
    }

    @JsonIgnore
    public Label getLblHokenryoSeikyuGaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblHokenryoSeikyuGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenHokenSeikyugaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeHokenHokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenHokenSeikyugaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoHokenHokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1HokenSeikyugaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi1HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1HokenSeikyugaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi1HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2HokenSeikyugaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi2HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2HokenSeikyugaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi2HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3HokenSeikyugaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi3HokenSeikyugaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3HokenSeikyugaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi3HokenSeikyugaku();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutanGaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblRiyoshaFutanGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenRiyoshaFutangaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeHokenRiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenRiyoshaFutangaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoHokenRiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1RiyoshaFutangaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi1RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1RiyoshaFutangaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi1RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2RiyoshaFutangaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi2RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2RiyoshaFutangaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi2RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3RiyoshaFutangaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi3RiyoshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3RiyoshaFutangaku() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi3RiyoshaFutangaku();
    }

    @JsonIgnore
    public Label getLblKinkyujiShisetsuRyoyohiHokenSeikyubunGokei() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblKinkyujiShisetsuRyoyohiHokenSeikyubunGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenKinkyujiShisetsuRyoyohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeHokenKinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenKinkyujiShisetsuRyoyohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoHokenKinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1KinkyujiShisetsuRyoyohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi1KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1KinkyujiShisetsuRyoyohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi1KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2KinkyujiShisetsuRyoyohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi2KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2KinkyujiShisetsuRyoyohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi2KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3KinkyujiShisetsuRyoyohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi3KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3KinkyujiShisetsuRyoyohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi3KinkyujiShisetsuRyoyohi();
    }

    @JsonIgnore
    public Label getLblTokuteiShinryohiKohiSeikyubunGokei() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblTokuteiShinryohiKohiSeikyubunGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenTokuteiShinryohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeHokenTokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenTokuteiShinryohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoHokenTokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1TokuteiShinryohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi1TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1TokuteiShinryohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi1TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2TokuteiShinryohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi2TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2TokuteiShinryohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi2TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3TokuteiShinryohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi3TokuteiShinryohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3TokuteiShinryohi() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi3TokuteiShinryohi();
    }

    @JsonIgnore
    public Label getLblTokuteiNyushoshaKaigoto() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getLblTokuteiNyushoshaKaigoto();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeHokenTokuteiNyushosha() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeHokenTokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoHokenTokuteiNyushosha() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoHokenTokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi1TokuteiNyushosha() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi1TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi1TokuteiNyushosha() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi1TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi2TokuteiNyushosha() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi2TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi2TokuteiNyushosha() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi2TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeKohi3TokuteiNyushosha() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtMaeKohi3TokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtGoKohi3TokuteiNyushosha() {
        return this.getKyufuJissekiKihonGokeiPanel().getTblKihonGokei().getTxtGoKohi3TokuteiNyushosha();
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiKihonGokeiClose() {
        return this.getKyufuJissekiKihonGokeiPanel().getBtnKyufuJissekiKihonGokeiClose();
    }

    @JsonIgnore
    public void setBtnKyufuJissekiKihonGokeiClose(Button btnKyufuJissekiKihonGokeiClose) {
        this.getKyufuJissekiKihonGokeiPanel().setBtnKyufuJissekiKihonGokeiClose(btnKyufuJissekiKihonGokeiClose);
    }

    // </editor-fold>
}
