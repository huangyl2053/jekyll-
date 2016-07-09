/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengkettsuchisho;

import jp.co.ndensan.reams.db.dbd.entity.report.homkaigriysfutggengkettsuchisho.HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 訪問介護等利用者負担額減額決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-090 wangchao
 */
public class HomKaigRiysFutgGengKettsuchishoReport extends Report<HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource> {

    private final HomKaigRiysFutgGengKettsuchishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 訪問介護等利用者負担額減額決定通知書
     * @return 訪問介護等利用者負担額減額決定通知書
     */
    public static HomKaigRiysFutgGengKettsuchishoReport createReport(@NonNull HomKaigRiysFutgGengKettsuchishoItem bodyItem) {
        return new HomKaigRiysFutgGengKettsuchishoReport(bodyItem);
    }

    private HomKaigRiysFutgGengKettsuchishoReport(HomKaigRiysFutgGengKettsuchishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource> writer) {
        IHomKaigRiysFutgGengKettsuchishoEditor bodyEditor = new HomKaigRiysFutgGengKettsuchishoBodyEditor(bodyItem);
        IHomKaigRiysFutgGengKettsuchishoBuider builder = new HomKaigRiysFutgGengKettsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
