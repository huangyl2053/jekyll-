package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoHenkoMainPanel のクラスファイル
 *
 * @reamsid_L DBC-2101-010 quxiaodong
 */
public class JukyushaIdoRenrakuhyoHenkoMainPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoSearchConditionPanel")
    private JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv JukyushaIdoRenrakuhyoHenkoSearchConditionPanel;
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoSearchResultListPanel")
    private JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv JukyushaIdoRenrakuhyoHenkoSearchResultListPanel;
    @JsonProperty("btnResearch")
    private Button btnResearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel
     * @return JukyushaIdoRenrakuhyoHenkoSearchConditionPanel
     */
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoSearchConditionPanel")
    public JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel() {
        return JukyushaIdoRenrakuhyoHenkoSearchConditionPanel;
    }

    /*
     * setJukyushaIdoRenrakuhyoHenkoSearchConditionPanel
     * @param JukyushaIdoRenrakuhyoHenkoSearchConditionPanel JukyushaIdoRenrakuhyoHenkoSearchConditionPanel
     */
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoSearchConditionPanel")
    public void setJukyushaIdoRenrakuhyoHenkoSearchConditionPanel(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv JukyushaIdoRenrakuhyoHenkoSearchConditionPanel) {
        this.JukyushaIdoRenrakuhyoHenkoSearchConditionPanel = JukyushaIdoRenrakuhyoHenkoSearchConditionPanel;
    }

    /*
     * getJukyushaIdoRenrakuhyoHenkoSearchResultListPanel
     * @return JukyushaIdoRenrakuhyoHenkoSearchResultListPanel
     */
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoSearchResultListPanel")
    public JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv getJukyushaIdoRenrakuhyoHenkoSearchResultListPanel() {
        return JukyushaIdoRenrakuhyoHenkoSearchResultListPanel;
    }

    /*
     * setJukyushaIdoRenrakuhyoHenkoSearchResultListPanel
     * @param JukyushaIdoRenrakuhyoHenkoSearchResultListPanel JukyushaIdoRenrakuhyoHenkoSearchResultListPanel
     */
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoSearchResultListPanel")
    public void setJukyushaIdoRenrakuhyoHenkoSearchResultListPanel(JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv JukyushaIdoRenrakuhyoHenkoSearchResultListPanel) {
        this.JukyushaIdoRenrakuhyoHenkoSearchResultListPanel = JukyushaIdoRenrakuhyoHenkoSearchResultListPanel;
    }

    /*
     * getbtnResearch
     * @return btnResearch
     */
    @JsonProperty("btnResearch")
    public Button getBtnResearch() {
        return btnResearch;
    }

    /*
     * setbtnResearch
     * @param btnResearch btnResearch
     */
    @JsonProperty("btnResearch")
    public void setBtnResearch(Button btnResearch) {
        this.btnResearch = btnResearch;
    }

    // </editor-fold>
}
