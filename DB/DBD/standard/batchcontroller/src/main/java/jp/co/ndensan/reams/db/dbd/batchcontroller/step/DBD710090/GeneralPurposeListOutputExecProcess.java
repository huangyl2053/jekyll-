/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd710090.HanyoListShisetsuNyutaishoOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuKomokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt13011.GeneralPurposeListOutputProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputNotContainNoEucCsvEntity;
import jp.co.ndensan.reams.db.dbd.service.core.dbd710090.HanyoListShiharaiHohoHenkoManager;
import jp.co.ndensan.reams.db.dbd.service.core.hanyolist.HanyoListManager;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.IJushoNyuryokuConfig;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBDBT13011_汎用リスト出力(施設入退所)事前準備_process処理クラスです。
 *
 * @reamsid_L DBD-1570-030 x_lilh
 */
public class GeneralPurposeListOutputExecProcess extends BatchProcessBase<GeneralPurposeListOutputEntity> {

    private static final RString 日本語ファイル名 = new RString("汎用リスト　施設入退所CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_ShisetuNyutaisyo.csv");
    private static final RString 出力条件表_保険者 = new RString("保険者：");
    private static final RString 出力条件表_基準日 = new RString("基準日：");
    private static final RString 出力条件表_対象データ_直近のみ = new RString("対象データ：直近のみ");
    private static final RString 出力条件表_喪失区分 = new RString("喪失区分：");
    private static final RString 出力条件表_年齢 = new RString("年齢：");
    private static final RString 出力条件表_歳 = new RString("歳");
    private static final RString 出力条件表_中間符号 = new RString("～");
    private static final RString 出力条件表_年齢基準日 = new RString("年齢基準日：");
    private static final RString 出力条件表_左丸括弧 = new RString("(");
    private static final RString 出力条件表_右丸括弧 = new RString(")");
    private static final RString 出力条件表_生年月日 = new RString("生年月日：");
    private static final RString 出力条件表_HALF_SPACE = RString.HALF_SPACE;
    private static final RString 出力条件表_行政区 = new RString("行政区： ");
    private static final RString 出力条件表_町域 = new RString("町域：");
    private static final RString 出力条件表_抽出対象者 = new RString("【抽出対象者】");

