/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyotaku.ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyotaku.SakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuKijunYMDParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistkyotakuservicekeikaku.IHanyoListKyotakuServiceKeikakuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuCsvEntityEditor;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
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
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 汎用リスト 居宅サービス計画Processクラスです。
 *
 * @reamsid_L DBC-3091-020 surun
 */
public class HanyoListKyotakuServiceKeikakuProcess extends BatchProcessBase<HanyoListKyotakuServiceKeikakuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistkyotakuservicekeikaku.IHanyoListKyotakuServiceKeikakuMapper.getCSVData");
    private static final RString CODE = new RString("0003");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC701001"));
    private static final ReportId EUC_ID = new ReportId("DBC701001");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString 日本語ファイル名 = new RString("汎用リスト 居宅サービス計画CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_KyotakuServiceKeikaku.csv");
    private static final RString CSV出力有無 = new RString("");
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 構成市町村 = new RString("構成市町村：");
    private static final RString 作成区分 = new RString("作成区分：");
    private static final RString 抽出区分 = new RString("抽出区分：");
    private static final RString 基準年月日 = new RString("基準年月日：");
    private static final RString 支援事業者番号 = new RString("支援事業者番号：");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSVNAME = new RString("HanyoList_KyotakuServiceKeikaku.csv");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private HanyoListKyotakuServiceKeikakuProcessParameter parameter;
    private HanyoListKyotakuServiceKeikakuCsvEntityEditor csvEntityEditor;
    private Association 地方公共団体;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private RString eucFilePath;
    private Decimal 連番;
    private FlexibleDate システム日付;
    private final MapperProvider mapperProvider = InstanceProvider.create(MapperProvider.class);
    private IHanyoListKyotakuServiceKeikakuMapper mapper;

    @BatchWriter
    private EucCsvWriter<HanyoListKyotakuServiceKeikakuCsvEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        連番 = Decimal.ONE;
        システム日付 = FlexibleDate.getNowDate();
        csvEntityEditor = new HanyoListKyotakuServiceKeikakuCsvEntityEditor(システム日付);
        personalDataList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<ShikibetsuCode> list = new ArrayList<>();
        builder.set識別コードリスト(list);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        parameter.set宛名検索条件(searchKey);
//        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        mapper = mapperProvider.create(IHanyoListKyotakuServiceKeikakuMapper.class);
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSVNAME);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(parameter.isCsv項目名付加()).build();
    }

    @Override
    protected void process(HanyoListKyotakuServiceKeikakuEntity entity) {

        if (parameter.get抽出区分().compareTo("2") == 0 && parameter.get基準年月日() != null && !parameter.get基準年月日().isEmpty()) {
            HanyoListKyotakuServiceKeikakuKijunYMDParameter param
                    = new HanyoListKyotakuServiceKeikakuKijunYMDParameter(entity.getDbT3005被保険者番号(), entity.getDbT3005対象年月(), parameter.get基準年月日());
            int kijunYMDDate = mapper.getKijunYMDData(param);
            if (kijunYMDDate == 0) {
                eucCsvWriter.writeLine(csvEntityEditor.editor(entity, parameter, 連番));
                連番 = 連番.add(Decimal.ONE);
                personalDataList.add(toPersonalData(entity));
            }
        } else {
            eucCsvWriter.writeLine(csvEntityEditor.editor(entity, parameter, 連番));
            連番 = 連番.add(Decimal.ONE);
            personalDataList.add(toPersonalData(entity));
        }
    
    }

    private PersonalData toPersonalData(HanyoListKyotakuServiceKeikakuEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), 定数_被保険者番号,
                entity.getDbV1001被保険者番号().value());
        return PersonalData.of(entity.get宛名Entity().getShikibetsuCode(), expandedInfo);
    }

    @Override
    protected void afterExecute() {
        if ((personalDataList == null || personalDataList.isEmpty()) && parameter.isCsv項目名付加()) {
            eucCsvWriter.writeLine(new HanyoListKyotakuServiceKeikakuCsvEntity());
        }
        eucCsvWriter.close();
        if (personalDataList == null || personalDataList.isEmpty()) {
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        } else {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLog);
        }
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出対象者);
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(構成市町村);
        LasdecCode lasdecCode = parameter.get構成市町村コード();
        if (lasdecCode != null && !lasdecCode.isEmpty()) {
            RString 構成市町村コード = 左記号.concat(lasdecCode.getColumnValue()).concat(右記号);
            HokenshaList hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
            HokenshaSummary hokenshaSummary = hokenshaList.get(lasdecCode);
            RString 構成市町村名 = hokenshaSummary == null ? RString.EMPTY : hokenshaSummary.get市町村名称();
            builder.append(構成市町村コード).append(構成市町村名);
        } else {
            builder.append(RString.EMPTY);
        }
        出力条件.add(builder.toRString());
        builder = get作成区分();
        出力条件.add(builder.toRString());
        builder = get抽出区分();
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(基準年月日);
        FlexibleDate flexibleDate = parameter.get基準年月日();
        builder.append(flexibleDate == null || flexibleDate.isEmpty()
                ? null : dataToRString(flexibleDate));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(支援事業者番号);
        builder.append(parameter.get支援事業者番号() == null || parameter.get支援事業者番号().isEmpty()
                ? null : parameter.get支援事業者番号());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号.concat(String.valueOf(JobContextHolder.getJobId())),
                日本語ファイル名,
                出力件数,
                CSV出力有無,
                英数字ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private RString dataToRString(FlexibleDate 日付) {
        if (日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }

    private RStringBuilder get作成区分() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(作成区分);
        RString sakuseiKubun = RString.EMPTY;
        if (SakuseiKubun.すべて.getコード().equals(parameter.get作成区分())) {
            sakuseiKubun = SakuseiKubun.すべて.get名称();
        } else if (SakuseiKubun.居宅支援のみ.getコード().equals(parameter.get作成区分())) {
            sakuseiKubun = SakuseiKubun.居宅支援のみ.get名称();
        } else if (SakuseiKubun.基準該当のみ.getコード().equals(parameter.get作成区分())) {
            sakuseiKubun = SakuseiKubun.基準該当のみ.get名称();
        } else if (SakuseiKubun.居宅支援_基準該当のみ.getコード().equals(parameter.get作成区分())) {
            sakuseiKubun = SakuseiKubun.居宅支援_基準該当のみ.get名称();
        } else if (SakuseiKubun.自己作成のみ.getコード().equals(parameter.get作成区分())) {
            sakuseiKubun = SakuseiKubun.自己作成のみ.get名称();
        } else if (SakuseiKubun.予防支援のみ.getコード().equals(parameter.get作成区分())) {
            sakuseiKubun = SakuseiKubun.予防支援のみ.get名称();
        }
        builder.append(sakuseiKubun);
        return builder;
    }

    private RStringBuilder get抽出区分() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出区分);
        RString chushutsuKubun = RString.EMPTY;
        if (ChushutsuKubun.全データ.getコード().equals(parameter.get抽出区分())) {
            chushutsuKubun = ChushutsuKubun.全データ.get名称();
        } else if (ChushutsuKubun.直近有効データ.getコード().equals(parameter.get抽出区分())) {
            chushutsuKubun = ChushutsuKubun.直近有効データ.get名称();
        } else if (ChushutsuKubun.全有効データ.getコード().equals(parameter.get抽出区分())) {
            chushutsuKubun = ChushutsuKubun.全有効データ.get名称();
        }
        builder.append(chushutsuKubun);
        return builder;
    }

}
