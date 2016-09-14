package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterRestore;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterSave;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * DBC5140011Main のクラスファイル
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class DBC5140011MainDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenSaveRestore")
    private JokenSaveRestoreDiv JokenSaveRestore;
    @JsonProperty("tplJokenShitei")
    private tplJokenShiteiDiv tplJokenShitei;
    @JsonProperty("ccdChohyoShutsuryokuKomoku")
    private ChohyoShutsuryokuKomokuDiv ccdChohyoShutsuryokuKomoku;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJokenSaveRestore
     * @return JokenSaveRestore
     */
    @JsonProperty("JokenSaveRestore")
    public JokenSaveRestoreDiv getJokenSaveRestore() {
        return JokenSaveRestore;
    }

    /*
     * setJokenSaveRestore
     * @param JokenSaveRestore JokenSaveRestore
     */
    @JsonProperty("JokenSaveRestore")
    public void setJokenSaveRestore(JokenSaveRestoreDiv JokenSaveRestore) {
        this.JokenSaveRestore = JokenSaveRestore;
    }

    /*
     * gettplJokenShitei
     * @return tplJokenShitei
     */
    @JsonProperty("tplJokenShitei")
    public tplJokenShiteiDiv getTplJokenShitei() {
        return tplJokenShitei;
    }

    /*
     * settplJokenShitei
     * @param tplJokenShitei tplJokenShitei
     */
    @JsonProperty("tplJokenShitei")
    public void setTplJokenShitei(tplJokenShiteiDiv tplJokenShitei) {
        this.tplJokenShitei = tplJokenShitei;
    }

    /*
     * getccdChohyoShutsuryokuKomoku
     * @return ccdChohyoShutsuryokuKomoku
     */
    @JsonProperty("ccdChohyoShutsuryokuKomoku")
    public IChohyoShutsuryokuKomokuDiv getCcdChohyoShutsuryokuKomoku() {
        return ccdChohyoShutsuryokuKomoku;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return this.getJokenSaveRestore().getBtnBatchParameterSave();
    }

    @JsonIgnore
    public void setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.getJokenSaveRestore().setBtnBatchParameterSave(btnBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return this.getJokenSaveRestore().getBtnBatchParameterRestore();
    }

    @JsonIgnore
    public void setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.getJokenSaveRestore().setBtnBatchParameterRestore(btnBatchParameterRestore);
    }

    @JsonIgnore
    public ChushutsuJoken1Div getChushutsuJoken1() {
        return this.getTplJokenShitei().getChushutsuJoken1();
    }

    @JsonIgnore
    public RadioButton getRadTaishoYM() {
        return this.getTplJokenShitei().getChushutsuJoken1().getRadTaishoYM();
    }

    @JsonIgnore
    public void setRadTaishoYM(RadioButton radTaishoYM) {
        this.getTplJokenShitei().getChushutsuJoken1().setRadTaishoYM(radTaishoYM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoYmRange() {
        return this.getTplJokenShitei().getChushutsuJoken1().getTxtTaishoYmRange();
    }

    @JsonIgnore
    public void setTxtTaishoYmRange(TextBoxDateRange txtTaishoYmRange) {
        this.getTplJokenShitei().getChushutsuJoken1().setTxtTaishoYmRange(txtTaishoYmRange);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getTplJokenShitei().getChushutsuJoken1().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getTplJokenShitei().getChushutsuJoken1().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiKekka() {
        return this.getTplJokenShitei().getChushutsuJoken1().getChkNinteiKekka();
    }

    @JsonIgnore
    public void setChkNinteiKekka(CheckBoxList chkNinteiKekka) {
        this.getTplJokenShitei().getChushutsuJoken1().setChkNinteiKekka(chkNinteiKekka);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaNo() {
        return this.getTplJokenShitei().getChushutsuJoken1().getCcdJigyoshaNo();
    }

    @JsonIgnore
    public ChikuShiteiDiv getChikuShitei() {
        return this.getTplJokenShitei().getChikuShitei();
    }

    @JsonIgnore
    public ChushutsuJoken2Div getChushutsuJoken2() {
        return this.getTplJokenShitei().getChushutsuJoken2();
    }

    @JsonIgnore
    public Label getLbl01() {
        return this.getTplJokenShitei().getChushutsuJoken2().getLbl01();
    }

    @JsonIgnore
    public void setLbl01(Label lbl01) {
        this.getTplJokenShitei().getChushutsuJoken2().setLbl01(lbl01);
    }

    @JsonIgnore
    public Button getChkSelectKyotaku() {
        return this.getTplJokenShitei().getChushutsuJoken2().getChkSelectKyotaku();
    }

    @JsonIgnore
    public void setChkSelectKyotaku(Button chkSelectKyotaku) {
        this.getTplJokenShitei().getChushutsuJoken2().setChkSelectKyotaku(chkSelectKyotaku);
    }

    @JsonIgnore
    public Button getBtnSelectShisetsu() {
        return this.getTplJokenShitei().getChushutsuJoken2().getBtnSelectShisetsu();
    }

    @JsonIgnore
    public void setBtnSelectShisetsu(Button btnSelectShisetsu) {
        this.getTplJokenShitei().getChushutsuJoken2().setBtnSelectShisetsu(btnSelectShisetsu);
    }

    @JsonIgnore
    public DataGrid<dgServiceShuruiList_Row> getDgServiceShuruiList() {
        return this.getTplJokenShitei().getChushutsuJoken2().getDgServiceShuruiList();
    }

    @JsonIgnore
    public void setDgServiceShuruiList(DataGrid<dgServiceShuruiList_Row> dgServiceShuruiList) {
        this.getTplJokenShitei().getChushutsuJoken2().setDgServiceShuruiList(dgServiceShuruiList);
    }

    @JsonIgnore
    public TextBox getTxtServiceKomokuCode1() {
        return this.getTplJokenShitei().getChushutsuJoken2().getTxtServiceKomokuCode1();
    }

    @JsonIgnore
    public void setTxtServiceKomokuCode1(TextBox txtServiceKomokuCode1) {
        this.getTplJokenShitei().getChushutsuJoken2().setTxtServiceKomokuCode1(txtServiceKomokuCode1);
    }

    @JsonIgnore
    public TextBox getTxtServiceKomokuCode2() {
        return this.getTplJokenShitei().getChushutsuJoken2().getTxtServiceKomokuCode2();
    }

    @JsonIgnore
    public void setTxtServiceKomokuCode2(TextBox txtServiceKomokuCode2) {
        this.getTplJokenShitei().getChushutsuJoken2().setTxtServiceKomokuCode2(txtServiceKomokuCode2);
    }

    @JsonIgnore
    public TextBox getTxtServiceKomokuCode3() {
        return this.getTplJokenShitei().getChushutsuJoken2().getTxtServiceKomokuCode3();
    }

    @JsonIgnore
    public void setTxtServiceKomokuCode3(TextBox txtServiceKomokuCode3) {
        this.getTplJokenShitei().getChushutsuJoken2().setTxtServiceKomokuCode3(txtServiceKomokuCode3);
    }

    @JsonIgnore
    public TextBox getTxtServiceKomokuCode4() {
        return this.getTplJokenShitei().getChushutsuJoken2().getTxtServiceKomokuCode4();
    }

    @JsonIgnore
    public void setTxtServiceKomokuCode4(TextBox txtServiceKomokuCode4) {
        this.getTplJokenShitei().getChushutsuJoken2().setTxtServiceKomokuCode4(txtServiceKomokuCode4);
    }

    @JsonIgnore
    public ShutsuryokuJokenDiv getShutsuryokuJoken() {
        return this.getTplJokenShitei().getShutsuryokuJoken();
    }

    @JsonIgnore
    public ShutsuryokuTaisoDetailDiv getShutsuryokuTaisoDetail() {
        return this.getTplJokenShitei().getShutsuryokuJoken().getShutsuryokuTaisoDetail();
    }

    @JsonIgnore
    public void setShutsuryokuTaisoDetail(ShutsuryokuTaisoDetailDiv ShutsuryokuTaisoDetail) {
        this.getTplJokenShitei().getShutsuryokuJoken().setShutsuryokuTaisoDetail(ShutsuryokuTaisoDetail);
    }

    @JsonIgnore
    public CheckBoxList getChkCsvEdit() {
        return this.getTplJokenShitei().getShutsuryokuJoken().getShutsuryokuTaisoDetail().getChkCsvEdit();
    }

    @JsonIgnore
    public void setChkCsvEdit(CheckBoxList chkCsvEdit) {
        this.getTplJokenShitei().getShutsuryokuJoken().getShutsuryokuTaisoDetail().setChkCsvEdit(chkCsvEdit);
    }

    // </editor-fold>
}
