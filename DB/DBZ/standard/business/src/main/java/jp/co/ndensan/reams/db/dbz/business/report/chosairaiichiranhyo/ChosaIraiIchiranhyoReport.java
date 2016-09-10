/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 認定調査依頼一覧表のReportです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
public class ChosaIraiIchiranhyoReport extends Report<ChosaIraiIchiranhyoReportSource> {

    private final List<ChosaIraiIchiranhyoBodyItem> bodyItemList;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItemList 認定調査依頼一覧表ボディのITEMリスト
     * @return 認定調査依頼一覧表のReport
     */
    public static ChosaIraiIchiranhyoReport createFrom(
            @NonNull List<ChosaIraiIchiranhyoBodyItem> bodyItemList) {

        return new ChosaIraiIchiranhyoReport(
                bodyItemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param bodyItemList 認定調査依頼一覧表ボディのITEMリスト
     */
    protected ChosaIraiIchiranhyoReport(
            List<ChosaIraiIchiranhyoBodyItem> bodyItemList) {

        this.bodyItemList = bodyItemList;
    }

    /**
     *
     * @param reportSourceWriter 認定調査依頼一覧表Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosaIraiIchiranhyoReportSource> reportSourceWriter) {
        for (ChosaIraiIchiranhyoBodyItem bodyItem : bodyItemList) {
            IChosaIraiIchiranhyoEditor bodyEditor = new ChosaIraiIchiranhyoBodyEditor(bodyItem);
            IChosaIraiIchiranhyoBuilder builder = new ChosaIraiIchiranhyoBuilderImpl(bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
