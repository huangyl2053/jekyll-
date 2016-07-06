/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshumeisai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosahoshumeisai.ChosaHoshumeisai;
import jp.co.ndensan.reams.db.dbe.business.core.chosahoshumeisai.ChosaHoshumeisaiBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshumeisai.ChosaHoshumeisaiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査報酬支払明細書のReportです。
 *
 * @reamsid_L DBE-1980-045 suguangjun
 */
public class ChosaHoshumeisaiReport extends Report<ChosaHoshumeisaiReportSource> {

    private final ChosaHoshumeisai data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護状態区分別判定件数のdataList
     */
    public ChosaHoshumeisaiReport(ChosaHoshumeisai data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosaHoshumeisaiReportSource> reportSourceWriter) {
        for (ChosaHoshumeisaiBody dataBody : getBodyData(data)) {
            IChosaHoshumeisaiEditor editor = new ChosaHoshumeisaiEditor(data);
            IChosaHoshumeisaiBodyEditor bodyEditor = new ChosaHoshumeisaiBodyEditor(dataBody);
            IChosaHoshumeisaiBuilder builder = new ChosaHoshumeisaiBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ChosaHoshumeisaiBody> getBodyData(ChosaHoshumeisai data) {
        List<ChosaHoshumeisaiBody> dataList = new ArrayList<>();
        dataList.add(new ChosaHoshumeisaiBody(data.get明細番号(),
                data.get被保険者番号(),
                data.get被保険者氏名(),
                data.get生年月日(),
                data.get調査票提出日(),
                data.get新規申請在宅(),
                data.get新規申請施設(),
                data.get継続申請在宅(),
                data.get継続申請施設(),
                data.get調査票作成料(),
                data.get合計件数新規在宅(),
                data.get合計件数新規施設(),
                data.get合計件数継続在宅(),
                data.get合計件数継続施設(),
                data.get合計金額(),
                RString.EMPTY,
                RString.EMPTY
        ));
        dataList.addAll(getBodyDataBak(data));
        return dataList;
    }

    private List<ChosaHoshumeisaiBody> getBodyDataBak(ChosaHoshumeisai data) {
        List<ChosaHoshumeisaiBody> dataList = new ArrayList<>();
        dataList.add(new ChosaHoshumeisaiBody(RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
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
        dataList.add(new ChosaHoshumeisaiBody(RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
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
