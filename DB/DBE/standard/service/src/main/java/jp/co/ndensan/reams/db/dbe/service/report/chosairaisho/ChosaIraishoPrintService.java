/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosairaisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoReport;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoReportJoho;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査依頼書PrinterServiceクラスです。
 *
 * @reamsid_L DBE-0010-020 lishengli
 */
public class ChosaIraishoPrintService {

    /**
     * 要介護認定調査依頼書を印刷します。
     *
     * @param headItemlist 要介護認定調査依頼書ヘッダのITEMリストです。
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ChosaIraishoHeadItem> headItemlist) {
        ChosaIraishoProperty property = new ChosaIraishoProperty();
        return new Printer<ChosaIraishoReportSource>().spool(property, toReports(new ChosaIraishoReportJoho(headItemlist)));
    }

    private static List<ChosaIraishoReport> toReports(ChosaIraishoReportJoho reportJoho) {
        List<ChosaIraishoReport> list = new ArrayList<>();
        list.add(ChosaIraishoReport.createFrom(
                reportJoho.getHeadItemList()));
        return list;
    }
}
