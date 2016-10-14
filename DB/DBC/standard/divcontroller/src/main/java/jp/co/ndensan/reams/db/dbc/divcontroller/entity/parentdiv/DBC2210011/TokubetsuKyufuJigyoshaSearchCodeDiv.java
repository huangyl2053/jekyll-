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
 * TokubetsuKyufuJigyoshaSearchCode のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuJigyoshaSearchCodeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSearchKenCode")
    private DropDownList ddlSearchKenCode;
    @JsonProperty("txtSearchJigyoshaKubun")
    private TextBoxCode txtSearchJigyoshaKubun;
    @JsonProperty("txtSearchGunshiCode")
    private TextBoxCode txtSearchGunshiCode;
    @JsonProperty("txtSearchRenban")
    private TextBoxCode txtSearchRenban;
    @JsonProperty("btnSearchCheckDigit")
    private Button btnSearchCheckDigit;
    @JsonProperty("txtSearchCheckDigit")
    private TextBoxCode txtSearchCheckDigit;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlSearchKenCode
     * @return ddlSearchKenCode
     */
    @JsonProperty("ddlSearchKenCode")
    public DropDownList getDdlSearchKenCode() {
        return ddlSearchKenCode;
    }

    /*
     * setddlSearchKenCode
     * @param ddlSearchKenCode ddlSearchKenCode
     */
    @JsonProperty("ddlSearchKenCode")
    public void setDdlSearchKenCode(DropDownList ddlSearchKenCode) {
        this.ddlSearchKenCode = ddlSearchKenCode;
    }

    /*
     * gettxtSearchJigyoshaKubun
     * @return txtSearchJigyoshaKubun
     */
    @JsonProperty("txtSearchJigyoshaKubun")
    public TextBoxCode getTxtSearchJigyoshaKubun() {
        return txtSearchJigyoshaKubun;
    }

    /*
     * settxtSearchJigyoshaKubun
     * @param txtSearchJigyoshaKubun txtSearchJigyoshaKubun
     */
    @JsonProperty("txtSearchJigyoshaKubun")
    public void setTxtSearchJigyoshaKubun(TextBoxCode txtSearchJigyoshaKubun) {
        this.txtSearchJigyoshaKubun = txtSearchJigyoshaKubun;
    }

    /*
     * gettxtSearchGunshiCode
     * @return txtSearchGunshiCode
     */
    @JsonProperty("txtSearchGunshiCode")
    public TextBoxCode getTxtSearchGunshiCode() {
        return txtSearchGunshiCode;
    }

    /*
     * settxtSearchGunshiCode
     * @param txtSearchGunshiCode txtSearchGunshiCode
     */
    @JsonProperty("txtSearchGunshiCode")
    public void setTxtSearchGunshiCode(TextBoxCode txtSearchGunshiCode) {
        this.txtSearchGunshiCode = txtSearchGunshiCode;
    }

    /*
     * gettxtSearchRenban
     * @return txtSearchRenban
     */
    @JsonProperty("txtSearchRenban")
    public TextBoxCode getTxtSearchRenban() {
        return txtSearchRenban;
    }

    /*
     * settxtSearchRenban
     * @param txtSearchRenban txtSearchRenban
     */
    @JsonProperty("txtSearchRenban")
    public void setTxtSearchRenban(TextBoxCode txtSearchRenban) {
        this.txtSearchRenban = txtSearchRenban;
    }

    /*
     * getbtnSearchCheckDigit
     * @return btnSearchCheckDigit
     */
    @JsonProperty("btnSearchCheckDigit")
    public Button getBtnSearchCheckDigit() {
        return btnSearchCheckDigit;
    }

    /*
     * setbtnSearchCheckDigit
     * @param btnSearchCheckDigit btnSearchCheckDigit
     */
    @JsonProperty("btnSearchCheckDigit")
    public void setBtnSearchCheckDigit(Button btnSearchCheckDigit) {
        this.btnSearchCheckDigit = btnSearchCheckDigit;
    }

    /*
     * gettxtSearchCheckDigit
     * @return txtSearchCheckDigit
     */
    @JsonProperty("txtSearchCheckDigit")
    public TextBoxCode getTxtSearchCheckDigit() {
        return txtSearchCheckDigit;
    }

    /*
     * settxtSearchCheckDigit
     * @param txtSearchCheckDigit txtSearchCheckDigit
     */
    @JsonProperty("txtSearchCheckDigit")
    public void setTxtSearchCheckDigit(TextBoxCode txtSearchCheckDigit) {
        this.txtSearchCheckDigit = txtSearchCheckDigit;
    }

    // </editor-fold>
}
