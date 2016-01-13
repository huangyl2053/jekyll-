/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.jukirendotorokulist.JukiRendoTorokuListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 住基連動登録リスト帳票作成
 */
public class JukiRendoTorokuListReport extends Report<JukiRendoTorokuListReportSource> {

    private final List<JukiRendoTorokuListItem> targets;

    protected JukiRendoTorokuListReport(List<JukiRendoTorokuListItem> targets) {
        this.targets = targets;

    }

    /**
     * インスタンスを生成します。
     *
     * @param JukiRendoTorokuListItems 住基連動登録リストのITEMリスト
     * @return 住基連動登録リストのReport
     */

    public static JukiRendoTorokuListReport createFrom(@NonNull List<JukiRendoTorokuListItem> JukiRendoTorokuListItems) {
        return new JukiRendoTorokuListReport(JukiRendoTorokuListItems);
    }

    /**
     *
     * @param reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<JukiRendoTorokuListReportSource> reportSourceWriter) {
        for (JukiRendoTorokuListItem target : targets) {
            IJukiRendoTorokuListEditor headerEditor = new JukiRendoTorokuListHeaderEditor(target);
            IJukiRendoTorokuListEditor hyojiBodyEditor = new JukiRendoTorokuListBodyEditor(target);
            IJuKiRendoTorokuListBuilder builder = new JuKiRendoTorokuListBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);

        }
    }
}
