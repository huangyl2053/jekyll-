/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishofukushiyogutaiyohinmoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のReportです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport extends Report<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource> {

    private final List<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity> entityList;
    private int index;

    /**
     * インスタンスを生成します。
     *
     * @param entityList 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のITEMリスト
     */
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport(
            List<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity> entityList) {
        this.entityList = entityList;
    }

    /**
     * 介護保険給付費通知書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource> reportSourceWriter) {
        for (KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity entity : entityList) {
            index = index + 1;
            IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor editor = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor(entity, index);
            IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuBuilder builder = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
