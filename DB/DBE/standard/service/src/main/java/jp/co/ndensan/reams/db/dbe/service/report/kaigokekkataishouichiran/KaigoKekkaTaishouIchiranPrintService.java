/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.kaigokekkataishouichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranProperty;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranReport;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.KekkatsuchiTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定結果通知書対象者一覧表Printerです。
 */
public class KaigoKekkaTaishouIchiranPrintService {

    /**
     * 要介護認定結果通知書対象者一覧表を印刷します。
     *
     * @param kaigoJoho
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(KaigoKekkaTaishouIchiranReportJoho kaigoJoho) {
        KaigoKekkaTaishouIchiranProperty property = new KaigoKekkaTaishouIchiranProperty();
        return new Printer<KekkatsuchiTaishoshaIchiranReportSource>().spool(property, toReports(kaigoJoho));
    }

    private static List<KaigoKekkaTaishouIchiranReport> toReports(KaigoKekkaTaishouIchiranReportJoho kaigoJoho) {
        List<KaigoKekkaTaishouIchiranReport> list = new ArrayList<>();
        List<KaigoKekkaTaishouIchiranBodyItem> bodyItemList = kaigoJoho.getBodyItemList();
        list.add(KaigoKekkaTaishouIchiranReport.createFrom(
                kaigoJoho.getHeadItem(),
                bodyItemList));
        return list;
    }
}
