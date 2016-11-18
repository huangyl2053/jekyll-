package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.IKaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.KaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * KaigoChohyoSeigyoKyotsu のクラスファイル
 *
 * @reamsid_L DBB-1770-070 yebangqiang
 */
public class KaigoChohyoSeigyoKyotsuDiv extends Panel implements IKaigoChohyoSeigyoKyotsuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtesakiJusho")
    private AtesakiJushoDiv AtesakiJusho;
    @JsonProperty("ConfigInfo1")
    private ConfigInfo1Div ConfigInfo1;
    @JsonProperty("ConfigInfo2")
    private ConfigInfo2Div ConfigInfo2;
    @JsonProperty("ConfigInfo3")
    private ConfigInfo3Div ConfigInfo3;
    @JsonProperty("ConfigInfo4")
    private ConfigInfo4Div ConfigInfo4;
    @JsonProperty("CommonButtonPanel")
    private CommonButtonPanelDiv CommonButtonPanel;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;
    @JsonProperty("hdnSubGyomuCode")
    private RString hdnSubGyomuCode;
    @JsonProperty("hdnReportId")
    private RString hdnReportId;
    @JsonProperty("hdnReportName")
    private RString hdnReportName;
    @JsonProperty("hdnIsDisplayInsertTag")
    private RString hdnIsDisplayInsertTag;
    @JsonProperty("hdnTagList")
    private RString hdnTagList;
    @JsonProperty("hdShubetsuCodeList")
    private RString hdShubetsuCodeList;
    @JsonProperty("hdSelectedShubetsuCode")
    private RString hdSelectedShubetsuCode;
    @JsonProperty("hdGyomuCode")
    private RString hdGyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtesakiJusho
     * @return AtesakiJusho
     */
    @JsonProperty("AtesakiJusho")
    public AtesakiJushoDiv getAtesakiJusho() {
        return AtesakiJusho;
    }

    /*
     * setAtesakiJusho
     * @param AtesakiJusho AtesakiJusho
     */
    @JsonProperty("AtesakiJusho")
    public void setAtesakiJusho(AtesakiJushoDiv AtesakiJusho) {
        this.AtesakiJusho = AtesakiJusho;
    }

    /*
     * getConfigInfo1
     * @return ConfigInfo1
     */
    @JsonProperty("ConfigInfo1")
    public ConfigInfo1Div getConfigInfo1() {
        return ConfigInfo1;
    }

    /*
     * setConfigInfo1
     * @param ConfigInfo1 ConfigInfo1
     */
    @JsonProperty("ConfigInfo1")
    public void setConfigInfo1(ConfigInfo1Div ConfigInfo1) {
        this.ConfigInfo1 = ConfigInfo1;
    }

    /*
     * getConfigInfo2
     * @return ConfigInfo2
     */
    @JsonProperty("ConfigInfo2")
    public ConfigInfo2Div getConfigInfo2() {
        return ConfigInfo2;
    }

    /*
     * setConfigInfo2
     * @param ConfigInfo2 ConfigInfo2
     */
    @JsonProperty("ConfigInfo2")
    public void setConfigInfo2(ConfigInfo2Div ConfigInfo2) {
        this.ConfigInfo2 = ConfigInfo2;
    }

    /*
     * getConfigInfo3
     * @return ConfigInfo3
     */
    @JsonProperty("ConfigInfo3")
    public ConfigInfo3Div getConfigInfo3() {
        return ConfigInfo3;
    }

    /*
     * setConfigInfo3
     * @param ConfigInfo3 ConfigInfo3
     */
    @JsonProperty("ConfigInfo3")
    public void setConfigInfo3(ConfigInfo3Div ConfigInfo3) {
        this.ConfigInfo3 = ConfigInfo3;
    }

    /*
     * getConfigInfo4
     * @return ConfigInfo4
     */
    @JsonProperty("ConfigInfo4")
    public ConfigInfo4Div getConfigInfo4() {
        return ConfigInfo4;
    }

    /*
     * setConfigInfo4
     * @param ConfigInfo4 ConfigInfo4
     */
    @JsonProperty("ConfigInfo4")
    public void setConfigInfo4(ConfigInfo4Div ConfigInfo4) {
        this.ConfigInfo4 = ConfigInfo4;
    }

    /*
     * getCommonButtonPanel
     * @return CommonButtonPanel
     */
    @JsonProperty("CommonButtonPanel")
    public CommonButtonPanelDiv getCommonButtonPanel() {
        return CommonButtonPanel;
    }

    /*
     * setCommonButtonPanel
     * @param CommonButtonPanel CommonButtonPanel
     */
    @JsonProperty("CommonButtonPanel")
    public void setCommonButtonPanel(CommonButtonPanelDiv CommonButtonPanel) {
        this.CommonButtonPanel = CommonButtonPanel;
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
     * gethdnSubGyomuCode
     * @return hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public RString getHdnSubGyomuCode() {
        return hdnSubGyomuCode;
    }

    /*
     * sethdnSubGyomuCode
     * @param hdnSubGyomuCode hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public void setHdnSubGyomuCode(RString hdnSubGyomuCode) {
        this.hdnSubGyomuCode = hdnSubGyomuCode;
    }

    /*
     * gethdnReportId
     * @return hdnReportId
     */
    @JsonProperty("hdnReportId")
    public RString getHdnReportId() {
        return hdnReportId;
    }

    /*
     * sethdnReportId
     * @param hdnReportId hdnReportId
     */
    @JsonProperty("hdnReportId")
    public void setHdnReportId(RString hdnReportId) {
        this.hdnReportId = hdnReportId;
    }

    /*
     * gethdnReportName
     * @return hdnReportName
     */
    @JsonProperty("hdnReportName")
    public RString getHdnReportName() {
        return hdnReportName;
    }

    /*
     * sethdnReportName
     * @param hdnReportName hdnReportName
     */
    @JsonProperty("hdnReportName")
    public void setHdnReportName(RString hdnReportName) {
        this.hdnReportName = hdnReportName;
    }

    /*
     * gethdnIsDisplayInsertTag
     * @return hdnIsDisplayInsertTag
     */
    @JsonProperty("hdnIsDisplayInsertTag")
    public RString getHdnIsDisplayInsertTag() {
        return hdnIsDisplayInsertTag;
    }

    /*
     * sethdnIsDisplayInsertTag
     * @param hdnIsDisplayInsertTag hdnIsDisplayInsertTag
     */
    @JsonProperty("hdnIsDisplayInsertTag")
    public void setHdnIsDisplayInsertTag(RString hdnIsDisplayInsertTag) {
        this.hdnIsDisplayInsertTag = hdnIsDisplayInsertTag;
    }

    /*
     * gethdnTagList
     * @return hdnTagList
     */
    @JsonProperty("hdnTagList")
    public RString getHdnTagList() {
        return hdnTagList;
    }

    /*
     * sethdnTagList
     * @param hdnTagList hdnTagList
     */
    @JsonProperty("hdnTagList")
    public void setHdnTagList(RString hdnTagList) {
        this.hdnTagList = hdnTagList;
    }

    /*
     * gethdShubetsuCodeList
     * @return hdShubetsuCodeList
     */
    @JsonProperty("hdShubetsuCodeList")
    public RString getHdShubetsuCodeList() {
        return hdShubetsuCodeList;
    }

    /*
     * sethdShubetsuCodeList
     * @param hdShubetsuCodeList hdShubetsuCodeList
     */
    @JsonProperty("hdShubetsuCodeList")
    public void setHdShubetsuCodeList(RString hdShubetsuCodeList) {
        this.hdShubetsuCodeList = hdShubetsuCodeList;
    }

    /*
     * gethdSelectedShubetsuCode
     * @return hdSelectedShubetsuCode
     */
    @JsonProperty("hdSelectedShubetsuCode")
    public RString getHdSelectedShubetsuCode() {
        return hdSelectedShubetsuCode;
    }

    /*
     * sethdSelectedShubetsuCode
     * @param hdSelectedShubetsuCode hdSelectedShubetsuCode
     */
    @JsonProperty("hdSelectedShubetsuCode")
    public void setHdSelectedShubetsuCode(RString hdSelectedShubetsuCode) {
        this.hdSelectedShubetsuCode = hdSelectedShubetsuCode;
    }

    /*
     * gethdGyomuCode
     * @return hdGyomuCode
     */
    @JsonProperty("hdGyomuCode")
    public RString getHdGyomuCode() {
        return hdGyomuCode;
    }

    /*
     * sethdGyomuCode
     * @param hdGyomuCode hdGyomuCode
     */
    @JsonProperty("hdGyomuCode")
    public void setHdGyomuCode(RString hdGyomuCode) {
        this.hdGyomuCode = hdGyomuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoAtesakiJushoSetteiDiv getCcdKaigoAtesakiJushoSettei() {
        return this.getAtesakiJusho().getCcdKaigoAtesakiJushoSettei();
    }

    @JsonIgnore
    public HyojiCodeNameDiv getHyojiCodeName() {
        return this.getConfigInfo1().getHyojiCodeName();
    }

    @JsonIgnore
    public void  setHyojiCodeName(HyojiCodeNameDiv HyojiCodeName) {
        this.getConfigInfo1().setHyojiCodeName(HyojiCodeName);
    }

    @JsonIgnore
    public DropDownList getDdlHyojiCodeName1() {
        return this.getConfigInfo1().getHyojiCodeName().getDdlHyojiCodeName1();
    }

    @JsonIgnore
    public void  setDdlHyojiCodeName1(DropDownList ddlHyojiCodeName1) {
        this.getConfigInfo1().getHyojiCodeName().setDdlHyojiCodeName1(ddlHyojiCodeName1);
    }

    @JsonIgnore
    public DropDownList getDdlHyojiCodeName2() {
        return this.getConfigInfo1().getHyojiCodeName().getDdlHyojiCodeName2();
    }

    @JsonIgnore
    public void  setDdlHyojiCodeName2(DropDownList ddlHyojiCodeName2) {
        this.getConfigInfo1().getHyojiCodeName().setDdlHyojiCodeName2(ddlHyojiCodeName2);
    }

    @JsonIgnore
    public DropDownList getDdlHyojiCodeName3() {
        return this.getConfigInfo1().getHyojiCodeName().getDdlHyojiCodeName3();
    }

    @JsonIgnore
    public void  setDdlHyojiCodeName3(DropDownList ddlHyojiCodeName3) {
        this.getConfigInfo1().getHyojiCodeName().setDdlHyojiCodeName3(ddlHyojiCodeName3);
    }

    @JsonIgnore
    public RadioButton getRadSetaiNushiHyoji() {
        return this.getConfigInfo2().getRadSetaiNushiHyoji();
    }

    @JsonIgnore
    public void  setRadSetaiNushiHyoji(RadioButton radSetaiNushiHyoji) {
        this.getConfigInfo2().setRadSetaiNushiHyoji(radSetaiNushiHyoji);
    }

    @JsonIgnore
    public RadioButton getRadDainoninHyoji() {
        return this.getConfigInfo2().getRadDainoninHyoji();
    }

    @JsonIgnore
    public void  setRadDainoninHyoji(RadioButton radDainoninHyoji) {
        this.getConfigInfo2().setRadDainoninHyoji(radDainoninHyoji);
    }

    @JsonIgnore
    public RadioButton getRadKozaMask() {
        return this.getConfigInfo2().getRadKozaMask();
    }

    @JsonIgnore
    public void  setRadKozaMask(RadioButton radKozaMask) {
        this.getConfigInfo2().setRadKozaMask(radKozaMask);
    }

    @JsonIgnore
    public RadioButton getRadKozaMeigininKana() {
        return this.getConfigInfo2().getRadKozaMeigininKana();
    }

    @JsonIgnore
    public void  setRadKozaMeigininKana(RadioButton radKozaMeigininKana) {
        this.getConfigInfo2().setRadKozaMeigininKana(radKozaMeigininKana);
    }

    @JsonIgnore
    public RadioButton getRadMonjiKireCrtlGaibu() {
        return this.getConfigInfo3().getRadMonjiKireCrtlGaibu();
    }

    @JsonIgnore
    public void  setRadMonjiKireCrtlGaibu(RadioButton radMonjiKireCrtlGaibu) {
        this.getConfigInfo3().setRadMonjiKireCrtlGaibu(radMonjiKireCrtlGaibu);
    }

    @JsonIgnore
    public RadioButton getRadMonjiKireCrtlNaibu() {
        return this.getConfigInfo3().getRadMonjiKireCrtlNaibu();
    }

    @JsonIgnore
    public void  setRadMonjiKireCrtlNaibu(RadioButton radMonjiKireCrtlNaibu) {
        this.getConfigInfo3().setRadMonjiKireCrtlNaibu(radMonjiKireCrtlNaibu);
    }

    @JsonIgnore
    public RadioButton getRadMojiKireBunriCtrl() {
        return this.getConfigInfo3().getRadMojiKireBunriCtrl();
    }

    @JsonIgnore
    public void  setRadMojiKireBunriCtrl(RadioButton radMojiKireBunriCtrl) {
        this.getConfigInfo3().setRadMojiKireBunriCtrl(radMojiKireBunriCtrl);
    }

    @JsonIgnore
    public RadioButton getRadDaikoPrintUmu() {
        return this.getConfigInfo3().getRadDaikoPrintUmu();
    }

    @JsonIgnore
    public void  setRadDaikoPrintUmu(RadioButton radDaikoPrintUmu) {
        this.getConfigInfo3().setRadDaikoPrintUmu(radDaikoPrintUmu);
    }

    @JsonIgnore
    public DropDownList getDdlChohyoMongonYoshiki() {
        return this.getConfigInfo3().getDdlChohyoMongonYoshiki();
    }

    @JsonIgnore
    public void  setDdlChohyoMongonYoshiki(DropDownList ddlChohyoMongonYoshiki) {
        this.getConfigInfo3().setDdlChohyoMongonYoshiki(ddlChohyoMongonYoshiki);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getConfigInfo4().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getConfigInfo4().setLin1(lin1);
    }

    @JsonIgnore
    public BarCodeDiv getBarCode() {
        return this.getConfigInfo4().getBarCode();
    }

    @JsonIgnore
    public void  setBarCode(BarCodeDiv BarCode) {
        this.getConfigInfo4().setBarCode(BarCode);
    }

    @JsonIgnore
    public DropDownList getDdlBarCodeUmu() {
        return this.getConfigInfo4().getBarCode().getDdlBarCodeUmu();
    }

    @JsonIgnore
    public void  setDdlBarCodeUmu(DropDownList ddlBarCodeUmu) {
        this.getConfigInfo4().getBarCode().setDdlBarCodeUmu(ddlBarCodeUmu);
    }

    @JsonIgnore
    public DropDownList getDdlBarCodeHenshuHoho() {
        return this.getConfigInfo4().getBarCode().getDdlBarCodeHenshuHoho();
    }

    @JsonIgnore
    public void  setDdlBarCodeHenshuHoho(DropDownList ddlBarCodeHenshuHoho) {
        this.getConfigInfo4().getBarCode().setDdlBarCodeHenshuHoho(ddlBarCodeHenshuHoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnBunshoNo() {
        return this.getCommonButtonPanel().getBtnBunshoNo();
    }

    @JsonIgnore
    public void  setBtnBunshoNo(ButtonDialog btnBunshoNo) {
        this.getCommonButtonPanel().setBtnBunshoNo(btnBunshoNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnTsuchishoTeikeibun() {
        return this.getCommonButtonPanel().getBtnTsuchishoTeikeibun();
    }

    @JsonIgnore
    public void  setBtnTsuchishoTeikeibun(ButtonDialog btnTsuchishoTeikeibun) {
        this.getCommonButtonPanel().setBtnTsuchishoTeikeibun(btnTsuchishoTeikeibun);
    }

    @JsonIgnore
    public ButtonDialog getBtnGyomuNinshohsa() {
        return this.getCommonButtonPanel().getBtnGyomuNinshohsa();
    }

    @JsonIgnore
    public void  setBtnGyomuNinshohsa(ButtonDialog btnGyomuNinshohsa) {
        this.getCommonButtonPanel().setBtnGyomuNinshohsa(btnGyomuNinshohsa);
    }

    @JsonIgnore
    public ButtonDialog getBtnKaigoToiawasesaki() {
        return this.getCommonButtonPanel().getBtnKaigoToiawasesaki();
    }

    @JsonIgnore
    public void  setBtnKaigoToiawasesaki(ButtonDialog btnKaigoToiawasesaki) {
        this.getCommonButtonPanel().setBtnKaigoToiawasesaki(btnKaigoToiawasesaki);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 介護帳票制御共通情報の初期化
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     */
    @Override
    public void initialize(SubGyomuCode subGyomuCode, ReportId reportId) {
        KaigoChohyoSeigyoKyotsuHandler handler = new KaigoChohyoSeigyoKyotsuHandler(this);
        ChohyoSeigyoKyotsuManager 帳票制御共通Mgr = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsu 帳票制御共通 = 帳票制御共通Mgr.get帳票制御共通(subGyomuCode, reportId);
        handler.initialize(subGyomuCode, reportId, 帳票制御共通);
        ViewStateHolder.put(ViewStateKeys.帳票制御共通, 帳票制御共通);
    }

    /**
     * 介護帳票制御共通情報の保存
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     */
    @Override
    public void save(SubGyomuCode subGyomuCode, ReportId reportId) {
        KaigoChohyoSeigyoKyotsuHandler handler = new KaigoChohyoSeigyoKyotsuHandler(this);
        ChohyoSeigyoKyotsu 帳票制御共通 = ViewStateHolder.get(ViewStateKeys.帳票制御共通, ChohyoSeigyoKyotsu.class);
        handler.save(subGyomuCode, reportId, 帳票制御共通);
    }
}
