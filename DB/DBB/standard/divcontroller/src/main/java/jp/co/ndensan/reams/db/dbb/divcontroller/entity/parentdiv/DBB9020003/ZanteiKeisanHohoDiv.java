package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * ZanteiKeisanHoho のクラスファイル
 *
 * @reamsid_L DBB-1770-050 xupeng
 */
public class ZanteiKeisanHohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlFukaHoho")
    private DropDownList ddlFukaHoho;
    @JsonProperty("txtFukaHohoHelp")
    private TextBoxMultiLine txtFukaHohoHelp;
    @JsonProperty("ddlIdoHoho")
    private DropDownList ddlIdoHoho;
    @JsonProperty("radHasuChosei")
    private RadioButton radHasuChosei;
    @JsonProperty("radHeichoSha")
    private RadioButton radHeichoSha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlFukaHoho
     * @return ddlFukaHoho
     */
    @JsonProperty("ddlFukaHoho")
    public DropDownList getDdlFukaHoho() {
        return ddlFukaHoho;
    }

    /*
     * setddlFukaHoho
     * @param ddlFukaHoho ddlFukaHoho
     */
    @JsonProperty("ddlFukaHoho")
    public void setDdlFukaHoho(DropDownList ddlFukaHoho) {
        this.ddlFukaHoho = ddlFukaHoho;
    }

    /*
     * gettxtFukaHohoHelp
     * @return txtFukaHohoHelp
     */
    @JsonProperty("txtFukaHohoHelp")
    public TextBoxMultiLine getTxtFukaHohoHelp() {
        return txtFukaHohoHelp;
    }

    /*
     * settxtFukaHohoHelp
     * @param txtFukaHohoHelp txtFukaHohoHelp
     */
    @JsonProperty("txtFukaHohoHelp")
    public void setTxtFukaHohoHelp(TextBoxMultiLine txtFukaHohoHelp) {
        this.txtFukaHohoHelp = txtFukaHohoHelp;
    }

    /*
     * getddlIdoHoho
     * @return ddlIdoHoho
     */
    @JsonProperty("ddlIdoHoho")
    public DropDownList getDdlIdoHoho() {
        return ddlIdoHoho;
    }

    /*
     * setddlIdoHoho
     * @param ddlIdoHoho ddlIdoHoho
     */
    @JsonProperty("ddlIdoHoho")
    public void setDdlIdoHoho(DropDownList ddlIdoHoho) {
        this.ddlIdoHoho = ddlIdoHoho;
    }

    /*
     * getradHasuChosei
     * @return radHasuChosei
     */
    @JsonProperty("radHasuChosei")
    public RadioButton getRadHasuChosei() {
        return radHasuChosei;
    }

    /*
     * setradHasuChosei
     * @param radHasuChosei radHasuChosei
     */
    @JsonProperty("radHasuChosei")
    public void setRadHasuChosei(RadioButton radHasuChosei) {
        this.radHasuChosei = radHasuChosei;
    }

    /*
     * getradHeichoSha
     * @return radHeichoSha
     */
    @JsonProperty("radHeichoSha")
    public RadioButton getRadHeichoSha() {
        return radHeichoSha;
    }

    /*
     * setradHeichoSha
     * @param radHeichoSha radHeichoSha
     */
    @JsonProperty("radHeichoSha")
    public void setRadHeichoSha(RadioButton radHeichoSha) {
        this.radHeichoSha = radHeichoSha;
    }

    // </editor-fold>
}
