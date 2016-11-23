package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader.IKyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader.KyufuJissekiHeaderDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * KogakuKaigoServiceMain のクラスファイル
 *
 * @author 自動生成
 */
public class KogakuKaigoServiceMainDiv extends Panel {

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
    @JsonProperty("txtKogakuKaigoServicehiKetteiYMD")
    private TextBox txtKogakuKaigoServicehiKetteiYMD;
    @JsonProperty("txtKogakuKaigoServicehiUketsukeYMD")
    private TextBox txtKogakuKaigoServicehiUketsukeYMD;
    @JsonProperty("txtKogakuKaigoServicehiShinsaYM")
    private TextBox txtKogakuKaigoServicehiShinsaYM;
    @JsonProperty("txtKogakuKaigoServicehiSofuYM")
    private TextBox txtKogakuKaigoServicehiSofuYM;
    @JsonProperty("spKogaku")
    private Space spKogaku;
    @JsonProperty("txtKogakuKaigoServicehiRiyoshaFutangaku")
    private TextBox txtKogakuKaigoServicehiRiyoshaFutangaku;
    @JsonProperty("txtKogakuKaigoServicehiShikyugaku")
    private TextBox txtKogakuKaigoServicehiShikyugaku;
    @JsonProperty("lblKogakuKaigoServicehiKohi1")
    private Label lblKogakuKaigoServicehiKohi1;
    @JsonProperty("txtKogakuKaigoServicehiKohi1FutanshaNo")
    private TextBox txtKogakuKaigoServicehiKohi1FutanshaNo;
    @JsonProperty("txtKogakuKaigoServicehiKohi1Futangaku")
    private TextBox txtKogakuKaigoServicehiKohi1Futangaku;
    @JsonProperty("txtKogakuKaigoServicehiKohi1Shikyugaku")
    private TextBox txtKogakuKaigoServicehiKohi1Shikyugaku;
    @JsonProperty("lblKogakuKaigoServicehiKohi2")
    private Label lblKogakuKaigoServicehiKohi2;
    @JsonProperty("txtKogakuKaigoServicehiKohi2FutanshaNo")
    private TextBox txtKogakuKaigoServicehiKohi2FutanshaNo;
    @JsonProperty("txtKogakuKaigoServicehiKohi2Futangaku")
    private TextBox txtKogakuKaigoServicehiKohi2Futangaku;
    @JsonProperty("txtKogakuKaigoServicehiKohi2Shikyugaku")
    private TextBox txtKogakuKaigoServicehiKohi2Shikyugaku;
    @JsonProperty("lblKogakuKaigoServicehiKohi3")
    private Label lblKogakuKaigoServicehiKohi3;
    @JsonProperty("txtKogakuKaigoServicehiKohi3FutanshaNo")
    private TextBox txtKogakuKaigoServicehiKohi3FutanshaNo;
    @JsonProperty("txtKogakuKaigoServicehiKohi3Futangaku")
    private TextBox txtKogakuKaigoServicehiKohi3Futangaku;
    @JsonProperty("txtKogakuKaigoServicehiKohi3Shikyugaku")
    private TextBox txtKogakuKaigoServicehiKohi3Shikyugaku;
    @JsonProperty("linButtonArea3")
    private HorizontalLine linButtonArea3;
    @JsonProperty("btnJigetsu")
    private Button btnJigetsu;
    @JsonProperty("btnZengetsu")
    private Button btnZengetsu;
    @JsonProperty("ccdKyufuJissekiHeader")
    private KyufuJissekiHeaderDiv ccdKyufuJissekiHeader;
    @JsonProperty("hiddenCurrentIndex")
    private RString hiddenCurrentIndex;
    @JsonProperty("hiddenTotalIndex")
    private RString hiddenTotalIndex;

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
     * gettxtKogakuKaigoServicehiKetteiYMD
     * @return txtKogakuKaigoServicehiKetteiYMD
     */
    @JsonProperty("txtKogakuKaigoServicehiKetteiYMD")
    public TextBox getTxtKogakuKaigoServicehiKetteiYMD() {
        return txtKogakuKaigoServicehiKetteiYMD;
    }

