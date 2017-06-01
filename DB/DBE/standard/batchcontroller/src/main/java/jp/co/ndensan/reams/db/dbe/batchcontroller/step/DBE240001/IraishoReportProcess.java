/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.NinteiChosaBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoReport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaisho.ChosaIraishoReportSource;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票「DBE220001_認定調査依頼書」の処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class IraishoReportProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書tmp");
    private static final ReportId 帳票ID = ReportIdDBZ.DBE220001.getReportId();
    private static final int INT6 = 6;
    private NinteiChosaBusiness business;
    private NinshoshaSource ninshoshaSource;
    private Map<Integer, RString> 通知文Map;
    private RString 文書番号;
    private boolean is認定広域 = false;
    private NinteiChosaProcessParamter processParamter;
    @BatchWriter
    private BatchReportWriter<ChosaIraishoReportSource> iraishoBatchReportWriter;
    private ReportSourceWriter<ChosaIraishoReportSource> iraishoReportSourceWriter;
    private int 宛名連番 = 1;

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
        iraishoBatchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        iraishoReportSourceWriter = new ReportSourceWriter<>(iraishoBatchReportWriter);
    }

    @Override
    protected void beforeExecute() {
        if (is認定広域) {
            ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                    帳票ID,
                    new FlexibleDate(processParamter.getHakkobi()),
                    NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし,
                    iraishoReportSourceWriter, new ShoKisaiHokenshaNo(processParamter.getShoKisaiHokenshaNo()));
        } else {
            ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                    帳票ID,
                    new FlexibleDate(processParamter.getHakkobi()),
                    NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし,
                    iraishoReportSourceWriter);
        }
        文書番号 = processParamter.get文書番号();
        int 通知書定型文パターン番号 = RString.isNullOrEmpty(processParamter.getShichosonCode()) ? 1 : Integer.parseInt(processParamter.getShichosonCode().toString());
        通知文Map = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, 帳票ID, KamokuCode.EMPTY, 通知書定型文パターン番号);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        ChosaIraishoHeadItem item = business.setChosaIraishoHeadItem(entity, 通知文Map, ninshoshaSource, 文書番号);
        item.setAtenaRemban(new RString(宛名連番++).padZeroToLeft(INT6));
        ChosaIraishoReport report = ChosaIraishoReport.createFrom(item);
        report.writeBy(iraishoReportSourceWriter);
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
                ReportIdDBZ.DBE220001.getReportName(),
                new RString(String.valueOf(iraishoReportSourceWriter.pageCount().value())),
                new RString("無し"),
                new RString("－"),
                business.set出力条件());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
