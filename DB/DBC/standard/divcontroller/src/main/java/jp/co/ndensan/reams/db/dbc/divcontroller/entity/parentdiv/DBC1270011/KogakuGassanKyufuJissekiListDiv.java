package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1270011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuGassanKyufuJissekiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuGassanKyufuJissekiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CheckBoxList1")
    private CheckBoxList CheckBoxList1;
    @JsonProperty("DataGrid1")
    private DataGrid<DataGrid1_Row> DataGrid1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getCheckBoxList1
     * @return CheckBoxList1
     */
    @JsonProperty("CheckBoxList1")
    public CheckBoxList getCheckBoxList1() {
        return CheckBoxList1;
    }

    /*
     * setCheckBoxList1
     * @param CheckBoxList1 CheckBoxList1
     */
    @JsonProperty("CheckBoxList1")
    public void setCheckBoxList1(CheckBoxList CheckBoxList1) {
        this.CheckBoxList1 = CheckBoxList1;
    }

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
