package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Apr 08 20:00:42 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgShikakuFuseigoIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShikakuFuseigoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuFuseigoIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShikakuFuseigoIchiran")
    private DataGrid<dgShikakuFuseigoIchiran_Row> dgShikakuFuseigoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShikakuFuseigoIchiran")
    public DataGrid<dgShikakuFuseigoIchiran_Row> getDgShikakuFuseigoIchiran() {
        return dgShikakuFuseigoIchiran;
    }

    @JsonProperty("dgShikakuFuseigoIchiran")
    public void setDgShikakuFuseigoIchiran(DataGrid<dgShikakuFuseigoIchiran_Row> dgShikakuFuseigoIchiran) {
        this.dgShikakuFuseigoIchiran=dgShikakuFuseigoIchiran;
    }

}
