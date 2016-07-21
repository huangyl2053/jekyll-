/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100018;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 社会福祉法人等利用者負担軽減対象確認証のReportです。
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public class ShakfukusRiysFutKeigTaisKakuninshoReport extends Report<ShakfukusRiysFutKeigTaisKakuninshoReportSource> {

    private final ShakfukusRiysFutKeigTaisKakuninshoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 社会福祉法人等利用者負担軽減対象確認証
     * @return 社会福祉法人等利用者負担軽減対象確認証
     */
    public static ShakfukusRiysFutKeigTaisKakuninshoReport createReport(@NonNull ShakfukusRiysFutKeigTaisKakuninshoItem bodyItem) {
        return new ShakfukusRiysFutKeigTaisKakuninshoReport(bodyItem);
    }

    private ShakfukusRiysFutKeigTaisKakuninshoReport(ShakfukusRiysFutKeigTaisKakuninshoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShakfukusRiysFutKeigTaisKakuninshoReportSource> writer) {
        IShakfukusRiysFutKeigTaisKakuninshoEditor bodyEditor = new ShakfukusRiysFutKeigTaisKakuninshoBodyEditor(bodyItem);
        IShakfukusRiysFutKeigTaisKakuninshoBuider builder = new ShakfukusRiysFutKeigTaisKakuninshoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
