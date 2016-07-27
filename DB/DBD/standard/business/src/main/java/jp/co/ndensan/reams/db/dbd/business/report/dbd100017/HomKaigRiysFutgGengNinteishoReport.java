/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100017;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100017.HomKaigRiysFutgGengNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 訪問介護等利用者負担額減額認定証のReportです。
 *
 * @reamsid_L DBD-3540-080 wangchao
 */
public final class HomKaigRiysFutgGengNinteishoReport extends Report<HomKaigRiysFutgGengNinteishoReportSource> {

    private final HomKaigRiysFutgGengNinteishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 訪問介護等利用者負担額減額認定証
     * @return 訪問介護等利用者負担額減額認定証
     */
    public static HomKaigRiysFutgGengNinteishoReport createReport(@NonNull HomKaigRiysFutgGengNinteishoItem bodyItem) {
        return new HomKaigRiysFutgGengNinteishoReport(bodyItem);
    }

    private HomKaigRiysFutgGengNinteishoReport(HomKaigRiysFutgGengNinteishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<HomKaigRiysFutgGengNinteishoReportSource> writer) {
        IHomKaigRiysFutgGengNinteishoEditor bodyEditor = new HomKaigRiysFutgGengNinteishoBodyEditor(bodyItem);
        IHomKaigRiysFutgGengNinteishoBuider builder = new HomKaigRiysFutgGengNinteishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
