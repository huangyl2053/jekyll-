package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110002.DataGrid1_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Panel1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Panel1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DataGrid1")
    private DataGrid<DataGrid1_Row> DataGrid1;
    @JsonProperty("Button1")
    private Button Button1;
    @JsonProperty("Button2")
    private Button Button2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("DataGrid1")
    public DataGrid<DataGrid1_Row> getDataGrid1() {
        return DataGrid1;
    }

    @JsonProperty("DataGrid1")
    public void setDataGrid1(DataGrid<DataGrid1_Row> DataGrid1) {
        this.DataGrid1=DataGrid1;
    }

    @JsonProperty("Button1")
    public Button getButton1() {
        return Button1;
    }

    @JsonProperty("Button1")
    public void setButton1(Button Button1) {
        this.Button1=Button1;
    }

    @JsonProperty("Button2")
    public Button getButton2() {
        return Button2;
    }

    @JsonProperty("Button2")
    public void setButton2(Button Button2) {
        this.Button2=Button2;
    }

}
