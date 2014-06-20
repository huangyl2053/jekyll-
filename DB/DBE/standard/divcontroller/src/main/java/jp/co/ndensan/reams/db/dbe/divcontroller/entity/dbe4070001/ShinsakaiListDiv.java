package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.dgShinsakaiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsakaiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinsakaiList")
    private DataGrid<dgShinsakaiList_Row> dgShinsakaiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShinsakaiList")
    public DataGrid<dgShinsakaiList_Row> getDgShinsakaiList() {
        return dgShinsakaiList;
    }

    @JsonProperty("dgShinsakaiList")
    public void setDgShinsakaiList(DataGrid<dgShinsakaiList_Row> dgShinsakaiList) {
        this.dgShinsakaiList=dgShinsakaiList;
    }

}
