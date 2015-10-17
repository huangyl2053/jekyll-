package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.IHihokenshaFinderDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaInputGuide のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaInputGuideDiv extends Panel implements IHihokenshaInputGuideDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("HihokenshaFinder")
    private IHihokenshaFinderDiv HihokenshaFinder;
    @JsonProperty("lblSearchResultOfHihokensha")
    private Label lblSearchResultOfHihokensha;
    @JsonProperty("dgSearchResultOfHihokensha")
    private DataGrid<dgSearchResultOfHihokensha_Row> dgSearchResultOfHihokensha;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("hihokenshaMeisho")
    private RString hihokenshaMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaFinder")
    public IHihokenshaFinderDiv getHihokenshaFinder() {
        return HihokenshaFinder;
    }

    @JsonProperty("lblSearchResultOfHihokensha")
    public Label getLblSearchResultOfHihokensha() {
        return lblSearchResultOfHihokensha;
    }

    @JsonProperty("lblSearchResultOfHihokensha")
    public void setLblSearchResultOfHihokensha(Label lblSearchResultOfHihokensha) {
        this.lblSearchResultOfHihokensha = lblSearchResultOfHihokensha;
    }

    @JsonProperty("dgSearchResultOfHihokensha")
    public DataGrid<dgSearchResultOfHihokensha_Row> getDgSearchResultOfHihokensha() {
        return dgSearchResultOfHihokensha;
    }

    @JsonProperty("dgSearchResultOfHihokensha")
    public void setDgSearchResultOfHihokensha(DataGrid<dgSearchResultOfHihokensha_Row> dgSearchResultOfHihokensha) {
        this.dgSearchResultOfHihokensha = dgSearchResultOfHihokensha;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    @JsonProperty("hihokenshaMeisho")
    public RString getHihokenshaMeisho() {
        return hihokenshaMeisho;
    }

    @JsonProperty("hihokenshaMeisho")
    public void setHihokenshaMeisho(RString hihokenshaMeisho) {
        this.hihokenshaMeisho = hihokenshaMeisho;
    }

    //--------------- この行より下にコードを追加してください -------------------
}
