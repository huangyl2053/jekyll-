package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * dgKyotakuServiceKeikakuIchiranMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class dgKyotakuServiceKeikakuIchiranMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKyotakuServiceKeikakuIchiran")
    private DataGrid<dgKyotakuServiceKeikakuIchiran_Row> dgKyotakuServiceKeikakuIchiran;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKyotakuServiceKeikakuIchiran
     * @return dgKyotakuServiceKeikakuIchiran
     */
    @JsonProperty("dgKyotakuServiceKeikakuIchiran")
    public DataGrid<dgKyotakuServiceKeikakuIchiran_Row> getDgKyotakuServiceKeikakuIchiran() {
        return dgKyotakuServiceKeikakuIchiran;
    }

    /*
     * setdgKyotakuServiceKeikakuIchiran
     * @param dgKyotakuServiceKeikakuIchiran dgKyotakuServiceKeikakuIchiran
     */
    @JsonProperty("dgKyotakuServiceKeikakuIchiran")
    public void setDgKyotakuServiceKeikakuIchiran(DataGrid<dgKyotakuServiceKeikakuIchiran_Row> dgKyotakuServiceKeikakuIchiran) {
        this.dgKyotakuServiceKeikakuIchiran = dgKyotakuServiceKeikakuIchiran;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
}
