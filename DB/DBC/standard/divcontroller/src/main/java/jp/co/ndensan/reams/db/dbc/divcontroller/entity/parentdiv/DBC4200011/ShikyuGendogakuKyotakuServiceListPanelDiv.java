package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011.dgShikyuGendogakuKyotakuService_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikyuGendogakuKyotakuServiceListPanel のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class ShikyuGendogakuKyotakuServiceListPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("btnAddKubunShikyuGendogaku")
    private Button btnAddKubunShikyuGendogaku;
    @JsonProperty("btnAddShuruiShikyuGendogaku")
    private Button btnAddShuruiShikyuGendogaku;
    @JsonProperty("dgShikyuGendogakuKyotakuService")
    private DataGrid<dgShikyuGendogakuKyotakuService_Row> dgShikyuGendogakuKyotakuService;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddKubunShikyuGendogaku")
    public Button getBtnAddKubunShikyuGendogaku() {
        return btnAddKubunShikyuGendogaku;
    }

    @JsonProperty("btnAddKubunShikyuGendogaku")
    public void setBtnAddKubunShikyuGendogaku(Button btnAddKubunShikyuGendogaku) {
        this.btnAddKubunShikyuGendogaku = btnAddKubunShikyuGendogaku;
    }

    @JsonProperty("btnAddShuruiShikyuGendogaku")
    public Button getBtnAddShuruiShikyuGendogaku() {
        return btnAddShuruiShikyuGendogaku;
    }

    @JsonProperty("btnAddShuruiShikyuGendogaku")
    public void setBtnAddShuruiShikyuGendogaku(Button btnAddShuruiShikyuGendogaku) {
        this.btnAddShuruiShikyuGendogaku = btnAddShuruiShikyuGendogaku;
    }

    @JsonProperty("dgShikyuGendogakuKyotakuService")
    public DataGrid<dgShikyuGendogakuKyotakuService_Row> getDgShikyuGendogakuKyotakuService() {
        return dgShikyuGendogakuKyotakuService;
    }

    @JsonProperty("dgShikyuGendogakuKyotakuService")
    public void setDgShikyuGendogakuKyotakuService(DataGrid<dgShikyuGendogakuKyotakuService_Row> dgShikyuGendogakuKyotakuService) {
        this.dgShikyuGendogakuKyotakuService = dgShikyuGendogakuKyotakuService;
    }

}
