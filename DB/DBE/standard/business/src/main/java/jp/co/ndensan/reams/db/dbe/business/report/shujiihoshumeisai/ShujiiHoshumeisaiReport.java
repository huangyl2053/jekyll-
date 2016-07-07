/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshumeisai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai.ShujiiHoshumeisaiBodyEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai.ShujiiHoshumeisaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshumeisai.ShujiiHoshumeisaiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のShujiiHoshumeisaiReportです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
public class ShujiiHoshumeisaiReport extends Report<ShujiiHoshumeisaiReportSource> {

    private final ShujiiHoshumeisaiEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data ShujiiHoshumeisaiEntity
     */
    public ShujiiHoshumeisaiReport(ShujiiHoshumeisaiEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiHoshumeisaiReportSource> reportSourceWriter) {
        for (ShujiiHoshumeisaiBodyEntity bodyData : getBodyData(data)) {
            IShujiiHoshumeisaiEditor editor = new ShujiiHoshumeisaiEditor(data);
            IShujiiHoshumeisaiBodyEditor bodyEditor = new ShujiiHoshumeisaiBodyEditor(bodyData);
            IShujiiHoshumeisaiBuilder builder = new ShujiiHoshumeisaiBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ShujiiHoshumeisaiBodyEntity> getBodyData(ShujiiHoshumeisaiEntity data) {
        List<ShujiiHoshumeisaiBodyEntity> dataList = new ArrayList<>();
        dataList.add(new ShujiiHoshumeisaiBodyEntity(data.get明細番号(),
                data.get被保険者番号(),
                data.get被保険者氏名(),
                data.get生年月日(),
                data.get意見書提出日(),
                data.get新規在宅(),
                data.get新規施設(),
                data.get継続在宅(),
                data.get継続施設(),
                data.get意見書作成料(),
                data.get新規在宅件数(),
                data.get新規施設件数(),
                data.get継続在宅件数(),
                data.get継続施設件数(),
                data.get合計金額(),
                RString.EMPTY,
                RString.EMPTY));
        dataList.addAll(getBodyDataBak(data));
        return dataList;
    }

    private List<ShujiiHoshumeisaiBodyEntity> getBodyDataBak(ShujiiHoshumeisaiEntity data) {
        List<ShujiiHoshumeisaiBodyEntity> dataList = new ArrayList<>();
        dataList.add(new ShujiiHoshumeisaiBodyEntity(data.get明細番号(),
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
                RString.EMPTY));
        dataList.add(new ShujiiHoshumeisaiBodyEntity(data.get明細番号(),
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
                RString.EMPTY));
        return dataList;
    }
}
