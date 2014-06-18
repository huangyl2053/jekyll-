package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.dgYokaigoninteiProgress_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YokaigoninteiProgress のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokaigoninteiProgressDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToOutputShinchokuIchiran")
    private Button btnToOutputShinchokuIchiran;
    @JsonProperty("btnToOutputKojinJokyohyo")
    private Button btnToOutputKojinJokyohyo;
    @JsonProperty("dgYokaigoninteiProgress")
    private DataGrid<dgYokaigoninteiProgress_Row> dgYokaigoninteiProgress;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToOutputShinchokuIchiran")
    public Button getBtnToOutputShinchokuIchiran() {
        return btnToOutputShinchokuIchiran;
    }

    @JsonProperty("btnToOutputShinchokuIchiran")
    public void setBtnToOutputShinchokuIchiran(Button btnToOutputShinchokuIchiran) {
        this.btnToOutputShinchokuIchiran=btnToOutputShinchokuIchiran;
    }

    @JsonProperty("btnToOutputKojinJokyohyo")
    public Button getBtnToOutputKojinJokyohyo() {
        return btnToOutputKojinJokyohyo;
    }

    @JsonProperty("btnToOutputKojinJokyohyo")
    public void setBtnToOutputKojinJokyohyo(Button btnToOutputKojinJokyohyo) {
        this.btnToOutputKojinJokyohyo=btnToOutputKojinJokyohyo;
    }

    @JsonProperty("dgYokaigoninteiProgress")
    public DataGrid<dgYokaigoninteiProgress_Row> getDgYokaigoninteiProgress() {
        return dgYokaigoninteiProgress;
    }

    @JsonProperty("dgYokaigoninteiProgress")
    public void setDgYokaigoninteiProgress(DataGrid<dgYokaigoninteiProgress_Row> dgYokaigoninteiProgress) {
        this.dgYokaigoninteiProgress=dgYokaigoninteiProgress;
    }

}
