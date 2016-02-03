/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer2ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のReportです。
 *
 */
public class ShokanKetteiTsuchiShoSealer2Report extends Report<ShokanKetteiTsuchiShoSealer2ReportSource> {

    private final ShokanKetteiTsuchiShoSealer2Item item;

    /**
     * インスタンスを生成します。
     *
     * @param item 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のITEM
     * @return 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のReport
     */
    public static ShokanKetteiTsuchiShoSealer2Report createFrom(ShokanKetteiTsuchiShoSealer2Item item) {
        return new ShokanKetteiTsuchiShoSealer2Report(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のITEM
     */
    protected ShokanKetteiTsuchiShoSealer2Report(ShokanKetteiTsuchiShoSealer2Item item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanKetteiTsuchiShoSealer2ReportSource> reportSourceWriter) {
        IShokanKetteiTsuchiShoSealer2Editor editor = new ShokanKetteiTsuchiShoSealer2HeadEditor(item);
        IShokanKetteiTsuchiShoSealer2Builder builder = new ShokanKetteiTsuchiShoSealer2BuliderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
