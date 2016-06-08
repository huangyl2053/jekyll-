package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmenshokai.GemmenShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KakushuGemmenJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KakushuGemmenJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKetteiKubun")
    private Label lblKetteiKubun;
    @JsonProperty("lblKaishiYMD")
    private Label lblKaishiYMD;
    @JsonProperty("lblShuryoYMD")
    private Label lblShuryoYMD;
    @JsonProperty("lblShinseiJokyo")
    private Label lblShinseiJokyo;
    @JsonProperty("txtFutanGendoGakuKetteiKubun")
    private TextBox txtFutanGendoGakuKetteiKubun;
    @JsonProperty("txtFutanGendoGakuKaishiYMD")
    private TextBoxFlexibleDate txtFutanGendoGakuKaishiYMD;
    @JsonProperty("txtFutanGendoGakuShuryoYMD")
    private TextBoxFlexibleDate txtFutanGendoGakuShuryoYMD;
    @JsonProperty("txtRiyoshaFutanDankai")
    private TextBox txtRiyoshaFutanDankai;
    @JsonProperty("txtFutanGendoGakuKyuSochi")
    private TextBox txtFutanGendoGakuKyuSochi;
    @JsonProperty("txtFutanGendoGakuShinseiJokyo")
    private TextBox txtFutanGendoGakuShinseiJokyo;
    @JsonProperty("txtFutanGendoGakuShinseiYMD")
    private TextBoxFlexibleDate txtFutanGendoGakuShinseiYMD;
    @JsonProperty("txtRiyoshaFutanKetteiKubun")
    private TextBox txtRiyoshaFutanKetteiKubun;
    @JsonProperty("txtRiyoshaFutanKaishiYMD")
    private TextBoxFlexibleDate txtRiyoshaFutanKaishiYMD;
    @JsonProperty("txtRiyoshaFutanShuryoYMD")
    private TextBoxFlexibleDate txtRiyoshaFutanShuryoYMD;
    @JsonProperty("txtRiyoshaFutanKyufuRitsu")
    private TextBox txtRiyoshaFutanKyufuRitsu;
    @JsonProperty("txtRiyoshaFutanShinseiJokyo")
    private TextBox txtRiyoshaFutanShinseiJokyo;
    @JsonProperty("txtRiyoshaFutanShinseiYMD")
    private TextBoxFlexibleDate txtRiyoshaFutanShinseiYMD;
    @JsonProperty("txtHomonKaigoKetteiKubun")
    private TextBox txtHomonKaigoKetteiKubun;
    @JsonProperty("txtHomonKaigoKaishiYMD")
    private TextBoxFlexibleDate txtHomonKaigoKaishiYMD;
    @JsonProperty("txtHomonKaigoShuryoYMD")
    private TextBoxFlexibleDate txtHomonKaigoShuryoYMD;
    @JsonProperty("txtHomonKaigoKyufuRitsu")
    private TextBox txtHomonKaigoKyufuRitsu;
    @JsonProperty("txtHomonKaigoBango")
    private TextBox txtHomonKaigoBango;
    @JsonProperty("txtHomonKaigoHobetsuKubun")
    private TextBox txtHomonKaigoHobetsuKubun;
    @JsonProperty("txtShaFukuKetteiKubun")
    private TextBox txtShaFukuKetteiKubun;
    @JsonProperty("txtShaFukuKaishiYMD")
    private TextBoxFlexibleDate txtShaFukuKaishiYMD;
    @JsonProperty("txtShaFukuShuryoYMD")
    private TextBoxFlexibleDate txtShaFukuShuryoYMD;
    @JsonProperty("txtShaFukuKyufuRitsu")
    private TextBox txtShaFukuKyufuRitsu;
    @JsonProperty("txtShaFukuBango")
    private TextBox txtShaFukuBango;
    @JsonProperty("txtShaFukuShinseiJokyo")
    private TextBox txtShaFukuShinseiJokyo;
    @JsonProperty("txtShaFukuShinseiYMD")
    private TextBoxFlexibleDate txtShaFukuShinseiYMD;
    @JsonProperty("txtTokubetsuChiikiKasanKetteiKubun")
    private TextBox txtTokubetsuChiikiKasanKetteiKubun;
    @JsonProperty("txtTokubetsuChiikiKasanKaishiYMD")
    private TextBoxFlexibleDate txtTokubetsuChiikiKasanKaishiYMD;
    @JsonProperty("txtTokubetsuChiikiKasanShuryoYMD")
    private TextBoxFlexibleDate txtTokubetsuChiikiKasanShuryoYMD;
    @JsonProperty("txtTokubetsuChiikiKasanKyufuRitsu")
    private TextBox txtTokubetsuChiikiKasanKyufuRitsu;
    @JsonProperty("txtTokubetsuChiikiKasanKetteiKubunBango")
    private TextBox txtTokubetsuChiikiKasanKetteiKubunBango;
    @JsonProperty("txtTokubetsuChiikiKasanShinseiJokyo")
    private TextBox txtTokubetsuChiikiKasanShinseiJokyo;
    @JsonProperty("txtTokubetsuChiikiKasanShinseiYMD")
    private TextBoxFlexibleDate txtTokubetsuChiikiKasanShinseiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKetteiKubun
     * @return lblKetteiKubun
     */
    @JsonProperty("lblKetteiKubun")
    public Label getLblKetteiKubun() {
        return lblKetteiKubun;
    }

    /*
     * setlblKetteiKubun
     * @param lblKetteiKubun lblKetteiKubun
     */
    @JsonProperty("lblKetteiKubun")
    public void setLblKetteiKubun(Label lblKetteiKubun) {
        this.lblKetteiKubun = lblKetteiKubun;
    }

    /*
     * getlblKaishiYMD
     * @return lblKaishiYMD
     */
    @JsonProperty("lblKaishiYMD")
    public Label getLblKaishiYMD() {
        return lblKaishiYMD;
    }

    /*
     * setlblKaishiYMD
     * @param lblKaishiYMD lblKaishiYMD
     */
    @JsonProperty("lblKaishiYMD")
    public void setLblKaishiYMD(Label lblKaishiYMD) {
        this.lblKaishiYMD = lblKaishiYMD;
    }

    /*
     * getlblShuryoYMD
     * @return lblShuryoYMD
     */
    @JsonProperty("lblShuryoYMD")
    public Label getLblShuryoYMD() {
        return lblShuryoYMD;
    }

    /*
     * setlblShuryoYMD
     * @param lblShuryoYMD lblShuryoYMD
     */
    @JsonProperty("lblShuryoYMD")
    public void setLblShuryoYMD(Label lblShuryoYMD) {
        this.lblShuryoYMD = lblShuryoYMD;
    }

    /*
     * getlblShinseiJokyo
     * @return lblShinseiJokyo
     */
    @JsonProperty("lblShinseiJokyo")
    public Label getLblShinseiJokyo() {
        return lblShinseiJokyo;
    }

    /*
     * setlblShinseiJokyo
     * @param lblShinseiJokyo lblShinseiJokyo
     */
    @JsonProperty("lblShinseiJokyo")
    public void setLblShinseiJokyo(Label lblShinseiJokyo) {
        this.lblShinseiJokyo = lblShinseiJokyo;
    }

    /*
     * gettxtFutanGendoGakuKetteiKubun
     * @return txtFutanGendoGakuKetteiKubun
     */
    @JsonProperty("txtFutanGendoGakuKetteiKubun")
    public TextBox getTxtFutanGendoGakuKetteiKubun() {
        return txtFutanGendoGakuKetteiKubun;
    }

    /*
     * settxtFutanGendoGakuKetteiKubun
     * @param txtFutanGendoGakuKetteiKubun txtFutanGendoGakuKetteiKubun
     */
    @JsonProperty("txtFutanGendoGakuKetteiKubun")
    public void setTxtFutanGendoGakuKetteiKubun(TextBox txtFutanGendoGakuKetteiKubun) {
        this.txtFutanGendoGakuKetteiKubun = txtFutanGendoGakuKetteiKubun;
    }

    /*
     * gettxtFutanGendoGakuKaishiYMD
     * @return txtFutanGendoGakuKaishiYMD
     */
    @JsonProperty("txtFutanGendoGakuKaishiYMD")
    public TextBoxFlexibleDate getTxtFutanGendoGakuKaishiYMD() {
        return txtFutanGendoGakuKaishiYMD;
    }

    /*
     * settxtFutanGendoGakuKaishiYMD
     * @param txtFutanGendoGakuKaishiYMD txtFutanGendoGakuKaishiYMD
     */
    @JsonProperty("txtFutanGendoGakuKaishiYMD")
    public void setTxtFutanGendoGakuKaishiYMD(TextBoxFlexibleDate txtFutanGendoGakuKaishiYMD) {
        this.txtFutanGendoGakuKaishiYMD = txtFutanGendoGakuKaishiYMD;
    }

    /*
     * gettxtFutanGendoGakuShuryoYMD
     * @return txtFutanGendoGakuShuryoYMD
     */
    @JsonProperty("txtFutanGendoGakuShuryoYMD")
    public TextBoxFlexibleDate getTxtFutanGendoGakuShuryoYMD() {
        return txtFutanGendoGakuShuryoYMD;
    }

    /*
     * settxtFutanGendoGakuShuryoYMD
     * @param txtFutanGendoGakuShuryoYMD txtFutanGendoGakuShuryoYMD
     */
    @JsonProperty("txtFutanGendoGakuShuryoYMD")
    public void setTxtFutanGendoGakuShuryoYMD(TextBoxFlexibleDate txtFutanGendoGakuShuryoYMD) {
        this.txtFutanGendoGakuShuryoYMD = txtFutanGendoGakuShuryoYMD;
    }

    /*
     * gettxtRiyoshaFutanDankai
     * @return txtRiyoshaFutanDankai
     */
    @JsonProperty("txtRiyoshaFutanDankai")
    public TextBox getTxtRiyoshaFutanDankai() {
        return txtRiyoshaFutanDankai;
    }

    /*
     * settxtRiyoshaFutanDankai
     * @param txtRiyoshaFutanDankai txtRiyoshaFutanDankai
     */
    @JsonProperty("txtRiyoshaFutanDankai")
    public void setTxtRiyoshaFutanDankai(TextBox txtRiyoshaFutanDankai) {
        this.txtRiyoshaFutanDankai = txtRiyoshaFutanDankai;
    }

    /*
     * gettxtFutanGendoGakuKyuSochi
     * @return txtFutanGendoGakuKyuSochi
     */
    @JsonProperty("txtFutanGendoGakuKyuSochi")
    public TextBox getTxtFutanGendoGakuKyuSochi() {
        return txtFutanGendoGakuKyuSochi;
    }

    /*
     * settxtFutanGendoGakuKyuSochi
     * @param txtFutanGendoGakuKyuSochi txtFutanGendoGakuKyuSochi
     */
    @JsonProperty("txtFutanGendoGakuKyuSochi")
    public void setTxtFutanGendoGakuKyuSochi(TextBox txtFutanGendoGakuKyuSochi) {
        this.txtFutanGendoGakuKyuSochi = txtFutanGendoGakuKyuSochi;
    }

    /*
     * gettxtFutanGendoGakuShinseiJokyo
     * @return txtFutanGendoGakuShinseiJokyo
     */
    @JsonProperty("txtFutanGendoGakuShinseiJokyo")
    public TextBox getTxtFutanGendoGakuShinseiJokyo() {
        return txtFutanGendoGakuShinseiJokyo;
    }

    /*
     * settxtFutanGendoGakuShinseiJokyo
     * @param txtFutanGendoGakuShinseiJokyo txtFutanGendoGakuShinseiJokyo
     */
    @JsonProperty("txtFutanGendoGakuShinseiJokyo")
    public void setTxtFutanGendoGakuShinseiJokyo(TextBox txtFutanGendoGakuShinseiJokyo) {
        this.txtFutanGendoGakuShinseiJokyo = txtFutanGendoGakuShinseiJokyo;
    }

    /*
     * gettxtFutanGendoGakuShinseiYMD
     * @return txtFutanGendoGakuShinseiYMD
     */
    @JsonProperty("txtFutanGendoGakuShinseiYMD")
    public TextBoxFlexibleDate getTxtFutanGendoGakuShinseiYMD() {
        return txtFutanGendoGakuShinseiYMD;
    }

    /*
     * settxtFutanGendoGakuShinseiYMD
     * @param txtFutanGendoGakuShinseiYMD txtFutanGendoGakuShinseiYMD
     */
    @JsonProperty("txtFutanGendoGakuShinseiYMD")
    public void setTxtFutanGendoGakuShinseiYMD(TextBoxFlexibleDate txtFutanGendoGakuShinseiYMD) {
        this.txtFutanGendoGakuShinseiYMD = txtFutanGendoGakuShinseiYMD;
    }

    /*
     * gettxtRiyoshaFutanKetteiKubun
     * @return txtRiyoshaFutanKetteiKubun
     */
    @JsonProperty("txtRiyoshaFutanKetteiKubun")
    public TextBox getTxtRiyoshaFutanKetteiKubun() {
        return txtRiyoshaFutanKetteiKubun;
    }

    /*
     * settxtRiyoshaFutanKetteiKubun
     * @param txtRiyoshaFutanKetteiKubun txtRiyoshaFutanKetteiKubun
     */
    @JsonProperty("txtRiyoshaFutanKetteiKubun")
    public void setTxtRiyoshaFutanKetteiKubun(TextBox txtRiyoshaFutanKetteiKubun) {
        this.txtRiyoshaFutanKetteiKubun = txtRiyoshaFutanKetteiKubun;
    }

    /*
     * gettxtRiyoshaFutanKaishiYMD
     * @return txtRiyoshaFutanKaishiYMD
     */
    @JsonProperty("txtRiyoshaFutanKaishiYMD")
    public TextBoxFlexibleDate getTxtRiyoshaFutanKaishiYMD() {
        return txtRiyoshaFutanKaishiYMD;
    }

    /*
     * settxtRiyoshaFutanKaishiYMD
     * @param txtRiyoshaFutanKaishiYMD txtRiyoshaFutanKaishiYMD
     */
    @JsonProperty("txtRiyoshaFutanKaishiYMD")
    public void setTxtRiyoshaFutanKaishiYMD(TextBoxFlexibleDate txtRiyoshaFutanKaishiYMD) {
        this.txtRiyoshaFutanKaishiYMD = txtRiyoshaFutanKaishiYMD;
    }

    /*
     * gettxtRiyoshaFutanShuryoYMD
     * @return txtRiyoshaFutanShuryoYMD
     */
    @JsonProperty("txtRiyoshaFutanShuryoYMD")
    public TextBoxFlexibleDate getTxtRiyoshaFutanShuryoYMD() {
        return txtRiyoshaFutanShuryoYMD;
    }

    /*
     * settxtRiyoshaFutanShuryoYMD
     * @param txtRiyoshaFutanShuryoYMD txtRiyoshaFutanShuryoYMD
     */
    @JsonProperty("txtRiyoshaFutanShuryoYMD")
    public void setTxtRiyoshaFutanShuryoYMD(TextBoxFlexibleDate txtRiyoshaFutanShuryoYMD) {
        this.txtRiyoshaFutanShuryoYMD = txtRiyoshaFutanShuryoYMD;
    }

    /*
     * gettxtRiyoshaFutanKyufuRitsu
     * @return txtRiyoshaFutanKyufuRitsu
     */
    @JsonProperty("txtRiyoshaFutanKyufuRitsu")
    public TextBox getTxtRiyoshaFutanKyufuRitsu() {
        return txtRiyoshaFutanKyufuRitsu;
    }

    /*
     * settxtRiyoshaFutanKyufuRitsu
     * @param txtRiyoshaFutanKyufuRitsu txtRiyoshaFutanKyufuRitsu
     */
    @JsonProperty("txtRiyoshaFutanKyufuRitsu")
    public void setTxtRiyoshaFutanKyufuRitsu(TextBox txtRiyoshaFutanKyufuRitsu) {
        this.txtRiyoshaFutanKyufuRitsu = txtRiyoshaFutanKyufuRitsu;
    }

    /*
     * gettxtRiyoshaFutanShinseiJokyo
     * @return txtRiyoshaFutanShinseiJokyo
     */
    @JsonProperty("txtRiyoshaFutanShinseiJokyo")
    public TextBox getTxtRiyoshaFutanShinseiJokyo() {
        return txtRiyoshaFutanShinseiJokyo;
    }

    /*
     * settxtRiyoshaFutanShinseiJokyo
     * @param txtRiyoshaFutanShinseiJokyo txtRiyoshaFutanShinseiJokyo
     */
    @JsonProperty("txtRiyoshaFutanShinseiJokyo")
    public void setTxtRiyoshaFutanShinseiJokyo(TextBox txtRiyoshaFutanShinseiJokyo) {
        this.txtRiyoshaFutanShinseiJokyo = txtRiyoshaFutanShinseiJokyo;
    }

    /*
     * gettxtRiyoshaFutanShinseiYMD
     * @return txtRiyoshaFutanShinseiYMD
     */
    @JsonProperty("txtRiyoshaFutanShinseiYMD")
    public TextBoxFlexibleDate getTxtRiyoshaFutanShinseiYMD() {
        return txtRiyoshaFutanShinseiYMD;
    }

    /*
     * settxtRiyoshaFutanShinseiYMD
     * @param txtRiyoshaFutanShinseiYMD txtRiyoshaFutanShinseiYMD
     */
    @JsonProperty("txtRiyoshaFutanShinseiYMD")
    public void setTxtRiyoshaFutanShinseiYMD(TextBoxFlexibleDate txtRiyoshaFutanShinseiYMD) {
        this.txtRiyoshaFutanShinseiYMD = txtRiyoshaFutanShinseiYMD;
    }

    /*
     * gettxtHomonKaigoKetteiKubun
     * @return txtHomonKaigoKetteiKubun
     */
    @JsonProperty("txtHomonKaigoKetteiKubun")
    public TextBox getTxtHomonKaigoKetteiKubun() {
        return txtHomonKaigoKetteiKubun;
    }

    /*
     * settxtHomonKaigoKetteiKubun
     * @param txtHomonKaigoKetteiKubun txtHomonKaigoKetteiKubun
     */
    @JsonProperty("txtHomonKaigoKetteiKubun")
    public void setTxtHomonKaigoKetteiKubun(TextBox txtHomonKaigoKetteiKubun) {
        this.txtHomonKaigoKetteiKubun = txtHomonKaigoKetteiKubun;
    }

    /*
     * gettxtHomonKaigoKaishiYMD
     * @return txtHomonKaigoKaishiYMD
     */
    @JsonProperty("txtHomonKaigoKaishiYMD")
    public TextBoxFlexibleDate getTxtHomonKaigoKaishiYMD() {
        return txtHomonKaigoKaishiYMD;
    }

    /*
     * settxtHomonKaigoKaishiYMD
     * @param txtHomonKaigoKaishiYMD txtHomonKaigoKaishiYMD
     */
    @JsonProperty("txtHomonKaigoKaishiYMD")
    public void setTxtHomonKaigoKaishiYMD(TextBoxFlexibleDate txtHomonKaigoKaishiYMD) {
        this.txtHomonKaigoKaishiYMD = txtHomonKaigoKaishiYMD;
    }

    /*
     * gettxtHomonKaigoShuryoYMD
     * @return txtHomonKaigoShuryoYMD
     */
    @JsonProperty("txtHomonKaigoShuryoYMD")
    public TextBoxFlexibleDate getTxtHomonKaigoShuryoYMD() {
        return txtHomonKaigoShuryoYMD;
    }

    /*
     * settxtHomonKaigoShuryoYMD
     * @param txtHomonKaigoShuryoYMD txtHomonKaigoShuryoYMD
     */
    @JsonProperty("txtHomonKaigoShuryoYMD")
    public void setTxtHomonKaigoShuryoYMD(TextBoxFlexibleDate txtHomonKaigoShuryoYMD) {
        this.txtHomonKaigoShuryoYMD = txtHomonKaigoShuryoYMD;
    }

    /*
     * gettxtHomonKaigoKyufuRitsu
     * @return txtHomonKaigoKyufuRitsu
     */
    @JsonProperty("txtHomonKaigoKyufuRitsu")
    public TextBox getTxtHomonKaigoKyufuRitsu() {
        return txtHomonKaigoKyufuRitsu;
    }

    /*
     * settxtHomonKaigoKyufuRitsu
     * @param txtHomonKaigoKyufuRitsu txtHomonKaigoKyufuRitsu
     */
    @JsonProperty("txtHomonKaigoKyufuRitsu")
    public void setTxtHomonKaigoKyufuRitsu(TextBox txtHomonKaigoKyufuRitsu) {
        this.txtHomonKaigoKyufuRitsu = txtHomonKaigoKyufuRitsu;
    }

    /*
     * gettxtHomonKaigoBango
     * @return txtHomonKaigoBango
     */
    @JsonProperty("txtHomonKaigoBango")
    public TextBox getTxtHomonKaigoBango() {
        return txtHomonKaigoBango;
    }

    /*
     * settxtHomonKaigoBango
     * @param txtHomonKaigoBango txtHomonKaigoBango
     */
    @JsonProperty("txtHomonKaigoBango")
    public void setTxtHomonKaigoBango(TextBox txtHomonKaigoBango) {
        this.txtHomonKaigoBango = txtHomonKaigoBango;
    }

    /*
     * gettxtHomonKaigoHobetsuKubun
     * @return txtHomonKaigoHobetsuKubun
     */
    @JsonProperty("txtHomonKaigoHobetsuKubun")
    public TextBox getTxtHomonKaigoHobetsuKubun() {
        return txtHomonKaigoHobetsuKubun;
    }

    /*
     * settxtHomonKaigoHobetsuKubun
     * @param txtHomonKaigoHobetsuKubun txtHomonKaigoHobetsuKubun
     */
    @JsonProperty("txtHomonKaigoHobetsuKubun")
    public void setTxtHomonKaigoHobetsuKubun(TextBox txtHomonKaigoHobetsuKubun) {
        this.txtHomonKaigoHobetsuKubun = txtHomonKaigoHobetsuKubun;
    }

    /*
     * gettxtShaFukuKetteiKubun
     * @return txtShaFukuKetteiKubun
     */
    @JsonProperty("txtShaFukuKetteiKubun")
    public TextBox getTxtShaFukuKetteiKubun() {
        return txtShaFukuKetteiKubun;
    }

    /*
     * settxtShaFukuKetteiKubun
     * @param txtShaFukuKetteiKubun txtShaFukuKetteiKubun
     */
    @JsonProperty("txtShaFukuKetteiKubun")
    public void setTxtShaFukuKetteiKubun(TextBox txtShaFukuKetteiKubun) {
        this.txtShaFukuKetteiKubun = txtShaFukuKetteiKubun;
    }

    /*
     * gettxtShaFukuKaishiYMD
     * @return txtShaFukuKaishiYMD
     */
    @JsonProperty("txtShaFukuKaishiYMD")
    public TextBoxFlexibleDate getTxtShaFukuKaishiYMD() {
        return txtShaFukuKaishiYMD;
    }

    /*
     * settxtShaFukuKaishiYMD
     * @param txtShaFukuKaishiYMD txtShaFukuKaishiYMD
     */
    @JsonProperty("txtShaFukuKaishiYMD")
    public void setTxtShaFukuKaishiYMD(TextBoxFlexibleDate txtShaFukuKaishiYMD) {
        this.txtShaFukuKaishiYMD = txtShaFukuKaishiYMD;
    }

    /*
     * gettxtShaFukuShuryoYMD
     * @return txtShaFukuShuryoYMD
     */
    @JsonProperty("txtShaFukuShuryoYMD")
    public TextBoxFlexibleDate getTxtShaFukuShuryoYMD() {
        return txtShaFukuShuryoYMD;
    }

    /*
     * settxtShaFukuShuryoYMD
     * @param txtShaFukuShuryoYMD txtShaFukuShuryoYMD
     */
    @JsonProperty("txtShaFukuShuryoYMD")
    public void setTxtShaFukuShuryoYMD(TextBoxFlexibleDate txtShaFukuShuryoYMD) {
        this.txtShaFukuShuryoYMD = txtShaFukuShuryoYMD;
    }

    /*
     * gettxtShaFukuKyufuRitsu
     * @return txtShaFukuKyufuRitsu
     */
    @JsonProperty("txtShaFukuKyufuRitsu")
    public TextBox getTxtShaFukuKyufuRitsu() {
        return txtShaFukuKyufuRitsu;
    }

    /*
     * settxtShaFukuKyufuRitsu
     * @param txtShaFukuKyufuRitsu txtShaFukuKyufuRitsu
     */
    @JsonProperty("txtShaFukuKyufuRitsu")
    public void setTxtShaFukuKyufuRitsu(TextBox txtShaFukuKyufuRitsu) {
        this.txtShaFukuKyufuRitsu = txtShaFukuKyufuRitsu;
    }

    /*
     * gettxtShaFukuBango
     * @return txtShaFukuBango
     */
    @JsonProperty("txtShaFukuBango")
    public TextBox getTxtShaFukuBango() {
        return txtShaFukuBango;
    }

    /*
     * settxtShaFukuBango
     * @param txtShaFukuBango txtShaFukuBango
     */
    @JsonProperty("txtShaFukuBango")
    public void setTxtShaFukuBango(TextBox txtShaFukuBango) {
        this.txtShaFukuBango = txtShaFukuBango;
    }

    /*
     * gettxtShaFukuShinseiJokyo
     * @return txtShaFukuShinseiJokyo
     */
    @JsonProperty("txtShaFukuShinseiJokyo")
    public TextBox getTxtShaFukuShinseiJokyo() {
        return txtShaFukuShinseiJokyo;
    }

    /*
     * settxtShaFukuShinseiJokyo
     * @param txtShaFukuShinseiJokyo txtShaFukuShinseiJokyo
     */
    @JsonProperty("txtShaFukuShinseiJokyo")
    public void setTxtShaFukuShinseiJokyo(TextBox txtShaFukuShinseiJokyo) {
        this.txtShaFukuShinseiJokyo = txtShaFukuShinseiJokyo;
    }

    /*
     * gettxtShaFukuShinseiYMD
     * @return txtShaFukuShinseiYMD
     */
    @JsonProperty("txtShaFukuShinseiYMD")
    public TextBoxFlexibleDate getTxtShaFukuShinseiYMD() {
        return txtShaFukuShinseiYMD;
    }

    /*
     * settxtShaFukuShinseiYMD
     * @param txtShaFukuShinseiYMD txtShaFukuShinseiYMD
     */
    @JsonProperty("txtShaFukuShinseiYMD")
    public void setTxtShaFukuShinseiYMD(TextBoxFlexibleDate txtShaFukuShinseiYMD) {
        this.txtShaFukuShinseiYMD = txtShaFukuShinseiYMD;
    }

    /*
     * gettxtTokubetsuChiikiKasanKetteiKubun
     * @return txtTokubetsuChiikiKasanKetteiKubun
     */
    @JsonProperty("txtTokubetsuChiikiKasanKetteiKubun")
    public TextBox getTxtTokubetsuChiikiKasanKetteiKubun() {
        return txtTokubetsuChiikiKasanKetteiKubun;
    }

    /*
     * settxtTokubetsuChiikiKasanKetteiKubun
     * @param txtTokubetsuChiikiKasanKetteiKubun txtTokubetsuChiikiKasanKetteiKubun
     */
    @JsonProperty("txtTokubetsuChiikiKasanKetteiKubun")
    public void setTxtTokubetsuChiikiKasanKetteiKubun(TextBox txtTokubetsuChiikiKasanKetteiKubun) {
        this.txtTokubetsuChiikiKasanKetteiKubun = txtTokubetsuChiikiKasanKetteiKubun;
    }

    /*
     * gettxtTokubetsuChiikiKasanKaishiYMD
     * @return txtTokubetsuChiikiKasanKaishiYMD
     */
    @JsonProperty("txtTokubetsuChiikiKasanKaishiYMD")
    public TextBoxFlexibleDate getTxtTokubetsuChiikiKasanKaishiYMD() {
        return txtTokubetsuChiikiKasanKaishiYMD;
    }

    /*
     * settxtTokubetsuChiikiKasanKaishiYMD
     * @param txtTokubetsuChiikiKasanKaishiYMD txtTokubetsuChiikiKasanKaishiYMD
     */
    @JsonProperty("txtTokubetsuChiikiKasanKaishiYMD")
    public void setTxtTokubetsuChiikiKasanKaishiYMD(TextBoxFlexibleDate txtTokubetsuChiikiKasanKaishiYMD) {
        this.txtTokubetsuChiikiKasanKaishiYMD = txtTokubetsuChiikiKasanKaishiYMD;
    }

    /*
     * gettxtTokubetsuChiikiKasanShuryoYMD
     * @return txtTokubetsuChiikiKasanShuryoYMD
     */
    @JsonProperty("txtTokubetsuChiikiKasanShuryoYMD")
    public TextBoxFlexibleDate getTxtTokubetsuChiikiKasanShuryoYMD() {
        return txtTokubetsuChiikiKasanShuryoYMD;
    }

    /*
     * settxtTokubetsuChiikiKasanShuryoYMD
     * @param txtTokubetsuChiikiKasanShuryoYMD txtTokubetsuChiikiKasanShuryoYMD
     */
    @JsonProperty("txtTokubetsuChiikiKasanShuryoYMD")
    public void setTxtTokubetsuChiikiKasanShuryoYMD(TextBoxFlexibleDate txtTokubetsuChiikiKasanShuryoYMD) {
        this.txtTokubetsuChiikiKasanShuryoYMD = txtTokubetsuChiikiKasanShuryoYMD;
    }

    /*
     * gettxtTokubetsuChiikiKasanKyufuRitsu
     * @return txtTokubetsuChiikiKasanKyufuRitsu
     */
    @JsonProperty("txtTokubetsuChiikiKasanKyufuRitsu")
    public TextBox getTxtTokubetsuChiikiKasanKyufuRitsu() {
        return txtTokubetsuChiikiKasanKyufuRitsu;
    }

    /*
     * settxtTokubetsuChiikiKasanKyufuRitsu
     * @param txtTokubetsuChiikiKasanKyufuRitsu txtTokubetsuChiikiKasanKyufuRitsu
     */
    @JsonProperty("txtTokubetsuChiikiKasanKyufuRitsu")
    public void setTxtTokubetsuChiikiKasanKyufuRitsu(TextBox txtTokubetsuChiikiKasanKyufuRitsu) {
        this.txtTokubetsuChiikiKasanKyufuRitsu = txtTokubetsuChiikiKasanKyufuRitsu;
    }

    /*
     * gettxtTokubetsuChiikiKasanKetteiKubunBango
     * @return txtTokubetsuChiikiKasanKetteiKubunBango
     */
    @JsonProperty("txtTokubetsuChiikiKasanKetteiKubunBango")
    public TextBox getTxtTokubetsuChiikiKasanKetteiKubunBango() {
        return txtTokubetsuChiikiKasanKetteiKubunBango;
    }

    /*
     * settxtTokubetsuChiikiKasanKetteiKubunBango
     * @param txtTokubetsuChiikiKasanKetteiKubunBango txtTokubetsuChiikiKasanKetteiKubunBango
     */
    @JsonProperty("txtTokubetsuChiikiKasanKetteiKubunBango")
    public void setTxtTokubetsuChiikiKasanKetteiKubunBango(TextBox txtTokubetsuChiikiKasanKetteiKubunBango) {
        this.txtTokubetsuChiikiKasanKetteiKubunBango = txtTokubetsuChiikiKasanKetteiKubunBango;
    }

    /*
     * gettxtTokubetsuChiikiKasanShinseiJokyo
     * @return txtTokubetsuChiikiKasanShinseiJokyo
     */
    @JsonProperty("txtTokubetsuChiikiKasanShinseiJokyo")
    public TextBox getTxtTokubetsuChiikiKasanShinseiJokyo() {
        return txtTokubetsuChiikiKasanShinseiJokyo;
    }

    /*
     * settxtTokubetsuChiikiKasanShinseiJokyo
     * @param txtTokubetsuChiikiKasanShinseiJokyo txtTokubetsuChiikiKasanShinseiJokyo
     */
    @JsonProperty("txtTokubetsuChiikiKasanShinseiJokyo")
    public void setTxtTokubetsuChiikiKasanShinseiJokyo(TextBox txtTokubetsuChiikiKasanShinseiJokyo) {
        this.txtTokubetsuChiikiKasanShinseiJokyo = txtTokubetsuChiikiKasanShinseiJokyo;
    }

    /*
     * gettxtTokubetsuChiikiKasanShinseiYMD
     * @return txtTokubetsuChiikiKasanShinseiYMD
     */
    @JsonProperty("txtTokubetsuChiikiKasanShinseiYMD")
    public TextBoxFlexibleDate getTxtTokubetsuChiikiKasanShinseiYMD() {
        return txtTokubetsuChiikiKasanShinseiYMD;
    }

    /*
     * settxtTokubetsuChiikiKasanShinseiYMD
     * @param txtTokubetsuChiikiKasanShinseiYMD txtTokubetsuChiikiKasanShinseiYMD
     */
    @JsonProperty("txtTokubetsuChiikiKasanShinseiYMD")
    public void setTxtTokubetsuChiikiKasanShinseiYMD(TextBoxFlexibleDate txtTokubetsuChiikiKasanShinseiYMD) {
        this.txtTokubetsuChiikiKasanShinseiYMD = txtTokubetsuChiikiKasanShinseiYMD;
    }

    // </editor-fold>
}
