/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.keisangojoho;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.keisangojoho.KeisangoJohoInsertProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.keisangojoho.TyukanTempInsertProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.keisangojoho.TyukanTempUpdateProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 計算後情報作成_バッチフロークラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class KeisangoJohoSakuseiFlow extends BatchFlowBase<KeisangoJohoSakuseiBatchParamter> {

    private static final String TYUKANTEMPINSERTPROCESS = "tyukanTempInsertProcess";
    private static final String TYUKANTEMPAFTERUPDATE = "tyukanTempAfterUpdate";
    private static final String TYUKANTEMPBEFOREUPDATE = "tyukanTempBeforeUpdate";
    private static final String KEISANGOJOHOAFTERINSERT = "keisangoJohoAfterInsert";
    private static final String KEISANGOJOHOBEFOREINSERT = "keisangoJohoBeforeInsert";

    @Override
    protected void defineFlow() {
        executeStep(TYUKANTEMPINSERTPROCESS);
        executeStep(TYUKANTEMPAFTERUPDATE);
        executeStep(KEISANGOJOHOAFTERINSERT);
        executeStep(TYUKANTEMPBEFOREUPDATE);
        executeStep(KEISANGOJOHOBEFOREINSERT);
    }

    /**
     * 検索した賦課情報を計算中間Tempテーブルに登録する処理クラスです。
     *
     * @return TyukanTempInsertProcess
     */
    @Step(TYUKANTEMPINSERTPROCESS)
    protected IBatchFlowCommand callTyukanTempInsertProcess() {
        getParameter().set更新前フラグ(false);
        return loopBatch(TyukanTempInsertProcess.class)
                .arguments(getParameter().toKeisangoJohoSakuseiProcessParamter()).define();
    }

    /**
     * 計算中間Tempの更新後データを更新する処理クラスです。
     *
     * @return TyukanTempUpdateProcess
     */
    @Step(TYUKANTEMPAFTERUPDATE)
    protected IBatchFlowCommand callTyukanTempAfterUpdate() {
        getParameter().set更新前フラグ(false);
        return loopBatch(TyukanTempUpdateProcess.class)
                .arguments(getParameter().toKeisangoJohoSakuseiProcessParamter()).define();
    }

    /**
     * 計算中間Tempの更新前データを更新する処理クラスです。
     *
     * @return TyukanTempUpdateProcess
     */
    @Step(TYUKANTEMPBEFOREUPDATE)
    protected IBatchFlowCommand callTyukanTempBeforeUpdate() {
        getParameter().set更新前フラグ(true);
        return loopBatch(TyukanTempUpdateProcess.class)
                .arguments(getParameter().toKeisangoJohoSakuseiProcessParamter()).define();
    }

    /**
     * 計算中間Tempテーブルから更新後データを検索したデータを計算後情報一時または計算後情報に登録し、
     * <br>計算中間Tempテーブルから削除する処理を行う処理です。
     *
     * @return KeisangoJohoInsertProcess
     */
    @Step(KEISANGOJOHOAFTERINSERT)
    protected IBatchFlowCommand callKeisangoJohoAfterInsert() {
        getParameter().set更新前フラグ(false);
        return loopBatch(KeisangoJohoInsertProcess.class)
                .arguments(getParameter().toKeisangoJohoSakuseiProcessParamter()).define();
    }

    /**
     * 計算中間Tempテーブルから更新前データを検索したデータを計算後情報一時または計算後情報に登録し、
     * <br>計算中間Tempテーブルから削除する処理を行う処理です。
     *
     * @return KeisangoJohoInsertProcess
     */
    @Step(KEISANGOJOHOBEFOREINSERT)
    protected IBatchFlowCommand callKeisangoJohoBeforeInsert() {
        getParameter().set更新前フラグ(true);
        return loopBatch(KeisangoJohoInsertProcess.class)
                .arguments(getParameter().toKeisangoJohoSakuseiProcessParamter()).define();
    }
}
