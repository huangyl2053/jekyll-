package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgRirekiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuKeikakuTodokedeRirekiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuKeikakuTodokedeRirekiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTodokedeNew")
    private Button btnTodokedeNew;
    @JsonProperty("btnTodokedeModify")
    private Button btnTodokedeModify;
    @JsonProperty("dgRirekiList")
    private DataGrid<dgRirekiList_Row> dgRirekiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnTodokedeNew")
    public Button getBtnTodokedeNew() {
        return btnTodokedeNew;
    }

    @JsonProperty("btnTodokedeNew")
    public void setBtnTodokedeNew(Button btnTodokedeNew) {
        this.btnTodokedeNew=btnTodokedeNew;
    }

    @JsonProperty("btnTodokedeModify")
    public Button getBtnTodokedeModify() {
        return btnTodokedeModify;
    }

    @JsonProperty("btnTodokedeModify")
    public void setBtnTodokedeModify(Button btnTodokedeModify) {
        this.btnTodokedeModify=btnTodokedeModify;
    }

    @JsonProperty("dgRirekiList")
    public DataGrid<dgRirekiList_Row> getDgRirekiList() {
        return dgRirekiList;
    }

    @JsonProperty("dgRirekiList")
    public void setDgRirekiList(DataGrid<dgRirekiList_Row> dgRirekiList) {
        this.dgRirekiList=dgRirekiList;
    }

}
