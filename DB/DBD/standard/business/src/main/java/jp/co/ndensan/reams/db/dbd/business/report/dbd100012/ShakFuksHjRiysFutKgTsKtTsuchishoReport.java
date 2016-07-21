/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100012;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100012.ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 社会福祉法人等利用者負担軽減対象決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-110 wangchao
 */
public class ShakFuksHjRiysFutKgTsKtTsuchishoReport extends Report<ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource> {

    private final ShakFuksHjRiysFutKgTsKtTsuchishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 社会福祉法人等利用者負担軽減対象決定通知書
     * @return 社会福祉法人等利用者負担軽減対象決定通知書
     */
    public static ShakFuksHjRiysFutKgTsKtTsuchishoReport createReport(@NonNull ShakFuksHjRiysFutKgTsKtTsuchishoItem bodyItem) {
        return new ShakFuksHjRiysFutKgTsKtTsuchishoReport(bodyItem);
    }

    private ShakFuksHjRiysFutKgTsKtTsuchishoReport(ShakFuksHjRiysFutKgTsKtTsuchishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource> writer) {
        IShakFuksHjRiysFutKgTsKtTsuchishoEditor bodyEditor = new ShakFuksHjRiysFutKgTsKtTsuchishoBodyEditor(bodyItem);
        IShakFuksHjRiysFutKgTsKtTsuchishoBuider builder = new ShakFuksHjRiysFutKgTsKtTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
