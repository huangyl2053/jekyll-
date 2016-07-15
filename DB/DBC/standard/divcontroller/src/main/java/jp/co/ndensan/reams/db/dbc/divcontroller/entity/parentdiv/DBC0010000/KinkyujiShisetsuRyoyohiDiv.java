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
 * KinkyujiShisetsuRyoyohi のクラスファイル 
 * 
 * @author 自動生成
 */
public class KinkyujiShisetsuRyoyohiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKinkyujiShisetsuRyoyohi")
    private DataGrid<dgKinkyujiShisetsuRyoyohi_Row> dgKinkyujiShisetsuRyoyohi;
    @JsonProperty("btnKinkyujiShisetsuRyoyohiClose")
    private Button btnKinkyujiShisetsuRyoyohiClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgKinkyujiShisetsuRyoyohi")
    public DataGrid<dgKinkyujiShisetsuRyoyohi_Row> getDgKinkyujiShisetsuRyoyohi() {
        return dgKinkyujiShisetsuRyoyohi;
    }

    @JsonProperty("dgKinkyujiShisetsuRyoyohi")
    public void setDgKinkyujiShisetsuRyoyohi(DataGrid<dgKinkyujiShisetsuRyoyohi_Row> dgKinkyujiShisetsuRyoyohi) {
        this.dgKinkyujiShisetsuRyoyohi=dgKinkyujiShisetsuRyoyohi;
    }

    @JsonProperty("btnKinkyujiShisetsuRyoyohiClose")
    public Button getBtnKinkyujiShisetsuRyoyohiClose() {
        return btnKinkyujiShisetsuRyoyohiClose;
    }

    @JsonProperty("btnKinkyujiShisetsuRyoyohiClose")
    public void setBtnKinkyujiShisetsuRyoyohiClose(Button btnKinkyujiShisetsuRyoyohiClose) {
        this.btnKinkyujiShisetsuRyoyohiClose=btnKinkyujiShisetsuRyoyohiClose;
    }

}
