package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiIryoHokenKanyuInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiIryoHokenKanyuInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSogoShokaiHokenKanyuList")
    private DataGrid<dgSogoShokaiHokenKanyuList_Row> dgSogoShokaiHokenKanyuList;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSogoShokaiHokenKanyuList")
    public DataGrid<dgSogoShokaiHokenKanyuList_Row> getDgSogoShokaiHokenKanyuList() {
        return dgSogoShokaiHokenKanyuList;
    }

    @JsonProperty("dgSogoShokaiHokenKanyuList")
    public void setDgSogoShokaiHokenKanyuList(DataGrid<dgSogoShokaiHokenKanyuList_Row> dgSogoShokaiHokenKanyuList) {
        this.dgSogoShokaiHokenKanyuList=dgSogoShokaiHokenKanyuList;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

}
