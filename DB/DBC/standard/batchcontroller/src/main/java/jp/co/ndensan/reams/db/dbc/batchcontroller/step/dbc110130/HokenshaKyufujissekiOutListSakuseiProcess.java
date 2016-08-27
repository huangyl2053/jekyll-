/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 処理結果リスト作成する。
 *
 * @reamsid_L DBC-2460-011 jiangwenkai
 */
public class HokenshaKyufujissekiOutListSakuseiProcess extends BatchProcessBase<DbWT1002KokuhorenSakuseiErrorTempEntity> {

    private KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter;
    private List<RString> headerList;
    private boolean key_1flag = false;
    private boolean key_2flag = false;
    private boolean key_3flag = false;
    private boolean key_4flag = false;
    private boolean key_5flag = false;

    private static final RString MSG_国保連情報作成エラーリストタイプ = new RString("国保連情報作成エラーリストタイプ");
    private static final RString MSG_国保連情報作成エラー区分 = new RString("国保連情報作成エラー区分");
    private static final RString 出力ファイル名 = new RString("DBC900002_KokuhorenDataSakuseiKekkaIchiran.csv");
    private static final RString HEADER_作成日時 = new RString("作成日時");
    private static final RString HEADER_処理名 = new RString("処理名");
    private static final RString HEADER_証記載保険者番号 = new RString("証記載保険者番号");
    private static final RString HEADER_被保険者番号 = new RString("被保険者番号");
    private static final RString HEADER_被保険者カナ氏名 = new RString("被保険者カナ氏名");
    private static final RString HEADER_被保険者氏名 = new RString("被保険者氏名");
    private static final RString HEADER_エラー内容 = new RString("エラー内容");
    private static final RString HEADER_備考 = new RString("備考");
    private static int numble_0 = 0;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC900002"));
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujissekiout"
            + "IHokenshaKyufujissekiOutMapper.select処理結果リスト一時TBL");

    @BatchWriter
    private CsvListWriter csvListWriter;

    @Override
    protected void initialize() {
        super.initialize();
        KokuhorenJoho_TorikomiErrorListType エラーリストタイプ = parameter.getエラーリストタイプ();
        if (null == parameter.getエラーリストタイプ()) {
            throw new BatchInterruptedException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(
                    MSG_国保連情報作成エラーリストタイプ.toString()).toString());
        }
        RString key1 = エラーリストタイプ.getキー1();
        RString key2 = エラーリストタイプ.getキー2();
        RString key3 = エラーリストタイプ.getキー3();
        RString key4 = エラーリストタイプ.getキー4();
        RString key5 = エラーリストタイプ.getキー5();
        this.headerList = new ArrayList<>();
        headerList.add(HEADER_作成日時);
        headerList.add(HEADER_処理名);
        headerList.add(HEADER_証記載保険者番号);
        headerList.add(HEADER_被保険者番号);
        headerList.add(HEADER_被保険者カナ氏名);
        headerList.add(HEADER_被保険者氏名);
        if (!RString.isNullOrEmpty(key1)) {
            headerList.add(key1);
            this.key_1flag = true;
        }
        if (!RString.isNullOrEmpty(key2)) {
            headerList.add(key2);
            this.key_2flag = true;
        }
        if (!RString.isNullOrEmpty(key3)) {
            headerList.add(key3);
            this.key_3flag = true;
        }
        if (!RString.isNullOrEmpty(key4)) {
            headerList.add(key4);
            this.key_4flag = true;
        }
        if (!RString.isNullOrEmpty(key5)) {
            headerList.add(key5);
            this.key_5flag = true;
        }
        headerList.add(HEADER_エラー内容);
        headerList.add(HEADER_備考);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
                .hasHeader(true).setHeader(headerList)
                .build();
    }

    @Override
    protected void process(DbWT1002KokuhorenSakuseiErrorTempEntity entity) {
        List<RString> outputList = this.getCSVファイル(entity);
        csvListWriter.writeLine(outputList);
    }

    private List<RString> getCSVファイル(DbWT1002KokuhorenSakuseiErrorTempEntity entity) {

        List<RString> rStringList = new ArrayList<>();
        if (numble_0 == 0) {
            RDateTime 作成日時 = RDateTime.now();
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            rStringList.add(作成日.concat(RString.HALF_SPACE).concat(作成時));
            numble_0++;
        }
        rStringList.add(getColumnValue(entity.get証記載保険者番号()));
        rStringList.add(getColumnValue(entity.get被保険者番号()));
        rStringList.add(entity.get被保険者カナ氏名());
        rStringList.add(entity.get被保険者氏名());
        if (this.key_1flag) {
            rStringList.add(entity.getキー1());
        }
        if (this.key_2flag) {
            rStringList.add(entity.getキー2());
        }
        if (this.key_3flag) {
            rStringList.add(entity.getキー3());
        }
        if (this.key_4flag) {
            rStringList.add(entity.getキー4());
        }
        if (this.key_5flag) {
            rStringList.add(entity.getキー5());
        }
        rStringList.add(entity.get備考());
        try {
            rStringList.add(KokuhorenJoho_TorikomiErrorKubun.get処理名(entity.getエラー区分()));
            rStringList.add(KokuhorenJoho_TorikomiErrorKubun.getエラーメッセージ(entity.getエラー区分()));
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(HokenshaKyufujissekiOutListSakuseiProcess.class.getName()).log(Level.SEVERE, null, ex);
            throw new BatchInterruptedException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(
                    MSG_国保連情報作成エラー区分.toString()).toString());
        }
        return rStringList;
    }

    @Override
    protected void afterExecute() {
        csvListWriter.close();
    }

    private RString getColumnValue(IDbColumnMappable column) {
        if (null == column) {
            return RString.EMPTY;
        }
        return column.getColumnValue();
    }

}
