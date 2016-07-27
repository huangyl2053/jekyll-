/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.KetteiJokyo;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.ShiharaiHoho;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.ShoriJokyo;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.HanyoListShokanbaraiJokyoNoRenbanCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.hanyolistshokanbaraijokyo.HanyoListCsvNoRenbanDataCreate;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
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
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 汎用リスト出力(償還払い状況)Process
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
public class HanyoListShokanbaraiJokyoNoRenbanProcess extends BatchProcessBase<HanyoListShokanbaraiJokyoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistshokanbaraijokyo.IHanyoListShokanbaraiJokyoMapper.getCSVData");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701002");
    private static final RString CSV出力有無 = new RString("");
    private static final RString ITEM = new RString("～");
//    private static final RString SPLIT = new RString("|");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　償還払い状況CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_ShokanbaraiJokyo.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final Code CODE = new Code("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString CODE_1 = new RString("1");
    private static final int INDEX_15 = 15;
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 保険者 = new RString("保険者：");
    private static final RString サービス提供年月 = new RString("サービス提供年月：");
    private static final RString 処理状況 = new RString("処理状況：");
    private static final RString 決定状況 = new RString("決定状況：");
    private static final RString 支払方法 = new RString("支払方法：");
    private static final RString 金融機関 = new RString("金融機関：");
    private static final RString 申請日 = new RString("申請日：");
    private static final RString 住宅改修支給届出日 = new RString("住宅改修支給届出日：");
    private static final RString 決定日 = new RString("決定日：");
    private static final RString 国保連送付年月 = new RString("国保連送付年月：");
    private static final RString 様式番号 = new RString("様式番号：");
    private static final RString すべて = new RString("すべて");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private HanyoListShokanbaraiJokyoProcessParameter parameter;
    private HanyoListCsvNoRenbanDataCreate dataCreate;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private Association 地方公共団体;
    private FlexibleDate システム日付;
//    private RString preBreakKey;
//    private HanyoListShokanbaraiJokyoEntity preEntity;
//    private Map<RString, Object> mapFlag;
//    private List<DbT3038ShokanKihonEntity> lstDbt3038List;
//    private List<KinyuKikanEntity> lstKinyuKikanEntity;

    @BatchWriter
    private EucCsvWriter<HanyoListShokanbaraiJokyoNoRenbanCSVEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
//        preBreakKey = RString.EMPTY;
        システム日付 = FlexibleDate.getNowDate();
        dataCreate = new HanyoListCsvNoRenbanDataCreate(システム日付);
        personalDataList = new ArrayList<>();
