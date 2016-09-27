/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD201010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanlist.RiyoshaFutanGakuGemmenNinteishaListProperty.DBD200002_ResultListEnum;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200002.RiyoshaFutangakuGemmenGaitoshaIchiranReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002.ChohyoShutsuryokuJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.ChohyoShutsuryokuJohoShutokuResultCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.ChohyoShutsuryokuJohoShutokuResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd00002.RiyoshaFutangakuGemmenGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 利用者負担額減免認定者リスト発行です。
 *
 * @reamsid_L DBD-3980-030 x_youyj
 */
public class ChohyoShutsuryokuJohoShutokuProcess extends BatchProcessBase<ChohyoShutsuryokuJohoShutokuResultEntity> {

    private ChohyoShutsuryokuJohoShutokuProcessParameter parameter;
    private IOutputOrder outputOrder;
    private RString 出力順;
    private RString reamsLoginID;
    private Association 導入団体;
    private RString 帳票ID;
    private RString 帳票タイトル;
    private RString 改ページ;
    private static final RString 認定者リストタイトル = new RString("介護保険 利用者負担額減免認定者リスト");
    private static final RString 該当者リストタイトル = new RString("介護保険 利用者負担額減免該当者リスト");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString THERE = new RString("3");
    private static final RString 却下 = new RString("却下");
    private static final RString 承認 = new RString("承認");
    private static final RString 空白 = new RString("");
    private static final RString ASTERISK = new RString("*");
    private static final RString 課 = new RString("課");
    private static final RString 旧措置者 = new RString("旧措置者");
    private static final ReportIdDBD REPORT_DBD200002 = ReportIdDBD.DBD200002;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.riyoulyagennmenn."
            + "IGennMennGennGakuTaiSyoulyaMapper.select利用者負担額減免認定者");
    private int 連番 = 0;
    private List<PersonalData> personalDataList;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private CsvWriter<ChohyoShutsuryokuJohoShutokuResultCsvEntity> eucCsvWriter;
    private EucEntityId eUC_ENTITY_ID;
    private RString ファイル名;
    private RString 帳票名称;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private boolean 項目名付加;

    @Override
    protected void initialize() {
        personalDataList = new ArrayList<>();
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();

        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBD介護受給,
                REPORT_DBD200002.getReportId(),
                reamsLoginID,
                parameter.get改頁出力順ID());
        出力順 = MyBatisOrderByClauseCreator.create(DBD200002_ResultListEnum.class, outputOrder);
        導入団体 = AssociationFinderFactory.createInstance().getAssociation();
        帳票ID = parameter.get帳票ID();
        edit初期化();
    }

    @BatchWriter
    private BatchReportWriter<RiyoshaFutangakuGemmenGaitoshaIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<RiyoshaFutangakuGemmenGaitoshaIchiranReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(parameter.get基準日());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toChohyoShutsuryokuJohoShutokuCsvMybatisprmParameter(psmShikibetsuTaisho, 出力順));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBD200002.getReportId().value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Excel, eUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(項目名付加).
                build();
    }

    @Override
    protected void process(ChohyoShutsuryokuJohoShutokuResultEntity t) {
        RiyoshaFutangakuGemmenGaitoshaIchiranReport reportSource = new RiyoshaFutangakuGemmenGaitoshaIchiranReport(t, parameter.get帳票作成日時(),
                出力順, 導入団体.getLasdecCode_().getColumnValue(), 導入団体.getShichosonName_(), 帳票タイトル, 改ページ);
        reportSource.writeBy(reportSourceWriter);

        if (t.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());
            ExpandedInformation expandedInformations
                    = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), t.get被保険者番号());
            PersonalData personalData = PersonalData.of(kojin.get識別コード(), expandedInformations);
            personalDataList.add(personalData);
        } else {
            if (t.get世帯員Entity().getPsmEntity() != null) {
                IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.get世帯員Entity().getPsmEntity());
                PersonalData personalData = PersonalData.of(kojin.get識別コード());
                personalDataList.add(personalData);
            }
        }
        ChohyoShutsuryokuJohoShutokuResultCsvEntity resultEntity = set利用者負担額減免認定者リストCSV(t);
        eucCsvWriter.writeLine(resultEntity);
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, log);

    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void edit初期化() {
        ChohyoShutsuryokuJohoShutokuProcessParameter processParameter
                = new ChohyoShutsuryokuJohoShutokuProcessParameter(parameter.get対象リスト());
        if (processParameter.is該当者リスト()) {
            帳票タイトル = 該当者リストタイトル;
            eUC_ENTITY_ID = new EucEntityId("DBD201010");
            ファイル名 = new RString("RiyoshaFutangakuGemmenGaitoshaIchiran");
            帳票名称 = new RString("DBD200002_RiyoshaFutangakuGemmenGaitoshaIchiran");
        } else if (processParameter.is認定者リスト()) {
            帳票タイトル = 認定者リストタイトル;
            eUC_ENTITY_ID = new EucEntityId("DBD201011");
            ファイル名 = new RString("RiyoshaFutangakuGemmenNinteishaIchiran");
            帳票名称 = new RString("DBD200013_RiyoshaFutangakuGemmenNinteishaIchiran");
        }
        if (parameter.getCsv出力設定() != null && !parameter.getCsv出力設定().isEmpty()) {
            for (CSVSettings csvsetings : parameter.getCsv出力設定()) {
                if (ONE.equals(csvsetings.getコード())) {
                    項目名付加 = true;
                } else if (!ONE.equals(csvsetings.getコード())) {
                    項目名付加 = false;
                }
            }
        }
    }

    private void バッチ出力条件リストの出力() {
        帳票ID = 帳票名称;
        RString 導入団体コード = 導入団体.getLasdecCode_().getColumnValue();
        RString 市町村名 = 導入団体.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = new RString("");
        RString 出力ページ数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        RString csv出力有無 = new RString("あり");
        RString csvファイル名 = new RString("RiyoshaFutangakuGemmenGaitoshaIchiran.csv");

        List<RString> 出力条件 = new ArrayList<>();
        if (parameter.get基準日() != null && !parameter.get基準日().isEmpty()) {
            出力条件.add(parameter.get基準日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        RString 所得年度 = new RString("");
        if (parameter.get所得年度() != null && !parameter.get所得年度().isEmpty()) {
            所得年度 = parameter.get所得年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }

        出力条件.add(new RString("【所得年度】 " + 所得年度));
        出力条件.add(new RString("【旧措置者区分】 " + parameter.get旧措置区分().get名称()));
        出力条件.add(new RString("【世帯表示】 " + parameter.get世帯表示().get名称()));
        if (ONE.equals(parameter.get対象リスト().getコード())) {
            出力条件.add(new RString("【受給者区分】 " + parameter.get受給者区分().get名称()));
            if (parameter.get世帯非課税等().size() == 1) {
                出力条件.add(new RString("【世帯非課税等】 "));
            } else if (parameter.get世帯非課税等().isEmpty()) {
                出力条件.add(new RString("【世帯非課税等】 指定なし"));
            } else {
                出力条件.add(new RString("　　　　　　　　 "));
            }
        }
        if (null != parameter.getCsv出力設定()) {
            出力条件.add(new RString("【CSV出力設定】 項目名付加、連番付加、日付\"/\"編集"));
        } else {
            出力条件.add(new RString("【CSV出力設定】 指定なし"));
        }
        RString 作成日時 = new RString("");
        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        if (parameter.get帳票作成日時() != null) {
            作成日時 = parameter.get帳票作成日時().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(timeFormat);
        }
        出力条件.add(作成日時);
//        RString 出力順 = 出力順;
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID,
                導入団体コード,
                市町村名,
                ジョブ番号,
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private ChohyoShutsuryokuJohoShutokuResultCsvEntity set利用者負担額減免認定者リストCSV(ChohyoShutsuryokuJohoShutokuResultEntity t) {
        ChohyoShutsuryokuJohoShutokuResultCsvEntity resultEntity = new ChohyoShutsuryokuJohoShutokuResultCsvEntity();
        resultEntity.set連番(new RString(String.valueOf(++連番)));
        resultEntity.set被保険者番号(t.get被保険者番号());
        if (t.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());
            resultEntity.set識別コード(kojin.get識別コード().getColumnValue());
            resultEntity.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
            resultEntity.set氏名(kojin.get名称().getName().getColumnValue());
            resultEntity.setカナ氏名(kojin.get名称().getKana().getColumnValue());
            resultEntity.set年齢(kojin.get年齢算出().get年齢());
            resultEntity.set住民種別(kojin.get住民状態().住民状態略称());
            resultEntity.set郵便番号(kojin.get住所().get郵便番号().getColumnValue());
            resultEntity.set住所(kojin.get住所().get住所());
            resultEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
            resultEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
        }
        resultEntity.set証保険者番号(t.get減免減額申請Entity().getShoKisaiHokenshaNo().getColumnValue());
        if (ZERO.equals(t.get利用者負担額減額Entity().getKetteiKubun())) {
            resultEntity.set決定区分(却下);
        } else if (ONE.equals(t.get利用者負担額減額Entity().getKetteiKubun())) {
            resultEntity.set決定区分(承認);
        } else {
            resultEntity.set決定区分(空白);
        }
        if (t.is老齢福祉年金受給者()) {
            resultEntity.set老齢福祉年金受給(ASTERISK);
        } else {
            resultEntity.set老齢福祉年金受給(空白);
        }

        if (t.is生活保護受給者()) {
            resultEntity.set生活保護受給区分(ASTERISK);
        } else {
            resultEntity.set生活保護受給区分(空白);
        }

        if (ONE.equals(t.get本人課税区分())) {
            resultEntity.set課税区分(課);
        } else {
            resultEntity.set課税区分(空白);
        }
        if (t.get利用者負担額減額Entity() == null || t.get利用者負担額減額Entity().getKyuhuritsu() == null) {
            resultEntity.set減免給付率(空白);
        } else {
            HokenKyufuRitsu kyuhuritsu = t.get利用者負担額減額Entity().getKyuhuritsu();
            if (kyuhuritsu != null) {
                Decimal str = kyuhuritsu.getColumnValue();
                resultEntity.set減免給付率(new RString(str.toString()));
            }
        }
        if (t.get世帯員Entity().getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.get世帯員Entity().getPsmEntity());
            resultEntity.set世帯員氏名(kojin.get名称().getName().getColumnValue());
            resultEntity.set世帯員住民種別(kojin.get住民状態().住民状態略称());
        }
        setVoidEntity(resultEntity, t);
        setEntity(resultEntity, t);
        return resultEntity;
    }

    private ChohyoShutsuryokuJohoShutokuResultCsvEntity setVoidEntity(ChohyoShutsuryokuJohoShutokuResultCsvEntity resultEntity,
            ChohyoShutsuryokuJohoShutokuResultEntity t) {
        resultEntity.set減免事由(t.get減免減額申請Entity().getGemmenGengakuShurui());
        for (CSVSettings csvsetings : parameter.getCsv出力設定()) {
            if (THERE.equals(csvsetings.getコード())) {
                FlexibleDate shineiYMD = t.get利用者負担額減額Entity().getShinseiYMD();
                if (shineiYMD != null && !shineiYMD.isEmpty()) {
                    resultEntity.set減免申請日(shineiYMD.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                }
                FlexibleDate ketteiYMD = t.get利用者負担額減額Entity().getKetteiYMD();
                if (ketteiYMD != null && !ketteiYMD.isEmpty()) {
                    resultEntity.set減免決定日(ketteiYMD.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                }
                FlexibleDate tekiyoKaishiYMD = t.get利用者負担額減額Entity().getTekiyoKaishiYMD();
                if (tekiyoKaishiYMD != null && !tekiyoKaishiYMD.isEmpty()) {
                    resultEntity.set減免適用日(tekiyoKaishiYMD.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                }
                FlexibleDate tekiyoShuryoYMD = t.get利用者負担額減額Entity().getTekiyoShuryoYMD();
                if (tekiyoShuryoYMD != null && !tekiyoShuryoYMD.isEmpty()) {
                    resultEntity.set減免有効期限(tekiyoShuryoYMD.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                }
            } else {
                FlexibleDate shineiYMD = t.get利用者負担額減額Entity().getShinseiYMD();
                if (shineiYMD != null && !shineiYMD.isEmpty()) {
                    resultEntity.set減免申請日(shineiYMD.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
                FlexibleDate ketteiYMD = t.get利用者負担額減額Entity().getKetteiYMD();
                if (ketteiYMD != null && !ketteiYMD.isEmpty()) {
                    resultEntity.set減免決定日(ketteiYMD.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
                FlexibleDate tekiyoKaishiYMD = t.get利用者負担額減額Entity().getTekiyoKaishiYMD();
                if (tekiyoKaishiYMD != null && !tekiyoKaishiYMD.isEmpty()) {
                    resultEntity.set減免適用日(tekiyoKaishiYMD.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
                FlexibleDate tekiyoShuryoYMD = t.get利用者負担額減額Entity().getTekiyoShuryoYMD();
                if (tekiyoShuryoYMD != null && !tekiyoShuryoYMD.isEmpty()) {
                    resultEntity.set減免有効期限(tekiyoShuryoYMD.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
            }
        }
        resultEntity.set入所施設コード(t.get入所施設コード());
        resultEntity.set入所施設名称(t.get入所施設名称());
        
        return resultEntity;
    }

    private ChohyoShutsuryokuJohoShutokuResultCsvEntity setEntity(ChohyoShutsuryokuJohoShutokuResultCsvEntity resultEntity,
            ChohyoShutsuryokuJohoShutokuResultEntity t) {
        resultEntity.set要介護度((YokaigoJotaiKubunSupport.toValue(t.get厚労省IF識別コード(),
                t.get認定情報Entity().get要介護状態区分コード())).getName());
        for (CSVSettings csvsetings : parameter.getCsv出力設定()) {
            if (THERE.equals(csvsetings.getコード())) {
                FlexibleDate 認定年月日 = t.get認定情報Entity().get認定年月日();
                if (認定年月日 != null && !認定年月日.isEmpty()) {
                    resultEntity.set認定日(認定年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                }
                FlexibleDate 認定有効期間開始年月日 = t.get認定情報Entity().get認定有効期間開始年月日();
                if (認定有効期間開始年月日 != null && !認定有効期間開始年月日.isEmpty()) {
                    resultEntity.set認定開始日(認定有効期間開始年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                }
                FlexibleDate 認定有効期間終了年月日 = t.get認定情報Entity().get認定有効期間終了年月日();
                if (認定有効期間終了年月日 != null && !認定有効期間終了年月日.isEmpty()) {
                    resultEntity.set認定終了日(認定有効期間終了年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
                }
            } else {
                FlexibleDate 認定年月日 = t.get認定情報Entity().get認定年月日();
                if (認定年月日 != null && !認定年月日.isEmpty()) {
                    resultEntity.set認定日(認定年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
                FlexibleDate 認定有効期間開始年月日 = t.get認定情報Entity().get認定有効期間開始年月日();
                if (認定有効期間開始年月日 != null && !認定有効期間開始年月日.isEmpty()) {
                    resultEntity.set認定開始日(認定有効期間開始年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
                FlexibleDate 認定有効期間終了年月日 = t.get認定情報Entity().get認定有効期間終了年月日();
                if (認定有効期間終了年月日 != null && !認定有効期間終了年月日.isEmpty()) {
                    resultEntity.set認定終了日(認定有効期間終了年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
            }
        }
        if (t.is旧措置者フラグ()) {
            resultEntity.set旧措置(旧措置者);
        } else {
            resultEntity.set旧措置(空白);
        }
        if (t.is所得税課税者()) {
            resultEntity.set所得税課税区分(課);
        } else {
            resultEntity.set所得税課税区分(空白);
        }
        if (ONE.equals(t.get世帯員Entity().get課税区分())) {
            resultEntity.set世帯員課税区分(課);
        } else {
            resultEntity.set世帯員課税区分(空白);
        }
        if (t.get世帯員Entity().get課税所得額().compareTo(ZERO) > 0) {
            resultEntity.set世帯員所得税課税区分(課);
        } else {
            resultEntity.set世帯員所得税課税区分(空白);
        }

        return resultEntity;
    }

}
