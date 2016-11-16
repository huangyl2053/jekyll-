/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1514ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.riyojokyotokeihyomeisailistsakusei.ShoriKekkaKakuninListCSVEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 処理結果確認リストCSVを出力するクラスです。
 *
 * @reamsid_L DBC-3500-030 jinjue
 */
public class ShoriKekkaKakuninListProcess extends BatchProcessBase<DbWT1514ShoriKekkaKakuninListEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyojokyotokeihyomeisailistsakusei."
            + "IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select処理結果確認リスト");
    private final RString csvFileName = new RString("DBU900002_ShoriKekkaKakuninList.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBU900002");
    private RString csvFilePath;
    private FileSpoolManager spoolManager;
    private CsvListWriter csvListWriter;
    private static final RString CSV_作成年月日 = new RString("作成年月日");
    private static final RString CSV_処理名 = new RString("処理名");
    private static final RString CSV_証記載保険者番号 = new RString("証記載保険者番号");
    private static final RString CSV_被保険者番号 = new RString("被保険者番号");
    private static final RString CSV_被保険者氏名 = new RString("被保険者氏名");
    private static final RString CSV_サービス提供年月 = new RString("サービス提供年月");
    private static final RString CSV_事業者番号 = new RString("事業者番号");
    private static final RString CSV_入力識別番号 = new RString("入力識別番号");
    private static final RString CSV_通し番号 = new RString("通し番号");
    private static final RString CSV_サービス種類コード = new RString("サービス種類コード");
    private static final RString CSV_エラー内容 = new RString("エラー内容");
    private static final RString CSV_備考 = new RString("備考");
    private int 作成_indexNO = 0;
    private static final RString 作成_内容 = new RString("△作成");
    private static final RString TABLE_処理結果確認リスト一時 = new RString("DbWT1514ShoriKekkaKakuninList");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果確認リスト一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        処理結果確認リスト一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_処理結果確認リスト一時,
                DbWT1514ShoriKekkaKakuninListEntity.class);
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        csvFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(), csvFileName);
        csvListWriter = new CsvListWriter.InstanceBuilder(csvFilePath)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.JIS)
                .hasHeader(true)
                .setHeader(getHeaderList())
                .setNewLine(NewLine.CRLF)
                .build();
    }

    @Override
    protected void afterExecute() {
        csvListWriter.close();
    }

    @Override
    protected void process(DbWT1514ShoriKekkaKakuninListEntity tempEntity) {

        ShoriKekkaKakuninListCSVEntity entity = new ShoriKekkaKakuninListCSVEntity();
        entity.setエラー内容(tempEntity.getErrorKubun());
        entity.setサービス提供年月(tempEntity.getKey1());
        entity.setサービス種類コード(tempEntity.getKey5());
        entity.set事業者番号(tempEntity.getKey2());
        entity.set備考(tempEntity.getBiko());
        entity.set入力識別番号(tempEntity.getKey3());
        entity.set処理名(tempEntity.getErrorKubun());
        entity.set被保険者氏名(tempEntity.getHihokenshaShimei());
        entity.set被保険者番号(tempEntity.getHihokenshaNo().value());
        entity.set証記載保険者番号(tempEntity.getShoKisaiHokenshaNo().value());
        entity.set通し番号(tempEntity.getKey4());
        作成_indexNO = 作成_indexNO + 1;
        List<RString> csvList = getBodyList(entity, 作成_indexNO);
        csvListWriter.writeLine(csvList);
    }

    /**
     * CSVヘッダを設定します。
     *
     * @return {@link List<RString>}
     */
    public List<RString> getHeaderList() {
        List<RString> headerList = new ArrayList<>();
        headerList.add(CSV_作成年月日);
        headerList.add(CSV_処理名);
        headerList.add(CSV_証記載保険者番号);
        headerList.add(CSV_被保険者番号);
        headerList.add(CSV_被保険者氏名);
        headerList.add(CSV_サービス提供年月);
        headerList.add(CSV_事業者番号);
        headerList.add(CSV_入力識別番号);
        headerList.add(CSV_通し番号);
        headerList.add(CSV_サービス種類コード);
        headerList.add(CSV_エラー内容);
        headerList.add(CSV_備考);
        return headerList;
    }

    /**
     * CSVレコードを取得します。
     *
     * @param entity ShoriKekkaKakuninListCSVEntity
     * @param 作成年月日_INDEXNO 作成年月日_INDEXNO
     *
     * @return {@link List<RString>}
     */
    public List<RString> getBodyList(ShoriKekkaKakuninListCSVEntity entity, int 作成年月日_INDEXNO) {
        List<RString> bodyList = new ArrayList<>();
        if (作成年月日_INDEXNO == 1) {
            bodyList.add(FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().concat(RDate.getNowTime().
                            toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)).concat(作成_内容));
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(Tokeihyo_ErrorKubun.toValue(entity.get処理名()).get名称());
        bodyList.add(entity.get証記載保険者番号());
        bodyList.add(entity.get被保険者番号());
        bodyList.add(entity.get被保険者氏名());
        bodyList.add(entity.getサービス提供年月());
        bodyList.add(entity.get事業者番号());
        bodyList.add(entity.get入力識別番号());
        bodyList.add(entity.get通し番号());
        bodyList.add(entity.getサービス種類コード());
        bodyList.add(Tokeihyo_ErrorKubun.toValue(entity.get処理名()).geterrorMessage());
        bodyList.add(entity.get備考());
        return bodyList;
    }
}
