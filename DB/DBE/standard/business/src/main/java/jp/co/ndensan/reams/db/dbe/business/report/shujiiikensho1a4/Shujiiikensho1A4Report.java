/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1a4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.Shujiiikensho1A4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書A4のReportです。
 *
 * @reamsid_L DBE-0150-380 lishengli
 */
public class Shujiiikensho1A4Report extends Report<Shujiiikensho1A4ReportSource> {

    private final JimuShinsakaiWariateJohoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business JimuShinsakaiWariateJohoBusiness
     * @return 主治医意見書A4のReport
     */
    public static Shujiiikensho1A4Report createFrom(JimuShinsakaiWariateJohoBusiness business) {

        return new Shujiiikensho1A4Report(business);
    }

    /**
     * インスタンスを生成します。
     *
     * @param business 主治医意見書のBusinessの編集クラス
     */
    public Shujiiikensho1A4Report(JimuShinsakaiWariateJohoBusiness business) {
        this.business = business;
    }

    /**
     * 委員用主治医意見書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<Shujiiikensho1A4ReportSource> reportSourceWriter) {
        IShujiiikensho1A4Editor editor = new Shujiiikensho1A4Editor(business);
        IShujiiikensho1A4Builder builder = new Shujiiikensho1A4Builder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