//        mapFlag = new HashMap<>();
//        lstDbt3038List = new ArrayList<>();
//        lstKinyuKikanEntity = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

    }

    @Override
    protected IBatchReader createReader() {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBC介護給付);
        builder.set業務コード(GyomuCode.DB介護保険);
        IKozaSearchKey searchKey = builder.build();
        parameter.setSearchkey(searchKey);
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(parameter.getReamsLoginId());
        parameter.setList(list);
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 英数字ファイル名);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8).
                setNewLine(NewLine.CRLF).
                hasHeader(parameter.is項目名付加()).
                build();
    }

    @Override
    protected void process(HanyoListShokanbaraiJokyoEntity entity) {
        eucCsvWriter.writeLine(dataCreate.createCsvData(entity, parameter));
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLog);
        バッチ出力条件リストの出力();
    }

    /*
     @Override
     protected void process(HanyoListShokanbaraiJokyoEntity entity) {
     RString nowBreakKey = RString.EMPTY;
     if (entity.get支給申請Entity() != null) {
     HihokenshaNo hihokenshaNo = entity.get支給申請Entity().getHiHokenshaNo();
     FlexibleYearMonth serviceTeikyoYM = entity.get支給申請Entity().getServiceTeikyoYM();
     JigyoshaNo shinseiJigyoshaNo = entity.get支給申請Entity().getShinseiJigyoshaNo();
     if (hihokenshaNo != null && serviceTeikyoYM != null && shinseiJigyoshaNo != null) {
     nowBreakKey = hihokenshaNo.value().concat(SPLIT)
     .concat(serviceTeikyoYM.toDateString()).concat(SPLIT)
     .concat(entity.get支給申請Entity().getSeiriNo()).concat(SPLIT)
     .concat(shinseiJigyoshaNo.value());
     }
     }

     if (RString.EMPTY.equals(preBreakKey) || preBreakKey.equals(nowBreakKey)) {
     preBreakKey = nowBreakKey;
     RString key3038 = RString.EMPTY;
     if (entity.get請求基本List() != null && !entity.get請求基本List().isEmpty()) {
     key3038 = nowBreakKey.concat(SPLIT).concat(entity.get請求基本List().get(0).getYoshikiNo())
     .concat(SPLIT).concat(entity.get請求基本List().get(0).getMeisaiNo());
     }
     mapFlag.put(key3038, true);
     lstDbt3038List.addAll(entity.get請求基本List());
     if (entity.get口座情報Entity() != null) {
     lstKinyuKikanEntity.addAll(entity.get口座情報Entity().getKinyuKikanEntity());
     }
     preEntity = entity;
     return;
     }
     if (!preBreakKey.equals(nowBreakKey)) {
     preEntity.get請求基本List().clear();
     preEntity.get請求基本List().addAll(lstDbt3038List);
     List<UaT0301YokinShubetsuPatternEntity> lstUat0301Entity = new ArrayList<>();

     for (KinyuKikanEntity kinyuKikanEntity : lstKinyuKikanEntity) {
     lstUat0301Entity.addAll(kinyuKikanEntity.get預金種別パターンEntity());
     }
     for (KinyuKikanEntity kinyuKikanEntity : lstKinyuKikanEntity) {
     kinyuKikanEntity.get預金種別パターンEntity().addAll(lstUat0301Entity);
     preEntity.get口座情報Entity().getKinyuKikanEntity().add(kinyuKikanEntity);
     }
     eucCsvWriter.writeLine(dataCreate.createCsvData(preEntity, parameter));
     personalDataList.add(toPersonalData(preEntity));
     lstDbt3038List.clear();
     lstDbt3038List.addAll(entity.get請求基本List());
     lstKinyuKikanEntity.clear();
     if (entity.get口座情報Entity() != null) {
     lstKinyuKikanEntity.addAll(entity.get口座情報Entity().getKinyuKikanEntity());
     }
     }
     preBreakKey = nowBreakKey;
     preEntity = entity;
     }

     @Override
     protected void afterExecute() {
     if (preEntity == null && parameter.is項目名付加()) {
     eucCsvWriter.writeLine(new HanyoListShokanbaraiJokyoNoRenbanCSVEntity());
     }
     if (preEntity != null && preEntity.get請求基本List() != null && !preEntity.get請求基本List().isEmpty()) {
     preEntity.get請求基本List().clear();
     preEntity.get請求基本List().addAll(lstDbt3038List);
     }
     List<UaT0301YokinShubetsuPatternEntity> lstUat0301Entity = new ArrayList<>();

     for (KinyuKikanEntity kinyuKikanEntity : lstKinyuKikanEntity) {
     lstUat0301Entity.addAll(kinyuKikanEntity.get預金種別パターンEntity());
     }
     for (KinyuKikanEntity kinyuKikanEntity : lstKinyuKikanEntity) {
     kinyuKikanEntity.get預金種別パターンEntity().addAll(lstUat0301Entity);
     preEntity.get口座情報Entity().getKinyuKikanEntity().add(kinyuKikanEntity);
     }
     if (preEntity != null) {
     eucCsvWriter.writeLine(dataCreate.createCsvData(preEntity, parameter));
     personalDataList.add(toPersonalData(preEntity));
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
     */
    private PersonalData toPersonalData(HanyoListShokanbaraiJokyoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(CODE, 被保険者番号,
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
        builder.append(抽出対象者);
        出力条件.add(builder.toRString());
        builder = get保険者名();
        出力条件.add(builder.toRString());
        builder = get処理状況();
        出力条件.add(builder.toRString());
        builder = get決定状況();
        出力条件.add(builder.toRString());
        builder = get支払方法();
        出力条件.add(builder.toRString());
        builder = getサービス提供年月();
        出力条件.add(builder.toRString());
        builder = get金融機関();
        出力条件.add(builder.toRString());
        builder = get申請日();
        出力条件.add(builder.toRString());
        builder = get住宅改修支給届出日();
        出力条件.add(builder.toRString());
        builder = get決定日();
        出力条件.add(builder.toRString());
        builder = get国保連送付年月();
        出力条件.add(builder.toRString());
        List<RStringBuilder> 様式番号List = get様式番号(parameter.get様式番号());
        for (RStringBuilder 番号 : 様式番号List) {
            出力条件.add(番号.toRString());
        }
        return 出力条件;
    }

    private RStringBuilder get保険者名() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(保険者);
        if (parameter.get保険者コード() == null || parameter.get保険者コード().isEmpty()) {
            return builder;
        }
        builder.append(parameter.get保険者コード() == null || parameter.get保険者コード().isEmpty()
                ? RString.EMPTY : 左記号.concat(parameter.get保険者コード())
                .concat(右記号).concat(parameter.get保険者名()));
        return builder;
    }

    private RStringBuilder get金融機関() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(金融機関);
        if (parameter.get金融機関コード() == null || parameter.get金融機関コード().isEmpty()) {
            return builder;
        }
        builder.append(parameter.get金融機関コード() == null || parameter.get金融機関コード().isEmpty()
                ? RString.EMPTY : 左記号.concat(parameter.get金融機関コード())
                .concat(右記号).concat(parameter.get金融機関名称()));
        return builder;
    }

    private RStringBuilder get処理状況() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(処理状況);
        RString shoriJokyo = RString.EMPTY;
        if (ShoriJokyo.すべて.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.すべて.get名称();
        } else if (ShoriJokyo.不給不支給決定済.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.不給不支給決定済.get名称();
        } else if (ShoriJokyo.国保連送付済.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.国保連送付済.get名称();
        } else if (ShoriJokyo.振込明細発行済.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.振込明細発行済.get名称();
        } else if (ShoriJokyo.申請入力.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.申請入力.get名称();
        } else if (ShoriJokyo.通知書発行済.getコード().equals(parameter.get処理状況())) {
            shoriJokyo = ShoriJokyo.通知書発行済.get名称();
        }
        builder.append(shoriJokyo);
        return builder;
    }

    private RStringBuilder get決定状況() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(決定状況);
        RString ketteiJokyo = RString.EMPTY;
        if (KetteiJokyo.支給区分の判定を行わない.getコード().equals(parameter.get決定情報())) {
            ketteiJokyo = KetteiJokyo.支給区分の判定を行わない.get名称();
        } else if (KetteiJokyo.不支給決定されたデータのみ抽出.getコード().equals(parameter.get決定情報())) {
            ketteiJokyo = KetteiJokyo.不支給決定されたデータのみ抽出.get名称();
        } else if (KetteiJokyo.支給決定されたデータのみ抽出.getコード().equals(parameter.get決定情報())) {
            ketteiJokyo = KetteiJokyo.支給決定されたデータのみ抽出.get名称();
        }
        builder.append(ketteiJokyo);
        return builder;
    }

    private RStringBuilder get支払方法() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(支払方法);
        RString shiharaiHoho = RString.EMPTY;
        if (ShiharaiHoho.支払方法の判定を行わない.getコード().equals(parameter.get支払方法())) {
            shiharaiHoho = ShiharaiHoho.支払方法の判定を行わない.get名称();
        } else if (ShiharaiHoho.窓口払いのデータを抽出.getコード().equals(parameter.get支払方法())) {
            shiharaiHoho = ShiharaiHoho.窓口払いのデータを抽出.get名称();
        } else if (ShiharaiHoho.金融機関への振込データを抽出.getコード().equals(parameter.get支払方法())) {
            shiharaiHoho = ShiharaiHoho.金融機関への振込データを抽出.get名称();
        }
        builder.append(shiharaiHoho);
        return builder;
    }

    private RStringBuilder getサービス提供年月() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス提供年月);
        RString serviceTeikyoYM = RString.EMPTY;
        if ((parameter.getサービス提供年月From() == null || parameter.getサービス提供年月From().isEmpty())
                && (parameter.getサービス提供年月To() == null || parameter.getサービス提供年月To().isEmpty())) {
            return builder;
        }
        serviceTeikyoYM = monthToRString(parameter.getサービス提供年月From())
                .concat(ITEM)
                .concat(monthToRString(parameter.getサービス提供年月To()));
        builder.append(serviceTeikyoYM);
        return builder;
    }

    private RStringBuilder get申請日() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(申請日);
        RString shinseiYMD = RString.EMPTY;
        if ((parameter.get申請日From() == null || parameter.get申請日From().isEmpty())
                && (parameter.get申請日To() == null || parameter.get申請日To().isEmpty())) {
            return builder;
        }
        shinseiYMD = dataToRString(parameter.get申請日From())
                .concat(ITEM)
                .concat(dataToRString(parameter.get申請日To()));
        builder.append(shinseiYMD);
        return builder;
    }

    private RStringBuilder get住宅改修支給届出日() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(住宅改修支給届出日);
        RString kaishuYM = RString.EMPTY;
        if ((parameter.get住宅改修支給届出日From() == null || parameter.get住宅改修支給届出日From().isEmpty())
                && (parameter.get住宅改修支給届出日To() == null || parameter.get住宅改修支給届出日To().isEmpty())) {
            return builder;
        }
        kaishuYM = dataToRString(parameter.get住宅改修支給届出日From())
                .concat(ITEM)
                .concat(dataToRString(parameter.get住宅改修支給届出日To()));
        builder.append(kaishuYM);
        return builder;
    }

    private RStringBuilder get決定日() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(決定日);
        RString ketteiYMD = RString.EMPTY;
        if ((parameter.get決定日From() == null || parameter.get決定日From().isEmpty())
                && (parameter.get決定日To() == null || parameter.get決定日To().isEmpty())) {
            return builder;
        }

        ketteiYMD = dataToRString(parameter.get決定日From())
                .concat(ITEM)
                .concat(dataToRString(parameter.get決定日To()));
        builder.append(ketteiYMD);
        return builder;
    }

    private RStringBuilder get国保連送付年月() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(国保連送付年月);
        RString kokuhorenYM = RString.EMPTY;
        if ((parameter.get国保連送付年月From() == null || parameter.get国保連送付年月From().isEmpty())
                && (parameter.get国保連送付年月To() == null || parameter.get国保連送付年月To().isEmpty())) {
            return builder;
        }
        kokuhorenYM = monthToRString(parameter.get国保連送付年月From())
                .concat(ITEM)
                .concat(monthToRString(parameter.get国保連送付年月To()));
        builder.append(kokuhorenYM);
        return builder;
    }

    private List<RStringBuilder> get様式番号(RString 番号) {

        List<RStringBuilder> buiderList = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(様式番号);
        if (番号.isNullOrEmpty()) {
            buiderList.add(builder);
            return buiderList;
        }
        boolean 様式番号分行 = false;
        if (CODE_1.equals(parameter.get様式番号選択())) {
            builder.append(すべて);
            buiderList.add(builder);
        } else {
            List<RString> 様式番号list = 番号.split(EUC_WRITER_DELIMITER.toString());
            for (int i = 1; i <= 様式番号list.size(); i++) {
                if (様式番号分行) {
                    builder = new RStringBuilder();
                    builder.append(RString.FULL_SPACE).append(RString.FULL_SPACE).append(RString.FULL_SPACE)
                            .append(RString.FULL_SPACE).append(RString.FULL_SPACE);
                }
                builder.append(様式番号list.get(i - 1));
                if (i != 様式番号list.size() && builder.toRString().length() + 1 + 様式番号list.get(i).length() < INDEX_15) {
                    builder.append(EUC_WRITER_DELIMITER);
                    getLast様式番号(builder, i, 様式番号list, buiderList);
                    様式番号分行 = false;
                } else if (i == 様式番号list.size()) {
                    buiderList.add(builder);
                    break;
                } else {
                    buiderList.add(builder);
                    様式番号分行 = true;
                }
            }
        }
        return buiderList;
    }

    private void getLast様式番号(RStringBuilder builder, int i, List<RString> 様式番号list, List<RStringBuilder> buiderList) {
        if (i == 様式番号list.size() - 1) {
            builder.append(様式番号list.get(i));
            buiderList.add(builder);
        }
    }

}
