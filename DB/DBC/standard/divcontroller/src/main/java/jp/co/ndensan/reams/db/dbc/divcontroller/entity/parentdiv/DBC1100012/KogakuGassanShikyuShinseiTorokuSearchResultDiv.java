package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012;
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
 * KogakuGassanShikyuShinseiTorokuSearchResult のクラスファイル
 *
 * @reamsid_L DBC-2040-010 lihang
 */
public class KogakuGassanShikyuShinseiTorokuSearchResultDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTorokuSearchResult")
    private DataGrid<dgTorokuSearchResult_Row> dgTorokuSearchResult;
    @JsonProperty("btnSaikensaku")
    private Button btnSaikensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTorokuSearchResult
     * @return dgTorokuSearchResult
     */
    @JsonProperty("dgTorokuSearchResult")
    public DataGrid<dgTorokuSearchResult_Row> getDgTorokuSearchResult() {
        return dgTorokuSearchResult;
    }

    /*
     * setdgTorokuSearchResult
     * @param dgTorokuSearchResult dgTorokuSearchResult
     */
    @JsonProperty("dgTorokuSearchResult")
    public void setDgTorokuSearchResult(DataGrid<dgTorokuSearchResult_Row> dgTorokuSearchResult) {
        this.dgTorokuSearchResult = dgTorokuSearchResult;
    }

    /*
     * getbtnSaikensaku
     * @return btnSaikensaku
     */
    @JsonProperty("btnSaikensaku")
    public Button getBtnSaikensaku() {
        return btnSaikensaku;
    }

    /*
     * setbtnSaikensaku
     * @param btnSaikensaku btnSaikensaku
     */
    @JsonProperty("btnSaikensaku")
    public void setBtnSaikensaku(Button btnSaikensaku) {
        this.btnSaikensaku = btnSaikensaku;
    }

    // </editor-fold>
}
