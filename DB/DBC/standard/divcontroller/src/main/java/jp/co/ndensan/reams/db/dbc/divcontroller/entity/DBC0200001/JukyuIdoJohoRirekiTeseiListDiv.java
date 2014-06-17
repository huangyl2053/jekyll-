package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200001.dgJukyuIdoJohoRirekiTeseiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyuIdoJohoRirekiTeseiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyuIdoJohoRirekiTeseiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJukyuIdoJohoRirekiTeseiList")
    private DataGrid<dgJukyuIdoJohoRirekiTeseiList_Row> dgJukyuIdoJohoRirekiTeseiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJukyuIdoJohoRirekiTeseiList")
    public DataGrid<dgJukyuIdoJohoRirekiTeseiList_Row> getDgJukyuIdoJohoRirekiTeseiList() {
        return dgJukyuIdoJohoRirekiTeseiList;
    }

    @JsonProperty("dgJukyuIdoJohoRirekiTeseiList")
    public void setDgJukyuIdoJohoRirekiTeseiList(DataGrid<dgJukyuIdoJohoRirekiTeseiList_Row> dgJukyuIdoJohoRirekiTeseiList) {
        this.dgJukyuIdoJohoRirekiTeseiList=dgJukyuIdoJohoRirekiTeseiList;
    }

}
