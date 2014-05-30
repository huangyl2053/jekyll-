package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceTeikyoShomeishoShokujiListH1503_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceTeikyoShomeishoShokujiListH1503 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceTeikyoShomeishoShokujiListH1503Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgServiceTeikyoShomeishoShokujiListH1503")
    private DataGrid<dgServiceTeikyoShomeishoShokujiListH1503_Row> dgServiceTeikyoShomeishoShokujiListH1503;

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

    @JsonProperty("dgServiceTeikyoShomeishoShokujiListH1503")
    public DataGrid<dgServiceTeikyoShomeishoShokujiListH1503_Row> getDgServiceTeikyoShomeishoShokujiListH1503() {
        return dgServiceTeikyoShomeishoShokujiListH1503;
    }

    @JsonProperty("dgServiceTeikyoShomeishoShokujiListH1503")
    public void setDgServiceTeikyoShomeishoShokujiListH1503(DataGrid<dgServiceTeikyoShomeishoShokujiListH1503_Row> dgServiceTeikyoShomeishoShokujiListH1503) {
        this.dgServiceTeikyoShomeishoShokujiListH1503=dgServiceTeikyoShomeishoShokujiListH1503;
    }

}
