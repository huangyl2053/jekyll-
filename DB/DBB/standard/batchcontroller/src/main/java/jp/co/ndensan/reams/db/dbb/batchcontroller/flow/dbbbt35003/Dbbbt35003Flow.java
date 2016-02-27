package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbbbt35003;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt35003.ChohyoHakkoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt35003.FukaJohoShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt35003.SystemTimeShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt35003.TsuchishoIdoshaTorokuProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.dbbbt35003.Dbbbt35003FlowParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35003.ChohyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35003.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35003.TsuchishoIdoshaTorokuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 特徴平準化（特徴6月分）通知書一括発行のバッチフロークラスです。
 */
public class Dbbbt35003Flow extends BatchFlowBase<Dbbbt35003FlowParameter> {

    private static final String システム日時の取得 = "getSystemDate";
    private static final String 賦課情報の取得 = "fukaJohoShutoku";
    private static final String 帳票の発行 = "chohyoHakko";
    private static final String 通知書発行後異動者の登録 = "tsuchishoIdoshaToroku";

    @Override
    protected void defineFlow() {

        executeStep(システム日時の取得);
        executeStep(賦課情報の取得);
        executeStep(帳票の発行);
        executeStep(通知書発行後異動者の登録);
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        return simpleBatch(SystemTimeShutokuProcess.class)
                .define();
    }

    /**
     * 賦課情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(賦課情報の取得)
    protected IBatchFlowCommand fukaJohoShutoku() {
        return simpleBatch(FukaJohoShutokuProcess.class)
                .arguments(createFukaJohoShutokuParameter())
                .define();
    }

    /**
     * 帳票の発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(帳票の発行)
    protected IBatchFlowCommand chohyoHakko() {
        return simpleBatch(ChohyoHakkoProcess.class)
                .arguments(createChohyoHakkoParameter())
                .define();
    }

    /**
     * 通知書発行後異動者の登録を行います。
     *
     * @return バッチコマンド
     */
    @Step(通知書発行後異動者の登録)
    protected IBatchFlowCommand tsuchishoIdoshaToroku() {
        return simpleBatch(TsuchishoIdoshaTorokuProcess.class)
                .arguments(createTsuchishoIdoshaTorokuParameter())
                .define();
    }

    private FukaJohoShutokuProcessParameter createFukaJohoShutokuParameter() {

        FukaJohoShutokuProcessParameter parameter = new FukaJohoShutokuProcessParameter();
//        parameter.set調定年度(getParameter().get調定年度());
//        parameter.set一括発行フラグ(getParameter().is一括発行フラグ());
        return parameter;
    }

    private ChohyoHakkoProcessParameter createChohyoHakkoParameter() {

        ChohyoHakkoProcessParameter parameter = new ChohyoHakkoProcessParameter();
//        parameter.set調定年度(getParameter().get調定年度());
//        parameter.set出力対象区分(getParameter().get出力対象());
//        parameter.set発行日(getParameter().get発行日());
//        parameter.set帳票作成日時(getResult(RDateTime.class, new RString(システム日時の取得), SystemTimeShutokuProcess.SYSTEM_TIME));
//        parameter.set出力帳票一覧List(getParameter().get出力帳票一覧List());
        return parameter;
    }

    private TsuchishoIdoshaTorokuProcessParameter createTsuchishoIdoshaTorokuParameter() {

        TsuchishoIdoshaTorokuProcessParameter parameter = new TsuchishoIdoshaTorokuProcessParameter();
//        parameter.set出力対象区分(getParameter().get出力対象());
//        parameter.set帳票作成日時(getResult(RDateTime.class, new RString(システム日時の取得), SystemTimeShutokuProcess.SYSTEM_TIME));
//        parameter.set出力帳票一覧List(getParameter().get出力帳票一覧List());
        return parameter;
    }

}
