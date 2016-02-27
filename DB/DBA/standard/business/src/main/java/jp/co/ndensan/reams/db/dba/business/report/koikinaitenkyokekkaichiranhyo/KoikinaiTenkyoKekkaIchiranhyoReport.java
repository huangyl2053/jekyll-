/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 広域内転居結果一覧表のReportです。
 */
public class KoikinaiTenkyoKekkaIchiranhyoReport extends Report<KoikinaiTenkyoKekkaIchiranhyoReportSource> {

    private final List<KoikinaiTenkyoKekkaIchiranhyoBodyItem> bodyItemList;
    private final KoikinaiTenkyoKekkaIchiranhyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 広域内転居結果一覧表ヘッダのITEM
     * @param itemList 広域内転居結果一覧表ボディのITEMリスト
     * @return 広域内住所地特例者一覧表のReport
     */
    public static KoikinaiTenkyoKekkaIchiranhyoReport createFrom(
            KoikinaiTenkyoKekkaIchiranhyoHeadItem headItem,
            @NonNull List<KoikinaiTenkyoKekkaIchiranhyoBodyItem> itemList) {

        return new KoikinaiTenkyoKekkaIchiranhyoReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 広域内転居結果一覧表ヘッダのITEM
     * @param itemList 広域内転居結果一覧表のITEMリスト
     */
    protected KoikinaiTenkyoKekkaIchiranhyoReport(
            KoikinaiTenkyoKekkaIchiranhyoHeadItem headItem,
            List<KoikinaiTenkyoKekkaIchiranhyoBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KoikinaiTenkyoKekkaIchiranhyoReportSource> reportSourceWriter) {
        for (KoikinaiTenkyoKekkaIchiranhyoBodyItem bodyItem : bodyItemList) {
            IKoikinaiTenkyoKekkaIchiranhyoEditor headerEditor = new KoikinaiTenkyoKekkaIchiranhyoHeaderEditor(headItem);
            IKoikinaiTenkyoKekkaIchiranhyoEditor bodyEditor = new KoikinaiTenkyoKekkaIchiranhyoBodyEditor(bodyItem);
            IKoikinaiTenkyoKekkaIchiranhyoBuilder builder = new KoikinaiTenkyoKekkaIchiranhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
