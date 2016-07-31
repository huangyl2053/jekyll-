package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SofusakiGenJushoShuseiPanel のクラスファイル
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class SofusakiGenJushoShuseiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SofusakiNyuryokuPanel")
    private SofusakiNyuryokuPanelDiv SofusakiNyuryokuPanel;
    @JsonProperty("GenJushoNyuryokuPanel")
    private GenJushoNyuryokuPanelDiv GenJushoNyuryokuPanel;
    @JsonProperty("GenJushoPanel")
    private GenJushoPanelDiv GenJushoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSofusakiNyuryokuPanel
     * @return SofusakiNyuryokuPanel
     */
    @JsonProperty("SofusakiNyuryokuPanel")
    public SofusakiNyuryokuPanelDiv getSofusakiNyuryokuPanel() {
        return SofusakiNyuryokuPanel;
    }

    /*
     * setSofusakiNyuryokuPanel
     * @param SofusakiNyuryokuPanel SofusakiNyuryokuPanel
     */
    @JsonProperty("SofusakiNyuryokuPanel")
    public void setSofusakiNyuryokuPanel(SofusakiNyuryokuPanelDiv SofusakiNyuryokuPanel) {
        this.SofusakiNyuryokuPanel = SofusakiNyuryokuPanel;
    }

    /*
     * getGenJushoNyuryokuPanel
     * @return GenJushoNyuryokuPanel
     */
    @JsonProperty("GenJushoNyuryokuPanel")
    public GenJushoNyuryokuPanelDiv getGenJushoNyuryokuPanel() {
        return GenJushoNyuryokuPanel;
    }

    /*
     * setGenJushoNyuryokuPanel
     * @param GenJushoNyuryokuPanel GenJushoNyuryokuPanel
     */
    @JsonProperty("GenJushoNyuryokuPanel")
    public void setGenJushoNyuryokuPanel(GenJushoNyuryokuPanelDiv GenJushoNyuryokuPanel) {
        this.GenJushoNyuryokuPanel = GenJushoNyuryokuPanel;
    }

    /*
     * getGenJushoPanel
     * @return GenJushoPanel
     */
    @JsonProperty("GenJushoPanel")
    public GenJushoPanelDiv getGenJushoPanel() {
        return GenJushoPanel;
    }

    /*
     * setGenJushoPanel
     * @param GenJushoPanel GenJushoPanel
     */
    @JsonProperty("GenJushoPanel")
    public void setGenJushoPanel(GenJushoPanelDiv GenJushoPanel) {
        this.GenJushoPanel = GenJushoPanel;
    }

    // </editor-fold>
}
