/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.ServiceHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550002.ServiceHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * サービス変更通知書のReportです。
 *
 * @reamsid_L DBD-1430-040 b_zhengs
 */
public final class ServiceHenkoTshuchishoReport extends Report<ServiceHenkoTshuchishoReportSource> {

    private final ServiceHenkoTsuchishoEntity entity;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param entity サービス変更通知書
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param ninshoshaSource NinshoshaSource
     */
    public ServiceHenkoTshuchishoReport(ServiceHenkoTsuchishoEntity entity,
            ChohyoSeigyoKyotsu 帳票制御共通,
            NinshoshaSource ninshoshaSource) {
        this.entity = entity;
        this.帳票制御共通 = 帳票制御共通;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<ServiceHenkoTshuchishoReportSource> writer) {
        IServiceHenkoTshuchishoEditor bodyEditor = new ServiceHenkoTshuchishoBodyEditor(entity,
                帳票制御共通,
                ninshoshaSource);
        IServiceHenkoTshuchishoBuilder builder = new ServiceHenkoTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
