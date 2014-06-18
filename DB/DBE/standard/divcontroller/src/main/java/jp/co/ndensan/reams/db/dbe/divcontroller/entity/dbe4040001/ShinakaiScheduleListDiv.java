package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001.dgShinakaiScheduleList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinakaiScheduleList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinakaiScheduleListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddShinsakai")
    private Button btnAddShinsakai;
    @JsonProperty("btnRemoveShinsakai")
    private Button btnRemoveShinsakai;
    @JsonProperty("dgShinakaiScheduleList")
    private DataGrid<dgShinakaiScheduleList_Row> dgShinakaiScheduleList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddShinsakai")
    public Button getBtnAddShinsakai() {
        return btnAddShinsakai;
    }

    @JsonProperty("btnAddShinsakai")
    public void setBtnAddShinsakai(Button btnAddShinsakai) {
        this.btnAddShinsakai=btnAddShinsakai;
    }

    @JsonProperty("btnRemoveShinsakai")
    public Button getBtnRemoveShinsakai() {
        return btnRemoveShinsakai;
    }

    @JsonProperty("btnRemoveShinsakai")
    public void setBtnRemoveShinsakai(Button btnRemoveShinsakai) {
        this.btnRemoveShinsakai=btnRemoveShinsakai;
    }

    @JsonProperty("dgShinakaiScheduleList")
    public DataGrid<dgShinakaiScheduleList_Row> getDgShinakaiScheduleList() {
        return dgShinakaiScheduleList;
    }

    @JsonProperty("dgShinakaiScheduleList")
    public void setDgShinakaiScheduleList(DataGrid<dgShinakaiScheduleList_Row> dgShinakaiScheduleList) {
        this.dgShinakaiScheduleList=dgShinakaiScheduleList;
    }

}
