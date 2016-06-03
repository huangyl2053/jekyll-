/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.tekiyojogaishadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho.TekiyojogaishaDaichoProperty;
import jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho.TekiyojogaishaDaichoReport;
import jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho.TekiyojogaishaDaichoReportJoho;
import jp.co.ndensan.reams.db.dba.entity.report.tekiyojogaishadaicho.TekiyojogaishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 適用除外者台帳PrinterServiceクラスです。
 *
 * @reamsid_L DBA-0412-040 lishengli
 */
public class TekiyojogaishaDaichoPrintService {

    /**
     * 適用除外者台帳を印刷します。
     *
     * @param reportJoho 適用除外者台帳作成_帳票パラメータクラス。
     * @return {@link TekiyojogaishaDaichoReport}
     */
    public SourceDataCollection print(TekiyojogaishaDaichoReportJoho reportJoho) {
        TekiyojogaishaDaichoProperty property = new TekiyojogaishaDaichoProperty();
        return new Printer<TekiyojogaishaDaichoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<TekiyojogaishaDaichoReport> toReports(TekiyojogaishaDaichoReportJoho reportJoho) {
        List<TekiyojogaishaDaichoReport> list = new ArrayList<>();
        list.add(TekiyojogaishaDaichoReport.createFrom(
                reportJoho.getItemList()));
        return list;
    }
}
