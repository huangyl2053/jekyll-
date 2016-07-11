package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001;
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
 * SeikatuhogoJukyushaJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatuhogoJukyushaJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSeikatuhogoJukyushaChushutsu")
    private RadioButton radSeikatuhogoJukyushaChushutsu;
    @JsonProperty("SeikatuhogoJukyushaHizukeChushutsu")
    private SeikatuhogoJukyushaHizukeChushutsuDiv SeikatuhogoJukyushaHizukeChushutsu;
    @JsonProperty("linLine05")
    private HorizontalLine linLine05;
    @JsonProperty("chkSeikatsuHogoJukyushaJoho")
    private CheckBoxList chkSeikatsuHogoJukyushaJoho;
    @JsonProperty("chkSeikatsuHogo")
    private CheckBoxList chkSeikatsuHogo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSeikatuhogoJukyushaChushutsu
     * @return radSeikatuhogoJukyushaChushutsu
     */
    @JsonProperty("radSeikatuhogoJukyushaChushutsu")
    public RadioButton getRadSeikatuhogoJukyushaChushutsu() {
        return radSeikatuhogoJukyushaChushutsu;
    }

    /*
     * setradSeikatuhogoJukyushaChushutsu
     * @param radSeikatuhogoJukyushaChushutsu radSeikatuhogoJukyushaChushutsu
     */
    @JsonProperty("radSeikatuhogoJukyushaChushutsu")
    public void setRadSeikatuhogoJukyushaChushutsu(RadioButton radSeikatuhogoJukyushaChushutsu) {
        this.radSeikatuhogoJukyushaChushutsu = radSeikatuhogoJukyushaChushutsu;
    }

    /*
     * getSeikatuhogoJukyushaHizukeChushutsu
     * @return SeikatuhogoJukyushaHizukeChushutsu
     */
    @JsonProperty("SeikatuhogoJukyushaHizukeChushutsu")
    public SeikatuhogoJukyushaHizukeChushutsuDiv getSeikatuhogoJukyushaHizukeChushutsu() {
        return SeikatuhogoJukyushaHizukeChushutsu;
    }

    /*
     * setSeikatuhogoJukyushaHizukeChushutsu
     * @param SeikatuhogoJukyushaHizukeChushutsu SeikatuhogoJukyushaHizukeChushutsu
     */
    @JsonProperty("SeikatuhogoJukyushaHizukeChushutsu")
    public void setSeikatuhogoJukyushaHizukeChushutsu(SeikatuhogoJukyushaHizukeChushutsuDiv SeikatuhogoJukyushaHizukeChushutsu) {
        this.SeikatuhogoJukyushaHizukeChushutsu = SeikatuhogoJukyushaHizukeChushutsu;
    }

    /*
     * getlinLine05
     * @return linLine05
     */
    @JsonProperty("linLine05")
    public HorizontalLine getLinLine05() {
        return linLine05;
    }

    /*
     * setlinLine05
     * @param linLine05 linLine05
     */
    @JsonProperty("linLine05")
    public void setLinLine05(HorizontalLine linLine05) {
        this.linLine05 = linLine05;
    }

    /*
     * getchkSeikatsuHogoJukyushaJoho
     * @return chkSeikatsuHogoJukyushaJoho
     */
    @JsonProperty("chkSeikatsuHogoJukyushaJoho")
    public CheckBoxList getChkSeikatsuHogoJukyushaJoho() {
        return chkSeikatsuHogoJukyushaJoho;
    }

    /*
     * setchkSeikatsuHogoJukyushaJoho
     * @param chkSeikatsuHogoJukyushaJoho chkSeikatsuHogoJukyushaJoho
     */
    @JsonProperty("chkSeikatsuHogoJukyushaJoho")
    public void setChkSeikatsuHogoJukyushaJoho(CheckBoxList chkSeikatsuHogoJukyushaJoho) {
        this.chkSeikatsuHogoJukyushaJoho = chkSeikatsuHogoJukyushaJoho;
    }

    /*
     * getchkSeikatsuHogo
     * @return chkSeikatsuHogo
     */
    @JsonProperty("chkSeikatsuHogo")
    public CheckBoxList getChkSeikatsuHogo() {
        return chkSeikatsuHogo;
    }

    /*
     * setchkSeikatsuHogo
     * @param chkSeikatsuHogo chkSeikatsuHogo
     */
    @JsonProperty("chkSeikatsuHogo")
    public void setChkSeikatsuHogo(CheckBoxList chkSeikatsuHogo) {
        this.chkSeikatsuHogo = chkSeikatsuHogo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getSeikatuhogoJukyushaYohaku() {
        return this.getSeikatuhogoJukyushaHizukeChushutsu().getSeikatuhogoJukyushaYohaku();
    }

    @JsonIgnore
    public void  setSeikatuhogoJukyushaYohaku(Space SeikatuhogoJukyushaYohaku) {
        this.getSeikatuhogoJukyushaHizukeChushutsu().setSeikatuhogoJukyushaYohaku(SeikatuhogoJukyushaYohaku);
    }

    @JsonIgnore
    public TextBoxDate getTexSeikatuhogoKijunDate() {
        return this.getSeikatuhogoJukyushaHizukeChushutsu().getTexSeikatuhogoKijunDate();
    }

    @JsonIgnore
    public void  setTexSeikatuhogoKijunDate(TextBoxDate texSeikatuhogoKijunDate) {
        this.getSeikatuhogoJukyushaHizukeChushutsu().setTexSeikatuhogoKijunDate(texSeikatuhogoKijunDate);
    }

    @JsonIgnore
    public RadioButton getRadSeikatuhogoHani() {
        return this.getSeikatuhogoJukyushaHizukeChushutsu().getRadSeikatuhogoHani();
    }

    @JsonIgnore
    public void  setRadSeikatuhogoHani(RadioButton radSeikatuhogoHani) {
        this.getSeikatuhogoJukyushaHizukeChushutsu().setRadSeikatuhogoHani(radSeikatuhogoHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTexSeikatuhogoDateHani() {
        return this.getSeikatuhogoJukyushaHizukeChushutsu().getTexSeikatuhogoDateHani();
    }

    @JsonIgnore
    public void  setTexSeikatuhogoDateHani(TextBoxDateRange texSeikatuhogoDateHani) {
        this.getSeikatuhogoJukyushaHizukeChushutsu().setTexSeikatuhogoDateHani(texSeikatuhogoDateHani);
    }

    // </editor-fold>
}
