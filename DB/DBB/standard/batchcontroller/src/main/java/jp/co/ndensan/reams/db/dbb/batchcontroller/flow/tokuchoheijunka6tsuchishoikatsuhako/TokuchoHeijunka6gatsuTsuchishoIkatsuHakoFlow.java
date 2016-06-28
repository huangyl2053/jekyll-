package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.FukaZennendoTempTblCreateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.KeisangoForKoseimaeShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.KeizokuHihokenshaKubunUpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.KoseimaeJohoUpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.SystemTimeShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.TokuchoKibetsuKingaku06ShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.TokuchoKibetsuKingaku06UpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoA4TypeProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoB5TypeProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoIdoshaTorokuProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.KoseimaeJohoUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoKibetsuKingaku06ProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoIdoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
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
    private static final String 計算後情報更正前の取得 = "getKeisangoForKoseimae";
    private static final String 更正前情報の更新 = "koseimaeJohoUpdate";
    private static final String 前年度賦課情報一時テーブル作成 = "zennendoJohoCreate";
    private static final String 前年度特徴期別金額06の取得 = "tokuchoKibetsuKingaku06Shutoku";
    private static final String 前年度特徴期別金額06の更新 = "karisanteigakuTempTblUpdate";
    private static final String 継続の被保険者区分の更新 = "keizokuHihokenshaKubunUpdate";
    private static final String 被保険者区分4月開始 = "hihokenshaKubunTo4gatsuKaishi";
    private static final String 被保険者区分6月開始 = "hihokenshaKubunTo6gatsuKaishi";
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
        executeStep(計算後情報更正前の取得);
        executeStep(更正前情報の更新);
        executeStep(前年度賦課情報一時テーブル作成);
        executeStep(前年度特徴期別金額06の取得);
        executeStep(前年度特徴期別金額06の更新);
        executeStep(継続の被保険者区分の更新);
        executeStep(被保険者区分4月開始);
        executeStep(被保険者区分6月開始);

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
     * 計算後情報更正前の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報更正前の取得)
    protected IBatchFlowCommand getKeisangoForKoseimae() {
        return loopBatch(KeisangoForKoseimaeShutokuProcess.class)
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
        return loopBatch(KoseimaeJohoUpdateProcess.class)
                .arguments(createKoseimaeUpdateParameter())
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
     * 前年度・特徴期別金額06の更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(前年度特徴期別金額06の取得)
    protected IBatchFlowCommand tokuchoKibetsuKingaku06Shutoku() {
        return simpleBatch(TokuchoKibetsuKingaku06ShutokuProcess.class)
                .define();
    }

    /**
     * 前年度特徴期別金額06の更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(前年度特徴期別金額06の更新)
    protected IBatchFlowCommand karisanteigakuTempTblUpdate() {
        return loopBatch(TokuchoKibetsuKingaku06UpdateProcess.class)
                .arguments(create前年度特徴期別金額06パラメータ())
                .define();
    }

    /**
     * 継続の被保険者区分を更新します。
     *
     * @return バッチコマンド
     */
    @Step(継続の被保険者区分の更新)
    protected IBatchFlowCommand keizokuHihokenshaKubunUpdate() {
        return loopBatch(KeizokuHihokenshaKubunUpdateProcess.class)
                .define();
    }

    /**
     * 4月開始の被保険者区分を更新します。
     *
     * @return バッチコマンド
     */
    @Step(被保険者区分4月開始)
    protected IBatchFlowCommand hihokenshaKubunTo4gatsuKaishi() {
        return loopBatch(KeizokuHihokenshaKubunUpdateProcess.class)
                .define();
    }

    /**
     * 6月開始の被保険者区分を更新します。
     *
     * @return バッチコマンド
     */
    @Step(被保険者区分6月開始)
    protected IBatchFlowCommand hihokenshaKubunTo6gatsuKaishi() {
        return loopBatch(KeizokuHihokenshaKubunUpdateProcess.class)
                .define();
    }

    /**
     * 通知書の発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(通知書の発行)
    protected IBatchFlowCommand tsuchishoHako() {
        int size = getParameter().get出力帳票entity().size();
        if (size == 0) {
            return null;
        }
        OutputChohyoIchiran 出力帳票entity;
        for (int i = 0; i < size - 1; i++) {
            出力帳票entity = getParameter().get出力帳票entity().get(i);
            if (ReportIdDBB.DBB100012.getReportId().getColumnValue().equals(出力帳票entity.get帳票ID())) {
                loopBatch(TsuchishoHakoB5TypeProcess.class).arguments(create通知書発行パラメータ(出力帳票entity)).define();
            } else {
                loopBatch(TsuchishoHakoA4TypeProcess.class).arguments(create通知書発行パラメータ(出力帳票entity)).define();
            }
        }
        出力帳票entity = getParameter().get出力帳票entity().get(size - 1);
        if (ReportIdDBB.DBB100012.getReportId().getColumnValue().equals(出力帳票entity.get帳票ID())) {
            return loopBatch(TsuchishoHakoB5TypeProcess.class).arguments(create通知書発行パラメータ(出力帳票entity)).define();
        }
        return loopBatch(TsuchishoHakoA4TypeProcess.class).arguments(create通知書発行パラメータ(出力帳票entity)).define();
    }

    /**
     * 通知書発行後異動者の登録を行います。
     *
     * @return バッチコマンド
     */
    @Step(通知書発行後異動者の登録)
    protected IBatchFlowCommand tsuchishoIdoshaToroku() {
        return loopBatch(TsuchishoIdoshaTorokuProcess.class)
                .arguments(createTsuchishoIdoshaTorokuProcessParameter())
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

    private KoseimaeJohoUpdateProcessParameter createKoseimaeUpdateParameter() {

        KoseimaeJohoUpdateProcessParameter parameter = new KoseimaeJohoUpdateProcessParameter();
        List<DbTKeisangoJohoTempTableEntity> 計算後List = new ArrayList<>();
        if (getResult(List.class, new RString(計算後情報更正前の取得), KeisangoForKoseimaeShutokuProcess.KEISANGO) != null) {
            計算後List = getResult(List.class, new RString(計算後情報更正前の取得), KeisangoForKoseimaeShutokuProcess.KEISANGO);
        }
        parameter.set計算後List(計算後List);
        return parameter;
    }

    private TsuchishoIdoshaTorokuProcessParameter createTsuchishoIdoshaTorokuProcessParameter() {

        TsuchishoIdoshaTorokuProcessParameter parameter = new TsuchishoIdoshaTorokuProcessParameter();
        parameter.set出力対象区分(getParameter().get出力対象指示フラグ());
        parameter.set調定年度(getParameter().get調定年度());
        parameter.set賦課年度(getParameter().get賦課年度());
        parameter.set発行日(getParameter().get発行日());
        parameter.set帳票作成日時(getResult(RDateTime.class, new RString(システム日時の取得), SystemTimeShutokuProcess.SYSTEM_TIME));
        parameter.set基準日時(getResult(RString.class, new RString(システム日時の取得), SystemTimeShutokuProcess.KIJUN_TIME));
        parameter.set出力帳票entity(getParameter().get出力帳票entity());

        return parameter;
    }

    private TsuchishoHakoProcessParameter create通知書発行パラメータ(OutputChohyoIchiran 出力帳票entity) {

        TsuchishoHakoProcessParameter param = new TsuchishoHakoProcessParameter();

        param.set帳票分類ID(出力帳票entity.get帳票分類ID());
        param.set調定年度(getParameter().get調定年度());
        param.set賦課年度(getParameter().get賦課年度());
        param.set出力対象区分(Integer.valueOf(getParameter().get出力対象指示フラグ().toString()));
        param.set発行日(getParameter().get発行日());
        param.set帳票作成日時(getResult(RDateTime.class, new RString(システム日時の取得), SystemTimeShutokuProcess.SYSTEM_TIME));
        param.set出力順ID(出力帳票entity.get出力順ID());
        param.set帳票ID(出力帳票entity.get帳票ID());
        param.set一括発行フラグ(getParameter().is一括発行フラグ());

        return param;
    }

    private TokuchoKibetsuKingaku06ProcessParameter create前年度特徴期別金額06パラメータ() {
        RString 前年度特徴期別金額06 = getResult(RString.class,
                new RString(前年度特徴期別金額06の取得), TokuchoKibetsuKingaku06ShutokuProcess.TOKUCHOKIBETSU_KINGAKU06);

        TokuchoKibetsuKingaku06ProcessParameter param = new TokuchoKibetsuKingaku06ProcessParameter();
        param.set前年度特徴期別金額06(前年度特徴期別金額06);
        return param;
    }

}
