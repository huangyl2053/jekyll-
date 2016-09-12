/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護保険利用者負担額減額・免除申請書のReportです。
 *
 * @reamsid_L DBA-0540-691 suguangjun
 */
public final class RiyoshaFutangakuGengakuMenjyoShinseishoReport extends Report<RiyoshaFutangakuGengakuMenjyoShinseishoReportSource> {

    private final RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 介護保険利用者負担額減額・免除申請書情報
     * @return 介護保険利用者負担額減額・免除申請書
     */
    public static RiyoshaFutangakuGengakuMenjyoShinseishoReport createReport(@NonNull RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem bodyItem) {
        return new RiyoshaFutangakuGengakuMenjyoShinseishoReport(bodyItem);
    }

    private RiyoshaFutangakuGengakuMenjyoShinseishoReport(RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<RiyoshaFutangakuGengakuMenjyoShinseishoReportSource> writer) {
        IRiyoshaFutangakuGengakuMenjyoShinseishoEditor bodyEditor = new RiyoshaFutangakuGengakuMenjyoShinseishoBodyEditor(bodyItem);
        IRiyoshaFutangakuGengakuMenjyoShinseishoBuilder builder = new RiyoshaFutangakuGengakuMenjyoShinseishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
