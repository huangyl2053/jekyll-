/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kogakuketteitsuchishosealer2;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoSealer2Property;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoSealer2Report;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer21.KogakuKetteiTsuchiShoSealer2Source;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * 帳票設計_DBCMN43002_高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）PrintServiceクラスです。
 *
 * @reamsid_L DBC-2000-070 lijian
 */
public class KogakuKetteiTsuchiShoSealer2PrintService {

    /**
     * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）(単一帳票出力用)
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoSealer2Entity
     * @param 発行日 RDate
     * @param 文書番号 RString
     * @param 帳票ID RString
     * @param 認証者 Ninshosha
     * @param titleList List<RString>
     * @param 連番 int
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KogakuKetteiTsuchiShoEntity 帳票情報,
            RDate 発行日,
            RString 文書番号,
            RString 帳票ID,
            Ninshosha 認証者,
            List<RString> titleList,
            int 連番) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(帳票情報, 発行日, 文書番号, 帳票ID, 認証者, titleList, 連番, reportManager);
            collection = reportManager.publish();
        }

        return collection;
    }

    /**
     * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）(複数帳票出力用)。
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoSealer2Entity
     * @param 発行日 RDate
     * @param 文書番号 RString
     * @param 帳票ID RString
     * @param 認証者 Ninshosha
     * @param titleList List<RString>
     * @param 連番 int
     * @param reportManager ReportManager
     */
    public void print(
            KogakuKetteiTsuchiShoEntity 帳票情報,
            RDate 発行日,
            RString 文書番号,
            RString 帳票ID,
            Ninshosha 認証者,
            List<RString> titleList,
            int 連番,
            ReportManager reportManager) {

        KogakuKetteiTsuchiShoSealer2Property property = new KogakuKetteiTsuchiShoSealer2Property();

        try (ReportAssembler<KogakuKetteiTsuchiShoSealer2Source> assembler = createAssembler(property, reportManager)) {
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

            RString 帳票イメージフォルダパス = assembler.getImageFolderPath();
            NinshoshaSource 認証者ソースデータ = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    帳票イメージフォルダパス,
                    発行日).buildSource();

            ReportSourceWriter<KogakuKetteiTsuchiShoSealer2Source> reportSourceWriter;
            reportSourceWriter = new ReportSourceWriter(assembler);

            new KogakuKetteiTsuchiShoSealer2Report(
                    titleList,
                    帳票情報,
                    認証者ソースデータ,
                    文書番号,
                    連番).writeBy(reportSourceWriter);
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