    /*
     * settxtKogakuKaigoServicehiKetteiYMD
     * @param txtKogakuKaigoServicehiKetteiYMD txtKogakuKaigoServicehiKetteiYMD
     */
    @JsonProperty("txtKogakuKaigoServicehiKetteiYMD")
    public void setTxtKogakuKaigoServicehiKetteiYMD(TextBox txtKogakuKaigoServicehiKetteiYMD) {
        this.txtKogakuKaigoServicehiKetteiYMD = txtKogakuKaigoServicehiKetteiYMD;
    }

    /*
     * gettxtKogakuKaigoServicehiUketsukeYMD
     * @return txtKogakuKaigoServicehiUketsukeYMD
     */
    @JsonProperty("txtKogakuKaigoServicehiUketsukeYMD")
    public TextBox getTxtKogakuKaigoServicehiUketsukeYMD() {
        return txtKogakuKaigoServicehiUketsukeYMD;
    }

    /*
     * settxtKogakuKaigoServicehiUketsukeYMD
     * @param txtKogakuKaigoServicehiUketsukeYMD txtKogakuKaigoServicehiUketsukeYMD
     */
    @JsonProperty("txtKogakuKaigoServicehiUketsukeYMD")
    public void setTxtKogakuKaigoServicehiUketsukeYMD(TextBox txtKogakuKaigoServicehiUketsukeYMD) {
        this.txtKogakuKaigoServicehiUketsukeYMD = txtKogakuKaigoServicehiUketsukeYMD;
    }

    /*
     * gettxtKogakuKaigoServicehiShinsaYM
     * @return txtKogakuKaigoServicehiShinsaYM
     */
    @JsonProperty("txtKogakuKaigoServicehiShinsaYM")
    public TextBox getTxtKogakuKaigoServicehiShinsaYM() {
        return txtKogakuKaigoServicehiShinsaYM;
    }

    /*
     * settxtKogakuKaigoServicehiShinsaYM
     * @param txtKogakuKaigoServicehiShinsaYM txtKogakuKaigoServicehiShinsaYM
     */
    @JsonProperty("txtKogakuKaigoServicehiShinsaYM")
    public void setTxtKogakuKaigoServicehiShinsaYM(TextBox txtKogakuKaigoServicehiShinsaYM) {
        this.txtKogakuKaigoServicehiShinsaYM = txtKogakuKaigoServicehiShinsaYM;
    }

    /*
     * gettxtKogakuKaigoServicehiSofuYM
     * @return txtKogakuKaigoServicehiSofuYM
     */
    @JsonProperty("txtKogakuKaigoServicehiSofuYM")
    public TextBox getTxtKogakuKaigoServicehiSofuYM() {
        return txtKogakuKaigoServicehiSofuYM;
    }

    /*
     * settxtKogakuKaigoServicehiSofuYM
     * @param txtKogakuKaigoServicehiSofuYM txtKogakuKaigoServicehiSofuYM
     */
    @JsonProperty("txtKogakuKaigoServicehiSofuYM")
    public void setTxtKogakuKaigoServicehiSofuYM(TextBox txtKogakuKaigoServicehiSofuYM) {
        this.txtKogakuKaigoServicehiSofuYM = txtKogakuKaigoServicehiSofuYM;
    }

    /*
     * getspKogaku
     * @return spKogaku
     */
    @JsonProperty("spKogaku")
    public Space getSpKogaku() {
        return spKogaku;
    }

    /*
     * setspKogaku
     * @param spKogaku spKogaku
     */
    @JsonProperty("spKogaku")
    public void setSpKogaku(Space spKogaku) {
        this.spKogaku = spKogaku;
    }

    /*
     * gettxtKogakuKaigoServicehiRiyoshaFutangaku
     * @return txtKogakuKaigoServicehiRiyoshaFutangaku
     */
    @JsonProperty("txtKogakuKaigoServicehiRiyoshaFutangaku")
    public TextBox getTxtKogakuKaigoServicehiRiyoshaFutangaku() {
        return txtKogakuKaigoServicehiRiyoshaFutangaku;
    }

    /*
     * settxtKogakuKaigoServicehiRiyoshaFutangaku
     * @param txtKogakuKaigoServicehiRiyoshaFutangaku txtKogakuKaigoServicehiRiyoshaFutangaku
     */
    @JsonProperty("txtKogakuKaigoServicehiRiyoshaFutangaku")
    public void setTxtKogakuKaigoServicehiRiyoshaFutangaku(TextBox txtKogakuKaigoServicehiRiyoshaFutangaku) {
        this.txtKogakuKaigoServicehiRiyoshaFutangaku = txtKogakuKaigoServicehiRiyoshaFutangaku;
    }

