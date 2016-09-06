/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyumeisai;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyumeisai.SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.seikyumeisai.SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 請求明細・給付管理票返戻（保留）一覧表のReportです。
 *
 * @reamsid_L DBC-2830-030 xuyannan
 */
public class SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReport extends Report<SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource> {

    private final SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity entity;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param entity 請求明細・給付管理票返戻（保留）一覧表のEntity
     * @param index 連番
     */
    public SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReport(
            SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity entity, int index) {
        this.entity = entity;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource> reportSourceWriter) {
        ISeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEditor editor = new SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEditor(entity, index);
        ISeikyumeisaiKyufukanrihyoHenreiHoryuIchiranBuilder builder = new SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
