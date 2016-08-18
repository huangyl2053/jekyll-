package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;
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
 * Rireki のクラスファイル
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class RirekiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgKyotakuServiceIchiran")
    private DataGrid<dgKyotakuServiceIchiran_Row> dgKyotakuServiceIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgKyotakuServiceIchiran
     * @return dgKyotakuServiceIchiran
     */
    @JsonProperty("dgKyotakuServiceIchiran")
    public DataGrid<dgKyotakuServiceIchiran_Row> getDgKyotakuServiceIchiran() {
        return dgKyotakuServiceIchiran;
    }

    /*
     * setdgKyotakuServiceIchiran
     * @param dgKyotakuServiceIchiran dgKyotakuServiceIchiran
     */
    @JsonProperty("dgKyotakuServiceIchiran")
    public void setDgKyotakuServiceIchiran(DataGrid<dgKyotakuServiceIchiran_Row> dgKyotakuServiceIchiran) {
        this.dgKyotakuServiceIchiran = dgKyotakuServiceIchiran;
    }

    // </editor-fold>
}
