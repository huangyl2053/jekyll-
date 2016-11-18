/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyokyotakuyobosogojigyo.KyufuKanrihyoKyotakuYoboSogoJigyoServiceReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyokyotakuyobosogojigyo.KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyufukanrihyoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyokyotakuyobosogojigyo.KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 給付管理票の帳票出力Processクラスです
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class KyufukanrihyoOutDoBillOutProcess extends BatchKeyBreakBase<KyufukanrihyoOutDoBillOutEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper."
                    + "get帳票出力対象データ");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource.ReportSourceFields.hokenshaNo.name()),
            new RString(KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource.ReportSourceFields.riyoYM.name()),
            new RString(KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource.ReportSourceFields.hihokenshaNo.name()),
            new RString(KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource.ReportSourceFields.kyotakuServiceKubun.name())
    ));
    private KyufukanrihyoOutProcessParameter parameter;
    private static final int 値6 = 6;
    @BatchWriter
    private BatchReportWriter<KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource> batchReportWriter;
    private ReportSourceWriter<KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toKyufukanrihyoOutMybatisParameter(RString.EMPTY, RString.EMPTY, RString.EMPTY));
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200009.getReportId().value())
                .addBreak(new BreakerCatalog<KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(KyufukanrihyoOutDoBillOutEntity t) {

    }

    @Override
    protected void usualProcess(KyufukanrihyoOutDoBillOutEntity currentEntity) {

        KyufuKanrihyoKyotakuYoboSogoJigyoServiceReport report
                = new KyufuKanrihyoKyotakuYoboSogoJigyoServiceReport(
                        editKyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity(currentEntity), parameter.get処理年月());
        report.writeBy(reportSourceWriter);
    }

    private KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity editKyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity(
            KyufukanrihyoOutDoBillOutEntity currentEntity) {
        KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity = currentEntity.get自己作成管理一時Entity();
        HihokenshaTempEntity 被保険者一時Entity = currentEntity.get被保険者一時Entity();
        KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity 給付管理票Entity = new KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity();
        給付管理票Entity.set更新区分(自己作成管理一時Entity.getKoshinKubun());
        if (自己作成管理一時Entity.getHokenshaNo().length() == 値6) {
            給付管理票Entity.set保険者番号(自己作成管理一時Entity.getHokenshaNo());
        } else if (値6 < 自己作成管理一時Entity.getHokenshaNo().length()) {
            給付管理票Entity.set保険者番号(自己作成管理一時Entity.getHokenshaNo()
                    .substring(自己作成管理一時Entity.getHokenshaNo().length() - 値6, 自己作成管理一時Entity.getHokenshaNo().length()));
        }
        給付管理票Entity.set保険者名(自己作成管理一時Entity.getHokenshaName());
        給付管理票Entity.set被保険者番号(自己作成管理一時Entity.getHihokenshaNo().getColumnValue());
        給付管理票Entity.set宛名カナ名称(被保険者一時Entity.getKanaMeisho());
        給付管理票Entity.set宛名名称(被保険者一時Entity.getMeisho());
        給付管理票Entity.set生年月日(被保険者一時Entity.getSeinenYmd());
        給付管理票Entity.set性別コード(被保険者一時Entity.getSeibetsuCode());
        給付管理票Entity.set表示用要介護状態区分コード(自己作成管理一時Entity.getYokaigoJotaiKubunCode());
        給付管理票Entity.set利用年月(自己作成管理一時Entity.getRiyoYM());
        給付管理票Entity.set表示用支給限度単位数(自己作成管理一時Entity.getHyojiShikyuGendoTanisu());
        給付管理票Entity.set限度額適用期間_開始年月(自己作成管理一時Entity.getShikyuGendoKaishiYM());
        給付管理票Entity.set支給限度有効終了年月(自己作成管理一時Entity.getShikyuGendoShuryoYM());
        給付管理票Entity.setサービス提供事業者名称(自己作成管理一時Entity.getServiceTeikyoJigyoshaName());
        給付管理票Entity.setサービス提供事業者番号(自己作成管理一時Entity.getServiceTeikyoJigyoshaNo());
        給付管理票Entity.setサービス種類コード(自己作成管理一時Entity.getServiceShuruiCode());
        給付管理票Entity.set給付計画単位数(自己作成管理一時Entity.getKyufuKeikakuTaniSu());
        return 給付管理票Entity;
    }

    @Override
    protected void afterExecute() {

    }
}
