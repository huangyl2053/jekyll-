/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5C3Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5C4Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5D3Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5D4Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5E3Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5E4Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.IchiTmpTableTorokuProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120041.DBC120041_KyodoJukyushaInSubParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C31KihonKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C32ShoukanKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C33KougakuKyoudouShoriEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計書_DBCMNF2002-5Cx_共同処理用受給者情報更新結果情報取込共通処理（CSVファイル取込）クラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
public class DBC120041_KyodoJukyushaInSub extends BatchFlowBase<DBC120041_KyodoJukyushaInSubParameter> {

    private static final RString TABLE_基本共同処理一時TBL = new RString("DbWT5C31KihonKyoudouShori");
    private static final RString TABLE_償還共同処理一時TBL = new RString("DbWT5C32ShoukanKyoudouShori");
    private static final RString TABLE_高額共同処理一時TBL = new RString("DbWT5C33KougakuKyoudouShori");
    private static final RString 基本情報_5C3 = new RString("5C3");
    private static final RString 償還情報_5D3 = new RString("5D3");
    private static final RString 高額情報_5E3 = new RString("5E3");
    private static final RString 基本情報_5C4 = new RString("5C4");
    private static final RString 償還情報_5D4 = new RString("5D4");
    private static final RString 高額情報_5E4 = new RString("5E4");
    private static final int ENDINDEX = 5;
    private static final String 一時TBL基本情報_5C3作成 = "一時TBL基本情報_5C3作成";
    private static final String 一時TBL償還情報_5D3作成 = "一時TBL償還情報_5D3作成";
    private static final String 一時TBL高額情報_5E3作成 = "一時TBL高額情報_5E3作成";
    private static final String 一時TBL基本情報_5C4作成 = "一時TBL基本情報_5C4作成";
    private static final String 一時TBL償還情報_5D4作成 = "一時TBL償還情報_5D4作成";
    private static final String 一時TBL高額情報_5E4作成 = "一時TBL高額情報_5E4作成";
    private static final String 一時TBLの登録 = "一時TBLの登録";
    private static final String CREATE基本共同処理一時TBL = "CREATE基本共同処理一時TBL";
    private static final String CREATE償還共同処理一時TBL = "CREATE償還共同処理一時TBL";
    private static final String CREATE高額共同処理一時TBL = "CREATE高額共同処理一時TBL";
    private RString ファイル名;
    private Integer レコード総件数;

