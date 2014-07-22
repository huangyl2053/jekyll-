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
    @JsonProperty("dgRenrakusaki")
    private DataGrid<dgRenrakusaki_Row> dgRenrakusaki;
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("btnDelete")
    private Button btnDelete;
    @JsonProperty("SelectedContents")
    private SelectedContentsDiv SelectedContents;
    @JsonProperty("btnKoshin")
    private Button btnKoshin;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnReturn")
    private Button btnReturn;
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
    @JsonProperty("dgRenrakusaki")
    public DataGrid<dgRenrakusaki_Row> getDgRenrakusaki() {
        return dgRenrakusaki;
    }

    @JsonProperty("dgRenrakusaki")
    public void setDgRenrakusaki(DataGrid<dgRenrakusaki_Row> dgRenrakusaki) {
        this.dgRenrakusaki=dgRenrakusaki;
    }

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

    @JsonProperty("SelectedContents")
    public SelectedContentsDiv getSelectedContents() {
        return SelectedContents;
    }

    @JsonProperty("SelectedContents")
    public void setSelectedContents(SelectedContentsDiv SelectedContents) {
        this.SelectedContents=SelectedContents;
    }

    @JsonProperty("btnKoshin")
    public Button getBtnKoshin() {
        return btnKoshin;
    }

    @JsonProperty("btnKoshin")
    public void setBtnKoshin(Button btnKoshin) {
        this.btnKoshin=btnKoshin;
    }

    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei=btnKakutei;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn=btnReturn;
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
