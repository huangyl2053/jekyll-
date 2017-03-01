/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo02.NinteiChosaJohohyo02EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo12.NinteiChosaJohohyo12EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo22.NinteiChosaJohohyo22EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo32.NinteiChosaJohohyo32EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo42.NinteiChosaJohohyo42EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo52.NinteiChosaJohohyo52EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage.NinteiChosaTokkiImageEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1.ShujiiikenshoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo.SonoTashiryoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiImage1A4SeparateEditor;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiText1A4AllEditor;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiText1A4SeparateEditor;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiIchijihanteikekkahyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo02Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo12Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo22Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo32Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo42Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo52Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaTokkiImageReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiShujiiikenshoReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiSonoTashiryoReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiTokkiImage1A4SeparateReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiTokkiText1A4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujikensho.ShujiiikenshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.SonoTashiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki.YokaigoNinteiJohoTeikyoIsshikiReportSource;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
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
 * 一式出力プロセスです。
 *
 * @author N3212 竹内 和紀
 */
public class IsshikiPrintProcess extends BatchProcessBase<YokaigoNinteiJohoTeikyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");
    private YokaigoBatchProcessParamter processPrm;
    private YokaigoNinteiJohoTeikyoFinder finder;
    @BatchWriter
    private BatchReportWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> batchWrite;
    private ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter;

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
    private static final RString FILENAME_A_BAK = new RString("F1401A01_BAK.png");
    private static final RString FILENAME_A = new RString("F1401A01.png");
    private static final RString FILENAME_B_BAK = new RString("F1401B02_BAK.png");
    private static final RString FILENAME_B = new RString("F1401B02.png");
    private static final RString FILENAME_C_BAK = new RString("F1401C03_BAK.png");
    private static final RString FILENAME_C = new RString("F1401C03.png");
    private static final RString FILENAME_D_BAK = new RString("F1401D04_BAK.png");
    private static final RString FILENAME_D = new RString("F1401D04.png");
    private static final RString FILENAME_E_BAK = new RString("F1401E05_BAK.png");
    private static final RString FILENAME_E = new RString("F1401E05.png");
    private static final RString FILENAME_F_BAK = new RString("F1401F06_BAK.png");
    private static final RString FILENAME_F = new RString("F1401F06.png");
    private static final RString SEPARATOR = new RString("/");

    static {
        System.setProperty("java.awt.headless", "true");
    }

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
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE091101.getReportId().value())
                .addBreak(new BreakerCatalog<YokaigoNinteiJohoTeikyoIsshikiReportSource>().new SimpleLayoutBreaker(
                    YokaigoNinteiJohoTeikyoIsshikiReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<YokaigoNinteiJohoTeikyoIsshikiReportSource> occuredBreak(
                            ReportLineRecord<YokaigoNinteiJohoTeikyoIsshikiReportSource> currentRecord,
                            ReportLineRecord<YokaigoNinteiJohoTeikyoIsshikiReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                                int layout = currentRecord.getSource().layout;
                                currentRecord.setFormGroupIndex(layout);
                                if (nextRecord != null && nextRecord.getSource() != null) {
                                    layout = nextRecord.getSource().layout;
                                    nextRecord.setFormGroupIndex(layout);
                                }
                                return currentRecord;
                            }
                }).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(YokaigoNinteiJohoTeikyoEntity entity) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(entity.get申請書管理番号());
        List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List = finder.get認定調査票サービス状況(申請書管理番号);
        List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList = finder.get認定調査票サービス状況フラグ(申請書管理番号);
        List<NinteichosahyoChosaItem> 認定調査票調査項目List = finder.get認定調査票調査項目List(申請書管理番号);
        RDateTime イメージ共有ファイルID = finder.getイメージ共有ファイルID(申請書管理番号);
        if (processPrm.is認定調査票出力()) {
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List = finder.get認定調査票記入項目List(申請書管理番号);
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())
                    && 総合事業開始区分_実施済.equals(processPrm.get総合事業開始区分())) {
                NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                        = NinteiChosaJohohyo02EntityEditor.edit(
                                entity,
                                認定調査票サービス状況List,
                                認定調査票サービス状況フラグList,
                                認定調査票調査項目List,
                                認定調査票記入項目List,
                                イメージ共有ファイルID,
                                processPrm.get認定調査票マスキング区分());
                JohoTeikyoIsshikiNinteiChosaJohohyo02Report report
                        = new JohoTeikyoIsshikiNinteiChosaJohohyo02Report(ninteiChosaJohohyoEntity);
                report.writeBy(reportSourceWriter);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())
                    && 総合事業開始区分_未実施.equals(processPrm.get総合事業開始区分())) {
                NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                        = NinteiChosaJohohyo12EntityEditor.edit(
                                entity,
                                認定調査票サービス状況List,
                                認定調査票サービス状況フラグList,
                                認定調査票調査項目List,
                                認定調査票記入項目List,
                                イメージ共有ファイルID,
                                processPrm.get認定調査票マスキング区分());
                JohoTeikyoIsshikiNinteiChosaJohohyo12Report report
                        = new JohoTeikyoIsshikiNinteiChosaJohohyo12Report(ninteiChosaJohohyoEntity);
                report.writeBy(reportSourceWriter);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.get厚労省IF識別コード())) {
                NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                        = NinteiChosaJohohyo22EntityEditor.edit(
                                entity,
                                認定調査票サービス状況List,
                                認定調査票サービス状況フラグList,
                                認定調査票調査項目List,
                                認定調査票記入項目List,
                                イメージ共有ファイルID,
                                processPrm.get認定調査票マスキング区分());
                JohoTeikyoIsshikiNinteiChosaJohohyo22Report report
                        = new JohoTeikyoIsshikiNinteiChosaJohohyo22Report(ninteiChosaJohohyoEntity);
                report.writeBy(reportSourceWriter);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.get厚労省IF識別コード())) {
                NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                        = NinteiChosaJohohyo32EntityEditor.edit(
                                entity,
                                認定調査票サービス状況List,
                                認定調査票サービス状況フラグList,
                                認定調査票調査項目List,
                                認定調査票記入項目List,
                                イメージ共有ファイルID,
                                processPrm.get認定調査票マスキング区分());
                JohoTeikyoIsshikiNinteiChosaJohohyo32Report report
                        = new JohoTeikyoIsshikiNinteiChosaJohohyo32Report(ninteiChosaJohohyoEntity);
                report.writeBy(reportSourceWriter);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード())) {
                NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                        = NinteiChosaJohohyo42EntityEditor.edit(
                                entity,
                                認定調査票サービス状況List,
                                認定調査票サービス状況フラグList,
                                認定調査票調査項目List,
                                認定調査票記入項目List,
                                イメージ共有ファイルID,
                                processPrm.get認定調査票マスキング区分());
                JohoTeikyoIsshikiNinteiChosaJohohyo42Report report
                        = new JohoTeikyoIsshikiNinteiChosaJohohyo42Report(ninteiChosaJohohyoEntity);
                report.writeBy(reportSourceWriter);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード())) {
                NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                        = NinteiChosaJohohyo52EntityEditor.edit(
                                entity,
                                認定調査票サービス状況List,
                                認定調査票サービス状況フラグList,
                                認定調査票調査項目List,
                                認定調査票記入項目List,
                                イメージ共有ファイルID,
                                processPrm.get認定調査票マスキング区分());
                JohoTeikyoIsshikiNinteiChosaJohohyo52Report report
                        = new JohoTeikyoIsshikiNinteiChosaJohohyo52Report(ninteiChosaJohohyoEntity);
                report.writeBy(reportSourceWriter);
            }
        }

        if (processPrm.is特記事項出力()) {
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
                    JohoTeikyoIsshikiNinteiChosaTokkiImageReport report = new JohoTeikyoIsshikiNinteiChosaTokkiImageReport(
                            NinteiChosaTokkiImageEntityEditor.edit(entity, 特記事項List, processPrm.get特記事項マスキング区分()));
                    report.writeBy(reportSourceWriter);
                } else {
                    JohoTeikyoIsshikiTokkiImage1A4SeparateReport report = new JohoTeikyoIsshikiTokkiImage1A4SeparateReport(
                            TokkiImage1A4SeparateEditor.edit(entity, 特記事項List, processPrm.get特記事項マスキング区分(), イメージ共有ファイルID));
                    report.writeBy(reportSourceWriter);
                }
            } else if (特記事項区分List.contains(TokkijikoTextImageKubun.テキスト.getコード())) {
                if (すべて.equals(processPrm.get情報提供資料の特記事項編集パターン())) {
                    JohoTeikyoIsshikiTokkiText1A4Report report = new JohoTeikyoIsshikiTokkiText1A4Report(
                            TokkiText1A4AllEditor.edit(entity, 特記事項List, processPrm.get特記事項マスキング区分()),
                            processPrm.get情報提供資料の特記事項編集パターン());
                    report.writeBy(reportSourceWriter);
                } else {
                    JohoTeikyoIsshikiTokkiText1A4Report report = new JohoTeikyoIsshikiTokkiText1A4Report(
                            TokkiText1A4SeparateEditor.edit(entity, 特記事項List, processPrm.get特記事項マスキング区分()),
                            processPrm.get情報提供資料の特記事項編集パターン());
                    report.writeBy(reportSourceWriter);
                }
            }
        }

        if (processPrm.is主治医意見書出力()) {
            if (entity.is意見書同意フラグ()) {
                ShujiiikenshoEntity shujiiikenshoEntity
                        = ShujiiikenshoEntityEditor.edit(entity, イメージ共有ファイルID, processPrm.get主治医意見書マスキング区分());
                JohoTeikyoIsshikiShujiiikenshoReport report = new JohoTeikyoIsshikiShujiiikenshoReport(shujiiikenshoEntity);
                report.writeBy(reportSourceWriter);
            }
        }

        if (processPrm.isその他資料出力()) {
            if (イメージ共有ファイルID != null) {
                RString 共有フォルダ名 = entity.get保険者番号().concat(entity.get被保険者番号());
                ReadOnlySharedFileEntryDescriptor descriptor = get共有ファイルエントリ情報(共有フォルダ名, イメージ共有ファイルID);
                RString path = getFilePath(descriptor);
                RString イメージファイルパスA = getAイメージファイルパス(descriptor, path);
                if (!イメージファイルパスA.isEmpty()) {
                    SonoTashiryoEntity sonoTashiryoEntity = SonoTashiryoEntityEditor.edit(entity, イメージファイルパスA);
                    JohoTeikyoIsshikiSonoTashiryoReport report = new JohoTeikyoIsshikiSonoTashiryoReport(sonoTashiryoEntity);
                    report.writeBy(reportSourceWriter);
                }

                RString イメージファイルパスB = getBイメージファイルパス(descriptor, path);
                if (!イメージファイルパスB.isEmpty()) {
                    SonoTashiryoEntity sonoTashiryoEntity = SonoTashiryoEntityEditor.edit(entity, イメージファイルパスB);
                    JohoTeikyoIsshikiSonoTashiryoReport report = new JohoTeikyoIsshikiSonoTashiryoReport(sonoTashiryoEntity);
                    report.writeBy(reportSourceWriter);
                }

                RString イメージファイルパスC = getCイメージファイルパス(descriptor, path);
                if (!イメージファイルパスC.isEmpty()) {
                    SonoTashiryoEntity sonoTashiryoEntity = SonoTashiryoEntityEditor.edit(entity, イメージファイルパスC);
                    JohoTeikyoIsshikiSonoTashiryoReport report = new JohoTeikyoIsshikiSonoTashiryoReport(sonoTashiryoEntity);
                    report.writeBy(reportSourceWriter);
                }

                RString イメージファイルパスD = getDイメージファイルパス(descriptor, path);
                if (!イメージファイルパスD.isEmpty()) {
                    SonoTashiryoEntity sonoTashiryoEntity = SonoTashiryoEntityEditor.edit(entity, イメージファイルパスD);
                    JohoTeikyoIsshikiSonoTashiryoReport report = new JohoTeikyoIsshikiSonoTashiryoReport(sonoTashiryoEntity);
                    report.writeBy(reportSourceWriter);
                }

                RString イメージファイルパスE = getEイメージファイルパス(descriptor, path);
                if (!イメージファイルパスE.isEmpty()) {
                    SonoTashiryoEntity sonoTashiryoEntity = SonoTashiryoEntityEditor.edit(entity, イメージファイルパスE);
                    JohoTeikyoIsshikiSonoTashiryoReport report = new JohoTeikyoIsshikiSonoTashiryoReport(sonoTashiryoEntity);
                    report.writeBy(reportSourceWriter);
                }

                RString イメージファイルパスF = getFイメージファイルパス(descriptor, path);
                if (!イメージファイルパスF.isEmpty()) {
                    SonoTashiryoEntity sonoTashiryoEntity = SonoTashiryoEntityEditor.edit(entity, イメージファイルパスF);
                    JohoTeikyoIsshikiSonoTashiryoReport report = new JohoTeikyoIsshikiSonoTashiryoReport(sonoTashiryoEntity);
                    report.writeBy(reportSourceWriter);
                }
            }
        }

        if (processPrm.is一次判定結果出力()) {
            List<RString> 認定調査特記事項番号List = finder.get認定調査特記事項番号(申請書管理番号);
            List<NinteichosahyoChosaItem> 前回認定調査票調査項目List = finder.get前回認定調査票調査項目List(申請書管理番号);
            List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List = finder.get主治医意見書意見項目List(申請書管理番号);
            List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List = finder.get前回主治医意見書意見項目List(申請書管理番号);

            IchijihanteikekkahyoEntity ichijihanteikekkahyoEntity
                    = IchijihanteikekkahyoEntityEditor.edit(entity, 認定調査特記事項番号List, 認定調査票サービス状況List,
                            認定調査票サービス状況フラグList, 認定調査票調査項目List, 前回認定調査票調査項目List,
                            主治医意見書意見項目List, 前回主治医意見書意見項目List, processPrm.get正常選択肢印刷有無(),
                            processPrm.get認定調査前回結果印刷有無(), processPrm.get一次判定結果マスキング区分());
            JohoTeikyoIsshikiIchijihanteikekkahyoReport report
                    = new JohoTeikyoIsshikiIchijihanteikekkahyoReport(ichijihanteikekkahyoEntity);
            report.writeBy(reportSourceWriter);
        }
    }

    private RString getAイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path) {
        if (マスキングあり.equals(processPrm.getその他資料マスキング区分())) {
            RString fineFullPath = getFilePath(path, FILENAME_A);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_A_BAK)) ? FILENAME_A_BAK : FILENAME_A;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getBイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path) {
        if (マスキングあり.equals(processPrm.getその他資料マスキング区分())) {
            RString fineFullPath = getFilePath(path, FILENAME_B);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_B_BAK)) ? FILENAME_B_BAK : FILENAME_B;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getCイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path) {
        if (マスキングあり.equals(processPrm.getその他資料マスキング区分())) {
            RString fineFullPath = getFilePath(path, FILENAME_C);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_C_BAK)) ? FILENAME_C_BAK : FILENAME_C;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getDイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path) {
        if (マスキングあり.equals(processPrm.getその他資料マスキング区分())) {
            RString fineFullPath = getFilePath(path, FILENAME_D);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_D_BAK)) ? FILENAME_D_BAK : FILENAME_D;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getEイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path) {
        if (マスキングあり.equals(processPrm.getその他資料マスキング区分())) {
            RString fineFullPath = getFilePath(path, FILENAME_E);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_E_BAK)) ? FILENAME_E_BAK : FILENAME_E;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getFイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path) {
        if (マスキングあり.equals(processPrm.getその他資料マスキング区分())) {
            RString fineFullPath = getFilePath(path, FILENAME_F);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_F_BAK)) ? FILENAME_F_BAK : FILENAME_F;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private boolean existマスキングファイル(List<SharedFileEntryInfoEntity> entryInfoList, RString ファイル名) {
        for (SharedFileEntryInfoEntity entryInfo : entryInfoList) {
            if (entryInfo.getFilesEntity().getPathname().endsWith(ファイル名)) {
                return true;
            }
        }
        return false;
    }

    private ReadOnlySharedFileEntryDescriptor get共有ファイルエントリ情報(RString 共有フォルダ名, RDateTime イメージ共有ファイルID) {
        return new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有フォルダ名), イメージ共有ファイルID);
    }

    private RString getFilePath(ReadOnlySharedFileEntryDescriptor descriptor) {
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(batchWrite.getImageFolderPath())).getCanonicalPath());
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名);
        }
        return RString.EMPTY;
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
                        ReportIdDBE.DBE517181.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517181.getReportId().value()),
                        new RString(String.valueOf(reportSourceWriter.pageCount().value())),
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
