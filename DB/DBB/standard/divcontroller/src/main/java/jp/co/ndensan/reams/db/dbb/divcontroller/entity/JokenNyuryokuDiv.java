package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.AtenaShosaiJokenDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JokenNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class JokenNyuryokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtSetaiCode")
    private TextBoxCode txtSetaiCode;
    @JsonProperty("txtName")
    private TextBox txtName;
    @JsonProperty("btnName")
    private Button btnName;
    @JsonProperty("radFix")
    private RadioButton radFix;
    @JsonProperty("lblTuzuki")
    private Label lblTuzuki;
    @JsonProperty("txtUmareYmd")
    private TextBoxFlexibleDate txtUmareYmd;
    @JsonProperty("ddlSeibetsu")
    private DropDownList ddlSeibetsu;
    @JsonProperty("AtenaShosaiJoken")
    private AtenaShosaiJokenDiv AtenaShosaiJoken;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtHihoban")
    private TextBoxCode txtHihoban;
    @JsonProperty("txtTsuchiNo")
    private TextBoxCode txtTsuchiNo;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("ddlFukaNendo")
    private DropDownList ddlFukaNendo;
    @JsonProperty("txtMaxGetKensu")
    private TextBoxNum txtMaxGetKensu;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnSearch")
    private Button btnSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("txtSetaiCode")
    public TextBoxCode getTxtSetaiCode() {
        return txtSetaiCode;
    }

    @JsonProperty("txtSetaiCode")
    public void setTxtSetaiCode(TextBoxCode txtSetaiCode) {
        this.txtSetaiCode=txtSetaiCode;
    }

    @JsonProperty("txtName")
    public TextBox getTxtName() {
        return txtName;
    }

    @JsonProperty("txtName")
    public void setTxtName(TextBox txtName) {
        this.txtName=txtName;
    }

    @JsonProperty("btnName")
    public Button getBtnName() {
        return btnName;
    }

    @JsonProperty("btnName")
    public void setBtnName(Button btnName) {
        this.btnName=btnName;
    }

    @JsonProperty("radFix")
    public RadioButton getRadFix() {
        return radFix;
    }

    @JsonProperty("radFix")
    public void setRadFix(RadioButton radFix) {
        this.radFix=radFix;
    }

    @JsonProperty("lblTuzuki")
    public Label getLblTuzuki() {
        return lblTuzuki;
    }

    @JsonProperty("lblTuzuki")
    public void setLblTuzuki(Label lblTuzuki) {
        this.lblTuzuki=lblTuzuki;
    }

    @JsonProperty("txtUmareYmd")
    public TextBoxFlexibleDate getTxtUmareYmd() {
        return txtUmareYmd;
    }

    @JsonProperty("txtUmareYmd")
    public void setTxtUmareYmd(TextBoxFlexibleDate txtUmareYmd) {
        this.txtUmareYmd=txtUmareYmd;
    }

    @JsonProperty("ddlSeibetsu")
    public DropDownList getDdlSeibetsu() {
        return ddlSeibetsu;
    }

    @JsonProperty("ddlSeibetsu")
    public void setDdlSeibetsu(DropDownList ddlSeibetsu) {
        this.ddlSeibetsu=ddlSeibetsu;
    }

    @JsonProperty("AtenaShosaiJoken")
    public AtenaShosaiJokenDiv getAtenaShosaiJoken() {
        return AtenaShosaiJoken;
    }

    @JsonProperty("AtenaShosaiJoken")
    public void setAtenaShosaiJoken(AtenaShosaiJokenDiv AtenaShosaiJoken) {
        this.AtenaShosaiJoken=AtenaShosaiJoken;
    }

    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1=lin1;
    }

    @JsonProperty("txtHihoban")
    public TextBoxCode getTxtHihoban() {
        return txtHihoban;
    }

    @JsonProperty("txtHihoban")
    public void setTxtHihoban(TextBoxCode txtHihoban) {
        this.txtHihoban=txtHihoban;
    }

    @JsonProperty("txtTsuchiNo")
    public TextBoxCode getTxtTsuchiNo() {
        return txtTsuchiNo;
    }

    @JsonProperty("txtTsuchiNo")
    public void setTxtTsuchiNo(TextBoxCode txtTsuchiNo) {
        this.txtTsuchiNo=txtTsuchiNo;
    }

    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3=lin3;
    }

    @JsonProperty("ddlFukaNendo")
    public DropDownList getDdlFukaNendo() {
        return ddlFukaNendo;
    }

    @JsonProperty("ddlFukaNendo")
    public void setDdlFukaNendo(DropDownList ddlFukaNendo) {
        this.ddlFukaNendo=ddlFukaNendo;
    }

    @JsonProperty("txtMaxGetKensu")
    public TextBoxNum getTxtMaxGetKensu() {
        return txtMaxGetKensu;
    }

    @JsonProperty("txtMaxGetKensu")
    public void setTxtMaxGetKensu(TextBoxNum txtMaxGetKensu) {
        this.txtMaxGetKensu=txtMaxGetKensu;
    }

    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2=lin2;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch=btnSearch;
    }

}
