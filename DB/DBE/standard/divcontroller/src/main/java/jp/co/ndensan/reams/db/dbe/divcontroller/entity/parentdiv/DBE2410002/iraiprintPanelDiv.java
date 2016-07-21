package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * iraiprintPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class iraiprintPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkIrai")
    private CheckBoxList chkIrai;
    @JsonProperty("txtHakobi")
    private TextBoxDate txtHakobi;
    @JsonProperty("radKigen")
    private RadioButton radKigen;
    @JsonProperty("txtKigenymd")
    private TextBoxDate txtKigenymd;
    @JsonProperty("sp")
    private Space sp;
    @JsonProperty("ChkPrint")
    private CheckBoxList ChkPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkIrai
     * @return chkIrai
     */
    @JsonProperty("chkIrai")
    public CheckBoxList getChkIrai() {
        return chkIrai;
    }

    /*
     * setchkIrai
     * @param chkIrai chkIrai
     */
    @JsonProperty("chkIrai")
    public void setChkIrai(CheckBoxList chkIrai) {
        this.chkIrai = chkIrai;
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
     * getradKigen
     * @return radKigen
     */
    @JsonProperty("radKigen")
    public RadioButton getRadKigen() {
        return radKigen;
    }

    /*
     * setradKigen
     * @param radKigen radKigen
     */
    @JsonProperty("radKigen")
    public void setRadKigen(RadioButton radKigen) {
        this.radKigen = radKigen;
    }

    /*
     * gettxtKigenymd
     * @return txtKigenymd
     */
    @JsonProperty("txtKigenymd")
    public TextBoxDate getTxtKigenymd() {
        return txtKigenymd;
    }

    /*
     * settxtKigenymd
     * @param txtKigenymd txtKigenymd
     */
    @JsonProperty("txtKigenymd")
    public void setTxtKigenymd(TextBoxDate txtKigenymd) {
        this.txtKigenymd = txtKigenymd;
    }

    /*
     * getsp
     * @return sp
     */
    @JsonProperty("sp")
    public Space getSp() {
        return sp;
    }

    /*
     * setsp
     * @param sp sp
     */
    @JsonProperty("sp")
    public void setSp(Space sp) {
        this.sp = sp;
    }

    /*
     * getChkPrint
     * @return ChkPrint
     */
    @JsonProperty("ChkPrint")
    public CheckBoxList getChkPrint() {
        return ChkPrint;
    }

    /*
     * setChkPrint
     * @param ChkPrint ChkPrint
     */
    @JsonProperty("ChkPrint")
    public void setChkPrint(CheckBoxList ChkPrint) {
        this.ChkPrint = ChkPrint;
    }

    // </editor-fold>
}
