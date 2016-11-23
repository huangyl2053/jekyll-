/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba110010.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakkoKanriboChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 被保険者証発行管理一覧表のReportです。
 *
 * @reamsid_L DBA-0600-070 lishengli
 */
public class HihokenshashoHakkoKanriIchiranhyoReport extends Report<HihokenshashoHakkoKanriIchiranhyoReportSource> {

    private final HihokenshashoHakkoKanriboProcessParameter parameter;
    private final List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> bodyItemList;

    /**
     * インスタンスを生成します。
     *
     * @param parameter バッチパラメータ
     * @param bodyItemList 被保険者証発行管理一覧表ボディのITEMリスト
     * @return 被保険者証発行管理一覧表のReport
     */
    public static HihokenshashoHakkoKanriIchiranhyoReport createFrom(
            @NonNull HihokenshashoHakkoKanriboProcessParameter parameter,
            @NonNull List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> bodyItemList) {

        return new HihokenshashoHakkoKanriIchiranhyoReport(
                parameter,
                bodyItemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param parameter バッチパラメータ
     * @param bodyItemList 被保険者証発行管理一覧表ボディのITEMリスト
     */
    protected HihokenshashoHakkoKanriIchiranhyoReport(
            HihokenshashoHakkoKanriboProcessParameter parameter,
            List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> bodyItemList) {

        this.parameter = parameter;
        this.bodyItemList = bodyItemList;
    }

    /**
     * 被保険者証発行管理一覧表writeBy。
     *
     * @param reportSourceWriter 被保険者証発行管理一覧表のReportSource
     */
    @Override
    public void writeBy(ReportSourceWriter<HihokenshashoHakkoKanriIchiranhyoReportSource> reportSourceWriter) {

        if (bodyItemList.isEmpty()) {
            return;
        }
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> outputList = new ArrayList<>();
        outputList.addAll(bodyItemList);

        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> paramItemList = HihokenshashoHakkoKanriExtractionCondition
                .create(parameter, bodyItemList.get(0));
        outputList.addAll(paramItemList);

        for (HihohenshashoHakkoKanriboChohyoDataSakuseiEntity bodyItem : outputList) {
            IHihokenshashoHakkoKanriIchiranhyoEditor bodyEditor = new HihokenshashoHakkoKanriIchiranhyoEditor(bodyItem);
            IHihokenshashoHakkoKanriIchiranhyoBuilder builder = new HihokenshashoHakkoKanriIchiranhyoBuilder(bodyEditor);
            reportSourceWriter.writeLine(builder);
        }

    }
}
