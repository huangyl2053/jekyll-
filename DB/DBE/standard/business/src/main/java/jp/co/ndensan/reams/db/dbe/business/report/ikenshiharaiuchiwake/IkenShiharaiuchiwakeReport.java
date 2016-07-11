/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshiharaiuchiwake;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshiharaiuchiwake.IkenShiharaiuchiwakeEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshiharaiuchiwake.IkenShiharaiuchiwakeReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBE622004_主治医意見書作成料支払内訳確認書のIkenShiharaiuchiwakePropertyです。
 *
 * @reamsid_L DBE-1980-047 xuyongchao
 */
public class IkenShiharaiuchiwakeReport extends Report<IkenShiharaiuchiwakeReportSource> {

    private final IkenShiharaiuchiwakeEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data IkenShiharaiuchiwakeEntity
     */
    public IkenShiharaiuchiwakeReport(IkenShiharaiuchiwakeEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenShiharaiuchiwakeReportSource> reportSourceWriter) {
        IIkenShiharaiuchiwakeEditor editor = new IkenShiharaiuchiwakeEditor(data);
        IIkenShiharaiuchiwakeBuilder builder = new IkenShiharaiuchiwakeBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
