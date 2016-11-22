package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikyuShinseiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikyuShinseiDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelUp")
    private panelUpDiv panelUp;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("panelHead")
    private panelHeadDiv panelHead;
    @JsonProperty("pnlShinsei")
    private pnlShinseiDiv pnlShinsei;
    @JsonProperty("CheckFlag")
    private RString CheckFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelUp
     * @return panelUp
     */
    @JsonProperty("panelUp")
    public panelUpDiv getPanelUp() {
        return panelUp;
    }

    /*
     * setpanelUp
     * @param panelUp panelUp
     */
    @JsonProperty("panelUp")
    public void setPanelUp(panelUpDiv panelUp) {
        this.panelUp = panelUp;
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
     * getpanelHead
     * @return panelHead
     */
    @JsonProperty("panelHead")
    public panelHeadDiv getPanelHead() {
        return panelHead;
    }

    /*
     * setpanelHead
     * @param panelHead panelHead
     */
    @JsonProperty("panelHead")
    public void setPanelHead(panelHeadDiv panelHead) {
        this.panelHead = panelHead;
    }

    /*
     * getpnlShinsei
     * @return pnlShinsei
     */
    @JsonProperty("pnlShinsei")
    public pnlShinseiDiv getPnlShinsei() {
        return pnlShinsei;
    }

    /*
     * setpnlShinsei
     * @param pnlShinsei pnlShinsei
     */
    @JsonProperty("pnlShinsei")
    public void setPnlShinsei(pnlShinseiDiv pnlShinsei) {
        this.pnlShinsei = pnlShinsei;
    }

    /*
     * getCheckFlag
     * @return CheckFlag
     */
    @JsonProperty("CheckFlag")
    public RString getCheckFlag() {
        return CheckFlag;
    }

    /*
     * setCheckFlag
     * @param CheckFlag CheckFlag
     */
    @JsonProperty("CheckFlag")
    public void setCheckFlag(RString CheckFlag) {
        this.CheckFlag = CheckFlag;
    }

    // </editor-fold>
}
