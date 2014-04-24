package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgIryoHoken_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IryoHokenTabPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryoHokenTabPanelDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgIryoHoken")
    private DataGrid<dgIryoHoken_Row> dgIryoHoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgIryoHoken")
    public DataGrid<dgIryoHoken_Row> getDgIryoHoken() {
        return dgIryoHoken;
    }

    @JsonProperty("dgIryoHoken")
    public void setDgIryoHoken(DataGrid<dgIryoHoken_Row> dgIryoHoken) {
        this.dgIryoHoken=dgIryoHoken;
    }

}
