package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHanteizumiDataShutsuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteizumiDataShutsuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SelectConditions")
    private SelectConditionsDiv SelectConditions;
    @JsonProperty("SelectResults")
    private SelectResultsDiv SelectResults;
    @JsonProperty("ShoriOptions")
    private ShoriOptionsDiv ShoriOptions;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSelectConditions
     * @return SelectConditions
     */
    @JsonProperty("SelectConditions")
    public SelectConditionsDiv getSelectConditions() {
        return SelectConditions;
    }

    /*
     * setSelectConditions
     * @param SelectConditions SelectConditions
     */
    @JsonProperty("SelectConditions")
    public void setSelectConditions(SelectConditionsDiv SelectConditions) {
        this.SelectConditions = SelectConditions;
    }

    /*
     * getSelectResults
     * @return SelectResults
     */
    @JsonProperty("SelectResults")
    public SelectResultsDiv getSelectResults() {
        return SelectResults;
    }

    /*
     * setSelectResults
     * @param SelectResults SelectResults
     */
    @JsonProperty("SelectResults")
    public void setSelectResults(SelectResultsDiv SelectResults) {
        this.SelectResults = SelectResults;
    }

    /*
     * getShoriOptions
     * @return ShoriOptions
     */
    @JsonProperty("ShoriOptions")
    public ShoriOptionsDiv getShoriOptions() {
        return ShoriOptions;
    }

    /*
     * setShoriOptions
     * @param ShoriOptions ShoriOptions
     */
    @JsonProperty("ShoriOptions")
    public void setShoriOptions(ShoriOptionsDiv ShoriOptions) {
        this.ShoriOptions = ShoriOptions;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadJyoken() {
        return this.getSelectConditions().getRadJyoken();
    }

    @JsonIgnore
    public void  setRadJyoken(RadioButton radJyoken) {
        this.getSelectConditions().setRadJyoken(radJyoken);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseibi() {
        return this.getSelectConditions().getTxtShinseibi();
    }

    @JsonIgnore
    public void  setTxtShinseibi(TextBoxDateRange txtShinseibi) {
        this.getSelectConditions().setTxtShinseibi(txtShinseibi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIchijiHanteibi() {
        return this.getSelectConditions().getTxtIchijiHanteibi();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteibi(TextBoxDateRange txtIchijiHanteibi) {
        this.getSelectConditions().setTxtIchijiHanteibi(txtIchijiHanteibi);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum() {
        return this.getSelectConditions().getTextBoxNum();
    }

    @JsonIgnore
    public void  setTextBoxNum(TextBoxNum TextBoxNum) {
        this.getSelectConditions().setTextBoxNum(TextBoxNum);
    }

    @JsonIgnore
    public Button getBtnKensakuClear() {
        return this.getSelectConditions().getBtnKensakuClear();
    }

    @JsonIgnore
    public void  setBtnKensakuClear(Button btnKensakuClear) {
        this.getSelectConditions().setBtnKensakuClear(btnKensakuClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getSelectConditions().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getSelectConditions().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public DataGrid<dgIchijiHanteiZumi_Row> getDgIchijiHanteiZumi() {
        return this.getSelectResults().getDgIchijiHanteiZumi();
    }

    @JsonIgnore
    public void  setDgIchijiHanteiZumi(DataGrid<dgIchijiHanteiZumi_Row> dgIchijiHanteiZumi) {
        this.getSelectResults().setDgIchijiHanteiZumi(dgIchijiHanteiZumi);
    }

    @JsonIgnore
    public Button getBtnCsvShutsuryoku() {
        return this.getShoriOptions().getBtnCsvShutsuryoku();
    }

    @JsonIgnore
    public void  setBtnCsvShutsuryoku(Button btnCsvShutsuryoku) {
        this.getShoriOptions().setBtnCsvShutsuryoku(btnCsvShutsuryoku);
    }

    @JsonIgnore
    public Button getBtnNinteiSoftyoDataShutsuryoku() {
        return this.getShoriOptions().getBtnNinteiSoftyoDataShutsuryoku();
    }

    @JsonIgnore
    public void  setBtnNinteiSoftyoDataShutsuryoku(Button btnNinteiSoftyoDataShutsuryoku) {
        this.getShoriOptions().setBtnNinteiSoftyoDataShutsuryoku(btnNinteiSoftyoDataShutsuryoku);
    }

    @JsonIgnore
    public Button getBtnIchijiHanteiKekkahyoShutsuryoku() {
        return this.getShoriOptions().getBtnIchijiHanteiKekkahyoShutsuryoku();
    }

    @JsonIgnore
    public void  setBtnIchijiHanteiKekkahyoShutsuryoku(Button btnIchijiHanteiKekkahyoShutsuryoku) {
        this.getShoriOptions().setBtnIchijiHanteiKekkahyoShutsuryoku(btnIchijiHanteiKekkahyoShutsuryoku);
    }

    // </editor-fold>
}
