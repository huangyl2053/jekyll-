/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.KokuhorenFuicchi;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.SanteiKijun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShiharaiSaki;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShinsaHoho;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShinseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShoriJokyo;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.Taishosha;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.HanyouRisutoSyuturyokuEucCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyourisutosyuturyoku.HanyouRisutoSyuturyokuEntity;
import jp.co.ndensan.reams.db.dbc.service.report.hanyolistkogakukaigo.DBC701003BreakerFieldsEnum;
import jp.co.ndensan.reams.db.dbc.service.report.hanyolistkogakukaigo.DBC701019BreakerFieldsEnum;
import jp.co.ndensan.reams.db.dbc.service.report.hanyolistkogakukaigo.HanyoListKogakuKaigoEucCsvEntityEditor;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0301YokinShubetsuPatternEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.kinyukikan.KinyuKikanEntity;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 汎用リスト出力(高額介護サービス費状況)CSV出力の処理クラスです。
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
public class HanyoListKogakuKaigoServiceHiJokyoProcess extends BatchProcessBase<HanyouRisutoSyuturyokuEntity> {

    private static RString readDataId;
    private static EucEntityId eucEntityId;
    private static ReportId eucId;
    private static RString 日本語ファイル名;
    private static RString 英数字ファイル名;
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString CSV出力有無 = new RString("");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 構成市町村 = new RString("構成市町村：");
    private static final RString サービス提供年月 = new RString("サービス提供年月:");
    private static final RString 処理状況 = new RString("処理状況：");
    private static final RString 審査方法 = new RString("審査方法：");
    private static final RString 算定基準 = new RString("算定基準：");
    private static final RString 国保連不一致 = new RString("国保連不一致：");
    private static final RString 対象者 = new RString("対象者：");
    private static final RString 申請区分 = new RString("申請区分：");
    private static final RString 支払先 = new RString("支払先：");
    private static final RString 金融機関 = new RString("金融機関：");
    private static final RString 申請日 = new RString("申請日：");
    private static final RString 保険者決定日 = new RString("保険者決定日：");
    private static final RString 国保連決定年月 = new RString("国保連決定年月：");
    private static final RString 対象者受取年月 = new RString("対象者受取年月：");
    private static final RString 国保連送付年月 = new RString("国保連送付年月：");
    private static final RString 決定情報受取年月 = new RString("決定情報受取年月：");
    private static final RString 審査年月 = new RString("審査年月：");
    private static final RString 波線 = new RString("　～　");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private static final RString CODE = new RString("0003");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString SPLIT = new RString("|");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString DBC701003 = new RString("DBC701003");
    private static final RString DBC701019 = new RString("DBC701019");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString 高額介護サービス費状況CSV = new RString("汎用リスト　高額介護サービス費状況CSV");
    private static final RString 英数字ファイル名_高額介護サービス費状況CSV = new RString("HanyoList_KogakuKaigoServiceHiJokyo.csv");
    private static final RString 事業高額サービス費状況CSV = new RString("汎用リスト　事業高額サービス費状況CSV");
    private static final RString 英数字ファイル名_事業高額サービス費状況CSV = new RString("HanyoList_JigyoKogakuServiceHiJokyo.csv");
    private static final RString データ読み込みID1 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistkogakuservicehi.IHanyoListKogakuServiceHiMapper.selectAllデータ");
    private static final RString データ読み込みID2 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistkogakuservicehi.IHanyoListKogakuServiceHiMapper.selectAllModeデータ");
    private RString preBreakKey;
    private HanyoListKogakuKaigoProcessParameter parameter;
    private HanyoListKogakuKaigoEucCsvEntityEditor dataCreate;
    private HanyouRisutoSyuturyokuEntity preEntity;
    private RString eucFilePath;
    private List<PersonalData> personalDataList;
    private FileSpoolManager manager;
    private Association 地方公共団体;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private Decimal 連番;
    private List<KinyuKikanEntity> lstKinyuKikanEntity;
    private FlexibleDate システム日付;
    private boolean modoFlag = true;
    private IOutputOrder 並び順;
    private ReportId 帳票ID;
    private Map<LasdecCode, KoseiShichosonMaster> 構成市町村Map;

