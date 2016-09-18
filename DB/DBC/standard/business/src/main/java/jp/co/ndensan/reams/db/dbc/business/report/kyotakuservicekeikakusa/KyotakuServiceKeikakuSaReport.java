/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa;

import jp.co.ndensan.reams.db.dbc.entity.report.kyotakuservicekeikakusakusei.KyotakuServiceKeikakuSakuseiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 計画届出状況チェックリストReportクラスです。
 *
 * @reamsid_L DBC-1960-040 wangxingpeng
 */
public class KyotakuServiceKeikakuSaReport extends
        Report<KyotakuServiceKeikakuSakuseiSource> {

    private final KyotakuServiceKeikakuSaParam 帳票出力パラメータ;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力パラメータ KyotakuServiceKeikakuSaParam
     */
    public KyotakuServiceKeikakuSaReport(KyotakuServiceKeikakuSaParam 帳票出力パラメータ) {
        this.帳票出力パラメータ = 帳票出力パラメータ;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyotakuServiceKeikakuSakuseiSource> writer) {
        if (null == 帳票出力パラメータ) {
            return;
        }
        IKyotakuServiceKeikakuSaEditor headerEditor = new KyotakuServiceKeikakuSaHeaderEditor(帳票出力パラメータ);
        IKyotakuServiceKeikakuSaEditor bodyEditor = new KyotakuServiceKeikakuSaBodyEditor(帳票出力パラメータ);
        IKyotakuServiceKeikakuSaBuilder builder = new KyotakuServiceKeikakuSaBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
