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
 * ShokujiHiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokujiHiyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokujiHiyoGokeiFromH1504")
    private ShokujiHiyoGokeiFromH1504Div ShokujiHiyoGokeiFromH1504;
    @JsonProperty("ShokujiHiyoMeisaiFromH1504")
    private ShokujiHiyoMeisaiFromH1504Div ShokujiHiyoMeisaiFromH1504;
    @JsonProperty("dgShokujiHiyoToH1503")
    private DataGrid<dgShokujiHiyoToH1503_Row> dgShokujiHiyoToH1503;
    @JsonProperty("btnShokujiHiyoClose")
    private Button btnShokujiHiyoClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokujiHiyoGokeiFromH1504")
    public ShokujiHiyoGokeiFromH1504Div getShokujiHiyoGokeiFromH1504() {
        return ShokujiHiyoGokeiFromH1504;
    }

    @JsonProperty("ShokujiHiyoGokeiFromH1504")
    public void setShokujiHiyoGokeiFromH1504(ShokujiHiyoGokeiFromH1504Div ShokujiHiyoGokeiFromH1504) {
        this.ShokujiHiyoGokeiFromH1504=ShokujiHiyoGokeiFromH1504;
    }

    @JsonProperty("ShokujiHiyoMeisaiFromH1504")
    public ShokujiHiyoMeisaiFromH1504Div getShokujiHiyoMeisaiFromH1504() {
        return ShokujiHiyoMeisaiFromH1504;
    }

    @JsonProperty("ShokujiHiyoMeisaiFromH1504")
    public void setShokujiHiyoMeisaiFromH1504(ShokujiHiyoMeisaiFromH1504Div ShokujiHiyoMeisaiFromH1504) {
        this.ShokujiHiyoMeisaiFromH1504=ShokujiHiyoMeisaiFromH1504;
    }

    @JsonProperty("dgShokujiHiyoToH1503")
    public DataGrid<dgShokujiHiyoToH1503_Row> getDgShokujiHiyoToH1503() {
        return dgShokujiHiyoToH1503;
    }

    @JsonProperty("dgShokujiHiyoToH1503")
    public void setDgShokujiHiyoToH1503(DataGrid<dgShokujiHiyoToH1503_Row> dgShokujiHiyoToH1503) {
        this.dgShokujiHiyoToH1503=dgShokujiHiyoToH1503;
    }

    @JsonProperty("btnShokujiHiyoClose")
    public Button getBtnShokujiHiyoClose() {
        return btnShokujiHiyoClose;
    }

    @JsonProperty("btnShokujiHiyoClose")
    public void setBtnShokujiHiyoClose(Button btnShokujiHiyoClose) {
        this.btnShokujiHiyoClose=btnShokujiHiyoClose;
    }

}
