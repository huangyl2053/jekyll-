package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBD5330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shujiiIryokikanandshujiiinput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNijiHanteiKikan")
    private TextBoxDateRange txtNijiHanteiKikan;
    @JsonProperty("radPrintCondition")
    private RadioButton radPrintCondition;
    @JsonProperty("radKekkaTsuchiOutputTaisho")
    private RadioButton radKekkaTsuchiOutputTaisho;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("ccdShujiiIryokikanAndShujiiInput")
    private ShujiiIryokikanAndShujiiInputDiv ccdShujiiIryokikanAndShujiiInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNijiHanteiKikan
     * @return txtNijiHanteiKikan
     */
    @JsonProperty("txtNijiHanteiKikan")
    public TextBoxDateRange getTxtNijiHanteiKikan() {
        return txtNijiHanteiKikan;
    }

    /*
     * settxtNijiHanteiKikan
     * @param txtNijiHanteiKikan txtNijiHanteiKikan
     */
    @JsonProperty("txtNijiHanteiKikan")
    public void setTxtNijiHanteiKikan(TextBoxDateRange txtNijiHanteiKikan) {
        this.txtNijiHanteiKikan = txtNijiHanteiKikan;
    }

    /*
     * getradPrintCondition
     * @return radPrintCondition
     */
    @JsonProperty("radPrintCondition")
    public RadioButton getRadPrintCondition() {
        return radPrintCondition;
    }

    /*
     * setradPrintCondition
     * @param radPrintCondition radPrintCondition
     */
    @JsonProperty("radPrintCondition")
    public void setRadPrintCondition(RadioButton radPrintCondition) {
        this.radPrintCondition = radPrintCondition;
    }

    /*
     * getradKekkaTsuchiOutputTaisho
     * @return radKekkaTsuchiOutputTaisho
     */
    @JsonProperty("radKekkaTsuchiOutputTaisho")
    public RadioButton getRadKekkaTsuchiOutputTaisho() {
        return radKekkaTsuchiOutputTaisho;
    }

    /*
     * setradKekkaTsuchiOutputTaisho
     * @param radKekkaTsuchiOutputTaisho radKekkaTsuchiOutputTaisho
     */
    @JsonProperty("radKekkaTsuchiOutputTaisho")
    public void setRadKekkaTsuchiOutputTaisho(RadioButton radKekkaTsuchiOutputTaisho) {
        this.radKekkaTsuchiOutputTaisho = radKekkaTsuchiOutputTaisho;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * getccdShujiiIryokikanAndShujiiInput
     * @return ccdShujiiIryokikanAndShujiiInput
     */
    @JsonProperty("ccdShujiiIryokikanAndShujiiInput")
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return ccdShujiiIryokikanAndShujiiInput;
    }

    // </editor-fold>
}
