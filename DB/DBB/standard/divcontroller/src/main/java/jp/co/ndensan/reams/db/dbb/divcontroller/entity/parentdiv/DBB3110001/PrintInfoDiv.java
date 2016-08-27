package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PrintInfo のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class PrintInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblPrintMessage")
    private Label lblPrintMessage;
    @JsonProperty("pritPublish1")
    private pritPublish1Div pritPublish1;
    @JsonProperty("pritPublish2")
    private pritPublish2Div pritPublish2;
    @JsonProperty("pritPublish3")
    private pritPublish3Div pritPublish3;
    @JsonProperty("pritPublish4")
    private pritPublish4Div pritPublish4;

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
     * getpritPublish1
     * @return pritPublish1
     */
    @JsonProperty("pritPublish1")
    public pritPublish1Div getPritPublish1() {
        return pritPublish1;
    }

    /*
     * setpritPublish1
     * @param pritPublish1 pritPublish1
     */
    @JsonProperty("pritPublish1")
    public void setPritPublish1(pritPublish1Div pritPublish1) {
        this.pritPublish1 = pritPublish1;
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

    /*
     * getpritPublish3
     * @return pritPublish3
     */
    @JsonProperty("pritPublish3")
    public pritPublish3Div getPritPublish3() {
        return pritPublish3;
    }

    /*
     * setpritPublish3
     * @param pritPublish3 pritPublish3
     */
    @JsonProperty("pritPublish3")
    public void setPritPublish3(pritPublish3Div pritPublish3) {
        this.pritPublish3 = pritPublish3;
    }

    /*
     * getpritPublish4
     * @return pritPublish4
     */
    @JsonProperty("pritPublish4")
    public pritPublish4Div getPritPublish4() {
        return pritPublish4;
    }

    /*
     * setpritPublish4
     * @param pritPublish4 pritPublish4
     */
    @JsonProperty("pritPublish4")
    public void setPritPublish4(pritPublish4Div pritPublish4) {
        this.pritPublish4 = pritPublish4;
    }

    // </editor-fold>
}
