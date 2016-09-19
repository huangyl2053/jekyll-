/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoNoRenbanCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoNoRenbanDataCreate;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * バッチ設計_DBCBT23014_汎用リスト出力(高額合算申請書情報)Process
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
public class HanyoListKogakuGassanShinseishoNoRenbanProcess extends BatchProcessBase<HanyoListKogakuGassanShinseishoJohoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.hanyolistkogakugassanshinseishojoho."
            + "IHanyoListKogakuGassanShinseishoJohoMapper.getCSVData");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701014");
    private static final RString ITEM = new RString("～");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　高額合算申請書情報CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_KogakuGassanShinseishoJoho.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final Code CODE = new Code("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 保険者 = new RString("保険者：");
    private static final RString 抽出区分 = new RString("抽出区分：");
    private static final RString 対象年度 = new RString("対象年度：");
    private static final RString 申請年月日 = new RString("申請年月日：");
    private static final RString 支給申請書整理番号 = new RString("支給申請書整理番号：");
    private static final RString 送付年月 = new RString("送付年月：");
    private static final RString すべて = new RString("すべて");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private RString 出力有無;
    private HanyoListKogakuGassanShinseishoJohoProcessParameter parameter;
    private HanyoListKogakuGassanShinseishoJohoNoRenbanDataCreate dataCreate;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private Association 地方公共団体;
    private FlexibleDate システム日付;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
//    TODO QA1490
//    private static final RString デフォルト出力順 = new RString("order by 高額合算申請書_被保険者番号,"
//            + "高額合算申請書_対象年度,高額合算申請書_保険者番号,高額合算申請書_整理番号");

    @BatchWriter
    private CsvWriter<HanyoListKogakuGassanShinseishoJohoNoRenbanCSVEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        出力有無 = CSV出力有無_なし;
        システム日付 = FlexibleDate.getNowDate();
        dataCreate = new HanyoListKogakuGassanShinseishoJohoNoRenbanDataCreate(システム日付);

        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBC介護給付);
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振込口座.getCode()));
        builder.set基準日(システム日付);
        IKozaSearchKey searchKey = builder.build();
        parameter.setSearchkey(searchKey);
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(parameter.getReamsLoginId());
        parameter.setList(list);
