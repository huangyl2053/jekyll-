/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100011;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100011.HomKaigRiysFutgGengKettTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 訪問介護等利用者負担額減額決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-090 wangchao
 */
public final class HomKaigRiysFutgGengKettTsuchishoReport extends Report<HomKaigRiysFutgGengKettTsuchishoReportSource> {

    private final HomKaigRiysFutgGengKettTsuchishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 訪問介護等利用者負担額減額決定通知書
     * @return 訪問介護等利用者負担額減額決定通知書
     */
    public static HomKaigRiysFutgGengKettTsuchishoReport createReport(@NonNull HomKaigRiysFutgGengKettTsuchishoItem bodyItem) {
        return new HomKaigRiysFutgGengKettTsuchishoReport(bodyItem);
    }

    private HomKaigRiysFutgGengKettTsuchishoReport(HomKaigRiysFutgGengKettTsuchishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<HomKaigRiysFutgGengKettTsuchishoReportSource> writer) {
        IHomKaigRiysFutgGengKettTsuchishoEditor bodyEditor = new HomKaigRiysFutgGengKettTsuchishoBodyEditor(bodyItem);
        IHomKaigRiysFutgGengKettTsuchishoBuider builder = new HomKaigRiysFutgGengKettTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
