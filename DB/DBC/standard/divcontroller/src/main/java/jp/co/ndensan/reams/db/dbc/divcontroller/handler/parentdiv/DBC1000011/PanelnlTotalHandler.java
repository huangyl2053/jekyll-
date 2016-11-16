/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC030010.DBC030010_ShokanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shoukanbaraisuuchishoikkatsusakusei.ShoukanBaraiSuuchiShoIkatsuParamter;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufubunruikubun.ShiharaiHohoKinoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000011.PanelnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.service.report.shoukanbaraisuuchishoikkatsusakusei.ShokanbaraiShikyuFushikyuKetteiTsuchishoIkkatsuSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い支給（不支給）決定通知書一括作成Handlerクラスです。
 *
 * @reamsid_L DBC-1000-010 zhangzhiming
 */
public class PanelnlTotalHandler {

    private final PanelnlTotalDiv div;
    private static final RString キー = new RString("key0");
    private static final RString キー_1 = new RString("key1");
    private static final RString キー_2 = new RString("key2");
    private static final RString 受託区分_2 = new RString("2");
    private static final RString 抽出条件_1 = new RString("1");
    private static final RString 抽出条件_2 = new RString("2");
    private static final RString 抽出条件_3 = new RString("3");
    private static final RString フラグ_FALSE = new RString("false");
    private static final RString フラグ_TRUE = new RString("true");
    private static final RString 利用者向け決定通知書 = new RString("ForRiyosha");
    private static final RString 受領委任者向け決定通知書 = new RString("ForJuryoininsha");

