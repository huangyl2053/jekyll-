package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmenshokai.GemmenShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.gemmenshokai.GemmenShokaiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * GemmenShokai のクラスファイル
 *
 * @author 自動生成
 */
public class GemmenShokaiDiv extends Panel implements IGemmenShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YokaigoNinteiJoho")
    private YokaigoNinteiJohoDiv YokaigoNinteiJoho;
    @JsonProperty("ShinseiChuJoho")
    private ShinseiChuJohoDiv ShinseiChuJoho;
    @JsonProperty("KakushuGemmenJoho")
    private KakushuGemmenJohoDiv KakushuGemmenJoho;
    @JsonProperty("RoreiSeihoJoho")
    private RoreiSeihoJohoDiv RoreiSeihoJoho;
    @JsonProperty("KyufuSeigenJoho")
    private KyufuSeigenJohoDiv KyufuSeigenJoho;
    @JsonProperty("FutanWariaiJoho")
    private FutanWariaiJohoDiv FutanWariaiJoho;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYokaigoNinteiJoho
     * @return YokaigoNinteiJoho
     */
    @JsonProperty("YokaigoNinteiJoho")
    public YokaigoNinteiJohoDiv getYokaigoNinteiJoho() {
        return YokaigoNinteiJoho;
    }

    /*
     * setYokaigoNinteiJoho
     * @param YokaigoNinteiJoho YokaigoNinteiJoho
     */
    @JsonProperty("YokaigoNinteiJoho")
    public void setYokaigoNinteiJoho(YokaigoNinteiJohoDiv YokaigoNinteiJoho) {
        this.YokaigoNinteiJoho = YokaigoNinteiJoho;
    }

    /*
     * getShinseiChuJoho
     * @return ShinseiChuJoho
     */
    @JsonProperty("ShinseiChuJoho")
    public ShinseiChuJohoDiv getShinseiChuJoho() {
        return ShinseiChuJoho;
    }

    /*
     * setShinseiChuJoho
     * @param ShinseiChuJoho ShinseiChuJoho
     */
    @JsonProperty("ShinseiChuJoho")
    public void setShinseiChuJoho(ShinseiChuJohoDiv ShinseiChuJoho) {
        this.ShinseiChuJoho = ShinseiChuJoho;
    }

    /*
     * getKakushuGemmenJoho
     * @return KakushuGemmenJoho
     */
    @JsonProperty("KakushuGemmenJoho")
    public KakushuGemmenJohoDiv getKakushuGemmenJoho() {
        return KakushuGemmenJoho;
    }

    /*
     * setKakushuGemmenJoho
     * @param KakushuGemmenJoho KakushuGemmenJoho
     */
    @JsonProperty("KakushuGemmenJoho")
    public void setKakushuGemmenJoho(KakushuGemmenJohoDiv KakushuGemmenJoho) {
        this.KakushuGemmenJoho = KakushuGemmenJoho;
    }

    /*
     * getRoreiSeihoJoho
     * @return RoreiSeihoJoho
     */
    @JsonProperty("RoreiSeihoJoho")
    public RoreiSeihoJohoDiv getRoreiSeihoJoho() {
        return RoreiSeihoJoho;
    }

    /*
     * setRoreiSeihoJoho
     * @param RoreiSeihoJoho RoreiSeihoJoho
     */
    @JsonProperty("RoreiSeihoJoho")
    public void setRoreiSeihoJoho(RoreiSeihoJohoDiv RoreiSeihoJoho) {
        this.RoreiSeihoJoho = RoreiSeihoJoho;
    }

    /*
     * getKyufuSeigenJoho
     * @return KyufuSeigenJoho
     */
    @JsonProperty("KyufuSeigenJoho")
    public KyufuSeigenJohoDiv getKyufuSeigenJoho() {
        return KyufuSeigenJoho;
    }

    /*
     * setKyufuSeigenJoho
     * @param KyufuSeigenJoho KyufuSeigenJoho
     */
    @JsonProperty("KyufuSeigenJoho")
    public void setKyufuSeigenJoho(KyufuSeigenJohoDiv KyufuSeigenJoho) {
        this.KyufuSeigenJoho = KyufuSeigenJoho;
    }

    /*
     * getFutanWariaiJoho
     * @return FutanWariaiJoho
     */
    @JsonProperty("FutanWariaiJoho")
    public FutanWariaiJohoDiv getFutanWariaiJoho() {
        return FutanWariaiJoho;
    }

    /*
     * setFutanWariaiJoho
     * @param FutanWariaiJoho FutanWariaiJoho
     */
    @JsonProperty("FutanWariaiJoho")
    public void setFutanWariaiJoho(FutanWariaiJohoDiv FutanWariaiJoho) {
        this.FutanWariaiJoho = FutanWariaiJoho;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtYokaigoNinteiJokyo() {
        return this.getYokaigoNinteiJoho().getTxtYokaigoNinteiJokyo();
    }

    @JsonIgnore
    public void  setTxtYokaigoNinteiJokyo(TextBox txtYokaigoNinteiJokyo) {
        this.getYokaigoNinteiJoho().setTxtYokaigoNinteiJokyo(txtYokaigoNinteiJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYokaigoNinteiShinseiYmd() {
        return this.getYokaigoNinteiJoho().getTxtYokaigoNinteiShinseiYmd();
    }

    @JsonIgnore
    public void  setTxtYokaigoNinteiShinseiYmd(TextBoxFlexibleDate txtYokaigoNinteiShinseiYmd) {
        this.getYokaigoNinteiJoho().setTxtYokaigoNinteiShinseiYmd(txtYokaigoNinteiShinseiYmd);
    }

    @JsonIgnore
    public TextBox getTxtYokaigoNinteiShinseiShurui() {
        return this.getYokaigoNinteiJoho().getTxtYokaigoNinteiShinseiShurui();
    }

    @JsonIgnore
    public void  setTxtYokaigoNinteiShinseiShurui(TextBox txtYokaigoNinteiShinseiShurui) {
        this.getYokaigoNinteiJoho().setTxtYokaigoNinteiShinseiShurui(txtYokaigoNinteiShinseiShurui);
    }

    @JsonIgnore
    public TextBox getTxtYokaigoNinteiKyuSochiKubun() {
        return this.getYokaigoNinteiJoho().getTxtYokaigoNinteiKyuSochiKubun();
    }

    @JsonIgnore
    public void  setTxtYokaigoNinteiKyuSochiKubun(TextBox txtYokaigoNinteiKyuSochiKubun) {
        this.getYokaigoNinteiJoho().setTxtYokaigoNinteiKyuSochiKubun(txtYokaigoNinteiKyuSochiKubun);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodo() {
        return this.getYokaigoNinteiJoho().getTxtYokaigodo();
    }

    @JsonIgnore
    public void  setTxtYokaigodo(TextBox txtYokaigodo) {
        this.getYokaigoNinteiJoho().setTxtYokaigodo(txtYokaigodo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYokaigoNinteiKaishiYmd() {
        return this.getYokaigoNinteiJoho().getTxtYokaigoNinteiKaishiYmd();
    }

    @JsonIgnore
    public void  setTxtYokaigoNinteiKaishiYmd(TextBoxFlexibleDate txtYokaigoNinteiKaishiYmd) {
        this.getYokaigoNinteiJoho().setTxtYokaigoNinteiKaishiYmd(txtYokaigoNinteiKaishiYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYokaigoNinteiShuryoYmd() {
        return this.getYokaigoNinteiJoho().getTxtYokaigoNinteiShuryoYmd();
    }

    @JsonIgnore
    public void  setTxtYokaigoNinteiShuryoYmd(TextBoxFlexibleDate txtYokaigoNinteiShuryoYmd) {
        this.getYokaigoNinteiJoho().setTxtYokaigoNinteiShuryoYmd(txtYokaigoNinteiShuryoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYokaigoNinteiNinteiYmd() {
        return this.getYokaigoNinteiJoho().getTxtYokaigoNinteiNinteiYmd();
    }

    @JsonIgnore
    public void  setTxtYokaigoNinteiNinteiYmd(TextBoxFlexibleDate txtYokaigoNinteiNinteiYmd) {
        this.getYokaigoNinteiJoho().setTxtYokaigoNinteiNinteiYmd(txtYokaigoNinteiNinteiYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiChuShinseiYmd() {
        return this.getShinseiChuJoho().getTxtShinseiChuShinseiYmd();
    }

    @JsonIgnore
    public void  setTxtShinseiChuShinseiYmd(TextBoxFlexibleDate txtShinseiChuShinseiYmd) {
        this.getShinseiChuJoho().setTxtShinseiChuShinseiYmd(txtShinseiChuShinseiYmd);
    }

    @JsonIgnore
    public TextBox getTxtShinseiChuShinseiShurui() {
        return this.getShinseiChuJoho().getTxtShinseiChuShinseiShurui();
    }

    @JsonIgnore
    public void  setTxtShinseiChuShinseiShurui(TextBox txtShinseiChuShinseiShurui) {
        this.getShinseiChuJoho().setTxtShinseiChuShinseiShurui(txtShinseiChuShinseiShurui);
    }

    @JsonIgnore
    public Label getLblKetteiKubun() {
        return this.getKakushuGemmenJoho().getLblKetteiKubun();
    }

    @JsonIgnore
    public void  setLblKetteiKubun(Label lblKetteiKubun) {
        this.getKakushuGemmenJoho().setLblKetteiKubun(lblKetteiKubun);
    }

    @JsonIgnore
    public Label getLblKaishiYMD() {
        return this.getKakushuGemmenJoho().getLblKaishiYMD();
    }

    @JsonIgnore
    public void  setLblKaishiYMD(Label lblKaishiYMD) {
        this.getKakushuGemmenJoho().setLblKaishiYMD(lblKaishiYMD);
    }

    @JsonIgnore
    public Label getLblShuryoYMD() {
        return this.getKakushuGemmenJoho().getLblShuryoYMD();
    }

    @JsonIgnore
    public void  setLblShuryoYMD(Label lblShuryoYMD) {
        this.getKakushuGemmenJoho().setLblShuryoYMD(lblShuryoYMD);
    }

    @JsonIgnore
    public Label getLblShinseiJokyo() {
        return this.getKakushuGemmenJoho().getLblShinseiJokyo();
    }

    @JsonIgnore
    public void  setLblShinseiJokyo(Label lblShinseiJokyo) {
        this.getKakushuGemmenJoho().setLblShinseiJokyo(lblShinseiJokyo);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendoGakuKetteiKubun() {
        return this.getKakushuGemmenJoho().getTxtFutanGendoGakuKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtFutanGendoGakuKetteiKubun(TextBox txtFutanGendoGakuKetteiKubun) {
        this.getKakushuGemmenJoho().setTxtFutanGendoGakuKetteiKubun(txtFutanGendoGakuKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendoGakuKaishiYMD() {
        return this.getKakushuGemmenJoho().getTxtFutanGendoGakuKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtFutanGendoGakuKaishiYMD(TextBoxFlexibleDate txtFutanGendoGakuKaishiYMD) {
        this.getKakushuGemmenJoho().setTxtFutanGendoGakuKaishiYMD(txtFutanGendoGakuKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendoGakuShuryoYMD() {
        return this.getKakushuGemmenJoho().getTxtFutanGendoGakuShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtFutanGendoGakuShuryoYMD(TextBoxFlexibleDate txtFutanGendoGakuShuryoYMD) {
        this.getKakushuGemmenJoho().setTxtFutanGendoGakuShuryoYMD(txtFutanGendoGakuShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaFutanDankai() {
        return this.getKakushuGemmenJoho().getTxtRiyoshaFutanDankai();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanDankai(TextBox txtRiyoshaFutanDankai) {
        this.getKakushuGemmenJoho().setTxtRiyoshaFutanDankai(txtRiyoshaFutanDankai);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendoGakuKyuSochi() {
        return this.getKakushuGemmenJoho().getTxtFutanGendoGakuKyuSochi();
    }

    @JsonIgnore
    public void  setTxtFutanGendoGakuKyuSochi(TextBox txtFutanGendoGakuKyuSochi) {
        this.getKakushuGemmenJoho().setTxtFutanGendoGakuKyuSochi(txtFutanGendoGakuKyuSochi);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendoGakuShinseiJokyo() {
        return this.getKakushuGemmenJoho().getTxtFutanGendoGakuShinseiJokyo();
    }

    @JsonIgnore
    public void  setTxtFutanGendoGakuShinseiJokyo(TextBox txtFutanGendoGakuShinseiJokyo) {
        this.getKakushuGemmenJoho().setTxtFutanGendoGakuShinseiJokyo(txtFutanGendoGakuShinseiJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendoGakuShinseiYMD() {
        return this.getKakushuGemmenJoho().getTxtFutanGendoGakuShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtFutanGendoGakuShinseiYMD(TextBoxFlexibleDate txtFutanGendoGakuShinseiYMD) {
        this.getKakushuGemmenJoho().setTxtFutanGendoGakuShinseiYMD(txtFutanGendoGakuShinseiYMD);
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaFutanKetteiKubun() {
        return this.getKakushuGemmenJoho().getTxtRiyoshaFutanKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanKetteiKubun(TextBox txtRiyoshaFutanKetteiKubun) {
        this.getKakushuGemmenJoho().setTxtRiyoshaFutanKetteiKubun(txtRiyoshaFutanKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanKaishiYMD() {
        return this.getKakushuGemmenJoho().getTxtRiyoshaFutanKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanKaishiYMD(TextBoxFlexibleDate txtRiyoshaFutanKaishiYMD) {
        this.getKakushuGemmenJoho().setTxtRiyoshaFutanKaishiYMD(txtRiyoshaFutanKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanShuryoYMD() {
        return this.getKakushuGemmenJoho().getTxtRiyoshaFutanShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanShuryoYMD(TextBoxFlexibleDate txtRiyoshaFutanShuryoYMD) {
        this.getKakushuGemmenJoho().setTxtRiyoshaFutanShuryoYMD(txtRiyoshaFutanShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaFutanKyufuRitsu() {
        return this.getKakushuGemmenJoho().getTxtRiyoshaFutanKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanKyufuRitsu(TextBox txtRiyoshaFutanKyufuRitsu) {
        this.getKakushuGemmenJoho().setTxtRiyoshaFutanKyufuRitsu(txtRiyoshaFutanKyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaFutanShinseiJokyo() {
        return this.getKakushuGemmenJoho().getTxtRiyoshaFutanShinseiJokyo();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanShinseiJokyo(TextBox txtRiyoshaFutanShinseiJokyo) {
        this.getKakushuGemmenJoho().setTxtRiyoshaFutanShinseiJokyo(txtRiyoshaFutanShinseiJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanShinseiYMD() {
        return this.getKakushuGemmenJoho().getTxtRiyoshaFutanShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanShinseiYMD(TextBoxFlexibleDate txtRiyoshaFutanShinseiYMD) {
        this.getKakushuGemmenJoho().setTxtRiyoshaFutanShinseiYMD(txtRiyoshaFutanShinseiYMD);
    }

    @JsonIgnore
    public TextBox getTxtHomonKaigoKetteiKubun() {
        return this.getKakushuGemmenJoho().getTxtHomonKaigoKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoKetteiKubun(TextBox txtHomonKaigoKetteiKubun) {
        this.getKakushuGemmenJoho().setTxtHomonKaigoKetteiKubun(txtHomonKaigoKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoKaishiYMD() {
        return this.getKakushuGemmenJoho().getTxtHomonKaigoKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoKaishiYMD(TextBoxFlexibleDate txtHomonKaigoKaishiYMD) {
        this.getKakushuGemmenJoho().setTxtHomonKaigoKaishiYMD(txtHomonKaigoKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoShuryoYMD() {
        return this.getKakushuGemmenJoho().getTxtHomonKaigoShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoShuryoYMD(TextBoxFlexibleDate txtHomonKaigoShuryoYMD) {
        this.getKakushuGemmenJoho().setTxtHomonKaigoShuryoYMD(txtHomonKaigoShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtHomonKaigoKyufuRitsu() {
        return this.getKakushuGemmenJoho().getTxtHomonKaigoKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoKyufuRitsu(TextBox txtHomonKaigoKyufuRitsu) {
        this.getKakushuGemmenJoho().setTxtHomonKaigoKyufuRitsu(txtHomonKaigoKyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtHomonKaigoBango() {
        return this.getKakushuGemmenJoho().getTxtHomonKaigoBango();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoBango(TextBox txtHomonKaigoBango) {
        this.getKakushuGemmenJoho().setTxtHomonKaigoBango(txtHomonKaigoBango);
    }

    @JsonIgnore
    public TextBox getTxtHomonKaigoHobetsuKubun() {
        return this.getKakushuGemmenJoho().getTxtHomonKaigoHobetsuKubun();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoHobetsuKubun(TextBox txtHomonKaigoHobetsuKubun) {
        this.getKakushuGemmenJoho().setTxtHomonKaigoHobetsuKubun(txtHomonKaigoHobetsuKubun);
    }

    @JsonIgnore
    public TextBox getTxtShaFukuKetteiKubun() {
        return this.getKakushuGemmenJoho().getTxtShaFukuKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtShaFukuKetteiKubun(TextBox txtShaFukuKetteiKubun) {
        this.getKakushuGemmenJoho().setTxtShaFukuKetteiKubun(txtShaFukuKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShaFukuKaishiYMD() {
        return this.getKakushuGemmenJoho().getTxtShaFukuKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtShaFukuKaishiYMD(TextBoxFlexibleDate txtShaFukuKaishiYMD) {
        this.getKakushuGemmenJoho().setTxtShaFukuKaishiYMD(txtShaFukuKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShaFukuShuryoYMD() {
        return this.getKakushuGemmenJoho().getTxtShaFukuShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtShaFukuShuryoYMD(TextBoxFlexibleDate txtShaFukuShuryoYMD) {
        this.getKakushuGemmenJoho().setTxtShaFukuShuryoYMD(txtShaFukuShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtShaFukuKyufuRitsu() {
        return this.getKakushuGemmenJoho().getTxtShaFukuKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtShaFukuKyufuRitsu(TextBox txtShaFukuKyufuRitsu) {
        this.getKakushuGemmenJoho().setTxtShaFukuKyufuRitsu(txtShaFukuKyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtShaFukuBango() {
        return this.getKakushuGemmenJoho().getTxtShaFukuBango();
    }

    @JsonIgnore
    public void  setTxtShaFukuBango(TextBox txtShaFukuBango) {
        this.getKakushuGemmenJoho().setTxtShaFukuBango(txtShaFukuBango);
    }

    @JsonIgnore
    public TextBox getTxtShaFukuShinseiJokyo() {
        return this.getKakushuGemmenJoho().getTxtShaFukuShinseiJokyo();
    }

    @JsonIgnore
    public void  setTxtShaFukuShinseiJokyo(TextBox txtShaFukuShinseiJokyo) {
        this.getKakushuGemmenJoho().setTxtShaFukuShinseiJokyo(txtShaFukuShinseiJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShaFukuShinseiYMD() {
        return this.getKakushuGemmenJoho().getTxtShaFukuShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShaFukuShinseiYMD(TextBoxFlexibleDate txtShaFukuShinseiYMD) {
        this.getKakushuGemmenJoho().setTxtShaFukuShinseiYMD(txtShaFukuShinseiYMD);
    }

    @JsonIgnore
    public TextBox getTxtTokubetsuChiikiKasanKetteiKubun() {
        return this.getKakushuGemmenJoho().getTxtTokubetsuChiikiKasanKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChiikiKasanKetteiKubun(TextBox txtTokubetsuChiikiKasanKetteiKubun) {
        this.getKakushuGemmenJoho().setTxtTokubetsuChiikiKasanKetteiKubun(txtTokubetsuChiikiKasanKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChiikiKasanKaishiYMD() {
        return this.getKakushuGemmenJoho().getTxtTokubetsuChiikiKasanKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChiikiKasanKaishiYMD(TextBoxFlexibleDate txtTokubetsuChiikiKasanKaishiYMD) {
        this.getKakushuGemmenJoho().setTxtTokubetsuChiikiKasanKaishiYMD(txtTokubetsuChiikiKasanKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChiikiKasanShuryoYMD() {
        return this.getKakushuGemmenJoho().getTxtTokubetsuChiikiKasanShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChiikiKasanShuryoYMD(TextBoxFlexibleDate txtTokubetsuChiikiKasanShuryoYMD) {
        this.getKakushuGemmenJoho().setTxtTokubetsuChiikiKasanShuryoYMD(txtTokubetsuChiikiKasanShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtTokubetsuChiikiKasanKyufuRitsu() {
        return this.getKakushuGemmenJoho().getTxtTokubetsuChiikiKasanKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChiikiKasanKyufuRitsu(TextBox txtTokubetsuChiikiKasanKyufuRitsu) {
        this.getKakushuGemmenJoho().setTxtTokubetsuChiikiKasanKyufuRitsu(txtTokubetsuChiikiKasanKyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtTokubetsuChiikiKasanKetteiKubunBango() {
        return this.getKakushuGemmenJoho().getTxtTokubetsuChiikiKasanKetteiKubunBango();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChiikiKasanKetteiKubunBango(TextBox txtTokubetsuChiikiKasanKetteiKubunBango) {
        this.getKakushuGemmenJoho().setTxtTokubetsuChiikiKasanKetteiKubunBango(txtTokubetsuChiikiKasanKetteiKubunBango);
    }

    @JsonIgnore
    public TextBox getTxtTokubetsuChiikiKasanShinseiJokyo() {
        return this.getKakushuGemmenJoho().getTxtTokubetsuChiikiKasanShinseiJokyo();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChiikiKasanShinseiJokyo(TextBox txtTokubetsuChiikiKasanShinseiJokyo) {
        this.getKakushuGemmenJoho().setTxtTokubetsuChiikiKasanShinseiJokyo(txtTokubetsuChiikiKasanShinseiJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChiikiKasanShinseiYMD() {
        return this.getKakushuGemmenJoho().getTxtTokubetsuChiikiKasanShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChiikiKasanShinseiYMD(TextBoxFlexibleDate txtTokubetsuChiikiKasanShinseiYMD) {
        this.getKakushuGemmenJoho().setTxtTokubetsuChiikiKasanShinseiYMD(txtTokubetsuChiikiKasanShinseiYMD);
    }

    @JsonIgnore
    public Label getLblRoreiFukushiNenkin() {
        return this.getRoreiSeihoJoho().getLblRoreiFukushiNenkin();
    }

    @JsonIgnore
    public void  setLblRoreiFukushiNenkin(Label lblRoreiFukushiNenkin) {
        this.getRoreiSeihoJoho().setLblRoreiFukushiNenkin(lblRoreiFukushiNenkin);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRoreiJukyuKaishiYMD() {
        return this.getRoreiSeihoJoho().getTxtRoreiJukyuKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtRoreiJukyuKaishiYMD(TextBoxFlexibleDate txtRoreiJukyuKaishiYMD) {
        this.getRoreiSeihoJoho().setTxtRoreiJukyuKaishiYMD(txtRoreiJukyuKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRoreiJukyuShuryoYMD() {
        return this.getRoreiSeihoJoho().getTxtRoreiJukyuShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtRoreiJukyuShuryoYMD(TextBoxFlexibleDate txtRoreiJukyuShuryoYMD) {
        this.getRoreiSeihoJoho().setTxtRoreiJukyuShuryoYMD(txtRoreiJukyuShuryoYMD);
    }

    @JsonIgnore
    public Label getLblSeikatsuHogo() {
        return this.getRoreiSeihoJoho().getLblSeikatsuHogo();
    }

    @JsonIgnore
    public void  setLblSeikatsuHogo(Label lblSeikatsuHogo) {
        this.getRoreiSeihoJoho().setLblSeikatsuHogo(lblSeikatsuHogo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSeihoJukyuKaishiYMD() {
        return this.getRoreiSeihoJoho().getTxtSeihoJukyuKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtSeihoJukyuKaishiYMD(TextBoxFlexibleDate txtSeihoJukyuKaishiYMD) {
        this.getRoreiSeihoJoho().setTxtSeihoJukyuKaishiYMD(txtSeihoJukyuKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSeihoJukyuHaishiYMD() {
        return this.getRoreiSeihoJoho().getTxtSeihoJukyuHaishiYMD();
    }

    @JsonIgnore
    public void  setTxtSeihoJukyuHaishiYMD(TextBoxFlexibleDate txtSeihoJukyuHaishiYMD) {
        this.getRoreiSeihoJoho().setTxtSeihoJukyuHaishiYMD(txtSeihoJukyuHaishiYMD);
    }

    @JsonIgnore
    public TextBox getTxtSeihoShubetsu() {
        return this.getRoreiSeihoJoho().getTxtSeihoShubetsu();
    }

    @JsonIgnore
    public void  setTxtSeihoShubetsu(TextBox txtSeihoShubetsu) {
        this.getRoreiSeihoJoho().setTxtSeihoShubetsu(txtSeihoShubetsu);
    }

    @JsonIgnore
    public Label getLblShiharaiHohoHenko() {
        return this.getKyufuSeigenJoho().getLblShiharaiHohoHenko();
    }

    @JsonIgnore
    public void  setLblShiharaiHohoHenko(Label lblShiharaiHohoHenko) {
        this.getKyufuSeigenJoho().setLblShiharaiHohoHenko(lblShiharaiHohoHenko);
    }

    @JsonIgnore
    public TextBox getTxtShiharaiHohoHenkoTorokuKubun() {
        return this.getKyufuSeigenJoho().getTxtShiharaiHohoHenkoTorokuKubun();
    }

    @JsonIgnore
    public void  setTxtShiharaiHohoHenkoTorokuKubun(TextBox txtShiharaiHohoHenkoTorokuKubun) {
        this.getKyufuSeigenJoho().setTxtShiharaiHohoHenkoTorokuKubun(txtShiharaiHohoHenkoTorokuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShiharaiHohoHenkoKaishiYMD() {
        return this.getKyufuSeigenJoho().getTxtShiharaiHohoHenkoKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtShiharaiHohoHenkoKaishiYMD(TextBoxFlexibleDate txtShiharaiHohoHenkoKaishiYMD) {
        this.getKyufuSeigenJoho().setTxtShiharaiHohoHenkoKaishiYMD(txtShiharaiHohoHenkoKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShiharaiHohoHenkoShuryoYMD() {
        return this.getKyufuSeigenJoho().getTxtShiharaiHohoHenkoShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtShiharaiHohoHenkoShuryoYMD(TextBoxFlexibleDate txtShiharaiHohoHenkoShuryoYMD) {
        this.getKyufuSeigenJoho().setTxtShiharaiHohoHenkoShuryoYMD(txtShiharaiHohoHenkoShuryoYMD);
    }

    @JsonIgnore
    public Label getLblKyufuGakuGengaku() {
        return this.getKyufuSeigenJoho().getLblKyufuGakuGengaku();
    }

    @JsonIgnore
    public void  setLblKyufuGakuGengaku(Label lblKyufuGakuGengaku) {
        this.getKyufuSeigenJoho().setLblKyufuGakuGengaku(lblKyufuGakuGengaku);
    }

    @JsonIgnore
    public TextBox getTxtKyufuGakuGengakuTorokuKubun() {
        return this.getKyufuSeigenJoho().getTxtKyufuGakuGengakuTorokuKubun();
    }

    @JsonIgnore
    public void  setTxtKyufuGakuGengakuTorokuKubun(TextBox txtKyufuGakuGengakuTorokuKubun) {
        this.getKyufuSeigenJoho().setTxtKyufuGakuGengakuTorokuKubun(txtKyufuGakuGengakuTorokuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKyufuGakuGengakuKaishiYMD() {
        return this.getKyufuSeigenJoho().getTxtKyufuGakuGengakuKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtKyufuGakuGengakuKaishiYMD(TextBoxFlexibleDate txtKyufuGakuGengakuKaishiYMD) {
        this.getKyufuSeigenJoho().setTxtKyufuGakuGengakuKaishiYMD(txtKyufuGakuGengakuKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKyufuGakuGengakuShuryoYMD() {
        return this.getKyufuSeigenJoho().getTxtKyufuGakuGengakuShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtKyufuGakuGengakuShuryoYMD(TextBoxFlexibleDate txtKyufuGakuGengakuShuryoYMD) {
        this.getKyufuSeigenJoho().setTxtKyufuGakuGengakuShuryoYMD(txtKyufuGakuGengakuShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtFutanWariai() {
        return this.getFutanWariaiJoho().getTxtFutanWariai();
    }

    @JsonIgnore
    public void  setTxtFutanWariai(TextBox txtFutanWariai) {
        this.getFutanWariaiJoho().setTxtFutanWariai(txtFutanWariai);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanWariaiKaishiYMD() {
        return this.getFutanWariaiJoho().getTxtFutanWariaiKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtFutanWariaiKaishiYMD(TextBoxFlexibleDate txtFutanWariaiKaishiYMD) {
        this.getFutanWariaiJoho().setTxtFutanWariaiKaishiYMD(txtFutanWariaiKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanWariaiShuryoYMD() {
        return this.getFutanWariaiJoho().getTxtFutanWariaiShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtFutanWariaiShuryoYMD(TextBoxFlexibleDate txtFutanWariaiShuryoYMD) {
        this.getFutanWariaiJoho().setTxtFutanWariaiShuryoYMD(txtFutanWariaiShuryoYMD);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initializa(HihokenshaNo 被保険者番号) {
        getHandler(this).onLoad(被保険者番号);
    }

    private GemmenShokaiHandler getHandler(GemmenShokaiDiv div) {
        return new GemmenShokaiHandler(div);
    }

}
