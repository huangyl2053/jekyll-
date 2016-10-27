/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB213001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.euc.dbb213001.TokuchoSofuJohoRenkeiCsvEntityEditor;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosofujohorenkei.FlowEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosofujohorenkei.ITokuchoSofuJohoRenkeiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.fld.FldWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 特徴送付情報連携プロセスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
public class CreateRenkeiFileProcess extends BatchProcessBase<TokuchoSofuJohoRenkeiEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosofujohorenkei.ITokuchoSofuJohoRenkeiMapper"
                    + ".select特徴送付情報連携のデータ");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString Z1A000XXDTA = new RString("Z1A000xx.DTA");
    private static final RString Z99_550_XXDTA = new RString("Z99_550_xx.DTA");
    private static final RString DEXXZ12YYYY01DTA = new RString("DExxZ12yyyy01.DTA");
    private static final RString DEXXZ1AYYYYZZDTA = new RString("DExxZ1Ayyyyzz.DTA");
    private static final RString 七月 = new RString("7");
    private static final RString XX = new RString("xx");
    private static final RString YYYY = new RString("yyyy");
    private static final RString ZZ = new RString("zz");
    private static final RString 介護_依頼_汎用キー = new RString("NenkinTokuchoBaitaiTsuban");
    private static final int INT_ZERO = 0;
    private static final int INT_FIVE = 5;
    private static final int INT_TWO = 2;
    private TokuchoSofuJohoRenkeiProcessParameter proParameter;
    private FlexibleYear 処理年度;
    private RYearMonth 処理対象年月;
    private List<RString> 市町村コードリスト;
    private List<RString> ファイル出力Z99_550List;
    private List<RString> ファイル出力Z1A000List;
    private List<RString> ファイル出力DE__Z12List;
    private List<RString> ファイル出力DE__Z1AList;
    private Map<RString, RString> 市町村IDMap;
    private Map<RString, Decimal> 各種金額欄合偉一;
    private Map<RString, Decimal> 各種金額欄合計二;
    private Map<RString, FldWriter> ファイル出力Z1A000Map;
    private Map<RString, FldWriter> ファイル出力Z99_550Map;
    private Map<RString, FldWriter> ファイル出力DE__Z12Map;
    private Map<RString, FldWriter> ファイル出力DE__Z1AMap;
    private Map<RString, RString> ファイルOutputMap;
    private Map<RString, Integer> レコード件数OutputMap;
    private Map<RString, RString> 作成年月日OutputMap;
    private RString 市町村;
    private RString 通知内容コード;
    private RString 特別徴収義務者コード;
    private Decimal 各種金額欄合計1 = Decimal.ZERO;
    private Decimal 各種金額欄合計2 = Decimal.ZERO;
    private CountedItem countedItem;
    private long 媒体通番;
    private int count = 0;
    private int dataCount = 1;
    private int レコード件数 = 2;
    private TokuchoSofuJohoRenkeiEntity 特徴送付情報連携情報;
    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_RETURNENTITY;
    private OutputParameter<FlowEntity> returnEntity;

    @BatchWriter
    private FldWriter fldZ1A000Writer;
    private FldWriter fldZ99_550Writer;
    private FldWriter fldDE__Z12Writer;
    private FldWriter fldDE__Z1AWriter;

    static {
        PARAMETER_OUT_RETURNENTITY = new RString("returnEntity");
    }

    @Override
    protected void initialize() {
        処理年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        処理対象年月 = RDate.getNowDate().getYearMonth();
        市町村 = RString.EMPTY;
        市町村コードリスト = new ArrayList<>();
        市町村IDMap = new HashMap<>();
        returnEntity = new OutputParameter<>();
        ファイルOutputMap = new HashMap<>();
        レコード件数OutputMap = new HashMap<>();
        ファイル出力Z1A000Map = new HashMap<>();
        ファイル出力Z99_550Map = new HashMap<>();
        ファイル出力DE__Z12Map = new HashMap<>();
        ファイル出力DE__Z1AMap = new HashMap<>();
        各種金額欄合偉一 = new HashMap<>();
        各種金額欄合計二 = new HashMap<>();
        作成年月日OutputMap = new HashMap<>();
        ファイル出力Z99_550List = new ArrayList<>();
        ファイル出力Z1A000List = new ArrayList<>();
        ファイル出力DE__Z12List = new ArrayList<>();
        ファイル出力DE__Z1AList = new ArrayList<>();
        proParameter = new TokuchoSofuJohoRenkeiProcessParameter();
        countedItem = Saiban.get(SubGyomuCode.UEX分配集約公開, 介護_依頼_汎用キー);
        媒体通番 = countedItem.next();
        List<DbT7051KoseiShichosonMasterEntity> 広域市町村情報 = getMapper(ITokuchoSofuJohoRenkeiMapper.class).select広域市町村情報();
        if (!広域市町村情報.isEmpty()) {
            for (DbT7051KoseiShichosonMasterEntity item : 広域市町村情報) {
                市町村コードリスト.add(item.getShichosonCode().value().substring(INT_ZERO, INT_FIVE));
                市町村IDMap.put(item.getShichosonCode().value().substring(INT_ZERO, INT_FIVE), item.getShichosonShokibetsuID());
            }
        }
        proParameter.set処理年度(処理年度);
        proParameter.set処理対象年月(処理対象年月);
        proParameter.set市町村コードリスト(市町村コードリスト);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, proParameter.toTokuchoSofuJohoRenkeiMybitisParameter());
    }

    @Override
    protected void createWriter() {
        int number = 0;
        for (RString 市町村コード : 市町村コードリスト) {
            RString ファイル出力Z1A000 = Z1A000XXDTA.replace(XX, 市町村IDMap.get(市町村コード));
            RString z1a000FilePath = Path.combinePath(Path.getTmpDirectoryPath(), ファイル出力Z1A000);
            ファイル出力Z1A000List.add(ファイル出力Z1A000);
            fldZ1A000Writer = new FldWriter.InstanceBuilder(z1a000FilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEncodeUtf8(true).
                    setNewLine(NewLine.CRLF).
                    build();
            ファイル出力Z1A000Map.put(市町村コード, fldZ1A000Writer);
            RString ファイル出力Z99_550 = Z99_550_XXDTA.replace(XX, 市町村IDMap.get(市町村コード));
            RString z99_550FilePath = Path.combinePath(Path.getTmpDirectoryPath(), ファイル出力Z99_550);
            ファイル出力Z99_550List.add(ファイル出力Z99_550);
            fldZ99_550Writer = new FldWriter.InstanceBuilder(z99_550FilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEncodeUtf8(true).
                    setNewLine(NewLine.CRLF).
                    build();
            ファイル出力Z99_550Map.put(市町村コード, fldZ99_550Writer);
            if (七月.equals(new RString(処理対象年月.getMonthValue()))) {
                RString ファイル出力DE__Z12 = DEXXZ12YYYY01DTA.replace(XX, 市町村IDMap.get(市町村コード)).replace(YYYY,
                        処理年度.toDateString());
                RString de__Z12FilePath = Path.combinePath(Path.getTmpDirectoryPath(), ファイル出力DE__Z12);
                ファイル出力DE__Z12List.add(ファイル出力DE__Z12);
                fldDE__Z12Writer = new FldWriter.InstanceBuilder(de__Z12FilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEncodeUtf8(true).
                        setNewLine(NewLine.CRLF).
                        build();
                ファイル出力DE__Z12Map.put(市町村コード, fldDE__Z12Writer);
                ファイルOutputMap.put(市町村コード, ファイル出力DE__Z12);
                レコード件数OutputMap.put(市町村コード, INT_ZERO);
                作成年月日OutputMap.put(市町村コード, new RString(YMDHMS.now().toString()).concat(new RString(RDateTime.now().getMillisOfSecond())));
            } else {
                RString ファイル出力DE__Z1A = DEXXZ1AYYYYZZDTA.replace(XX, 市町村IDMap.get(市町村コード)).replace(YYYY,
                        処理年度.toDateString()).replace(ZZ, new RString(number).padZeroToLeft(INT_TWO));
                RString de__Z1AFilePath = Path.combinePath(Path.getTmpDirectoryPath(), ファイル出力DE__Z1A);
                ファイル出力DE__Z1AList.add(ファイル出力DE__Z1A);
                fldDE__Z1AWriter = new FldWriter.InstanceBuilder(de__Z1AFilePath).
                        setDelimiter(EUC_WRITER_DELIMITER).
                        setEncodeUtf8(true).
                        setNewLine(NewLine.CRLF).
                        build();
                ファイル出力DE__Z1AMap.put(市町村コード, fldDE__Z1AWriter);
                ファイルOutputMap.put(市町村コード, ファイル出力DE__Z1A);
                レコード件数OutputMap.put(市町村コード, INT_ZERO);
                作成年月日OutputMap.put(市町村コード, new RString(YMDHMS.now().toString()).concat(new RString(RDateTime.now().getMillisOfSecond())));
            }
            number++;
        }
    }

    @Override
    protected void process(TokuchoSofuJohoRenkeiEntity entity) {
        if (市町村.equals(entity.get構成市町村コード())) {
            if (七月.equals(new RString(処理対象年月.getMonthValue()))) {
                editブロック(entity, ファイル出力DE__Z12Map);
            } else {
                editブロック(entity, ファイル出力DE__Z1AMap);
            }
        } else {
            通知内容コード = RString.EMPTY;
            特別徴収義務者コード = RString.EMPTY;
            if (七月.equals(new RString(処理対象年月.getMonthValue()))) {
                ファイル出力Z1A000Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                        .edit管理(媒体通番));
                ファイル出力Z1A000Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                        .editファイル管理(dataCount));
                ファイル出力Z99_550Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                        .edit管理(媒体通番));
                ファイル出力Z99_550Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                        .editファイル管理(dataCount));
                editブロック(entity, ファイル出力DE__Z12Map);
            } else {
                ファイル出力Z1A000Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                        .edit管理(媒体通番));
                ファイル出力Z1A000Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                        .editファイル管理(count));
                ファイル出力Z99_550Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                        .edit管理(媒体通番));
                ファイル出力Z99_550Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                        .editファイル管理(count));
                editブロック(entity, ファイル出力DE__Z1AMap);
            }
            市町村 = entity.get構成市町村コード();
            dataCount = 0;
        }
        特徴送付情報連携情報 = entity;
        count++;
    }

    private void editブロック(TokuchoSofuJohoRenkeiEntity entity, Map<RString, FldWriter> writerMap) {
        if (通知内容コード.equals(entity.get通知内容コードDT()) && 特別徴収義務者コード.equals(entity.get特別徴収義務者コードDT().value())) {
            各種金額欄合計1 = 各種金額欄合計1.add(new Decimal(entity.get各種金額欄1DT().toString()));
            各種金額欄合計2 = 各種金額欄合計2.add(new Decimal(entity.get各種金額欄2DT().toString()));
            レコード件数++;
            dataCount++;
            ファイル出力Z1A000Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity).editデータ());
            ファイル出力Z99_550Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                    .editデータZ99_550_xx_DTAファイルのみ());
            writerMap.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity).editデータ());
        } else {
            各種金額欄合計1 = new Decimal(entity.get各種金額欄1DT().toString());
            各種金額欄合計2 = new Decimal(entity.get各種金額欄2DT().toString());
            editトレイラ(entity, writerMap);
            レコード件数++;
            ファイル出力Z1A000Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity).editヘッダ());
            ファイル出力Z99_550Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity).editヘッダ());
            レコード件数++;
            ファイル出力Z1A000Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity).editデータ());
            ファイル出力Z99_550Map.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity)
                    .editデータZ99_550_xx_DTAファイルのみ());
            dataCount++;
            writerMap.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity).editヘッダ());
            writerMap.get(entity.get構成市町村コード()).writeLine(new TokuchoSofuJohoRenkeiCsvEntityEditor(entity).editデータ());

        }
        通知内容コード = entity.get通知内容コードDT();
        特別徴収義務者コード = entity.get特別徴収義務者コードDT().value();
        各種金額欄合偉一.put(entity.get構成市町村コード(), 各種金額欄合計1);
        各種金額欄合計二.put(entity.get構成市町村コード(), 各種金額欄合計2);
    }

    private void editトレイラ(TokuchoSofuJohoRenkeiEntity entity, Map<RString, FldWriter> writerMap) {
        if (count != INT_ZERO) {
            レコード件数++;
            ファイル出力Z1A000Map.get(特徴送付情報連携情報.get構成市町村コード()).writeLine(
                    new TokuchoSofuJohoRenkeiCsvEntityEditor(特徴送付情報連携情報)
                    .editトレイラ(各種金額欄合偉一.get(特徴送付情報連携情報.get構成市町村コード()),
                            各種金額欄合計二.get(特徴送付情報連携情報.get構成市町村コード()),
                            レコード件数));
            ファイル出力Z99_550Map.get(特徴送付情報連携情報.get構成市町村コード()).writeLine(
                    new TokuchoSofuJohoRenkeiCsvEntityEditor(特徴送付情報連携情報)
                    .editトレイラ(各種金額欄合偉一.get(特徴送付情報連携情報.get構成市町村コード()),
                            各種金額欄合計二.get(特徴送付情報連携情報.get構成市町村コード()),
                            レコード件数));
            writerMap.get(特徴送付情報連携情報.get構成市町村コード()).writeLine(
                    new TokuchoSofuJohoRenkeiCsvEntityEditor(特徴送付情報連携情報)
                    .editトレイラ(各種金額欄合偉一.get(特徴送付情報連携情報.get構成市町村コード()),
                            各種金額欄合計二.get(特徴送付情報連携情報.get構成市町村コード()),
                            レコード件数 - INT_TWO));

            if (!市町村.equals(entity.get構成市町村コード())) {
                レコード件数OutputMap.put(市町村, レコード件数 - INT_TWO);
                レコード件数 = INT_TWO;
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (特徴送付情報連携情報 != null) {
            レコード件数++;
            ファイル出力Z1A000Map.get(特徴送付情報連携情報.get構成市町村コード()).writeLine(
                    new TokuchoSofuJohoRenkeiCsvEntityEditor(特徴送付情報連携情報)
                    .editトレイラ(各種金額欄合偉一.get(特徴送付情報連携情報.get構成市町村コード()),
                            各種金額欄合計二.get(特徴送付情報連携情報.get構成市町村コード()),
                            レコード件数));
            ファイル出力Z99_550Map.get(特徴送付情報連携情報.get構成市町村コード()).writeLine(
                    new TokuchoSofuJohoRenkeiCsvEntityEditor(特徴送付情報連携情報)
                    .editトレイラ(各種金額欄合偉一.get(特徴送付情報連携情報.get構成市町村コード()),
                            各種金額欄合計二.get(特徴送付情報連携情報.get構成市町村コード()),
                            レコード件数));
            if (!七月.equals(new RString(処理対象年月.getMonthValue()))) {
                ファイル出力DE__Z1AMap.get(特徴送付情報連携情報.get構成市町村コード()).writeLine(
                        new TokuchoSofuJohoRenkeiCsvEntityEditor(特徴送付情報連携情報)
                        .editトレイラ(各種金額欄合偉一.get(特徴送付情報連携情報.get構成市町村コード()),
                                各種金額欄合計二.get(特徴送付情報連携情報.get構成市町村コード()),
                                レコード件数 - INT_TWO));
            } else {
                ファイル出力DE__Z12Map.get(特徴送付情報連携情報.get構成市町村コード()).writeLine(
                        new TokuchoSofuJohoRenkeiCsvEntityEditor(特徴送付情報連携情報)
                        .editトレイラ(各種金額欄合偉一.get(特徴送付情報連携情報.get構成市町村コード()),
                                各種金額欄合計二.get(特徴送付情報連携情報.get構成市町村コード()),
                                レコード件数 - INT_TWO));
            }
            レコード件数OutputMap.put(特徴送付情報連携情報.get構成市町村コード(), レコード件数 - INT_TWO);
        }
        FlowEntity flowEntity = new FlowEntity();
        flowEntity.setレコード件数(レコード件数OutputMap);
        flowEntity.setファイル(ファイルOutputMap);
        flowEntity.set作成年月日OutputMap(作成年月日OutputMap);
        returnEntity.setValue(flowEntity);
        for (RString fileName : ファイル出力Z1A000List) {
            FilesystemName sharedFileName = new FilesystemName(fileName);
            SharedFile.defineSharedFile(sharedFileName);
            FilesystemPath 絶対パス = new FilesystemPath(Path.getTmpDirectoryPath());
            SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        }
        for (RString fileName : ファイル出力Z99_550List) {
            FilesystemName sharedFileName = new FilesystemName(fileName);
            SharedFile.defineSharedFile(sharedFileName);
            FilesystemPath 絶対パス = new FilesystemPath(Path.getTmpDirectoryPath());
            SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        }
        for (RString fileName : ファイル出力DE__Z12List) {
            FilesystemName sharedFileName = new FilesystemName(fileName);
            SharedFile.defineSharedFile(sharedFileName);
            FilesystemPath 絶対パス = new FilesystemPath(Path.getTmpDirectoryPath());
            SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        }
        for (RString fileName : ファイル出力DE__Z1AList) {
            FilesystemName sharedFileName = new FilesystemName(fileName);
            SharedFile.defineSharedFile(sharedFileName);
            FilesystemPath 絶対パス = new FilesystemPath(Path.getTmpDirectoryPath());
            SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        }
    }
}
