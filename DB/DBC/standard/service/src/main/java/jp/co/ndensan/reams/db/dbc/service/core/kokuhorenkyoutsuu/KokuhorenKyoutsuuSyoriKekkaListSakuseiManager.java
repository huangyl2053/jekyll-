package jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.entity.csv.SyoriKekkaListItijiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu.SyoriKekkaListItijiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 国保連情報取込処理共通のビジネスです。<br>
 * 処理結果リスト作成
 *
 * @reamsid_L DBC-0980-550 zhangrui
 */
public class KokuhorenKyoutsuuSyoriKekkaListSakuseiManager {

    private final MapperProvider mapperProvider;

    private static final RString 国保連情報取込エラーリストタイプ = new RString("国保連情報取込エラーリストタイプ");
    private static final RString 出力ファイル名 = new RString("DBC900001_KokuhorenDataTorikomiKekkaIchiran.csv");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString HEADER_作成日時 = new RString("作成日時");
    private static final RString HEADER_処理名 = new RString("処理名");
    private static final RString HEADER_証記載保険者番号 = new RString("証記載保険者番号");
    private static final RString HEADER_被保険者番号 = new RString("被保険者番号");
    private static final RString HEADER_被保険者カナ氏名 = new RString("被保険者カナ氏名");
    private static final RString HEADER_被保険者氏名 = new RString("被保険者氏名");
    private static final RString HEADER_キー1 = new RString("キー1");
    private static final RString HEADER_キー2 = new RString("キー2");
    private static final RString HEADER_キー3 = new RString("キー3");
    private static final RString HEADER_キー4 = new RString("キー4");
    private static final RString HEADER_キー5 = new RString("キー5");
    private static final RString HEADER_エラー内容 = new RString("エラー内容");
    private static final RString HEADER_備考 = new RString("備考");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC900001"));

    @BatchWriter
    private CsvListWriter csvListWriter;

    /**
     * 国保連情報取込共通処理（処理結果リスト作成）のコンストラクタ。
     *
     */
    public KokuhorenKyoutsuuSyoriKekkaListSakuseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 国保連情報取込共通処理（処理結果リスト作成）
     *
     * @param エラーリストタイプ KokuhorenJoho_TorikomiErrorListType
     */
    public void create国保連情報データ取込処理結果リスト(KokuhorenJoho_TorikomiErrorListType エラーリストタイプ) {
        requireNonNull(国保連情報取込エラーリストタイプ, UrSystemErrorMessages.値がnull.
                getReplacedMessage(国保連情報取込エラーリストタイプ.toString()));
        RString key1 = エラーリストタイプ.getキー1();
        RString key2 = エラーリストタイプ.getキー2();
        RString key3 = エラーリストタイプ.getキー3();
        RString key4 = エラーリストタイプ.getキー4();
        RString key5 = エラーリストタイプ.getキー5();

        List<RString> headerList = new ArrayList<>();
        headerList.add(HEADER_作成日時);
        headerList.add(HEADER_処理名);
        headerList.add(HEADER_証記載保険者番号);
        headerList.add(HEADER_被保険者番号);
        headerList.add(HEADER_被保険者カナ氏名);
        headerList.add(HEADER_被保険者氏名);
        if (!RString.isNullOrEmpty(key1)) {
            headerList.add(HEADER_キー1);
        }
        if (!RString.isNullOrEmpty(key2)) {
            headerList.add(HEADER_キー2);
        }
        if (!RString.isNullOrEmpty(key3)) {
            headerList.add(HEADER_キー3);
        }
        if (!RString.isNullOrEmpty(key4)) {
            headerList.add(HEADER_キー4);
        }
        if (!RString.isNullOrEmpty(key5)) {
            headerList.add(HEADER_キー5);
        }
        headerList.add(HEADER_エラー内容);
        headerList.add(HEADER_備考);

        IKokuhorenKyoutsuuMapper mapper = mapperProvider.create(IKokuhorenKyoutsuuMapper.class);
        List<SyoriKekkaListItijiEntity> entityList = mapper.select処理結果リスト一時TBL();
        if (null != entityList && !entityList.isEmpty()) {
            List<SyoriKekkaListItijiCSVEntity> csvEntityList = new ArrayList<>();
            boolean isFirst = true;
            for (SyoriKekkaListItijiEntity data : entityList) {
                SyoriKekkaListItijiCSVEntity entity = new SyoriKekkaListItijiCSVEntity();
                if (isFirst) {
                    YMDHMS currentTime = YMDHMS.now();
                    RString 年月日 = currentTime.getRDateTime().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                            .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                    RString 時刻 = currentTime.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
                    entity.set作成日時(new RString(年月日.concat(時刻.toString()).toString()));
                }
                entity.set処理名(data.getエラー区分().get処理名());
                entity.set証記載保険者番号(data.get証記載保険者番号().getColumnValue());
                entity.set被保険者番号(data.get被保険者番号().getColumnValue());
                entity.set被保険者カナ氏名(data.get被保険者カナ氏名());
                entity.set被保険者氏名(data.get被保険者氏名());
                entity.setキー1(data.getキー1());
                entity.setキー2(data.getキー2());
                entity.setキー3(data.getキー3());
                entity.setキー4(data.getキー4());
                entity.setキー5(data.getキー5());
                entity.setエラー内容(data.getエラー区分().getエラーメッセージ());
                entity.set備考(data.get備考());
                csvEntityList.add(entity);
            }

            FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                    EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
            RString spoolWorkPath = manager.getEucOutputDirectry();
            RString eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);

            csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                    .setDelimiter(カンマ)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setEncode(Encode.SJIS)
                    .hasHeader(true).setHeader(headerList)
                    .build();
            for (SyoriKekkaListItijiCSVEntity data : csvEntityList) {
                List<RString> rList = new ArrayList<>();
                rList.add(data.getエラー内容());
                if (!RString.isNullOrEmpty(key1)) {
                    rList.add(getNotNull(data.getキー1()));
                }
                if (!RString.isNullOrEmpty(key2)) {
                    rList.add(getNotNull(data.getキー2()));
                }
                if (!RString.isNullOrEmpty(key3)) {
                    rList.add(getNotNull(data.getキー3()));
                }
                if (!RString.isNullOrEmpty(key4)) {
                    rList.add(getNotNull(data.getキー4()));
                }
                if (!RString.isNullOrEmpty(key5)) {
                    rList.add(getNotNull(data.getキー5()));
                }
                rList.add(getNotNull(data.get作成日時()));
                rList.add(getNotNull(data.get備考()));
                rList.add(getNotNull(data.get処理名()));
                rList.add(getNotNull(data.get被保険者カナ氏名()));
                rList.add(getNotNull(data.get被保険者氏名()));
                rList.add(getNotNull(data.get被保険者番号()));
                rList.add(getNotNull(data.get証記載保険者番号()));

                csvListWriter.writeLine(rList);
            }

            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
            csvListWriter.close();
        }
    }

    private RString getNotNull(RString rstring) {
        return RString.isNullOrEmpty(rstring) ? RString.EMPTY : rstring;
    }

}
