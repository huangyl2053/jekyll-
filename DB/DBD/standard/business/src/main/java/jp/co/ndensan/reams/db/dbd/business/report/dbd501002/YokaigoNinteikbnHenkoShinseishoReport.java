/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd501002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteishinseishohakko.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501002.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護認定区分変更申請書のReportです。
 *
 * @reamsid_L DBD-1400-030 b_zhengs
 */
public final class YokaigoNinteikbnHenkoShinseishoReport extends Report<YokaigoNinteikbnHenkoShinseishoReportSource> {

    private final ShinseiShoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定区分変更申請書
     * @return 要介護認定区分変更申請書
     */
    public static YokaigoNinteikbnHenkoShinseishoReport createReport(@NonNull ShinseiShoEntity entity) {
        return new YokaigoNinteikbnHenkoShinseishoReport(entity);
    }

    private YokaigoNinteikbnHenkoShinseishoReport(ShinseiShoEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteikbnHenkoShinseishoReportSource> writer) {
        IYokaigoNinteikbnHenkoShinseishoEditor bodyEditor = new YokaigoNinteikbnHenkoShinseishoBodyEditor(entity);
        IYokaigoNinteikbnHenkoShinseishoBuilder builder = new YokaigoNinteikbnHenkoShinseishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
