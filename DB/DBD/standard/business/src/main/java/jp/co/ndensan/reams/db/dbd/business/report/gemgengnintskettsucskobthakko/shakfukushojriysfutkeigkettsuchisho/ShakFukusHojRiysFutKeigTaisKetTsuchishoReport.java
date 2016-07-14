/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.shakfukushojriysfutkeigkettsuchisho;

import jp.co.ndensan.reams.db.dbd.entity.report.shakfukushojriysfutkeigkettsuchisho.ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 社会福祉法人等利用者負担軽減対象決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-110 wangchao
 */
public class ShakFukusHojRiysFutKeigTaisKetTsuchishoReport extends Report<ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource> {

    private final ShakFukusHojRiysFutKeigTaisKetTsuchishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 社会福祉法人等利用者負担軽減対象決定通知書
     * @return 社会福祉法人等利用者負担軽減対象決定通知書
     */
    public static ShakFukusHojRiysFutKeigTaisKetTsuchishoReport createReport(@NonNull ShakFukusHojRiysFutKeigTaisKetTsuchishoItem bodyItem) {
        return new ShakFukusHojRiysFutKeigTaisKetTsuchishoReport(bodyItem);
    }

    private ShakFukusHojRiysFutKeigTaisKetTsuchishoReport(ShakFukusHojRiysFutKeigTaisKetTsuchishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource> writer) {
        IShakFukusHojRiysFutKeigTaisKetTsuchishoEditor bodyEditor = new ShakFukusHojRiysFutKeigTaisKetTsuchishoBodyEditor(bodyItem);
        IShakFukusHojRiysFutKeigTaisKetTsuchishoBuider builder = new ShakFukusHojRiysFutKeigTaisKetTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
