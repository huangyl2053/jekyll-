/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jigyokogakuketteitsuchishoyoteibiyijinashi;

import jp.co.ndensan.reams.db.dbc.business.core.servicenokanribangourendou.JigyouKetteiTutisyoResult;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyoteibiyijinashi.JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyoteibiyijinashi.JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiReport;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyoteibiyijinashi.JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
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
 * 新総合事業・事業高額決定通知書（単）帳票クラスです。
 *
 * @reamsid_L DBC-4760-030 yebangqiang
 */
public class JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiPrintService {

    private static final ReportId 帳票分類ID = new ReportId("DBC100061_JigyoKogakuKetteiTsuchisho");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private final RString コード_ログコード = new RString("0003");

    /**
     * 新総合事業・事業高額決定通知書（単）帳票
     *
     * @param entity 決定通知書Entity
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 発行日 FlexibleDate
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(JigyouKetteiTutisyoResult entity,
            HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 発行日) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(reportManager, entity, 発行日);
            collection = reportManager.publish();
            AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号, 識別コード));
        }
        return collection;
    }

    private void print(ReportManager reportManager, JigyouKetteiTutisyoResult entity, FlexibleDate 発行日) {
        JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiProperty property = new JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiProperty();
        try (ReportAssembler<JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            NinshoshaSource 認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID, 発行日,
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            ChohyoSeigyoKyotsu kyotsu = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ID);
            JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiReport.createFrom(entity, kyotsu, 認証者情報).writeBy(reportSourceWriter);
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

    private PersonalData toPersonalData(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(コード_ログコード), 定数_被保険者番号,
                被保険者番号.getColumnValue());
        return PersonalData.of(識別コード, expandedInfo);
    }
}
