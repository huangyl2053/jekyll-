/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 一次判定結果のReportです。
 *
 * @reamsid_L DBE-0230-060 lizhuoxuan
 */
public class IchijihanteikekkahyoReport extends Report<IchijihanteikekkahyoReportSource> {

    private final IchijihanteikekkahyoEntity entity;
    private static final int ZERO = 0;
    private static final int MAXCOUNT = 20;

    /**
     * インスタンスを生成します。
     *
     * @param entity 主治医意見書Entity
     */
    public IchijihanteikekkahyoReport(IchijihanteikekkahyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 主治医意見書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<IchijihanteikekkahyoReportSource> reportSourceWriter) {
        for (int i = ZERO; i < MAXCOUNT; i++) {
            IIchijihanteikekkahyoEditor editor = new IchijihanteikekkahyoEditor(entity, i);
            IIchijihanteikekkahyoBuilder builder = new IchijihanteikekkahyoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }

    }
}
