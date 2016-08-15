/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb022002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.processprm.hanyolistshotokujoho.HanyoListShotokuJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistshotokujoho.HanyoListShotokuJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistshotokujoho.HanyoListShotokuJohoNoRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbb.service.core.hanyolistshotokujoho.HanyoListShotokuJohoNoRenbanCsvEditor;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報NoRenbanProcessのクラス
 *
 * @reamsid_L DBB-1901-030 surun
 */
public class HanyoListShotokuJohoNoRenbanProcess extends BatchProcessBase<HanyoListShotokuJohoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "hanyolistshotokujoho.IHanyoListShotokuJohoMapper.getCSVData");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200034"));
    private static final RString 日本語ファイル名 = new RString("汎用リスト 所得情報CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_ShotokuJojo.csv");
    private static final RString CSVNAME = new RString("HanyoList_ShotokuJojo.csv");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 抽出条件 = new RString("【抽出条件】");
    private static final RString 賦課年度 = new RString("賦課年度：");
    private static final RString 課税区分 = new RString("課税区分：");
    private static final RString 定数_課税区分減免前 = new RString("課税区分（減免前）：");
    private static final RString 定数_課税区分減免後 = new RString("課税区分（減免後）：");
    private static final ReportId EUC_ID = new ReportId("DBB200034");
    private static final RString CSV出力有無 = new RString("");
    private static final RString CODE = new RString("0003");
    private static final RString 定数_年度 = new RString("年度");
    private static final RString 表示しない = new RString("0");
    private static final RString 課税TRUE = new RString("■課税  ");
    private static final RString 非課税TRUE = new RString("■非課税  ");
    private static final RString 未申告TRUE = new RString("■未申告  ");
    private static final RString 所得調査中TRUE = new RString("■所得調査中  ");
    private static final RString 課税取消TRUE = new RString("■課税取消  ");
    private static final RString 課税FALSE = new RString("□課税  ");
    private static final RString 非課税FALSE = new RString("□非課税  ");
    private static final RString 未申告FALSE = new RString("□未申告  ");
    private static final RString 所得調査中FALSE = new RString("□所得調査中  ");
    private static final RString 課税取消FALSE = new RString("□課税取消  ");
    private static final RString 定数_ONE = new RString("1");
    private static final RString 定数_TWO = new RString("2");
    private static final RString 定数_THREE = new RString("3");
    private static final RString 定数_FOUR = new RString("4");
    private static final RString 定数_FIVE = new RString("5");
    private static final RString 年齢SHOW = new RString("年齢：");
    private static final RString 年齢PARAMETER = new RString("年齢");
    private static final RString 年齢基準日SHOW = new RString("年齢基準日：");
    private static final RString 生年月日PARAMETER = new RString("生年月日");
    private static final RString 生年月日SHOW = new RString("生年月日：");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private static final RString LINE = new RString("　～　");
    private static final RString 定数_歳 = new RString("歳");
    private static final RString 定数_住所 = new RString("1");
    private static final RString 定数_行政区 = new RString("2");
    private static final RString 定数_地区 = new RString("3");
    private static final RString 住所SHOW = new RString("住所：");
    private static final RString 行政区SHOW = new RString("行政区：");
    private static final RString 地区1SHOW = new RString("地区1：");
    private static final RString 地区2SHOW = new RString("地区2：");
    private static final RString 地区3SHOW = new RString("地区3：");
    private static final RString 保険者SHOW = new RString("保険者：");
    private static final int INDEX_ZERO = 0;
    private HanyoListShotokuJohoNoRenbanCsvEditor csvEditor;
    private HanyoListShotokuJohoProcessParameter processParameter;
    private List<PersonalData> personalDataList;
    private HokenryoDankaiList 保険料段階リスト;
    List<KoseiShichosonMaster> 構成市町村マスタlist;
    private Association 地方公共団体;
    private FileSpoolManager manager;
    private YMDHMS システム日時;
    private RString eucFilePath;

    @BatchWriter
    private CsvWriter<HanyoListShotokuJohoNoRenbanCsvEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        システム日時 = YMDHMS.now();
        csvEditor = new HanyoListShotokuJohoNoRenbanCsvEditor();
        personalDataList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        HokenryoDankaiSettings hokenryoDankaiSettings = HokenryoDankaiSettings.createInstance();
        保険料段階リスト = hokenryoDankaiSettings.get保険料段階ListIn(processParameter.get賦課年度());
        構成市町村マスタlist = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.直近レコード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        processParameter.set宛名検索条件(searchKey);
        return new BatchDbReader(READ_DATA_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSVNAME);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(processParameter.is項目名付加()).build();
    }

    @Override
    protected void process(HanyoListShotokuJohoEntity entity) {
        eucCsvWriter.writeLine(csvEditor.editor(entity, processParameter, 保険料段階リスト, 構成市町村マスタlist));
        personalDataList.add(toPersonalData(entity));
    }

    private PersonalData toPersonalData(HanyoListShotokuJohoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), 定数_被保険者番号,
                entity.getDbv1001被保険者番号().value());
        return PersonalData.of(entity.get宛名Entity().getShikibetsuCode(), expandedInfo);
    }

    @Override
    protected void afterExecute() {
        if ((personalDataList == null || personalDataList.isEmpty()) && processParameter.is項目名付加()) {
            eucCsvWriter.writeLine(new HanyoListShotokuJohoNoRenbanCsvEntity());
        }
        eucCsvWriter.close();
        if (personalDataList == null || personalDataList.isEmpty()) {
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        } else {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath, accessLog);
        }
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder1 = new RStringBuilder();
        builder1.append(抽出条件);
        出力条件.add(builder1.toRString());
        RStringBuilder builder2 = new RStringBuilder();
        builder2.append(賦課年度);
        FlexibleYear 賦課年度2 = processParameter.get賦課年度();
        if (賦課年度2 != null && !賦課年度2.isEmpty()) {
            builder2.append(賦課年度2.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK)
                    .toDateString()).append(定数_年度);
        } else {
            builder2.append(RString.EMPTY);
        }
        出力条件.add(builder2.toRString());
        出力条件.add(RString.EMPTY);
        RStringBuilder builder4 = new RStringBuilder();
        List<RString> 課税区分減免前list = processParameter.get課税区分減免前s();
        if (表示しない.equals(processParameter.get住民税減免前後表示区分())) {
            builder4.append(課税区分);
        } else {
            builder4.append(定数_課税区分減免前);
        }
        set課税区分前後(builder4, 課税区分減免前list);
        出力条件.add(builder4.toRString());
        出力条件.add(RString.EMPTY);
        RStringBuilder builder6 = new RStringBuilder();
        List<RString> 課税区分減免後list = processParameter.get課税区分減免後s();
        if (表示しない.equals(processParameter.get住民税減免前後表示区分())) {
            出力条件.add(RString.EMPTY);
        } else {
            builder6.append(定数_課税区分減免後);
            set課税区分前後(builder6, 課税区分減免後list);
            出力条件.add(builder6.toRString());
        }
        出力条件.add(RString.EMPTY);
        RStringBuilder builder8 = new RStringBuilder();
        set年齢層抽出方法(builder8, 出力条件);
        RStringBuilder builder9 = new RStringBuilder();
        set地区区分(builder9, 出力条件);
        RStringBuilder builder10 = new RStringBuilder();
        KaigoDonyuKeitaiManager manager = KaigoDonyuKeitaiManager.createInstance();
        List<KaigoDonyuKeitai> list = manager.get介護導入形態By業務分類(GyomuBunrui.介護事務);
        if (list.get(INDEX_ZERO).get導入形態コード().is広域()) {
            builder10.append(保険者SHOW);
            //TODO パラメータ.宛名抽出条件.保険者
            builder10.append(RString.EMPTY);
            出力条件.add(builder10.toRString());
        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ID.value(),
                導入団体コード,
                市町村名,
                new RString(String.valueOf(JobContextHolder.getJobId())),
                日本語ファイル名,
                出力件数,
                CSV出力有無,
                英数字ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void set地区区分(RStringBuilder builder, List<RString> 出力条件) {
        if (processParameter != null && processParameter.get宛名抽出条件() != null
                && processParameter.get宛名抽出条件().getChiku_Kubun() != null) {
            RString 地区区分名称 = processParameter.get宛名抽出条件().getChiku_Kubun().getコード();
            if (定数_住所.equals(地区区分名称)) {
                builder.append(住所SHOW);
                RString 町域From = processParameter.get宛名抽出条件().getJusho_From();
                RString 町域To = processParameter.get宛名抽出条件().getJusho_To();
                builder.append(町域From).append(LINE).append(町域To);
                出力条件.add(builder.toRString());
            } else if (定数_行政区.equals(地区区分名称)) {
                builder.append(行政区SHOW);
                RString 行政区From = processParameter.get宛名抽出条件().getGyoseiku_From();
                RString 行政区To = processParameter.get宛名抽出条件().getGyoseiku_To();
                builder.append(行政区From).append(LINE).append(行政区To);
                出力条件.add(builder.toRString());
            } else if (定数_地区.equals(地区区分名称)) {
                RStringBuilder builder1 = new RStringBuilder();
                builder1.append(地区1SHOW);
                RString 地区１From = processParameter.get宛名抽出条件().getChiku1_From();
                RString 地区１To = processParameter.get宛名抽出条件().getChiku1_To();
                builder1.append(地区１From).append(LINE).append(地区１To);
                出力条件.add(builder1.toRString());
                RStringBuilder builder2 = new RStringBuilder();
                builder2.append(地区2SHOW);
                RString 地区2From = processParameter.get宛名抽出条件().getChiku2_From();
                RString 地区2To = processParameter.get宛名抽出条件().getChiku2_To();
                builder2.append(地区2From).append(LINE).append(地区2To);
                出力条件.add(builder2.toRString());
                RStringBuilder builder3 = new RStringBuilder();
                builder3.append(地区3SHOW);
                RString 地区3From = processParameter.get宛名抽出条件().getChiku3_From();
                RString 地区3To = processParameter.get宛名抽出条件().getChiku3_To();
                builder3.append(地区3From).append(LINE).append(地区3To);
                出力条件.add(builder3.toRString());
            }
        }
    }

    private void set年齢層抽出方法(RStringBuilder builder, List<RString> 出力条件) {
        if (年齢PARAMETER.equals(processParameter.get宛名抽出条件().getAgeSelectKijun().get名称())) {
            builder.append(年齢SHOW);
            if (processParameter.get宛名抽出条件().getNenreiRange() != null) {
                set年齢(builder);
            } else {
                builder.append(RString.FULL_SPACE);
            }
            builder.append(左記号).append(年齢基準日SHOW);
            RDate 年齢基準日 = processParameter.get宛名抽出条件().getNenreiKijunbi();
            if (年齢基準日 != null) {
                RString 変数_年齢基準日 = 年齢基準日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString();
                builder.append(変数_年齢基準日).append(右記号);
            } else {
                builder.append(RString.FULL_SPACE).append(右記号);
            }
            出力条件.add(builder.toRString());
        } else if (生年月日PARAMETER.equals(processParameter.get宛名抽出条件().getAgeSelectKijun().get名称())) {
            builder.append(生年月日SHOW);
            if (processParameter.get宛名抽出条件().getSeinengappiRange() != null) {
                set生年月日(builder);
            } else {
                builder.append(RString.EMPTY);
            }
            出力条件.add(builder.toRString());
        }
    }

    private void set年齢(RStringBuilder builder) {
        Decimal 年齢From = processParameter.get宛名抽出条件().getNenreiRange().getFrom();
        Decimal 年齢To = processParameter.get宛名抽出条件().getNenreiRange().getTo();
        RString 変数_年齢From = null;
        RString 変数_年齢To = null;
        if (年齢From != null) {
            変数_年齢From = new RString(年齢From.toString());
        }
        if (年齢To != null) {
            変数_年齢To = new RString(年齢To.toString());
        }
        builder.append(変数_年齢From).append(定数_歳).append(LINE).
                append(変数_年齢To).append(定数_歳).append(RString.FULL_SPACE);
    }

    private void set生年月日(RStringBuilder builder) {
        RDate 生年月日From = processParameter.get宛名抽出条件().getSeinengappiRange().getFrom();
        RDate 生年月日To = processParameter.get宛名抽出条件().getSeinengappiRange().getTo();
        RString 変数_生年月日From = null;
        RString 変数_生年月日To = null;
        if (生年月日From != null) {
            変数_生年月日From = 生年月日From.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        if (生年月日To != null) {
            変数_生年月日To = 生年月日To.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        builder.append(変数_生年月日From).append(LINE).append(変数_生年月日To);
    }

    private void set課税区分前後(RStringBuilder builder, List<RString> list) {
        if (list.contains(定数_ONE)) {
            builder.append(課税TRUE);
        } else {
            builder.append(課税FALSE);
        }
        if (list.contains(定数_TWO)) {
            builder.append(非課税TRUE);
        } else {
            builder.append(非課税FALSE);
        }
        if (list.contains(定数_THREE)) {
            builder.append(未申告TRUE);
        } else {
            builder.append(未申告FALSE);
        }
        if (list.contains(定数_FOUR)) {
            builder.append(所得調査中TRUE);
        } else {
            builder.append(所得調査中FALSE);
        }
        if (list.contains(定数_FIVE)) {
            builder.append(課税取消TRUE);
        } else {
            builder.append(課税取消FALSE);
        }
    }
}
