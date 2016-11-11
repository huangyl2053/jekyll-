/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.workflowcontroller.dbbwf45001;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB055001.DBB055001_KanendoIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.BranchPrintTshuchisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * バッチ設計_DBBBT45001_本算定異動（過年度）を判定するクラスです。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
public class DBBWF45001 {

    /**
     * バッチ起動画面で通知書発行が指示された場合、106を実行します。
     *
     * @param flowVersion flowVersion
     * @return 判断結果
     */
    public BranchPrintTshuchisho branchPrintTshuchisho(int flowVersion) {

        FlowParameters params = FlowParameterAccessor.get();
        if (params.get(new RString("通知書一括発行"), Boolean.class)) {
            return BranchPrintTshuchisho.発行処理する;
        }
        return BranchPrintTshuchisho.発行処理しない;
    }

    /**
     * バッチ設計_DBBBT45001_本算定異動（過年度）のバッチパラメータを設定。
     *
     * @param flowPrm フローパラメータ
     * @return バッチパラメータ
     */
    public DBB055001_KanendoIdoFukaParameter toBatchParameter(FlowParameters flowPrm) {
        DBB055001_KanendoIdoFukaParameter param = new DBB055001_KanendoIdoFukaParameter();
        param.set調定年度(flowPrm.get(new RString("調定年度"), FlexibleYear.class));
        param.set処理対象(flowPrm.get(new RString("処理対象"), RString.class));
        param.set抽出開始日時(flowPrm.get(new RString("抽出開始日時"), RDateTime.class));
        param.set抽出終了日時(flowPrm.get(new RString("抽出終了日時"), RDateTime.class));
        param.set出力帳票List(flowPrm.get(new RString("出力帳票List"), ArrayList.class));
        param.set決定_チェックボックス(flowPrm.get(new RString("決定_チェックボックス"), RString.class));
        param.set決定_対象賦課年度(flowPrm.get(new RString("決定_対象賦課年度"), ArrayList.class));
        param.set決定_発行日(flowPrm.get(new RString("決定_発行日"), RDate.class));
        param.set決定_文書番号(flowPrm.get(new RString("決定_文書番号"), RString.class));
        param.set変更_チェックボックス(flowPrm.get(new RString("変更_チェックボックス"), RString.class));
        param.set変更_対象賦課年度(flowPrm.get(new RString("変更_対象賦課年度"), ArrayList.class));
        param.set変更_発行日(flowPrm.get(new RString("変更_発行日"), RDate.class));
        param.set変更_文書番号(flowPrm.get(new RString("変更_文書番号"), RString.class));
        param.set変更_対象者(flowPrm.get(new RString("変更_対象者"), RString.class));
        param.set納入_対象賦課年度(flowPrm.get(new RString("納入_対象賦課年度"), ArrayList.class));
        param.set納入_発行日(flowPrm.get(new RString("納入_発行日"), RDate.class));
        param.set納入_出力期(flowPrm.get(new RString("納入_出力期"), RString.class));
        param.set納入_対象者(flowPrm.get(new RString("納入_対象者"), RString.class));
        param.set納入_口座振替様式(flowPrm.get(new RString("納入_口座振替様式"), RString.class));
        param.set納入_先頭出力(flowPrm.get(new RString("納入_先頭出力"), RString.class));
        param.set納入_ページ山分け(flowPrm.get(new RString("納入_ページ山分け"), RString.class));
        param.set一括発行起動フラグ(flowPrm.get(new RString("一括発行起動フラグ"), Boolean.class));
        return param;
    }
}
