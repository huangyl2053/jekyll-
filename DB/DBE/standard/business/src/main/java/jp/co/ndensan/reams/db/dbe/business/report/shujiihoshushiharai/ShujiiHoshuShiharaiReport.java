/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshushiharai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshushiharai.ShujiiHoshuShiharaiBodyEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshushiharai.ShujiiHoshuShiharaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshushiharai.ShujiiHoshuShiharaiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBE621002_主治医意見書作成報酬支払通知書のShujiiHoshuShiharaiReportです。
 *
 * @reamsid_L DBE-1980-040 xuyongchao
 */
public class ShujiiHoshuShiharaiReport extends Report<ShujiiHoshuShiharaiReportSource> {

    private final ShujiiHoshuShiharaiEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 主治医意見書作成報酬支払通知書のdataList
     */
    public ShujiiHoshuShiharaiReport(ShujiiHoshuShiharaiEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiHoshuShiharaiReportSource> reportSourceWriter) {
        for (ShujiiHoshuShiharaiBodyEntity bodyData : getBodyData(data)) {
            IShujiiHoshuShiharaiEditor editor = new ShujiiHoshuShiharaiEditor(data);
            IShujiiHoshuShiharaiBodyEditor bodyEditor = new ShujiiHoshuShiharaiBodyEditor(bodyData);
            IShujiiHoshuShiharaiBuilder builder = new ShujiiHoshuShiharaiBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ShujiiHoshuShiharaiBodyEntity> getBodyData(ShujiiHoshuShiharaiEntity data) {
        List<ShujiiHoshuShiharaiBodyEntity> dataList = new ArrayList<>();
        dataList.add(new ShujiiHoshuShiharaiBodyEntity(data.get在宅新規件数(), data.get在宅新規単価税込(), data.get在宅新規合計()));
        dataList.add(new ShujiiHoshuShiharaiBodyEntity(data.get在宅継続件数(), data.get在宅継続単価税込(), data.get在宅継続合計()));
        dataList.add(new ShujiiHoshuShiharaiBodyEntity(data.get施設新規件数(), data.get施設新規単価税込(), data.get施設新規合計()));
        dataList.add(new ShujiiHoshuShiharaiBodyEntity(data.get施設継続件数(), data.get施設継続単価税込(), data.get施設継続合計()));
        dataList.add(new ShujiiHoshuShiharaiBodyEntity(data.get検診料等の件数(), data.get検診料等の単価税込(), data.get検診料等の金額()));
        return dataList;
    }
}
