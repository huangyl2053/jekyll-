/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shokanharaishikyushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.shokanharaishikyushinseisho.ShokanharaiShikyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険償還払支給申請書帳票作成します。
 */
public final class ShokanharaiShikyuShinseishoReport extends Report<ShokanharaiShikyuShinseishoReportSource> {

    private final ShokanharaiShikyuShinseishoItem item;

    private ShokanharaiShikyuShinseishoReport(ShokanharaiShikyuShinseishoItem item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険償還払支給申請書Entityリスト
     * @return ShokanharaiShikyuShinseishoReport
     */
    public static ShokanharaiShikyuShinseishoReport createReport(@NonNull ShokanharaiShikyuShinseishoItem item) {
        return new ShokanharaiShikyuShinseishoReport(item);
    }

    /**
     * 介護保険償還払支給申請書writeByします。
     *
     * @param writer 介護保険償還払支給申請書作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<ShokanharaiShikyuShinseishoReportSource> writer) {
        IShokanharaiShikyuShinseishoEditor joho = new ShokanharaiShikyuShinseishoEditor(item);
        IShokanharaiShikyuShinseishoBuilder builder = new ShokanharaiShikyuShinseishoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
