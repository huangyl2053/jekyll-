/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5720001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200037.JukyushaIdoCheckListProperty.DBD200037_JukyushaIdoCheckListEnum;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200037.JukyushaIdoCheckListReport;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5720001.JyukyushaDaichoIdoCheckListMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5720001.JyukyushaDaichoIdoCheckListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.JyukyushaDaichoIdoCheckListEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200037.JukyushaIdoCheckListReportSource;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * バッチ設計_受給者台帳異動チェックリストのprocess処理クラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public class JyukyushaDaichoIdoCheckListProcess extends BatchKeyBreakBase<JyukyushaDaichoIdoCheckListEntity> {

    private static final ReportId REPORT_DBD200037 = ReportIdDBD.DBD200037.getReportId();
    private JyukyushaDaichoIdoCheckListProcessParameter parameter;
    private JyukyushaDaichoIdoCheckListMybatisParameter mybatisPrm;
    private static final RString 今回抽出開始年月日 = new RString("今回抽出開始年月日");
    private static final RString 今回抽出開始時分秒 = new RString("今回抽出開始時分秒");
    private static final RString 今回抽出終了年月日 = new RString("今回抽出終了年月日");
    private static final RString 今回抽出終了時分秒 = new RString("今回抽出終了時分秒");
    private static final RString 出力対象 = new RString("出力対象");
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(JukyushaIdoCheckListReportSource.ReportSourceFields.hokenshaNo.name())));
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushaidochecklist."
                    + "IJukyushaIdoCheckListMapper.get帳票出力対象データ");
    private static final int 最大表示行数 = 18;
    private int ページ表示行数;

    @BatchWriter
    private BatchReportWriter<JukyushaIdoCheckListReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaIdoCheckListReportSource> reportSourceWriter;
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7022EntityWriter;

    @Override
    protected void initialize() {
        parameter.set出力順(get出力順());
        mybatisPrm = parameter.toJyukyushaDaichoIdoCheckListMybatisParameter();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisPrm);
    }

    @Override
    protected void createWriter() {
        dbT7022EntityWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD200037.value()).addBreak(
                new BreakerCatalog<JukyushaIdoCheckListReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(JyukyushaDaichoIdoCheckListEntity current) {
        if (hasBrek(getBefore(), current)) {
            ページ表示行数 = 0;
        }

    }

    @Override
    protected void usualProcess(JyukyushaDaichoIdoCheckListEntity entity) {
        JukyushaIdoCheckListReport report = new JukyushaIdoCheckListReport(entity);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
        DbT7022ShoriDateKanriEntity dbT7022entity = new DbT7022ShoriDateKanriEntity();
        dbT7022entity.setKijunYMD(new FlexibleDate(parameter.get今回抽出終了年月日().toString()));
        dbT7022entity.setKijunTimestamp(new YMDHMS(parameter.get今回抽出終了時分秒().toString()));
        dbT7022entity.setTaishoKaishiYMD(new FlexibleDate(parameter.get今回抽出開始年月日().toString()));
        dbT7022entity.setTaishoShuryoYMD(new FlexibleDate(parameter.get今回抽出終了年月日().toString()));
        dbT7022entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.get今回抽出開始時分秒().toString()));
        dbT7022entity.setTaishoShuryoTimestamp(new YMDHMS(parameter.get今回抽出終了時分秒().toString()));
        dbT7022EntityWriter.update(dbT7022entity);
    }

    private boolean hasBrek(JyukyushaDaichoIdoCheckListEntity before, JyukyushaDaichoIdoCheckListEntity current) {
        return !(before.get保険者番号().equals(current.get保険者番号())) || ページ表示行数 % 最大表示行数 == 0;
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(SubGyomuCode.DBD介護受給, REPORT_DBD200037, parameter.get出力順ID());
        if (null == order) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(DBD200037_JukyushaIdoCheckListEnum.class, order);
        }
        return 出力順;
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString ページ数 = new RString(reportSourceWriter.pageCount().value());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                REPORT_DBD200037.getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD200037.getReportName(),
                ページ数,
                new RString("無し"),
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();

    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();

        if (parameter.get今回抽出開始年月日() != null) {
            出力条件.add(add出力条件(今回抽出開始年月日, parameter.get今回抽出開始年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出開始時分秒() != null) {
            出力条件.add(add出力条件(今回抽出開始時分秒, parameter.get今回抽出開始時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
        if (parameter.get今回抽出終了年月日() != null) {
            出力条件.add(add出力条件(今回抽出終了年月日, parameter.get今回抽出終了年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出終了時分秒() != null) {
            出力条件.add(add出力条件(今回抽出終了時分秒, parameter.get今回抽出終了時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
        if (parameter.get出力対象() != null) {
            出力条件.add(add出力条件(出力対象, parameter.get出力対象()));
        }

        return 出力条件;
    }

    private RString add出力条件(RString バッチパラメータ名, RString 値) {
        RString 条件 = new RStringBuilder(new RString("[")).append(バッチパラメータ名).
                append(new RString("]")).append(値).toRString();
        return 条件;
    }

}
