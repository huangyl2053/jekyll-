package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.FukaZennendoTempTblCreateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.KarisanteigakuTempTblUpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.KoseimaeJohoUpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.SystemTimeShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoIdoshaTorokuProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴6月分）通知書一括発行のバッチフロークラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlow extends BatchFlowBase<TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter> {

    private static final String システム日時の取得 = "getSystemDate";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 仮算定額変更情報一時テーブル作成 = "fukaJohoShutoku";
    private static final String 更正前情報の更新 = "koseimaeJohoUpdate";
    private static final String 前年度賦課情報一時テーブル作成 = "zennendoJohoCreate";
    private static final String 仮算定額変更情報一時テーブルの更新 = "karisanteigakuTempTblUpdate";
    private static final String 通知書の発行 = "tsuchishoHako";
    private static final String 通知書発行後異動者の登録 = "tsuchishoIdoshaToroku";

    private static final RString BATCH_ID = new RString("KeisangoJohoSakuseiFlow");

    @Override
    protected void defineFlow() {

        if (getParameter().is一括発行フラグ()) {
            executeStep(システム日時の取得);
            executeStep(計算後情報作成);
        }

        executeStep(仮算定額変更情報一時テーブル作成);
        executeStep(更正前情報の更新);
        executeStep(前年度賦課情報一時テーブル作成);
        executeStep(仮算定額変更情報一時テーブルの更新);

        executeStep(通知書の発行);

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
                .arguments(createFukaJohoShutokuParameter())
                .define();
    }

    /**
     * 計算後情報作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand keisangoJohoSakusei() {
        int size = getParameter().get出力帳票entity().size();
        if (size == 0) {
            return null;
        }
        OutputChohyoIchiran 出力帳票entity;
        for (int i = 0; i < size - 1; i++) {
            出力帳票entity = getParameter().get出力帳票entity().get(i);
            otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課, getKeisangoJohoSakuseiBatchParamter(出力帳票entity.get帳票分類ID())).define();
        }
        出力帳票entity = getParameter().get出力帳票entity().get(size - 1);
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課, getKeisangoJohoSakuseiBatchParamter(出力帳票entity.get帳票分類ID())).define();
    }

    /**
     * 仮算定額変更情報一時テーブル作成と賦課情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(仮算定額変更情報一時テーブル作成)
    protected IBatchFlowCommand fukaJohoShutoku() {
        return loopBatch(FukaJohoShutokuProcess.class)
                .arguments(createFukaJohoShutokuParameter())
                .define();
    }

    /**
     * 「更正前」計算後情報全項目の更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(更正前情報の更新)
    protected IBatchFlowCommand koseimaeJohoUpdate() {
        return simpleBatch(KoseimaeJohoUpdateProcess.class)
                .arguments(createFukaJohoShutokuParameter())
                .define();
    }

    /**
     * 前年度賦課情報一時テーブルの作成と情報登録を行います。
     *
     * @return バッチコマンド
     */
    @Step(前年度賦課情報一時テーブル作成)
    protected IBatchFlowCommand zennendoJohoCreate() {
        return loopBatch(FukaZennendoTempTblCreateProcess.class)
                .arguments(createFukaJohoShutokuParameter())
                .define();
    }

    /**
     * 仮算定額変更情報一時テーブルの更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(仮算定額変更情報一時テーブルの更新)
    protected IBatchFlowCommand karisanteigakuTempTblUpdate() {
        return simpleBatch(KarisanteigakuTempTblUpdateProcess.class)
                .define();
    }

    /**
     * 通知書の発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(通知書の発行)
    protected IBatchFlowCommand tsuchishoHako() {
        RDateTime 帳票作成日時 = getResult(RDateTime.class, new RString(システム日時の取得), SystemTimeShutokuProcess.SYSTEM_TIME);
        int size = getParameter().get出力帳票entity().size();
        if (size == 0) {
            return null;
        }
        OutputChohyoIchiran 出力帳票entity;
        for (int i = 0; i < size - 1; i++) {
            出力帳票entity = getParameter().get出力帳票entity().get(i);
            loopBatch(TsuchishoHakoProcess.class).arguments(create通知書発行パラメータ(出力帳票entity, 帳票作成日時)).define();
        }
        出力帳票entity = getParameter().get出力帳票entity().get(size - 1);
        return loopBatch(TsuchishoHakoProcess.class).arguments(create通知書発行パラメータ(出力帳票entity, 帳票作成日時)).define();
    }

    /**
     * 通知書発行後異動者の登録を行います。
     *
     * @return バッチコマンド
     */
    @Step(通知書発行後異動者の登録)
    protected IBatchFlowCommand tsuchishoIdoshaToroku() {
        return simpleBatch(TsuchishoIdoshaTorokuProcess.class)
                .arguments(createChohyoHakkoParameter())
                .define();
    }

    private KeisangoJohoSakuseiBatchParamter getKeisangoJohoSakuseiBatchParamter(RString 帳票分類ID) {
        KeisangoJohoSakuseiBatchParamter parameter = new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度().toDateString(),
                getParameter().get賦課年度().toDateString(),
                getResult(RString.class, new RString(システム日時の取得), SystemTimeShutokuProcess.KIJUN_TIME),
                null, 帳票分類ID);

        return parameter;
    }

    private FukaJohoShutokuProcessParameter createFukaJohoShutokuParameter() {

        FukaJohoShutokuProcessParameter parameter = new FukaJohoShutokuProcessParameter();
        parameter.set調定年度(getParameter().get調定年度());
        parameter.set一括発行フラグ(getParameter().is一括発行フラグ());
        return parameter;
    }

    private TsuchishoHakoProcessParameter createChohyoHakkoParameter() {

        TsuchishoHakoProcessParameter parameter = new TsuchishoHakoProcessParameter();
        parameter.set出力対象区分(getParameter().get出力対象指示フラグ());
        parameter.set調定年度(getParameter().get調定年度());
        parameter.set賦課年度(getParameter().get賦課年度());
        parameter.set発行日(getParameter().get発行日());
        parameter.set帳票作成日時(getResult(RDateTime.class, new RString(システム日時の取得), SystemTimeShutokuProcess.SYSTEM_TIME));
        parameter.set出力帳票entity(getParameter().get出力帳票entity());

        return parameter;
    }

    private TsuchishoHakoEntity create通知書発行パラメータ(OutputChohyoIchiran 出力帳票entity, RDateTime 帳票作成日時) {

        TsuchishoHakoEntity param = new TsuchishoHakoEntity();

        param.set帳票分類ID(出力帳票entity.get帳票分類ID());
        param.set調定年度(getParameter().get調定年度());
        param.set賦課年度(getParameter().get賦課年度());
        param.set出力対象区分(Integer.valueOf(getParameter().get出力対象指示フラグ().toString()));
        param.set発行日(getParameter().get発行日());
        param.set帳票作成日時(帳票作成日時);
        param.set出力順ID(出力帳票entity.get出力順ID());
        param.set帳票ID(出力帳票entity.get帳票ID());
        param.set一括発行フラグ(getParameter().is一括発行フラグ());

        return param;
    }

}
