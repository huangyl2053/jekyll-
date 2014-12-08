package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosaItakusakiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChosaItakusakiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToMentenanceChosaKikan")
    private Button btnToMentenanceChosaKikan;
    @JsonProperty("dgChosaItakusakiList")
    private DataGrid<dgChosaItakusakiList_Row> dgChosaItakusakiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToMentenanceChosaKikan")
    public Button getBtnToMentenanceChosaKikan() {
        return btnToMentenanceChosaKikan;
    }

    @JsonProperty("btnToMentenanceChosaKikan")
    public void setBtnToMentenanceChosaKikan(Button btnToMentenanceChosaKikan) {
        this.btnToMentenanceChosaKikan=btnToMentenanceChosaKikan;
    }

    @JsonProperty("dgChosaItakusakiList")
    public DataGrid<dgChosaItakusakiList_Row> getDgChosaItakusakiList() {
        return dgChosaItakusakiList;
    }

    @JsonProperty("dgChosaItakusakiList")
    public void setDgChosaItakusakiList(DataGrid<dgChosaItakusakiList_Row> dgChosaItakusakiList) {
        this.dgChosaItakusakiList=dgChosaItakusakiList;
    }

}
