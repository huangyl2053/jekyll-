/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd501001;

import jp.co.ndensan.reams.db.dbd.business.report.dbd5130001.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501001.YokaigoNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護認定申請書のReportです。
 *
 * @reamsid_L DBD-1400-020 b_zhengs
 */
public final class YokaigoNinteiShinseishoReport extends Report<YokaigoNinteiShinseishoReportSource> {

    private final ShinseiShoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定申請書
     * @return 要介護認定申請書
     */
    public static YokaigoNinteiShinseishoReport createReport(@NonNull ShinseiShoEntity entity) {
        return new YokaigoNinteiShinseishoReport(entity);
    }

    private YokaigoNinteiShinseishoReport(ShinseiShoEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiShinseishoReportSource> writer) {
        IYokaigoNinteiShinseishoEditor bodyEditor = new YokaigoNinteiShinseishoBodyEditor(entity);
        IYokaigoNinteiShinseishoBuilder builder = new YokaigoNinteiShinseishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
