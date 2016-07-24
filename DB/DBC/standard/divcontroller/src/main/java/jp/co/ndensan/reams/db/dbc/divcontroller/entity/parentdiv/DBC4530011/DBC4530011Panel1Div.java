package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4530011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * DBC4530011Panel1 のクラスファイル
 *
 * @reamsid_L DBC-3360-010 xuxin
 */
public class DBC4530011Panel1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShiharaiBasho")
    private Label lblShiharaiBasho;
    @JsonProperty("txtShiharaiBasho")
    private TextBoxMultiLine txtShiharaiBasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShiharaiBasho
     * @return lblShiharaiBasho
     */
    @JsonProperty("lblShiharaiBasho")
    public Label getLblShiharaiBasho() {
        return lblShiharaiBasho;
    }

    /*
     * setlblShiharaiBasho
     * @param lblShiharaiBasho lblShiharaiBasho
     */
    @JsonProperty("lblShiharaiBasho")
    public void setLblShiharaiBasho(Label lblShiharaiBasho) {
        this.lblShiharaiBasho = lblShiharaiBasho;
    }

    /*
     * gettxtShiharaiBasho
     * @return txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public TextBoxMultiLine getTxtShiharaiBasho() {
        return txtShiharaiBasho;
    }

    /*
     * settxtShiharaiBasho
     * @param txtShiharaiBasho txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public void setTxtShiharaiBasho(TextBoxMultiLine txtShiharaiBasho) {
        this.txtShiharaiBasho = txtShiharaiBasho;
    }

    // </editor-fold>
}
