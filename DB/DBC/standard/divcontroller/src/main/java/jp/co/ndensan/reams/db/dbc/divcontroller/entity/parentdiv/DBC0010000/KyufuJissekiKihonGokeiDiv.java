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
 * KyufuJissekiKihonGokei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiKihonGokeiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKyufuJissekiKihonGokei")
    private DataGrid<dgKyufuJissekiKihonGokei_Row> dgKyufuJissekiKihonGokei;
    @JsonProperty("btnKyufuJissekiKihonGokeiClose")
    private Button btnKyufuJissekiKihonGokeiClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgKyufuJissekiKihonGokei")
    public DataGrid<dgKyufuJissekiKihonGokei_Row> getDgKyufuJissekiKihonGokei() {
        return dgKyufuJissekiKihonGokei;
    }

    @JsonProperty("dgKyufuJissekiKihonGokei")
    public void setDgKyufuJissekiKihonGokei(DataGrid<dgKyufuJissekiKihonGokei_Row> dgKyufuJissekiKihonGokei) {
        this.dgKyufuJissekiKihonGokei=dgKyufuJissekiKihonGokei;
    }

    @JsonProperty("btnKyufuJissekiKihonGokeiClose")
    public Button getBtnKyufuJissekiKihonGokeiClose() {
        return btnKyufuJissekiKihonGokeiClose;
    }

    @JsonProperty("btnKyufuJissekiKihonGokeiClose")
    public void setBtnKyufuJissekiKihonGokeiClose(Button btnKyufuJissekiKihonGokeiClose) {
        this.btnKyufuJissekiKihonGokeiClose=btnKyufuJissekiKihonGokeiClose;
    }

}
