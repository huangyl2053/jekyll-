/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定主治医意見書記入用紙のReportです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiReport extends Report<IkenshokinyuyoshiReportSource> {

    private IkenshokinyuyoshiBusiness business;
    private List<IkenshokinyuyoshiBusiness> businessList;

    /**
     * インスタンスを生成します。
     *
     * @param business 要介護認定主治医意見書記入用紙のBusiness
     */
    public IkenshokinyuyoshiReport(IkenshokinyuyoshiBusiness business) {
        this.business = business;
    }

    /**
     * インスタンスを生成します。
     *
     * @param businessList 要介護認定主治医意見書記入用紙のBusinessList
     */
    public IkenshokinyuyoshiReport(List<IkenshokinyuyoshiBusiness> businessList) {
        this.businessList = businessList;
    }

    /**
     * 要介護認定主治医意見書記入用紙を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<IkenshokinyuyoshiReportSource> reportSourceWriter) {
        if (business == null) {
            for (IkenshokinyuyoshiBusiness ikenshokinyuyoshiBusiness : businessList) {
                IIkenshokinyuyoshiEditor editor = new IkenshokinyuyoshiEditorImpl(ikenshokinyuyoshiBusiness);
                IIkenshokinyuyoshiBuilder builder = new IkenshokinyuyoshiBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else {
            IIkenshokinyuyoshiEditor editor = new IkenshokinyuyoshiEditorImpl(business);
            IIkenshokinyuyoshiBuilder builder = new IkenshokinyuyoshiBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }

    }
}
