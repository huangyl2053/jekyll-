package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003.dghukainfo_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChoshuYuyoFukaRirekiAll のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuYuyoFukaRirekiAllDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dghukainfo")
    private DataGrid<dghukainfo_Row> dghukainfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dghukainfo")
    public DataGrid<dghukainfo_Row> getDghukainfo() {
        return dghukainfo;
    }

    @JsonProperty("dghukainfo")
    public void setDghukainfo(DataGrid<dghukainfo_Row> dghukainfo) {
        this.dghukainfo=dghukainfo;
    }

}
