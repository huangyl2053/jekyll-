/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo.KyufuJissekiMeisaiGetProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470shoriKekkaListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.ShoriKekkaCSVEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 処理結果リスト作成Processクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class ShoriKekkaListSakuseiDoProcess
        extends BatchProcessBase<DbWT3470shoriKekkaListTempEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecoderiyojokyo."
                    + "IServicecodeRiyojokyoMapper.get処理結果リスト");
    private KyufuJissekiMeisaiGetProcessParameter parameter;
    private static final RString 帳票出力順 = new RString("ORDER BY \"DbWT3470shoriKekkaList\".\"errorKubun\" ASC"
            + ", \"DbWT3470shoriKekkaList\".\"shoHokanehshaNo\" ASC"
            + ",\"DbWT3470shoriKekkaList\".\"hihokenshaNo\" ASC "
            + ",\"DbWT3470shoriKekkaList\".\"key1\" ASC"
            + ",\"DbWT3470shoriKekkaList\".\"key2\" ASC"
            + ",\"DbWT3470shoriKekkaList\".\"key3\" ASC"
            + ",\"DbWT3470shoriKekkaList\".\"key4\" ASC"
            + ",\"DbWT3470shoriKekkaList\".\"key5\" ASC");
    private FileSpoolManager manager;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC900001");
    private CsvWriter<ShoriKekkaCSVEntity> shoriKekkaCsvWriter;
    private RString shoriKekkaFilePath;
    private static final RString コンマ = new RString(",");
    private static final RString 出力ファイル名
            = new RString("処理結果リスト.csv");
    private static final RString ダブル引用符 = new RString("\"");
    private int 行目;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;

    @Override
    protected void initialize() {
        parameter.set出力順(帳票出力順);
        行目 = INT_1;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        shoriKekkaFilePath = Path.combinePath(manager.getEucOutputDirectry(),
                出力ファイル名);
        shoriKekkaCsvWriter = BatchWriters.csvWriter(ShoriKekkaCSVEntity.class).
                filePath(shoriKekkaFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(DbWT3470shoriKekkaListTempEntity entity) {
        ShoriKekkaCSVEntity output;
        if (行目 == INT_1) {
            output = get帳票のCSVファイル作成(entity);
        } else {
            output = get帳票のCSVファイル作成NoHead(entity);
        }
        行目 = 行目 + INT_1;
        shoriKekkaCsvWriter.writeLine(output);
    }

    @Override
    protected void afterExecute() {
        shoriKekkaCsvWriter.close();
        if (shoriKekkaCsvWriter.getCount() != INT_0) {
            manager.spool(SubGyomuCode.DBC介護給付, shoriKekkaFilePath);
        }
    }

    private ShoriKekkaCSVEntity
            get帳票のCSVファイル作成(DbWT3470shoriKekkaListTempEntity entity) {
        ShoriKekkaCSVEntity output = new ShoriKekkaCSVEntity();
        output.set作成日時(getパターン12(FlexibleDate.getNowDate()));
        output.set処理名(entity.getErrorKubun());
        output.set証記載保険者番号(getColumnValue(entity.getShoHokanehshaNo()));
        output.set被保険者番号(getColumnValue(entity.getHihokenshaNo()));
        output.set被保険者カナ氏名(entity.getHihokenshaKanaShimei());
        output.setキー1(entity.getKey1().toDateString());
        output.setキー2(entity.getKey2().toDateString());
        output.setキー3(entity.getKey3());
        output.setキー4(entity.getKey4());
        output.setキー5(entity.getKey5());
        output.setエラー内容(entity.getErrorKubun());
        output.set備考(entity.getBiko());

        return output;
    }

    private ShoriKekkaCSVEntity
            get帳票のCSVファイル作成NoHead(DbWT3470shoriKekkaListTempEntity entity) {
        ShoriKekkaCSVEntity output = new ShoriKekkaCSVEntity();
        output.set処理名(entity.getErrorKubun());
        output.set証記載保険者番号(getColumnValue(entity.getShoHokanehshaNo()));
        output.set被保険者番号(getColumnValue(entity.getHihokenshaNo()));
        output.set被保険者カナ氏名(entity.getHihokenshaKanaShimei());
        if (entity.getKey1() != null) {
            output.setキー1(entity.getKey1().toDateString());
        }
        if (entity.getKey2() != null) {
            output.setキー2(entity.getKey2().toDateString());
        }
        if (entity.getKey3() != null) {
            output.setキー3(entity.getKey3());
        }
        if (entity.getKey4() != null) {
            output.setキー4(entity.getKey4());
        }
        if (entity.getKey5() != null) {
            output.setキー5(entity.getKey5());
        }
        output.setエラー内容(entity.getErrorKubun());
        output.set備考(entity.getBiko());
        return output;
    }

    private static RString getパターン12(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
