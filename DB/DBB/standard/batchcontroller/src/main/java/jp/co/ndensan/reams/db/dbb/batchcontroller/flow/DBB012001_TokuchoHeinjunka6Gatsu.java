/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001.HeinjunkaFukaTaishoBunkatuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001.HeinjunkaKeisanProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001.InsFukaTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001.InsHeinjunkaFukaTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001.PrtKaigoFukaTokuchoHeijunkaTaishogaiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001.PrtKaigoFukaTokuchoHeijunkaTaishoshaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001.PrtReportOutputJokenhyoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012001.DBB012001_TokuchoHeinjunka6GatsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
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
 * 特徴平準化（特徴6月分）バッチクラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class DBB012001_TokuchoHeinjunka6Gatsu extends BatchFlowBase<DBB012001_TokuchoHeinjunka6GatsuParameter> {

    private static final String 計算後情報作成 = "keisangoJohoSakuseiProcess";
    private static final String 対象者と対象外データを一時テーブルに登録 = "HeinjunkaFukaTaishoBunkatuProcess";
    private static final String 平準化計算 = "HeinjunkaKeisanProcess";
    private static final String 平準化前賦課出力 = "InsHeinjunkaFukaTmpProcess";
    private static final String 対象者の帳票出力 = "PrtKaigoFukaTokuchoHeijunkaTaishoshaProcess";
    private static final String 対象外の帳票出力 = "PrtKaigoFukaTokuchoHeijunkaTaishogaiProcess";
    private static final String 賦課の情報一時テーブルに賦課情報を登録 = "InsFukaTmpProcess";
    private static final String 賦課情報の登録 = "FukaJohoToroku";
    private static final String バッチ出力条件表 = "PrtReportOutputJokenhyoProcess";
    private static final String 処理日付管理テーブル更新 = "updateSystemTimeProcess";
    private static final RString BATCH_ID = new RString("KeisangoJohoSakuseiFlow");
    private static final RString FUKAJOHOTOROKUFLOW_FLOWID = new RString("DBB004001_FukaJohoToroku");
    private static RString 対象者ページ数;
    private static RString 対象外ページ数;
    private static final int YEAR_ONE = 1;

    private DBB012001_TokuchoHeinjunka6GatsuParameter parameter;
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
        executeStep(平準化前賦課出力);
        executeStep(対象者と対象外データを一時テーブルに登録);
        executeStep(平準化計算);
        executeStep(賦課の情報一時テーブルに賦課情報を登録);
        executeStep(賦課情報の登録);
        executeStep(計算後情報作成);
        executeStep(対象者の帳票出力);
        対象者ページ数 = getResult(RString.class, new RString(対象者の帳票出力), PrtKaigoFukaTokuchoHeijunkaTaishoshaProcess.PAGE_COUNT);
        executeStep(対象外の帳票出力);
        対象外ページ数 = getResult(RString.class, new RString(対象外の帳票出力), PrtKaigoFukaTokuchoHeijunkaTaishogaiProcess.PAGE_COUNT);
        executeStep(バッチ出力条件表);
        executeStep(処理日付管理テーブル更新);
    }

    /**
     * 平準化前賦課Temp出力を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(平準化前賦課出力)
    protected IBatchFlowCommand insHeinjunkaFukaTmpProcess() {
        return loopBatch(InsHeinjunkaFukaTmpProcess.class).arguments(createParameter()).define();
    }

    /**
     * 対象者と対象外データを一時テーブルに登録を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(対象者と対象外データを一時テーブルに登録)
    protected IBatchFlowCommand heinjunkaFukaTaishoBunkatuProcess() {
        return loopBatch(HeinjunkaFukaTaishoBunkatuProcess.class).arguments(createParameter()).define();
    }

    /**
     * 平準化計算を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(平準化計算)
    protected IBatchFlowCommand heinjunkaKeisanProcess() {
        return loopBatch(HeinjunkaKeisanProcess.class).arguments(createParameter()).define();
    }

    /**
     * 賦課の情報一時テーブルに賦課情報を登録を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(賦課の情報一時テーブルに賦課情報を登録)
    protected IBatchFlowCommand insFukaTmpProcess() {
        return loopBatch(InsFukaTmpProcess.class).arguments(createParameter()).define();
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
     * 対象者の帳票出力を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(対象者の帳票出力)
    protected IBatchFlowCommand prtKaigoFukaTokuchoHeijunkaTaishoshaProcess() {
        return loopBatch(PrtKaigoFukaTokuchoHeijunkaTaishoshaProcess.class).arguments(createParameter()).define();
    }

    /**
     * 対象外の帳票出力を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(対象外の帳票出力)
    protected IBatchFlowCommand prtKaigoFukaTokuchoHeijunkaTaishogaiProcess() {
        return loopBatch(PrtKaigoFukaTokuchoHeijunkaTaishogaiProcess.class).arguments(createParameter()).define();
    }

    /**
     * バッチ出力条件表を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(バッチ出力条件表)
    protected IBatchFlowCommand prtReportOutputJokenhyoProcess() {
        return simpleBatch(PrtReportOutputJokenhyoProcess.class).arguments(createParameter()).define();
    }

    /**
     * 処理日付管理テーブル更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(処理日付管理テーブル更新)
    protected IBatchFlowCommand updateSystemTimeProcess() {
        return simpleBatch(UpdShoriDateKanriProcess.class).arguments(createParameter()).define();
    }

    private TokuchoHeinjunka6GatsuProcessParameter createParameter() {
        TokuchoHeinjunka6GatsuProcessParameter param = new TokuchoHeinjunka6GatsuProcessParameter();
        param.set調定年度(parameter.get調定年度());
        param.set賦課年度(parameter.get賦課年度());
        param.set増額平準化方法(parameter.get増額平準化方法());
        param.set減額平準化方法(parameter.get減額平準化方法());
        OutputChohyoIchiran 出力帳票一覧 = new OutputChohyoIchiran();
        if (!parameter.get出力帳票entity().isEmpty()) {
            出力帳票一覧.set出力順ID(parameter.get出力帳票entity().get(0).get出力順ID());
            param.set出力帳票一覧(出力帳票一覧);
        }
        param.set出力対象(parameter.get出力対象());
        param.set調定日時(システム日時);
        param.set調定前年度(parameter.get調定年度().minusYear(YEAR_ONE));
        if (対象者ページ数 != null && 対象外ページ数 != null) {
            param.set出力ページ数(Integer.parseInt(対象者ページ数.toString()) + Integer.parseInt(対象外ページ数.toString()));
        }
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        param.setShikibetsutaishoParam(new UaFt200FindShikibetsuTaishoParam(searchKey));
        return param;
    }
}
