package jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShinryoListH1503;
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
 * ServiceTeikyoShomeishoShinryoListH1503 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceTeikyoShomeishoShinryoListH1503Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgServiceTeikyoShomeishoShinryoListH1503")
    private DataGrid<dgServiceTeikyoShomeishoShinryoListH1503_Row> dgServiceTeikyoShomeishoShinryoListH1503;

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

    @JsonProperty("dgServiceTeikyoShomeishoShinryoListH1503")
    public DataGrid<dgServiceTeikyoShomeishoShinryoListH1503_Row> getDgServiceTeikyoShomeishoShinryoListH1503() {
        return dgServiceTeikyoShomeishoShinryoListH1503;
    }

    @JsonProperty("dgServiceTeikyoShomeishoShinryoListH1503")
    public void setDgServiceTeikyoShomeishoShinryoListH1503(DataGrid<dgServiceTeikyoShomeishoShinryoListH1503_Row> dgServiceTeikyoShomeishoShinryoListH1503) {
        this.dgServiceTeikyoShomeishoShinryoListH1503=dgServiceTeikyoShomeishoShinryoListH1503;
    }

}
