/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550003;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.YokaigodoHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550003.YokaigodoHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護度変更通知書のReportです。
 *
 * @reamsid_L DBD-1430-050 b_zhengs
 */
public final class YokaigodoHenkoTshuchishoReport extends Report<YokaigodoHenkoTshuchishoReportSource> {

    private final YokaigodoHenkoTsuchishoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護度変更通知書
     * @return 要介護度変更通知書
     */
    public static YokaigodoHenkoTshuchishoReport createReport(@NonNull YokaigodoHenkoTsuchishoEntity entity) {
        return new YokaigodoHenkoTshuchishoReport(entity);
    }

    private YokaigodoHenkoTshuchishoReport(YokaigodoHenkoTsuchishoEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigodoHenkoTshuchishoReportSource> writer) {
        IYokaigodoHenkoTshuchishoEditor bodyEditor = new YokaigodoHenkoTshuchishoBodyEditor(entity);
        IYokaigodoHenkoTshuchishoBuilder builder = new YokaigodoHenkoTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
