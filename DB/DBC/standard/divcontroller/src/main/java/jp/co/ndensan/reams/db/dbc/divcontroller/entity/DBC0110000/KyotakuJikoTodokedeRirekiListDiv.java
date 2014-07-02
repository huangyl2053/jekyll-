package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuJikoTodokedeRirekiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuJikoTodokedeRirekiListDiv extends Panel {
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
    @JsonProperty("dgKyotakuJikoTodokedeRirekiList")
    private DataGrid<dgKyotakuJikoTodokedeRirekiList_Row> dgKyotakuJikoTodokedeRirekiList;

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

    @JsonProperty("dgKyotakuJikoTodokedeRirekiList")
    public DataGrid<dgKyotakuJikoTodokedeRirekiList_Row> getDgKyotakuJikoTodokedeRirekiList() {
        return dgKyotakuJikoTodokedeRirekiList;
    }

    @JsonProperty("dgKyotakuJikoTodokedeRirekiList")
    public void setDgKyotakuJikoTodokedeRirekiList(DataGrid<dgKyotakuJikoTodokedeRirekiList_Row> dgKyotakuJikoTodokedeRirekiList) {
        this.dgKyotakuJikoTodokedeRirekiList=dgKyotakuJikoTodokedeRirekiList;
    }

}
