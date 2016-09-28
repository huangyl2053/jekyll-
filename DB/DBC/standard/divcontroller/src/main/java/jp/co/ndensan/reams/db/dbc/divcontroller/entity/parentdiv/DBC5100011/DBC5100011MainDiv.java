package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * DBC5100011Main のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBC5100011MainDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenSaveRestore")
    private JokenSaveRestoreDiv JokenSaveRestore;
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ChikuShitei")
    private ChikuShiteiDiv ChikuShitei;
    @JsonProperty("ShutsuryokuTaisho")
    private ShutsuryokuTaishoDiv ShutsuryokuTaisho;
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
     * getChikuShitei
     * @return ChikuShitei
     */
    @JsonProperty("ChikuShitei")
    public ChikuShiteiDiv getChikuShitei() {
        return ChikuShitei;
    }

    /*
     * setChikuShitei
     * @param ChikuShitei ChikuShitei
     */
    @JsonProperty("ChikuShitei")
    public void setChikuShitei(ChikuShiteiDiv ChikuShitei) {
        this.ChikuShitei = ChikuShitei;
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
    public void  setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.getJokenSaveRestore().setBtnBatchParameterSave(btnBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return this.getJokenSaveRestore().getBtnBatchParameterRestore();
    }

    @JsonIgnore
    public void  setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.getJokenSaveRestore().setBtnBatchParameterRestore(btnBatchParameterRestore);
    }

    @JsonIgnore
    public KyufuJissekiJokenDiv getKyufuJissekiJoken() {
        return this.getChushutsuJoken().getKyufuJissekiJoken();
    }

    @JsonIgnore
    public void  setKyufuJissekiJoken(KyufuJissekiJokenDiv KyufuJissekiJoken) {
        this.getChushutsuJoken().setKyufuJissekiJoken(KyufuJissekiJoken);
    }

    @JsonIgnore
    public RadioButton getRadTaishoYM() {
        return this.getChushutsuJoken().getKyufuJissekiJoken().getRadTaishoYM();
    }

    @JsonIgnore
    public void  setRadTaishoYM(RadioButton radTaishoYM) {
        this.getChushutsuJoken().getKyufuJissekiJoken().setRadTaishoYM(radTaishoYM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoYmRange() {
        return this.getChushutsuJoken().getKyufuJissekiJoken().getTxtTaishoYmRange();
    }

    @JsonIgnore
    public void  setTxtTaishoYmRange(TextBoxDateRange txtTaishoYmRange) {
        this.getChushutsuJoken().getKyufuJissekiJoken().setTxtTaishoYmRange(txtTaishoYmRange);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getChushutsuJoken().getKyufuJissekiJoken().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getChushutsuJoken().getKyufuJissekiJoken().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaNo() {
        return this.getChushutsuJoken().getKyufuJissekiJoken().getCcdJigyoshaNo();
    }

    @JsonIgnore
    public RiyojokyoJokenDiv getRiyojokyoJoken() {
        return this.getChushutsuJoken().getRiyojokyoJoken();
    }

    @JsonIgnore
    public void  setRiyojokyoJoken(RiyojokyoJokenDiv RiyojokyoJoken) {
        this.getChushutsuJoken().setRiyojokyoJoken(RiyojokyoJoken);
    }

    @JsonIgnore
    public RadioButton getRadRiyoJisseki() {
        return this.getChushutsuJoken().getRiyojokyoJoken().getRadRiyoJisseki();
    }

    @JsonIgnore
    public void  setRadRiyoJisseki(RadioButton radRiyoJisseki) {
        this.getChushutsuJoken().getRiyojokyoJoken().setRadRiyoJisseki(radRiyoJisseki);
    }

    @JsonIgnore
    public RadioButton getRadKyotakuRiyoritsu() {
        return this.getChushutsuJoken().getRiyojokyoJoken().getRadKyotakuRiyoritsu();
    }

    @JsonIgnore
    public void  setRadKyotakuRiyoritsu(RadioButton radKyotakuRiyoritsu) {
        this.getChushutsuJoken().getRiyojokyoJoken().setRadKyotakuRiyoritsu(radKyotakuRiyoritsu);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtKyotakuRiyoritsuRange() {
        return this.getChushutsuJoken().getRiyojokyoJoken().getTxtKyotakuRiyoritsuRange();
    }

    @JsonIgnore
    public void  setTxtKyotakuRiyoritsuRange(TextBoxNumRange txtKyotakuRiyoritsuRange) {
        this.getChushutsuJoken().getRiyojokyoJoken().setTxtKyotakuRiyoritsuRange(txtKyotakuRiyoritsuRange);
    }

    @JsonIgnore
    public RadioButton getRadHomonRiyoritsu() {
        return this.getChushutsuJoken().getRiyojokyoJoken().getRadHomonRiyoritsu();
    }

    @JsonIgnore
    public void  setRadHomonRiyoritsu(RadioButton radHomonRiyoritsu) {
        this.getChushutsuJoken().getRiyojokyoJoken().setRadHomonRiyoritsu(radHomonRiyoritsu);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtHomonRiyoritsuRange() {
        return this.getChushutsuJoken().getRiyojokyoJoken().getTxtHomonRiyoritsuRange();
    }

    @JsonIgnore
    public void  setTxtHomonRiyoritsuRange(TextBoxNumRange txtHomonRiyoritsuRange) {
        this.getChushutsuJoken().getRiyojokyoJoken().setTxtHomonRiyoritsuRange(txtHomonRiyoritsuRange);
    }

    @JsonIgnore
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return this.getChikuShitei().getCcdChikuShichosonSelect();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuTaisho() {
        return this.getShutsuryokuTaisho().getChkShutsuryokuTaisho();
    }

    @JsonIgnore
    public void  setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.getShutsuryokuTaisho().setChkShutsuryokuTaisho(chkShutsuryokuTaisho);
    }

    @JsonIgnore
    public ShutsuryokuTaisoDetailDiv getShutsuryokuTaisoDetail() {
        return this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail();
    }

    @JsonIgnore
    public void  setShutsuryokuTaisoDetail(ShutsuryokuTaisoDetailDiv ShutsuryokuTaisoDetail) {
        this.getShutsuryokuTaisho().setShutsuryokuTaisoDetail(ShutsuryokuTaisoDetail);
    }

    @JsonIgnore
    public Space getSpc01() {
        return this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().getSpc01();
    }

    @JsonIgnore
    public void  setSpc01(Space spc01) {
        this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().setSpc01(spc01);
    }

    @JsonIgnore
    public RadioButton getRadMeisaiGokeiOut() {
        return this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().getRadMeisaiGokeiOut();
    }

    @JsonIgnore
    public void  setRadMeisaiGokeiOut(RadioButton radMeisaiGokeiOut) {
        this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().setRadMeisaiGokeiOut(radMeisaiGokeiOut);
    }

    @JsonIgnore
    public CheckBoxList getChkMeisaiCsvEdit() {
        return this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().getChkMeisaiCsvEdit();
    }

    @JsonIgnore
    public void  setChkMeisaiCsvEdit(CheckBoxList chkMeisaiCsvEdit) {
        this.getShutsuryokuTaisho().getShutsuryokuTaisoDetail().setChkMeisaiCsvEdit(chkMeisaiCsvEdit);
    }

    // </editor-fold>
}
