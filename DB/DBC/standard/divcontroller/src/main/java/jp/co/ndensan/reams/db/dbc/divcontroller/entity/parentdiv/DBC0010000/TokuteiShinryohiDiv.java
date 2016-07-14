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
 * TokuteiShinryohi のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiShinryohiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokuteiShinryohiFromH1504")
    private DataGrid<dgTokuteiShinryohiFromH1504_Row> dgTokuteiShinryohiFromH1504;
    @JsonProperty("dgTokuteiShinryohiToH1503")
    private DataGrid<dgTokuteiShinryohiToH1503_Row> dgTokuteiShinryohiToH1503;
    @JsonProperty("btnTokuteiShinryohiClose")
    private Button btnTokuteiShinryohiClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgTokuteiShinryohiFromH1504")
    public DataGrid<dgTokuteiShinryohiFromH1504_Row> getDgTokuteiShinryohiFromH1504() {
        return dgTokuteiShinryohiFromH1504;
    }

    @JsonProperty("dgTokuteiShinryohiFromH1504")
    public void setDgTokuteiShinryohiFromH1504(DataGrid<dgTokuteiShinryohiFromH1504_Row> dgTokuteiShinryohiFromH1504) {
        this.dgTokuteiShinryohiFromH1504=dgTokuteiShinryohiFromH1504;
    }

    @JsonProperty("dgTokuteiShinryohiToH1503")
    public DataGrid<dgTokuteiShinryohiToH1503_Row> getDgTokuteiShinryohiToH1503() {
        return dgTokuteiShinryohiToH1503;
    }

    @JsonProperty("dgTokuteiShinryohiToH1503")
    public void setDgTokuteiShinryohiToH1503(DataGrid<dgTokuteiShinryohiToH1503_Row> dgTokuteiShinryohiToH1503) {
        this.dgTokuteiShinryohiToH1503=dgTokuteiShinryohiToH1503;
    }

    @JsonProperty("btnTokuteiShinryohiClose")
    public Button getBtnTokuteiShinryohiClose() {
        return btnTokuteiShinryohiClose;
    }

    @JsonProperty("btnTokuteiShinryohiClose")
    public void setBtnTokuteiShinryohiClose(Button btnTokuteiShinryohiClose) {
        this.btnTokuteiShinryohiClose=btnTokuteiShinryohiClose;
    }

}
