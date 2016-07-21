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
 * TokuteiNyushoshaKaigoServicehi のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiNyushoshaKaigoServicehiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokuteiNyushoshaKaigoServicehi")
    private DataGrid<dgTokuteiNyushoshaKaigoServicehi_Row> dgTokuteiNyushoshaKaigoServicehi;
    @JsonProperty("btnTokuteiNyushoshaKaigoServicehiClose")
    private Button btnTokuteiNyushoshaKaigoServicehiClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgTokuteiNyushoshaKaigoServicehi")
    public DataGrid<dgTokuteiNyushoshaKaigoServicehi_Row> getDgTokuteiNyushoshaKaigoServicehi() {
        return dgTokuteiNyushoshaKaigoServicehi;
    }

    @JsonProperty("dgTokuteiNyushoshaKaigoServicehi")
    public void setDgTokuteiNyushoshaKaigoServicehi(DataGrid<dgTokuteiNyushoshaKaigoServicehi_Row> dgTokuteiNyushoshaKaigoServicehi) {
        this.dgTokuteiNyushoshaKaigoServicehi=dgTokuteiNyushoshaKaigoServicehi;
    }

    @JsonProperty("btnTokuteiNyushoshaKaigoServicehiClose")
    public Button getBtnTokuteiNyushoshaKaigoServicehiClose() {
        return btnTokuteiNyushoshaKaigoServicehiClose;
    }

    @JsonProperty("btnTokuteiNyushoshaKaigoServicehiClose")
    public void setBtnTokuteiNyushoshaKaigoServicehiClose(Button btnTokuteiNyushoshaKaigoServicehiClose) {
        this.btnTokuteiNyushoshaKaigoServicehiClose=btnTokuteiNyushoshaKaigoServicehiClose;
    }

}
