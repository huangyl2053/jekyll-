/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoSealerReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ））のReportです。
 *
 */
public class ShokanKetteiTsuchiShoSealerReport extends Report<ShokanKetteiTsuchiShoSealerReportSource> {

    private final List<ShokanKetteiTsuchiShoSealerItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）のITEM
     * @return 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）のReport
     */
    public static ShokanKetteiTsuchiShoSealerReport createFrom(
            List<ShokanKetteiTsuchiShoSealerItem> itemList) {

        return new ShokanKetteiTsuchiShoSealerReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）のITEM
     */
    protected ShokanKetteiTsuchiShoSealerReport(
            List<ShokanKetteiTsuchiShoSealerItem> itemList) {

        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanKetteiTsuchiShoSealerReportSource> reportSourceWriter) {
        for (ShokanKetteiTsuchiShoSealerItem item : itemList) {
            IShokanKetteiTsuchiShoSealerEditor editor = new ShokanKetteiTsuchiShoSealerEditor(item);
            IShokanKetteiTsuchiShoSealerBuilder builder = new ShokanKetteiTsuchiShoSealerBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
