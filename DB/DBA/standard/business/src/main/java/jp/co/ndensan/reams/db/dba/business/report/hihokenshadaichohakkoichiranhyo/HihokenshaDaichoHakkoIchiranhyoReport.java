package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * {@link HihokenshaDaichoHakkoIchiranhyoReportSource}のプロパティです。
 *
 * @reamsid_L DBA-0510-070 wangxiaodong
 */
public final class HihokenshaDaichoHakkoIchiranhyoReport extends Report<HihokenshaDaichoHakkoIchiranhyoReportSource> {

    private final HihokenshaDaichoHakkoIchiranhyoHeaderItem headerItem;
    private final List<HihokenshaDaichoHakkoIchiranhyoBodyItem> bodyItemList;

    /**
     * インスタンスを生成します。
     *
     * @param headerItem 被保険者台帳一覧表ヘッダーItem
     * @param bodyItemList 被保険者台帳一覧表ボディーItemリスト
     */
    private HihokenshaDaichoHakkoIchiranhyoReport(HihokenshaDaichoHakkoIchiranhyoHeaderItem headerItem,
            List<HihokenshaDaichoHakkoIchiranhyoBodyItem> bodyItemList) {
        this.headerItem = headerItem;
        this.bodyItemList = bodyItemList;
    }

    /**
     * インスタンスを生成します。
     *
     * @param headerItem 被保険者台帳一覧表ヘッダーItem
     * @param bodyItemList 被保険者台帳一覧表ボディーItemリスト
     * @return 被保険者台帳一覧表
     */
    public static HihokenshaDaichoHakkoIchiranhyoReport createReport(
            @NonNull HihokenshaDaichoHakkoIchiranhyoHeaderItem headerItem,
            @NonNull List<HihokenshaDaichoHakkoIchiranhyoBodyItem> bodyItemList) {
        return new HihokenshaDaichoHakkoIchiranhyoReport(headerItem, bodyItemList);
    }

    /**
     *
     * @param writer 被保険者台帳一覧表Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<HihokenshaDaichoHakkoIchiranhyoReportSource> writer) {
        for (HihokenshaDaichoHakkoIchiranhyoBodyItem item : bodyItemList) {
            HihokenshaDaichoHakkoIchiranhyoHeaderEditor header = new HihokenshaDaichoHakkoIchiranhyoHeaderEditor(headerItem);
            HihokenshaDaichoHakkoIchiranhyoBodyEditor body = new HihokenshaDaichoHakkoIchiranhyoBodyEditor(item);
            IHihokenshaDaichoHakkoIchiranhyoBuilder builder = new HihokenshaDaichoHakkoIchiranhyoBuilderImpl(header, body);
            writer.writeLine(builder);
        }
    }
}
