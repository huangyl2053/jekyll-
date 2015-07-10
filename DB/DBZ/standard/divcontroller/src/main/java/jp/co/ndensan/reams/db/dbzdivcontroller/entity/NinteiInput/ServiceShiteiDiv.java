package jp.co.ndensan.reams.db.dbzdivcontroller.entity.NinteiInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceShitei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceShiteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblServiceIken")
    private Label lblServiceIken;
    @JsonProperty("dgServiceIchiran")
    private DataGrid<dgServiceIchiran_Row> dgServiceIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblServiceIken")
    public Label getLblServiceIken() {
        return lblServiceIken;
    }

    @JsonProperty("lblServiceIken")
    public void setLblServiceIken(Label lblServiceIken) {
        this.lblServiceIken=lblServiceIken;
    }

    @JsonProperty("dgServiceIchiran")
    public DataGrid<dgServiceIchiran_Row> getDgServiceIchiran() {
        return dgServiceIchiran;
    }

    @JsonProperty("dgServiceIchiran")
    public void setDgServiceIchiran(DataGrid<dgServiceIchiran_Row> dgServiceIchiran) {
        this.dgServiceIchiran=dgServiceIchiran;
    }

    // </editor-fold>
}
