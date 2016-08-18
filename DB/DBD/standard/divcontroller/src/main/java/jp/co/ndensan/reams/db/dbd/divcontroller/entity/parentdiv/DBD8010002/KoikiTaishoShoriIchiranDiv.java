package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoikiTaishoShoriIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoikiTaishoShoriIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKoikiTaishoShoriItiran")
    private DataGrid<dgKoikiTaishoShoriItiran_Row> dgKoikiTaishoShoriItiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKoikiTaishoShoriItiran
     * @return dgKoikiTaishoShoriItiran
     */
    @JsonProperty("dgKoikiTaishoShoriItiran")
    public DataGrid<dgKoikiTaishoShoriItiran_Row> getDgKoikiTaishoShoriItiran() {
        return dgKoikiTaishoShoriItiran;
    }

    /*
     * setdgKoikiTaishoShoriItiran
     * @param dgKoikiTaishoShoriItiran dgKoikiTaishoShoriItiran
     */
    @JsonProperty("dgKoikiTaishoShoriItiran")
    public void setDgKoikiTaishoShoriItiran(DataGrid<dgKoikiTaishoShoriItiran_Row> dgKoikiTaishoShoriItiran) {
        this.dgKoikiTaishoShoriItiran = dgKoikiTaishoShoriItiran;
    }

    // </editor-fold>
}
