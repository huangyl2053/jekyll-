package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005;
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
 * mainPanel のクラスファイル
 *
 * @author 自動生成
 */
public class mainPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaChikuPanel")
    private ChosaChikuPanelDiv ChosaChikuPanel;
    @JsonProperty("NinteiChosainPanel")
    private NinteiChosainPanelDiv NinteiChosainPanel;
    @JsonProperty("NinteiChosainInput")
    private NinteiChosainInputDiv NinteiChosainInput;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosaChikuPanel
     * @return ChosaChikuPanel
     */
    @JsonProperty("ChosaChikuPanel")
    public ChosaChikuPanelDiv getChosaChikuPanel() {
        return ChosaChikuPanel;
    }

    /*
     * setChosaChikuPanel
     * @param ChosaChikuPanel ChosaChikuPanel
     */
    @JsonProperty("ChosaChikuPanel")
    public void setChosaChikuPanel(ChosaChikuPanelDiv ChosaChikuPanel) {
        this.ChosaChikuPanel = ChosaChikuPanel;
    }

    /*
     * getNinteiChosainPanel
     * @return NinteiChosainPanel
     */
    @JsonProperty("NinteiChosainPanel")
    public NinteiChosainPanelDiv getNinteiChosainPanel() {
        return NinteiChosainPanel;
    }

    /*
     * setNinteiChosainPanel
     * @param NinteiChosainPanel NinteiChosainPanel
     */
    @JsonProperty("NinteiChosainPanel")
    public void setNinteiChosainPanel(NinteiChosainPanelDiv NinteiChosainPanel) {
        this.NinteiChosainPanel = NinteiChosainPanel;
    }

    /*
     * getNinteiChosainInput
     * @return NinteiChosainInput
     */
    @JsonProperty("NinteiChosainInput")
    public NinteiChosainInputDiv getNinteiChosainInput() {
        return NinteiChosainInput;
    }

    /*
     * setNinteiChosainInput
     * @param NinteiChosainInput NinteiChosainInput
     */
    @JsonProperty("NinteiChosainInput")
    public void setNinteiChosainInput(NinteiChosainInputDiv NinteiChosainInput) {
        this.NinteiChosainInput = NinteiChosainInput;
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
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    // </editor-fold>
}
