package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * KensakuOption のクラスファイル 
 * @reamsid_L DBE-0210-010 dongyabin
 * @author 自動生成
 */
public class KensakuOptionDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkKensakuOption")
    private CheckBoxList chkKensakuOption;
    @JsonProperty("txtMaximumDisplayNumber")
    private TextBox txtMaximumDisplayNumber;
    @JsonProperty("btnConditionClear")
    private Button btnConditionClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkKensakuOption
     * @return chkKensakuOption
     */
    @JsonProperty("chkKensakuOption")
    public CheckBoxList getChkKensakuOption() {
        return chkKensakuOption;
    }

    /*
     * setchkKensakuOption
     * @param chkKensakuOption chkKensakuOption
     */
    @JsonProperty("chkKensakuOption")
    public void setChkKensakuOption(CheckBoxList chkKensakuOption) {
        this.chkKensakuOption = chkKensakuOption;
    }

    /*
     * gettxtMaximumDisplayNumber
     * @return txtMaximumDisplayNumber
     */
    @JsonProperty("txtMaximumDisplayNumber")
    public TextBox getTxtMaximumDisplayNumber() {
        return txtMaximumDisplayNumber;
    }

    /*
     * settxtMaximumDisplayNumber
     * @param txtMaximumDisplayNumber txtMaximumDisplayNumber
     */
    @JsonProperty("txtMaximumDisplayNumber")
    public void setTxtMaximumDisplayNumber(TextBox txtMaximumDisplayNumber) {
        this.txtMaximumDisplayNumber = txtMaximumDisplayNumber;
    }

    /*
     * getbtnConditionClear
     * @return btnConditionClear
     */
    @JsonProperty("btnConditionClear")
    public Button getBtnConditionClear() {
        return btnConditionClear;
    }

    /*
     * setbtnConditionClear
     * @param btnConditionClear btnConditionClear
     */
    @JsonProperty("btnConditionClear")
    public void setBtnConditionClear(Button btnConditionClear) {
        this.btnConditionClear = btnConditionClear;
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

    // </editor-fold>
}
