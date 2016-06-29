package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * HonsanteiShoriNaiyo のクラスファイル
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonsanteiShoriNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBox txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("ddlChoteiKi")
    private DropDownList ddlChoteiKi;
    @JsonProperty("txtShotokuKijunYMD")
    private TextBoxDate txtShotokuKijunYMD;
    @JsonProperty("txtShikakuKijunYMD")
    private TextBoxDate txtShikakuKijunYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendo
     * @return txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * getddlChoteiKi
     * @return ddlChoteiKi
     */
    @JsonProperty("ddlChoteiKi")
    public DropDownList getDdlChoteiKi() {
        return ddlChoteiKi;
    }

    /*
     * setddlChoteiKi
     * @param ddlChoteiKi ddlChoteiKi
     */
    @JsonProperty("ddlChoteiKi")
    public void setDdlChoteiKi(DropDownList ddlChoteiKi) {
        this.ddlChoteiKi = ddlChoteiKi;
    }

    /*
     * gettxtShotokuKijunYMD
     * @return txtShotokuKijunYMD
     */
    @JsonProperty("txtShotokuKijunYMD")
    public TextBoxDate getTxtShotokuKijunYMD() {
        return txtShotokuKijunYMD;
    }

    /*
     * settxtShotokuKijunYMD
     * @param txtShotokuKijunYMD txtShotokuKijunYMD
     */
    @JsonProperty("txtShotokuKijunYMD")
    public void setTxtShotokuKijunYMD(TextBoxDate txtShotokuKijunYMD) {
        this.txtShotokuKijunYMD = txtShotokuKijunYMD;
    }

    /*
     * gettxtShikakuKijunYMD
     * @return txtShikakuKijunYMD
     */
    @JsonProperty("txtShikakuKijunYMD")
    public TextBoxDate getTxtShikakuKijunYMD() {
        return txtShikakuKijunYMD;
    }

    /*
     * settxtShikakuKijunYMD
     * @param txtShikakuKijunYMD txtShikakuKijunYMD
     */
    @JsonProperty("txtShikakuKijunYMD")
    public void setTxtShikakuKijunYMD(TextBoxDate txtShikakuKijunYMD) {
        this.txtShikakuKijunYMD = txtShikakuKijunYMD;
    }

    // </editor-fold>
}
