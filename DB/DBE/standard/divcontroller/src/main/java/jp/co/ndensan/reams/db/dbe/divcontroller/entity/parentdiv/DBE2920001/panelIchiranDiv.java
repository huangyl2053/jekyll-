package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTorikomiFileIchiran")
    private DataGrid<dgTorikomiFileIchiran_Row> dgTorikomiFileIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTorikomiFileIchiran
     * @return dgTorikomiFileIchiran
     */
    @JsonProperty("dgTorikomiFileIchiran")
    public DataGrid<dgTorikomiFileIchiran_Row> getDgTorikomiFileIchiran() {
        return dgTorikomiFileIchiran;
    }

    /*
     * setdgTorikomiFileIchiran
     * @param dgTorikomiFileIchiran dgTorikomiFileIchiran
     */
    @JsonProperty("dgTorikomiFileIchiran")
    public void setDgTorikomiFileIchiran(DataGrid<dgTorikomiFileIchiran_Row> dgTorikomiFileIchiran) {
        this.dgTorikomiFileIchiran = dgTorikomiFileIchiran;
    }

    // </editor-fold>
}
