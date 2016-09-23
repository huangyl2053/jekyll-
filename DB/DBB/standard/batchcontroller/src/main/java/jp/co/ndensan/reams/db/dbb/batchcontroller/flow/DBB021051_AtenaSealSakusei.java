/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021051.DBB021051_AtenaSealSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のバッチクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
public class DBB021051_AtenaSealSakusei extends BatchFlowBase<DBB021051_AtenaSealSakuseiParameter> {

    private static final String 宛名シール情報取得 = "atenaSealJohoShutokuProcess";
    private static final String 帳票出力用情報取得 = "chohyoJohoShutokuProcess";
    private static final String 処理結果リストCSV = "ShoriKekkaListProcess";

    @Override
    protected void defineFlow() {
        executeStep(宛名シール情報取得);
        executeStep(帳票出力用情報取得);
        boolean hasError = getResult(Boolean.class, new RString(宛名シール情報取得), AtenaSealJohoShutokuProcess.HAS_ERROR);
        if (hasError) {
            executeStep(処理結果リストCSV);
        }
    }

    @Step(宛名シール情報取得)
    IBatchFlowCommand atenaSealJohoShutokuProcess() {
        return loopBatch(AtenaSealJohoShutokuProcess.class).arguments(getParameter().toDBB021051ProcessParameter()).define();
    }

    @Step(帳票出力用情報取得)
    IBatchFlowCommand chohyoJohoShutokuProcess() {
        return loopBatch(ChohyoJohoShutokuProcess.class).arguments(getParameter().toDBB021051ProcessParameter()).define();
    }

    @Step(処理結果リストCSV)
    IBatchFlowCommand shoriKekkaListProcess() {
        return loopBatch(ShoriKekkaListProcess.class).arguments(getParameter().toDBB021051ProcessParameter()).define();
    }
}
