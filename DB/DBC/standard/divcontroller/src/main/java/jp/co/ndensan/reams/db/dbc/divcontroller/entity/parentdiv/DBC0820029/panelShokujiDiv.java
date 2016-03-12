package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelShokuji のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShokujiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelShoikujiList")
    private panelShoikujiListDiv panelShoikujiList;
    @JsonProperty("PanelDetailGokei")
    private PanelDetailGokeiDiv PanelDetailGokei;
    @JsonProperty("panelDetail1")
    private panelDetail1Div panelDetail1;
    @JsonProperty("panelDetail2")
    private panelDetail2Div panelDetail2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelShoikujiList
     * @return panelShoikujiList
     */
    @JsonProperty("panelShoikujiList")
    public panelShoikujiListDiv getPanelShoikujiList() {
        return panelShoikujiList;
    }

    /*
     * setpanelShoikujiList
     * @param panelShoikujiList panelShoikujiList
     */
    @JsonProperty("panelShoikujiList")
    public void setPanelShoikujiList(panelShoikujiListDiv panelShoikujiList) {
        this.panelShoikujiList = panelShoikujiList;
    }

    /*
     * getPanelDetailGokei
     * @return PanelDetailGokei
     */
    @JsonProperty("PanelDetailGokei")
    public PanelDetailGokeiDiv getPanelDetailGokei() {
        return PanelDetailGokei;
    }

    /*
     * setPanelDetailGokei
     * @param PanelDetailGokei PanelDetailGokei
     */
    @JsonProperty("PanelDetailGokei")
    public void setPanelDetailGokei(PanelDetailGokeiDiv PanelDetailGokei) {
        this.PanelDetailGokei = PanelDetailGokei;
    }

    /*
     * getpanelDetail1
     * @return panelDetail1
     */
    @JsonProperty("panelDetail1")
    public panelDetail1Div getPanelDetail1() {
        return panelDetail1;
    }

    /*
     * setpanelDetail1
     * @param panelDetail1 panelDetail1
     */
    @JsonProperty("panelDetail1")
    public void setPanelDetail1(panelDetail1Div panelDetail1) {
        this.panelDetail1 = panelDetail1;
    }

    /*
     * getpanelDetail2
     * @return panelDetail2
     */
    @JsonProperty("panelDetail2")
    public panelDetail2Div getPanelDetail2() {
        return panelDetail2;
    }

    /*
     * setpanelDetail2
     * @param panelDetail2 panelDetail2
     */
    @JsonProperty("panelDetail2")
    public void setPanelDetail2(panelDetail2Div panelDetail2) {
        this.panelDetail2 = panelDetail2;
    }

    // </editor-fold>
}
