/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyotaku.ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyotaku.SakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuEntity;
import jp.co.ndensan.reams.db.dbc.service.core.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuCsvEntityEditor;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
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
 * 汎用リスト 居宅サービス計画Processクラスです。
 *
 * @reamsid_L DBC-3091-020 surun
 */
public class HanyoListKyotakuServiceKeikakuProcess extends BatchProcessBase<HanyoListKyotakuServiceKeikakuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistkyotakuservicekeikaku.IHanyoListKyotakuServiceKeikakuMapper.getCSVData");
    private static final RString CODE_1 = new RString("1");
    private static final RString CODE_2 = new RString("2");
    private static final RString CODE_3 = new RString("3");
    private static final RString CODE = new RString("0003");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC701001"));
    private static final ReportId EUC_ID = new ReportId("DBC701001");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString 日本語ファイル名 = new RString("汎用リスト 居宅サービス計画CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_KyotakuServiceKeikaku.csv");
    private static final RString CSV出力有無 = new RString("");
    private static final RString 構成市町村 = new RString("【構成市町村】");
    private static final RString 作成区分 = new RString("【作成区分】");
    private static final RString 抽出区分 = new RString("【抽出区分】");
    private static final RString 基準年月日 = new RString("【基準年月日】");
    private static final RString 支援事業者番号 = new RString("【支援事業者番号】");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSVNAME = new RString("HanyoList_KyotakuServiceKeikaku.csv");
    private HanyoListKyotakuServiceKeikakuProcessParameter parameter;
    private HanyoListKyotakuServiceKeikakuCsvEntityEditor csvEntityEditor;
    private Association 地方公共団体;
    private RDate システム日時;
    private RString 文字コード;
    private Encode ファイル文字コード;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private RString eucFilePath;
    private Decimal 連番;

    @BatchWriter
    private EucCsvWriter<HanyoListKyotakuServiceKeikakuCsvEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        連番 = Decimal.ONE;
        csvEntityEditor = new HanyoListKyotakuServiceKeikakuCsvEntityEditor();
        personalDataList = new ArrayList<>();

        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.直近レコード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        parameter.set宛名検索条件(searchKey);
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        システム日時 = RDate.getNowDate();
        文字コード = DbBusinessConifg.get(ConfigNameDBU.EUC共通_文字コード, システム日時, SubGyomuCode.DBU介護統計報告);
        if (CODE_1.equals(文字コード)) {
            ファイル文字コード = Encode.UTF_8withBOM;
        } else if (CODE_2.equals(文字コード)) {
            ファイル文字コード = Encode.SJIS;
        } else if (CODE_3.equals(文字コード)) {
            ファイル文字コード = Encode.JIS;
        } else {
            ファイル文字コード = Encode.UTF_8withBOM;
        }
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSVNAME);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(ファイル文字コード).
                setNewLine(NewLine.CRLF).
                hasHeader(parameter.isCsv項目名付加()).build();
    }

    @Override
    protected void process(HanyoListKyotakuServiceKeikakuEntity entity) {
        eucCsvWriter.writeLine(csvEntityEditor.editor(entity, parameter, 連番));
        連番 = 連番.add(Decimal.ONE);
        personalDataList.add(toPersonalData(entity));

    }

    private PersonalData toPersonalData(HanyoListKyotakuServiceKeikakuEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), new RString("被保険者番号"),
                entity.getDbT3005被保険者番号().value());
        return PersonalData.of(entity.get宛名Entity().getShikibetsuCode(), expandedInfo);
    }

    @Override
    protected void afterExecute() {
        AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLog);
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(構成市町村);
        RString 構成市町村コード = 左記号.concat(parameter.get構成市町村コード().getColumnValue()).concat(右記号);
        //TODOのNo.716 構成市町村名 ?
        builder.append(parameter.get構成市町村コード().isEmpty()
                ? RString.EMPTY : 構成市町村コード);
        出力条件.add(builder.toRString());
        builder = get作成区分();
        出力条件.add(builder.toRString());
        builder = get抽出区分();
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(基準年月日);
        builder.append(parameter.get基準年月日().isEmpty()
                ? RString.EMPTY : dataToRString(parameter.get基準年月日()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(支援事業者番号);
        builder.append(parameter.get支援事業者番号().isEmpty()
                ? RString.EMPTY : parameter.get支援事業者番号());
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
