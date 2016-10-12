/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.HokenshaKyufujissekiKokanjohoSikibetsuNo;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujisseki.DbWT1111KyufuJissekiTempTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.service.core.hokenshakyufujisseki.HokenshaKyufujissekiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成のデータレコードの書き込みProcessです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class InsDataRecordTempProcess extends BatchProcessBase<DbWT1111KyufuJissekiTempTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get給付実績Temp");
    private static final RString 給付実績一時NAME = new RString("DbWT1111KyufuJisseki");
    private static final RString ファイル名_前 = new RString("10_113");
    private static final RString ファイル名_後 = new RString(".csv");
    private static final RString コンマ = new RString(",");
    private static final RString 囲みの文字 = new RString("\"");
    private static final RString 国保連送付外字_変換区分_1 = new RString("1");
    private static final RString 不正MESSAGE = new RString("【入力識別番号：被保険者番号：サービス提供年月：事業者番号：通し番号】");
    private static final RString コロン = new RString(":");
    private static final RString 設定区分_0 = new RString("0");
    private static final RString DBC業務コンフィグ_1 = new RString("1");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_99 = new RString("99");
    private static final RString RSTRING_0000 = new RString("0000");
    private static final RString データ区分_00 = new RString("00");
    private static final RString データ区分_01 = new RString("01");
    private static final RString データ区分_02 = new RString("02");
    private static final RString データ区分_03 = new RString("03");
    private static final RString データ区分_04 = new RString("04");
    private static final RString データ区分_05 = new RString("05");
    private static final RString データ区分_06 = new RString("06");
    private static final RString データ区分_07 = new RString("07");
    private static final RString データ区分_08 = new RString("08");
    private static final RString データ区分_09 = new RString("09");
    private static final RString データ区分_10 = new RString("10");
    private static final RString データ区分_11 = new RString("11");
    private static final RString データ区分_12 = new RString("12");
    private static final RString データ区分_13 = new RString("13");
    private static final RString データ区分_14 = new RString("14");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;
    private static final int INT_100 = 100;
    /**
     * 総出力件数カウンターです。
     */
    public static final RString PARAMETER_OUT_OUTPUTCOUNT;
    /**
     * エントリ情報Listです。
     */
    public static final RString PARAMETER_OUT_OUTPUTENTRY;

    static {
        PARAMETER_OUT_OUTPUTCOUNT = new RString("outputCount");
        PARAMETER_OUT_OUTPUTENTRY = new RString("outputEntry");
    }

    private HokenshaKyufujissekiProcessParameter processParameter;
    private DbWT1111KyufuJissekiTempTempEntity 給付実績;
    private List<SharedFileDescriptor> entryList;
    private RString 出力ファイル名;
    private int 出力件数;
    private int 総出力件数;
    private RString csvFilePath;
    private Encode 文字コード;
    private boolean configFlag;
    private int レコード件数;
    private int cnt01;
    private int cnt02;
    private int cnt03;
    private int cnt13;
    private int cnt04;
    private int cnt05;
    private int cnt06;
    private int cnt07;
    private int cnt08;
    private int cnt10;
    private int cnt11;
    private int cnt12;
    private int cnt14;

    private OutputParameter<Integer> outputCount;
    private OutputParameter<List> outputEntry;
    @BatchWriter
    private CsvListWriter csvListWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績一時tableWriter;

    @Override
    protected void initialize() {
        cnt01 = INT_0;
        出力件数 = INT_0;
        総出力件数 = INT_0;
        給付実績 = null;
        outputEntry = new OutputParameter<>();
        outputCount = new OutputParameter<>();
        entryList = new ArrayList<>();
        configFlag = DBC業務コンフィグ_1.equals(processParameter.get国保連共同処理受託区分_償還())
                && DBC業務コンフィグ_1.equals(processParameter.get国保連共同処理受託区分_高額());
        if (!configFlag) {
            int 出力件数カウンター = HokenshaKyufujissekiFinder.createInstance().get給付実績Temp().size();
            int レコード件数_基本 = HokenshaKyufujissekiFinder.createInstance().get給付実績基本Temp().size();
            int レコード件数_高額 = HokenshaKyufujissekiFinder.createInstance().get給付実績高額Temp().size();
            if (DBC業務コンフィグ_1.equals(processParameter.get国保連共同処理受託区分_償還())) {
                レコード件数 = レコード件数_高額;
            } else if (DBC業務コンフィグ_1.equals(processParameter.get国保連共同処理受託区分_高額())) {
                レコード件数 = レコード件数_基本;
            } else {
                レコード件数 = 出力件数カウンター;
            }
        }
        RString 国保連送付外字_変換区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付外字_変換区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (国保連送付外字_変換区分_1.equals(国保連送付外字_変換区分)) {
            // TODO QA90831 文字コードがありません。
            文字コード = Encode.UTF_8withBOM;
        } else {
            文字コード = Encode.SJIS;
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, processParameter.toHokenshaKyufujissekiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        給付実績一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績一時NAME, DbWT1111KyufuJissekiEntity.class);
        if (!configFlag) {
            RString spoolWorkPath = Path.getTmpDirectoryPath();
            出力ファイル名 = ファイル名_前.concat(processParameter.get保険者番号().getColumnValue())
                    .concat(processParameter.getShoriYM().toDateString()).concat(ファイル名_後);
            csvFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
            csvListWriter = new CsvListWriter.InstanceBuilder(csvFilePath)
                    .setDelimiter(コンマ)
                    .setEnclosure(RString.EMPTY)
                    .setEncode(文字コード)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(false)
                    .build();
        }
    }

    @Override
    protected void process(DbWT1111KyufuJissekiTempTempEntity entity) {
        if (!configFlag && 出力件数 == INT_0) {
            出力件数 = 出力件数 + INT_1;
            List<RString> csvList = getコントロールlist();
            csvListWriter.writeLine(csvList);
        }
        出力件数 = 出力件数 + INT_1;
        総出力件数 = 総出力件数 + INT_1;
        if (データ区分_00.equals(entity.getDataKunbun()) && 給付実績 != null) {
            DbWT1111KyufuJissekiEntity 給付実績一時entity = get給付実績一時_基本entity(給付実績);
            給付実績一時tableWriter.insert(給付実績一時entity);
        } else if (データ区分_14.equals(entity.getDataKunbun()) && 給付実績 != null) {
            if (!データ区分_14.equals(給付実績.getDataKunbun())) {
                DbWT1111KyufuJissekiEntity 給付実績一時entity = get給付実績一時_基本entity(給付実績);
                給付実績一時tableWriter.insert(給付実績一時entity);
            } else {
                DbWT1111KyufuJissekiEntity 給付実績一時entity = get給付実績一時_高額entity(給付実績);
                給付実績一時tableWriter.insert(給付実績一時entity);
            }
        }
        if (!DBC業務コンフィグ_1.equals(processParameter.get国保連共同処理受託区分_償還()) && !データ区分_14.equals(entity.getDataKunbun())) {
            write送付ファイル_基本(entity);
        }
        if (!DBC業務コンフィグ_1.equals(processParameter.get国保連共同処理受託区分_高額()) && データ区分_14.equals(entity.getDataKunbun())) {
            List<RString> csvList = get高額list(entity);
            csvListWriter.writeLine(csvList);
        }
        給付実績 = entity;
    }

    @Override
    protected void afterExecute() {
        if (給付実績 != null) {
            if (データ区分_14.equals(給付実績.getDataKunbun())) {
                DbWT1111KyufuJissekiEntity 給付実績一時entity = get給付実績一時_高額entity(給付実績);
                給付実績一時tableWriter.insert(給付実績一時entity);
            } else {
                DbWT1111KyufuJissekiEntity 給付実績一時entity = get給付実績一時_基本entity(給付実績);
                給付実績一時tableWriter.insert(給付実績一時entity);
            }
        }
        if (!configFlag) {
            List<RString> csvList = getエンドレコードlist();
            csvListWriter.writeLine(csvList);
            SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力ファイル名));
            sfd = SharedFile.defineSharedFile(sfd, 1, SharedFile.GROUP_ALL, null, true, null);
            CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
            SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(csvFilePath), opts);
            entryList.add(sfd);
            csvListWriter.close();
        }
        outputEntry.setValue(entryList);
        outputCount.setValue(総出力件数);
    }

    private void write送付ファイル_基本(DbWT1111KyufuJissekiTempTempEntity entity) {
        if (データ区分_00.equals(entity.getDataKunbun())) {
            cnt01 = cnt01 + INT_1;
            件数カウンター初期化();
            if (entity.getDbWT1131_kokanShikibetsuNo().getColumnValue()
                    .compareTo(HokenshaKyufujissekiKokanjohoSikibetsuNo.平成20年4月以降.getコード()) < INT_0) {
                List<RString> csvList = get基本list(entity, INT_1);
                csvListWriter.writeLine(csvList);
            } else {
                List<RString> csvList = get基本list(entity, INT_2);
                csvListWriter.writeLine(csvList);
            }
        } else if (データ区分_01.equals(entity.getDataKunbun()) && entity.getDbT3018_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_meisaiSetteiKubun());
            cnt02 = cnt02 + INT_1;
            List<RString> csvList = get明細list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_02.equals(entity.getDataKunbun()) && entity.getDbT3019_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_kinkyuShisetsuRyoyoSetteiKubun());
            cnt03 = cnt03 + INT_1;
            List<RString> csvList = get施設list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_03.equals(entity.getDataKunbun()) && entity.getDbT3032_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_kinkyuShisetsuRyoyoSetteiKubun());
            cnt13 = cnt13 + INT_1;
            List<RString> csvList = get所定list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_04.equals(entity.getDataKunbun()) && entity.getDbT3020_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_tokuteiShinryoSetteiKubun());
            cnt04 = cnt04 + INT_1;
            List<RString> csvList = get特定診療list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_05.equals(entity.getDataKunbun()) && entity.getDbT3021_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_tokuteishinryoTokubetsuryoyoSetteiKubun());
            cnt04 = cnt04 + INT_1;
            List<RString> csvList = get特別療養list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_06.equals(entity.getDataKunbun()) && entity.getDbT3022_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_shokujiHiyosetteiKubun());
            cnt05 = cnt05 + INT_1;
            List<RString> csvList = get食事list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_07.equals(entity.getDataKunbun()) && entity.getDbT3025_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_kyotakuKeikakuSetteiKubun());
            cnt06 = cnt06 + INT_1;
            List<RString> csvList = get居宅list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_08.equals(entity.getDataKunbun()) && entity.getDbT3026_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_fukushoyouguKonyuSetteiKubun());
            cnt07 = cnt07 + INT_1;
            List<RString> csvList = get福祉list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_09.equals(entity.getDataKunbun()) && entity.getDbT3027_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_jutakukaishuSetteiKubun());
            cnt08 = cnt08 + INT_1;
            List<RString> csvList = get住宅list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_10.equals(entity.getDataKunbun()) && entity.getDbT3033_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_shukeiSetteiKubun());
            cnt10 = cnt10 + INT_1;
            List<RString> csvList = get集計list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_11.equals(entity.getDataKunbun()) && entity.getDbT3029_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_tokuteinyushoshaSetteiKubun());
            cnt11 = cnt11 + INT_1;
            List<RString> csvList = get入所list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_12.equals(entity.getDataKunbun()) && entity.getDbT3030_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_shakaifukushiKeigenSetteiKubun());
            cnt12 = cnt12 + INT_1;
            List<RString> csvList = get社福list(entity);
            csvListWriter.writeLine(csvList);
        } else if (データ区分_13.equals(entity.getDataKunbun()) && entity.getDbT3106_hiHokenshaNo() != null) {
            エラー処理(entity, entity.getDbWT1131_meisaiJushochitokureiSetteiKubun());
            cnt14 = cnt14 + INT_1;
            List<RString> csvList = get住特list(entity);
            csvListWriter.writeLine(csvList);
        }
    }

    private void エラー処理(DbWT1111KyufuJissekiTempTempEntity entity, RString kunbun) {
        if (設定区分_0.equals(kunbun)) {
            RString 入力識別番号 = entity.getInputShikibetsuNo() == null ? RString.EMPTY : entity.getInputShikibetsuNo().getColumnValue();
            RString 被保険者番号 = entity.getHiHokenshaNo() == null ? RString.EMPTY : entity.getHiHokenshaNo().getColumnValue();
            RString サービス提供年月 = entity.getServiceTeikyoYM() == null ? RString.EMPTY : entity.getServiceTeikyoYM().toDateString();
            RString 事業者番号 = entity.getJigyoshoNo() == null ? RString.EMPTY : entity.getJigyoshoNo().getColumnValue();
            RString message = 不正MESSAGE.concat(入力識別番号).concat(コロン)
                    .concat(被保険者番号).concat(コロン)
                    .concat(サービス提供年月).concat(コロン)
                    .concat(事業者番号).concat(コロン)
                    .concat(entity.getToshiNo());
            throw new BatchInterruptedException(DbcErrorMessages.給付実績組み合わせ不正.getMessage().replace(message.toString()).evaluate());
        }
    }

    private DbWT1111KyufuJissekiEntity get給付実績一時_高額entity(DbWT1111KyufuJissekiTempTempEntity entity) {
        DbWT1111KyufuJissekiEntity 一時entity = new DbWT1111KyufuJissekiEntity();
        一時entity.setRenban(entity.getDbWT1132_renban());
        一時entity.setKokanJohoShikibetsuNo(entity.getDbWT1132_kokanJohoShikibetsuNo() == null
                ? RString.EMPTY : entity.getDbWT1132_kokanJohoShikibetsuNo().getColumnValue());
        一時entity.setNyuryokuShikibetsuNo(entity.getDbWT1132_inputShikibetsuNo());
        一時entity.setRecordShubetsuCode(entity.getDbWT1132_recodeShubetsuCode());
        一時entity.setKyufuJissekiSakuseiKubunCode(entity.getDbWT1132_kyufuSakuseiKubunCode());
        一時entity.setServiceTeikyoYM(entity.getDbWT1132_serviceTeikyoYM());
        一時entity.setKyufuJissekiKubun(entity.getDbWT1132_kyufuJissekiKubunCode());
        一時entity.setJigyoshoNo(JigyoshaNo.EMPTY);
        一時entity.setSeiriNo(RString.EMPTY);
        一時entity.setRecordKensuH1(INT_0);
        一時entity.setRecordKensuD1(INT_0);
        一時entity.setRecordKensuDD(INT_0);
        一時entity.setRecordKensuD2(INT_0);
        一時entity.setRecordKensuDC(INT_0);
        一時entity.setRecordKensuD3(INT_0);
        一時entity.setRecordKensuD4(INT_0);
        一時entity.setRecordKensuD5(INT_0);
        一時entity.setRecordKensuD6(INT_0);
        一時entity.setRecordKensuD7(INT_0);
        一時entity.setRecordKensuD8(INT_1);
        一時entity.setRecordKensuDE(INT_0);
        一時entity.setRecordKensuT1(INT_0);
        一時entity.setRecordKensuD9(INT_0);
        一時entity.setRecordKensuDA(INT_0);
        一時entity.setRecordKensuDB(INT_0);
        一時entity.setKeikokuKubunCode(RString.EMPTY);
        一時entity.setHokenshaNo(entity.getDbWT1132_hokenshaNo());
        一時entity.setHokenshaName(entity.getDbWT1132_hokenshaName());
        一時entity.setJigyoshaName(RString.EMPTY);
        一時entity.setNyuryokuShikibetsuMeisho(RString.EMPTY);
        return 一時entity;
    }

    private DbWT1111KyufuJissekiEntity get給付実績一時_基本entity(DbWT1111KyufuJissekiTempTempEntity entity) {
        DbWT1111KyufuJissekiEntity 一時entity = new DbWT1111KyufuJissekiEntity();
        一時entity.setRenban(entity.getRenban1());
        一時entity.setKokanJohoShikibetsuNo(entity.getDbWT1131_kyotakuKaigoShienJigyoshoNo() == null
                ? RString.EMPTY : entity.getDbWT1131_kyotakuKaigoShienJigyoshoNo().getColumnValue());
        一時entity.setNyuryokuShikibetsuNo(entity.getInputShikibetsuNo());
        一時entity.setRecordShubetsuCode(entity.getDbWT1131_recodeShubetsuCode());
        一時entity.setKyufuJissekiSakuseiKubunCode(entity.getDbWT1131_kyufuSakuseiKubunCode());
        一時entity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        一時entity.setKyufuJissekiKubun(entity.getDbWT1131_kyufuJissekiKubunCode());
        JigyoshaNo 事業所番号 = entity.getJigyoshoNo();
        if (cnt01 == INT_0 && cnt02 == INT_0 && cnt03 == INT_0 && cnt13 == INT_0 && cnt04 == INT_0 && cnt05 == INT_0
                && cnt06 == INT_0 && cnt07 == INT_0 && cnt08 == INT_0 && cnt10 == INT_0 && cnt11 == INT_0 && cnt12 == INT_0 && cnt14 == INT_0) {
            事業所番号 = JigyoshaNo.EMPTY;
        }
        一時entity.setJigyoshoNo(事業所番号);
        一時entity.setSeiriNo(entity.getDbWT1131_seiriNo());
        一時entity.setRecordKensuH1(cnt01);
        一時entity.setRecordKensuD1(cnt02);
        一時entity.setRecordKensuDD(cnt14);
        一時entity.setRecordKensuD2(cnt03);
        一時entity.setRecordKensuDC(cnt13);
        一時entity.setRecordKensuD3(cnt04);
        一時entity.setRecordKensuD4(cnt05);
        一時entity.setRecordKensuD5(cnt06);
        一時entity.setRecordKensuD6(cnt07);
        一時entity.setRecordKensuD7(cnt08);
        一時entity.setRecordKensuD8(INT_0);
        一時entity.setRecordKensuDE(INT_0);
        一時entity.setRecordKensuT1(cnt10);
        一時entity.setRecordKensuD9(cnt11);
        一時entity.setRecordKensuDA(cnt12);
        一時entity.setRecordKensuDB(INT_0);
        一時entity.setKeikokuKubunCode(RString.EMPTY);
        一時entity.setHokenshaNo(entity.getDbWT1131_hokenshaNo());
        一時entity.setHokenshaName(entity.getDbWT1131_hokenshaName());
        一時entity.setJigyoshaName(RString.EMPTY);
        一時entity.setNyuryokuShikibetsuMeisho(RString.EMPTY);
        return 一時entity;
    }

    private List<RString> getエンドレコードlist() {
        出力件数 = 出力件数 + INT_1;
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.エンドレコード.getコード());
        list.add(new RString(出力件数));
        return list;
    }

    private List<RString> get高額list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbWT1132_kokanJohoShikibetsuNo() == null
                ? null : entity.getDbWT1132_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1132_inputShikibetsuNo() == null ? null : entity.getDbWT1132_inputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1132_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbWT1132_kyufuSakuseiKubunCode()));
        list.add(trimRString(entity.getDbWT1132_shokisaiHokenshaNo() == null ? null : entity.getDbWT1132_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1132_sofuHihokenshaNo() == null ? null : entity.getDbWT1132_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1132_serviceTeikyoYM() == null ? null : entity.getDbWT1132_serviceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getDbWT1132_kyufuJissekiKubunCode()));
        list.add(trimRString(entity.getDbWT1132_uketsukeYMD() == null ? null : new RString(entity.getDbWT1132_uketsukeYMD().toString())));
        list.add(trimRString(entity.getDbWT1132_ketteiYMD() == null ? null : new RString(entity.getDbWT1132_ketteiYMD().toString())));
        list.add(trimRString(entity.getDbWT1132_kohi1FutanNo()));
        list.add(trimRString(entity.getDbWT1132_kohi2FutanNo()));
        list.add(trimRString(entity.getDbWT1132_kohi3FutanNo()));
        list.add(new RString(entity.getDbWT1132_riyoshaFutangaku()));
        list.add(new RString(entity.getDbWT1132_kohi1Futangaku()));
        list.add(new RString(entity.getDbWT1132_kohi2Futangaku()));
        list.add(new RString(entity.getDbWT1132_kohi3Futangaku()));
        list.add(new RString(entity.getDbWT1132_shikyugaku()));
        list.add(new RString(entity.getDbWT1132_kohi1Shikyugaku()));
        list.add(new RString(entity.getDbWT1132_kohi2Shikyugaku()));
        list.add(new RString(entity.getDbWT1132_kohi3Shikyugaku()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get住特list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3106_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3106_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3106_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3106_shokisaiHokenshaNo() == null ? null : entity.getDbT3106_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3106_seiriNo()));
        list.add(trimRString(entity.getDbT3106_serviceShuruiCode() == null ? null : entity.getDbT3106_serviceShuruiCode().getColumnValue()));
        list.add(trimRString(entity.getDbT3106_serviceKomokuCode() == null ? null : entity.getDbT3106_serviceKomokuCode().getColumnValue()));
        list.add(entity.getDbT3106_tanisu() == null ? RString.EMPTY : new RString(entity.getDbT3106_tanisu().toString()));
        list.add(entity.getDbT3106_nissuKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3106_nissuKaisu().toString()));
        list.add(entity.getDbT3106_kohi1TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3106_kohi1TaishoNissuKaisu().toString()));
        list.add(entity.getDbT3106_kohi2TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3106_kohi2TaishoNissuKaisu().toString()));
        list.add(entity.getDbT3106_kohi3TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3106_kohi3TaishoNissuKaisu().toString()));
        list.add(new RString(entity.getDbT3106_serviceTanisu()));
        list.add(new RString(entity.getDbT3106_kohi1TaishoServiceTanisu()));
        list.add(new RString(entity.getDbT3106_kohi2TaishoServiceTanisu()));
        list.add(new RString(entity.getDbT3106_kohi3TaishoServiceTanisu()));
        list.add(trimRString(entity.getDbT3106_shisetsuShozaiHokenshaNo() == null
                ? null : entity.getDbT3106_shisetsuShozaiHokenshaNo().getColumnValue()));
        list.add(囲み文字(trimRString(entity.getDbT3106_tekiyo())));
        list.add(entity.getDbT3106_atoTanisu() == null ? RString.EMPTY : new RString(entity.getDbT3106_atoTanisu().toString()));
        list.add(entity.getDbT3106_atoNissuKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3106_atoNissuKaisu().toString()));
        return get住特list(entity, list);
    }

    private List<RString> get住特list(DbWT1111KyufuJissekiTempTempEntity entity, List<RString> list) {
        list.add(entity.getDbT3106_atoKohi1TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3106_atoKohi1TaishoNissuKaisu().toString()));
        list.add(entity.getDbT3106_atoKohi2TaishoNissukaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3106_atoKohi2TaishoNissukaisu().toString()));
        list.add(entity.getDbT3106_atoKohi3TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3106_atoKohi3TaishoNissuKaisu().toString()));
        list.add(new RString(entity.getDbT3106_atoServiceTanisu()));
        list.add(new RString(entity.getDbT3106_atoKohi1TaishoServiceTanisu()));
        list.add(new RString(entity.getDbT3106_atoKohi2TaishoServiceTanisu()));
        list.add(new RString(entity.getDbT3106_atoKohi3TaishoServiceTanisu()));
        list.add(entity.getDbT3106_saishinsaKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3106_saishinsaKaisu().toString()));
        list.add(entity.getDbT3106_kagoKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3106_kagoKaisu().toString()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get社福list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3030_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3030_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3030_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3030_shokisaiHokenshaNo() == null ? null : entity.getDbT3030_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3030_seiriNo()));
        list.add(entity.getDbT3030_keigenritsu() == null
                ? RSTRING_0000 : new RString(entity.getDbT3030_keigenritsu().multiply(INT_100).toString()).padZeroToLeft(INT_4));
        list.add(trimRString(entity.getDbT3030_serviceSyuruiCode() == null ? null : entity.getDbT3030_serviceSyuruiCode().getColumnValue()));
        list.add(entity.getDbT3030_riyoshaFutanTotal() == null ? RString.EMPTY : new RString(entity.getDbT3030_riyoshaFutanTotal().toString()));
        list.add(entity.getDbT3030_keigengaku() == null ? RString.EMPTY : new RString(entity.getDbT3030_keigengaku().toString()));
        list.add(entity.getDbT3030_keigengoRiyoshaFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3030_keigengoRiyoshaFutangaku().toString()));
        list.add(囲み文字(trimRString(entity.getDbT3030_biko())));
        list.add(entity.getDbT3030_atoRiyoshaFutanTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3030_atoRiyoshaFutanTotal().toString()));
        list.add(entity.getDbT3030_atoKeigengaku() == null ? RString.EMPTY : new RString(entity.getDbT3030_atoKeigengaku().toString()));
        list.add(entity.getDbT3030_atoKeigengoRiyoshaFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3030_atoKeigengoRiyoshaFutangaku().toString()));
        list.add(entity.getDbT3030_saishinsaKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3030_saishinsaKaisu().intValue()));
        list.add(entity.getDbT3030_kagoKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3030_kagoKaisu().intValue()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get入所list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3029_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3029_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3029_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3029_shokisaiHokenshaNo() == null ? null : entity.getDbT3029_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3029_seiriNo()));
        list.add(trimRString(entity.getDbT3029_recodeJunjiNo()));
        list.add(trimRString(entity.getDbT3029_serviceSyuruiCode() == null ? null : entity.getDbT3029_serviceSyuruiCode().getColumnValue()));
        list.add(trimRString(entity.getDbT3029_serviceKomokuCode() == null ? null : entity.getDbT3029_serviceKomokuCode().getColumnValue()));
        list.add(entity.getDbT3029_hiyoTanka() == null ? RString.EMPTY : new RString(entity.getDbT3029_hiyoTanka().toString()));
        list.add(entity.getDbT3029_futanGendogaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_hiyoTanka().toString()));
        list.add(entity.getDbT3029_nissu() == null ? RString.EMPTY : new RString(entity.getDbT3029_nissu().intValue()));
        list.add(entity.getDbT3029_kohi1Nissu() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi1Nissu().intValue()));
        list.add(entity.getDbT3029_kohi2Nissu() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi2Nissu().intValue()));
        list.add(entity.getDbT3029_kohi3Nissu() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi3Nissu().intValue()));
        list.add(entity.getDbT3029_hiyogaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_hiyogaku().toString()));
        list = get入所list(entity, list);
        list = get入所list1(entity, list);
        list = get入所list2(entity, list);
        return list;
    }

    private List<RString> get入所list(DbWT1111KyufuJissekiTempTempEntity entity, List<RString> list) {
        list.add(entity.getDbT3029_hokenbunSeikyugaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_hokenbunSeikyugaku().toString()));
        list.add(entity.getDbT3029_kohi1Futangaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi1Futangaku().toString()));
        list.add(entity.getDbT3029_kohi2Futangaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi2Futangaku().toString()));
        list.add(entity.getDbT3029_kohi3Futangaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi3Futangaku().toString()));
        list.add(entity.getDbT3029_riyoshaFutangaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_riyoshaFutangaku().toString()));
        list.add(entity.getDbT3029_hiyogakuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3029_hiyogakuTotal().toString()));
        list.add(entity.getDbT3029_hokenbunSeikyugakuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_hokenbunSeikyugakuTotal().toString()));
        list.add(entity.getDbT3029_riyoshaFutangakuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_riyoshaFutangakuTotal().toString()));
        list.add(entity.getDbT3029_kohi1FutangakuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi1FutangakuTotal().toString()));
        list.add(entity.getDbT3029_kohi1Seikyugaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi1Seikyugaku().toString()));
        list.add(entity.getDbT3029_kohi1HonninFutanGetsugaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_kohi1HonninFutanGetsugaku().toString()));
        list.add(entity.getDbT3029_kohi2FutangakuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi2FutangakuTotal().toString()));
        return list;
    }

    private List<RString> get入所list1(DbWT1111KyufuJissekiTempTempEntity entity, List<RString> list) {
        list.add(entity.getDbT3029_kohi2Seikyugaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi2Seikyugaku().toString()));
        list.add(entity.getDbT3029_kohi2HonninFutanGetsugaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_kohi2HonninFutanGetsugaku().toString()));
        list.add(entity.getDbT3029_kohi3FutangakuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi2FutangakuTotal().toString()));
        list.add(entity.getDbT3029_kohi3Seikyugaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_kohi2Seikyugaku().toString()));
        list.add(entity.getDbT3029_kohi3HonninFutanGetsugaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_kohi2HonninFutanGetsugaku().toString()));
        list.add(entity.getDbT3029_atoHiyoTanka() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoHiyoTanka().toString()));
        list.add(entity.getDbT3029_atoNissu() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoNissu().intValue()));
        list.add(entity.getDbT3029_atoKohi1Nissu() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi1Nissu().intValue()));
        list.add(entity.getDbT3029_atoKohi2Nissu() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi2Nissu().intValue()));
        list.add(entity.getDbT3029_atoKohi3Nissu() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi3Nissu().intValue()));
        list.add(entity.getDbT3029_atoHiyogaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoHiyogaku().toString()));
        list.add(entity.getDbT3029_atoHokenbunSeikyugaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_atoHokenbunSeikyugaku().toString()));
        list.add(entity.getDbT3029_atoKohi1Futangaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi1Futangaku().toString()));
        list.add(entity.getDbT3029_atoKohi2Futangaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi2Futangaku().toString()));
        list.add(entity.getDbT3029_atoKohi3Futangaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi3Futangaku().toString()));
        return list;
    }

    private List<RString> get入所list2(DbWT1111KyufuJissekiTempTempEntity entity, List<RString> list) {
        list.add(entity.getDbT3029_atoRiyoshaFutangaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoRiyoshaFutangaku().toString()));
        list.add(entity.getDbT3029_atoHiyogakuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoHiyogakuTotal().toString()));
        list.add(entity.getDbT3029_atoHokenbunSeikyugakuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_atoHokenbunSeikyugakuTotal().toString()));
        list.add(entity.getDbT3029_atoRiyoshaFutangakuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_atoRiyoshaFutangakuTotal().toString()));
        list.add(entity.getDbT3029_atoKohi1FutangakuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi1FutangakuTotal().toString()));
        list.add(entity.getDbT3029_atoKohi1Seikyugaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi1Seikyugaku().toString()));
        list.add(entity.getDbT3029_atoKohi1HonninFutanGetsugaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi1HonninFutanGetsugaku().toString()));
        list.add(entity.getDbT3029_atoKohi2FutangakuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi2FutangakuTotal().toString()));
        list.add(entity.getDbT3029_atoKohi2Seikyugaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi2Seikyugaku().toString()));
        list.add(entity.getDbT3029_atoKohi2HonninFutanGetsugaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi2HonninFutanGetsugaku().toString()));
        list.add(entity.getDbT3029_atoKohi3FutangakuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi3FutangakuTotal().toString()));
        list.add(entity.getDbT3029_atoKohi3Seikyugaku() == null ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi3Seikyugaku().toString()));
        list.add(entity.getDbT3029_atoKohi3HonninFutanGetsugaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3029_atoKohi3HonninFutanGetsugaku().toString()));
        list.add(entity.getDbT3029_saishinsaKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3029_saishinsaKaisu().intValue()));
        list.add(entity.getDbT3029_kagoKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3029_kagoKaisu().intValue()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get集計list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3033_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3033_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3033_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3033_shokisaiHokenshaNo() == null ? null : entity.getDbT3033_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3033_seiriNo()));
        list.add(trimRString(entity.getDbT3033_serviceSyuruiCode() == null ? null : entity.getDbT3033_serviceSyuruiCode().getColumnValue()));
        list.add(entity.getDbT3033_serviceJitsunissu() == null ? RString.EMPTY : new RString(entity.getDbT3033_serviceJitsunissu().intValue()));
        list.add(entity.getDbT3033_planTanisu() == null ? RString.EMPTY : new RString(entity.getDbT3033_planTanisu().toString()));
        list.add(entity.getDbT3033_gendogakuKanriTaishoTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_gendogakuKanriTaishoTanisu().toString()));
        list.add(entity.getDbT3033_gendogakuKanritaishogaiTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_gendogakuKanritaishogaiTanisu().toString()));
        list.add(entity.getDbT3033_tankiNyushoPlanNissu() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_tankiNyushoPlanNissu().intValue()));
        list.add(entity.getDbT3033_tankiNyushoJitsunissu() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_tankiNyushoJitsunissu().intValue()));
        list.add(entity.getDbT3033_hokenTanisuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3033_hokenTanisuTotal().toString()));
        list = get集計list(entity, list);
        list = get集計list1(entity, list);
        list = get集計list2(entity, list);
        return list;
    }

    private List<RString> get集計list(DbWT1111KyufuJissekiTempTempEntity entity, List<RString> list) {
        list.add(entity.getDbT3033_hokenTanisuTani() == null
                ? RSTRING_0000 : new RString(entity.getDbT3033_hokenTanisuTani().multiply(INT_100).toString()).padZeroToLeft(INT_4));
        list.add(trimRString(entity.getDbT3033_hokenSeikyugaku() == null ? null : new RString(entity.getDbT3033_hokenSeikyugaku().toString())));
        list.add(entity.getDbT3033_hokenRiyoshaFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_hokenRiyoshaFutangaku().toString()));
        list.add(entity.getDbT3033_kohi1TanisuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3033_kohi1TanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_kohi1Seikyugaku() == null ? null : new RString(entity.getDbT3033_kohi1Seikyugaku().toString())));
        list.add(entity.getDbT3033_kohi1HonninFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_kohi1HonninFutangaku().toString()));
        list.add(entity.getDbT3033_kohi2TanisuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3033_kohi2TanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_kohi2Seikyugaku() == null ? null : new RString(entity.getDbT3033_kohi2Seikyugaku().toString())));
        list.add(entity.getDbT3033_kohi2HonninFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_kohi2HonninFutangaku().toString()));
        list.add(entity.getDbT3033_kohi3TanisuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3033_kohi3TanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_kohi3Seikyugaku() == null ? null : new RString(entity.getDbT3033_kohi3Seikyugaku().toString())));
        return list;
    }

    private List<RString> get集計list1(DbWT1111KyufuJissekiTempTempEntity entity, List<RString> list) {
        list.add(entity.getDbT3033_kohi3HonninFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_kohi3HonninFutangaku().toString()));
        list.add(entity.getDbT3033_hokenDekidakaTanisuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_hokenDekidakaTanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_hokenDekidakaSeikyugaku() == null
                ? null : new RString(entity.getDbT3033_hokenDekidakaSeikyugaku().toString())));
        list.add(entity.getDbT3033_hokenDekidakaIryohiRiyoshaFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_hokenDekidakaIryohiRiyoshaFutangaku().toString()));
        list.add(entity.getDbT3033_kohi1DekidakaTanisuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_kohi1DekidakaTanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_kohi1DekidakaSeikyugaku() == null
                ? null : new RString(entity.getDbT3033_kohi1DekidakaSeikyugaku().toString())));
        list.add(entity.getDbT3033_kohi1DekidakaIryohiRiyoshaFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_kohi1DekidakaIryohiRiyoshaFutangaku().toString()));
        list.add(entity.getDbT3033_kohi2DekidakaTanisuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_kohi2DekidakaTanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_kohi2DekidakaSeikyugaku() == null
                ? null : new RString(entity.getDbT3033_kohi2DekidakaSeikyugaku().toString())));
        list.add(entity.getDbT3033_kohi2DekidakaIryohiRiyoshaFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_kohi2DekidakaIryohiRiyoshaFutangaku().toString()));
        list.add(entity.getDbT3033_kohi3DekidakaTanisuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_kohi3DekidakaTanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_kohi3DekidakaSeikyugaku() == null
                ? null : new RString(entity.getDbT3033_kohi3DekidakaSeikyugaku().toString())));
        list.add(entity.getDbT3033_kohi3DekidakaIryohiRiyoshaFutangaku() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_kohi3DekidakaIryohiRiyoshaFutangaku().toString()));
        list.add(entity.getDbT3033_atoTankiNyushoJitsunissu() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_atoTankiNyushoJitsunissu().intValue()));
        list.add(entity.getDbT3033_atoHokenTanisuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3033_atoHokenTanisuTotal().toString()));
        return list;
    }

    private List<RString> get集計list2(DbWT1111KyufuJissekiTempTempEntity entity, List<RString> list) {
        list.add(trimRString(entity.getDbT3033_atoHokenSeikyugaku() == null
                ? null : new RString(entity.getDbT3033_atoHokenSeikyugaku().toString())));
        list.add(entity.getDbT3033_atoKohi1TanisuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3033_atoKohi1TanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_atoKohi1Seikyugaku() == null
                ? null : new RString(entity.getDbT3033_atoKohi1Seikyugaku().toString())));
        list.add(entity.getDbT3033_atoKohi2TanisuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3033_atoKohi2TanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_atoKohi2Seikyugaku() == null
                ? null : new RString(entity.getDbT3033_atoKohi2Seikyugaku().toString())));
        list.add(entity.getDbT3033_atoKohi3TanisuTotal() == null ? RString.EMPTY : new RString(entity.getDbT3033_atoKohi3TanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_atoKohi3Seikyugaku() == null
                ? null : new RString(entity.getDbT3033_atoKohi3Seikyugaku().toString())));
        list.add(entity.getDbT3033_atoHokenDekidakaTanisuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_atoHokenDekidakaTanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_atoHokenDekidakaSeikyugaku() == null
                ? null : new RString(entity.getDbT3033_atoHokenDekidakaSeikyugaku().toString())));
        list.add(entity.getDbT3033_atoKohi1DekidakaTanisuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_atoKohi1DekidakaTanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_atoKohi1DekidakaSeikyugaku() == null
                ? null : new RString(entity.getDbT3033_atoKohi1DekidakaSeikyugaku().toString())));
        list.add(entity.getDbT3033_atoKohi2DekidakaTanisuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_atoKohi2DekidakaTanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_atoKohi2DekidakaSeikyugaku() == null
                ? null : new RString(entity.getDbT3033_atoKohi2DekidakaSeikyugaku().toString())));
        list.add(entity.getDbT3033_atoKohi3DekidakaTanisuTotal() == null
                ? RString.EMPTY : new RString(entity.getDbT3033_atoKohi3DekidakaTanisuTotal().toString()));
        list.add(trimRString(entity.getDbT3033_atoKohi3DekidakaSeikyugaku() == null
                ? null : new RString(entity.getDbT3033_atoKohi3DekidakaSeikyugaku().toString())));
        list.add(entity.getDbT3033_saishinsaKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3033_saishinsaKaisu().intValue()));
        list.add(entity.getDbT3033_kagoKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3033_kagoKaisu().intValue()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get住宅list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3027_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3027_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3027_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3027_shokisaiHokenshaNo() == null ? null : entity.getDbT3027_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3027_seiriNo()));
        list.add(trimRString(entity.getDbT3027_serviceCode() == null ? null : entity.getDbT3027_serviceCode().getColumnValue()));
        list.add(trimRString(entity.getDbT3027_jutakuKaishuchakkoYMD() == null
                ? null : new RString(entity.getDbT3027_jutakuKaishuchakkoYMD().toString())));
        list.add(囲み文字(trimRString(entity.getDbT3027_jutakuKaishuJigyoshaName())));
        list.add(囲み文字(trimRString(entity.getDbT3027_juutakukaishuJyutakuAdress())));
        list.add(entity.getDbT3027_kaishuKingaku() == null ? RString.EMPTY : new RString(entity.getDbT3027_kaishuKingaku().toString()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get福祉list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3026_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3026_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3026_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3026_shokisaiHokenshaNo() == null ? null : entity.getDbT3026_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3026_seiriNo()));
        list.add(trimRString(entity.getDbT3026_serviceCode() == null ? null : entity.getDbT3026_serviceCode().getColumnValue()));
        list.add(trimRString(entity.getDbT3026_fukushiyoguHanbaiYMD() == null
                ? null : new RString(entity.getDbT3026_fukushiyoguHanbaiYMD().toString())));
        list.add(囲み文字(trimRString(entity.getDbT3026_fukushiyoguShohinName())));
        list.add(trimRString(entity.getDbT3026_fukushiyoguSyumokuCode()));
        list.add(囲み文字(trimRString(entity.getDbT3026_fukushiyoguSeizoJigyoshaName())));
        list.add(囲み文字(trimRString(entity.getDbT3026_fukushiyoguHanbaiJigyoshaName())));
        list.add(entity.getDbT3026_hanbaiKingaku() == null ? RString.EMPTY : new RString(entity.getDbT3026_hanbaiKingaku().toString()));
        list.add(囲み文字(trimRString(entity.getDbT3026_tekiyo())));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get居宅list(DbWT1111KyufuJissekiTempTempEntity entity) {
        KokanShikibetsuNo 交換情報識別番号 = entity.getDbT3025_kokanJohoShikibetsuNo();
        boolean 条件2 = 交換情報識別番号 == null
                ? false : (HokenshaKyufujissekiKokanjohoSikibetsuNo.平成18年4月以降.getコード().compareTo(交換情報識別番号.getColumnValue()) <= INT_0
                && 交換情報識別番号.getColumnValue().compareTo(HokenshaKyufujissekiKokanjohoSikibetsuNo.平成21年4月以降.getコード()) < 0);
        boolean 条件3 = 交換情報識別番号 == null
                ? false : (HokenshaKyufujissekiKokanjohoSikibetsuNo.平成21年4月以降.getコード().compareTo(交換情報識別番号.getColumnValue()) <= INT_0);
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3025_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3025_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3025_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3025_shokisaiHokenshaNo() == null ? null : entity.getDbT3025_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list = get居宅list(entity, 条件2, 条件3, list);
        if (条件3) {
            list.add(entity.getDbT3025_atoKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3025_atoKaisu().intValue()));
            list.add(entity.getDbT3025_atoServiceTanisu() == null ? RString.EMPTY : new RString(entity.getDbT3025_atoServiceTanisu().toString()));
            if (RSTRING_99.equals(entity.getDbT3025_servicePlanhiMeisaiLineNo())) {
                list.add(entity.getDbT3025_atoServiceTanisuTotal() == null
                        ? RString.EMPTY : new RString(entity.getDbT3025_atoServiceTanisuTotal().toString()));
                list.add(entity.getDbT3025_atoSeikyuKingaku() == null
                        ? RString.EMPTY : new RString(entity.getDbT3025_atoSeikyuKingaku().toString()));
            } else {
                list.add(RString.EMPTY);
                list.add(RString.EMPTY);
            }
        } else {
            list.add(entity.getDbT3025_atoSeikyuKingaku() == null ? RString.EMPTY : new RString(entity.getDbT3025_atoSeikyuKingaku().toString()));
        }
        list.add(entity.getDbT3025_saishinsaKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3025_saishinsaKaisu().intValue()));
        if (条件2 || 条件3) {
            list.add(entity.getDbT3025_kagoKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3025_kagoKaisu().intValue()));
        } else {
            list.add(RString.EMPTY);
        }
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get居宅list(DbWT1111KyufuJissekiTempTempEntity entity, boolean 条件2, boolean 条件3, List<RString> list) {
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3025_seiriNo()));
        list.add(trimRString(entity.getDbT3025_shiteiKijunGaitoJigyoshaKubunCode()));
        list.add(entity.getDbT3025_tanisuTanka() == null
                ? RSTRING_0000 : new RString(entity.getDbT3025_tanisuTanka().multiply(INT_100).toString()).padZeroToLeft(INT_4));
        list.add(trimRString(entity.getDbT3025_kyotakuServiceSakuseiIraiYMD() == null
                ? null : new RString(entity.getDbT3025_kyotakuServiceSakuseiIraiYMD().toString())));
        if (条件3) {
            list.add(trimRString(entity.getDbT3025_servicePlanhiMeisaiLineNo()));
        }
        list.add(entity.getDbT3025_serviceCode() == null ? RString.EMPTY : entity.getDbT3025_serviceCode().getColumnValue());
        list.add(entity.getDbT3025_tanisu() == null ? RString.EMPTY : new RString(entity.getDbT3025_tanisu().toString()));
        if (条件3) {
            list.add(entity.getDbT3025_kaisu() == null ? RString.EMPTY : new RString(entity.getDbT3025_kaisu().intValue()));
            list.add(entity.getDbT3025_serviceTanisu() == null ? RString.EMPTY : new RString(entity.getDbT3025_serviceTanisu().toString()));
            if (RSTRING_99.equals(entity.getDbT3025_servicePlanhiMeisaiLineNo())) {
                list.add(entity.getDbT3025_serviceTanisuTotal() == null
                        ? RString.EMPTY : new RString(entity.getDbT3025_serviceTanisuTotal().toString()));
                list.add(entity.getDbT3025_seikyuKingaku() == null ? RString.EMPTY : new RString(entity.getDbT3025_seikyuKingaku().toString()));
            } else {
                list.add(RString.EMPTY);
                list.add(RString.EMPTY);
            }
        } else {
            list.add(entity.getDbT3025_seikyuKingaku() == null ? RString.EMPTY : new RString(entity.getDbT3025_seikyuKingaku().toString()));
        }
        if (条件2 || 条件3) {
            list.add(trimRString(entity.getDbT3025_tantouKaigoShienSemmoninNo()));
            list.add(囲み文字(trimRString(entity.getDbT3025_tekiyo())));
        }
        list.add(entity.getDbT3025_atoTanisu() == null ? RString.EMPTY : new RString(entity.getDbT3025_atoTanisu().toString()));
        return list;
    }

    private List<RString> get食事list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3022_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3022_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3022_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3022_shokisaiHokenshaNo() == null ? null : entity.getDbT3022_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3022_seiriNo()));
        list.add(new RString(entity.getDbT3022_kihonTeikyoNissu()));
        list.add(new RString(entity.getDbT3022_kihonTeikyoTanka()));
        list.add(new RString(entity.getDbT3022_kihonTeikyoKingaku()));
        list.add(new RString(entity.getDbT3022_tokubestuTeikyoNissu()));
        list.add(new RString(entity.getDbT3022_tokubestuTeikyoTanka()));
        list.add(new RString(entity.getDbT3022_tokubestuTeikyoKingaku()));
        list.add(new RString(entity.getDbT3022_syokujiTeikyoNissu()));
        list.add(new RString(entity.getDbT3022_kohi1SyokujiTeikyoNissu()));
        list.add(new RString(entity.getDbT3022_kohi2SyokujiTeikyoNissu()));
        list.add(new RString(entity.getDbT3022_kohi3SyokujiTeikyoNissu()));
        list.add(new RString(entity.getDbT3022_syokujiTeikyohiTotal()));
        list.add(new RString(entity.getDbT3022_getsugakuHyojunFutanGaku()));
        list.add(new RString(entity.getDbT3022_syokujiTeikyohiSeikyugaku()));
        list.add(new RString(entity.getDbT3022_kohi1SyokujiTeikyohiSeikyugaku()));
        list.add(new RString(entity.getDbT3022_kohi2SyokujiTeikyohiSeikyugaku()));
        list.add(new RString(entity.getDbT3022_kohi3SyokujiTeikyohiSeikyugaku()));
        list.add(new RString(entity.getDbT3022_nichigakuHyojunFutanGaku()));
        list.add(new RString(entity.getDbT3022_atoKihonTeikyoTanka()));
        list.add(new RString(entity.getDbT3022_atoTokubestuTeikyoTanka()));
        list.add(new RString(entity.getDbT3022_atoSyokujiTeikyohiSeikyugaku()));
        list.add(new RString(entity.getDbT3022_saishinsaKaisu()));
        list.add(new RString(entity.getDbT3022_kagoKaisu()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get特別療養list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3021_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3021_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3021_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3021_shokisaiHokenshaNo() == null ? null : entity.getDbT3021_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3021_seiriNo()));
        list.add(trimRString(entity.getDbT3021_recodeJunjiNo()));
        list.add(囲み文字(trimRString(entity.getDbT3021_shobyoName())));
        list.add(trimRString(entity.getDbT3021_shikibetsuNo()));
        list.add(new RString(entity.getDbT3021_tanisu()));
        list.add(new RString(entity.getDbT3021_hokenKaisu()));
        list.add(new RString(entity.getDbT3021_hokenServiceTanisu()));
        list.add(new RString(entity.getDbT3021_hokenTotalTanisu()));
        list.add(new RString(entity.getDbT3021_kohi1Kaisu()));
        list.add(new RString(entity.getDbT3021_kohi1ServiceTanisu()));
        list.add(new RString(entity.getDbT3021_kohi1TotalTanisu()));
        list.add(new RString(entity.getDbT3021_kohi2Kaisu()));
        list.add(new RString(entity.getDbT3021_kohi2ServiceTanisu()));
        list.add(new RString(entity.getDbT3021_kohi2TotalTanisu()));
        list.add(new RString(entity.getDbT3021_kohi3Kaisu()));
        list.add(new RString(entity.getDbT3021_kohi3ServiceTanisu()));
        list.add(new RString(entity.getDbT3021_kohi3TotalTanisu()));
        list.add(囲み文字(trimRString(entity.getDbT3021_tekiyo())));
        list.add(new RString(entity.getDbT3021_atoTanisu()));
        list.add(new RString(entity.getDbT3021_atoHokenKaisu()));
        list.add(new RString(entity.getDbT3021_atoHokenServiceTanisu()));
        list.add(new RString(entity.getDbT3021_atoHokenTotalTanisu()));
        list.add(new RString(entity.getDbT3021_atoKohi1Kaisu()));
        list.add(new RString(entity.getDbT3021_atoKohi1ServiceTanisu()));
        list.add(new RString(entity.getDbT3021_atoKohi1TotalTanisu()));
        list.add(new RString(entity.getDbT3021_atoKohi2Kaisu()));
        list.add(new RString(entity.getDbT3021_atoKohi2ServiceTanisu()));
        list.add(new RString(entity.getDbT3021_atoKohi2TotalTanisu()));
        list.add(new RString(entity.getDbT3021_atoKohi3Kaisu()));
        list.add(new RString(entity.getDbT3021_atoKohi3ServiceTanisu()));
        list.add(new RString(entity.getDbT3021_atoKohi3TotalTanisu()));
        list.add(new RString(entity.getDbT3021_saishinsaKaisu()));
        list.add(new RString(entity.getDbT3021_kagoKaisu()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get特定診療list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3020_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3020_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3020_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3020_shokisaiHokenshaNo() == null ? null : entity.getDbT3020_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3020_seiriNo()));
        list.add(trimRString(entity.getDbT3020_recodeJunjiNo()));
        list.add(囲み文字(trimRString(entity.getDbT3020_shobyoName())));
        list.add(new RString(entity.getDbT3020_hokenShidoKanriryo()));
        list.add(new RString(entity.getDbT3020_hokenTanjunXsen()));
        list.add(new RString(entity.getDbT3020_hokenRehabilitation()));
        list.add(new RString(entity.getDbT3020_hokenSeishinkaSemmonRyoho()));
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(new RString(entity.getDbT3020_hokenTotalTanisu()));
        list.add(new RString(entity.getDbT3020_kohi1ShidoKanriryo()));
        list.add(new RString(entity.getDbT3020_kohi1TanjunXsen()));
        list.add(new RString(entity.getDbT3020_kohi1Rehabilitation()));
        list.add(new RString(entity.getDbT3020_kohi1SeishinkaSemmonRyoho()));
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(new RString(entity.getDbT3020_kohi1TotalTanisu()));
        list.add(new RString(entity.getDbT3020_kohi2ShidoKanriryo()));
        list.add(new RString(entity.getDbT3020_kohi2TanjunXsen()));
        list.add(new RString(entity.getDbT3020_kohi2Rehabilitation()));
        list.add(new RString(entity.getDbT3020_kohi2SeishinkaSemmonRyoho()));
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(new RString(entity.getDbT3020_kohi2TotalTanisu()));
        list.add(new RString(entity.getDbT3020_kohi3ShidoKanriryo()));
        list.add(new RString(entity.getDbT3020_kohi3TanjunXsen()));
        list.add(new RString(entity.getDbT3020_kohi3Rehabilitation()));
        list.add(new RString(entity.getDbT3020_kohi3SeishinkaSemmonRyoho()));
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(new RString(entity.getDbT3020_kohi3TotalTanisu()));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo1())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo2())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo3())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo4())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo5())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo6())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo7())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo8())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo9())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo10())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo11())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo12())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo13())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo14())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo15())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo16())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo17())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo18())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo19())));
        list.add(囲み文字(trimRString(entity.getDbT3020_tekiyo20())));
        list.add(new RString(entity.getDbT3020_atoHokenShidoKanriryo()));
        list.add(new RString(entity.getDbT3020_atoHokenTanjunXsen()));
        list.add(new RString(entity.getDbT3020_atoHokenRehabilitation()));
        list.add(new RString(entity.getDbT3020_atoHokenSeishinkaSemmonRyoho()));
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(new RString(entity.getDbT3020_atoKohi1ShidoKanriryo()));
        list.add(new RString(entity.getDbT3020_atoKohi1TanjunXsen()));
        list.add(new RString(entity.getDbT3020_atoKohi1Rehabilitation()));
        list.add(new RString(entity.getDbT3020_atoKohi1SeishinkaSemmonRyoho()));
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(new RString(entity.getDbT3020_atoKohi2ShidoKanriryo()));
        list.add(new RString(entity.getDbT3020_atoKohi2TanjunXsen()));
        list.add(new RString(entity.getDbT3020_atoKohi2Rehabilitation()));
        list.add(new RString(entity.getDbT3020_atoKohi2SeishinkaSemmonRyoho()));
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(new RString(entity.getDbT3020_atoKohi3ShidoKanriryo()));
        list.add(new RString(entity.getDbT3020_atoKohi3TanjunXsen()));
        list.add(new RString(entity.getDbT3020_atoKohi3Rehabilitation()));
        list.add(new RString(entity.getDbT3020_atoKohi3SeishinkaSemmonRyoho()));
        list.add(RString.EMPTY);
        list.add(RString.EMPTY);
        list.add(new RString(entity.getDbT3020_saishinsaKaisu()));
        list.add(new RString(entity.getDbT3020_kagoKaisu()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get所定list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3032_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3032_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3032_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3032_shokisaiHokenshaNo() == null ? null : entity.getDbT3032_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3032_seiriNo()));
        list.add(trimRString(entity.getDbT3032_recodeJunjiNo()));
        list.add(囲み文字(trimRString(entity.getDbT3032_kinkyuShobyoName1())));
        list.add(囲み文字(trimRString(entity.getDbT3032_kinkyuShobyoName2())));
        list.add(囲み文字(trimRString(entity.getDbT3032_kinkyuShobyoName3())));
        list.add(trimRString(entity.getDbT3032_kinkyuChiryoKaishiYMD1() == null
                ? null : new RString(entity.getDbT3032_kinkyuChiryoKaishiYMD1().toString())));
        list.add(trimRString(entity.getDbT3032_kinkyuChiryoKaishiYMD2() == null
                ? null : new RString(entity.getDbT3032_kinkyuChiryoKaishiYMD2().toString())));
        list.add(trimRString(entity.getDbT3032_kinkyuChiryoKaishiYMD3() == null
                ? null : new RString(entity.getDbT3032_kinkyuChiryoKaishiYMD3().toString())));
        list.add(new RString(entity.getDbT3032_oshinNissu()));
        list.add(囲み文字(trimRString(entity.getDbT3032_oshinIryoKikanName())));
        list.add(new RString(entity.getDbT3032_tsuinNissu()));
        list.add(囲み文字(trimRString(entity.getDbT3032_tsuinIryoKikanName())));
        list.add(new RString(entity.getDbT3032_kinkyuChiryoKanriTanisu()));
        list.add(new RString(entity.getDbT3032_kinkyuChiryoKanriNissu()));
        list.add(new RString(entity.getDbT3032_kinkyuChiryoKanriSubTotal()));
        list.add(new RString(entity.getDbT3032_rehabilitationTensu()));
        list.add(new RString(entity.getDbT3032_shochiTensu()));
        list.add(new RString(entity.getDbT3032_shujutsuTensu()));
        list.add(new RString(entity.getDbT3032_masuiTensu()));
        list.add(new RString(entity.getDbT3032_hoshasenChiryoTensu()));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo1())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo2())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo3())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo4())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo5())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo6())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo7())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo8())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo9())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo10())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo11())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo12())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo13())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo14())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo15())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo16())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo17())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo18())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo19())));
        list.add(囲み文字(trimRString(entity.getDbT3032_tekiyo20())));
        list.add(new RString(entity.getDbT3032_kinkyuShisetsuRyoyohiTotalTensu()));
        list.add(囲み文字(trimRString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiShobyoName1())));
        list.add(囲み文字(trimRString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiShobyoName2())));
        list.add(囲み文字(trimRString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiShobyoName3())));
        list.add(trimRString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiKaishiYMD1() == null
                ? null : new RString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiKaishiYMD1().toString())));
        list.add(trimRString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiKaishiYMD2() == null
                ? null : new RString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiKaishiYMD2().toString())));
        list.add(trimRString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiKaishiYMD3() == null
                ? null : new RString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiKaishiYMD3().toString())));
        list.add(new RString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiTanisu()));
        list.add(new RString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiNissu()));
        list.add(new RString(entity.getDbT3032_shoteiShikkanShisetsuRyoyohiSubTotal()));
        list.add(new RString(entity.getDbT3032_atoOshinNissu()));
        list.add(new RString(entity.getDbT3032_atoTsuinNissu()));
        list.add(new RString(entity.getDbT3032_atoKinkyuChiryoKanriTanisu()));
        list.add(new RString(entity.getDbT3032_atoKinkyuChiryoKanriNissu()));
        list.add(new RString(entity.getDbT3032_atoRehabilitationTensu()));
        list.add(new RString(entity.getDbT3032_atoShochiTensu()));
        list.add(new RString(entity.getDbT3032_atoShujutsuTensu()));
        list.add(new RString(entity.getDbT3032_atoMasuiTensu()));
        list.add(new RString(entity.getDbT3032_atoHoshasenChiryoTensu()));
        list.add(new RString(entity.getDbT3032_atoShoteiShikkanShisetsuRyoyoHiTanisu()));
        list.add(new RString(entity.getDbT3032_atoShoteiShikkanShisetsuRyoyoHiNissu()));
        list.add(new RString(entity.getDbT3032_saishinsaKaisu()));
        list.add(new RString(entity.getDbT3032_kagoKaisu()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get施設list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3019_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3019_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3019_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3019_shokisaiHokenshaNo() == null ? null : entity.getDbT3019_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3019_seiriNo()));
        list.add(trimRString(entity.getDbT3019_recodeJunjiNo()));
        list.add(囲み文字(trimRString(entity.getDbT3019_kinkyuShobyoName1())));
        list.add(囲み文字(trimRString(entity.getDbT3019_kinkyuShobyoName2())));
        list.add(囲み文字(trimRString(entity.getDbT3019_kinkyuShobyoName3())));
        list.add(trimRString(entity.getDbT3019_kinkyuChiryoKaishiYMD1() == null
                ? null : new RString(entity.getDbT3019_kinkyuChiryoKaishiYMD1().toString())));
        list.add(trimRString(entity.getDbT3019_kinkyuChiryoKaishiYMD2() == null
                ? null : new RString(entity.getDbT3019_kinkyuChiryoKaishiYMD2().toString())));
        list.add(trimRString(entity.getDbT3019_kinkyuChiryoKaishiYMD3() == null
                ? null : new RString(entity.getDbT3019_kinkyuChiryoKaishiYMD3().toString())));
        list.add(new RString(entity.getDbT3019_oshinNissu()));
        list.add(囲み文字(trimRString(entity.getDbT3019_oshinIryoKikanName())));
        list.add(new RString(entity.getDbT3019_tsuinNissu()));
        list.add(囲み文字(trimRString(entity.getDbT3019_tsuinIryoKikanName())));
        list.add(new RString(entity.getDbT3019_kinkyuChiryoKanriTanisu()));
        list.add(new RString(entity.getDbT3019_kinkyuChiryoKanriNissu()));
        list.add(new RString(entity.getDbT3019_kinkyuChiryoKanriSubTotal()));
        list.add(new RString(entity.getDbT3019_rehabilitationTensu()));
        list.add(new RString(entity.getDbT3019_shochiTensu()));
        list.add(new RString(entity.getDbT3019_shujutsuTensu()));
        list.add(new RString(entity.getDbT3019_masuiTensu()));
        list.add(new RString(entity.getDbT3019_hoshasenChiryoTensu()));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo1())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo2())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo3())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo4())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo5())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo6())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo7())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo8())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo9())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo10())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo11())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo12())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo13())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo14())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo15())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo16())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo17())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo18())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo19())));
        list.add(囲み文字(trimRString(entity.getDbT3019_tekiyo20())));
        list.add(new RString(entity.getDbT3019_kinkyuShisetsuRyoyoHiTotalTensu()));
        list.add(new RString(entity.getDbT3019_atoOshinNissu()));
        list.add(new RString(entity.getDbT3019_atoTsuinNissu()));
        list.add(new RString(entity.getDbT3019_atoKinkyuChiryoKanriTanisu()));
        list.add(new RString(entity.getDbT3019_atoKinkyuChiryoKanriNissu()));
        list.add(new RString(entity.getDbT3019_atoRehabilitationTensu()));
        list.add(new RString(entity.getDbT3019_atoShochiTensu()));
        list.add(new RString(entity.getDbT3019_atoShujutsuTensu()));
        list.add(new RString(entity.getDbT3019_atoMasuiTensu()));
        list.add(new RString(entity.getDbT3019_atoHoshasenChiryoTensu()));
        list.add(new RString(entity.getDbT3019_saishinsaKaisu()));
        list.add(new RString(entity.getDbT3019_kagoKaisu()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get明細list(DbWT1111KyufuJissekiTempTempEntity entity) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbT3018_kokanJohoShikibetsuNo() == null ? null : entity.getDbT3018_kokanJohoShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3018_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbT3018_shokisaiHokenshaNo() == null ? null : entity.getDbT3018_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbT3018_seiriNo()));
        list.add(trimRString(entity.getDbT3018_serviceShuruiCode() == null ? null : entity.getDbT3018_serviceShuruiCode().getColumnValue()));
        list.add(trimRString(entity.getDbT3018_serviceKomokuCode() == null ? null : entity.getDbT3018_serviceKomokuCode().getColumnValue()));
        list.add(entity.getDbT3018_tanisu() == null ? RString.EMPTY : new RString(entity.getDbT3018_tanisu().toString()));
        list.add(entity.getDbT3018_nissuKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3018_nissuKaisu().intValue()));
        list.add(entity.getDbT3018_kohi1TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_kohi1TaishoNissuKaisu().intValue()));
        list.add(entity.getDbT3018_kohi2TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_kohi2TaishoNissuKaisu().intValue()));
        list.add(entity.getDbT3018_kohi3TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_kohi3TaishoNissuKaisu().intValue()));
        list.add(entity.getDbT3018_serviceTanisu() == null ? RString.EMPTY : new RString(entity.getDbT3018_serviceTanisu().toString()));
        list = get明細list(entity, list);
        list.add(entity.getDbT3018_saishinsaKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3018_saishinsaKaisu().intValue()));
        list.add(entity.getDbT3018_kagoKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3018_kagoKaisu().intValue()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get明細list(DbWT1111KyufuJissekiTempTempEntity entity, List<RString> list) {
        list.add(entity.getDbT3018_kohi1TaishoServiceTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_kohi1TaishoServiceTanisu().toString()));
        list.add(entity.getDbT3018_kohi2TaishoServiceTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_kohi2TaishoServiceTanisu().toString()));
        list.add(entity.getDbT3018_kohi3TaishoServiceTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_kohi3TaishoServiceTanisu().toString()));
        list.add(囲み文字(trimRString(entity.getDbT3018_tekiyo())));
        list.add(entity.getDbT3018_atoTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_atoTanisu().toString()));
        list.add(entity.getDbT3018_atoNissuKaisu() == null ? RString.EMPTY : new RString(entity.getDbT3018_atoNissuKaisu().intValue()));
        list.add(entity.getDbT3018_atoKohi1TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_atoKohi1TaishoNissuKaisu().intValue()));
        list.add(entity.getDbT3018_atoKohi2TaishoNissukaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_atoKohi2TaishoNissukaisu().intValue()));
        list.add(entity.getDbT3018_atoKohi3TaishoNissuKaisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_atoKohi3TaishoNissuKaisu().intValue()));
        list.add(entity.getDbT3018_atoServiceTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_atoServiceTanisu().toString()));
        list.add(entity.getDbT3018_atoKohi1TaishoServiceTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_atoKohi1TaishoServiceTanisu().toString()));
        list.add(entity.getDbT3018_atoKohi2TaishoServiceTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_atoKohi2TaishoServiceTanisu().toString()));
        list.add(entity.getDbT3018_atoKohi3TaishoServiceTanisu() == null
                ? RString.EMPTY : new RString(entity.getDbT3018_atoKohi3TaishoServiceTanisu().toString()));
        return list;
    }

    private List<RString> getコントロールlist() {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.コントロールレコード.getコード());
        list.add(new RString(出力件数));
        list.add(RSTRING_0);
        list.add(new RString(レコード件数));
        list.add(ConfigKeysKokuhorenSofu.給付実績情報.getコード());
        list.add(RSTRING_0);
        list.add(processParameter.get保険者番号().getColumnValue());
        list.add(RSTRING_0);
        list.add(RSTRING_0);
        RString 媒体区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_給付実績Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        list.add(媒体区分);
        list.add(processParameter.getShoriYM().toDateString());
        list.add(RSTRING_0);
        return list;
    }

    private List<RString> get基本list(DbWT1111KyufuJissekiTempTempEntity entity, int no) {
        List<RString> list = new ArrayList<>();
        list.add(RecordShubetsu.データレコード.getコード());
        list.add(new RString(出力件数));
        list.add(trimRString(entity.getDbWT1131_kokanShikibetsuNo() == null ? null : entity.getDbWT1131_kokanShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getInputShikibetsuNo() == null ? null : entity.getInputShikibetsuNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_recodeShubetsuCode()));
        list.add(trimRString(entity.getDbWT1131_kyufuSakuseiKubunCode()));
        list.add(trimRString(entity.getDbWT1131_shokisaiHokenshaNo() == null ? null : entity.getDbWT1131_shokisaiHokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_sofuHihokenshaNo() == null ? null : entity.getDbWT1131_sofuHihokenshaNo().getColumnValue()));
        list.add(trimRString(entity.getServiceTeikyoYM() == null ? null : entity.getServiceTeikyoYM().toDateString()));
        list.add(trimRString(entity.getDbWT1131_kyufuJissekiKubunCode()));
        list.add(trimRString(entity.getJigyoshoNo() == null ? null : entity.getJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_seiriNo()));
        list.add(trimRString(entity.getDbWT1131_kohi1FutanshaNo()));
        list.add(trimRString(entity.getDbWT1131_kohi1JukyushaNo()));
        list.add(trimRString(entity.getDbWT1131_kohi2FutanshaNo()));
        list.add(trimRString(entity.getDbWT1131_kohi2JukyushaNo()));
        list.add(trimRString(entity.getDbWT1131_kohi3FutanshaNo()));
        list.add(trimRString(entity.getDbWT1131_kohi3JukyushaNo()));
        list.add(trimRString(entity.getDbWT1131_umareYMD() == null ? null : new RString(entity.getDbWT1131_umareYMD().toString())));
        list.add(trimRString(entity.getDbWT1131_seibetsuCode()));
        list.add(trimRString(entity.getDbWT1131_yoKaigoJotaiKubunCode()));
        list.add(trimRString(entity.getDbWT1131_kyuSochiNyushoshaTokureiCode()));
        list.add(trimRString(entity.getDbWT1131_ninteiYukoKaishiYMD() == null
                ? null : new RString(entity.getDbWT1131_ninteiYukoKaishiYMD().toString())));
        list.add(trimRString(entity.getDbWT1131_ninteiYukoShuryoYMD() == null
                ? null : new RString(entity.getDbWT1131_ninteiYukoShuryoYMD().toString())));
        list.add(trimRString(entity.getDbWT1131_rojinHokenShichosonNo()));
        list.add(trimRString(entity.getDbWT1131_rojinhokenJukyushaNo()));
        if (INT_2 == no) {
            list.add(trimRString(entity.getDbWT1131_kokiHokenshaNo()));
            list.add(trimRString(entity.getDbWT1131_kokiHiHokenshaNo()));
            list.add(trimRString(entity.getDbWT1131_kokuhoHokenshaNo()));
            list.add(trimRString(entity.getDbWT1131_kokuhoHiHokenshashoNo()));
            list.add(trimRString(entity.getDbWT1131_kokuhoKojinNo()));
        }
        list.add(trimRString(entity.getDbWT1131_kyotakuServiceSakuseiKubunCode()));
        list.add(trimRString(entity.getDbWT1131_kyotakuKaigoShienJigyoshoNo() == null
                ? null : entity.getDbWT1131_kyotakuKaigoShienJigyoshoNo().getColumnValue()));
        list.add(trimRString(entity.getDbWT1131_kaishiYMD() == null ? null : new RString(entity.getDbWT1131_kaishiYMD().toString())));
        list.add(trimRString(entity.getDbWT1131_chushiYMD() == null ? null : new RString(entity.getDbWT1131_chushiYMD().toString())));
        list.add(trimRString(entity.getDbWT1131_chushiRiyuNyushomaeJyokyoCode()));
        list.add(new RString(entity.getDbWT1131_nyushoJitsunissu()));
        list.add(new RString(entity.getDbWT1131_gaihakuNissu()));
        list.add(trimRString(entity.getDbWT1131_taishogoJotaiCode()));
        list = get基本list(entity, list);
        list.add(new RString(entity.getDbWT1131_maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi1ServiceTanisu()));
        list.add(new RString(entity.getDbWT1131_maeKohi1Seikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi1RiyoshaFutangaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi1KinkyuShisetsuRyoyoSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi1TokuteiShinryohiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi2ServiceTanisu()));
        list.add(new RString(entity.getDbWT1131_maeKohi2Seikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi2RiyoshaFutangaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi2KinkyuShisetsuRyoyoSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi2TokuteiShinryohiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi3ServiceTanisu()));
        list.add(new RString(entity.getDbWT1131_maeKohi3Seikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi3RiyoshaFutangaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi3KinkyuShisetsuRyoyoSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi3TokuteiShinryohiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoHokenServiceTanisu()));
        list.add(entity.getDbWT1131_atoHokenSeikyugaku() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_atoHokenSeikyugaku().toString()));
        list.add(new RString(entity.getDbWT1131_atoHokenRiyoshaFutangaku()));
        list.add(entity.getDbWT1131_atoHokenKinkyuShisetsuRyoyoSeikyugaku() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_atoHokenKinkyuShisetsuRyoyoSeikyugaku().toString()));
        list.add(entity.getDbWT1131_atoHokenTokuteiShinryohiSeikyugaku() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_atoHokenTokuteiShinryohiSeikyugaku().toString()));
        list.add(new RString(entity.getDbWT1131_atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi1ServiceTanisu()));
        list.add(new RString(entity.getDbWT1131_atoKohi1Seikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi1RiyoshaFutangaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi1KinkyuShisetsuRyoyoSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi1TokuteiShinryohiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi2ServiceTanisu()));
        list.add(new RString(entity.getDbWT1131_atoKohi2Seikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi2RiyoshaFutangaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi2KinkyuShisetsuRyoyoSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi2TokuteiShinryohiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi3ServiceTanisu()));
        list.add(new RString(entity.getDbWT1131_atoKohi3Seikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi3RiyoshaFutangaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi3KinkyuShisetsuRyoyoSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi3TokuteiShinryohiSeikyugaku()));
        list.add(new RString(entity.getDbWT1131_atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku()));
        list.add(trimRString(entity.getDbWT1131_keikaiKubunCode()));
        list.add(processParameter.getShoriYM().toDateString());
        return list;
    }

    private List<RString> get基本list(DbWT1111KyufuJissekiTempTempEntity entity, List<RString> list) {
        list.add(trimRString(entity.getDbWT1131_nyushoYMD() == null ? null : new RString(entity.getDbWT1131_nyushoYMD().toString())));
        list.add(trimRString(entity.getDbWT1131_taishoYMD() == null ? null : new RString(entity.getDbWT1131_taishoYMD().toString())));
        list.add(entity.getDbWT1131_hokenKyufuritsu() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_hokenKyufuritsu().getColumnValue().toString()));
        list.add(entity.getDbWT1131_kohi1Kyufuritsu() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_kohi1Kyufuritsu().getColumnValue().toString()));
        list.add(entity.getDbWT1131_kohi2Kyufuritsu() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_kohi2Kyufuritsu().getColumnValue().toString()));
        list.add(entity.getDbWT1131_kohi3Kyufuritsu() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_kohi3Kyufuritsu().getColumnValue().toString()));
        list.add(new RString(entity.getDbWT1131_maeHokenServiceTanisu()));
        list.add(entity.getDbWT1131_maeHokenSeikyugaku() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_maeHokenSeikyugaku().toString()));
        list.add(new RString(entity.getDbWT1131_maeHokenRiyoshaFutangaku()));
        list.add(entity.getDbWT1131_maeHokenKinkyuShisetsuRyoyoSeikyugaku() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_maeHokenKinkyuShisetsuRyoyoSeikyugaku().toString()));
        list.add(entity.getDbWT1131_maeHokenTokuteiShinryohiSeikyugaku() == null
                ? RString.EMPTY : new RString(entity.getDbWT1131_maeHokenTokuteiShinryohiSeikyugaku().toString()));
        return list;
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private RString 囲み文字(RString str) {
        return 囲みの文字.concat(str).concat(囲みの文字);
    }

    private void 件数カウンター初期化() {
        cnt02 = INT_0;
        cnt03 = INT_0;
        cnt13 = INT_0;
        cnt04 = INT_0;
        cnt05 = INT_0;
        cnt06 = INT_0;
        cnt07 = INT_0;
        cnt08 = INT_0;
        cnt10 = INT_0;
        cnt11 = INT_0;
        cnt12 = INT_0;
        cnt14 = INT_0;
    }
}
