package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001.dgShikakuFuseigoIchiranForDemo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001.dgShikakuFuseigoIchiran_Row;
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
    @JsonProperty("chkMushiBunHihyoji")
    private CheckBoxList chkMushiBunHihyoji;
    @JsonProperty("dgShikakuFuseigoIchiran")
    private DataGrid<dgShikakuFuseigoIchiran_Row> dgShikakuFuseigoIchiran;
    @JsonProperty("dgShikakuFuseigoIchiranForDemo")
    private DataGrid<dgShikakuFuseigoIchiranForDemo_Row> dgShikakuFuseigoIchiranForDemo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkMushiBunHihyoji")
    public CheckBoxList getChkMushiBunHihyoji() {
        return chkMushiBunHihyoji;
    }

    @JsonProperty("chkMushiBunHihyoji")
    public void setChkMushiBunHihyoji(CheckBoxList chkMushiBunHihyoji) {
        this.chkMushiBunHihyoji=chkMushiBunHihyoji;
    }

    @JsonProperty("dgShikakuFuseigoIchiran")
    public DataGrid<dgShikakuFuseigoIchiran_Row> getDgShikakuFuseigoIchiran() {
        return dgShikakuFuseigoIchiran;
    }

    @JsonProperty("dgShikakuFuseigoIchiran")
    public void setDgShikakuFuseigoIchiran(DataGrid<dgShikakuFuseigoIchiran_Row> dgShikakuFuseigoIchiran) {
        this.dgShikakuFuseigoIchiran=dgShikakuFuseigoIchiran;
    }

    @JsonProperty("dgShikakuFuseigoIchiranForDemo")
    public DataGrid<dgShikakuFuseigoIchiranForDemo_Row> getDgShikakuFuseigoIchiranForDemo() {
        return dgShikakuFuseigoIchiranForDemo;
    }

    @JsonProperty("dgShikakuFuseigoIchiranForDemo")
    public void setDgShikakuFuseigoIchiranForDemo(DataGrid<dgShikakuFuseigoIchiranForDemo_Row> dgShikakuFuseigoIchiranForDemo) {
        this.dgShikakuFuseigoIchiranForDemo=dgShikakuFuseigoIchiranForDemo;
    }

}
