package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * iraiprint のクラスファイル 
 * 
 * @author 自動生成
 */
public class iraiprintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("printName")
    private Label printName;
    @JsonProperty("iraiSho")
    private CheckBoxList iraiSho;
    @JsonProperty("txtHakobi")
    private TextBoxDate txtHakobi;
    @JsonProperty("radkigen")
    private RadioButton radkigen;
    @JsonProperty("txtkigenymd")
    private TextBoxDate txtkigenymd;
    @JsonProperty("Sp2")
    private Space Sp2;
    @JsonProperty("iraiIchiranHyo")
    private CheckBoxList iraiIchiranHyo;
    @JsonProperty("Sp")
    private Space Sp;
    @JsonProperty("Sp3")
    private Space Sp3;
    @JsonProperty("kinyoYoshi")
    private CheckBoxList kinyoYoshi;
    @JsonProperty("kinyuYoshiOCR")
    private CheckBoxList kinyuYoshiOCR;
    @JsonProperty("kinyuYoshiDesign")
    private CheckBoxList kinyuYoshiDesign;
    @JsonProperty("seikyuSho")
    private CheckBoxList seikyuSho;
    @JsonProperty("Sp4")
    private Space Sp4;
    @JsonProperty("meireiSho")
    private CheckBoxList meireiSho;
    @JsonProperty("teishutsuIraiSho")
    private CheckBoxList teishutsuIraiSho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getprintName
     * @return printName
     */
    @JsonProperty("printName")
    public Label getPrintName() {
        return printName;
    }

    /*
     * setprintName
     * @param printName printName
     */
    @JsonProperty("printName")
    public void setPrintName(Label printName) {
        this.printName = printName;
    }

    /*
     * getiraiSho
     * @return iraiSho
     */
    @JsonProperty("iraiSho")
    public CheckBoxList getIraiSho() {
        return iraiSho;
    }

    /*
     * setiraiSho
     * @param iraiSho iraiSho
     */
    @JsonProperty("iraiSho")
    public void setIraiSho(CheckBoxList iraiSho) {
        this.iraiSho = iraiSho;
    }

    /*
     * gettxtHakobi
     * @return txtHakobi
     */
    @JsonProperty("txtHakobi")
    public TextBoxDate getTxtHakobi() {
        return txtHakobi;
    }

    /*
     * settxtHakobi
     * @param txtHakobi txtHakobi
     */
    @JsonProperty("txtHakobi")
    public void setTxtHakobi(TextBoxDate txtHakobi) {
        this.txtHakobi = txtHakobi;
    }

    /*
     * getradkigen
     * @return radkigen
     */
    @JsonProperty("radkigen")
    public RadioButton getRadkigen() {
        return radkigen;
    }

    /*
     * setradkigen
     * @param radkigen radkigen
     */
    @JsonProperty("radkigen")
    public void setRadkigen(RadioButton radkigen) {
        this.radkigen = radkigen;
    }

    /*
     * gettxtkigenymd
     * @return txtkigenymd
     */
    @JsonProperty("txtkigenymd")
    public TextBoxDate getTxtkigenymd() {
        return txtkigenymd;
    }

    /*
     * settxtkigenymd
     * @param txtkigenymd txtkigenymd
     */
    @JsonProperty("txtkigenymd")
    public void setTxtkigenymd(TextBoxDate txtkigenymd) {
        this.txtkigenymd = txtkigenymd;
    }

    /*
     * getSp2
     * @return Sp2
     */
    @JsonProperty("Sp2")
    public Space getSp2() {
        return Sp2;
    }

    /*
     * setSp2
     * @param Sp2 Sp2
     */
    @JsonProperty("Sp2")
    public void setSp2(Space Sp2) {
        this.Sp2 = Sp2;
    }

    /*
     * getiraiIchiranHyo
     * @return iraiIchiranHyo
     */
    @JsonProperty("iraiIchiranHyo")
    public CheckBoxList getIraiIchiranHyo() {
        return iraiIchiranHyo;
    }

    /*
     * setiraiIchiranHyo
     * @param iraiIchiranHyo iraiIchiranHyo
     */
    @JsonProperty("iraiIchiranHyo")
    public void setIraiIchiranHyo(CheckBoxList iraiIchiranHyo) {
        this.iraiIchiranHyo = iraiIchiranHyo;
    }

    /*
     * getSp
     * @return Sp
     */
    @JsonProperty("Sp")
    public Space getSp() {
        return Sp;
    }

    /*
     * setSp
     * @param Sp Sp
     */
    @JsonProperty("Sp")
    public void setSp(Space Sp) {
        this.Sp = Sp;
    }

    /*
     * getSp3
     * @return Sp3
     */
    @JsonProperty("Sp3")
    public Space getSp3() {
        return Sp3;
    }

    /*
     * setSp3
     * @param Sp3 Sp3
     */
    @JsonProperty("Sp3")
    public void setSp3(Space Sp3) {
        this.Sp3 = Sp3;
    }

    /*
     * getkinyoYoshi
     * @return kinyoYoshi
     */
    @JsonProperty("kinyoYoshi")
    public CheckBoxList getKinyoYoshi() {
        return kinyoYoshi;
    }

    /*
     * setkinyoYoshi
     * @param kinyoYoshi kinyoYoshi
     */
    @JsonProperty("kinyoYoshi")
    public void setKinyoYoshi(CheckBoxList kinyoYoshi) {
        this.kinyoYoshi = kinyoYoshi;
    }

    /*
     * getkinyuYoshiOCR
     * @return kinyuYoshiOCR
     */
    @JsonProperty("kinyuYoshiOCR")
    public CheckBoxList getKinyuYoshiOCR() {
        return kinyuYoshiOCR;
    }

    /*
     * setkinyuYoshiOCR
     * @param kinyuYoshiOCR kinyuYoshiOCR
     */
    @JsonProperty("kinyuYoshiOCR")
    public void setKinyuYoshiOCR(CheckBoxList kinyuYoshiOCR) {
        this.kinyuYoshiOCR = kinyuYoshiOCR;
    }

    /*
     * getkinyuYoshiDesign
     * @return kinyuYoshiDesign
     */
    @JsonProperty("kinyuYoshiDesign")
    public CheckBoxList getKinyuYoshiDesign() {
        return kinyuYoshiDesign;
    }

    /*
     * setkinyuYoshiDesign
     * @param kinyuYoshiDesign kinyuYoshiDesign
     */
    @JsonProperty("kinyuYoshiDesign")
    public void setKinyuYoshiDesign(CheckBoxList kinyuYoshiDesign) {
        this.kinyuYoshiDesign = kinyuYoshiDesign;
    }

    /*
     * getseikyuSho
     * @return seikyuSho
     */
    @JsonProperty("seikyuSho")
    public CheckBoxList getSeikyuSho() {
        return seikyuSho;
    }

    /*
     * setseikyuSho
     * @param seikyuSho seikyuSho
     */
    @JsonProperty("seikyuSho")
    public void setSeikyuSho(CheckBoxList seikyuSho) {
        this.seikyuSho = seikyuSho;
    }

    /*
     * getSp4
     * @return Sp4
     */
    @JsonProperty("Sp4")
    public Space getSp4() {
        return Sp4;
    }

    /*
     * setSp4
     * @param Sp4 Sp4
     */
    @JsonProperty("Sp4")
    public void setSp4(Space Sp4) {
        this.Sp4 = Sp4;
    }

    /*
     * getmeireiSho
     * @return meireiSho
     */
    @JsonProperty("meireiSho")
    public CheckBoxList getMeireiSho() {
        return meireiSho;
    }

    /*
     * setmeireiSho
     * @param meireiSho meireiSho
     */
    @JsonProperty("meireiSho")
    public void setMeireiSho(CheckBoxList meireiSho) {
        this.meireiSho = meireiSho;
    }

    /*
     * getteishutsuIraiSho
     * @return teishutsuIraiSho
     */
    @JsonProperty("teishutsuIraiSho")
    public CheckBoxList getTeishutsuIraiSho() {
        return teishutsuIraiSho;
    }

    /*
     * setteishutsuIraiSho
     * @param teishutsuIraiSho teishutsuIraiSho
     */
    @JsonProperty("teishutsuIraiSho")
    public void setTeishutsuIraiSho(CheckBoxList teishutsuIraiSho) {
        this.teishutsuIraiSho = teishutsuIraiSho;
    }

    // </editor-fold>
}
