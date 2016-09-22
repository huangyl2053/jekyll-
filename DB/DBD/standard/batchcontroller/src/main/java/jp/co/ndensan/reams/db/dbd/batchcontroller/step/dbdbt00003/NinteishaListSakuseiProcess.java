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
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.KakuninListNoRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.NinnteiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200014.HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource;
import jp.co.ndensan.reams.db.dbd.service.core.dbd202010.NinteishaListSakuseiManager;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
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

    private Association association;
    private CsvWriter<KakuninListCsvEntity> eucCsvWriter;
    private CsvWriter<KakuninListNoRenbanCsvEntity> eucNoRenbanCsvWriter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private int i = 0;

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
        if (parameter.get出力設定().contains(CSVSettings.連番付加)) {
            eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                    alwaysWriteHeader(KakuninListCsvEntity.class).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(parameter.get出力設定().contains(CSVSettings.項目名付加)).
                    build();
        } else {
            eucNoRenbanCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                    alwaysWriteHeader(KakuninListNoRenbanCsvEntity.class).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(parameter.get出力設定().contains(CSVSettings.項目名付加)).
                    build();
        }

    }

    @Override
    protected void process(NinteishaListSakuseiEntity t) {
        i++;
        edit帳票用データ(t);
        HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReport find
                = new HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReport(parameter.get帳票作成日時(),
                        parameter.get対象リスト(), t, association, outputOrder);
        find.writeBy(reportSourceWriter);

        personalDataList.add(toPersonalData(t));
        if (parameter.get出力設定().contains(CSVSettings.連番付加)) {
            KakuninListCsvEntity eucCsvEntity = new KakuninListCsvEntity();
            NinteishaListSakuseiManager.createInstance().連番ありCSV情報設定(eucCsvEntity, t, i);
            eucCsvWriter.writeLine(eucCsvEntity);
        } else {
            KakuninListNoRenbanCsvEntity eucCsvEntity = new KakuninListNoRenbanCsvEntity();
            NinteishaListSakuseiManager.createInstance().連番なしCSV情報設定(eucCsvEntity, t);
        }
    }

    @Override
    protected void afterExecute() {
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        if (parameter.get出力設定().contains(CSVSettings.連番付加)) {
            eucCsvWriter.close();
        } else {
            eucNoRenbanCsvWriter.close();
        }
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
            edit出力条件_出力設定(出力条件);
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
            edit出力条件_出力設定(出力条件);
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

    private void edit出力条件_出力設定(List<RString> 出力条件) {
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

}
