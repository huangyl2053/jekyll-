/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsainshiharaimeisaisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsainshiharaimeisaisho.ShinsainShiharaimeisaisho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsainshiharaimeisaisho.ShinsainShiharaimeisaishoBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsainshiharaimeisaisho.ShinsainShiharaimeisaishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会委員報酬支払明細書のReportです。
 *
 * @reamsid_L DBE-1980-046 suguangjun
 */
public class ShinsainShiharaimeisaishoReport extends Report<ShinsainShiharaimeisaishoReportSource> {

    private final ShinsainShiharaimeisaisho data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護状態区分別判定件数のdataList
     */
    public ShinsainShiharaimeisaishoReport(ShinsainShiharaimeisaisho data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsainShiharaimeisaishoReportSource> reportSourceWriter) {
        for (ShinsainShiharaimeisaishoBody dataBody : getBodyData(data)) {
            IShinsainShiharaimeisaishoEditor editor = new ShinsainShiharaimeisaishoEditor(data);
            IShinsainShiharaimeisaishoBodyEditor bodyEditor = new ShinsainShiharaimeisaishoBodyEditor(dataBody);
            IShinsainShiharaimeisaishoBuilder builder = new ShinsainShiharaimeisaishoBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ShinsainShiharaimeisaishoBody> getBodyData(ShinsainShiharaimeisaisho data) {
        List<ShinsainShiharaimeisaishoBody> dataList = new ArrayList<>();
        dataList.add(new ShinsainShiharaimeisaishoBody(data.get明細番号(),
                data.get被保険者番号(),
                data.get被保険者氏名(),
                data.get生年月日(),
                data.get査会開催年月日(),
                data.get報酬総額(),
                data.get費用弁償(),
                data.get税額控除(),
                data.get報酬合計(),
                data.get合計金額(),
                RString.EMPTY,
                RString.EMPTY
        ));
        dataList.addAll(getBodyDataBak(data));
        return dataList;
    }

    private List<ShinsainShiharaimeisaishoBody> getBodyDataBak(ShinsainShiharaimeisaisho data) {
        List<ShinsainShiharaimeisaishoBody> dataList = new ArrayList<>();
        dataList.add(new ShinsainShiharaimeisaishoBody(RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                data.get消費税(),
                RString.EMPTY,
                RString.EMPTY
        ));
        dataList.add(new ShinsainShiharaimeisaishoBody(RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                data.get合計請求額(),
                RString.EMPTY,
                RString.EMPTY
        ));
        return dataList;
    }
}
