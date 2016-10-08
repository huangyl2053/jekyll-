/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.SoufuErrorTblEntity;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 送付エラーリストの帳票とCSVを出力を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class SoufuErrorOutProcess extends BatchProcessBase<SoufuErrorTblEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select送付エラー一時");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC110020");
    private final RString csvFileName = new RString("SofuDataErroriList.csv");
    private final int COUNT_0 = 0;
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
    private static final RString CSV_ページ数 = new RString("ページ数");
    private static final RString CSV_作成年月日 = new RString("作成年月日");
    private static final RString CSV_処理年月 = new RString("処理年月");

    private RString eucFilePath;
    private int 連番;
    private RString 市町村コード = RString.EMPTY;
    private RString 市町村名称 = RString.EMPTY;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    private FileSpoolManager spoolManager;
    private CsvListWriter csvListWriter;

    @Override
    protected void initialize() {
        市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
        市町村名称 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records().get(COUNT_0).get市町村名称();
        連番 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(),
                csvFileName);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true)
                .setHeader(getHeaderList())
                .build();
    }

    @Override
    protected void process(SoufuErrorTblEntity entity) {
        連番++;
        csvListWriter.writeLine(getBodyList(entity, 連番));
    }

    @Override
    protected void afterExecute() {
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
        headerList.add(CSV_ページ数);
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
        List<RString> headerList = new ArrayList<>();
        headerList.add(市町村コード);
        headerList.add(市町村名称);
        headerList.add(new RString(連番));
        headerList.add(entity.get被保険者番号().getColumnValue());
        headerList.add(entity.get氏名カナ());
        headerList.add(entity.get氏名());
        headerList.add(dateChangeToRString(entity.get資格取得日()));
        headerList.add(entity.get要介護状態区分コード().getColumnValue());
        headerList.add(dateChangeToRString(entity.get要介護認定申請日()));
        headerList.add(entity.get居宅事業者番号().getColumnValue());
        headerList.add(dateChangeToRString(entity.get特定申請日()));
//        headerList.add(dateChangeToRString(entity.get特定開始日()));
//        headerList.add(dateChangeToRString(entity.get特定終了日()));
//        headerList.add(dateChangeToRString(entity.get社福開始日()));
//        headerList.add(dateChangeToRString(entity.get社福終了日()));
//        headerList.add(dateChangeToRString(entity.get償還開始日()));
        headerList.add(entity.getエラーコード());
        headerList.add(entity.getエラー内容());
        headerList.add(dateChangeToRString(entity.get資格喪失日()));
        headerList.add(dateChangeToRString(entity.get認定開始日()));
//        headerList.add(dateChangeToRString(entity.get社福開始日()));
//        headerList.add(dateChangeToRString(entity.get社福終了日()));
//        headerList.add(dateChangeToRString(entity.get償還開始日()));
//        headerList.add(dateChangeToRString(entity.get特定開始日()));
//        headerList.add(dateChangeToRString(entity.get特定終了日()));
//        headerList.add(dateChangeToRString(entity.get社福開始日()));
//        headerList.add(dateChangeToRString(entity.get社福終了日()));
//        headerList.add(dateChangeToRString(entity.get償還開始日()));
        return headerList;
    }

    private RString dateChangeToRString(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

}
