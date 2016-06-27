package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * KyodoJukyushaIdoRenrakuhyoKogakuPanel のクラスファイル
 *
 * @reamsid_L DBC-4390-010 xupeng
 */
public class KyodoJukyushaIdoRenrakuhyoKogakuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKogakuIdoYMD")
    private TextBoxDate txtKogakuIdoYMD;
    @JsonProperty("txtKogakuRirekiNo")
    private TextBoxNum txtKogakuRirekiNo;
    @JsonProperty("lin5")
    private HorizontalLine lin5;
    @JsonProperty("txtSetaiShuyakuNo")
    private TextBox txtSetaiShuyakuNo;
    @JsonProperty("ddlSetaiShotokuKubun")
    private DropDownList ddlSetaiShotokuKubun;
    @JsonProperty("ddlShotokuKubun")
    private DropDownList ddlShotokuKubun;
    @JsonProperty("KogakuRadioBtnPanel")
    private KogakuRadioBtnPanelDiv KogakuRadioBtnPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKogakuIdoYMD
     * @return txtKogakuIdoYMD
     */
    @JsonProperty("txtKogakuIdoYMD")
    public TextBoxDate getTxtKogakuIdoYMD() {
        return txtKogakuIdoYMD;
    }

    /*
     * settxtKogakuIdoYMD
     * @param txtKogakuIdoYMD txtKogakuIdoYMD
     */
    @JsonProperty("txtKogakuIdoYMD")
    public void setTxtKogakuIdoYMD(TextBoxDate txtKogakuIdoYMD) {
        this.txtKogakuIdoYMD = txtKogakuIdoYMD;
    }

    /*
     * gettxtKogakuRirekiNo
     * @return txtKogakuRirekiNo
     */
    @JsonProperty("txtKogakuRirekiNo")
    public TextBoxNum getTxtKogakuRirekiNo() {
        return txtKogakuRirekiNo;
    }

    /*
     * settxtKogakuRirekiNo
     * @param txtKogakuRirekiNo txtKogakuRirekiNo
     */
    @JsonProperty("txtKogakuRirekiNo")
    public void setTxtKogakuRirekiNo(TextBoxNum txtKogakuRirekiNo) {
        this.txtKogakuRirekiNo = txtKogakuRirekiNo;
    }

    /*
     * getlin5
     * @return lin5
     */
    @JsonProperty("lin5")
    public HorizontalLine getLin5() {
        return lin5;
    }

    /*
     * setlin5
     * @param lin5 lin5
     */
    @JsonProperty("lin5")
    public void setLin5(HorizontalLine lin5) {
        this.lin5 = lin5;
    }

    /*
     * gettxtSetaiShuyakuNo
     * @return txtSetaiShuyakuNo
     */
    @JsonProperty("txtSetaiShuyakuNo")
    public TextBox getTxtSetaiShuyakuNo() {
        return txtSetaiShuyakuNo;
    }

    /*
     * settxtSetaiShuyakuNo
     * @param txtSetaiShuyakuNo txtSetaiShuyakuNo
     */
    @JsonProperty("txtSetaiShuyakuNo")
    public void setTxtSetaiShuyakuNo(TextBox txtSetaiShuyakuNo) {
        this.txtSetaiShuyakuNo = txtSetaiShuyakuNo;
    }

    /*
     * getddlSetaiShotokuKubun
     * @return ddlSetaiShotokuKubun
     */
    @JsonProperty("ddlSetaiShotokuKubun")
    public DropDownList getDdlSetaiShotokuKubun() {
        return ddlSetaiShotokuKubun;
    }

    /*
     * setddlSetaiShotokuKubun
     * @param ddlSetaiShotokuKubun ddlSetaiShotokuKubun
     */
    @JsonProperty("ddlSetaiShotokuKubun")
    public void setDdlSetaiShotokuKubun(DropDownList ddlSetaiShotokuKubun) {
        this.ddlSetaiShotokuKubun = ddlSetaiShotokuKubun;
    }

    /*
     * getddlShotokuKubun
     * @return ddlShotokuKubun
     */
    @JsonProperty("ddlShotokuKubun")
    public DropDownList getDdlShotokuKubun() {
        return ddlShotokuKubun;
    }

    /*
     * setddlShotokuKubun
     * @param ddlShotokuKubun ddlShotokuKubun
     */
    @JsonProperty("ddlShotokuKubun")
    public void setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.ddlShotokuKubun = ddlShotokuKubun;
    }

    /*
     * getKogakuRadioBtnPanel
     * @return KogakuRadioBtnPanel
     */
    @JsonProperty("KogakuRadioBtnPanel")
    public KogakuRadioBtnPanelDiv getKogakuRadioBtnPanel() {
        return KogakuRadioBtnPanel;
    }

    /*
     * setKogakuRadioBtnPanel
     * @param KogakuRadioBtnPanel KogakuRadioBtnPanel
     */
    @JsonProperty("KogakuRadioBtnPanel")
    public void setKogakuRadioBtnPanel(KogakuRadioBtnPanelDiv KogakuRadioBtnPanel) {
        this.KogakuRadioBtnPanel = KogakuRadioBtnPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadRoureiFukushiNenkinJukyuAriFlag() {
        return this.getKogakuRadioBtnPanel().getRadRoureiFukushiNenkinJukyuAriFlag();
    }

    @JsonIgnore
    public void setRadRoureiFukushiNenkinJukyuAriFlag(RadioButton radRoureiFukushiNenkinJukyuAriFlag) {
        this.getKogakuRadioBtnPanel().setRadRoureiFukushiNenkinJukyuAriFlag(radRoureiFukushiNenkinJukyuAriFlag);
    }

    @JsonIgnore
    public RadioButton getRadRiyoshaFutan2DankaiAriFlag() {
        return this.getKogakuRadioBtnPanel().getRadRiyoshaFutan2DankaiAriFlag();
    }

    @JsonIgnore
    public void setRadRiyoshaFutan2DankaiAriFlag(RadioButton radRiyoshaFutan2DankaiAriFlag) {
        this.getKogakuRadioBtnPanel().setRadRiyoshaFutan2DankaiAriFlag(radRiyoshaFutan2DankaiAriFlag);
    }

    @JsonIgnore
    public RadioButton getRadShikyuShinseishoOutputAriFlag() {
        return this.getKogakuRadioBtnPanel().getRadShikyuShinseishoOutputAriFlag();
    }

    @JsonIgnore
    public void setRadShikyuShinseishoOutputAriFlag(RadioButton radShikyuShinseishoOutputAriFlag) {
        this.getKogakuRadioBtnPanel().setRadShikyuShinseishoOutputAriFlag(radShikyuShinseishoOutputAriFlag);
    }

    // </editor-fold>
}
