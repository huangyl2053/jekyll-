package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceKeikakuhi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceKeikakuhiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgServiceKeikakuhiFromH2104")
    private DataGrid<dgServiceKeikakuhiFromH2104_Row> dgServiceKeikakuhiFromH2104;
    @JsonProperty("dgServiceKeikakuhiToH2103")
    private DataGrid<dgServiceKeikakuhiToH2103_Row> dgServiceKeikakuhiToH2103;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgServiceKeikakuhiFromH2104")
    public DataGrid<dgServiceKeikakuhiFromH2104_Row> getDgServiceKeikakuhiFromH2104() {
        return dgServiceKeikakuhiFromH2104;
    }

    @JsonProperty("dgServiceKeikakuhiFromH2104")
    public void setDgServiceKeikakuhiFromH2104(DataGrid<dgServiceKeikakuhiFromH2104_Row> dgServiceKeikakuhiFromH2104) {
        this.dgServiceKeikakuhiFromH2104=dgServiceKeikakuhiFromH2104;
    }

    @JsonProperty("dgServiceKeikakuhiToH2103")
    public DataGrid<dgServiceKeikakuhiToH2103_Row> getDgServiceKeikakuhiToH2103() {
        return dgServiceKeikakuhiToH2103;
    }

    @JsonProperty("dgServiceKeikakuhiToH2103")
    public void setDgServiceKeikakuhiToH2103(DataGrid<dgServiceKeikakuhiToH2103_Row> dgServiceKeikakuhiToH2103) {
        this.dgServiceKeikakuhiToH2103=dgServiceKeikakuhiToH2103;
    }

}
