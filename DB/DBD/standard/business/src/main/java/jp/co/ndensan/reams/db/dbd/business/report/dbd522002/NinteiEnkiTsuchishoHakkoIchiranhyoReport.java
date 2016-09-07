/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd522002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.EnkiTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd522002.NinteiEnkiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定延期通知書発行一覧表のReportです。
 *
 * @reamsid_L DBD-1410-040 chenxin
 */
public class NinteiEnkiTsuchishoHakkoIchiranhyoReport extends Report<NinteiEnkiTsuchishoHakkoIchiranhyoReportSource> {

    private final EnkiTsuchishoEntity target;

    /**
     * インスタンスを生成します。
     *
     * @param target 要介護認定延期通知書発行一覧表
     */
    public NinteiEnkiTsuchishoHakkoIchiranhyoReport(EnkiTsuchishoEntity target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteiEnkiTsuchishoHakkoIchiranhyoReportSource> reportSourceWriter) {

        INinteiEnkiTsuchishoHakkoIchiranhyoEditor headerEditor = new NinteiEnkiTsuchishoHakkoIchiranhyoHeaderEditor(target);
        INinteiEnkiTsuchishoHakkoIchiranhyoEditor bodyEditor = new NinteiEnkiTsuchishoHakkoIchiranhyoBodyEditor(target);
        INinteiEnkiTsuchishoHakkoIchiranhyoBuilder builder = new NinteiEnkiTsuchishoHakkoIchiranhyoJyohoBuilderImpl(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
