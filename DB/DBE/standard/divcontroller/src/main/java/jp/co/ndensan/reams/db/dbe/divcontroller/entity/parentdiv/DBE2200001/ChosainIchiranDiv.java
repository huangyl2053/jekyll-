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
 * ChosainIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosainIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgchosainIchiran")
    private DataGrid<dgchosainIchiran_Row> dgchosainIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgchosainIchiran
     * @return dgchosainIchiran
     */
    @JsonProperty("dgchosainIchiran")
    public DataGrid<dgchosainIchiran_Row> getDgchosainIchiran() {
        return dgchosainIchiran;
    }

    /*
     * setdgchosainIchiran
     * @param dgchosainIchiran dgchosainIchiran
     */
    @JsonProperty("dgchosainIchiran")
    public void setDgchosainIchiran(DataGrid<dgchosainIchiran_Row> dgchosainIchiran) {
        this.dgchosainIchiran = dgchosainIchiran;
    }

    // </editor-fold>
}
