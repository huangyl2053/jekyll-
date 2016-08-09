/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia4.TsuikashiryokagamiA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia4.TsuikashiryokagamiA4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用介護認定追加資料鑑情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuTuikaSiryoDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiTaiyosyaJohoEntity> {

    private static final RString SELECT_JIMUTUIKASIRYO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper.get事務局情報");
    private static final int INT_4 = 4;
    private static final List<RString> PAGE_BREAK_KEYS_A4 = Collections.unmodifiableList(Arrays.asList(
            new RString(TsuikashiryokagamiA4ReportSource.ReportSourceFields.shinsakaiNo.name())));
    private static final int 満ページ件数 = 10;
    private IinShinsakaiIinJohoProcessParameter paramter;
    private IJimuShiryoShinsakaiIinMapper mapper;
    private JimuShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private List<ShinsakaiIinJohoEntity> 審査員;
    private JimuTuikaSiryoBusiness business;
    private int データ件数;
    @BatchWriter
    private BatchReportWriter<TsuikashiryokagamiA4ReportSource> batchWriterA4;
    private ReportSourceWriter<TsuikashiryokagamiA4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        mapper = getMapper(IJimuShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setHaishiFlag_False(IsHaishi.有効.is廃止());
        myBatisParameter.setHaishiFlag_True(IsHaishi.廃止.is廃止());
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setSisutemuYMD(FlexibleDate.getNowDate());
        審査員 = mapper.get事務局委員氏名(myBatisParameter);
        データ件数 = mapper.get事務局情報件数(myBatisParameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUTUIKASIRYO, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriterA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517019.getReportId().value())
                .addBreak(new BreakerCatalog<TsuikashiryokagamiA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A4))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriterA4);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiTaiyosyaJohoEntity entity) {
        if (データ件数 % 満ページ件数 == 0) {
            TsuikashiryokagamiA4Report report = new TsuikashiryokagamiA4Report(business);
            report.writeBy(reportSourceWriterA4);
        }
    }

    @Override
    protected void usualProcess(ShinsakaiTaiyosyaJohoEntity entity) {
        business = new JimuTuikaSiryoBusiness(entity,
                審査員,
                paramter,
                データ件数,
                ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517019.getReportId(),
                        KamokuCode.EMPTY, 1, 1, FlexibleDate.getNowDate()));
        TsuikashiryokagamiA4Report report = new TsuikashiryokagamiA4Report(business);
        report.writeBy(reportSourceWriterA4);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString id = ReportIdDBE.DBE517019.getReportId().getColumnValue();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                get帳票名(),
                new RString(batchWriterA4.getPageCount()),
                RString.EMPTY,
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(条件(new RString("合議体番号"), new RString(paramter.getGogitaiNo())));
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

    private RString get帳票名() {
        RString 介護認定審査会開催番号 = paramter.getShinsakaiKaisaiNo();
        RStringBuilder 帳票名 = new RStringBuilder();
        帳票名.append(介護認定審査会開催番号.substring(介護認定審査会開催番号.length() - INT_4));
        帳票名.append(new RString("　審査会　追加資料"));
        return 帳票名.toRString();
    }
}
