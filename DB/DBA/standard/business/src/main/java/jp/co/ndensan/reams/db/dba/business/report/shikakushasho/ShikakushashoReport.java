/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushasho.ShikakushashoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険資格者証のReportです。
 */
public final class ShikakushashoReport extends Report<ShikakushashoReportSource> {
    
    private final List<ShikakushashoBodyItem> bodyItemList;
    
    /**
     * インスタンスを生成します。
     * @param bodyItemList 介護保険資格者証情報
     * @return 介護保険資格者証
     */
    public static ShikakushashoReport createReport(@NonNull List<ShikakushashoBodyItem> bodyItemList) {
        return new ShikakushashoReport(bodyItemList);
    }
    
    private ShikakushashoReport(List<ShikakushashoBodyItem> bodyItemList) {
        this.bodyItemList = bodyItemList;
    }

    @Override
    protected void writeBy(ReportSourceWriter<ShikakushashoReportSource> writer) {
        for (int i = 0; i < bodyItemList.size(); i++) {
            IShikakushashoEditor bodyEditor = new ShikakushashoBodyEditor(bodyItemList.get(i), i);
            IShikakushashoBuilder builder = new ShikakushashoBuilderImpl(bodyEditor);
            writer.writeLine(builder);
        }
    }
}
