/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosokatsuhyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyosokatsuhyo.KyufuKanrihyoSokatsuhyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyosokatsuhyo.KyufuKanrihyoSokatsuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 給付管理票総括票のReportです。
 *
 * @reamsid_L DBC-2840-042 kanghongsong
 */
public class KyufuKanrihyoSokatsuhyoReport extends Report<KyufuKanrihyoSokatsuhyoReportSource> {

    private final KyufuKanrihyoSokatsuhyoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 給付管理票総括票Entity
     */
    public KyufuKanrihyoSokatsuhyoReport(KyufuKanrihyoSokatsuhyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 給付管理票総括票を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuKanrihyoSokatsuhyoReportSource> reportSourceWriter) {

        IKyufuKanrihyoSokatsuhyoEditor headerEditor = new KyufuKanrihyoSokatsuhyoEditor(entity);
        IKyufuKanrihyoSokatsuhyoBuilder builder = new KyufuKanrihyoSokatsuhyoBuilder(headerEditor);
        reportSourceWriter.writeLine(builder);
    }

}
