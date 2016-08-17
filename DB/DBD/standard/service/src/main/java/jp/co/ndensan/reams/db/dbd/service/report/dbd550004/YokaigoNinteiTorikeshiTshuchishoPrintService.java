/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd550004;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.report.dbd550004.YokaigoNinteiTorikeshiTshuchishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd550004.YokaigoNinteiTorikeshiTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550004.YokaigoNinteiTorikeshiTshuchishoSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.HojinDaihyoshaRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SetainushiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibun;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunFinder;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定取消通知書
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class YokaigoNinteiTorikeshiTshuchishoPrintService {

    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private static final int NO_5 = 5;
    private static final int NO_6 = 6;

    /**
     * 帳票を出力
     *
     * @param reportManager ReportManager
     * @param date RDate
     * @param bunshoNo RString
     * @param hihokenshaNo RString
     * @param hihokenshaName RString
     * @param riyu RString
     * @param teishutsuKigenYMD RString
     */
    public void print(ReportManager reportManager, RDate date, RString bunshoNo, RString hihokenshaNo, RString hihokenshaName, RString riyu,
            RString teishutsuKigenYMD) {
        YokaigoNinteiTorikeshiTshuchishoProperty property = new YokaigoNinteiTorikeshiTshuchishoProperty();
        try (ReportAssembler<YokaigoNinteiTorikeshiTshuchishoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<YokaigoNinteiTorikeshiTshuchishoSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = get認証者情報(date, reportSourceWriter);
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            IAtesaki 宛先情報 = get宛先情報();
            List<RString> 通知書定型文リスト = get通知文情報();
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(get帳票制御(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550004.getReportId()));
            YokaigoNinteiTorikeshiTshuchishoReport report = new YokaigoNinteiTorikeshiTshuchishoReport(宛先情報, association,
                    帳票制御共通, 通知書定型文リスト, ninshoshaSource, bunshoNo, hihokenshaNo, hihokenshaName, riyu, teishutsuKigenYMD);
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

    private IAtesaki get宛先情報() {
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        List<IAtesaki> 宛先s = ShikibetsuTaishoService.getAtesakiFinder().get宛先s(builder.build());
        return 宛先s.get(0);

    }

    private DbT7065ChohyoSeigyoKyotsuEntity get帳票制御(SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        DbT7065ChohyoSeigyoKyotsuDac dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        return dac.selectByKey(サブ業務コード, 帳票分類ID);
    }

    private NinshoshaSource get認証者情報(RDate date, ReportSourceWriter<YokaigoNinteiTorikeshiTshuchishoSource> writer) {
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550004.getReportId(),
                new FlexibleDate(date.toDateString()), writer);
        return ninshoshaSource;
    }

    private List<RString> get通知文情報() {
        TsuchishoTeikeibunFinder finder = new TsuchishoTeikeibunFinder();
        List<TsuchishoTeikeibun> tsuchishoTeikeibun = finder.get通知書定型文パターン(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550004.getReportId());
        TsuchishoTeikeibunManager mag = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo 帳票タイトルInfo = mag.get通知書定型文パターン(ReportIdDBD.DBD501002.getReportId(), SubGyomuCode.DBD介護受給);

        Map<Integer, RString> 通知文情報Map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550004.getReportId(), KamokuCode.EMPTY,
                tsuchishoTeikeibun.get(0).getパターン番号());
        List<RString> 通知文情報 = new ArrayList<>();
        RString 通知文1 = new RString(通知文情報Map.get(1).toString() + 通知文情報Map.get(2).toString());
        通知文情報.add(通知文1);
        for (int i = NO_3; i < NO_6; i++) {
            通知文情報.add(通知文情報Map.get(i));
        }
        Map<Integer, RString> フフォント大Map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550004.getReportId(), KamokuCode.EMPTY,
                tsuchishoTeikeibun.get(1).getパターン番号());
        通知文情報.add(フフォント大Map.get(NO_5));
        Map<Integer, RString> フォント混在Map1 = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550004.getReportId(), KamokuCode.EMPTY,
                tsuchishoTeikeibun.get(2).getパターン番号());
        通知文情報.add(フォント混在Map1.get(NO_5));
        通知文情報.add(フォント混在Map1.get(NO_6));
        Map<Integer, RString> フォント混在Map2 = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550004.getReportId(), KamokuCode.EMPTY,
                tsuchishoTeikeibun.get(NO_3).getパターン番号());
        通知文情報.add(フォント混在Map2.get(NO_5));
        通知文情報.add(フォント混在Map2.get(NO_6));
        return 通知文情報;
    }

}
