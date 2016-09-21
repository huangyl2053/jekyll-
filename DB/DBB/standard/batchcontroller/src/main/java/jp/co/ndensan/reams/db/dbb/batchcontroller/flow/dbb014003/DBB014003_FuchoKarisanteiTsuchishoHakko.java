/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb014003;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003.DBB014003_FuchoKarisanteiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB003001.DBB003001_KeisangoJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014003.FuchoKarisanteiTsuchishoHakkoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定通知書一括発行のFlowクラスです。
 *
 * @reamsid_L DBB-0710-030 gongliang
 */
public class DBB014003_FuchoKarisanteiTsuchishoHakko extends BatchFlowBase<DBB014003_FuchoKarisanteiTsuchishoHakkoParameter> {

    private DBB014003_FuchoKarisanteiTsuchishoHakkoParameter parameter;
    private FuchoKarisanteiTsuchishoHakkoProcessParameter processParameter;

//    @BatchWriter
//    private BatchEntityCreatedTempTableWriter 異動賦課情報一時tableWriter;
    private static final String 計算後情報作成 = "kiisagoJyohouSakusei";
//    private static final String 異動賦課情報一時テーブル登録 = "insertTmpIdoFukaJoho";

    private static final RString KEISANGOJOHOSAKUEEIFLOW_FLOWID = new RString("KeisangoJohoSakuseiFlow");

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null) {
            return;
        }
        processParameter = parameter.toProcessParam(YMDHMS.now());
        if (getParameter().is一括発行起動フラグ()) {
            executeStep(計算後情報作成);
        }
//        executeStep(異動賦課情報一時テーブル登録);
    }

    /**
     * 計算後情報作成です。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand kiisagoJyohouSakuseiIchi() {
        return otherBatchFlow(KEISANGOJOHOSAKUEEIFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter()).define();
    }

    private DBB003001_KeisangoJohoSakuseiParameter getKeisangoJohoSakuseiBatchParamter() {
        ReportId 帳票分類ID = processParameter.get出力帳票一覧List().get(0).get帳票分類ID();
        RString 帳票分類IDR = 帳票分類ID == null || 帳票分類ID.isEmpty() ? RString.EMPTY : 帳票分類ID.getColumnValue();
        return new DBB003001_KeisangoJohoSakuseiParameter(processParameter.get調定年度().toDateString(),
                processParameter.get調定年度().toDateString(),
                new RString(processParameter.getシステム日時().toString()),
                RString.EMPTY, 帳票分類IDR);
    }

//    @Step(異動賦課情報一時テーブル登録)
//    protected IBatchFlowCommand insertTmpIdoFukaJoho() {
//        return loopBatch(InsertTmpIdoFukaJohoProcess.class).arguments().define(processParameter);
//    }
}
