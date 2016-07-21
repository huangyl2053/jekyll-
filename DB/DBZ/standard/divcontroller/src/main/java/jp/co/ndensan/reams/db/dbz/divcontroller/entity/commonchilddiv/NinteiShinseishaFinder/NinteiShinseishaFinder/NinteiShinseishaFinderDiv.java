package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNumRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * NinteiShinseishaFinder のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class NinteiShinseishaFinderDiv extends Panel implements INinteiShinseishaFinderDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNumber")
    private TextBoxCode txtHihokenshaNumber;
    @JsonProperty("ddlHokenshaNumber")
    private HokenshaListDiv ddlHokenshaNumber;
    @JsonProperty("ddlShichosonCode")
    private DropDownList ddlShichosonCode;
    @JsonProperty("linHorizon")
    private HorizontalLine linHorizon;
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("ddlHihokenshaNameMatchType")
    private DropDownList ddlHihokenshaNameMatchType;
    @JsonProperty("chkMinashiFlag")
    private CheckBoxList chkMinashiFlag;
    @JsonProperty("txtNinteiShinseiDateFrom")
    private TextBoxFlexibleDate txtNinteiShinseiDateFrom;
    @JsonProperty("lblNinteiShinseiDate")
    private Label lblNinteiShinseiDate;
    @JsonProperty("txtNinteiShinseiDateTo")
    private TextBoxFlexibleDate txtNinteiShinseiDateTo;
    @JsonProperty("txtBirthDateFrom")
    private TextBoxFlexibleDate txtBirthDateFrom;
    @JsonProperty("lblBirthDate")
    private Label lblBirthDate;
    @JsonProperty("txtBirthDateTO")
    private TextBoxFlexibleDate txtBirthDateTO;
    @JsonProperty("ddlShinseijiShinseiKubun")
    private DropDownList ddlShinseijiShinseiKubun;
    @JsonProperty("chkSeibetsu")
    private CheckBoxList chkSeibetsu;
    @JsonProperty("ShosaiJoken")
    private ShosaiJokenDiv ShosaiJoken;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;
    @JsonProperty("hdnChosaItakusakiCode")
    private RString hdnChosaItakusakiCode;
    @JsonProperty("hdnChosainCode")
    private RString hdnChosainCode;
    @JsonProperty("hdnShujiiIryokikanCode")
    private RString hdnShujiiIryokikanCode;
    @JsonProperty("hdnShujiiCode")
    private RString hdnShujiiCode;
    @JsonProperty("hdnZenkaiChosaItakusakiCode")
    private RString hdnZenkaiChosaItakusakiCode;
    @JsonProperty("hdnZenkaiShujiiIryokikanCode")
    private RString hdnZenkaiShujiiIryokikanCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNumber
     * @return txtHihokenshaNumber
     */
    @JsonProperty("txtHihokenshaNumber")
    public TextBoxCode getTxtHihokenshaNumber() {
        return txtHihokenshaNumber;
    }

    /*
     * settxtHihokenshaNumber
     * @param txtHihokenshaNumber txtHihokenshaNumber
     */
    @JsonProperty("txtHihokenshaNumber")
    public void setTxtHihokenshaNumber(TextBoxCode txtHihokenshaNumber) {
        this.txtHihokenshaNumber = txtHihokenshaNumber;
    }

    /*
     * getddlHokenshaNumber
     * @return ddlHokenshaNumber
     */
    @JsonProperty("ddlHokenshaNumber")
    public IHokenshaListDiv getDdlHokenshaNumber() {
        return ddlHokenshaNumber;
    }

    /*
     * getddlShichosonCode
     * @return ddlShichosonCode
     */
    @JsonProperty("ddlShichosonCode")
    public DropDownList getDdlShichosonCode() {
        return ddlShichosonCode;
    }

    /*
     * setddlShichosonCode
     * @param ddlShichosonCode ddlShichosonCode
     */
    @JsonProperty("ddlShichosonCode")
    public void setDdlShichosonCode(DropDownList ddlShichosonCode) {
        this.ddlShichosonCode = ddlShichosonCode;
    }

    /*
     * getlinHorizon
     * @return linHorizon
     */
    @JsonProperty("linHorizon")
    public HorizontalLine getLinHorizon() {
        return linHorizon;
    }

    /*
     * setlinHorizon
     * @param linHorizon linHorizon
     */
    @JsonProperty("linHorizon")
    public void setLinHorizon(HorizontalLine linHorizon) {
        this.linHorizon = linHorizon;
    }

    /*
     * gettxtHihokenshaName
     * @return txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public TextBox getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    /*
     * settxtHihokenshaName
     * @param txtHihokenshaName txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.txtHihokenshaName = txtHihokenshaName;
    }

    /*
     * getddlHihokenshaNameMatchType
     * @return ddlHihokenshaNameMatchType
     */
    @JsonProperty("ddlHihokenshaNameMatchType")
    public DropDownList getDdlHihokenshaNameMatchType() {
        return ddlHihokenshaNameMatchType;
    }

    /*
     * setddlHihokenshaNameMatchType
     * @param ddlHihokenshaNameMatchType ddlHihokenshaNameMatchType
     */
    @JsonProperty("ddlHihokenshaNameMatchType")
    public void setDdlHihokenshaNameMatchType(DropDownList ddlHihokenshaNameMatchType) {
        this.ddlHihokenshaNameMatchType = ddlHihokenshaNameMatchType;
    }

    /*
     * getchkMinashiFlag
     * @return chkMinashiFlag
     */
    @JsonProperty("chkMinashiFlag")
    public CheckBoxList getChkMinashiFlag() {
        return chkMinashiFlag;
    }

    /*
     * setchkMinashiFlag
     * @param chkMinashiFlag chkMinashiFlag
     */
    @JsonProperty("chkMinashiFlag")
    public void setChkMinashiFlag(CheckBoxList chkMinashiFlag) {
        this.chkMinashiFlag = chkMinashiFlag;
    }

    /*
     * gettxtNinteiShinseiDateFrom
     * @return txtNinteiShinseiDateFrom
     */
    @JsonProperty("txtNinteiShinseiDateFrom")
    public TextBoxFlexibleDate getTxtNinteiShinseiDateFrom() {
        return txtNinteiShinseiDateFrom;
    }

    /*
     * settxtNinteiShinseiDateFrom
     * @param txtNinteiShinseiDateFrom txtNinteiShinseiDateFrom
     */
    @JsonProperty("txtNinteiShinseiDateFrom")
    public void setTxtNinteiShinseiDateFrom(TextBoxFlexibleDate txtNinteiShinseiDateFrom) {
        this.txtNinteiShinseiDateFrom = txtNinteiShinseiDateFrom;
    }

    /*
     * getlblNinteiShinseiDate
     * @return lblNinteiShinseiDate
     */
    @JsonProperty("lblNinteiShinseiDate")
    public Label getLblNinteiShinseiDate() {
        return lblNinteiShinseiDate;
    }

    /*
     * setlblNinteiShinseiDate
     * @param lblNinteiShinseiDate lblNinteiShinseiDate
     */
    @JsonProperty("lblNinteiShinseiDate")
    public void setLblNinteiShinseiDate(Label lblNinteiShinseiDate) {
        this.lblNinteiShinseiDate = lblNinteiShinseiDate;
    }

    /*
     * gettxtNinteiShinseiDateTo
     * @return txtNinteiShinseiDateTo
     */
    @JsonProperty("txtNinteiShinseiDateTo")
    public TextBoxFlexibleDate getTxtNinteiShinseiDateTo() {
        return txtNinteiShinseiDateTo;
    }

    /*
     * settxtNinteiShinseiDateTo
     * @param txtNinteiShinseiDateTo txtNinteiShinseiDateTo
     */
    @JsonProperty("txtNinteiShinseiDateTo")
    public void setTxtNinteiShinseiDateTo(TextBoxFlexibleDate txtNinteiShinseiDateTo) {
        this.txtNinteiShinseiDateTo = txtNinteiShinseiDateTo;
    }

    /*
     * gettxtBirthDateFrom
     * @return txtBirthDateFrom
     */
    @JsonProperty("txtBirthDateFrom")
    public TextBoxFlexibleDate getTxtBirthDateFrom() {
        return txtBirthDateFrom;
    }

    /*
     * settxtBirthDateFrom
     * @param txtBirthDateFrom txtBirthDateFrom
     */
    @JsonProperty("txtBirthDateFrom")
    public void setTxtBirthDateFrom(TextBoxFlexibleDate txtBirthDateFrom) {
        this.txtBirthDateFrom = txtBirthDateFrom;
    }

    /*
     * getlblBirthDate
     * @return lblBirthDate
     */
    @JsonProperty("lblBirthDate")
    public Label getLblBirthDate() {
        return lblBirthDate;
    }

    /*
     * setlblBirthDate
     * @param lblBirthDate lblBirthDate
     */
    @JsonProperty("lblBirthDate")
    public void setLblBirthDate(Label lblBirthDate) {
        this.lblBirthDate = lblBirthDate;
    }

    /*
     * gettxtBirthDateTO
     * @return txtBirthDateTO
     */
    @JsonProperty("txtBirthDateTO")
    public TextBoxFlexibleDate getTxtBirthDateTO() {
        return txtBirthDateTO;
    }

    /*
     * settxtBirthDateTO
     * @param txtBirthDateTO txtBirthDateTO
     */
    @JsonProperty("txtBirthDateTO")
    public void setTxtBirthDateTO(TextBoxFlexibleDate txtBirthDateTO) {
        this.txtBirthDateTO = txtBirthDateTO;
    }

    /*
     * getddlShinseijiShinseiKubun
     * @return ddlShinseijiShinseiKubun
     */
    @JsonProperty("ddlShinseijiShinseiKubun")
    public DropDownList getDdlShinseijiShinseiKubun() {
        return ddlShinseijiShinseiKubun;
    }

    /*
     * setddlShinseijiShinseiKubun
     * @param ddlShinseijiShinseiKubun ddlShinseijiShinseiKubun
     */
    @JsonProperty("ddlShinseijiShinseiKubun")
    public void setDdlShinseijiShinseiKubun(DropDownList ddlShinseijiShinseiKubun) {
        this.ddlShinseijiShinseiKubun = ddlShinseijiShinseiKubun;
    }

    /*
     * getchkSeibetsu
     * @return chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public CheckBoxList getChkSeibetsu() {
        return chkSeibetsu;
    }

    /*
     * setchkSeibetsu
     * @param chkSeibetsu chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public void setChkSeibetsu(CheckBoxList chkSeibetsu) {
        this.chkSeibetsu = chkSeibetsu;
    }

    /*
     * getShosaiJoken
     * @return ShosaiJoken
     */
    @JsonProperty("ShosaiJoken")
    public ShosaiJokenDiv getShosaiJoken() {
        return ShosaiJoken;
    }

    /*
     * setShosaiJoken
     * @param ShosaiJoken ShosaiJoken
     */
    @JsonProperty("ShosaiJoken")
    public void setShosaiJoken(ShosaiJokenDiv ShosaiJoken) {
        this.ShosaiJoken = ShosaiJoken;
    }

    /*
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    /*
     * gethdnChosaItakusakiCode
     * @return hdnChosaItakusakiCode
     */
    @JsonProperty("hdnChosaItakusakiCode")
    public RString getHdnChosaItakusakiCode() {
        return hdnChosaItakusakiCode;
    }

    /*
     * sethdnChosaItakusakiCode
     * @param hdnChosaItakusakiCode hdnChosaItakusakiCode
     */
    @JsonProperty("hdnChosaItakusakiCode")
    public void setHdnChosaItakusakiCode(RString hdnChosaItakusakiCode) {
        this.hdnChosaItakusakiCode = hdnChosaItakusakiCode;
    }

    /*
     * gethdnChosainCode
     * @return hdnChosainCode
     */
    @JsonProperty("hdnChosainCode")
    public RString getHdnChosainCode() {
        return hdnChosainCode;
    }

    /*
     * sethdnChosainCode
     * @param hdnChosainCode hdnChosainCode
     */
    @JsonProperty("hdnChosainCode")
    public void setHdnChosainCode(RString hdnChosainCode) {
        this.hdnChosainCode = hdnChosainCode;
    }

    /*
     * gethdnShujiiIryokikanCode
     * @return hdnShujiiIryokikanCode
     */
    @JsonProperty("hdnShujiiIryokikanCode")
    public RString getHdnShujiiIryokikanCode() {
        return hdnShujiiIryokikanCode;
    }

    /*
     * sethdnShujiiIryokikanCode
     * @param hdnShujiiIryokikanCode hdnShujiiIryokikanCode
     */
    @JsonProperty("hdnShujiiIryokikanCode")
    public void setHdnShujiiIryokikanCode(RString hdnShujiiIryokikanCode) {
        this.hdnShujiiIryokikanCode = hdnShujiiIryokikanCode;
    }

    /*
     * gethdnShujiiCode
     * @return hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public RString getHdnShujiiCode() {
        return hdnShujiiCode;
    }

    /*
     * sethdnShujiiCode
     * @param hdnShujiiCode hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public void setHdnShujiiCode(RString hdnShujiiCode) {
        this.hdnShujiiCode = hdnShujiiCode;
    }

    /*
     * gethdnZenkaiChosaItakusakiCode
     * @return hdnZenkaiChosaItakusakiCode
     */
    @JsonProperty("hdnZenkaiChosaItakusakiCode")
    public RString getHdnZenkaiChosaItakusakiCode() {
        return hdnZenkaiChosaItakusakiCode;
    }

    /*
     * sethdnZenkaiChosaItakusakiCode
     * @param hdnZenkaiChosaItakusakiCode hdnZenkaiChosaItakusakiCode
     */
    @JsonProperty("hdnZenkaiChosaItakusakiCode")
    public void setHdnZenkaiChosaItakusakiCode(RString hdnZenkaiChosaItakusakiCode) {
        this.hdnZenkaiChosaItakusakiCode = hdnZenkaiChosaItakusakiCode;
    }

    /*
     * gethdnZenkaiShujiiIryokikanCode
     * @return hdnZenkaiShujiiIryokikanCode
     */
    @JsonProperty("hdnZenkaiShujiiIryokikanCode")
    public RString getHdnZenkaiShujiiIryokikanCode() {
        return hdnZenkaiShujiiIryokikanCode;
    }

    /*
     * sethdnZenkaiShujiiIryokikanCode
     * @param hdnZenkaiShujiiIryokikanCode hdnZenkaiShujiiIryokikanCode
     */
    @JsonProperty("hdnZenkaiShujiiIryokikanCode")
    public void setHdnZenkaiShujiiIryokikanCode(RString hdnZenkaiShujiiIryokikanCode) {
        this.hdnZenkaiShujiiIryokikanCode = hdnZenkaiShujiiIryokikanCode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum GyomuType implements ICommonChildDivMode {

        Nintei("Nintei"),
        Jukyu("Jukyu");

        private final String name;

        private GyomuType(final String name) {
            this.name = name;
        }

        public static GyomuType getEnum(String str) {
            GyomuType[] enumArray = GyomuType.values();

            for (GyomuType enumStr : enumArray) {
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

    public GyomuType getMode_GyomuType() {
        return (GyomuType) _CommonChildDivModeUtil.getMode(this.modes, GyomuType.class);
    }

    public void setMode_GyomuType(GyomuType value) {
        _CommonChildDivModeUtil.setMode(this.modes, GyomuType.class, value);
    }

    public static enum MinashiType implements ICommonChildDivMode {

        Minashi("Minashi"),
        NotMinashi("NotMinashi");

        private final String name;

        private MinashiType(final String name) {
            this.name = name;
        }

        public static MinashiType getEnum(String str) {
            MinashiType[] enumArray = MinashiType.values();

            for (MinashiType enumStr : enumArray) {
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

    public MinashiType getMode_MinashiType() {
        return (MinashiType) _CommonChildDivModeUtil.getMode(this.modes, MinashiType.class);
    }

    public void setMode_MinashiType(MinashiType value) {
        _CommonChildDivModeUtil.setMode(this.modes, MinashiType.class, value);
    }

    public static enum DisplayType implements ICommonChildDivMode {

        StandardMode("StandardMode"),
        PhaseMode("PhaseMode"),
        NinteiChosaMode("NinteiChosaMode"),
        IkenshoMode("IkenshoMode"),
        ShinsakaiMode("ShinsakaiMode");

        private final String name;

        private DisplayType(final String name) {
            this.name = name;
        }

        public static DisplayType getEnum(String str) {
            DisplayType[] enumArray = DisplayType.values();

            for (DisplayType enumStr : enumArray) {
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

    public DisplayType getMode_DisplayType() {
        return (DisplayType) _CommonChildDivModeUtil.getMode(this.modes, DisplayType.class);
    }

    public void setMode_DisplayType(DisplayType value) {
        _CommonChildDivModeUtil.setMode(this.modes, DisplayType.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KihonJohoDiv getKihonJoho() {
        return this.getShosaiJoken().getKihonJoho();
    }

    @JsonIgnore
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.getShosaiJoken().setKihonJoho(KihonJoho);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaKubun() {
        return this.getShosaiJoken().getKihonJoho().getDdlHihokenshaKubun();
    }

    @JsonIgnore
    public void setDdlHihokenshaKubun(DropDownList ddlHihokenshaKubun) {
        this.getShosaiJoken().getKihonJoho().setDdlHihokenshaKubun(ddlHihokenshaKubun);
    }

    @JsonIgnore
    public DropDownList getDdlHoreiShinseiji() {
        return this.getShosaiJoken().getKihonJoho().getDdlHoreiShinseiji();
    }

    @JsonIgnore
    public void setDdlHoreiShinseiji(DropDownList ddlHoreiShinseiji) {
        this.getShosaiJoken().getKihonJoho().setDdlHoreiShinseiji(ddlHoreiShinseiji);
    }

    @JsonIgnore
    public DropDownList getDdlShoriKubun() {
        return this.getShosaiJoken().getKihonJoho().getDdlShoriKubun();
    }

    @JsonIgnore
    public void setDdlShoriKubun(DropDownList ddlShoriKubun) {
        this.getShosaiJoken().getKihonJoho().setDdlShoriKubun(ddlShoriKubun);
    }

    @JsonIgnore
    public DropDownList getDdlKoroshoShikibetsuCode() {
        return this.getShosaiJoken().getKihonJoho().getDdlKoroshoShikibetsuCode();
    }

    @JsonIgnore
    public void setDdlKoroshoShikibetsuCode(DropDownList ddlKoroshoShikibetsuCode) {
        this.getShosaiJoken().getKihonJoho().setDdlKoroshoShikibetsuCode(ddlKoroshoShikibetsuCode);
    }

    @JsonIgnore
    public Label getLblYubinNo() {
        return this.getShosaiJoken().getKihonJoho().getLblYubinNo();
    }

    @JsonIgnore
    public void setLblYubinNo(Label lblYubinNo) {
        this.getShosaiJoken().getKihonJoho().setLblYubinNo(lblYubinNo);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getShosaiJoken().getKihonJoho().getTxtYubinNo();
    }

    @JsonIgnore
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getShosaiJoken().getKihonJoho().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public DropDownList getDdlChiku() {
        return this.getShosaiJoken().getKihonJoho().getDdlChiku();
    }

    @JsonIgnore
    public void setDdlChiku(DropDownList ddlChiku) {
        this.getShosaiJoken().getKihonJoho().setDdlChiku(ddlChiku);
    }

    @JsonIgnore
    public RadioButton getRadShisetsuNyusho() {
        return this.getShosaiJoken().getKihonJoho().getRadShisetsuNyusho();
    }

    @JsonIgnore
    public void setRadShisetsuNyusho(RadioButton radShisetsuNyusho) {
        this.getShosaiJoken().getKihonJoho().setRadShisetsuNyusho(radShisetsuNyusho);
    }

    @JsonIgnore
    public NinteiChosaDiv getNinteiChosa() {
        return this.getShosaiJoken().getNinteiChosa();
    }

    @JsonIgnore
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.getShosaiJoken().setNinteiChosa(NinteiChosa);
    }

    @JsonIgnore
    public Label getLblNinteiChosaIinItakuSaki() {
        return this.getShosaiJoken().getNinteiChosa().getLblNinteiChosaIinItakuSaki();
    }

    @JsonIgnore
    public void setLblNinteiChosaIinItakuSaki(Label lblNinteiChosaIinItakuSaki) {
        this.getShosaiJoken().getNinteiChosa().setLblNinteiChosaIinItakuSaki(lblNinteiChosaIinItakuSaki);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinteiChosaItakusakiGuide() {
        return this.getShosaiJoken().getNinteiChosa().getBtnNinteiChosaItakusakiGuide();
    }

    @JsonIgnore
    public void setBtnNinteiChosaItakusakiGuide(ButtonDialog btnNinteiChosaItakusakiGuide) {
        this.getShosaiJoken().getNinteiChosa().setBtnNinteiChosaItakusakiGuide(btnNinteiChosaItakusakiGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiName() {
        return this.getShosaiJoken().getNinteiChosa().getTxtNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.getShosaiJoken().getNinteiChosa().setTxtNinteiChosaItakusakiName(txtNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public Label getLblNinteiChosaInShimei() {
        return this.getShosaiJoken().getNinteiChosa().getLblNinteiChosaInShimei();
    }

    @JsonIgnore
    public void setLblNinteiChosaInShimei(Label lblNinteiChosaInShimei) {
        this.getShosaiJoken().getNinteiChosa().setLblNinteiChosaInShimei(lblNinteiChosaInShimei);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinteiChosainGuide() {
        return this.getShosaiJoken().getNinteiChosa().getBtnNinteiChosainGuide();
    }

    @JsonIgnore
    public void setBtnNinteiChosainGuide(ButtonDialog btnNinteiChosainGuide) {
        this.getShosaiJoken().getNinteiChosa().setBtnNinteiChosainGuide(btnNinteiChosainGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getShosaiJoken().getNinteiChosa().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getShosaiJoken().getNinteiChosa().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public DropDownList getDdlChosaJisshiBasho() {
        return this.getShosaiJoken().getNinteiChosa().getDdlChosaJisshiBasho();
    }

    @JsonIgnore
    public void setDdlChosaJisshiBasho(DropDownList ddlChosaJisshiBasho) {
        this.getShosaiJoken().getNinteiChosa().setDdlChosaJisshiBasho(ddlChosaJisshiBasho);
    }

    @JsonIgnore
    public DropDownList getDdlChosaKubun() {
        return this.getShosaiJoken().getNinteiChosa().getDdlChosaKubun();
    }

    @JsonIgnore
    public void setDdlChosaKubun(DropDownList ddlChosaKubun) {
        this.getShosaiJoken().getNinteiChosa().setDdlChosaKubun(ddlChosaKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtChosaJisshiDateFrom() {
        return this.getShosaiJoken().getNinteiChosa().getTxtChosaJisshiDateFrom();
    }

    @JsonIgnore
    public void setTxtChosaJisshiDateFrom(TextBoxFlexibleDate txtChosaJisshiDateFrom) {
        this.getShosaiJoken().getNinteiChosa().setTxtChosaJisshiDateFrom(txtChosaJisshiDateFrom);
    }

    @JsonIgnore
    public Label getLblChosaJisshiDate() {
        return this.getShosaiJoken().getNinteiChosa().getLblChosaJisshiDate();
    }

    @JsonIgnore
    public void setLblChosaJisshiDate(Label lblChosaJisshiDate) {
        this.getShosaiJoken().getNinteiChosa().setLblChosaJisshiDate(lblChosaJisshiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtChosaJisshiDateTo() {
        return this.getShosaiJoken().getNinteiChosa().getTxtChosaJisshiDateTo();
    }

    @JsonIgnore
    public void setTxtChosaJisshiDateTo(TextBoxFlexibleDate txtChosaJisshiDateTo) {
        this.getShosaiJoken().getNinteiChosa().setTxtChosaJisshiDateTo(txtChosaJisshiDateTo);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaNetakirido() {
        return this.getShosaiJoken().getNinteiChosa().getDdlNinteiChosaNetakirido();
    }

    @JsonIgnore
    public void setDdlNinteiChosaNetakirido(DropDownList ddlNinteiChosaNetakirido) {
        this.getShosaiJoken().getNinteiChosa().setDdlNinteiChosaNetakirido(ddlNinteiChosaNetakirido);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaNinchido() {
        return this.getShosaiJoken().getNinteiChosa().getDdlNinteiChosaNinchido();
    }

    @JsonIgnore
    public void setDdlNinteiChosaNinchido(DropDownList ddlNinteiChosaNinchido) {
        this.getShosaiJoken().getNinteiChosa().setDdlNinteiChosaNinchido(ddlNinteiChosaNinchido);
    }

    @JsonIgnore
    public ShujiiJohoDiv getShujiiJoho() {
        return this.getShosaiJoken().getShujiiJoho();
    }

    @JsonIgnore
    public void setShujiiJoho(ShujiiJohoDiv ShujiiJoho) {
        this.getShosaiJoken().setShujiiJoho(ShujiiJoho);
    }

    @JsonIgnore
    public Label getLblShujiiIryokikan() {
        return this.getShosaiJoken().getShujiiJoho().getLblShujiiIryokikan();
    }

    @JsonIgnore
    public void setLblShujiiIryokikan(Label lblShujiiIryokikan) {
        this.getShosaiJoken().getShujiiJoho().setLblShujiiIryokikan(lblShujiiIryokikan);
    }

    @JsonIgnore
    public ButtonDialog getBtnShujiiIryokikanGuide() {
        return this.getShosaiJoken().getShujiiJoho().getBtnShujiiIryokikanGuide();
    }

    @JsonIgnore
    public void setBtnShujiiIryokikanGuide(ButtonDialog btnShujiiIryokikanGuide) {
        this.getShosaiJoken().getShujiiJoho().setBtnShujiiIryokikanGuide(btnShujiiIryokikanGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiIryokikanName() {
        return this.getShosaiJoken().getShujiiJoho().getTxtShujiiIryokikanName();
    }

    @JsonIgnore
    public void setTxtShujiiIryokikanName(TextBox txtShujiiIryokikanName) {
        this.getShosaiJoken().getShujiiJoho().setTxtShujiiIryokikanName(txtShujiiIryokikanName);
    }

    @JsonIgnore
    public Label getLblShujiiName() {
        return this.getShosaiJoken().getShujiiJoho().getLblShujiiName();
    }

    @JsonIgnore
    public void setLblShujiiName(Label lblShujiiName) {
        this.getShosaiJoken().getShujiiJoho().setLblShujiiName(lblShujiiName);
    }

    @JsonIgnore
    public ButtonDialog getBtnShujiiGuide() {
        return this.getShosaiJoken().getShujiiJoho().getBtnShujiiGuide();
    }

    @JsonIgnore
    public void setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.getShosaiJoken().getShujiiJoho().setBtnShujiiGuide(btnShujiiGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getShosaiJoken().getShujiiJoho().getTxtShujiiName();
    }

    @JsonIgnore
    public void setTxtShujiiName(TextBox txtShujiiName) {
        this.getShosaiJoken().getShujiiJoho().setTxtShujiiName(txtShujiiName);
    }

    @JsonIgnore
    public DropDownList getDdlShujiIkubun() {
        return this.getShosaiJoken().getShujiiJoho().getDdlShujiIkubun();
    }

    @JsonIgnore
    public void setDdlShujiIkubun(DropDownList ddlShujiIkubun) {
        this.getShosaiJoken().getShujiiJoho().setDdlShujiIkubun(ddlShujiIkubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIkenshoKinyuDateFrom() {
        return this.getShosaiJoken().getShujiiJoho().getTxtIkenshoKinyuDateFrom();
    }

    @JsonIgnore
    public void setTxtIkenshoKinyuDateFrom(TextBoxFlexibleDate txtIkenshoKinyuDateFrom) {
        this.getShosaiJoken().getShujiiJoho().setTxtIkenshoKinyuDateFrom(txtIkenshoKinyuDateFrom);
    }

    @JsonIgnore
    public Label getLblIkenshoKinyuDateFrom() {
        return this.getShosaiJoken().getShujiiJoho().getLblIkenshoKinyuDateFrom();
    }

    @JsonIgnore
    public void setLblIkenshoKinyuDateFrom(Label lblIkenshoKinyuDateFrom) {
        this.getShosaiJoken().getShujiiJoho().setLblIkenshoKinyuDateFrom(lblIkenshoKinyuDateFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIkenshoKinyuDateTo() {
        return this.getShosaiJoken().getShujiiJoho().getTxtIkenshoKinyuDateTo();
    }

    @JsonIgnore
    public void setTxtIkenshoKinyuDateTo(TextBoxFlexibleDate txtIkenshoKinyuDateTo) {
        this.getShosaiJoken().getShujiiJoho().setTxtIkenshoKinyuDateTo(txtIkenshoKinyuDateTo);
    }

    @JsonIgnore
    public DropDownList getDdlShujiJohoNetakirido() {
        return this.getShosaiJoken().getShujiiJoho().getDdlShujiJohoNetakirido();
    }

    @JsonIgnore
    public void setDdlShujiJohoNetakirido(DropDownList ddlShujiJohoNetakirido) {
        this.getShosaiJoken().getShujiiJoho().setDdlShujiJohoNetakirido(ddlShujiJohoNetakirido);
    }

    @JsonIgnore
    public DropDownList getDdlShujiJohoNinchido() {
        return this.getShosaiJoken().getShujiiJoho().getDdlShujiJohoNinchido();
    }

    @JsonIgnore
    public void setDdlShujiJohoNinchido(DropDownList ddlShujiJohoNinchido) {
        this.getShosaiJoken().getShujiiJoho().setDdlShujiJohoNinchido(ddlShujiJohoNinchido);
    }

    @JsonIgnore
    public IchijiHanteiDiv getIchijiHantei() {
        return this.getShosaiJoken().getIchijiHantei();
    }

    @JsonIgnore
    public void setIchijiHantei(IchijiHanteiDiv IchijiHantei) {
        this.getShosaiJoken().setIchijiHantei(IchijiHantei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIchijiHanteiDateFrom() {
        return this.getShosaiJoken().getIchijiHantei().getTxtIchijiHanteiDateFrom();
    }

    @JsonIgnore
    public void setTxtIchijiHanteiDateFrom(TextBoxFlexibleDate txtIchijiHanteiDateFrom) {
        this.getShosaiJoken().getIchijiHantei().setTxtIchijiHanteiDateFrom(txtIchijiHanteiDateFrom);
    }

    @JsonIgnore
    public Label getLblIchijiHanteiDate() {
        return this.getShosaiJoken().getIchijiHantei().getLblIchijiHanteiDate();
    }

    @JsonIgnore
    public void setLblIchijiHanteiDate(Label lblIchijiHanteiDate) {
        this.getShosaiJoken().getIchijiHantei().setLblIchijiHanteiDate(lblIchijiHanteiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIchijiHanteiDateTo() {
        return this.getShosaiJoken().getIchijiHantei().getTxtIchijiHanteiDateTo();
    }

    @JsonIgnore
    public void setTxtIchijiHanteiDateTo(TextBoxFlexibleDate txtIchijiHanteiDateTo) {
        this.getShosaiJoken().getIchijiHantei().setTxtIchijiHanteiDateTo(txtIchijiHanteiDateTo);
    }

    @JsonIgnore
    public DropDownList getDdlIchijiHanteiKekka() {
        return this.getShosaiJoken().getIchijiHantei().getDdlIchijiHanteiKekka();
    }

    @JsonIgnore
    public void setDdlIchijiHanteiKekka(DropDownList ddlIchijiHanteiKekka) {
        this.getShosaiJoken().getIchijiHantei().setDdlIchijiHanteiKekka(ddlIchijiHanteiKekka);
    }

    @JsonIgnore
    public IchiGoHanteiDiv getIchiGoHantei() {
        return this.getShosaiJoken().getIchiGoHantei();
    }

    @JsonIgnore
    public void setIchiGoHantei(IchiGoHanteiDiv IchiGoHantei) {
        this.getShosaiJoken().setIchiGoHantei(IchiGoHantei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIchiGoHanteiDateFrom() {
        return this.getShosaiJoken().getIchiGoHantei().getTxtIchiGoHanteiDateFrom();
    }

    @JsonIgnore
    public void setTxtIchiGoHanteiDateFrom(TextBoxFlexibleDate txtIchiGoHanteiDateFrom) {
        this.getShosaiJoken().getIchiGoHantei().setTxtIchiGoHanteiDateFrom(txtIchiGoHanteiDateFrom);
    }

    @JsonIgnore
    public Label getLblIchiGoHanteiDate() {
        return this.getShosaiJoken().getIchiGoHantei().getLblIchiGoHanteiDate();
    }

    @JsonIgnore
    public void setLblIchiGoHanteiDate(Label lblIchiGoHanteiDate) {
        this.getShosaiJoken().getIchiGoHantei().setLblIchiGoHanteiDate(lblIchiGoHanteiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIchiGoHanteiDateTo() {
        return this.getShosaiJoken().getIchiGoHantei().getTxtIchiGoHanteiDateTo();
    }

    @JsonIgnore
    public void setTxtIchiGoHanteiDateTo(TextBoxFlexibleDate txtIchiGoHanteiDateTo) {
        this.getShosaiJoken().getIchiGoHantei().setTxtIchiGoHanteiDateTo(txtIchiGoHanteiDateTo);
    }

    @JsonIgnore
    public DropDownList getDdlIchiGohanteiKekka() {
        return this.getShosaiJoken().getIchiGoHantei().getDdlIchiGohanteiKekka();
    }

    @JsonIgnore
    public void setDdlIchiGohanteiKekka(DropDownList ddlIchiGohanteiKekka) {
        this.getShosaiJoken().getIchiGoHantei().setDdlIchiGohanteiKekka(ddlIchiGohanteiKekka);
    }

    @JsonIgnore
    public KaigoNinteiShinsakaiJohoDiv getKaigoNinteiShinsakaiJoho() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho();
    }

    @JsonIgnore
    public void setKaigoNinteiShinsakaiJoho(KaigoNinteiShinsakaiJohoDiv KaigoNinteiShinsakaiJoho) {
        this.getShosaiJoken().setKaigoNinteiShinsakaiJoho(KaigoNinteiShinsakaiJoho);
    }

    @JsonIgnore
    public DropDownList getDdlNijiHanteiKekka() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getDdlNijiHanteiKekka();
    }

    @JsonIgnore
    public void setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setDdlNijiHanteiKekka(ddlNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBox getTxtNinteiYukoKikan() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoKikan();
    }

    @JsonIgnore
    public void setTxtNinteiYukoKikan(TextBox txtNinteiYukoKikan) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoKikan(txtNinteiYukoKikan);
    }

    @JsonIgnore
    public TextBox getTxtCheckDay() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtCheckDay();
    }

    @JsonIgnore
    public void setTxtCheckDay(TextBox txtCheckDay) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtCheckDay(txtCheckDay);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoKaishiDateFrom() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoKaishiDateFrom();
    }

    @JsonIgnore
    public void setTxtNinteiYukoKaishiDateFrom(TextBoxFlexibleDate txtNinteiYukoKaishiDateFrom) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoKaishiDateFrom(txtNinteiYukoKaishiDateFrom);
    }

    @JsonIgnore
    public Label getLblNinteiYukoKaishiDate() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getLblNinteiYukoKaishiDate();
    }

    @JsonIgnore
    public void setLblNinteiYukoKaishiDate(Label lblNinteiYukoKaishiDate) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setLblNinteiYukoKaishiDate(lblNinteiYukoKaishiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoKaishiDateTo() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoKaishiDateTo();
    }

    @JsonIgnore
    public void setTxtNinteiYukoKaishiDateTo(TextBoxFlexibleDate txtNinteiYukoKaishiDateTo) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoKaishiDateTo(txtNinteiYukoKaishiDateTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryoDateFrom() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoShuryoDateFrom();
    }

    @JsonIgnore
    public void setTxtNinteiYukoShuryoDateFrom(TextBoxFlexibleDate txtNinteiYukoShuryoDateFrom) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoShuryoDateFrom(txtNinteiYukoShuryoDateFrom);
    }

    @JsonIgnore
    public Label getLblNinteiYukoShuryoDate() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getLblNinteiYukoShuryoDate();
    }

    @JsonIgnore
    public void setLblNinteiYukoShuryoDate(Label lblNinteiYukoShuryoDate) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setLblNinteiYukoShuryoDate(lblNinteiYukoShuryoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryoDate() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoShuryoDate();
    }

    @JsonIgnore
    public void setTxtNinteiYukoShuryoDate(TextBoxFlexibleDate txtNinteiYukoShuryoDate) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoShuryoDate(txtNinteiYukoShuryoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNijiHanteiDateFrom() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNijiHanteiDateFrom();
    }

    @JsonIgnore
    public void setTxtNijiHanteiDateFrom(TextBoxFlexibleDate txtNijiHanteiDateFrom) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNijiHanteiDateFrom(txtNijiHanteiDateFrom);
    }

    @JsonIgnore
    public Label getLblNijiHanteiDate() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getLblNijiHanteiDate();
    }

    @JsonIgnore
    public void setLblNijiHanteiDate(Label lblNijiHanteiDate) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setLblNijiHanteiDate(lblNijiHanteiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNijiHnateiDateTo() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNijiHnateiDateTo();
    }

    @JsonIgnore
    public void setTxtNijiHnateiDateTo(TextBoxFlexibleDate txtNijiHnateiDateTo) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNijiHnateiDateTo(txtNijiHnateiDateTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDateFrom() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtKaisaiDateFrom();
    }

    @JsonIgnore
    public void setTxtKaisaiDateFrom(TextBoxFlexibleDate txtKaisaiDateFrom) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtKaisaiDateFrom(txtKaisaiDateFrom);
    }

    @JsonIgnore
    public Label getLblKaisaiDate() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getLblKaisaiDate();
    }

    @JsonIgnore
    public void setLblKaisaiDate(Label lblKaisaiDate) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setLblKaisaiDate(lblKaisaiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDateTo() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtKaisaiDateTo();
    }

    @JsonIgnore
    public void setTxtKaisaiDateTo(TextBoxFlexibleDate txtKaisaiDateTo) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtKaisaiDateTo(txtKaisaiDateTo);
    }

    @JsonIgnore
    public Label getLblKaisaiNumber() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getLblKaisaiNumber();
    }

    @JsonIgnore
    public void setLblKaisaiNumber(Label lblKaisaiNumber) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setLblKaisaiNumber(lblKaisaiNumber);
    }

    @JsonIgnore
    public TextBox getTxtKaisaiNumberStart() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtKaisaiNumberStart();
    }

    @JsonIgnore
    public void setTxtKaisaiNumberStart(TextBox txtKaisaiNumberStart) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtKaisaiNumberStart(txtKaisaiNumberStart);
    }

    @JsonIgnore
    public Label getLblKaisaiNoFor() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getLblKaisaiNoFor();
    }

    @JsonIgnore
    public void setLblKaisaiNoFor(Label lblKaisaiNoFor) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setLblKaisaiNoFor(lblKaisaiNoFor);
    }

    @JsonIgnore
    public TextBox getTxtKaisaiNumberEnd() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtKaisaiNumberEnd();
    }

    @JsonIgnore
    public void setTxtKaisaiNumberEnd(TextBox txtKaisaiNumberEnd) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtKaisaiNumberEnd(txtKaisaiNumberEnd);
    }

    @JsonIgnore
    public ZenkaiJohoDiv getZenkaiJoho() {
        return this.getShosaiJoken().getZenkaiJoho();
    }

    @JsonIgnore
    public void setZenkaiJoho(ZenkaiJohoDiv ZenkaiJoho) {
        this.getShosaiJoken().setZenkaiJoho(ZenkaiJoho);
    }

    @JsonIgnore
    public Label getLblZenkaiChosaItakusaki() {
        return this.getShosaiJoken().getZenkaiJoho().getLblZenkaiChosaItakusaki();
    }

    @JsonIgnore
    public void setLblZenkaiChosaItakusaki(Label lblZenkaiChosaItakusaki) {
        this.getShosaiJoken().getZenkaiJoho().setLblZenkaiChosaItakusaki(lblZenkaiChosaItakusaki);
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiChosaItakusakiGuide() {
        return this.getShosaiJoken().getZenkaiJoho().getBtnZenkaiChosaItakusakiGuide();
    }

    @JsonIgnore
    public void setBtnZenkaiChosaItakusakiGuide(ButtonDialog btnZenkaiChosaItakusakiGuide) {
        this.getShosaiJoken().getZenkaiJoho().setBtnZenkaiChosaItakusakiGuide(btnZenkaiChosaItakusakiGuide);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiNinteiChosaItakusakiName() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void setTxtZenkaiNinteiChosaItakusakiName(TextBox txtZenkaiNinteiChosaItakusakiName) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiNinteiChosaItakusakiName(txtZenkaiNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public Label getLblZenkaiShujiiIryokikan() {
        return this.getShosaiJoken().getZenkaiJoho().getLblZenkaiShujiiIryokikan();
    }

    @JsonIgnore
    public void setLblZenkaiShujiiIryokikan(Label lblZenkaiShujiiIryokikan) {
        this.getShosaiJoken().getZenkaiJoho().setLblZenkaiShujiiIryokikan(lblZenkaiShujiiIryokikan);
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiShujiiIryokikanGuide() {
        return this.getShosaiJoken().getZenkaiJoho().getBtnZenkaiShujiiIryokikanGuide();
    }

    @JsonIgnore
    public void setBtnZenkaiShujiiIryokikanGuide(ButtonDialog btnZenkaiShujiiIryokikanGuide) {
        this.getShosaiJoken().getZenkaiJoho().setBtnZenkaiShujiiIryokikanGuide(btnZenkaiShujiiIryokikanGuide);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiShujiiIryokikanName() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiShujiiIryokikanName();
    }

    @JsonIgnore
    public void setTxtZenkaiShujiiIryokikanName(TextBox txtZenkaiShujiiIryokikanName) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiShujiiIryokikanName(txtZenkaiShujiiIryokikanName);
    }

    @JsonIgnore
    public DropDownList getDdlZenkaiNijiHanteiKekka() {
        return this.getShosaiJoken().getZenkaiJoho().getDdlZenkaiNijiHanteiKekka();
    }

    @JsonIgnore
    public void setDdlZenkaiNijiHanteiKekka(DropDownList ddlZenkaiNijiHanteiKekka) {
        this.getShosaiJoken().getZenkaiJoho().setDdlZenkaiNijiHanteiKekka(ddlZenkaiNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiNinteiYukoKikan() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiNinteiYukoKikan();
    }

    @JsonIgnore
    public void setTxtZenkaiNinteiYukoKikan(TextBox txtZenkaiNinteiYukoKikan) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiNinteiYukoKikan(txtZenkaiNinteiYukoKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiYukoKaishiDateFrom() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiYukoKaishiDateFrom();
    }

    @JsonIgnore
    public void setTxtZenkaiYukoKaishiDateFrom(TextBoxFlexibleDate txtZenkaiYukoKaishiDateFrom) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiYukoKaishiDateFrom(txtZenkaiYukoKaishiDateFrom);
    }

    @JsonIgnore
    public Label getLblZenkaiYukoKaishiDate() {
        return this.getShosaiJoken().getZenkaiJoho().getLblZenkaiYukoKaishiDate();
    }

    @JsonIgnore
    public void setLblZenkaiYukoKaishiDate(Label lblZenkaiYukoKaishiDate) {
        this.getShosaiJoken().getZenkaiJoho().setLblZenkaiYukoKaishiDate(lblZenkaiYukoKaishiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiYukoKaishiDateTo() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiYukoKaishiDateTo();
    }

    @JsonIgnore
    public void setTxtZenkaiYukoKaishiDateTo(TextBoxFlexibleDate txtZenkaiYukoKaishiDateTo) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiYukoKaishiDateTo(txtZenkaiYukoKaishiDateTo);
    }

    @JsonIgnore
    public SonotaJohoDiv getSonotaJoho() {
        return this.getShosaiJoken().getSonotaJoho();
    }

    @JsonIgnore
    public void setSonotaJoho(SonotaJohoDiv SonotaJoho) {
        this.getShosaiJoken().setSonotaJoho(SonotaJoho);
    }

    @JsonIgnore
    public TextBoxCode getTxtGeninShikkanCode() {
        return this.getShosaiJoken().getSonotaJoho().getTxtGeninShikkanCode();
    }

    @JsonIgnore
    public void setTxtGeninShikkanCode(TextBoxCode txtGeninShikkanCode) {
        this.getShosaiJoken().getSonotaJoho().setTxtGeninShikkanCode(txtGeninShikkanCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnGeninShikkanGuide() {
        return this.getShosaiJoken().getSonotaJoho().getBtnGeninShikkanGuide();
    }

    @JsonIgnore
    public void setBtnGeninShikkanGuide(ButtonDialog btnGeninShikkanGuide) {
        this.getShosaiJoken().getSonotaJoho().setBtnGeninShikkanGuide(btnGeninShikkanGuide);
    }

    @JsonIgnore
    public TextBox getTxtGeninShikkanName() {
        return this.getShosaiJoken().getSonotaJoho().getTxtGeninShikkanName();
    }

    @JsonIgnore
    public void setTxtGeninShikkanName(TextBox txtGeninShikkanName) {
        this.getShosaiJoken().getSonotaJoho().setTxtGeninShikkanName(txtGeninShikkanName);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtShinseiKeikaNissu() {
        return this.getShosaiJoken().getSonotaJoho().getTxtShinseiKeikaNissu();
    }

    @JsonIgnore
    public void setTxtShinseiKeikaNissu(TextBoxNumRange txtShinseiKeikaNissu) {
        this.getShosaiJoken().getSonotaJoho().setTxtShinseiKeikaNissu(txtShinseiKeikaNissu);
    }

    @JsonIgnore
    public KanryoJohoDiv getKanryoJoho() {
        return this.getShosaiJoken().getKanryoJoho();
    }

    @JsonIgnore
    public void setKanryoJoho(KanryoJohoDiv KanryoJoho) {
        this.getShosaiJoken().setKanryoJoho(KanryoJoho);
    }

    @JsonIgnore
    public DropDownList getDdlNowPhase() {
        return this.getShosaiJoken().getKanryoJoho().getDdlNowPhase();
    }

    @JsonIgnore
    public void setDdlNowPhase(DropDownList ddlNowPhase) {
        this.getShosaiJoken().getKanryoJoho().setDdlNowPhase(ddlNowPhase);
    }

    @JsonIgnore
    public CheckBoxList getChkShoriJotai() {
        return this.getShosaiJoken().getKanryoJoho().getChkShoriJotai();
    }

    @JsonIgnore
    public void setChkShoriJotai(CheckBoxList chkShoriJotai) {
        this.getShosaiJoken().getKanryoJoho().setChkShoriJotai(chkShoriJotai);
    }

    @JsonIgnore
    public Label getLblKoshinTaishoChushutsu() {
        return this.getShosaiJoken().getKanryoJoho().getLblKoshinTaishoChushutsu();
    }

    @JsonIgnore
    public void setLblKoshinTaishoChushutsu(Label lblKoshinTaishoChushutsu) {
        this.getShosaiJoken().getKanryoJoho().setLblKoshinTaishoChushutsu(lblKoshinTaishoChushutsu);
    }

    @JsonIgnore
    public CheckBoxList getChkKoshinTaishoChushutsu() {
        return this.getShosaiJoken().getKanryoJoho().getChkKoshinTaishoChushutsu();
    }

    @JsonIgnore
    public void setChkKoshinTaishoChushutsu(CheckBoxList chkKoshinTaishoChushutsu) {
        this.getShosaiJoken().getKanryoJoho().setChkKoshinTaishoChushutsu(chkKoshinTaishoChushutsu);
    }

    @JsonIgnore
    public Label getLblIchijiHantei() {
        return this.getShosaiJoken().getKanryoJoho().getLblIchijiHantei();
    }

    @JsonIgnore
    public void setLblIchijiHantei(Label lblIchijiHantei) {
        this.getShosaiJoken().getKanryoJoho().setLblIchijiHantei(lblIchijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getChkIchijiHantei() {
        return this.getShosaiJoken().getKanryoJoho().getChkIchijiHantei();
    }

    @JsonIgnore
    public void setChkIchijiHantei(CheckBoxList chkIchijiHantei) {
        this.getShosaiJoken().getKanryoJoho().setChkIchijiHantei(chkIchijiHantei);
    }

    @JsonIgnore
    public Label getLblShinseiUketsuke() {
        return this.getShosaiJoken().getKanryoJoho().getLblShinseiUketsuke();
    }

    @JsonIgnore
    public void setLblShinseiUketsuke(Label lblShinseiUketsuke) {
        this.getShosaiJoken().getKanryoJoho().setLblShinseiUketsuke(lblShinseiUketsuke);
    }

    @JsonIgnore
    public CheckBoxList getChkShinseiUketsuke() {
        return this.getShosaiJoken().getKanryoJoho().getChkShinseiUketsuke();
    }

    @JsonIgnore
    public void setChkShinseiUketsuke(CheckBoxList chkShinseiUketsuke) {
        this.getShosaiJoken().getKanryoJoho().setChkShinseiUketsuke(chkShinseiUketsuke);
    }

    @JsonIgnore
    public Label getLblMasking() {
        return this.getShosaiJoken().getKanryoJoho().getLblMasking();
    }

    @JsonIgnore
    public void setLblMasking(Label lblMasking) {
        this.getShosaiJoken().getKanryoJoho().setLblMasking(lblMasking);
    }

    @JsonIgnore
    public CheckBoxList getChkMasking() {
        return this.getShosaiJoken().getKanryoJoho().getChkMasking();
    }

    @JsonIgnore
    public void setChkMasking(CheckBoxList chkMasking) {
        this.getShosaiJoken().getKanryoJoho().setChkMasking(chkMasking);
    }

    @JsonIgnore
    public Label getLblChosaIrai() {
        return this.getShosaiJoken().getKanryoJoho().getLblChosaIrai();
    }

    @JsonIgnore
    public void setLblChosaIrai(Label lblChosaIrai) {
        this.getShosaiJoken().getKanryoJoho().setLblChosaIrai(lblChosaIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaIrai() {
        return this.getShosaiJoken().getKanryoJoho().getChkChosaIrai();
    }

    @JsonIgnore
    public void setChkChosaIrai(CheckBoxList chkChosaIrai) {
        this.getShosaiJoken().getKanryoJoho().setChkChosaIrai(chkChosaIrai);
    }

    @JsonIgnore
    public Label getLblShinsakaiToroku() {
        return this.getShosaiJoken().getKanryoJoho().getLblShinsakaiToroku();
    }

    @JsonIgnore
    public void setLblShinsakaiToroku(Label lblShinsakaiToroku) {
        this.getShosaiJoken().getKanryoJoho().setLblShinsakaiToroku(lblShinsakaiToroku);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiToroku() {
        return this.getShosaiJoken().getKanryoJoho().getChkShinsakaiToroku();
    }

    @JsonIgnore
    public void setChkShinsakaiToroku(CheckBoxList chkShinsakaiToroku) {
        this.getShosaiJoken().getKanryoJoho().setChkShinsakaiToroku(chkShinsakaiToroku);
    }

    @JsonIgnore
    public Label getLblIkenshoIrai() {
        return this.getShosaiJoken().getKanryoJoho().getLblIkenshoIrai();
    }

    @JsonIgnore
    public void setLblIkenshoIrai(Label lblIkenshoIrai) {
        this.getShosaiJoken().getKanryoJoho().setLblIkenshoIrai(lblIkenshoIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoIrai() {
        return this.getShosaiJoken().getKanryoJoho().getChkIkenshoIrai();
    }

    @JsonIgnore
    public void setChkIkenshoIrai(CheckBoxList chkIkenshoIrai) {
        this.getShosaiJoken().getKanryoJoho().setChkIkenshoIrai(chkIkenshoIrai);
    }

    @JsonIgnore
    public Label getLblNijiHantei() {
        return this.getShosaiJoken().getKanryoJoho().getLblNijiHantei();
    }

    @JsonIgnore
    public void setLblNijiHantei(Label lblNijiHantei) {
        this.getShosaiJoken().getKanryoJoho().setLblNijiHantei(lblNijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getChkNijiHantei() {
        return this.getShosaiJoken().getKanryoJoho().getChkNijiHantei();
    }

    @JsonIgnore
    public void setChkNijiHantei(CheckBoxList chkNijiHantei) {
        this.getShosaiJoken().getKanryoJoho().setChkNijiHantei(chkNijiHantei);
    }

    @JsonIgnore
    public Label getLblChosaNyushu() {
        return this.getShosaiJoken().getKanryoJoho().getLblChosaNyushu();
    }

    @JsonIgnore
    public void setLblChosaNyushu(Label lblChosaNyushu) {
        this.getShosaiJoken().getKanryoJoho().setLblChosaNyushu(lblChosaNyushu);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaNyushu() {
        return this.getShosaiJoken().getKanryoJoho().getChkChosaNyushu();
    }

    @JsonIgnore
    public void setChkChosaNyushu(CheckBoxList chkChosaNyushu) {
        this.getShosaiJoken().getKanryoJoho().setChkChosaNyushu(chkChosaNyushu);
    }

    @JsonIgnore
    public Label getLblTsuchiShori() {
        return this.getShosaiJoken().getKanryoJoho().getLblTsuchiShori();
    }

    @JsonIgnore
    public void setLblTsuchiShori(Label lblTsuchiShori) {
        this.getShosaiJoken().getKanryoJoho().setLblTsuchiShori(lblTsuchiShori);
    }

    @JsonIgnore
    public CheckBoxList getChkTsuchiShori() {
        return this.getShosaiJoken().getKanryoJoho().getChkTsuchiShori();
    }

    @JsonIgnore
    public void setChkTsuchiShori(CheckBoxList chkTsuchiShori) {
        this.getShosaiJoken().getKanryoJoho().setChkTsuchiShori(chkTsuchiShori);
    }

    @JsonIgnore
    public Label getLblIkenshoNyushu() {
        return this.getShosaiJoken().getKanryoJoho().getLblIkenshoNyushu();
    }

    @JsonIgnore
    public void setLblIkenshoNyushu(Label lblIkenshoNyushu) {
        this.getShosaiJoken().getKanryoJoho().setLblIkenshoNyushu(lblIkenshoNyushu);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoNyushu() {
        return this.getShosaiJoken().getKanryoJoho().getChkIkenshoNyushu();
    }

    @JsonIgnore
    public void setChkIkenshoNyushu(CheckBoxList chkIkenshoNyushu) {
        this.getShosaiJoken().getKanryoJoho().setChkIkenshoNyushu(chkIkenshoNyushu);
    }

    @JsonIgnore
    public Label getLblGetsureiShori() {
        return this.getShosaiJoken().getKanryoJoho().getLblGetsureiShori();
    }

    @JsonIgnore
    public void setLblGetsureiShori(Label lblGetsureiShori) {
        this.getShosaiJoken().getKanryoJoho().setLblGetsureiShori(lblGetsureiShori);
    }

    @JsonIgnore
    public CheckBoxList getChkGetsureiShori() {
        return this.getShosaiJoken().getKanryoJoho().getChkGetsureiShori();
    }

    @JsonIgnore
    public void setChkGetsureiShori(CheckBoxList chkGetsureiShori) {
        this.getShosaiJoken().getKanryoJoho().setChkGetsureiShori(chkGetsureiShori);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 初期化処理です。
     */
    @Override
    public void initialize() {
        getHandler(this).initialize();
    }

    /**
     * 検索条件DIVを取得します。
     *
     * @return NinteiShinseishaFinderDiv
     */
    @Override
    public NinteiShinseishaFinderDiv getNinteiShinseishaFinderDiv() {
        return this;
    }

    /**
     * バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    @Override
    public ValidationMessageControlPairs validate() {
        return getValidationHandler(this).validate();
    }

    private NinteiShinseishaFinderHandler getHandler(NinteiShinseishaFinderDiv div) {
        return new NinteiShinseishaFinderHandler(div);
    }

    private NinteiShinseishaFinderValidationHandler getValidationHandler(NinteiShinseishaFinderDiv div) {
        return new NinteiShinseishaFinderValidationHandler(div);
    }
}
