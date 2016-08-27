package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0250011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.IKyodoJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonReportPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * KyodoIdoRenrakuhyoTorokuMain のクラスファイル
 *
 * @reamsid_L DBC-1950-010 wangkanglei
 */
public class KyodoIdoRenrakuhyoTorokuMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyodoIdoRenrakuhyoTorokuPrint")
    private KyodoIdoRenrakuhyoTorokuPrintDiv KyodoIdoRenrakuhyoTorokuPrint;
    @JsonProperty("hdnFlag")
    private TextBox hdnFlag;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("KyodoIdoRenrakuhyoTorokuInfo")
    private KyodoJukyushaIdoRenrakuhyoDiv KyodoIdoRenrakuhyoTorokuInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyodoIdoRenrakuhyoTorokuPrint
     * @return KyodoIdoRenrakuhyoTorokuPrint
     */
    @JsonProperty("KyodoIdoRenrakuhyoTorokuPrint")
    public KyodoIdoRenrakuhyoTorokuPrintDiv getKyodoIdoRenrakuhyoTorokuPrint() {
        return KyodoIdoRenrakuhyoTorokuPrint;
    }

    /*
     * setKyodoIdoRenrakuhyoTorokuPrint
     * @param KyodoIdoRenrakuhyoTorokuPrint KyodoIdoRenrakuhyoTorokuPrint
     */
    @JsonProperty("KyodoIdoRenrakuhyoTorokuPrint")
    public void setKyodoIdoRenrakuhyoTorokuPrint(KyodoIdoRenrakuhyoTorokuPrintDiv KyodoIdoRenrakuhyoTorokuPrint) {
        this.KyodoIdoRenrakuhyoTorokuPrint = KyodoIdoRenrakuhyoTorokuPrint;
    }

    /*
     * gethdnFlag
     * @return hdnFlag
     */
    @JsonProperty("hdnFlag")
    public TextBox getHdnFlag() {
        return hdnFlag;
    }

    /*
     * sethdnFlag
     * @param hdnFlag hdnFlag
     */
    @JsonProperty("hdnFlag")
    public void setHdnFlag(TextBox hdnFlag) {
        this.hdnFlag = hdnFlag;
    }

    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public IKanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * getKyodoIdoRenrakuhyoTorokuInfo
     * @return KyodoIdoRenrakuhyoTorokuInfo
     */
    @JsonProperty("KyodoIdoRenrakuhyoTorokuInfo")
    public IKyodoJukyushaIdoRenrakuhyoDiv getKyodoIdoRenrakuhyoTorokuInfo() {
        return KyodoIdoRenrakuhyoTorokuInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkRensakuhyoHakko() {
        return this.getKyodoIdoRenrakuhyoTorokuPrint().getChkRensakuhyoHakko();
    }

    @JsonIgnore
    public void setChkRensakuhyoHakko(CheckBoxList chkRensakuhyoHakko) {
        this.getKyodoIdoRenrakuhyoTorokuPrint().setChkRensakuhyoHakko(chkRensakuhyoHakko);
    }

    @JsonIgnore
    public ButtonReportPublish getBtnReportPublish() {
        return this.getKyodoIdoRenrakuhyoTorokuPrint().getBtnReportPublish();
    }

    @JsonIgnore
    public void setBtnReportPublish(ButtonReportPublish btnReportPublish) {
        this.getKyodoIdoRenrakuhyoTorokuPrint().setBtnReportPublish(btnReportPublish);
    }

    // </editor-fold>
}
