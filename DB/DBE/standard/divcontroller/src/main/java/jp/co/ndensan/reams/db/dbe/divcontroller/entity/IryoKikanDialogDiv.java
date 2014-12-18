package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.IIryoKikanDialogDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShujiiIchiran_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IryoKikanDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryoKikanDialogDiv extends Panel implements IIryoKikanDialogDiv {
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
    @JsonProperty("dgShujiiIchiran")
    private DataGrid<dgShujiiIchiran_Row> dgShujiiIchiran;
    @JsonProperty("btnSelectKikan")
    private Button btnSelectKikan;
    @JsonProperty("btnNonSelectReturn")
    private Button btnNonSelectReturn;
    @JsonProperty("iryokikanCode")
    private RString iryokikanCode;
    @JsonProperty("iryokikanName")
    private RString iryokikanName;
    @JsonProperty("ishiCode")
    private RString ishiCode;
    @JsonProperty("ishiName")
    private RString ishiName;

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

    @JsonProperty("dgShujiiIchiran")
    public DataGrid<dgShujiiIchiran_Row> getDgShujiiIchiran() {
        return dgShujiiIchiran;
    }

    @JsonProperty("dgShujiiIchiran")
    public void setDgShujiiIchiran(DataGrid<dgShujiiIchiran_Row> dgShujiiIchiran) {
        this.dgShujiiIchiran=dgShujiiIchiran;
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

    @JsonProperty("iryokikanCode")
    public RString getIryokikanCode() {
        return iryokikanCode;
    }

    @JsonProperty("iryokikanCode")
    public void setIryokikanCode(RString iryokikanCode) {
        this.iryokikanCode=iryokikanCode;
    }

    @JsonProperty("iryokikanName")
    public RString getIryokikanName() {
        return iryokikanName;
    }

    @JsonProperty("iryokikanName")
    public void setIryokikanName(RString iryokikanName) {
        this.iryokikanName=iryokikanName;
    }

    @JsonProperty("ishiCode")
    public RString getIshiCode() {
        return ishiCode;
    }

    @JsonProperty("ishiCode")
    public void setIshiCode(RString ishiCode) {
        this.ishiCode=ishiCode;
    }

    @JsonProperty("ishiName")
    public RString getIshiName() {
        return ishiName;
    }

    @JsonProperty("ishiName")
    public void setIshiName(RString ishiName) {
        this.ishiName=ishiName;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
