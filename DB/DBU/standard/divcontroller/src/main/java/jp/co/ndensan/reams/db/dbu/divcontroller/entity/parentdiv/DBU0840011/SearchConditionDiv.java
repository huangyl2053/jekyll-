package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchCondition のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlCursorPosition")
    private DropDownList ddlCursorPosition;
    @JsonProperty("radForwardMatch")
    private RadioButton radForwardMatch;
    @JsonProperty("lblSearchOption")
    private Label lblSearchOption;
    @JsonProperty("chkSearchOptionHihokensha")
    private CheckBoxList chkSearchOptionHihokensha;
    @JsonProperty("chkSearchOptionYokaigoNinteisha")
    private CheckBoxList chkSearchOptionYokaigoNinteisha;
    @JsonProperty("chkSearchOptionJushochiTokureisha")
    private CheckBoxList chkSearchOptionJushochiTokureisha;
    @JsonProperty("chkSearchOptionTajushochiTokureisha")
    private CheckBoxList chkSearchOptionTajushochiTokureisha;
    @JsonProperty("chkSearchOptionTekiyoJogaisha")
    private CheckBoxList chkSearchOptionTekiyoJogaisha;
    @JsonProperty("txtMaxGetNumber")
    private TextBoxNum txtMaxGetNumber;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlCursorPosition
     * @return ddlCursorPosition
     */
    @JsonProperty("ddlCursorPosition")
    public DropDownList getDdlCursorPosition() {
        return ddlCursorPosition;
    }

    /*
     * setddlCursorPosition
     * @param ddlCursorPosition ddlCursorPosition
     */
    @JsonProperty("ddlCursorPosition")
    public void setDdlCursorPosition(DropDownList ddlCursorPosition) {
        this.ddlCursorPosition = ddlCursorPosition;
    }

    /*
     * getradForwardMatch
     * @return radForwardMatch
     */
    @JsonProperty("radForwardMatch")
    public RadioButton getRadForwardMatch() {
        return radForwardMatch;
    }

    /*
     * setradForwardMatch
     * @param radForwardMatch radForwardMatch
     */
    @JsonProperty("radForwardMatch")
    public void setRadForwardMatch(RadioButton radForwardMatch) {
        this.radForwardMatch = radForwardMatch;
    }

    /*
     * getlblSearchOption
     * @return lblSearchOption
     */
    @JsonProperty("lblSearchOption")
    public Label getLblSearchOption() {
        return lblSearchOption;
    }

    /*
     * setlblSearchOption
     * @param lblSearchOption lblSearchOption
     */
    @JsonProperty("lblSearchOption")
    public void setLblSearchOption(Label lblSearchOption) {
        this.lblSearchOption = lblSearchOption;
    }

    /*
     * getchkSearchOptionHihokensha
     * @return chkSearchOptionHihokensha
     */
    @JsonProperty("chkSearchOptionHihokensha")
    public CheckBoxList getChkSearchOptionHihokensha() {
        return chkSearchOptionHihokensha;
    }

    /*
     * setchkSearchOptionHihokensha
     * @param chkSearchOptionHihokensha chkSearchOptionHihokensha
     */
    @JsonProperty("chkSearchOptionHihokensha")
    public void setChkSearchOptionHihokensha(CheckBoxList chkSearchOptionHihokensha) {
        this.chkSearchOptionHihokensha = chkSearchOptionHihokensha;
    }

    /*
     * getchkSearchOptionYokaigoNinteisha
     * @return chkSearchOptionYokaigoNinteisha
     */
    @JsonProperty("chkSearchOptionYokaigoNinteisha")
    public CheckBoxList getChkSearchOptionYokaigoNinteisha() {
        return chkSearchOptionYokaigoNinteisha;
    }

    /*
     * setchkSearchOptionYokaigoNinteisha
     * @param chkSearchOptionYokaigoNinteisha chkSearchOptionYokaigoNinteisha
     */
    @JsonProperty("chkSearchOptionYokaigoNinteisha")
    public void setChkSearchOptionYokaigoNinteisha(CheckBoxList chkSearchOptionYokaigoNinteisha) {
        this.chkSearchOptionYokaigoNinteisha = chkSearchOptionYokaigoNinteisha;
    }

    /*
     * getchkSearchOptionJushochiTokureisha
     * @return chkSearchOptionJushochiTokureisha
     */
    @JsonProperty("chkSearchOptionJushochiTokureisha")
    public CheckBoxList getChkSearchOptionJushochiTokureisha() {
        return chkSearchOptionJushochiTokureisha;
    }

    /*
     * setchkSearchOptionJushochiTokureisha
     * @param chkSearchOptionJushochiTokureisha chkSearchOptionJushochiTokureisha
     */
    @JsonProperty("chkSearchOptionJushochiTokureisha")
    public void setChkSearchOptionJushochiTokureisha(CheckBoxList chkSearchOptionJushochiTokureisha) {
        this.chkSearchOptionJushochiTokureisha = chkSearchOptionJushochiTokureisha;
    }

    /*
     * getchkSearchOptionTajushochiTokureisha
     * @return chkSearchOptionTajushochiTokureisha
     */
    @JsonProperty("chkSearchOptionTajushochiTokureisha")
    public CheckBoxList getChkSearchOptionTajushochiTokureisha() {
        return chkSearchOptionTajushochiTokureisha;
    }

    /*
     * setchkSearchOptionTajushochiTokureisha
     * @param chkSearchOptionTajushochiTokureisha chkSearchOptionTajushochiTokureisha
     */
    @JsonProperty("chkSearchOptionTajushochiTokureisha")
    public void setChkSearchOptionTajushochiTokureisha(CheckBoxList chkSearchOptionTajushochiTokureisha) {
        this.chkSearchOptionTajushochiTokureisha = chkSearchOptionTajushochiTokureisha;
    }

    /*
     * getchkSearchOptionTekiyoJogaisha
     * @return chkSearchOptionTekiyoJogaisha
     */
    @JsonProperty("chkSearchOptionTekiyoJogaisha")
    public CheckBoxList getChkSearchOptionTekiyoJogaisha() {
        return chkSearchOptionTekiyoJogaisha;
    }

    /*
     * setchkSearchOptionTekiyoJogaisha
     * @param chkSearchOptionTekiyoJogaisha chkSearchOptionTekiyoJogaisha
     */
    @JsonProperty("chkSearchOptionTekiyoJogaisha")
    public void setChkSearchOptionTekiyoJogaisha(CheckBoxList chkSearchOptionTekiyoJogaisha) {
        this.chkSearchOptionTekiyoJogaisha = chkSearchOptionTekiyoJogaisha;
    }

    /*
     * gettxtMaxGetNumber
     * @return txtMaxGetNumber
     */
    @JsonProperty("txtMaxGetNumber")
    public TextBoxNum getTxtMaxGetNumber() {
        return txtMaxGetNumber;
    }

    /*
     * settxtMaxGetNumber
     * @param txtMaxGetNumber txtMaxGetNumber
     */
    @JsonProperty("txtMaxGetNumber")
    public void setTxtMaxGetNumber(TextBoxNum txtMaxGetNumber) {
        this.txtMaxGetNumber = txtMaxGetNumber;
    }

    // </editor-fold>
}
