package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010001;
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
 * DvChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvChushutsu")
    private DvChushutsuDiv DvChushutsu;
    @JsonProperty("DvChushutsuShosai")
    private DvChushutsuShosaiDiv DvChushutsuShosai;
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("chkHihokenshaJoho")
    private CheckBoxList chkHihokenshaJoho;
    @JsonProperty("linLine2")
    private HorizontalLine linLine2;
    @JsonProperty("radChushutsuKijun")
    private RadioButton radChushutsuKijun;
    @JsonProperty("chkShutokuJiyu")
    private CheckBoxList chkShutokuJiyu;
    @JsonProperty("chkSoshitsuJiyu")
    private CheckBoxList chkSoshitsuJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvChushutsu
     * @return DvChushutsu
     */
    @JsonProperty("DvChushutsu")
    public DvChushutsuDiv getDvChushutsu() {
        return DvChushutsu;
    }

    /*
     * setDvChushutsu
     * @param DvChushutsu DvChushutsu
     */
    @JsonProperty("DvChushutsu")
    public void setDvChushutsu(DvChushutsuDiv DvChushutsu) {
        this.DvChushutsu = DvChushutsu;
    }

    /*
     * getDvChushutsuShosai
     * @return DvChushutsuShosai
     */
    @JsonProperty("DvChushutsuShosai")
    public DvChushutsuShosaiDiv getDvChushutsuShosai() {
        return DvChushutsuShosai;
    }

    /*
     * setDvChushutsuShosai
     * @param DvChushutsuShosai DvChushutsuShosai
     */
    @JsonProperty("DvChushutsuShosai")
    public void setDvChushutsuShosai(DvChushutsuShosaiDiv DvChushutsuShosai) {
        this.DvChushutsuShosai = DvChushutsuShosai;
    }

    /*
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
    }

    /*
     * getchkHihokenshaJoho
     * @return chkHihokenshaJoho
     */
    @JsonProperty("chkHihokenshaJoho")
    public CheckBoxList getChkHihokenshaJoho() {
        return chkHihokenshaJoho;
    }

    /*
     * setchkHihokenshaJoho
     * @param chkHihokenshaJoho chkHihokenshaJoho
     */
    @JsonProperty("chkHihokenshaJoho")
    public void setChkHihokenshaJoho(CheckBoxList chkHihokenshaJoho) {
        this.chkHihokenshaJoho = chkHihokenshaJoho;
    }

    /*
     * getlinLine2
     * @return linLine2
     */
    @JsonProperty("linLine2")
    public HorizontalLine getLinLine2() {
        return linLine2;
    }

    /*
     * setlinLine2
     * @param linLine2 linLine2
     */
    @JsonProperty("linLine2")
    public void setLinLine2(HorizontalLine linLine2) {
        this.linLine2 = linLine2;
    }

    /*
     * getradChushutsuKijun
     * @return radChushutsuKijun
     */
    @JsonProperty("radChushutsuKijun")
    public RadioButton getRadChushutsuKijun() {
        return radChushutsuKijun;
    }

    /*
     * setradChushutsuKijun
     * @param radChushutsuKijun radChushutsuKijun
     */
    @JsonProperty("radChushutsuKijun")
    public void setRadChushutsuKijun(RadioButton radChushutsuKijun) {
        this.radChushutsuKijun = radChushutsuKijun;
    }

    /*
     * getchkShutokuJiyu
     * @return chkShutokuJiyu
     */
    @JsonProperty("chkShutokuJiyu")
    public CheckBoxList getChkShutokuJiyu() {
        return chkShutokuJiyu;
    }

    /*
     * setchkShutokuJiyu
     * @param chkShutokuJiyu chkShutokuJiyu
     */
    @JsonProperty("chkShutokuJiyu")
    public void setChkShutokuJiyu(CheckBoxList chkShutokuJiyu) {
        this.chkShutokuJiyu = chkShutokuJiyu;
    }

    /*
     * getchkSoshitsuJiyu
     * @return chkSoshitsuJiyu
     */
    @JsonProperty("chkSoshitsuJiyu")
    public CheckBoxList getChkSoshitsuJiyu() {
        return chkSoshitsuJiyu;
    }

    /*
     * setchkSoshitsuJiyu
     * @param chkSoshitsuJiyu chkSoshitsuJiyu
     */
    @JsonProperty("chkSoshitsuJiyu")
    public void setChkSoshitsuJiyu(CheckBoxList chkSoshitsuJiyu) {
        this.chkSoshitsuJiyu = chkSoshitsuJiyu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChushutsu() {
        return this.getDvChushutsu().getRadChushutsu();
    }

    @JsonIgnore
    public void  setRadChushutsu(RadioButton radChushutsu) {
        this.getDvChushutsu().setRadChushutsu(radChushutsu);
    }

    @JsonIgnore
    public Label getLblKuhaku() {
        return this.getDvChushutsuShosai().getLblKuhaku();
    }

    @JsonIgnore
    public void  setLblKuhaku(Label lblKuhaku) {
        this.getDvChushutsuShosai().setLblKuhaku(lblKuhaku);
    }

    @JsonIgnore
    public RadioButton getRadKijunbiDate() {
        return this.getDvChushutsuShosai().getRadKijunbiDate();
    }

    @JsonIgnore
    public void  setRadKijunbiDate(RadioButton radKijunbiDate) {
        this.getDvChushutsuShosai().setRadKijunbiDate(radKijunbiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIryokikan() {
        return this.getDvChushutsuShosai().getTxtIryokikan();
    }

    @JsonIgnore
    public void  setTxtIryokikan(TextBoxDateRange txtIryokikan) {
        this.getDvChushutsuShosai().setTxtIryokikan(txtIryokikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunDate() {
        return this.getDvChushutsuShosai().getTxtKijunDate();
    }

    @JsonIgnore
    public void  setTxtKijunDate(TextBoxDate txtKijunDate) {
        this.getDvChushutsuShosai().setTxtKijunDate(txtKijunDate);
    }

    @JsonIgnore
    public CheckBoxList getChkKijunDateNozoku() {
        return this.getDvChushutsuShosai().getChkKijunDateNozoku();
    }

    @JsonIgnore
    public void  setChkKijunDateNozoku(CheckBoxList chkKijunDateNozoku) {
        this.getDvChushutsuShosai().setChkKijunDateNozoku(chkKijunDateNozoku);
    }

    @JsonIgnore
    public RadioButton getRadHani() {
        return this.getDvChushutsuShosai().getRadHani();
    }

    @JsonIgnore
    public void  setRadHani(RadioButton radHani) {
        this.getDvChushutsuShosai().setRadHani(radHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuHani() {
        return this.getDvChushutsuShosai().getTxtChushutsuHani();
    }

    @JsonIgnore
    public void  setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.getDvChushutsuShosai().setTxtChushutsuHani(txtChushutsuHani);
    }

    // </editor-fold>
}
