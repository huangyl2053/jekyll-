/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.atenasealcreate;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate.JukyuNinteiShinseityuIgaiProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate.NenreiTotatsuSenTakuShiNaiProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate.NenreiTotatsuSenTakuShiTaProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate.NenreiTotatsuSenTakuShiTanoCyouHyouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate.ShikakuShutokuCyouHyouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate.ShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgaiCyouHyouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.atenasealcreate.ShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgaiProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.atenasealcreate.AtenaSealCreateBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成バッチ処理クラスです。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public class AtenaSealCreateFlow extends BatchFlowBase<AtenaSealCreateBatchParameter> {

    private static final String NENREI_PROCESS = "年齢到達予定者選択した";
    private static final String NENREI_CYOUHYOU_PROCESS = "年齢到達予定者選択した帳票を作成";
    private static final String NOT_NENREI_PROCESS = "年齢到達予定者選択しない";
    private static final String SHIKAKU_CYOUHYOU_PROCESS = "抽出対象者が資格取得者帳票を作成";
    private static final String JUKYUNI_PROCESS = "抽出対象者が受給認定申請中を除く";
    private static final String SHIKAKU_NENREI_JUKYUNI_PROCESS = "抽出対象者が資格取得者＋年齢到達予定者または抽出対象者に受給認定申請中を除く";
    private static final String SHIKA_NENR_JUKYU_CYOU_PROCESS
            = "抽出対象者が資格取得者＋年齢到達予定者または抽出対象者に受給認定申請中を除く帳票を作成";
    private static final RString 抽出対象者_年齢到達予定者 = new RString("2");
    private static final RString 抽出対象者_資格取得者 = new RString("1");
    private static final RString 抽出対象者_受給認定申請中を除く = new RString("5");
    private static final RString 抽出対象者_資格取得者_年齢到達予定者 = new RString("3");

    @Override
    protected void defineFlow() {
        if (抽出対象者_年齢到達予定者.equals(getParameter().getChuushutsutaishousha())) {
            executeStep(NENREI_PROCESS);
            executeStep(NENREI_CYOUHYOU_PROCESS);
        } else {
            executeStep(NOT_NENREI_PROCESS);
            if (抽出対象者_資格取得者.equals(getParameter().getChuushutsutaishousha())) {
                executeStep(SHIKAKU_CYOUHYOU_PROCESS);
            }
            if (抽出対象者_受給認定申請中を除く.equals(getParameter().getChuushutsutaishousha())) {
                executeStep(JUKYUNI_PROCESS);
            }
            if (抽出対象者_資格取得者_年齢到達予定者.equals(getParameter().getChuushutsutaishousha())
                    || 抽出対象者_受給認定申請中を除く.equals(getParameter().getChuushutsutaishousha())) {
                executeStep(NENREI_PROCESS);
                executeStep(SHIKAKU_NENREI_JUKYUNI_PROCESS);
                executeStep(SHIKA_NENR_JUKYU_CYOU_PROCESS);
            }
        }
        //TODO 「処理詳細4．3．3」未実装です。
    }

    /**
     * 年齢到達予定者選択した帳票を作成batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(NENREI_CYOUHYOU_PROCESS)
    protected IBatchFlowCommand reportProcessShitaUse() {
        return loopBatch(NenreiTotatsuSenTakuShiTanoCyouHyouProcess.class).
                arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 年齢到達予定者選択したの場合batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(NENREI_PROCESS)
    protected IBatchFlowCommand reportProcessShita() {
        return loopBatch(NenreiTotatsuSenTakuShiTaProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 年齢到達予定者選択しないの場合batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(NOT_NENREI_PROCESS)
    protected IBatchFlowCommand reportProcessShinai() {
        return loopBatch(NenreiTotatsuSenTakuShiNaiProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * バッチパラメータ.抽出対象者が資格取得者の場合帳票を作成batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKAKU_CYOUHYOU_PROCESS)
    protected IBatchFlowCommand reportProcessShikaKushutoKu() {
        return loopBatch(ShikakuShutokuCyouHyouProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * バッチパラメータ.抽出対象者が受給認定申請中を除くの場合batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(JUKYUNI_PROCESS)
    protected IBatchFlowCommand reportProcessJukyuNinteiShinseityuIgai() {
        return loopBatch(JukyuNinteiShinseityuIgaiProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * バッチパラメータ.抽出対象者が資格取得者＋年齢到達予定者 または
     * バッチパラメータ.抽出対象者に受給認定申請中を除くが選択されているの場合、batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKAKU_NENREI_JUKYUNI_PROCESS)
    protected IBatchFlowCommand reportProcessShikakuShutokuNenreiTotatsu() {
        return loopBatch(ShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgaiProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 抽出対象者が資格取得者＋年齢到達予定者または抽出対象者に受給認定申請中を除く帳票を作成batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKA_NENR_JUKYU_CYOU_PROCESS)
    protected IBatchFlowCommand reportProcessShikakuShutokuNenreiTotatsuUse() {
        return loopBatch(ShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgaiCyouHyouProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }
}
