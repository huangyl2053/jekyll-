package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlKeteiJohoMsg のクラスファイル
 *
 * @author 自動生成
 */
public class PnlKeteiJohoMsgDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PnlTotal")
    private PnlTotalDiv PnlTotal;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPnlTotal
     * @return PnlTotal
     */
    @JsonProperty("PnlTotal")
    public PnlTotalDiv getPnlTotal() {
        return PnlTotal;
    }

    /*
     * setPnlTotal
     * @param PnlTotal PnlTotal
     */
    @JsonProperty("PnlTotal")
    public void setPnlTotal(PnlTotalDiv PnlTotal) {
        this.PnlTotal = PnlTotal;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KaigoCommonPanelDiv getKaigoCommonPanel() {
        return this.getPnlTotal().getKaigoCommonPanel();
    }

    @JsonIgnore
    public void setKaigoCommonPanel(KaigoCommonPanelDiv KaigoCommonPanel) {
        this.getPnlTotal().setKaigoCommonPanel(KaigoCommonPanel);
    }

    @JsonIgnore
    public PnlButtonDiv getPnlButton() {
        return this.getPnlTotal().getPnlButton();
    }

    @JsonIgnore
    public void setPnlButton(PnlButtonDiv PnlButton) {
        this.getPnlTotal().setPnlButton(PnlButton);
    }

    @JsonIgnore
    public Button getBtnShinseJoho() {
        return this.getPnlTotal().getPnlButton().getBtnShinseJoho();
    }

    @JsonIgnore
    public void setBtnShinseJoho(Button btnShinseJoho) {
        this.getPnlTotal().getPnlButton().setBtnShinseJoho(btnShinseJoho);
    }

    @JsonIgnore
    public Button getBtnKetteiJoho() {
        return this.getPnlTotal().getPnlButton().getBtnKetteiJoho();
    }

    @JsonIgnore
    public void setBtnKetteiJoho(Button btnKetteiJoho) {
        this.getPnlTotal().getPnlButton().setBtnKetteiJoho(btnKetteiJoho);
    }

    @JsonIgnore
    public YoguKonyuhiShikyuShinseiContentsPanelDiv getYoguKonyuhiShikyuShinseiContentsPanel() {
        return this.getPnlTotal().getYoguKonyuhiShikyuShinseiContentsPanel();
    }

    @JsonIgnore
    public void setYoguKonyuhiShikyuShinseiContentsPanel(YoguKonyuhiShikyuShinseiContentsPanelDiv YoguKonyuhiShikyuShinseiContentsPanel) {
        this.getPnlTotal().setYoguKonyuhiShikyuShinseiContentsPanel(YoguKonyuhiShikyuShinseiContentsPanel);
    }

    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdMessage() {
        return this.getPnlTotal().getCcdMessage();
    }

    // </editor-fold>
}
