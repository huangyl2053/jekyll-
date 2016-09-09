package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TorokuKanyRirekiuListPanel のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class TorokuKanyRirekiuListPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKanyuJohoTsuika")
    private Button btnKanyuJohoTsuika;
    @JsonProperty("dgTorokuKanyRirekiuList")
    private DataGrid<dgTorokuKanyRirekiuList_Row> dgTorokuKanyRirekiuList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKanyuJohoTsuika
     * @return btnKanyuJohoTsuika
     */
    @JsonProperty("btnKanyuJohoTsuika")
    public Button getBtnKanyuJohoTsuika() {
        return btnKanyuJohoTsuika;
    }

    /*
     * setbtnKanyuJohoTsuika
     * @param btnKanyuJohoTsuika btnKanyuJohoTsuika
     */
    @JsonProperty("btnKanyuJohoTsuika")
    public void setBtnKanyuJohoTsuika(Button btnKanyuJohoTsuika) {
        this.btnKanyuJohoTsuika = btnKanyuJohoTsuika;
    }

    /*
     * getdgTorokuKanyRirekiuList
     * @return dgTorokuKanyRirekiuList
     */
    @JsonProperty("dgTorokuKanyRirekiuList")
    public DataGrid<dgTorokuKanyRirekiuList_Row> getDgTorokuKanyRirekiuList() {
        return dgTorokuKanyRirekiuList;
    }

    /*
     * setdgTorokuKanyRirekiuList
     * @param dgTorokuKanyRirekiuList dgTorokuKanyRirekiuList
     */
    @JsonProperty("dgTorokuKanyRirekiuList")
    public void setDgTorokuKanyRirekiuList(DataGrid<dgTorokuKanyRirekiuList_Row> dgTorokuKanyRirekiuList) {
        this.dgTorokuKanyRirekiuList = dgTorokuKanyRirekiuList;
    }

    // </editor-fold>
}
