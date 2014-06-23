package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceCode_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceCodeListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceCodeListPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddRow")
    private Button btnAddRow;
    @JsonProperty("dgServiceCode")
    private DataGrid<dgServiceCode_Row> dgServiceCode;
    @JsonProperty("btnSave")
    private Button btnSave;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddRow")
    public Button getBtnAddRow() {
        return btnAddRow;
    }

    @JsonProperty("btnAddRow")
    public void setBtnAddRow(Button btnAddRow) {
        this.btnAddRow=btnAddRow;
    }

    @JsonProperty("dgServiceCode")
    public DataGrid<dgServiceCode_Row> getDgServiceCode() {
        return dgServiceCode;
    }

    @JsonProperty("dgServiceCode")
    public void setDgServiceCode(DataGrid<dgServiceCode_Row> dgServiceCode) {
        this.dgServiceCode=dgServiceCode;
    }

    @JsonProperty("btnSave")
    public Button getBtnSave() {
        return btnSave;
    }

    @JsonProperty("btnSave")
    public void setBtnSave(Button btnSave) {
        this.btnSave=btnSave;
    }

}
