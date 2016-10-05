package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * DBC8010001Main のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBC8010001MainDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Itakusha")
    private ItakushaDiv Itakusha;
    @JsonProperty("SakuseiShiji")
    private SakuseiShijiDiv SakuseiShiji;
    @JsonProperty("ChushutsuHani")
    private ChushutsuHaniDiv ChushutsuHani;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getItakusha
     * @return Itakusha
     */
    @JsonProperty("Itakusha")
    public ItakushaDiv getItakusha() {
        return Itakusha;
    }

    /*
     * setItakusha
     * @param Itakusha Itakusha
     */
    @JsonProperty("Itakusha")
    public void setItakusha(ItakushaDiv Itakusha) {
        this.Itakusha = Itakusha;
    }

    /*
     * getSakuseiShiji
     * @return SakuseiShiji
     */
    @JsonProperty("SakuseiShiji")
    public SakuseiShijiDiv getSakuseiShiji() {
        return SakuseiShiji;
    }

    /*
     * setSakuseiShiji
     * @param SakuseiShiji SakuseiShiji
     */
    @JsonProperty("SakuseiShiji")
    public void setSakuseiShiji(SakuseiShijiDiv SakuseiShiji) {
        this.SakuseiShiji = SakuseiShiji;
    }

    /*
     * getChushutsuHani
     * @return ChushutsuHani
     */
    @JsonProperty("ChushutsuHani")
    public ChushutsuHaniDiv getChushutsuHani() {
        return ChushutsuHani;
    }

    /*
     * setChushutsuHani
     * @param ChushutsuHani ChushutsuHani
     */
    @JsonProperty("ChushutsuHani")
    public void setChushutsuHani(ChushutsuHaniDiv ChushutsuHani) {
        this.ChushutsuHani = ChushutsuHani;
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
    public TextBox getTxtItakushaCode() {
        return this.getItakusha().getTxtItakushaCode();
    }

    @JsonIgnore
    public void  setTxtItakushaCode(TextBox txtItakushaCode) {
        this.getItakusha().setTxtItakushaCode(txtItakushaCode);
    }

    @JsonIgnore
    public TextBox getTxtItakushamei() {
        return this.getItakusha().getTxtItakushamei();
    }

    @JsonIgnore
    public void  setTxtItakushamei(TextBox txtItakushamei) {
        this.getItakusha().setTxtItakushamei(txtItakushamei);
    }

    @JsonIgnore
    public TextBox getTxtFurikomiGroupCode() {
        return this.getItakusha().getTxtFurikomiGroupCode();
    }

    @JsonIgnore
    public void  setTxtFurikomiGroupCode(TextBox txtFurikomiGroupCode) {
        this.getItakusha().setTxtFurikomiGroupCode(txtFurikomiGroupCode);
    }

    @JsonIgnore
    public TextBox getTxtFurikomiGroupMeisho() {
        return this.getItakusha().getTxtFurikomiGroupMeisho();
    }

    @JsonIgnore
    public void  setTxtFurikomiGroupMeisho(TextBox txtFurikomiGroupMeisho) {
        this.getItakusha().setTxtFurikomiGroupMeisho(txtFurikomiGroupMeisho);
    }

    @JsonIgnore
    public DropDownList getDdlShoriTaisho() {
        return this.getSakuseiShiji().getDdlShoriTaisho();
    }

    @JsonIgnore
    public void  setDdlShoriTaisho(DropDownList ddlShoriTaisho) {
        this.getSakuseiShiji().setDdlShoriTaisho(ddlShoriTaisho);
    }

    @JsonIgnore
    public RadioButton getRadShoriSentakuFurikomiDataSakusei() {
        return this.getSakuseiShiji().getRadShoriSentakuFurikomiDataSakusei();
    }

    @JsonIgnore
    public void  setRadShoriSentakuFurikomiDataSakusei(RadioButton radShoriSentakuFurikomiDataSakusei) {
        this.getSakuseiShiji().setRadShoriSentakuFurikomiDataSakusei(radShoriSentakuFurikomiDataSakusei);
    }

    @JsonIgnore
    public Space getSpc01() {
        return this.getSakuseiShiji().getSpc01();
    }

    @JsonIgnore
    public void  setSpc01(Space spc01) {
        this.getSakuseiShiji().setSpc01(spc01);
    }

    @JsonIgnore
    public FurikomiDataSakuseiShijiDiv getFurikomiDataSakuseiShiji() {
        return this.getSakuseiShiji().getFurikomiDataSakuseiShiji();
    }

    @JsonIgnore
    public void  setFurikomiDataSakuseiShiji(FurikomiDataSakuseiShijiDiv FurikomiDataSakuseiShiji) {
        this.getSakuseiShiji().setFurikomiDataSakuseiShiji(FurikomiDataSakuseiShiji);
    }

    @JsonIgnore
    public TextBoxDate getTxtFurikomiShiteiYMD() {
        return this.getSakuseiShiji().getFurikomiDataSakuseiShiji().getTxtFurikomiShiteiYMD();
    }

    @JsonIgnore
    public void  setTxtFurikomiShiteiYMD(TextBoxDate txtFurikomiShiteiYMD) {
        this.getSakuseiShiji().getFurikomiDataSakuseiShiji().setTxtFurikomiShiteiYMD(txtFurikomiShiteiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkSaisakusei() {
        return this.getSakuseiShiji().getFurikomiDataSakuseiShiji().getChkSaisakusei();
    }

    @JsonIgnore
    public void  setChkSaisakusei(CheckBoxList chkSaisakusei) {
        this.getSakuseiShiji().getFurikomiDataSakuseiShiji().setChkSaisakusei(chkSaisakusei);
    }

    @JsonIgnore
    public RadioButton getRadShoriSentakuFurikomiDataModify() {
        return this.getSakuseiShiji().getRadShoriSentakuFurikomiDataModify();
    }

    @JsonIgnore
    public void  setRadShoriSentakuFurikomiDataModify(RadioButton radShoriSentakuFurikomiDataModify) {
        this.getSakuseiShiji().setRadShoriSentakuFurikomiDataModify(radShoriSentakuFurikomiDataModify);
    }

    @JsonIgnore
    public Space getSpc02() {
        return this.getSakuseiShiji().getSpc02();
    }

    @JsonIgnore
    public void  setSpc02(Space spc02) {
        this.getSakuseiShiji().setSpc02(spc02);
    }

    @JsonIgnore
    public FurikomiDataModifyShijiDiv getFurikomiDataModifyShiji() {
        return this.getSakuseiShiji().getFurikomiDataModifyShiji();
    }

    @JsonIgnore
    public void  setFurikomiDataModifyShiji(FurikomiDataModifyShijiDiv FurikomiDataModifyShiji) {
        this.getSakuseiShiji().setFurikomiDataModifyShiji(FurikomiDataModifyShiji);
    }

    @JsonIgnore
    public TextBoxDate getTxtWrongFurikomiShiteiYMD() {
        return this.getSakuseiShiji().getFurikomiDataModifyShiji().getTxtWrongFurikomiShiteiYMD();
    }

    @JsonIgnore
    public void  setTxtWrongFurikomiShiteiYMD(TextBoxDate txtWrongFurikomiShiteiYMD) {
        this.getSakuseiShiji().getFurikomiDataModifyShiji().setTxtWrongFurikomiShiteiYMD(txtWrongFurikomiShiteiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtCorrectFurikomiShiteiYMD() {
        return this.getSakuseiShiji().getFurikomiDataModifyShiji().getTxtCorrectFurikomiShiteiYMD();
    }

    @JsonIgnore
    public void  setTxtCorrectFurikomiShiteiYMD(TextBoxDate txtCorrectFurikomiShiteiYMD) {
        this.getSakuseiShiji().getFurikomiDataModifyShiji().setTxtCorrectFurikomiShiteiYMD(txtCorrectFurikomiShiteiYMD);
    }

    @JsonIgnore
    public RadioButton getRadShoriSentakuIchiranhyoSakusei() {
        return this.getSakuseiShiji().getRadShoriSentakuIchiranhyoSakusei();
    }

    @JsonIgnore
    public void  setRadShoriSentakuIchiranhyoSakusei(RadioButton radShoriSentakuIchiranhyoSakusei) {
        this.getSakuseiShiji().setRadShoriSentakuIchiranhyoSakusei(radShoriSentakuIchiranhyoSakusei);
    }

    @JsonIgnore
    public Space getSpc03() {
        return this.getSakuseiShiji().getSpc03();
    }

    @JsonIgnore
    public void  setSpc03(Space spc03) {
        this.getSakuseiShiji().setSpc03(spc03);
    }

    @JsonIgnore
    public IchiranhyoSakuseiShijiDiv getIchiranhyoSakuseiShiji() {
        return this.getSakuseiShiji().getIchiranhyoSakuseiShiji();
    }

    @JsonIgnore
    public void  setIchiranhyoSakuseiShiji(IchiranhyoSakuseiShijiDiv IchiranhyoSakuseiShiji) {
        this.getSakuseiShiji().setIchiranhyoSakuseiShiji(IchiranhyoSakuseiShiji);
    }

    @JsonIgnore
    public RadioButton getRadSiharaihohou() {
        return this.getSakuseiShiji().getIchiranhyoSakuseiShiji().getRadSiharaihohou();
    }

    @JsonIgnore
    public void  setRadSiharaihohou(RadioButton radSiharaihohou) {
        this.getSakuseiShiji().getIchiranhyoSakuseiShiji().setRadSiharaihohou(radSiharaihohou);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtZenkaiTaishoYmdRange() {
        return this.getChushutsuHani().getTxtZenkaiTaishoYmdRange();
    }

    @JsonIgnore
    public void  setTxtZenkaiTaishoYmdRange(TextBoxDateRange txtZenkaiTaishoYmdRange) {
        this.getChushutsuHani().setTxtZenkaiTaishoYmdRange(txtZenkaiTaishoYmdRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKonkaiTaishoYmdRange() {
        return this.getChushutsuHani().getTxtKonkaiTaishoYmdRange();
    }

    @JsonIgnore
    public void  setTxtKonkaiTaishoYmdRange(TextBoxDateRange txtKonkaiTaishoYmdRange) {
        this.getChushutsuHani().setTxtKonkaiTaishoYmdRange(txtKonkaiTaishoYmdRange);
    }

    @JsonIgnore
    public Label getLbl01() {
        return this.getChushutsuHani().getLbl01();
    }

    @JsonIgnore
    public void  setLbl01(Label lbl01) {
        this.getChushutsuHani().setLbl01(lbl01);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteishaUketoriYmRange() {
        return this.getChushutsuHani().getTxtKetteishaUketoriYmRange();
    }

    @JsonIgnore
    public void  setTxtKetteishaUketoriYmRange(TextBoxDateRange txtKetteishaUketoriYmRange) {
        this.getChushutsuHani().setTxtKetteishaUketoriYmRange(txtKetteishaUketoriYmRange);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuTaisho() {
        return this.getChushutsuHani().getRadChushutsuTaisho();
    }

    @JsonIgnore
    public void  setRadChushutsuTaisho(RadioButton radChushutsuTaisho) {
        this.getChushutsuHani().setRadChushutsuTaisho(radChushutsuTaisho);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishoSakuseiYMD() {
        return this.getChushutsuHani().getTxtTaishoSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtTaishoSakuseiYMD(TextBoxDate txtTaishoSakuseiYMD) {
        this.getChushutsuHani().setTxtTaishoSakuseiYMD(txtTaishoSakuseiYMD);
    }

    // </editor-fold>
}
