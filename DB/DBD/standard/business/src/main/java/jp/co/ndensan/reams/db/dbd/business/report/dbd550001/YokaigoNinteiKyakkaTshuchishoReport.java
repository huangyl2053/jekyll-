/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.NinteikyakkaTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550001.YokaigoNinteiKyakkaTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護認定却下通知書のReportです。
 *
 * @reamsid_L DBD-1430-060 b_zhengs
 */
public final class YokaigoNinteiKyakkaTshuchishoReport extends Report<YokaigoNinteiKyakkaTshuchishoReportSource> {

    private final NinteikyakkaTsuchishoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定却下通知書
     * @return 要介護認定却下通知書
     */
    public static YokaigoNinteiKyakkaTshuchishoReport createReport(@NonNull NinteikyakkaTsuchishoEntity entity) {
        return new YokaigoNinteiKyakkaTshuchishoReport(entity);
    }

    private YokaigoNinteiKyakkaTshuchishoReport(NinteikyakkaTsuchishoEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiKyakkaTshuchishoReportSource> writer) {
        IYokaigoNinteiKyakkaTshuchishoEditor bodyEditor = new YokaigoNinteiKyakkaTshuchishoBodyEditor(entity);
        IYokaigoNinteiKyakkaTshuchishoBuilder builder = new YokaigoNinteiKyakkaTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
