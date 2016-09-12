package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinchokuIchiran")
    private DataGrid<dgShinchokuIchiran_Row> dgShinchokuIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShinchokuIchiran
     * @return dgShinchokuIchiran
     */
    @JsonProperty("dgShinchokuIchiran")
    public DataGrid<dgShinchokuIchiran_Row> getDgShinchokuIchiran() {
        return dgShinchokuIchiran;
    }

    /*
     * setdgShinchokuIchiran
     * @param dgShinchokuIchiran dgShinchokuIchiran
     */
    @JsonProperty("dgShinchokuIchiran")
    public void setDgShinchokuIchiran(DataGrid<dgShinchokuIchiran_Row> dgShinchokuIchiran) {
        this.dgShinchokuIchiran = dgShinchokuIchiran;
    }

    // </editor-fold>
}
