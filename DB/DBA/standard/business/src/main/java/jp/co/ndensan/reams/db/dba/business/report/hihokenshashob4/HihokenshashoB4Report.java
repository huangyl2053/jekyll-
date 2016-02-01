/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashob4.HihokenshashoB4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険被保険者証（B4版）帳票作成します。
 */
public final class HihokenshashoB4Report extends Report<HihokenshashoB4ReportSource> {
    
    private final List<HihokenshashoB4BodyItem> items;
    
    private HihokenshashoB4Report(List<HihokenshashoB4BodyItem> items) {
        this.items = items;
    }
    
    /**
     * インスタンスを生成します。
     * @param items 一覧表証発行者Entityリスト
     * @return HihokenshashoHakkoIchiranHyoReport
     */
    public static HihokenshashoB4Report createReport(@NonNull List<HihokenshashoB4BodyItem> items) {
        return new HihokenshashoB4Report(items);
    }

    @Override
    protected void writeBy(ReportSourceWriter<HihokenshashoB4ReportSource> writer) {
        for (HihokenshashoB4BodyItem item : items) {
            IHihokenshashoB4Editor joho = new HihokenshashoB4Editor(item);
            IHihokenshashoB4Builder builder = new HihokenshashoB4BuilderImpl(joho);
            writer.writeLine(builder);
        }
    }
}
