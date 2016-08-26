/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.workflowcontroller.dbbwf35001;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012003.DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.BranchPrintTshuchisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.RLogger;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 「バッチ特徴平準化（特徴6月分）通知書一括発行を実行するか」を判定するクラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class DBBWF35001 {

    /**
     * バッチ起動画面で通知書発行が指示された場合、104を実行します。
     *
     * @param flowVersion flowVersion
     * @return 判断結果
     */
    public BranchPrintTshuchisho branchPrintTshuchisho(int flowVersion) {

        FlowParameters params = FlowParameterAccessor.get();
        RLogger.info(new RString("===================通知書一括発行==============" + params.get(new RString("通知書一括発行："), Boolean.class)));
        if (params.get(new RString("通知書一括発行"), Boolean.class)) {
            return BranchPrintTshuchisho.発行処理する;
        }
        return BranchPrintTshuchisho.発行処理しない;
    }

    /**
     * 特徴平準化（特徴6月分）通知書一括発行のバッチパラメータを設定。
     *
     * @param flowPrm フローパラメータ
     * @return バッチパラメータ
     */
    public DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter setTsuchishoBatchParam(FlowParameters flowPrm) {
        RLogger.info(new RString("===================DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter=============="));
        DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter param = new DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter();
        param.set調定年度(flowPrm.get(new RString("調定年度"), FlexibleYear.class));
        param.set賦課年度(flowPrm.get(new RString("賦課年度"), FlexibleYear.class));
        param.set出力帳票一覧List(flowPrm.get(new RString("出力帳票一覧List"), ArrayList.class));
        param.set発行日(flowPrm.get(new RString("発行日"), FlexibleDate.class));
        param.set出力対象(flowPrm.get(new RString("出力対象"), RString.class));
        param.set一括発行フラグ(flowPrm.get(new RString("一括発行フラグ"), Boolean.class));
        param.set帳票グループ(flowPrm.get(new RString("帳票グループ"), RString.class));
        param.set文書番号(flowPrm.get(new RString("文書番号"), RString.class));
        return param;
    }

}
