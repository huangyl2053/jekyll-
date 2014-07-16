package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaDetailDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchCriteriaOfHihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchCriteriaOfHihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtTuchishoNo")
    private TextBoxCode txtTuchishoNo;
    @JsonProperty("ddlFukaNendo")
    private DropDownList ddlFukaNendo;
    @JsonProperty("SearchCriteriaDetail")
    private SearchCriteriaDetailDiv SearchCriteriaDetail;

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

    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtTuchishoNo")
    public TextBoxCode getTxtTuchishoNo() {
        return txtTuchishoNo;
    }

    @JsonProperty("txtTuchishoNo")
    public void setTxtTuchishoNo(TextBoxCode txtTuchishoNo) {
        this.txtTuchishoNo=txtTuchishoNo;
    }

    @JsonProperty("ddlFukaNendo")
    public DropDownList getDdlFukaNendo() {
        return ddlFukaNendo;
    }

    @JsonProperty("ddlFukaNendo")
    public void setDdlFukaNendo(DropDownList ddlFukaNendo) {
        this.ddlFukaNendo=ddlFukaNendo;
    }

    @JsonProperty("SearchCriteriaDetail")
    public SearchCriteriaDetailDiv getSearchCriteriaDetail() {
        return SearchCriteriaDetail;
    }

    @JsonProperty("SearchCriteriaDetail")
    public void setSearchCriteriaDetail(SearchCriteriaDetailDiv SearchCriteriaDetail) {
        this.SearchCriteriaDetail=SearchCriteriaDetail;
    }

}
