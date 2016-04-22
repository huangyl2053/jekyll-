package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001;
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
 * dvYoshikiNo のクラスファイル
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class dvYoshikiNoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShokanKaigo")
    private Button btnShokanKaigo;
    @JsonProperty("btnYobo")
    private Button btnYobo;
    @JsonProperty("dgYoshikiNo")
    private DataGrid<dgYoshikiNo_Row> dgYoshikiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShokanKaigo
     * @return btnShokanKaigo
     */
    @JsonProperty("btnShokanKaigo")
    public Button getBtnShokanKaigo() {
        return btnShokanKaigo;
    }

    /*
     * setbtnShokanKaigo
     * @param btnShokanKaigo btnShokanKaigo
     */
    @JsonProperty("btnShokanKaigo")
    public void setBtnShokanKaigo(Button btnShokanKaigo) {
        this.btnShokanKaigo = btnShokanKaigo;
    }

    /*
     * getbtnYobo
     * @return btnYobo
     */
    @JsonProperty("btnYobo")
    public Button getBtnYobo() {
        return btnYobo;
    }

    /*
     * setbtnYobo
     * @param btnYobo btnYobo
     */
    @JsonProperty("btnYobo")
    public void setBtnYobo(Button btnYobo) {
        this.btnYobo = btnYobo;
    }

    /*
     * getdgYoshikiNo
     * @return dgYoshikiNo
     */
    @JsonProperty("dgYoshikiNo")
    public DataGrid<dgYoshikiNo_Row> getDgYoshikiNo() {
        return dgYoshikiNo;
    }

    /*
     * setdgYoshikiNo
     * @param dgYoshikiNo dgYoshikiNo
     */
    @JsonProperty("dgYoshikiNo")
    public void setDgYoshikiNo(DataGrid<dgYoshikiNo_Row> dgYoshikiNo) {
        this.dgYoshikiNo = dgYoshikiNo;
    }

    // </editor-fold>
}
