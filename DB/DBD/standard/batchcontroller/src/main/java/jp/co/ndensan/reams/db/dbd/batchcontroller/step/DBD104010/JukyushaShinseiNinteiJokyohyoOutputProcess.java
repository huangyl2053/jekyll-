/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD104010;

import jp.co.ndensan.reams.db.dbd.business.core.dbd104010.JukyushagenmenninteiDateManager;
import jp.co.ndensan.reams.db.dbd.business.core.dbd104010.JukyushagenmenshinseiDateManager;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300001.JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd104010.DBD104010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijkouTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushagemmenjisshijokyo.JukyushaGemmenJisshiJokyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300001.JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource;
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
 * 受給者減免月別申請認定状況表のReportのProcessです。
 *
 * @reamsid_L DBD-3770-030 liuwei2
 */
public class JukyushaShinseiNinteiJokyohyoOutputProcess extends BatchProcessBase<NinteijkouTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate"
            + ".jukyushagenmenjkoujyotai.IJukyushagenmenshinseiMapper.get出力情報");
    private DBD104010ProcessParameter processParameter;
    private static final RString タイトルのみ印字 = new RString("タイトルのみ印字");
    @BatchWriter
    private BatchReportWriter<JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource> reportSourceWriter;
    private final RString 全て = new RString("全て");
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private Association 地方公共団体;

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
        JukyushagenmenshinseiDateManager manager = new JukyushagenmenshinseiDateManager();
        JukyushaGemmenJisshiJokyoEntity データリスト;
        if (!タイトルのみ印字.equals(t.getInnjiKubun())) {
            データリスト = manager.set受給者減免月別申請認定状況帳票出力(t);
        } else {
            データリスト = manager.set受給者減免月別申請認定状況帳票出力_タイトルのみ印字(t);
        }

        JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReport report
                = new JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReport(地方公共団体, processParameter.get対象年度(),
                        データリスト, 市町村コード.value(), 市町村名称);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
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
                new RString("「受給者減免月別申請・認定状況表」"),
                ページ数,
                new RString("なし"),
                RString.EMPTY,
                manager.set出力条件(processParameter, 市町村名));
        OutputJokenhyoFactory.createInstance(item).print();
    }
}
