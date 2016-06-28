package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShichosonIchiran のクラスファイル
 *
 * 画面設計_DBBGM51005_所得情報アップロード
 *
 * @reamsid_L DBB-1730-010 yangchenbing
 */
public class ShichosonIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DataGrid1")
    private DataGrid<DataGrid1_Row> DataGrid1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDataGrid1
     * @return DataGrid1
     */
    @JsonProperty("DataGrid1")
    public DataGrid<DataGrid1_Row> getDataGrid1() {
        return DataGrid1;
    }

    /*
     * setDataGrid1
     * @param DataGrid1 DataGrid1
     */
    @JsonProperty("DataGrid1")
    public void setDataGrid1(DataGrid<DataGrid1_Row> DataGrid1) {
        this.DataGrid1 = DataGrid1;
    }

    // </editor-fold>
}
