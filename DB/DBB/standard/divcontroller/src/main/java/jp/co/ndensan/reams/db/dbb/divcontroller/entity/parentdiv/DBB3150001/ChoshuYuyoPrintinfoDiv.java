package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;
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
 * ChoshuYuyoPrintinfo のクラスファイル
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class ChoshuYuyoPrintinfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pritPublish1")
    private pritPublish1Div pritPublish1;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
        return this.getPritPublish1().getLblPrintMessage();
    }

    @JsonIgnore
    public void setLblPrintMessage(Label lblPrintMessage) {
        this.getPritPublish1().setLblPrintMessage(lblPrintMessage);
    }

    @JsonIgnore
    public pritPublish2Div getPritPublish2() {
        return this.getPritPublish1().getPritPublish2();
    }

    @JsonIgnore
    public void setPritPublish2(pritPublish2Div pritPublish2) {
        this.getPritPublish1().setPritPublish2(pritPublish2);
    }

    // </editor-fold>
}
