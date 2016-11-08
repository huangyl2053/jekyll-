/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.IChiJiTBLProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.JukyuNinteiShinseityuIgaiProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.NenreiTotatsuSenTakuShiNaiProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.NenreiTotatsuSenTakuShiTaProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.NenreiTotatsuSenTakuShiTanoCyouHyouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.ShikakuShutokuCyouHyouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.ShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgaiCyouHyouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.ShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgaiProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.ShikakuShutokuToJukyuNinteiShinseityuIgaiCyouHyouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.ShikakuShutokuToNenreiTotatsuCyouHyouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.ShikakuShutokuToNenreiTotatsuProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010.ShikakuShutokuToNenreiTotatsuToJukyuNinteiShinseityuIgaiCyouHyouProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA090010.DBA090010_AtenaSeelParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成バッチ処理クラスです。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public class DBA090010_AtenaSeel extends BatchFlowBase<DBA090010_AtenaSeelParameter> {

    private static final String NENREI_PROCESS = "年齢到達予定者選択した";
    private static final String NENREI_CYOUHYOU_PROCESS = "年齢到達予定者選択した帳票を作成";
    private static final String NOT_NENREI_PROCESS = "年齢到達予定者選択しない";
    private static final String SHIKAKU_CYOUHYOU_PROCESS = "抽出対象者が資格取得者帳票を作成";
    private static final String JUKYUNI_PROCESS = "抽出対象者が受給認定申請中を除く";
    private static final String SHIKAKU_NENREI_JUKYUNI_PROCESS = "抽出対象者が資格取得者＋年齢到達予定者または抽出対象者に受給認定申請中を除く";
    private static final String SHIKA_NENR_JUKYU_CYOU_PROCESS
            = "抽出対象者が資格取得者＋年齢到達予定者または抽出対象者に受給認定申請中を除く帳票を作成";
    private static final String SHIKAKUSHUTOKU_NENREITOTATSU = "バッチパラメータ.抽出対象者が3(資格取得者＋年齢到達予定者) の場合";
    private static final String SHIKAKUSHU_NENREITO_CYOU = "バッチパラメータ.抽出対象者が3(資格取得者＋年齢到達予定者) の場合、帳票出力";
    private static final String SHIKAKUSHU_NENREITO_JUKY
            = "バッチパラメータ.抽出対象者が6(資格取得者＋年齢到達予定者) の場合、帳票出力";
    private static final String SHIKAKUSHUTOKU_JUKY = "バッチパラメータ.抽出対象者が5が選択されている場合";
    private static final String ICHIJITBL = "処理結果リストCSV";
    private static final RString 抽出対象者_1 = new RString("1");
    private static final RString 抽出対象者_2 = new RString("2");
    private static final RString 抽出対象者_3 = new RString("3");
    private static final RString 抽出対象者_4 = new RString("4");
    private static final RString 抽出対象者_5 = new RString("5");

    @Override
    protected void defineFlow() {
        if (抽出対象者_1.equals(getParameter().getChuushutsutaishousha())) {
            executeStep(NOT_NENREI_PROCESS);
            executeStep(SHIKAKU_CYOUHYOU_PROCESS);
            executeStep(ICHIJITBL);
        } else if (抽出対象者_2.equals(getParameter().getChuushutsutaishousha())) {
            executeStep(NENREI_PROCESS);
            executeStep(NENREI_CYOUHYOU_PROCESS);
            executeStep(ICHIJITBL);
        } else if (抽出対象者_3.equals(getParameter().getChuushutsutaishousha())) {
            executeStep(NOT_NENREI_PROCESS);
            executeStep(NENREI_PROCESS);
            executeStep(SHIKAKUSHUTOKU_NENREITOTATSU);
            executeStep(SHIKAKUSHU_NENREITO_CYOU);
            executeStep(ICHIJITBL);
        } else if (抽出対象者_4.equals(getParameter().getChuushutsutaishousha())) {
            executeStep(NOT_NENREI_PROCESS);
            executeStep(SHIKAKU_CYOUHYOU_PROCESS);
            executeStep(ICHIJITBL);
        } else if (抽出対象者_5.equals(getParameter().getChuushutsutaishousha())) {
            executeStep(NOT_NENREI_PROCESS);
            executeStep(JUKYUNI_PROCESS);
            executeStep(SHIKAKUSHUTOKU_JUKY);
            executeStep(ICHIJITBL);
        } else {
            executeStep(NENREI_PROCESS);
            executeStep(NOT_NENREI_PROCESS);
            executeStep(JUKYUNI_PROCESS);
            executeStep(SHIKAKU_NENREI_JUKYUNI_PROCESS);
            executeStep(SHIKAKUSHUTOKU_NENREITOTATSU);
            executeStep(SHIKAKUSHU_NENREITO_JUKY);
            executeStep(ICHIJITBL);
        }
    }

    /**
     * 宛名識別対象一時テーブル1の作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(NENREI_PROCESS)
    protected IBatchFlowCommand reportProcessShita() {
        return loopBatch(NenreiTotatsuSenTakuShiTaProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 宛名識別対象一時テーブル1の帳票を作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(NENREI_CYOUHYOU_PROCESS)
    protected IBatchFlowCommand reportProcessShitaUse() {
        return loopBatch(NenreiTotatsuSenTakuShiTanoCyouHyouProcess.class).
                arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 宛名識別対象一時テーブル2の作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(NOT_NENREI_PROCESS)
    protected IBatchFlowCommand reportProcessShinai() {
        return loopBatch(NenreiTotatsuSenTakuShiNaiProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 宛名識別対象一時テーブル2の帳票を作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKAKU_CYOUHYOU_PROCESS)
    protected IBatchFlowCommand reportProcessShikaKushutoKu() {
        return loopBatch(ShikakuShutokuCyouHyouProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 宛名識別対象一時テーブル3の作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(JUKYUNI_PROCESS)
    protected IBatchFlowCommand reportProcessJukyuNinteiShinseityuIgai() {
        return loopBatch(JukyuNinteiShinseityuIgaiProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 宛名識別対象一時テーブル4の作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKAKU_NENREI_JUKYUNI_PROCESS)
    protected IBatchFlowCommand reportProcessShikakuShutokuNenreiTotatsu() {
        return loopBatch(ShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgaiProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 宛名識別対象一時テーブル4の帳票を作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKA_NENR_JUKYU_CYOU_PROCESS)
    protected IBatchFlowCommand reportProcessShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgai() {
        return loopBatch(ShikakuShutokuNenreiTotatsuJukyuNinteiShinseityuIgaiCyouHyouProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 宛名識別対象一時テーブル5を作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKAKUSHUTOKU_NENREITOTATSU)
    protected IBatchFlowCommand reportProcessShikakuShutokuToNenreiTotatsu() {
        return loopBatch(ShikakuShutokuToNenreiTotatsuProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 宛名識別対象一時テーブル3の帳票を作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKAKUSHUTOKU_JUKY)
    protected IBatchFlowCommand reportProcessShikakuShutokuToJukyuNinteiShinseityuIga() {
        return loopBatch(ShikakuShutokuToJukyuNinteiShinseityuIgaiCyouHyouProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 処理結果リストCSVの作成。
     *
     * @return IBatchFlowCommand
     */
    @Step(ICHIJITBL)
    protected IBatchFlowCommand reportProcessIchiJiTBL() {
        return loopBatch(IChiJiTBLProcess.class).define();
    }

    /**
     * 宛名識別対象一時テーブル5の帳票を作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKAKUSHU_NENREITO_CYOU)
    protected IBatchFlowCommand reportProcessShikaKushutoKu_NenreiToTatsu_Cyou() {
        return loopBatch(ShikakuShutokuToNenreiTotatsuCyouHyouProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }

    /**
     * 宛名識別対象一時テーブル6の帳票を作成、データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHIKAKUSHU_NENREITO_JUKY)
    protected IBatchFlowCommand reportProcessShikaKushutoKu_NenreiToTatsu_JukyuNinteiShinseityuIgai() {
        return loopBatch(ShikakuShutokuToNenreiTotatsuToJukyuNinteiShinseityuIgaiCyouHyouProcess.class)
                .arguments(getParameter().toAtenaSealCreateProcessParameter()).define();
    }
}
