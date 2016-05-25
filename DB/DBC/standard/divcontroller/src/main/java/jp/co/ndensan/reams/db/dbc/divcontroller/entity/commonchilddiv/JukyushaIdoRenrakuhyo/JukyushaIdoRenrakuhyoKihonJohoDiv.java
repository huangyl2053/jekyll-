package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoKihonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoKihonJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRenrakuhyoIdoDate")
    private TextBoxFlexibleDate txtRenrakuhyoIdoDate;
    @JsonProperty("radRenrakuhyoIdoKubun")
    private RadioButton radRenrakuhyoIdoKubun;
    @JsonProperty("ddlIdoJiyu")
    private DropDownList ddlIdoJiyu;
    @JsonProperty("txtRenrakuhyoHihoNo")
    private TextBoxCode txtRenrakuhyoHihoNo;
    @JsonProperty("txtRenrakuhyoHihoName")
    private TextBoxKana txtRenrakuhyoHihoName;
    @JsonProperty("txtHihoBirthday")
    private TextBoxFlexibleDate txtHihoBirthday;
    @JsonProperty("radHihoSex")
    private RadioButton radHihoSex;
    @JsonProperty("txtShikakuShutokuDate")
    private TextBoxFlexibleDate txtShikakuShutokuDate;
    @JsonProperty("txtShikakuSoshitsuDate")
    private TextBoxFlexibleDate txtShikakuSoshitsuDate;
    @JsonProperty("txtShokisaiHokenshaNo")
    private TextBoxCode txtShokisaiHokenshaNo;
    @JsonProperty("txtKoikiHokenshaNo")
    private TextBoxCode txtKoikiHokenshaNo;
    @JsonProperty("txtRenrakuhyoSendYM")
    private TextBoxFlexibleDate txtRenrakuhyoSendYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRenrakuhyoIdoDate
     * @return txtRenrakuhyoIdoDate
     */
    @JsonProperty("txtRenrakuhyoIdoDate")
    public TextBoxFlexibleDate getTxtRenrakuhyoIdoDate() {
        return txtRenrakuhyoIdoDate;
    }

    /*
     * settxtRenrakuhyoIdoDate
     * @param txtRenrakuhyoIdoDate txtRenrakuhyoIdoDate
     */
    @JsonProperty("txtRenrakuhyoIdoDate")
    public void setTxtRenrakuhyoIdoDate(TextBoxFlexibleDate txtRenrakuhyoIdoDate) {
        this.txtRenrakuhyoIdoDate = txtRenrakuhyoIdoDate;
    }

    /*
     * getradRenrakuhyoIdoKubun
     * @return radRenrakuhyoIdoKubun
     */
    @JsonProperty("radRenrakuhyoIdoKubun")
    public RadioButton getRadRenrakuhyoIdoKubun() {
        return radRenrakuhyoIdoKubun;
    }

    /*
     * setradRenrakuhyoIdoKubun
     * @param radRenrakuhyoIdoKubun radRenrakuhyoIdoKubun
     */
    @JsonProperty("radRenrakuhyoIdoKubun")
    public void setRadRenrakuhyoIdoKubun(RadioButton radRenrakuhyoIdoKubun) {
        this.radRenrakuhyoIdoKubun = radRenrakuhyoIdoKubun;
    }

    /*
     * getddlIdoJiyu
     * @return ddlIdoJiyu
     */
    @JsonProperty("ddlIdoJiyu")
    public DropDownList getDdlIdoJiyu() {
        return ddlIdoJiyu;
    }

    /*
     * setddlIdoJiyu
     * @param ddlIdoJiyu ddlIdoJiyu
     */
    @JsonProperty("ddlIdoJiyu")
    public void setDdlIdoJiyu(DropDownList ddlIdoJiyu) {
        this.ddlIdoJiyu = ddlIdoJiyu;
    }

    /*
     * gettxtRenrakuhyoHihoNo
     * @return txtRenrakuhyoHihoNo
     */
    @JsonProperty("txtRenrakuhyoHihoNo")
    public TextBoxCode getTxtRenrakuhyoHihoNo() {
        return txtRenrakuhyoHihoNo;
    }

    /*
     * settxtRenrakuhyoHihoNo
     * @param txtRenrakuhyoHihoNo txtRenrakuhyoHihoNo
     */
    @JsonProperty("txtRenrakuhyoHihoNo")
    public void setTxtRenrakuhyoHihoNo(TextBoxCode txtRenrakuhyoHihoNo) {
        this.txtRenrakuhyoHihoNo = txtRenrakuhyoHihoNo;
    }

    /*
     * gettxtRenrakuhyoHihoName
     * @return txtRenrakuhyoHihoName
     */
    @JsonProperty("txtRenrakuhyoHihoName")
    public TextBoxKana getTxtRenrakuhyoHihoName() {
        return txtRenrakuhyoHihoName;
    }

    /*
     * settxtRenrakuhyoHihoName
     * @param txtRenrakuhyoHihoName txtRenrakuhyoHihoName
     */
    @JsonProperty("txtRenrakuhyoHihoName")
    public void setTxtRenrakuhyoHihoName(TextBoxKana txtRenrakuhyoHihoName) {
        this.txtRenrakuhyoHihoName = txtRenrakuhyoHihoName;
    }

    /*
     * gettxtHihoBirthday
     * @return txtHihoBirthday
     */
    @JsonProperty("txtHihoBirthday")
    public TextBoxFlexibleDate getTxtHihoBirthday() {
        return txtHihoBirthday;
    }

    /*
     * settxtHihoBirthday
     * @param txtHihoBirthday txtHihoBirthday
     */
    @JsonProperty("txtHihoBirthday")
    public void setTxtHihoBirthday(TextBoxFlexibleDate txtHihoBirthday) {
        this.txtHihoBirthday = txtHihoBirthday;
    }

    /*
     * getradHihoSex
     * @return radHihoSex
     */
    @JsonProperty("radHihoSex")
    public RadioButton getRadHihoSex() {
        return radHihoSex;
    }

    /*
     * setradHihoSex
     * @param radHihoSex radHihoSex
     */
    @JsonProperty("radHihoSex")
    public void setRadHihoSex(RadioButton radHihoSex) {
        this.radHihoSex = radHihoSex;
    }

    /*
     * gettxtShikakuShutokuDate
     * @return txtShikakuShutokuDate
     */
    @JsonProperty("txtShikakuShutokuDate")
    public TextBoxFlexibleDate getTxtShikakuShutokuDate() {
        return txtShikakuShutokuDate;
    }

    /*
     * settxtShikakuShutokuDate
     * @param txtShikakuShutokuDate txtShikakuShutokuDate
     */
    @JsonProperty("txtShikakuShutokuDate")
    public void setTxtShikakuShutokuDate(TextBoxFlexibleDate txtShikakuShutokuDate) {
        this.txtShikakuShutokuDate = txtShikakuShutokuDate;
    }

    /*
     * gettxtShikakuSoshitsuDate
     * @return txtShikakuSoshitsuDate
     */
    @JsonProperty("txtShikakuSoshitsuDate")
    public TextBoxFlexibleDate getTxtShikakuSoshitsuDate() {
        return txtShikakuSoshitsuDate;
    }

    /*
     * settxtShikakuSoshitsuDate
     * @param txtShikakuSoshitsuDate txtShikakuSoshitsuDate
     */
    @JsonProperty("txtShikakuSoshitsuDate")
    public void setTxtShikakuSoshitsuDate(TextBoxFlexibleDate txtShikakuSoshitsuDate) {
        this.txtShikakuSoshitsuDate = txtShikakuSoshitsuDate;
    }

    /*
     * gettxtShokisaiHokenshaNo
     * @return txtShokisaiHokenshaNo
     */
    @JsonProperty("txtShokisaiHokenshaNo")
    public TextBoxCode getTxtShokisaiHokenshaNo() {
        return txtShokisaiHokenshaNo;
    }

    /*
     * settxtShokisaiHokenshaNo
     * @param txtShokisaiHokenshaNo txtShokisaiHokenshaNo
     */
    @JsonProperty("txtShokisaiHokenshaNo")
    public void setTxtShokisaiHokenshaNo(TextBoxCode txtShokisaiHokenshaNo) {
        this.txtShokisaiHokenshaNo = txtShokisaiHokenshaNo;
    }

    /*
     * gettxtKoikiHokenshaNo
     * @return txtKoikiHokenshaNo
     */
    @JsonProperty("txtKoikiHokenshaNo")
    public TextBoxCode getTxtKoikiHokenshaNo() {
        return txtKoikiHokenshaNo;
    }

    /*
     * settxtKoikiHokenshaNo
     * @param txtKoikiHokenshaNo txtKoikiHokenshaNo
     */
    @JsonProperty("txtKoikiHokenshaNo")
    public void setTxtKoikiHokenshaNo(TextBoxCode txtKoikiHokenshaNo) {
        this.txtKoikiHokenshaNo = txtKoikiHokenshaNo;
    }

    /*
     * gettxtRenrakuhyoSendYM
     * @return txtRenrakuhyoSendYM
     */
    @JsonProperty("txtRenrakuhyoSendYM")
    public TextBoxFlexibleDate getTxtRenrakuhyoSendYM() {
        return txtRenrakuhyoSendYM;
    }

    /*
     * settxtRenrakuhyoSendYM
     * @param txtRenrakuhyoSendYM txtRenrakuhyoSendYM
     */
    @JsonProperty("txtRenrakuhyoSendYM")
    public void setTxtRenrakuhyoSendYM(TextBoxFlexibleDate txtRenrakuhyoSendYM) {
        this.txtRenrakuhyoSendYM = txtRenrakuhyoSendYM;
    }

    // </editor-fold>
}
