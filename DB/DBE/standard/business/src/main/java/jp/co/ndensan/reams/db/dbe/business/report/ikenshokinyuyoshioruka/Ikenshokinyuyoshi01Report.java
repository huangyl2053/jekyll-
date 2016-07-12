/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書（オルカ）のReportです。
 *
 * @reamsid_L DBE-1600-020 lishengli
 */
public class Ikenshokinyuyoshi01Report extends Report<Ikenshokinyuyoshi01ReportSource> {

    private final IkenshokinyuyoshiBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 主治医意見書（オルカ）のBusiness
     */
    public Ikenshokinyuyoshi01Report(IkenshokinyuyoshiBusiness business) {
        this.business = business;
    }

    /**
     * 主治医意見書（オルカ）を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<Ikenshokinyuyoshi01ReportSource> reportSourceWriter) {
        IIkenshokinyuyoshi01Editor editor = new Ikenshokinyuyoshi01EditorImpl(business);
        IIkenshokinyuyoshi01Builder builder = new Ikenshokinyuyoshi01BuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
