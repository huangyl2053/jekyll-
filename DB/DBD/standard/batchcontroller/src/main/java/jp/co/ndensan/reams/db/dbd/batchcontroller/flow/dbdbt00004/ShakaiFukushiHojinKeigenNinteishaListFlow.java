/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt00004;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00004.NinteishaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00004.SystemTimeKarisanteiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00004.TaishoshaIchijiTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDBT00004.DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmenGengakuTaishoShaHanteiYoukonSakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00004.NinteishaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00004.TaishoshaIchijiTokuteiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社会福祉法人軽減認定者リスト作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-3830-010 tianyh
 */
public class ShakaiFukushiHojinKeigenNinteishaListFlow extends BatchFlowBase<DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter> {

    private static final String 対象者一次特定 = "TaishoshaIchijiTokuteiProcess";
    private static final String システム日時の取得 = "getSystemDate";
    private static final String 減免減額対象者判定用根拠作成 = "GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei";
    private static final RString バッチID_DBDBZZ0001 = new RString("GemmenGengakuTaishoShaHanteiYoukonSakuseiFlow");
    private static final String CSV_PROCESS = "csvProcess";
    private GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter youkonsakuseiparameter;

    @Override

    protected void defineFlow() {
        executeStep(システム日時の取得);
        executeStep(対象者一次特定);
        executeStep(減免減額対象者判定用根拠作成);
        executeStep(CSV_PROCESS);
    }

    /**
     * 対象者一次特定を取得します。
     *
     * @return バッチコマンド
     */
    @Step(対象者一次特定)
    protected IBatchFlowCommand getUpdateNotApplicantList() {
        return loopBatch(TaishoshaIchijiTokuteiProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        return simpleBatch(SystemTimeKarisanteiProcess.class).define();
    }

    /**
     * 減免減額対象者判定用根拠作成。
     *
     * @return バッチコマンド
     */
    @Step(減免減額対象者判定用根拠作成)
    protected IBatchFlowCommand 減免減額対象者判定用根拠作成() {
        youkonsakuseiparameter = new GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter(getParameter().get所得年度());
        return otherBatchFlow(バッチID_DBDBZZ0001, SubGyomuCode.DBD介護受給, youkonsakuseiparameter).define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(CSV_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(NinteishaListSakuseiProcess.class)
                .arguments(createNinteishaListSakuseiProcessParameter())
                .define();
    }

    private TaishoshaIchijiTokuteiProcessParameter createProcessParameter() {
        DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter parameter = getParameter();
        TaishoshaIchijiTokuteiProcessParameter processParameter = new TaishoshaIchijiTokuteiProcessParameter(
                parameter.get対象リスト(),
                parameter.get対象期間指定(),
                parameter.get対象年度の開始年月日(),
                parameter.get対象年度の終了年月日(),
                parameter.get旧措置者区分(),
                parameter.get基準日(),
                parameter.get課税判定等基準日(),
                parameter.get受給者区分(),
                parameter.get抽出対象()
        );
        return processParameter;
    }

    private NinteishaListSakuseiProcessParameter createNinteishaListSakuseiProcessParameter() {
        DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter parameter = getParameter();
        NinteishaListSakuseiProcessParameter processParameter = new NinteishaListSakuseiProcessParameter(
                parameter.get対象リスト(),
                parameter.get対象期間指定(),
                parameter.get対象年度の開始年月日(),
                parameter.get対象年度の終了年月日(),
                parameter.get旧措置者区分(),
                parameter.get世帯表示(),
                parameter.get所得年度(),
                parameter.get基準日(),
                parameter.get課税判定等基準日(),
                parameter.get受給者区分(),
                parameter.get世帯非課税等(),
                parameter.get抽出対象(),
                parameter.getCSV出力設定(),
                parameter.get改頁出力順ID(),
                parameter.get帳票ID(),
                getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeKarisanteiProcess.SYSTEM_TIME)
        );
        return processParameter;
    }
}
