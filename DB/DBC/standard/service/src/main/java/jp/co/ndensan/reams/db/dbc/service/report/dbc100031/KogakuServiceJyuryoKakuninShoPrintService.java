/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.dbc100031;

import jp.co.ndensan.reams.db.dbc.business.core.kogakuservicehijuryoininkeiyakukakuninsho.KogakuServiceHiJuryoininKeiyakuKakuninshoResult;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoSource;
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
 * 高額サービス費受領委任契約承認（不承認）確認書PrintServiceクラスです。
 *
 * @reamsid_L DBC-1980-040 qinzhen
 */
public class KogakuServiceJyuryoKakuninShoPrintService {

    private ReportSourceWriter<KogakuServiceJyuryoKakuninShoSource> reportSourceWriter;

    /**
     * print
     *
     * @param result KogakuServiceHiJuryoininKeiyakuKakuninshoResult
     * @return SourceDataCollection
     */
    public SourceDataCollection print(KogakuServiceHiJuryoininKeiyakuKakuninshoResult result) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printSingle(result, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    private void printSingle(KogakuServiceHiJuryoininKeiyakuKakuninshoResult result, ReportManager reportManager) {
        KogakuServiceJyuryoKakuninShoProperty property = new KogakuServiceJyuryoKakuninShoProperty();
        try (ReportAssembler<KogakuServiceJyuryoKakuninShoSource> assembler
                = createAssembler(property, reportManager)) {
            reportSourceWriter = new ReportSourceWriter(assembler);
            KogakuServiceJyuryoKakuninShoReport report = new KogakuServiceJyuryoKakuninShoReport(get帳票出力対象データ(result));
            report.writeBy(reportSourceWriter);
        }

    }

    private KogakuServiceJyuryoKakuninShoEntity get帳票出力対象データ(KogakuServiceHiJuryoininKeiyakuKakuninshoResult result) {
        KogakuServiceJyuryoKakuninShoEntity entity = new KogakuServiceJyuryoKakuninShoEntity();
        entity.set文書番号(result.get文書番号());

        entity.set電子公印(result.get電子公印());
        entity.set発行日(result.get発行日());
        entity.set認証者役職名(result.get認証者役職名());
        entity.set認証者役職名1(result.get認証者役職名1());
        entity.set認証者役職名2(result.get認証者役職名2());
        entity.set認証者氏名掛けない(result.get認証者氏名掛けない());
        entity.set認証者氏名掛ける(result.get認証者氏名掛ける());
        entity.set公印省略(result.get公印省略());
        entity.set公印文字列(result.get公印文字列());

        entity.set郵便番号(result.get郵便番号());
        entity.set行政区(result.get行政区名());
        entity.set住所Text(result.get住所());
        entity.set住所1(result.get住所5());
        entity.set住所2(result.get住所6());
        entity.set住所3(result.get住所4());
        entity.set方書Text(result.get方書());
        entity.set方書1(result.get方書4());
        entity.set方書2(result.get方書3());
        entity.set方書Small1(result.get方書小1());
        entity.set方書Small2(result.get方書小2());
        entity.set代納人区分(result.get代納人区分());
        entity.set氏名Text(result.get氏名());
        entity.set氏名1(result.get氏名6());
        entity.set氏名2(result.get氏名5());
        entity.set氏名Small1(result.get氏名小1());
        entity.set氏名Small2(result.get氏名小2());
        entity.set氏名samabunText(result.get様文氏名());
        entity.set氏名samabun1(result.get様文氏名1());
        entity.set氏名samabun2(result.get様文氏名2());
        entity.set氏名samabunSmall1(result.get様文氏名小1());
        entity.set氏名samabunSmall2(result.get様文氏名小2());
        entity.set名称付与1(result.get名称付与1());
        entity.set名称付与2(result.get名称付与2());
        entity.set様文1(result.get様文1());
        entity.set様文2(result.get様文2());
        entity.set括弧Left1(result.get左括弧1());
        entity.set括弧Left2(result.get左括弧2());
        entity.set括弧Right1(result.get右括弧1());
        entity.set括弧Right2(result.get右括弧2());
        entity.setカスタマバーコード(result.getカスタマーバーコード());

        entity.set通知文1(result.get通知文1());
        entity.set通知文2(result.get通知文2());
        entity.set被保険者氏名(result.get被保険者氏名());
        entity.set被保険者番号(result.get被保険者番号());
        entity.set被保険者氏名フリガナ(result.get被保険者氏名フリガナ());
        entity.set受付年月日(result.get受付年月日());
        entity.set承認不承認(result.get承認不承認());
        entity.set承認年月日(result.get承認年月日());
        entity.set不承認理由(result.get不承認の理由());
        entity.set事業所名(result.get事業所名());
        entity.set代表者名(result.get代表者氏名());
        entity.set事業所郵便番号(result.get事業所郵便番号());
        entity.set事業所電話番号(result.get事業所電話番号());
        entity.set事業所所在地(result.get事業所所在地());

        return entity;
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
