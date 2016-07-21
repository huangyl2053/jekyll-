package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

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
    @JsonProperty("txtNijiHanteiKikan")
    private TextBoxDateRange txtNijiHanteiKikan;
    @JsonProperty("radPrintCondition")
    private RadioButton radPrintCondition;
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
    @JsonProperty("txtNijiHanteiKikan")
    public TextBoxDateRange getTxtNijiHanteiKikan() {
        return txtNijiHanteiKikan;
    }

    @JsonProperty("txtNijiHanteiKikan")
    public void setTxtNijiHanteiKikan(TextBoxDateRange txtNijiHanteiKikan) {
        this.txtNijiHanteiKikan = txtNijiHanteiKikan;
    }

    @JsonProperty("radPrintCondition")
    public RadioButton getRadPrintCondition() {
        return radPrintCondition;
    }

    @JsonProperty("radPrintCondition")
    public void setRadPrintCondition(RadioButton radPrintCondition) {
        this.radPrintCondition = radPrintCondition;
    }

    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    @JsonProperty("ccdShujiiIryokikanAndShujiiInput")
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return ccdShujiiIryokikanAndShujiiInput;
    }

    // </editor-fold>
}
