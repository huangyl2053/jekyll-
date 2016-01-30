package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKihonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelKyotaku")
    private panelKyotakuDiv panelKyotaku;
    @JsonProperty("hlFour")
    private HorizontalLine hlFour;
    @JsonProperty("panelServiceKikan")
    private panelServiceKikanDiv panelServiceKikan;
    @JsonProperty("panelShisetuNyutaisyoInfo")
    private panelShisetuNyutaisyoInfoDiv panelShisetuNyutaisyoInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelKyotaku
     * @return panelKyotaku
     */
    @JsonProperty("panelKyotaku")
    public panelKyotakuDiv getPanelKyotaku() {
        return panelKyotaku;
    }

    /*
     * setpanelKyotaku
     * @param panelKyotaku panelKyotaku
     */
    @JsonProperty("panelKyotaku")
    public void setPanelKyotaku(panelKyotakuDiv panelKyotaku) {
        this.panelKyotaku = panelKyotaku;
    }

    /*
     * gethlFour
     * @return hlFour
     */
    @JsonProperty("hlFour")
    public HorizontalLine getHlFour() {
        return hlFour;
    }

    /*
     * sethlFour
     * @param hlFour hlFour
     */
    @JsonProperty("hlFour")
    public void setHlFour(HorizontalLine hlFour) {
        this.hlFour = hlFour;
    }

    /*
     * getpanelServiceKikan
     * @return panelServiceKikan
     */
    @JsonProperty("panelServiceKikan")
    public panelServiceKikanDiv getPanelServiceKikan() {
        return panelServiceKikan;
    }

    /*
     * setpanelServiceKikan
     * @param panelServiceKikan panelServiceKikan
     */
    @JsonProperty("panelServiceKikan")
    public void setPanelServiceKikan(panelServiceKikanDiv panelServiceKikan) {
        this.panelServiceKikan = panelServiceKikan;
    }

    /*
     * getpanelShisetuNyutaisyoInfo
     * @return panelShisetuNyutaisyoInfo
     */
    @JsonProperty("panelShisetuNyutaisyoInfo")
    public panelShisetuNyutaisyoInfoDiv getPanelShisetuNyutaisyoInfo() {
        return panelShisetuNyutaisyoInfo;
    }

    /*
     * setpanelShisetuNyutaisyoInfo
     * @param panelShisetuNyutaisyoInfo panelShisetuNyutaisyoInfo
     */
    @JsonProperty("panelShisetuNyutaisyoInfo")
    public void setPanelShisetuNyutaisyoInfo(panelShisetuNyutaisyoInfoDiv panelShisetuNyutaisyoInfo) {
        this.panelShisetuNyutaisyoInfo = panelShisetuNyutaisyoInfo;
    }

    // </editor-fold>
}
