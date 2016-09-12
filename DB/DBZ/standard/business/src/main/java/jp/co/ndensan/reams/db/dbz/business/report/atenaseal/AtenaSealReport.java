/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.atenaseal;

import jp.co.ndensan.reams.db.dbz.business.core.atenaseal.AtenaSealReportBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.atenaseal.AtenaSealCreateReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 宛名シールのReportです。
 *
 * @reamsid_L DBA-1210-050 zhengsongling
 */
public class AtenaSealReport extends Report<AtenaSealCreateReportSource> {

    private final AtenaSealReportBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 要介護認定調査票（概況特記）のbusiness
     */
    public AtenaSealReport(AtenaSealReportBusiness business) {
        this.business = business;
    }

    /**
     * 要介護認定調査票（概況特記）を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<AtenaSealCreateReportSource> reportSourceWriter) {
        IAtenaSealEditor editor = new AtenaSealEditorImpl(business);
        IAtenaSealBuilder builder = new AtenaSealBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
