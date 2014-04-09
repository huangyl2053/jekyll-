package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 09:37:23 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgShuseiSetaiIn_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShuseiSetaiInListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShuseiSetaiInListPanelDiv extends Panel {
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
    @JsonProperty("dgShuseiSetaiIn")
    public DataGrid<dgShuseiSetaiIn_Row> getDgShuseiSetaiIn() {
        return dgShuseiSetaiIn;
    }

    @JsonProperty("dgShuseiSetaiIn")
    public void setDgShuseiSetaiIn(DataGrid<dgShuseiSetaiIn_Row> dgShuseiSetaiIn) {
        this.dgShuseiSetaiIn=dgShuseiSetaiIn;
    }

}
