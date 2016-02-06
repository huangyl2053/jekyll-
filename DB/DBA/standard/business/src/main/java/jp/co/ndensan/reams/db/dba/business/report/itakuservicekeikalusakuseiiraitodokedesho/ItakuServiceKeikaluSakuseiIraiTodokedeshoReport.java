/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.itakuservicekeikalusakuseiiraitodokedesho;

import jp.co.ndensan.reams.db.dba.entity.report.itakuservicekeikalusakuseiiraitodokedesho.ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 居宅（介護予防）サービス計画作成依頼（変更）届出書帳票作成します。
 */
public final class ItakuServiceKeikaluSakuseiIraiTodokedeshoReport extends Report<ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource> {

    private final ItakuServiceKeikaluSakuseiIraiTodokedeshoItem item;

    private ItakuServiceKeikaluSakuseiIraiTodokedeshoReport(ItakuServiceKeikaluSakuseiIraiTodokedeshoItem item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 居宅（介護予防）サービス計画作成依頼（変更）届出書Entityリスト
     * @return ItakuServiceKeikaluSakuseiIraiTodokedeshoReport
     */
    public static ItakuServiceKeikaluSakuseiIraiTodokedeshoReport createReport(@NonNull ItakuServiceKeikaluSakuseiIraiTodokedeshoItem item) {
        return new ItakuServiceKeikaluSakuseiIraiTodokedeshoReport(item);
    }

    /**
     * 居宅（介護予防）サービス計画作成依頼（変更）届出書writeByします。
     *
     * @param writer 居宅（介護予防）サービス計画作成依頼（変更）届出書作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource> writer) {
        IItakuServiceKeikaluSakuseiIraiTodokedeshoEditor joho = new ItakuServiceKeikaluSakuseiIraiTodokedeshoEditor(item);
        IItakuServiceKeikaluSakuseiIraiTodokedeshoBuilder builder = new ItakuServiceKeikaluSakuseiIraiTodokedeshoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
