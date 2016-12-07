package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgServiceIchiran")
    private DataGrid<dgServiceIchiran_Row> dgServiceIchiran;
    @JsonProperty("lblServiceIken")
    private Label lblServiceIken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgServiceIchiran
     * @return dgServiceIchiran
     */
    @JsonProperty("dgServiceIchiran")
    public DataGrid<dgServiceIchiran_Row> getDgServiceIchiran() {
        return dgServiceIchiran;
    }

    /*
     * setdgServiceIchiran
     * @param dgServiceIchiran dgServiceIchiran
     */
    @JsonProperty("dgServiceIchiran")
    public void setDgServiceIchiran(DataGrid<dgServiceIchiran_Row> dgServiceIchiran) {
        this.dgServiceIchiran = dgServiceIchiran;
    }

    /*
     * getlblServiceIken
     * @return lblServiceIken
     */
    @JsonProperty("lblServiceIken")
    public Label getLblServiceIken() {
        return lblServiceIken;
    }

    /*
     * setlblServiceIken
     * @param lblServiceIken lblServiceIken
     */
    @JsonProperty("lblServiceIken")
    public void setLblServiceIken(Label lblServiceIken) {
        this.lblServiceIken = lblServiceIken;
    }

    // </editor-fold>
}
