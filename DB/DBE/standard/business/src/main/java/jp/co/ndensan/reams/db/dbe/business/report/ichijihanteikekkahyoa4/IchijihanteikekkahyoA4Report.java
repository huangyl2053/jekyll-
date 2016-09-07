/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyoa4;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用一次判定結果票A4のReportです。
 *
 * @reamsid_L DBE-0150-300 lishengli
 */
public class IchijihanteikekkahyoA4Report extends Report<IchijihanteikekkahyoA4ReportSource> {

    private static final int LENGTH_20 = 20;
    private final IchijihanteikekkahyoA4Entity item;

    /**
     * インスタンスを生成します。
     *
     * @param item 委員用一次判定結果票Entity
     */
    public IchijihanteikekkahyoA4Report(IchijihanteikekkahyoA4Entity item) {
        this.item = item;
    }

    /**
     * 委員用一次判定結果票A4を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<IchijihanteikekkahyoA4ReportSource> reportSourceWriter) {
        for (int i = 0; i < LENGTH_20; i++) {
            IIchijihanteikekkahyoA4Editor headerEditor = new IchijihanteikekkahyoA4Editor(item, i);
            IIchijihanteikekkahyoA4Builder builder = new IchijihanteikekkahyoA4Builder(headerEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
