package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceTeikyoShomeishoShinryoList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceTeikyoShomeishoShinryoList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceTeikyoShomeishoShinryoListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgServiceTeikyoShomeishoShinryoList")
    private DataGrid<dgServiceTeikyoShomeishoShinryoList_Row> dgServiceTeikyoShomeishoShinryoList;

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

    @JsonProperty("dgServiceTeikyoShomeishoShinryoList")
    public DataGrid<dgServiceTeikyoShomeishoShinryoList_Row> getDgServiceTeikyoShomeishoShinryoList() {
        return dgServiceTeikyoShomeishoShinryoList;
    }

    @JsonProperty("dgServiceTeikyoShomeishoShinryoList")
    public void setDgServiceTeikyoShomeishoShinryoList(DataGrid<dgServiceTeikyoShomeishoShinryoList_Row> dgServiceTeikyoShomeishoShinryoList) {
        this.dgServiceTeikyoShomeishoShinryoList=dgServiceTeikyoShomeishoShinryoList;
    }

}
