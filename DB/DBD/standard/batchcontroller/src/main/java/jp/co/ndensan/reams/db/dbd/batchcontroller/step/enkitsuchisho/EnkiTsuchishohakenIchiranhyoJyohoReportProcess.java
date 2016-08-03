/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.enkitsuchisho;

import jp.co.ndensan.reams.db.dbd.business.report.dbd522002.NinteiEnkiTsuchishoHakkoIchiranhyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.enkitsuchisho.EnkiTsuchishohakenIchiranhyoJyohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.EnkiTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd522002.NinteiEnkiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.enkitsuchisho.IEnkiTsuchishoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 延期通知書発行一覧表の作成_process処理クラスです。
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
public class EnkiTsuchishohakenIchiranhyoJyohoReportProcess extends BatchProcessBase<EnkiTsuchishoEntity> {

    private static final ReportId REPORT_DBD522002 = ReportIdDBD.DBD522002.getReportId();
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.enkitsuchisho."
                    + "IEnkiTsuchishoMapper.get延期通知書発行一覧表情報");
    IEnkiTsuchishoMapper mapper;
    private int 連番 = 0;

    @BatchWriter
    private BatchReportWriter<NinteiEnkiTsuchishoHakkoIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<NinteiEnkiTsuchishoHakkoIchiranhyoReportSource> reportSourceWriter;
    private EnkiTsuchishohakenIchiranhyoJyohoProcessParameter parameter;

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toEnkiTsuchishohakenIchiranhyoJyohoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD522002.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
    }

//    @Override
//    protected void afterExecute() {
//        outputJokenhyoFactory();
//    }
    @Override
    protected void process(EnkiTsuchishoEntity entity) {
        if (entity == null) {

        } else {
            NinteiEnkiTsuchishoHakkoIchiranhyoReport report = new NinteiEnkiTsuchishoHakkoIchiranhyoReport(entity);
            entity.set処理見込み日From(parameter.toEnkiTsuchishohakenIchiranhyoJyohoMybatisParameter().getShorimikomibiFrom());
            entity.set処理見込み日To(parameter.toEnkiTsuchishohakenIchiranhyoJyohoMybatisParameter().getShorimikomibiTo());
            entity.set通知書発行日(parameter.toEnkiTsuchishohakenIchiranhyoJyohoMybatisParameter().getTsuchishohakkonbi());
            entity.set連番(連番++);
            report.writeBy(reportSourceWriter);
        }
    }

//    private void outputJokenhyoFactory() {
//        Association association = AssociationFinderFactory.createInstance().getAssociation();
//        RString id = ReportIdDBD.DBD522002.getReportId().getColumnValue();
//        RString ページ数 = new RString(reportSourceWriterA3.pageCount().value());
//        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
//                id,
//                association.getLasdecCode_().getColumnValue(),
//                association.get市町村名(),
//                new RString(String.valueOf(JobContextHolder.getJobId())),
//                get帳票名(),
//                ページ数,
//                RString.EMPTY,
//                RString.EMPTY,
//                contribute());
//        OutputJokenhyoFactory.createInstance(item).print();
//    }
//
//    private RString get帳票名() {
//        RString 介護認定審査会開催番号 = paramter.getShinsakaiKaisaiNo();
//        RStringBuilder 帳票名 = new RStringBuilder();
//        帳票名.append(介護認定審査会開催番号.substring(介護認定審査会開催番号.length() - INT_4));
//        帳票名.append(new RString("　審査会"));
//        return 帳票名.toRString();
//    }
}
