package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0070011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SofuIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class SofuIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSofuIchiran")
    private DataGrid<dgSofuIchiran_Row> dgSofuIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSofuIchiran
     * @return dgSofuIchiran
     */
    @JsonProperty("dgSofuIchiran")
    public DataGrid<dgSofuIchiran_Row> getDgSofuIchiran() {
        return dgSofuIchiran;
    }

    /*
     * setdgSofuIchiran
     * @param dgSofuIchiran dgSofuIchiran
     */
    @JsonProperty("dgSofuIchiran")
    public void setDgSofuIchiran(DataGrid<dgSofuIchiran_Row> dgSofuIchiran) {
        this.dgSofuIchiran = dgSofuIchiran;
    }

    // </editor-fold>
}
