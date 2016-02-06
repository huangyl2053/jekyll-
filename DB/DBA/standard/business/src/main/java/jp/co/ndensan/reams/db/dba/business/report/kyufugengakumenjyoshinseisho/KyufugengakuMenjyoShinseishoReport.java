/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufugengakumenjyoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.kyufugengakumenjyoshinseisho.KyufugengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 給付額減額免除申請書帳票作成します。
 */
public final class KyufugengakuMenjyoShinseishoReport extends Report<KyufugengakuMenjyoShinseishoReportSource> {

    private final KyufugengakuMenjyoShinseishoItem item;

    private KyufugengakuMenjyoShinseishoReport(KyufugengakuMenjyoShinseishoItem item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 給付額減額免除申請書Entityリスト
     * @return KyufugengakuMenjyoShinseishoReport
     */
    public static KyufugengakuMenjyoShinseishoReport createReport(@NonNull KyufugengakuMenjyoShinseishoItem item) {
        return new KyufugengakuMenjyoShinseishoReport(item);
    }

    /**
     * 給付額減額免除申請書writeByします。
     *
     * @param writer 給付額減額免除申請書作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufugengakuMenjyoShinseishoReportSource> writer) {
        IKyufugengakuMenjyoShinseishoEditor joho = new KyufugengakuMenjyoShinseishoEditor(item);
        IKyufugengakuMenjyoShinseishoBuilder builder = new KyufugengakuMenjyoShinseishoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
