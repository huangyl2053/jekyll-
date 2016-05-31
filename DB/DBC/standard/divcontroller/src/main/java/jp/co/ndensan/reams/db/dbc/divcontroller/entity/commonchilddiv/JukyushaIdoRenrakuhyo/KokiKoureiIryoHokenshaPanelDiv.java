package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KokiKoureiIryoHokenshaPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokiKoureiIryoHokenshaPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokiKoureiPanel")
    private KokiKoureiPanelDiv KokiKoureiPanel;
    @JsonProperty("KokuhoPanel")
    private KokuhoPanelDiv KokuhoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokiKoureiPanel
     * @return KokiKoureiPanel
     */
    @JsonProperty("KokiKoureiPanel")
    public KokiKoureiPanelDiv getKokiKoureiPanel() {
        return KokiKoureiPanel;
    }

    /*
     * setKokiKoureiPanel
     * @param KokiKoureiPanel KokiKoureiPanel
     */
    @JsonProperty("KokiKoureiPanel")
    public void setKokiKoureiPanel(KokiKoureiPanelDiv KokiKoureiPanel) {
        this.KokiKoureiPanel = KokiKoureiPanel;
    }

    /*
     * getKokuhoPanel
     * @return KokuhoPanel
     */
    @JsonProperty("KokuhoPanel")
    public KokuhoPanelDiv getKokuhoPanel() {
        return KokuhoPanel;
    }

    /*
     * setKokuhoPanel
     * @param KokuhoPanel KokuhoPanel
     */
    @JsonProperty("KokuhoPanel")
    public void setKokuhoPanel(KokuhoPanelDiv KokuhoPanel) {
        this.KokuhoPanel = KokuhoPanel;
    }

    // </editor-fold>
}
