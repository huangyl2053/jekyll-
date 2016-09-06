/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishosealer;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100042_介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)のReportです。
 *
 * @reamsid_L DBC-2280-070 lizhuoxuan
 */
public class KyufuhiTsuchishoSealerReport extends Report<KyufuhiTsuchishoSealerReportSource> {

    private final List<KyufuhiTsuchishoSealerEntity> entityList;
    private int index;

    /**
     * インスタンスを生成します。
     *
     * @param entityList 介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)のITEMリスト
     */
    public KyufuhiTsuchishoSealerReport(
            List<KyufuhiTsuchishoSealerEntity> entityList) {
        this.entityList = entityList;
    }

    /**
     * 介護保険給付費通知書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuhiTsuchishoSealerReportSource> reportSourceWriter) {
        for (KyufuhiTsuchishoSealerEntity entity : entityList) {
            index = index + 1;
            IKyufuhiTsuchishoSealerEditor editor = new KyufuhiTsuchishoSealerEditor(entity, index);
            IKyufuhiTsuchishoSealerBuilder builder = new KyufuhiTsuchishoSealerBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
