/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.DataCompareShoriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.DelJukyushaIdoRenrakuhyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.InsIdoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.InsIdomaiDataTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.InsJukyushaIdoRenrakuhyoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.InsShiharaihohoTemp1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.InsShiharaihohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.SoufuErrorOutProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdAtenaTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdFutanWariaiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdGengakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdHihokenshaTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdHyojunFutanTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdJukyushaTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdJutokuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdKokuhoShikakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdKoukiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdKyotakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdNijiYoboTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdRiyoshafutanGengakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdSeihoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdShafukuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdSogoJigyoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020.UpdTokuteNyushoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110020.DBC110020_JukyushaIdoRenrakuhyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110020.JukyushaIdoRenrakuhyoOutFlowEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者異動連絡票作成のFLOWです。
 *
 * @reamsid_L DBC-2720-030 chenhui
 */
public class DBC110020_JukyushaIdoRenrakuhyoOut extends BatchFlowBase<DBC110020_JukyushaIdoRenrakuhyoOutParameter> {

    private static final RString 再処理 = new RString("1");
    private static final String 異動対象の抽出 = "insIdoTemp";
    private static final String 支払方法変更の抽出 = "insShiharaihohoTemp";
    private static final String 給付額減額の抽出 = "updGengakuTemp";
    private static final String 後期高齢者情報の抽出 = "updKoukiTemp";
    private static final String 国保資格情報の抽出 = "updKokuhoShikakuTemp";
    private static final String 生活保護受給者の情報の抽出 = "updSeihoTemp";
    private static final String 特定入所者の情報の抽出 = "updTokuteNyushoTemp";
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
    private static final String 異動一時１テーブルの作成 = "insShiharaihohoTemp1";
    private static final String 送付エラー一時出力 = "soufuErrorOutTemp";
    private static final String 異動日毎データ抽出 = "insIdomaiDataTemp";
    private static final String 受給者異動送付削除産 = "delJukyushaIdoRenrakuhyo";
    private static final String 受給者異動の抽出 = "insJukyushaIdoRenrakuhyoTemp";
    private static final String データ比較処理 = "dataCompareShori";
    private static final String 国保連インタフェース管理更新 = "upDoInterfaceKanriKousin";
    private static final RString 交換情報識別番号 = new RString("531");
    private JukyushaIdoRenrakuhyoOutFlowEntity returnEntity;

    @Override
    protected void defineFlow() {
        executeStep(異動対象の抽出);
        executeStep(支払方法変更の抽出);
        executeStep(給付額減額の抽出);
        executeStep(後期高齢者情報の抽出);
        executeStep(国保資格情報の抽出);
        executeStep(生活保護受給者の情報の抽出);
        executeStep(特定入所者の情報の抽出);
        executeStep(社福減免の情報の抽出);
        executeStep(利用者負担の情報の抽出);
        executeStep(標準負担の情報の抽出);
        executeStep(二割負担の情報の抽出);
        executeStep(居宅計画の情報の抽出);
        executeStep(住所地特例の情報の抽出);
        executeStep(宛名情報の情報の抽出);
        executeStep(受給者台帳の情報の抽出);
        executeStep(二次予防の情報の抽出);
        executeStep(総合事業対象者の情報の抽出);
        executeStep(被保険者台帳の情報の抽出);
        executeStep(異動一時１テーブルの作成);
        executeStep(送付エラー一時出力);
        executeStep(異動日毎データ抽出);
        if (再処理.equals(getParameter().get再処理区分())) {
            executeStep(受給者異動送付削除産);
        }
        executeStep(受給者異動の抽出);
        executeStep(データ比較処理);
        returnEntity = getResult(JukyushaIdoRenrakuhyoOutFlowEntity.class, new RString(データ比較処理),
                DataCompareShoriProcess.PARAMETER_OUT_RETURNENTITY);
        executeStep(国保連インタフェース管理更新);

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

    @Step(生活保護受給者の情報の抽出)
    IBatchFlowCommand updSeihoTemp() {
        return loopBatch(UpdSeihoTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(特定入所者の情報の抽出)
    IBatchFlowCommand updTokuteNyushoTemp() {
        return loopBatch(UpdTokuteNyushoTempProcess.class).arguments(getParameter().
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

    @Step(住所地特例の情報の抽出)
    IBatchFlowCommand updJutokuTemp() {
        return loopBatch(UpdJutokuTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(宛名情報の情報の抽出)
    IBatchFlowCommand updAtenaTemp() {
        return loopBatch(UpdAtenaTempProcess.class).arguments(getParameter().
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

    @Step(異動一時１テーブルの作成)
    IBatchFlowCommand insShiharaihohoTemp1() {
        return loopBatch(InsShiharaihohoTemp1Process.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(送付エラー一時出力)
    IBatchFlowCommand soufuErrorOutTemp() {
        return loopBatch(SoufuErrorOutProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(異動日毎データ抽出)
    IBatchFlowCommand insIdomaiDataTemp() {
        return loopBatch(InsIdomaiDataTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(受給者異動送付削除産)
    IBatchFlowCommand delJukyushaIdoRenrakuhyo() {
        return simpleBatch(DelJukyushaIdoRenrakuhyoProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(受給者異動の抽出)
    IBatchFlowCommand insJukyushaIdoRenrakuhyoTemp() {
        return loopBatch(InsJukyushaIdoRenrakuhyoTempProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(データ比較処理)
    IBatchFlowCommand dataCompareShori() {
        return loopBatch(DataCompareShoriProcess.class).arguments(getParameter().
                toProcessParameter())
                .define();
    }

    @Step(国保連インタフェース管理更新)
    IBatchFlowCommand upDoInterfaceKanriKousin() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        FlexibleYearMonth 処理年月 = new FlexibleYearMonth(getParameter().get処理年月().toDateString());
        parameter.set処理年月(処理年月);
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理対象年月(処理年月);
        parameter.setレコード件数合計(returnEntity.get異動連絡票件数());
        List<RString> fileNameList = new ArrayList<>();
        fileNameList.add(getParameter().getファイル名());
        parameter.setFileNameList(fileNameList);
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }
}
