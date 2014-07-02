package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0070011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0070011.dgSofuIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SofuIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class SofuIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSofuIchiran")
    private DataGrid<dgSofuIchiran_Row> dgSofuIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSofuIchiran")
    public DataGrid<dgSofuIchiran_Row> getDgSofuIchiran() {
        return dgSofuIchiran;
    }

    @JsonProperty("dgSofuIchiran")
    public void setDgSofuIchiran(DataGrid<dgSofuIchiran_Row> dgSofuIchiran) {
        this.dgSofuIchiran=dgSofuIchiran;
    }

}
