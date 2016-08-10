package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuseigenRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlKyufuseigen のクラスファイル
 *
 * @reamsid_L DBC-4350-050 liuxiaoyu
 */
public class pnlKyufuseigenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKyufuseigenRirekiList")
    private DataGrid<dgKyufuseigenRirekiList_Row> dgKyufuseigenRirekiList;
    @JsonProperty("pnlButton")
    private pnlButtonDiv pnlButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKyufuseigenRirekiList
     * @return dgKyufuseigenRirekiList
     */
    @JsonProperty("dgKyufuseigenRirekiList")
    public DataGrid<dgKyufuseigenRirekiList_Row> getDgKyufuseigenRirekiList() {
        return dgKyufuseigenRirekiList;
    }

    /*
     * setdgKyufuseigenRirekiList
     * @param dgKyufuseigenRirekiList dgKyufuseigenRirekiList
     */
    @JsonProperty("dgKyufuseigenRirekiList")
    public void setDgKyufuseigenRirekiList(DataGrid<dgKyufuseigenRirekiList_Row> dgKyufuseigenRirekiList) {
        this.dgKyufuseigenRirekiList = dgKyufuseigenRirekiList;
    }

    /*
     * getpnlButton
     * @return pnlButton
     */
    @JsonProperty("pnlButton")
    public pnlButtonDiv getPnlButton() {
        return pnlButton;
    }

    /*
     * setpnlButton
     * @param pnlButton pnlButton
     */
    @JsonProperty("pnlButton")
    public void setPnlButton(pnlButtonDiv pnlButton) {
        this.pnlButton = pnlButton;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnClose() {
        return this.getPnlButton().getBtnClose();
    }

    @JsonIgnore
    public void setBtnClose(Button btnClose) {
        this.getPnlButton().setBtnClose(btnClose);
    }

    // </editor-fold>
}
