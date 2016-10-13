/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020;

import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhitsuchisho.KyufuhiTsuchishoBatchMybitisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho.KyufuhiTsuchishoSealerType;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.report.parts.toiawasesaki.IToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.report.parts.toiawasesaki.IToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護給付費福祉用具貸与品目一時TBLを作成します。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTsuchishoReportDBC100042Process extends BatchProcessBase<KyufuhiTuchiHakkoEntity> {

    private static final RString 介護給付費福祉用具貸与品目情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufuhitsuchisho.IKyufuhiTsuchishoMapper.getSeikatsuHogoJukyusha");
    private RString 被保険者番号;
    private RString サービス年月;
    private RString 文書番号;
    private RString 通知文;
    private int index;
    private int 分子;
    private static final int 数値_15 = 15;
    NinshoshaSource ninshoshaSource;
    SofubutsuAtesakiSource atesakiSource;
    IToiawasesakiSourceBuilder sourceBuilder;
    private KyufuhiTsuchishoProcessParameter processParameter;
    private AtesakiPSMSearchKeyBuilder 宛先builder;
    private static final ReportId REPORT_DBC100042 = ReportIdDBC.DBC100042.getReportId();
    @BatchWriter
    private BatchReportWriter<KyufuhiTsuchishoSealerReportSource> batchWrite;
    private ReportSourceWriter<KyufuhiTsuchishoSealerReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        被保険者番号 = RString.EMPTY;
        サービス年月 = RString.EMPTY;
        index = 0;
        分子 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBC100042.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
        ninshoshaSource = ReportUtil.get認証者情報(
                SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100042.getReportId(), new FlexibleDate(processParameter.get処理年月日()),
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100042.getReportId(),
                new FlexibleDate(processParameter.get処理年月日()));
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(new FlexibleDate(processParameter.get処理年月日()));
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(宛先builder.build());
        atesakiSource
                = new SofubutsuAtesakiSourceBuilder(new SofubutsuAtesakiEditorBuilder(宛先).build()).buildSource();
        IToiawasesakiSourceBuilderCreator aa = ReportSourceBuilders.toiawaseSourceBuilder();
        sourceBuilder = aa.create(GyomuCode.DB介護保険, ReportIdDBC.DBC100042.getReportId(), BushoCode.EMPTY,
                new RDate(processParameter.get処理年月日().toString()));
        通知文 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100042.getReportId(), KamokuCode.EMPTY, 1, 1, FlexibleDate.getNowDate());
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
        KyufuhiTsuchishoSealerType tsuchisho = new KyufuhiTsuchishoSealerType();
        KyufuhiTsuchishoSealerEntity coverEntity = tsuchisho.帳票データ作成(entity, processParameter, ninshoshaSource, atesakiSource, sourceBuilder);
        coverEntity.setBunshoNo(文書番号);
        coverEntity.setTsuchibun1(通知文);
        coverEntity.setPageBunshi(分子);
        coverEntity.setPageBunbo(entity.getCount());
        boolean isBreak = isBreak(entity);
        if (!isBreak || index % 数値_15 == 0) {
            coverEntity.setListServiceIchiran_1(entity.getサービス提供年月());
        } else if (!isBreak) {
            coverEntity.setListServiceIchiran_1(RString.EMPTY);
        }
        index++;
        被保険者番号 = entity.get被保険者番号();
        サービス年月 = entity.getサービス提供年月();
        KyufuhiTsuchishoSealerReport report = new KyufuhiTsuchishoSealerReport(coverEntity);
        report.writeBy(reportSourceWriter);
    }

    private boolean isBreak(KyufuhiTuchiHakkoEntity entity) {
        return 被保険者番号.equals(entity.get被保険者番号()) && サービス年月.equals(entity.getサービス提供年月());
    }
}
