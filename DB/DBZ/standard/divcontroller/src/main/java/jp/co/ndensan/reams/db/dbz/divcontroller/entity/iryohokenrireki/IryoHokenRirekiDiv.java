package jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.dgIryoHokenRireki_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IryoHokenRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryoHokenRirekiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgIryoHokenRireki")
    private DataGrid<dgIryoHokenRireki_Row> dgIryoHokenRireki;
    @JsonProperty("mode")
    private RString mode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgIryoHokenRireki")
    public DataGrid<dgIryoHokenRireki_Row> getDgIryoHokenRireki() {
        return dgIryoHokenRireki;
    }

    @JsonProperty("dgIryoHokenRireki")
    public void setDgIryoHokenRireki(DataGrid<dgIryoHokenRireki_Row> dgIryoHokenRireki) {
        this.dgIryoHokenRireki=dgIryoHokenRireki;
    }

    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode=mode;
    }

}
