/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 広域内住所地特例者一覧表のReportです。
 */
public class KoikinaiJushochitokureishaIchiranhyoReport extends Report<KoikinaiJushochitokureishaIchiranhyoReportSource> {

    private final List<KoikinaiJushochitokureishaIchiranhyoBodyItem> bodyItemList;
    private final KoikinaiJushochitokureishaIchiranhyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 広域内住所地特例者一覧表ヘッダのITEM
     * @param itemList 広域内住所地特例者一覧表ボディのITEMリスト
     * @return 広域内住所地特例者一覧表のReport
     */
    public static KoikinaiJushochitokureishaIchiranhyoReport createFrom(
            KoikinaiJushochitokureishaIchiranhyoHeadItem headItem,
            @NonNull List<KoikinaiJushochitokureishaIchiranhyoBodyItem> itemList) {

        return new KoikinaiJushochitokureishaIchiranhyoReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 広域内住所地特例者一覧表ヘッダのITEM
     * @param itemList 広域内住所地特例者一覧表のITEMリスト
     */
    protected KoikinaiJushochitokureishaIchiranhyoReport(
            KoikinaiJushochitokureishaIchiranhyoHeadItem headItem,
            List<KoikinaiJushochitokureishaIchiranhyoBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KoikinaiJushochitokureishaIchiranhyoReportSource> reportSourceWriter) {
        for (KoikinaiJushochitokureishaIchiranhyoBodyItem bodyItem : bodyItemList) {
            KoikinaiJushochitokureishaIchiranhyoEditor headerEditor = new KoikinaiJushochitokureishaIchiranhyoHeaderEditor(headItem);
            KoikinaiJushochitokureishaIchiranhyoEditor bodyEditor = new KoikinaiJushochitokureishaIchiranhyoBodyEditor(bodyItem);
            KoikinaiJushochitokureishaIchiranhyoBuilder builder = new KoikinaiJushochitokureishaIchiranhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
