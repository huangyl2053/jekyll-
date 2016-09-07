package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GemmenPrintinfo のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class GemmenPrintinfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PrintInfo")
    private PrintInfoDiv PrintInfo;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPrintInfo
     * @return PrintInfo
     */
    @JsonProperty("PrintInfo")
    public PrintInfoDiv getPrintInfo() {
        return PrintInfo;
    }

    /*
     * setPrintInfo
     * @param PrintInfo PrintInfo
     */
    @JsonProperty("PrintInfo")
    public void setPrintInfo(PrintInfoDiv PrintInfo) {
        this.PrintInfo = PrintInfo;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblPrintMessage() {
        return this.getPrintInfo().getLblPrintMessage();
    }

    @JsonIgnore
    public void setLblPrintMessage(Label lblPrintMessage) {
        this.getPrintInfo().setLblPrintMessage(lblPrintMessage);
    }

    @JsonIgnore
    public pritPublish1Div getPritPublish1() {
        return this.getPrintInfo().getPritPublish1();
    }

    @JsonIgnore
    public void setPritPublish1(pritPublish1Div pritPublish1) {
        this.getPrintInfo().setPritPublish1(pritPublish1);
    }

    @JsonIgnore
    public pritPublish2Div getPritPublish2() {
        return this.getPrintInfo().getPritPublish2();
    }

    @JsonIgnore
    public void setPritPublish2(pritPublish2Div pritPublish2) {
        this.getPrintInfo().setPritPublish2(pritPublish2);
    }

    @JsonIgnore
    public pritPublish3Div getPritPublish3() {
        return this.getPrintInfo().getPritPublish3();
    }

    @JsonIgnore
    public void setPritPublish3(pritPublish3Div pritPublish3) {
        this.getPrintInfo().setPritPublish3(pritPublish3);
    }

    @JsonIgnore
    public pritPublish4Div getPritPublish4() {
        return this.getPrintInfo().getPritPublish4();
    }

    @JsonIgnore
    public void setPritPublish4(pritPublish4Div pritPublish4) {
        this.getPrintInfo().setPritPublish4(pritPublish4);
    }

    // </editor-fold>
}
