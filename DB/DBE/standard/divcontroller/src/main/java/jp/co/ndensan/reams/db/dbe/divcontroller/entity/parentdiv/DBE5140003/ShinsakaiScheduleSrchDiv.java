package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140003;
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
 * ShinsakaiScheduleSrch のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiScheduleSrchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-10_08-47-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiKaisaiYoteiKikan")
    private TextBoxDateRange txtShinsakaiKaisaiYoteiKikan;
    @JsonProperty("ScheduleSpace")
    private Space ScheduleSpace;
    @JsonProperty("radPrintType")
    private RadioButton radPrintType;
    @JsonProperty("SchedulePrintOption")
    private SchedulePrintOptionDiv SchedulePrintOption;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiKaisaiYoteiKikan
     * @return txtShinsakaiKaisaiYoteiKikan
     */
    @JsonProperty("txtShinsakaiKaisaiYoteiKikan")
    public TextBoxDateRange getTxtShinsakaiKaisaiYoteiKikan() {
        return txtShinsakaiKaisaiYoteiKikan;
    }

    /*
     * settxtShinsakaiKaisaiYoteiKikan
     * @param txtShinsakaiKaisaiYoteiKikan txtShinsakaiKaisaiYoteiKikan
     */
    @JsonProperty("txtShinsakaiKaisaiYoteiKikan")
    public void setTxtShinsakaiKaisaiYoteiKikan(TextBoxDateRange txtShinsakaiKaisaiYoteiKikan) {
        this.txtShinsakaiKaisaiYoteiKikan = txtShinsakaiKaisaiYoteiKikan;
    }

    /*
     * getScheduleSpace
     * @return ScheduleSpace
     */
    @JsonProperty("ScheduleSpace")
    public Space getScheduleSpace() {
        return ScheduleSpace;
    }

    /*
     * setScheduleSpace
     * @param ScheduleSpace ScheduleSpace
     */
    @JsonProperty("ScheduleSpace")
    public void setScheduleSpace(Space ScheduleSpace) {
        this.ScheduleSpace = ScheduleSpace;
    }

    /*
     * getradPrintType
     * @return radPrintType
     */
    @JsonProperty("radPrintType")
    public RadioButton getRadPrintType() {
        return radPrintType;
    }

    /*
     * setradPrintType
     * @param radPrintType radPrintType
     */
    @JsonProperty("radPrintType")
    public void setRadPrintType(RadioButton radPrintType) {
        this.radPrintType = radPrintType;
    }

    /*
     * getSchedulePrintOption
     * @return SchedulePrintOption
     */
    @JsonProperty("SchedulePrintOption")
    public SchedulePrintOptionDiv getSchedulePrintOption() {
        return SchedulePrintOption;
    }

    /*
     * setSchedulePrintOption
     * @param SchedulePrintOption SchedulePrintOption
     */
    @JsonProperty("SchedulePrintOption")
    public void setSchedulePrintOption(SchedulePrintOptionDiv SchedulePrintOption) {
        this.SchedulePrintOption = SchedulePrintOption;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkShinsakaiScheduleKagami() {
        return this.getSchedulePrintOption().getChkShinsakaiScheduleKagami();
    }

    @JsonIgnore
    public void  setChkShinsakaiScheduleKagami(CheckBoxList chkShinsakaiScheduleKagami) {
        this.getSchedulePrintOption().setChkShinsakaiScheduleKagami(chkShinsakaiScheduleKagami);
    }

    @JsonIgnore
    public TextBoxDate getTxtNendo() {
        return this.getSchedulePrintOption().getTxtNendo();
    }

    @JsonIgnore
    public void  setTxtNendo(TextBoxDate txtNendo) {
        this.getSchedulePrintOption().setTxtNendo(txtNendo);
    }

    // </editor-fold>
}