    private static final RString 資格判定なし = new RString("資格判定なし");
    private static final RString 全て = new RString("全て");

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBD701010");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private GeneralPurposeListOutputProcessParameter processParamter;
    private CsvWriter<GeneralPurposeListOutputEucCsvEntity> eucCsvWriter;
    private CsvWriter<GeneralPurposeListOutputNotContainNoEucCsvEntity> eucNotContainNoCsvWriter;

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.generalpurposelistoutput."
            + "IGeneralPurposeListOutputMapper.getGeneralPurposeListOutputInfo");
    
    private Association 地方公共団体情報;
    private IAssociationFinder finder;
    private RString 出力順;
    private HokenshaList 保険者リスト;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private List<PersonalData> personalDataList;

    @Override
    protected void initialize() {
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        finder = AssociationFinderFactory.createInstance();
        保険者リスト = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        personalDataList = new ArrayList<>();

        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
                new ReportId(processParamter.get帳票ID()), processParamter.get出力順());
        出力順 = get出力順(outputOrder);
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho = key.build();
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toGeneralPurposeListOutputMybatisParameter(psmShikibetsuTaisho, psmAtesaki, 出力順));
    }

    int csvcount = 0;

    @Override
    protected void process(GeneralPurposeListOutputEntity entity) {

        if (processParamter.is連番付加()) {
            GeneralPurposeListOutputEucCsvEntity eucCsvEntity = new GeneralPurposeListOutputEucCsvEntity();
            if (entity.get被保険者台帳管理_市町村コード() != null && !entity.get被保険者台帳管理_市町村コード().isEmpty()) {
                eucCsvEntity.set市町村名(finder.getAssociation(new LasdecCode(entity.get被保険者台帳管理_市町村コード())).get市町村名());
            }
            HanyoListShiharaiHohoHenkoManager.createInstance().連番ありCSV情報設定(eucCsvEntity, entity, csvcount, 地方公共団体情報, 保険者リスト,
                    processParamter.is日付スラッシュ付加());
            eucCsvWriter.writeLine(eucCsvEntity);
        } else {
            GeneralPurposeListOutputNotContainNoEucCsvEntity eucCsvEntity = new GeneralPurposeListOutputNotContainNoEucCsvEntity();
            if (entity.get被保険者台帳管理_市町村コード() != null && !entity.get被保険者台帳管理_市町村コード().isEmpty()) {
                eucCsvEntity.set市町村名(finder.getAssociation(new LasdecCode(entity.get被保険者台帳管理_市町村コード())).get市町村名());
            }
            HanyoListShiharaiHohoHenkoManager.createInstance().連番なしCSV情報設定(eucCsvEntity, entity, 地方公共団体情報, 保険者リスト,
                    processParamter.is日付スラッシュ付加());
            eucNotContainNoCsvWriter.writeLine(eucCsvEntity);
        }

        csvcount++;
        personalDataList.add(toPersonalData(entity));
    }

    private RString get出力順(IOutputOrder order) {
        if (order != null) {
            RString 出力順 = MyBatisOrderByClauseCreator.create(HanyoListShisetsuNyutaishoOrderKey.class, order);
            return 出力順.concat(",施設入所_識別コード,施設入所_履歴番号");
        }
        return RString.EMPTY;
    }

    @Override
    protected void afterExecute() {
        eucFileOutputJohoFactory();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);

        if (processParamter.is連番付加()) {
            IBatchWriter batchWriter = (IBatchWriter) eucCsvWriter;
            batchWriter.close();
        } else {
            IBatchWriter batchWriter = (IBatchWriter) eucNotContainNoCsvWriter;
            batchWriter.close();
        }

        manager.spool(eucFilePath, log);
    }

    private PersonalData toPersonalData(GeneralPurposeListOutputEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者台帳管理_被保険者番号());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HanyoList_ShisetuNyutaisyo.csv"));

        if (processParamter.is連番付加()) {
            eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                    .alwaysWriteHeader(GeneralPurposeListOutputEucCsvEntity.class)
                    .setEncode(Encode.UTF_8withBOM)
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(processParamter.is項目名付加())
                    .build();
        } else {
            eucNotContainNoCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                    .alwaysWriteHeader(GeneralPurposeListOutputNotContainNoEucCsvEntity.class)
                    .setEncode(Encode.UTF_8withBOM)
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(processParamter.is項目名付加())
                    .build();
        }

    }

    private void eucFileOutputJohoFactory() {
        if (processParamter.is連番付加()) {

            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    日本語ファイル名,
                    地方公共団体情報.getLasdecCode_().getColumnValue(),
                    地方公共団体情報.get市町村名(),
                    new RString(JobContextHolder.getJobId()),
                    英数字ファイル名,
                    EUC_ENTITY_ID.toRString(),
                    new RString(String.valueOf(eucCsvWriter.getCount())),
                    get出力条件表());
            EucFileOutputJokenhyoFactory.createInstance(item).print();
        } else {
            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    日本語ファイル名,
                    地方公共団体情報.getLasdecCode_().getColumnValue(),
                    地方公共団体情報.get市町村名(),
                    new RString(JobContextHolder.getJobId()),
                    英数字ファイル名,
                    EUC_ENTITY_ID.toRString(),
                    new RString(String.valueOf(eucNotContainNoCsvWriter.getCount())),
                    get出力条件表());
            EucFileOutputJokenhyoFactory.createInstance(item).print();
        }
    }

    private RString edit抽出項目区分(RString 抽出項目区分) {
        try {
            return ChushutsuKomokuKubun.toValue(抽出項目区分).get名称();
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }

    private List<RString> get出力条件表() {
        List<RString> list = new ArrayList<>();
        AtenaSelectBatchParameter atenaSelectBatchParameter = processParamter.get宛名抽出条件();
        NenreiSoChushutsuHoho nenreiSoChushutsuHoho = atenaSelectBatchParameter.getAgeSelectKijun();

        list.add(出力条件表_抽出対象者);
        if (atenaSelectBatchParameter.getShichoson_Code() != null && !atenaSelectBatchParameter.getShichoson_Code().isEmpty()) {
            list.add(出力条件表_保険者.concat(edit市町村(atenaSelectBatchParameter.getShichoson_Code())));
        }

        if (processParamter.get基準日() != null && !processParamter.get基準日().isEmpty()) {
            list.add(出力条件表_基準日.concat(edit日期(processParamter.get基準日())));
        }
        set日付範囲について(list);
        if (processParamter.is直近データ抽出()) {
            list.add(出力条件表_対象データ_直近のみ);
        }

        if (processParamter.get喪失区分() != null && !資格判定なし.equals(processParamter.get喪失区分().get名称())) {
            list.add(出力条件表_喪失区分.concat(processParamter.get喪失区分().get名称()));
        }
        set出力条件表_年齢(atenaSelectBatchParameter, nenreiSoChushutsuHoho, list);
        set出力条件表_生年月日(atenaSelectBatchParameter, nenreiSoChushutsuHoho, list);
        set出力条件表_地区選択(atenaSelectBatchParameter, list);
        return list;
    }

    private void set日付範囲について(List<RString> list) {
        if ((processParamter.get日付範囲From() != null && !processParamter.get日付範囲From().isEmpty())
                && (processParamter.get日付範囲To() != null && !processParamter.get日付範囲To().isEmpty())) {
            list.add(edit抽出項目区分(processParamter.get抽出項目区分()).concat(new RString(":"))
                    .concat(edit日期(processParamter.get日付範囲From())).concat(出力条件表_中間符号)
                    .concat(edit日期(processParamter.get日付範囲To())));
        }
        if ((processParamter.get日付範囲From() != null && !processParamter.get日付範囲From().isEmpty())
                && (processParamter.get日付範囲To() == null || processParamter.get日付範囲To().isEmpty())) {
            list.add(edit抽出項目区分(processParamter.get抽出項目区分()).concat(new RString(":"))
                    .concat(edit日期(processParamter.get日付範囲From())).concat(出力条件表_中間符号));
        }
        if ((processParamter.get日付範囲From() == null || processParamter.get日付範囲From().isEmpty())
                && (processParamter.get日付範囲To() != null && !processParamter.get日付範囲To().isEmpty())) {
            list.add(edit抽出項目区分(processParamter.get抽出項目区分()).concat(new RString(":"))
                    .concat(出力条件表_中間符号).concat(edit日期(processParamter.get日付範囲To())));
        }
    }

    private RString edit日期(FlexibleDate 変更前日期) {
        if (変更前日期 != null && !変更前日期.isEmpty()) {
            return 変更前日期.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString edit日期RDate(RDate 変更前日期) {
        if (変更前日期 != null) {
            return 変更前日期.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private void set出力条件表_年齢(AtenaSelectBatchParameter atenaSelectBatchParameter,
            NenreiSoChushutsuHoho nenreiSoChushutsuHoho,
            List<RString> list) {
        if (NenreiSoChushutsuHoho.年齢範囲.equals(nenreiSoChushutsuHoho)) {
            Range<Decimal> ageRange = atenaSelectBatchParameter.getNenreiRange();
            Decimal startAge = ageRange.getFrom();
            Decimal endAge = ageRange.getTo();

            if (Decimal.ZERO != startAge && Decimal.ZERO != endAge) {
                list.add(出力条件表_年齢
                        .concat(startAge.toString())
                        .concat(出力条件表_歳)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(endAge.toString())
                        .concat(出力条件表_歳)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_左丸括弧)
                        .concat(出力条件表_年齢基準日)
                        .concat(edit日期RDate(atenaSelectBatchParameter.getNenreiKijunbi()))
                        .concat(出力条件表_右丸括弧));
            }
            if (Decimal.ZERO != startAge && Decimal.ZERO == endAge) {
                list.add(出力条件表_年齢
                        .concat(startAge.toString())
                        .concat(出力条件表_歳)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_左丸括弧)
                        .concat(出力条件表_年齢基準日)
                        .concat(edit日期RDate(atenaSelectBatchParameter.getNenreiKijunbi()))
                        .concat(出力条件表_右丸括弧));
            }

            if (Decimal.ZERO == startAge && Decimal.ZERO != endAge) {
                list.add(出力条件表_年齢
                        .concat(出力条件表_中間符号)
                        .concat(endAge.toString())
                        .concat(出力条件表_歳)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_左丸括弧)
                        .concat(出力条件表_年齢基準日)
                        .concat(edit日期RDate(atenaSelectBatchParameter.getNenreiKijunbi()))
                        .concat(出力条件表_右丸括弧));
            }
        }
    }

    private void set出力条件表_生年月日(AtenaSelectBatchParameter atenaSelectBatchParameter,
            NenreiSoChushutsuHoho nenreiSoChushutsuHoho,
            List<RString> list) {
        if (NenreiSoChushutsuHoho.生年月日範囲.equals(nenreiSoChushutsuHoho)) {
            Range<RDate> seinengappiRange = atenaSelectBatchParameter.getSeinengappiRange();
            RDate startSeinengappiRange = seinengappiRange.getFrom();
            RDate endSeinengappiRange = seinengappiRange.getTo();
            if (startSeinengappiRange != null && endSeinengappiRange != null) {
                list.add(出力条件表_生年月日
                        .concat(edit日期(new FlexibleDate(startSeinengappiRange.toDateString())))
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(edit日期(new FlexibleDate(endSeinengappiRange.toDateString()))));
            }
            if (startSeinengappiRange != null && endSeinengappiRange == null) {
                list.add(出力条件表_生年月日
                        .concat(edit日期(new FlexibleDate(startSeinengappiRange.toDateString())))
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号));
            }
            if (startSeinengappiRange == null && endSeinengappiRange != null) {
                list.add(出力条件表_生年月日
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号)
                        .concat(edit日期(new FlexibleDate(endSeinengappiRange.toDateString()))));
            }
        }
    }

    private RString edit市町村(LasdecCode 市町村コード) {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association 地方公共団体 = finder.getAssociation(市町村コード);
        return 地方公共団体.get市町村名();
    }

    private void set出力条件表_地区選択(AtenaSelectBatchParameter atenaSelectBatchParameter, List<RString> list) {
        if (atenaSelectBatchParameter.getChiku_Kubun() != null && !全て.equals(atenaSelectBatchParameter.getChiku_Kubun().get名称())) {

            RString 町域Str = edit地区選択(出力条件表_町域, atenaSelectBatchParameter.getJusho_From(),
                    atenaSelectBatchParameter.getJusho_FromMesho(), atenaSelectBatchParameter.getJusho_To(),
                    atenaSelectBatchParameter.getJusho_ToMesho());
            RString 地区Str = edit地区選択(出力条件表_行政区, atenaSelectBatchParameter.getGyoseiku_From(),
                    atenaSelectBatchParameter.getGyoseiku_FromMesho(), atenaSelectBatchParameter.getGyoseiku_To(),
                    atenaSelectBatchParameter.getGyoseiku_ToMesho());

            if (!町域Str.isNullOrEmpty()) {
                list.add(町域Str);
            }
            if (!地区Str.isNullOrEmpty()) {
                list.add(地区Str);
            }

            IJushoNyuryokuConfig config = JushoNyuryokuConfigFactory.createInstance();
            RString 名称1 = config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１);
            RString 名称2 = config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類２);
            RString 名称3 = config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類３);

            RString 地区1Str = edit地区(名称1, atenaSelectBatchParameter.getChiku1_From(), atenaSelectBatchParameter.getChiku1_FromMesho(),
                    atenaSelectBatchParameter.getChiku1_To(), atenaSelectBatchParameter.getChiku1_ToMesho());
            RString 地区2Str = edit地区(名称2, atenaSelectBatchParameter.getChiku2_From(), atenaSelectBatchParameter.getChiku2_FromMesho(),
                    atenaSelectBatchParameter.getChiku2_To(), atenaSelectBatchParameter.getChiku2_ToMesho());
            RString 地区3Str = edit地区(名称3, atenaSelectBatchParameter.getChiku3_From(), atenaSelectBatchParameter.getChiku3_FromMesho(),
                    atenaSelectBatchParameter.getChiku3_To(), atenaSelectBatchParameter.getChiku3_ToMesho());

            if (!地区1Str.isNullOrEmpty()) {
                list.add(地区1Str);
            }
            if (!地区2Str.isNullOrEmpty()) {
                list.add(地区2Str);
            }
            if (!地区3Str.isNullOrEmpty()) {
                list.add(地区3Str);
            }

        }
    }

    private RString edit地区(RString 名称, RString 地区From, RString 地区From名称, RString 地区To, RString 地区To名称) {
        RString 地区Str = RString.EMPTY;

        if (地区From != null && !地区From.isEmpty() && 地区To != null && !地区To.isEmpty()) {
            地区Str = 地区Str.concat(名称)
                    .concat(出力条件表_左丸括弧)
                    .concat(地区From)
                    .concat(出力条件表_右丸括弧)
                    .concat(地区From名称)
                    .concat(出力条件表_中間符号)
                    .concat(出力条件表_左丸括弧)
                    .concat(地区To)
                    .concat(出力条件表_右丸括弧)
                    .concat(地区To名称);
        }

        if (地区From != null && !地区From.isEmpty() && (地区To == null || 地区To.isEmpty())) {

            地区Str = 地区Str.concat(名称).concat(出力条件表_左丸括弧).concat(地区From).concat(出力条件表_右丸括弧).concat(地区From名称).concat(出力条件表_中間符号)
                    .concat(出力条件表_左丸括弧).concat(地区From).concat(出力条件表_右丸括弧).concat(地区From名称);
        }

        if ((地区From == null || 地区From.isEmpty()) && 地区To != null && !地区To.isEmpty()) {

            地区Str = 地区Str.concat(名称).concat(出力条件表_右丸括弧).concat(地区To).concat(出力条件表_右丸括弧).concat(地区To名称).concat(出力条件表_中間符号)
                    .concat(出力条件表_左丸括弧).concat(地区To).concat(出力条件表_右丸括弧).concat(地区To名称);
        }
        return 地区Str;
    }

    private RString edit地区選択(RString kubun, RString from, RString fromNm, RString to, RString toNm) {

        RString 地区選択Str = RString.EMPTY;
        if (from != null && !from.isEmpty() && to != null && !to.isEmpty()) {
            地区選択Str = kubun
                    .concat(出力条件表_左丸括弧)
                    .concat(from)
                    .concat(出力条件表_右丸括弧)
                    .concat(fromNm)
                    .concat(出力条件表_HALF_SPACE)
                    .concat(出力条件表_中間符号)
                    .concat(出力条件表_HALF_SPACE)
                    .concat(出力条件表_左丸括弧)
                    .concat(to)
                    .concat(出力条件表_右丸括弧)
                    .concat(toNm);
        }

        if (from != null && !from.isEmpty() && (to == null || to.isEmpty())) {
            地区選択Str = kubun.concat(出力条件表_左丸括弧)
                    .concat(from)
                    .concat(出力条件表_右丸括弧)
                    .concat(fromNm)
                    .concat(出力条件表_HALF_SPACE)
                    .concat(出力条件表_中間符号);
        }
        if ((from == null || from.isEmpty()) && to != null && !to.isEmpty()) {
            地区選択Str = kubun.concat(出力条件表_中間符号)
                    .concat(出力条件表_HALF_SPACE)
                    .concat(出力条件表_左丸括弧)
                    .concat(to)
                    .concat(出力条件表_右丸括弧)
                    .concat(toNm);
        }

        return 地区選択Str;
    }

}
