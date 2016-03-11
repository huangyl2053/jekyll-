package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020006;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTaishoChiku")
    private DropDownList ddlTaishoChiku;
    @JsonProperty("txtSettingMonth")
    private TextBoxFlexibleDate txtSettingMonth;
    @JsonProperty("btnPrevious")
    private Button btnPrevious;
    @JsonProperty("btnNext")
    private Button btnNext;
    @JsonProperty("txtNinteiChosaItakusakiCode")
    private TextBox txtNinteiChosaItakusakiCode;
    @JsonProperty("txtNinteiChosaItakusakiName")
    private TextBox txtNinteiChosaItakusakiName;
    @JsonProperty("txtNinteiChosainCode")
    private TextBox txtNinteiChosainCode;
    @JsonProperty("txtNinteiChosainName")
    private TextBox txtNinteiChosainName;
    @JsonProperty("btnSearch")
    private ButtonDialog btnSearch;
    @JsonProperty("hiddenShichosonCode")
    private RString hiddenShichosonCode;
    @JsonProperty("taishoChikuKey")
    private RString taishoChikuKey;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTaishoChiku
     * @return ddlTaishoChiku
     */
    @JsonProperty("ddlTaishoChiku")
    public DropDownList getDdlTaishoChiku() {
        return ddlTaishoChiku;
    }

    /*
     * setddlTaishoChiku
     * @param ddlTaishoChiku ddlTaishoChiku
     */
    @JsonProperty("ddlTaishoChiku")
    public void setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.ddlTaishoChiku = ddlTaishoChiku;
    }

    /*
     * gettxtSettingMonth
     * @return txtSettingMonth
     */
    @JsonProperty("txtSettingMonth")
    public TextBoxFlexibleDate getTxtSettingMonth() {
        return txtSettingMonth;
    }

    /*
     * settxtSettingMonth
     * @param txtSettingMonth txtSettingMonth
     */
    @JsonProperty("txtSettingMonth")
    public void setTxtSettingMonth(TextBoxFlexibleDate txtSettingMonth) {
        this.txtSettingMonth = txtSettingMonth;
    }

    /*
     * getbtnPrevious
     * @return btnPrevious
     */
    @JsonProperty("btnPrevious")
    public Button getBtnPrevious() {
        return btnPrevious;
    }

    /*
     * setbtnPrevious
     * @param btnPrevious btnPrevious
     */
    @JsonProperty("btnPrevious")
    public void setBtnPrevious(Button btnPrevious) {
        this.btnPrevious = btnPrevious;
    }

    /*
     * getbtnNext
     * @return btnNext
     */
    @JsonProperty("btnNext")
    public Button getBtnNext() {
        return btnNext;
    }

    /*
     * setbtnNext
     * @param btnNext btnNext
     */
    @JsonProperty("btnNext")
    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

    /*
     * gettxtNinteiChosaItakusakiCode
     * @return txtNinteiChosaItakusakiCode
     */
    @JsonProperty("txtNinteiChosaItakusakiCode")
    public TextBox getTxtNinteiChosaItakusakiCode() {
        return txtNinteiChosaItakusakiCode;
    }

    /*
     * settxtNinteiChosaItakusakiCode
     * @param txtNinteiChosaItakusakiCode txtNinteiChosaItakusakiCode
     */
    @JsonProperty("txtNinteiChosaItakusakiCode")
    public void setTxtNinteiChosaItakusakiCode(TextBox txtNinteiChosaItakusakiCode) {
        this.txtNinteiChosaItakusakiCode = txtNinteiChosaItakusakiCode;
    }

    /*
     * gettxtNinteiChosaItakusakiName
     * @return txtNinteiChosaItakusakiName
     */
    @JsonProperty("txtNinteiChosaItakusakiName")
    public TextBox getTxtNinteiChosaItakusakiName() {
        return txtNinteiChosaItakusakiName;
    }

    /*
     * settxtNinteiChosaItakusakiName
     * @param txtNinteiChosaItakusakiName txtNinteiChosaItakusakiName
     */
    @JsonProperty("txtNinteiChosaItakusakiName")
    public void setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.txtNinteiChosaItakusakiName = txtNinteiChosaItakusakiName;
    }

    /*
     * gettxtNinteiChosainCode
     * @return txtNinteiChosainCode
     */
    @JsonProperty("txtNinteiChosainCode")
    public TextBox getTxtNinteiChosainCode() {
        return txtNinteiChosainCode;
    }

    /*
     * settxtNinteiChosainCode
     * @param txtNinteiChosainCode txtNinteiChosainCode
     */
    @JsonProperty("txtNinteiChosainCode")
    public void setTxtNinteiChosainCode(TextBox txtNinteiChosainCode) {
        this.txtNinteiChosainCode = txtNinteiChosainCode;
    }

    /*
     * gettxtNinteiChosainName
     * @return txtNinteiChosainName
     */
    @JsonProperty("txtNinteiChosainName")
    public TextBox getTxtNinteiChosainName() {
        return txtNinteiChosainName;
    }

    /*
     * settxtNinteiChosainName
     * @param txtNinteiChosainName txtNinteiChosainName
     */
    @JsonProperty("txtNinteiChosainName")
    public void setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.txtNinteiChosainName = txtNinteiChosainName;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public ButtonDialog getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(ButtonDialog btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * gethiddenShichosonCode
     * @return hiddenShichosonCode
     */
    @JsonProperty("hiddenShichosonCode")
    public RString getHiddenShichosonCode() {
        return hiddenShichosonCode;
    }

    /*
     * sethiddenShichosonCode
     * @param hiddenShichosonCode hiddenShichosonCode
     */
    @JsonProperty("hiddenShichosonCode")
    public void setHiddenShichosonCode(RString hiddenShichosonCode) {
        this.hiddenShichosonCode = hiddenShichosonCode;
    }

    /*
     * gettaishoChikuKey
     * @return taishoChikuKey
     */
    @JsonProperty("taishoChikuKey")
    public RString getTaishoChikuKey() {
        return taishoChikuKey;
    }

    /*
     * settaishoChikuKey
     * @param taishoChikuKey taishoChikuKey
     */
    @JsonProperty("taishoChikuKey")
    public void setTaishoChikuKey(RString taishoChikuKey) {
        this.taishoChikuKey = taishoChikuKey;
    }

    // </editor-fold>
}
