/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020;

import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhitsuchisho.KyufuhiTsuchishoBatchMybitisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho.KyufuhiTsuchishoFukushiYoguTaiyoHinmoku;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
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
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
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
public class KyufuhiTsuchishoReportDBC100043Process extends BatchProcessBase<KyufuhiTuchiHakkoEntity> {

    private static final RString 介護給付費福祉用具貸与品目情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufuhitsuchisho.IKyufuhiTsuchishoMapper.getSeikatsuHogoJukyusha");
    private RString 被保険者番号;
    private RString サービス年月;
    private RString 通知文1;
    private RString 通知文3;
    private int index;
    private int 分子;
    private static final int 数値_11 = 11;
    private static final int 数値_15 = 15;
    private KyufuhiTsuchishoProcessParameter processParameter;
    private AtesakiPSMSearchKeyBuilder 宛先builder;
    private static final ReportId REPORT_DBC100043 = ReportIdDBC.DBC100043.getReportId();
    @BatchWriter
    private BatchReportWriter<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource> batchWrite;
    private ReportSourceWriter<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        被保険者番号 = RString.EMPTY;
        サービス年月 = RString.EMPTY;
        index = 0;
        分子 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBC100043.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
        通知文1 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100043.getReportId(), KamokuCode.EMPTY, 数値_11, 1, FlexibleDate.getNowDate());
        通知文3 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100043.getReportId(), KamokuCode.EMPTY, 数値_11, 2, FlexibleDate.getNowDate());
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
            分子++;
        }
        KyufuhiTsuchishoFukushiYoguTaiyoHinmoku tsuchisho = new KyufuhiTsuchishoFukushiYoguTaiyoHinmoku();
        KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity coverEntity = tsuchisho.帳票データ作成(entity, processParameter);
        coverEntity.set通知文1(通知文1);
        coverEntity.set通知文3(通知文3);
        coverEntity.setページ分子(分子);
        coverEntity.setページ分母(entity.getCount());
        boolean isBreak = isBreak(entity);
        if (!isBreak || index % 数値_15 == 0) {
            coverEntity.setサービス年月(entity.getサービス提供年月());
        } else if (!isBreak) {
            coverEntity.setサービス年月(RString.EMPTY);
        }
        index++;
        被保険者番号 = entity.get被保険者番号();
        サービス年月 = entity.getサービス提供年月();
        KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport report = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport(coverEntity);
        report.writeBy(reportSourceWriter);
    }

    private boolean isBreak(KyufuhiTuchiHakkoEntity entity) {
        return 被保険者番号.equals(entity.get被保険者番号()) && サービス年月.equals(entity.getサービス提供年月());
    }
}
