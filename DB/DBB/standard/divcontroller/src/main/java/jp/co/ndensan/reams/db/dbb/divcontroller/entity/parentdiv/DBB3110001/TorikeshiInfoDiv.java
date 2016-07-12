package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * TorikeshiInfo のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class TorikeshiInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorikeshiYMD")
    private TextBoxDate txtTorikeshiYMD;
    @JsonProperty("btnTorikeshiShurui")
    private Button btnTorikeshiShurui;
    @JsonProperty("txtTorikeshiShurui")
    private TextBox txtTorikeshiShurui;
    @JsonProperty("txtTorikeshiRiyu")
    private TextBoxMultiLine txtTorikeshiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTorikeshiYMD
     * @return txtTorikeshiYMD
     */
    @JsonProperty("txtTorikeshiYMD")
    public TextBoxDate getTxtTorikeshiYMD() {
        return txtTorikeshiYMD;
    }

    /*
     * settxtTorikeshiYMD
     * @param txtTorikeshiYMD txtTorikeshiYMD
     */
    @JsonProperty("txtTorikeshiYMD")
    public void setTxtTorikeshiYMD(TextBoxDate txtTorikeshiYMD) {
        this.txtTorikeshiYMD = txtTorikeshiYMD;
    }

    /*
     * getbtnTorikeshiShurui
     * @return btnTorikeshiShurui
     */
    @JsonProperty("btnTorikeshiShurui")
    public Button getBtnTorikeshiShurui() {
        return btnTorikeshiShurui;
    }

    /*
     * setbtnTorikeshiShurui
     * @param btnTorikeshiShurui btnTorikeshiShurui
     */
    @JsonProperty("btnTorikeshiShurui")
    public void setBtnTorikeshiShurui(Button btnTorikeshiShurui) {
        this.btnTorikeshiShurui = btnTorikeshiShurui;
    }

    /*
     * gettxtTorikeshiShurui
     * @return txtTorikeshiShurui
     */
    @JsonProperty("txtTorikeshiShurui")
    public TextBox getTxtTorikeshiShurui() {
        return txtTorikeshiShurui;
    }

    /*
     * settxtTorikeshiShurui
     * @param txtTorikeshiShurui txtTorikeshiShurui
     */
    @JsonProperty("txtTorikeshiShurui")
    public void setTxtTorikeshiShurui(TextBox txtTorikeshiShurui) {
        this.txtTorikeshiShurui = txtTorikeshiShurui;
    }

    /*
     * gettxtTorikeshiRiyu
     * @return txtTorikeshiRiyu
     */
    @JsonProperty("txtTorikeshiRiyu")
    public TextBoxMultiLine getTxtTorikeshiRiyu() {
        return txtTorikeshiRiyu;
    }

    /*
     * settxtTorikeshiRiyu
     * @param txtTorikeshiRiyu txtTorikeshiRiyu
     */
    @JsonProperty("txtTorikeshiRiyu")
    public void setTxtTorikeshiRiyu(TextBoxMultiLine txtTorikeshiRiyu) {
        this.txtTorikeshiRiyu = txtTorikeshiRiyu;
    }

    // </editor-fold>
}
