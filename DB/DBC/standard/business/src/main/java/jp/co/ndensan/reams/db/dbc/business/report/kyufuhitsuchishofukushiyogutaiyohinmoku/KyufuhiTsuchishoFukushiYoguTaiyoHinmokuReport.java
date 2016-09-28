/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishofukushiyogutaiyohinmoku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のReportです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport extends Report<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource> {

    private final KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity entity;
    private int index;

    /**
     * インスタンスを生成します。
     *
     * @param entity 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のITEM
     */
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport(
            KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護保険給付費通知書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource> reportSourceWriter) {
        index = index + 1;
        IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor editor = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor(entity, index);
        IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuBuilder builder = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
