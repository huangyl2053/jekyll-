package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ButtonsForWaritsukeChosaItakusakiListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ShozokuChosainListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.dgChosaItakusakiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChosaItakusakiAndChosainList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiAndChosainListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ButtonsForWaritsukeChosaItakusakiList")
    private ButtonsForWaritsukeChosaItakusakiListDiv ButtonsForWaritsukeChosaItakusakiList;
    @JsonProperty("dgChosaItakusakiList")
    private DataGrid<dgChosaItakusakiList_Row> dgChosaItakusakiList;
    @JsonProperty("ShozokuChosainList")
    private ShozokuChosainListDiv ShozokuChosainList;
    @JsonProperty("lblPadding")
    private Label lblPadding;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ButtonsForWaritsukeChosaItakusakiList")
    public ButtonsForWaritsukeChosaItakusakiListDiv getButtonsForWaritsukeChosaItakusakiList() {
        return ButtonsForWaritsukeChosaItakusakiList;
    }

    @JsonProperty("ButtonsForWaritsukeChosaItakusakiList")
    public void setButtonsForWaritsukeChosaItakusakiList(ButtonsForWaritsukeChosaItakusakiListDiv ButtonsForWaritsukeChosaItakusakiList) {
        this.ButtonsForWaritsukeChosaItakusakiList=ButtonsForWaritsukeChosaItakusakiList;
    }

    @JsonProperty("dgChosaItakusakiList")
    public DataGrid<dgChosaItakusakiList_Row> getDgChosaItakusakiList() {
        return dgChosaItakusakiList;
    }

    @JsonProperty("dgChosaItakusakiList")
    public void setDgChosaItakusakiList(DataGrid<dgChosaItakusakiList_Row> dgChosaItakusakiList) {
        this.dgChosaItakusakiList=dgChosaItakusakiList;
    }

    @JsonProperty("ShozokuChosainList")
    public ShozokuChosainListDiv getShozokuChosainList() {
        return ShozokuChosainList;
    }

    @JsonProperty("ShozokuChosainList")
    public void setShozokuChosainList(ShozokuChosainListDiv ShozokuChosainList) {
        this.ShozokuChosainList=ShozokuChosainList;
    }

    @JsonProperty("lblPadding")
    public Label getLblPadding() {
        return lblPadding;
    }

    @JsonProperty("lblPadding")
    public void setLblPadding(Label lblPadding) {
        this.lblPadding=lblPadding;
    }

}
