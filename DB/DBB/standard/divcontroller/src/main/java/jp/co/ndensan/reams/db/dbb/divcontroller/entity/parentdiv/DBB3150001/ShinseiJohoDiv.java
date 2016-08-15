package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * ShinseiJoho のクラスファイル
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class ShinseiJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBoxDate txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBoxDate txtFukaNendo;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("btnYuyoShurui")
    private ButtonDialog btnYuyoShurui;
    @JsonProperty("txtYuyoShurui")
    private TextBox txtYuyoShurui;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;

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
    public TextBoxDate getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBoxDate txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBoxDate getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBoxDate txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * getbtnYuyoShurui
     * @return btnYuyoShurui
     */
    @JsonProperty("btnYuyoShurui")
    public ButtonDialog getBtnYuyoShurui() {
        return btnYuyoShurui;
    }

    /*
     * setbtnYuyoShurui
     * @param btnYuyoShurui btnYuyoShurui
     */
    @JsonProperty("btnYuyoShurui")
    public void setBtnYuyoShurui(ButtonDialog btnYuyoShurui) {
        this.btnYuyoShurui = btnYuyoShurui;
    }

    /*
     * gettxtYuyoShurui
     * @return txtYuyoShurui
     */
    @JsonProperty("txtYuyoShurui")
    public TextBox getTxtYuyoShurui() {
        return txtYuyoShurui;
    }

    /*
     * settxtYuyoShurui
     * @param txtYuyoShurui txtYuyoShurui
     */
    @JsonProperty("txtYuyoShurui")
    public void setTxtYuyoShurui(TextBox txtYuyoShurui) {
        this.txtYuyoShurui = txtYuyoShurui;
    }

    /*
     * gettxtShinseiRiyu
     * @return txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    /*
     * settxtShinseiRiyu
     * @param txtShinseiRiyu txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.txtShinseiRiyu = txtShinseiRiyu;
    }

    // </editor-fold>
}
