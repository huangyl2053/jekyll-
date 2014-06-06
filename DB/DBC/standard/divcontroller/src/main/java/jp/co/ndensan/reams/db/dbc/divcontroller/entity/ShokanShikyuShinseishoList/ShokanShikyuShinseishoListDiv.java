package jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuShinseishoList;
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
 * ShokanShikyuShinseishoList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuShinseishoListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgShokanShikyuShinseishoList")
    private DataGrid<dgShokanShikyuShinseishoList_Row> dgShokanShikyuShinseishoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd=btnAdd;
    }

    @JsonProperty("dgShokanShikyuShinseishoList")
    public DataGrid<dgShokanShikyuShinseishoList_Row> getDgShokanShikyuShinseishoList() {
        return dgShokanShikyuShinseishoList;
    }

    @JsonProperty("dgShokanShikyuShinseishoList")
    public void setDgShokanShikyuShinseishoList(DataGrid<dgShokanShikyuShinseishoList_Row> dgShokanShikyuShinseishoList) {
        this.dgShokanShikyuShinseishoList=dgShokanShikyuShinseishoList;
    }

}
