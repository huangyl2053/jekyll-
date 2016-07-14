/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.shakfukhojriysfutkeigtaiskakunninsho;

import jp.co.ndensan.reams.db.dbd.entity.report.shakfukriysfutkeigtaiskakunninsho.ShafukuRiyoshaFutanKeigenTaishoKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 社会福祉法人等利用者負担軽減対象確認証のReportです。
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public class ShakFukusHojRiysFutKeigTaisKunNinshoReport extends Report<ShafukuRiyoshaFutanKeigenTaishoKakuninshoReportSource> {

    private final ShakFukusHojRiysFutKeigTaisKunNinshoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 社会福祉法人等利用者負担軽減対象確認証
     * @return 社会福祉法人等利用者負担軽減対象確認証
     */
    public static ShakFukusHojRiysFutKeigTaisKunNinshoReport createReport(@NonNull ShakFukusHojRiysFutKeigTaisKunNinshoItem bodyItem) {
        return new ShakFukusHojRiysFutKeigTaisKunNinshoReport(bodyItem);
    }

    private ShakFukusHojRiysFutKeigTaisKunNinshoReport(ShakFukusHojRiysFutKeigTaisKunNinshoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShafukuRiyoshaFutanKeigenTaishoKakuninshoReportSource> writer) {
        IShakFukusHojRiysFutKeigTaisKunNinshoEditor bodyEditor = new ShakFukusHojRiysFutKeigTaisKunNinshoBodyEditor(bodyItem);
        IShakFukusHojRiysFutKeigTaisKunNinshoBuider builder = new ShakFukusHojRiysFutKeigTaisKunNinshoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
