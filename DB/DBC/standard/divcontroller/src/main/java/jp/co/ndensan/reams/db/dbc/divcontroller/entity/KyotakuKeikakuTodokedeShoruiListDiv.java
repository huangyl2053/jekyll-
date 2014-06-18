package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgShoruiJokyoList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuKeikakuTodokedeShoruiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuKeikakuTodokedeShoruiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShoruiJokyoList")
    private DataGrid<dgShoruiJokyoList_Row> dgShoruiJokyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShoruiJokyoList")
    public DataGrid<dgShoruiJokyoList_Row> getDgShoruiJokyoList() {
        return dgShoruiJokyoList;
    }

    @JsonProperty("dgShoruiJokyoList")
    public void setDgShoruiJokyoList(DataGrid<dgShoruiJokyoList_Row> dgShoruiJokyoList) {
        this.dgShoruiJokyoList=dgShoruiJokyoList;
    }

}
