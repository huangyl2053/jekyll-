/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200014.HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbdbt00003.NinteishaListSakuseiProcessProperty;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00003.NinteishaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.KakuninListCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.NinnteiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.SetaiInRisutoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200014.HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 訪問介護利用者負担額減額認定者リス発行_process処理クラスです。
 *
 * @reamsid_L DBD-3970-050 x_xuliang
 */
public class NinteishaListSakuseiProcess extends BatchProcessBase<NinteishaListSakuseiEntity> {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID_認定者 = new EucEntityId("DBD202010");
    private static final EucEntityId EUC_ENTITY_ID_該当者 = new EucEntityId("DBD202011");
    private static final ReportId REPORTID = new ReportId("DBD200003_HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran");
    private static final RString REAMSLOGINID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
    private static final RString 対象期間指定 = new RString("【対象期間指定】");
    private static final RString 対象年度 = new RString("【対象年度】");
    private static final RString 課税判定等基準日 = new RString("【課税判定等基準日】");
    private static final RString 基準日 = new RString("【基準日】");
    private static final RString 所得年度 = new RString("【所得年度】");
    private static final RString 旧措置者区分 = new RString("【旧措置者区分】");
    private static final RString 世帯表示 = new RString("【世帯表示】");
    private static final RString 受給者区分 = new RString("【受給者区分】");
    private static final RString 法別区分 = new RString("【法別区分】");
    private static final RString CSV出力設定 = new RString("【CSV出力設定】");
    private static final RString 世帯非課税等 = new RString("【世帯非課税等】");
    private static final RString CSV出力設定指定なし = new RString("【CSV出力設定】 指定なし");
    private static final RString 世帯非課税等指定なし = new RString("【世帯非課税等】 指定なし");
    private static final RString EUC_WRITER_LIAN = new RString("～");
    private static final RString EUC_WRITER_DIAN = new RString("、");
    private static final RString EUC_WRITER_KONG = new RString("　　　　　　　　 ");
    private static final RString SPACE = new RString(" ");
    private static final RString SXING = new RString("*");
    private static final RString KE = new RString("課");
    private static final RString JIUCUO = new RString("旧措置者");

    private Association association;
    private CsvWriter<KakuninListCsvEntity> eucCsvWriter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private int i = 0;
    private boolean 項目名付加;

    private NinteishaListSakuseiProcessParameter parameter;

    private RString 出力順;
    private IOutputOrder outputOrder;

