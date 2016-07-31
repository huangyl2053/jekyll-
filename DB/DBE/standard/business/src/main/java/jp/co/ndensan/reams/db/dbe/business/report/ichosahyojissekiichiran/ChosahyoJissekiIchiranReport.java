/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichosahyojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.ChosahyoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.chosahyojissekiichiran.ChosahyoJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票出力用認定調査実績集計表Builderクラスです。
 *
 * @reamsid_L DBE-1691-030 dangjingjing
 */
public class ChosahyoJissekiIchiranReport extends Report<ChosahyoJissekiIchiranReportSource> {

    private final ChosahyoJissekiIchiranEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ChosahyoJissekiIchiranReport(ChosahyoJissekiIchiranEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosahyoJissekiIchiranReportSource> reportSourceWriter) {
        IChosahyoJissekiIchiranEditor editor = new ChosahyoJissekiIchiranEditor(data);
        IChosahyoJissekiIchiranBuilder builder = new ChosahyoJissekiIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
