/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkajohoichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichiran.HanteiKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkajohoichiran.HanteiKekkaIchiranA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護認定判定結果一覧のReportです。
 *
 * @reamsid_L DBE-0170-020 wangkun
 */
public class HanteiKekkaIchiranReport extends Report<HanteiKekkaIchiranA4ReportSource> {

    private final HanteiKekkaIchiranEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定判定結果一覧のITEM
     * @return 要介護認定結果通知書対象者一覧表のReport
     */
    public static HanteiKekkaIchiranReport createFrom(
            @NonNull HanteiKekkaIchiranEntity item) {
        return new HanteiKekkaIchiranReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定判定結果一覧のITEM
     */
    protected HanteiKekkaIchiranReport(HanteiKekkaIchiranEntity item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<HanteiKekkaIchiranA4ReportSource> reportSourceWriter) {
        reportSourceWriter.writeLine(new HanteiKekkaIchiranBuilder(new HanteiKekkaIchiranEditor(item)));
    }
}
