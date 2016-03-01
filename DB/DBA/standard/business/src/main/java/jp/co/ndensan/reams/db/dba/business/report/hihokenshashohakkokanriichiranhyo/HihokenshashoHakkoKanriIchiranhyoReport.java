/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 被保険者証発行管理一覧表のReportです。
 */
public class HihokenshashoHakkoKanriIchiranhyoReport extends Report<HihokenshashoHakkoKanriIchiranhyoReportSource> {

    private final List<HihokenshashoHakkoKanriIchiranhyoBodyItem> bodyItemList;
    private final HihokenshashoHakkoKanriIchiranhyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 被保険者証発行管理一覧表ヘッダのITEM
     * @param bodyItemList 被保険者証発行管理一覧表ボディのITEMリスト
     * @return 被保険者証発行管理一覧表のReport
     */
    public static HihokenshashoHakkoKanriIchiranhyoReport createFrom(
            HihokenshashoHakkoKanriIchiranhyoHeadItem headItem,
            @NonNull List<HihokenshashoHakkoKanriIchiranhyoBodyItem> bodyItemList) {

        return new HihokenshashoHakkoKanriIchiranhyoReport(
                headItem,
                bodyItemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 被保険者証発行管理一覧表ヘッダのITEM
     * @param bodyItemList 被保険者証発行管理一覧表ボディのITEMリスト
     */
    protected HihokenshashoHakkoKanriIchiranhyoReport(
            HihokenshashoHakkoKanriIchiranhyoHeadItem headItem,
            List<HihokenshashoHakkoKanriIchiranhyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }

    /**
     * 被保険者証発行管理一覧表writeBy。
     *
     * @param reportSourceWriter 被保険者証発行管理一覧表のReportSource
     */
    @Override
    public void writeBy(ReportSourceWriter<HihokenshashoHakkoKanriIchiranhyoReportSource> reportSourceWriter) {
        for (HihokenshashoHakkoKanriIchiranhyoBodyItem bodyItem : bodyItemList) {
            IHihokenshashoHakkoKanriIchiranhyoEditor headEditor = new HihokenshashoHakkoKanriIchiranhyoHeaderEditor(headItem);
            IHihokenshashoHakkoKanriIchiranhyoEditor bodyEditor = new HihokenshashoHakkoKanriIchiranhyoBodyEditor(bodyItem);
            IHihokenshashoHakkoKanriIchiranhyoBuilder builder = new HihokenshashoHakkoKanriIchiranhyoBuilderItem(headEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
