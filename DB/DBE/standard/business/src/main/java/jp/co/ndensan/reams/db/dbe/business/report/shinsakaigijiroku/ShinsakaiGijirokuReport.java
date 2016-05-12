/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaigijiroku.ShinsakaiGijirokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護認定審査会議事録のReportです。
 *
 * @reamsid_L DBE-0170-040 wangkun
 */
public class ShinsakaiGijirokuReport extends Report<ShinsakaiGijirokuReportSource> {

    private final List<ShinsakaiKekkaJohoRelateEntity> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会議事録のITEMリスト
     * @return 介護認定審査会議事録対象者一覧表のReport
     */
    public static ShinsakaiGijirokuReport createFrom(
            @NonNull List<ShinsakaiKekkaJohoRelateEntity> itemList) {
        return new ShinsakaiGijirokuReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会議事録のITEMリスト
     */
    protected ShinsakaiGijirokuReport(List<ShinsakaiKekkaJohoRelateEntity> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiGijirokuReportSource> reportSourceWriter) {
        for (ShinsakaiKekkaJohoRelateEntity item : itemList) {
            reportSourceWriter.writeLine(new ShinsakaiGijirokuBuilder(new ShinsakaiGijirokuEditor(item)));
        }
    }
}
