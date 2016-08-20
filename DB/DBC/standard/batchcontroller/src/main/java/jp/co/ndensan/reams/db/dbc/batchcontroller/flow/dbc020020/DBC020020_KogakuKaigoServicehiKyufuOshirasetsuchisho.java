/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc020020;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.HihokenshaDaichoForShinseiJyohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.HihokenshaDaichoForShinseiShokanProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.JidoShokanJutakuAriDataDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.JidoShokanJutakuNaiDataDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.JigyoKogakuServiceHiOshiraseTsuchishoKigenAriOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.JigyoKogakuServiceHiOshiraseTsuchishoKigenNaiOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.JigyoKogakuServiceShikyuShinseishoOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.JigyoKogakuShinseiKanriForShinseiJyohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.JigyoKogakuShinseiKanriForShinseiShokanProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.JigyoKogakuShinseikanriMasterUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.JigyoShinseishoHakoIchiranhyoOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.KogakuServiceHiOshiraseTsuchishoKigenNashiOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.KogakuServiceHiOshiraseTsuchishoKikanAriOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.KogakuServiceShikyuShinseishoOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.KogakuShinseiKanriForShinseiJyohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.KogakuShinseiKanriForShinseiShokanProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.KogakuShinseikanriMasterUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.ShiboushaDataDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.ShinseiJohoChohyoTempTableInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.ShinseishoHakoIchiranhyoOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.ShokanJyohoForShinseiJyohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020.ShoriTaishogaiDataDeleteProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020020.DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shunyugaku.ShutsuryokuJoken;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 高額サービス費給付お知らせ通知書作成のバッチフロークラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchisho
        extends BatchFlowBase<DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter> {

    private static final RString ONE = new RString("1");
    private static final RString 高額介護サービス費 = new RString("DBCMN43001");
    private static final FlexibleYearMonth 制度改正施行日 = new FlexibleYearMonth("200510");
    private static final String KOGAKU_MASTER_SHINSEI = "kogaku_master_shinsei";
    private static final String JIGYO_MASTER_SHINSEI = "jigyo_master_shinsei";
    private static final String HIHOKENSHADAICHO_SHINSEI = "hihokenshadaicho_shinsei";
    private static final String KOGAKU_MASTER_SHOKAN = "kogaku_master_shokan";
    private static final String JIGYO_MASTER_SHOKAN = "jigyo_master_shokan";
    private static final String TAISHOGAI = "taishogai";
    private static final String JUTAKUARI = "jutakuari";
    private static final String JUTAKUNAI = "jutakunai";
    private static final String HIHOKENSHADAICHO_SHOKAN = "hihokenshadaicho_shokan";
    private static final String SHIBOUSHA = "shibousha";
    private static final String SHOKAN_SHINSEI = "shokan_shinsei";
    private static final String CHOHYO = "chohyo";
    private static final String ICHIRANHYO = "ichiranhyo";
    private static final String JIGYO_ICHIRANHYO = "jigyo_ichiranhyo";
    private static final String KOGAKU_SHINSEISHO = "kogaku_shinseisho";
    private static final String KOGAKU_TSUCHISHO_KIGENNAI = "kogaku_tsuchisho_kigennai";
    private static final String KOGAKU_TSUCHISHO_KIGENARI = "kogaku_tsuchisho_kigenari";
    private static final String KOGAKU_UPDATE = "kogaku_update";
    private static final String JIGYO_SHINSEISHO = "jigyo_shinseisho";
    private static final String JIGYO_TSUCHISHO_KIGENNAI = "jigyo_tsuchisho_kigennai";
    private static final String JIGYO_TSUCHISHO_KIGENARI = "jigyo_tsuchisho_kigenari";
    private static final String JIGYO_UPDATE = "jigyo_update";
    private static final RString 死亡者制御_0 = new RString("0");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        createParameter();
        if (高額介護サービス費.equals(processParameter.getMenuId())) {
            executeStep(KOGAKU_MASTER_SHINSEI);
            executeStep(HIHOKENSHADAICHO_SHINSEI);
            if (isShokanExcute()) {
                executeStep(KOGAKU_MASTER_SHOKAN);
            }
        } else {
            executeStep(JIGYO_MASTER_SHINSEI);
            executeStep(HIHOKENSHADAICHO_SHINSEI);
            if (isShokanExcute()) {
                executeStep(JIGYO_MASTER_SHOKAN);
            }
        }
        // TODO QA.1223 該当処理不要？
        //executeStep(TAISHOGAI);
        if (processParameter.isJutakuAri()) {
            executeStep(JUTAKUARI);
        } else {
            executeStep(JUTAKUNAI);
        }
        executeStep(HIHOKENSHADAICHO_SHOKAN);

        RString 死亡者制御 = BusinessConfig.get(ConfigNameDBC.高額自動償還_死亡者制御, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (死亡者制御_0.equals(死亡者制御)) {
            executeStep(SHIBOUSHA);
        }

        executeStep(SHOKAN_SHINSEI);
        executeStep(CHOHYO);

        if (高額介護サービス費.equals(processParameter.getMenuId())) {
            executeStep(ICHIRANHYO);
            if (getParameter().isShinseishoHakko()) {
                executeStep(KOGAKU_SHINSEISHO);
            }
            excuteShinseisho();
            if (ShutsuryokuJoken.審査年月 == getParameter().getChushutsuJoken()) {
                executeStep(KOGAKU_UPDATE);
            }
        } else {
            executeStep(JIGYO_ICHIRANHYO);
            if (getParameter().isShinseishoHakko()) {
                executeStep(JIGYO_SHINSEISHO);
            }
            excuteOshirase();
            if (ShutsuryokuJoken.審査年月 == getParameter().getChushutsuJoken()) {
                executeStep(JIGYO_UPDATE);
            }
        }
    }

    private void excuteShinseisho() {
        if (getParameter().isOshiraseTsuchishoHakko()) {
            if (getParameter().getShinseishoTeishutsuKigen() == null || getParameter().getShinseishoTeishutsuKigen().isEmpty()) {
                executeStep(KOGAKU_TSUCHISHO_KIGENNAI);
            } else {
                executeStep(KOGAKU_TSUCHISHO_KIGENARI);
            }
        }
    }

    private boolean isShokanExcute() {
        return ShutsuryokuJoken.審査年月 == getParameter().getChushutsuJoken() && 制度改正施行日.isBefore(getParameter().getShoriYm());
    }

    private void excuteOshirase() {
        if (getParameter().isOshiraseTsuchishoHakko()) {
            if (getParameter().getShinseishoTeishutsuKigen() == null || getParameter().getShinseishoTeishutsuKigen().isEmpty()) {
                executeStep(JIGYO_TSUCHISHO_KIGENNAI);
            } else {
                executeStep(JIGYO_TSUCHISHO_KIGENARI);
            }
        }
    }

    @Step(KOGAKU_MASTER_SHINSEI)
    IBatchFlowCommand executeKogakuMasterShinsei() {
        return loopBatch(KogakuShinseiKanriForShinseiJyohoProcess.class).arguments(processParameter).define();
    }

    @Step(JIGYO_MASTER_SHINSEI)
    IBatchFlowCommand executeJigyoMasterShinsei() {
        return loopBatch(JigyoKogakuShinseiKanriForShinseiJyohoProcess.class).arguments(processParameter).define();
    }

    @Step(HIHOKENSHADAICHO_SHINSEI)
    IBatchFlowCommand executeHihokenshadaichoShinsei() {
        return loopBatch(HihokenshaDaichoForShinseiJyohoProcess.class).arguments(processParameter).define();
    }

    @Step(KOGAKU_MASTER_SHOKAN)
    IBatchFlowCommand executeKogakuMasterShokan() {
        return loopBatch(KogakuShinseiKanriForShinseiShokanProcess.class).arguments(processParameter).define();
    }

    @Step(JIGYO_MASTER_SHOKAN)
    IBatchFlowCommand executeJigyoMasterShokan() {
        return loopBatch(JigyoKogakuShinseiKanriForShinseiShokanProcess.class).arguments(processParameter).define();
    }

    @Step(TAISHOGAI)
    IBatchFlowCommand executeTaishogai() {
        return loopBatch(ShoriTaishogaiDataDeleteProcess.class).arguments(processParameter).define();
    }

    @Step(JUTAKUARI)
    IBatchFlowCommand executeJutakuAri() {
        return loopBatch(JidoShokanJutakuAriDataDeleteProcess.class).arguments(processParameter).define();
    }

    @Step(JUTAKUNAI)
    IBatchFlowCommand executeJutakuNai() {
        return loopBatch(JidoShokanJutakuNaiDataDeleteProcess.class).arguments(processParameter).define();
    }

    @Step(HIHOKENSHADAICHO_SHOKAN)
    IBatchFlowCommand executeHihokenshadaichoShokan() {
        return loopBatch(HihokenshaDaichoForShinseiShokanProcess.class).arguments(processParameter).define();
    }

    @Step(SHIBOUSHA)
    IBatchFlowCommand executeShibousha() {
        return loopBatch(ShiboushaDataDeleteProcess.class).arguments(processParameter).define();
    }

    @Step(SHOKAN_SHINSEI)
    IBatchFlowCommand executeShokanShinsei() {
        return loopBatch(ShokanJyohoForShinseiJyohoProcess.class).arguments(processParameter).define();
    }

    @Step(CHOHYO)
    IBatchFlowCommand executeChohyo() {
        return loopBatch(ShinseiJohoChohyoTempTableInsertProcess.class).arguments(processParameter).define();
    }

    @Step(ICHIRANHYO)
    IBatchFlowCommand executeIchiranhyo() {
        return loopBatch(ShinseishoHakoIchiranhyoOutputProcess.class).arguments(processParameter).define();
    }

    @Step(JIGYO_ICHIRANHYO)
    IBatchFlowCommand executeJigyoIchiranhyo() {
        return loopBatch(JigyoShinseishoHakoIchiranhyoOutputProcess.class).arguments(processParameter).define();
    }

    @Step(KOGAKU_SHINSEISHO)
    IBatchFlowCommand executeKogakuShinseisho() {
        return loopBatch(KogakuServiceShikyuShinseishoOutputProcess.class).arguments(processParameter).define();
    }

    @Step(KOGAKU_TSUCHISHO_KIGENNAI)
    IBatchFlowCommand executeKogakuTsuchishoNai() {
        return loopBatch(KogakuServiceHiOshiraseTsuchishoKigenNashiOutputProcess.class).arguments(processParameter).define();
    }

    @Step(KOGAKU_TSUCHISHO_KIGENARI)
    IBatchFlowCommand executeKogakuTsuchishoAri() {
        return loopBatch(KogakuServiceHiOshiraseTsuchishoKikanAriOutputProcess.class).arguments(processParameter).define();
    }

    @Step(KOGAKU_UPDATE)
    IBatchFlowCommand executeKogakuUpdate() {
        return loopBatch(KogakuShinseikanriMasterUpdateProcess.class).arguments(processParameter).define();
    }

    @Step(JIGYO_SHINSEISHO)
    IBatchFlowCommand executeJigyoShinseisho() {
        return loopBatch(JigyoKogakuServiceShikyuShinseishoOutputProcess.class).arguments(processParameter).define();
    }

    @Step(JIGYO_TSUCHISHO_KIGENARI)
    IBatchFlowCommand executeJigyoTsuchishoAri() {
        return loopBatch(JigyoKogakuServiceHiOshiraseTsuchishoKigenAriOutputProcess.class).arguments(processParameter).define();
    }

    @Step(JIGYO_TSUCHISHO_KIGENNAI)
    IBatchFlowCommand executeJigyoTsuchishoNai() {
        return loopBatch(JigyoKogakuServiceHiOshiraseTsuchishoKigenNaiOutputProcess.class).arguments(processParameter).define();
    }

    @Step(JIGYO_UPDATE)
    IBatchFlowCommand executeJigyoUpdate() {
        return loopBatch(JigyoKogakuShinseikanriMasterUpdateProcess.class).arguments(processParameter).define();
    }

    private void createParameter() {
        processParameter = getParameter().toProcessParameter();

        processParameter.set保険者番号(
                BusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        processParameter.set事業高額(
                BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額, RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        // TODO QA.1142  DBC業務コンフィグ.自動高額償還_初回申請把握基準日はありません
        processParameter.set初回申請把握基準日(
                BusinessConfig.get(ConfigNameDBC.高額自動償還_初回申請把握基準日, RDate.getNowDate(), SubGyomuCode.DBC介護給付));

        processParameter.set宛名検索条件(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).set基準日(FlexibleDate.getNowDate()).build());

        processParameter.set宛先検索条件(new AtesakiPSMSearchKeyBuilder(AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険,
                SubGyomuCode.DBC介護給付)).set基準日(FlexibleDate.getNowDate()).build());

        processParameter.set口座検索条件(new KozaSearchKeyBuilder().set業務コード(GyomuCode.DB介護保険).
                setサブ業務コード(SubGyomuCode.DBC介護給付).
                set用途区分(new KozaYotoKubunCodeValue(new Code(ONE))).
                set基準日(FlexibleDate.getNowDate()).
                build());
        processParameter.set権限有科目リスト(new ShunoKamokuAuthority().
                get参照権限科目コード(UrControlDataFactory.createInstance().getLoginInfo().getUserId()));
    }
}