    /*
     * gettxtKogakuKaigoServicehiShikyugaku
     * @return txtKogakuKaigoServicehiShikyugaku
     */
    @JsonProperty("txtKogakuKaigoServicehiShikyugaku")
    public TextBox getTxtKogakuKaigoServicehiShikyugaku() {
        return txtKogakuKaigoServicehiShikyugaku;
    }

    /*
     * settxtKogakuKaigoServicehiShikyugaku
     * @param txtKogakuKaigoServicehiShikyugaku txtKogakuKaigoServicehiShikyugaku
     */
    @JsonProperty("txtKogakuKaigoServicehiShikyugaku")
    public void setTxtKogakuKaigoServicehiShikyugaku(TextBox txtKogakuKaigoServicehiShikyugaku) {
        this.txtKogakuKaigoServicehiShikyugaku = txtKogakuKaigoServicehiShikyugaku;
    }

    /*
     * getlblKogakuKaigoServicehiKohi1
     * @return lblKogakuKaigoServicehiKohi1
     */
    @JsonProperty("lblKogakuKaigoServicehiKohi1")
    public Label getLblKogakuKaigoServicehiKohi1() {
        return lblKogakuKaigoServicehiKohi1;
    }

    /*
     * setlblKogakuKaigoServicehiKohi1
     * @param lblKogakuKaigoServicehiKohi1 lblKogakuKaigoServicehiKohi1
     */
    @JsonProperty("lblKogakuKaigoServicehiKohi1")
    public void setLblKogakuKaigoServicehiKohi1(Label lblKogakuKaigoServicehiKohi1) {
        this.lblKogakuKaigoServicehiKohi1 = lblKogakuKaigoServicehiKohi1;
    }

    /*
     * gettxtKogakuKaigoServicehiKohi1FutanshaNo
     * @return txtKogakuKaigoServicehiKohi1FutanshaNo
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi1FutanshaNo")
    public TextBox getTxtKogakuKaigoServicehiKohi1FutanshaNo() {
        return txtKogakuKaigoServicehiKohi1FutanshaNo;
    }

    /*
     * settxtKogakuKaigoServicehiKohi1FutanshaNo
     * @param txtKogakuKaigoServicehiKohi1FutanshaNo txtKogakuKaigoServicehiKohi1FutanshaNo
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi1FutanshaNo")
    public void setTxtKogakuKaigoServicehiKohi1FutanshaNo(TextBox txtKogakuKaigoServicehiKohi1FutanshaNo) {
        this.txtKogakuKaigoServicehiKohi1FutanshaNo = txtKogakuKaigoServicehiKohi1FutanshaNo;
    }

    /*
     * gettxtKogakuKaigoServicehiKohi1Futangaku
     * @return txtKogakuKaigoServicehiKohi1Futangaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi1Futangaku")
    public TextBox getTxtKogakuKaigoServicehiKohi1Futangaku() {
        return txtKogakuKaigoServicehiKohi1Futangaku;
    }

    /*
     * settxtKogakuKaigoServicehiKohi1Futangaku
     * @param txtKogakuKaigoServicehiKohi1Futangaku txtKogakuKaigoServicehiKohi1Futangaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi1Futangaku")
    public void setTxtKogakuKaigoServicehiKohi1Futangaku(TextBox txtKogakuKaigoServicehiKohi1Futangaku) {
        this.txtKogakuKaigoServicehiKohi1Futangaku = txtKogakuKaigoServicehiKohi1Futangaku;
    }

    /*
     * gettxtKogakuKaigoServicehiKohi1Shikyugaku
     * @return txtKogakuKaigoServicehiKohi1Shikyugaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi1Shikyugaku")
    public TextBox getTxtKogakuKaigoServicehiKohi1Shikyugaku() {
        return txtKogakuKaigoServicehiKohi1Shikyugaku;
    }

    /*
     * settxtKogakuKaigoServicehiKohi1Shikyugaku
     * @param txtKogakuKaigoServicehiKohi1Shikyugaku txtKogakuKaigoServicehiKohi1Shikyugaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi1Shikyugaku")
    public void setTxtKogakuKaigoServicehiKohi1Shikyugaku(TextBox txtKogakuKaigoServicehiKohi1Shikyugaku) {
        this.txtKogakuKaigoServicehiKohi1Shikyugaku = txtKogakuKaigoServicehiKohi1Shikyugaku;
    }

    /*
     * getlblKogakuKaigoServicehiKohi2
     * @return lblKogakuKaigoServicehiKohi2
     */
    @JsonProperty("lblKogakuKaigoServicehiKohi2")
    public Label getLblKogakuKaigoServicehiKohi2() {
        return lblKogakuKaigoServicehiKohi2;
    }

