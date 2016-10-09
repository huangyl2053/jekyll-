/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD104010;

import jp.co.ndensan.reams.db.dbd.business.core.dbd104010.JukyushagenmenninteiDateManager;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300002.JukyushaGemmenTsukibetsuNinteishasuJokyohyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd104010.DBD104010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijkouTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushagemmenjisshijokyo.JukyushaGemmenJisshiJokyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300002.JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource;
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
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者減免月別認定者数状況表のReportのProcessです。
 *
 * @reamsid_L DBD-3770-030 liuwei2
 */
public class JukyushaNinteishasuJokyohyoOutputProcess extends BatchProcessBase<NinteijkouTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate"
            + ".jukyushagenmenjkoujyotai.IJukyushagenmenshinseiMapper.get出力情報");
    private DBD104010ProcessParameter processParameter;
    @BatchWriter
    private BatchReportWriter<JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource> reportSourceWriter;
    private final RString 全て = new RString("全て");
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private Association 地方公共団体;
    private static final RString タイトルのみ印字 = new RString("タイトルのみ印字");

    @Override
    protected void initialize() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        if (全て.equals(processParameter.get宛名抽出条件().getShichoson_Code().value()) || processParameter.get宛名抽出条件().getShichoson_Code().isEmpty()) {
            市町村コード = 地方公共団体.getLasdecCode_();
            市町村名称 = 地方公共団体.get市町村名();
        } else {
            市町村コード = processParameter.get宛名抽出条件().getShichoson_Code();
            市町村名称 = AssociationFinderFactory.createInstance().getAssociation(processParameter.get宛名抽出条件().getShichoson_Code()).get市町村名();
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(processParameter.get帳票ID().value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(NinteijkouTempTableEntity t) {
        JukyushagenmenninteiDateManager manager = new JukyushagenmenninteiDateManager();
        JukyushaGemmenJisshiJokyoEntity データリスト;
        if (!タイトルのみ印字.equals(t.getInnjiKubun())) {
            データリスト = manager.set受給者減免月別認定者数帳票出力(t);
        } else {
            データリスト = manager.set受給者減免月別認定者数帳票出力_タイトルのみ印字(t);
        }
        JukyushaGemmenTsukibetsuNinteishasuJokyohyoReport report
                = new JukyushaGemmenTsukibetsuNinteishasuJokyohyoReport(地方公共団体, processParameter.get対象年度(),
                        市町村コード.value(), 市町村名称, データリスト);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void beforeExecute() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        JukyushagenmenninteiDateManager manager = new JukyushagenmenninteiDateManager();
        Association association = AssociationFinderFactory.createInstance().getAssociation(processParameter.get宛名抽出条件().getShichoson_Code());
        RString 市町村名 = association.get市町村名();

        RString ページ数 = new RString(reportSourceWriter.pageCount().value());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                processParameter.get帳票ID().value(),
                地方公共団体.getLasdecCode_().getColumnValue(),
                地方公共団体.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("「受給者減免月別認定者数状況表」"),
                ページ数,
                new RString("なし"),
                RString.EMPTY,
                manager.set出力条件(processParameter, 市町村名));
        OutputJokenhyoFactory.createInstance(item).print();
    }
}
