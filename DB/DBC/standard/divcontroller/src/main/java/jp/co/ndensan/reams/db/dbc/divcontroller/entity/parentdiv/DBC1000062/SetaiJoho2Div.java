package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * SetaiJoho2 のクラスファイル
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class SetaiJoho2Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetaiKazei")
    private TextBox txtSetaiKazei;
    @JsonProperty("txtTekiyoStartYM")
    private TextBoxFlexibleDate txtTekiyoStartYM;
    @JsonProperty("txtTekiyoEndYM")
    private TextBoxFlexibleDate txtTekiyoEndYM;
    @JsonProperty("ddlSanteiKijunGaku")
    private DropDownList ddlSanteiKijunGaku;
    @JsonProperty("txtKetteiYMD")
    private TextBoxFlexibleDate txtKetteiYMD;
    @JsonProperty("txtKetteiTsuchishoHakkoYMD")
    private TextBoxFlexibleDate txtKetteiTsuchishoHakkoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSetaiKazei
     * @return txtSetaiKazei
     */
    @JsonProperty("txtSetaiKazei")
    public TextBox getTxtSetaiKazei() {
        return txtSetaiKazei;
    }

    /*
     * settxtSetaiKazei
     * @param txtSetaiKazei txtSetaiKazei
     */
    @JsonProperty("txtSetaiKazei")
    public void setTxtSetaiKazei(TextBox txtSetaiKazei) {
        this.txtSetaiKazei = txtSetaiKazei;
    }

    /*
     * gettxtTekiyoStartYM
     * @return txtTekiyoStartYM
     */
    @JsonProperty("txtTekiyoStartYM")
    public TextBoxFlexibleDate getTxtTekiyoStartYM() {
        return txtTekiyoStartYM;
    }

    /*
     * settxtTekiyoStartYM
     * @param txtTekiyoStartYM txtTekiyoStartYM
     */
    @JsonProperty("txtTekiyoStartYM")
    public void setTxtTekiyoStartYM(TextBoxFlexibleDate txtTekiyoStartYM) {
        this.txtTekiyoStartYM = txtTekiyoStartYM;
    }

    /*
     * gettxtTekiyoEndYM
     * @return txtTekiyoEndYM
     */
    @JsonProperty("txtTekiyoEndYM")
    public TextBoxFlexibleDate getTxtTekiyoEndYM() {
        return txtTekiyoEndYM;
    }

    /*
     * settxtTekiyoEndYM
     * @param txtTekiyoEndYM txtTekiyoEndYM
     */
    @JsonProperty("txtTekiyoEndYM")
    public void setTxtTekiyoEndYM(TextBoxFlexibleDate txtTekiyoEndYM) {
        this.txtTekiyoEndYM = txtTekiyoEndYM;
    }

    /*
     * getddlSanteiKijunGaku
     * @return ddlSanteiKijunGaku
     */
    @JsonProperty("ddlSanteiKijunGaku")
    public DropDownList getDdlSanteiKijunGaku() {
        return ddlSanteiKijunGaku;
    }

    /*
     * setddlSanteiKijunGaku
     * @param ddlSanteiKijunGaku ddlSanteiKijunGaku
     */
    @JsonProperty("ddlSanteiKijunGaku")
    public void setDdlSanteiKijunGaku(DropDownList ddlSanteiKijunGaku) {
        this.ddlSanteiKijunGaku = ddlSanteiKijunGaku;
    }

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * gettxtKetteiTsuchishoHakkoYMD
     * @return txtKetteiTsuchishoHakkoYMD
     */
    @JsonProperty("txtKetteiTsuchishoHakkoYMD")
    public TextBoxFlexibleDate getTxtKetteiTsuchishoHakkoYMD() {
        return txtKetteiTsuchishoHakkoYMD;
    }

    /*
     * settxtKetteiTsuchishoHakkoYMD
     * @param txtKetteiTsuchishoHakkoYMD txtKetteiTsuchishoHakkoYMD
     */
    @JsonProperty("txtKetteiTsuchishoHakkoYMD")
    public void setTxtKetteiTsuchishoHakkoYMD(TextBoxFlexibleDate txtKetteiTsuchishoHakkoYMD) {
        this.txtKetteiTsuchishoHakkoYMD = txtKetteiTsuchishoHakkoYMD;
    }

    // </editor-fold>
}
