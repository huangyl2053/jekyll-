package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.dgSogoShokaiJukyuShisetsuNyushoList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplSogoShokaiJukyuShisetsuNyusho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplSogoShokaiJukyuShisetsuNyushoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSogoShokaiJukyuShisetsuNyushoList")
    private DataGrid<dgSogoShokaiJukyuShisetsuNyushoList_Row> dgSogoShokaiJukyuShisetsuNyushoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSogoShokaiJukyuShisetsuNyushoList")
    public DataGrid<dgSogoShokaiJukyuShisetsuNyushoList_Row> getDgSogoShokaiJukyuShisetsuNyushoList() {
        return dgSogoShokaiJukyuShisetsuNyushoList;
    }

    @JsonProperty("dgSogoShokaiJukyuShisetsuNyushoList")
    public void setDgSogoShokaiJukyuShisetsuNyushoList(DataGrid<dgSogoShokaiJukyuShisetsuNyushoList_Row> dgSogoShokaiJukyuShisetsuNyushoList) {
        this.dgSogoShokaiJukyuShisetsuNyushoList=dgSogoShokaiJukyuShisetsuNyushoList;
    }

}
