/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiIchiran;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoirairirekiichiran.IkenshoirairirekiIchiranProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReport;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReport;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouProperty;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouReport;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouReportJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.syujiyikensho.IkenshoSakuseiIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReport;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReport;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 主治医意見書作成依頼情報の帳票出力管理クラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIraiReportOutputService {

    private static final int 数字_1 = 1;
    private static final int 数字_2 = 2;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    ShujiiIkenshoSakuseiIraiReportOutputService() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoSakuseiIraiReportOutputService}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoSakuseiIraiReportOutputService}のインスタンス
     */
    public static ShujiiIkenshoSakuseiIraiReportOutputService createInstance() {
        return InstanceProvider.create(ShujiiIkenshoSakuseiIraiReportOutputService.class);
    }

    /**
     * 主治医意見書作成依頼情報を出力します。
     *
     * @param 主治医意見書作成依頼情報ItemList 主治医意見書作成依頼情報ItemList
     * @param reportManager 帳票印刷Manager
     */
    public void print主治医意見書作成依頼情報(List<ShujiiIkenshoSakuseiIraishoItem> 主治医意見書作成依頼情報ItemList,
            ReportManager reportManager) {
        List<ShujiiIkenshoSakuseiIraishoReport> list = new ArrayList<>();
        ShujiiIkenshoSakuseiIraishoProperty property = new ShujiiIkenshoSakuseiIraishoProperty();
        try (ReportAssembler<ShujiiIkenshoSakuseiIraishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<ShujiiIkenshoSakuseiIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshosha = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId(),
                    FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            for (int i = 0; i < 主治医意見書作成依頼情報ItemList.size(); i++) {
                ShujiiIkenshoSakuseiIraishoItem item = 主治医意見書作成依頼情報ItemList.get(i);
                list.add(ShujiiIkenshoSakuseiIraishoReport.createFrom(set主治医意見書作成依頼(item, ninshosha)));
            }
            for (ShujiiIkenshoSakuseiIraishoReport report : list) {
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 主治医意見書作成料請求書を出力します。
     *
     * @param 主治医意見書作成料請求書ItemList 主治医意見書作成料請求書ItemList
     * @param reportManager 帳票印刷Manager
     */
    public void print主治医意見書作成料請求書(List<ShujiiIkenshoSakuseiRyoSeikyushoItem> 主治医意見書作成料請求書ItemList,
            ReportManager reportManager) {
        List<ShujiiIkenshoSakuseiRyoSeikyushoReport> list = new ArrayList<>();
        for (int i = 0; i < 主治医意見書作成料請求書ItemList.size(); i++) {
            ShujiiIkenshoSakuseiRyoSeikyushoItem item = 主治医意見書作成料請求書ItemList.get(i);
            list.add(ShujiiIkenshoSakuseiRyoSeikyushoReport.createFrom(item));
        }
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
     * @param reportManager 帳票印刷Manager
     */
    public void print介護保険診断命令書(List<KaigohokenShindanMeireishoHeaderItem> 介護保険診断命令書ItemList, ReportManager reportManager) {
        List<KaigohokenShindanMeireishoReport> list = new ArrayList<>();
        KaigohokenShindanMeireishoProperty property = new KaigohokenShindanMeireishoProperty();
        try (ReportAssembler<KaigohokenShindanMeireishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KaigohokenShindanMeireishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshosha = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE235001.getReportId(),
                    FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            for (int i = 0; i < 介護保険診断命令書ItemList.size(); i++) {
                KaigohokenShindanMeireishoHeaderItem item = 介護保険診断命令書ItemList.get(i);
                list.add(KaigohokenShindanMeireishoReport.createFrom2(set介護保険診断命令書(item, ninshosha)));
            }
            for (KaigohokenShindanMeireishoReport report : list) {
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 介護保険指定医依頼兼主治医意見書提出意見書を出力します。
     *
     * @param 介護保険指定医依頼兼主治医意見書提出意見書ItemList 介護保険指定医依頼兼主治医意見書提出意見書ItemList
     * @param reportManager 帳票印刷Manager
     */
    public void print介護保険指定医依頼兼主治医意見書提出意見書(List<ShujiiIkenshoTeishutsuIraishoItem> 介護保険指定医依頼兼主治医意見書提出意見書ItemList,
            ReportManager reportManager) {
        List<ShujiiIkenshoTeishutsuIraishoReport> list = new ArrayList<>();
        ShujiiIkenshoTeishutsuIraishoProperty property = new ShujiiIkenshoTeishutsuIraishoProperty();
        try (ReportAssembler<ShujiiIkenshoTeishutsuIraishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<ShujiiIkenshoTeishutsuIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshosha = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE236001.getReportId(),
                    FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            for (int i = 0; i < 介護保険指定医依頼兼主治医意見書提出意見書ItemList.size(); i++) {
                ShujiiIkenshoTeishutsuIraishoItem item = 介護保険指定医依頼兼主治医意見書提出意見書ItemList.get(i);
                list.add(ShujiiIkenshoTeishutsuIraishoReport.createFrom(setNishosha(item,ninshosha)));
            }
            for (ShujiiIkenshoTeishutsuIraishoReport report : list) {
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 主治医意見書作成依頼一覧表を出力します。
     *
     * @param 主治医意見書作成依頼一覧表ItemList 主治医意見書作成依頼一覧表ItemList
     * @param reportManager 帳票印刷Manager
     */
    public void print主治医意見書作成依頼一覧表(List<IkenshoSakuseiIraiIchiranhyoItem> 主治医意見書作成依頼一覧表ItemList,
            ReportManager reportManager) {
        List<IkenshoSakuseiIraiIchiranhyoReport> list = new ArrayList<>();
        IkenshoSakuseiIraiIchiranhyoProperty property = new IkenshoSakuseiIraiIchiranhyoProperty();
        try (ReportAssembler<IkenshoSakuseiIraiIchiranhyoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<IkenshoSakuseiIraiIchiranhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshosha = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE230002.getReportId(),
                    FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            for (int i = 0; i < 主治医意見書作成依頼一覧表ItemList.size(); i++) {
                IkenshoSakuseiIraiIchiranhyoItem item = 主治医意見書作成依頼一覧表ItemList.get(i);
                list.add(IkenshoSakuseiIraiIchiranhyoReport.createFrom2(set主治医意見書作成依頼一覧表認定者(
                    item, ninshosha)));
            }
            for (IkenshoSakuseiIraiIchiranhyoReport report : list) {
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 主治医意見書作成依頼発行一覧表を出力します。
     *
     * @param 主治医意見書作成依頼発行一覧表情報 主治医意見書作成依頼発行一覧表情報
     * @param reportManager 帳票印刷Manager
     */
    public void print主治医意見書作成依頼発行一覧表(SyujiyikenshosakuseyiraihakouReportJoho 主治医意見書作成依頼発行一覧表情報, ReportManager reportManager) {
        List<SyujiyikenshosakuseyiraihakouReport> list = new ArrayList<>();
        SyujiyikenshosakuseyiraihakouProperty property = new SyujiyikenshosakuseyiraihakouProperty();
        list.add(SyujiyikenshosakuseyiraihakouReport.createFrom(主治医意見書作成依頼発行一覧表情報.getHeadItem(), 主治医意見書作成依頼発行一覧表情報.getBodyItemList()));
        try (ReportAssembler<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> assembler = createAssembler(property, reportManager)) {
            for (SyujiyikenshosakuseyiraihakouReport report : list) {
                ReportSourceWriter<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 主治医意見書依頼該当者履歴一覧を出力します。
     *
     * @param 主治医意見書依頼該当者履歴一覧ItemList 主治医意見書依頼該当者履歴一覧ItemList
     * @param reportManager 帳票印刷Manager
     */
    public void print主治医意見書依頼該当者履歴一覧(List<IkenshoirairirekiIchiran> 主治医意見書依頼該当者履歴一覧ItemList,
            ReportManager reportManager) {
        List<IkenshoirairirekiIchiranReport> list = new ArrayList<>();
        for (int i = 0; i < 主治医意見書依頼該当者履歴一覧ItemList.size(); i++) {
            IkenshoirairirekiIchiran item = 主治医意見書依頼該当者履歴一覧ItemList.get(i);
            list.add(IkenshoirairirekiIchiranReport.createFrom(item));
        }
        IkenshoirairirekiIchiranProperty property = new IkenshoirairirekiIchiranProperty();
        try (ReportAssembler<IkenshoirairirekiIchiranReportSource> assembler = createAssembler(property, reportManager)) {
            for (IkenshoirairirekiIchiranReport report : list) {
                ReportSourceWriter<IkenshoirairirekiIchiranReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    private ShujiiIkenshoTeishutsuIraishoItem setNishosha(ShujiiIkenshoTeishutsuIraishoItem item, NinshoshaSource ninshosha) {
            item.setDenshiKoin(ninshosha.denshiKoin);
            item.setNinshoshaYakushokuMei(ninshosha.ninshoshaYakushokuMei);
            item.setNinshoshaYakushokuMei1(ninshosha.ninshoshaYakushokuMei1);
            item.setNinshoshaYakushokuMei2(ninshosha.ninshoshaYakushokuMei2);
            item.setNinshoshaShimeiKakenai(ninshosha.ninshoshaShimeiKakenai);
            item.setNinshoshaShimeiKakeru(ninshosha.ninshoshaShimeiKakeru);
            item.setKoinMojiretsu(ninshosha.koinMojiretsu);
            item.setKoinShoryaku(ninshosha.koinShoryaku);
        return item;
    }

    private IkenshoSakuseiIraiIchiranhyoItem set主治医意見書作成依頼一覧表認定者(IkenshoSakuseiIraiIchiranhyoItem item,
            NinshoshaSource ninshosha) {
            item.setDenshiKoin(ninshosha.denshiKoin);
            item.setNinshoshaYakushokuMei(ninshosha.ninshoshaYakushokuMei);
            item.setNinshoshaYakushokuMei1(ninshosha.ninshoshaYakushokuMei1);
            item.setNinshoshaYakushokuMei2(ninshosha.ninshoshaYakushokuMei2);
            item.setNinshoshaShimeiKakenai(ninshosha.ninshoshaShimeiKakenai);
            item.setNinshoshaShimeiKakeru(ninshosha.ninshoshaShimeiKakeru);
            item.setKoinMojiretsu(ninshosha.koinMojiretsu);
            item.setKoinShoryaku(ninshosha.koinShoryaku);
        return item;
    }

    private KaigohokenShindanMeireishoHeaderItem set介護保険診断命令書(KaigohokenShindanMeireishoHeaderItem item,
            NinshoshaSource ninshosha) {
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援,
                ReportIdDBZ.DBE235001.getReportId(), KamokuCode.EMPTY, 数字_1);
        item.setDenshiKoin(ninshosha.denshiKoin);
        item.setNinshoshaYakushokuMei(ninshosha.ninshoshaYakushokuMei);
        item.setNinshoshaYakushokuMei1(ninshosha.ninshoshaYakushokuMei1);
        item.setNinshoshaYakushokuMei2(ninshosha.ninshoshaYakushokuMei2);
        item.setNinshoshaShimeiKakenai(ninshosha.ninshoshaShimeiKakenai);
        item.setNinshoshaShimeiKakeru(ninshosha.ninshoshaShimeiKakeru);
        item.setKoinMojiretsu(ninshosha.koinMojiretsu);
        item.setKoinShoryaku(ninshosha.koinShoryaku);
        item.setTsuchibun1(通知文.get(数字_1));
        item.setTsuchibun2(通知文.get(数字_2));
        return item;
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

    private ShujiiIkenshoSakuseiIraishoItem set主治医意見書作成依頼(ShujiiIkenshoSakuseiIraishoItem item,
            NinshoshaSource ninshosha) {
            item.setHakkoYMD1(item.getHakkoYMD1());
            item.setDenshiKoin(ninshosha.denshiKoin);
            item.setNinshoshaYakushokuMei(ninshosha.ninshoshaYakushokuMei);
            item.setNinshoshaYakushokuMei1(ninshosha.ninshoshaYakushokuMei1);
            item.setNinshoshaYakushokuMei2(ninshosha.ninshoshaYakushokuMei2);
            item.setNinshoshaShimeiKakenai(ninshosha.ninshoshaShimeiKakenai);
            item.setNinshoshaShimeiKakeru(ninshosha.ninshoshaShimeiKakeru);
            item.setKoinMojiretsu(ninshosha.koinMojiretsu);
            item.setKoinShoryaku(ninshosha.koinShoryaku);
            item.setBunshoNo(item.getBunshoNo());
            item.setYubinNo1(item.getYubinNo1());
            item.setJushoText(item.getJushoText());
            item.setKikanNameText(item.getKikanNameText());
            item.setShimeiText(item.getShimeiText());
            item.setMeishoFuyo(item.getMeishoFuyo());
            item.setCustomerBarCode(item.getCustomerBarCode());
            item.setSonota(item.getSonota());
            item.setAtenaRenban(item.getAtenaRenban());
            item.setTitle(item.getTitle());
            item.setTsuchibun1(item.getTsuchibun1());
            item.setShinseiKubun(item.getShinseiKubun());
            item.setHihokenshaNo1(item.getHihokenshaNo1());
            item.setHihokenshaNo2(item.getHihokenshaNo2());
            item.setHihokenshaNo3(item.getHihokenshaNo3());
            item.setHihokenshaNo4(item.getHihokenshaNo4());
            item.setHihokenshaNo5(item.getHihokenshaNo5());
            item.setHihokenshaNo6(item.getHihokenshaNo6());
            item.setHihokenshaNo7(item.getHihokenshaNo7());
            item.setHihokenshaNo8(item.getHihokenshaNo8());
            item.setHihokenshaNo9(item.getHihokenshaNo9());
            item.setHihokenshaNo10(item.getHihokenshaNo10());
            item.setHokenshaNo1(item.getHokenshaNo1());
            item.setHokenshaNo2(item.getHokenshaNo2());
            item.setHokenshaNo3(item.getHokenshaNo3());
            item.setHokenshaNo4(item.getHokenshaNo4());
            item.setHokenshaNo5(item.getHokenshaNo5());
            item.setHokenshaNo6(item.getHokenshaNo6());
            item.setHihokenshaNameKana(item.getHihokenshaNameKana());
            item.setSeibetsuMan(item.getSeibetsuMan());
            item.setSeibetsuWoman(item.getSeibetsuWoman());
            item.setHihokenshaName(item.getHihokenshaName());
            item.setBirthGengoMeiji(item.getBirthGengoMeiji());
            item.setBirthGengoTaisho(item.getBirthGengoTaisho());
            item.setBirthGengoShowa(item.getBirthGengoShowa());
            item.setBirthYMD(item.getBirthYMD());
            item.setYubinNo(item.getYubinNo());
            item.setJusho(item.getJusho());
            item.setShinseiYMD(item.getShinseiYMD());
            item.setTeishutsuKigen(item.getTeishutsuKigen());
            item.setTsuchibun2(item.getTsuchibun2());
            item.setRemban(item.getRemban());
            item.setShoriName(item.getShoriName());
        return item;
    }
}
