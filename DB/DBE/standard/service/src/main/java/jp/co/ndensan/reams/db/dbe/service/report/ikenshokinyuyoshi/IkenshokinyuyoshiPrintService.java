/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ikenshokinyuyoshi;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi.IkenshokinyuyoshiProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi.IkenshokinyuyoshiReport;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定主治医意見書記入用紙のPrinterです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiPrintService {

    /**
     * 要介護認定主治医意見書記入用紙を印刷します。
     *
     * @param businessList 要介護認定主治医意見書記入用紙のBusinessList
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<IkenshokinyuyoshiBusiness> businessList) {
        IkenshokinyuyoshiProperty property = new IkenshokinyuyoshiProperty();
        return new Printer<IkenshokinyuyoshiReportSource>().spool(property, toReports(businessList));
    }

    private static IkenshokinyuyoshiReport toReports(List<IkenshokinyuyoshiBusiness> businessList) {
        return new IkenshokinyuyoshiReport(businessList);
    }
}
