package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuJissekiSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKyufuJissekiSearchHihokenshaNo")
    private TextBoxCode txtKyufuJissekiSearchHihokenshaNo;
    @JsonProperty("radKyufuJissekiSearchDateType")
    private RadioButton radKyufuJissekiSearchDateType;
    @JsonProperty("ddlKyufuJissekiSearchNendo")
    private DropDownList ddlKyufuJissekiSearchNendo;
    @JsonProperty("txtKyufuJissekiSearchServiceTeikyoYM")
    private TextBoxDateRange txtKyufuJissekiSearchServiceTeikyoYM;
    @JsonProperty("btnKyufuJissekiSearchClear")
    private Button btnKyufuJissekiSearchClear;
    @JsonProperty("btnKyufuJissekiSearch")
    private Button btnKyufuJissekiSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKyufuJissekiSearchHihokenshaNo")
    public TextBoxCode getTxtKyufuJissekiSearchHihokenshaNo() {
        return txtKyufuJissekiSearchHihokenshaNo;
    }

    @JsonProperty("txtKyufuJissekiSearchHihokenshaNo")
    public void setTxtKyufuJissekiSearchHihokenshaNo(TextBoxCode txtKyufuJissekiSearchHihokenshaNo) {
        this.txtKyufuJissekiSearchHihokenshaNo=txtKyufuJissekiSearchHihokenshaNo;
    }

    @JsonProperty("radKyufuJissekiSearchDateType")
    public RadioButton getRadKyufuJissekiSearchDateType() {
        return radKyufuJissekiSearchDateType;
    }

    @JsonProperty("radKyufuJissekiSearchDateType")
    public void setRadKyufuJissekiSearchDateType(RadioButton radKyufuJissekiSearchDateType) {
        this.radKyufuJissekiSearchDateType=radKyufuJissekiSearchDateType;
    }

    @JsonProperty("ddlKyufuJissekiSearchNendo")
    public DropDownList getDdlKyufuJissekiSearchNendo() {
        return ddlKyufuJissekiSearchNendo;
    }

    @JsonProperty("ddlKyufuJissekiSearchNendo")
    public void setDdlKyufuJissekiSearchNendo(DropDownList ddlKyufuJissekiSearchNendo) {
        this.ddlKyufuJissekiSearchNendo=ddlKyufuJissekiSearchNendo;
    }

    @JsonProperty("txtKyufuJissekiSearchServiceTeikyoYM")
    public TextBoxDateRange getTxtKyufuJissekiSearchServiceTeikyoYM() {
        return txtKyufuJissekiSearchServiceTeikyoYM;
    }

    @JsonProperty("txtKyufuJissekiSearchServiceTeikyoYM")
    public void setTxtKyufuJissekiSearchServiceTeikyoYM(TextBoxDateRange txtKyufuJissekiSearchServiceTeikyoYM) {
        this.txtKyufuJissekiSearchServiceTeikyoYM=txtKyufuJissekiSearchServiceTeikyoYM;
    }

    @JsonProperty("btnKyufuJissekiSearchClear")
    public Button getBtnKyufuJissekiSearchClear() {
        return btnKyufuJissekiSearchClear;
    }

    @JsonProperty("btnKyufuJissekiSearchClear")
    public void setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.btnKyufuJissekiSearchClear=btnKyufuJissekiSearchClear;
    }

    @JsonProperty("btnKyufuJissekiSearch")
    public Button getBtnKyufuJissekiSearch() {
        return btnKyufuJissekiSearch;
    }

    @JsonProperty("btnKyufuJissekiSearch")
    public void setBtnKyufuJissekiSearch(Button btnKyufuJissekiSearch) {
        this.btnKyufuJissekiSearch=btnKyufuJissekiSearch;
    }

}
