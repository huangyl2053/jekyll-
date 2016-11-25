/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120270;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.shikakushogohyo.ShikakuShogohyoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.shikakushogohyo.ShikakuShogohyoReport;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ShikakuShogohyoKeikokuShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha.KyuSochiNyushoshaTokureiCode;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shikakushogohyoin.ShikakuShogohyoInDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin.ShikakuShogohyoInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin.ShikakuShogohyoInCsvEntitySingle;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin.ShikakuShogohyoInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.shikakushogohyo.ShikakuShogohyoSource;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
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
 * 介護給付費資格照合表情報取込の帳票データ出力クラスです。
 *
 * @reamsid_L DBC-2890-010 wangxingpeng
 */
public class ShikakuShogohyoInDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<ShikakuShogohyoInEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db."
            + "mapper.relate.shikakushogohyoin.IShikakuShogohyoInMapper.getCSVData");
    private static final RString CODE = new RString("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC100017");
    private static final RString 出力ファイル名 = new RString("DBC100017_ShikakuShogohyo.csv");
    private static final RString 実行不可MESSAGE = new RString("市町村セキュリティ情報の取得");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString SAKUSEI = new RString("作成");
    private static final int NUM_0 = 0;
    private static final int NUM_100 = 100;
    private static final int NUM_2 = 2;
    private static final int NUM_1 = 1;
    private static IYokaigoJotaiKubun 要介護状態区分;
    private final Set<RString> 識別コードset = new HashSet<>();
    private ShikakuShogohyoInDoIchiranhyoSakuseiProcessParameter parameter;
    private ShikakuShogohyoInCsvEntity csvEntity;
    private ShikakuShogohyoInCsvEntitySingle csvEntity1;
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
    private CsvWriter csvWriter;

    @BatchWriter

    private BatchReportWriter<ShikakuShogohyoSource> batchReportWriter_一覧表;
    private ReportSourceWriter<ShikakuShogohyoSource> reportSourceWriter_一覧表;

    @Override
    protected void initialize() {
        改頁リスト = new ArrayList<>();
        ShichosonSecurityJohoFinder finder = ShichosonSecurityJohoFinder.createInstance();
        this.市町村セキュリティ情報 = finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (null == this.市町村セキュリティ情報 || KaigoDonyuKubun.未導入.code().equals(市町村セキュリティ情報.get介護導入区分().code())) {
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
        PageBreaker<ShikakuShogohyoSource> breaker = new ShikakuShogohyoPageBreak(改頁リスト);
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100017.
                getReportId().getColumnValue()).addBreak(breaker).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
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
                csvEntity = new ShikakuShogohyoInCsvEntity();
                csvEntity1 = new ShikakuShogohyoInCsvEntitySingle();
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
                csvEntity = new ShikakuShogohyoInCsvEntity();
                csvEntity1 = new ShikakuShogohyoInCsvEntitySingle();
                editヘッダー項目(currentRecord);
            }
            edit明細項目(currentRecord);
            writeLine(currentRecord, true);
        }
        csvWriter.close();
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
            RString 作成日 = 作成日時.getDate().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
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
            RString 作成日 = 作成日時.getDate().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)
                    .concat(RString.HALF_SPACE).concat(SAKUSEI);
            RString 日時 = 作成日.concat(RString.HALF_SPACE).concat(作成時);
            csvEntity1.set作成日時(日時);
        }

    }

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

        ShikakuShogohyoReport report
                = new ShikakuShogohyoReport(is集計, 合計, entity, parameter.getシステム日付(), 連番, 導入形態コード);
        report.writeBy(reportSourceWriter_一覧表);
    }

    private void writeCsvLine(ShikakuShogohyoInCsvEntity entity, ShikakuShogohyoInCsvEntitySingle entity1) {
        if (市町村セキュリティ情報.get導入形態コード().is広域()) {
            csvWriter.writeLine(entity);
        } else {
            csvWriter.writeLine(entity1);
        }
    }

    private void edit明細項目(ShikakuShogohyoInEntity entity) {
        if (市町村セキュリティ情報.get導入形態コード().is広域()) {
            edit明細項目1(entity);
        } else {
            edit明細項目2(entity);
        }
        writeCsvLine(csvEntity, csvEntity1);
        csvEntity = new ShikakuShogohyoInCsvEntity();
        csvEntity1 = new ShikakuShogohyoInCsvEntitySingle();
    }

    private void edit被保険者(ShikakuShogohyoInEntity entity) {
        if (entity.get被保険者一時() != null) {
            csvEntity.set被保険者氏名(entity.get被保険者一時().get宛名名称());
            csvEntity.set被保険者番号(entity.get被保険者一時().get登録被保険者番号().getColumnValue());
            csvEntity.set証記載保険者番号(entity.get被保険者一時().get証記載保険者番号().getColumnValue());
        }
    }

    private void edit明細項目1(ShikakuShogohyoInEntity entity) {
        csvEntity.set連番(new RString(連番));
        edit被保険者(entity);

        if (entity.get資格照合表一時() != null) {
            editor編集(entity, csvEntity);
            if (entity.get資格照合表一時().getServiceTanisu() != null) {
                csvEntity.setサービス単位数(decimal_to_string(entity.get資格照合表一時().getServiceTanisu()));
            }
            if (entity.get資格照合表一時().getServiceTeikyoYM() != null) {
                csvEntity.setサービス提供年月(パターン54(entity.get資格照合表一時().getServiceTeikyoYM()));
            }
            csvEntity.setサービス日数_回数(new RString(entity.get資格照合表一時().getServiceNissuKaisu()));
            if (entity.get資格照合表一時().getServiceShuruiCode() != null) {
                csvEntity.setサービス種類コード(entity.get資格照合表一時().getServiceShuruiCode().getColumnValue());
            }

            csvEntity.setサービス種類名(entity.get資格照合表一時().getServiceShuruiMei());
            csvEntity.set事業者名(entity.get資格照合表一時().getJigyoshoMei());
            if (entity.get資格照合表一時().getJigyoshoNo() != null) {
                csvEntity.set事業者番号(entity.get資格照合表一時().getJigyoshoNo().getColumnValue());
            }

            if (entity.get資格照合表一時().getHokenKyufuRitsu().getColumnValue() != null) {
                csvEntity.set保険給付率(decimal_to_string(entity.get資格照合表一時().getHokenKyufuRitsu().getColumnValue()));
            }
            csvEntity.set保険者名(entity.get資格照合表一時().getHokenshaName());
            if (entity.get資格照合表一時().getHokenshaNo() != null) {
                csvEntity.set保険者番号(entity.get資格照合表一時().getHokenshaNo().getColumnValue());
            }

            if (entity.get資格照合表一時().getKyotakuServicePlanSakuseiKubunCode() != null
                    && !entity.get資格照合表一時().getKyotakuServicePlanSakuseiKubunCode().getColumnValue().isEmpty()) {
                csvEntity.set居宅サービス計画作成区分コード(entity.get資格照合表一時().getKyotakuServicePlanSakuseiKubunCode().getColumnValue());
                csvEntity.set居宅サービス計画作成区分(JukyushaIF_KeikakuSakuseiKubunCode.
                        toValue(entity.get資格照合表一時().getKyotakuServicePlanSakuseiKubunCode().getColumnValue()).get名称());
            }

            if (entity.get資格照合表一時().getShienJigyoshoNo() != null) {
                csvEntity.set支援事業者番号(entity.get資格照合表一時().getShienJigyoshoNo().getColumnValue());
            }

            csvEntity.set旧措置入所者特例コード(entity.get資格照合表一時().getKyusochiTokureiCode());
            if (!RString.isNullOrEmpty(entity.get資格照合表一時().getKyusochiTokureiCode())) {
                csvEntity.set旧措置入所者特例有無(KyuSochiNyushoshaTokureiCode.
                        toValue(entity.get資格照合表一時().getKyusochiTokureiCode()).get名称());
            }
            if (entity.get資格照合表一時().getTokuteiNyushoshaKaigoServiceGaku() != null) {
                csvEntity.set特定入所者介護サービス費等(decimal_to_string(entity.get資格照合表一時().getTokuteiNyushoshaKaigoServiceGaku()));
            }
            csvEntity.set要介護区分コード(entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
            if (entity.get資格照合表一時().getServiceTeikyoYM() != null
                    && entity.get資格照合表一時().getYokaigoKubunCode() != null) {
                要介護状態区分 = YokaigoJotaiKubunSupport.toValue(entity.get資格照合表一時().getServiceTeikyoYM(),
                        entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
                csvEntity.set要介護度(要介護状態区分.getName());
            }
            if (entity.get資格照合表一時().getShikyuGendoGaku() != null) {
                csvEntity.set訪問通所_短期入所支給限度額(decimal_to_string(entity.get資格照合表一時().getShikyuGendoGaku()));
            }
            csvEntity.set認定有効期間_終了(パターン4(entity.get資格照合表一時().getNinteiYukoKikanShuryoYMD()));
            csvEntity.set認定有効期間_開始(パターン4(entity.get資格照合表一時().getNinteiYukoKikanKaishiYMD()));
            if (!RString.isNullOrEmpty(entity.get資格照合表一時().getShubetsu())) {
                csvEntity.set警告種別(ShikakuShogohyoKeikokuShubetsu.toValue(entity.get資格照合表一時().getShubetsu()).get名称());
            }
            csvEntity.set限度額適用期間_終了(パターン4(entity.get資格照合表一時().getGendoGakuTekiyoKikanShuryoYMD()));
            csvEntity.set限度額適用期間_開始(パターン4(entity.get資格照合表一時().getGendoGakuTekiyoKikanKaishiYMD()));
            edit明細項目1食費(entity);
        }

    }

    private void edit明細項目1食費(ShikakuShogohyoInEntity entity) {
        if (entity.get資格照合表一時().getShokujiFutanGaku() != null) {
            csvEntity.set食事標準負担額(decimal_to_string(entity.get資格照合表一時().getShokujiFutanGaku()));
        }
        if (entity.get資格照合表一時().getNichiGakuShokujiFutanGaku() != null) {
            csvEntity.set食事標準負担額_日額(decimal_to_string(entity.get資格照合表一時().getNichiGakuShokujiFutanGaku()));
        }
        if (entity.get資格照合表一時().getGetsuGakuShokujiFutanGaku() != null) {
            csvEntity.set食事標準負担額_月額(decimal_to_string(entity.get資格照合表一時().getGetsuGakuShokujiFutanGaku()));
        }
        if (entity.get資格照合表一時().getShokuhiFutanGendoGaku() != null) {
            csvEntity.set食費負担限度額(decimal_to_string(entity.get資格照合表一時().getShokuhiFutanGendoGaku()));
        }
    }

    private void edit明細項目2被保険者(ShikakuShogohyoInEntity entity) {
        if (entity.get被保険者一時() != null) {
            csvEntity1.set被保険者氏名(entity.get被保険者一時().get宛名名称());
            csvEntity1.set被保険者番号(entity.get被保険者一時().get登録被保険者番号().getColumnValue());
        }
    }

    private void editサービス種類(ShikakuShogohyoInEntity entity) {

        if (entity.get資格照合表一時().getServiceShuruiCode() != null) {
            csvEntity1.setサービス種類コード(entity.get資格照合表一時().getServiceShuruiCode().getColumnValue());

        }
        csvEntity1.setサービス種類名(entity.get資格照合表一時().getServiceShuruiMei());
    }

    private void edit事業者(ShikakuShogohyoInEntity entity) {
        csvEntity1.set事業者名(entity.get資格照合表一時().getJigyoshoMei());
        if (entity.get資格照合表一時().getJigyoshoNo() != null) {
            csvEntity1.set事業者番号(entity.get資格照合表一時().getJigyoshoNo().getColumnValue());

        }
    }

    private void edit明細項目2(ShikakuShogohyoInEntity entity) {
        csvEntity1.set連番(new RString(連番));
        edit明細項目2被保険者(entity);
        if (entity.get資格照合表一時() != null) {
            editor編集1(entity, csvEntity1);
            if (entity.get資格照合表一時().getServiceTanisu() != null) {
                csvEntity1.setサービス単位数(decimal_to_string(entity.get資格照合表一時().getServiceTanisu()));
            }
            if (entity.get資格照合表一時().getServiceTeikyoYM() != null) {
                csvEntity1.setサービス提供年月(パターン54(entity.get資格照合表一時().getServiceTeikyoYM()));
            }
            csvEntity1.setサービス日数_回数(new RString(entity.get資格照合表一時().getServiceNissuKaisu()));
            editサービス種類(entity);
            edit事業者(entity);
            if (entity.get資格照合表一時().getHokenKyufuRitsu().getColumnValue() != null) {
                csvEntity1.set保険給付率(decimal_to_string(entity.get資格照合表一時().getHokenKyufuRitsu().getColumnValue()));
            }
            csvEntity1.set保険者名(entity.get資格照合表一時().getHokenshaName());

            if (entity.get資格照合表一時().getHokenshaNo() != null) {
                csvEntity1.set保険者番号(entity.get資格照合表一時().getHokenshaNo().getColumnValue());
            }
            if (entity.get資格照合表一時().getKyotakuServicePlanSakuseiKubunCode() != null
                    && !entity.get資格照合表一時().getKyotakuServicePlanSakuseiKubunCode().getKey().isEmpty()) {
                csvEntity1.set居宅サービス計画作成区分コード(entity.get資格照合表一時().getKyotakuServicePlanSakuseiKubunCode().getColumnValue());
                csvEntity1.set居宅サービス計画作成区分(JukyushaIF_KeikakuSakuseiKubunCode.
                        toValue(entity.get資格照合表一時().getKyotakuServicePlanSakuseiKubunCode().getColumnValue()).get名称());
            }

            if (entity.get資格照合表一時().getShienJigyoshoNo() != null) {
                csvEntity1.set支援事業者番号(entity.get資格照合表一時().getShienJigyoshoNo().getColumnValue());

            }
            csvEntity1.set旧措置入所者特例コード(entity.get資格照合表一時().getKyusochiTokureiCode());
            if (!RString.isNullOrEmpty(entity.get資格照合表一時().getKyusochiTokureiCode())) {
                csvEntity1.set旧措置入所者特例有無(KyuSochiNyushoshaTokureiCode.
                        toValue(entity.get資格照合表一時().getKyusochiTokureiCode()).get名称());
            }
            if (entity.get資格照合表一時().getTokuteiNyushoshaKaigoServiceGaku() != null) {
                csvEntity1.set特定入所者介護サービス費等(decimal_to_string(entity.get資格照合表一時().getTokuteiNyushoshaKaigoServiceGaku()));
            }
            if (entity.get資格照合表一時().getYokaigoKubunCode() != null) {
                csvEntity1.set要介護区分コード(entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
            }
            if (entity.get資格照合表一時().getServiceTeikyoYM() != null
                    && entity.get資格照合表一時().getYokaigoKubunCode() != null) {
                要介護状態区分 = YokaigoJotaiKubunSupport.toValue(entity.get資格照合表一時().getServiceTeikyoYM(),
                        entity.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
                csvEntity1.set要介護度(要介護状態区分.getName());
            }
            if (entity.get資格照合表一時().getShikyuGendoGaku() != null) {
                csvEntity1.set訪問通所_短期入所支給限度額(decimal_to_string(entity.get資格照合表一時().getShikyuGendoGaku()));
            }
            csvEntity1.set認定有効期間_終了(パターン4(entity.get資格照合表一時().getNinteiYukoKikanShuryoYMD()));
            csvEntity1.set認定有効期間_開始(パターン4(entity.get資格照合表一時().getNinteiYukoKikanKaishiYMD()));
            if (!RString.isNullOrEmpty(entity.get資格照合表一時().getShubetsu())) {
                csvEntity1.set警告種別(ShikakuShogohyoKeikokuShubetsu.toValue(entity.get資格照合表一時().getShubetsu()).get名称());
            }
            csvEntity1.set限度額適用期間_終了(パターン4(entity.get資格照合表一時().getGendoGakuTekiyoKikanShuryoYMD()));
            csvEntity1.set限度額適用期間_開始(パターン4(entity.get資格照合表一時().getGendoGakuTekiyoKikanKaishiYMD()));
            edit食事(entity);
        }

    }

    private void edit食事(ShikakuShogohyoInEntity entity) {
        if (entity.get資格照合表一時().getShokujiFutanGaku() != null) {
            csvEntity1.set食事標準負担額(decimal_to_string(entity.get資格照合表一時().getShokujiFutanGaku()));
        }
        if (entity.get資格照合表一時().getNichiGakuShokujiFutanGaku() != null) {
            csvEntity1.set食事標準負担額_日額(decimal_to_string(entity.get資格照合表一時().getNichiGakuShokujiFutanGaku()));
        }
        if (entity.get資格照合表一時().getGetsuGakuShokujiFutanGaku() != null) {
            csvEntity1.set食事標準負担額_月額(decimal_to_string(entity.get資格照合表一時().getGetsuGakuShokujiFutanGaku()));
        }
        if (entity.get資格照合表一時().getShokuhiFutanGendoGaku() != null) {
            csvEntity1.set食費負担限度額(decimal_to_string(entity.get資格照合表一時().getShokuhiFutanGendoGaku()));
        }
    }

    private void editor編集(ShikakuShogohyoInEntity entity, ShikakuShogohyoInCsvEntity csvEntity) {
        if (entity.get資格照合表一時().getKohi1KyufuRitsu() != null) {
            csvEntity.set公費1給付率(decimal_to_string(entity.get資格照合表一時().getKohi1KyufuRitsu().getColumnValue()));
        }
        if (entity.get資格照合表一時().getKohi2KyufuRitsu() != null) {
            csvEntity.set公費2給付率(decimal_to_string(entity.get資格照合表一時().getKohi2KyufuRitsu().getColumnValue()));
        }
        if (entity.get資格照合表一時().getKohi3KyufuRitsu() != null) {
            csvEntity.set公費3給付率(decimal_to_string(entity.get資格照合表一時().getKohi3KyufuRitsu().getColumnValue()));
        }
        if (entity.get資格照合表一時().getRiyoshaFutanGaku() != null) {
            csvEntity.set利用者負担額(decimal_to_string(entity.get資格照合表一時().getRiyoshaFutanGaku()));
        }
        if (entity.get資格照合表一時().getTanisuTanka().
                divide(NUM_100).roundHalfUpTo(NUM_2).toString() != null) {
            csvEntity.set単位数単価(new RString(entity.get資格照合表一時().getTanisuTanka().
                    divide(NUM_100).roundHalfUpTo(NUM_2).toString()));
        }
        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku1() != null) {
            csvEntity.set居住費負担限度額_ユニット型個室(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku1()));
        }
        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku2() != null) {
            csvEntity.set居住費負担限度額_ユニット型準個室(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku2()));
        }

        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku5() != null) {
            csvEntity.set居住費負担限度額_多床室(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku5()));
        }
        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku3() != null) {
            csvEntity.set居住費負担限度額_従来型個室_特養等(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku3()));
        }
        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku4() != null) {
            csvEntity.set居住費負担限度額_従来型個室_老健_療養等(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku4()));
        }
    }

    private void editor編集1(ShikakuShogohyoInEntity entity, ShikakuShogohyoInCsvEntitySingle csvEntity) {
        if (entity.get資格照合表一時().getKohi1KyufuRitsu() != null) {
            csvEntity.set公費1給付率(decimal_to_string(entity.get資格照合表一時().getKohi1KyufuRitsu().getColumnValue()));
        }
        if (entity.get資格照合表一時().getKohi2KyufuRitsu() != null) {
            csvEntity.set公費2給付率(decimal_to_string(entity.get資格照合表一時().getKohi2KyufuRitsu().getColumnValue()));
        }
        if (entity.get資格照合表一時().getKohi3KyufuRitsu() != null) {
            csvEntity.set公費3給付率(decimal_to_string(entity.get資格照合表一時().getKohi3KyufuRitsu().getColumnValue()));
        }
        if (entity.get資格照合表一時().getRiyoshaFutanGaku() != null) {
            csvEntity.set利用者負担額(decimal_to_string(entity.get資格照合表一時().getRiyoshaFutanGaku()));
        }
        if (entity.get資格照合表一時().getTanisuTanka().
                divide(NUM_100).roundHalfUpTo(NUM_2).toString() != null) {
            csvEntity.set単位数単価(new RString(entity.get資格照合表一時().getTanisuTanka().
                    divide(NUM_100).roundHalfUpTo(NUM_2).toString()));
        }
        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku1() != null) {
            csvEntity.set居住費負担限度額_ユニット型個室(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku1()));
        }
        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku2() != null) {
            csvEntity.set居住費負担限度額_ユニット型準個室(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku2()));
        }

        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku5() != null) {
            csvEntity.set居住費負担限度額_多床室(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku5()));
        }
        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku3() != null) {
            csvEntity.set居住費負担限度額_従来型個室_特養等(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku3()));
        }
        if (entity.get資格照合表一時().getKyojuhiFutanGendoGaku4() != null) {
            csvEntity.set居住費負担限度額_従来型個室_老健_療養等(decimal_to_string(entity.get資格照合表一時().getKyojuhiFutanGendoGaku4()));
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
