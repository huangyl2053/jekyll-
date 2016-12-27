/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkijiko;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiJiko;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkijiko.TokkiJikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項帳票のReportクラスです。
 */
public class TokkiJikoReport extends Report<TokkiJikoReportSource> {

    private static final int 短冊行数 = 15;
    private final TokkiJiko data;

    /**
     * コンストラクタです。
     *
     * @param data {@link TokkiJiko}
     */
    public TokkiJikoReport(TokkiJiko data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokkiJikoReportSource> writer) {
        ITokkiJikoReportEditor editor = new TokkiJikoReportEditor(data);
        ITokkiJikoReportBuilder builder = new TokkiJikoReportBuilder(editor);
        writer.writeLine(builder);
        int page = 1;
        while (data.get短冊テキストリスト().size() < page * 短冊行数
                || data.get短冊イメージリスト().size() < page * 短冊行数) {
            ITokkiJikoReportEditor editor2 = new TokkiJikoReport2Editor(data, page);
            ITokkiJikoReportBuilder builder2 = new TokkiJikoReportBuilder(editor2);
            writer.writeLine(builder2);
        }
    }
}
