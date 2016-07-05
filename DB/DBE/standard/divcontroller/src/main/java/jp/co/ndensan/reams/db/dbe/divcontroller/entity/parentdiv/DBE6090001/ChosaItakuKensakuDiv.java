package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaItakuKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakuKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chosainShimei")
    private TextBox chosainShimei;
    @JsonProperty("ddlHihokenshaNameMatchType")
    private DropDownList ddlHihokenshaNameMatchType;
    @JsonProperty("txtKensakuNendo")
    private TextBoxDateRange txtKensakuNendo;
    @JsonProperty("TextBoxNum")
    private TextBoxNum TextBoxNum;
    @JsonProperty("btnKyufuJissekiSearchClear")
    private Button btnKyufuJissekiSearchClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchosainShimei
     * @return chosainShimei
     */
    @JsonProperty("chosainShimei")
    public TextBox getChosainShimei() {
        return chosainShimei;
    }

    /*
     * setchosainShimei
     * @param chosainShimei chosainShimei
     */
    @JsonProperty("chosainShimei")
    public void setChosainShimei(TextBox chosainShimei) {
        this.chosainShimei = chosainShimei;
    }

    /*
     * getddlHihokenshaNameMatchType
     * @return ddlHihokenshaNameMatchType
     */
    @JsonProperty("ddlHihokenshaNameMatchType")
    public DropDownList getDdlHihokenshaNameMatchType() {
        return ddlHihokenshaNameMatchType;
    }

    /*
     * setddlHihokenshaNameMatchType
     * @param ddlHihokenshaNameMatchType ddlHihokenshaNameMatchType
     */
    @JsonProperty("ddlHihokenshaNameMatchType")
    public void setDdlHihokenshaNameMatchType(DropDownList ddlHihokenshaNameMatchType) {
        this.ddlHihokenshaNameMatchType = ddlHihokenshaNameMatchType;
    }

    /*
     * gettxtKensakuNendo
     * @return txtKensakuNendo
     */
    @JsonProperty("txtKensakuNendo")
    public TextBoxDateRange getTxtKensakuNendo() {
        return txtKensakuNendo;
    }

    /*
     * settxtKensakuNendo
     * @param txtKensakuNendo txtKensakuNendo
     */
    @JsonProperty("txtKensakuNendo")
    public void setTxtKensakuNendo(TextBoxDateRange txtKensakuNendo) {
        this.txtKensakuNendo = txtKensakuNendo;
    }

    /*
     * getTextBoxNum
     * @return TextBoxNum
     */
    @JsonProperty("TextBoxNum")
    public TextBoxNum getTextBoxNum() {
        return TextBoxNum;
    }

    /*
     * setTextBoxNum
     * @param TextBoxNum TextBoxNum
     */
    @JsonProperty("TextBoxNum")
    public void setTextBoxNum(TextBoxNum TextBoxNum) {
        this.TextBoxNum = TextBoxNum;
    }

    /*
     * getbtnKyufuJissekiSearchClear
     * @return btnKyufuJissekiSearchClear
     */
    @JsonProperty("btnKyufuJissekiSearchClear")
    public Button getBtnKyufuJissekiSearchClear() {
        return btnKyufuJissekiSearchClear;
    }

    /*
     * setbtnKyufuJissekiSearchClear
     * @param btnKyufuJissekiSearchClear btnKyufuJissekiSearchClear
     */
    @JsonProperty("btnKyufuJissekiSearchClear")
    public void setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.btnKyufuJissekiSearchClear = btnKyufuJissekiSearchClear;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
