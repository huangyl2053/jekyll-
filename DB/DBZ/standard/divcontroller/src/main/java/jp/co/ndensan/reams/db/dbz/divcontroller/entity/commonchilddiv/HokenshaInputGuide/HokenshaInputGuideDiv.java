package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaInputGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;

/**
 * HokenshaInputGuide のクラスファイル
 *
 * @reamsid_L DBA-0180-010 lishengli
 */
public class HokenshaInputGuideDiv extends Panel implements IHokenshaInputGuideDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
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
    /*
     * getddlHokenshaKenCode
     * @return ddlHokenshaKenCode
     */
    @JsonProperty("ddlHokenshaKenCode")
    public DropDownList getDdlHokenshaKenCode() {
        return ddlHokenshaKenCode;
    }

    /*
     * setddlHokenshaKenCode
     * @param ddlHokenshaKenCode ddlHokenshaKenCode
     */
    @JsonProperty("ddlHokenshaKenCode")
    public void setDdlHokenshaKenCode(DropDownList ddlHokenshaKenCode) {
        this.ddlHokenshaKenCode = ddlHokenshaKenCode;
    }

    /*
     * getbtnSearchGaitoHokensha
     * @return btnSearchGaitoHokensha
     */
    @JsonProperty("btnSearchGaitoHokensha")
    public Button getBtnSearchGaitoHokensha() {
        return btnSearchGaitoHokensha;
    }

    /*
     * setbtnSearchGaitoHokensha
     * @param btnSearchGaitoHokensha btnSearchGaitoHokensha
     */
    @JsonProperty("btnSearchGaitoHokensha")
    public void setBtnSearchGaitoHokensha(Button btnSearchGaitoHokensha) {
        this.btnSearchGaitoHokensha = btnSearchGaitoHokensha;
    }

    /*
     * getSearchResultHokensha
     * @return SearchResultHokensha
     */
    @JsonProperty("SearchResultHokensha")
    public SearchResultHokenshaDiv getSearchResultHokensha() {
        return SearchResultHokensha;
    }

    /*
     * setSearchResultHokensha
     * @param SearchResultHokensha SearchResultHokensha
     */
    @JsonProperty("SearchResultHokensha")
    public void setSearchResultHokensha(SearchResultHokenshaDiv SearchResultHokensha) {
        this.SearchResultHokensha = SearchResultHokensha;
    }

    /*
     * getbtnHokenshaReturn
     * @return btnHokenshaReturn
     */
    @JsonProperty("btnHokenshaReturn")
    public Button getBtnHokenshaReturn() {
        return btnHokenshaReturn;
    }

    /*
     * setbtnHokenshaReturn
     * @param btnHokenshaReturn btnHokenshaReturn
     */
    @JsonProperty("btnHokenshaReturn")
    public void setBtnHokenshaReturn(Button btnHokenshaReturn) {
        this.btnHokenshaReturn = btnHokenshaReturn;
    }

    /*
     * gethokenshaNo
     * @return hokenshaNo
     */
    @JsonProperty("hokenshaNo")
    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    /*
     * sethokenshaNo
     * @param hokenshaNo hokenshaNo
     */
    @JsonProperty("hokenshaNo")
    public void setHokenshaNo(RString hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /*
     * gethokenshaMeisho
     * @return hokenshaMeisho
     */
    @JsonProperty("hokenshaMeisho")
    public RString getHokenshaMeisho() {
        return hokenshaMeisho;
    }

    /*
     * sethokenshaMeisho
     * @param hokenshaMeisho hokenshaMeisho
     */
    @JsonProperty("hokenshaMeisho")
    public void setHokenshaMeisho(RString hokenshaMeisho) {
        this.hokenshaMeisho = hokenshaMeisho;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
