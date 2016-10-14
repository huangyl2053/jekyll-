package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuKyufuJigyoshaDetailCode のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuJigyoshaDetailCodeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKenCode")
    private DropDownList ddlKenCode;
    @JsonProperty("txtJigyoshaKubun")
    private TextBoxCode txtJigyoshaKubun;
    @JsonProperty("txtGunshiCode")
    private TextBoxCode txtGunshiCode;
    @JsonProperty("txtRenban")
    private TextBoxCode txtRenban;
    @JsonProperty("btnCheckDigit")
    private Button btnCheckDigit;
    @JsonProperty("txtCheckDigit")
    private TextBoxCode txtCheckDigit;

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
     * gettxtJigyoshaKubun
     * @return txtJigyoshaKubun
     */
    @JsonProperty("txtJigyoshaKubun")
    public TextBoxCode getTxtJigyoshaKubun() {
        return txtJigyoshaKubun;
    }

    /*
     * settxtJigyoshaKubun
     * @param txtJigyoshaKubun txtJigyoshaKubun
     */
    @JsonProperty("txtJigyoshaKubun")
    public void setTxtJigyoshaKubun(TextBoxCode txtJigyoshaKubun) {
        this.txtJigyoshaKubun = txtJigyoshaKubun;
    }

    /*
     * gettxtGunshiCode
     * @return txtGunshiCode
     */
    @JsonProperty("txtGunshiCode")
    public TextBoxCode getTxtGunshiCode() {
        return txtGunshiCode;
    }

    /*
     * settxtGunshiCode
     * @param txtGunshiCode txtGunshiCode
     */
    @JsonProperty("txtGunshiCode")
    public void setTxtGunshiCode(TextBoxCode txtGunshiCode) {
        this.txtGunshiCode = txtGunshiCode;
    }

    /*
     * gettxtRenban
     * @return txtRenban
     */
    @JsonProperty("txtRenban")
    public TextBoxCode getTxtRenban() {
        return txtRenban;
    }

    /*
     * settxtRenban
     * @param txtRenban txtRenban
     */
    @JsonProperty("txtRenban")
    public void setTxtRenban(TextBoxCode txtRenban) {
        this.txtRenban = txtRenban;
    }

    /*
     * getbtnCheckDigit
     * @return btnCheckDigit
     */
    @JsonProperty("btnCheckDigit")
    public Button getBtnCheckDigit() {
        return btnCheckDigit;
    }

    /*
     * setbtnCheckDigit
     * @param btnCheckDigit btnCheckDigit
     */
    @JsonProperty("btnCheckDigit")
    public void setBtnCheckDigit(Button btnCheckDigit) {
        this.btnCheckDigit = btnCheckDigit;
    }

    /*
     * gettxtCheckDigit
     * @return txtCheckDigit
     */
    @JsonProperty("txtCheckDigit")
    public TextBoxCode getTxtCheckDigit() {
        return txtCheckDigit;
    }

    /*
     * settxtCheckDigit
     * @param txtCheckDigit txtCheckDigit
     */
    @JsonProperty("txtCheckDigit")
    public void setTxtCheckDigit(TextBoxCode txtCheckDigit) {
        this.txtCheckDigit = txtCheckDigit;
    }

    // </editor-fold>
}
