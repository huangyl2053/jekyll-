/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
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

    private HokenshaKyufujissekiOutListSakuseiProcessParameter parameter;
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
    private static final int INT_0 = 0;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC900002"));
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujissekiout."
            + "IHokenshaKyufujissekiOutMapper.select処理結果リスト一時TBL");

    private CsvListWriter csvListWriter;
    private FileSpoolManager manager;
    private RString eucFilePath;

    @Override
    protected void initialize() {
        super.initialize();
        KokuhorenJoho_SakuseiErrorListType エラーリストタイプ = parameter.getエラーリストタイプ();
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
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(headerList)
                .build();
    }

    @Override
    protected void process(DbWT1002KokuhorenSakuseiErrorTempEntity entity) {

        List<RString> outputList = this.getCSVファイル(entity);
        csvListWriter.writeLine(this.toBodyList(outputList));
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
        } else {
            rStringList.add(RString.EMPTY);
        }
        try {
            KokuhorenJoho_SakuseiErrorKubun.toValue(entity.getErrorKubun());
            rStringList.add(KokuhorenJoho_SakuseiErrorKubun.get処理名(entity.getErrorKubun()));
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(HokenshaKyufujissekiOutListSakuseiProcess.class.getName()).log(Level.SEVERE, null, ex);
            throw new BatchInterruptedException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(
                    MSG_国保連情報作成エラー区分.toString()).toString());
        }
        rStringList.add(getColumnValue(entity.getShoHokanehshaNo()));
        rStringList.add(getColumnValue(entity.getHihokenshaNo()));
        rStringList.add(entity.getHihokenshaKanaShimei());
        rStringList.add(entity.getHihokenshaShimei());
        if (this.key_1flag) {
            rStringList.add(entity.getKey1());
        }
        if (this.key_2flag) {
            rStringList.add(entity.getKey2());
        }
        if (this.key_3flag) {
            rStringList.add(entity.getKey3());
        }
        if (this.key_4flag) {
            rStringList.add(entity.getKey4());
        }
        if (this.key_5flag) {
            rStringList.add(entity.getKey5());
        }
        rStringList.add(KokuhorenJoho_SakuseiErrorKubun.getエラーメッセージ(entity.getErrorKubun()));
        rStringList.add(entity.getBiko());
        return rStringList;
    }

    @Override
    protected void afterExecute() {
        csvListWriter.close();
        manager.spool(eucFilePath);
    }

    private RString getColumnValue(IDbColumnMappable column) {
        if (null == column) {
            return RString.EMPTY;
        }
        return column.getColumnValue();
    }

    private List<RString> toBodyList(List<RString> bodyList) {
        for (int i = INT_0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
        return bodyList;
    }

}
