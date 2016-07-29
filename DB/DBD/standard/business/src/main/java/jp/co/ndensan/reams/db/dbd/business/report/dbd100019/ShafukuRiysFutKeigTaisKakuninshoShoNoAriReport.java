/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100019;

import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoItem;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 社会福祉法人等利用者負担軽減対象確認証のReportです。
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public final class ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport extends Report<ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource> {

    private final ShakfukusRiysFutKeigTaisKakuninshoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 社会福祉法人等利用者負担軽減対象確認証
     * @return 社会福祉法人等利用者負担軽減対象確認証
     */
    public static ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport createReport(@NonNull ShakfukusRiysFutKeigTaisKakuninshoItem bodyItem) {
        return new ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport(bodyItem);
    }

    private ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport(ShakfukusRiysFutKeigTaisKakuninshoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource> writer) {
        IShafukuRiysFutKeigTaisKakuninshoShoNoAriEditor bodyEditor = new ShafukuRiysFutKeigTaisKakuninshoShoNoAriBodyEditor(bodyItem);
        IShafukuRiysFutKeigTaisKakuninshoShoNoAriBuider builder = new ShafukuRiysFutKeigTaisKakuninshoShoNoAriBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
