package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600021;
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
 * JyukyusyaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JyukyusyaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SikakuJoho")
    private SikakuJohoDiv SikakuJoho;
    @JsonProperty("YokaigoNinteJoho")
    private YokaigoNinteJohoDiv YokaigoNinteJoho;
    @JsonProperty("NinteSinseJoho")
    private NinteSinseJohoDiv NinteSinseJoho;
    @JsonProperty("KakushuGenmenJoho")
    private KakushuGenmenJohoDiv KakushuGenmenJoho;
    @JsonProperty("KyuhuSeigenJoho")
    private KyuhuSeigenJohoDiv KyuhuSeigenJoho;
    @JsonProperty("SogoJigyoTaisyosyaJoho")
    private SogoJigyoTaisyosyaJohoDiv SogoJigyoTaisyosyaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSikakuJoho
     * @return SikakuJoho
     */
    @JsonProperty("SikakuJoho")
    public SikakuJohoDiv getSikakuJoho() {
        return SikakuJoho;
    }

    /*
     * setSikakuJoho
     * @param SikakuJoho SikakuJoho
     */
    @JsonProperty("SikakuJoho")
    public void setSikakuJoho(SikakuJohoDiv SikakuJoho) {
        this.SikakuJoho = SikakuJoho;
    }

    /*
     * getYokaigoNinteJoho
     * @return YokaigoNinteJoho
     */
    @JsonProperty("YokaigoNinteJoho")
    public YokaigoNinteJohoDiv getYokaigoNinteJoho() {
        return YokaigoNinteJoho;
    }

    /*
     * setYokaigoNinteJoho
     * @param YokaigoNinteJoho YokaigoNinteJoho
     */
    @JsonProperty("YokaigoNinteJoho")
    public void setYokaigoNinteJoho(YokaigoNinteJohoDiv YokaigoNinteJoho) {
        this.YokaigoNinteJoho = YokaigoNinteJoho;
    }

    /*
     * getNinteSinseJoho
     * @return NinteSinseJoho
     */
    @JsonProperty("NinteSinseJoho")
    public NinteSinseJohoDiv getNinteSinseJoho() {
        return NinteSinseJoho;
    }

    /*
     * setNinteSinseJoho
     * @param NinteSinseJoho NinteSinseJoho
     */
    @JsonProperty("NinteSinseJoho")
    public void setNinteSinseJoho(NinteSinseJohoDiv NinteSinseJoho) {
        this.NinteSinseJoho = NinteSinseJoho;
    }

    /*
     * getKakushuGenmenJoho
     * @return KakushuGenmenJoho
     */
    @JsonProperty("KakushuGenmenJoho")
    public KakushuGenmenJohoDiv getKakushuGenmenJoho() {
        return KakushuGenmenJoho;
    }

    /*
     * setKakushuGenmenJoho
     * @param KakushuGenmenJoho KakushuGenmenJoho
     */
    @JsonProperty("KakushuGenmenJoho")
    public void setKakushuGenmenJoho(KakushuGenmenJohoDiv KakushuGenmenJoho) {
        this.KakushuGenmenJoho = KakushuGenmenJoho;
    }

    /*
     * getKyuhuSeigenJoho
     * @return KyuhuSeigenJoho
     */
    @JsonProperty("KyuhuSeigenJoho")
    public KyuhuSeigenJohoDiv getKyuhuSeigenJoho() {
        return KyuhuSeigenJoho;
    }

    /*
     * setKyuhuSeigenJoho
     * @param KyuhuSeigenJoho KyuhuSeigenJoho
     */
    @JsonProperty("KyuhuSeigenJoho")
    public void setKyuhuSeigenJoho(KyuhuSeigenJohoDiv KyuhuSeigenJoho) {
        this.KyuhuSeigenJoho = KyuhuSeigenJoho;
    }

    /*
     * getSogoJigyoTaisyosyaJoho
     * @return SogoJigyoTaisyosyaJoho
     */
    @JsonProperty("SogoJigyoTaisyosyaJoho")
    public SogoJigyoTaisyosyaJohoDiv getSogoJigyoTaisyosyaJoho() {
        return SogoJigyoTaisyosyaJoho;
    }

    /*
     * setSogoJigyoTaisyosyaJoho
     * @param SogoJigyoTaisyosyaJoho SogoJigyoTaisyosyaJoho
     */
    @JsonProperty("SogoJigyoTaisyosyaJoho")
    public void setSogoJigyoTaisyosyaJoho(SogoJigyoTaisyosyaJohoDiv SogoJigyoTaisyosyaJoho) {
        this.SogoJigyoTaisyosyaJoho = SogoJigyoTaisyosyaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getSikakuJohoButton() {
        return this.getSikakuJoho().getSikakuJohoButton();
    }

    @JsonIgnore
    public void  setSikakuJohoButton(Button SikakuJohoButton) {
        this.getSikakuJoho().setSikakuJohoButton(SikakuJohoButton);
    }

    @JsonIgnore
    public Button getJyukyusyaJohoButton() {
        return this.getSikakuJoho().getJyukyusyaJohoButton();
    }

    @JsonIgnore
    public void  setJyukyusyaJohoButton(Button JyukyusyaJohoButton) {
        this.getSikakuJoho().setJyukyusyaJohoButton(JyukyusyaJohoButton);
    }

    @JsonIgnore
    public Button getKyuhuJohoButton() {
        return this.getSikakuJoho().getKyuhuJohoButton();
    }

    @JsonIgnore
    public void  setKyuhuJohoButton(Button KyuhuJohoButton) {
        this.getSikakuJoho().setKyuhuJohoButton(KyuhuJohoButton);
    }

    @JsonIgnore
    public Button getHukaJohoButton() {
        return this.getSikakuJoho().getHukaJohoButton();
    }

    @JsonIgnore
    public void  setHukaJohoButton(Button HukaJohoButton) {
        this.getSikakuJoho().setHukaJohoButton(HukaJohoButton);
    }

    @JsonIgnore
    public Button getJyuminJohoButton() {
        return this.getSikakuJoho().getJyuminJohoButton();
    }

    @JsonIgnore
    public void  setJyuminJohoButton(Button JyuminJohoButton) {
        this.getSikakuJoho().setJyuminJohoButton(JyuminJohoButton);
    }

    @JsonIgnore
    public Button getJyukyuJohoButton() {
        return this.getSikakuJoho().getJyukyuJohoButton();
    }

    @JsonIgnore
    public void  setJyukyuJohoButton(Button JyukyuJohoButton) {
        this.getSikakuJoho().setJyukyuJohoButton(JyukyuJohoButton);
    }

    @JsonIgnore
    public TextBox getYokaigoDo() {
        return this.getYokaigoNinteJoho().getYokaigoDo();
    }

    @JsonIgnore
    public void  setYokaigoDo(TextBox YokaigoDo) {
        this.getYokaigoNinteJoho().setYokaigoDo(YokaigoDo);
    }

    @JsonIgnore
    public TextBoxDate getNinteiYukoFromYYMMDD() {
        return this.getYokaigoNinteJoho().getNinteiYukoFromYYMMDD();
    }

    @JsonIgnore
    public void  setNinteiYukoFromYYMMDD(TextBoxDate NinteiYukoFromYYMMDD) {
        this.getYokaigoNinteJoho().setNinteiYukoFromYYMMDD(NinteiYukoFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getYokaigoNinteJohoSinseiYYMMDD() {
        return this.getYokaigoNinteJoho().getYokaigoNinteJohoSinseiYYMMDD();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoSinseiYYMMDD(TextBoxDate YokaigoNinteJohoSinseiYYMMDD) {
        this.getYokaigoNinteJoho().setYokaigoNinteJohoSinseiYYMMDD(YokaigoNinteJohoSinseiYYMMDD);
    }

    @JsonIgnore
    public TextBox getYokaigoNinteJohoSinseiSyubetu() {
        return this.getYokaigoNinteJoho().getYokaigoNinteJohoSinseiSyubetu();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoSinseiSyubetu(TextBox YokaigoNinteJohoSinseiSyubetu) {
        this.getYokaigoNinteJoho().setYokaigoNinteJohoSinseiSyubetu(YokaigoNinteJohoSinseiSyubetu);
    }

    @JsonIgnore
    public TextBox getYokaigoNinteJohoSinseiKubunT() {
        return this.getYokaigoNinteJoho().getYokaigoNinteJohoSinseiKubunT();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoSinseiKubunT(TextBox YokaigoNinteJohoSinseiKubunT) {
        this.getYokaigoNinteJoho().setYokaigoNinteJohoSinseiKubunT(YokaigoNinteJohoSinseiKubunT);
    }

    @JsonIgnore
    public CheckBoxList getYokaigoNinteJohoKyuSoti() {
        return this.getYokaigoNinteJoho().getYokaigoNinteJohoKyuSoti();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoKyuSoti(CheckBoxList YokaigoNinteJohoKyuSoti) {
        this.getYokaigoNinteJoho().setYokaigoNinteJohoKyuSoti(YokaigoNinteJohoKyuSoti);
    }

    @JsonIgnore
    public TextBoxDate getNinteiYukoEndYYMMDD() {
        return this.getYokaigoNinteJoho().getNinteiYukoEndYYMMDD();
    }

    @JsonIgnore
    public void  setNinteiYukoEndYYMMDD(TextBoxDate NinteiYukoEndYYMMDD) {
        this.getYokaigoNinteJoho().setNinteiYukoEndYYMMDD(NinteiYukoEndYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getYokaigoNinteJohoNinteiYYMMDD() {
        return this.getYokaigoNinteJoho().getYokaigoNinteJohoNinteiYYMMDD();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoNinteiYYMMDD(TextBoxDate YokaigoNinteJohoNinteiYYMMDD) {
        this.getYokaigoNinteJoho().setYokaigoNinteJohoNinteiYYMMDD(YokaigoNinteJohoNinteiYYMMDD);
    }

    @JsonIgnore
    public TextBox getJyotai() {
        return this.getYokaigoNinteJoho().getJyotai();
    }

    @JsonIgnore
    public void  setJyotai(TextBox Jyotai) {
        this.getYokaigoNinteJoho().setJyotai(Jyotai);
    }

    @JsonIgnore
    public TextBox getYokaigoNinteJohoSinseiKubunHourei() {
        return this.getYokaigoNinteJoho().getYokaigoNinteJohoSinseiKubunHourei();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoSinseiKubunHourei(TextBox YokaigoNinteJohoSinseiKubunHourei) {
        this.getYokaigoNinteJoho().setYokaigoNinteJohoSinseiKubunHourei(YokaigoNinteJohoSinseiKubunHourei);
    }

    @JsonIgnore
    public TextBoxDate getNinteSinseJohoSinseiYYMMDD() {
        return this.getNinteSinseJoho().getNinteSinseJohoSinseiYYMMDD();
    }

    @JsonIgnore
    public void  setNinteSinseJohoSinseiYYMMDD(TextBoxDate NinteSinseJohoSinseiYYMMDD) {
        this.getNinteSinseJoho().setNinteSinseJohoSinseiYYMMDD(NinteSinseJohoSinseiYYMMDD);
    }

    @JsonIgnore
    public TextBox getNinteSinseJohoSinseiSyubetu() {
        return this.getNinteSinseJoho().getNinteSinseJohoSinseiSyubetu();
    }

    @JsonIgnore
    public void  setNinteSinseJohoSinseiSyubetu(TextBox NinteSinseJohoSinseiSyubetu) {
        this.getNinteSinseJoho().setNinteSinseJohoSinseiSyubetu(NinteSinseJohoSinseiSyubetu);
    }

    @JsonIgnore
    public TextBox getNinteSinseJohoSinseiKubunT() {
        return this.getNinteSinseJoho().getNinteSinseJohoSinseiKubunT();
    }

    @JsonIgnore
    public void  setNinteSinseJohoSinseiKubunT(TextBox NinteSinseJohoSinseiKubunT) {
        this.getNinteSinseJoho().setNinteSinseJohoSinseiKubunT(NinteSinseJohoSinseiKubunT);
    }

    @JsonIgnore
    public Label getHutanGendoGakuNintei() {
        return this.getKakushuGenmenJoho().getHutanGendoGakuNintei();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNintei(Label HutanGendoGakuNintei) {
        this.getKakushuGenmenJoho().setHutanGendoGakuNintei(HutanGendoGakuNintei);
    }

    @JsonIgnore
    public TextBox getHutanGendoGakuNinteiKeteKubun() {
        return this.getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubun();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubun(TextBox HutanGendoGakuNinteiKeteKubun) {
        this.getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubun(HutanGendoGakuNinteiKeteKubun);
    }

    @JsonIgnore
    public TextBox getHutanGendoGakuNinteiKeteKubunKyusoti() {
        return this.getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunKyusoti();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubunKyusoti(TextBox HutanGendoGakuNinteiKeteKubunKyusoti) {
        this.getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubunKyusoti(HutanGendoGakuNinteiKeteKubunKyusoti);
    }

    @JsonIgnore
    public TextBox getHutanGendoGakuNinteiKeteKubunHutanDankai() {
        return this.getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunHutanDankai();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubunHutanDankai(TextBox HutanGendoGakuNinteiKeteKubunHutanDankai) {
        this.getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubunHutanDankai(HutanGendoGakuNinteiKeteKubunHutanDankai);
    }

    @JsonIgnore
    public TextBoxDate getHutanGendoGakuNinteiKeteKubunTekiyoYYMMDD() {
        return this.getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubunTekiyoYYMMDD(TextBoxDate HutanGendoGakuNinteiKeteKubunTekiyoYYMMDD) {
        this.getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubunTekiyoYYMMDD(HutanGendoGakuNinteiKeteKubunTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getHutanGendoGakuNinteiKeteKubunYukouKigen() {
        return this.getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunYukouKigen();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubunYukouKigen(TextBoxDate HutanGendoGakuNinteiKeteKubunYukouKigen) {
        this.getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubunYukouKigen(HutanGendoGakuNinteiKeteKubunYukouKigen);
    }

    @JsonIgnore
    public Label getRiyosyaHutanDankai() {
        return this.getKakushuGenmenJoho().getRiyosyaHutanDankai();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankai(Label RiyosyaHutanDankai) {
        this.getKakushuGenmenJoho().setRiyosyaHutanDankai(RiyosyaHutanDankai);
    }

    @JsonIgnore
    public TextBox getRiyosyaHutanDankaiKeteKubun() {
        return this.getKakushuGenmenJoho().getRiyosyaHutanDankaiKeteKubun();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankaiKeteKubun(TextBox RiyosyaHutanDankaiKeteKubun) {
        this.getKakushuGenmenJoho().setRiyosyaHutanDankaiKeteKubun(RiyosyaHutanDankaiKeteKubun);
    }

    @JsonIgnore
    public TextBox getRiyosyaHutanDankaiKyuhuRitu() {
        return this.getKakushuGenmenJoho().getRiyosyaHutanDankaiKyuhuRitu();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankaiKyuhuRitu(TextBox RiyosyaHutanDankaiKyuhuRitu) {
        this.getKakushuGenmenJoho().setRiyosyaHutanDankaiKyuhuRitu(RiyosyaHutanDankaiKyuhuRitu);
    }

    @JsonIgnore
    public TextBoxDate getRiyosyaHutanDankaiTekiyoYYMMDD() {
        return this.getKakushuGenmenJoho().getRiyosyaHutanDankaiTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankaiTekiyoYYMMDD(TextBoxDate RiyosyaHutanDankaiTekiyoYYMMDD) {
        this.getKakushuGenmenJoho().setRiyosyaHutanDankaiTekiyoYYMMDD(RiyosyaHutanDankaiTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getRiyosyaHutanDankaiYukouKigen() {
        return this.getKakushuGenmenJoho().getRiyosyaHutanDankaiYukouKigen();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankaiYukouKigen(TextBoxDate RiyosyaHutanDankaiYukouKigen) {
        this.getKakushuGenmenJoho().setRiyosyaHutanDankaiYukouKigen(RiyosyaHutanDankaiYukouKigen);
    }

    @JsonIgnore
    public Label getHomonKaigRiyosyaHutan() {
        return this.getKakushuGenmenJoho().getHomonKaigRiyosyaHutan();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutan(Label HomonKaigRiyosyaHutan) {
        this.getKakushuGenmenJoho().setHomonKaigRiyosyaHutan(HomonKaigRiyosyaHutan);
    }

    @JsonIgnore
    public TextBox getHomonKaigRiyosyaHutanKeteKubun() {
        return this.getKakushuGenmenJoho().getHomonKaigRiyosyaHutanKeteKubun();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanKeteKubun(TextBox HomonKaigRiyosyaHutanKeteKubun) {
        this.getKakushuGenmenJoho().setHomonKaigRiyosyaHutanKeteKubun(HomonKaigRiyosyaHutanKeteKubun);
    }

    @JsonIgnore
    public TextBox getHomonKaigRiyosyaHutanSyurui() {
        return this.getKakushuGenmenJoho().getHomonKaigRiyosyaHutanSyurui();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanSyurui(TextBox HomonKaigRiyosyaHutanSyurui) {
        this.getKakushuGenmenJoho().setHomonKaigRiyosyaHutanSyurui(HomonKaigRiyosyaHutanSyurui);
    }

    @JsonIgnore
    public TextBox getHomonKaigRiyosyaHutanKyuhuRitu() {
        return this.getKakushuGenmenJoho().getHomonKaigRiyosyaHutanKyuhuRitu();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanKyuhuRitu(TextBox HomonKaigRiyosyaHutanKyuhuRitu) {
        this.getKakushuGenmenJoho().setHomonKaigRiyosyaHutanKyuhuRitu(HomonKaigRiyosyaHutanKyuhuRitu);
    }

    @JsonIgnore
    public TextBoxDate getHomonKaigRiyosyaHutanTekiyoYYMMDD() {
        return this.getKakushuGenmenJoho().getHomonKaigRiyosyaHutanTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanTekiyoYYMMDD(TextBoxDate HomonKaigRiyosyaHutanTekiyoYYMMDD) {
        this.getKakushuGenmenJoho().setHomonKaigRiyosyaHutanTekiyoYYMMDD(HomonKaigRiyosyaHutanTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getHomonKaigRiyosyaHutanYukouKigen() {
        return this.getKakushuGenmenJoho().getHomonKaigRiyosyaHutanYukouKigen();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanYukouKigen(TextBoxDate HomonKaigRiyosyaHutanYukouKigen) {
        this.getKakushuGenmenJoho().setHomonKaigRiyosyaHutanYukouKigen(HomonKaigRiyosyaHutanYukouKigen);
    }

    @JsonIgnore
    public Label getSyakaiHukushiHozinKeigen() {
        return this.getKakushuGenmenJoho().getSyakaiHukushiHozinKeigen();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigen(Label SyakaiHukushiHozinKeigen) {
        this.getKakushuGenmenJoho().setSyakaiHukushiHozinKeigen(SyakaiHukushiHozinKeigen);
    }

    @JsonIgnore
    public TextBox getSyakaiHukushiHozinKeigenKeteKubun() {
        return this.getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenKeteKubun();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigenKeteKubun(TextBox SyakaiHukushiHozinKeigenKeteKubun) {
        this.getKakushuGenmenJoho().setSyakaiHukushiHozinKeigenKeteKubun(SyakaiHukushiHozinKeigenKeteKubun);
    }

    @JsonIgnore
    public TextBox getSyakaiHukushiHozinKeigenKeigenRitu() {
        return this.getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenKeigenRitu();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigenKeigenRitu(TextBox SyakaiHukushiHozinKeigenKeigenRitu) {
        this.getKakushuGenmenJoho().setSyakaiHukushiHozinKeigenKeigenRitu(SyakaiHukushiHozinKeigenKeigenRitu);
    }

    @JsonIgnore
    public TextBoxDate getSyakaiHukushiHozinKeigenTekiyoYYMMDD() {
        return this.getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigenTekiyoYYMMDD(TextBoxDate SyakaiHukushiHozinKeigenTekiyoYYMMDD) {
        this.getKakushuGenmenJoho().setSyakaiHukushiHozinKeigenTekiyoYYMMDD(SyakaiHukushiHozinKeigenTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getSyakaiHukushiHozinKeigenYukouKigen() {
        return this.getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenYukouKigen();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigenYukouKigen(TextBoxDate SyakaiHukushiHozinKeigenYukouKigen) {
        this.getKakushuGenmenJoho().setSyakaiHukushiHozinKeigenYukouKigen(SyakaiHukushiHozinKeigenYukouKigen);
    }

    @JsonIgnore
    public Label getTokubetuTikiKasanGenmen() {
        return this.getKakushuGenmenJoho().getTokubetuTikiKasanGenmen();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmen(Label TokubetuTikiKasanGenmen) {
        this.getKakushuGenmenJoho().setTokubetuTikiKasanGenmen(TokubetuTikiKasanGenmen);
    }

    @JsonIgnore
    public TextBox getTokubetuTikiKasanGenmenKeteKubun() {
        return this.getKakushuGenmenJoho().getTokubetuTikiKasanGenmenKeteKubun();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmenKeteKubun(TextBox TokubetuTikiKasanGenmenKeteKubun) {
        this.getKakushuGenmenJoho().setTokubetuTikiKasanGenmenKeteKubun(TokubetuTikiKasanGenmenKeteKubun);
    }

    @JsonIgnore
    public TextBox getTokubetuTikiKasanGenmenKeigenRitu() {
        return this.getKakushuGenmenJoho().getTokubetuTikiKasanGenmenKeigenRitu();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmenKeigenRitu(TextBox TokubetuTikiKasanGenmenKeigenRitu) {
        this.getKakushuGenmenJoho().setTokubetuTikiKasanGenmenKeigenRitu(TokubetuTikiKasanGenmenKeigenRitu);
    }

    @JsonIgnore
    public TextBoxDate getTokubetuTikiKasanGenmenTekiyoYYMMDD() {
        return this.getKakushuGenmenJoho().getTokubetuTikiKasanGenmenTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmenTekiyoYYMMDD(TextBoxDate TokubetuTikiKasanGenmenTekiyoYYMMDD) {
        this.getKakushuGenmenJoho().setTokubetuTikiKasanGenmenTekiyoYYMMDD(TokubetuTikiKasanGenmenTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getTokubetuTikiKasanGenmenYukouKigen() {
        return this.getKakushuGenmenJoho().getTokubetuTikiKasanGenmenYukouKigen();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmenYukouKigen(TextBoxDate TokubetuTikiKasanGenmenYukouKigen) {
        this.getKakushuGenmenJoho().setTokubetuTikiKasanGenmenYukouKigen(TokubetuTikiKasanGenmenYukouKigen);
    }

    @JsonIgnore
    public Label getHyojunHutanGenmen() {
        return this.getKakushuGenmenJoho().getHyojunHutanGenmen();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmen(Label HyojunHutanGenmen) {
        this.getKakushuGenmenJoho().setHyojunHutanGenmen(HyojunHutanGenmen);
    }

    @JsonIgnore
    public TextBox getHyojunHutanGenmenKeteKubun() {
        return this.getKakushuGenmenJoho().getHyojunHutanGenmenKeteKubun();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmenKeteKubun(TextBox HyojunHutanGenmenKeteKubun) {
        this.getKakushuGenmenJoho().setHyojunHutanGenmenKeteKubun(HyojunHutanGenmenKeteKubun);
    }

    @JsonIgnore
    public TextBox getHyojunHutanGenmenHutanGaku() {
        return this.getKakushuGenmenJoho().getHyojunHutanGenmenHutanGaku();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmenHutanGaku(TextBox HyojunHutanGenmenHutanGaku) {
        this.getKakushuGenmenJoho().setHyojunHutanGenmenHutanGaku(HyojunHutanGenmenHutanGaku);
    }

    @JsonIgnore
    public TextBoxDate getHyojunHutanGenmenTekiyoYYMMDD() {
        return this.getKakushuGenmenJoho().getHyojunHutanGenmenTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmenTekiyoYYMMDD(TextBoxDate HyojunHutanGenmenTekiyoYYMMDD) {
        this.getKakushuGenmenJoho().setHyojunHutanGenmenTekiyoYYMMDD(HyojunHutanGenmenTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getHyojunHutanGenmenYukouKigen() {
        return this.getKakushuGenmenJoho().getHyojunHutanGenmenYukouKigen();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmenYukouKigen(TextBoxDate HyojunHutanGenmenYukouKigen) {
        this.getKakushuGenmenJoho().setHyojunHutanGenmenYukouKigen(HyojunHutanGenmenYukouKigen);
    }

    @JsonIgnore
    public Label getShiharaiHoho() {
        return this.getKyuhuSeigenJoho().getShiharaiHoho();
    }

    @JsonIgnore
    public void  setShiharaiHoho(Label ShiharaiHoho) {
        this.getKyuhuSeigenJoho().setShiharaiHoho(ShiharaiHoho);
    }

    @JsonIgnore
    public TextBox getShiharaiHohoTorokuKubun() {
        return this.getKyuhuSeigenJoho().getShiharaiHohoTorokuKubun();
    }

    @JsonIgnore
    public void  setShiharaiHohoTorokuKubun(TextBox ShiharaiHohoTorokuKubun) {
        this.getKyuhuSeigenJoho().setShiharaiHohoTorokuKubun(ShiharaiHohoTorokuKubun);
    }

    @JsonIgnore
    public TextBoxDate getShiharaiHohoFromYYMMDD() {
        return this.getKyuhuSeigenJoho().getShiharaiHohoFromYYMMDD();
    }

    @JsonIgnore
    public void  setShiharaiHohoFromYYMMDD(TextBoxDate ShiharaiHohoFromYYMMDD) {
        this.getKyuhuSeigenJoho().setShiharaiHohoFromYYMMDD(ShiharaiHohoFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getShiharaiHohoEndYYMMDD() {
        return this.getKyuhuSeigenJoho().getShiharaiHohoEndYYMMDD();
    }

    @JsonIgnore
    public void  setShiharaiHohoEndYYMMDD(TextBoxDate ShiharaiHohoEndYYMMDD) {
        this.getKyuhuSeigenJoho().setShiharaiHohoEndYYMMDD(ShiharaiHohoEndYYMMDD);
    }

    @JsonIgnore
    public Label getKyuhugakuGengaku() {
        return this.getKyuhuSeigenJoho().getKyuhugakuGengaku();
    }

    @JsonIgnore
    public void  setKyuhugakuGengaku(Label KyuhugakuGengaku) {
        this.getKyuhuSeigenJoho().setKyuhugakuGengaku(KyuhugakuGengaku);
    }

    @JsonIgnore
    public TextBox getKyuhugakuGengakuTorokuKubun() {
        return this.getKyuhuSeigenJoho().getKyuhugakuGengakuTorokuKubun();
    }

    @JsonIgnore
    public void  setKyuhugakuGengakuTorokuKubun(TextBox KyuhugakuGengakuTorokuKubun) {
        this.getKyuhuSeigenJoho().setKyuhugakuGengakuTorokuKubun(KyuhugakuGengakuTorokuKubun);
    }

    @JsonIgnore
    public TextBoxDate getKyuhugakuGengakuFromYYMMDD() {
        return this.getKyuhuSeigenJoho().getKyuhugakuGengakuFromYYMMDD();
    }

    @JsonIgnore
    public void  setKyuhugakuGengakuFromYYMMDD(TextBoxDate KyuhugakuGengakuFromYYMMDD) {
        this.getKyuhuSeigenJoho().setKyuhugakuGengakuFromYYMMDD(KyuhugakuGengakuFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getKyuhugakuGengakuEndYYMMDD() {
        return this.getKyuhuSeigenJoho().getKyuhugakuGengakuEndYYMMDD();
    }

    @JsonIgnore
    public void  setKyuhugakuGengakuEndYYMMDD(TextBoxDate KyuhugakuGengakuEndYYMMDD) {
        this.getKyuhuSeigenJoho().setKyuhugakuGengakuEndYYMMDD(KyuhugakuGengakuEndYYMMDD);
    }

    @JsonIgnore
    public Label getKeikaSoti() {
        return this.getSogoJigyoTaisyosyaJoho().getKeikaSoti();
    }

    @JsonIgnore
    public void  setKeikaSoti(Label KeikaSoti) {
        this.getSogoJigyoTaisyosyaJoho().setKeikaSoti(KeikaSoti);
    }

    @JsonIgnore
    public TextBoxDate getKeikaSotiTekiyoFromYYMMDD() {
        return this.getSogoJigyoTaisyosyaJoho().getKeikaSotiTekiyoFromYYMMDD();
    }

    @JsonIgnore
    public void  setKeikaSotiTekiyoFromYYMMDD(TextBoxDate KeikaSotiTekiyoFromYYMMDD) {
        this.getSogoJigyoTaisyosyaJoho().setKeikaSotiTekiyoFromYYMMDD(KeikaSotiTekiyoFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getKeikaSotiTekiyoEndYYMMDD() {
        return this.getSogoJigyoTaisyosyaJoho().getKeikaSotiTekiyoEndYYMMDD();
    }

    @JsonIgnore
    public void  setKeikaSotiTekiyoEndYYMMDD(TextBoxDate KeikaSotiTekiyoEndYYMMDD) {
        this.getSogoJigyoTaisyosyaJoho().setKeikaSotiTekiyoEndYYMMDD(KeikaSotiTekiyoEndYYMMDD);
    }

    @JsonIgnore
    public Label getSogoJigyo() {
        return this.getSogoJigyoTaisyosyaJoho().getSogoJigyo();
    }

    @JsonIgnore
    public void  setSogoJigyo(Label SogoJigyo) {
        this.getSogoJigyoTaisyosyaJoho().setSogoJigyo(SogoJigyo);
    }

    @JsonIgnore
    public TextBoxDate getSogoJigyoTekiyoFromYYMMDD() {
        return this.getSogoJigyoTaisyosyaJoho().getSogoJigyoTekiyoFromYYMMDD();
    }

    @JsonIgnore
    public void  setSogoJigyoTekiyoFromYYMMDD(TextBoxDate SogoJigyoTekiyoFromYYMMDD) {
        this.getSogoJigyoTaisyosyaJoho().setSogoJigyoTekiyoFromYYMMDD(SogoJigyoTekiyoFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getSogoJigyoTekiyoEndYYMMDD() {
        return this.getSogoJigyoTaisyosyaJoho().getSogoJigyoTekiyoEndYYMMDD();
    }

    @JsonIgnore
    public void  setSogoJigyoTekiyoEndYYMMDD(TextBoxDate SogoJigyoTekiyoEndYYMMDD) {
        this.getSogoJigyoTaisyosyaJoho().setSogoJigyoTekiyoEndYYMMDD(SogoJigyoTekiyoEndYYMMDD);
    }

    // </editor-fold>
}
