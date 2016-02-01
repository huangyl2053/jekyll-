/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashoa4.HihokenshashoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険被保険者証のReportです。
 */
public final class HihokenshashoA4Report extends Report<HihokenshashoA4ReportSource> {
    
    private final List<HihokenshashoA4BodyItem> bodyItemList;
    
    /**
     * インスタンスを生成します。
     * @param bodyItemList 介護保険被保険者証情報
     * @return 介護保険被保険者証
     */
    public static HihokenshashoA4Report createReport(@NonNull List<HihokenshashoA4BodyItem> bodyItemList) {
        return new HihokenshashoA4Report(bodyItemList);
    }
    
    private HihokenshashoA4Report(List<HihokenshashoA4BodyItem> bodyItemList) {
        this.bodyItemList = bodyItemList;
    }

    @Override
    protected void writeBy(ReportSourceWriter<HihokenshashoA4ReportSource> writer) {
        for (int i = 0; i < bodyItemList.size(); i++) {
            IHihokenshashoA4Editor bodyEditor = new HihokenshashoA4BodyEditor(bodyItemList.get(i), i);
            IHihokenshashoA4Builder builder = new HihokenshashoA4BuilderItem(bodyEditor);
            writer.writeLine(builder);
        }
    }
}
