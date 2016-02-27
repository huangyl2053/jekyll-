/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.daisanshakouihigaitodokekaigohokenyo;

import jp.co.ndensan.reams.db.dba.entity.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 第三者行為による被害届（介護保険用）の帳票を作成します。
 */
public final class DaisanshaKouiHigaitodokeKaigoHokenyoReport extends Report<DaisanshaKouiHigaitodokeKaigoHokenyoReportSource> {

    private final DaisanshaKouiHigaitodokeKaigoHokenyoItem item;

    private DaisanshaKouiHigaitodokeKaigoHokenyoReport(DaisanshaKouiHigaitodokeKaigoHokenyoItem item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 第三者行為による被害届（介護保険用）のEntity
     * @return DaisanshaKouiHigaitodokeKaigoHokenyoReport
     */
    public static DaisanshaKouiHigaitodokeKaigoHokenyoReport createReport(@NonNull DaisanshaKouiHigaitodokeKaigoHokenyoItem item) {
        return new DaisanshaKouiHigaitodokeKaigoHokenyoReport(item);
    }

    /**
     * 第三者行為による被害届（介護保険用）のwriteBy処理です。
     *
     * @param writer 第三者行為による被害届（介護保険用）作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<DaisanshaKouiHigaitodokeKaigoHokenyoReportSource> writer) {
        IDaisanshaKouiHigaitodokeKaigoHokenyoEditor joho = new DaisanshaKouiHigaitodokeKaigoHokenyoEditorImpl(item);
        IDaisanshaKouiHigaitodokeKaigoHokenyoBuilder builder = new DaisanshaKouiHigaitodokeKaigoHokenyoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
