/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairaishudou;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran.ChosairairirekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran.ChosairairirekiIchiranProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran.ChosairairirekiIchiranReport;
import jp.co.ndensan.reams.db.dbe.entity.report.chosairairirekiichiran.ChosairairirekiIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyogaikyotokki.GaikyotokkiA4Business;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoReport;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa.ChosahyoDesignKatamenProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaItem;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReport;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa.ChosahyoOcrKatamenProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa.ChosahyoOcrRyomenProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyotokki.GaikyotokkiA4Property;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyotokki.GaikyotokkiA4Report;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoOcrKatamenProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoOcrRyomenProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReport;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijikofree.ChosahyoTokkijikoFreeProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijikofree.ChosahyoTokkijikoFreeReport;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijikofree.ChosahyoTokkijikoKomokuAriProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijikofree.ChosahyoTokkijikoKomokuNashiProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijikofree.TokkijikoFreeTenyuryokuProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijikofree.TokkijikoKomokuAriTenyuryokuProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijikofree.TokkijikoKomokuNashiTenyuryokuProperty;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoItem;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoReport;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoRyoumenProperty;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoRyoumenReport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyotokki.GaikyotokkiA4ReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.SaiChekkuhyoReportSource;
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
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 *
 * 認定調査依頼(手動)のサービスクラスです。
 *
 * @reamsid_L DBE-1590-010 sunhaidi
 */
