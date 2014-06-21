package jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.dgIryoKikanList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IryoKikanList のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryoKikanListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToMentenanceIryoKikan")
    private Button btnToMentenanceIryoKikan;
    @JsonProperty("dgIryoKikanList")
    private DataGrid<dgIryoKikanList_Row> dgIryoKikanList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToMentenanceIryoKikan")
    public Button getBtnToMentenanceIryoKikan() {
        return btnToMentenanceIryoKikan;
    }

    @JsonProperty("btnToMentenanceIryoKikan")
    public void setBtnToMentenanceIryoKikan(Button btnToMentenanceIryoKikan) {
        this.btnToMentenanceIryoKikan=btnToMentenanceIryoKikan;
    }

    @JsonProperty("dgIryoKikanList")
    public DataGrid<dgIryoKikanList_Row> getDgIryoKikanList() {
        return dgIryoKikanList;
    }

    @JsonProperty("dgIryoKikanList")
    public void setDgIryoKikanList(DataGrid<dgIryoKikanList_Row> dgIryoKikanList) {
        this.dgIryoKikanList=dgIryoKikanList;
    }

}