    @Override
    protected void defineFlow() {
        レコード総件数 = 0;
        executeStep(CREATE基本共同処理一時TBL);
        executeStep(CREATE償還共同処理一時TBL);
        executeStep(CREATE高額共同処理一時TBL);
        for (RString csvファイル名 : getParameter().getエントリ情報List()) {
            ファイル名 = csvファイル名;
            try {
                if (基本情報_5C3.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL基本情報_5C3作成);
                    レコード総件数 = レコード総件数 + checkNull(getResult(Integer.class, new RString(一時TBL基本情報_5C3作成),
                            CreateTmptable5C3Process.レコード件数));
                } else if (償還情報_5D3.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL償還情報_5D3作成);
                    レコード総件数 = レコード総件数 + checkNull(getResult(Integer.class, new RString(一時TBL償還情報_5D3作成),
                            CreateTmptable5D3Process.レコード件数));
                } else if (高額情報_5E3.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL高額情報_5E3作成);
                    レコード総件数 = レコード総件数 + checkNull(getResult(Integer.class, new RString(一時TBL高額情報_5E3作成),
                            CreateTmptable5E3Process.レコード件数));
                } else if (基本情報_5C4.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL基本情報_5C4作成);
                    レコード総件数 = レコード総件数 + checkNull(getResult(Integer.class, new RString(一時TBL基本情報_5C4作成),
                            CreateTmptable5C4Process.レコード件数));
                } else if (償還情報_5D4.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL償還情報_5D4作成);
                    レコード総件数 = レコード総件数 + checkNull(getResult(Integer.class, new RString(一時TBL償還情報_5D4作成),
                            CreateTmptable5D4Process.レコード件数));
                } else if (高額情報_5E4.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL高額情報_5E4作成);
                    レコード総件数 = レコード総件数 + checkNull(getResult(Integer.class, new RString(一時TBL高額情報_5E4作成),
                            CreateTmptable5E4Process.レコード件数));
                }
            } catch (Exception e) {
                throw new BatchInterruptedException(e.getMessage());
            }
        }
        executeStep(一時TBLの登録);
    }

    /**
     * 基本共同処理一時TBLをCREATEするProcessです。
     *
     * @return 基本共同処理一時TBL
     */
    @Step(CREATE基本共同処理一時TBL)
    protected IBatchFlowCommand create基本共同処理一時TempTable() {
        return createTempTable(TABLE_基本共同処理一時TBL, DbWT5C31KihonKyoudouShoriEntity.class).define();
    }

    /**
     * 償還共同処理一時TBLをCREATEするProcessです。
     *
     * @return 償還共同処理一時TBL
     */
    @Step(CREATE償還共同処理一時TBL)
    protected IBatchFlowCommand create償還共同処理一時TempTable() {
        return createTempTable(TABLE_償還共同処理一時TBL, DbWT5C32ShoukanKyoudouShoriEntity.class).define();
    }

    /**
     * 高額共同処理一時TBLをCREATEするProcessです。
     *
     * @return 要介護認定申請情報中間一時テーブル
     */
    @Step(CREATE高額共同処理一時TBL)
    protected IBatchFlowCommand create高額共同処理一時TempTable() {
        return createTempTable(TABLE_高額共同処理一時TBL, DbWT5C33KougakuKyoudouShoriEntity.class).define();
    }

    /**
     * 一時TBL基本情報_5C3作成処理Processです。
     *
     * @return CreateTmptable5C3Process
     */
    @Step(一時TBL基本情報_5C3作成)
    protected IBatchFlowCommand createTmptable5C3Process() {
        return loopBatch(CreateTmptable5C3Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(ファイル名)).define();
    }

    /**
     * 一時TBL償還情報_5D3作成処理Processです。
     *
     * @return CreateTmptable5D3Process
     */
    @Step(一時TBL償還情報_5D3作成)
    protected IBatchFlowCommand createTmptable5D3Process() {
        return loopBatch(CreateTmptable5D3Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(ファイル名)).define();
    }

    /**
     * 一時TBL高額情報_5E3作成処理Processです。
     *
     * @return CreateTmptable5E3Process
     */
    @Step(一時TBL高額情報_5E3作成)
    protected IBatchFlowCommand createTmptable5E3Process() {
        return loopBatch(CreateTmptable5E3Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(ファイル名)).define();
    }

    /**
     * 一時TBL基本情報_5C4作成処理Processです。
     *
     * @return CreateTmptable5C4Process
     */
    @Step(一時TBL基本情報_5C4作成)
    protected IBatchFlowCommand createTmptable5C4Process() {
        return loopBatch(CreateTmptable5C4Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(ファイル名)).define();
    }

    /**
     * 一時TBL償還情報_5D4作成処理Processです。
     *
     * @return CreateTmptable5D4Process
     */
    @Step(一時TBL償還情報_5D4作成)
    protected IBatchFlowCommand createTmptable5D4Process() {
        return loopBatch(CreateTmptable5D4Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(ファイル名)).define();
    }

    /**
     * 一時TBL高額情報_5E4作成処理Processです。
     *
     * @return CreateTmptable5E4Process
     */
    @Step(一時TBL高額情報_5E4作成)
    protected IBatchFlowCommand createTmptable5E4Process() {
        return loopBatch(CreateTmptable5E4Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(ファイル名)).define();
    }

    /**
     * 一時TBLの登録Processです。
     *
     * @return IchiTmpTableTorokuProcess
     */
    @Step(一時TBLの登録)
    protected IBatchFlowCommand ichiTmpTableTorokuProcess() {
        return loopBatch(IchiTmpTableTorokuProcess.class).define();
    }

    private Integer checkNull(Integer レコード件数) {
        if (レコード件数 != null) {
            return レコード件数;
        }
        return 0;
    }
}
