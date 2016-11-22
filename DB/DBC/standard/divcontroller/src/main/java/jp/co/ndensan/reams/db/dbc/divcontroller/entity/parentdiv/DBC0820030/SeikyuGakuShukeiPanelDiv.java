package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyuGakuShukeiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuGakuShukeiPanelDiv extends Panel {
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
    @JsonProperty("panelSeikyugakuShukei")
    private panelSeikyugakuShukeiDiv panelSeikyugakuShukei;
    @JsonProperty("seiriNo")
    private RString seiriNo;

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
     * getpanelSeikyugakuShukei
     * @return panelSeikyugakuShukei
     */
    @JsonProperty("panelSeikyugakuShukei")
    public panelSeikyugakuShukeiDiv getPanelSeikyugakuShukei() {
        return panelSeikyugakuShukei;
    }

    /*
     * setpanelSeikyugakuShukei
     * @param panelSeikyugakuShukei panelSeikyugakuShukei
     */
    @JsonProperty("panelSeikyugakuShukei")
    public void setPanelSeikyugakuShukei(panelSeikyugakuShukeiDiv panelSeikyugakuShukei) {
        this.panelSeikyugakuShukei = panelSeikyugakuShukei;
    }

    /*
     * getseiriNo
     * @return seiriNo
     */
    @JsonProperty("seiriNo")
    public RString getSeiriNo() {
        return seiriNo;
    }

    /*
     * setseiriNo
     * @param seiriNo seiriNo
     */
    @JsonProperty("seiriNo")
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    // </editor-fold>
}
