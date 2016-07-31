/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.Ikenshokinyuyoshi02Property;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.Ikenshokinyuyoshi02Report;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi02ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 主治医意見書（オルカ）のPrinterです。
 *
 * @reamsid_L DBE-1600-021 lishengli
 */
public class Ikenshokinyuyoshi02PrintService {

    /**
     * 主治医意見書（オルカ）を印刷します。
     *
     * @param business 主治医意見書（オルカ）のBusinessList
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(IkenshokinyuyoshiBusiness business) {
        Ikenshokinyuyoshi02Property property = new Ikenshokinyuyoshi02Property();
        return new Printer<Ikenshokinyuyoshi02ReportSource>().spool(property, toReports(business));
    }

    private static Ikenshokinyuyoshi02Report toReports(IkenshokinyuyoshiBusiness business) {
        return new Ikenshokinyuyoshi02Report(business);
    }
}
