package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJokenInput のクラスファイル 
 * 
 * @reamsid_L DBE-3000-030  lijia
 * 
 */
public class KensakuJokenInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiIinCodeFrom")
    private TextBoxCode txtShinsakaiIinCodeFrom;
    @JsonProperty("txtShinsakaiIinCodeTo")
    private TextBoxCode txtShinsakaiIinCodeTo;
    @JsonProperty("txtShinsakaiIinName")
    private TextBox txtShinsakaiIinName;
    @JsonProperty("ddlSeibetsu")
    private DropDownList ddlSeibetsu;
    @JsonProperty("ddlShinsainShikakuCode")
    private DropDownList ddlShinsainShikakuCode;
    @JsonProperty("ccdHokensha")
    private HokenshaListDiv ccdHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiIinCodeFrom
     * @return txtShinsakaiIinCodeFrom
     */
    @JsonProperty("txtShinsakaiIinCodeFrom")
    public TextBoxCode getTxtShinsakaiIinCodeFrom() {
        return txtShinsakaiIinCodeFrom;
    }

    /*
     * settxtShinsakaiIinCodeFrom
     * @param txtShinsakaiIinCodeFrom txtShinsakaiIinCodeFrom
     */
    @JsonProperty("txtShinsakaiIinCodeFrom")
    public void setTxtShinsakaiIinCodeFrom(TextBoxCode txtShinsakaiIinCodeFrom) {
        this.txtShinsakaiIinCodeFrom = txtShinsakaiIinCodeFrom;
    }

    /*
     * gettxtShinsakaiIinCodeTo
     * @return txtShinsakaiIinCodeTo
     */
    @JsonProperty("txtShinsakaiIinCodeTo")
    public TextBoxCode getTxtShinsakaiIinCodeTo() {
        return txtShinsakaiIinCodeTo;
    }

    /*
     * settxtShinsakaiIinCodeTo
     * @param txtShinsakaiIinCodeTo txtShinsakaiIinCodeTo
     */
    @JsonProperty("txtShinsakaiIinCodeTo")
    public void setTxtShinsakaiIinCodeTo(TextBoxCode txtShinsakaiIinCodeTo) {
        this.txtShinsakaiIinCodeTo = txtShinsakaiIinCodeTo;
    }

    /*
     * gettxtShinsakaiIinName
     * @return txtShinsakaiIinName
     */
    @JsonProperty("txtShinsakaiIinName")
    public TextBox getTxtShinsakaiIinName() {
        return txtShinsakaiIinName;
    }

    /*
     * settxtShinsakaiIinName
     * @param txtShinsakaiIinName txtShinsakaiIinName
     */
    @JsonProperty("txtShinsakaiIinName")
    public void setTxtShinsakaiIinName(TextBox txtShinsakaiIinName) {
        this.txtShinsakaiIinName = txtShinsakaiIinName;
    }

    /*
     * getddlSeibetsu
     * @return ddlSeibetsu
     */
    @JsonProperty("ddlSeibetsu")
    public DropDownList getDdlSeibetsu() {
        return ddlSeibetsu;
    }

    /*
     * setddlSeibetsu
     * @param ddlSeibetsu ddlSeibetsu
     */
    @JsonProperty("ddlSeibetsu")
    public void setDdlSeibetsu(DropDownList ddlSeibetsu) {
        this.ddlSeibetsu = ddlSeibetsu;
    }

    /*
     * getddlShinsainShikakuCode
     * @return ddlShinsainShikakuCode
     */
    @JsonProperty("ddlShinsainShikakuCode")
    public DropDownList getDdlShinsainShikakuCode() {
        return ddlShinsainShikakuCode;
    }

    /*
     * setddlShinsainShikakuCode
     * @param ddlShinsainShikakuCode ddlShinsainShikakuCode
     */
    @JsonProperty("ddlShinsainShikakuCode")
    public void setDdlShinsainShikakuCode(DropDownList ddlShinsainShikakuCode) {
        this.ddlShinsainShikakuCode = ddlShinsainShikakuCode;
    }

    /*
     * getccdHokensha
     * @return ccdHokensha
     */
    @JsonProperty("ccdHokensha")
    public IHokenshaListDiv getCcdHokensha() {
        return ccdHokensha;
    }

    // </editor-fold>
}
