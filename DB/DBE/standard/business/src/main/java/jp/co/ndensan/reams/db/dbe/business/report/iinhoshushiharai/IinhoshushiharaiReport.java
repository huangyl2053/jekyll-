/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinhoshushiharai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iinhoshushiharai.Iinhoshushiharai;
import jp.co.ndensan.reams.db.dbe.business.core.iinhoshushiharai.IinhoshushiharaiBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinhoshushiharai.IinhoshushiharaiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会委員報酬支払通知書のReportです。
 *
 * @reamsid_L DBE-1980-030 suguangjun
 */
public class IinhoshushiharaiReport extends Report<IinhoshushiharaiReportSource> {

    private final Iinhoshushiharai data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護状態区分別判定件数のdataList
     */
    public IinhoshushiharaiReport(Iinhoshushiharai data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<IinhoshushiharaiReportSource> reportSourceWriter) {
        for (IinhoshushiharaiBody dataBody : getBodyData(data)) {
            IIinhoshushiharaiEditor editor = new IinhoshushiharaiEditor(data);
            IIinhoshushiharaiBodyEditor bodyEditor = new IinhoshushiharaiBodyEditor(dataBody);
            IIinhoshushiharaiBuilder builder = new IinhoshushiharaiBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<IinhoshushiharaiBody> getBodyData(Iinhoshushiharai data) {
        List<IinhoshushiharaiBody> dataList = new ArrayList<>();
        dataList.add(new IinhoshushiharaiBody(data.get報酬報償費(),
                data.get差引支給額()
        ));
        dataList.add(new IinhoshushiharaiBody(data.get源泉所得税(),
                data.get費用弁償()
        ));
        dataList.add(new IinhoshushiharaiBody(RString.EMPTY,
                data.get合計()
        ));
        return dataList;
    }
}
