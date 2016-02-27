package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * WaritsukeKohoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class WaritsukeKohoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKohoshaIchiran")
    private Label lblKohoshaIchiran;
    @JsonProperty("dgWaritsukeKohoshaIchiran")
    private DataGrid<dgWaritsukeKohoshaIchiran_Row> dgWaritsukeKohoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKohoshaIchiran
     * @return lblKohoshaIchiran
     */
    @JsonProperty("lblKohoshaIchiran")
    public Label getLblKohoshaIchiran() {
        return lblKohoshaIchiran;
    }

    /*
     * setlblKohoshaIchiran
     * @param lblKohoshaIchiran lblKohoshaIchiran
     */
    @JsonProperty("lblKohoshaIchiran")
    public void setLblKohoshaIchiran(Label lblKohoshaIchiran) {
        this.lblKohoshaIchiran = lblKohoshaIchiran;
    }

    /*
     * getdgWaritsukeKohoshaIchiran
     * @return dgWaritsukeKohoshaIchiran
     */
    @JsonProperty("dgWaritsukeKohoshaIchiran")
    public DataGrid<dgWaritsukeKohoshaIchiran_Row> getDgWaritsukeKohoshaIchiran() {
        return dgWaritsukeKohoshaIchiran;
    }

    /*
     * setdgWaritsukeKohoshaIchiran
     * @param dgWaritsukeKohoshaIchiran dgWaritsukeKohoshaIchiran
     */
    @JsonProperty("dgWaritsukeKohoshaIchiran")
    public void setDgWaritsukeKohoshaIchiran(DataGrid<dgWaritsukeKohoshaIchiran_Row> dgWaritsukeKohoshaIchiran) {
        this.dgWaritsukeKohoshaIchiran = dgWaritsukeKohoshaIchiran;
    }

    // </editor-fold>
}
