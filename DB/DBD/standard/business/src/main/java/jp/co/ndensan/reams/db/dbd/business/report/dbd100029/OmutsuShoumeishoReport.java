/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100029;

import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.OmutsusiyoSyomeishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100029.OmutsuShoumeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * おむつ使用証明書のReportです。
 *
 * @reamsid_L DBD-5780-030 donghj
 */
public class OmutsuShoumeishoReport extends Report<OmutsuShoumeishoReportSource> {

    private final OmutsusiyoSyomeishoEntity おむつ使用証明書Entity;

    /**
     * インスタンスを生成します。
     *
     * @param おむつ使用証明書Entity OmutsusiyoSyomeishoEntity
     */
    public OmutsuShoumeishoReport(OmutsusiyoSyomeishoEntity おむつ使用証明書Entity) {
        this.おむつ使用証明書Entity = おむつ使用証明書Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<OmutsuShoumeishoReportSource> writer) {
        IOmutsuShoumeishoEditor editor = new OmutsuShoumeishoEditor(おむつ使用証明書Entity);
        IOmutsuShoumeishoBuilder builder = new OmutsuShoumeishoBuilder(editor);
        writer.writeLine(builder);
    }

}