    @BatchWriter
    private BatchReportWriter<HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource> reportSourceWriter;

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.riyoshafutangakugengakunintei"
            + ".IRiyoshafutangakuGengakuNinteiMapper.get訪問介護利用者負担額減額認定者リスト");

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        personalDataList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(parameter.get基準日());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBD介護受給, REPORTID, REAMSLOGINID, parameter.get改頁出力順ID());
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator
                    .create(NinteishaListSakuseiProcessProperty.DBD200003_HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran.class, outputOrder);
        }
        return new BatchDbReader(MAPPERPATH, parameter.toNinteishaListSakuseiMybatisParameter(psmShikibetsuTaisho, 出力順));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);

        if (TargetList.認定者リスト.getコード().equals(parameter.get対象リスト().getコード())) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_認定者, UzUDE0831EucAccesslogFileType.Csv);
            eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiran.csv"));
        } else if (TargetList.該当者リスト.getコード().equals(parameter.get対象リスト().getコード())) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_該当者, UzUDE0831EucAccesslogFileType.Csv);
            eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran.csv"));
        }
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(項目名付加).
                build();
    }

    @Override
    protected void process(NinteishaListSakuseiEntity t) {
        edit帳票用データ(t);
        HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReport find
                = new HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReport(parameter.get帳票作成日時(),
                        parameter.get対象リスト(), t, association, outputOrder);
        find.writeBy(reportSourceWriter);

        personalDataList.add(toPersonalData(t));
        KakuninListCsvEntity eucCsvEntity = new KakuninListCsvEntity();
        setEucCsvEntity(eucCsvEntity, t);
        eucCsvWriter.writeLine(eucCsvEntity);
    }

    @Override
    protected void afterExecute() {
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        eucCsvWriter.close();
        manager.spool(eucFilePath, log);
        バッチ出力条件リストの出力を行う();
    }

    private void edit帳票用データ(NinteishaListSakuseiEntity t) {

        if (t.get認定情報Entity() != null) {
            t.get認定情報Entity().set認定情報_要介護状態区分コード(t.get認定情報Entity().get認定情報_要介護状態区分コード());
            t.get認定情報Entity().set認定情報_認定年月日(t.get認定情報Entity().get認定情報_認定年月日());
            t.get認定情報Entity().set認定情報_認定有効期間開始年月日(t.get認定情報Entity().get認定情報_認定有効期間開始年月日());
            t.get認定情報Entity().set認定情報_認定有効期間終了年月日(t.get認定情報Entity().get認定情報_認定有効期間終了年月日());
        } else if (t.get総合事業対象者情報Entity() != null) {
            if (t.get認定情報Entity() == null) {
                t.set認定情報Entity(new NinnteiJohoEntity());
            }
            t.get認定情報Entity().set認定情報_要介護状態区分コード(new RString("06"));
            t.get認定情報Entity().set認定情報_認定年月日(t.get総合事業対象者情報Entity().get総合事業対象者情報_チェックリスト実施日());
            t.get認定情報Entity().set認定情報_認定有効期間開始年月日(t.get総合事業対象者情報Entity().get総合事業対象者情報_適用開始年月日());
            t.get認定情報Entity().set認定情報_認定有効期間終了年月日(t.get総合事業対象者情報Entity().get総合事業対象者情報_適用終了年月日());
        }
    }

    private PersonalData toPersonalData(NinteishaListSakuseiEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    private void バッチ出力条件リストの出力を行う() {
        if (TargetList.認定者リスト.getコード().equals(parameter.get対象リスト().getコード())) {
            出力条件リスト_認定者();
        } else if (TargetList.該当者リスト.getコード().equals(parameter.get対象リスト().getコード())) {
            出力条件リスト_該当者();
        }
    }

    private void 出力条件リスト_認定者() {
        RString 帳票ID = new RString("DBD200014_HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiran");
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = new RString("訪問介護利用者負担額減額認定者リスト");
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("あり");
        RString csvファイル名 = new RString("HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiran.csv");

        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(対象期間指定.concat(parameter.get対象期間指定().get名称()));
        if (TaishoKikan.対象年度.getコード().equals(parameter.get対象期間指定().getコード())) {
            出力条件.add(対象年度.concat(edit日期(parameter.get対象年度の開始年月日()))
                    .concat(EUC_WRITER_LIAN)
                    .concat(edit日期(parameter.get対象年度の終了年月日())));
            出力条件.add(課税判定等基準日.concat(edit日期(parameter.get課税判定等基準日())));
        } else if (TaishoKikan.基準日.getコード().equals(parameter.get対象期間指定().getコード())) {
            出力条件.add(基準日.concat(parameter.get基準日().toString()));
        }
        出力条件.add(所得年度.concat(edit年度(parameter.get所得年度())));
        出力条件.add(旧措置者区分.concat(parameter.get旧措置者区分().get名称()));
        出力条件.add(世帯表示.concat(parameter.get世帯表示().get名称()));
        出力条件.add(法別区分.concat(parameter.get法別区分().get名称()));
        if (null == parameter.get出力設定()) {
            出力条件.add(CSV出力設定指定なし);
        } else {
            出力条件.add(CSV出力設定.concat(CSVSettings.項目名付加.get名称())
                    .concat(EUC_WRITER_DIAN)
                    .concat(CSVSettings.連番付加.get名称())
                    .concat(EUC_WRITER_DIAN)
                    .concat(CSVSettings.日付スラッシュ編集.get名称()));
        }
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

    private RString edit日期(FlexibleDate 日期) {

        RString 変更後日期 = RString.EMPTY;
        if (日期 != null) {
            変更後日期 = 日期.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return 変更後日期;
    }

    private RString edit年度(FlexibleYear 所得年度) {
        RString 変更後年度 = RString.EMPTY;
        if (所得年度 != null) {
            変更後年度 = 所得年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.NONE).toDateString();
        }
        return 変更後年度;
    }

    private void 出力条件リスト_該当者() {
        RString 帳票ID = new RString("DBD200003_HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran");
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = new RString("訪問介護利用者負担額減額該当者リスト");
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("あり");
        RString csvファイル名 = new RString("HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran.csv");

        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(対象期間指定.concat(parameter.get対象期間指定().get名称()));
        if (TaishoKikan.対象年度.getコード().equals(parameter.get対象期間指定().getコード())) {
            出力条件.add(対象年度.concat(parameter.get対象年度の開始年月日().toString())
                    .concat(EUC_WRITER_LIAN)
                    .concat(parameter.get対象年度の終了年月日().toString()));
            出力条件.add(課税判定等基準日.concat(parameter.get課税判定等基準日().toString()));
        } else if (TaishoKikan.基準日.getコード().equals(parameter.get対象期間指定().getコード())) {
            出力条件.add(基準日.concat(parameter.get基準日().toString()));
        }
        出力条件.add(所得年度.concat(parameter.get所得年度().toDateString()));
        出力条件.add(旧措置者区分.concat(parameter.get旧措置者区分().get名称()));
        出力条件.add(世帯表示.concat(parameter.get世帯表示().get名称()));
        出力条件.add(受給者区分.concat(parameter.get受給者区分().get名称()));
        if (parameter.get世帯非課税等() == null || parameter.get世帯非課税等().isEmpty()) {
            出力条件.add(世帯非課税等指定なし);
        } else {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < parameter.get世帯非課税等().size(); i++) {
                if (i == parameter.get世帯非課税等().size() - 1) {
                    builder.append(parameter.get世帯非課税等().get(i).get名称());
                } else {
                    builder.append(parameter.get世帯非課税等().get(i).get名称().concat(EUC_WRITER_KONG));
                }
            }
            出力条件.add(世帯非課税等.concat(builder.toString()));
        }
        if (parameter.get出力設定() == null || parameter.get出力設定().isEmpty()) {
            出力条件.add(CSV出力設定指定なし);
        } else {

            if (parameter.get出力設定() != null && !parameter.get出力設定().isEmpty()) {

                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < parameter.get出力設定().size(); i++) {
                    if (i == parameter.get出力設定().size() - 1) {
                        builder.append(parameter.get出力設定().get(i).get名称());
                    } else {
                        builder.append(parameter.get出力設定().get(i).get名称().concat(EUC_WRITER_DIAN));
                    }
                }
                出力条件.add(CSV出力設定.concat(builder.toString()));
            }
        }
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

    private void setEucCsvEntity(KakuninListCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t) {
        if (parameter.get出力設定().equals(CSVSettings.連番付加)) {
            eucCsvEntity.set連番(new RString(String.valueOf(++i)));
        }
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());
        SetaiInRisutoEntity setaEntity = new SetaiInRisutoEntity();
        eucCsvEntity.set被保険者番号(t.get被保険者番号().getColumnValue());
        eucCsvEntity.set識別コード(kojin.get識別コード().value());
        eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getShoKisaiHokenshaNo() != null) {
            eucCsvEntity.set証保険者番号(t.get訪問介護利用者負担額減額().getShoKisaiHokenshaNo().value());
        }

        eucCsvEntity.set氏名(kojin.get名称().getName().value());
        eucCsvEntity.setカナ氏名(kojin.get名称().getKana().value());
        eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
        eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
        eucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().value());
        eucCsvEntity.set住所(kojin.get住所().get住所());
        eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
        eucCsvEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getKohiJukyushaNo() != null) {
            eucCsvEntity.set公費受給者番号(t.get訪問介護利用者負担額減額().getKohiJukyushaNo());
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getHobetsuKubun() != null) {
            eucCsvEntity.set法別番号(t.get訪問介護利用者負担額減額().getHobetsuKubun());
        }
        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getKetteiKubun() != null) {
            eucCsvEntity.set決定区分(t.get訪問介護利用者負担額減額().getKetteiKubun());
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getShinseiYMD() != null) {
            eucCsvEntity.set減免申請日(set年月日(t.get訪問介護利用者負担額減額().getShinseiYMD()));
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getKetteiYMD() != null) {
            eucCsvEntity.set減免決定日(set年月日(t.get訪問介護利用者負担額減額().getKetteiYMD()));
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getTekiyoKaishiYMD() != null) {
            eucCsvEntity.set減免適用日(set年月日(t.get訪問介護利用者負担額減額().getTekiyoKaishiYMD()));
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getTekiyoShuryoYMD() != null) {
            eucCsvEntity.set減免有効期限(set年月日(t.get訪問介護利用者負担額減額().getTekiyoShuryoYMD()));
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getKyufuritsu() != null) {
            eucCsvEntity.set給付率(new RString(t.get訪問介護利用者負担額減額().getKyufuritsu().value().toString()));
        }

        if (t.is老齢福祉年金受給者() == true) {
            eucCsvEntity.set老齢福祉年金受給(SXING);
        } else {
            eucCsvEntity.set老齢福祉年金受給(SPACE);
        }

        if (t.is生活保護受給者() == true) {
            eucCsvEntity.set生活保護受給区分(SXING);
        } else {
            eucCsvEntity.set生活保護受給区分(SPACE);
        }
        if (t.get本人課税区分().equals(KazeiKubun.課税.get名称())) {
            eucCsvEntity.set課税区分(KE);
        } else {
            eucCsvEntity.set課税区分(SPACE);
        }
        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getShogaishaTechoTokyu() != null) {
            eucCsvEntity.set障害者手帳等級(t.get訪問介護利用者負担額減額().getShogaishaTechoTokyu());
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getShogaishaTechoNo() != null) {
            eucCsvEntity.set障害者番号(t.get訪問介護利用者負担額減額().getShogaishaTechoNo());
        }

        eucCsvEntity.set特定疾病(RString.isNullOrEmpty(t.get要介護認定申請情報_2号特定疾病コード()) ? RString.EMPTY
                : TokuteiShippei.toValue(t.get要介護認定申請情報_2号特定疾病コード()).get名称());
        if (t.is所得税課税者() == true) {
            eucCsvEntity.set所得税課税区分(KE);
        } else {
            eucCsvEntity.set所得税課税区分(SPACE);
        }
        if (t.is受給者台帳Newest_旧措置者フラグ() == true) {
            eucCsvEntity.set旧措置(JIUCUO);
        } else {
            eucCsvEntity.set旧措置(SPACE);
        }
        if (t.get認定情報Entity() != null) {
            eucCsvEntity.set要介護度(t.get認定情報Entity().get認定情報_要介護状態区分コード());
            eucCsvEntity.set認定日(set年月日(t.get認定情報Entity().get認定情報_認定年月日()));
            eucCsvEntity.set認定開始日(set年月日(t.get認定情報Entity().get認定情報_認定有効期間開始年月日()));
            eucCsvEntity.set認定終了日(set年月日(t.get認定情報Entity().get認定情報_認定有効期間終了年月日()));
        } else if (t.get総合事業対象者情報Entity() != null) {
            eucCsvEntity.set要介護度(new RString("06"));
            eucCsvEntity.set認定日(set年月日(t.get総合事業対象者情報Entity().get総合事業対象者情報_チェックリスト実施日()));
            eucCsvEntity.set認定開始日(set年月日(t.get総合事業対象者情報Entity().get総合事業対象者情報_適用開始年月日()));
            eucCsvEntity.set認定終了日(set年月日(t.get総合事業対象者情報Entity().get総合事業対象者情報_適用終了年月日()));
        }
        eucCsvEntity.set世帯員氏名(kojin.get名称().getName().value());
        eucCsvEntity.set世帯員住民種別(kojin.get住民状態().住民状態略称());
        if (setaEntity.get課税区分() != null && !setaEntity.get課税区分().isEmpty() && setaEntity.get課税区分().equals(new RString("1"))) {
            eucCsvEntity.set世帯員課税区分(KE);
        } else {
            eucCsvEntity.set世帯員課税区分(SPACE);
        }
        if (setaEntity.get課税所得額() != null && setaEntity.get課税所得額().intValue() > 0) {
            eucCsvEntity.set世帯員所得税課税区分(KE);
        } else {
            eucCsvEntity.set世帯員所得税課税区分(SPACE);
        }

    }

    private RString set年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        } else {
            return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
        }
    }
}
