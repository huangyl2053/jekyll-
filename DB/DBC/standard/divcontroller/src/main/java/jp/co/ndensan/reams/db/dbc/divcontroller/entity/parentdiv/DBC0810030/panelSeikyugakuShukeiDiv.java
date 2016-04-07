package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelSeikyugakuShukei のクラスファイル
 *
 * @reamsid_L DBC-1010-140 quxiaodong
 */
public class panelSeikyugakuShukeiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdSeikyugakushukei")
    private DataGrid<dgdSeikyugakushukei_Row> dgdSeikyugakushukei;
    @JsonProperty("panelSeikyuShokai")
    private panelSeikyuShokaiDiv panelSeikyuShokai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdSeikyugakushukei
     * @return dgdSeikyugakushukei
     */
    @JsonProperty("dgdSeikyugakushukei")
    public DataGrid<dgdSeikyugakushukei_Row> getDgdSeikyugakushukei() {
        return dgdSeikyugakushukei;
    }

    /*
     * setdgdSeikyugakushukei
     * @param dgdSeikyugakushukei dgdSeikyugakushukei
     */
    @JsonProperty("dgdSeikyugakushukei")
    public void setDgdSeikyugakushukei(DataGrid<dgdSeikyugakushukei_Row> dgdSeikyugakushukei) {
        this.dgdSeikyugakushukei = dgdSeikyugakushukei;
    }

    /*
     * getpanelSeikyuShokai
     * @return panelSeikyuShokai
     */
    @JsonProperty("panelSeikyuShokai")
    public panelSeikyuShokaiDiv getPanelSeikyuShokai() {
        return panelSeikyuShokai;
    }

    /*
     * setpanelSeikyuShokai
     * @param panelSeikyuShokai panelSeikyuShokai
     */
    @JsonProperty("panelSeikyuShokai")
    public void setPanelSeikyuShokai(panelSeikyuShokaiDiv panelSeikyuShokai) {
        this.panelSeikyuShokai = panelSeikyuShokai;
    }

    // </editor-fold>
}
