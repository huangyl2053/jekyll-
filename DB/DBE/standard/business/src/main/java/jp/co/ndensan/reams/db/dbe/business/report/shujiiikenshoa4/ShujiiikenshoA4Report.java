/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1a4.ShujiiikenshoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用主治医意見書のReportです。
 *
 * @reamsid_L DBE-0150-090 wangrenzes
 */
public class ShujiiikenshoA4Report extends Report<ShujiiikenshoA4ReportSource> {

    private final JimuShinsakaiWariateJohoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 申請に関する帳票発行
     */
    public ShujiiikenshoA4Report(JimuShinsakaiWariateJohoBusiness business) {
        this.business = business;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiikenshoA4ReportSource> reportSourceWriter) {

        IShujiiikenshoA4Editor editor = new ShujiiikenshoA4Editor(business);
        IShujiiikenshoA4Builder builder = new ShujiiikenshoA4Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
