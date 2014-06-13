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
 * tplSogoShokaiJukyuGenmenGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplSogoShokaiJukyuGenmenGengakuDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSogoShokaiJukyuGenmenGengakuList")
    private DataGrid<dgSogoShokaiJukyuGenmenGengakuList_Row> dgSogoShokaiJukyuGenmenGengakuList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSogoShokaiJukyuGenmenGengakuList")
    public DataGrid<dgSogoShokaiJukyuGenmenGengakuList_Row> getDgSogoShokaiJukyuGenmenGengakuList() {
        return dgSogoShokaiJukyuGenmenGengakuList;
    }

    @JsonProperty("dgSogoShokaiJukyuGenmenGengakuList")
    public void setDgSogoShokaiJukyuGenmenGengakuList(DataGrid<dgSogoShokaiJukyuGenmenGengakuList_Row> dgSogoShokaiJukyuGenmenGengakuList) {
        this.dgSogoShokaiJukyuGenmenGengakuList=dgSogoShokaiJukyuGenmenGengakuList;
    }

}
