package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DAB2000600;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShuseiSetaiInListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShuseiSetaiInListPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShuseiSetaiIn")
    private DataGrid<dgShuseiSetaiIn_Row> dgShuseiSetaiIn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShuseiSetaiIn
     * @return dgShuseiSetaiIn
     */
    @JsonProperty("dgShuseiSetaiIn")
    public DataGrid<dgShuseiSetaiIn_Row> getDgShuseiSetaiIn() {
        return dgShuseiSetaiIn;
    }

    /*
     * setdgShuseiSetaiIn
     * @param dgShuseiSetaiIn dgShuseiSetaiIn
     */
    @JsonProperty("dgShuseiSetaiIn")
    public void setDgShuseiSetaiIn(DataGrid<dgShuseiSetaiIn_Row> dgShuseiSetaiIn) {
        this.dgShuseiSetaiIn = dgShuseiSetaiIn;
    }

    // </editor-fold>
}
