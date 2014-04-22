package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShinseishoTodokedeGrid_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinseiInfoTabPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiInfoTabPanelDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinseishoTodokedeGrid")
    private DataGrid<ShinseishoTodokedeGrid_Row> ShinseishoTodokedeGrid;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShinseishoTodokedeGrid")
    public DataGrid<ShinseishoTodokedeGrid_Row> getShinseishoTodokedeGrid() {
        return ShinseishoTodokedeGrid;
    }

    @JsonProperty("ShinseishoTodokedeGrid")
    public void setShinseishoTodokedeGrid(DataGrid<ShinseishoTodokedeGrid_Row> ShinseishoTodokedeGrid) {
        this.ShinseishoTodokedeGrid=ShinseishoTodokedeGrid;
    }

}
