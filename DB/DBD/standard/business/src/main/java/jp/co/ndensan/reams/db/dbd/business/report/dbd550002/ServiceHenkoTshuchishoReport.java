/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.ServiceHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550002.ServiceHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private final List<RString> 通知書定型文リスト;
    private final ChohyoSeigyoKyotsu 帳票制御共通;

    /**
     * インスタンスを生成します。
     *
     * @param entity サービス変更通知書
     * @param 通知書定型文リスト List
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @return サービス変更通知書
     */
    public static ServiceHenkoTshuchishoReport createReport(@NonNull ServiceHenkoTsuchishoEntity entity,
            List<RString> 通知書定型文リスト,
            ChohyoSeigyoKyotsu 帳票制御共通) {
        return new ServiceHenkoTshuchishoReport(entity,
                通知書定型文リスト,
                帳票制御共通);
    }

    private ServiceHenkoTshuchishoReport(ServiceHenkoTsuchishoEntity entity,
            List<RString> 通知書定型文リスト,
            ChohyoSeigyoKyotsu 帳票制御共通) {
        this.entity = entity;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.帳票制御共通 = 帳票制御共通;
    }

    @Override
    public void writeBy(ReportSourceWriter<ServiceHenkoTshuchishoReportSource> writer) {
        IServiceHenkoTshuchishoEditor bodyEditor = new ServiceHenkoTshuchishoBodyEditor(entity,
                通知書定型文リスト,
                帳票制御共通);
        IServiceHenkoTshuchishoBuilder builder = new ServiceHenkoTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
