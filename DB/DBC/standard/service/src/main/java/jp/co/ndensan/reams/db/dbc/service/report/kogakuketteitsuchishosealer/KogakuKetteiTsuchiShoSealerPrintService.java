/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kogakuketteitsuchishosealer;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KogakuKetteiTsuchiShoSealerProperty;
import jp.co.ndensan.reams.db.dbc.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KogakuKetteiTsuchiShoSealerReport;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer.KogakuKetteiTsuchiShoSealerSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）PrintServiceクラスです。
 *
 * @reamsid_L DBC-2000-060 lijian
 */
public class KogakuKetteiTsuchiShoSealerPrintService {

    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名2 = new RString("シーラタイプタイトル２");
    private static final RString 介護保険高額介護サービス費 = new RString("介護保険高額介護サービス費");

    /**
     * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）(単一帳票出力用)
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoSealer2Entity
     * @param 文書番号 RString
     * @param 通知書定型文list List<RString>
     * @param インフォlist List<RString>
     * @param 帳票分類ID ReportId
     * @param 認証者 Ninshosha
     * @param 発行日 RDate
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(KogakuKetteiTsuchiShoEntity 帳票情報,
            RString 文書番号,
            List<RString> 通知書定型文list,
            List<RString> インフォlist,
            ReportId 帳票分類ID, Ninshosha 認証者, RDate 発行日) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(帳票情報, 文書番号, 通知書定型文list, インフォlist, 帳票分類ID, 認証者, 発行日, reportManager);
            collection = reportManager.publish();
        }

        return collection;
    }

    /**
     * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）(複数帳票出力用)。
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoEntity
     * @param 文書番号 RString
     * @param 通知書定型文list List<RString>
     * @param インフォlist List<RString>
     * @param 帳票分類ID ReportId
     * @param 認証者 Ninshosha
     * @param 発行日 RDate
     * @param reportManager ReportManager
     */
    public void print(
            KogakuKetteiTsuchiShoEntity 帳票情報,
            RString 文書番号,
            List<RString> 通知書定型文list,
            List<RString> インフォlist,
            ReportId 帳票分類ID,
            Ninshosha 認証者,
            RDate 発行日,
            ReportManager reportManager) {

        RString title = RString.EMPTY;
        RString title1 = RString.EMPTY;
        RString title2 = RString.EMPTY;
        DbT7067ChohyoSeigyoHanyoDac dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        DbT7067ChohyoSeigyoHanyoEntity entity = dac.selectByKey(SubGyomuCode.DBC介護給付, 帳票分類ID, 管理年度, 項目名2);
        if (entity == null) {
            title = 介護保険高額介護サービス費;
        } else {
            title1 = 介護保険高額介護サービス費;
            title2 = entity.getKomokuValue();
        }
        List<RString> titleList = new ArrayList<>();
        titleList.add(title);
        titleList.add(title1);
        titleList.add(title2);

        KogakuKetteiTsuchiShoSealerProperty property = new KogakuKetteiTsuchiShoSealerProperty();
        try (ReportAssembler<KogakuKetteiTsuchiShoSealerSource> assembler = createAssembler(property, reportManager)) {
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

            RString 帳票イメージフォルダパス = assembler.getImageFolderPath();
            NinshoshaSource 認証者ソースデータ = NinshoshaSourceBuilderFactory.createInstance(認証者,
                    地方公共団体,
                    帳票イメージフォルダパス,
                    発行日).buildSource();
            ReportSourceWriter<KogakuKetteiTsuchiShoSealerSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            new KogakuKetteiTsuchiShoSealerReport(
                    帳票情報,
                    文書番号,
                    通知書定型文list,
                    インフォlist,
                    認証者ソースデータ,
                    titleList).writeBy(reportSourceWriter);
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
