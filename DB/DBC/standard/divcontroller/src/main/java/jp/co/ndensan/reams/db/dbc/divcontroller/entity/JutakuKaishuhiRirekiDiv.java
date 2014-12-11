package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IJutakuKaishuhiRirekiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuhiRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuhiRirekiDiv extends Panel implements IJutakuKaishuhiRirekiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJutakuKaishuRireki")
    private DataGrid<dgJutakuKaishuRireki_Row> dgJutakuKaishuRireki;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJutakuKaishuRireki")
    public DataGrid<dgJutakuKaishuRireki_Row> getDgJutakuKaishuRireki() {
        return dgJutakuKaishuRireki;
    }

    @JsonProperty("dgJutakuKaishuRireki")
    public void setDgJutakuKaishuRireki(DataGrid<dgJutakuKaishuRireki_Row> dgJutakuKaishuRireki) {
        this.dgJutakuKaishuRireki=dgJutakuKaishuRireki;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
