/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShoriJokyo;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.KetteiJokyo;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.ShiharaiHoho;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.HanyoListShokanbaraiJokyoCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.hanyolistshokanbaraijokyo.HanyoListCsvDataCreate;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * 汎用リスト出力(償還払い状況)Process
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
public class HanyoListShokanbaraiJokyoProcess extends BatchProcessBase<HanyoListShokanbaraiJokyoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistshokanbaraijokyo.IHanyoListShokanbaraiJokyoMapper.getCSVData");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701002");
    private static final RString CSV出力有無 = new RString("");
    private static final RString ITEM = new RString("～");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　償還払い状況CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_ShokanbaraiJokyo.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CODE = new RString("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString CODE_1 = new RString("1");
    private static final RString CODE_2 = new RString("2");
    private static final RString CODE_3 = new RString("3");
    private static final RString 保険者 = new RString("【保険者】");
    private static final RString サービス提供年月 = new RString("【サービス提供年月】");
    private static final RString 処理状況 = new RString("【処理状況】");
    private static final RString 決定状況 = new RString("【決定状況】");
    private static final RString 支払方法 = new RString("【支払方法】");
    private static final RString 金融機関 = new RString("【金融機関】");
    private static final RString 申請日 = new RString("【申請日】");
    private static final RString 住宅改修支給届出日 = new RString("【住宅改修支給届出日】");
    private static final RString 決定日 = new RString("【決定日】");
    private static final RString 国保連送付年月 = new RString("【国保連送付年月】");
    private static final RString 様式番号 = new RString("【様式番号】");
    private static final RString すべて = new RString("すべて");
    private HanyoListShokanbaraiJokyoProcessParameter parameter;
    private HanyoListCsvDataCreate dataCreate;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private Association 地方公共団体;
    private HokenshaList 保険者リスト;
    private RString 文字コード;
    private Encode csv文字コード;
    private Decimal 連番;

    @BatchWriter
    private EucCsvWriter<HanyoListShokanbaraiJokyoCSVEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        連番 = Decimal.ONE;
        dataCreate = new HanyoListCsvDataCreate();
        personalDataList = new ArrayList<>();

        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        保険者リスト = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);

    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.直近レコード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        parameter.set宛名検索条件(searchKey);
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        RDate システム日時 = RDate.getNowDate();
        文字コード = DbBusinessConifg.get(ConfigNameDBU.EUC共通_文字コード, システム日時, SubGyomuCode.DBU介護統計報告);
        if (CODE_1.equals(文字コード)) {
            csv文字コード = Encode.UTF_8withBOM;
        } else if (CODE_2.equals(文字コード)) {
            csv文字コード = Encode.SJIS;
        } else if (CODE_3.equals(文字コード)) {
            csv文字コード = Encode.JIS;
        } else {
            csv文字コード = Encode.UTF_8withBOM;
        }

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 英数字ファイル名);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(csv文字コード).
                setNewLine(NewLine.CRLF).
                hasHeader(parameter.is項目名付加()).
                build();
    }

    @Override
    protected void process(HanyoListShokanbaraiJokyoEntity entity) {
        eucCsvWriter.writeLine(dataCreate.createCsvData(entity, parameter, 連番, 保険者リスト));
        連番 = 連番.add(Decimal.ONE);
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLog);
        バッチ出力条件リストの出力();
    }

    private PersonalData toPersonalData(HanyoListShokanbaraiJokyoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), 被保険者番号,
                entity.get被保険者番号().value());
        return PersonalData.of(entity.get宛名Entity().getShikibetsuCode(), expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        List<RString> 出力条件 = get出力条件();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
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

    private RString monthToRString(FlexibleYearMonth 日付) {
        if (日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
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

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(保険者);
        builder.append(parameter.get保険者コード() == null
                ? RString.EMPTY : parameter.get保険者コード().concat(parameter.get保険者名()));
        出力条件.add(builder.toRString());
        builder = get処理状況();
        出力条件.add(builder.toRString());
        builder = get決定状況();
        出力条件.add(builder.toRString());
        builder = get支払方法();
        出力条件.add(builder.toRString());
        builder = getサービス提供年月();
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(金融機関);
        builder.append(parameter.get金融機関コード() == null
                || parameter.get金融機関コード().isEmpty()
                ? RString.EMPTY : parameter.get金融機関コード().concat(parameter.get金融機関名称()));
        出力条件.add(builder.toRString());
        builder = get申請日();
        出力条件.add(builder.toRString());
        builder = get住宅改修支給届出日();
        出力条件.add(builder.toRString());
        builder = get決定日();
        出力条件.add(builder.toRString());
        builder = get国保連送付年月();
        出力条件.add(builder.toRString());
        builder = get様式番号();
        出力条件.add(builder.toRString());
        return 出力条件;
    }

    private RStringBuilder get処理状況() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(処理状況);
        RString shoriJokyo = RString.EMPTY;
        if (ShoriJokyo.すべて.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.すべて.get名称();
        } else if (ShoriJokyo.国保連決定取込済み.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.国保連決定取込済み.get名称();
        } else if (ShoriJokyo.国保連結果送付済み.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.国保連結果送付済み.get名称();
        } else if (ShoriJokyo.通知書発行済み.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.通知書発行済み.get名称();
        } else if (ShoriJokyo.振込明細発行済み.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.振込明細発行済み.get名称();
        } else if (ShoriJokyo.申請入力のみ.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.申請入力のみ.get名称();
        } else if (ShoriJokyo.支給不支給決定済み.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.支給不支給決定済み.get名称();
        } else if (ShoriJokyo.対象者で申請なし.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.支給不支給決定済み.get名称();
        }
        builder.append(shoriJokyo);
        return builder;
    }

    private RStringBuilder get決定状況() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(決定状況);
        RString ketteiJokyo = RString.EMPTY;
        if (KetteiJokyo.支給区分の判定を行わない.getコード().equals(parameter.get処理状況())) {
            ketteiJokyo = KetteiJokyo.支給区分の判定を行わない.get名称();
        } else if (KetteiJokyo.不支給決定されたデータのみ抽出.getコード().equals(parameter.get処理状況())) {
            ketteiJokyo = KetteiJokyo.不支給決定されたデータのみ抽出.get名称();
        } else if (KetteiJokyo.支給決定されたデータのみ抽出.getコード().equals(parameter.get処理状況())) {
            ketteiJokyo = KetteiJokyo.支給決定されたデータのみ抽出.get名称();
        }
        builder.append(ketteiJokyo);
        return builder;
    }

    private RStringBuilder get支払方法() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(支払方法);
        RString shiharaiHoho = RString.EMPTY;
        if (ShiharaiHoho.支払方法の判定を行わない.getコード().equals(parameter.get処理状況())) {
            shiharaiHoho = ShiharaiHoho.支払方法の判定を行わない.get名称();
        } else if (ShiharaiHoho.窓口払いのデータを抽出.getコード().equals(parameter.get処理状況())) {
            shiharaiHoho = ShiharaiHoho.窓口払いのデータを抽出.get名称();
        } else if (ShiharaiHoho.金融機関への振込データを抽出.getコード().equals(parameter.get処理状況())) {
            shiharaiHoho = ShiharaiHoho.金融機関への振込データを抽出.get名称();
        }
        builder.append(shiharaiHoho);
        return builder;
    }

    private RStringBuilder getサービス提供年月() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス提供年月);
        RString serviceTeikyoYM = RString.EMPTY;
        if (parameter.getサービス提供年月From() != null && parameter.getサービス提供年月To() != null) {
            serviceTeikyoYM = monthToRString(parameter.getサービス提供年月From())
                    .concat(ITEM)
                    .concat(monthToRString(parameter.getサービス提供年月To()));
        } else if (parameter.getサービス提供年月From() == null && parameter.getサービス提供年月To() != null) {
            serviceTeikyoYM = ITEM.concat(monthToRString(parameter.getサービス提供年月To()));
        } else if (parameter.getサービス提供年月From() != null && parameter.getサービス提供年月To() == null) {
            serviceTeikyoYM = monthToRString(parameter.getサービス提供年月From())
                    .concat(ITEM);
        }
        builder.append(serviceTeikyoYM);
        return builder;
    }

    private RStringBuilder get申請日() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(申請日);
        RString shinseiYMD = RString.EMPTY;
        if (parameter.get申請日From() != null && parameter.get申請日To() != null) {
            shinseiYMD = dataToRString(parameter.get申請日From())
                    .concat(ITEM)
                    .concat(dataToRString(parameter.get申請日To()));
        } else if (parameter.get申請日From() == null && parameter.get申請日To() != null) {
            shinseiYMD = ITEM.concat(dataToRString(parameter.get申請日To()));
        } else if (parameter.get申請日From() != null && parameter.get申請日To() == null) {
            shinseiYMD = dataToRString(parameter.get申請日From())
                    .concat(ITEM);
        }
        builder.append(shinseiYMD);
        return builder;
    }

    private RStringBuilder get住宅改修支給届出日() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(住宅改修支給届出日);
        RString kaishuYM = RString.EMPTY;
        if (parameter.get住宅改修支給届出日From() != null && parameter.get住宅改修支給届出日To() != null) {
            kaishuYM = dataToRString(parameter.get住宅改修支給届出日From())
                    .concat(ITEM)
                    .concat(dataToRString(parameter.get住宅改修支給届出日To()));
        } else if (parameter.get住宅改修支給届出日From() == null && parameter.get住宅改修支給届出日To() != null) {
            kaishuYM = ITEM.concat(dataToRString(parameter.get住宅改修支給届出日To()));
        } else if (parameter.get住宅改修支給届出日From() != null && parameter.get住宅改修支給届出日To() == null) {
            kaishuYM = dataToRString(parameter.get住宅改修支給届出日From())
                    .concat(ITEM);
        }
        builder.append(kaishuYM);
        return builder;
    }

    private RStringBuilder get決定日() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(決定日);
        RString ketteiYMD = RString.EMPTY;
        if (parameter.get決定日From() != null && parameter.get決定日To() != null) {
            ketteiYMD = dataToRString(parameter.get決定日From())
                    .concat(ITEM)
                    .concat(dataToRString(parameter.get決定日To()));
        } else if (parameter.get決定日From() == null && parameter.get決定日To() != null) {
            ketteiYMD = ITEM.concat(dataToRString(parameter.get決定日To()));
        } else if (parameter.get決定日From() != null && parameter.get決定日To() == null) {
            ketteiYMD = dataToRString(parameter.get決定日From())
                    .concat(ITEM);
        }
        builder.append(ketteiYMD);
        return builder;
    }

    private RStringBuilder get国保連送付年月() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(国保連送付年月);
        RString kokuhorenYM = RString.EMPTY;
        if (parameter.get国保連送付年月From() != null && parameter.get国保連送付年月To() != null) {
            kokuhorenYM = monthToRString(parameter.get国保連送付年月From())
                    .concat(ITEM)
                    .concat(monthToRString(parameter.get国保連送付年月To()));
        } else if (parameter.get国保連送付年月From() == null && parameter.get国保連送付年月To() != null) {
            kokuhorenYM = ITEM.concat(monthToRString(parameter.get国保連送付年月To()));
        } else if (parameter.get国保連送付年月From() != null && parameter.get国保連送付年月To() == null) {
            kokuhorenYM = monthToRString(parameter.get国保連送付年月From())
                    .concat(ITEM);
        }
        builder.append(kokuhorenYM);
        return builder;
    }

    private RStringBuilder get様式番号() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(様式番号);
        RString yoshikiNo = RString.EMPTY;
        if (CODE_1.equals(parameter.get様式番号選択())) {
            yoshikiNo = すべて;
        }
        builder.append(yoshikiNo);
        return builder;
    }

}
