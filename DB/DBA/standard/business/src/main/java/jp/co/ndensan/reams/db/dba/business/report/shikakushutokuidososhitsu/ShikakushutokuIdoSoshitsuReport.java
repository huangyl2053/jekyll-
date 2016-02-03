/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushutokuidososhitsu;

import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険資格取得・異動・喪失届帳票作成します。
 */
public final class ShikakushutokuIdoSoshitsuReport extends Report<ShikakushutokuIdoSoshitsuReportSource> {
    
    private final ShikakushutokuIdoSoshitsuItem item;
    
    private ShikakushutokuIdoSoshitsuReport(ShikakushutokuIdoSoshitsuItem item) {
        this.item = item;
    }
    
    /**
     * インスタンスを生成します。
     * @param item 介護保険資格取得・異動・喪失届Entityリスト
     * @return HihokenshashoHakkoIchiranHyoReport
     */
    public static ShikakushutokuIdoSoshitsuReport createReport(@NonNull ShikakushutokuIdoSoshitsuItem item) {
        return new ShikakushutokuIdoSoshitsuReport(item);
    }

    /**
     * 介護保険資格取得・異動・喪失届writeByします。
     * @param writer 介護保険資格取得・異動・喪失届作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<ShikakushutokuIdoSoshitsuReportSource> writer) {
        IShikakushutokuIdoSoshitsuEditor joho = new ShikakushutokuIdoSoshitsuEditor(item);
        IShikakushutokuIdoSoshitsuBuilder builder = new ShikakushutokuIdoSoshitsuBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
