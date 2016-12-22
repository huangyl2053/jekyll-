package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChoisaItakusakiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoisaItakusakiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgChosaItakusakiIchiran")
    private DataGrid<dgChosaItakusakiIchiran_Row> dgChosaItakusakiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgChosaItakusakiIchiran
     * @return dgChosaItakusakiIchiran
     */
    @JsonProperty("dgChosaItakusakiIchiran")
    public DataGrid<dgChosaItakusakiIchiran_Row> getDgChosaItakusakiIchiran() {
        return dgChosaItakusakiIchiran;
    }

    /*
     * setdgChosaItakusakiIchiran
     * @param dgChosaItakusakiIchiran dgChosaItakusakiIchiran
     */
    @JsonProperty("dgChosaItakusakiIchiran")
    public void setDgChosaItakusakiIchiran(DataGrid<dgChosaItakusakiIchiran_Row> dgChosaItakusakiIchiran) {
        this.dgChosaItakusakiIchiran = dgChosaItakusakiIchiran;
    }

    // </editor-fold>
}
