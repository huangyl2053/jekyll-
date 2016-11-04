/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jyuryoitakukeiyakukakuninshokeiyakujigyoshayo;

import jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakukeiyakukakuninshokeiyaku.JyuryoItakuKeiyakuKakuninShoKeiyakuProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakukeiyakukakuninshokeiyaku.JyuryoItakuKeiyakuKakuninShoKeiyakuReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jyuryoitakukeiyakukakuninshokeiyaku.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
 * 帳票設計_DBCMN31003_介護保険受領委任契約承認（不承認）確認書（事業者用）PrintServiceクラスです。
 *
 * @reamsid_L DBC-2130-060 liuxiaoyu
 */
public class JyuryoItakuKeiyakuKakuninShoKeiyakuPrintService {

    /**
     * 帳票設計_DBCMN31003_介護保険受領委任契約承認（不承認）確認書（事業者用）
     *
     * @param 事業者用Entity KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity 事業者用Entity
    ) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(事業者用Entity, reportManager, FlexibleDate.getNowDate());
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBCMN31003_介護保険受領委任契約承認（不承認）確認書（事業者用）
     *
     * @param 事業者用Entity KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity
     * @param reportManager ReportManager
     * @param 発行日 FlexibleDate
     */
    private void print(KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity 事業者用Entity, ReportManager reportManager, FlexibleDate 発行日) {
        JyuryoItakuKeiyakuKakuninShoKeiyakuProperty property = new JyuryoItakuKeiyakuKakuninShoKeiyakuProperty();
        try (ReportAssembler<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            NinshoshaSource 認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100030.getReportId(),
                    発行日, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            new JyuryoItakuKeiyakuKakuninShoKeiyakuReport(事業者用Entity, 認証者情報).writeBy(reportSourceWriter);
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
