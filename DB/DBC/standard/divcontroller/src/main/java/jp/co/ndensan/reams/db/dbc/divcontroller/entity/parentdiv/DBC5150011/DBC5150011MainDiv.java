package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv.IServiceCodeInputCommonChildDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

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
    public TextBoxDate getTxtKijunYM() {
        return this.getChushutsuJoken().getTxtKijunYM();
    }

    @JsonIgnore
    public void setTxtKijunYM(TextBoxDate txtKijunYM) {
        this.getChushutsuJoken().setTxtKijunYM(txtKijunYM);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJokenAll() {
        return this.getChushutsuJoken().getRadChushutsuJokenAll();
    }

    @JsonIgnore
    public void setRadChushutsuJokenAll(RadioButton radChushutsuJokenAll) {
        this.getChushutsuJoken().setRadChushutsuJokenAll(radChushutsuJokenAll);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJokenServiceCode() {
        return this.getChushutsuJoken().getRadChushutsuJokenServiceCode();
    }

    @JsonIgnore
    public void setRadChushutsuJokenServiceCode(RadioButton radChushutsuJokenServiceCode) {
        this.getChushutsuJoken().setRadChushutsuJokenServiceCode(radChushutsuJokenServiceCode);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJokenServiceBunrui() {
        return this.getChushutsuJoken().getRadChushutsuJokenServiceBunrui();
    }

    @JsonIgnore
    public void setRadChushutsuJokenServiceBunrui(RadioButton radChushutsuJokenServiceBunrui) {
        this.getChushutsuJoken().setRadChushutsuJokenServiceBunrui(radChushutsuJokenServiceBunrui);
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
    public DataGrid<dgServiceBunruiList_Row> getDgServiceBunruiList() {
        return this.getChushutsuJoken().getPanServiceSyurui().getDgServiceBunruiList();
    }

    @JsonIgnore
    public void setDgServiceBunruiList(DataGrid<dgServiceBunruiList_Row> dgServiceBunruiList) {
        this.getChushutsuJoken().getPanServiceSyurui().setDgServiceBunruiList(dgServiceBunruiList);
    }

    @JsonIgnore
    public IServiceCodeInputCommonChildDiv getCcdServiceCodeInput() {
        return this.getChushutsuJoken().getCcdServiceCodeInput();
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
    public Space getSpa1() {
        return this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().getSpa1();
    }

    @JsonIgnore
    public void setSpa1(Space spa1) {
        this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().setSpa1(spa1);
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
