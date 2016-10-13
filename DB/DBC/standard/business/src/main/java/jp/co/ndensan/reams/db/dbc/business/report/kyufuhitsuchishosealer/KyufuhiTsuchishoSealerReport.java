/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishosealer;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100042_介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)のReportです。
 *
 * @reamsid_L DBC-2280-070 lizhuoxuan
 */
public class KyufuhiTsuchishoSealerReport extends Report<KyufuhiTsuchishoSealerReportSource> {

    private final KyufuhiTsuchishoSealerEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)のITEM
     */
    public KyufuhiTsuchishoSealerReport(
            KyufuhiTsuchishoSealerEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護保険給付費通知書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuhiTsuchishoSealerReportSource> reportSourceWriter) {
        IKyufuhiTsuchishoSealerEditor editor = new KyufuhiTsuchishoSealerEditor(entity);
        IKyufuhiTsuchishoSealerBuilder builder = new KyufuhiTsuchishoSealerBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
