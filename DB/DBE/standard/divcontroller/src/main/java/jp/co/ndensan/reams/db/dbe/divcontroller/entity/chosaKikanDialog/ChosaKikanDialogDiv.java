package jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaKikanDialog;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaKikanDialog.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaKikanDialog.dgKikanIchiran_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChosaKikanDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaKikanDialogDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToMentenanceChosaKikan")
    private Button btnToMentenanceChosaKikan;
    @JsonProperty("dgKikanIchiran")
    private DataGrid<dgKikanIchiran_Row> dgKikanIchiran;
    @JsonProperty("dgChosainIchiran")
    private DataGrid<dgChosainIchiran_Row> dgChosainIchiran;
    @JsonProperty("btnSelectKikan")
    private Button btnSelectKikan;
    @JsonProperty("btnNonSelectReturn")
    private Button btnNonSelectReturn;
    @JsonProperty("chosaItakusakiCode")
    private RString chosaItakusakiCode;
    @JsonProperty("chosaItakusakiName")
    private RString chosaItakusakiName;
    @JsonProperty("chosainCode")
    private RString chosainCode;
    @JsonProperty("chosainName")
    private RString chosainName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToMentenanceChosaKikan")
    public Button getBtnToMentenanceChosaKikan() {
        return btnToMentenanceChosaKikan;
    }

    @JsonProperty("btnToMentenanceChosaKikan")
    public void setBtnToMentenanceChosaKikan(Button btnToMentenanceChosaKikan) {
        this.btnToMentenanceChosaKikan=btnToMentenanceChosaKikan;
    }

    @JsonProperty("dgKikanIchiran")
    public DataGrid<dgKikanIchiran_Row> getDgKikanIchiran() {
        return dgKikanIchiran;
    }

    @JsonProperty("dgKikanIchiran")
    public void setDgKikanIchiran(DataGrid<dgKikanIchiran_Row> dgKikanIchiran) {
        this.dgKikanIchiran=dgKikanIchiran;
    }

    @JsonProperty("dgChosainIchiran")
    public DataGrid<dgChosainIchiran_Row> getDgChosainIchiran() {
        return dgChosainIchiran;
    }

    @JsonProperty("dgChosainIchiran")
    public void setDgChosainIchiran(DataGrid<dgChosainIchiran_Row> dgChosainIchiran) {
        this.dgChosainIchiran=dgChosainIchiran;
    }

    @JsonProperty("btnSelectKikan")
    public Button getBtnSelectKikan() {
        return btnSelectKikan;
    }

    @JsonProperty("btnSelectKikan")
    public void setBtnSelectKikan(Button btnSelectKikan) {
        this.btnSelectKikan=btnSelectKikan;
    }

    @JsonProperty("btnNonSelectReturn")
    public Button getBtnNonSelectReturn() {
        return btnNonSelectReturn;
    }

    @JsonProperty("btnNonSelectReturn")
    public void setBtnNonSelectReturn(Button btnNonSelectReturn) {
        this.btnNonSelectReturn=btnNonSelectReturn;
    }

    @JsonProperty("chosaItakusakiCode")
    public RString getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    @JsonProperty("chosaItakusakiCode")
    public void setChosaItakusakiCode(RString chosaItakusakiCode) {
        this.chosaItakusakiCode=chosaItakusakiCode;
    }

    @JsonProperty("chosaItakusakiName")
    public RString getChosaItakusakiName() {
        return chosaItakusakiName;
    }

    @JsonProperty("chosaItakusakiName")
    public void setChosaItakusakiName(RString chosaItakusakiName) {
        this.chosaItakusakiName=chosaItakusakiName;
    }

    @JsonProperty("chosainCode")
    public RString getChosainCode() {
        return chosainCode;
    }

    @JsonProperty("chosainCode")
    public void setChosainCode(RString chosainCode) {
        this.chosainCode=chosainCode;
    }

    @JsonProperty("chosainName")
    public RString getChosainName() {
        return chosainName;
    }

    @JsonProperty("chosainName")
    public void setChosainName(RString chosainName) {
        this.chosainName=chosainName;
    }

}
