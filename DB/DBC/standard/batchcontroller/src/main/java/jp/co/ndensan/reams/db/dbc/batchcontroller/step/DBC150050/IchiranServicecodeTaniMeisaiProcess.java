/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.servicecodetanimeisaiichiran.IchiranServicecodeTaniMeisaiOutPutOrder;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufusakuseikubun.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha.KyuSochiNyushoshaTokureiCode;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran.KyufuJissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc150050.DbWT3470chohyouShutsuryokuyouCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470chohyouShutsuryokuTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.jushochitokureisha.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票出力対象データ取得Processクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class IchiranServicecodeTaniMeisaiProcess
        extends BatchKeyBreakBase<DbWT3470chohyouShutsuryokuTempEntity> {

    private KyufuJissekiProcessParameter parameter;
    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran."
                    + "IServicecodeTaniMeisaiIchiranMapper.get帳票出力用一時TBL");

    private IOutputOrder 並び順;
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    @BatchWriter
    private CsvWriter<DbWT3470chohyouShutsuryokuyouCSVEntity> dbwt3470CSVWriter;
    private static final RString ダブル引用符 = new RString("\"");
    private RString dbwt3470FilePath;
    private FileSpoolManager manager;
    private static final RString 出力ファイル名
            = new RString("DBC200005_ServiceCodeTaniMeisaiIchiran.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200005");
    private int count;
    private Set<ShikibetsuCode> 識別コードset;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private final Code code = new Code("0003");
    private final RString 漢字_被保険者番号 = new RString("被保険者番号");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 無し = new RString("1");

    @Override
    protected void initialize() {

        count = INT_0;
        識別コードset = new HashSet<>();
        並び順 = get並び順();
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = MyBatisOrderByClauseCreator.create(IchiranServicecodeTaniMeisaiOutPutOrder.class, 並び順);
        if (!RString.isNullOrEmpty(出力順)) {
            List<RString> 出力順BODY = 出力順.split(コンマ.toString());
            出力順 = RString.EMPTY;
            if (1 < 出力順BODY.size()) {
                for (int i = 0; i < 出力順BODY.size(); i++) {
                    出力順 = concat出力順(i, 出力順, 出力順BODY.get(i));
                }
            }
            parameter.set出力順(出力順);
        }

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        dbwt3470FilePath = Path.combinePath(manager.getEucOutputDirectry(),
                出力ファイル名);
        dbwt3470CSVWriter = BatchWriters.csvWriter(DbWT3470chohyouShutsuryokuyouCSVEntity.class).
                filePath(dbwt3470FilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();

    }

    @Override
    protected void usualProcess(DbWT3470chohyouShutsuryokuTempEntity entity) {
        count = count + INT_1;
        アクセスログ対象追加(entity);
        DbWT3470chohyouShutsuryokuyouCSVEntity csvEntity = new DbWT3470chohyouShutsuryokuyouCSVEntity();
        if (count == INT_1) {
            setCSVヘッダー(csvEntity);
        }
        setCSV明細(entity, csvEntity);
        dbwt3470CSVWriter.writeLine(csvEntity);
    }

    @Override
    protected void afterExecute() {
        dbwt3470CSVWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(dbwt3470FilePath, accessLogUUID);
        } else {
            manager.spool(dbwt3470FilePath);
        }
    }

    private void setCSVヘッダー(DbWT3470chohyouShutsuryokuyouCSVEntity csvEntity) {
        RDateTime 作成日時 = RDateTime.now();
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
        csvEntity.set保険者番号(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        csvEntity.set保険者名(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
    }

    private void setCSV明細(DbWT3470chohyouShutsuryokuTempEntity entity,
            DbWT3470chohyouShutsuryokuyouCSVEntity csvEntity) {
        csvEntity.set住民コード(getColumnValue(entity.getShikibetsuCode()));
        csvEntity.set住民種別(entity.getJuminShubetsuCode());
        csvEntity.set氏名(getColumnValue(entity.getMeisho()));
        csvEntity.set氏名カナ(getColumnValue(entity.getKanaMeisho()));
        csvEntity.set生年月日(doパターン4(entity.getSeinengappiYMD()));
        csvEntity.set年齢(entity.getAge());
        csvEntity.set性別(entity.getSeibetsu());
        if (!RString.isNullOrEmpty(entity.getSeibetsu())) {
            csvEntity.set性別名称(Seibetsu.toValue(entity.getSeibetsu()).get名称());
        } else {
            csvEntity.set性別名称(RString.EMPTY);
        }
        csvEntity.set続柄コード(getColumnValue(entity.getTsuzukigaraCode()));
        csvEntity.set世帯コード(getColumnValue(entity.getSetaiCode()));
        csvEntity.set世帯主名(getColumnValue(entity.getSetainushiMei()));
        csvEntity.set住所コード(getColumnValue(entity.getChoikiCode()));
        csvEntity.set郵便番号(getColumnValue(entity.getYubinNo()));
        csvEntity.set住所番地方書(entity.getJushoBanchiKatagaki());
        csvEntity.set住所(entity.getJusho());
        csvEntity.set番地(entity.getBanchi());
        csvEntity.set方書(entity.getKatagaki());
        csvEntity.set行政区コード(getColumnValue(entity.getGyoseikuCode()));
        csvEntity.set行政区名(entity.getGyoseikuName());
        csvEntity.set地区１(entity.getChikuCode1());
        csvEntity.set地区２(entity.getChikuCode2());
        csvEntity.set地区３(entity.getChikuCode3());
        csvEntity.set空白(entity.getBlank());
        csvEntity.set資格区分(entity.getHihokennshaKubunCode());
        csvEntity.set広域内住所地特例(entity.getKoikinaiJushochiTokureiFlag());
        if (!RString.isNullOrEmpty(entity.getKoikinaiJushochiTokureiFlag())) {
            csvEntity.set広域内住所地名称(JushochitokureishaKubun.
                    toValue(entity.getKoikinaiJushochiTokureiFlag()).get名称());
        } else {
            csvEntity.set広域内住所地名称(RString.EMPTY);
        }
        csvEntity.set入力識別番号(getColumnValue(entity.getInputShikibetsuNo()));
        csvEntity.set給付実績情報作成区分コード(entity.getKyufuSakuseiKubunCode());
        if (!RString.isNullOrEmpty(entity.getKyufuSakuseiKubunCode())) {
            csvEntity.set給付実績情報作成区分名称(KyufuSakuseiKubun.toValue(entity.getKyufuSakuseiKubunCode()).get名称());
        } else {
            csvEntity.set給付実績情報作成区分名称(RString.EMPTY);
        }
        csvEntity.set証記載保険者番号(entity.getShokisaiHokenshaNo());
        csvEntity.set証記載保険者名(entity.getShokisaiHokenshaName());
        csvEntity.set被保険者番号(getColumnValue(entity.getHiHokenshaNo()));
        csvEntity.setサービス提供年月(doパターン54(entity.getServiceTeikyoYM()));
        csvEntity.set給付実績区分コード(entity.getKyufuJissekiKubunCode());
        if (!RString.isNullOrEmpty(entity.getKyufuJissekiKubunCode())) {
            csvEntity.set給付実績区分名称(KyufuJissekiKubun.toValue(entity.getKyufuJissekiKubunCode()).get名称());
        } else {
            csvEntity.set給付実績区分名称(RString.EMPTY);
        }
        csvEntity.set事業所番号(getColumnValue(entity.getJigyoshoNo()));
        csvEntity.set事業所名(entity.getJigyoshoName());
        csvEntity.set要介護状態区分コード(entity.getYoKaigoJotaiKubunCode());
        if (!RString.isNullOrEmpty(entity.getYoKaigoJotaiKubunCode())) {
            csvEntity.set要介護状態区分名称(YokaigoJotaiKubun.toValue(entity.getYoKaigoJotaiKubunCode()).get名称());
        } else {
            csvEntity.set要介護状態区分名称(RString.EMPTY);
        }
        set旧措置入所者特例(entity, csvEntity);
        csvEntity.set認定有効期間_開始年月日(doパターン4(entity.getNinteiYukoKaishiYMD()));
        csvEntity.set認定有効期間_終了年月日(doパターン4(entity.getNinteiYukoShuryoYMD()));
        csvEntity.set老人保健市町村番号(entity.getRojinHokenShichosonNo());
        csvEntity.set老人保健受給者番号(entity.getRojinhokenJukyushaNo());
        csvEntity.set計画作成区分(entity.getKyotakuServiceSakuseiKubunCode());
        csvEntity.set計画事業所番号(entity.getSakujigyoshoNo());
        csvEntity.set計画事業所名(entity.getSakujigyoshoName());
        csvEntity.set入所院年月日(doパターン4(entity.getNyushoYMD()));
        csvEntity.set退所院年月日(doパターン4(entity.getTaishoYMD()));
        csvEntity.set入所院実日数(doカンマ編集(entity.getNyushoJitsunissu()));
        csvEntity.set保険給付率(doカンマ編集(entity.getHokenKyufuritsu()));
        csvEntity.set公費１給付率(doカンマ編集(entity.getKohi1Kyufuritsu()));
        csvEntity.set公費２給付率(doカンマ編集(entity.getKohi2Kyufuritsu()));
        csvEntity.set公費３給付率(doカンマ編集(entity.getKohi3Kyufuritsu()));
        csvEntity.set保険者番号後期(entity.getKokiHokenshaNo());
        csvEntity.set被保険者番号後期(entity.getKokiHiHokenshaNo());
        csvEntity.set保険者番号国保(entity.getKokuhoHokenshaNo());
        csvEntity.set被保険者証番号国保(entity.getKokuhoHiHokenshashoNo());
        csvEntity.set個人番号国保(entity.getKokuhoKojinNo());
        csvEntity.setサービスコード(entity.getServiceCode());
        csvEntity.setサービス名称(entity.getServiceName());
        csvEntity.setサービスコード名称(entity.getServiceCodeName());
        csvEntity.set単位数(doカンマ編集(entity.getAtoTanisu()));
        csvEntity.set日数回数(doカンマ編集(entity.getAtoNissuKaisu()));
        csvEntity.set公費１日数回数(doカンマ編集(entity.getAtoKohi1TaishoNissuKaisu()));
        csvEntity.set公費２日数回数(doカンマ編集(entity.getAtoKohi2TaishoNissukaisu()));
        csvEntity.set公費３日数回数(doカンマ編集(entity.getAtoKohi3TaishoNissuKaisu()));
        csvEntity.setサービス単位数(doカンマ編集(entity.getAtoServiceTanisu()));
        csvEntity.set公費１サービス単位数(doカンマ編集(entity.getAtoKohi1TaishoServiceTanisu()));
        csvEntity.set公費２サービス単位数(doカンマ編集(entity.getAtoKohi2TaishoServiceTanisu()));
        csvEntity.set公費３サービス単位数(doカンマ編集(entity.getAtoKohi3TaishoServiceTanisu()));
        csvEntity.set審査年月(doパターン54(entity.getShinsaYM()));

    }

    private void set旧措置入所者特例(DbWT3470chohyouShutsuryokuTempEntity entity, DbWT3470chohyouShutsuryokuyouCSVEntity csvEntity) {

        if (!RString.isNullOrEmpty(entity.getKyuSochiNyushoshaTokureiCode())) {

            if (無し.equals(entity.getKyuSochiNyushoshaTokureiCode())) {
                csvEntity.set旧措置入所者特例コード(KyuSochiNyushoshaTokureiCode.無し.getコード());
                csvEntity.set旧措置入所者特例名称(KyuSochiNyushoshaTokureiCode.無し.get名称());
            } else {
                csvEntity.set旧措置入所者特例コード(KyuSochiNyushoshaTokureiCode.有り.getコード());
                csvEntity.set旧措置入所者特例名称(KyuSochiNyushoshaTokureiCode.有り.get名称());
            }
        }
    }

    private IOutputOrder get並び順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        return order;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString doパターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString concat出力順(int i, RString 出力順, RString 条件) {
        if (i == INT_0) {
            出力順 = 出力順.concat(条件);
        } else {
            出力順 = 出力順.concat(コンマ).concat(条件);
        }
        return 出力順;
    }

    private void アクセスログ対象追加(DbWT3470chohyouShutsuryokuTempEntity entity) {
        if (null == entity.getShikibetsuCode() || entity.getShikibetsuCode().isEmpty()) {
            return;
        }
        if (識別コードset.contains(entity.getShikibetsuCode())) {
            return;
        }
        識別コードset.add(entity.getShikibetsuCode());
        PersonalData personalData = getPersonalData(entity);
        personalDataList.add(personalData);
    }

    private PersonalData getPersonalData(DbWT3470chohyouShutsuryokuTempEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(code, 漢字_被保険者番号,
                entity.getHiHokenshaNo().getColumnValue());
        return PersonalData.of(entity.getShikibetsuCode(), expandedInformations);
    }

    @Override
    protected void keyBreakProcess(DbWT3470chohyouShutsuryokuTempEntity t) {
    }
}
