/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100014;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100014.HomKaigRiysFutGenｍKettTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別地域加算減免・訪問介護利用者負担減額決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-130 wangchao
 */
public class HomKaigRiysFutGenｍKettTsuchishoReport extends Report<HomKaigRiysFutGenｍKettTsuchishoReportSource> {

    private final HomKaigRiysFutGenｍKettTsuchishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 特別地域加算減免・訪問介護利用者負担減額決定通知書
     * @return 特別地域加算減免・訪問介護利用者負担減額決定通知書
     */
    public static HomKaigRiysFutGenｍKettTsuchishoReport createReport(@NonNull HomKaigRiysFutGenｍKettTsuchishoItem bodyItem) {
        return new HomKaigRiysFutGenｍKettTsuchishoReport(bodyItem);
    }

    private HomKaigRiysFutGenｍKettTsuchishoReport(HomKaigRiysFutGenｍKettTsuchishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<HomKaigRiysFutGenｍKettTsuchishoReportSource> writer) {
        IHomKaigRiysFutGenｍKettTsuchishoEditor bodyEditor = new HomKaigRiysFutGenｍKettTsuchishoBodyEditor(bodyItem);
        IHomKaigRiysFutGenｍKettTsuchishoBuider builder = new HomKaigRiysFutGenｍKettTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
