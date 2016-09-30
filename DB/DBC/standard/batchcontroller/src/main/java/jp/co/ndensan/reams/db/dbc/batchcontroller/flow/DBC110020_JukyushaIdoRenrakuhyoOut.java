/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.InsIdoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.InsShiharaihohoTemp1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.InsShiharaihohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdFutanWariaiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdGengakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdHihokenshaTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdHyojunFutanTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdJukyushaTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdKokuhoShikakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdKoukiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdKyotakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdNijiYoboTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdRiyoshafutanGengakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdShafukuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdSogoJigyoTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110020.DBC110020_JukyushaIdoRenrakuhyoOutParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 受給者異動連絡票作成のFLOWです。
 *
 * @reamsid_L DBC-2720-030 chenhui
 */
public class DBC110020_JukyushaIdoRenrakuhyoOut extends BatchFlowBase<DBC110020_JukyushaIdoRenrakuhyoOutParameter> {

    private static final String 異動対象の抽出 = "insIdoTemp";
    private static final String 支払方法変更の抽出 = "insShiharaihohoTemp";
    private static final String 給付額減額の抽出 = "updGengakuTemp";
    private static final String 後期高齢者情報の抽出 = "updKoukiTemp";
    private static final String 国保資格情報の抽出 = "updKokuhoShikakuTemp";
    private static final String 生活保護受給者の情報の抽出 = "updKokuhoShikakuTemp";
    private static final String 特定入所者の情報の抽出 = "updKokuhoShikakuTemp";
    private static final String 社福減免の情報の抽出 = "updShafukuTemp";
    private static final String 利用者負担の情報の抽出 = "updRiyoshafutanGengakuTemp";
    private static final String 標準負担の情報の抽出 = "updHyojunFutanTemp";
    private static final String 二割負担の情報の抽出 = "updFutanWariaiTemp";
    private static final String 居宅計画の情報の抽出 = "updKyotakuTemp";
    private static final String 住所地特例の情報の抽出 = "updJutokuTemp";
    private static final String 宛名情報の情報の抽出 = "updAtenaTemp";
    private static final String 受給者台帳の情報の抽出 = "updJukyushaTemp";
    private static final String 二次予防の情報の抽出 = "updNijiYoboTemp";
    private static final String 総合事業対象者の情報の抽出 = "updSogoJigyoTemp";
    private static final String 被保険者台帳の情報の抽出 = "updHihokenshaTemp";
//    private static final String テースト抽出 = "jukyuTest";
    private static final String 異動一時１テーブルの作成 = "insShiharaihohoTemp1";

    @Override
    protected void defineFlow() {
        executeStep(異動対象の抽出);
        executeStep(支払方法変更の抽出);
        executeStep(給付額減額の抽出);
        executeStep(後期高齢者情報の抽出);
        //TODO QA1622
//        executeStep(国保資格情報の抽出);
//        executeStep(生活保護受給者の情報の抽出);
//        executeStep(特定入所者の情報の抽出);
        executeStep(社福減免の情報の抽出);
        executeStep(利用者負担の情報の抽出);
        executeStep(標準負担の情報の抽出);
        executeStep(二割負担の情報の抽出);
        executeStep(居宅計画の情報の抽出);
        //TODO QA1622
//        executeStep(住所地特例の情報の抽出);
//        executeStep(宛名情報の情報の抽出);
        executeStep(受給者台帳の情報の抽出);
        executeStep(二次予防の情報の抽出);
        executeStep(総合事業対象者の情報の抽出);
        executeStep(被保険者台帳の情報の抽出);
//        executeStep(テースト抽出);
        executeStep(異動一時１テーブルの作成);
    }

    @Step(異動対象の抽出)
    IBatchFlowCommand insIdoTemp() {
        return loopBatch(InsIdoTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(支払方法変更の抽出)
    IBatchFlowCommand insShiharaihohoTemp() {
        return loopBatch(InsShiharaihohoTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(給付額減額の抽出)
    IBatchFlowCommand updGengakuTemp() {
        return loopBatch(UpdGengakuTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(後期高齢者情報の抽出)
    IBatchFlowCommand updKoukiTemp() {
        return loopBatch(UpdKoukiTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(国保資格情報の抽出)
    IBatchFlowCommand updKokuhoShikakuTemp() {
        return loopBatch(UpdKokuhoShikakuTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(社福減免の情報の抽出)
    IBatchFlowCommand updShafukuTemp() {
        return loopBatch(UpdShafukuTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(利用者負担の情報の抽出)
    IBatchFlowCommand updRiyoshafutanGengakuTemp() {
        return loopBatch(UpdRiyoshafutanGengakuTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(標準負担の情報の抽出)
    IBatchFlowCommand updHyojunFutanTemp() {
        return loopBatch(UpdHyojunFutanTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(二割負担の情報の抽出)
    IBatchFlowCommand updFutanWariaiTemp() {
        return loopBatch(UpdFutanWariaiTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(居宅計画の情報の抽出)
    IBatchFlowCommand updKyotakuTemp() {
        return loopBatch(UpdKyotakuTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(受給者台帳の情報の抽出)
    IBatchFlowCommand updJukyushaTem() {
        return loopBatch(UpdJukyushaTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(二次予防の情報の抽出)
    IBatchFlowCommand updNijiYoboTemp() {
        return loopBatch(UpdNijiYoboTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(総合事業対象者の情報の抽出)
    IBatchFlowCommand updSogoJigyoTemp() {
        return loopBatch(UpdSogoJigyoTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(被保険者台帳の情報の抽出)
    IBatchFlowCommand updHihokenshaTemp() {
        return loopBatch(UpdHihokenshaTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

//    @Step(テースト抽出)
//    IBatchFlowCommand jukyuTest() {
//        return loopBatch(JukyuTestProcess.class).arguments(getParameter().
//                toProcessParameter())
//                .define();
//    }
    @Step(異動一時１テーブルの作成)
    IBatchFlowCommand insShiharaihohoTemp1() {
        return loopBatch(InsShiharaihohoTemp1Process.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

}
