package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNijiHanteiKikan")
    private TextBoxDateRange txtNijiHanteiKikan;
    @JsonProperty("radKekkaTsuchiOutputTaisho")
    private RadioButton radKekkaTsuchiOutputTaisho;
    @JsonProperty("txtDispMax")
    private TextBoxNum txtDispMax;
    @JsonProperty("btnClear")
    private Button btnClear;
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
     * gettxtDispMax
     * @return txtDispMax
     */
    @JsonProperty("txtDispMax")
    public TextBoxNum getTxtDispMax() {
        return txtDispMax;
    }

    /*
     * settxtDispMax
     * @param txtDispMax txtDispMax
     */
    @JsonProperty("txtDispMax")
    public void setTxtDispMax(TextBoxNum txtDispMax) {
        this.txtDispMax = txtDispMax;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
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
