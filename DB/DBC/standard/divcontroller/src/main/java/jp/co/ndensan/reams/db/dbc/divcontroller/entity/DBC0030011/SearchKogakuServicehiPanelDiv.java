package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.SearchKogakuHihokenshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.SearchYMDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchKogakuServicehiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchKogakuServicehiPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("radSearchKubun")
    private RadioButton radSearchKubun;
    @JsonProperty("SearchKogakuHihokensha")
    private SearchKogakuHihokenshaDiv SearchKogakuHihokensha;
    @JsonProperty("SearchYM")
    private SearchYMDiv SearchYM;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnSearch")
    private Button btnSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("radSearchKubun")
    public RadioButton getRadSearchKubun() {
        return radSearchKubun;
    }

    @JsonProperty("radSearchKubun")
    public void setRadSearchKubun(RadioButton radSearchKubun) {
        this.radSearchKubun=radSearchKubun;
    }

    @JsonProperty("SearchKogakuHihokensha")
    public SearchKogakuHihokenshaDiv getSearchKogakuHihokensha() {
        return SearchKogakuHihokensha;
    }

    @JsonProperty("SearchKogakuHihokensha")
    public void setSearchKogakuHihokensha(SearchKogakuHihokenshaDiv SearchKogakuHihokensha) {
        this.SearchKogakuHihokensha=SearchKogakuHihokensha;
    }

    @JsonProperty("SearchYM")
    public SearchYMDiv getSearchYM() {
        return SearchYM;
    }

    @JsonProperty("SearchYM")
    public void setSearchYM(SearchYMDiv SearchYM) {
        this.SearchYM=SearchYM;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch=btnSearch;
    }

}
