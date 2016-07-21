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
 * ShokujiHiyoMeisaiFromH1504 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokujiHiyoMeisaiFromH1504Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShokujiHiyoMeisaiFromH1504")
    private DataGrid<dgShokujiHiyoMeisaiFromH1504_Row> dgShokujiHiyoMeisaiFromH1504;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShokujiHiyoMeisaiFromH1504")
    public DataGrid<dgShokujiHiyoMeisaiFromH1504_Row> getDgShokujiHiyoMeisaiFromH1504() {
        return dgShokujiHiyoMeisaiFromH1504;
    }

    @JsonProperty("dgShokujiHiyoMeisaiFromH1504")
    public void setDgShokujiHiyoMeisaiFromH1504(DataGrid<dgShokujiHiyoMeisaiFromH1504_Row> dgShokujiHiyoMeisaiFromH1504) {
        this.dgShokujiHiyoMeisaiFromH1504=dgShokujiHiyoMeisaiFromH1504;
    }

}
