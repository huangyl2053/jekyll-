/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb011003;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003.DbT2002FukaZennendoTempInsertProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003.KarisanteiIkkatsuHakkoTempInsertProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003.PrintTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003.SystemTimeKarisanteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003.UpdChoteiGakuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003.UpdFukaJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003.UpdHihokenshaKubunProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.KarisanteiBatchEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴仮算定通知書一括発行するクラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class DBB011003_TokuchoKarisanteiTsuchishoHakko extends BatchFlowBase<TokuchoKaishiTsuchishoBatchParameter> {

    private static final String システム日時の取得 = "getSystemDate";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 仮算定一括発行一時テーブル作成 = "karisanteiShutoku";
    private static final String 前年度賦課情報一時テーブル作成 = "fukaZennendoShutoku";
    private static final String 更新前年度賦課情報 = "updFukaJoho";
    private static final String 更新特徴調定額 = "updChoteiGaku";
    private static final String 更新被保険者区分 = "updHihokenshaKubun";
    private static final String 通知書の発行 = "printTsuchisho";
    private static final RString BATCH_ID = new RString("KeisangoJohoSakuseiFlow");
    private static final RString 特別徴収開始通知書仮算定_帳票分類ID
            = new RString("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private KarisanteiBatchEntity 出力帳票Entity;

    @Override
    protected void defineFlow() {

        executeStep(システム日時の取得);
        List<KarisanteiBatchEntity> 出力帳票一覧List = getParameter().get出力帳票一覧();
        for (KarisanteiBatchEntity 出力帳票一覧 : 出力帳票一覧List) {
            if (!特別徴収開始通知書仮算定_帳票分類ID.equals(出力帳票一覧.get帳票分類ID().getColumnValue())) {
                continue;
            }
            出力帳票Entity = 出力帳票一覧;
            executeStep(計算後情報作成);
            executeStep(仮算定一括発行一時テーブル作成);
            executeStep(前年度賦課情報一時テーブル作成);
            executeStep(更新前年度賦課情報);
            executeStep(更新特徴調定額);
            executeStep(更新被保険者区分);
            executeStep(通知書の発行);
        }

    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step (システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        return simpleBatch(SystemTimeKarisanteiProcess.class).define();
    }

    /**
     * 計算後情報作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (計算後情報作成)
    protected IBatchFlowCommand keisangoJohoSakusei() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(特別徴収開始通知書仮算定_帳票分類ID)).define();
    }

    /**
     * 仮算定一括発行一時テーブル作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (仮算定一括発行一時テーブル作成)
    protected IBatchFlowCommand karisanteiShutoku() {
        return loopBatch(KarisanteiIkkatsuHakkoTempInsertProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * 前年度賦課情報一時テーブル作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (前年度賦課情報一時テーブル作成)
    protected IBatchFlowCommand fukaZennendoShutoku() {
        return loopBatch(DbT2002FukaZennendoTempInsertProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * 賦課情報取得作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (更新前年度賦課情報)
    protected IBatchFlowCommand updFukaJoho() {
        return simpleBatch(UpdFukaJohoProcess.class).define();
    }

    /**
     * 更新特徴調定額作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (更新特徴調定額)
    protected IBatchFlowCommand updChoteiGaku() {
        return simpleBatch(UpdChoteiGakuProcess.class).define();
    }

    /**
     * 更新被保険者区分作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (更新被保険者区分)
    protected IBatchFlowCommand updHihokenshaKubun() {
        return simpleBatch(UpdHihokenshaKubunProcess.class).define();
    }

    /**
     * 通知書の発行バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (通知書の発行)
    protected IBatchFlowCommand printTsuchisho() {
        return loopBatch(PrintTsuchishoProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    private KeisangoJohoSakuseiBatchParamter getKeisangoJohoSakuseiBatchParamter(RString 帳票分類ID) {
        return new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度().toDateString(),
                getParameter().get調定年度().toDateString(),
                null, null, 帳票分類ID);
    }

    private TokuchoKaishiTsuchishoProcessParameter createProcessParameter() {
        TokuchoKaishiTsuchishoProcessParameter parameter = new TokuchoKaishiTsuchishoProcessParameter();
        parameter.set調定年度(getParameter().get調定年度());
        parameter.set賦課年度(getParameter().get賦課年度());
        parameter.set出力対象(getParameter().get出力対象());
        parameter.set出力帳票一覧Entity(出力帳票Entity);
        parameter.set発行日(getParameter().get発行日());
        parameter.set帳票作成日時(getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeKarisanteiProcess.SYSTEM_TIME));
        parameter.set一括発行起動フラグ(getParameter().is一括発行起動フラグ());
        return parameter;
    }
}
