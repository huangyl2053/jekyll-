/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiDataSakusei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021.FurikomimeisaiFurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 処理結果確認リスト作成する。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class FurikomimeisaiDataSyoriResultProcess extends BatchProcessBase<ShoriKekkaKakuninListTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.select処理結果確認リスト情報");
    private static final int 先頭_作成日時_アカウント = 1;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC900004");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 出力ファイル名 = new RString("DBC900004_ShoriKekkaKakuninList.csv");
    private static final RString 作成R = new RString("作成");
    private static final int INT_0 = 0;

    private FurikomimeisaiFurikomiDataProcessParameter parameter;
    private CsvWriter<ShoriKekkaKakuninListCsvEntity> eucCsvWriter;

    private FileSpoolManager manager;
    private RString eucFilePath;

    private int count = 0;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), 出力ファイル名);

    }

    @Override
    protected void process(ShoriKekkaKakuninListTempTableEntity t) {
        if (count == INT_0) {
            eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                    .alwaysWriteHeader(ShoriKekkaKakuninListCsvEntity.class)
                    .setEncode(Encode.UTF_8withBOM)
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(true)
                    .build();
        }
        count++;
        ShoriKekkaKakuninListCsvEntity eucCsvEntity = new ShoriKekkaKakuninListCsvEntity();
        edit処理結果確認リスト情報(eucCsvEntity, t);
        eucCsvWriter.writeLine(eucCsvEntity);
    }

    @Override
    protected void afterExecute() {
        if (count != 0) {
            eucCsvWriter.close();
            manager.spool(eucFilePath);
        }
    }

    private void edit処理結果確認リスト情報(ShoriKekkaKakuninListCsvEntity eucCsvEntity, ShoriKekkaKakuninListTempTableEntity t) {
        if (先頭_作成日時_アカウント == count) {
            eucCsvEntity.set作成日時(getSakuseiYmhm());
        } else {
            eucCsvEntity.set作成日時(RString.EMPTY);
        }
        if (t.getErrorKubun() != null && !t.getErrorKubun().isEmpty()) {
            eucCsvEntity.set処理名(FurikomiDataSakusei_ErrorKubun.get処理名(t.getErrorKubun()));
        } else {
            eucCsvEntity.set処理名(RString.EMPTY);
        }
        if (t.getShoKisaiHokenshaNo() != null) {
            eucCsvEntity.set証記載保険者番号(t.getShoKisaiHokenshaNo().value());
        } else {
            eucCsvEntity.set証記載保険者番号(RString.EMPTY);
        }
        if (t.getHiHokenshaNo() != null) {
            eucCsvEntity.set被保険者番号(t.getHiHokenshaNo().value());
        } else {
            eucCsvEntity.set被保険者番号(RString.EMPTY);
        }
        if (t.getErrorKubun() != null && !t.getErrorKubun().isEmpty()) {
            eucCsvEntity.setエラー内容(FurikomiDataSakusei_ErrorKubun.getエラーメッセージ(t.getErrorKubun()));
        } else {
            eucCsvEntity.setエラー内容(RString.EMPTY);
        }
        eucCsvEntity.set備考(t.getBiko() == null ? RString.EMPTY : t.getBiko());
    }

    private RString getSakuseiYmhm() {
        RDateTime datetime = parameter.getシステム日時().getRDateTime();
        RStringBuilder sakuseiYMD = new RStringBuilder();
        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(作成R);
        return sakuseiYMD.toRString();
    }
}