    @BatchWriter
    private EucCsvWriter<HanyouRisutoSyuturyokuEucCsvEntity> eucCsvWriter;

    @Override
    protected void initialize() {

        RString 出力順 = null;
        if (1 == parameter.getModo()) {
            readDataId = データ読み込みID1;
            eucEntityId = new EucEntityId(DBC701003);
            eucId = new ReportId(DBC701003);
            日本語ファイル名 = 高額介護サービス費状況CSV;
            英数字ファイル名 = 英数字ファイル名_高額介護サービス費状況CSV;
            帳票ID = ReportIdDBC.DBC701003.getReportId();
            帳票制御共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票ID);
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            並び順 = finder.get出力順(SubGyomuCode.DBC介護給付, 帳票ID,
                    parameter.getShutsuryokuju()
            );
            if (null == 並び順) {
                throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                        .replace(実行不可MESSAGE.toString()).toString());
            }
            出力順 = MyBatisOrderByClauseCreator.create(DBC701003BreakerFieldsEnum.class, 並び順);
        } else if (2 == parameter.getModo()) {
            readDataId = データ読み込みID2;
            eucEntityId = new EucEntityId(DBC701019);
            eucId = new ReportId(DBC701019);
            日本語ファイル名 = 事業高額サービス費状況CSV;
            英数字ファイル名 = 英数字ファイル名_事業高額サービス費状況CSV;
            this.modoFlag = false;
            帳票ID = ReportIdDBC.DBC701019.getReportId();
            帳票制御共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票ID);
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            並び順 = finder.get出力順(SubGyomuCode.DBC介護給付, 帳票ID,
                    parameter.getShutsuryokuju()
            );
            if (null == 並び順) {
                throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                        .replace(実行不可MESSAGE.toString()).toString());
            }
            出力順 = MyBatisOrderByClauseCreator.create(DBC701019BreakerFieldsEnum.class, 並び順);
        }
        parameter.set出力順(出力順);
        構成市町村Map = new HashMap<>();
        List<KoseiShichosonMaster> 構成市町村マスタ = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        if (構成市町村マスタ != null && !構成市町村マスタ.isEmpty()) {
            for (KoseiShichosonMaster koseiShichosonMaster : 構成市町村マスタ) {
                構成市町村Map.put(koseiShichosonMaster.get市町村コード(), koseiShichosonMaster);
            }
        }
    }

    @Override
    protected void beforeExecute() {
        連番 = Decimal.ONE;
        preBreakKey = RString.EMPTY;
        システム日付 = FlexibleDate.getNowDate();
        dataCreate = new HanyoListKogakuKaigoEucCsvEntityEditor(システム日付);
        personalDataList = new ArrayList<>();
        lstKinyuKikanEntity = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected IBatchReader createReader() {
        RString 国保連IFなし区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 事業高額分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBC介護給付);
        builder.set業務コード(GyomuCode.DB介護保険);
        IKozaSearchKey searchKey = builder.build();
        parameter.setSearchkey(searchKey);
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(parameter.getReamsLoginId());
        parameter.setList(list);
        parameter.setKamokuCodelist(list);
        parameter.set国保連IFなし区分(国保連IFなし区分);
        parameter.set事業高額分(事業高額分);
        return new BatchDbReader(readDataId, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, eucEntityId, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 英数字ファイル名);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, eucEntityId).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(parameter.isTomokumeFuka())
                .build();
    }

    @Override
    protected void process(HanyouRisutoSyuturyokuEntity entity) {

        RString tmp区分;
        if (entity.get区分() == 1) {
            tmp区分 = 区分_1;
        } else {
            tmp区分 = 区分_2;
        }

        RString nowBreakKey = tmp区分.concat(SPLIT)
                .concat(entity.get被保険者番号key().value()).concat(SPLIT)
                .concat(new RString(entity.getサービス提供年月key().toString())).concat(SPLIT)
                .concat(entity.get履歴番号key().toString());
        if (RString.EMPTY.equals(preBreakKey) || preBreakKey.equals(nowBreakKey)) {
            preBreakKey = nowBreakKey;
            if (entity.get口座情報() != null && entity.get口座情報().getUaT0310KozaEntity() != null) {
                lstKinyuKikanEntity.addAll(entity.get口座情報().getKinyuKikanEntity());
            }
            preEntity = entity;
            return;
        }
        if (!preBreakKey.equals(nowBreakKey)) {
            List<UaT0301YokinShubetsuPatternEntity> lstUat0301Entity = new ArrayList<>();

            for (KinyuKikanEntity kinyuKikanEntity : lstKinyuKikanEntity) {
                lstUat0301Entity.addAll(kinyuKikanEntity.get預金種別パターンEntity());
            }
            for (KinyuKikanEntity kinyuKikanEntity : lstKinyuKikanEntity) {
                if (kinyuKikanEntity.get預金種別パターンEntity() != null
                        && preEntity.get口座情報() != null && preEntity.get口座情報().getKinyuKikanEntity() != null) {
                    kinyuKikanEntity.get預金種別パターンEntity().addAll(lstUat0301Entity);
                    preEntity.get口座情報().getKinyuKikanEntity().add(kinyuKikanEntity);
                }
            }
            Association 導入団体情報 = AssociationFinderFactory.createInstance().getAssociation(preEntity.get市町村コード());
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(preEntity.get宛名());
            RString 住所 = JushoHenshu.editJusho(帳票制御共通情報, 宛名, 導入団体情報);
            eucCsvWriter.writeLine(dataCreate.edit(preEntity, parameter, 連番, 構成市町村Map, 住所));
            連番 = 連番.add(Decimal.ONE);
            personalDataList.add(toPersonalData(preEntity));
            lstKinyuKikanEntity.clear();
            if (entity.get口座情報() != null && entity.get口座情報().getUaT0310KozaEntity() != null) {
                lstKinyuKikanEntity.addAll(entity.get口座情報().getKinyuKikanEntity());
            }
        }
        preBreakKey = nowBreakKey;
        preEntity = entity;
    }

    @Override
    protected void afterExecute() {

        if (preEntity == null && parameter.isTomokumeFuka()) {
            eucCsvWriter.writeLine(new HanyouRisutoSyuturyokuEucCsvEntity());
        }
        List<UaT0301YokinShubetsuPatternEntity> lstUat0301Entity = new ArrayList<>();

        for (KinyuKikanEntity kinyuKikanEntity : lstKinyuKikanEntity) {
            lstUat0301Entity.addAll(kinyuKikanEntity.get預金種別パターンEntity());
        }
        for (KinyuKikanEntity kinyuKikanEntity : lstKinyuKikanEntity) {
            if (kinyuKikanEntity.get預金種別パターンEntity() != null
                    && preEntity.get口座情報() != null && preEntity.get口座情報().getKinyuKikanEntity() != null) {
                kinyuKikanEntity.get預金種別パターンEntity().addAll(lstUat0301Entity);
                preEntity.get口座情報().getKinyuKikanEntity().add(kinyuKikanEntity);
            }
        }
        if (preEntity != null) {
            Association 導入団体情報 = AssociationFinderFactory.createInstance().getAssociation(preEntity.get市町村コード());
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(preEntity.get宛名());
            RString 住所 = JushoHenshu.editJusho(帳票制御共通情報, 宛名, 導入団体情報);
            eucCsvWriter.writeLine(dataCreate.edit(preEntity, parameter, 連番, 構成市町村Map, 住所));
            連番 = 連番.add(Decimal.ONE);
            personalDataList.add(toPersonalData(preEntity));
        }
        eucCsvWriter.close();

        if (personalDataList == null || personalDataList.isEmpty()) {
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        } else {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLog);
        }
        バッチ出力条件リストの出力();
    }

    private PersonalData toPersonalData(HanyouRisutoSyuturyokuEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), 定数_被保険者番号,
                entity.get被保険者番号().value());
        return PersonalData.of(entity.get宛名().getShikibetsuCode(), expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter.getCount()));

        List<RString> 出力条件 = get出力条件();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                eucId.value(),
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

    private List<RString> get出力条件() {

        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出対象者);
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(構成市町村);
        LasdecCode lasdecCode = parameter.getKouseiShichosonCode();
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

        builder = new RStringBuilder();
        builder.append(サービス提供年月);
        RString serviceYmFrom = get提供年月(parameter.getServiceYmFrom());
        RString serviceYmTo = get提供年月(parameter.getServiceYmTo());
        if (!serviceYmFrom.isNullOrEmpty() || !serviceYmTo.isNullOrEmpty()) {
            builder.append(serviceYmFrom.concat(波線)
                    .concat(serviceYmTo));
        }
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(処理状況);
        builder.append(null == parameter.getShoriJokyo() || parameter.getShoriJokyo().isEmpty()
                ? RString.EMPTY : ShoriJokyo.toValue(parameter.getShoriJokyo()));
        出力条件.add(builder.toRString());

        if (this.modoFlag) {
            builder = new RStringBuilder();
            builder.append(審査方法);
            builder.append(null == parameter.getShinsaHoho() || parameter.getShinsaHoho().isEmpty()
                    ? RString.EMPTY : ShinsaHoho.toValue(parameter.getShinsaHoho()));
            出力条件.add(builder.toRString());
        }

        builder = new RStringBuilder();
        builder.append(算定基準);
        builder.append(null == parameter.getSanteiKijun()
                || parameter.getSanteiKijun().isEmpty()
                ? RString.EMPTY : SanteiKijun.toValue(parameter.getSanteiKijun()));
        出力条件.add(builder.toRString());

        if (this.modoFlag) {
            builder = new RStringBuilder();
            builder.append(国保連不一致);
            builder.append(null == parameter.getKokuhorenFuicchi()
                    || parameter.getKokuhorenFuicchi().isEmpty()
                    ? RString.EMPTY : KokuhorenFuicchi.toValue(parameter.getKokuhorenFuicchi()));
            出力条件.add(builder.toRString());
        }

        出力条件 = get対象者TO金融機関の出力条件(出力条件);

        return get時間出力条件(出力条件);
    }

    private List<RString> get対象者TO金融機関の出力条件(List<RString> 出力条件) {

        RStringBuilder builder = new RStringBuilder();
        builder.append(対象者);
        builder.append(null == parameter.getTaishosha()
                || parameter.getTaishosha().isEmpty()
                ? RString.EMPTY : Taishosha.toValue(parameter.getTaishosha()));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(申請区分);
        builder.append(null == parameter.getShinseiKubun()
                || parameter.getShinseiKubun().isEmpty()
                ? RString.EMPTY : ShinseiKubun.toValue(parameter.getShinseiKubun()));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(支払先);
        builder.append(null == parameter.getShiharaiSaki()
                || parameter.getShiharaiSaki().isEmpty()
                ? RString.EMPTY : ShiharaiSaki.toValue(parameter.getShiharaiSaki()));
        出力条件.add(builder.toRString());

        builder = get金融機関();
        出力条件.add(builder.toRString());
        return 出力条件;
    }

    private RStringBuilder get金融機関() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(金融機関);
        if (parameter.getKiyuKikanCode() == null || parameter.getKiyuKikanCode().isEmpty()) {
            return builder;
        }
        builder.append(parameter.getKiyuKikanCode() == null || parameter.getKiyuKikanCode().isEmpty()
                ? RString.EMPTY : 左記号.concat(parameter.getKiyuKikanCode())
                .concat(右記号).concat(parameter.getKiyuKikanName()));
        return builder;
    }

    private List<RString> get時間出力条件(List<RString> 出力条件) {

        RStringBuilder builder = new RStringBuilder();
        builder.append(申請日);
        RString serviceYmFrom = get年月日(parameter.getShisehiFrom());
        RString serviceYmTo = get年月日(parameter.getShisehiTo());
        if (!serviceYmFrom.isNullOrEmpty() || !serviceYmTo.isNullOrEmpty()) {
            builder.append(serviceYmFrom.concat(波線)
                    .concat(serviceYmTo));
        }
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(保険者決定日);
        serviceYmFrom = get年月日(parameter.getHokemonoKeteihiFrom());
        serviceYmTo = get年月日(parameter.getHokemonoKeteihiTo());
        if (!serviceYmFrom.isNullOrEmpty() || !serviceYmTo.isNullOrEmpty()) {
            builder.append(serviceYmFrom.concat(波線)
                    .concat(serviceYmTo));
        }
        出力条件.add(builder.toRString());

        if (this.modoFlag) {
            builder = new RStringBuilder();
            builder.append(国保連決定年月);

            serviceYmFrom = get提供年月(parameter.getKokuhoreKeteiymFrom());
            serviceYmTo = get提供年月(parameter.getKokuhoreKeteiymTo());
            if (!serviceYmFrom.isNullOrEmpty() || !serviceYmTo.isNullOrEmpty()) {
                builder.append(serviceYmFrom.concat(波線)
                        .concat(serviceYmTo));
            }
            出力条件.add(builder.toRString());
        }
        return get年月出力条件(出力条件);
    }

    private List<RString> get年月出力条件(List<RString> 出力条件) {

        RStringBuilder builder = new RStringBuilder();
        RString serviceYmFrom;
        RString serviceYmTo;

        if (this.modoFlag) {
            builder.append(対象者受取年月);
            serviceYmFrom = get提供年月(parameter.getTaishoshaUketoriymFrom());
            serviceYmTo = get提供年月(parameter.getTaishoshaUketoriymTo());
            if (!serviceYmFrom.isNullOrEmpty() || !serviceYmTo.isNullOrEmpty()) {
                builder.append(serviceYmFrom.concat(波線)
                        .concat(serviceYmTo));
            }
            出力条件.add(builder.toRString());
        }
        if (this.modoFlag) {
            builder = new RStringBuilder();
            builder.append(国保連送付年月);
            serviceYmFrom = get提供年月(parameter.getKokuhoreSofuYMFrom());
            serviceYmTo = get提供年月(parameter.getKokuhoreSofuYMTo());
            if (!serviceYmFrom.isNullOrEmpty() || !serviceYmTo.isNullOrEmpty()) {
                builder.append(serviceYmFrom.concat(波線)
                        .concat(serviceYmTo));
            }
            出力条件.add(builder.toRString());
        }
        if (this.modoFlag) {
            builder = new RStringBuilder();
            builder.append(決定情報受取年月);
            serviceYmFrom = get提供年月(parameter.getKeteijohoUketoriymFrom());
            serviceYmTo = get提供年月(parameter.getKeteijohoUketoriymTo());
            if (!serviceYmFrom.isNullOrEmpty() || !serviceYmTo.isNullOrEmpty()) {
                builder.append(serviceYmFrom.concat(波線)
                        .concat(serviceYmTo));
            }
            出力条件.add(builder.toRString());
        }

        if (!this.modoFlag) {
            builder = new RStringBuilder();
            builder.append(審査年月);
            serviceYmFrom = get提供年月(parameter.getShinsaYM());
            builder.append(serviceYmFrom);
            出力条件.add(builder.toRString());
        }

        return 出力条件;
    }

    private RString get提供年月(FlexibleYearMonth サービス提供年月) {

        if (サービス提供年月 == null || サービス提供年月.isEmpty()) {
            return RString.EMPTY;
        }
        return サービス提供年月.wareki().firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private RString get年月日(FlexibleDate 年月日) {

        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

}
