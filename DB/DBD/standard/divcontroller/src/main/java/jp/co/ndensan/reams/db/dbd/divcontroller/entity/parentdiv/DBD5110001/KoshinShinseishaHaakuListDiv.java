package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KoshinShinseishaHaakuList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoshinShinseishaHaakuListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PrintJyoken")
    private PrintJyokenDiv PrintJyoken;
    @JsonProperty("YukokikanTo")
    private YukokikanToDiv YukokikanTo;
    @JsonProperty("YukokikanFromTo")
    private YukokikanFromToDiv YukokikanFromTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPrintJyoken
     * @return PrintJyoken
     */
    @JsonProperty("PrintJyoken")
    public PrintJyokenDiv getPrintJyoken() {
        return PrintJyoken;
    }

    /*
     * setPrintJyoken
     * @param PrintJyoken PrintJyoken
     */
    @JsonProperty("PrintJyoken")
    public void setPrintJyoken(PrintJyokenDiv PrintJyoken) {
        this.PrintJyoken = PrintJyoken;
    }

    /*
     * getYukokikanTo
     * @return YukokikanTo
     */
    @JsonProperty("YukokikanTo")
    public YukokikanToDiv getYukokikanTo() {
        return YukokikanTo;
    }

    /*
     * setYukokikanTo
     * @param YukokikanTo YukokikanTo
     */
    @JsonProperty("YukokikanTo")
    public void setYukokikanTo(YukokikanToDiv YukokikanTo) {
        this.YukokikanTo = YukokikanTo;
    }

    /*
     * getYukokikanFromTo
     * @return YukokikanFromTo
     */
    @JsonProperty("YukokikanFromTo")
    public YukokikanFromToDiv getYukokikanFromTo() {
        return YukokikanFromTo;
    }

    /*
     * setYukokikanFromTo
     * @param YukokikanFromTo YukokikanFromTo
     */
    @JsonProperty("YukokikanFromTo")
    public void setYukokikanFromTo(YukokikanFromToDiv YukokikanFromTo) {
        this.YukokikanFromTo = YukokikanFromTo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getSpSpace1() {
        return this.getPrintJyoken().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getPrintJyoken().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public RadioButton getRadPrintSelect() {
        return this.getPrintJyoken().getRadPrintSelect();
    }

    @JsonIgnore
    public void  setRadPrintSelect(RadioButton radPrintSelect) {
        this.getPrintJyoken().setRadPrintSelect(radPrintSelect);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getYukokikanTo().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getYukokikanTo().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public TextBoxYearMonth getTxtInsatsuDate() {
        return this.getYukokikanTo().getTxtInsatsuDate();
    }

    @JsonIgnore
    public void  setTxtInsatsuDate(TextBoxYearMonth txtInsatsuDate) {
        this.getYukokikanTo().setTxtInsatsuDate(txtInsatsuDate);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getYukokikanFromTo().getSpSpace3();
    }

    @JsonIgnore
    public void  setSpSpace3(Space spSpace3) {
        this.getYukokikanFromTo().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public TextBoxYearMonth getTxtInsatsuDateFrom() {
        return this.getYukokikanFromTo().getTxtInsatsuDateFrom();
    }

    @JsonIgnore
    public void  setTxtInsatsuDateFrom(TextBoxYearMonth txtInsatsuDateFrom) {
        this.getYukokikanFromTo().setTxtInsatsuDateFrom(txtInsatsuDateFrom);
    }

    @JsonIgnore
    public TextBoxYearMonth getTxtInsatsuDateTo() {
        return this.getYukokikanFromTo().getTxtInsatsuDateTo();
    }

    @JsonIgnore
    public void  setTxtInsatsuDateTo(TextBoxYearMonth txtInsatsuDateTo) {
        this.getYukokikanFromTo().setTxtInsatsuDateTo(txtInsatsuDateTo);
    }

    // </editor-fold>
}
