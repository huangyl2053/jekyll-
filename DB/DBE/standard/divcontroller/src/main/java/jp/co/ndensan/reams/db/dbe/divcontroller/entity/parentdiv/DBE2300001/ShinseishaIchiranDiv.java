package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseishaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinseishaIchiran")
    private DataGrid<dgShinseishaIchiran_Row> dgShinseishaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShinseishaIchiran
     * @return dgShinseishaIchiran
     */
    @JsonProperty("dgShinseishaIchiran")
    public DataGrid<dgShinseishaIchiran_Row> getDgShinseishaIchiran() {
        return dgShinseishaIchiran;
    }

    /*
     * setdgShinseishaIchiran
     * @param dgShinseishaIchiran dgShinseishaIchiran
     */
    @JsonProperty("dgShinseishaIchiran")
    public void setDgShinseishaIchiran(DataGrid<dgShinseishaIchiran_Row> dgShinseishaIchiran) {
        this.dgShinseishaIchiran = dgShinseishaIchiran;
    }

    // </editor-fold>
}
