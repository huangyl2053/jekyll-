/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001.CollectSetaiinProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001.InsFukaJohoTmepProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001.InsFukaKeisanTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001.InsFukaTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001.InsSortTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001.PrtFuchoKarisanteiKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001.SelectKeisanTaishoshaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001.SelectZenFukaDataProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB003001.DBB003001_KeisangoJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB004001.DBB004001_FukaJohoTorokuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014001.DBB014001_FuchoKarisanteiFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定賦課のバッチフロークラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class DBB014001_FuchoKarisanteiFuka extends BatchFlowBase<DBB014001_FuchoKarisanteiFukaParameter> {

    private static final String 計算対象者抽出 = "SelectKeisanTaishoshaProcess";
    private static final String 前年度データ取得 = "SelectZenFukaDataProcess";
    private static final String 世帯員把握 = "CollectSetaiinProcess";
    private static final String 世帯員把握フロー = "SetaiinBatchFlow";
    private static final String 賦課計算_賦課 = "InsFukaJohoTmepProcess";
    private static final String 賦課計算_中間 = "InsFukaKeisanTempProcess";
    private static final String 賦課計算 = "InsFukaTempProcess";
    private static final String 普徴仮算定結果 = "PrtFuchoKarisanteiKekkaIchiranProcess";
    private static final String 処理日付管理テーブル更新 = "UpdShoriDateKanriProcess";
    private static final String 出力順設定 = "InsSortTempProcess";
    private static final String 普徴仮算定通知書一括発行 = "fuchoKarisanteiTsuchishoHakko";

    private static final RString 世帯員把握BATCH_ID = new RString("DBB002001_SetaiinHaaku");
    private static final ReportId 帳票ID = new ReportId("DBB200006_FutsuChoshuKarisanteiKekkaIchiran");
    private static final RString 賦課の情報登録フローBATCHID = new RString("DBB004001_FukaJohoToroku");
    private static final String 賦課情報登録 = "callChoteiToroku";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final RString 計算後情報作成BATCH_ID = new RString("DBB003001_KeisangoJohoSakusei");
    private static final RString 普徴仮算定通知書一括発行BATCH_ID = new RString("DBB014003_FuchoKarisanteiTsuchishoHakko");

    private static final int NUM_1 = 1;
    private static final int NUM_4 = 4;
    private static final RString 仮算定賦課方法_01 = new RString("01");
    private static final RString 仮算定賦課方法_02 = new RString("02");
    private static final RString 仮算定賦課方法_03 = new RString("03");
    private static final RString 仮算定賦課方法_04 = new RString("04");
    private static final RString 仮算定賦課方法_05 = new RString("05");
    private static final RString 仮算定賦課方法_06 = new RString("06");
    private static final RString 仮算定賦課方法_10 = new RString("10");
    private static final RString 仮算定賦課方法_11 = new RString("11");

    private RDateTime バッチ起動日時;

    @Override
    protected void defineFlow() {
        boolean flag1 = false;
        boolean flag2 = false;
        for (HonsanteifukaBatchTyouhyou 出力帳票一覧 : getParameter().get出力帳票一覧()) {
            if (帳票ID.equals(出力帳票一覧.get帳票ID())) {
                flag1 = true;
            } else {
                flag2 = true;
            }
        }
        if (!flag1) {
            return;
        }
        バッチ起動日時 = RDateTime.now();
        executeStep(計算対象者抽出);
        RDate 調定年度開始日 = new RDate(getParameter().get調定年度().getYearValue(), NUM_4, NUM_1);
        RString 普通徴収_仮算定賦課方法
                = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定賦課方法, 調定年度開始日, SubGyomuCode.DBB介護賦課);
        if (仮算定賦課方法_01.equals(普通徴収_仮算定賦課方法) || 仮算定賦課方法_02.equals(普通徴収_仮算定賦課方法)
                || 仮算定賦課方法_03.equals(普通徴収_仮算定賦課方法) || 仮算定賦課方法_04.equals(普通徴収_仮算定賦課方法)
                || 仮算定賦課方法_05.equals(普通徴収_仮算定賦課方法) || 仮算定賦課方法_06.equals(普通徴収_仮算定賦課方法)
                || 仮算定賦課方法_11.equals(普通徴収_仮算定賦課方法) || 仮算定賦課方法_10.equals(普通徴収_仮算定賦課方法)) {
            executeStep(前年度データ取得);
        }
        executeStep(世帯員把握);
        executeStep(世帯員把握フロー);
        executeStep(賦課計算_賦課);
        executeStep(賦課計算_中間);
        executeStep(賦課計算);
        executeStep(賦課情報登録);
        executeStep(計算後情報作成);
        executeStep(出力順設定);
        executeStep(普徴仮算定結果);
        executeStep(処理日付管理テーブル更新);
        if (flag2) {
            executeStep(普徴仮算定通知書一括発行);
        }
    }

    @Step(計算対象者抽出)
    IBatchFlowCommand selectKeisanTaishoshaProcess() {
        return loopBatch(SelectKeisanTaishoshaProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(前年度データ取得)
    IBatchFlowCommand selectZenFukaDataProcess() {
        return loopBatch(SelectZenFukaDataProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(世帯員把握)
    IBatchFlowCommand collectSetaiinProcess() {
        return loopBatch(CollectSetaiinProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(世帯員把握フロー)
    IBatchFlowCommand setaiinBatchFlow() {
        return otherBatchFlow(世帯員把握BATCH_ID, SubGyomuCode.DBB介護賦課,
                new DBB002001_SetaiinHaakuParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード())).define();
    }

    @Step(賦課計算_賦課)
    IBatchFlowCommand insFukaJohoTmepProcess() {
        return loopBatch(InsFukaJohoTmepProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(賦課計算_中間)
    IBatchFlowCommand insFukaKeisanTempProcess() {
        return loopBatch(InsFukaKeisanTempProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(賦課計算)
    IBatchFlowCommand insFukaTempProcess() {
        return loopBatch(InsFukaTempProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(普徴仮算定結果)
    IBatchFlowCommand prtFuchoKarisanteiKekkaIchiranProcess() {
        return loopBatch(PrtFuchoKarisanteiKekkaIchiranProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(処理日付管理テーブル更新)
    IBatchFlowCommand updShoriDateKanriProcess() {
        return simpleBatch(UpdShoriDateKanriProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(出力順設定)
    IBatchFlowCommand insSortTempProcess() {
        return loopBatch(InsSortTempProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 賦課情報登録メソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課情報登録)
    protected IBatchFlowCommand callChoteiToroku() {
        return otherBatchFlow(賦課の情報登録フローBATCHID, SubGyomuCode.DBB介護賦課,
                new DBB004001_FukaJohoTorokuParameter()).define();
    }

    /**
     * 計算後情報作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand keisangoJohoSakusei() {
        return otherBatchFlow(計算後情報作成BATCH_ID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(RString.EMPTY)).define();
    }

    /**
     * 普徴仮算定通知書一括発行バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(普徴仮算定通知書一括発行)
    IBatchFlowCommand fuchoKarisanteiTsuchishoHakko() {
        return otherBatchFlow(普徴仮算定通知書一括発行BATCH_ID, SubGyomuCode.DBB介護賦課,
                getParameter().toDBB014003_FuchoKarisanteiTsuchishoHakkoParameter()).define();
    }

    private FuchoKarisanteiFukaProcessParameter getProcessParameter() {
        FuchoKarisanteiFukaProcessParameter param = new FuchoKarisanteiFukaProcessParameter();
        param.set調定年度(getParameter().get調定年度());
        param.set賦課年度(getParameter().get賦課年度());
        param.setバッチ起動日時(バッチ起動日時);
        if (getParameter().get出力帳票一覧() != null && !getParameter().get出力帳票一覧().isEmpty()) {
            for (HonsanteifukaBatchTyouhyou entity : getParameter().get出力帳票一覧()) {
                if (entity != null && 帳票ID.equals(entity.get帳票ID())) {
                    param.set出力順ID(entity.get出力順ID());
                }
            }
        }
        return param;
    }

    private DBB003001_KeisangoJohoSakuseiParameter getKeisangoJohoSakuseiBatchParamter(RString 帳票分類ID) {
        return new DBB003001_KeisangoJohoSakuseiParameter(getParameter().get調定年度().toDateString(),
                getParameter().get賦課年度().toDateString(),
                new RString(new YMDHMS(バッチ起動日時).toString()),
                ShoriName.普徴仮算定賦課.get名称(), 帳票分類ID);
    }
}
