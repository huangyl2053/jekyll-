/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiDataSakusei_ErrorKubun;
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
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 処理結果確認リスト作成_Process処理クラスです．
 *
 * @reamsid_L DBC-2180-030 x_lilh
 */
public class SyoriResultKakuninListCreateProcess extends BatchProcessBase<ShoriKekkaKakuninListTempTableEntity> {

    private static final int 先頭_作成日時_アカウント = 1;
    private static final RString 作成 = new RString("作成");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC900004");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IFurikomiErrorListCreateMapper.select処理結果確認リスト情報");

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
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("DBC900004_ShoriKekkaKakuninList.csv"));
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .alwaysWriteHeader(ShoriKekkaKakuninListCsvEntity.class)
                .setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(ShoriKekkaKakuninListTempTableEntity t) {
        ShoriKekkaKakuninListCsvEntity eucCsvEntity = new ShoriKekkaKakuninListCsvEntity();
        if (t.getHiHokenshaNo() != null && !t.getHiHokenshaNo().isEmpty()) {
            count++;
            edit処理結果確認リスト情報(eucCsvEntity, t, count);
            eucCsvWriter.writeLine(eucCsvEntity);
        }
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }

    private void edit処理結果確認リスト情報(ShoriKekkaKakuninListCsvEntity eucCsvEntity, ShoriKekkaKakuninListTempTableEntity t, int count) {
        if (先頭_作成日時_アカウント == count) {
            eucCsvEntity.set作成日時(editシステム作成日時());
        } else {
            eucCsvEntity.set作成日時(RString.EMPTY);
        }
        if (t.getErrorKubun() != null && !t.getErrorKubun().isEmpty()) {
            eucCsvEntity.set処理名(FurikomiDataSakusei_ErrorKubun.get処理名(t.getErrorKubun()));
        }

        if (t.getShoKisaiHokenshaNo() != null) {
            eucCsvEntity.set証記載保険者番号(t.getShoKisaiHokenshaNo().value());
        }
        if (t.getHiHokenshaNo() != null) {
            eucCsvEntity.set被保険者番号(t.getHiHokenshaNo().value());
        }

        if (t.getErrorKubun() != null && !t.getErrorKubun().isEmpty()) {
            eucCsvEntity.setエラー内容(FurikomiDataSakusei_ErrorKubun.getエラーメッセージ(t.getErrorKubun()));
        }

        eucCsvEntity.set備考(t.getBiko());
    }

    private RString editシステム作成日時() {
        StringBuilder builder = new StringBuilder();

        RDateTime システム日時 = RDateTime.now();
        RString 編集後日付 = システム日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        RString 作成時 = システム日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);

        builder.append(編集後日付);
        builder.append(作成時);
        builder.append(RString.FULL_SPACE);
        builder.append(作成);
        return new RString(builder.toString());
    }
}
