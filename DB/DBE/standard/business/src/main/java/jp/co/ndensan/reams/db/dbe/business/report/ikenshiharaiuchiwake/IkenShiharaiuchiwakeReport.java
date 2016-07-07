/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshiharaiuchiwake;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshiharaiuchiwake.IkenShiharaiuchiwakeBodyEntity;
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
        for (IkenShiharaiuchiwakeBodyEntity bodyData : getBodyData(data)) {
            IIkenShiharaiuchiwakeEditor editor = new IkenShiharaiuchiwakeEditor(data);
            IIkenShiharaiuchiwakeBodyEditor bodyEditor = new IkenShiharaiuchiwakeBodyEditor(bodyData);
            IIkenShiharaiuchiwakeBuilder builder = new IkenShiharaiuchiwakeBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<IkenShiharaiuchiwakeBodyEntity> getBodyData(IkenShiharaiuchiwakeEntity data) {
        List<IkenShiharaiuchiwakeBodyEntity> dataList = new ArrayList<>();
        dataList.add(new IkenShiharaiuchiwakeBodyEntity(
                data.get明細番号(),
                data.get被保険者番号(),
                data.get被保険者氏名(),
                data.get内訳住所(),
                data.get金額()));
        return dataList;
    }

}
