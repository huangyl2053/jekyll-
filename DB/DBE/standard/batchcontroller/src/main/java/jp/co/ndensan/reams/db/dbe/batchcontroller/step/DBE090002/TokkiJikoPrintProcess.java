/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage.NinteiChosaTokkiImageEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage.NinteiChosaTokkiImageLaypoutBreaker;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage.NinteiChosaTokkiImagePageBreaker;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage.NinteiChosaTokkiImageReport;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiImage1A4SeparateEditor;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiText1A4AllEditor;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiText1A4Report;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiText1A4SeparateEditor;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokkiimage.NinteiChosaTokkiImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage.NinteiChosaTokkiImageReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext1a4.TokkiText1ReportSource;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 特記事項出力プロセスです。
 *
 * @author N3212 竹内 和紀
 */
public class TokkiJikoPrintProcess extends BatchProcessBase<YokaigoNinteiJohoTeikyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");
    private YokaigoBatchProcessParamter processPrm;
    private YokaigoNinteiJohoTeikyoFinder finder;
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokkiImageReportSource> ninteiChosaTokkiImageReportWriter;
    private ReportSourceWriter<NinteiChosaTokkiImageReportSource> ninteiChosaTokkiImageReportSourceWriter;
    @BatchWriter
    private BatchReportWriter<TokkiText1ReportSource> tokkiImage1A4SeparateReportWriter;
    private ReportSourceWriter<TokkiText1ReportSource> tokkiImage1A4SeparateReportSourceWriter;
    @BatchWriter
    private BatchReportWriter<TokkiText1ReportSource> tokkiText1A4AllReportWriter;
    private ReportSourceWriter<TokkiText1ReportSource> tokkiText1A4AllReportSourceWriter;
    @BatchWriter
    private BatchReportWriter<TokkiText1ReportSource> tokkiText1A4SeparateReportWriter;
    private ReportSourceWriter<TokkiText1ReportSource> tokkiText1A4SeparateReportSourceWriter;

    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString 認定調査票チェックフラグ = new RString("【認定調査票】");
    private static final RString 特記事項チェックフラグ = new RString("【特記事項】");
    private static final RString 主治医意見書チェックフラグ = new RString("【主治医意見書】");
    private static final RString その他資料チェックフラグ = new RString("【その他資料】");
    private static final RString 一次判定結果チェックフラグ = new RString("【一次判定結果】");
    private static final RString 出力する = new RString("出力する");
    private static final RString 出力しない = new RString("出力しない");
    private static final RString 総合事業開始区分 = new RString("【総合事業開始区分】");
    private static final RString 総合事業開始区分_未実施 = new RString("1");
    private static final RString 総合事業開始区分_実施済 = new RString("2");
    private static final RString 総合事業未実施 = new RString("総合事業未実施");
    private static final RString 総合事業実施済 = new RString("総合事業実施済");
    private static final RString すべて = new RString("1");
    private final RString マスキングなし = new RString("0");
    private final RString マスキングあり = new RString("1");

    @Override
    protected void initialize() {
        finder = YokaigoNinteiJohoTeikyoFinder.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected void createWriter() {
        ninteiChosaTokkiImageReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE091003.getReportId().value())
                .addBreak(new NinteiChosaTokkiImagePageBreaker())
                .addBreak(new NinteiChosaTokkiImageLaypoutBreaker()).create();
        ninteiChosaTokkiImageReportSourceWriter = new ReportSourceWriter(ninteiChosaTokkiImageReportWriter);

        tokkiImage1A4SeparateReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517134.getReportId().value())
                .addBreak(new BreakerCatalog<TokkiText1ReportSource>().new SimpleLayoutBreaker(TokkiText1ReportSource.LAYOUTBREAKITEM,
                        TokkiText1ReportSource.TOKKIIMG) {
                    @Override
                    public ReportLineRecord<TokkiText1ReportSource> occuredBreak(
                            ReportLineRecord<TokkiText1ReportSource> currentRecord,
                            ReportLineRecord<TokkiText1ReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                                int layout = currentRecord.getSource().layoutBreakItem;
                                currentRecord.setFormGroupIndex(layout);
                                if (nextRecord != null && nextRecord.getSource() != null) {
                                    layout = nextRecord.getSource().layoutBreakItem;
                                    nextRecord.setFormGroupIndex(layout);
                                }
                                return currentRecord;
                            }
                }).create();
        tokkiImage1A4SeparateReportSourceWriter = new ReportSourceWriter(tokkiImage1A4SeparateReportWriter);
        tokkiText1A4AllReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517131.getReportId().value())
                .addBreak(new BreakerCatalog<TokkiText1ReportSource>().simplePageBreaker(TokkiText1ReportSource.RECORDCOUNT))
                .addBreak(new BreakerCatalog<TokkiText1ReportSource>().new SimpleLayoutBreaker(
                    TokkiText1ReportSource.LAYOUTBREAKITEM) {
                    @Override
                    public ReportLineRecord<TokkiText1ReportSource> occuredBreak(
                            ReportLineRecord<TokkiText1ReportSource> currentRecord,
                            ReportLineRecord<TokkiText1ReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                                int layout = currentRecord.getSource().layoutBreakItem;
                                currentRecord.setFormGroupIndex(layout);
                                if (nextRecord != null && nextRecord.getSource() != null) {
                                    layout = nextRecord.getSource().layoutBreakItem;
                                    nextRecord.setFormGroupIndex(layout);
                                }
                                return currentRecord;
                            }
                }).create();
        tokkiText1A4AllReportSourceWriter = new ReportSourceWriter(tokkiText1A4AllReportWriter);

        tokkiText1A4SeparateReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517132.getReportId().value())
                .addBreak(new BreakerCatalog<TokkiText1ReportSource>().simplePageBreaker(TokkiText1ReportSource.RECORDCOUNT))
                .addBreak(new BreakerCatalog<TokkiText1ReportSource>().new SimpleLayoutBreaker(
                    TokkiText1ReportSource.LAYOUTBREAKITEM) {
                    @Override
                    public ReportLineRecord<TokkiText1ReportSource> occuredBreak(
                            ReportLineRecord<TokkiText1ReportSource> currentRecord,
                            ReportLineRecord<TokkiText1ReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                                int layout = currentRecord.getSource().layoutBreakItem;
                                currentRecord.setFormGroupIndex(layout);
                                if (nextRecord != null && nextRecord.getSource() != null) {
                                    layout = nextRecord.getSource().layoutBreakItem;
                                    nextRecord.setFormGroupIndex(layout);
                                }
                                return currentRecord;
                            }
                }).create();
        tokkiText1A4SeparateReportSourceWriter = new ReportSourceWriter(tokkiText1A4SeparateReportWriter);
    }

    @Override
    protected void process(YokaigoNinteiJohoTeikyoEntity entity) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(entity.get申請書管理番号());
        List<NinteichosaRelate> 特記事項List = finder.get特記事項List(申請書管理番号, processPrm.get特記事項マスキング区分());
        if (マスキングあり.equals(processPrm.get特記事項マスキング区分()) && 特記事項List.isEmpty()) {
            特記事項List = finder.get特記事項List(申請書管理番号, マスキングなし);
        }
        List<RString> 特記事項区分List = new ArrayList<>();
        for (NinteichosaRelate 特記事項 : 特記事項List) {
            特記事項区分List.add(特記事項.get特記事項区分());
        }
        if (特記事項区分List.contains(TokkijikoTextImageKubun.イメージ.getコード())) {
            if (entity.get認定申請年月日().isBeforeOrEquals(processPrm.get特記事項判定日())) {
                NinteiChosaTokkiImageEntity ninteiChosaTokkiImageEntity
                        = NinteiChosaTokkiImageEntityEditor.edit(entity, 特記事項List, processPrm.get特記事項マスキング区分());
                NinteiChosaTokkiImageReport report = new NinteiChosaTokkiImageReport(ninteiChosaTokkiImageEntity);
                report.writeBy(ninteiChosaTokkiImageReportSourceWriter);
            } else {
                RDateTime イメージ共有ファイルID = finder.getイメージ共有ファイルID(申請書管理番号);
                TokkiText1A4Entity tokkiText1A4Entity
                        = TokkiImage1A4SeparateEditor.edit(entity, 特記事項List, processPrm.get特記事項マスキング区分(), イメージ共有ファイルID);
                TokkiText1A4Report report = new TokkiText1A4Report(tokkiText1A4Entity);
                report.writeBy(tokkiImage1A4SeparateReportSourceWriter);
            }
        } else if (特記事項区分List.contains(TokkijikoTextImageKubun.テキスト.getコード())) {

            if (すべて.equals(processPrm.get情報提供資料の特記事項編集パターン())) {
                TokkiText1A4Entity tokkiText1A4Entity = TokkiText1A4AllEditor.edit(entity, 特記事項List, processPrm.get特記事項マスキング区分());
                TokkiText1A4Report report = new TokkiText1A4Report(tokkiText1A4Entity);
                report.writeBy(tokkiText1A4AllReportSourceWriter);
            } else {
                TokkiText1A4Report report
                        = new TokkiText1A4Report(TokkiText1A4SeparateEditor.edit(entity, 特記事項List, processPrm.get特記事項マスキング区分()));
                report.writeBy(tokkiText1A4SeparateReportSourceWriter);
            }
        }
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
    }

    private void set出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(認定調査票チェックフラグ);
        builder.append(get帳票発行有無(processPrm.is認定調査票出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(特記事項チェックフラグ);
        builder.append(get帳票発行有無(processPrm.is特記事項出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医意見書チェックフラグ);
        builder.append(get帳票発行有無(processPrm.is主治医意見書出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(その他資料チェックフラグ);
        builder.append(get帳票発行有無(processPrm.isその他資料出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(一次判定結果チェックフラグ);
        builder.append(get帳票発行有無(processPrm.is一次判定結果出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(総合事業開始区分);
        builder.append(get総合事業開始区分名称(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援)));
        出力条件.add(builder.toRString());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdDBE.DBE091003.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE091003.getReportId().value()),
                        new RString(String.valueOf(ninteiChosaTokkiImageReportSourceWriter.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }

    private RString get帳票発行有無(boolean 帳票発行フラグ) {
        if (帳票発行フラグ) {
            return 出力する;
        } else {
            return 出力しない;
        }
    }

    private RString get総合事業開始区分名称(RString 総合事業開始区分) {
        if (総合事業開始区分.equals(総合事業開始区分_未実施)) {
            return 総合事業未実施;
        } else if (総合事業開始区分.equals(総合事業開始区分_実施済)) {
            return 総合事業実施済;
        }
        return RString.EMPTY;
    }
}
