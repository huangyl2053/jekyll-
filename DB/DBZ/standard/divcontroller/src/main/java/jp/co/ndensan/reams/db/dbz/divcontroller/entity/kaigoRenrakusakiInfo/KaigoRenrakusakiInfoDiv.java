package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoRenrakusakiInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoRenrakusakiInfo.SelectedContentsDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoRenrakusakiInfo.dgRenrakusaki_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoRenrakusakiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoRenrakusakiInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("btnDelete")
    private Button btnDelete;
    @JsonProperty("dgRenrakusaki")
    private DataGrid<dgRenrakusaki_Row> dgRenrakusaki;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("SelectedContents")
    private SelectedContentsDiv SelectedContents;
    @JsonProperty("hokenshaNo")
    private RString hokenshaNo;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("shoriKbn")
    private RString shoriKbn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd=btnAdd;
    }

    @JsonProperty("btnDelete")
    public Button getBtnDelete() {
        return btnDelete;
    }

    @JsonProperty("btnDelete")
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete=btnDelete;
    }

    @JsonProperty("dgRenrakusaki")
    public DataGrid<dgRenrakusaki_Row> getDgRenrakusaki() {
        return dgRenrakusaki;
    }

    @JsonProperty("dgRenrakusaki")
    public void setDgRenrakusaki(DataGrid<dgRenrakusaki_Row> dgRenrakusaki) {
        this.dgRenrakusaki=dgRenrakusaki;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    @JsonProperty("SelectedContents")
    public SelectedContentsDiv getSelectedContents() {
        return SelectedContents;
    }

    @JsonProperty("SelectedContents")
    public void setSelectedContents(SelectedContentsDiv SelectedContents) {
        this.SelectedContents=SelectedContents;
    }

    @JsonProperty("hokenshaNo")
    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    @JsonProperty("hokenshaNo")
    public void setHokenshaNo(RString hokenshaNo) {
        this.hokenshaNo=hokenshaNo;
    }

    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo=hihokenshaNo;
    }

    @JsonProperty("shoriKbn")
    public RString getShoriKbn() {
        return shoriKbn;
    }

    @JsonProperty("shoriKbn")
    public void setShoriKbn(RString shoriKbn) {
        this.shoriKbn=shoriKbn;
    }

}
