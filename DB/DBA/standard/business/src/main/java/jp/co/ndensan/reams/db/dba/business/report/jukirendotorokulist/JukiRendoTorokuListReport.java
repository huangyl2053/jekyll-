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
 * 住基連動登録リスト帳票です。
 *
 * @reamsid_L DBA-0560-060 xuyue
 */
public class JukiRendoTorokuListReport extends Report<JukiRendoTorokuListReportSource> {

    private final List<JukiRendoTorokuListItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets JukiRendoTorokuListItem
     */
    protected JukiRendoTorokuListReport(List<JukiRendoTorokuListItem> targets) {
        this.targets = targets;

    }

    /**
     * インスタンスを生成します。
     *
     * @param jukiRendoTorokuListItems 住基連動登録リストのITEMリスト
     * @return 住基連動登録リストのReport
     */
    public static JukiRendoTorokuListReport createFrom(@NonNull List<JukiRendoTorokuListItem> jukiRendoTorokuListItems) {
        return new JukiRendoTorokuListReport(jukiRendoTorokuListItems);
    }

    /**
     *
     * @param reportSourceWriter ReportSourceWriter
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
