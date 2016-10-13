/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020;

import jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhitsuchisho.KyufuhiTsuchishoBatchMybitisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakoichiran.KyufuhiTuchiHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho.KyufuhiTuchiHakkoIchiran;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護給付費福祉用具貸与品目一時TBLを作成します。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTsuchishoReportDBC200044Process extends BatchProcessBase<KyufuhiTuchiHakkoEntity> {

    private AtesakiPSMSearchKeyBuilder 宛先builder;
    private static final RString 介護給付費福祉用具貸与品目情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufuhitsuchisho.IKyufuhiTsuchishoMapper.getSeikatsuHogoJukyusha");
    private KyufuhiTsuchishoProcessParameter processParameter;
    private boolean tempFlag = true;
    private RString 被保険者番号;
    private int index;
    private int 連番;
    private static final int 数値_25 = 25;
    private static final ReportId REPORT_DBC200044 = ReportIdDBC.DBC200044.getReportId();
    @BatchWriter
    private BatchReportWriter<KyufuhiTuchiHakkoIchiranReportSource> batchWrite;
    private ReportSourceWriter<KyufuhiTuchiHakkoIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        被保険者番号 = RString.EMPTY;
        index = 0;
        連番 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBC200044.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(new FlexibleDate(processParameter.get処理年月日()));
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(宛先builder.build());
        KyufuhiTsuchishoBatchMybitisParameter mybatisParam = processParameter.
                toKyufuhiTsuchishoBatchMybitisParameter(new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString()));
        return new BatchDbReader(介護給付費福祉用具貸与品目情報取得SQL, mybatisParam);
    }

    @Override
    protected void process(KyufuhiTuchiHakkoEntity entity) {
        if (!被保険者番号.equals(entity.get被保険者番号())) {
            連番++;
        }
        tempFlag = false;
        KyufuhiTuchiHakkoIchiran hakkoIchiran = new KyufuhiTuchiHakkoIchiran();
        KyufuhiTuchiHakkoIchiranEntity coverEntity = hakkoIchiran.帳票データ作成2(entity, processParameter);
        coverEntity.set帳票連番(new RString(連番));
        boolean isBreak = isBreak(entity);
        if (!isBreak || index % 数値_25 == 0) {
            coverEntity.set被保険者番号(entity.get被保険者番号());
        } else if (!isBreak) {
            coverEntity.set被保険者番号(RString.EMPTY);
        }
        index++;
        被保険者番号 = entity.get被保険者番号();
        KyufuhiTuchiHakkoIchiranReport report = new KyufuhiTuchiHakkoIchiranReport(coverEntity);
        report.writeBy(reportSourceWriter);
    }

    private boolean isBreak(KyufuhiTuchiHakkoEntity entity) {
        return 被保険者番号.equals(entity.get被保険者番号());
    }

    @Override
    protected void afterExecute() {
        if (tempFlag) {
            KyufuhiTuchiHakkoIchiran hakkoIchiran = new KyufuhiTuchiHakkoIchiran();
            KyufuhiTuchiHakkoIchiranEntity coverEntity = hakkoIchiran.帳票データ作成1(processParameter);
            KyufuhiTuchiHakkoIchiranReport report = new KyufuhiTuchiHakkoIchiranReport(coverEntity);
            report.writeBy(reportSourceWriter);
        }
    }

}
