/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 認定調査依頼発行一覧表のReportです。
 *
 * @reamsid_L DBE-0080-110 yaodongsheng
 */
public class ChosaIraiHakkoIchiranhyoReport extends Report<ChosaIraiHakkoIchiranhyoReportSource> {

    private final ChosaIraiHakkoIchiranhyoBodyItem item;
    private final List<ChosaIraiHakkoIchiranhyoBodyItem> bodyItemList;
    private final ChosaIraiHakkoIchiranhyoHeadItem headItem;
    private final int count;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査依頼発行一覧表ヘッダのITEM
     * @param itemList 認定調査依頼発行一覧表ボディのITEMリスト
     * @return 認定調査依頼発行一覧表のReport
     */
    public static ChosaIraiHakkoIchiranhyoReport createFrom(
            ChosaIraiHakkoIchiranhyoHeadItem headItem,
            @NonNull List<ChosaIraiHakkoIchiranhyoBodyItem> itemList) {

        return new ChosaIraiHakkoIchiranhyoReport(
                headItem,
                null,
                itemList,
                0);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査依頼発行一覧表ヘッダのITEM
     * @param item 認定調査依頼発行一覧表ボディのITEM
     * @param count count
     * @return 認定調査依頼発行一覧表のReport
     */
    public static ChosaIraiHakkoIchiranhyoReport createFrom(
            ChosaIraiHakkoIchiranhyoHeadItem headItem,
            ChosaIraiHakkoIchiranhyoBodyItem item,
            int count) {

        return new ChosaIraiHakkoIchiranhyoReport(
                headItem,
                item,
                null,
                count);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査依頼発行一覧表ヘッダのITEM
     * @param bodyItem bodyItem
     * @param bodyItemList bodyItemList
     * @param count count
     */
    protected ChosaIraiHakkoIchiranhyoReport(
            ChosaIraiHakkoIchiranhyoHeadItem headItem,
            ChosaIraiHakkoIchiranhyoBodyItem bodyItem,
            List<ChosaIraiHakkoIchiranhyoBodyItem> bodyItemList,
            int count) {

        this.headItem = headItem;
        this.item = bodyItem;
        this.bodyItemList = bodyItemList;
        this.count = count;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosaIraiHakkoIchiranhyoReportSource> reportSourceWriter) {
        if (bodyItemList != null) {
            int renban = 0;
            RString breakKey = RString.EMPTY;
            for (ChosaIraiHakkoIchiranhyoBodyItem bodyItem : bodyItemList) {
                if (!breakKey.equals(setBreakKey(bodyItem))) {
                    renban = 1;
                } else {
                    renban++;
                }
                bodyItem.setRenban(renban);
                ChosaIraiHakkoIchiranhyoHeaderEditor headerEditor = new ChosaIraiHakkoIchiranhyoHeaderEditor(headItem);
                ChosaIraiHakkoIchiranhyoBodyEditor bodyEditor = new ChosaIraiHakkoIchiranhyoBodyEditor(bodyItem);
                IChosaIraiHakkoIchiranhyoBuilder builder = new ChosaIraiHakkoIchiranhyoBuilderImpl(headerEditor, bodyEditor);
                reportSourceWriter.writeLine(builder);
                breakKey = setBreakKey(bodyItem);
            }
        } else {
            item.setRenban(count);
            ChosaIraiHakkoIchiranhyoHeaderEditor headerEditor = new ChosaIraiHakkoIchiranhyoHeaderEditor(headItem);
            ChosaIraiHakkoIchiranhyoBodyEditor bodyEditor = new ChosaIraiHakkoIchiranhyoBodyEditor(item);
            IChosaIraiHakkoIchiranhyoBuilder builder = new ChosaIraiHakkoIchiranhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private RString setBreakKey(ChosaIraiHakkoIchiranhyoBodyItem item) {
        return new RStringBuilder().append(item.get依頼書作成日()).append(item.get依頼書提出期限()).append(item.get市町村コード()).toRString();
    }
}
