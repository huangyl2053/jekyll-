package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShuruiShikyuGendogaku のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class ShuruiShikyuGendogakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("lblServicehiShurui")
    private Label lblServicehiShurui;
    @JsonProperty("lblServicehiHiritsu")
    private Label lblServicehiHiritsu;
    @JsonProperty("btnAddServicehiShurui")
    private Button btnAddServicehiShurui;
    @JsonProperty("btnAddServicehiHiritsu")
    private Button btnAddServicehiHiritsu;
    @JsonProperty("dgServicehiShurui")
    private DataGrid<dgServicehiShurui_Row> dgServicehiShurui;
    @JsonProperty("dgServicehiHiritsu")
    private DataGrid<dgServicehiHiritsu_Row> dgServicehiHiritsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblServicehiShurui")
    public Label getLblServicehiShurui() {
        return lblServicehiShurui;
    }

    @JsonProperty("lblServicehiShurui")
    public void setLblServicehiShurui(Label lblServicehiShurui) {
        this.lblServicehiShurui = lblServicehiShurui;
    }

    @JsonProperty("lblServicehiHiritsu")
    public Label getLblServicehiHiritsu() {
        return lblServicehiHiritsu;
    }

    @JsonProperty("lblServicehiHiritsu")
    public void setLblServicehiHiritsu(Label lblServicehiHiritsu) {
        this.lblServicehiHiritsu = lblServicehiHiritsu;
    }

    @JsonProperty("btnAddServicehiShurui")
    public Button getBtnAddServicehiShurui() {
        return btnAddServicehiShurui;
    }

    @JsonProperty("btnAddServicehiShurui")
    public void setBtnAddServicehiShurui(Button btnAddServicehiShurui) {
        this.btnAddServicehiShurui = btnAddServicehiShurui;
    }

    @JsonProperty("btnAddServicehiHiritsu")
    public Button getBtnAddServicehiHiritsu() {
        return btnAddServicehiHiritsu;
    }

    @JsonProperty("btnAddServicehiHiritsu")
    public void setBtnAddServicehiHiritsu(Button btnAddServicehiHiritsu) {
        this.btnAddServicehiHiritsu = btnAddServicehiHiritsu;
    }

    @JsonProperty("dgServicehiShurui")
    public DataGrid<dgServicehiShurui_Row> getDgServicehiShurui() {
        return dgServicehiShurui;
    }

    @JsonProperty("dgServicehiShurui")
    public void setDgServicehiShurui(DataGrid<dgServicehiShurui_Row> dgServicehiShurui) {
        this.dgServicehiShurui = dgServicehiShurui;
    }

    @JsonProperty("dgServicehiHiritsu")
    public DataGrid<dgServicehiHiritsu_Row> getDgServicehiHiritsu() {
        return dgServicehiHiritsu;
    }

    @JsonProperty("dgServicehiHiritsu")
    public void setDgServicehiHiritsu(DataGrid<dgServicehiHiritsu_Row> dgServicehiHiritsu) {
        this.dgServicehiHiritsu = dgServicehiHiritsu;
    }

}
