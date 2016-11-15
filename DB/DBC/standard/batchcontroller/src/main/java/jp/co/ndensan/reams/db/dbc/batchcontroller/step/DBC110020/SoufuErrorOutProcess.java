/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200095.KokuhorenSofuDataErrorIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200095.KokuhorenSofuDataErrorIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.SoufuErrorTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200095.KokuhorenSofuDataErrorIchiranSource;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 送付エラーリストの帳票とCSVを出力を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class SoufuErrorOutProcess extends BatchKeyBreakBase<SoufuErrorTblEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select送付エラー一時");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200095");
    private static final RString CSV_FILENAME = new RString("SofuDataErroriList.csv");
    private static final int COUNT_0 = 0;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSV_市町村コード = new RString("市町村コード");
    private static final RString CSV_市町村名称 = new RString("市町村名称");
    private static final RString CSV_連番 = new RString("連番");
    private static final RString CSV_被保険者番号 = new RString("被保険者番号");
    private static final RString CSV_氏名カナ = new RString("氏名カナ");
    private static final RString CSV_氏名 = new RString("氏名");
    private static final RString CSV_資格取得日 = new RString("資格取得日");
    private static final RString CSV_認定要介護度 = new RString("認定要介護度");
    private static final RString CSV_認定申請日 = new RString("認定申請日");
    private static final RString CSV_居宅事業者番号 = new RString("居宅事業者番号");
    private static final RString CSV_特定申請日 = new RString("特定申請日");
    private static final RString CSV_特定開始日 = new RString("特定開始日");
    private static final RString CSV_特定終了日 = new RString("特定終了日");
    private static final RString CSV_社福開始日 = new RString("社福開始日");
    private static final RString CSV_社福終了日 = new RString("社福終了日");
    private static final RString CSV_償還開始日 = new RString("償還開始日");
    private static final RString CSV_エラー情報_コード = new RString("エラー情報　コード");
    private static final RString CSV_エラー情報_内容 = new RString("エラー情報　内容");
    private static final RString CSV_資格喪失日 = new RString("資格喪失日");
    private static final RString CSV_認定開始日 = new RString("認定開始日");
    private static final RString CSV_認定終了日 = new RString("認定終了日");
    private static final RString CSV_居宅開始日 = new RString("居宅開始日");
    private static final RString CSV_利用申請日 = new RString("利用申請日");
    private static final RString CSV_利用開始日 = new RString("利用開始日");
    private static final RString CSV_利用終了日 = new RString("利用終了日");
    private static final RString CSV_標準開始日 = new RString("標準開始日");
    private static final RString CSV_標準終了日 = new RString("標準終了日");
    private static final RString CSV_被下開始日 = new RString("被下開始日");
    private static final RString CSV_作成年月日 = new RString("作成年月日");
    private static final RString CSV_処理年月 = new RString("処理年月");
    private static final RString RST_SPACE = new RString(" ");

    private RString eucFilePath;
    private int 連番;
    private RString 市町村コード = RString.EMPTY;
    private RString 市町村名称 = RString.EMPTY;
    private RString 作成年月日 = RString.EMPTY;
    private FileSpoolManager spoolManager;
    private CsvListWriter csvListWriter;
    private BatchReportWriter<KokuhorenSofuDataErrorIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<KokuhorenSofuDataErrorIchiranSource> reportSourceWriter_一覧表;

    @Override
    protected void initialize() {
        市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
        市町村名称 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records().get(COUNT_0).get市町村名称();
        RDateTime sysDate = RDate.getNowDateTime();
        RString 年月日 = sysDate.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
        RTime 時刻 = sysDate.getTime();
        作成年月日 = new RString(年月日.toString() + RST_SPACE
                + 時刻.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        連番 = 0;
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(),
                CSV_FILENAME);
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200095.getReportId().value(), SubGyomuCode.DBC介護給付).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true)
                .setHeader(getHeaderList())
                .build();
    }

    @Override
    protected void afterExecute() {
        csvListWriter.close();
        spoolManager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        batchReportWriter_一覧表.close();
    }

    /**
     * CSVヘッダを設定します。
     *
     * @return {@link List<RString>}
     */
    public List<RString> getHeaderList() {
        List<RString> headerList = new ArrayList<>();
        headerList.add(CSV_市町村コード);
        headerList.add(CSV_市町村名称);
        headerList.add(CSV_連番);
        headerList.add(CSV_被保険者番号);
        headerList.add(CSV_氏名カナ);
        headerList.add(CSV_氏名);
        headerList.add(CSV_資格取得日);
        headerList.add(CSV_認定要介護度);
        headerList.add(CSV_認定申請日);
        headerList.add(CSV_居宅事業者番号);
        headerList.add(CSV_特定申請日);
        headerList.add(CSV_特定開始日);
        headerList.add(CSV_特定終了日);
        headerList.add(CSV_社福開始日);
        headerList.add(CSV_社福終了日);
        headerList.add(CSV_償還開始日);
        headerList.add(CSV_エラー情報_コード);
        headerList.add(CSV_エラー情報_内容);
        headerList.add(CSV_資格喪失日);
        headerList.add(CSV_認定開始日);
        headerList.add(CSV_認定終了日);
        headerList.add(CSV_居宅開始日);
        headerList.add(CSV_利用申請日);
        headerList.add(CSV_利用開始日);
        headerList.add(CSV_利用終了日);
        headerList.add(CSV_標準開始日);
        headerList.add(CSV_標準終了日);
        headerList.add(CSV_被下開始日);
        headerList.add(CSV_作成年月日);
        headerList.add(CSV_処理年月);
        return headerList;
    }

    /**
     * CSVレコードを取得します。
     *
     * @param entity SoufuErrorTblEntity
     * @param 連番 int
     *
     * @return {@link List<RString>}
     */
    public List<RString> getBodyList(SoufuErrorTblEntity entity, int 連番) {
        List<RString> bodyList = new ArrayList<>();
        bodyList.add(市町村コード);
        bodyList.add(市町村名称);
        bodyList.add(new RString(連番));
        bodyList.add(entity.get被保険者番号().getColumnValue());
        if (RString.isNullOrEmpty(entity.get氏名カナ())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(entity.get氏名カナ());
        }
        if (RString.isNullOrEmpty(entity.get氏名カナ())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(entity.get氏名());
        }

        bodyList.add(dateChangeToRString(entity.get資格取得日()));
        if (entity.get要介護状態区分コード() != null) {
            bodyList.add(entity.get要介護状態区分コード().getColumnValue());
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(dateChangeToRString(entity.get要介護認定申請日()));
        if (entity.get居宅事業者番号() != null) {
            bodyList.add(entity.get居宅事業者番号().getColumnValue());
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(dateChangeToRString(entity.get特定申請日()));
        bodyList.add(dateChangeToRString(entity.get特定適用開始日()));
        bodyList.add(dateChangeToRString(entity.get特定適用終了日()));
        bodyList.add(dateChangeToRString(entity.get社会福祉適用開始日()));
        bodyList.add(dateChangeToRString(entity.get社会福祉適用終了日()));
        bodyList.add(dateChangeToRString(entity.get償還払化開始日()));
        bodyList.add(entity.getエラーコード());
        bodyList.add(entity.getエラー内容());
        bodyList.add(dateChangeToRString(entity.get資格喪失日()));
        bodyList.add(dateChangeToRString(entity.get認定開始日()));
        bodyList.add(dateChangeToRString(entity.get認定終了日()));
        bodyList.add(dateChangeToRString(entity.get居宅適用開始日()));
        bodyList.add(dateChangeToRString(entity.get利用者負担申請日()));
        bodyList.add(dateChangeToRString(entity.get利用者負担適用開始日()));
        bodyList.add(dateChangeToRString(entity.get利用者負担適用終了日()));
        bodyList.add(dateChangeToRString(entity.get標準負担適用開始日()));
        bodyList.add(dateChangeToRString(entity.get標準負担適用終了日()));
        bodyList.add(dateChangeToRString(entity.get給付率引下げ開始日()));
        bodyList.add(作成年月日);
        bodyList.add(entity.get処理年月());
        return bodyList;
    }

    private RString dateChangeToRString(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    @Override
    protected void keyBreakProcess(SoufuErrorTblEntity t) {
    }

    @Override
    protected void usualProcess(SoufuErrorTblEntity entity) {
        連番++;
        csvListWriter.writeLine(getBodyList(entity, 連番));
        KokuhorenSofuDataErrorIchiranEntity reportEntity = getReportEntity(entity);
        KokuhorenSofuDataErrorIchiranReport reprot = new KokuhorenSofuDataErrorIchiranReport(reportEntity, 市町村コード, 市町村名称, 連番);
        reprot.writeBy(reportSourceWriter_一覧表);
    }

    private KokuhorenSofuDataErrorIchiranEntity getReportEntity(SoufuErrorTblEntity soufuErrorTblEntity) {
        KokuhorenSofuDataErrorIchiranEntity entity = new KokuhorenSofuDataErrorIchiranEntity();
        entity.set被保険者番号(soufuErrorTblEntity.get被保険者番号());
        entity.set氏名カナ(soufuErrorTblEntity.get氏名カナ());
        entity.set氏名(soufuErrorTblEntity.get氏名());
        entity.set資格取得日(soufuErrorTblEntity.get資格取得日());
        if (soufuErrorTblEntity.get要介護状態区分コード() != null) {
            entity.set認定要介護度(soufuErrorTblEntity.get要介護状態区分コード().getColumnValue());
        }
        entity.set認定申請日(soufuErrorTblEntity.get要介護認定申請日());
        if (soufuErrorTblEntity.get居宅事業者番号() != null) {
            entity.set居宅事業者番号(soufuErrorTblEntity.get居宅事業者番号().getColumnValue());
        }
        entity.set特定申請日(soufuErrorTblEntity.get特定申請日());
        entity.set特定開始日(soufuErrorTblEntity.get特定適用開始日());
        entity.set特定終了日(soufuErrorTblEntity.get特定適用終了日());
        entity.set社福開始日(soufuErrorTblEntity.get社会福祉適用開始日());
        entity.set社福終了日(soufuErrorTblEntity.get社会福祉適用終了日());
        entity.set償還開始日(soufuErrorTblEntity.get償還払化開始日());
        entity.setエラー情報コード(soufuErrorTblEntity.getエラーコード());
        entity.setエラー情報内容(soufuErrorTblEntity.getエラー内容());
        entity.set資格喪失日(soufuErrorTblEntity.get資格喪失日());
        entity.set認定開始日(soufuErrorTblEntity.get認定開始日());
        entity.set認定終了日(soufuErrorTblEntity.get認定終了日());
        entity.set居宅開始日(soufuErrorTblEntity.get居宅適用開始日());
        entity.set利用申請日(soufuErrorTblEntity.get利用者負担申請日());
        entity.set利用開始日(soufuErrorTblEntity.get利用者負担適用開始日());
        entity.set利用終了日(soufuErrorTblEntity.get利用者負担適用終了日());
        entity.set標準開始日(soufuErrorTblEntity.get標準負担適用開始日());
        entity.set標準終了日(soufuErrorTblEntity.get標準負担適用終了日());
        entity.set引下開始日(soufuErrorTblEntity.get給付率引下げ開始日());
        entity.set作成年月日(soufuErrorTblEntity.get作成年月日());
        if (soufuErrorTblEntity.get処理年月() != null) {
            entity.set処理年月(new FlexibleYearMonth(soufuErrorTblEntity.get処理年月()));
        }
        return entity;
    }

}
