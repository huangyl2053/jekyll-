/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshushiharai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahoshushiharai.ChosaHoshuShiharaiBodyEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahoshushiharai.ChosaHoshuShiharaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshushiharai.ChosaHoshuShiharaiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBE621003_認定調査報酬支払通知書のChosaHoshuShiharaiReportです。
 *
 * @reamsid_L DBE-1980-041 xuyongchao
 */
public class ChosaHoshuShiharaiReport extends Report<ChosaHoshuShiharaiReportSource> {

    private final ChosaHoshuShiharaiEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data data
     */
    public ChosaHoshuShiharaiReport(ChosaHoshuShiharaiEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosaHoshuShiharaiReportSource> reportSourceWriter) {
        for (ChosaHoshuShiharaiBodyEntity bodyData : getBodyData(data)) {
            IChosaHoshuShiharaiEditor editor = new ChosaHoshuShiharaiEditor(data);
            IChosaHoshuShiharaiBodyEditor bodyEditor = new ChosaHoshuShiharaiBodyEditor(bodyData);
            IChosaHoshuShiharaiBuilder builder = new ChosaHoshuShiharaiBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ChosaHoshuShiharaiBodyEntity> getBodyData(ChosaHoshuShiharaiEntity data) {
        List<ChosaHoshuShiharaiBodyEntity> dataList = new ArrayList<>();
        dataList.add(new ChosaHoshuShiharaiBodyEntity(data.get在宅新規件数(), data.get在宅新規単価税込(), data.get在宅新規合計()));
        dataList.add(new ChosaHoshuShiharaiBodyEntity(data.get在宅再調査件数(), data.get在宅再調査単価税込(), data.get在宅再調査合計()));
        dataList.add(new ChosaHoshuShiharaiBodyEntity(data.get施設新規件数(), data.get施設新規単価税込(), data.get施設新規合計()));
        dataList.add(new ChosaHoshuShiharaiBodyEntity(data.get施設再調査件数(), data.get施設再調査単価税込(), data.get施設再調査合計()));
        dataList.add(new ChosaHoshuShiharaiBodyEntity(data.getその他の設定件数(), data.getその他の単価税込(), data.getその他の金額合計()));
        return dataList;
    }

}
