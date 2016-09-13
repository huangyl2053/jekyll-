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

    private final KyotakuServiceKeikakuSaParam parameter;

    /**
     * インスタンスを生成します。
     *
     * @param parameter KyotakuServiceKeikakuSaParam
     */
    public KyotakuServiceKeikakuSaReport(KyotakuServiceKeikakuSaParam parameter) {
        this.parameter = parameter;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyotakuServiceKeikakuSakuseiSource> writer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
