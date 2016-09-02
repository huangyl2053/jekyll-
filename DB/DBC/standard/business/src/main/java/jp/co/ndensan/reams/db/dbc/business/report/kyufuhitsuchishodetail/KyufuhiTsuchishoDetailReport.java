/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishodetail;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険給付費通知書(２ページ目以降)のReportです。
 *
 * @reamsid_L DBC-2280-050 lizhuoxuan
 */
public class KyufuhiTsuchishoDetailReport extends Report<KyufuhiTsuchishoDetailReportSource> {

    private final List<KyufuhiTsuchishoDetailEntity> entityList;
    private int index;

    /**
     * インスタンスを生成します。
     *
     * @param entityList 介護保険給付費通知書(２ページ目以降)のITEMリスト
     */
    public KyufuhiTsuchishoDetailReport(
            List<KyufuhiTsuchishoDetailEntity> entityList) {
        this.entityList = entityList;
    }

    /**
     * 介護保険給付費通知書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuhiTsuchishoDetailReportSource> reportSourceWriter) {
        for (KyufuhiTsuchishoDetailEntity entity : entityList) {
            index = index + 1;
            IKyufuhiTsuchishoDetailEditor editor = new KyufuhiTsuchishoDetailEditor(entity, index);
            IKyufuhiTsuchishoDetailBuilder builder = new KyufuhiTsuchishoDetailBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
