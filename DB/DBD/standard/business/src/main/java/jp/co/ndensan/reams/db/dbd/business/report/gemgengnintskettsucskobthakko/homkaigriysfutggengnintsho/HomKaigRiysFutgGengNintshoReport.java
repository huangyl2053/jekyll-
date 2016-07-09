/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengnintsho;

import jp.co.ndensan.reams.db.dbd.entity.report.homkaigriysfutggengnintsho.HomonKaigoRiyoshaFutangakuGengakuNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 訪問介護等利用者負担額減額認定証のReportです。
 *
 * @reamsid_L DBD-3540-080 wangchao
 */
public class HomKaigRiysFutgGengNintshoReport extends Report<HomonKaigoRiyoshaFutangakuGengakuNinteishoReportSource> {

    private final HomKaigRiysFutgGengNintshoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 訪問介護等利用者負担額減額認定証
     * @return 訪問介護等利用者負担額減額認定証
     */
    public static HomKaigRiysFutgGengNintshoReport createReport(@NonNull HomKaigRiysFutgGengNintshoItem bodyItem) {
        return new HomKaigRiysFutgGengNintshoReport(bodyItem);
    }

    private HomKaigRiysFutgGengNintshoReport(HomKaigRiysFutgGengNintshoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<HomonKaigoRiyoshaFutangakuGengakuNinteishoReportSource> writer) {
        IHomKaigRiysFutgGengNintshoEditor bodyEditor = new HomKaigRiysFutgGengNintshoBodyEditor(bodyItem);
        IHomKaigRiysFutgGengNintshoBuider builder = new HomKaigRiysFutgGengNintshoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