    /**
     * コンストラクタです。
     *
     * @param div 償還払い支給（不支給）決定通知書一括作成
     */
    public PanelnlTotalHandler(PanelnlTotalDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param shori 前回対象日
     * @param chohyo 帳票分類ID
     */
    public void onLoad(ShoriDateKanri shori, ChohyoBunruiKanri chohyo) {
        if (shori != null && shori.get対象開始年月日() != null && !shori.get対象開始年月日().isEmpty()) {
            div.getTxtZenkaiTaishobi().setFromValue(new RDate(shori.get対象開始年月日().toString()));
        }
        if (shori != null && shori.get対象終了年月日() != null && !shori.get対象終了年月日().isEmpty()) {
            div.getTxtZenkaiTaishobi().setToValue(new RDate(shori.get対象終了年月日().toString()));
            div.getTxtUketsukebi().setFromValue(new RDate(shori.get対象終了年月日().toString())
                    .plusDay(1));
            div.getTxtKeteibiJoken().setFromValue(new RDate(shori.get対象終了年月日().toString())
                    .plusDay(1));
        }
        div.getTxtZenkaiTaishobi().setReadOnly(true);
        div.getRadUketsukebi().setSelectedKey(キー);
        div.getTxtUketsukebi().setToValue(RDate.getNowDate());
        div.getTxtKeteibiJoken().setToValue(RDate.getNowDate());
        if (抽出条件_1.equals(DbBusinessConfig.get(ConfigNameDBC.償還払支給不支給決定通知書一括作成_初期選択抽出条件, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付))) {
            div.getRadUketsukebi().setSelectedKey(キー);
            div.getTxtUketsukebi().setDisabled(false);
            if (div.getTxtUketsukebi().getFromValue() != null
                    && div.getTxtUketsukebi().getToValue().isBefore(div.getTxtUketsukebi().getFromValue())) {
                div.getTxtUketsukebi().setFromValue(div.getTxtUketsukebi().getToValue());
            }
            div.getTxtKeteibiJoken().setDisabled(true);
            div.getTxtKeteibiJoken().clearFromValue();
            div.getTxtKeteibiJoken().clearToValue();
            div.getTxtKeteishaUketsukeYM().setDisabled(true);
        }
        if (抽出条件_2.equals(DbBusinessConfig.get(ConfigNameDBC.償還払支給不支給決定通知書一括作成_初期選択抽出条件, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付))) {
            div.getRadKetteibi().setSelectedKey(キー);
            div.getTxtKeteibiJoken().setDisabled(false);
            if (div.getTxtKeteibiJoken().getFromValue() != null
                    && div.getTxtKeteibiJoken().getToValue().isBefore(div.getTxtKeteibiJoken().getFromValue())) {
                div.getTxtKeteibiJoken().setFromValue(div.getTxtKeteibiJoken().getToValue());
            }
            div.getTxtUketsukebi().setDisabled(true);
            div.getTxtUketsukebi().clearFromValue();
            div.getTxtUketsukebi().clearToValue();
            div.getTxtKeteishaUketsukeYM().setDisabled(true);
        }
        if (抽出条件_3.equals(DbBusinessConfig.get(ConfigNameDBC.償還払支給不支給決定通知書一括作成_初期選択抽出条件, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付))) {
            div.getRadKetteishaUketsukeYM().setSelectedKey(キー);
            div.getTxtKeteishaUketsukeYM().setDisabled(false);
            div.getTxtUketsukebi().setDisabled(true);
            div.getTxtKeteibiJoken().setDisabled(true);
            div.getTxtUketsukebi().clearFromValue();
            div.getTxtUketsukebi().clearToValue();
            div.getTxtKeteibiJoken().clearFromValue();
            div.getTxtKeteibiJoken().clearToValue();
        }
        if (受託区分_2.equals(DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付))) {
            div.getTxtKeteishaUketsukeYM().setDomain(RDate.getNowDate().getYearMonth());
            div.getTxtKeteishaUketsukeYM().setDisplayNone(false);
            div.getRadKetteishaUketsukeYM().setDisplayNone(false);
        } else {
            div.getTxtKeteishaUketsukeYM().setDisplayNone(true);
            div.getRadKetteishaUketsukeYM().setDisplayNone(true);
        }
        div.getRadInnsho().setSelectedKey(キー);
        div.getPnlShokanbaraiShikyuKeteiTuchisho().getTxtHakkobi().setValue(RDate.getNowDate());
        div.getPnlTestOutput().getRadKeteibiIkatsuKoushinnKubun().setSelectedKey(キー);
        div.getPnlTestOutput().getTxtKeteibiTuchisho().setDisplayNone(true);
        div.getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().initialize(ShiharaiHohoKinoKubun.償還払.getコード());
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, chohyo.get帳票分類ID());
    }

    /**
     * 決定日一括更新区分を処理します。
     *
     */
    public void onChange_koushin() {
        if (キー.equals(div.getPnlShokanbaraiShikyuKeteiTuchisho().getRadKeteibiIkatsuKoushinnKubun().getSelectedKey())) {
            div.getPnlShokanbaraiShikyuKeteiTuchisho().getTxtKeteibiTuchisho().setDisplayNone(true);
        } else {
            div.getPnlShokanbaraiShikyuKeteiTuchisho().getTxtKeteibiTuchisho().setDisplayNone(false);
            div.getPnlShokanbaraiShikyuKeteiTuchisho().getTxtKeteibiTuchisho().setReadOnly(false);
        }
    }

    /**
     * 決定者受付年月を処理します。
     *
     * @param shori 前回対象日
     */
    public void onClick_KetteishaUketsukeYM(ShoriDateKanri shori) {
        if (キー.equals(div.getRadKetteishaUketsukeYM().getSelectedKey())) {
            div.getTxtUketsukebi().setDisabled(true);
            div.getTxtKeteibiJoken().setDisabled(true);
            div.getTxtUketsukebi().clearFromValue();
            div.getTxtUketsukebi().clearToValue();
            div.getTxtKeteibiJoken().clearFromValue();
            div.getTxtKeteibiJoken().clearToValue();
            div.getTxtKeteishaUketsukeYM().setDisabled(false);
            div.getRadKetteishaUketsukeYM().setDisabled(false);
            if (shori != null && shori.get対象開始年月日() != null && !shori.get対象開始年月日().isEmpty()) {
                div.getTxtZenkaiTaishobi().setFromValue(new RDate(shori.get対象開始年月日().toString()));
            }
            if (shori != null && shori.get対象終了年月日() != null && !shori.get対象終了年月日().isEmpty()) {
                div.getTxtZenkaiTaishobi().setToValue(new RDate(shori.get対象終了年月日().toString()));
            }
        }
    }

    /**
     * 決定日を処理します。
     *
     * @param shori 前回対象日
     */
    public void onClick_ketteibi(ShoriDateKanri shori) {
        if (キー.equals(div.getRadKetteibi().getSelectedKey())) {
            div.getTxtUketsukebi().setDisabled(true);
            div.getTxtUketsukebi().clearFromValue();
            div.getTxtUketsukebi().clearToValue();
            div.getTxtKeteishaUketsukeYM().setDisabled(true);
            div.getTxtKeteibiJoken().setDisabled(false);
            div.getRadKetteishaUketsukeYM().setDisabled(false);
            div.getTxtKeteibiJoken().setToValue(RDate.getNowDate());
            if (shori != null && shori.get対象開始年月日() != null && !shori.get対象開始年月日().isEmpty()) {
                div.getTxtZenkaiTaishobi().setFromValue(new RDate(shori.get対象開始年月日().toString()));
            }
            if (shori != null && shori.get対象終了年月日() != null && !shori.get対象終了年月日().isEmpty()) {
                div.getTxtZenkaiTaishobi().setToValue(new RDate(shori.get対象終了年月日().toString()));
                div.getTxtKeteibiJoken().setFromValue(new RDate(shori.get対象終了年月日().toString())
                        .plusDay(1));
            }
            if (div.getTxtKeteibiJoken().getFromValue() != null
                    && div.getTxtKeteibiJoken().getToValue().isBefore(div.getTxtKeteibiJoken().getFromValue())) {
                div.getTxtKeteibiJoken().setFromValue(div.getTxtKeteibiJoken().getToValue());
            }
        }
    }

    /**
     * 受付日を処理します。
     *
     * @param shori 前回対象日
     */
    public void onClick_uketsukebi(ShoriDateKanri shori) {
        if (キー.equals(div.getRadUketsukebi().getSelectedKey())) {
            div.getTxtUketsukebi().setDisabled(false);
            div.getTxtKeteibiJoken().setDisabled(true);
            div.getTxtKeteibiJoken().clearFromValue();
            div.getTxtKeteibiJoken().clearToValue();
            div.getTxtKeteishaUketsukeYM().setDisabled(true);
            div.getRadKetteishaUketsukeYM().setDisabled(false);
            div.getTxtUketsukebi().setToValue(RDate.getNowDate());
            if (shori != null && shori.get対象開始年月日() != null && !shori.get対象開始年月日().isEmpty()) {
                div.getTxtZenkaiTaishobi().setFromValue(new RDate(shori.get対象開始年月日().toString()));
            }
            if (shori != null && shori.get対象終了年月日() != null && !shori.get対象終了年月日().isEmpty()) {
                div.getTxtZenkaiTaishobi().setToValue(new RDate(shori.get対象終了年月日().toString()));
                div.getTxtUketsukebi().setFromValue(new RDate(shori.get対象終了年月日().toString())
                        .plusDay(1));
            }
            if (div.getTxtUketsukebi().getFromValue() != null
                    && div.getTxtUketsukebi().getToValue().isBefore(div.getTxtUketsukebi().getFromValue())) {
                div.getTxtUketsukebi().setFromValue(div.getTxtUketsukebi().getToValue());
            }
        }
    }

    /**
     * バッチパラメータを引き渡し、バッチを起動します。
     *
     * @return ShoukanBaraiSuuchiShoIkatsuBatchParamter
     */
    public DBC030010_ShokanShikyuKetteiTsuchishoParameter onClick_btnJikouBatch() {
        ShokanbaraiShikyuFushikyuKetteiTsuchishoIkkatsuSakusei shokanbarai = new ShokanbaraiShikyuFushikyuKetteiTsuchishoIkkatsuSakusei();
        ShoukanBaraiSuuchiShoIkatsuParamter paramter = new ShoukanBaraiSuuchiShoIkatsuParamter();
        if (キー.equals(div.getRadUketsukebi().getSelectedKey())) {
            paramter.set抽出モード(抽出条件_1);
        }
        if (キー.equals(div.getRadKetteibi().getSelectedKey())) {
            paramter.set抽出モード(抽出条件_2);
        }
        if (キー.equals(div.getRadKetteishaUketsukeYM().getSelectedKey())) {
            paramter.set抽出モード(抽出条件_3);
        }
        paramter.set受付日付From(div.getTxtUketsukebi().getFromValue());
        paramter.set受付日付To(div.getTxtUketsukebi().getToValue());
        paramter.set決定日付From(div.getTxtKeteibiJoken().getFromValue());
        paramter.set決定日付To(div.getTxtKeteibiJoken().getToValue());
        paramter.set決定者受付年月(div.getTxtKeteishaUketsukeYM().getDomain());
        if (キー.equals(div.getRadInnsho().getSelectedKey())) {
            paramter.set印書(抽出条件_1);
        }
        if (キー_1.equals(div.getRadInnsho().getSelectedKey())) {
            paramter.set印書(抽出条件_2);
        }
        if (キー_2.equals(div.getRadInnsho().getSelectedKey())) {
            paramter.set印書(抽出条件_3);
        }
        paramter.set発行日(div.getPnlShokanbaraiShikyuKeteiTuchisho().getTxtHakkobi().getValue());
        paramter.set文書番号(div.getBunshoBangoInput().get文書番号());
        if (div.getPnlShokanbaraiShikyuKeteiTuchisho().getChkTestShutsuryoku().getSelectedKeys().isEmpty()) {
            paramter.setテスト出力フラグ(フラグ_FALSE);
        } else {
            paramter.setテスト出力フラグ(フラグ_TRUE);
        }
        if (キー.equals(div.getPnlTestOutput().getRadKeteibiIkatsuKoushinnKubun().getSelectedKey())) {
            paramter.set決定日一括更新区分(抽出条件_1);
        }
        if (キー_1.equals(div.getPnlTestOutput().getRadKeteibiIkatsuKoushinnKubun().getSelectedKey())) {
            paramter.set決定日一括更新区分(抽出条件_2);
        }
        paramter.set決定日(div.getPnlTestOutput().getTxtKeteibiTuchisho().getValue());
        if (div.getPnlShokanbaraiShikyuKeteiTuchisho().getChkOutputTargetKubun().getSelectedKeys().contains(利用者向け決定通知書)) {
            paramter.set利用者向け決定通知書フラグ(フラグ_TRUE);
        } else {
            paramter.set利用者向け決定通知書フラグ(フラグ_FALSE);
        }
        if (div.getPnlShokanbaraiShikyuKeteiTuchisho().getChkOutputTargetKubun().getSelectedKeys().contains(受領委任者向け決定通知書)) {
            paramter.set受領委任者向け決定通知書フラグ(フラグ_TRUE);
        } else {
            paramter.set受領委任者向け決定通知書フラグ(フラグ_FALSE);
        }
        paramter.set振込予定日(div.getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().get振込予定日());
        paramter.set支払場所(div.getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().get支払場所());
        paramter.set支払期間From(div.getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().get支払期間FROM());
        paramter.set支払期間To(div.getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().get支払期間TO());
        paramter.set開始時間(div.getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().get開始時間());
        paramter.set終了時間(div.getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().get終了時間());
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() != null) {
            paramter.set出力順ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID()));
        } else {
            paramter.set出力順ID(RString.EMPTY);
        }
        paramter.set窓口払い一括更新区分(div.getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().get窓口払い一括更新区分());
        return shokanbarai.getShokanbaraiShikyuFushikyuKetteiTsuchishoBatchParameter(paramter);
    }

    /**
     * 実行するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        return createValidationHandler(div).validateCheck();
    }

    private PanelnlTotalValidationHandler createValidationHandler(PanelnlTotalDiv div) {
        return new PanelnlTotalValidationHandler(div);
    }
}
