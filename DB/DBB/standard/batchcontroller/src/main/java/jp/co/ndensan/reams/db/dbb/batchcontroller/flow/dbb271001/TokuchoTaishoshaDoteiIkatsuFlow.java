/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb271001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001.CreateGyomuHokenshaJohoGetsujiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001.CreateGyomuHokenshaJohoNenjiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001.GetDoteiJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001.GetMiDoteiJohoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchotaishoshadotei.TokuchoTaishoshaDoteiIkatsuBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class TokuchoTaishoshaDoteiIkatsuFlow extends BatchFlowBase<TokuchoTaishoshaDoteiIkatsuBatchParameter> {

    private static final RString 処理区分_月次 = new RString("1");
    private static final RString 処理区分_年次 = new RString("2");
    private static final String 業務被保険者情報作成_月次 = "createGyomuHokenshaJohoGetsuji";
    private static final String 業務被保険者情報作成_年次 = "createGyomuHokenshaJohoNenji";
//    private static final String バッチ特徴同定を呼び出し = "doBatchTokuchoDotei";
    private static final String 同定情報を取得する = "getDoteiJoho";
    private static final String 未同定情報を取得する = "getMiDoteiJoho";
    private static final RString 同定方法_宛名同定 = new RString("1");

    private static final RString BATCH_ID = new RString("UEXT02010_TokuchoDotei");

    @Override
    protected void defineFlow() {
        if (処理区分_月次.equals(getParameter().get処理区分())) {
            executeStep(業務被保険者情報作成_月次);
        } else if (処理区分_年次.equals(getParameter().get処理区分())) {
            executeStep(業務被保険者情報作成_年次);
        }
//        executeStep(バッチ特徴同定を呼び出し);
        executeStep(同定情報を取得する);
        executeStep(未同定情報を取得する);
    }

    /**
     * 業務被保険者情報作成（月次）処理クラスです。
     *
     * @return CreateGyomuHokenshaJohoGetsujiProcess
     */
    @Step(業務被保険者情報作成_月次)
    protected IBatchFlowCommand callCreateGyomuHokenshaJohoGetsujiProcess() {
        return loopBatch(CreateGyomuHokenshaJohoGetsujiProcess.class).
                arguments(getParameter().toCreateGyomuHokenshaJohoGetsujiProcessParameter()).define();
    }

    /**
     * 業務被保険者情報作成（年次）処理クラスです。
     *
     * @return CreateGyomuHokenshaJohoNenjiProcess
     */
    @Step(業務被保険者情報作成_年次)
    protected IBatchFlowCommand callCreateGyomuHokenshaJohoNenjiProcess() {
        return loopBatch(CreateGyomuHokenshaJohoNenjiProcess.class).
                define();
    }

    /**
     * バッチ_特徴同定(UEXT02010_TokuchoDotei)を呼び出しクラスです。
     *
     * @return DoBatchTokuchoDoteiProcess
     */
    //TODO バッチ_特徴同定にrgdbのUeT0511表を利用する、その表はすでに削除しました、エーラが起こります。QAあり。
//    @Step(バッチ特徴同定を呼び出し)
//    protected IBatchFlowCommand callDoBatchTokuchoDoteiProcess() {
//        return otherBatchFlow(BATCH_ID, SubGyomuCode.UEX分配集約公開,
//                getBatchParamter()).define();
//    }
//
//    private UEXT02010_TokuchoDoteiParameter getBatchParamter() {
//        UEXT02010_TokuchoDoteiParameter parameter = new UEXT02010_TokuchoDoteiParameter();
//        parameter.setShoriNendo(getParameter().get処理年度());
//        parameter.setKaigoShoriNendo(getParameter().get処理年度());
//        parameter.setHosokuTsuki(getParameter().get捕捉月());
//        parameter.setDoteiHoho(同定方法_宛名同定);
//        parameter.setGyomuCode(null);
//        parameter.setShoriTime(getParameter().get処理日時());
//        boolean 年度切替後 = Boolean.FALSE;
//        FlexibleYear システム日付の年 = FlexibleDate.getNowDate().getYear();
//        if (システム日付の年.equals(getParameter().get処理年度())) {
//            年度切替後 = Boolean.TRUE;
//        }
//        parameter.setNendoKirikaeAto(年度切替後);
//        return parameter;
//    }
    /**
     * 同定情報を取得するクラスです。
     *
     * @return DoBatchTokuchoDoteiProcess
     */
    @Step(同定情報を取得する)
    protected IBatchFlowCommand callGetDoteiJohoProcess() {
        return loopBatch(GetDoteiJohoProcess.class).
                arguments(getParameter().toGetDoteiJohoProcessParameter()).define();
    }

    /**
     * 未同定情報を取得するクラスです。
     *
     * @return DoBatchTokuchoDoteiProcess
     */
    @Step(未同定情報を取得する)
    protected IBatchFlowCommand callGetMiDoteiJohoProcess() {
        return loopBatch(GetMiDoteiJohoProcess.class).
                arguments(getParameter().toGetMiDoteiJohoProcessParameter()).define();
    }

}
