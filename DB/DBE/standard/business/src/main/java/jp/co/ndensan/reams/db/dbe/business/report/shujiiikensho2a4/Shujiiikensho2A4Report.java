/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho2a4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.Shujiiikensho2A4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書A4のReportです。
 *
 * @reamsid_L DBE-0150-390 lishengli
 */
public class Shujiiikensho2A4Report extends Report<Shujiiikensho2A4ReportSource> {

    private final JimuShinsakaiWariateJohoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business JimuShinsakaiWariateJohoBusiness
     * @return 主治医意見書A4のReport
     */
    public static Shujiiikensho2A4Report createFrom(JimuShinsakaiWariateJohoBusiness business) {
        return new Shujiiikensho2A4Report(business);
    }

    /**
     * インスタンスを生成します。
     *
     * @param business JimuShinsakaiWariateJohoBusiness
     */
    public Shujiiikensho2A4Report(JimuShinsakaiWariateJohoBusiness business) {
        this.business = business;
    }

    /**
     * 委員用主治医意見書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<Shujiiikensho2A4ReportSource> reportSourceWriter) {
        IShujiiikensho2A4Editor editor = new Shujiiikensho2A4Editor(business);
        IShujiiikensho2A4Builder builder = new Shujiiikensho2A4Builder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
