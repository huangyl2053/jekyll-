package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlShokanHanteiKekka のクラスファイル
 *
 * @reamsid_L DBC-1030-140 panhe
 */
public class PnlShokanHanteiKekkaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelAtenaShikaku")
    private panelAtenaShikakuDiv panelAtenaShikaku;
    @JsonProperty("PnlShokanShinseiList")
    private PnlShokanShinseiListDiv PnlShokanShinseiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelAtenaShikaku
     * @return panelAtenaShikaku
     */
    @JsonProperty("panelAtenaShikaku")
    public panelAtenaShikakuDiv getPanelAtenaShikaku() {
        return panelAtenaShikaku;
    }

    /*
     * setpanelAtenaShikaku
     * @param panelAtenaShikaku panelAtenaShikaku
     */
    @JsonProperty("panelAtenaShikaku")
    public void setPanelAtenaShikaku(panelAtenaShikakuDiv panelAtenaShikaku) {
        this.panelAtenaShikaku = panelAtenaShikaku;
    }

    /*
     * getPnlShokanShinseiList
     * @return PnlShokanShinseiList
     */
    @JsonProperty("PnlShokanShinseiList")
    public PnlShokanShinseiListDiv getPnlShokanShinseiList() {
        return PnlShokanShinseiList;
    }

    /*
     * setPnlShokanShinseiList
     * @param PnlShokanShinseiList PnlShokanShinseiList
     */
    @JsonProperty("PnlShokanShinseiList")
    public void setPnlShokanShinseiList(PnlShokanShinseiListDiv PnlShokanShinseiList) {
        this.PnlShokanShinseiList = PnlShokanShinseiList;
    }

    // </editor-fold>
}
