/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kogakuketteitsuchishoshiharaiyoteibiyijiari;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
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
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書((支払予定日あり))のPrintServiceクラスです。
 *
 * @reamsid_L DBC-2000-040 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiPrintService {

    /**
     * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書((支払予定日あり))
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity
     * @param 連番 int
     * @param 発行日 RDate
     * @param 認証者 Ninshosha
     * @param 通知書定型文List List<RString>
     * @param 帳票制御共通情報 ChohyoSeigyoKyotsu
     * @param titleList List<RString>
     * @param 金融機関コード RString
     * @param compSofubutsuAtesakiソース SofubutsuAtesakiSource
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報,
            int 連番,
            RDate 発行日,
            Ninshosha 認証者,
            List<RString> 通知書定型文List,
            ChohyoSeigyoKyotsu 帳票制御共通情報,
            List<RString> titleList,
            RString 金融機関コード,
            SofubutsuAtesakiSource compSofubutsuAtesakiソース) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(帳票情報, 連番, 発行日, 認証者, 通知書定型文List, 帳票制御共通情報, titleList, reportManager, compSofubutsuAtesakiソース
            );
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書((支払予定日あり))
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity
     * @param 連番 int
     * @param 発行日 RDate
     * @param 認証者 Ninshosha
     * @param 通知書定型文List List<RString>
     * @param 帳票制御共通情報 ChohyoSeigyoKyotsu
     * @param titleList List<RString>
     * @param reportManage ReportManager
     * @param compSofubutsuAtesakiソース SofubutsuAtesakiSource
     */
    public void print(
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報,
            int 連番,
            RDate 発行日,
            Ninshosha 認証者,
            List<RString> 通知書定型文List,
            ChohyoSeigyoKyotsu 帳票制御共通情報,
            List<RString> titleList,
            ReportManager reportManage,
            SofubutsuAtesakiSource compSofubutsuAtesakiソース) {
        KogakuKetteiTsuchiShoShiharaiYoteiBiYijiProperty property = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiProperty();
        try (ReportAssembler<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> assembler = createAssembler(property, reportManage)) {
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            RString 帳票イメージフォルダパス = assembler.getImageFolderPath();
            NinshoshaSource 認証者ソースデータ = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    帳票イメージフォルダパス,
                    発行日).buildSource();
            ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> reportSourceWriter;
            reportSourceWriter = new ReportSourceWriter(assembler);
            new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiReport(
                    帳票情報,
                    連番,
                    titleList,
                    通知書定型文List,
                    認証者ソースデータ,
                    帳票制御共通情報,
                    compSofubutsuAtesakiソース).writeBy(reportSourceWriter);
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
