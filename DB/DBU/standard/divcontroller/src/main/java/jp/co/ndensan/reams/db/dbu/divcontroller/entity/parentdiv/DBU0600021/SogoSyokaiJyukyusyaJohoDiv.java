package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SogoSyokaiJyukyusyaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoSyokaiJyukyusyaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HeadPanel")
    private HeadPanelDiv HeadPanel;
    @JsonProperty("JyukyusyaJoho")
    private JyukyusyaJohoDiv JyukyusyaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHeadPanel
     * @return HeadPanel
     */
    @JsonProperty("HeadPanel")
    public HeadPanelDiv getHeadPanel() {
        return HeadPanel;
    }

    /*
     * setHeadPanel
     * @param HeadPanel HeadPanel
     */
    @JsonProperty("HeadPanel")
    public void setHeadPanel(HeadPanelDiv HeadPanel) {
        this.HeadPanel = HeadPanel;
    }

    /*
     * getJyukyusyaJoho
     * @return JyukyusyaJoho
     */
    @JsonProperty("JyukyusyaJoho")
    public JyukyusyaJohoDiv getJyukyusyaJoho() {
        return JyukyusyaJoho;
    }

    /*
     * setJyukyusyaJoho
     * @param JyukyusyaJoho JyukyusyaJoho
     */
    @JsonProperty("JyukyusyaJoho")
    public void setJyukyusyaJoho(JyukyusyaJohoDiv JyukyusyaJoho) {
        this.JyukyusyaJoho = JyukyusyaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getKaigoShikakuKihonChildDiv() {
        return this.getHeadPanel().getKaigoShikakuKihonChildDiv();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getKaigoAtenaInfoChildDiv() {
        return this.getHeadPanel().getKaigoAtenaInfoChildDiv();
    }

    @JsonIgnore
    public SikakuJohoDiv getSikakuJoho() {
        return this.getJyukyusyaJoho().getSikakuJoho();
    }

    @JsonIgnore
    public void  setSikakuJoho(SikakuJohoDiv SikakuJoho) {
        this.getJyukyusyaJoho().setSikakuJoho(SikakuJoho);
    }

    @JsonIgnore
    public Button getSikakuJohoButton() {
        return this.getJyukyusyaJoho().getSikakuJoho().getSikakuJohoButton();
    }

    @JsonIgnore
    public void  setSikakuJohoButton(Button SikakuJohoButton) {
        this.getJyukyusyaJoho().getSikakuJoho().setSikakuJohoButton(SikakuJohoButton);
    }

    @JsonIgnore
    public Button getJyukyusyaJohoButton() {
        return this.getJyukyusyaJoho().getSikakuJoho().getJyukyusyaJohoButton();
    }

    @JsonIgnore
    public void  setJyukyusyaJohoButton(Button JyukyusyaJohoButton) {
        this.getJyukyusyaJoho().getSikakuJoho().setJyukyusyaJohoButton(JyukyusyaJohoButton);
    }

    @JsonIgnore
    public Button getKyuhuJohoButton() {
        return this.getJyukyusyaJoho().getSikakuJoho().getKyuhuJohoButton();
    }

    @JsonIgnore
    public void  setKyuhuJohoButton(Button KyuhuJohoButton) {
        this.getJyukyusyaJoho().getSikakuJoho().setKyuhuJohoButton(KyuhuJohoButton);
    }

    @JsonIgnore
    public Button getHukaJohoButton() {
        return this.getJyukyusyaJoho().getSikakuJoho().getHukaJohoButton();
    }

    @JsonIgnore
    public void  setHukaJohoButton(Button HukaJohoButton) {
        this.getJyukyusyaJoho().getSikakuJoho().setHukaJohoButton(HukaJohoButton);
    }

    @JsonIgnore
    public Button getJyuminJohoButton() {
        return this.getJyukyusyaJoho().getSikakuJoho().getJyuminJohoButton();
    }

    @JsonIgnore
    public void  setJyuminJohoButton(Button JyuminJohoButton) {
        this.getJyukyusyaJoho().getSikakuJoho().setJyuminJohoButton(JyuminJohoButton);
    }

    @JsonIgnore
    public Button getJyukyuJohoButton() {
        return this.getJyukyusyaJoho().getSikakuJoho().getJyukyuJohoButton();
    }

    @JsonIgnore
    public void  setJyukyuJohoButton(Button JyukyuJohoButton) {
        this.getJyukyusyaJoho().getSikakuJoho().setJyukyuJohoButton(JyukyuJohoButton);
    }

    @JsonIgnore
    public YokaigoNinteJohoDiv getYokaigoNinteJoho() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho();
    }

    @JsonIgnore
    public void  setYokaigoNinteJoho(YokaigoNinteJohoDiv YokaigoNinteJoho) {
        this.getJyukyusyaJoho().setYokaigoNinteJoho(YokaigoNinteJoho);
    }

    @JsonIgnore
    public TextBox getYokaigoDo() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoDo();
    }

    @JsonIgnore
    public void  setYokaigoDo(TextBox YokaigoDo) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setYokaigoDo(YokaigoDo);
    }

    @JsonIgnore
    public TextBoxDate getNinteiYukoFromYYMMDD() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getNinteiYukoFromYYMMDD();
    }

    @JsonIgnore
    public void  setNinteiYukoFromYYMMDD(TextBoxDate NinteiYukoFromYYMMDD) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setNinteiYukoFromYYMMDD(NinteiYukoFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getYokaigoNinteJohoSinseiYYMMDD() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoSinseiYYMMDD();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoSinseiYYMMDD(TextBoxDate YokaigoNinteJohoSinseiYYMMDD) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setYokaigoNinteJohoSinseiYYMMDD(YokaigoNinteJohoSinseiYYMMDD);
    }

    @JsonIgnore
    public TextBox getYokaigoNinteJohoSinseiSyubetu() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoSinseiSyubetu();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoSinseiSyubetu(TextBox YokaigoNinteJohoSinseiSyubetu) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setYokaigoNinteJohoSinseiSyubetu(YokaigoNinteJohoSinseiSyubetu);
    }

    @JsonIgnore
    public TextBox getYokaigoNinteJohoSinseiKubunT() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoSinseiKubunT();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoSinseiKubunT(TextBox YokaigoNinteJohoSinseiKubunT) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setYokaigoNinteJohoSinseiKubunT(YokaigoNinteJohoSinseiKubunT);
    }

    @JsonIgnore
    public CheckBoxList getYokaigoNinteJohoKyuSoti() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoKyuSoti();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoKyuSoti(CheckBoxList YokaigoNinteJohoKyuSoti) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setYokaigoNinteJohoKyuSoti(YokaigoNinteJohoKyuSoti);
    }

    @JsonIgnore
    public TextBoxDate getNinteiYukoEndYYMMDD() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getNinteiYukoEndYYMMDD();
    }

    @JsonIgnore
    public void  setNinteiYukoEndYYMMDD(TextBoxDate NinteiYukoEndYYMMDD) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setNinteiYukoEndYYMMDD(NinteiYukoEndYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getYokaigoNinteJohoNinteiYYMMDD() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoNinteiYYMMDD();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoNinteiYYMMDD(TextBoxDate YokaigoNinteJohoNinteiYYMMDD) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setYokaigoNinteJohoNinteiYYMMDD(YokaigoNinteJohoNinteiYYMMDD);
    }

    @JsonIgnore
    public TextBox getJyotai() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getJyotai();
    }

    @JsonIgnore
    public void  setJyotai(TextBox Jyotai) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setJyotai(Jyotai);
    }

    @JsonIgnore
    public TextBox getYokaigoNinteJohoSinseiKubunHourei() {
        return this.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoSinseiKubunHourei();
    }

    @JsonIgnore
    public void  setYokaigoNinteJohoSinseiKubunHourei(TextBox YokaigoNinteJohoSinseiKubunHourei) {
        this.getJyukyusyaJoho().getYokaigoNinteJoho().setYokaigoNinteJohoSinseiKubunHourei(YokaigoNinteJohoSinseiKubunHourei);
    }

    @JsonIgnore
    public NinteSinseJohoDiv getNinteSinseJoho() {
        return this.getJyukyusyaJoho().getNinteSinseJoho();
    }

    @JsonIgnore
    public void  setNinteSinseJoho(NinteSinseJohoDiv NinteSinseJoho) {
        this.getJyukyusyaJoho().setNinteSinseJoho(NinteSinseJoho);
    }

    @JsonIgnore
    public TextBoxDate getNinteSinseJohoSinseiYYMMDD() {
        return this.getJyukyusyaJoho().getNinteSinseJoho().getNinteSinseJohoSinseiYYMMDD();
    }

    @JsonIgnore
    public void  setNinteSinseJohoSinseiYYMMDD(TextBoxDate NinteSinseJohoSinseiYYMMDD) {
        this.getJyukyusyaJoho().getNinteSinseJoho().setNinteSinseJohoSinseiYYMMDD(NinteSinseJohoSinseiYYMMDD);
    }

    @JsonIgnore
    public TextBox getNinteSinseJohoSinseiSyubetu() {
        return this.getJyukyusyaJoho().getNinteSinseJoho().getNinteSinseJohoSinseiSyubetu();
    }

    @JsonIgnore
    public void  setNinteSinseJohoSinseiSyubetu(TextBox NinteSinseJohoSinseiSyubetu) {
        this.getJyukyusyaJoho().getNinteSinseJoho().setNinteSinseJohoSinseiSyubetu(NinteSinseJohoSinseiSyubetu);
    }

    @JsonIgnore
    public TextBox getNinteSinseJohoSinseiKubunT() {
        return this.getJyukyusyaJoho().getNinteSinseJoho().getNinteSinseJohoSinseiKubunT();
    }

    @JsonIgnore
    public void  setNinteSinseJohoSinseiKubunT(TextBox NinteSinseJohoSinseiKubunT) {
        this.getJyukyusyaJoho().getNinteSinseJoho().setNinteSinseJohoSinseiKubunT(NinteSinseJohoSinseiKubunT);
    }

    @JsonIgnore
    public KakushuGenmenJohoDiv getKakushuGenmenJoho() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho();
    }

    @JsonIgnore
    public void  setKakushuGenmenJoho(KakushuGenmenJohoDiv KakushuGenmenJoho) {
        this.getJyukyusyaJoho().setKakushuGenmenJoho(KakushuGenmenJoho);
    }

    @JsonIgnore
    public Label getHutanGendoGakuNintei() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNintei();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNintei(Label HutanGendoGakuNintei) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHutanGendoGakuNintei(HutanGendoGakuNintei);
    }

    @JsonIgnore
    public TextBox getHutanGendoGakuNinteiKeteKubun() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubun();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubun(TextBox HutanGendoGakuNinteiKeteKubun) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubun(HutanGendoGakuNinteiKeteKubun);
    }

    @JsonIgnore
    public TextBox getHutanGendoGakuNinteiKeteKubunKyusoti() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunKyusoti();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubunKyusoti(TextBox HutanGendoGakuNinteiKeteKubunKyusoti) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubunKyusoti(HutanGendoGakuNinteiKeteKubunKyusoti);
    }

    @JsonIgnore
    public TextBox getHutanGendoGakuNinteiKeteKubunHutanDankai() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunHutanDankai();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubunHutanDankai(TextBox HutanGendoGakuNinteiKeteKubunHutanDankai) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubunHutanDankai(HutanGendoGakuNinteiKeteKubunHutanDankai);
    }

    @JsonIgnore
    public TextBoxDate getHutanGendoGakuNinteiKeteKubunTekiyoYYMMDD() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubunTekiyoYYMMDD(TextBoxDate HutanGendoGakuNinteiKeteKubunTekiyoYYMMDD) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubunTekiyoYYMMDD(HutanGendoGakuNinteiKeteKubunTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getHutanGendoGakuNinteiKeteKubunYukouKigen() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunYukouKigen();
    }

    @JsonIgnore
    public void  setHutanGendoGakuNinteiKeteKubunYukouKigen(TextBoxDate HutanGendoGakuNinteiKeteKubunYukouKigen) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHutanGendoGakuNinteiKeteKubunYukouKigen(HutanGendoGakuNinteiKeteKubunYukouKigen);
    }

    @JsonIgnore
    public Label getRiyosyaHutanDankai() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getRiyosyaHutanDankai();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankai(Label RiyosyaHutanDankai) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setRiyosyaHutanDankai(RiyosyaHutanDankai);
    }

    @JsonIgnore
    public TextBox getRiyosyaHutanDankaiKeteKubun() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getRiyosyaHutanDankaiKeteKubun();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankaiKeteKubun(TextBox RiyosyaHutanDankaiKeteKubun) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setRiyosyaHutanDankaiKeteKubun(RiyosyaHutanDankaiKeteKubun);
    }

    @JsonIgnore
    public TextBox getRiyosyaHutanDankaiKyuhuRitu() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getRiyosyaHutanDankaiKyuhuRitu();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankaiKyuhuRitu(TextBox RiyosyaHutanDankaiKyuhuRitu) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setRiyosyaHutanDankaiKyuhuRitu(RiyosyaHutanDankaiKyuhuRitu);
    }

    @JsonIgnore
    public TextBoxDate getRiyosyaHutanDankaiTekiyoYYMMDD() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getRiyosyaHutanDankaiTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankaiTekiyoYYMMDD(TextBoxDate RiyosyaHutanDankaiTekiyoYYMMDD) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setRiyosyaHutanDankaiTekiyoYYMMDD(RiyosyaHutanDankaiTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getRiyosyaHutanDankaiYukouKigen() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getRiyosyaHutanDankaiYukouKigen();
    }

    @JsonIgnore
    public void  setRiyosyaHutanDankaiYukouKigen(TextBoxDate RiyosyaHutanDankaiYukouKigen) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setRiyosyaHutanDankaiYukouKigen(RiyosyaHutanDankaiYukouKigen);
    }

    @JsonIgnore
    public Label getHomonKaigRiyosyaHutan() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutan();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutan(Label HomonKaigRiyosyaHutan) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHomonKaigRiyosyaHutan(HomonKaigRiyosyaHutan);
    }

    @JsonIgnore
    public TextBox getHomonKaigRiyosyaHutanKeteKubun() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanKeteKubun();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanKeteKubun(TextBox HomonKaigRiyosyaHutanKeteKubun) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHomonKaigRiyosyaHutanKeteKubun(HomonKaigRiyosyaHutanKeteKubun);
    }

    @JsonIgnore
    public TextBox getHomonKaigRiyosyaHutanSyurui() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanSyurui();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanSyurui(TextBox HomonKaigRiyosyaHutanSyurui) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHomonKaigRiyosyaHutanSyurui(HomonKaigRiyosyaHutanSyurui);
    }

    @JsonIgnore
    public TextBox getHomonKaigRiyosyaHutanKyuhuRitu() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanKyuhuRitu();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanKyuhuRitu(TextBox HomonKaigRiyosyaHutanKyuhuRitu) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHomonKaigRiyosyaHutanKyuhuRitu(HomonKaigRiyosyaHutanKyuhuRitu);
    }

    @JsonIgnore
    public TextBoxDate getHomonKaigRiyosyaHutanTekiyoYYMMDD() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanTekiyoYYMMDD(TextBoxDate HomonKaigRiyosyaHutanTekiyoYYMMDD) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHomonKaigRiyosyaHutanTekiyoYYMMDD(HomonKaigRiyosyaHutanTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getHomonKaigRiyosyaHutanYukouKigen() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanYukouKigen();
    }

    @JsonIgnore
    public void  setHomonKaigRiyosyaHutanYukouKigen(TextBoxDate HomonKaigRiyosyaHutanYukouKigen) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHomonKaigRiyosyaHutanYukouKigen(HomonKaigRiyosyaHutanYukouKigen);
    }

    @JsonIgnore
    public Label getSyakaiHukushiHozinKeigen() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getSyakaiHukushiHozinKeigen();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigen(Label SyakaiHukushiHozinKeigen) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setSyakaiHukushiHozinKeigen(SyakaiHukushiHozinKeigen);
    }

    @JsonIgnore
    public TextBox getSyakaiHukushiHozinKeigenKeteKubun() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenKeteKubun();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigenKeteKubun(TextBox SyakaiHukushiHozinKeigenKeteKubun) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setSyakaiHukushiHozinKeigenKeteKubun(SyakaiHukushiHozinKeigenKeteKubun);
    }

    @JsonIgnore
    public TextBox getSyakaiHukushiHozinKeigenKeigenRitu() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenKeigenRitu();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigenKeigenRitu(TextBox SyakaiHukushiHozinKeigenKeigenRitu) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setSyakaiHukushiHozinKeigenKeigenRitu(SyakaiHukushiHozinKeigenKeigenRitu);
    }

    @JsonIgnore
    public TextBoxDate getSyakaiHukushiHozinKeigenTekiyoYYMMDD() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigenTekiyoYYMMDD(TextBoxDate SyakaiHukushiHozinKeigenTekiyoYYMMDD) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setSyakaiHukushiHozinKeigenTekiyoYYMMDD(SyakaiHukushiHozinKeigenTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getSyakaiHukushiHozinKeigenYukouKigen() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenYukouKigen();
    }

    @JsonIgnore
    public void  setSyakaiHukushiHozinKeigenYukouKigen(TextBoxDate SyakaiHukushiHozinKeigenYukouKigen) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setSyakaiHukushiHozinKeigenYukouKigen(SyakaiHukushiHozinKeigenYukouKigen);
    }

    @JsonIgnore
    public Label getTokubetuTikiKasanGenmen() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getTokubetuTikiKasanGenmen();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmen(Label TokubetuTikiKasanGenmen) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setTokubetuTikiKasanGenmen(TokubetuTikiKasanGenmen);
    }

    @JsonIgnore
    public TextBox getTokubetuTikiKasanGenmenKeteKubun() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getTokubetuTikiKasanGenmenKeteKubun();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmenKeteKubun(TextBox TokubetuTikiKasanGenmenKeteKubun) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setTokubetuTikiKasanGenmenKeteKubun(TokubetuTikiKasanGenmenKeteKubun);
    }

    @JsonIgnore
    public TextBox getTokubetuTikiKasanGenmenKeigenRitu() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getTokubetuTikiKasanGenmenKeigenRitu();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmenKeigenRitu(TextBox TokubetuTikiKasanGenmenKeigenRitu) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setTokubetuTikiKasanGenmenKeigenRitu(TokubetuTikiKasanGenmenKeigenRitu);
    }

    @JsonIgnore
    public TextBoxDate getTokubetuTikiKasanGenmenTekiyoYYMMDD() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getTokubetuTikiKasanGenmenTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmenTekiyoYYMMDD(TextBoxDate TokubetuTikiKasanGenmenTekiyoYYMMDD) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setTokubetuTikiKasanGenmenTekiyoYYMMDD(TokubetuTikiKasanGenmenTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getTokubetuTikiKasanGenmenYukouKigen() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getTokubetuTikiKasanGenmenYukouKigen();
    }

    @JsonIgnore
    public void  setTokubetuTikiKasanGenmenYukouKigen(TextBoxDate TokubetuTikiKasanGenmenYukouKigen) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setTokubetuTikiKasanGenmenYukouKigen(TokubetuTikiKasanGenmenYukouKigen);
    }

    @JsonIgnore
    public Label getHyojunHutanGenmen() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHyojunHutanGenmen();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmen(Label HyojunHutanGenmen) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHyojunHutanGenmen(HyojunHutanGenmen);
    }

    @JsonIgnore
    public TextBox getHyojunHutanGenmenKeteKubun() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHyojunHutanGenmenKeteKubun();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmenKeteKubun(TextBox HyojunHutanGenmenKeteKubun) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHyojunHutanGenmenKeteKubun(HyojunHutanGenmenKeteKubun);
    }

    @JsonIgnore
    public TextBox getHyojunHutanGenmenHutanGaku() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHyojunHutanGenmenHutanGaku();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmenHutanGaku(TextBox HyojunHutanGenmenHutanGaku) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHyojunHutanGenmenHutanGaku(HyojunHutanGenmenHutanGaku);
    }

    @JsonIgnore
    public TextBoxDate getHyojunHutanGenmenTekiyoYYMMDD() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHyojunHutanGenmenTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmenTekiyoYYMMDD(TextBoxDate HyojunHutanGenmenTekiyoYYMMDD) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHyojunHutanGenmenTekiyoYYMMDD(HyojunHutanGenmenTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getHyojunHutanGenmenYukouKigen() {
        return this.getJyukyusyaJoho().getKakushuGenmenJoho().getHyojunHutanGenmenYukouKigen();
    }

    @JsonIgnore
    public void  setHyojunHutanGenmenYukouKigen(TextBoxDate HyojunHutanGenmenYukouKigen) {
        this.getJyukyusyaJoho().getKakushuGenmenJoho().setHyojunHutanGenmenYukouKigen(HyojunHutanGenmenYukouKigen);
    }

    @JsonIgnore
    public KyuhuSeigenJohoDiv getKyuhuSeigenJoho() {
        return this.getJyukyusyaJoho().getKyuhuSeigenJoho();
    }

    @JsonIgnore
    public void  setKyuhuSeigenJoho(KyuhuSeigenJohoDiv KyuhuSeigenJoho) {
        this.getJyukyusyaJoho().setKyuhuSeigenJoho(KyuhuSeigenJoho);
    }

    @JsonIgnore
    public Label getShiharaiHoho() {
        return this.getJyukyusyaJoho().getKyuhuSeigenJoho().getShiharaiHoho();
    }

    @JsonIgnore
    public void  setShiharaiHoho(Label ShiharaiHoho) {
        this.getJyukyusyaJoho().getKyuhuSeigenJoho().setShiharaiHoho(ShiharaiHoho);
    }

    @JsonIgnore
    public TextBox getShiharaiHohoTorokuKubun() {
        return this.getJyukyusyaJoho().getKyuhuSeigenJoho().getShiharaiHohoTorokuKubun();
    }

    @JsonIgnore
    public void  setShiharaiHohoTorokuKubun(TextBox ShiharaiHohoTorokuKubun) {
        this.getJyukyusyaJoho().getKyuhuSeigenJoho().setShiharaiHohoTorokuKubun(ShiharaiHohoTorokuKubun);
    }

    @JsonIgnore
    public TextBoxDate getShiharaiHohoFromYYMMDD() {
        return this.getJyukyusyaJoho().getKyuhuSeigenJoho().getShiharaiHohoFromYYMMDD();
    }

    @JsonIgnore
    public void  setShiharaiHohoFromYYMMDD(TextBoxDate ShiharaiHohoFromYYMMDD) {
        this.getJyukyusyaJoho().getKyuhuSeigenJoho().setShiharaiHohoFromYYMMDD(ShiharaiHohoFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getShiharaiHohoEndYYMMDD() {
        return this.getJyukyusyaJoho().getKyuhuSeigenJoho().getShiharaiHohoEndYYMMDD();
    }

    @JsonIgnore
    public void  setShiharaiHohoEndYYMMDD(TextBoxDate ShiharaiHohoEndYYMMDD) {
        this.getJyukyusyaJoho().getKyuhuSeigenJoho().setShiharaiHohoEndYYMMDD(ShiharaiHohoEndYYMMDD);
    }

    @JsonIgnore
    public Label getKyuhugakuGengaku() {
        return this.getJyukyusyaJoho().getKyuhuSeigenJoho().getKyuhugakuGengaku();
    }

    @JsonIgnore
    public void  setKyuhugakuGengaku(Label KyuhugakuGengaku) {
        this.getJyukyusyaJoho().getKyuhuSeigenJoho().setKyuhugakuGengaku(KyuhugakuGengaku);
    }

    @JsonIgnore
    public TextBox getKyuhugakuGengakuTorokuKubun() {
        return this.getJyukyusyaJoho().getKyuhuSeigenJoho().getKyuhugakuGengakuTorokuKubun();
    }

    @JsonIgnore
    public void  setKyuhugakuGengakuTorokuKubun(TextBox KyuhugakuGengakuTorokuKubun) {
        this.getJyukyusyaJoho().getKyuhuSeigenJoho().setKyuhugakuGengakuTorokuKubun(KyuhugakuGengakuTorokuKubun);
    }

    @JsonIgnore
    public TextBoxDate getKyuhugakuGengakuFromYYMMDD() {
        return this.getJyukyusyaJoho().getKyuhuSeigenJoho().getKyuhugakuGengakuFromYYMMDD();
    }

    @JsonIgnore
    public void  setKyuhugakuGengakuFromYYMMDD(TextBoxDate KyuhugakuGengakuFromYYMMDD) {
        this.getJyukyusyaJoho().getKyuhuSeigenJoho().setKyuhugakuGengakuFromYYMMDD(KyuhugakuGengakuFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getKyuhugakuGengakuEndYYMMDD() {
        return this.getJyukyusyaJoho().getKyuhuSeigenJoho().getKyuhugakuGengakuEndYYMMDD();
    }

    @JsonIgnore
    public void  setKyuhugakuGengakuEndYYMMDD(TextBoxDate KyuhugakuGengakuEndYYMMDD) {
        this.getJyukyusyaJoho().getKyuhuSeigenJoho().setKyuhugakuGengakuEndYYMMDD(KyuhugakuGengakuEndYYMMDD);
    }

    @JsonIgnore
    public SogoJigyoTaisyosyaJohoDiv getSogoJigyoTaisyosyaJoho() {
        return this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho();
    }

    @JsonIgnore
    public void  setSogoJigyoTaisyosyaJoho(SogoJigyoTaisyosyaJohoDiv SogoJigyoTaisyosyaJoho) {
        this.getJyukyusyaJoho().setSogoJigyoTaisyosyaJoho(SogoJigyoTaisyosyaJoho);
    }

    @JsonIgnore
    public Label getKeikaSoti() {
        return this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getKeikaSoti();
    }

    @JsonIgnore
    public void  setKeikaSoti(Label KeikaSoti) {
        this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().setKeikaSoti(KeikaSoti);
    }

    @JsonIgnore
    public TextBoxDate getKeikaSotiTekiyoFromYYMMDD() {
        return this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getKeikaSotiTekiyoFromYYMMDD();
    }

    @JsonIgnore
    public void  setKeikaSotiTekiyoFromYYMMDD(TextBoxDate KeikaSotiTekiyoFromYYMMDD) {
        this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().setKeikaSotiTekiyoFromYYMMDD(KeikaSotiTekiyoFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getKeikaSotiTekiyoEndYYMMDD() {
        return this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getKeikaSotiTekiyoEndYYMMDD();
    }

    @JsonIgnore
    public void  setKeikaSotiTekiyoEndYYMMDD(TextBoxDate KeikaSotiTekiyoEndYYMMDD) {
        this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().setKeikaSotiTekiyoEndYYMMDD(KeikaSotiTekiyoEndYYMMDD);
    }

    @JsonIgnore
    public Label getSogoJigyo() {
        return this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getSogoJigyo();
    }

    @JsonIgnore
    public void  setSogoJigyo(Label SogoJigyo) {
        this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().setSogoJigyo(SogoJigyo);
    }

    @JsonIgnore
    public TextBoxDate getSogoJigyoTekiyoFromYYMMDD() {
        return this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getSogoJigyoTekiyoFromYYMMDD();
    }

    @JsonIgnore
    public void  setSogoJigyoTekiyoFromYYMMDD(TextBoxDate SogoJigyoTekiyoFromYYMMDD) {
        this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().setSogoJigyoTekiyoFromYYMMDD(SogoJigyoTekiyoFromYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getSogoJigyoTekiyoEndYYMMDD() {
        return this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getSogoJigyoTekiyoEndYYMMDD();
    }

    @JsonIgnore
    public void  setSogoJigyoTekiyoEndYYMMDD(TextBoxDate SogoJigyoTekiyoEndYYMMDD) {
        this.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().setSogoJigyoTekiyoEndYYMMDD(SogoJigyoTekiyoEndYYMMDD);
    }

    // </editor-fold>
}
