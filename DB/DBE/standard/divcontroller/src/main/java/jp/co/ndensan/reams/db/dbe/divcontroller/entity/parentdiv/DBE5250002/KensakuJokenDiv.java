package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002;
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
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTeishutsuKigen")
    private RadioButton radTeishutsuKigen;
    @JsonProperty("txtTeishutsuKigenDateRange")
    private TextBoxDateRange txtTeishutsuKigenDateRange;
    @JsonProperty("labelHihokenshaNo")
    private Label labelHihokenshaNo;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("radDataShutsuryokuUmu")
    private RadioButton radDataShutsuryokuUmu;
    @JsonProperty("txtHyojiDataLimit")
    private TextBoxNum txtHyojiDataLimit;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnHyoji")
    private Button btnHyoji;
    @JsonProperty("ccdHokensha")
    private HokenshaListDiv ccdHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTeishutsuKigen
     * @return radTeishutsuKigen
     */
    @JsonProperty("radTeishutsuKigen")
    public RadioButton getRadTeishutsuKigen() {
        return radTeishutsuKigen;
    }

    /*
     * setradTeishutsuKigen
     * @param radTeishutsuKigen radTeishutsuKigen
     */
    @JsonProperty("radTeishutsuKigen")
    public void setRadTeishutsuKigen(RadioButton radTeishutsuKigen) {
        this.radTeishutsuKigen = radTeishutsuKigen;
    }

    /*
     * gettxtTeishutsuKigenDateRange
     * @return txtTeishutsuKigenDateRange
     */
    @JsonProperty("txtTeishutsuKigenDateRange")
    public TextBoxDateRange getTxtTeishutsuKigenDateRange() {
        return txtTeishutsuKigenDateRange;
    }

    /*
     * settxtTeishutsuKigenDateRange
     * @param txtTeishutsuKigenDateRange txtTeishutsuKigenDateRange
     */
    @JsonProperty("txtTeishutsuKigenDateRange")
    public void setTxtTeishutsuKigenDateRange(TextBoxDateRange txtTeishutsuKigenDateRange) {
        this.txtTeishutsuKigenDateRange = txtTeishutsuKigenDateRange;
    }

    /*
     * getlabelHihokenshaNo
     * @return labelHihokenshaNo
     */
    @JsonProperty("labelHihokenshaNo")
    public Label getLabelHihokenshaNo() {
        return labelHihokenshaNo;
    }

    /*
     * setlabelHihokenshaNo
     * @param labelHihokenshaNo labelHihokenshaNo
     */
    @JsonProperty("labelHihokenshaNo")
    public void setLabelHihokenshaNo(Label labelHihokenshaNo) {
        this.labelHihokenshaNo = labelHihokenshaNo;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * getradDataShutsuryokuUmu
     * @return radDataShutsuryokuUmu
     */
    @JsonProperty("radDataShutsuryokuUmu")
    public RadioButton getRadDataShutsuryokuUmu() {
        return radDataShutsuryokuUmu;
    }

    /*
     * setradDataShutsuryokuUmu
     * @param radDataShutsuryokuUmu radDataShutsuryokuUmu
     */
    @JsonProperty("radDataShutsuryokuUmu")
    public void setRadDataShutsuryokuUmu(RadioButton radDataShutsuryokuUmu) {
        this.radDataShutsuryokuUmu = radDataShutsuryokuUmu;
    }

    /*
     * gettxtHyojiDataLimit
     * @return txtHyojiDataLimit
     */
    @JsonProperty("txtHyojiDataLimit")
    public TextBoxNum getTxtHyojiDataLimit() {
        return txtHyojiDataLimit;
    }

    /*
     * settxtHyojiDataLimit
     * @param txtHyojiDataLimit txtHyojiDataLimit
     */
    @JsonProperty("txtHyojiDataLimit")
    public void setTxtHyojiDataLimit(TextBoxNum txtHyojiDataLimit) {
        this.txtHyojiDataLimit = txtHyojiDataLimit;
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
     * getbtnHyoji
     * @return btnHyoji
     */
    @JsonProperty("btnHyoji")
    public Button getBtnHyoji() {
        return btnHyoji;
    }

    /*
     * setbtnHyoji
     * @param btnHyoji btnHyoji
     */
    @JsonProperty("btnHyoji")
    public void setBtnHyoji(Button btnHyoji) {
        this.btnHyoji = btnHyoji;
    }

    /*
     * getccdHokensha
     * @return ccdHokensha
     */
    @JsonProperty("ccdHokensha")
    public IHokenshaListDiv getCcdHokensha() {
        return ccdHokensha;
    }

    // </editor-fold>
}
