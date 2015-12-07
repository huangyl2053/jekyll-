package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiIinJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsainCode")
    private TextBox txtShinsainCode;
    @JsonProperty("txtShinsaIinYMDFrom")
    private TextBoxDate txtShinsaIinYMDFrom;
    @JsonProperty("txtShinsaIinYMDTo")
    private TextBoxDate txtShinsaIinYMDTo;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtKanaShimei")
    private TextBox txtKanaShimei;
    @JsonProperty("txtBirthYMD")
    private TextBoxFlexibleDate txtBirthYMD;
    @JsonProperty("radSeibetsu")
    private RadioButton radSeibetsu;
    @JsonProperty("ddlShikakuCode")
    private DropDownList ddlShikakuCode;
    @JsonProperty("txtBiko")
    private TextBox txtBiko;
    @JsonProperty("ccdshinsakaiChikuCode")
    private CodeInputDiv ccdshinsakaiChikuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsainCode
     * @return txtShinsainCode
     */
    @JsonProperty("txtShinsainCode")
    public TextBox getTxtShinsainCode() {
        return txtShinsainCode;
    }

    /*
     * settxtShinsainCode
     * @param txtShinsainCode txtShinsainCode
     */
    @JsonProperty("txtShinsainCode")
    public void setTxtShinsainCode(TextBox txtShinsainCode) {
        this.txtShinsainCode = txtShinsainCode;
    }

    /*
     * gettxtShinsaIinYMDFrom
     * @return txtShinsaIinYMDFrom
     */
    @JsonProperty("txtShinsaIinYMDFrom")
    public TextBoxDate getTxtShinsaIinYMDFrom() {
        return txtShinsaIinYMDFrom;
    }

    /*
     * settxtShinsaIinYMDFrom
     * @param txtShinsaIinYMDFrom txtShinsaIinYMDFrom
     */
    @JsonProperty("txtShinsaIinYMDFrom")
    public void setTxtShinsaIinYMDFrom(TextBoxDate txtShinsaIinYMDFrom) {
        this.txtShinsaIinYMDFrom = txtShinsaIinYMDFrom;
    }

    /*
     * gettxtShinsaIinYMDTo
     * @return txtShinsaIinYMDTo
     */
    @JsonProperty("txtShinsaIinYMDTo")
    public TextBoxDate getTxtShinsaIinYMDTo() {
        return txtShinsaIinYMDTo;
    }

    /*
     * settxtShinsaIinYMDTo
     * @param txtShinsaIinYMDTo txtShinsaIinYMDTo
     */
    @JsonProperty("txtShinsaIinYMDTo")
    public void setTxtShinsaIinYMDTo(TextBoxDate txtShinsaIinYMDTo) {
        this.txtShinsaIinYMDTo = txtShinsaIinYMDTo;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtKanaShimei
     * @return txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    public TextBox getTxtKanaShimei() {
        return txtKanaShimei;
    }

    /*
     * settxtKanaShimei
     * @param txtKanaShimei txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    public void setTxtKanaShimei(TextBox txtKanaShimei) {
        this.txtKanaShimei = txtKanaShimei;
    }

    /*
     * gettxtBirthYMD
     * @return txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public TextBoxFlexibleDate getTxtBirthYMD() {
        return txtBirthYMD;
    }

    /*
     * settxtBirthYMD
     * @param txtBirthYMD txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public void setTxtBirthYMD(TextBoxFlexibleDate txtBirthYMD) {
        this.txtBirthYMD = txtBirthYMD;
    }

    /*
     * getradSeibetsu
     * @return radSeibetsu
     */
    @JsonProperty("radSeibetsu")
    public RadioButton getRadSeibetsu() {
        return radSeibetsu;
    }

    /*
     * setradSeibetsu
     * @param radSeibetsu radSeibetsu
     */
    @JsonProperty("radSeibetsu")
    public void setRadSeibetsu(RadioButton radSeibetsu) {
        this.radSeibetsu = radSeibetsu;
    }

    /*
     * getddlShikakuCode
     * @return ddlShikakuCode
     */
    @JsonProperty("ddlShikakuCode")
    public DropDownList getDdlShikakuCode() {
        return ddlShikakuCode;
    }

    /*
     * setddlShikakuCode
     * @param ddlShikakuCode ddlShikakuCode
     */
    @JsonProperty("ddlShikakuCode")
    public void setDdlShikakuCode(DropDownList ddlShikakuCode) {
        this.ddlShikakuCode = ddlShikakuCode;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBox getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBox txtBiko) {
        this.txtBiko = txtBiko;
    }

    /*
     * getccdshinsakaiChikuCode
     * @return ccdshinsakaiChikuCode
     */
    @JsonProperty("ccdshinsakaiChikuCode")
    public ICodeInputDiv getCcdshinsakaiChikuCode() {
        return ccdshinsakaiChikuCode;
    }

    // </editor-fold>
}
