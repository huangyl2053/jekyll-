package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JigyoshaNoInputGuide のクラスファイル 
 * 
 * 
 */
public class JigyoshaNoInputGuideDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKenCode")
    private DropDownList ddlKenCode;
    @JsonProperty("ddlJigyoshaKubun")
    private DropDownList ddlJigyoshaKubun;
    @JsonProperty("ddlToshiCode")
    private DropDownList ddlToshiCode;
    @JsonProperty("txtTsuban")
    private TextBox txtTsuban;
    @JsonProperty("txtCheckDigit")
    private TextBox txtCheckDigit;
    @JsonProperty("btnCalcCD")
    private Button btnCalcCD;
    @JsonProperty("btnJigyoshaNoDecide")
    private Button btnJigyoshaNoDecide;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKenCode
     * @return ddlKenCode
     */
    @JsonProperty("ddlKenCode")
    public DropDownList getDdlKenCode() {
        return ddlKenCode;
    }

    /*
     * setddlKenCode
     * @param ddlKenCode ddlKenCode
     */
    @JsonProperty("ddlKenCode")
    public void setDdlKenCode(DropDownList ddlKenCode) {
        this.ddlKenCode = ddlKenCode;
    }

    /*
     * getddlJigyoshaKubun
     * @return ddlJigyoshaKubun
     */
    @JsonProperty("ddlJigyoshaKubun")
    public DropDownList getDdlJigyoshaKubun() {
        return ddlJigyoshaKubun;
    }

    /*
     * setddlJigyoshaKubun
     * @param ddlJigyoshaKubun ddlJigyoshaKubun
     */
    @JsonProperty("ddlJigyoshaKubun")
    public void setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.ddlJigyoshaKubun = ddlJigyoshaKubun;
    }

    /*
     * getddlToshiCode
     * @return ddlToshiCode
     */
    @JsonProperty("ddlToshiCode")
    public DropDownList getDdlToshiCode() {
        return ddlToshiCode;
    }

    /*
     * setddlToshiCode
     * @param ddlToshiCode ddlToshiCode
     */
    @JsonProperty("ddlToshiCode")
    public void setDdlToshiCode(DropDownList ddlToshiCode) {
        this.ddlToshiCode = ddlToshiCode;
    }

    /*
     * gettxtTsuban
     * @return txtTsuban
     */
    @JsonProperty("txtTsuban")
    public TextBox getTxtTsuban() {
        return txtTsuban;
    }

    /*
     * settxtTsuban
     * @param txtTsuban txtTsuban
     */
    @JsonProperty("txtTsuban")
    public void setTxtTsuban(TextBox txtTsuban) {
        this.txtTsuban = txtTsuban;
    }

    /*
     * gettxtCheckDigit
     * @return txtCheckDigit
     */
    @JsonProperty("txtCheckDigit")
    public TextBox getTxtCheckDigit() {
        return txtCheckDigit;
    }

    /*
     * settxtCheckDigit
     * @param txtCheckDigit txtCheckDigit
     */
    @JsonProperty("txtCheckDigit")
    public void setTxtCheckDigit(TextBox txtCheckDigit) {
        this.txtCheckDigit = txtCheckDigit;
    }

    /*
     * getbtnCalcCD
     * @return btnCalcCD
     */
    @JsonProperty("btnCalcCD")
    public Button getBtnCalcCD() {
        return btnCalcCD;
    }

    /*
     * setbtnCalcCD
     * @param btnCalcCD btnCalcCD
     */
    @JsonProperty("btnCalcCD")
    public void setBtnCalcCD(Button btnCalcCD) {
        this.btnCalcCD = btnCalcCD;
    }

    /*
     * getbtnJigyoshaNoDecide
     * @return btnJigyoshaNoDecide
     */
    @JsonProperty("btnJigyoshaNoDecide")
    public Button getBtnJigyoshaNoDecide() {
        return btnJigyoshaNoDecide;
    }

    /*
     * setbtnJigyoshaNoDecide
     * @param btnJigyoshaNoDecide btnJigyoshaNoDecide
     */
    @JsonProperty("btnJigyoshaNoDecide")
    public void setBtnJigyoshaNoDecide(Button btnJigyoshaNoDecide) {
        this.btnJigyoshaNoDecide = btnJigyoshaNoDecide;
    }

    // </editor-fold>
}