    /*
     * setlblKogakuKaigoServicehiKohi2
     * @param lblKogakuKaigoServicehiKohi2 lblKogakuKaigoServicehiKohi2
     */
    @JsonProperty("lblKogakuKaigoServicehiKohi2")
    public void setLblKogakuKaigoServicehiKohi2(Label lblKogakuKaigoServicehiKohi2) {
        this.lblKogakuKaigoServicehiKohi2 = lblKogakuKaigoServicehiKohi2;
    }

    /*
     * gettxtKogakuKaigoServicehiKohi2FutanshaNo
     * @return txtKogakuKaigoServicehiKohi2FutanshaNo
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi2FutanshaNo")
    public TextBox getTxtKogakuKaigoServicehiKohi2FutanshaNo() {
        return txtKogakuKaigoServicehiKohi2FutanshaNo;
    }

    /*
     * settxtKogakuKaigoServicehiKohi2FutanshaNo
     * @param txtKogakuKaigoServicehiKohi2FutanshaNo txtKogakuKaigoServicehiKohi2FutanshaNo
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi2FutanshaNo")
    public void setTxtKogakuKaigoServicehiKohi2FutanshaNo(TextBox txtKogakuKaigoServicehiKohi2FutanshaNo) {
        this.txtKogakuKaigoServicehiKohi2FutanshaNo = txtKogakuKaigoServicehiKohi2FutanshaNo;
    }

    /*
     * gettxtKogakuKaigoServicehiKohi2Futangaku
     * @return txtKogakuKaigoServicehiKohi2Futangaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi2Futangaku")
    public TextBox getTxtKogakuKaigoServicehiKohi2Futangaku() {
        return txtKogakuKaigoServicehiKohi2Futangaku;
    }

    /*
     * settxtKogakuKaigoServicehiKohi2Futangaku
     * @param txtKogakuKaigoServicehiKohi2Futangaku txtKogakuKaigoServicehiKohi2Futangaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi2Futangaku")
    public void setTxtKogakuKaigoServicehiKohi2Futangaku(TextBox txtKogakuKaigoServicehiKohi2Futangaku) {
        this.txtKogakuKaigoServicehiKohi2Futangaku = txtKogakuKaigoServicehiKohi2Futangaku;
    }

    /*
     * gettxtKogakuKaigoServicehiKohi2Shikyugaku
     * @return txtKogakuKaigoServicehiKohi2Shikyugaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi2Shikyugaku")
    public TextBox getTxtKogakuKaigoServicehiKohi2Shikyugaku() {
        return txtKogakuKaigoServicehiKohi2Shikyugaku;
    }

    /*
     * settxtKogakuKaigoServicehiKohi2Shikyugaku
     * @param txtKogakuKaigoServicehiKohi2Shikyugaku txtKogakuKaigoServicehiKohi2Shikyugaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi2Shikyugaku")
    public void setTxtKogakuKaigoServicehiKohi2Shikyugaku(TextBox txtKogakuKaigoServicehiKohi2Shikyugaku) {
        this.txtKogakuKaigoServicehiKohi2Shikyugaku = txtKogakuKaigoServicehiKohi2Shikyugaku;
    }

    /*
     * getlblKogakuKaigoServicehiKohi3
     * @return lblKogakuKaigoServicehiKohi3
     */
    @JsonProperty("lblKogakuKaigoServicehiKohi3")
    public Label getLblKogakuKaigoServicehiKohi3() {
        return lblKogakuKaigoServicehiKohi3;
    }

    /*
     * setlblKogakuKaigoServicehiKohi3
     * @param lblKogakuKaigoServicehiKohi3 lblKogakuKaigoServicehiKohi3
     */
    @JsonProperty("lblKogakuKaigoServicehiKohi3")
    public void setLblKogakuKaigoServicehiKohi3(Label lblKogakuKaigoServicehiKohi3) {
        this.lblKogakuKaigoServicehiKohi3 = lblKogakuKaigoServicehiKohi3;
    }

