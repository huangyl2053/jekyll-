package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GogitaiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class GogitaiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTsuika")
    private Button btnTsuika;
    @JsonProperty("btnCSVShutsuryoku")
    private Button btnCSVShutsuryoku;
    @JsonProperty("dgGogitaiIchiran")
    private DataGrid<dgGogitaiIchiran_Row> dgGogitaiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTsuika
     * @return btnTsuika
     */
    @JsonProperty("btnTsuika")
    public Button getBtnTsuika() {
        return btnTsuika;
    }

    /*
     * setbtnTsuika
     * @param btnTsuika btnTsuika
     */
    @JsonProperty("btnTsuika")
    public void setBtnTsuika(Button btnTsuika) {
        this.btnTsuika = btnTsuika;
    }

    /*
     * getbtnCSVShutsuryoku
     * @return btnCSVShutsuryoku
     */
    @JsonProperty("btnCSVShutsuryoku")
    public Button getBtnCSVShutsuryoku() {
        return btnCSVShutsuryoku;
    }

    /*
     * setbtnCSVShutsuryoku
     * @param btnCSVShutsuryoku btnCSVShutsuryoku
     */
    @JsonProperty("btnCSVShutsuryoku")
    public void setBtnCSVShutsuryoku(Button btnCSVShutsuryoku) {
        this.btnCSVShutsuryoku = btnCSVShutsuryoku;
    }

    /*
     * getdgGogitaiIchiran
     * @return dgGogitaiIchiran
     */
    @JsonProperty("dgGogitaiIchiran")
    public DataGrid<dgGogitaiIchiran_Row> getDgGogitaiIchiran() {
        return dgGogitaiIchiran;
    }

    /*
     * setdgGogitaiIchiran
     * @param dgGogitaiIchiran dgGogitaiIchiran
     */
    @JsonProperty("dgGogitaiIchiran")
    public void setDgGogitaiIchiran(DataGrid<dgGogitaiIchiran_Row> dgGogitaiIchiran) {
        this.dgGogitaiIchiran = dgGogitaiIchiran;
    }

    // </editor-fold>
}
