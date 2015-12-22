package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ShoKaishuKirokuKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoKaishuKirokuKanriDiv extends Panel implements IShoKaishuKirokuKanriDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelKoufuList")
    private panelKoufuListDiv panelKoufuList;
    @JsonProperty("panelInput")
    private panelInputDiv panelInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelKoufuList
     * @return panelKoufuList
     */
    @JsonProperty("panelKoufuList")
    public panelKoufuListDiv getPanelKoufuList() {
        return panelKoufuList;
    }

    /*
     * setpanelKoufuList
     * @param panelKoufuList panelKoufuList
     */
    @JsonProperty("panelKoufuList")
    public void setPanelKoufuList(panelKoufuListDiv panelKoufuList) {
        this.panelKoufuList = panelKoufuList;
    }

    /*
     * getpanelInput
     * @return panelInput
     */
    @JsonProperty("panelInput")
    public panelInputDiv getPanelInput() {
        return panelInput;
    }

    /*
     * setpanelInput
     * @param panelInput panelInput
     */
    @JsonProperty("panelInput")
    public void setPanelInput(panelInputDiv panelInput) {
        this.panelInput = panelInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKoufuKaishu_Row> getDgKoufuKaishu() {
        return this.getPanelKoufuList().getDgKoufuKaishu();
    }

    @JsonIgnore
    public void  setDgKoufuKaishu(DataGrid<dgKoufuKaishu_Row> dgKoufuKaishu) {
        this.getPanelKoufuList().setDgKoufuKaishu(dgKoufuKaishu);
    }

    @JsonIgnore
    public TextBox getTxtKoufuType() {
        return this.getPanelInput().getTxtKoufuType();
    }

    @JsonIgnore
    public void  setTxtKoufuType(TextBox txtKoufuType) {
        this.getPanelInput().setTxtKoufuType(txtKoufuType);
    }

    @JsonIgnore
    public TextBoxDate getTxtKoufuDate() {
        return this.getPanelInput().getTxtKoufuDate();
    }

    @JsonIgnore
    public void  setTxtKoufuDate(TextBoxDate txtKoufuDate) {
        this.getPanelInput().setTxtKoufuDate(txtKoufuDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukouKigen() {
        return this.getPanelInput().getTxtYukouKigen();
    }

    @JsonIgnore
    public void  setTxtYukouKigen(TextBoxDate txtYukouKigen) {
        this.getPanelInput().setTxtYukouKigen(txtYukouKigen);
    }

    @JsonIgnore
    public DropDownList getDdlKoufuJiyu() {
        return this.getPanelInput().getDdlKoufuJiyu();
    }

    @JsonIgnore
    public void  setDdlKoufuJiyu(DropDownList ddlKoufuJiyu) {
        this.getPanelInput().setDdlKoufuJiyu(ddlKoufuJiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxaKoufuRiyu() {
        return this.getPanelInput().getTxaKoufuRiyu();
    }

    @JsonIgnore
    public void  setTxaKoufuRiyu(TextBoxMultiLine txaKoufuRiyu) {
        this.getPanelInput().setTxaKoufuRiyu(txaKoufuRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaisyuDate() {
        return this.getPanelInput().getTxtKaisyuDate();
    }

    @JsonIgnore
    public void  setTxtKaisyuDate(TextBoxDate txtKaisyuDate) {
        this.getPanelInput().setTxtKaisyuDate(txtKaisyuDate);
    }

    @JsonIgnore
    public DropDownList getDdlKaisyuJiyu() {
        return this.getPanelInput().getDdlKaisyuJiyu();
    }

    @JsonIgnore
    public void  setDdlKaisyuJiyu(DropDownList ddlKaisyuJiyu) {
        this.getPanelInput().setDdlKaisyuJiyu(ddlKaisyuJiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxaKaishuRiyu() {
        return this.getPanelInput().getTxaKaishuRiyu();
    }

    @JsonIgnore
    public void  setTxaKaishuRiyu(TextBoxMultiLine txaKaishuRiyu) {
        this.getPanelInput().setTxaKaishuRiyu(txaKaishuRiyu);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getPanelInput().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getPanelInput().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelInput().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelInput().setBtnCancel(btnCancel);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
