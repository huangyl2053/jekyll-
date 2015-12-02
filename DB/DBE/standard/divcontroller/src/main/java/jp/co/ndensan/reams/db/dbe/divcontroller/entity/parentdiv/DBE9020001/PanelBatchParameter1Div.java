package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * PanelBatchParameter1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelBatchParameter1Div extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
