package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigokanryomessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlTotal のクラスファイル
 *
 * @author 自動生成
 */
public class PnlTotalDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoCommonPanel")
    private KaigoCommonPanelDiv KaigoCommonPanel;
    @JsonProperty("PnlButton")
    private PnlButtonDiv PnlButton;
    @JsonProperty("YoguKonyuhiShikyuShinseiContentsPanel")
    private YoguKonyuhiShikyuShinseiContentsPanelDiv YoguKonyuhiShikyuShinseiContentsPanel;
    @JsonProperty("ccdMessage")
    private KaigoKanryoMessageDiv ccdMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoCommonPanel
     * @return KaigoCommonPanel
     */
    @JsonProperty("KaigoCommonPanel")
    public KaigoCommonPanelDiv getKaigoCommonPanel() {
        return KaigoCommonPanel;
    }

    /*
     * setKaigoCommonPanel
     * @param KaigoCommonPanel KaigoCommonPanel
     */
    @JsonProperty("KaigoCommonPanel")
    public void setKaigoCommonPanel(KaigoCommonPanelDiv KaigoCommonPanel) {
        this.KaigoCommonPanel = KaigoCommonPanel;
    }

    /*
     * getPnlButton
     * @return PnlButton
     */
    @JsonProperty("PnlButton")
    public PnlButtonDiv getPnlButton() {
        return PnlButton;
    }

    /*
     * setPnlButton
     * @param PnlButton PnlButton
     */
    @JsonProperty("PnlButton")
    public void setPnlButton(PnlButtonDiv PnlButton) {
        this.PnlButton = PnlButton;
    }

    /*
     * getYoguKonyuhiShikyuShinseiContentsPanel
     * @return YoguKonyuhiShikyuShinseiContentsPanel
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiContentsPanel")
    public YoguKonyuhiShikyuShinseiContentsPanelDiv getYoguKonyuhiShikyuShinseiContentsPanel() {
        return YoguKonyuhiShikyuShinseiContentsPanel;
    }

    /*
     * setYoguKonyuhiShikyuShinseiContentsPanel
     * @param YoguKonyuhiShikyuShinseiContentsPanel YoguKonyuhiShikyuShinseiContentsPanel
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiContentsPanel")
    public void setYoguKonyuhiShikyuShinseiContentsPanel(YoguKonyuhiShikyuShinseiContentsPanelDiv YoguKonyuhiShikyuShinseiContentsPanel) {
        this.YoguKonyuhiShikyuShinseiContentsPanel = YoguKonyuhiShikyuShinseiContentsPanel;
    }

    /*
     * getccdMessage
     * @return ccdMessage
     */
    @JsonProperty("ccdMessage")
    public IKaigoKanryoMessageDiv getCcdMessage() {
        return (IKaigoKanryoMessageDiv) ccdMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnShinseJoho() {
        return this.getPnlButton().getBtnShinseJoho();
    }

    @JsonIgnore
    public void setBtnShinseJoho(Button btnShinseJoho) {
        this.getPnlButton().setBtnShinseJoho(btnShinseJoho);
    }

    @JsonIgnore
    public Button getBtnKetteiJoho() {
        return this.getPnlButton().getBtnKetteiJoho();
    }

    @JsonIgnore
    public void setBtnKetteiJoho(Button btnKetteiJoho) {
        this.getPnlButton().setBtnKetteiJoho(btnKetteiJoho);
    }

    // </editor-fold>
}
