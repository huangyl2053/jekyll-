/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReport;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReport;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReport;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;
import jp.co.ndensan.reams.db.dbe.service.report.ikenshokinyuyoshi.IkenshokinyuyoshiPrintService;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha._NinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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

/**
 * 主治医意見書作成依頼情報の帳票出力管理クラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIraiReportOutputService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public ShujiiIkenshoSakuseiIraiReportOutputService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 主治医意見書作成依頼情報を出力します。
     *
     * @param 主治医意見書作成依頼情報ItemList 主治医意見書作成依頼情報ItemList
     */
    public void print主治医意見書作成依頼情報(List<ShujiiIkenshoSakuseiIraishoItem> 主治医意見書作成依頼情報ItemList) {
        List<ShujiiIkenshoSakuseiIraishoReport> list = new ArrayList<>();
        list.add(ShujiiIkenshoSakuseiIraishoReport.createFrom(主治医意見書作成依頼情報ItemList));
        ShujiiIkenshoSakuseiIraishoProperty property = new ShujiiIkenshoSakuseiIraishoProperty();
        try (ReportAssembler<ShujiiIkenshoSakuseiIraishoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ShujiiIkenshoSakuseiIraishoReport report : list) {
                ReportSourceWriter<ShujiiIkenshoSakuseiIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 主治医意見書作成料請求書を出力します。
     *
     * @param 主治医意見書作成料請求書ItemList 主治医意見書作成料請求書ItemList
     */
    public void print主治医意見書作成料請求書(List<ShujiiIkenshoSakuseiRyoSeikyushoItem> 主治医意見書作成料請求書ItemList) {
        List<ShujiiIkenshoSakuseiRyoSeikyushoReport> list = new ArrayList<>();
        list.add(ShujiiIkenshoSakuseiRyoSeikyushoReport.createFrom(主治医意見書作成料請求書ItemList));
        ShujiiIkenshoSakuseiRyoSeikyushoProperty property = new ShujiiIkenshoSakuseiRyoSeikyushoProperty();
        try (ReportAssembler<ShujiiIkenshoSakuseiRyoSeikyushoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ShujiiIkenshoSakuseiRyoSeikyushoReport report : list) {
                ReportSourceWriter<ShujiiIkenshoSakuseiRyoSeikyushoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 介護保険診断命令書を出力します。
     *
     * @param 介護保険診断命令書ItemList 介護保険診断命令書ItemList
     */
    public void print介護保険診断命令書(List<KaigohokenShindanMeireishoHeaderItem> 介護保険診断命令書ItemList) {
        List<KaigohokenShindanMeireishoReport> list = new ArrayList<>();
        KaigohokenShindanMeireishoProperty property = new KaigohokenShindanMeireishoProperty();
        try (ReportAssembler<KaigohokenShindanMeireishoReportSource> assembler = createAssembler(property, reportManager)) {
            INinshoshaSourceBuilder ninshosha = new _NinshoshaSourceBuilderCreator().create(GyomuCode.DB介護保険, RString.EMPTY,
                    RDate.getNowDate(), assembler.getImageFolderPath());
            list.add(KaigohokenShindanMeireishoReport.createFrom(set介護保険診断命令書(介護保険診断命令書ItemList, ninshosha.buildSource())));
            for (KaigohokenShindanMeireishoReport report : list) {
                ReportSourceWriter<KaigohokenShindanMeireishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 介護保険指定医依頼兼主治医意見書提出意見書を出力します。
     *
     * @param 介護保険指定医依頼兼主治医意見書提出意見書ItemList 介護保険指定医依頼兼主治医意見書提出意見書ItemList
     */
    public void print介護保険指定医依頼兼主治医意見書提出意見書(List<ShujiiIkenshoTeishutsuIraishoItem> 介護保険指定医依頼兼主治医意見書提出意見書ItemList) {
        List<ShujiiIkenshoTeishutsuIraishoReport> list = new ArrayList<>();
        ShujiiIkenshoTeishutsuIraishoProperty property = new ShujiiIkenshoTeishutsuIraishoProperty();
        try (ReportAssembler<ShujiiIkenshoTeishutsuIraishoReportSource> assembler = createAssembler(property, reportManager)) {
            INinshoshaSourceBuilder ninshoshaSourceBuilder = new _NinshoshaSourceBuilderCreator().create(GyomuCode.DB介護保険, RString.EMPTY,
                    RDate.getNowDate(), assembler.getImageFolderPath());
            list.add(ShujiiIkenshoTeishutsuIraishoReport.createFrom(setNishosha(介護保険指定医依頼兼主治医意見書提出意見書ItemList,
                    ninshoshaSourceBuilder.buildSource())));
            for (ShujiiIkenshoTeishutsuIraishoReport report : list) {
                ReportSourceWriter<ShujiiIkenshoTeishutsuIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 主治医意見書作成依頼一覧表を出力します。
     *
     * @param 主治医意見書作成依頼一覧表ItemList 主治医意見書作成依頼一覧表ItemList
     */
    public void print主治医意見書作成依頼一覧表(List<IkenshoSakuseiIraiIchiranhyoItem> 主治医意見書作成依頼一覧表ItemList) {
        List<IkenshoSakuseiIraiIchiranhyoReport> list = new ArrayList<>();
        IkenshoSakuseiIraiIchiranhyoProperty property = new IkenshoSakuseiIraiIchiranhyoProperty();
        try (ReportAssembler<IkenshoSakuseiIraiIchiranhyoReportSource> assembler = createAssembler(property, reportManager)) {
            INinshoshaSourceBuilder ninshoshaSourceBuilder = new _NinshoshaSourceBuilderCreator().create(GyomuCode.DB介護保険, RString.EMPTY,
                    RDate.getNowDate(), assembler.getImageFolderPath());
            list.add(IkenshoSakuseiIraiIchiranhyoReport.createFrom(set主治医意見書作成依頼一覧表認定者(主治医意見書作成依頼一覧表ItemList, ninshoshaSourceBuilder.buildSource())));
            for (IkenshoSakuseiIraiIchiranhyoReport report : list) {
                ReportSourceWriter<IkenshoSakuseiIraiIchiranhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 主治医意見書記入用紙を出力します。
     *
     * @param 主治医意見書記入用紙List 主治医意見書記入用紙List
     */
    public void print主治医意見書記入用紙(List<IkenshokinyuyoshiBusiness> 主治医意見書記入用紙List) {
        new IkenshokinyuyoshiPrintService().print(主治医意見書記入用紙List);
    }

    /**
     * 主治医意見書記入用紙OCRを出力します。
     *
     * @param 主治医意見書記入用紙OCRList 主治医意見書記入用紙OCRList
     */
    public void print主治医意見書記入用紙OCR(List<IkenshokinyuyoshiBusiness> 主治医意見書記入用紙OCRList) {
        new IkenshokinyuyoshiPrintService().print(主治医意見書記入用紙OCRList);
    }

    private List<ShujiiIkenshoTeishutsuIraishoItem> setNishosha(List<ShujiiIkenshoTeishutsuIraishoItem> itemList, NinshoshaSource ninshosha) {
        List<ShujiiIkenshoTeishutsuIraishoItem> resultList = new ArrayList<>();
        for (ShujiiIkenshoTeishutsuIraishoItem item : itemList) {
            item.setHakkoYMD1(ninshosha.hakkoYMD);
            item.setDenshiKoin(ninshosha.denshiKoin);
            item.setNinshoshaYakushokuMei(ninshosha.ninshoshaYakushokuMei);
            item.setNinshoshaYakushokuMei1(ninshosha.ninshoshaYakushokuMei1);
            item.setNinshoshaYakushokuMei2(ninshosha.ninshoshaYakushokuMei2);
            item.setNinshoshaShimeiKakenai(ninshosha.ninshoshaShimeiKakenai);
            item.setNinshoshaShimeiKakeru(ninshosha.ninshoshaShimeiKakeru);
            item.setKoinMojiretsu(ninshosha.koinMojiretsu);
            item.setKoinShoryaku(ninshosha.koinShoryaku);
            resultList.add(item);
        }
        return resultList;
    }

    private List<IkenshoSakuseiIraiIchiranhyoItem> set主治医意見書作成依頼一覧表認定者(List<IkenshoSakuseiIraiIchiranhyoItem> itemList,
            NinshoshaSource ninshosha) {
        List<IkenshoSakuseiIraiIchiranhyoItem> resultList = new ArrayList<>();
        for (IkenshoSakuseiIraiIchiranhyoItem item : itemList) {
            item.setHakkoYMD(ninshosha.hakkoYMD);
            item.setDenshiKoin(ninshosha.denshiKoin);
            item.setNinshoshaYakushokuMei(ninshosha.ninshoshaYakushokuMei);
            item.setNinshoshaYakushokuMei1(ninshosha.ninshoshaYakushokuMei1);
            item.setNinshoshaYakushokuMei2(ninshosha.ninshoshaYakushokuMei2);
            item.setNinshoshaShimeiKakenai(ninshosha.ninshoshaShimeiKakenai);
            item.setNinshoshaShimeiKakeru(ninshosha.ninshoshaShimeiKakeru);
            item.setKoinMojiretsu(ninshosha.koinMojiretsu);
            item.setKoinShoryaku(ninshosha.koinShoryaku);
            resultList.add(item);
        }
        return resultList;
    }

    private List<KaigohokenShindanMeireishoHeaderItem> set介護保険診断命令書(List<KaigohokenShindanMeireishoHeaderItem> itemList,
            NinshoshaSource ninshosha) {
        List<KaigohokenShindanMeireishoHeaderItem> resultList = new ArrayList<>();
        for (KaigohokenShindanMeireishoHeaderItem item : itemList) {
            item.setShomeiHakkoYMD(ninshosha.hakkoYMD);
            item.setDenshiKoin(ninshosha.denshiKoin);
//            item.setNinshoshaYakushokuMei(ninshosha.ninshoshaYakushokuMei);
//            item.setNinshoshaYakushokuMei1(ninshosha.ninshoshaYakushokuMei1);
//            item.setNinshoshaYakushokuMei2(ninshosha.ninshoshaYakushokuMei2);
//            item.setNinshoshaShimeiKakenai(ninshosha.ninshoshaShimeiKakenai);
//            item.setNinshoshaShimeiKakeru(ninshosha.ninshoshaShimeiKakeru);
//            item.setKoinMojiretsu(ninshosha.koinMojiretsu);
            item.setKoinShoryaku(ninshosha.koinShoryaku);
            resultList.add(item);
        }
        return resultList;
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T>
            createAssembler(IReportProperty<T> property, ReportManager manager) {

        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaks : property.breakers()) {
            builder.addBreak(breaks);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
