/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.CreateTaishogaiKeisanReprotProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.CreateTaishoshaKeisanReportProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.DelHeijunkaZenFukaTemp1Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.DelHeijunkaZenFukaTemp2Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.GetChukibetuRankJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.GetFukaJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.GetShiKakuJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.HeinjunkaFukaTaishoBunkatuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.InsFukaErrorTbl1Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.InsFukaErrorTbl2Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.InsSetaiTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.InsShikakuJyohoTaishoKeisanTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.InsertKaigoFukaTblProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001.InsertKaigoKibetsuTblProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB013001.DBB013001_TokuchoHeinjunka8GatsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb013001.TokuchoHeinjunka8GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴8月分）バッチクラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class DBB013001_TokuchoHeinjunka8Gatsu extends BatchFlowBase<DBB013001_TokuchoHeinjunka8GatsuParameter> {

    private static final String 資格情報TEMP一時テーブルに登録 = "GetShiKakuJohoProcess";
    private static final String 平準化前賦課TEMPテーブルに登録 = "GetFukaJohoProcess";
    private static final String 賦課情報あり_賦課エラー一覧テーブルに登録 = "InsFukaErrorTbl1Process";
    private static final String 特徴停止_賦課エラー一覧テーブルに登録 = "InsFukaErrorTbl2Process";
    private static final String 賦課情報あり_平準化前賦課TEMPテーブルに削除 = "DelHeijunkaZenFukaTEMP1Process";
    private static final String 特徴停止_平準化前賦課TEMPテーブルに削除 = "DelHeijunkaZenFukaTEMP2Process";
    private static final String 月別ランクTEMP一時テーブルに登録 = "GetChukibetuRankJohoProcess";
    private static final String 世帯員把握入力テーブルに登録 = "InsertKaigoFukaTblProcess";
    private static final String 世帯員所得情報登録 = "setaiinHaaku";
    private static final String 平準化前賦課TEMP一時テーブルに登録 = "heinjunkaFukaTaishoBunkatu";
    private static final String 計算後情報作成 = "keisangoJohoSakuseiProcess";
    private static final String 平準化前賦課出力 = "InsHeinjunkaFukaTmpProcess";
    private static final RString BATCH_ID = new RString("DBB003001_KeisangoJohoSakusei");
    private static final RString BATCH_ID_2 = new RString("DBB002001_SetaiinHaaku");
    private static final RString FUKAJOHOTOROKUFLOW_FLOWID = new RString("DBB004001_FukaJohoToroku");
    private static final String 対象者のデータ取得と帳票とEUCファイル出力 = "CreateTaishoshaKeisanReportProcess";
    private static final String 対象外のデータ取得と帳票とEUCファイル出力 = "CreateTaishogaiKeisanReprotProcess";
    private static final String 賦課情報の登録 = "FukaJohoToroku";

    private static final String 資格情報対象計算TEMPテーブルに登録 = "insShikakuJyohoTaishoKeisanTemp";
    private static final String 賦課計算_世帯員 = "insSetaiTempProcess";
    private static final String 賦課計算 = "caluculateFuka";

    private DBB013001_TokuchoHeinjunka8GatsuParameter parameter;
    private YMDHMS システム日時;

    @Override
    protected void initialize() {
        システム日時 = YMDHMS.now();
    }

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null) {
            return;
        }
        executeStep(資格情報TEMP一時テーブルに登録);
        executeStep(平準化前賦課TEMPテーブルに登録);
        executeStep(賦課情報あり_賦課エラー一覧テーブルに登録);
        executeStep(賦課情報あり_平準化前賦課TEMPテーブルに削除);
        executeStep(特徴停止_賦課エラー一覧テーブルに登録);
        executeStep(特徴停止_平準化前賦課TEMPテーブルに削除);
        executeStep(月別ランクTEMP一時テーブルに登録);
        executeStep(世帯員把握入力テーブルに登録);
        executeStep(世帯員所得情報登録);
        executeStep(平準化前賦課TEMP一時テーブルに登録);

        executeStep(資格情報対象計算TEMPテーブルに登録);
        executeStep(賦課計算_世帯員);
        executeStep(賦課計算);
        executeStep(賦課情報の登録);
        executeStep(計算後情報作成);

        executeStep(対象者のデータ取得と帳票とEUCファイル出力);
        executeStep(対象外のデータ取得と帳票とEUCファイル出力);
    }

    /**
     * 資格情報TEMP一時テーブルに登録を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(資格情報TEMP一時テーブルに登録)
    protected IBatchFlowCommand insHeinjunkaFukaTmpProcess() {
        return loopBatch(GetShiKakuJohoProcess.class).arguments(createParameter()).define();
    }

    /**
     * 平準化前賦課TEMPテーブルに登録を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(平準化前賦課TEMPテーブルに登録)
    protected IBatchFlowCommand getFukaJohoProcess() {
        return loopBatch(GetFukaJohoProcess.class).arguments(createParameter()).define();
    }

    /**
     * 賦課情報あり_賦課エラー一覧テーブルに登録を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(賦課情報あり_賦課エラー一覧テーブルに登録)
    protected IBatchFlowCommand insFukaErrorTbl1Process() {
        return loopBatch(InsFukaErrorTbl1Process.class).arguments(createParameter()).define();
    }

    /**
     * 特徴停止_賦課エラー一覧テーブルに登録を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(特徴停止_賦課エラー一覧テーブルに登録)
    protected IBatchFlowCommand insFukaErrorTbl2Process() {
        return loopBatch(InsFukaErrorTbl2Process.class).arguments(createParameter()).define();
    }

    /**
     * 賦課情報あり_平準化前賦課TEMPテーブルに削除を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(賦課情報あり_平準化前賦課TEMPテーブルに削除)
    protected IBatchFlowCommand delHeijunkaZenFukaTEMP1Process() {
        return simpleBatch(DelHeijunkaZenFukaTemp1Process.class).define();
    }

    /**
     * 特徴停止_平準化前賦課TEMPテーブルに削除を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(特徴停止_平準化前賦課TEMPテーブルに削除)
    protected IBatchFlowCommand delHeijunkaZenFukaTEMP2Process() {
        return simpleBatch(DelHeijunkaZenFukaTemp2Process.class).arguments(createParameter()).define();
    }

    /**
     * 月別ランクTEMP一時テーブルに登録を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(月別ランクTEMP一時テーブルに登録)
    protected IBatchFlowCommand getChukibetuRankJohoProcess() {
        return loopBatch(GetChukibetuRankJohoProcess.class).arguments(createParameter()).define();
    }

    /**
     * 世帯員把握入力テーブルに登録を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握入力テーブルに登録)
    protected IBatchFlowCommand insertKaigoFukaTblProcess() {
        return loopBatch(InsertKaigoFukaTblProcess.class).define();
    }

    /**
     * 平準化前賦課Temp一時テーブルに登録を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(平準化前賦課TEMP一時テーブルに登録)
    protected IBatchFlowCommand heinjunkaFukaTaishoBunkatuProcess() {
        return loopBatch(HeinjunkaFukaTaishoBunkatuProcess.class).define();
    }

    /**
     * 計算後情報作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand keisangoJohoSakuseiProcess() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課,
                getParameter().toKeisangoJohoSakuseiBatchParamter(システム日時)).define();
    }

    /**
     * 世帯員把握（バッチ）を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(世帯員所得情報登録)
    protected IBatchFlowCommand setaiinHaakuProcess() {
        return otherBatchFlow(BATCH_ID_2, SubGyomuCode.DBB介護賦課,
                new DBB002001_SetaiinHaakuParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード())).define();
    }

    /**
     * 対象者のデータ取得と帳票とEUCファイル出力を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(対象者のデータ取得と帳票とEUCファイル出力)
    protected IBatchFlowCommand createTaishoshaKeisanReportProcess() {
        return loopBatch(CreateTaishoshaKeisanReportProcess.class).arguments(createParameter()).define();
    }

    /**
     * 対象外のデータ取得と帳票とEUCファイル出力を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(対象外のデータ取得と帳票とEUCファイル出力)
    protected IBatchFlowCommand createTaishogaiKeisanReportProcess() {
        return loopBatch(CreateTaishogaiKeisanReprotProcess.class).arguments(createParameter()).define();
    }

    /**
     * 平準化前賦課TEMP出力を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(平準化前賦課出力)
    protected IBatchFlowCommand getShiKakuJohoProcess() {
        return loopBatch(GetShiKakuJohoProcess.class).arguments(createParameter()).define();
    }

    /**
     * 賦課計算中間一時テーブルに登録のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(資格情報対象計算TEMPテーブルに登録)
    protected IBatchFlowCommand insShikakuJyohoTaishoKeisanTempProcess() {
        return loopBatch(InsShikakuJyohoTaishoKeisanTempProcess.class).arguments(createParameter()).define();
    }

    /**
     * 賦課計算中間一時テーブルに登録のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算_世帯員)
    protected IBatchFlowCommand insSetaiTemp() {
        return loopBatch(InsSetaiTempProcess.class).define();
    }

    /**
     * 賦課計算_賦課のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算)
    protected IBatchFlowCommand insertKaigoKibetsuTbl() {
        return loopBatch(InsertKaigoKibetsuTblProcess.class).arguments(createParameter()).define();
    }

    /**
     * 賦課情報の登録
     *
     * @return 賦課の情報登録フロー
     */
    @Step(賦課情報の登録)
    protected IBatchFlowCommand fukaJohoToroku() {
        return otherBatchFlow(FUKAJOHOTOROKUFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getParameter().toFukaJohoTorokuBatchParameter()).define();
    }

    private TokuchoHeinjunka8GatsuProcessParameter createParameter() {
        TokuchoHeinjunka8GatsuProcessParameter param = new TokuchoHeinjunka8GatsuProcessParameter();
        param.set調定年度(parameter.get調定年度());
        param.set賦課年度(parameter.get賦課年度());
        param.set調定日時(システム日時);
        param.set出力順ID(parameter.get出力順ID());
        param.set増額平準化方法(parameter.get増額平準化方法());
        param.set減額平準化方法(parameter.get減額平準化方法());
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        param.setShikibetsutaishoParam(new UaFt200FindShikibetsuTaishoParam(searchKey));
        return param;
    }
}
