package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChikuSpace1")
    private Space ChikuSpace1;
    @JsonProperty("ddlChiku")
    private DropDownList ddlChiku;
    @JsonProperty("txtChikuCodeFrom")
    private TextBoxCode txtChikuCodeFrom;
    @JsonProperty("btnChikuJushoCodeFrom")
    private ButtonDialog btnChikuJushoCodeFrom;
    @JsonProperty("btnChikuGyoseikuCodeFrom")
    private ButtonDialog btnChikuGyoseikuCodeFrom;
    @JsonProperty("txtChikuNameFrom")
    private TextBox txtChikuNameFrom;
    @JsonProperty("txtChikuCodeTo")
    private TextBoxCode txtChikuCodeTo;
    @JsonProperty("btnChikuJushoCodeTo")
    private ButtonDialog btnChikuJushoCodeTo;
    @JsonProperty("txtChikuNameTo")
    private TextBox txtChikuNameTo;
    @JsonProperty("ShichosonSpace1")
    private Space ShichosonSpace1;
    @JsonProperty("btnChikuGyoseikuCodeTo")
    private ButtonDialog btnChikuGyoseikuCodeTo;
    @JsonProperty("InputMode")
    private RString InputMode;
    @JsonProperty("SearchLevel")
    private RString SearchLevel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChikuSpace1
     * @return ChikuSpace1
     */
    @JsonProperty("ChikuSpace1")
    public Space getChikuSpace1() {
        return ChikuSpace1;
    }

    /*
     * setChikuSpace1
     * @param ChikuSpace1 ChikuSpace1
     */
    @JsonProperty("ChikuSpace1")
    public void setChikuSpace1(Space ChikuSpace1) {
        this.ChikuSpace1 = ChikuSpace1;
    }

    /*
     * getddlChiku
     * @return ddlChiku
     */
    @JsonProperty("ddlChiku")
    public DropDownList getDdlChiku() {
        return ddlChiku;
    }

    /*
     * setddlChiku
     * @param ddlChiku ddlChiku
     */
    @JsonProperty("ddlChiku")
    public void setDdlChiku(DropDownList ddlChiku) {
        this.ddlChiku = ddlChiku;
    }

    /*
     * gettxtChikuCodeFrom
     * @return txtChikuCodeFrom
     */
    @JsonProperty("txtChikuCodeFrom")
    public TextBoxCode getTxtChikuCodeFrom() {
        return txtChikuCodeFrom;
    }

    /*
     * settxtChikuCodeFrom
     * @param txtChikuCodeFrom txtChikuCodeFrom
     */
    @JsonProperty("txtChikuCodeFrom")
    public void setTxtChikuCodeFrom(TextBoxCode txtChikuCodeFrom) {
        this.txtChikuCodeFrom = txtChikuCodeFrom;
    }

    /*
     * getbtnChikuJushoCodeFrom
     * @return btnChikuJushoCodeFrom
     */
    @JsonProperty("btnChikuJushoCodeFrom")
    public ButtonDialog getBtnChikuJushoCodeFrom() {
        return btnChikuJushoCodeFrom;
    }

    /*
     * setbtnChikuJushoCodeFrom
     * @param btnChikuJushoCodeFrom btnChikuJushoCodeFrom
     */
    @JsonProperty("btnChikuJushoCodeFrom")
    public void setBtnChikuJushoCodeFrom(ButtonDialog btnChikuJushoCodeFrom) {
        this.btnChikuJushoCodeFrom = btnChikuJushoCodeFrom;
    }

    /*
     * getbtnChikuGyoseikuCodeFrom
     * @return btnChikuGyoseikuCodeFrom
     */
    @JsonProperty("btnChikuGyoseikuCodeFrom")
    public ButtonDialog getBtnChikuGyoseikuCodeFrom() {
        return btnChikuGyoseikuCodeFrom;
    }

    /*
     * setbtnChikuGyoseikuCodeFrom
     * @param btnChikuGyoseikuCodeFrom btnChikuGyoseikuCodeFrom
     */
    @JsonProperty("btnChikuGyoseikuCodeFrom")
    public void setBtnChikuGyoseikuCodeFrom(ButtonDialog btnChikuGyoseikuCodeFrom) {
        this.btnChikuGyoseikuCodeFrom = btnChikuGyoseikuCodeFrom;
    }

    /*
     * gettxtChikuNameFrom
     * @return txtChikuNameFrom
     */
    @JsonProperty("txtChikuNameFrom")
    public TextBox getTxtChikuNameFrom() {
        return txtChikuNameFrom;
    }

    /*
     * settxtChikuNameFrom
     * @param txtChikuNameFrom txtChikuNameFrom
     */
    @JsonProperty("txtChikuNameFrom")
    public void setTxtChikuNameFrom(TextBox txtChikuNameFrom) {
        this.txtChikuNameFrom = txtChikuNameFrom;
    }

    /*
     * gettxtChikuCodeTo
     * @return txtChikuCodeTo
     */
    @JsonProperty("txtChikuCodeTo")
    public TextBoxCode getTxtChikuCodeTo() {
        return txtChikuCodeTo;
    }

    /*
     * settxtChikuCodeTo
     * @param txtChikuCodeTo txtChikuCodeTo
     */
    @JsonProperty("txtChikuCodeTo")
    public void setTxtChikuCodeTo(TextBoxCode txtChikuCodeTo) {
        this.txtChikuCodeTo = txtChikuCodeTo;
    }

    /*
     * getbtnChikuJushoCodeTo
     * @return btnChikuJushoCodeTo
     */
    @JsonProperty("btnChikuJushoCodeTo")
    public ButtonDialog getBtnChikuJushoCodeTo() {
        return btnChikuJushoCodeTo;
    }

    /*
     * setbtnChikuJushoCodeTo
     * @param btnChikuJushoCodeTo btnChikuJushoCodeTo
     */
    @JsonProperty("btnChikuJushoCodeTo")
    public void setBtnChikuJushoCodeTo(ButtonDialog btnChikuJushoCodeTo) {
        this.btnChikuJushoCodeTo = btnChikuJushoCodeTo;
    }

    /*
     * gettxtChikuNameTo
     * @return txtChikuNameTo
     */
    @JsonProperty("txtChikuNameTo")
    public TextBox getTxtChikuNameTo() {
        return txtChikuNameTo;
    }

    /*
     * settxtChikuNameTo
     * @param txtChikuNameTo txtChikuNameTo
     */
    @JsonProperty("txtChikuNameTo")
    public void setTxtChikuNameTo(TextBox txtChikuNameTo) {
        this.txtChikuNameTo = txtChikuNameTo;
    }

    /*
     * getShichosonSpace1
     * @return ShichosonSpace1
     */
    @JsonProperty("ShichosonSpace1")
    public Space getShichosonSpace1() {
        return ShichosonSpace1;
    }

    /*
     * setShichosonSpace1
     * @param ShichosonSpace1 ShichosonSpace1
     */
    @JsonProperty("ShichosonSpace1")
    public void setShichosonSpace1(Space ShichosonSpace1) {
        this.ShichosonSpace1 = ShichosonSpace1;
    }

    /*
     * getbtnChikuGyoseikuCodeTo
     * @return btnChikuGyoseikuCodeTo
     */
    @JsonProperty("btnChikuGyoseikuCodeTo")
    public ButtonDialog getBtnChikuGyoseikuCodeTo() {
        return btnChikuGyoseikuCodeTo;
    }

    /*
     * setbtnChikuGyoseikuCodeTo
     * @param btnChikuGyoseikuCodeTo btnChikuGyoseikuCodeTo
     */
    @JsonProperty("btnChikuGyoseikuCodeTo")
    public void setBtnChikuGyoseikuCodeTo(ButtonDialog btnChikuGyoseikuCodeTo) {
        this.btnChikuGyoseikuCodeTo = btnChikuGyoseikuCodeTo;
    }

    /*
     * getInputMode
     * @return InputMode
     */
    @JsonProperty("InputMode")
    public RString getInputMode() {
        return InputMode;
    }

    /*
     * setInputMode
     * @param InputMode InputMode
     */
    @JsonProperty("InputMode")
    public void setInputMode(RString InputMode) {
        this.InputMode = InputMode;
    }

    /*
     * getSearchLevel
     * @return SearchLevel
     */
    @JsonProperty("SearchLevel")
    public RString getSearchLevel() {
        return SearchLevel;
    }

    /*
     * setSearchLevel
     * @param SearchLevel SearchLevel
     */
    @JsonProperty("SearchLevel")
    public void setSearchLevel(RString SearchLevel) {
        this.SearchLevel = SearchLevel;
    }

    // </editor-fold>
}
