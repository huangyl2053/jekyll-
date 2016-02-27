/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.service.report.shikakushasho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoJoho;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoProerty;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoReport;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushasho.ShikakushashoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 介護保険資格者証Printクラスです。
 */
public class ShikakushashoPrintService {
    
    /**
     * 介護保険資格者証Printします。
     * @param reportJoho 介護保険資格者証作成_帳票クラスパラメータ
     * @return 介護保険資格者証作成_帳票
     */
    public SourceDataCollection print(ShikakushashoJoho reportJoho) {
        ShikakushashoProerty property = new ShikakushashoProerty();
        return new Printer<ShikakushashoReportSource>().spool(property, toReports(reportJoho));
    }
    
    private static List<ShikakushashoReport> toReports(ShikakushashoJoho joho) {
        List<ShikakushashoReport> list = new ArrayList<>();
        list.add(ShikakushashoReport.createReport(joho.getBodyItem()));
        return list;
    }
}
