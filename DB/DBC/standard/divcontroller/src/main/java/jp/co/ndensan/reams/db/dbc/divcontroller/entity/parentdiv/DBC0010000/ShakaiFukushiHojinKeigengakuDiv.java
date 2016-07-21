package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
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
 * ShakaiFukushiHojinKeigengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShakaiFukushiHojinKeigengakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShakaiFukushiHojinKeigengaku")
    private DataGrid<dgShakaiFukushiHojinKeigengaku_Row> dgShakaiFukushiHojinKeigengaku;
    @JsonProperty("btnShakaiFukushiHojinKeigengakuClose")
    private Button btnShakaiFukushiHojinKeigengakuClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShakaiFukushiHojinKeigengaku")
    public DataGrid<dgShakaiFukushiHojinKeigengaku_Row> getDgShakaiFukushiHojinKeigengaku() {
        return dgShakaiFukushiHojinKeigengaku;
    }

    @JsonProperty("dgShakaiFukushiHojinKeigengaku")
    public void setDgShakaiFukushiHojinKeigengaku(DataGrid<dgShakaiFukushiHojinKeigengaku_Row> dgShakaiFukushiHojinKeigengaku) {
        this.dgShakaiFukushiHojinKeigengaku=dgShakaiFukushiHojinKeigengaku;
    }

    @JsonProperty("btnShakaiFukushiHojinKeigengakuClose")
    public Button getBtnShakaiFukushiHojinKeigengakuClose() {
        return btnShakaiFukushiHojinKeigengakuClose;
    }

    @JsonProperty("btnShakaiFukushiHojinKeigengakuClose")
    public void setBtnShakaiFukushiHojinKeigengakuClose(Button btnShakaiFukushiHojinKeigengakuClose) {
        this.btnShakaiFukushiHojinKeigengakuClose=btnShakaiFukushiHojinKeigengakuClose;
    }

}
