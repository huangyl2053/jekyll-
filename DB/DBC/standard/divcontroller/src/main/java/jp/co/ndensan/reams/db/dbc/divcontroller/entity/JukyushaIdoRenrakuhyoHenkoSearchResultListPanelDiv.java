package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyushaIdoRenrakuhyoHenkoSearchResultListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResult")
    private DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> dgJukyushaIdoRenrakuhyoHenkoSearchResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResult")
    public DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> getDgJukyushaIdoRenrakuhyoHenkoSearchResult() {
        return dgJukyushaIdoRenrakuhyoHenkoSearchResult;
    }

    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResult")
    public void setDgJukyushaIdoRenrakuhyoHenkoSearchResult(DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> dgJukyushaIdoRenrakuhyoHenkoSearchResult) {
        this.dgJukyushaIdoRenrakuhyoHenkoSearchResult=dgJukyushaIdoRenrakuhyoHenkoSearchResult;
    }

}
