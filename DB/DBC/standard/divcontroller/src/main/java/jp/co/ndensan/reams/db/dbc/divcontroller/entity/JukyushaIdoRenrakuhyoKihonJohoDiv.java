package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyushaIdoRenrakuhyoKihonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoKihonJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRenrakuhyoHihoNo")
    private TextBoxCode txtRenrakuhyoHihoNo;
    @JsonProperty("txtRenrakuhyoSendYM")
    private TextBoxFlexibleDate txtRenrakuhyoSendYM;
    @JsonProperty("txtRenrakuhyoIdoDate")
    private TextBoxFlexibleDate txtRenrakuhyoIdoDate;
    @JsonProperty("lblRenrakuhyoIdoKubun")
    private Label lblRenrakuhyoIdoKubun;
    @JsonProperty("radRenrakuhyoIdoKubun")
    private RadioButton radRenrakuhyoIdoKubun;
    @JsonProperty("txtShikakuShutokuDate")
    private TextBoxFlexibleDate txtShikakuShutokuDate;
    @JsonProperty("txtRenrakuhyoHihoName")
    private TextBoxKana txtRenrakuhyoHihoName;
    @JsonProperty("txtHihoBirthday")
    private TextBoxFlexibleDate txtHihoBirthday;
    @JsonProperty("lblHihoSex")
    private Label lblHihoSex;
    @JsonProperty("radHihoSex")
    private RadioButton radHihoSex;
    @JsonProperty("txtShikakuSoshitsuDate")
    private TextBoxFlexibleDate txtShikakuSoshitsuDate;
    @JsonProperty("ddlIdoJiyu")
    private DropDownList ddlIdoJiyu;
    @JsonProperty("ddlYokaigoJotaiKubun")
    private DropDownList ddlYokaigoJotaiKubun;
    @JsonProperty("txtShokisaiHokenshaNo")
    private TextBoxCode txtShokisaiHokenshaNo;
    @JsonProperty("txtKoikiHokenshaNo")
    private TextBoxCode txtKoikiHokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtRenrakuhyoHihoNo")
    public TextBoxCode getTxtRenrakuhyoHihoNo() {
        return txtRenrakuhyoHihoNo;
    }

    @JsonProperty("txtRenrakuhyoHihoNo")
    public void setTxtRenrakuhyoHihoNo(TextBoxCode txtRenrakuhyoHihoNo) {
        this.txtRenrakuhyoHihoNo=txtRenrakuhyoHihoNo;
    }

    @JsonProperty("txtRenrakuhyoSendYM")
    public TextBoxFlexibleDate getTxtRenrakuhyoSendYM() {
        return txtRenrakuhyoSendYM;
    }

    @JsonProperty("txtRenrakuhyoSendYM")
    public void setTxtRenrakuhyoSendYM(TextBoxFlexibleDate txtRenrakuhyoSendYM) {
        this.txtRenrakuhyoSendYM=txtRenrakuhyoSendYM;
    }

    @JsonProperty("txtRenrakuhyoIdoDate")
    public TextBoxFlexibleDate getTxtRenrakuhyoIdoDate() {
        return txtRenrakuhyoIdoDate;
    }

    @JsonProperty("txtRenrakuhyoIdoDate")
    public void setTxtRenrakuhyoIdoDate(TextBoxFlexibleDate txtRenrakuhyoIdoDate) {
        this.txtRenrakuhyoIdoDate=txtRenrakuhyoIdoDate;
    }

    @JsonProperty("lblRenrakuhyoIdoKubun")
    public Label getLblRenrakuhyoIdoKubun() {
        return lblRenrakuhyoIdoKubun;
    }

    @JsonProperty("lblRenrakuhyoIdoKubun")
    public void setLblRenrakuhyoIdoKubun(Label lblRenrakuhyoIdoKubun) {
        this.lblRenrakuhyoIdoKubun=lblRenrakuhyoIdoKubun;
    }

    @JsonProperty("radRenrakuhyoIdoKubun")
    public RadioButton getRadRenrakuhyoIdoKubun() {
        return radRenrakuhyoIdoKubun;
    }

    @JsonProperty("radRenrakuhyoIdoKubun")
    public void setRadRenrakuhyoIdoKubun(RadioButton radRenrakuhyoIdoKubun) {
        this.radRenrakuhyoIdoKubun=radRenrakuhyoIdoKubun;
    }

    @JsonProperty("txtShikakuShutokuDate")
    public TextBoxFlexibleDate getTxtShikakuShutokuDate() {
        return txtShikakuShutokuDate;
    }

    @JsonProperty("txtShikakuShutokuDate")
    public void setTxtShikakuShutokuDate(TextBoxFlexibleDate txtShikakuShutokuDate) {
        this.txtShikakuShutokuDate=txtShikakuShutokuDate;
    }

    @JsonProperty("txtRenrakuhyoHihoName")
    public TextBoxKana getTxtRenrakuhyoHihoName() {
        return txtRenrakuhyoHihoName;
    }

    @JsonProperty("txtRenrakuhyoHihoName")
    public void setTxtRenrakuhyoHihoName(TextBoxKana txtRenrakuhyoHihoName) {
        this.txtRenrakuhyoHihoName=txtRenrakuhyoHihoName;
    }

    @JsonProperty("txtHihoBirthday")
    public TextBoxFlexibleDate getTxtHihoBirthday() {
        return txtHihoBirthday;
    }

    @JsonProperty("txtHihoBirthday")
    public void setTxtHihoBirthday(TextBoxFlexibleDate txtHihoBirthday) {
        this.txtHihoBirthday=txtHihoBirthday;
    }

    @JsonProperty("lblHihoSex")
    public Label getLblHihoSex() {
        return lblHihoSex;
    }

    @JsonProperty("lblHihoSex")
    public void setLblHihoSex(Label lblHihoSex) {
        this.lblHihoSex=lblHihoSex;
    }

    @JsonProperty("radHihoSex")
    public RadioButton getRadHihoSex() {
        return radHihoSex;
    }

    @JsonProperty("radHihoSex")
    public void setRadHihoSex(RadioButton radHihoSex) {
        this.radHihoSex=radHihoSex;
    }

    @JsonProperty("txtShikakuSoshitsuDate")
    public TextBoxFlexibleDate getTxtShikakuSoshitsuDate() {
        return txtShikakuSoshitsuDate;
    }

    @JsonProperty("txtShikakuSoshitsuDate")
    public void setTxtShikakuSoshitsuDate(TextBoxFlexibleDate txtShikakuSoshitsuDate) {
        this.txtShikakuSoshitsuDate=txtShikakuSoshitsuDate;
    }

    @JsonProperty("ddlIdoJiyu")
    public DropDownList getDdlIdoJiyu() {
        return ddlIdoJiyu;
    }

    @JsonProperty("ddlIdoJiyu")
    public void setDdlIdoJiyu(DropDownList ddlIdoJiyu) {
        this.ddlIdoJiyu=ddlIdoJiyu;
    }

    @JsonProperty("ddlYokaigoJotaiKubun")
    public DropDownList getDdlYokaigoJotaiKubun() {
        return ddlYokaigoJotaiKubun;
    }

    @JsonProperty("ddlYokaigoJotaiKubun")
    public void setDdlYokaigoJotaiKubun(DropDownList ddlYokaigoJotaiKubun) {
        this.ddlYokaigoJotaiKubun=ddlYokaigoJotaiKubun;
    }

    @JsonProperty("txtShokisaiHokenshaNo")
    public TextBoxCode getTxtShokisaiHokenshaNo() {
        return txtShokisaiHokenshaNo;
    }

    @JsonProperty("txtShokisaiHokenshaNo")
    public void setTxtShokisaiHokenshaNo(TextBoxCode txtShokisaiHokenshaNo) {
        this.txtShokisaiHokenshaNo=txtShokisaiHokenshaNo;
    }

    @JsonProperty("txtKoikiHokenshaNo")
    public TextBoxCode getTxtKoikiHokenshaNo() {
        return txtKoikiHokenshaNo;
    }

    @JsonProperty("txtKoikiHokenshaNo")
    public void setTxtKoikiHokenshaNo(TextBoxCode txtKoikiHokenshaNo) {
        this.txtKoikiHokenshaNo=txtKoikiHokenshaNo;
    }

}
