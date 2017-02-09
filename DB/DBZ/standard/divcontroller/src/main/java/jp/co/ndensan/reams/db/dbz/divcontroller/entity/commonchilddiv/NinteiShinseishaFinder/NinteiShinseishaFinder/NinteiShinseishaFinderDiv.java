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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.saikinshorisha.SaikinShorisha.ISaikinShorishaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.saikinshorisha.SaikinShorisha.SaikinShorishaDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseishafinder.NinteiShinseishaFinderParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNumRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * NinteiShinseishaFinder のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class NinteiShinseishaFinderDiv extends Panel implements INinteiShinseishaFinderDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
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
    @JsonProperty("txtNinteiShinseiDateRange")
    private TextBoxDateRange txtNinteiShinseiDateRange;
    @JsonProperty("ddlShinseijiShinseiKubun")
    private DropDownList ddlShinseijiShinseiKubun;
    @JsonProperty("chkTennyu")
    private CheckBoxList chkTennyu;
    @JsonProperty("txtBirthDateRange")
    private TextBoxDateRange txtBirthDateRange;
    @JsonProperty("chkSeibetsu")
    private CheckBoxList chkSeibetsu;
    @JsonProperty("ccdSaikinShorisha")
    private SaikinShorishaDiv ccdSaikinShorisha;
    @JsonProperty("KanryoJoho")
    private KanryoJohoDiv KanryoJoho;
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
    @JsonProperty("hdnChosaShichosonCode")
    private RString hdnChosaShichosonCode;
    @JsonProperty("hdnShujiiShichosonCode")
    private RString hdnShujiiShichosonCode;

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
     * gettxtNinteiShinseiDateRange
     * @return txtNinteiShinseiDateRange
     */
    @JsonProperty("txtNinteiShinseiDateRange")
    public TextBoxDateRange getTxtNinteiShinseiDateRange() {
        return txtNinteiShinseiDateRange;
    }

    /*
     * settxtNinteiShinseiDateRange
     * @param txtNinteiShinseiDateRange txtNinteiShinseiDateRange
     */
    @JsonProperty("txtNinteiShinseiDateRange")
    public void setTxtNinteiShinseiDateRange(TextBoxDateRange txtNinteiShinseiDateRange) {
        this.txtNinteiShinseiDateRange = txtNinteiShinseiDateRange;
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
     * getchkTennyu
     * @return chkTennyu
     */
    @JsonProperty("chkTennyu")
    public CheckBoxList getChkTennyu() {
        return chkTennyu;
    }

    /*
     * setchkTennyu
     * @param chkTennyu chkTennyu
     */
    @JsonProperty("chkTennyu")
    public void setChkTennyu(CheckBoxList chkTennyu) {
        this.chkTennyu = chkTennyu;
    }

    /*
     * gettxtBirthDateRange
     * @return txtBirthDateRange
     */
    @JsonProperty("txtBirthDateRange")
    public TextBoxDateRange getTxtBirthDateRange() {
        return txtBirthDateRange;
    }

    /*
     * settxtBirthDateRange
     * @param txtBirthDateRange txtBirthDateRange
     */
    @JsonProperty("txtBirthDateRange")
    public void setTxtBirthDateRange(TextBoxDateRange txtBirthDateRange) {
        this.txtBirthDateRange = txtBirthDateRange;
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
     * getccdSaikinShorisha
     * @return ccdSaikinShorisha
     */
    @JsonProperty("ccdSaikinShorisha")
    public ISaikinShorishaDiv getCcdSaikinShorisha() {
        return ccdSaikinShorisha;
    }

    /*
     * getKanryoJoho
     * @return KanryoJoho
     */
    @JsonProperty("KanryoJoho")
    public KanryoJohoDiv getKanryoJoho() {
        return KanryoJoho;
    }

    /*
     * setKanryoJoho
     * @param KanryoJoho KanryoJoho
     */
    @JsonProperty("KanryoJoho")
    public void setKanryoJoho(KanryoJohoDiv KanryoJoho) {
        this.KanryoJoho = KanryoJoho;
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
     * gethdnChosaShichosonCode
     * @return hdnChosaShichosonCode
     */
    @JsonProperty("hdnChosaShichosonCode")
    public RString getHdnChosaShichosonCode() {
        return hdnChosaShichosonCode;
    }

    /*
     * sethdnChosaShichosonCode
     * @param hdnChosaShichosonCode hdnChosaShichosonCode
     */
    @JsonProperty("hdnChosaShichosonCode")
    public void setHdnChosaShichosonCode(RString hdnChosaShichosonCode) {
        this.hdnChosaShichosonCode = hdnChosaShichosonCode;
    }

    /*
     * gethdnShujiiShichosonCode
     * @return hdnShujiiShichosonCode
     */
    @JsonProperty("hdnShujiiShichosonCode")
    public RString getHdnShujiiShichosonCode() {
        return hdnShujiiShichosonCode;
    }

    /*
     * sethdnShujiiShichosonCode
     * @param hdnShujiiShichosonCode hdnShujiiShichosonCode
     */
    @JsonProperty("hdnShujiiShichosonCode")
    public void setHdnShujiiShichosonCode(RString hdnShujiiShichosonCode) {
        this.hdnShujiiShichosonCode = hdnShujiiShichosonCode;
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
        return (GyomuType) _CommonChildDivModeUtil.getMode( this.modes, GyomuType.class );
    }

    public void setMode_GyomuType( GyomuType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, GyomuType.class , value );
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
        return (MinashiType) _CommonChildDivModeUtil.getMode( this.modes, MinashiType.class );
    }

    public void setMode_MinashiType( MinashiType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, MinashiType.class , value );
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
        return (DisplayType) _CommonChildDivModeUtil.getMode( this.modes, DisplayType.class );
    }

    public void setMode_DisplayType( DisplayType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayType.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlNowPhase() {
        return this.getKanryoJoho().getDdlNowPhase();
    }

    @JsonIgnore
    public void  setDdlNowPhase(DropDownList ddlNowPhase) {
        this.getKanryoJoho().setDdlNowPhase(ddlNowPhase);
    }

    @JsonIgnore
    public Label getLblKoshinTaishoChushutsu() {
        return this.getKanryoJoho().getLblKoshinTaishoChushutsu();
    }

    @JsonIgnore
    public void  setLblKoshinTaishoChushutsu(Label lblKoshinTaishoChushutsu) {
        this.getKanryoJoho().setLblKoshinTaishoChushutsu(lblKoshinTaishoChushutsu);
    }

    @JsonIgnore
    public CheckBoxList getChkKoshinTaishoChushutsu() {
        return this.getKanryoJoho().getChkKoshinTaishoChushutsu();
    }

    @JsonIgnore
    public void  setChkKoshinTaishoChushutsu(CheckBoxList chkKoshinTaishoChushutsu) {
        this.getKanryoJoho().setChkKoshinTaishoChushutsu(chkKoshinTaishoChushutsu);
    }

    @JsonIgnore
    public Label getLblIchijiHantei() {
        return this.getKanryoJoho().getLblIchijiHantei();
    }

    @JsonIgnore
    public void  setLblIchijiHantei(Label lblIchijiHantei) {
        this.getKanryoJoho().setLblIchijiHantei(lblIchijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getChkIchijiHantei() {
        return this.getKanryoJoho().getChkIchijiHantei();
    }

    @JsonIgnore
    public void  setChkIchijiHantei(CheckBoxList chkIchijiHantei) {
        this.getKanryoJoho().setChkIchijiHantei(chkIchijiHantei);
    }

    @JsonIgnore
    public Label getLblShinseiUketsuke() {
        return this.getKanryoJoho().getLblShinseiUketsuke();
    }

    @JsonIgnore
    public void  setLblShinseiUketsuke(Label lblShinseiUketsuke) {
        this.getKanryoJoho().setLblShinseiUketsuke(lblShinseiUketsuke);
    }

    @JsonIgnore
    public CheckBoxList getChkShinseiUketsuke() {
        return this.getKanryoJoho().getChkShinseiUketsuke();
    }

    @JsonIgnore
    public void  setChkShinseiUketsuke(CheckBoxList chkShinseiUketsuke) {
        this.getKanryoJoho().setChkShinseiUketsuke(chkShinseiUketsuke);
    }

    @JsonIgnore
    public Label getLblMasking() {
        return this.getKanryoJoho().getLblMasking();
    }

    @JsonIgnore
    public void  setLblMasking(Label lblMasking) {
        this.getKanryoJoho().setLblMasking(lblMasking);
    }

    @JsonIgnore
    public CheckBoxList getChkMasking() {
        return this.getKanryoJoho().getChkMasking();
    }

    @JsonIgnore
    public void  setChkMasking(CheckBoxList chkMasking) {
        this.getKanryoJoho().setChkMasking(chkMasking);
    }

    @JsonIgnore
    public Label getLblChosaIrai() {
        return this.getKanryoJoho().getLblChosaIrai();
    }

    @JsonIgnore
    public void  setLblChosaIrai(Label lblChosaIrai) {
        this.getKanryoJoho().setLblChosaIrai(lblChosaIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaIrai() {
        return this.getKanryoJoho().getChkChosaIrai();
    }

    @JsonIgnore
    public void  setChkChosaIrai(CheckBoxList chkChosaIrai) {
        this.getKanryoJoho().setChkChosaIrai(chkChosaIrai);
    }

    @JsonIgnore
    public Label getLblShinsakaiToroku() {
        return this.getKanryoJoho().getLblShinsakaiToroku();
    }

    @JsonIgnore
    public void  setLblShinsakaiToroku(Label lblShinsakaiToroku) {
        this.getKanryoJoho().setLblShinsakaiToroku(lblShinsakaiToroku);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiToroku() {
        return this.getKanryoJoho().getChkShinsakaiToroku();
    }

    @JsonIgnore
    public void  setChkShinsakaiToroku(CheckBoxList chkShinsakaiToroku) {
        this.getKanryoJoho().setChkShinsakaiToroku(chkShinsakaiToroku);
    }

    @JsonIgnore
    public Label getLblIkenshoIrai() {
        return this.getKanryoJoho().getLblIkenshoIrai();
    }

    @JsonIgnore
    public void  setLblIkenshoIrai(Label lblIkenshoIrai) {
        this.getKanryoJoho().setLblIkenshoIrai(lblIkenshoIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoIrai() {
        return this.getKanryoJoho().getChkIkenshoIrai();
    }

    @JsonIgnore
    public void  setChkIkenshoIrai(CheckBoxList chkIkenshoIrai) {
        this.getKanryoJoho().setChkIkenshoIrai(chkIkenshoIrai);
    }

    @JsonIgnore
    public Label getLblNijiHantei() {
        return this.getKanryoJoho().getLblNijiHantei();
    }

    @JsonIgnore
    public void  setLblNijiHantei(Label lblNijiHantei) {
        this.getKanryoJoho().setLblNijiHantei(lblNijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getChkNijiHantei() {
        return this.getKanryoJoho().getChkNijiHantei();
    }

    @JsonIgnore
    public void  setChkNijiHantei(CheckBoxList chkNijiHantei) {
        this.getKanryoJoho().setChkNijiHantei(chkNijiHantei);
    }

    @JsonIgnore
    public Label getLblChosaNyushu() {
        return this.getKanryoJoho().getLblChosaNyushu();
    }

    @JsonIgnore
    public void  setLblChosaNyushu(Label lblChosaNyushu) {
        this.getKanryoJoho().setLblChosaNyushu(lblChosaNyushu);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaNyushu() {
        return this.getKanryoJoho().getChkChosaNyushu();
    }

    @JsonIgnore
    public void  setChkChosaNyushu(CheckBoxList chkChosaNyushu) {
        this.getKanryoJoho().setChkChosaNyushu(chkChosaNyushu);
    }

    @JsonIgnore
    public Label getLblTsuchiShori() {
        return this.getKanryoJoho().getLblTsuchiShori();
    }

    @JsonIgnore
    public void  setLblTsuchiShori(Label lblTsuchiShori) {
        this.getKanryoJoho().setLblTsuchiShori(lblTsuchiShori);
    }

    @JsonIgnore
    public CheckBoxList getChkTsuchiShori() {
        return this.getKanryoJoho().getChkTsuchiShori();
    }

    @JsonIgnore
    public void  setChkTsuchiShori(CheckBoxList chkTsuchiShori) {
        this.getKanryoJoho().setChkTsuchiShori(chkTsuchiShori);
    }

    @JsonIgnore
    public Label getLblIkenshoNyushu() {
        return this.getKanryoJoho().getLblIkenshoNyushu();
    }

    @JsonIgnore
    public void  setLblIkenshoNyushu(Label lblIkenshoNyushu) {
        this.getKanryoJoho().setLblIkenshoNyushu(lblIkenshoNyushu);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoNyushu() {
        return this.getKanryoJoho().getChkIkenshoNyushu();
    }

    @JsonIgnore
    public void  setChkIkenshoNyushu(CheckBoxList chkIkenshoNyushu) {
        this.getKanryoJoho().setChkIkenshoNyushu(chkIkenshoNyushu);
    }

    @JsonIgnore
    public Label getLblGetsureiShori() {
        return this.getKanryoJoho().getLblGetsureiShori();
    }

    @JsonIgnore
    public void  setLblGetsureiShori(Label lblGetsureiShori) {
        this.getKanryoJoho().setLblGetsureiShori(lblGetsureiShori);
    }

    @JsonIgnore
    public CheckBoxList getChkGetsureiShori() {
        return this.getKanryoJoho().getChkGetsureiShori();
    }

    @JsonIgnore
    public void  setChkGetsureiShori(CheckBoxList chkGetsureiShori) {
        this.getKanryoJoho().setChkGetsureiShori(chkGetsureiShori);
    }

    @JsonIgnore
    public KihonJohoDiv getKihonJoho() {
        return this.getShosaiJoken().getKihonJoho();
    }

    @JsonIgnore
    public void  setKihonJoho(KihonJohoDiv KihonJoho) {
        this.getShosaiJoken().setKihonJoho(KihonJoho);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaKubun() {
        return this.getShosaiJoken().getKihonJoho().getDdlHihokenshaKubun();
    }

    @JsonIgnore
    public void  setDdlHihokenshaKubun(DropDownList ddlHihokenshaKubun) {
        this.getShosaiJoken().getKihonJoho().setDdlHihokenshaKubun(ddlHihokenshaKubun);
    }

    @JsonIgnore
    public DropDownList getDdlHoreiShinseiji() {
        return this.getShosaiJoken().getKihonJoho().getDdlHoreiShinseiji();
    }

    @JsonIgnore
    public void  setDdlHoreiShinseiji(DropDownList ddlHoreiShinseiji) {
        this.getShosaiJoken().getKihonJoho().setDdlHoreiShinseiji(ddlHoreiShinseiji);
    }

    @JsonIgnore
    public DropDownList getDdlShoriKubun() {
        return this.getShosaiJoken().getKihonJoho().getDdlShoriKubun();
    }

    @JsonIgnore
    public void  setDdlShoriKubun(DropDownList ddlShoriKubun) {
        this.getShosaiJoken().getKihonJoho().setDdlShoriKubun(ddlShoriKubun);
    }

    @JsonIgnore
    public DropDownList getDdlKoroshoShikibetsuCode() {
        return this.getShosaiJoken().getKihonJoho().getDdlKoroshoShikibetsuCode();
    }

    @JsonIgnore
    public void  setDdlKoroshoShikibetsuCode(DropDownList ddlKoroshoShikibetsuCode) {
        this.getShosaiJoken().getKihonJoho().setDdlKoroshoShikibetsuCode(ddlKoroshoShikibetsuCode);
    }

    @JsonIgnore
    public Label getLblYubinNo() {
        return this.getShosaiJoken().getKihonJoho().getLblYubinNo();
    }

    @JsonIgnore
    public void  setLblYubinNo(Label lblYubinNo) {
        this.getShosaiJoken().getKihonJoho().setLblYubinNo(lblYubinNo);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getShosaiJoken().getKihonJoho().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getShosaiJoken().getKihonJoho().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public DropDownList getDdlChiku() {
        return this.getShosaiJoken().getKihonJoho().getDdlChiku();
    }

    @JsonIgnore
    public void  setDdlChiku(DropDownList ddlChiku) {
        this.getShosaiJoken().getKihonJoho().setDdlChiku(ddlChiku);
    }

    @JsonIgnore
    public CheckBoxList getChkShisetsuNyusho() {
        return this.getShosaiJoken().getKihonJoho().getChkShisetsuNyusho();
    }

    @JsonIgnore
    public void  setChkShisetsuNyusho(CheckBoxList chkShisetsuNyusho) {
        this.getShosaiJoken().getKihonJoho().setChkShisetsuNyusho(chkShisetsuNyusho);
    }

    @JsonIgnore
    public NinteiChosaDiv getNinteiChosa() {
        return this.getShosaiJoken().getNinteiChosa();
    }

    @JsonIgnore
    public void  setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.getShosaiJoken().setNinteiChosa(NinteiChosa);
    }

    @JsonIgnore
    public TextBoxDomainCode getTxtNinteiChosaIinItakuSaki() {
        return this.getShosaiJoken().getNinteiChosa().getTxtNinteiChosaIinItakuSaki();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaIinItakuSaki(TextBoxDomainCode txtNinteiChosaIinItakuSaki) {
        this.getShosaiJoken().getNinteiChosa().setTxtNinteiChosaIinItakuSaki(txtNinteiChosaIinItakuSaki);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinteiChosaItakusakiGuide() {
        return this.getShosaiJoken().getNinteiChosa().getBtnNinteiChosaItakusakiGuide();
    }

    @JsonIgnore
    public void  setBtnNinteiChosaItakusakiGuide(ButtonDialog btnNinteiChosaItakusakiGuide) {
        this.getShosaiJoken().getNinteiChosa().setBtnNinteiChosaItakusakiGuide(btnNinteiChosaItakusakiGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiName() {
        return this.getShosaiJoken().getNinteiChosa().getTxtNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.getShosaiJoken().getNinteiChosa().setTxtNinteiChosaItakusakiName(txtNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public TextBoxDomainCode getTxtNinteiChosaInShimei() {
        return this.getShosaiJoken().getNinteiChosa().getTxtNinteiChosaInShimei();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaInShimei(TextBoxDomainCode txtNinteiChosaInShimei) {
        this.getShosaiJoken().getNinteiChosa().setTxtNinteiChosaInShimei(txtNinteiChosaInShimei);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinteiChosainGuide() {
        return this.getShosaiJoken().getNinteiChosa().getBtnNinteiChosainGuide();
    }

    @JsonIgnore
    public void  setBtnNinteiChosainGuide(ButtonDialog btnNinteiChosainGuide) {
        this.getShosaiJoken().getNinteiChosa().setBtnNinteiChosainGuide(btnNinteiChosainGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getShosaiJoken().getNinteiChosa().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getShosaiJoken().getNinteiChosa().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public DropDownList getDdlChosaJisshiBasho() {
        return this.getShosaiJoken().getNinteiChosa().getDdlChosaJisshiBasho();
    }

    @JsonIgnore
    public void  setDdlChosaJisshiBasho(DropDownList ddlChosaJisshiBasho) {
        this.getShosaiJoken().getNinteiChosa().setDdlChosaJisshiBasho(ddlChosaJisshiBasho);
    }

    @JsonIgnore
    public DropDownList getDdlChosaKubun() {
        return this.getShosaiJoken().getNinteiChosa().getDdlChosaKubun();
    }

    @JsonIgnore
    public void  setDdlChosaKubun(DropDownList ddlChosaKubun) {
        this.getShosaiJoken().getNinteiChosa().setDdlChosaKubun(ddlChosaKubun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChosaJisshiDateRange() {
        return this.getShosaiJoken().getNinteiChosa().getTxtChosaJisshiDateRange();
    }

    @JsonIgnore
    public void  setTxtChosaJisshiDateRange(TextBoxDateRange txtChosaJisshiDateRange) {
        this.getShosaiJoken().getNinteiChosa().setTxtChosaJisshiDateRange(txtChosaJisshiDateRange);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaNetakirido() {
        return this.getShosaiJoken().getNinteiChosa().getDdlNinteiChosaNetakirido();
    }

    @JsonIgnore
    public void  setDdlNinteiChosaNetakirido(DropDownList ddlNinteiChosaNetakirido) {
        this.getShosaiJoken().getNinteiChosa().setDdlNinteiChosaNetakirido(ddlNinteiChosaNetakirido);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaNinchido() {
        return this.getShosaiJoken().getNinteiChosa().getDdlNinteiChosaNinchido();
    }

    @JsonIgnore
    public void  setDdlNinteiChosaNinchido(DropDownList ddlNinteiChosaNinchido) {
        this.getShosaiJoken().getNinteiChosa().setDdlNinteiChosaNinchido(ddlNinteiChosaNinchido);
    }

    @JsonIgnore
    public ShujiiJohoDiv getShujiiJoho() {
        return this.getShosaiJoken().getShujiiJoho();
    }

    @JsonIgnore
    public void  setShujiiJoho(ShujiiJohoDiv ShujiiJoho) {
        this.getShosaiJoken().setShujiiJoho(ShujiiJoho);
    }

    @JsonIgnore
    public TextBoxDomainCode getTxtShujiiIryokikan() {
        return this.getShosaiJoken().getShujiiJoho().getTxtShujiiIryokikan();
    }

    @JsonIgnore
    public void  setTxtShujiiIryokikan(TextBoxDomainCode txtShujiiIryokikan) {
        this.getShosaiJoken().getShujiiJoho().setTxtShujiiIryokikan(txtShujiiIryokikan);
    }

    @JsonIgnore
    public ButtonDialog getBtnShujiiIryokikanGuide() {
        return this.getShosaiJoken().getShujiiJoho().getBtnShujiiIryokikanGuide();
    }

    @JsonIgnore
    public void  setBtnShujiiIryokikanGuide(ButtonDialog btnShujiiIryokikanGuide) {
        this.getShosaiJoken().getShujiiJoho().setBtnShujiiIryokikanGuide(btnShujiiIryokikanGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiIryokikanName() {
        return this.getShosaiJoken().getShujiiJoho().getTxtShujiiIryokikanName();
    }

    @JsonIgnore
    public void  setTxtShujiiIryokikanName(TextBox txtShujiiIryokikanName) {
        this.getShosaiJoken().getShujiiJoho().setTxtShujiiIryokikanName(txtShujiiIryokikanName);
    }

    @JsonIgnore
    public TextBoxDomainCode getTxtShujiiShimei() {
        return this.getShosaiJoken().getShujiiJoho().getTxtShujiiShimei();
    }

    @JsonIgnore
    public void  setTxtShujiiShimei(TextBoxDomainCode txtShujiiShimei) {
        this.getShosaiJoken().getShujiiJoho().setTxtShujiiShimei(txtShujiiShimei);
    }

    @JsonIgnore
    public ButtonDialog getBtnShujiiGuide() {
        return this.getShosaiJoken().getShujiiJoho().getBtnShujiiGuide();
    }

    @JsonIgnore
    public void  setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.getShosaiJoken().getShujiiJoho().setBtnShujiiGuide(btnShujiiGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getShosaiJoken().getShujiiJoho().getTxtShujiiName();
    }

    @JsonIgnore
    public void  setTxtShujiiName(TextBox txtShujiiName) {
        this.getShosaiJoken().getShujiiJoho().setTxtShujiiName(txtShujiiName);
    }

    @JsonIgnore
    public DropDownList getDdlShujiIkubun() {
        return this.getShosaiJoken().getShujiiJoho().getDdlShujiIkubun();
    }

    @JsonIgnore
    public void  setDdlShujiIkubun(DropDownList ddlShujiIkubun) {
        this.getShosaiJoken().getShujiiJoho().setDdlShujiIkubun(ddlShujiIkubun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIkenshoKinyuDateRange() {
        return this.getShosaiJoken().getShujiiJoho().getTxtIkenshoKinyuDateRange();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyuDateRange(TextBoxDateRange txtIkenshoKinyuDateRange) {
        this.getShosaiJoken().getShujiiJoho().setTxtIkenshoKinyuDateRange(txtIkenshoKinyuDateRange);
    }

    @JsonIgnore
    public DropDownList getDdlShujiJohoNetakirido() {
        return this.getShosaiJoken().getShujiiJoho().getDdlShujiJohoNetakirido();
    }

    @JsonIgnore
    public void  setDdlShujiJohoNetakirido(DropDownList ddlShujiJohoNetakirido) {
        this.getShosaiJoken().getShujiiJoho().setDdlShujiJohoNetakirido(ddlShujiJohoNetakirido);
    }

    @JsonIgnore
    public DropDownList getDdlShujiJohoNinchido() {
        return this.getShosaiJoken().getShujiiJoho().getDdlShujiJohoNinchido();
    }

    @JsonIgnore
    public void  setDdlShujiJohoNinchido(DropDownList ddlShujiJohoNinchido) {
        this.getShosaiJoken().getShujiiJoho().setDdlShujiJohoNinchido(ddlShujiJohoNinchido);
    }

    @JsonIgnore
    public IchijiHanteiDiv getIchijiHantei() {
        return this.getShosaiJoken().getIchijiHantei();
    }

    @JsonIgnore
    public void  setIchijiHantei(IchijiHanteiDiv IchijiHantei) {
        this.getShosaiJoken().setIchijiHantei(IchijiHantei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIchijiHanteiDateRange() {
        return this.getShosaiJoken().getIchijiHantei().getTxtIchijiHanteiDateRange();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiDateRange(TextBoxDateRange txtIchijiHanteiDateRange) {
        this.getShosaiJoken().getIchijiHantei().setTxtIchijiHanteiDateRange(txtIchijiHanteiDateRange);
    }

    @JsonIgnore
    public DropDownList getDdlIchijiHanteiKekka() {
        return this.getShosaiJoken().getIchijiHantei().getDdlIchijiHanteiKekka();
    }

    @JsonIgnore
    public void  setDdlIchijiHanteiKekka(DropDownList ddlIchijiHanteiKekka) {
        this.getShosaiJoken().getIchijiHantei().setDdlIchijiHanteiKekka(ddlIchijiHanteiKekka);
    }

    @JsonIgnore
    public IchiGoHanteiDiv getIchiGoHantei() {
        return this.getShosaiJoken().getIchiGoHantei();
    }

    @JsonIgnore
    public void  setIchiGoHantei(IchiGoHanteiDiv IchiGoHantei) {
        this.getShosaiJoken().setIchiGoHantei(IchiGoHantei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIchiGoHanteiDateRange() {
        return this.getShosaiJoken().getIchiGoHantei().getTxtIchiGoHanteiDateRange();
    }

    @JsonIgnore
    public void  setTxtIchiGoHanteiDateRange(TextBoxDateRange txtIchiGoHanteiDateRange) {
        this.getShosaiJoken().getIchiGoHantei().setTxtIchiGoHanteiDateRange(txtIchiGoHanteiDateRange);
    }

    @JsonIgnore
    public DropDownList getDdlIchiGohanteiKekka() {
        return this.getShosaiJoken().getIchiGoHantei().getDdlIchiGohanteiKekka();
    }

    @JsonIgnore
    public void  setDdlIchiGohanteiKekka(DropDownList ddlIchiGohanteiKekka) {
        this.getShosaiJoken().getIchiGoHantei().setDdlIchiGohanteiKekka(ddlIchiGohanteiKekka);
    }

    @JsonIgnore
    public KaigoNinteiShinsakaiJohoDiv getKaigoNinteiShinsakaiJoho() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho();
    }

    @JsonIgnore
    public void  setKaigoNinteiShinsakaiJoho(KaigoNinteiShinsakaiJohoDiv KaigoNinteiShinsakaiJoho) {
        this.getShosaiJoken().setKaigoNinteiShinsakaiJoho(KaigoNinteiShinsakaiJoho);
    }

    @JsonIgnore
    public DropDownList getDdlNijiHanteiKekka() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getDdlNijiHanteiKekka();
    }

    @JsonIgnore
    public void  setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setDdlNijiHanteiKekka(ddlNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBox getTxtNinteiYukoKikan() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoKikan();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikan(TextBox txtNinteiYukoKikan) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoKikan(txtNinteiYukoKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtCheckDay() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtCheckDay();
    }

    @JsonIgnore
    public void  setTxtCheckDay(TextBoxDate txtCheckDay) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtCheckDay(txtCheckDay);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYukoKaishiDateRange() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoKaishiDateRange();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKaishiDateRange(TextBoxDateRange txtNinteiYukoKaishiDateRange) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoKaishiDateRange(txtNinteiYukoKaishiDateRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYukoShuryoDateRange() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNinteiYukoShuryoDateRange();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryoDateRange(TextBoxDateRange txtNinteiYukoShuryoDateRange) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNinteiYukoShuryoDateRange(txtNinteiYukoShuryoDateRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNijiHanteiDateRange() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtNijiHanteiDateRange();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiDateRange(TextBoxDateRange txtNijiHanteiDateRange) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtNijiHanteiDateRange(txtNijiHanteiDateRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKaisaiDateRange() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtKaisaiDateRange();
    }

    @JsonIgnore
    public void  setTxtKaisaiDateRange(TextBoxDateRange txtKaisaiDateRange) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtKaisaiDateRange(txtKaisaiDateRange);
    }

    @JsonIgnore
    public Label getLblKaisaiNumber() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getLblKaisaiNumber();
    }

    @JsonIgnore
    public void  setLblKaisaiNumber(Label lblKaisaiNumber) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setLblKaisaiNumber(lblKaisaiNumber);
    }

    @JsonIgnore
    public TextBox getTxtKaisaiNumberStart() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtKaisaiNumberStart();
    }

    @JsonIgnore
    public void  setTxtKaisaiNumberStart(TextBox txtKaisaiNumberStart) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtKaisaiNumberStart(txtKaisaiNumberStart);
    }

    @JsonIgnore
    public Label getLblKaisaiNoFor() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getLblKaisaiNoFor();
    }

    @JsonIgnore
    public void  setLblKaisaiNoFor(Label lblKaisaiNoFor) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setLblKaisaiNoFor(lblKaisaiNoFor);
    }

    @JsonIgnore
    public TextBox getTxtKaisaiNumberEnd() {
        return this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().getTxtKaisaiNumberEnd();
    }

    @JsonIgnore
    public void  setTxtKaisaiNumberEnd(TextBox txtKaisaiNumberEnd) {
        this.getShosaiJoken().getKaigoNinteiShinsakaiJoho().setTxtKaisaiNumberEnd(txtKaisaiNumberEnd);
    }

    @JsonIgnore
    public ZenkaiJohoDiv getZenkaiJoho() {
        return this.getShosaiJoken().getZenkaiJoho();
    }

    @JsonIgnore
    public void  setZenkaiJoho(ZenkaiJohoDiv ZenkaiJoho) {
        this.getShosaiJoken().setZenkaiJoho(ZenkaiJoho);
    }

    @JsonIgnore
    public TextBoxDomainCode getTxtZenkaiChosaItakusaki() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiChosaItakusaki();
    }

    @JsonIgnore
    public void  setTxtZenkaiChosaItakusaki(TextBoxDomainCode txtZenkaiChosaItakusaki) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiChosaItakusaki(txtZenkaiChosaItakusaki);
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiChosaItakusakiGuide() {
        return this.getShosaiJoken().getZenkaiJoho().getBtnZenkaiChosaItakusakiGuide();
    }

    @JsonIgnore
    public void  setBtnZenkaiChosaItakusakiGuide(ButtonDialog btnZenkaiChosaItakusakiGuide) {
        this.getShosaiJoken().getZenkaiJoho().setBtnZenkaiChosaItakusakiGuide(btnZenkaiChosaItakusakiGuide);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiNinteiChosaItakusakiName() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtZenkaiNinteiChosaItakusakiName(TextBox txtZenkaiNinteiChosaItakusakiName) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiNinteiChosaItakusakiName(txtZenkaiNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public TextBoxDomainCode getTxtZenkaiShujiiIryokikan() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiShujiiIryokikan();
    }

    @JsonIgnore
    public void  setTxtZenkaiShujiiIryokikan(TextBoxDomainCode txtZenkaiShujiiIryokikan) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiShujiiIryokikan(txtZenkaiShujiiIryokikan);
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiShujiiIryokikanGuide() {
        return this.getShosaiJoken().getZenkaiJoho().getBtnZenkaiShujiiIryokikanGuide();
    }

    @JsonIgnore
    public void  setBtnZenkaiShujiiIryokikanGuide(ButtonDialog btnZenkaiShujiiIryokikanGuide) {
        this.getShosaiJoken().getZenkaiJoho().setBtnZenkaiShujiiIryokikanGuide(btnZenkaiShujiiIryokikanGuide);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiShujiiIryokikanName() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiShujiiIryokikanName();
    }

    @JsonIgnore
    public void  setTxtZenkaiShujiiIryokikanName(TextBox txtZenkaiShujiiIryokikanName) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiShujiiIryokikanName(txtZenkaiShujiiIryokikanName);
    }

    @JsonIgnore
    public DropDownList getDdlZenkaiNijiHanteiKekka() {
        return this.getShosaiJoken().getZenkaiJoho().getDdlZenkaiNijiHanteiKekka();
    }

    @JsonIgnore
    public void  setDdlZenkaiNijiHanteiKekka(DropDownList ddlZenkaiNijiHanteiKekka) {
        this.getShosaiJoken().getZenkaiJoho().setDdlZenkaiNijiHanteiKekka(ddlZenkaiNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiNinteiYukoKikan() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiNinteiYukoKikan();
    }

    @JsonIgnore
    public void  setTxtZenkaiNinteiYukoKikan(TextBox txtZenkaiNinteiYukoKikan) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiNinteiYukoKikan(txtZenkaiNinteiYukoKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtZenkaiYukoKaishiDateRange() {
        return this.getShosaiJoken().getZenkaiJoho().getTxtZenkaiYukoKaishiDateRange();
    }

    @JsonIgnore
    public void  setTxtZenkaiYukoKaishiDateRange(TextBoxDateRange txtZenkaiYukoKaishiDateRange) {
        this.getShosaiJoken().getZenkaiJoho().setTxtZenkaiYukoKaishiDateRange(txtZenkaiYukoKaishiDateRange);
    }

    @JsonIgnore
    public SonotaJohoDiv getSonotaJoho() {
        return this.getShosaiJoken().getSonotaJoho();
    }

    @JsonIgnore
    public void  setSonotaJoho(SonotaJohoDiv SonotaJoho) {
        this.getShosaiJoken().setSonotaJoho(SonotaJoho);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdGeninShikkan() {
        return this.getShosaiJoken().getSonotaJoho().getCcdGeninShikkan();
    }

    @JsonIgnore
    public TextBoxNumRange getTxtShinseiKeikaNissu() {
        return this.getShosaiJoken().getSonotaJoho().getTxtShinseiKeikaNissu();
    }

    @JsonIgnore
    public void  setTxtShinseiKeikaNissu(TextBoxNumRange txtShinseiKeikaNissu) {
        this.getShosaiJoken().getSonotaJoho().setTxtShinseiKeikaNissu(txtShinseiKeikaNissu);
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

    /**
     * 最近処理者Divを取得します。
     *
     * @return
     */
    @Override
    public ISaikinShorishaDiv getSaikinShorishaDiv() {
        return this.getCcdSaikinShorisha();
    }

    @Override
    public void updateSaikinShorisha(RString hihokenshaNo, RString hihokenshaName) {
        this.getCcdSaikinShorisha().update(hihokenshaNo, hihokenshaName, this.getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号());
    }

    @Override
    public void initialize_最近処理者非表示() {
        getHandler(this).initialize_最近処理者非表示();
    }

    @Override
    public void reloadSaikinShorisha() {
        this.getCcdSaikinShorisha().initialize(this.getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号());
    }

    private NinteiShinseishaFinderHandler getHandler(NinteiShinseishaFinderDiv div) {
        return new NinteiShinseishaFinderHandler(div);
    }

    private NinteiShinseishaFinderValidationHandler getValidationHandler(NinteiShinseishaFinderDiv div) {
        return new NinteiShinseishaFinderValidationHandler(div);
    }

    @Override
    public void initialize(NinteiShinseishaFinderParameter parameter) {
        getHandler(this).initialize(parameter);
    }

    @Override
    public NinteiShinseishaFinderParameter getParameter() {
        return getHandler(this).getParameter();
    }

}
