/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1a4.Shujiiikensho1A4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.Shujiiikensho1A4ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用主治医意見書情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 wangxiaodong
 */
public class IinIkenshoDataSakuseiA4Process extends BatchProcessBase<ShinsakaiSiryoKyotsuEntity> {

    private static final RString SELECT_SHINSAKAISIRYOKYOTSU = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiSiryoKyotsu");
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private JimuShinsakaiWariateJohoBusiness 主治医意見書;

    @BatchWriter
    private BatchReportWriter<Shujiiikensho1A4ReportSource> batchWriteA4;
    private ReportSourceWriter<Shujiiikensho1A4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setShoriJotaiKubunList(shoriJotaiKubunList);
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHINSAKAISIRYOKYOTSU, myBatisParameter);
    }

    @Override
    protected void process(ShinsakaiSiryoKyotsuEntity entity) {
        entity.setHihokenshaNo(RString.EMPTY);
        entity.setHihokenshaName(AtenaMeisho.EMPTY);
        entity.setShoKisaiHokenshaNo(RString.EMPTY);
        entity.setJimukyoku(false);
        主治医意見書 = new JimuShinsakaiWariateJohoBusiness(entity);
        Shujiiikensho1A4Report reportA4 = new Shujiiikensho1A4Report(主治医意見書);
        reportA4.writeBy(reportSourceWriterA4);
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517151.getReportId().value()).create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE517151.getReportId().value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                new RString("主治医意見書（表）"),
                new RString(1),
                RString.EMPTY,
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(条件(new RString("合議体番号"), paramter.getGogitaiNo()));
        出力条件.add(条件(new RString("介護認定審査会開催予定年月日"), paramter.getShinsakaiKaisaiYoteiYMD().wareki().toDateString()));
        出力条件.add(条件(new RString("介護認定審査会開催番号"), paramter.getShinsakaiKaisaiNo()));
        return 出力条件;
    }

    private RString 条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("【"));
        条件.append(バッチパラメータ名);
        条件.append(new RString("】"));
        条件.append(値);
        return 条件.toRString();
    }
}
