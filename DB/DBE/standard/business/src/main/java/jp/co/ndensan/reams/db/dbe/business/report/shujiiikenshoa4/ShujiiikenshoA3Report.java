/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1a4.ShujiiikenshoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用主治医意見書A3のReportです。
 *
 * @reamsid_L DBE-0150-090 wangrenze
 */
public class ShujiiikenshoA3Report extends Report<ShujiiikenshoA3ReportSource> {

    private final JimuShinsakaiWariateJohoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 事務局用主治医意見書
     */
    public ShujiiikenshoA3Report(JimuShinsakaiWariateJohoBusiness business) {
        this.business = business;
    }

    /**
     *
     * @param reportSourceWriter 事務局用主治医意見書A3Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShujiiikenshoA3ReportSource> reportSourceWriter) {
        IShujiiikenshoA3Editor headerEditor = new ShujiiikenshoA3Editor(business);
        IShujiiikenshoA3Builder builder = new ShujiiikenshoA3Builder(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