    /*
     * gettxtKogakuKaigoServicehiKohi3FutanshaNo
     * @return txtKogakuKaigoServicehiKohi3FutanshaNo
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi3FutanshaNo")
    public TextBox getTxtKogakuKaigoServicehiKohi3FutanshaNo() {
        return txtKogakuKaigoServicehiKohi3FutanshaNo;
    }

    /*
     * settxtKogakuKaigoServicehiKohi3FutanshaNo
     * @param txtKogakuKaigoServicehiKohi3FutanshaNo txtKogakuKaigoServicehiKohi3FutanshaNo
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi3FutanshaNo")
    public void setTxtKogakuKaigoServicehiKohi3FutanshaNo(TextBox txtKogakuKaigoServicehiKohi3FutanshaNo) {
        this.txtKogakuKaigoServicehiKohi3FutanshaNo = txtKogakuKaigoServicehiKohi3FutanshaNo;
    }

    /*
     * gettxtKogakuKaigoServicehiKohi3Futangaku
     * @return txtKogakuKaigoServicehiKohi3Futangaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi3Futangaku")
    public TextBox getTxtKogakuKaigoServicehiKohi3Futangaku() {
        return txtKogakuKaigoServicehiKohi3Futangaku;
    }

    /*
     * settxtKogakuKaigoServicehiKohi3Futangaku
     * @param txtKogakuKaigoServicehiKohi3Futangaku txtKogakuKaigoServicehiKohi3Futangaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi3Futangaku")
    public void setTxtKogakuKaigoServicehiKohi3Futangaku(TextBox txtKogakuKaigoServicehiKohi3Futangaku) {
        this.txtKogakuKaigoServicehiKohi3Futangaku = txtKogakuKaigoServicehiKohi3Futangaku;
    }

    /*
     * gettxtKogakuKaigoServicehiKohi3Shikyugaku
     * @return txtKogakuKaigoServicehiKohi3Shikyugaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi3Shikyugaku")
    public TextBox getTxtKogakuKaigoServicehiKohi3Shikyugaku() {
        return txtKogakuKaigoServicehiKohi3Shikyugaku;
    }

    /*
     * settxtKogakuKaigoServicehiKohi3Shikyugaku
     * @param txtKogakuKaigoServicehiKohi3Shikyugaku txtKogakuKaigoServicehiKohi3Shikyugaku
     */
    @JsonProperty("txtKogakuKaigoServicehiKohi3Shikyugaku")
    public void setTxtKogakuKaigoServicehiKohi3Shikyugaku(TextBox txtKogakuKaigoServicehiKohi3Shikyugaku) {
        this.txtKogakuKaigoServicehiKohi3Shikyugaku = txtKogakuKaigoServicehiKohi3Shikyugaku;
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
     * getccdKyufuJissekiHeader
     * @return ccdKyufuJissekiHeader
     */
    @JsonProperty("ccdKyufuJissekiHeader")
    public IKyufuJissekiHeaderDiv getCcdKyufuJissekiHeader() {
        return ccdKyufuJissekiHeader;
    }

    /*
     * gethiddenCurrentIndex
     * @return hiddenCurrentIndex
     */
    @JsonProperty("hiddenCurrentIndex")
    public RString getHiddenCurrentIndex() {
        return hiddenCurrentIndex;
    }

    /*
     * sethiddenCurrentIndex
     * @param hiddenCurrentIndex hiddenCurrentIndex
     */
    @JsonProperty("hiddenCurrentIndex")
    public void setHiddenCurrentIndex(RString hiddenCurrentIndex) {
        this.hiddenCurrentIndex = hiddenCurrentIndex;
    }

    /*
     * gethiddenTotalIndex
     * @return hiddenTotalIndex
     */
    @JsonProperty("hiddenTotalIndex")
    public RString getHiddenTotalIndex() {
        return hiddenTotalIndex;
    }

    /*
     * sethiddenTotalIndex
     * @param hiddenTotalIndex hiddenTotalIndex
     */
    @JsonProperty("hiddenTotalIndex")
    public void setHiddenTotalIndex(RString hiddenTotalIndex) {
        this.hiddenTotalIndex = hiddenTotalIndex;
    }

    // </editor-fold>
}
