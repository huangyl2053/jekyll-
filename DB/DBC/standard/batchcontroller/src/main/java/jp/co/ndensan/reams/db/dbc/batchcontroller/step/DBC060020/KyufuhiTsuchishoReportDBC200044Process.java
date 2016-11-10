/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufuhitsuchisho.KyufuhiTsuchishoShutsuryokujun;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhitsuchisho.KyufuhiTsuchishoBatchMybitisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakoichiran.KyufuhiTuchiHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho.KyufuhiTuchiHakkoIchiran;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
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
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
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
    private ShutsuryokujunRelateEntity 出力順Entity;
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("NP_UNWRITTEN_FIELD")
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
        出力順Entity = get出力順項目();
    }

    @Override
    protected IBatchReader createReader() {
        List<RString> pageBreakKeys = Collections.unmodifiableList(出力順Entity.getPageBreakKeys());
        if (pageBreakKeys != null && !pageBreakKeys.isEmpty()) {
            batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBC200044.value()).
                    addBreak(new BreakerCatalog<KyufuhiTuchiHakkoIchiranReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBC200044.value()).create();
        }
        reportSourceWriter = new ReportSourceWriter(batchWrite);
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(new FlexibleDate(processParameter.get処理年月日()));
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(宛先builder.build());
        processParameter.setOrderBy(出力順Entity.get出力順OrderBy());
        KyufuhiTsuchishoBatchMybitisParameter mybatisParam = processParameter.
                toKyufuhiTsuchishoBatchMybitisParameter(new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString()),
                        get宛名PSM検索きー());
        return new BatchDbReader(介護給付費福祉用具貸与品目情報取得SQL, mybatisParam);
    }

    @Override
    protected void process(KyufuhiTuchiHakkoEntity entity) {
        if (!被保険者番号.equals(entity.get被保険者番号())) {
            連番++;
        }
        tempFlag = false;
        KyufuhiTuchiHakkoIchiran hakkoIchiran = new KyufuhiTuchiHakkoIchiran();
        KyufuhiTuchiHakkoIchiranEntity coverEntity = hakkoIchiran.帳票データ作成2(entity, processParameter, 出力順Entity);
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
            KyufuhiTuchiHakkoIchiranEntity coverEntity = hakkoIchiran.帳票データ作成1(processParameter, 出力順Entity);
            KyufuhiTuchiHakkoIchiranReport report = new KyufuhiTuchiHakkoIchiranReport(coverEntity);
            report.writeBy(reportSourceWriter);
        }
    }

    private ShutsuryokujunRelateEntity get出力順項目() {
        return ReportUtil.get出力順情報(KyufuhiTsuchishoShutsuryokujun.ShutsuryokujunEnum.class,
                SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100041.getReportId(),
                processParameter.getShutsuryokujunId());
    }

    private IShikibetsuTaishoPSMSearchKey get宛名PSM検索きー() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        住民種別.add(JuminShubetsu.住登外個人_外国人);
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民状態.add(JuminJotai.住民);
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        住民状態.add(JuminJotai.死亡者);
        builder.set住民種別(住民種別);
        builder.set住民状態(住民状態);
        builder.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        return builder.build();
    }
}
