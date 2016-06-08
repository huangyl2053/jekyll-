package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
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
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("btnYuyoShurui")
    private Button btnYuyoShurui;
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
    public Button getBtnYuyoShurui() {
        return btnYuyoShurui;
    }

    /*
     * setbtnYuyoShurui
     * @param btnYuyoShurui btnYuyoShurui
     */
    @JsonProperty("btnYuyoShurui")
    public void setBtnYuyoShurui(Button btnYuyoShurui) {
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
