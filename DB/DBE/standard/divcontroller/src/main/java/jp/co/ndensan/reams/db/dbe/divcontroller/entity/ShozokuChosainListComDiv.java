package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.IShozokuChosainListComDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShozokuChosainList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShozokuChosainListCom のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShozokuChosainListComDiv extends Panel implements IShozokuChosainListComDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShozokuChosainList")
    private DataGrid<dgShozokuChosainList_Row> dgShozokuChosainList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShozokuChosainList")
    public DataGrid<dgShozokuChosainList_Row> getDgShozokuChosainList() {
        return dgShozokuChosainList;
    }

    @JsonProperty("dgShozokuChosainList")
    public void setDgShozokuChosainList(DataGrid<dgShozokuChosainList_Row> dgShozokuChosainList) {
        this.dgShozokuChosainList=dgShozokuChosainList;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
