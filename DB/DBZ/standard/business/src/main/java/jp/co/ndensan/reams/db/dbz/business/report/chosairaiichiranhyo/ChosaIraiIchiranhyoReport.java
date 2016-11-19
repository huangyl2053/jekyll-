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

/**
 * 認定調査依頼一覧表のReportです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
public class ChosaIraiIchiranhyoReport extends Report<ChosaIraiIchiranhyoReportSource> {

    private final List<ChosaIraiIchiranhyoBodyItem> bodyItemList;
    private final ChosaIraiIchiranhyoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItemList 認定調査依頼一覧表ボディのITEMリスト
     * @return 認定調査依頼一覧表のReport
     */
    public static ChosaIraiIchiranhyoReport createFrom(
            List<ChosaIraiIchiranhyoBodyItem> bodyItemList) {
        return new ChosaIraiIchiranhyoReport(
                bodyItemList, null);
    }

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 認定調査依頼一覧表ボディのITEM
     * @return 認定調査依頼一覧表のReport
     */
    public static ChosaIraiIchiranhyoReport createFrom(
            ChosaIraiIchiranhyoBodyItem bodyItem) {
        return new ChosaIraiIchiranhyoReport(
                null, bodyItem);
    }

    /**
     * インスタンスを生成します。
     *
     * @param bodyItemList 認定調査依頼一覧表ボディのITEMリスト
     * @param bodyItem 認定調査依頼一覧表ボディのITEM
     */
    protected ChosaIraiIchiranhyoReport(
            List<ChosaIraiIchiranhyoBodyItem> bodyItemList,
            ChosaIraiIchiranhyoBodyItem bodyItem) {
        this.bodyItemList = bodyItemList;
        this.bodyItem = bodyItem;
    }

    /**
     *
     * @param reportSourceWriter 認定調査依頼一覧表Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosaIraiIchiranhyoReportSource> reportSourceWriter) {
        if (bodyItemList != null) {
            for (ChosaIraiIchiranhyoBodyItem item : bodyItemList) {
                IChosaIraiIchiranhyoEditor bodyEditor = new ChosaIraiIchiranhyoBodyEditor(item);
                IChosaIraiIchiranhyoBuilder builder = new ChosaIraiIchiranhyoBuilderImpl(bodyEditor);
                reportSourceWriter.writeLine(builder);
            }
        } else {
            IChosaIraiIchiranhyoEditor bodyEditor = new ChosaIraiIchiranhyoBodyEditor(bodyItem);
            IChosaIraiIchiranhyoBuilder builder = new ChosaIraiIchiranhyoBuilderImpl(bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
