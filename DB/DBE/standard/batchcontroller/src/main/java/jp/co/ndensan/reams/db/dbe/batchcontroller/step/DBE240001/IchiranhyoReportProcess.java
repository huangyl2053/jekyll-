/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.NinteiChosaBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.service.core.kaigiatesakijushosettei.KaigoAtesakiJushoSetteiFinder;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票「DBE220002_認定調査依頼一覧表」の処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class IchiranhyoReportProcess extends BatchKeyBreakBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書tmp");
    private static final ReportId 帳票ID = ReportIdDBZ.DBE220002.getReportId();
    private int 連番 = 1;
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("shichosoncode"), new RString("chosaitakusakicode")));
    private NinteiChosaBusiness business;
    private NinshoshaSource ninshoshaSource;
    private Map<Integer, RString> 通知文Map;
    private NinteiChosaProcessParamter processParamter;
    private boolean is認定広域 = false;

    @BatchWriter
    private BatchReportWriter<ChosaIraiIchiranhyoReportSource> ichiranhyoBatchReportWriter;
    private ReportSourceWriter<ChosaIraiIchiranhyoReportSource> ichiranhyoReportSourceWriter;

    @Override
    protected void initialize() {
        business = new NinteiChosaBusiness(processParamter);
        KaigoAtesakiJushoSetteiFinder finader = KaigoAtesakiJushoSetteiFinder.createInstance();
        List<KaigoDonyuKeitai> 介護導入形態 = finader.select介護導入形態().records();
        for (KaigoDonyuKeitai item : 介護導入形態) {
            if (GyomuBunrui.介護認定.equals(item.get業務分類()) && DonyuKeitaiCode.認定広域.equals(item.get導入形態コード())) {
                is認定広域 = true;
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaMybitisParamter());
    }

    @Override
    protected void createWriter() {
        ichiranhyoBatchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).
                addBreak(new BreakerCatalog<ChosaIraiIchiranhyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        ichiranhyoReportSourceWriter = new ReportSourceWriter<>(ichiranhyoBatchReportWriter);
    }

    @Override
    protected void beforeExecute() {
        if (is認定広域) {
            ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                    帳票ID,
                    new FlexibleDate(processParamter.getHakkobi()),
                    NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし,
                    ichiranhyoReportSourceWriter, new ShoKisaiHokenshaNo(processParamter.getShoKisaiHokenshaNo()));
        } else {
            ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                    帳票ID,
                    new FlexibleDate(processParamter.getHakkobi()),
                    NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし,
                    ichiranhyoReportSourceWriter);
        }
    }

    @Override
    protected void keyBreakProcess(HomonChosaIraishoRelateEntity current) {
        if (hasBrek(getBefore(), current)) {
            連番 = 1;
        }
    }

    private boolean hasBrek(HomonChosaIraishoRelateEntity before, HomonChosaIraishoRelateEntity current) {
        return !before.get証記載保険者番号().equals(current.get証記載保険者番号()) || !before.get認定調査委託先コード().equals(current.get認定調査委託先コード());
    }

    @Override
    protected void usualProcess(HomonChosaIraishoRelateEntity entity) {
        int 通知書定型文パターン番号 = RString.isNullOrEmpty(processParamter.getShichosonCode()) ? 1 : Integer.parseInt(processParamter.getShichosonCode().toString());
        通知文Map = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, 帳票ID, KamokuCode.EMPTY, 通知書定型文パターン番号);
        ChosaIraiIchiranhyoReport report = ChosaIraiIchiranhyoReport.
                createFrom(business.setBodyItem(entity, 連番, ninshoshaSource, 通知文Map));
        report.writeBy(ichiranhyoReportSourceWriter);
        連番++;
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBZ.DBE220002.getReportName(),
                new RString(String.valueOf(ichiranhyoReportSourceWriter.pageCount().value())),
                new RString("無し"),
                new RString("－"),
                business.set出力条件());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
