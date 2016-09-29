package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IryohiKojyoItiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryohiKojyoItiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AddButton")
    private Button AddButton;
    @JsonProperty("ClearButton")
    private Button ClearButton;
    @JsonProperty("IryohiKojyoItiranDataGrid")
    private DataGrid<IryohiKojyoItiranDataGrid_Row> IryohiKojyoItiranDataGrid;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAddButton
     * @return AddButton
     */
    @JsonProperty("AddButton")
    public Button getAddButton() {
        return AddButton;
    }

    /*
     * setAddButton
     * @param AddButton AddButton
     */
    @JsonProperty("AddButton")
    public void setAddButton(Button AddButton) {
        this.AddButton = AddButton;
    }

    /*
     * getClearButton
     * @return ClearButton
     */
    @JsonProperty("ClearButton")
    public Button getClearButton() {
        return ClearButton;
    }

    /*
     * setClearButton
     * @param ClearButton ClearButton
     */
    @JsonProperty("ClearButton")
    public void setClearButton(Button ClearButton) {
        this.ClearButton = ClearButton;
    }

    /*
     * getIryohiKojyoItiranDataGrid
     * @return IryohiKojyoItiranDataGrid
     */
    @JsonProperty("IryohiKojyoItiranDataGrid")
    public DataGrid<IryohiKojyoItiranDataGrid_Row> getIryohiKojyoItiranDataGrid() {
        return IryohiKojyoItiranDataGrid;
    }

    /*
     * setIryohiKojyoItiranDataGrid
     * @param IryohiKojyoItiranDataGrid IryohiKojyoItiranDataGrid
     */
    @JsonProperty("IryohiKojyoItiranDataGrid")
    public void setIryohiKojyoItiranDataGrid(DataGrid<IryohiKojyoItiranDataGrid_Row> IryohiKojyoItiranDataGrid) {
        this.IryohiKojyoItiranDataGrid = IryohiKojyoItiranDataGrid;
    }

    // </editor-fold>
}
