package jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoNyushoList;
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
 * ServiceTeikyoShomeishoNyushoList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceTeikyoShomeishoNyushoListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgServiceTeikyoShomeishoNyushoList")
    private DataGrid<dgServiceTeikyoShomeishoNyushoList_Row> dgServiceTeikyoShomeishoNyushoList;

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

    @JsonProperty("dgServiceTeikyoShomeishoNyushoList")
    public DataGrid<dgServiceTeikyoShomeishoNyushoList_Row> getDgServiceTeikyoShomeishoNyushoList() {
        return dgServiceTeikyoShomeishoNyushoList;
    }

    @JsonProperty("dgServiceTeikyoShomeishoNyushoList")
    public void setDgServiceTeikyoShomeishoNyushoList(DataGrid<dgServiceTeikyoShomeishoNyushoList_Row> dgServiceTeikyoShomeishoNyushoList) {
        this.dgServiceTeikyoShomeishoNyushoList=dgServiceTeikyoShomeishoNyushoList;
    }

}
