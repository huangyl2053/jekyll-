package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * DBC5150011Main のクラスファイル
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class DBC5150011MainDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ShutsuryokuTaisho")
    private ShutsuryokuTaishoDiv ShutsuryokuTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getShutsuryokuTaisho
     * @return ShutsuryokuTaisho
     */
    @JsonProperty("ShutsuryokuTaisho")
    public ShutsuryokuTaishoDiv getShutsuryokuTaisho() {
        return ShutsuryokuTaisho;
    }

    /*
     * setShutsuryokuTaisho
     * @param ShutsuryokuTaisho ShutsuryokuTaisho
     */
    @JsonProperty("ShutsuryokuTaisho")
    public void setShutsuryokuTaisho(ShutsuryokuTaishoDiv ShutsuryokuTaisho) {
        this.ShutsuryokuTaisho = ShutsuryokuTaisho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtKijyouDate() {
        return this.getChushutsuJoken().getTxtKijyouDate();
    }

    @JsonIgnore
    public void setTxtKijyouDate(TextBoxDate txtKijyouDate) {
        this.getChushutsuJoken().setTxtKijyouDate(txtKijyouDate);
    }

    @JsonIgnore
    public RadioButton getRadMeisaiGokeiOut() {
        return this.getChushutsuJoken().getRadMeisaiGokeiOut();
    }

    @JsonIgnore
    public void setRadMeisaiGokeiOut(RadioButton radMeisaiGokeiOut) {
        this.getChushutsuJoken().setRadMeisaiGokeiOut(radMeisaiGokeiOut);
    }

    @JsonIgnore
    public panServiceSyuruiDiv getPanServiceSyurui() {
        return this.getChushutsuJoken().getPanServiceSyurui();
    }

    @JsonIgnore
    public void setPanServiceSyurui(panServiceSyuruiDiv panServiceSyurui) {
        this.getChushutsuJoken().setPanServiceSyurui(panServiceSyurui);
    }

    @JsonIgnore
    public ButtonDialog getBtnServiceCode() {
        return this.getChushutsuJoken().getPanServiceSyurui().getBtnServiceCode();
    }

    @JsonIgnore
    public void setBtnServiceCode(ButtonDialog btnServiceCode) {
        this.getChushutsuJoken().getPanServiceSyurui().setBtnServiceCode(btnServiceCode);
    }

    @JsonIgnore
    public TextBoxCode getTxtSyuruiCode() {
        return this.getChushutsuJoken().getPanServiceSyurui().getTxtSyuruiCode();
    }

    @JsonIgnore
    public void setTxtSyuruiCode(TextBoxCode txtSyuruiCode) {
        this.getChushutsuJoken().getPanServiceSyurui().setTxtSyuruiCode(txtSyuruiCode);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode() {
        return this.getChushutsuJoken().getPanServiceSyurui().getTxtServiceCode();
    }

    @JsonIgnore
    public void setTxtServiceCode(TextBoxCode txtServiceCode) {
        this.getChushutsuJoken().getPanServiceSyurui().setTxtServiceCode(txtServiceCode);
    }

    @JsonIgnore
    public DataGrid<dgServiceShuruiList_Row> getDgServiceShuruiList() {
        return this.getChushutsuJoken().getPanServiceSyurui().getDgServiceShuruiList();
    }

    @JsonIgnore
    public void setDgServiceShuruiList(DataGrid<dgServiceShuruiList_Row> dgServiceShuruiList) {
        this.getChushutsuJoken().getPanServiceSyurui().setDgServiceShuruiList(dgServiceShuruiList);
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuTaisho() {
        return this.getShutsuryokuTaisho().getChkShutsuryokuTaisho();
    }

    @JsonIgnore
    public void setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.getShutsuryokuTaisho().setChkShutsuryokuTaisho(chkShutsuryokuTaisho);
    }

    @JsonIgnore
    public ShutsuryokuTaisoDetailDiv getShutsuryokuTaisoDetail() {
        return this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail();
    }

    @JsonIgnore
    public void setShutsuryokuTaisoDetail(ShutsuryokuTaisoDetailDiv ShutsuryokuTaisoDetail) {
        this.getShutsuryokuTaisho().setShutsuryokuTaisoDetail(ShutsuryokuTaisoDetail);
    }

    @JsonIgnore
    public TextBox getTxtTitle() {
        return this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().getTxtTitle();
    }

    @JsonIgnore
    public void setTxtTitle(TextBox txtTitle) {
        this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().setTxtTitle(txtTitle);
    }

    @JsonIgnore
    public CheckBoxList getChkMeisaiCsvEdit() {
        return this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().getChkMeisaiCsvEdit();
    }

    @JsonIgnore
    public void setChkMeisaiCsvEdit(CheckBoxList chkMeisaiCsvEdit) {
        this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().setChkMeisaiCsvEdit(chkMeisaiCsvEdit);
    }

    // </editor-fold>
}
