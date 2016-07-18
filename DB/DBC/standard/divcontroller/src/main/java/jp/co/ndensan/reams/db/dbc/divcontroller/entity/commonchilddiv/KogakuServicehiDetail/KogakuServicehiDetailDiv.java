package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.IKogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * 画面設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class KogakuServicehiDetailDiv extends Panel implements IKogakuServicehiDetailDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("txtJotai")
    private TextBox txtJotai;
    @JsonProperty("txtKanriBango")
    private TextBoxNum txtKanriBango;
    @JsonProperty("tabKogakuServicehiDetail")
    private tabKogakuServicehiDetailDiv tabKogakuServicehiDetail;
    @JsonProperty("KogakuServicehiDetailEntity")
    private RString KogakuServicehiDetailEntity;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTeikyoYM
     * @return txtTeikyoYM
     */
    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    /*
     * settxtTeikyoYM
     * @param txtTeikyoYM txtTeikyoYM
     */
    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM = txtTeikyoYM;
    }

    /*
     * gettxtJotai
     * @return txtJotai
     */
    @JsonProperty("txtJotai")
    public TextBox getTxtJotai() {
        return txtJotai;
    }

    /*
     * settxtJotai
     * @param txtJotai txtJotai
     */
    @JsonProperty("txtJotai")
    public void setTxtJotai(TextBox txtJotai) {
        this.txtJotai = txtJotai;
    }

    /*
     * gettxtKanriBango
     * @return txtKanriBango
     */
    @JsonProperty("txtKanriBango")
    public TextBoxNum getTxtKanriBango() {
        return txtKanriBango;
    }

    /*
     * settxtKanriBango
     * @param txtKanriBango txtKanriBango
     */
    @JsonProperty("txtKanriBango")
    public void setTxtKanriBango(TextBoxNum txtKanriBango) {
        this.txtKanriBango = txtKanriBango;
    }

    /*
     * gettabKogakuServicehiDetail
     * @return tabKogakuServicehiDetail
     */
    @JsonProperty("tabKogakuServicehiDetail")
    public tabKogakuServicehiDetailDiv getTabKogakuServicehiDetail() {
        return tabKogakuServicehiDetail;
    }

    /*
     * settabKogakuServicehiDetail
     * @param tabKogakuServicehiDetail tabKogakuServicehiDetail
     */
    @JsonProperty("tabKogakuServicehiDetail")
    public void setTabKogakuServicehiDetail(tabKogakuServicehiDetailDiv tabKogakuServicehiDetail) {
        this.tabKogakuServicehiDetail = tabKogakuServicehiDetail;
    }

    /*
     * getKogakuServicehiDetailEntity
     * @return KogakuServicehiDetailEntity
     */
    @JsonProperty("KogakuServicehiDetailEntity")
    public RString getKogakuServicehiDetailEntity() {
        return KogakuServicehiDetailEntity;
    }

    /*
     * setKogakuServicehiDetailEntity
     * @param KogakuServicehiDetailEntity KogakuServicehiDetailEntity
     */
    @JsonProperty("KogakuServicehiDetailEntity")
    public void setKogakuServicehiDetailEntity(RString KogakuServicehiDetailEntity) {
        this.KogakuServicehiDetailEntity = KogakuServicehiDetailEntity;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        tsuika("tsuika"),
        shusei("shusei"),
        sofuzumi("sofuzumi"),
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
    public tplShinseishaDiv getTplShinseisha() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha();
    }

    @JsonIgnore
    public void setTplShinseisha(tplShinseishaDiv tplShinseisha) {
        this.getTabKogakuServicehiDetail().setTplShinseisha(tplShinseisha);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public RadioButton getRdbShinseisyaKubun() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getRdbShinseisyaKubun();
    }

    @JsonIgnore
    public void setRdbShinseisyaKubun(RadioButton rdbShinseisyaKubun) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setRdbShinseisyaKubun(rdbShinseisyaKubun);
    }

    @JsonIgnore
    public TextBoxCode getTxtHokenJyaBango() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtHokenJyaBango();
    }

    @JsonIgnore
    public void setTxtHokenJyaBango(TextBoxCode txtHokenJyaBango) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtHokenJyaBango(txtHokenJyaBango);
    }

    @JsonIgnore
    public CheckBoxList getChkKokuhorenSaiso() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getChkKokuhorenSaiso();
    }

    @JsonIgnore
    public void setChkKokuhorenSaiso(CheckBoxList chkKokuhorenSaiso) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setChkKokuhorenSaiso(chkKokuhorenSaiso);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKanji() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtShimeiKanji();
    }

    @JsonIgnore
    public void setTxtShimeiKanji(TextBox txtShimeiKanji) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtShimeiKanji(txtShimeiKanji);
    }

    @JsonIgnore
    public TextBoxKana getTxtShimeiKana() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtShimeiKana();
    }

    @JsonIgnore
    public void setTxtShimeiKana(TextBoxKana txtShimeiKana) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtShimeiKana(txtShimeiKana);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiTotalAmount() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtShiharaiTotalAmount();
    }

    @JsonIgnore
    public void setTxtShiharaiTotalAmount(TextBoxNum txtShiharaiTotalAmount) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtShiharaiTotalAmount(txtShiharaiTotalAmount);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKotei() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtKotei();
    }

    @JsonIgnore
    public void setTxtKotei(TextBoxMultiLine txtKotei) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtKotei(txtKotei);
    }

    @JsonIgnore
    public tplKozaDiv getTplKoza() {
        return this.getTabKogakuServicehiDetail().getTplKoza();
    }

    @JsonIgnore
    public void setTplKoza(tplKozaDiv tplKoza) {
        this.getTabKogakuServicehiDetail().setTplKoza(tplKoza);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJyoho() {
        return this.getTabKogakuServicehiDetail().getTplKoza().getCcdShiharaiHohoJyoho();
    }

    @JsonIgnore
    public tplJudgementResultDiv getTplJudgementResult() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult();
    }

    @JsonIgnore
    public void setTplJudgementResult(tplJudgementResultDiv tplJudgementResult) {
        this.getTabKogakuServicehiDetail().setTplJudgementResult(tplJudgementResult);
    }

    @JsonIgnore
    public IKogakuKyufuTaishoListDiv getCcdKogakuKyufuTaishoList() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getCcdKogakuKyufuTaishoList();
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeYMD() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getTxtUketsukeYMD();
    }

    @JsonIgnore
    public void setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.getTabKogakuServicehiDetail().getTplJudgementResult().setTxtUketsukeYMD(txtUketsukeYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtHonninShiharaiGaku() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getTxtHonninShiharaiGaku();
    }

    @JsonIgnore
    public void setTxtHonninShiharaiGaku(TextBoxNum txtHonninShiharaiGaku) {
        this.getTabKogakuServicehiDetail().getTplJudgementResult().setTxtHonninShiharaiGaku(txtHonninShiharaiGaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getTabKogakuServicehiDetail().getTplJudgementResult().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public RadioButton getRdbShikyuKubun() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getRdbShikyuKubun();
    }

    @JsonIgnore
    public void setRdbShikyuKubun(RadioButton rdbShikyuKubun) {
        this.getTabKogakuServicehiDetail().getTplJudgementResult().setRdbShikyuKubun(rdbShikyuKubun);
    }

    @JsonIgnore
    public RadioButton getRdbShinsaHohoKubun() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getRdbShinsaHohoKubun();
    }

    @JsonIgnore
    public void setRdbShinsaHohoKubun(RadioButton rdbShinsaHohoKubun) {
        this.getTabKogakuServicehiDetail().getTplJudgementResult().setRdbShinsaHohoKubun(rdbShinsaHohoKubun);
    }

    @JsonIgnore
    public TextBox getTxtSetaiSyuyakuBango() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getTxtSetaiSyuyakuBango();
    }

    @JsonIgnore
    public void setTxtSetaiSyuyakuBango(TextBox txtSetaiSyuyakuBango) {
        this.getTabKogakuServicehiDetail().getTplJudgementResult().setTxtSetaiSyuyakuBango(txtSetaiSyuyakuBango);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuKingaku() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getTxtShikyuKingaku();
    }

    @JsonIgnore
    public void setTxtShikyuKingaku(TextBoxNum txtShikyuKingaku) {
        this.getTabKogakuServicehiDetail().getTplJudgementResult().setTxtShikyuKingaku(txtShikyuKingaku);
    }

    @JsonIgnore
    public RadioButton getRdbKogakuJidoSyokanTaisyo() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getRdbKogakuJidoSyokanTaisyo();
    }

    @JsonIgnore
    public void setRdbKogakuJidoSyokanTaisyo(RadioButton rdbKogakuJidoSyokanTaisyo) {
        this.getTabKogakuServicehiDetail().getTplJudgementResult().setRdbKogakuJidoSyokanTaisyo(rdbKogakuJidoSyokanTaisyo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShikyusinaiRiyu() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getTxtShikyusinaiRiyu();
    }

    @JsonIgnore
    public void setTxtShikyusinaiRiyu(TextBoxMultiLine txtShikyusinaiRiyu) {
        this.getTabKogakuServicehiDetail().getTplJudgementResult().setTxtShikyusinaiRiyu(txtShikyusinaiRiyu);
    }

    @JsonIgnore
    public tplKetteiJohoDiv getTplKetteiJoho() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho();
    }

    @JsonIgnore
    public void setTplKetteiJoho(tplKetteiJohoDiv tplKetteiJoho) {
        this.getTabKogakuServicehiDetail().setTplKetteiJoho(tplKetteiJoho);
    }

    @JsonIgnore
    public KokuhorenKetteiJohoPanel1Div getKokuhorenKetteiJohoPanel1() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1();
    }

    @JsonIgnore
    public void setKokuhorenKetteiJohoPanel1(KokuhorenKetteiJohoPanel1Div KokuhorenKetteiJohoPanel1) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().setKokuhorenKetteiJohoPanel1(KokuhorenKetteiJohoPanel1);
    }

    @JsonIgnore
    public TextBoxCode getTxtTsuchiBango() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtTsuchiBango();
    }

    @JsonIgnore
    public void setTxtTsuchiBango(TextBoxCode txtTsuchiBango) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtTsuchiBango(txtTsuchiBango);
    }

    @JsonIgnore
    public TextBox getTxtShikyuKubun() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtShikyuKubun();
    }

    @JsonIgnore
    public void setTxtShikyuKubun(TextBox txtShikyuKubun) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtShikyuKubun(txtShikyuKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYM() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtKetteiYM();
    }

    @JsonIgnore
    public void setTxtKetteiYM(TextBoxDate txtKetteiYM) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtKetteiYM(txtKetteiYM);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiKingakuGokei() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtShiharaiKingakuGokei();
    }

    @JsonIgnore
    public void setTxtShiharaiKingakuGokei(TextBoxNum txtShiharaiKingakuGokei) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtShiharaiKingakuGokei(txtShiharaiKingakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtKogakuShikyuGaku() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtKogakuShikyuGaku();
    }

    @JsonIgnore
    public void setTxtKogakuShikyuGaku(TextBoxNum txtKogakuShikyuGaku) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtKogakuShikyuGaku(txtKogakuShikyuGaku);
    }

    @JsonIgnore
    public SakuseiPanelDiv getSakuseiPanel() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getSakuseiPanel();
    }

    @JsonIgnore
    public void setSakuseiPanel(SakuseiPanelDiv SakuseiPanel) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().setSakuseiPanel(SakuseiPanel);
    }

    @JsonIgnore
    public KokuhorenKetteiJohoPanel2Div getKokuhorenKetteiJohoPanel2() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getSakuseiPanel().getKokuhorenKetteiJohoPanel2();
    }

    @JsonIgnore
    public void setKokuhorenKetteiJohoPanel2(KokuhorenKetteiJohoPanel2Div KokuhorenKetteiJohoPanel2) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getSakuseiPanel().setKokuhorenKetteiJohoPanel2(KokuhorenKetteiJohoPanel2);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD1() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getSakuseiPanel().getKokuhorenKetteiJohoPanel2().getTxtSakuseiYMD1();
    }

    @JsonIgnore
    public void setTxtSakuseiYMD1(TextBoxDate txtSakuseiYMD1) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getSakuseiPanel().getKokuhorenKetteiJohoPanel2().setTxtSakuseiYMD1(txtSakuseiYMD1);
    }

    @JsonIgnore
    public FurikomiMeisaiJohoPanelDiv getFurikomiMeisaiJohoPanel() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getSakuseiPanel().getFurikomiMeisaiJohoPanel();
    }

    @JsonIgnore
    public void setFurikomiMeisaiJohoPanel(FurikomiMeisaiJohoPanelDiv FurikomiMeisaiJohoPanel) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getSakuseiPanel().setFurikomiMeisaiJohoPanel(FurikomiMeisaiJohoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD2() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getSakuseiPanel().getFurikomiMeisaiJohoPanel().getTxtSakuseiYMD2();
    }

    @JsonIgnore
    public void setTxtSakuseiYMD2(TextBoxDate txtSakuseiYMD2) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getSakuseiPanel().getFurikomiMeisaiJohoPanel().setTxtSakuseiYMD2(txtSakuseiYMD2);
    }

    @JsonIgnore
    public KokuhorenSoufuJohoPanelDiv getKokuhorenSoufuJohoPanel() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenSoufuJohoPanel();
    }

    @JsonIgnore
    public void setKokuhorenSoufuJohoPanel(KokuhorenSoufuJohoPanelDiv KokuhorenSoufuJohoPanel) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().setKokuhorenSoufuJohoPanel(KokuhorenSoufuJohoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaisyoUketoriYM() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenSoufuJohoPanel().getTxtTaisyoUketoriYM();
    }

    @JsonIgnore
    public void setTxtTaisyoUketoriYM(TextBoxDate txtTaisyoUketoriYM) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenSoufuJohoPanel().setTxtTaisyoUketoriYM(txtTaisyoUketoriYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKekkaSoufuYM() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenSoufuJohoPanel().getTxtKekkaSoufuYM();
    }

    @JsonIgnore
    public void setTxtKekkaSoufuYM(TextBoxDate txtKekkaSoufuYM) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenSoufuJohoPanel().setTxtKekkaSoufuYM(txtKekkaSoufuYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiSyaUketoriYM() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenSoufuJohoPanel().getTxtKetteiSyaUketoriYM();
    }

    @JsonIgnore
    public void setTxtKetteiSyaUketoriYM(TextBoxDate txtKetteiSyaUketoriYM) {
        this.getTabKogakuServicehiDetail().getTplKetteiJoho().getKokuhorenSoufuJohoPanel().setTxtKetteiSyaUketoriYM(txtKetteiSyaUketoriYM);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 画面初期化です。
     *
     * @param 画面モード RString
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @param 履歴番号 int
     * @param 識別コード ShikibetsuCode
     */
    @Override
    public void initialize(RString 画面モード, RString メニューID, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号, int 履歴番号, ShikibetsuCode 識別コード) {
        KogakuServicehiDetailDivHandler.of(this).画面初期化(
                画面モード, メニューID, 被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 識別コード);
    }

    /**
     * 受付日と決定日のチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    @Override
    public ValidationMessageControlPairs check受付日と決定日() {
        ValidationMessageControlPairs validPairs = KogakuServicehiDetailDivValidationHandler.
                of(this).受付日と決定日のチェック();
        return validPairs;
    }

    /**
     * 画面初期化データします。
     *
     * @return KougakuSabisuhiShousaiNaiyouResult
     */
    @Override
    public KougakuSabisuhiShousaiNaiyouResult get画面初期化データ() {
        return KogakuServicehiDetailDivHandler.of(this).get画面初期化データ();
    }

    /**
     * 申請日を取得します。
     *
     * @return RDate
     */
    @Override
    public RDate get申請日() {
        return KogakuServicehiDetailDivHandler.of(this).get申請日();
    }

    /**
     * 申請者区分を取得します。
     *
     * @return RString
     */
    @Override
    public RString get申請者区分() {
        return KogakuServicehiDetailDivHandler.of(this).get申請者区分();
    }

    /**
     * 申請者区分を取得します。
     *
     * @return HokenshaNo
     */
    @Override
    public RString get証記載保険者番号() {
        return KogakuServicehiDetailDivHandler.of(this).get証記載保険者番号();
    }

    /**
     * 国保連再送を取得します。
     *
     * @return boolean
     */
    @Override
    public boolean is国保連再送() {
        return KogakuServicehiDetailDivHandler.of(this).is国保連再送();
    }

    /**
     * 氏名_漢字を取得します。
     *
     * @return RString
     */
    @Override
    public RString get氏名_漢字() {
        return KogakuServicehiDetailDivHandler.of(this).get氏名_漢字();
    }

    /**
     * 氏名_カナを取得します。
     *
     * @return RString
     */
    @Override
    public RString get氏名_カナ() {
        return KogakuServicehiDetailDivHandler.of(this).get氏名_カナ();
    }

    /**
     * 電話番号を取得します。
     *
     * @return RString
     */
    @Override
    public RString get電話番号() {
        return KogakuServicehiDetailDivHandler.of(this).get電話番号();
    }

    /**
     * 申請理由を取得します。
     *
     * @return RString
     */
    @Override
    public RString get申請理由() {
        return KogakuServicehiDetailDivHandler.of(this).get申請理由();
    }

    /**
     * 支払金額合計を取得します。
     *
     * @return RString
     */
    @Override
    public Decimal get支払金額合計() {
        return KogakuServicehiDetailDivHandler.of(this).get支払金額合計();
    }

    /**
     * 受付日を取得します。
     *
     * @return RDate
     */
    @Override
    public RDate get受付日() {
        return KogakuServicehiDetailDivHandler.of(this).get受付日();
    }

    /**
     * 本人支払額を取得します。
     *
     * @return Decimal
     */
    @Override
    public Decimal get本人支払額() {
        return KogakuServicehiDetailDivHandler.of(this).get本人支払額();
    }

    /**
     * 決定日を取得します。
     *
     * @return RDate
     */
    @Override
    public RDate get決定日() {
        return KogakuServicehiDetailDivHandler.of(this).get決定日();
    }

    /**
     * 支給区分を取得します。
     *
     * @return RString
     */
    @Override
    public RString get支給区分() {
        return KogakuServicehiDetailDivHandler.of(this).get支給区分();
    }

    /**
     * 審査方法区分を取得します。
     *
     * @return RString
     */
    @Override
    public RString get審査方法区分() {
        return KogakuServicehiDetailDivHandler.of(this).get審査方法区分();
    }

    /**
     * 世帯集約番号を取得します。
     *
     * @return RString
     */
    @Override
    public RString get世帯集約番号() {
        return KogakuServicehiDetailDivHandler.of(this).get世帯集約番号();
    }

    /**
     * 支給金額を取得します。
     *
     * @return Decimal
     */
    @Override
    public Decimal get支給金額() {
        return KogakuServicehiDetailDivHandler.of(this).get支給金額();
    }

    /**
     * 高額自動償還を取得します。
     *
     * @return RString
     */
    @Override
    public RString get高額自動償還() {
        return KogakuServicehiDetailDivHandler.of(this).get高額自動償還();
    }

    /**
     * 支給しない理由を取得します。
     *
     * @return RString
     */
    @Override
    public RString get支給しない理由() {
        return KogakuServicehiDetailDivHandler.of(this).get支給しない理由();
    }
}
