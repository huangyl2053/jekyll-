/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.shiharaihohohenkolist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;

/**
 * 支払方法変更管理リスト作成_バッチフ処理クラスです。
 * 
 * @reamsid_L DBD-3630-040  zhulx
 */
public class ShiharaiHohoKanriListProcess extends BatchProcessBase {


//    private OutputParameter<List<ShikakuIdoTaishoshaEntity>> ShiharaiHohoKanriList;

//    @Override
//    protected void beforeExecute() {
//        
//    }

    @Override
    protected void process(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected IBatchReader createReader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
//        if (bodyItemList != null) {
//            ShujiiIkenshoSakuseiTokusokujoReport report = ShujiiIkenshoSakuseiTokusokujoReport.createFrom(bodyItemList);
//            report.writeBy(reportSourceWriter);
//        }
//        outShinseishoKanriNoList.setValue(shinseishoKanriNoList);
    }

    private void set出力条件表() {
        List 出力条件 = new ArrayList();
        出力条件.add("");
//        出力条件.add(processPrm.getTemp_保険者コード());
//        出力条件.add(processPrm.getTemp_保険者名称());
//        出力条件.add(processPrm.getTemp_主治医医療機関コード());
//        出力条件.add(processPrm.getTemp_主治医コード());
//        出力条件.add(processPrm.getTemp_基準日() == null ? RString.EMPTY : new RString(processPrm.getTemp_基準日().toString()));
//        出力条件.add(processPrm.getTemp_主治医意見書督促期限日数() == null ? RString.EMPTY
//                : new RString(processPrm.getTemp_主治医意見書督促期限日数().toString()));
//        出力条件.add(processPrm.getTemp_主治医意見書督促状());
//        出力条件.add(processPrm.getTemp_主治医意見書督促対象者一覧表());
//        出力条件.add(processPrm.getTemp_CSV出力());
//        出力条件.add(processPrm.getTemp_印刷済対象者());
//        出力条件.add(processPrm.getTemp_発行履歴());
//        出力条件.add(new RString(String.valueOf(processPrm.getTemp_督促方法())));
//        出力条件.add(processPrm.getTemp_督促メモ());
//        出力条件.add(processPrm.getTemp_督促日() == null ? RString.EMPTY : new RString(processPrm.getTemp_督促日().toString()));
//        出力条件.add(processPrm.getTemp_印刷期間開始日() == null ? RString.EMPTY : new RString(processPrm.getTemp_印刷期間開始日().toString()));
//        出力条件.add(processPrm.getTemp_印刷期間終了日() == null ? RString.EMPTY : new RString(processPrm.getTemp_印刷期間終了日().toString()));
//        Association association = AssociationFinderFactory.createInstance().getAssociation();
//        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
//                = new ReportOutputJokenhyoItem(
//                        REPORT_DBE233001.value(),
//                        association.getLasdecCode_().getColumnValue(),
//                        association.get市町村名(),
//                        new RString("【ジョブ番号】").concat(String.valueOf(JobContextHolder.getJobId())),
//                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, REPORT_DBE233001.value()),
//                        new RString(String.valueOf(reportSourceWriter.pageCount().value())),
//                        CSV出力有無,
//                        CSVファイル名,
//                        出力条件);
//        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }

}
