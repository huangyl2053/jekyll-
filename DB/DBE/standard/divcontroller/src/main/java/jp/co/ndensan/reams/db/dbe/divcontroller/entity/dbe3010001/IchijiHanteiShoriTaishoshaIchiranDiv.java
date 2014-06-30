package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IchijiHanteiShoriTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiShoriTaishoshaIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTaishoshaSearch")
    private Button btnTaishoshaSearch;
    @JsonProperty("dgIchijiHanteiTaishoshaIchiran")
    private DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dgIchijiHanteiTaishoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnTaishoshaSearch")
    public Button getBtnTaishoshaSearch() {
        return btnTaishoshaSearch;
    }

    @JsonProperty("btnTaishoshaSearch")
    public void setBtnTaishoshaSearch(Button btnTaishoshaSearch) {
        this.btnTaishoshaSearch=btnTaishoshaSearch;
    }

    @JsonProperty("dgIchijiHanteiTaishoshaIchiran")
    public DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> getDgIchijiHanteiTaishoshaIchiran() {
        return dgIchijiHanteiTaishoshaIchiran;
    }

    @JsonProperty("dgIchijiHanteiTaishoshaIchiran")
    public void setDgIchijiHanteiTaishoshaIchiran(DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dgIchijiHanteiTaishoshaIchiran) {
        this.dgIchijiHanteiTaishoshaIchiran=dgIchijiHanteiTaishoshaIchiran;
    }

}