//        TODO QA1490
//        if (RString.isNullOrEmpty(parameter.get抽出区分())) {
//            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
//            IOutputOrder 出力順;
//            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
//                    ReportIdDBC.DBC701014.getReportId(), parameter.get出力順());
//            if (出力順 != null) {
//                parameter.set出力順(Long.valueOf(MyBatisOrderByClauseCreator.create(
//                        HanyoListKogakuGassanShinseishoJohoProperty.DBC701014ShutsuryokujunEnum.class, 出力順).toString()));
//            } else {
//                parameter.set出力順(Long.valueOf(デフォルト出力順.toString()));
//            }
//        }
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 英数字ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(parameter.is項目名付加()).
                build();

    }

    @Override
    protected void beforeExecute() {
        personalDataList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        市町村名MasterMap = new HashMap<>();
        List<KoseiShichosonMaster> 市町村名Master = KoseiShichosonJohoFinder
                .createInstance().get現市町村情報();
        for (KoseiShichosonMaster koseiShichosonMaster : 市町村名Master) {
            市町村名MasterMap.put(koseiShichosonMaster.get市町村コード().value(),
                    koseiShichosonMaster);
        }
    }

    @Override
    protected void process(HanyoListKogakuGassanShinseishoJohoEntity entity) {
        出力有無 = CSV出力有無_あり;
        eucCsvWriter.writeLine(dataCreate.createCsvData(entity, parameter, 市町村名MasterMap, 地方公共団体));
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        if (personalDataList == null || personalDataList.isEmpty()) {
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        } else {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLog);
        }
        バッチ出力条件リストの出力();
    }

    private PersonalData toPersonalData(HanyoListKogakuGassanShinseishoJohoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(CODE, 被保険者番号,
                entity.get高額合算申請書_被保険者番号());
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
                RString.EMPTY,
                日本語ファイル名,
                出力件数,
                出力有無,
                英数字ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory
                .createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private RString monthToRString(FlexibleYearMonth 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }

    private RString dataToRString(FlexibleDate 日付) {
        if (日付 == null || 日付.isEmpty()) {
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
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get抽出区分();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get対象年度();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get申請年月日();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get支給申請書整理番号();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get送付年月();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }

        return 出力条件;
    }

    private RStringBuilder get抽出区分() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出区分);
        if (parameter.get抽出区分() == null || parameter.get抽出区分().isEmpty()) {
            return null;
        }
        builder.append(Kaigogassan_ChushutsuKubun.toValue(parameter.get抽出区分()).get名称());
        return builder;
    }

    private RStringBuilder get保険者名() {
        RStringBuilder builder = new RStringBuilder();
        if (parameter.get保険者コード() == null || parameter.get保険者コード().isEmpty()
                || すべて.equals(parameter.get保険者コード())) {
            return null;
        }
        builder.append(保険者);
        Association 地方公共団体コード = AssociationFinderFactory.createInstance().getAssociation(
                new LasdecCode(parameter.get保険者コード()));
        builder.append(地方公共団体コード.get市町村名());
        return builder;
    }

    private RStringBuilder get申請年月日() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(申請年月日);
        if ((parameter.get申請年月日From() == null || parameter.get申請年月日From().isEmpty())
                && (parameter.get申請年月日To() == null || parameter.get申請年月日To().isEmpty())) {
            return null;
        }
        if (parameter.get申請年月日From() != null && !parameter.get申請年月日From().isEmpty()
                && parameter.get申請年月日To() != null && !parameter.get申請年月日To().isEmpty()) {
            return builder.append(dataToRString(parameter.get申請年月日From()))
                    .append(ITEM).append(dataToRString(parameter.get申請年月日To()));
        } else if (parameter.get申請年月日To() == null || parameter.get申請年月日To().isEmpty()) {
            return builder.append(dataToRString(parameter.get申請年月日From())).append(ITEM);
        } else if (parameter.get申請年月日From() == null || parameter.get申請年月日From().isEmpty()) {
            return builder.append(ITEM).append(dataToRString(parameter.get申請年月日To()));
        }

        return null;
    }

    private RStringBuilder get支給申請書整理番号() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(支給申請書整理番号);
        if ((parameter.get支給申請書整理番号From() == null || parameter.get支給申請書整理番号From().isEmpty())
                && (parameter.get支給申請書整理番号To() == null || parameter.get支給申請書整理番号To().isEmpty())) {
            return null;
        }
        if (parameter.get支給申請書整理番号From() != null && !parameter.get支給申請書整理番号From().isEmpty()
                && parameter.get支給申請書整理番号To() != null && !parameter.get支給申請書整理番号To().isEmpty()) {
            return builder.append(parameter.get支給申請書整理番号From()).append(ITEM)
                    .append(parameter.get支給申請書整理番号To());
        } else if (parameter.get支給申請書整理番号To() == null || parameter.get支給申請書整理番号To().isEmpty()) {
            return builder.append(parameter.get支給申請書整理番号From()).append(ITEM);
        } else if (parameter.get支給申請書整理番号From() == null || parameter.get支給申請書整理番号From().isEmpty()) {
            return builder.append(ITEM).append(parameter.get支給申請書整理番号To());
        }
        return null;
    }

    private RStringBuilder get送付年月() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(送付年月);
        if ((parameter.get送付年月From() == null || parameter.get送付年月From().isEmpty())
                && (parameter.get送付年月To() == null || parameter.get送付年月To().isEmpty())) {
            return null;
        }
        if (parameter.get送付年月From() != null && !parameter.get送付年月From().isEmpty()
                && parameter.get送付年月To() != null && !parameter.get送付年月To().isEmpty()) {
            return builder.append(monthToRString(parameter.get送付年月From())).append(ITEM)
                    .append(monthToRString(parameter.get送付年月To()));
        } else if (parameter.get送付年月To() == null || parameter.get送付年月To().isEmpty()) {
            return builder.append(monthToRString(parameter.get送付年月From())).append(ITEM);
        } else if (parameter.get送付年月From() == null || parameter.get送付年月From().isEmpty()) {
            return builder.append(ITEM).append(monthToRString(parameter.get送付年月To()));
        }
        return null;
    }

    private RStringBuilder get対象年度() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(対象年度);
        if (parameter.get対象年度() != null && !parameter.get対象年度().isEmpty()) {
            return builder.append(DateConverter.getWarekiYear(new RYear(parameter.get対象年度().toString())));
        }
        return null;
    }
}
