package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
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
 * tplSogoShokaiJukyuNintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplSogoShokaiJukyuNinteiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSogoShokaiJukyuNinteiList")
    private DataGrid<dgSogoShokaiJukyuNinteiList_Row> dgSogoShokaiJukyuNinteiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSogoShokaiJukyuNinteiList")
    public DataGrid<dgSogoShokaiJukyuNinteiList_Row> getDgSogoShokaiJukyuNinteiList() {
        return dgSogoShokaiJukyuNinteiList;
    }

    @JsonProperty("dgSogoShokaiJukyuNinteiList")
    public void setDgSogoShokaiJukyuNinteiList(DataGrid<dgSogoShokaiJukyuNinteiList_Row> dgSogoShokaiJukyuNinteiList) {
        this.dgSogoShokaiJukyuNinteiList=dgSogoShokaiJukyuNinteiList;
    }

}
