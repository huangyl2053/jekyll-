package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;

/**
 * ChushutuJoken のクラスファイル
 *
 * @author 自動生成
 */
public class ChushutuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHanteiKijun")
    private Label lblHanteiKijun;
    @JsonProperty("txtKijunDate")
    private TextBoxDate txtKijunDate;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("radTaisho")
    private RadioButton radTaisho;
    @JsonProperty("ZenTorokushaIgai")
    private ZenTorokushaIgaiDiv ZenTorokushaIgai;
    @JsonProperty("chkOutputsHokenryoKannosha")
    private CheckBoxList chkOutputsHokenryoKannosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getlblHanteiKijun
     * @return lblHanteiKijun
     */
    @JsonProperty("lblHanteiKijun")
    public Label getLblHanteiKijun() {
        return lblHanteiKijun;
    }

    /*
     * setlblHanteiKijun
     * @param lblHanteiKijun lblHanteiKijun
     */
    @JsonProperty("lblHanteiKijun")
    public void setLblHanteiKijun(Label lblHanteiKijun) {
        this.lblHanteiKijun = lblHanteiKijun;
    }

    /*
     * gettxtKijunDate
     * @return txtKijunDate
     */
    @JsonProperty("txtKijunDate")
    public TextBoxDate getTxtKijunDate() {
        return txtKijunDate;
    }

    /*
     * settxtKijunDate
     * @param txtKijunDate txtKijunDate
     */
    @JsonProperty("txtKijunDate")
    public void setTxtKijunDate(TextBoxDate txtKijunDate) {
        this.txtKijunDate = txtKijunDate;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getradTaisho
     * @return radTaisho
     */
    @JsonProperty("radTaisho")
    public RadioButton getRadTaisho() {
        return radTaisho;
    }

    /*
     * setradTaisho
     * @param radTaisho radTaisho
     */
    @JsonProperty("radTaisho")
    public void setRadTaisho(RadioButton radTaisho) {
        this.radTaisho = radTaisho;
    }

    /*
     * getZenTorokushaIgai
     * @return ZenTorokushaIgai
     */
    @JsonProperty("ZenTorokushaIgai")
    public ZenTorokushaIgaiDiv getZenTorokushaIgai() {
        return ZenTorokushaIgai;
    }

    /*
     * setZenTorokushaIgai
     * @param ZenTorokushaIgai ZenTorokushaIgai
     */
    @JsonProperty("ZenTorokushaIgai")
    public void setZenTorokushaIgai(ZenTorokushaIgaiDiv ZenTorokushaIgai) {
        this.ZenTorokushaIgai = ZenTorokushaIgai;
    }

    /*
     * getchkOutputsHokenryoKannosha
     * @return chkOutputsHokenryoKannosha
     */
    @JsonProperty("chkOutputsHokenryoKannosha")
    public CheckBoxList getChkOutputsHokenryoKannosha() {
        return chkOutputsHokenryoKannosha;
    }

    /*
     * setchkOutputsHokenryoKannosha
     * @param chkOutputsHokenryoKannosha chkOutputsHokenryoKannosha
     */
    @JsonProperty("chkOutputsHokenryoKannosha")
    public void setChkOutputsHokenryoKannosha(CheckBoxList chkOutputsHokenryoKannosha) {
        this.chkOutputsHokenryoKannosha = chkOutputsHokenryoKannosha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkTsuchishoMihakko() {
        return this.getZenTorokushaIgai().getChkTsuchishoMihakko();
    }

    @JsonIgnore
    public void setChkTsuchishoMihakko(CheckBoxList chkTsuchishoMihakko) {
        this.getZenTorokushaIgai().setChkTsuchishoMihakko(chkTsuchishoMihakko);
    }

    @JsonIgnore
    public CheckBoxList getChkGengakuTekiyochuSha() {
        return this.getZenTorokushaIgai().getChkGengakuTekiyochuSha();
    }

    @JsonIgnore
    public void setChkGengakuTekiyochuSha(CheckBoxList chkGengakuTekiyochuSha) {
        this.getZenTorokushaIgai().setChkGengakuTekiyochuSha(chkGengakuTekiyochuSha);
    }

    @JsonIgnore
    public TextBoxDate getTxtGengakuTekiyoChushaKijunDate() {
        return this.getZenTorokushaIgai().getTxtGengakuTekiyoChushaKijunDate();
    }

    @JsonIgnore
    public void setTxtGengakuTekiyoChushaKijunDate(TextBoxDate txtGengakuTekiyoChushaKijunDate) {
        this.getZenTorokushaIgai().setTxtGengakuTekiyoChushaKijunDate(txtGengakuTekiyoChushaKijunDate);
    }

    @JsonIgnore
    public CheckBoxList getChkGengakuShuryoDate() {
        return this.getZenTorokushaIgai().getChkGengakuShuryoDate();
    }

    @JsonIgnore
    public void setChkGengakuShuryoDate(CheckBoxList chkGengakuShuryoDate) {
        this.getZenTorokushaIgai().setChkGengakuShuryoDate(chkGengakuShuryoDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtGengakuShuryoRange() {
        return this.getZenTorokushaIgai().getTxtGengakuShuryoRange();
    }

    @JsonIgnore
    public void setTxtGengakuShuryoRange(TextBoxDateRange txtGengakuShuryoRange) {
        this.getZenTorokushaIgai().setTxtGengakuShuryoRange(txtGengakuShuryoRange);
    }

    // </editor-fold>
    public Object getChushutuJoken() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
