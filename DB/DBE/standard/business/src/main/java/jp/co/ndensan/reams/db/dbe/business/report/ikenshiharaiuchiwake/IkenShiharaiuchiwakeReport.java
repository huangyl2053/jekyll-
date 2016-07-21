/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshiharaiuchiwake;

import java.util.ArrayList;
import java.util.List;
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
    private static final int COUNT = 10;

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
        List<IkenShiharaiuchiwakeEntity> dataList = new ArrayList<>();
        dataList.add(data);
        if (data.getCount() > COUNT) {
            data.setLayoutBreakItem(2);
            dataList.add(data);
        } else {
            data.setLayoutBreakItem(1);
            dataList.add(data);
        }
        writeBy(reportSourceWriter, dataList);
    }

    private void writeBy(ReportSourceWriter<IkenShiharaiuchiwakeReportSource> reportSourceWriter, List<IkenShiharaiuchiwakeEntity> dataList) {
        for (IkenShiharaiuchiwakeEntity target : dataList) {
            IIkenShiharaiuchiwakeEditor editor = new IkenShiharaiuchiwakeEditor(target);
            IIkenShiharaiuchiwakeEditor detailEditor = new IkenShiharaiuchiwakeDetailEditor(target);
            IIkenShiharaiuchiwakeBuilder builder = new IkenShiharaiuchiwakeBuilder(editor, detailEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
