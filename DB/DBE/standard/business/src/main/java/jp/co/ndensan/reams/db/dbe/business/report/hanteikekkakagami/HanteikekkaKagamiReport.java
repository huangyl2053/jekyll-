/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkakagami.HanteikekkaKagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護認定審査判定結果（鑑）のReportです。
 *
 * @reamsid_L DBE-0170-030 wangkun
 */
public class HanteikekkaKagamiReport extends Report<HanteikekkaKagamiReportSource> {

    private final List<HanteikekkaKagamiEntity> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査判定結果（鑑）のITEMリスト
     * @return 要介護認定結果通知書対象者一覧表のReport
     */
    public static HanteikekkaKagamiReport createFrom(
            @NonNull List<HanteikekkaKagamiEntity> itemList) {
        return new HanteikekkaKagamiReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査判定結果（鑑）のITEMリスト
     */
    protected HanteikekkaKagamiReport(List<HanteikekkaKagamiEntity> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<HanteikekkaKagamiReportSource> reportSourceWriter) {
        for (HanteikekkaKagamiEntity item : itemList) {
            reportSourceWriter.writeLine(new HanteikekkaKagamiBuilder(new HanteikekkaKagamiEditor(item)));
        }
    }
}
