/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakukaishuriyushosakusei;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishuriyushosakusei.JutakuKaishuRiyushoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jutakukaishuriyushosakusei.JutakuKaishuRiyushoSakuseiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200004_利用状況一覧表Reportクラスです。
 *
 * @reamsid_L DBC-2850-040 lizhuoxuan
 */
public class JutakuKaishuRiyushoSakuseiReport extends Report<JutakuKaishuRiyushoSakuseiReportSource> {

    private final JutakuKaishuRiyushoSakuseiEntity deta;

    /**
     * インスタンスを生成します。
     *
     * @param deta 利用状況一覧表パラメータ
     */
    public JutakuKaishuRiyushoSakuseiReport(JutakuKaishuRiyushoSakuseiEntity deta) {
        this.deta = deta;
    }

    @Override
    public void writeBy(ReportSourceWriter<JutakuKaishuRiyushoSakuseiReportSource> reportSourceWriter) {
        IJutakuKaishuRiyushoSakuseiEditor editor = new JutakuKaishuRiyushoSakuseiEditor(deta);
        IJutakuKaishuRiyushoSakuseiBuilder builder = new JutakuKaishuRiyushoSakuseiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
