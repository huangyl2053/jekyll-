package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pritPublish1 のクラスファイル
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class pritPublish1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblPrintMessage")
    private Label lblPrintMessage;
    @JsonProperty("pritPublish2")
    private pritPublish2Div pritPublish2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblPrintMessage
     * @return lblPrintMessage
     */
    @JsonProperty("lblPrintMessage")
    public Label getLblPrintMessage() {
        return lblPrintMessage;
    }

    /*
     * setlblPrintMessage
     * @param lblPrintMessage lblPrintMessage
     */
    @JsonProperty("lblPrintMessage")
    public void setLblPrintMessage(Label lblPrintMessage) {
        this.lblPrintMessage = lblPrintMessage;
    }

    /*
     * getpritPublish2
     * @return pritPublish2
     */
    @JsonProperty("pritPublish2")
    public pritPublish2Div getPritPublish2() {
        return pritPublish2;
    }

    /*
     * setpritPublish2
     * @param pritPublish2 pritPublish2
     */
    @JsonProperty("pritPublish2")
    public void setPritPublish2(pritPublish2Div pritPublish2) {
        this.pritPublish2 = pritPublish2;
    }

    // </editor-fold>
}
