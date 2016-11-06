/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishocover;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishocover.KyufuhiTsuchishoCoverEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishocover.KyufuhiTsuchishoCoverReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100041_介護保険給付費通知書のReportです。
 *
 * @reamsid_L DBC-2280-040 lizhuoxuan
 */
public class KyufuhiTsuchishoCoverReport extends Report<KyufuhiTsuchishoCoverReportSource> {

    private static final int PAGECOUNT = 15;
    private final KyufuhiTsuchishoCoverEntity entity;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param entity 介護保険給付費通知書のITEM
     * @param index 連番
     */
    public KyufuhiTsuchishoCoverReport(
            KyufuhiTsuchishoCoverEntity entity,
            int index) {
        this.entity = entity;
        this.index = index;
    }

    /**
     * 介護保険給付費通知書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuhiTsuchishoCoverReportSource> reportSourceWriter) {
        if (PAGECOUNT >= index) {
            IKyufuhiTsuchishoCoverEditor editor = new KyufuhiTsuchishoCoverEditor(entity);
            IKyufuhiTsuchishoCoverBuilder builder = new KyufuhiTsuchishoCoverBuilder(editor);
            reportSourceWriter.writeLine(builder);
        } else {
            IKyufuhiTsuchishoCoverEditor editor = new KyufuhiTsuchishoCoverTwoEditor(entity);
            IKyufuhiTsuchishoCoverBuilder builder = new KyufuhiTsuchishoCoverBuilder(editor);
            reportSourceWriter.writeLine(builder);

        }
    }
}
