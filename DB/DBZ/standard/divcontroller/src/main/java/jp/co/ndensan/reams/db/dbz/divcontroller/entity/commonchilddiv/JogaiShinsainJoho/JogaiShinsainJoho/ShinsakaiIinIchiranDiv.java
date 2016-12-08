package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiIinIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShinkiTsuika")
    private Button btnShinkiTsuika;
    @JsonProperty("dgShinsakaiIinIchiran")
    private DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShinkiTsuika
     * @return btnShinkiTsuika
     */
    @JsonProperty("btnShinkiTsuika")
    public Button getBtnShinkiTsuika() {
        return btnShinkiTsuika;
    }

    /*
     * setbtnShinkiTsuika
     * @param btnShinkiTsuika btnShinkiTsuika
     */
    @JsonProperty("btnShinkiTsuika")
    public void setBtnShinkiTsuika(Button btnShinkiTsuika) {
        this.btnShinkiTsuika = btnShinkiTsuika;
    }

    /*
     * getdgShinsakaiIinIchiran
     * @return dgShinsakaiIinIchiran
     */
    @JsonProperty("dgShinsakaiIinIchiran")
    public DataGrid<dgShinsakaiIinIchiran_Row> getDgShinsakaiIinIchiran() {
        return dgShinsakaiIinIchiran;
    }

    /*
     * setdgShinsakaiIinIchiran
     * @param dgShinsakaiIinIchiran dgShinsakaiIinIchiran
     */
    @JsonProperty("dgShinsakaiIinIchiran")
    public void setDgShinsakaiIinIchiran(DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran) {
        this.dgShinsakaiIinIchiran = dgShinsakaiIinIchiran;
    }

    // </editor-fold>
}
