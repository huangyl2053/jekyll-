package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810028;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KinkyujiShoteiShikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class KinkyujiShoteiShikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelCcd")
    private panelCcdDiv panelCcd;
    @JsonProperty("panelHead")
    private panelHeadDiv panelHead;
    @JsonProperty("panelKinkyujiShoteishikkan")
    private panelKinkyujiShoteishikkanDiv panelKinkyujiShoteishikkan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelCcd
     * @return panelCcd
     */
    @JsonProperty("panelCcd")
    public panelCcdDiv getPanelCcd() {
        return panelCcd;
    }

    /*
     * setpanelCcd
     * @param panelCcd panelCcd
     */
    @JsonProperty("panelCcd")
    public void setPanelCcd(panelCcdDiv panelCcd) {
        this.panelCcd = panelCcd;
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
     * getpanelKinkyujiShoteishikkan
     * @return panelKinkyujiShoteishikkan
     */
    @JsonProperty("panelKinkyujiShoteishikkan")
    public panelKinkyujiShoteishikkanDiv getPanelKinkyujiShoteishikkan() {
        return panelKinkyujiShoteishikkan;
    }

    /*
     * setpanelKinkyujiShoteishikkan
     * @param panelKinkyujiShoteishikkan panelKinkyujiShoteishikkan
     */
    @JsonProperty("panelKinkyujiShoteishikkan")
    public void setPanelKinkyujiShoteishikkan(panelKinkyujiShoteishikkanDiv panelKinkyujiShoteishikkan) {
        this.panelKinkyujiShoteishikkan = panelKinkyujiShoteishikkan;
    }

    // </editor-fold>
}
