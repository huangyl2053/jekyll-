package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0010001.dgdGaitoushaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GaitoshaSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaitoshaSentakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukanendo")
    private TextBoxDate txtFukanendo;
    @JsonProperty("dgdGaitoushaIchiran")
    private DataGrid<dgdGaitoushaIchiran_Row> dgdGaitoushaIchiran;
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

    @JsonProperty("dgdGaitoushaIchiran")
    public DataGrid<dgdGaitoushaIchiran_Row> getDgdGaitoushaIchiran() {
        return dgdGaitoushaIchiran;
    }

    @JsonProperty("dgdGaitoushaIchiran")
    public void setDgdGaitoushaIchiran(DataGrid<dgdGaitoushaIchiran_Row> dgdGaitoushaIchiran) {
        this.dgdGaitoushaIchiran=dgdGaitoushaIchiran;
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
