/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikashitsukekinshokankigen;

import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikashitsukekinshokankigen.KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護保険給付費貸付金償還期限延長申請書の帳票作成します。
 *
 */
public final class KyufuhiKashitsukekinShokankigenEnchoShinseishoReport extends
        Report<KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource> {

    private final KyufuhiKashitsukekinShokankigenEnchoShinseishoItem item;

    private KyufuhiKashitsukekinShokankigenEnchoShinseishoReport(KyufuhiKashitsukekinShokankigenEnchoShinseishoItem item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険給付費貸付金償還期限延長申請書Entityリスト
     * @return KyufuhiKashitsukekinShokankigenEnchoShinseishoReport
     */
    public static KyufuhiKashitsukekinShokankigenEnchoShinseishoReport createReport(
            @NonNull KyufuhiKashitsukekinShokankigenEnchoShinseishoItem item) {
        return new KyufuhiKashitsukekinShokankigenEnchoShinseishoReport(item);
    }

    /**
     * 介護保険給付費貸付金償還期限延長申請書writeByします。
     *
     * @param writer 介護保険給付費貸付金償還期限延長申請書_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource> writer) {
        IKyufuhiKashitsukekinShokankigenEnchoShinseishoEditor joho = new KyufuhiKashitsukekinShokankigenEnchoShinseishoEditorImpl(item);
        IKyufuhiKashitsukekinShokankigenEnchoShinseishoBuilder builder = new KyufuhiKashitsukekinShokankigenEnchoShinseishoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
