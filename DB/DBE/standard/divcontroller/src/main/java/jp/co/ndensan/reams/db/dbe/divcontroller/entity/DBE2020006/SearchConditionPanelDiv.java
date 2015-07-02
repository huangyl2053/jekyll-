package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020006;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
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

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlTaishoChiku")
    public DropDownList getDdlTaishoChiku() {
        return ddlTaishoChiku;
    }

    @JsonProperty("ddlTaishoChiku")
    public void setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.ddlTaishoChiku=ddlTaishoChiku;
    }

    @JsonProperty("txtSettingMonth")
    public TextBoxFlexibleDate getTxtSettingMonth() {
        return txtSettingMonth;
    }

    @JsonProperty("txtSettingMonth")
    public void setTxtSettingMonth(TextBoxFlexibleDate txtSettingMonth) {
        this.txtSettingMonth=txtSettingMonth;
    }

    @JsonProperty("btnPrevious")
    public Button getBtnPrevious() {
        return btnPrevious;
    }

    @JsonProperty("btnPrevious")
    public void setBtnPrevious(Button btnPrevious) {
        this.btnPrevious=btnPrevious;
    }

    @JsonProperty("btnNext")
    public Button getBtnNext() {
        return btnNext;
    }

    @JsonProperty("btnNext")
    public void setBtnNext(Button btnNext) {
        this.btnNext=btnNext;
    }

    @JsonProperty("txtNinteiChosaItakusakiCode")
    public TextBox getTxtNinteiChosaItakusakiCode() {
        return txtNinteiChosaItakusakiCode;
    }

    @JsonProperty("txtNinteiChosaItakusakiCode")
    public void setTxtNinteiChosaItakusakiCode(TextBox txtNinteiChosaItakusakiCode) {
        this.txtNinteiChosaItakusakiCode=txtNinteiChosaItakusakiCode;
    }

    @JsonProperty("txtNinteiChosaItakusakiName")
    public TextBox getTxtNinteiChosaItakusakiName() {
        return txtNinteiChosaItakusakiName;
    }

    @JsonProperty("txtNinteiChosaItakusakiName")
    public void setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.txtNinteiChosaItakusakiName=txtNinteiChosaItakusakiName;
    }

    @JsonProperty("txtNinteiChosainCode")
    public TextBox getTxtNinteiChosainCode() {
        return txtNinteiChosainCode;
    }

    @JsonProperty("txtNinteiChosainCode")
    public void setTxtNinteiChosainCode(TextBox txtNinteiChosainCode) {
        this.txtNinteiChosainCode=txtNinteiChosainCode;
    }

    @JsonProperty("txtNinteiChosainName")
    public TextBox getTxtNinteiChosainName() {
        return txtNinteiChosainName;
    }

    @JsonProperty("txtNinteiChosainName")
    public void setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.txtNinteiChosainName=txtNinteiChosainName;
    }

    @JsonProperty("btnSearch")
    public ButtonDialog getBtnSearch() {
        return btnSearch;
    }

    @JsonProperty("btnSearch")
    public void setBtnSearch(ButtonDialog btnSearch) {
        this.btnSearch=btnSearch;
    }

    // </editor-fold>
}
