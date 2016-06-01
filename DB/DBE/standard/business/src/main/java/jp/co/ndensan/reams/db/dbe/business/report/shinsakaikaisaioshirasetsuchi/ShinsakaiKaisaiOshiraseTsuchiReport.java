/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaikaisaioshirasetsuchi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会開催のお知らせのReportです。
 *
 * @reamsid_L DBE-0150-110 lishengli
 */
public class ShinsakaiKaisaiOshiraseTsuchiReport extends Report<ShinsakaiKaisaiOshiraseTsuchiReportSource> {

    private final List<ShinsakaiKaisaiOshiraseTsuchiItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会開催のお知らせのITEMLIST
     * @return 介護認定審査会開催のお知らせのReport
     */
    public static ShinsakaiKaisaiOshiraseTsuchiReport createFrom(List<ShinsakaiKaisaiOshiraseTsuchiItem> itemList) {

        return new ShinsakaiKaisaiOshiraseTsuchiReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会開催のお知らせのITEMLIST
     */
    protected ShinsakaiKaisaiOshiraseTsuchiReport(List<ShinsakaiKaisaiOshiraseTsuchiItem> itemList) {

        this.itemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter 介護認定審査会開催のお知らせReportSourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiKaisaiOshiraseTsuchiReportSource> reportSourceWriter) {
        for (ShinsakaiKaisaiOshiraseTsuchiItem item : itemList) {
            IShinsakaiKaisaiOshiraseTsuchiEditor editor = new ShinsakaiKaisaiOshiraseTsuchiEditor(item);
            IShinsakaiKaisaiOshiraseTsuchiBuilder builder = new ShinsakaiKaisaiOshiraseTsuchiBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
