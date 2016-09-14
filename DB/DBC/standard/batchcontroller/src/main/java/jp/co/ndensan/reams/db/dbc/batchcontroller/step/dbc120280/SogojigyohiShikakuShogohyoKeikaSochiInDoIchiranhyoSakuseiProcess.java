/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120280;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishikakushogohyokeikasochi.SogojigyohiShikakuShogohyoKeikaSochiPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishikakushogohyokeikasochi.SogojigyohiShikakuShogohyoKeikaSochiReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ShikakuShogohyoKeikokuShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohishikakushogohyokeikasochiin.SogojigyohiShikakuShogohyoKeikaSochiInProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin.ShikakuShogohyoInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishikakushogohyokeikasochiin.SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishikakushogohyokeikasochiin.SogojigyohiShikakuShogohyoKeikaSochiInCsvEntitySingle;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohishikakushogohyokeikasochi.SogojigyohiShikakuShogohyoKeikaSochiSource;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費（経過措置）資格照合表情報取込の帳票データ出力クラスです。
 *
 * @reamsid_L DBC-2890-011 wangxingpeng
 */
public class SogojigyohiShikakuShogohyoKeikaSochiInDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<ShikakuShogohyoInEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db."
            + "mapper.relate.shikakushogohyoin.IShikakuShogohyoInMapper.getCSVData");
    private static final RString CODE = new RString("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC100018");
    private static final RString 出力ファイル名 = new RString("DBC100018_SogojigyohiShikakuShogohyoKeikaSochi.csv");
    private static final RString 実行不可MESSAGE = new RString("市町村セキュリティ情報の取得");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString SAKUSEI = new RString("作成");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static IYokaigoJotaiKubun 要介護状態区分;
    private final Set<RString> 識別コードset = new HashSet<>();
    private SogojigyohiShikakuShogohyoKeikaSochiInProcessParameter parameter;
    private SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity csvEntity;
    private SogojigyohiShikakuShogohyoKeikaSochiInCsvEntitySingle csvEntity1;
    private List<RString> 改頁リスト;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private ShikakuShogohyoInEntity currentRecord;
    private ShichosonSecurityJoho 市町村セキュリティ情報;
    private DonyuKeitaiCode 導入形態コード;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private YMDHMS 作成日時;
    private int 連番;
    private int 合計 = 0;
    private int count = 0;
    @BatchWriter
    private CsvWriter eucCsvWriter;
    @BatchWriter
    private CsvWriter eucCsvWriter1;

    @BatchWriter
    private BatchReportWriter<SogojigyohiShikakuShogohyoKeikaSochiSource> batchReportWriter_一覧表;
    private ReportSourceWriter<SogojigyohiShikakuShogohyoKeikaSochiSource> reportSourceWriter_一覧表;

    @Override
    protected void initialize() {
        連番 = NUM_0;
        改頁リスト = new ArrayList<>();
        ShichosonSecurityJohoFinder finder = ShichosonSecurityJohoFinder.createInstance();
        this.市町村セキュリティ情報 = finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (null == this.市町村セキュリティ情報) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);

    }

    @Override
    protected void createWriter() {
        PageBreaker<SogojigyohiShikakuShogohyoKeikaSochiSource> breaker = new SogojigyohiShikakuShogohyoKeikaSochiPageBreak(改頁リスト);
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100018
                .getReportId().getColumnValue()).addBreak(breaker).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = BatchWriters.csvWriter(SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity.class).
                filePath(eucFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).build();
        eucCsvWriter1 = BatchWriters.csvWriter(SogojigyohiShikakuShogohyoKeikaSochiInCsvEntitySingle.class).
                filePath(eucFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).build();

    }

    @Override
    protected void usualProcess(ShikakuShogohyoInEntity entity) {
        アクセスログ対象追加(entity);
        currentRecord = entity;

        ShikakuShogohyoInEntity beforeEntity = getBefore();
        if (null != beforeEntity) {
            if (null == csvEntity) {
                csvEntity = new SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity();
                csvEntity1 = new SogojigyohiShikakuShogohyoKeikaSochiInCsvEntitySingle();
                editヘッダー項目(currentRecord);
            }
            if (is改頁(beforeEntity, entity)) {
                edit明細項目(beforeEntity);
                writeLine(beforeEntity, true);
            } else {
                edit明細項目(beforeEntity);
                writeLine(beforeEntity, false);
            }
        }
        連番 = 連番 + 1;
    }

    @Override
    protected void keyBreakProcess(ShikakuShogohyoInEntity t) {

    }

    @Override
    protected void afterExecute() {
        if (連番 != 0) {
            if (1 == 連番) {
                csvEntity = new SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity();
                csvEntity1 = new SogojigyohiShikakuShogohyoKeikaSochiInCsvEntitySingle();
                editヘッダー項目(currentRecord);
            }
            edit明細項目(currentRecord);
            writeLine(currentRecord, true);
        }
        eucCsvWriter.close();
        eucCsvWriter1.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        } else {
            manager.spool(eucFilePath);
        }

    }

    private void アクセスログ対象追加(ShikakuShogohyoInEntity entity) {
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get被保険者一時();
        RString 識別コード = 被保険者.get識別コード();
        if (null == 識別コード || 識別コード.isEmpty()) {
            return;
        }
        if (識別コードset.contains(識別コード)) {
            return;
        }
        識別コードset.add(識別コード);
        PersonalData personalData = getPersonalData(被保険者);
        personalDataList.add(personalData);
    }

    private void editヘッダー項目(ShikakuShogohyoInEntity entity) {
        if (市町村セキュリティ情報.get導入形態コード().is広域()) {
            editヘッダー項目1(entity);
        } else {

            editヘッダー項目2(entity);
        }
    }

    private void editヘッダー項目1(ShikakuShogohyoInEntity entity) {
        RString 審査年月 = entity.get資格照合表一時().getShinsaYM().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        csvEntity.set審査年月(審査年月);
        if (parameter.getシステム日付() != null) {
            作成日時 = parameter.getシステム日付();
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)
                    .concat(RString.HALF_SPACE).concat(SAKUSEI);
            RString 日時 = 作成日.concat(RString.HALF_SPACE).concat(作成時);
            csvEntity.set作成日時(日時);
        }
    }

    private void editヘッダー項目2(ShikakuShogohyoInEntity entity) {
        RString 審査年月 = entity.get資格照合表一時().getShinsaYM().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        csvEntity1.set審査年月(審査年月);
        if (parameter.getシステム日付() != null) {
            作成日時 = parameter.getシステム日付();
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)
                    .concat(RString.HALF_SPACE).concat(SAKUSEI);
            RString 日時 = 作成日.concat(RString.HALF_SPACE).concat(作成時);
            csvEntity1.set作成日時(日時);
        }
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource ShikakuShogohyoInEntity
     * @param nextSource ShikakuShogohyoInEntity
     * @return 改頁Flag
     */
    private boolean is改頁(ShikakuShogohyoInEntity currentSource,
            ShikakuShogohyoInEntity nextSource) {
        boolean flag = false;
        if (!currentSource.get資格照合表一時().getHokenshaNo()
                .equals(nextSource.get資格照合表一時().getHokenshaNo())) {
            flag = true;
        }
        return flag;
    }

    private PersonalData getPersonalData(DbWT0001HihokenshaTempEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), 被保険者番号,
                entity.get登録被保険者番号().getColumnValue());
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInfo);
    }

    private void writeLine(ShikakuShogohyoInEntity entity, boolean is集計) {
        導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        count = count + NUM_1;
        if (is集計) {
            合計 = count;
            count = NUM_0;
        }

        SogojigyohiShikakuShogohyoKeikaSochiReport report
                = new SogojigyohiShikakuShogohyoKeikaSochiReport(is集計, 合計, entity, parameter.getシステム日付(), 連番, 導入形態コード);
        report.writeBy(reportSourceWriter_一覧表);
    }

    private void writeCsvLine(SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity entity, SogojigyohiShikakuShogohyoKeikaSochiInCsvEntitySingle entity1) {
        if (市町村セキュリティ情報.get導入形態コード().is広域()) {
            eucCsvWriter.writeLine(entity);
        } else {
            eucCsvWriter1.writeLine(entity1);
        }
    }

    private void edit明細項目(ShikakuShogohyoInEntity entity) {
        if (市町村セキュリティ情報.get導入形態コード().is広域()) {
            edit明細項目1(entity);
        } else {
            edit明細項目2(entity);
        }

        writeCsvLine(csvEntity, csvEntity1);
        csvEntity = new SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity();
        csvEntity1 = new SogojigyohiShikakuShogohyoKeikaSochiInCsvEntitySingle();
    }

    private void edit明細項目1(ShikakuShogohyoInEntity entity) {
        csvEntity.set連番(new RString(連番));
        if (entity.get被保険者一時() != null) {
            csvEntity.set被保険者氏名(entity.get被保険者一時().get宛名名称());
            csvEntity.set被保険者番号(entity.get被保険者一時().get登録被保険者番号().getColumnValue());
            csvEntity.set証記載保険者番号(entity.get被保険者一時().get証記載保険者番号().getColumnValue());
        }
        if (entity.get資格照合表一時() != null) {
            if (entity.get資格照合表一時().getServiceTanisu() != null) {
                csvEntity.setサービス単位数(decimal_to_string(entity.get資格照合表一時().getServiceTanisu()));
            }
            if (entity.get資格照合表一時().getServiceTeikyoYM() != null) {
                csvEntity.setサービス提供年月(パターン54(entity.get資格照合表一時().getServiceTeikyoYM()));
            }
            csvEntity.setサービス日数_回数(new RString(entity.get資格照合表一時().getServiceNissuKaisu()));
            csvEntity.setサービス種類コード(entity.get資格照合表一時().getServiceShuruiCode().getColumnValue());
            csvEntity.setサービス種類名(entity.get資格照合表一時().getServiceShuruiMei());
            csvEntity.set事業者名(entity.get資格照合表一時().getJigyoshoMei());
            csvEntity.set事業者番号(entity.get資格照合表一時().getJigyoshoNo().getColumnValue());
            csvEntity.set保険者名(entity.get資格照合表一時().getHokenshaName());
            csvEntity.set保険者番号(entity.get資格照合表一時().getHokenshaNo().getColumnValue());
            if (entity.get資格照合表一時().getRiyoshaFutanGaku() != null) {
                csvEntity.set利用者負担額(decimal_to_string(entity.get資格照合表一時().getRiyoshaFutanGaku()));
            }
            csvEntity.set要介護区分コード(entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
            if (entity.get資格照合表一時().getServiceTeikyoYM() != null
                    && entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue() != null) {
                要介護状態区分 = YokaigoJotaiKubunSupport.toValue(entity.get資格照合表一時().getServiceTeikyoYM(),
                        entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
                csvEntity.set要介護度(要介護状態区分.getName());
            }
            csvEntity.set認定有効期間_終了(パターン4(entity.get資格照合表一時().getNinteiYukoKikanShuryoYMD()));
            csvEntity.set認定有効期間_開始(パターン4(entity.get資格照合表一時().getNinteiYukoKikanKaishiYMD()));
            if (entity.get資格照合表一時().getShubetsu() != null) {
                csvEntity.set警告種別(ShikakuShogohyoKeikokuShubetsu.toValue(entity.get資格照合表一時().getShubetsu()).get名称());
            }
        }
    }

    private void edit明細項目2(ShikakuShogohyoInEntity entity) {
        csvEntity1.set連番(new RString(連番));
        if (entity.get被保険者一時() != null) {
            csvEntity1.set被保険者氏名(entity.get被保険者一時().get宛名名称());
            csvEntity1.set被保険者番号(entity.get被保険者一時().get登録被保険者番号().getColumnValue());

        }
        if (entity.get資格照合表一時() != null) {
            if (entity.get資格照合表一時().getServiceTanisu() != null) {
                csvEntity1.setサービス単位数(decimal_to_string(entity.get資格照合表一時().getServiceTanisu()));
            }
            if (entity.get資格照合表一時().getServiceTeikyoYM() != null) {
                csvEntity1.setサービス提供年月(パターン54(entity.get資格照合表一時().getServiceTeikyoYM()));
            }
            csvEntity1.setサービス日数_回数(new RString(entity.get資格照合表一時().getServiceNissuKaisu()));
            csvEntity1.setサービス種類コード(entity.get資格照合表一時().getServiceShuruiCode().getColumnValue());
            csvEntity1.setサービス種類名(entity.get資格照合表一時().getServiceShuruiMei());
            csvEntity1.set事業者名(entity.get資格照合表一時().getJigyoshoMei());
            csvEntity1.set事業者番号(entity.get資格照合表一時().getJigyoshoNo().getColumnValue());
            csvEntity1.set保険者名(entity.get資格照合表一時().getHokenshaName());
            csvEntity1.set保険者番号(entity.get資格照合表一時().getHokenshaNo().getColumnValue());
            if (entity.get資格照合表一時().getRiyoshaFutanGaku() != null) {
                csvEntity1.set利用者負担額(decimal_to_string(entity.get資格照合表一時().getRiyoshaFutanGaku()));
            }
            csvEntity1.set要介護区分コード(entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
            if (entity.get資格照合表一時().getServiceTeikyoYM() != null
                    && entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue() != null) {
                要介護状態区分 = YokaigoJotaiKubunSupport.toValue(entity.get資格照合表一時().getServiceTeikyoYM(),
                        entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
                csvEntity1.set要介護度(要介護状態区分.getName());
            }
            csvEntity1.set認定有効期間_終了(パターン4(entity.get資格照合表一時().getNinteiYukoKikanShuryoYMD()));
            csvEntity1.set認定有効期間_開始(パターン4(entity.get資格照合表一時().getNinteiYukoKikanKaishiYMD()));
            if (entity.get資格照合表一時().getShubetsu() != null) {
                csvEntity1.set警告種別(ShikakuShogohyoKeikokuShubetsu.toValue(entity.get資格照合表一時().getShubetsu()).get名称());
            }
        }
    }

    /**
     * 数値からstringに転換する。
     *
     * @param number 数値
     * @return カンマで編集した値
     */
    private static RString decimal_to_string(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    /**
     * 日付からstringに転換する。
     *
     * @param 年月日 日付
     * @return stringで表示する日付
     */
    private static RString パターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    /**
     * 年月stringに転換する。
     *
     * @param 年月 FlexibleYearMonth
     * @return stringで表示する年月
     */
    private RString パターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
