package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosakekka1_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosakekka2_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosakekka3_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChosaKekkaShosai のクラスファイル
 *
 * @author 自動生成
 */
public class ChosaKekkaShosaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("dgChosakekka1")
    private DataGrid<dgChosakekka1_Row> dgChosakekka1;
    @JsonProperty("dgChosakekka2")
    private DataGrid<dgChosakekka2_Row> dgChosakekka2;
    @JsonProperty("dgChosakekka3")
    private DataGrid<dgChosakekka3_Row> dgChosakekka3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgChosakekka1")
    public DataGrid<dgChosakekka1_Row> getDgChosakekka1() {
        return dgChosakekka1;
    }

    @JsonProperty("dgChosakekka1")
    public void setDgChosakekka1(DataGrid<dgChosakekka1_Row> dgChosakekka1) {
        this.dgChosakekka1 = dgChosakekka1;
    }

    @JsonProperty("dgChosakekka2")
    public DataGrid<dgChosakekka2_Row> getDgChosakekka2() {
        return dgChosakekka2;
    }

    @JsonProperty("dgChosakekka2")
    public void setDgChosakekka2(DataGrid<dgChosakekka2_Row> dgChosakekka2) {
        this.dgChosakekka2 = dgChosakekka2;
    }

    @JsonProperty("dgChosakekka3")
    public DataGrid<dgChosakekka3_Row> getDgChosakekka3() {
        return dgChosakekka3;
    }

    @JsonProperty("dgChosakekka3")
    public void setDgChosakekka3(DataGrid<dgChosakekka3_Row> dgChosakekka3) {
        this.dgChosakekka3 = dgChosakekka3;
    }

}
