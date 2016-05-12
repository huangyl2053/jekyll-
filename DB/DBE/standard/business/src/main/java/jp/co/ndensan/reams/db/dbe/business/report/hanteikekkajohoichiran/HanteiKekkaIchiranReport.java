/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkajohoichiran;

import java.util.List;
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

    private final List<HanteiKekkaIchiranEntity> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定判定結果一覧のITEMリスト
     * @return 要介護認定結果通知書対象者一覧表のReport
     */
    public static HanteiKekkaIchiranReport createFrom(
            @NonNull List<HanteiKekkaIchiranEntity> itemList) {
        return new HanteiKekkaIchiranReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定判定結果一覧のITEMリスト
     */
    protected HanteiKekkaIchiranReport(List<HanteiKekkaIchiranEntity> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<HanteiKekkaIchiranA4ReportSource> reportSourceWriter) {
        for (HanteiKekkaIchiranEntity item : itemList) {
            reportSourceWriter.writeLine(new HanteiKekkaIchiranBuilder(new HanteiKekkaIchiranEditor(item)));
        }
    }
}
