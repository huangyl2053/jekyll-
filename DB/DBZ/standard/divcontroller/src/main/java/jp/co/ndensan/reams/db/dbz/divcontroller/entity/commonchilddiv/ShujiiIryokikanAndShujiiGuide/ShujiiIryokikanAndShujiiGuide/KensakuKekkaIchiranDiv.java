package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuKekkaIchiran のクラスファイル
 *
 * @reamsid_L DBZ-1300-130 xuyannan
 */
public class KensakuKekkaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKensakuKekkaIchiran")
    private DataGrid<dgKensakuKekkaIchiran_Row> dgKensakuKekkaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKensakuKekkaIchiran
     * @return dgKensakuKekkaIchiran
     */
    @JsonProperty("dgKensakuKekkaIchiran")
    public DataGrid<dgKensakuKekkaIchiran_Row> getDgKensakuKekkaIchiran() {
        return dgKensakuKekkaIchiran;
    }

    /*
     * setdgKensakuKekkaIchiran
     * @param dgKensakuKekkaIchiran dgKensakuKekkaIchiran
     */
    @JsonProperty("dgKensakuKekkaIchiran")
    public void setDgKensakuKekkaIchiran(DataGrid<dgKensakuKekkaIchiran_Row> dgKensakuKekkaIchiran) {
        this.dgKensakuKekkaIchiran = dgKensakuKekkaIchiran;
    }

    // </editor-fold>
}
