/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranParameter;
import jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoin.KyufukanrihyoDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufukanrihyoin.KyufukanrihyoIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT1121KyufuKanrihyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin.HihokenshaKyufukanrihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
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
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
public class KyufukanrihyoDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<HihokenshaKyufukanrihyoEntity> {

    private KyufukanrihyoDoIchiranhyoSakuseiProcessParameter parameter;
    private IOutputOrder 並び順;
    private List<RString> 改頁項目リスト;
    private Map<RString, RString> 出力順Map;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private List<HihokenshaKyufukanrihyoEntity> entityList;
    private HihokenshaKyufukanrihyoEntity currentRecord;
    private KyufukanrihyoIchiranCSVEntity csvEntity;
    private final Set<RString> 識別コードset = new HashSet<>();
    private int 連番;
    private int 件数1 = 0;
    private int 件数2 = 0;
    private int 件数3 = 0;
    private int 合計件数 = 0;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 給付管理票種別区分コード1 = new RString("1");
    private static final RString 給付管理票種別区分コード2 = new RString("2");
    private static final RString 給付管理票種別区分コード3 = new RString("3");
    private static final RString 居宅サービス計画作成区分コード_自己作成 = new RString("2");
    private static final RString 備考_支援事業者未登録 = new RString("2");
    private static final FlexibleYearMonth 基準サービス提供年月 = new FlexibleYearMonth("200604");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200073");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufukanrihyoin.IKyufukanrihyoInMapper.get帳票出力対象データ");
    private static final RString 出力ファイル名
            = new RString("DBC200073_KyufuKanrihyoTorikomiKekkaIchiran.csv");
    private static final RString デフォルト出力順 = new RString(" ORDER BY \"DbWT1121KyufuKanrihyo\".\"hokenshaNo\" ASC ");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");

    @BatchWriter
    private CsvWriter eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<KyufuKanrihyoTorikomiKekkaIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<KyufuKanrihyoTorikomiKekkaIchiranSource> reportSourceWriter_一覧表;

    @Override
    protected void initialize() {
        super.initialize();
        改頁項目リスト = new ArrayList<>();
        出力順Map = new HashMap<>();
        entityList = new ArrayList<>();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        並び順 = get並び順(parameter.get帳票ID(), parameter.get出力順ID());
        RString 出力順 = MyBatisOrderByClauseCreator
                .create(KyufuKanrihyoTorikomiKekkaIchiranProperty.DBC200073BreakerFieldsEnum.class, 並び順);
        if (RString.isNullOrEmpty(出力順)) {
            出力順 = デフォルト出力順;
        } else {
            List<RString> 出力順BODY = 出力順.split(コンマ.toString());
            出力順 = デフォルト出力順;
            if (出力順BODY.size() > 1) {
                for (int i = 1; i < 出力順BODY.size(); i++) {
                    出力順 = 出力順.concat(コンマ).concat(出力順BODY.get(i));
                }
            }
        }
        帳票データの取得Parameter.set出力順(出力順);
    }

    @Override
    protected void beforeExecute() {
        if (並び順 != null) {
            int i = 0;
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                }
                if (i == INT_1) {
                    出力順Map.put(KEY_並び順の２件目, item.get項目名());
                } else if (i == INT_2) {
                    出力順Map.put(KEY_並び順の３件目, item.get項目名());
                } else if (i == INT_3) {
                    出力順Map.put(KEY_並び順の４件目, item.get項目名());
                } else if (i == INT_4) {
                    出力順Map.put(KEY_並び順の５件目, item.get項目名());
                } else if (i == INT_5) {
                    出力順Map.put(KEY_並び順の６件目, item.get項目名());
                }
                i = i + 1;
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<KyufuKanrihyoTorikomiKekkaIchiranSource> breaker = new KyufuKanrihyoTorikomiKekkaIchiranPageBreak(改頁項目リスト);
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(
                parameter.get帳票ID().value()).addBreak(breaker).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void usualProcess(HihokenshaKyufukanrihyoEntity entity) {
        アクセスログ対象追加(entity);

        currentRecord = entity;
        entityList.add(entity);
        HihokenshaKyufukanrihyoEntity beforeEntity = getBefore();
        if (null != beforeEntity) {
            if (null == csvEntity) {
                csvEntity = new KyufukanrihyoIchiranCSVEntity();
                editヘッダー項目(beforeEntity);
            }
            if (is改頁(beforeEntity, entity)) {
                edit明細項目(beforeEntity);
                edit集計項目(beforeEntity);
                writeLine(beforeEntity, true);
            } else {
                edit明細項目(beforeEntity);
                writeLine(beforeEntity, false);
            }
        }
        連番 = 連番 + 1;
    }

    @Override
    protected void keyBreakProcess(HihokenshaKyufukanrihyoEntity t) {
    }

    @Override
    protected void afterExecute() {
        if (!entityList.isEmpty()) {
            writeLine(currentRecord, true);
            if (1 == entityList.size()) {
                csvEntity = new KyufukanrihyoIchiranCSVEntity();
                editヘッダー項目(currentRecord);
            }
            edit明細項目(currentRecord);
            edit集計項目(currentRecord);
        }
        eucCsvWriter.close();

        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        }
    }

    private IOutputOrder get並び順(ReportId 帳票分類ID, RString 出力順ID) {
        if (RString.isNullOrEmpty(出力順ID)) {
            return null;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        return outputOrder;
    }

    private void 件数編集(HihokenshaKyufukanrihyoEntity entity) {
        RString 給付管理票種別区分コード = entity.get給付管理票().get給付管理票種別区分コード();
        if (給付管理票種別区分コード1.equals(給付管理票種別区分コード)) {
            件数1 = 件数1 + 1;
        } else if (給付管理票種別区分コード2.equals(給付管理票種別区分コード)) {
            件数2 = 件数2 + 1;
        } else if (給付管理票種別区分コード3.equals(給付管理票種別区分コード)) {
            件数3 = 件数3 + 1;
        }
        合計件数 = 合計件数 + 1;
    }

    private void アクセスログ対象追加(HihokenshaKyufukanrihyoEntity entity) {
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get被保険者();
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

    private PersonalData getPersonalData(DbWT0001HihokenshaTempEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource HihokenshaKyufukanrihyoEntity
     * @param nextSource HihokenshaKyufukanrihyoEntity
     * @return 改頁Flag
     */
    public boolean is改頁(HihokenshaKyufukanrihyoEntity currentSource,
            HihokenshaKyufukanrihyoEntity nextSource) {
        boolean flag = false;
        if (!currentSource.get給付管理票().getコントロールレコード保険者番号()
                .equals(nextSource.get給付管理票().getコントロールレコード保険者番号())) {
            flag = true;
        }
        return flag;
    }

    private void writeLine(HihokenshaKyufukanrihyoEntity entity, boolean is集計) {
        KyufuKanrihyoTorikomiKekkaIchiranParameter パラメータ
                = new KyufuKanrihyoTorikomiKekkaIchiranParameter(entity,
                        出力順Map, 改頁項目リスト, parameter.get処理年月(),
                        parameter.getシステム日付(), parameter.get導入形態コード(), is集計, 連番);
        if (is集計) {
            パラメータ.set件数1(件数1);
            パラメータ.set件数2(件数2);
            パラメータ.set件数3(件数3);
            パラメータ.set合計件数(合計件数);
            件数1 = INT_0;
            件数2 = INT_0;
            件数3 = INT_0;
            合計件数 = INT_0;
        }
        KyufuKanrihyoTorikomiKekkaIchiranReport report = new KyufuKanrihyoTorikomiKekkaIchiranReport(パラメータ);
        report.writeBy(reportSourceWriter_一覧表);
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, INT_0);
    }

    private void editヘッダー項目(HihokenshaKyufukanrihyoEntity entity) {
        csvEntity.set取込年月(parameter.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        RString 作成日 = parameter.getシステム日付().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = parameter.getシステム日付().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        csvEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
    }

    private void edit明細項目(HihokenshaKyufukanrihyoEntity entity) {
        件数編集(entity);
        DbWT1121KyufuKanrihyoTempEntity 給付管理票 = entity.get給付管理票();
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get被保険者();
        csvEntity.set保険者番号(給付管理票.getコントロールレコード保険者番号());
        csvEntity.set保険者名(給付管理票.getコントロールレコード保険者名());
        csvEntity.setNo(new RString(連番));
        csvEntity.set対象年月(doパターン54(給付管理票.getサービス提供年月()));
        RString 計画作成区分コード = 給付管理票.get居宅サービス計画作成区分コード();
        if (居宅サービス計画作成区分コード_自己作成.equals(計画作成区分コード)) {
            csvEntity.set支援事業者番号(RString.EMPTY);
            csvEntity.set支援事業者名(RString.EMPTY);
            JukyushaIF_KeikakuSakuseiKubunCode 居宅サービス計画作成区分
                    = JukyushaIF_KeikakuSakuseiKubunCode.toValue(給付管理票.get居宅サービス計画作成区分コード());
            RString 居宅サービス計画作成区分名称 = (null != 居宅サービス計画作成区分)
                    ? 居宅サービス計画作成区分.get名称() : RString.EMPTY;
            csvEntity.set計画作成区分(居宅サービス計画作成区分名称);
        } else {
            csvEntity.set支援事業者番号(給付管理票.get居宅支援事業所番号());
            csvEntity.set支援事業者名(給付管理票.get事業者名称());
            csvEntity.set計画作成区分(RString.EMPTY);
        }
        csvEntity.set作成区分(給付管理票.get給付管理票情報作成区分コード());
        RString 作成区分名 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.給付管理票情報作成区分.getコード(),
                new Code(給付管理票.get給付管理票情報作成区分コード()));
        csvEntity.set作成区分名(RString.isNullOrEmpty(作成区分名) ? RString.EMPTY : 作成区分名);
        csvEntity.set被保険者番号(getColumnValue(被保険者.get登録被保険者番号()));
        csvEntity.set被保険者氏名(被保険者.get宛名名称());
        csvEntity.set作成種別区分(給付管理票.get給付管理票種別区分コード());
        RString 作成種別区分名 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.給付管理票種別区分.getコード(),
                new Code(給付管理票.get給付管理票種別区分コード()));
        csvEntity.set作成種別区分名(RString.isNullOrEmpty(作成種別区分名) ? RString.EMPTY : 作成種別区分名);
        csvEntity.set要介護状態区分(給付管理票.get要介護状態区分コード());
        IYokaigoJotaiKubun 要介護状態区分 = YokaigoJotaiKubunSupport.toValue(給付管理票.getサービス提供年月(),
                給付管理票.get要介護状態区分コード());
        csvEntity.set要介護度((null != 要介護状態区分) ? 要介護状態区分.getName() : RString.EMPTY);
        csvEntity.set限度額管理期間_開始(doパターン54(給付管理票.get限度額適用開始年月()));
        csvEntity.set限度額管理期間_終了(doパターン54(給付管理票.get限度額適用終了年月()));
        csvEntity.set区分支給限度基準額(doカンマ編集(給付管理票.get居宅_介護予防支給限度額()));
        if (null != 給付管理票.getサービス提供年月() && 給付管理票.getサービス提供年月().isBefore(基準サービス提供年月)) {
            csvEntity.set指定サービス単位(doカンマ編集(給付管理票.get指定サービス分小計()));
            csvEntity.set基準該当サービス単位(doカンマ編集(給付管理票.get基準該当サービス分小計()));
        }
        csvEntity.set合計単位(doカンマ編集(給付管理票.get給付計画合計単位数_日数()));
        if (!居宅サービス計画作成区分コード_自己作成.equals(計画作成区分コード)
                && RString.isNullOrEmpty(給付管理票.get事業者名称())) {
            csvEntity.set備考(備考_支援事業者未登録);
        }
        if (parameter.get導入形態コード().is広域()) {
            csvEntity.set証記載保険者番号(getColumnValue(被保険者.get証記載保険者番号()));
        }
        eucCsvWriter.writeLine(csvEntity);
        csvEntity = new KyufukanrihyoIchiranCSVEntity();
    }

    private void edit集計項目(HihokenshaKyufukanrihyoEntity entity) {
        DbWT1121KyufuKanrihyoTempEntity 給付管理票 = entity.get給付管理票();
        csvEntity.set保険者番号(給付管理票.getコントロールレコード保険者番号());
        csvEntity.set保険者名(給付管理票.getコントロールレコード保険者名());
        csvEntity.set訪問通所件数(doカンマ編集(new Decimal(件数1)));
        csvEntity.set短期入所件数(doカンマ編集(new Decimal(件数2)));
        csvEntity.set居宅件数(doカンマ編集(new Decimal(件数3)));
        csvEntity.set合計件数(doカンマ編集(new Decimal(合計件数)));
        eucCsvWriter.writeLine(csvEntity);
        csvEntity = new KyufukanrihyoIchiranCSVEntity();
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IValueObject<RString> column) {
        return (null == column) ? RString.EMPTY : column.value();
    }

}
