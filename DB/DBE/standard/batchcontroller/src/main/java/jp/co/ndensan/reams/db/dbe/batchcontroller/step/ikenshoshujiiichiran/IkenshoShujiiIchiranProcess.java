/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ikenshoshujiiichiran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran.IkenshoShujiiIchiranBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran.IkenshoShujiiIchiranHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran.IkenshoShujiiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.IkenshoShujiiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoshujiiichiran.IkenshoShujiiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;

/**
 * 医療機関・主治医一覧表_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-0260-030 zuotao
 */
public class IkenshoShujiiIchiranProcess extends BatchKeyBreakBase<IkenshoShujiiIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshoshujiiichiran."
            + "IkenshoShujiiIchiranRelateMapper.getIkenshoShujiiIchiranRelateEntity");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("listIchiranhyoUpper_1")));
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString 市町村コード = new RString("【市町村コード】");
    private static final RString 市町村名 = new RString("【市町村名】");
    private static final RString 主治医医療機関コードFROM = new RString("【主治医医療機関コードFrom】");
    private static final RString 主治医医療機関コードTO = new RString("【主治医医療機関コードTo】");
    private static final RString 主治医コードFROM = new RString("【主治医コードFrom】");
    private static final RString 主治医コードTO = new RString("【主治医コードTo】");
    private static final RString 状況 = new RString("【状況】");
    private static final RString 並び順 = new RString("【並び順】");
    private static final RString 改頁 = new RString("【改頁】");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");

    IkenshoShujiiIchiranHeadItem headItem;
    List<IkenshoShujiiIchiranBodyItem> bodyItemList;
    IkenshoShujiiIchiranProcessParameter processParameter;
    @BatchWriter
    private BatchReportWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> batchWrite;
    private ReportSourceWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        bodyItemList = new ArrayList<>();
        headItem = new IkenshoShujiiIchiranHeadItem(
                processParameter.getShichosonCode(),
                processParameter.getShichosonName(),
                processParameter.getIryoKikanCodeFrom(),
                processParameter.getIryoKikanCodeTo(),
                processParameter.getShujiiCodeFrom(),
                processParameter.getShujiiCodeTo(),
                processParameter.getJyokyo(),
                processParameter.getOutputSort(),
                processParameter.getNextpage());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, IkenshoShujiiIchiranProcessParameter.
                to主治医一覧表作成MybatisParameter(processParameter));
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE591001.getReportId().value())
                .addBreak(new BreakerCatalog<ShujiiIryokikanShujiiIchiranhyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void usualProcess(IkenshoShujiiIchiranRelateEntity entity) {
        bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void keyBreakProcess(IkenshoShujiiIchiranRelateEntity current) {
        if (hasBrek(getBefore(), current)) {
            IkenshoShujiiIchiranReport report = IkenshoShujiiIchiranReport.createFrom(headItem, bodyItemList);
            report.writeBy(reportSourceWriter);
            bodyItemList = new ArrayList<>();
        }
    }

    @Override
    protected void afterExecute() {

        IkenshoShujiiIchiranReport report = IkenshoShujiiIchiranReport.createFrom(headItem, bodyItemList);
        report.writeBy(reportSourceWriter);
        set出力条件表();
    }

    private IkenshoShujiiIchiranBodyItem setBodyItem(IkenshoShujiiIchiranRelateEntity entity) {
        return new IkenshoShujiiIchiranBodyItem(
                entity.getIryokikanCode(),
                entity.getIryoKikanMeishoKana(),
                entity.getDaihyoshaNameKana(),
                entity.getYubinNo() == null ? RString.EMPTY : entity.getYubinNo().value(),
                entity.getTelNo() == null ? RString.EMPTY : entity.getTelNo().value(),
                entity.isIryokikanJokyoFlag(),
                entity.getShujiiCode(),
                entity.getShujiiKana() == null ? RString.EMPTY : entity.getShujiiKana().value(),
                entity.getSeibetsu() == null ? RString.EMPTY : entity.getSeibetsu().getKey(),
                entity.isShujiiJokyoFlag(),
                entity.getIryoKikanMeisho(),
                entity.getDaihyoshaName() == null ? RString.EMPTY : entity.getDaihyoshaName().value(),
                entity.getJusho(),
                entity.getShujiiName() == null ? RString.EMPTY : entity.getShujiiName().value(),
                entity.getShinryokaName());
    }

    private boolean hasBrek(IkenshoShujiiIchiranRelateEntity before, IkenshoShujiiIchiranRelateEntity current) {
        return !before.getShujiiCode().equals(current.getShujiiCode());
    }

    private void set出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(市町村コード);
        builder.append(processParameter.getShichosonCode());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(市町村名);
        builder.append(processParameter.getShichosonName());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医医療機関コードFROM);
        builder.append(processParameter.getIryoKikanCodeFrom());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医医療機関コードTO);
        builder.append(processParameter.getIryoKikanCodeTo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医コードFROM);
        builder.append(processParameter.getShujiiCodeFrom());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医コードTO);
        builder.append(processParameter.getShujiiCodeTo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(状況);
        builder.append(processParameter.getJyokyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(並び順);
        builder.append(processParameter.getOutputSort());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(改頁);
        builder.append(processParameter.getNextpage());
        出力条件.add(builder.toRString());

        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdDBE.DBE591001.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        ジョブ番号.concat(String.valueOf(JobContextHolder.getJobId())),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE591001.getReportId().value()),
                        new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }
}
