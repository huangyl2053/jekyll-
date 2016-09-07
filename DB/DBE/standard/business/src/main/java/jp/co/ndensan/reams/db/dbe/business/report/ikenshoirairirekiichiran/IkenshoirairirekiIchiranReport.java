/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoirairirekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiIchiran;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBE230004_主治医意見書作成依頼履歴一覧表のReportです。
 *
 * @reamsid_L DBE-1590-032 zuotao
 */
public class IkenshoirairirekiIchiranReport extends Report<IkenshoirairirekiIchiranReportSource> {

    private final List<IkenshoirairirekiIchiran> businessList;

    /**
     * インスタンスを生成します。
     *
     * @param businessList 主治医意見書作成依頼履歴一覧表
     * @return 主治医意見書作成依頼履歴一覧表のReport
     */
    public static IkenshoirairirekiIchiranReport createFrom(List<IkenshoirairirekiIchiran> businessList) {

        return new IkenshoirairirekiIchiranReport(businessList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param businessList 主治医意見書作成依頼履歴一覧表
     */
    public IkenshoirairirekiIchiranReport(List<IkenshoirairirekiIchiran> businessList) {
        this.businessList = businessList;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenshoirairirekiIchiranReportSource> reportSourceWriter) {
        for (IkenshoirairirekiIchiran business : businessList) {
            IkenshoirairirekiIchiranEditor editor = new IkenshoirairirekiIchiranEditor(business);
            IkenshoirairirekiIchiranBuilder builder = new IkenshoirairirekiIchiranBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