public class NinnteiChousairaiShudouPrintService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public NinnteiChousairaiShudouPrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 要介護認定調査依頼書を出力します。
     *
     * @param 要介護認定調査依頼書List 要介護認定調査依頼書List
     */
    public void print要介護認定調査依頼書(List<ChosaIraishoHeadItem> 要介護認定調査依頼書List) {
        ChosaIraishoProperty property = new ChosaIraishoProperty();
        try (ReportAssembler<ChosaIraishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<ChosaIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE220001.getReportId(),
                    FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            List<ChosaIraishoHeadItem> 要介護認定調査依頼書 = new ArrayList<>();
            for (ChosaIraishoHeadItem item : 要介護認定調査依頼書List) {
                item = new ChosaIraishoHeadItem(
                        item.getHakkoYMD1(),
                        ninshoshaSource.denshiKoin,
                        ninshoshaSource.ninshoshaYakushokuMei,
                        ninshoshaSource.ninshoshaYakushokuMei2,
                        ninshoshaSource.ninshoshaYakushokuMei1,
                        ninshoshaSource.koinMojiretsu,
                        ninshoshaSource.ninshoshaShimeiKakeru,
                        ninshoshaSource.ninshoshaShimeiKakenai,
                        ninshoshaSource.koinShoryaku,
                        item.getBunshoNo(),
                        item.getYubinNo1(),
                        item.getJushoText(),
                        item.getKikanNameText(),
                        item.getShimeiText(),
                        item.getMeishoFuyo(),
                        item.getCustomerBarCode(),
                        item.getSonota(),
                        item.getTitle(),
                        item.getTsuchibun1(),
                        item.getHihokenshaNo1(),
                        item.getHihokenshaNo2(),
                        item.getHihokenshaNo3(),
                        item.getHihokenshaNo4(),
                        item.getHihokenshaNo5(),
                        item.getHihokenshaNo6(),
                        item.getHihokenshaNo7(),
                        item.getHihokenshaNo8(),
                        item.getHihokenshaNo9(),
                        item.getHihokenshaNo10(),
                        item.getHihokenshaNameKana(),
                        item.getBirthGengoMeiji(),
                        item.getBirthGengoTaisho(),
                        item.getBirthGengoShowa(),
                        item.getBirthYMD(),
                        item.getHihokenshaName(),
                        item.getSeibetsuMan(),
                        item.getSeibetsuWoman(),
                        item.getYubinNo(),
                        item.getJusho(),
                        item.getTelNo(),
                        item.getHomonChosasakiYubinNo(),
                        item.getHomonChosasakiJusho(),
                        item.getHomonChosasakiJushoName(),
                        item.getHomonChosasakiTelNo(),
                        item.getShinseiYMD(),
                        item.getTeishutsuKigen(),
                        item.getTsuchibun2());
                要介護認定調査依頼書.add(item);
            }
            ChosaIraishoReport report = ChosaIraishoReport.createFrom(要介護認定調査依頼書);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * 認定調査票(デザイン用紙片面)を出力します。
     *
     * @param 認定調査票_概況調査List 認定調査票_概況調査List
     */
    public void print認定調査票_デザイン用紙片面(List<ChosahyoGaikyochosaItem> 認定調査票_概況調査List) {
        List<ChosahyoGaikyochosaReport> list = new ArrayList<>();
        if (!認定調査票_概況調査List.isEmpty()) {
            list.add(ChosahyoGaikyochosaReport.createFrom(認定調査票_概況調査List));
        }
        ChosahyoDesignKatamenProperty property = new ChosahyoDesignKatamenProperty();
        try (ReportAssembler<ChosahyoGaikyochosaReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoGaikyochosaReport report : list) {
                ReportSourceWriter<ChosahyoGaikyochosaReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 認定調査票(デザイン)両面を出力します。
     *
     * @param 認定調査票_概況調査List 認定調査票_概況調査List
     */
    public void print認定調査票_デザイン用紙両面(List<ChosahyoGaikyochosaItem> 認定調査票_概況調査List) {
        List<ChosahyoGaikyochosaReport> list = new ArrayList<>();
        if (!認定調査票_概況調査List.isEmpty()) {
            list.add(ChosahyoGaikyochosaReport.createFrom(認定調査票_概況調査List));
        }
        ChosahyoGaikyochosaProperty property = new ChosahyoGaikyochosaProperty();
        try (ReportAssembler<ChosahyoGaikyochosaReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoGaikyochosaReport report : list) {
                ReportSourceWriter<ChosahyoGaikyochosaReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 認定調査票(OCR両面)を出力します。
     *
     * @param 認定調査票_概況調査List 認定調査票_概況調査List
     */
    public void print認定調査票OCR両面(List<ChosahyoGaikyochosaItem> 認定調査票_概況調査List) {
        List<ChosahyoGaikyochosaReport> list = new ArrayList<>();
        if (!認定調査票_概況調査List.isEmpty()) {
            list.add(ChosahyoGaikyochosaReport.createFrom(認定調査票_概況調査List));
        }
        ChosahyoOcrRyomenProperty property = new ChosahyoOcrRyomenProperty();
        try (ReportAssembler<ChosahyoGaikyochosaReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoGaikyochosaReport report : list) {
                ReportSourceWriter<ChosahyoGaikyochosaReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 認定調査票(OCR片面)を出力します。
     *
     * @param 認定調査票_概況調査List 認定調査票_概況調査List
     */
    public void print認定調査票OCR片面(List<ChosahyoGaikyochosaItem> 認定調査票_概況調査List) {
        List<ChosahyoGaikyochosaReport> list = new ArrayList<>();
        if (!認定調査票_概況調査List.isEmpty()) {
            list.add(ChosahyoGaikyochosaReport.createFrom(認定調査票_概況調査List));
        }
        ChosahyoOcrKatamenProperty property = new ChosahyoOcrKatamenProperty();
        try (ReportAssembler<ChosahyoGaikyochosaReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoGaikyochosaReport report : list) {
                ReportSourceWriter<ChosahyoGaikyochosaReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票（特記事項）デザイン用紙を出力します。
     *
     * @param 認定調査票_特記事項List 認定調査票_概況調査List
     */
    public void print認定調査票_特記事項_デザイン用紙(List<ChosahyoTokkijikoBusiness> 認定調査票_特記事項List) {
        List<ChosahyoTokkijikoReport> list = new ArrayList<>();
        if (!認定調査票_特記事項List.isEmpty()) {
            list.add(new ChosahyoTokkijikoReport(認定調査票_特記事項List, ReportIdDBZ.DBE221003.getReportId()));
        }
        ChosahyoTokkijikoProperty property = new ChosahyoTokkijikoProperty();
        try (ReportAssembler<ChosahyoTokkijikoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoTokkijikoReport report : list) {
                ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 認定調査依頼一覧表を印刷します。
     *
     * @param bodyItems 認定調査依頼一覧表ボディのITEM
     */
    public void print認定調査依頼一覧表(List<ChosaIraiIchiranhyoBodyItem> bodyItems) {
        ChosaIraiIchiranhyoProperty property = new ChosaIraiIchiranhyoProperty();
        try (ReportAssembler<ChosaIraiIchiranhyoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<ChosaIraiIchiranhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE220002.getReportId(),
                    FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            List<ChosaIraiIchiranhyoBodyItem> itemList = new ArrayList<>();
            for (ChosaIraiIchiranhyoBodyItem item : bodyItems) {
                itemList.add(new ChosaIraiIchiranhyoBodyItem(
                        ninshoshaSource.hakkoYMD,
                        ninshoshaSource.denshiKoin,
                        ninshoshaSource.ninshoshaYakushokuMei,
                        ninshoshaSource.ninshoshaYakushokuMei2,
                        ninshoshaSource.ninshoshaYakushokuMei1,
                        ninshoshaSource.ninshoshaShimeiKakenai,
                        ninshoshaSource.ninshoshaShimeiKakeru,
                        ninshoshaSource.koinMojiretsu,
                        ninshoshaSource.koinShoryaku,
                        item.getYubinNo1(),
                        item.getJushoText(),
                        item.getKikanNameText(),
                        item.getShimeiText(),
                        item.getMeishoFuyo(),
                        item.getJigyoshaNo(),
                        item.getTsuchibun1(),
                        item.getTsuchibun2(),
                        item.getListIchiranhyo_1(),
                        item.getListIchiranhyo_2(),
                        item.getListIchiranhyo_3(),
                        item.getListIchiranhyo_4(),
                        item.getListIchiranhyo_5(),
                        item.getListIchiranhyo_6(),
                        item.getListIchiranhyo_7(),
                        item.getListIchiranhyo_8(),
                        item.getListIchiranhyo_9(),
                        item.getListIchiranhyo_10(),
                        item.getListIchiranhyo_11(),
                        item.getListIchiranhyo_12()));
            }
            ChosaIraiIchiranhyoReport report = ChosaIraiIchiranhyoReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * 認定調査依頼該当者履歴一覧を出力します。
     *
     * @param 認定調査依頼該当者履歴一覧 認定調査依頼該当者履歴一覧
     */
    public void print認定調査依頼該当者履歴一覧(List<ChosairairirekiIchiranBusiness> 認定調査依頼該当者履歴一覧) {
        List<ChosairairirekiIchiranReport> list = new ArrayList<>();
        if (!認定調査依頼該当者履歴一覧.isEmpty()) {
            list.add(new ChosairairirekiIchiranReport(認定調査依頼該当者履歴一覧));
        }
        ChosairairirekiIchiranProperty property = new ChosairairirekiIchiranProperty();
        try (ReportAssembler<ChosairairirekiIchiranReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosairairirekiIchiranReport report : list) {
                ReportSourceWriter<ChosairairirekiIchiranReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票（特記事項）のOCR両面を出力します。
     *
     * @param 認定調査票_特記事項List 認定調査票_概況調査List
     */
    public void print認定調査票_特記事項_OCR両面(List<ChosahyoTokkijikoBusiness> 認定調査票_特記事項List) {
        List<ChosahyoTokkijikoReport> list = new ArrayList<>();
        if (!認定調査票_特記事項List.isEmpty()) {
            list.add(new ChosahyoTokkijikoReport(認定調査票_特記事項List, ReportIdDBZ.DBE221031.getReportId()));
        }
        ChosahyoTokkijikoOcrRyomenProperty property = new ChosahyoTokkijikoOcrRyomenProperty();
        try (ReportAssembler<ChosahyoTokkijikoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoTokkijikoReport report : list) {
                ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票（特記事項）のOCR片面を出力します。
     *
     * @param 認定調査票_特記事項List 認定調査票_概況調査List
     */
    public void print認定調査票_特記事項_OCR片面(List<ChosahyoTokkijikoBusiness> 認定調査票_特記事項List) {
        List<ChosahyoTokkijikoReport> list = new ArrayList<>();
        if (!認定調査票_特記事項List.isEmpty()) {
            list.add(new ChosahyoTokkijikoReport(認定調査票_特記事項List, ReportIdDBZ.DBE221032.getReportId()));
        }
        ChosahyoTokkijikoOcrKatamenProperty property = new ChosahyoTokkijikoOcrKatamenProperty();
        try (ReportAssembler<ChosahyoTokkijikoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoTokkijikoReport report : list) {
                ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票（特記事項）項目有りを出力します。
     *
     * @param 認定調査票_特記事項List 認定調査票_概況調査List
     */
    public void print認定調査票_特記事項_項目有り(List<ChosahyoTokkijikoBusiness> 認定調査票_特記事項List) {
        List<ChosahyoTokkijikoFreeReport> list = new ArrayList<>();
        if (!認定調査票_特記事項List.isEmpty()) {
            list.add(ChosahyoTokkijikoFreeReport.createFrom(認定調査票_特記事項List));
        }
        ChosahyoTokkijikoKomokuAriProperty property = new ChosahyoTokkijikoKomokuAriProperty();
        try (ReportAssembler<ChosahyoTokkijikoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoTokkijikoFreeReport report : list) {
                ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票（特記事項）項目有り（手入力）を出力します。
     *
     * @param 認定調査票_特記事項List 認定調査票_特記事項List
     */
    public void print認定調査票_特記事項_項目有り_手入力(List<ChosahyoTokkijikoBusiness> 認定調査票_特記事項List) {
        List<ChosahyoTokkijikoFreeReport> list = new ArrayList<>();
        if (!認定調査票_特記事項List.isEmpty()) {
            list.add(ChosahyoTokkijikoFreeReport.createFrom(認定調査票_特記事項List));
        }
        TokkijikoKomokuAriTenyuryokuProperty property = new TokkijikoKomokuAriTenyuryokuProperty();
        try (ReportAssembler<ChosahyoTokkijikoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoTokkijikoFreeReport report : list) {
                ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票（特記事項）項目無し（手入力）を出力します。
     *
     * @param 認定調査票_特記事項List 認定調査票_特記事項List
     */
    public void print認定調査票_特記事項_項目無し_手入力(List<ChosahyoTokkijikoBusiness> 認定調査票_特記事項List) {
        List<ChosahyoTokkijikoFreeReport> list = new ArrayList<>();
        if (!認定調査票_特記事項List.isEmpty()) {
            list.add(ChosahyoTokkijikoFreeReport.createFrom(認定調査票_特記事項List));
        }
        TokkijikoKomokuNashiTenyuryokuProperty property = new TokkijikoKomokuNashiTenyuryokuProperty();
        try (ReportAssembler<ChosahyoTokkijikoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoTokkijikoFreeReport report : list) {
                ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票（特記事項）フリータイプ（手入力）を出力します。
     *
     * @param 認定調査票_特記事項List 認定調査票_特記事項List
     */
    public void print認定調査票_特記事項_フリータイプ_手入力(List<ChosahyoTokkijikoBusiness> 認定調査票_特記事項List) {
        List<ChosahyoTokkijikoFreeReport> list = new ArrayList<>();
        if (!認定調査票_特記事項List.isEmpty()) {
            list.add(ChosahyoTokkijikoFreeReport.createFrom(認定調査票_特記事項List));
        }
        TokkijikoFreeTenyuryokuProperty property = new TokkijikoFreeTenyuryokuProperty();
        try (ReportAssembler<ChosahyoTokkijikoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoTokkijikoFreeReport report : list) {
                ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票（特記事項）項目無しを出力します。
     *
     * @param 認定調査票_特記事項List 認定調査票_概況調査List
     */
    public void print認定調査票_特記事項_項目無し(List<ChosahyoTokkijikoBusiness> 認定調査票_特記事項List) {
        List<ChosahyoTokkijikoFreeReport> list = new ArrayList<>();
        if (!認定調査票_特記事項List.isEmpty()) {
            list.add(ChosahyoTokkijikoFreeReport.createFrom(認定調査票_特記事項List));
        }
        ChosahyoTokkijikoKomokuNashiProperty property = new ChosahyoTokkijikoKomokuNashiProperty();
        try (ReportAssembler<ChosahyoTokkijikoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoTokkijikoFreeReport report : list) {
                ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票（特記事項）フリー様式を出力します。
     *
     * @param 認定調査票_特記事項List 認定調査票_概況調査List
     */
    public void print認定調査票_特記事項_フリータイプ(List<ChosahyoTokkijikoBusiness> 認定調査票_特記事項List) {
        List<ChosahyoTokkijikoFreeReport> list = new ArrayList<>();
        if (!認定調査票_特記事項List.isEmpty()) {
            list.add(ChosahyoTokkijikoFreeReport.createFrom(認定調査票_特記事項List));
        }
        ChosahyoTokkijikoFreeProperty property = new ChosahyoTokkijikoFreeProperty();
        try (ReportAssembler<ChosahyoTokkijikoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ChosahyoTokkijikoFreeReport report : list) {
                ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 概況特記を出力します。
     *
     * @param 概況特記List 概況特記List
     */
    public void print概況特記(List<GaikyotokkiA4Business> 概況特記List) {
        List<GaikyotokkiA4Report> list = new ArrayList<>();
        if (!概況特記List.isEmpty()) {
            for (GaikyotokkiA4Business 概況特記 : 概況特記List) {
                list.add(new GaikyotokkiA4Report(概況特記));
            }
        }
        GaikyotokkiA4Property property = new GaikyotokkiA4Property();
        try (ReportAssembler<GaikyotokkiA4ReportSource> assembler = createAssembler(property, reportManager)) {
            for (GaikyotokkiA4Report report : list) {
                ReportSourceWriter<GaikyotokkiA4ReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票差異チェック票_片面を出力します。
     *
     * @param チェック票List 要介護認定調査票差異チェック票List
     */
    public void print要介護認定調査票差異チェック票_片面(List<SaiChekkuhyoItem> チェック票List) {
        List<SaiChekkuhyoReport> saiChekkuhyoReportList = new ArrayList<>();
        if (!チェック票List.isEmpty()) {
            saiChekkuhyoReportList.add(SaiChekkuhyoReport.createFrom(チェック票List));
        }
        SaiChekkuhyoProperty property = new SaiChekkuhyoProperty();
        try (ReportAssembler<SaiChekkuhyoReportSource> assembler = createAssembler(property, reportManager)) {
            for (SaiChekkuhyoReport report : saiChekkuhyoReportList) {
                ReportSourceWriter<SaiChekkuhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票差異チェック票_両面右を出力します。
     *
     * @param チェック票List 要介護認定調査票差異チェック票List
     */
    public void print要介護認定調査票差異チェック票_両面右(List<SaiChekkuhyoItem> チェック票List) {
        List<SaiChekkuhyoRyoumenReport> ryoumenReportList = new ArrayList<>();
        ryoumenReportList.add(SaiChekkuhyoRyoumenReport.createFrom(チェック票List));
        SaiChekkuhyoRyoumenProperty ryoumenproperty = new SaiChekkuhyoRyoumenProperty(ReportIdDBZ.DBE292002.getReportId());
        try (ReportAssembler<SaiChekkuhyoReportSource> assembler = createAssembler(ryoumenproperty, reportManager)) {
            for (SaiChekkuhyoRyoumenReport report : ryoumenReportList) {
                ReportSourceWriter<SaiChekkuhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 要介護認定調査票差異チェック票_両面左を出力します。
     *
     * @param チェック票List 要介護認定調査票差異チェック票List
     */
    public void print要介護認定調査票差異チェック票_両面左(List<SaiChekkuhyoItem> チェック票List) {
        List<SaiChekkuhyoRyoumenReport> ryoumenReportList = new ArrayList<>();
        ryoumenReportList.add(SaiChekkuhyoRyoumenReport.createFrom(チェック票List));
        SaiChekkuhyoRyoumenProperty ryoumenproperty = new SaiChekkuhyoRyoumenProperty(ReportIdDBZ.DBE292003.getReportId());
        try (ReportAssembler<SaiChekkuhyoReportSource> assembler = createAssembler(ryoumenproperty, reportManager)) {
            for (SaiChekkuhyoRyoumenReport report : ryoumenReportList) {
                ReportSourceWriter<SaiChekkuhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
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
