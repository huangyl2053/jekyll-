package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;

/**
 * OutputJukyushaIdoRenrakuhyo のクラスファイル
 *
 * @author 自動生成
 */
public class OutputJukyushaIdoRenrakuhyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkJukyushaTeiseiRearakuhyoHakkou")
    private CheckBoxList chkJukyushaTeiseiRearakuhyoHakkou;
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    private CheckBoxList chkJukyushaIdoRenrakuhyo;
    @JsonProperty("btnReportPublish")
    private ButtonReportPublish btnReportPublish;
    @JsonProperty("lin01")
    private HorizontalLine lin01;
    @JsonProperty("radTeiseiKomokuHantei")
    private RadioButton radTeiseiKomokuHantei;
    @JsonProperty("btnSave")
    private Button btnSave;
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoPrintSetting")
    private PrintContentsSettingDiv JukyushaIdoRenrakuhyoHenkoPrintSetting;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getchkJukyushaTeiseiRearakuhyoHakkou
     * @return chkJukyushaTeiseiRearakuhyoHakkou
     */
    @JsonProperty("chkJukyushaTeiseiRearakuhyoHakkou")
    public CheckBoxList getChkJukyushaTeiseiRearakuhyoHakkou() {
        return chkJukyushaTeiseiRearakuhyoHakkou;
    }

    /*
     * setchkJukyushaTeiseiRearakuhyoHakkou
     * @param chkJukyushaTeiseiRearakuhyoHakkou chkJukyushaTeiseiRearakuhyoHakkou
     */
    @JsonProperty("chkJukyushaTeiseiRearakuhyoHakkou")
    public void setChkJukyushaTeiseiRearakuhyoHakkou(CheckBoxList chkJukyushaTeiseiRearakuhyoHakkou) {
        this.chkJukyushaTeiseiRearakuhyoHakkou = chkJukyushaTeiseiRearakuhyoHakkou;
    }

    /*
     * getchkJukyushaIdoRenrakuhyo
     * @return chkJukyushaIdoRenrakuhyo
     */
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    public CheckBoxList getChkJukyushaIdoRenrakuhyo() {
        return chkJukyushaIdoRenrakuhyo;
    }

    /*
     * setchkJukyushaIdoRenrakuhyo
     * @param chkJukyushaIdoRenrakuhyo chkJukyushaIdoRenrakuhyo
     */
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    public void setChkJukyushaIdoRenrakuhyo(CheckBoxList chkJukyushaIdoRenrakuhyo) {
        this.chkJukyushaIdoRenrakuhyo = chkJukyushaIdoRenrakuhyo;
    }

    /*
     * getbtnReportPublish
     * @return btnReportPublish
     */
    @JsonProperty("btnReportPublish")
    public ButtonReportPublish getBtnReportPublish() {
        return btnReportPublish;
    }

    /*
     * setbtnReportPublish
     * @param btnReportPublish btnReportPublish
     */
    @JsonProperty("btnReportPublish")
    public void setBtnReportPublish(ButtonReportPublish btnReportPublish) {
        this.btnReportPublish = btnReportPublish;
    }

    /*
     * getlin01
     * @return lin01
     */
    @JsonProperty("lin01")
    public HorizontalLine getLin01() {
        return lin01;
    }

    /*
     * setlin01
     * @param lin01 lin01
     */
    @JsonProperty("lin01")
    public void setLin01(HorizontalLine lin01) {
        this.lin01 = lin01;
    }

    /*
     * getradTeiseiKomokuHantei
     * @return radTeiseiKomokuHantei
     */
    @JsonProperty("radTeiseiKomokuHantei")
    public RadioButton getRadTeiseiKomokuHantei() {
        return radTeiseiKomokuHantei;
    }

    /*
     * setradTeiseiKomokuHantei
     * @param radTeiseiKomokuHantei radTeiseiKomokuHantei
     */
    @JsonProperty("radTeiseiKomokuHantei")
    public void setRadTeiseiKomokuHantei(RadioButton radTeiseiKomokuHantei) {
        this.radTeiseiKomokuHantei = radTeiseiKomokuHantei;
    }

    /*
     * getbtnSave
     * @return btnSave
     */
    @JsonProperty("btnSave")
    public Button getBtnSave() {
        return btnSave;
    }

    /*
     * setbtnSave
     * @param btnSave btnSave
     */
    @JsonProperty("btnSave")
    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    /*
     * getJukyushaIdoRenrakuhyoHenkoPrintSetting
     * @return JukyushaIdoRenrakuhyoHenkoPrintSetting
     */
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoPrintSetting")
    public IPrintContentsSettingDiv getJukyushaIdoRenrakuhyoHenkoPrintSetting() {
        return JukyushaIdoRenrakuhyoHenkoPrintSetting;
    }

    // </editor-fold>
}
