/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020;

import java.util.ArrayList;
import java.util.List;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
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
public class KyufuhiTsuchishoReportDBC100043Process extends BatchKeyBreakBase<KyufuhiTuchiHakkoEntity> {

    private static final RString 介護給付費福祉用具貸与品目情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufuhitsuchisho.IKyufuhiTsuchishoMapper.getSeikatsuHogoJukyusha");
    private RString 通知文1;
    private RString 通知文3;
    private int 分子;
    private static final int 数値_11 = 11;
    private static final int 数値_3 = 3;
    private KyufuhiTsuchishoProcessParameter processParameter;
    private AtesakiPSMSearchKeyBuilder 宛先builder;
    private static final ReportId REPORT_DBC100043 = ReportIdDBC.DBC100043.getReportId();
    private KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity 福祉用具貸与品目情報 = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity();
    @BatchWriter
    private BatchReportWriter<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource> batchWrite;
    private ReportSourceWriter<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        分子 = 1;
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
                toKyufuhiTsuchishoBatchMybitisParameter(new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString()),
                        get宛名PSM検索きー());
        return new BatchDbReader(介護給付費福祉用具貸与品目情報取得SQL, mybatisParam);
    }

    @Override
    protected void keyBreakProcess(KyufuhiTuchiHakkoEntity entity) {
        if (isBreak(entity)) {
            KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport report = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport(福祉用具貸与品目情報);
            report.writeBy(reportSourceWriter);
            福祉用具貸与品目情報.clear();
        }
    }

    @Override
    protected void usualProcess(KyufuhiTuchiHakkoEntity entity) {
        if (getBefore() != null && !getBefore().get被保険者番号().equals(entity.get被保険者番号())) {
            分子++;
        }
        entity.getRelateEntity();
        KyufuhiTsuchishoFukushiYoguTaiyoHinmoku tsuchisho = new KyufuhiTsuchishoFukushiYoguTaiyoHinmoku();
        福祉用具貸与品目情報 = tsuchisho.帳票データ作成(entity, processParameter, 福祉用具貸与品目情報);
        福祉用具貸与品目情報.set通知文1(通知文1);
        福祉用具貸与品目情報.set通知文3(通知文3);
        // TODO ページ分子とページ分母の実装を確認してください。
        福祉用具貸与品目情報.setページ分子(分子);
        福祉用具貸与品目情報.setページ分母(entity.getCount());
    }

    private boolean isBreak(KyufuhiTuchiHakkoEntity entity) {
        KyufuhiTuchiHakkoEntity beforeEntity = getBefore();
        if (entity.getRelateEntity() != null) {
            return !beforeEntity.get被保険者番号().equals(entity.get被保険者番号())
                    || (福祉用具貸与品目情報.size() >= 数値_3);
        } else {
            return false;
        }
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

    @Override
    protected void afterExecute() {
        if (福祉用具貸与品目情報.size() != 0) {
            KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport report = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport(福祉用具貸与品目情報);
            report.writeBy(reportSourceWriter);
        }
    }
}
