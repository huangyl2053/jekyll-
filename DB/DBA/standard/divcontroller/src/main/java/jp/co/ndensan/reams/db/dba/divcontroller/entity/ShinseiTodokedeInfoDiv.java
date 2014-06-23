package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgShinseishoTodokede_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinseiTodokedeInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiTodokedeInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinseishoTodokede")
    private DataGrid<dgShinseishoTodokede_Row> dgShinseishoTodokede;
    @JsonProperty("btnBackTodokedeInfo")
    private Button btnBackTodokedeInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShinseishoTodokede")
    public DataGrid<dgShinseishoTodokede_Row> getDgShinseishoTodokede() {
        return dgShinseishoTodokede;
    }

    @JsonProperty("dgShinseishoTodokede")
    public void setDgShinseishoTodokede(DataGrid<dgShinseishoTodokede_Row> dgShinseishoTodokede) {
        this.dgShinseishoTodokede=dgShinseishoTodokede;
    }

    @JsonProperty("btnBackTodokedeInfo")
    public Button getBtnBackTodokedeInfo() {
        return btnBackTodokedeInfo;
    }

    @JsonProperty("btnBackTodokedeInfo")
    public void setBtnBackTodokedeInfo(Button btnBackTodokedeInfo) {
        this.btnBackTodokedeInfo=btnBackTodokedeInfo;
    }

}
