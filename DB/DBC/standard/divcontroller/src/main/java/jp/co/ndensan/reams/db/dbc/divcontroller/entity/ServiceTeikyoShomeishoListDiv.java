package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IServiceTeikyoShomeishoListDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceTeikyoShomeishoList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceTeikyoShomeishoList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceTeikyoShomeishoListDiv extends Panel implements IServiceTeikyoShomeishoListDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgServiceTeikyoShomeishoList")
    private DataGrid<dgServiceTeikyoShomeishoList_Row> dgServiceTeikyoShomeishoList;

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

    @JsonProperty("dgServiceTeikyoShomeishoList")
    public DataGrid<dgServiceTeikyoShomeishoList_Row> getDgServiceTeikyoShomeishoList() {
        return dgServiceTeikyoShomeishoList;
    }

    @JsonProperty("dgServiceTeikyoShomeishoList")
    public void setDgServiceTeikyoShomeishoList(DataGrid<dgServiceTeikyoShomeishoList_Row> dgServiceTeikyoShomeishoList) {
        this.dgServiceTeikyoShomeishoList=dgServiceTeikyoShomeishoList;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
