/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchigenmenhoseiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBC200043_給付費通知減免補正一覧表 Reportクラスです。
 *
 * @reamsid_L DBC-2270-040 dongyabin
 */
public class KyufuhiTuchiGenmenhoseiIchiranReport extends Report<KyufuhiTuchiGenmenhoseiIchiranReportSource> {

    private final KyufuhiTuchiGenmenhoseiIchiranEntity deta;

    /**
     * インスタンスを生成します。
     *
     * @param deta 給付費通知減免補正一覧表パラメータ
     */
    public KyufuhiTuchiGenmenhoseiIchiranReport(KyufuhiTuchiGenmenhoseiIchiranEntity deta) {
        this.deta = deta;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufuhiTuchiGenmenhoseiIchiranReportSource> reportSourceWriter) {
        IKyufuhiTuchiGenmenhoseiIchiranEditor editor = new KyufuhiTuchiGenmenhoseiIchiranEditor(deta);
        KyufuhiTuchiGenmenhoseiIchiranBuilder builder = new KyufuhiTuchiGenmenhoseiIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
