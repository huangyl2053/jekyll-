/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.chosairairirekiichiran.ChosairairirekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査依頼履歴一覧表のReportです。
 *
 * @reamsid_L DBE-1590-031 sunhaidi
 */
public class ChosairairirekiIchiranReport extends Report<ChosairairirekiIchiranReportSource> {

    private final List<ChosairairirekiIchiranBusiness> businessList;

    /**
     * インスタンスを生成します。
     *
     * @param businessList 要介護認定判定結果一覧表Ａ３版のentity
     */
    public ChosairairirekiIchiranReport(List<ChosairairirekiIchiranBusiness> businessList) {
        this.businessList = businessList;
    }

    /**
     * 認定調査依頼履歴一覧表を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosairairirekiIchiranReportSource> reportSourceWriter) {
        for (ChosairairirekiIchiranBusiness business : businessList) {
            IChosairairirekiIchiranEditor editor = new ChosairairirekiIchiranEditorImpl(business);
            IChosairairirekiIchiranBuilder builder = new ChosairairirekiIchiranBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
