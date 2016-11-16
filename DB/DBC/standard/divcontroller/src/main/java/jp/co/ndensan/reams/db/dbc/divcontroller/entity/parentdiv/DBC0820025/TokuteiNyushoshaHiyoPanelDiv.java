package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuteiNyushoshaHiyoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiNyushoshaHiyoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
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
    @JsonProperty("panelTokutei")
    private panelTokuteiDiv panelTokutei;
    @JsonProperty("RowId")
    private RString RowId;

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
     * getpanelTokutei
     * @return panelTokutei
     */
    @JsonProperty("panelTokutei")
    public panelTokuteiDiv getPanelTokutei() {
        return panelTokutei;
    }

    /*
     * setpanelTokutei
     * @param panelTokutei panelTokutei
     */
    @JsonProperty("panelTokutei")
    public void setPanelTokutei(panelTokuteiDiv panelTokutei) {
        this.panelTokutei = panelTokutei;
    }

    /*
     * getRowId
     * @return RowId
     */
    @JsonProperty("RowId")
    public RString getRowId() {
        return RowId;
    }

    /*
     * setRowId
     * @param RowId RowId
     */
    @JsonProperty("RowId")
    public void setRowId(RString RowId) {
        this.RowId = RowId;
    }

    // </editor-fold>
}
