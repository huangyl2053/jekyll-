/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kogakuketteitsuchishoshiharaiyoteibiyijinashi;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
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
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書のPrintServiceクラスです。
 *
 * @reamsid_L DBC-2000-050 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiPrintService {

    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final ReportId 帳票分類ID = new ReportId("DBC100007_KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashi");
    private static final RString 項目名 = new RString("取り消し線");

    /**
     * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEntity
     * @param 連番 int
     * @param 発行日 RDate
     * @param 認証者 Ninshosha
     * @param 通知書定型文List List<RString>
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報,
            int 連番,
            RDate 発行日,
            Ninshosha 認証者,
            List<RString> 通知書定型文List) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(帳票情報, 連番, 発行日, 認証者, 通知書定型文List, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書((支払予定日あり))
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEntity
     * @param 連番 int
     * @param 発行日 RDate
     * @param 認証者 Ninshosha
     * @param 通知書定型文List List<RString>
     * @param reportManage ReportManager
     */
    public void print(
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報,
            int 連番,
            RDate 発行日,
            Ninshosha 認証者,
            List<RString> 通知書定型文List,
            ReportManager reportManage) {
        KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty property = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty();
        try (ReportAssembler<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> assembler = createAssembler(property, reportManage)) {
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            RString 帳票イメージフォルダパス = assembler.getImageFolderPath();
            NinshoshaSource 認証者ソースデータ = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    帳票イメージフォルダパス,
                    発行日).buildSource();
            ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> reportSourceWriter;
            reportSourceWriter = new ReportSourceWriter(assembler);
            RString 設定値 = fetch設定値();
            new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport(帳票情報,
                    連番,
                    設定値,
                    通知書定型文List,
                    認証者ソースデータ).writeBy(reportSourceWriter);
        }
    }

    private RString fetch設定値() {
        DbT7067ChohyoSeigyoHanyoDac dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        DbT7067ChohyoSeigyoHanyoEntity entity = dac.selectByKey(SubGyomuCode.DBC介護給付, 帳票分類ID, 管理年度, 項目名);
        RString 設定値 = entity.getKomokuValue();
        return 設定値;
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
