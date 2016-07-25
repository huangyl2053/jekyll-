/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karisanteiidokekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.KeisanjohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteiidokekkaichiran.KarisanteiIdoKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteiidokekkaichiran.KarisanteiIdoKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteiidokekkaichiran.KarisanteiIdoKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * 帳票設計_DBBRP36001_2_仮算定異動（一括）結果一覧表クラスです。
 *
 * @reamsid_L DBB-0850-030 zhaowei
 */
public class KarisanteiIdoKekkaIchiranPrintService {

    private static final ReportId ID = new ReportId("DBB200013_KarisanteiIdoKekkaIchiran");

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param 更正前後EntityList List<KeisanjohoAtenaKozaKouseizengoEntity>
     * @param 出力順ID RString
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @return SourceDataCollection
     */
    public SourceDataCollection print仮算定異動一括結果一覧表(List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            RString 出力順ID, YMDHMS 調定日時, FlexibleYear 賦課年度) {
        SourceDataCollection collection;
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        List<RString> 出力順項目リスト = new ArrayList<>();
        List<RString> 改頁項目リスト = new ArrayList<>();
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200013.getReportId(), Long.valueOf(出力順ID.toString()));
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                }
                出力順項目リスト.add(item.get項目名());
            }
        }

        List<RString> 住所編集リスト = new ArrayList<>();
        for (KeisanjohoAtenaKozaKouseizengoEntity entity : 更正前後EntityList) {
            if (entity.get計算後情報_宛名_口座_更正前Entity() != null && entity.get計算後情報_宛名_口座_更正前Entity().get宛名Entity() != null) {
                IKojin iKojin = ShikibetsuTaishoFactory.createKojin(entity.get計算後情報_宛名_口座_更正前Entity().get宛名Entity());
                ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, ID);
                EditedKojin 編集後個人 = new EditedKojin(iKojin, 帳票制御共通, null);
                住所編集リスト.add(編集後個人.get編集後住所());
            }
        }

        try (ReportManager reportManager = new ReportManager()) {
            print(更正前後EntityList, 調定日時, 賦課年度, association, 住所編集リスト, 出力順項目リスト, 改頁項目リスト, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBBRP36001_2_仮算定異動（一括）結果一覧表 printメソッド(複数帳票出力用)
     *
     * @param 更正前後EntityList KeisanjohoAtenaKozaKouseizengoEntityのList
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param association Association
     * @param 住所編集リスト List<RString>
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param reportManager ReportManager
     */
    public void print(List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            YMDHMS 調定日時, FlexibleYear 賦課年度, Association association, List<RString> 住所編集リスト,
            List<RString> 出力順項目リスト, List<RString> 改頁項目リスト, ReportManager reportManager) {
        KarisanteiIdoKekkaIchiranProperty property = new KarisanteiIdoKekkaIchiranProperty();
        try (ReportAssembler<KarisanteiIdoKekkaIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiIdoKekkaIchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
            new KarisanteiIdoKekkaIchiranReport(更正前後EntityList, 調定日時, 賦課年度, association,
                    住所編集リスト, 出力順項目リスト, 改頁項目リスト)
                    .writeBy(reportSourceWriter);
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
}
