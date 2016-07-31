/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01Property;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01Report;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 主治医意見書（オルカ）のPrinterです。
 *
 * @reamsid_L DBE-1600-020 lishengli
 */
public class Ikenshokinyuyoshi01PrintService {

    /**
     * 主治医意見書（オルカ）を印刷します。
     *
     * @param business 主治医意見書（オルカ）のBusinessList
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(IkenshokinyuyoshiBusiness business) {
        Ikenshokinyuyoshi01Property property = new Ikenshokinyuyoshi01Property();
        return new Printer<Ikenshokinyuyoshi01ReportSource>().spool(property, toReports(business));
    }

    private static Ikenshokinyuyoshi01Report toReports(IkenshokinyuyoshiBusiness business) {
        return new Ikenshokinyuyoshi01Report(business);
    }
}
