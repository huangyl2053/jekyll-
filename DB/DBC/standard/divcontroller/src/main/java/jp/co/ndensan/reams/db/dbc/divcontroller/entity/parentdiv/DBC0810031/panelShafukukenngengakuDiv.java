package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelShafukukenngengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShafukukenngengakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdShafukukeigenngaku")
    private DataGrid<dgdShafukukeigenngaku_Row> dgdShafukukeigenngaku;
    @JsonProperty("panelShakaiFukushiShokai")
    private panelShakaiFukushiShokaiDiv panelShakaiFukushiShokai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdShafukukeigenngaku
     * @return dgdShafukukeigenngaku
     */
    @JsonProperty("dgdShafukukeigenngaku")
    public DataGrid<dgdShafukukeigenngaku_Row> getDgdShafukukeigenngaku() {
        return dgdShafukukeigenngaku;
    }

    /*
     * setdgdShafukukeigenngaku
     * @param dgdShafukukeigenngaku dgdShafukukeigenngaku
     */
    @JsonProperty("dgdShafukukeigenngaku")
    public void setDgdShafukukeigenngaku(DataGrid<dgdShafukukeigenngaku_Row> dgdShafukukeigenngaku) {
        this.dgdShafukukeigenngaku = dgdShafukukeigenngaku;
    }

    /*
     * getpanelShakaiFukushiShokai
     * @return panelShakaiFukushiShokai
     */
    @JsonProperty("panelShakaiFukushiShokai")
    public panelShakaiFukushiShokaiDiv getPanelShakaiFukushiShokai() {
        return panelShakaiFukushiShokai;
    }

    /*
     * setpanelShakaiFukushiShokai
     * @param panelShakaiFukushiShokai panelShakaiFukushiShokai
     */
    @JsonProperty("panelShakaiFukushiShokai")
    public void setPanelShakaiFukushiShokai(panelShakaiFukushiShokaiDiv panelShakaiFukushiShokai) {
        this.panelShakaiFukushiShokai = panelShakaiFukushiShokai;
    }

    // </editor-fold>
}
