package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchGaitoshaGrid_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshaSearchGaitoshaPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaSearchGaitoshaPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaSelectButton")
    private Button HihokenshaSelectButton;
    @JsonProperty("HihokenshaSearchGaitoshaGrid")
    private DataGrid<HihokenshaSearchGaitoshaGrid_Row> HihokenshaSearchGaitoshaGrid;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaSelectButton")
    public Button getHihokenshaSelectButton() {
        return HihokenshaSelectButton;
    }

    @JsonProperty("HihokenshaSelectButton")
    public void setHihokenshaSelectButton(Button HihokenshaSelectButton) {
        this.HihokenshaSelectButton=HihokenshaSelectButton;
    }

    @JsonProperty("HihokenshaSearchGaitoshaGrid")
    public DataGrid<HihokenshaSearchGaitoshaGrid_Row> getHihokenshaSearchGaitoshaGrid() {
        return HihokenshaSearchGaitoshaGrid;
    }

    @JsonProperty("HihokenshaSearchGaitoshaGrid")
    public void setHihokenshaSearchGaitoshaGrid(DataGrid<HihokenshaSearchGaitoshaGrid_Row> HihokenshaSearchGaitoshaGrid) {
        this.HihokenshaSearchGaitoshaGrid=HihokenshaSearchGaitoshaGrid;
    }

}
