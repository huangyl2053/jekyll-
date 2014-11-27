package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110002.DataGrid3_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Panel4 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Panel4Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DataGrid3")
    private DataGrid<DataGrid3_Row> DataGrid3;
    @JsonProperty("Button3")
    private Button Button3;
    @JsonProperty("Button6")
    private Button Button6;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("DataGrid3")
    public DataGrid<DataGrid3_Row> getDataGrid3() {
        return DataGrid3;
    }

    @JsonProperty("DataGrid3")
    public void setDataGrid3(DataGrid<DataGrid3_Row> DataGrid3) {
        this.DataGrid3=DataGrid3;
    }

    @JsonProperty("Button3")
    public Button getButton3() {
        return Button3;
    }

    @JsonProperty("Button3")
    public void setButton3(Button Button3) {
        this.Button3=Button3;
    }

    @JsonProperty("Button6")
    public Button getButton6() {
        return Button6;
    }

    @JsonProperty("Button6")
    public void setButton6(Button Button6) {
        this.Button6=Button6;
    }

}
