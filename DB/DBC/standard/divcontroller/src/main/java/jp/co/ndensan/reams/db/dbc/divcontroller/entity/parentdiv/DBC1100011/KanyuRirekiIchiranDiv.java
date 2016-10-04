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
 * KanyuRirekiIchiran のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KanyuRirekiIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddKanyuRireki")
    private Button btnAddKanyuRireki;
    @JsonProperty("dgKanyuRirekiIchiran")
    private DataGrid<dgKanyuRirekiIchiran_Row> dgKanyuRirekiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddKanyuRireki
     * @return btnAddKanyuRireki
     */
    @JsonProperty("btnAddKanyuRireki")
    public Button getBtnAddKanyuRireki() {
        return btnAddKanyuRireki;
    }

    /*
     * setbtnAddKanyuRireki
     * @param btnAddKanyuRireki btnAddKanyuRireki
     */
    @JsonProperty("btnAddKanyuRireki")
    public void setBtnAddKanyuRireki(Button btnAddKanyuRireki) {
        this.btnAddKanyuRireki = btnAddKanyuRireki;
    }

    /*
     * getdgKanyuRirekiIchiran
     * @return dgKanyuRirekiIchiran
     */
    @JsonProperty("dgKanyuRirekiIchiran")
    public DataGrid<dgKanyuRirekiIchiran_Row> getDgKanyuRirekiIchiran() {
        return dgKanyuRirekiIchiran;
    }

    /*
     * setdgKanyuRirekiIchiran
     * @param dgKanyuRirekiIchiran dgKanyuRirekiIchiran
     */
    @JsonProperty("dgKanyuRirekiIchiran")
    public void setDgKanyuRirekiIchiran(DataGrid<dgKanyuRirekiIchiran_Row> dgKanyuRirekiIchiran) {
        this.dgKanyuRirekiIchiran = dgKanyuRirekiIchiran;
    }

    // </editor-fold>
}
