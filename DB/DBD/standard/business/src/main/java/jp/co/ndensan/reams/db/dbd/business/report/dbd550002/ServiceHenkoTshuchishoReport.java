/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.ServiceHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550002.ServiceHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * サービス変更通知書のReportです。
 *
 * @reamsid_L DBD-1430-040 b_zhengs
 */
public final class ServiceHenkoTshuchishoReport extends Report<ServiceHenkoTshuchishoReportSource> {

    private final ServiceHenkoTsuchishoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity サービス変更通知書
     * @return サービス変更通知書
     */
    public static ServiceHenkoTshuchishoReport createReport(@NonNull ServiceHenkoTsuchishoEntity entity) {
        return new ServiceHenkoTshuchishoReport(entity);
    }

    private ServiceHenkoTshuchishoReport(ServiceHenkoTsuchishoEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<ServiceHenkoTshuchishoReportSource> writer) {
        IServiceHenkoTshuchishoEditor bodyEditor = new ServiceHenkoTshuchishoBodyEditor(entity);
        IServiceHenkoTshuchishoBuilder builder = new ServiceHenkoTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
