package jp.co.ndensan.reams.db.dba.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaDaichoRirekiPanel のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaDaichoRirekiPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("HihokenshaDaichoIdoRirekiGrid")
    private DataGrid<HihokenshaDaichoIdoRirekiGrid_Row> HihokenshaDaichoIdoRirekiGrid;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaDaichoIdoRirekiGrid")
    public DataGrid<HihokenshaDaichoIdoRirekiGrid_Row> getHihokenshaDaichoIdoRirekiGrid() {
        return HihokenshaDaichoIdoRirekiGrid;
    }

    @JsonProperty("HihokenshaDaichoIdoRirekiGrid")
    public void setHihokenshaDaichoIdoRirekiGrid(DataGrid<HihokenshaDaichoIdoRirekiGrid_Row> HihokenshaDaichoIdoRirekiGrid) {
        this.HihokenshaDaichoIdoRirekiGrid = HihokenshaDaichoIdoRirekiGrid;
    }

}
