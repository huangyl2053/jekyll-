package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo.IJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo.JukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;

/**
 * JukyushaTeiseiRenrakuhyoTorokuPanel のクラスファイル
 *
 * @author 自動生成
 */
public class JukyushaTeiseiRenrakuhyoTorokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyo")
    private JukyushaIdoRenrakuhyoDiv JukyushaIdoRenrakuhyo;
    @JsonProperty("OutputJukyushaIdoRenrakuhyo")
    private OutputJukyushaIdoRenrakuhyoDiv OutputJukyushaIdoRenrakuhyo;
    @JsonProperty("hdnFlag")
    private TextBox hdnFlag;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("dialogFlag")
    private RString dialogFlag;
    @JsonProperty("saveFlg")
    private RString saveFlg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getJukyushaIdoRenrakuhyo
     * @return JukyushaIdoRenrakuhyo
     */
    @JsonProperty("JukyushaIdoRenrakuhyo")
    public IJukyushaIdoRenrakuhyoDiv getJukyushaIdoRenrakuhyo() {
        return JukyushaIdoRenrakuhyo;
    }

    /*
     * getOutputJukyushaIdoRenrakuhyo
     * @return OutputJukyushaIdoRenrakuhyo
     */
    @JsonProperty("OutputJukyushaIdoRenrakuhyo")
    public OutputJukyushaIdoRenrakuhyoDiv getOutputJukyushaIdoRenrakuhyo() {
        return OutputJukyushaIdoRenrakuhyo;
    }

    /*
     * setOutputJukyushaIdoRenrakuhyo
     * @param OutputJukyushaIdoRenrakuhyo OutputJukyushaIdoRenrakuhyo
     */
    @JsonProperty("OutputJukyushaIdoRenrakuhyo")
    public void setOutputJukyushaIdoRenrakuhyo(OutputJukyushaIdoRenrakuhyoDiv OutputJukyushaIdoRenrakuhyo) {
        this.OutputJukyushaIdoRenrakuhyo = OutputJukyushaIdoRenrakuhyo;
    }

    /*
     * gethdnFlag
     * @return hdnFlag
     */
    @JsonProperty("hdnFlag")
    public TextBox getHdnFlag() {
        return hdnFlag;
    }

    /*
     * sethdnFlag
     * @param hdnFlag hdnFlag
     */
    @JsonProperty("hdnFlag")
    public void setHdnFlag(TextBox hdnFlag) {
        this.hdnFlag = hdnFlag;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getdialogFlag
     * @return dialogFlag
     */
    @JsonProperty("dialogFlag")
    public RString getDialogFlag() {
        return dialogFlag;
    }

    /*
     * setdialogFlag
     * @param dialogFlag dialogFlag
     */
    @JsonProperty("dialogFlag")
    public void setDialogFlag(RString dialogFlag) {
        this.dialogFlag = dialogFlag;
    }

    /*
     * getsaveFlg
     * @return saveFlg
     */
    @JsonProperty("saveFlg")
    public RString getSaveFlg() {
        return saveFlg;
    }

    /*
     * setsaveFlg
     * @param saveFlg saveFlg
     */
    @JsonProperty("saveFlg")
    public void setSaveFlg(RString saveFlg) {
        this.saveFlg = saveFlg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkJukyushaTeiseiRearakuhyoHakkou() {
        return this.getOutputJukyushaIdoRenrakuhyo().getChkJukyushaTeiseiRearakuhyoHakkou();
    }

    @JsonIgnore
    public void setChkJukyushaTeiseiRearakuhyoHakkou(CheckBoxList chkJukyushaTeiseiRearakuhyoHakkou) {
        this.getOutputJukyushaIdoRenrakuhyo().setChkJukyushaTeiseiRearakuhyoHakkou(chkJukyushaTeiseiRearakuhyoHakkou);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyushaIdoRenrakuhyo() {
        return this.getOutputJukyushaIdoRenrakuhyo().getChkJukyushaIdoRenrakuhyo();
    }

    @JsonIgnore
    public void setChkJukyushaIdoRenrakuhyo(CheckBoxList chkJukyushaIdoRenrakuhyo) {
        this.getOutputJukyushaIdoRenrakuhyo().setChkJukyushaIdoRenrakuhyo(chkJukyushaIdoRenrakuhyo);
    }

    @JsonIgnore
    public ButtonReportPublish getBtnReportPublish() {
        return this.getOutputJukyushaIdoRenrakuhyo().getBtnReportPublish();
    }

    @JsonIgnore
    public void setBtnReportPublish(ButtonReportPublish btnReportPublish) {
        this.getOutputJukyushaIdoRenrakuhyo().setBtnReportPublish(btnReportPublish);
    }

    @JsonIgnore
    public HorizontalLine getLin01() {
        return this.getOutputJukyushaIdoRenrakuhyo().getLin01();
    }

    @JsonIgnore
    public void setLin01(HorizontalLine lin01) {
        this.getOutputJukyushaIdoRenrakuhyo().setLin01(lin01);
    }

    @JsonIgnore
    public RadioButton getRadTeiseiKomokuHantei() {
        return this.getOutputJukyushaIdoRenrakuhyo().getRadTeiseiKomokuHantei();
    }

    @JsonIgnore
    public void setRadTeiseiKomokuHantei(RadioButton radTeiseiKomokuHantei) {
        this.getOutputJukyushaIdoRenrakuhyo().setRadTeiseiKomokuHantei(radTeiseiKomokuHantei);
    }

    @JsonIgnore
    public Button getBtnSave() {
        return this.getOutputJukyushaIdoRenrakuhyo().getBtnSave();
    }

    @JsonIgnore
    public void setBtnSave(Button btnSave) {
        this.getOutputJukyushaIdoRenrakuhyo().setBtnSave(btnSave);
    }

    @JsonIgnore
    public IPrintContentsSettingDiv getJukyushaIdoRenrakuhyoHenkoPrintSetting() {
        return this.getOutputJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoHenkoPrintSetting();
    }

    // </editor-fold>
}
