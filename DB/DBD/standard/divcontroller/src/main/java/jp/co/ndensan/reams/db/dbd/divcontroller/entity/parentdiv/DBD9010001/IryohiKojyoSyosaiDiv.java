package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001;
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
 * IryohiKojyoSyosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryohiKojyoSyosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SyosaiPanel1")
    private SyosaiPanel1Div SyosaiPanel1;
    @JsonProperty("SyosaiPanel2")
    private SyosaiPanel2Div SyosaiPanel2;
    @JsonProperty("KakuteButton")
    private Button KakuteButton;
    @JsonProperty("CancleButton")
    private Button CancleButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSyosaiPanel1
     * @return SyosaiPanel1
     */
    @JsonProperty("SyosaiPanel1")
    public SyosaiPanel1Div getSyosaiPanel1() {
        return SyosaiPanel1;
    }

    /*
     * setSyosaiPanel1
     * @param SyosaiPanel1 SyosaiPanel1
     */
    @JsonProperty("SyosaiPanel1")
    public void setSyosaiPanel1(SyosaiPanel1Div SyosaiPanel1) {
        this.SyosaiPanel1 = SyosaiPanel1;
    }

    /*
     * getSyosaiPanel2
     * @return SyosaiPanel2
     */
    @JsonProperty("SyosaiPanel2")
    public SyosaiPanel2Div getSyosaiPanel2() {
        return SyosaiPanel2;
    }

    /*
     * setSyosaiPanel2
     * @param SyosaiPanel2 SyosaiPanel2
     */
    @JsonProperty("SyosaiPanel2")
    public void setSyosaiPanel2(SyosaiPanel2Div SyosaiPanel2) {
        this.SyosaiPanel2 = SyosaiPanel2;
    }

    /*
     * getKakuteButton
     * @return KakuteButton
     */
    @JsonProperty("KakuteButton")
    public Button getKakuteButton() {
        return KakuteButton;
    }

    /*
     * setKakuteButton
     * @param KakuteButton KakuteButton
     */
    @JsonProperty("KakuteButton")
    public void setKakuteButton(Button KakuteButton) {
        this.KakuteButton = KakuteButton;
    }

    /*
     * getCancleButton
     * @return CancleButton
     */
    @JsonProperty("CancleButton")
    public Button getCancleButton() {
        return CancleButton;
    }

    /*
     * setCancleButton
     * @param CancleButton CancleButton
     */
    @JsonProperty("CancleButton")
    public void setCancleButton(Button CancleButton) {
        this.CancleButton = CancleButton;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getKubunRadioButton() {
        return this.getSyosaiPanel1().getKubunRadioButton();
    }

    @JsonIgnore
    public void  setKubunRadioButton(RadioButton KubunRadioButton) {
        this.getSyosaiPanel1().setKubunRadioButton(KubunRadioButton);
    }

    @JsonIgnore
    public TextBoxDate getSinseYYMMDD() {
        return this.getSyosaiPanel1().getSinseYYMMDD();
    }

    @JsonIgnore
    public void  setSinseYYMMDD(TextBoxDate sinseYYMMDD) {
        this.getSyosaiPanel1().setSinseYYMMDD(sinseYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getTorokuYYMMDD() {
        return this.getSyosaiPanel1().getTorokuYYMMDD();
    }

    @JsonIgnore
    public void  setTorokuYYMMDD(TextBoxDate torokuYYMMDD) {
        this.getSyosaiPanel1().setTorokuYYMMDD(torokuYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getTaisyoYY() {
        return this.getSyosaiPanel1().getTaisyoYY();
    }

    @JsonIgnore
    public void  setTaisyoYY(TextBoxDate TaisyoYY) {
        this.getSyosaiPanel1().setTaisyoYY(TaisyoYY);
    }

    @JsonIgnore
    public TextBoxDate getSakuseYYMMDD() {
        return this.getSyosaiPanel2().getSakuseYYMMDD();
    }

    @JsonIgnore
    public void  setSakuseYYMMDD(TextBoxDate SakuseYYMMDD) {
        this.getSyosaiPanel2().setSakuseYYMMDD(SakuseYYMMDD);
    }

    @JsonIgnore
    public TextBoxDate getNinteFromYYMMDD() {
        return this.getSyosaiPanel2().getNinteFromYYMMDD();
    }

    @JsonIgnore
    public void  setNinteFromYYMMDD(TextBoxDate NinteFromYYMMDD) {
        this.getSyosaiPanel2().setNinteFromYYMMDD(NinteFromYYMMDD);
    }

    @JsonIgnore
    public Label getNinnteiTo() {
        return this.getSyosaiPanel2().getNinnteiTo();
    }

    @JsonIgnore
    public void  setNinnteiTo(Label NinnteiTo) {
        this.getSyosaiPanel2().setNinnteiTo(NinnteiTo);
    }

    @JsonIgnore
    public TextBoxDate getNinteEndYYMMDD() {
        return this.getSyosaiPanel2().getNinteEndYYMMDD();
    }

    @JsonIgnore
    public void  setNinteEndYYMMDD(TextBoxDate NinteEndYYMMDD) {
        this.getSyosaiPanel2().setNinteEndYYMMDD(NinteEndYYMMDD);
    }

    @JsonIgnore
    public RadioButton getNitijyoSekatuJiritudo() {
        return this.getSyosaiPanel2().getNitijyoSekatuJiritudo();
    }

    @JsonIgnore
    public void  setNitijyoSekatuJiritudo(RadioButton NitijyoSekatuJiritudo) {
        this.getSyosaiPanel2().setNitijyoSekatuJiritudo(NitijyoSekatuJiritudo);
    }

    @JsonIgnore
    public RadioButton getNyosikin() {
        return this.getSyosaiPanel2().getNyosikin();
    }

    @JsonIgnore
    public void  setNyosikin(RadioButton Nyosikin) {
        this.getSyosaiPanel2().setNyosikin(Nyosikin);
    }

    // </editor-fold>
}
