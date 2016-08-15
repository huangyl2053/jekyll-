package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KyodoJukyushaIdoRenrakuhyo のクラスファイル
 *
 * @reamsid_L DBC-4390-010 xupeng
 */
public class KyodoJukyushaIdoRenrakuhyoDiv extends Panel implements IKyodoJukyushaIdoRenrakuhyoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("chkKihonSofuAdd")
    private CheckBoxList chkKihonSofuAdd;
    @JsonProperty("chkKihonSofuDelete")
    private CheckBoxList chkKihonSofuDelete;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihonPanel")
    private KyodoJukyushaIdoRenrakuhyoKihonPanelDiv KyodoJukyushaIdoRenrakuhyoKihonPanel;
    @JsonProperty("chkShokanSofuAdd")
    private CheckBoxList chkShokanSofuAdd;
    @JsonProperty("chkShokanSofuDelete")
    private CheckBoxList chkShokanSofuDelete;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokanPanel")
    private KyodoJukyushaIdoRenrakuhyoShokanPanelDiv KyodoJukyushaIdoRenrakuhyoShokanPanel;
    @JsonProperty("chkKogakuSofuAdd")
    private CheckBoxList chkKogakuSofuAdd;
    @JsonProperty("chkKogakuSofuDelete")
    private CheckBoxList chkKogakuSofuDelete;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogakuPanel")
    private KyodoJukyushaIdoRenrakuhyoKogakuPanelDiv KyodoJukyushaIdoRenrakuhyoKogakuPanel;
    @JsonProperty("hdnHiHokenshaNo")
    private RString hdnHiHokenshaNo;
    @JsonProperty("hdnIdoYMD")
    private RString hdnIdoYMD;
    @JsonProperty("hdnDeleteFlg")
    private RString hdnDeleteFlg;
    @JsonProperty("hdnTaisyoYM")
    private RString hdnTaisyoYM;
    @JsonProperty("hdnKyodoShoriyoJukyushaIdoEntity")
    private RString hdnKyodoShoriyoJukyushaIdoEntity;

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
     * getchkKihonSofuAdd
     * @return chkKihonSofuAdd
     */
    @JsonProperty("chkKihonSofuAdd")
    public CheckBoxList getChkKihonSofuAdd() {
        return chkKihonSofuAdd;
    }

    /*
     * setchkKihonSofuAdd
     * @param chkKihonSofuAdd chkKihonSofuAdd
     */
    @JsonProperty("chkKihonSofuAdd")
    public void setChkKihonSofuAdd(CheckBoxList chkKihonSofuAdd) {
        this.chkKihonSofuAdd = chkKihonSofuAdd;
    }

    /*
     * getchkKihonSofuDelete
     * @return chkKihonSofuDelete
     */
    @JsonProperty("chkKihonSofuDelete")
    public CheckBoxList getChkKihonSofuDelete() {
        return chkKihonSofuDelete;
    }

    /*
     * setchkKihonSofuDelete
     * @param chkKihonSofuDelete chkKihonSofuDelete
     */
    @JsonProperty("chkKihonSofuDelete")
    public void setChkKihonSofuDelete(CheckBoxList chkKihonSofuDelete) {
        this.chkKihonSofuDelete = chkKihonSofuDelete;
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
     * getchkShokanSofuAdd
     * @return chkShokanSofuAdd
     */
    @JsonProperty("chkShokanSofuAdd")
    public CheckBoxList getChkShokanSofuAdd() {
        return chkShokanSofuAdd;
    }

    /*
     * setchkShokanSofuAdd
     * @param chkShokanSofuAdd chkShokanSofuAdd
     */
    @JsonProperty("chkShokanSofuAdd")
    public void setChkShokanSofuAdd(CheckBoxList chkShokanSofuAdd) {
        this.chkShokanSofuAdd = chkShokanSofuAdd;
    }

    /*
     * getchkShokanSofuDelete
     * @return chkShokanSofuDelete
     */
    @JsonProperty("chkShokanSofuDelete")
    public CheckBoxList getChkShokanSofuDelete() {
        return chkShokanSofuDelete;
    }

    /*
     * setchkShokanSofuDelete
     * @param chkShokanSofuDelete chkShokanSofuDelete
     */
    @JsonProperty("chkShokanSofuDelete")
    public void setChkShokanSofuDelete(CheckBoxList chkShokanSofuDelete) {
        this.chkShokanSofuDelete = chkShokanSofuDelete;
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
     * getchkKogakuSofuAdd
     * @return chkKogakuSofuAdd
     */
    @JsonProperty("chkKogakuSofuAdd")
    public CheckBoxList getChkKogakuSofuAdd() {
        return chkKogakuSofuAdd;
    }

    /*
     * setchkKogakuSofuAdd
     * @param chkKogakuSofuAdd chkKogakuSofuAdd
     */
    @JsonProperty("chkKogakuSofuAdd")
    public void setChkKogakuSofuAdd(CheckBoxList chkKogakuSofuAdd) {
        this.chkKogakuSofuAdd = chkKogakuSofuAdd;
    }

    /*
     * getchkKogakuSofuDelete
     * @return chkKogakuSofuDelete
     */
    @JsonProperty("chkKogakuSofuDelete")
    public CheckBoxList getChkKogakuSofuDelete() {
        return chkKogakuSofuDelete;
    }

    /*
     * setchkKogakuSofuDelete
     * @param chkKogakuSofuDelete chkKogakuSofuDelete
     */
    @JsonProperty("chkKogakuSofuDelete")
    public void setChkKogakuSofuDelete(CheckBoxList chkKogakuSofuDelete) {
        this.chkKogakuSofuDelete = chkKogakuSofuDelete;
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
     * gethdnHiHokenshaNo
     * @return hdnHiHokenshaNo
     */
    @JsonProperty("hdnHiHokenshaNo")
    public RString getHdnHiHokenshaNo() {
        return hdnHiHokenshaNo;
    }

    /*
     * sethdnHiHokenshaNo
     * @param hdnHiHokenshaNo hdnHiHokenshaNo
     */
    @JsonProperty("hdnHiHokenshaNo")
    public void setHdnHiHokenshaNo(RString hdnHiHokenshaNo) {
        this.hdnHiHokenshaNo = hdnHiHokenshaNo;
    }

    /*
     * gethdnIdoYMD
     * @return hdnIdoYMD
     */
    @JsonProperty("hdnIdoYMD")
    public RString getHdnIdoYMD() {
        return hdnIdoYMD;
    }

    /*
     * sethdnIdoYMD
     * @param hdnIdoYMD hdnIdoYMD
     */
    @JsonProperty("hdnIdoYMD")
    public void setHdnIdoYMD(RString hdnIdoYMD) {
        this.hdnIdoYMD = hdnIdoYMD;
    }

    /*
     * gethdnDeleteFlg
     * @return hdnDeleteFlg
     */
    @JsonProperty("hdnDeleteFlg")
    public RString getHdnDeleteFlg() {
        return hdnDeleteFlg;
    }

    /*
     * sethdnDeleteFlg
     * @param hdnDeleteFlg hdnDeleteFlg
     */
    @JsonProperty("hdnDeleteFlg")
    public void setHdnDeleteFlg(RString hdnDeleteFlg) {
        this.hdnDeleteFlg = hdnDeleteFlg;
    }

    /*
     * gethdnTaisyoYM
     * @return hdnTaisyoYM
     */
    @JsonProperty("hdnTaisyoYM")
    public RString getHdnTaisyoYM() {
        return hdnTaisyoYM;
    }

    /*
     * sethdnTaisyoYM
     * @param hdnTaisyoYM hdnTaisyoYM
     */
    @JsonProperty("hdnTaisyoYM")
    public void setHdnTaisyoYM(RString hdnTaisyoYM) {
        this.hdnTaisyoYM = hdnTaisyoYM;
    }

    /*
     * gethdnKyodoShoriyoJukyushaIdoEntity
     * @return hdnKyodoShoriyoJukyushaIdoEntity
     */
    @JsonProperty("hdnKyodoShoriyoJukyushaIdoEntity")
    public RString getHdnKyodoShoriyoJukyushaIdoEntity() {
        return hdnKyodoShoriyoJukyushaIdoEntity;
    }

    /*
     * sethdnKyodoShoriyoJukyushaIdoEntity
     * @param hdnKyodoShoriyoJukyushaIdoEntity hdnKyodoShoriyoJukyushaIdoEntity
     */
    @JsonProperty("hdnKyodoShoriyoJukyushaIdoEntity")
    public void setHdnKyodoShoriyoJukyushaIdoEntity(RString hdnKyodoShoriyoJukyushaIdoEntity) {
        this.hdnKyodoShoriyoJukyushaIdoEntity = hdnKyodoShoriyoJukyushaIdoEntity;
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
        return (DisplayMode) _CommonChildDivModeUtil.getMode(this.modes, DisplayMode.class);
    }

    public void setMode_DisplayMode(DisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, DisplayMode.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setLin1(lin1);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeiseiYMD() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD();
    }

    @JsonIgnore
    public void setTxtTeiseiYMD(TextBoxDate txtTeiseiYMD) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setTxtTeiseiYMD(txtTeiseiYMD);
    }

    @JsonIgnore
    public RadioButton getRadTeiseiKubunCode() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode();
    }

    @JsonIgnore
    public void setRadTeiseiKubunCode(RadioButton radTeiseiKubunCode) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setRadTeiseiKubunCode(radTeiseiKubunCode);
    }

    @JsonIgnore
    public RadioButton getRadRoureiFukushiNenkinJukyuAriFlag() {
        return this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().getRadRoureiFukushiNenkinJukyuAriFlag();
    }

    @JsonIgnore
    public void setRadRoureiFukushiNenkinJukyuAriFlag(RadioButton radRoureiFukushiNenkinJukyuAriFlag) {
        this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().setRadRoureiFukushiNenkinJukyuAriFlag(radRoureiFukushiNenkinJukyuAriFlag);
    }

    @JsonIgnore
    public RadioButton getRadRiyoshaFutan2DankaiAriFlag() {
        return this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().getRadRiyoshaFutan2DankaiAriFlag();
    }

    @JsonIgnore
    public void setRadRiyoshaFutan2DankaiAriFlag(RadioButton radRiyoshaFutan2DankaiAriFlag) {
        this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().setRadRiyoshaFutan2DankaiAriFlag(radRiyoshaFutan2DankaiAriFlag);
    }

    @JsonIgnore
    public RadioButton getRadShikyuShinseishoOutputAriFlag() {
        return this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().getRadShikyuShinseishoOutputAriFlag();
    }

    @JsonIgnore
    public void setRadShikyuShinseishoOutputAriFlag(RadioButton radShikyuShinseishoOutputAriFlag) {
        this.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getKogakuRadioBtnPanel().setRadShikyuShinseishoOutputAriFlag(radShikyuShinseishoOutputAriFlag);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 画面を画面初期化します。
     *
     * @param 処理モード RString
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     * @param 論理削除 boolean
     * @param 対象年月 FlexibleYearMonth
     * @return KyodoshoriyoJukyushaIdoRenrakuhyoParam
     */
    @JsonIgnore
    @Override
    public KyodoshoriyoJukyushaIdoRenrakuhyoParam initialize(RString 処理モード, HihokenshaNo 被保険者番号,
            FlexibleDate 異動日, boolean 論理削除, FlexibleYearMonth 対象年月) {
        return KyodoJukyushaIdoRenrakuhyoDivHandler.of(this).initialize(処理モード, 被保険者番号, 異動日, 論理削除, 対象年月);
    }

    /**
     * 最新画面データ
     *
     * @return KyodoshoriyoJukyushaIdoRenrakuhyoParam
     */
    @JsonIgnore
    @Override
    public KyodoshoriyoJukyushaIdoRenrakuhyoParam getNewデータ() {
        return KyodoJukyushaIdoRenrakuhyoDivHandler.of(this).getNewデータ();
    }

    /**
     * 一時差止日の入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs get一時差止日の入力チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivHandler.of(this).一時差止日の入力チェック();
    }

    /**
     * 一時差止日の関連チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs get一時差止日の関連チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivHandler.of(this).一時差止日の関連チェック();
    }

    /**
     * 「基本送付情報を追加する」チェックボックス。
     *
     * @return list
     */
    @JsonIgnore
    @Override
    public List<RString> get基本送付情報を追加する() {
        return this.getChkKihonSofuAdd().getSelectedKeys();
    }

    /**
     * 「償還送付情報を追加する」チェックボックス。
     *
     * @return list
     */
    @JsonIgnore
    @Override
    public List<RString> get償還送付情報を追加する() {
        return this.getChkShokanSofuAdd().getSelectedKeys();
    }

    /**
     * 「高額送付情報を追加する」チェックボックス。
     *
     * @return list
     */
    @JsonIgnore
    @Override
    public List<RString> get高額送付情報を追加する() {
        return this.getChkKogakuSofuAdd().getSelectedKeys();
    }

    /**
     * 「基本送付情報を削除する」チェックボックス。
     *
     * @return list
     */
    @JsonIgnore
    @Override
    public List<RString> get基本送付情報を削除する() {
        return this.getChkKihonSofuDelete().getSelectedKeys();
    }

    /**
     * 「償還送付情報を削除する」チェックボックス。
     *
     * @return list
     */
    @JsonIgnore
    @Override
    public List<RString> get償還送付情報を削除する() {
        return this.getChkShokanSofuDelete().getSelectedKeys();
    }

    /**
     * 「高額送付情報を削除する」チェックボックス。
     *
     * @return list
     */
    @JsonIgnore
    @Override
    public List<RString> get高額送付情報を削除する() {
        return this.getChkKogakuSofuDelete().getSelectedKeys();
    }

    /**
     * 基本送付情報の履歴番号。
     *
     * @return 履歴番号 int
     */
    @JsonIgnore
    @Override
    public Decimal get基本送付_履歴番号() {
        return this.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtRirekiNo().getValue();
    }

    /**
     * 償還送付情報の履歴番号。
     *
     * @return 履歴番号 int
     */
    @JsonIgnore
    @Override
    public Decimal get償還送付_履歴番号() {
        return this.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtRirekiNo().getValue();
    }

    /**
     * 高額送付情報の履歴番号。
     *
     * @return 履歴番号 int
     */
    @JsonIgnore
    @Override
    public Decimal get高額送付_履歴番号() {
        return this.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtRirekiNo().getValue();
    }

    /**
     * 訂正区分。
     *
     * @return 訂正区分 RString
     */
    @JsonIgnore
    @Override
    public RString get訂正区分() {
        return this.getRadTeiseiKubunCode().getSelectedValue();
    }

    /**
     * 訂正年月日。
     *
     * @return 訂正年月日 RDate
     */
    @JsonIgnore
    @Override
    public RDate get訂正年月日() {
        return this.getTxtTeiseiYMD().getValue();
    }

    /**
     * 基本送付情報を追加活性する。
     *
     * @return boolean
     */
    @JsonIgnore
    @Override
    public boolean get基本送付情報を追加活性() {
        return !this.getChkKihonSofuAdd().isDisabled();
    }

    /**
     * 償還送付情報を追加活性する。
     *
     * @return boolean
     */
    @JsonIgnore
    @Override
    public boolean get償還送付情報を追加活性() {
        return !this.getChkShokanSofuAdd().isDisabled();
    }

    /**
     * 高額送付情報を追加活性する。
     *
     * @return boolean
     */
    @JsonIgnore
    @Override
    public boolean get高額送付情報を追加活性() {
        return !this.getChkKogakuSofuAdd().isDisabled();
    }

    /**
     * 基本送付情報の異動日チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 基本送付情報の異動日チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).基本送付情報の異動日チェック();
    }

    /**
     * 償還送付情報の異動日チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 償還送付情報の異動日チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).償還送付情報の異動日チェック();
    }

    /**
     * 高額送付情報の異動日チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 高額送付情報の異動日チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).高額送付情報の異動日チェック();
    }

    /**
     * 基本送付情報の異動区分チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 基本送付情報の異動区分チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).基本送付情報の異動区分チェック();
    }

    /**
     * 償還送付情報の異動区分チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 償還送付情報の異動区分チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).償還送付情報の異動区分チェック();
    }

    /**
     * 高額送付情報の異動区分チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 高額送付情報の異動区分チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).高額送付情報の異動区分チェック();
    }

    /**
     * 基本送付情報の履歴番号チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 基本送付情報の履歴番号チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).基本送付情報の履歴番号チェック();
    }

    /**
     * 償還送付情報の履歴番号チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 償還送付情報の履歴番号チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).償還送付情報の履歴番号チェック();
    }

    /**
     * 高額送付情報の履歴番号チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 高額送付情報の履歴番号チェック() {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).高額送付情報の履歴番号チェック();
    }

    /**
     * 修正有無チェック
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs 修正有無チェック(KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化異動情報Entity,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 画面項目異動情報Entity, boolean 基本送付情報Flag,
            boolean 償還送付情報変Flag, boolean 高額送付情報Flag) {
        return KyodoJukyushaIdoRenrakuhyoDivValidationHandler.of(this).修正有無チェック(初期化異動情報Entity,
                画面項目異動情報Entity, 基本送付情報Flag, 償還送付情報変Flag, 高額送付情報Flag);
    }
}
