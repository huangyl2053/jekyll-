package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;

/**
 * KaNendoIdoFukaIchiran のクラスファイル
 *
 * @reamsid_L DBB-0680-010 wangkanglei
 */
public class KaNendoIdoFukaIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKanendoFukaIchiran")
    private DataGrid<dgKanendoFukaIchiran_Row> dgKanendoFukaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getdgKanendoFukaIchiran
     * @return dgKanendoFukaIchiran
     */
    @JsonProperty("dgKanendoFukaIchiran")
    public DataGrid<dgKanendoFukaIchiran_Row> getDgKanendoFukaIchiran() {
        return dgKanendoFukaIchiran;
    }

    /*
     * setdgKanendoFukaIchiran
     * @param dgKanendoFukaIchiran dgKanendoFukaIchiran
     */
    @JsonProperty("dgKanendoFukaIchiran")
    public void setDgKanendoFukaIchiran(DataGrid<dgKanendoFukaIchiran_Row> dgKanendoFukaIchiran) {
        this.dgKanendoFukaIchiran = dgKanendoFukaIchiran;
    }

    // </editor-fold>
}
