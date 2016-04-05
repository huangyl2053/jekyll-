/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 被保険者証発行一覧表帳票作成します。
 */
public final class HihokenshashoHakkoIchiranHyoReport extends Report<HihokenshashoHakkoIchiranhyoReportSource> {
    
    private final List<HihokenshashoHakkoIchiranHyoItem> items;
    
    private HihokenshashoHakkoIchiranHyoReport(List<HihokenshashoHakkoIchiranHyoItem> items) {
        this.items = items;
    }
    
    /**
     * インスタンスを生成します。
     * @param items 一覧表証発行者Entityリスト
     * @return HihokenshashoHakkoIchiranHyoReport
     */
    public static HihokenshashoHakkoIchiranHyoReport createReport(@NonNull List<HihokenshashoHakkoIchiranHyoItem> items) {
        return new HihokenshashoHakkoIchiranHyoReport(items);
    }

    @Override
    protected void writeBy(ReportSourceWriter<HihokenshashoHakkoIchiranhyoReportSource> writer) {
        for (HihokenshashoHakkoIchiranHyoItem item : items) {
            IHihokenshashoHakkoIchiranHyoEditor joho = new HihokenshashoHakkoIchiranHyoEditor(item);
            IHihokenshashoHakkoIchiranHyoBuilder builder = new HihokenshashoHakkoIchiranHyoBuilderImpl(joho);
            writer.writeLine(builder);
        }
    }
}
