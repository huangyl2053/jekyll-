/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkijiko;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiJiko;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
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
        List<TokkiA4Entity> 短冊リスト;
        boolean isText;
        if (!data.get短冊テキストリスト().isEmpty()) {
            短冊リスト = data.get短冊テキストリスト();
            isText = true;
        } else if (!data.get短冊イメージリスト().isEmpty()) {
            短冊リスト = data.get短冊イメージリスト();
            isText = false;
        } else {
            短冊リスト = Collections.EMPTY_LIST;
            isText = false;
        }

        if (!短冊リスト.isEmpty()) {
            int page = 0;
            int column = 0;
            ITokkiJikoReportEditor editor = new TokkiJikoReportEditor(data, 0);
            for (int i = 0; i < 短冊リスト.size(); i++) {
                if (column == 短冊行数) {
                    page++;
                    column = 0;
                    editor = new TokkiJikoReportEditor(data, page);
                }
                ITokkiJikoReportListFieldEditor listEditor = new TokkiJikoReportListFieldEditor(短冊リスト.get(i).get事項番号(), isText);
                ITokkiJikoReportBuilder builder = new TokkiJikoReportBuilder(editor, listEditor);
                writer.writeLine(builder);
                ITokkiJikoReportListFieldEditor listEditor2 = new TokkiJikoReportListFieldEditor(短冊リスト.get(i).get項目名称(), isText);
                ITokkiJikoReportBuilder builder2 = new TokkiJikoReportBuilder(editor, listEditor2);
                writer.writeLine(builder2);
                column++;
            }
        } else {
            for (int i = 0; i < data.get全画面イメージリスト().size(); i++) {
                ITokkiJikoReportEditor editor = new TokkiJikoReportEditor(data, i);
                ITokkiJikoReportBuilder builder = new TokkiJikoReportBuilder(editor);
                writer.writeLine(builder);
            }
        }
    }
}
