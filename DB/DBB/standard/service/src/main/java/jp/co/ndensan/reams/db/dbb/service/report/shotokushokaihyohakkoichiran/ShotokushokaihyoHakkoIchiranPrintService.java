/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.shotokushokaihyohakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 帳票設計_DBBPR51001_所得照会票発行一覧表のPrintService
 *
 * @reamsid_L DBB-1720-060 lijunjun
 */
public class ShotokushokaihyoHakkoIchiranPrintService {

    private static final ReportId 帳票分類ID = new ReportId("DBB200024_ShotokushokaihyoHakkoIchiran");

    /**
     * 所得照会票発行一覧表printメソッドです。
     *
     * @param 所得照会票発行一覧リスト List<ShotokuShoukaiDataTempEntity>
     * @param 構成市町村情報リスト List<KoikiZenShichosonJoho>
     * @param 照会年月日 FlexibleDate
     * @param 処理年度 FlexibleYear
     * @param テストプリント boolean
     * @param 出力順ID Long
     * @return SourceDataCollection
     */
    public SourceDataCollection print所得照会票(List<ShotokuShoukaiDataTempEntity> 所得照会票発行一覧リスト,
            List<KoikiZenShichosonJoho> 構成市町村情報リスト,
            FlexibleDate 照会年月日,
            FlexibleYear 処理年度,
            boolean テストプリント,
            Long 出力順ID) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, 出力順ID);
        ShotokushokaihyoHakkoIchiranProperty property = new ShotokushokaihyoHakkoIchiranProperty(並び順);

        List<RString> 出力順項目リスト = get出力順(出力順ID);
        List<RString> 改頁項目リスト = get改頁項目(出力順ID);

        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShotokushokaihyoHakkoIchiranSource> assembler
                    = createAssembler(property, reportManager)) {
                ReportSourceWriter<ShotokushokaihyoHakkoIchiranSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new ShotokushokaihyoHakkoIchiranReport(所得照会票発行一覧リスト, 構成市町村情報リスト, 出力順項目リスト,
                        改頁項目リスト, 照会年月日, 処理年度, テストプリント, association).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

    private List<RString> get出力順(Long 出力順ID) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200024.getReportId(), 出力順ID);
        List<RString> 並び順List = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                並び順List.add(item.get項目名());
            }
        }
        return 並び順List;
    }

    private List<RString> get改頁項目(Long 出力順ID) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200024.getReportId(), 出力順ID);
        List<RString> 改頁項目List = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目List.add(item.get項目名());
                }
            }
        }
        return 改頁項目List;
    }
}
