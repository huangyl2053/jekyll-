/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.dbc100108;

import jp.co.ndensan.reams.db.dbc.business.core.servicenokanribangourendou.JigyouKetteiTutisyoResult;
import jp.co.ndensan.reams.db.dbc.business.report.dbc100108.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriProperty;
import jp.co.ndensan.reams.db.dbc.business.report.dbc100108.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou.JigyouKetteiTutisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100108.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 高額サービス等支給（不支給）決定通知書(支払予定日あり)帳票クラスです。
 *
 * @reamsid_L DBC-5160-040 donghj
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriPrintService {

    /**
     * 帳票を出力
     *
     * @param result JigyouKetteiTutisyoResult
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 発行日 FlexibleDate
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(JigyouKetteiTutisyoResult result,
            HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 発行日) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(reportManager, result.get決定通知書Entity(), 発行日);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票を出力
     *
     * @param reportManager ReportManager
     * @param 決定通知書Entity JigyouKetteiTutisyoEntity
     * @param 発行日 FlexibleDate
     */
    public void print(ReportManager reportManager, JigyouKetteiTutisyoEntity 決定通知書Entity, FlexibleDate 発行日) {
        KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriProperty property
                = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriProperty();
        try (ReportAssembler<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100108.getReportId());
            NinshoshaSource 認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100108.getReportId(), 発行日,
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriReport report
                    = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriReport(決定通知書Entity, 帳票制御共通, 認証者情報);
            report.writeBy(reportSourceWriter);
        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

}
