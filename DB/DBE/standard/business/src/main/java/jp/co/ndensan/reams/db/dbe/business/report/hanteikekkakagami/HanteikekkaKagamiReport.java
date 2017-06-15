/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami;

import jp.co.ndensan.reams.db.dbe.business.core.shucho.Shuchos;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkakagami.HanteikekkaKagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査判定結果（鑑）のReportです。
 *
 * @reamsid_L DBE-0170-030 wangkun
 */
public class HanteikekkaKagamiReport extends Report<HanteikekkaKagamiReportSource> {

    private final HanteikekkaKagamiEntity item;
    private final Shuchos shuchos;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護認定審査判定結果（鑑）のITEM
     */
    public HanteikekkaKagamiReport(HanteikekkaKagamiEntity item, Shuchos shuchos) {
        this.item = item;
        this.shuchos = shuchos;
    }

    @Override
    public void writeBy(ReportSourceWriter<HanteikekkaKagamiReportSource> reportSourceWriter) {
        reportSourceWriter.writeLine(new HanteikekkaKagamiBuilder(new HanteikekkaKagamiEditor(item, shuchos)));
    }
}
