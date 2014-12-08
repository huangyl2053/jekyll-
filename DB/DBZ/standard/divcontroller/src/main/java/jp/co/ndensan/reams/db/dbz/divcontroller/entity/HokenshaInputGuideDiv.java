package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IHokenshaInputGuideDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchResultHokenshaDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HokenshaInputGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenshaInputGuideDiv extends Panel implements IHokenshaInputGuideDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokenshaKenCode")
    private DropDownList ddlHokenshaKenCode;
    @JsonProperty("btnSearchGaitoHokensha")
    private Button btnSearchGaitoHokensha;
    @JsonProperty("SearchResultHokensha")
    private SearchResultHokenshaDiv SearchResultHokensha;
    @JsonProperty("btnHokenshaReturn")
    private Button btnHokenshaReturn;
    @JsonProperty("hokenshaNo")
    private RString hokenshaNo;
    @JsonProperty("hokenshaMeisho")
    private RString hokenshaMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlHokenshaKenCode")
    public DropDownList getDdlHokenshaKenCode() {
        return ddlHokenshaKenCode;
    }

    @JsonProperty("ddlHokenshaKenCode")
    public void setDdlHokenshaKenCode(DropDownList ddlHokenshaKenCode) {
        this.ddlHokenshaKenCode=ddlHokenshaKenCode;
    }

    @JsonProperty("btnSearchGaitoHokensha")
    public Button getBtnSearchGaitoHokensha() {
        return btnSearchGaitoHokensha;
    }

    @JsonProperty("btnSearchGaitoHokensha")
    public void setBtnSearchGaitoHokensha(Button btnSearchGaitoHokensha) {
        this.btnSearchGaitoHokensha=btnSearchGaitoHokensha;
    }

    @JsonProperty("SearchResultHokensha")
    public SearchResultHokenshaDiv getSearchResultHokensha() {
        return SearchResultHokensha;
    }

    @JsonProperty("SearchResultHokensha")
    public void setSearchResultHokensha(SearchResultHokenshaDiv SearchResultHokensha) {
        this.SearchResultHokensha=SearchResultHokensha;
    }

    @JsonProperty("btnHokenshaReturn")
    public Button getBtnHokenshaReturn() {
        return btnHokenshaReturn;
    }

    @JsonProperty("btnHokenshaReturn")
    public void setBtnHokenshaReturn(Button btnHokenshaReturn) {
        this.btnHokenshaReturn=btnHokenshaReturn;
    }

    @JsonProperty("hokenshaNo")
    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    @JsonProperty("hokenshaNo")
    public void setHokenshaNo(RString hokenshaNo) {
        this.hokenshaNo=hokenshaNo;
    }

    @JsonProperty("hokenshaMeisho")
    public RString getHokenshaMeisho() {
        return hokenshaMeisho;
    }

    @JsonProperty("hokenshaMeisho")
    public void setHokenshaMeisho(RString hokenshaMeisho) {
        this.hokenshaMeisho=hokenshaMeisho;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
