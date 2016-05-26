package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KyodoJukyushaIdoRenrakuhyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyodoJukyushaIdoRenrakuhyoDiv extends Panel implements IKyodoJukyushaIdoRenrakuhyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHiHokenshaNo")
    private TextBox txtHiHokenshaNo;
    @JsonProperty("txtTaisyoYM")
    private TextBoxDate txtTaisyoYM;
    @JsonProperty("txtIdoYMD")
    private TextBoxDate txtIdoYMD;
    @JsonProperty("txtShoKisaiHokenshaNo")
    private TextBox txtShoKisaiHokenshaNo;
    @JsonProperty("radIdoKubunCode")
    private RadioButton radIdoKubunCode;
    @JsonProperty("ddlJukyushaIdoJiyu")
    private DropDownList ddlJukyushaIdoJiyu;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoTeisei")
    private KyodoJukyushaIdoRenrakuhyoTeiseiDiv KyodoJukyushaIdoRenrakuhyoTeisei;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("chkKihonSofu")
    private CheckBoxList chkKihonSofu;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihonPanel")
    private KyodoJukyushaIdoRenrakuhyoKihonPanelDiv KyodoJukyushaIdoRenrakuhyoKihonPanel;
    @JsonProperty("chkShokanSofu")
    private CheckBoxList chkShokanSofu;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokanPanel")
    private KyodoJukyushaIdoRenrakuhyoShokanPanelDiv KyodoJukyushaIdoRenrakuhyoShokanPanel;
    @JsonProperty("chkKogakuSofu")
    private CheckBoxList chkKogakuSofu;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogakuPanel")
    private KyodoJukyushaIdoRenrakuhyoKogakuPanelDiv KyodoJukyushaIdoRenrakuhyoKogakuPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHiHokenshaNo
     * @return txtHiHokenshaNo
     */
    @JsonProperty("txtHiHokenshaNo")
    public TextBox getTxtHiHokenshaNo() {
        return txtHiHokenshaNo;
    }

    /*
     * settxtHiHokenshaNo
     * @param txtHiHokenshaNo txtHiHokenshaNo
     */
    @JsonProperty("txtHiHokenshaNo")
    public void setTxtHiHokenshaNo(TextBox txtHiHokenshaNo) {
        this.txtHiHokenshaNo = txtHiHokenshaNo;
    }

    /*
     * gettxtTaisyoYM
     * @return txtTaisyoYM
     */
    @JsonProperty("txtTaisyoYM")
    public TextBoxDate getTxtTaisyoYM() {
        return txtTaisyoYM;
    }

    /*
     * settxtTaisyoYM
     * @param txtTaisyoYM txtTaisyoYM
     */
    @JsonProperty("txtTaisyoYM")
    public void setTxtTaisyoYM(TextBoxDate txtTaisyoYM) {
        this.txtTaisyoYM = txtTaisyoYM;
    }

    /*
     * gettxtIdoYMD
     * @return txtIdoYMD
     */
    @JsonProperty("txtIdoYMD")
    public TextBoxDate getTxtIdoYMD() {
        return txtIdoYMD;
    }

    /*
     * settxtIdoYMD
     * @param txtIdoYMD txtIdoYMD
     */
    @JsonProperty("txtIdoYMD")
    public void setTxtIdoYMD(TextBoxDate txtIdoYMD) {
        this.txtIdoYMD = txtIdoYMD;
    }

    /*
     * gettxtShoKisaiHokenshaNo
     * @return txtShoKisaiHokenshaNo
     */
    @JsonProperty("txtShoKisaiHokenshaNo")
    public TextBox getTxtShoKisaiHokenshaNo() {
        return txtShoKisaiHokenshaNo;
    }

    /*
     * settxtShoKisaiHokenshaNo
     * @param txtShoKisaiHokenshaNo txtShoKisaiHokenshaNo
     */
    @JsonProperty("txtShoKisaiHokenshaNo")
    public void setTxtShoKisaiHokenshaNo(TextBox txtShoKisaiHokenshaNo) {
        this.txtShoKisaiHokenshaNo = txtShoKisaiHokenshaNo;
    }

    /*
     * getradIdoKubunCode
     * @return radIdoKubunCode
     */
    @JsonProperty("radIdoKubunCode")
    public RadioButton getRadIdoKubunCode() {
        return radIdoKubunCode;
    }

    /*
     * setradIdoKubunCode
     * @param radIdoKubunCode radIdoKubunCode
     */
    @JsonProperty("radIdoKubunCode")
    public void setRadIdoKubunCode(RadioButton radIdoKubunCode) {
        this.radIdoKubunCode = radIdoKubunCode;
    }

    /*
     * getddlJukyushaIdoJiyu
     * @return ddlJukyushaIdoJiyu
     */
    @JsonProperty("ddlJukyushaIdoJiyu")
    public DropDownList getDdlJukyushaIdoJiyu() {
        return ddlJukyushaIdoJiyu;
    }

    /*
     * setddlJukyushaIdoJiyu
     * @param ddlJukyushaIdoJiyu ddlJukyushaIdoJiyu
     */
    @JsonProperty("ddlJukyushaIdoJiyu")
    public void setDdlJukyushaIdoJiyu(DropDownList ddlJukyushaIdoJiyu) {
        this.ddlJukyushaIdoJiyu = ddlJukyushaIdoJiyu;
    }

    /*
     * getKyodoJukyushaIdoRenrakuhyoTeisei
     * @return KyodoJukyushaIdoRenrakuhyoTeisei
     */
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoTeisei")
    public KyodoJukyushaIdoRenrakuhyoTeiseiDiv getKyodoJukyushaIdoRenrakuhyoTeisei() {
        return KyodoJukyushaIdoRenrakuhyoTeisei;
    }

    /*
     * setKyodoJukyushaIdoRenrakuhyoTeisei
     * @param KyodoJukyushaIdoRenrakuhyoTeisei KyodoJukyushaIdoRenrakuhyoTeisei
     */
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoTeisei")
    public void setKyodoJukyushaIdoRenrakuhyoTeisei(KyodoJukyushaIdoRenrakuhyoTeiseiDiv KyodoJukyushaIdoRenrakuhyoTeisei) {
        this.KyodoJukyushaIdoRenrakuhyoTeisei = KyodoJukyushaIdoRenrakuhyoTeisei;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * getchkKihonSofu
     * @return chkKihonSofu
     */
    @JsonProperty("chkKihonSofu")
    public CheckBoxList getChkKihonSofu() {
        return chkKihonSofu;
    }

    /*
     * setchkKihonSofu
     * @param chkKihonSofu chkKihonSofu
     */
    @JsonProperty("chkKihonSofu")
    public void setChkKihonSofu(CheckBoxList chkKihonSofu) {
        this.chkKihonSofu = chkKihonSofu;
    }

    /*
     * getKyodoJukyushaIdoRenrakuhyoKihonPanel
     * @return KyodoJukyushaIdoRenrakuhyoKihonPanel
     */
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihonPanel")
    public KyodoJukyushaIdoRenrakuhyoKihonPanelDiv getKyodoJukyushaIdoRenrakuhyoKihonPanel() {
        return KyodoJukyushaIdoRenrakuhyoKihonPanel;
    }

    /*
     * setKyodoJukyushaIdoRenrakuhyoKihonPanel
     * @param KyodoJukyushaIdoRenrakuhyoKihonPanel KyodoJukyushaIdoRenrakuhyoKihonPanel
     */
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihonPanel")
    public void setKyodoJukyushaIdoRenrakuhyoKihonPanel(KyodoJukyushaIdoRenrakuhyoKihonPanelDiv KyodoJukyushaIdoRenrakuhyoKihonPanel) {
        this.KyodoJukyushaIdoRenrakuhyoKihonPanel = KyodoJukyushaIdoRenrakuhyoKihonPanel;
    }

    /*
     * getchkShokanSofu
     * @return chkShokanSofu
     */
    @JsonProperty("chkShokanSofu")
    public CheckBoxList getChkShokanSofu() {
        return chkShokanSofu;
    }

    /*
     * setchkShokanSofu
     * @param chkShokanSofu chkShokanSofu
     */
    @JsonProperty("chkShokanSofu")
    public void setChkShokanSofu(CheckBoxList chkShokanSofu) {
        this.chkShokanSofu = chkShokanSofu;
    }

    /*
     * getKyodoJukyushaIdoRenrakuhyoShokanPanel
     * @return KyodoJukyushaIdoRenrakuhyoShokanPanel
     */
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokanPanel")
    public KyodoJukyushaIdoRenrakuhyoShokanPanelDiv getKyodoJukyushaIdoRenrakuhyoShokanPanel() {
        return KyodoJukyushaIdoRenrakuhyoShokanPanel;
    }

    /*
     * setKyodoJukyushaIdoRenrakuhyoShokanPanel
     * @param KyodoJukyushaIdoRenrakuhyoShokanPanel KyodoJukyushaIdoRenrakuhyoShokanPanel
     */
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokanPanel")
    public void setKyodoJukyushaIdoRenrakuhyoShokanPanel(KyodoJukyushaIdoRenrakuhyoShokanPanelDiv KyodoJukyushaIdoRenrakuhyoShokanPanel) {
        this.KyodoJukyushaIdoRenrakuhyoShokanPanel = KyodoJukyushaIdoRenrakuhyoShokanPanel;
    }

    /*
     * getchkKogakuSofu
     * @return chkKogakuSofu
     */
    @JsonProperty("chkKogakuSofu")
    public CheckBoxList getChkKogakuSofu() {
        return chkKogakuSofu;
    }

    /*
     * setchkKogakuSofu
     * @param chkKogakuSofu chkKogakuSofu
     */
    @JsonProperty("chkKogakuSofu")
    public void setChkKogakuSofu(CheckBoxList chkKogakuSofu) {
        this.chkKogakuSofu = chkKogakuSofu;
    }

    /*
     * getKyodoJukyushaIdoRenrakuhyoKogakuPanel
     * @return KyodoJukyushaIdoRenrakuhyoKogakuPanel
     */
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogakuPanel")
    public KyodoJukyushaIdoRenrakuhyoKogakuPanelDiv getKyodoJukyushaIdoRenrakuhyoKogakuPanel() {
        return KyodoJukyushaIdoRenrakuhyoKogakuPanel;
    }

    /*
     * setKyodoJukyushaIdoRenrakuhyoKogakuPanel
     * @param KyodoJukyushaIdoRenrakuhyoKogakuPanel KyodoJukyushaIdoRenrakuhyoKogakuPanel
     */
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogakuPanel")
    public void setKyodoJukyushaIdoRenrakuhyoKogakuPanel(KyodoJukyushaIdoRenrakuhyoKogakuPanelDiv KyodoJukyushaIdoRenrakuhyoKogakuPanel) {
        this.KyodoJukyushaIdoRenrakuhyoKogakuPanel = KyodoJukyushaIdoRenrakuhyoKogakuPanel;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        shinki("shinki"),
        teisei("teisei"),
        sakujyo("sakujyo"),
        shokai("shokai");

        private final String name;

        private DisplayMode(final String name) {
            this.name = name;
        }

        public static DisplayMode getEnum(String str) {
            DisplayMode[] enumArray = DisplayMode.values();

            for (DisplayMode enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) { 
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode( this.modes, DisplayMode.class );
    }

    public void setMode_DisplayMode( DisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayMode.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setLin1(lin1);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeiseiYMD() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD();
    }

    @JsonIgnore
    public void  setTxtTeiseiYMD(TextBoxDate txtTeiseiYMD) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setTxtTeiseiYMD(txtTeiseiYMD);
    }

    @JsonIgnore
    public RadioButton getRadTeiseiKubunCode() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode();
    }

    @JsonIgnore
    public void  setRadTeiseiKubunCode(RadioButton radTeiseiKubunCode) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setRadTeiseiKubunCode(radTeiseiKubunCode);
    }

    @JsonIgnore
    public RadioButton getRadRoureiFukushiNenkinJukyuAriFlag() {
        return this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().getRadRoureiFukushiNenkinJukyuAriFlag();
    }

    @JsonIgnore
    public void  setRadRoureiFukushiNenkinJukyuAriFlag(RadioButton radRoureiFukushiNenkinJukyuAriFlag) {
        this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().setRadRoureiFukushiNenkinJukyuAriFlag(radRoureiFukushiNenkinJukyuAriFlag);
    }

    @JsonIgnore
    public RadioButton getRadRiyoshaFutan2DankaiAriFlag() {
        return this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().getRadRiyoshaFutan2DankaiAriFlag();
    }

    @JsonIgnore
    public void  setRadRiyoshaFutan2DankaiAriFlag(RadioButton radRiyoshaFutan2DankaiAriFlag) {
        this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().setRadRiyoshaFutan2DankaiAriFlag(radRiyoshaFutan2DankaiAriFlag);
    }

    @JsonIgnore
    public RadioButton getRadShikyuShinseishoOutputAriFlag() {
        return this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().getRadShikyuShinseishoOutputAriFlag();
    }

    @JsonIgnore
    public void  setRadShikyuShinseishoOutputAriFlag(RadioButton radShikyuShinseishoOutputAriFlag) {
        this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().setRadShikyuShinseishoOutputAriFlag(radShikyuShinseishoOutputAriFlag);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
