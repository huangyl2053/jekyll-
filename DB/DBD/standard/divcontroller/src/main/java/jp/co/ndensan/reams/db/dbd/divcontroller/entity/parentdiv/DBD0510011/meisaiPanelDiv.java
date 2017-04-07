package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * meisaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class meisaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShichoson")
    private DataGrid<dgShichoson_Row> dgShichoson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShichoson
     * @return dgShichoson
     */
    @JsonProperty("dgShichoson")
    public DataGrid<dgShichoson_Row> getDgShichoson() {
        return dgShichoson;
    }

    /*
     * setdgShichoson
     * @param dgShichoson dgShichoson
     */
    @JsonProperty("dgShichoson")
    public void setDgShichoson(DataGrid<dgShichoson_Row> dgShichoson) {
        this.dgShichoson = dgShichoson;
    }

    // </editor-fold>
}
