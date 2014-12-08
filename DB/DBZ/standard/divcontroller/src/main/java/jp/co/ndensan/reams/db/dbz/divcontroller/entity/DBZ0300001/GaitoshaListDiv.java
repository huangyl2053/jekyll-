package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0300001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0300001.dgFukaGaitoshaList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GaitoshaList のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaitoshaListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukanendo")
    private TextBoxDate txtFukanendo;
    @JsonProperty("dgFukaGaitoshaList")
    private DataGrid<dgFukaGaitoshaList_Row> dgFukaGaitoshaList;
    @JsonProperty("btnReSearch")
    private Button btnReSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtFukanendo")
    public TextBoxDate getTxtFukanendo() {
        return txtFukanendo;
    }

    @JsonProperty("txtFukanendo")
    public void setTxtFukanendo(TextBoxDate txtFukanendo) {
        this.txtFukanendo=txtFukanendo;
    }

    @JsonProperty("dgFukaGaitoshaList")
    public DataGrid<dgFukaGaitoshaList_Row> getDgFukaGaitoshaList() {
        return dgFukaGaitoshaList;
    }

    @JsonProperty("dgFukaGaitoshaList")
    public void setDgFukaGaitoshaList(DataGrid<dgFukaGaitoshaList_Row> dgFukaGaitoshaList) {
        this.dgFukaGaitoshaList=dgFukaGaitoshaList;
    }

    @JsonProperty("btnReSearch")
    public Button getBtnReSearch() {
        return btnReSearch;
    }

    @JsonProperty("btnReSearch")
    public void setBtnReSearch(Button btnReSearch) {
        this.btnReSearch=btnReSearch;
    }

}
