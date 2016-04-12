/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer2ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のReportです。
 *
 * @reamsid_L DBC-1000-140 hezhenzhen
 *
 */
public class ShokanKetteiTsuchiShoSealer2Report extends Report<ShokanKetteiTsuchiShoSealer2ReportSource> {

    private final List<ShokanKetteiTsuchiShoSealer2Item> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のITEM
     * @return 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のReport
     */
    public static ShokanKetteiTsuchiShoSealer2Report createFrom(List<ShokanKetteiTsuchiShoSealer2Item> itemList) {
        return new ShokanKetteiTsuchiShoSealer2Report(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のITEM
     */
    protected ShokanKetteiTsuchiShoSealer2Report(List<ShokanKetteiTsuchiShoSealer2Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanKetteiTsuchiShoSealer2ReportSource> reportSourceWriter) {
        for (ShokanKetteiTsuchiShoSealer2Item item : itemList) {
            IShokanKetteiTsuchiShoSealer2Editor editor = new ShokanKetteiTsuchiShoSealer2HeadEditor(item);
            IShokanKetteiTsuchiShoSealer2Builder builder = new ShokanKetteiTsuchiShoSealer2BuliderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
