/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130020.TorikomiKokiKoreshaJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.TorikomiKokiKoreshaJyohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

/**
 * 後期高齢者情報のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
public class InsTorikomiKokiKoreshaJyohoProcess extends BatchProcessBase<RString> {

    private boolean 文言設定flag;
    private RString filePath;
    private RString ファイル名称;
    private TorikomiKokiKoreshaJyohoTempProcessParameter processParameter;
    private TorikomiKokiKoreshaJyohoEntity 取込後期高齢者情報Entity;
    private List<LasdecCode> 市町村コードリスト;
    private static final RString LONG_RSTRING_ZERO = new RString("000000000000000");
    private static final int INDEX_492 = 492;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_16 = 16;
    private static final int INDEX_17 = 17;
    private static final int INDEX_25 = 25;
    private static final int INDEX_3 = 3;
    private static final int INDEX_28 = 28;
    private static final int INDEX_39 = 39;
    private static final int INDEX_47 = 47;
    private static final int INDEX_54 = 54;
    private static final int INDEX_55 = 55;
    private static final int INDEX_62 = 62;
    private static final int INDEX_63 = 63;
    private static final int INDEX_40 = 40;
    private static final int INDEX_103 = 103;
    private static final int INDEX_111 = 111;
    private static final int INDEX_128 = 128;
    private static final int INDEX_100 = 100;
    private static final int INDEX_322 = 322;
    private static final int INDEX_328 = 328;
    private static final int INDEX_0 = 0;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_18 = 18;
    private static final int INDEX_22 = 22;
    private static final int INDEX_36 = 36;
    private static final int INDEX_30 = 30;
    private static final int INDEX_38 = 38;
    private static final int INDEX_46 = 46;
    private static final int INDEX_12 = 12;
    private static final int INDEX_4 = 4;
    private static final int INDEX_8 = 8;
    private static final int INDEX_10 = 10;
    private static final int INDEX_15 = 15;
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
    private static final RString 処理枝番_単一時 = new RString("0000");
    private static final RString 処理枝番_広域時 = new RString("00");
    private static final RString TEMP_TABLE = new RString("tempTorikomiKokuhoJyoho");
    private static final RString 正則表現_数値 = new RString("[0-9]*");
    private static final RString 正則表現_半角空白 = new RString("[ ]*");
    private static final RString 正則表現_全角空白 = new RString("/[^uFF00-uFFFF]/g");
    private static final RString 保険者区分_単独保険者 = new RString("1");
    private static final RString 保険者区分_広域保険者 = new RString("2");
    private static final RString アンダーバー = new RString("_");
    private static final RString ファイル名称の拡張子 = new RString(".txt");
    private static final RString エラーコード_01 = new RString("01");
    private static final RString エラーコード_02 = new RString("02");
    private static final RString エラーコード_03 = new RString("03");
    private static final RString エラーコード_04 = new RString("04");
    private static final RString エラーコード_05 = new RString("05");
    private static final RString エラーコード_06 = new RString("06");
    private static final RString エラーコード_07 = new RString("07");
    private static final RString エラーコード_08 = new RString("08");
    private static final RString エラーコード_09 = new RString("09");
    private static final RString エラーコード_10 = new RString("10");
    private static final RString エラーコード_52 = new RString("52");
    private static final RString エラーコード_53 = new RString("53");
    private static final RString エラーコード_54 = new RString("54");
    private static final RString エラーコード_55 = new RString("55");
    private static final RString エラーコード_56 = new RString("56");
    private static final RString エラーコード_57 = new RString("57");
    private static final RString エラーコード_58 = new RString("58");
    private static final RString エラーコード_59 = new RString("59");
    private static final RString エラーコード_60 = new RString("60");
    private static final RString エラーコード_61 = new RString("61");
    private static final RString エラーコード_62 = new RString("62");
    private static final RString エラーコード_63 = new RString("63");
    private static final RString エラーコード_64 = new RString("64");
    private static final RString エラーコード_65 = new RString("65");
    private static final RString エラーコード_66 = new RString("66");
    private static final RString エラーコード_67 = new RString("67");
    private static final RString エラーコード_68 = new RString("68");
    private static final RString エラーコード_69 = new RString("69");
    private static final RString コード文言_フォーマットエラー = new RString("フォーマットエラー");
    private static final RString コード文言_市町村コード = new RString("項目設定エラー：市町村コード");
    private static final RString コード文言_住民コード = new RString("項目設定エラー：住民コード");
    private static final RString コード文言_保険者番号 = new RString("項目設定エラー：保険者番号");
    private static final RString コード文言_履歴番号 = new RString("項目設定エラー：履歴番号");
    private static final RString コード文言_被保険者番号 = new RString("項目設定エラー：被保険者番号");
    private static final RString コード文言_個人番号 = new RString("項目設定エラー：個人番号");
    private static final RString コード文言_資格取得日 = new RString("項目設定エラー：資格取得日");
    private static final RString コード文言_資格喪失日 = new RString("項目設定エラー：資格喪失日");
    private static final RString コード文言_保険者番号_市町村 = new RString("項目設定エラー：保険者番号（市町村）");
    private static final RString コード文言_保険者番号_広域 = new RString("項目設定エラー：保険者番号（広域）");
    private static final RString コード文言_資格取得事由 = new RString("項目設定エラー：資格取得事由");
    private static final RString コード文言_資格喪失事由 = new RString("項目設定エラー：資格喪失事由");
    private static final RString 文言_資格取得日資格喪失日 = new RString("項目設定エラー：資格取得日＞資格喪失日");
    private static final RString 文言_保険者開始日保険者終了日 = new RString("項目設定エラー：保険者開始日＞保険者終了日");
    private static final RString エラー区分_1 = new RString("1");
    private static final RString エラー区分_0 = new RString("0");
    private static final RString DB = new RString("DB");
    private static final RString コロン = new RString(":");
    private static final RString 中黒 = new RString(".");
    private static final RString ハイフン = new RString("-");
    private static final RString エラーコード_51 = new RString("51");
    private static final RString 履歴番号_0001 = new RString("0001");
    private static final RString 日付_99999999 = new RString("99999999");
    private static final RString 個人区分コード_1 = new RString("1");
    private static final RString 個人区分コード_2 = new RString("2");
    private static final RString 個人区分コード_3 = new RString("3");
    private static final RString コード文言_個人区分コード = new RString("項目設定エラー：個人区分コード");
    private static final RString 文言_個人区分コード_住登外 = new RString("（警告）個人区分コードが住登外です");
    private static final RString コード文言_保険者開始日 = new RString("項目設定エラー：保険者開始日");
    private static final RString コード文言_保険者終了日 = new RString("項目設定エラー：保険者終了日");
    private static final RString コード文言_氏名カナ = new RString("項目設定エラー：氏名カナ");
    private static final RString コード文言_生年月日 = new RString("項目設定エラー：生年月日");
    private static final RString コード文言_性別コード = new RString("項目設定エラー：性別コード");
    private static final RString コード文言_現住所 = new RString("項目設定エラー：現住所");
    private static final RString 性別コード_1 = new RString("0");
    private static final RString 性別コード_2 = new RString("1");
    private static final RString 性別コード_3 = new RString("2");

    FileSpoolManager spoolManager;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 一時tableWriter;

    @Override
    protected void initialize() {
        文言設定flag = true;
        if (保険者区分_単独保険者.equals(processParameter.get保険者区分())) {
            ファイル名称 = processParameter.get表題().concat(アンダーバー).
                    concat(処理枝番_単一時).concat(ファイル名称の拡張子);
        } else if (保険者区分_広域保険者.equals(processParameter.get保険者区分())) {
            ファイル名称 = processParameter.get表題().concat(アンダーバー).
                    concat(処理枝番_広域時).concat(processParameter.get市町村識別ID()).concat(ファイル名称の拡張子);
        }
        List<UzT0885SharedFileEntryEntity> list = SharedFile.searchSharedFile(ファイル名称);
        Collections.sort(list, new Comparator<UzT0885SharedFileEntryEntity>() {
            @Override
            public int compare(UzT0885SharedFileEntryEntity o1, UzT0885SharedFileEntryEntity o2) {
                RDateTime 一覧表示順1 = o1.getSharedFileId();
                RDateTime 一覧表示順2 = o2.getSharedFileId();
                int flag = 0;
                if (一覧表示順1 != null && 一覧表示順2 != null) {
                    flag = 一覧表示順2.compareTo(一覧表示順1);
                }
                return flag;
            }
        });
        filePath = new RString(SharedFile.getBasePath()).concat(DB).concat(File.separator).concat(ファイル名称).concat(File.separator)
                .concat(new RString(list.get(0).getSharedFileId().toString()).replace(コロン.toString(), 中黒.toString())
                        .replace(ハイフン.toString(), 中黒.toString())).concat(File.separator).concat(ファイル名称);
        市町村コードリスト = getMapper(IKokikoreishaShikakuIdoInMapper.class).get構成市町村マスタ();
    }

    @Override

    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath, Encode.SJIS);
    }

    @Override
    protected void createWriter() {
        一時tableWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                TorikomiKokiKoreshaJyohoEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(RString result) {
        取込後期高齢者情報Entity = new TorikomiKokiKoreshaJyohoEntity();
        取込後期高齢者情報Entity.setエラー区分(エラー区分_0);
        if (ＩＦ種類_電算.equals(processParameter.getIf種類())) {
            int バイト数 = 0;
            try {
                バイト数 = result.toString().getBytes(Encode.SJIS.getName()).length;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(InsTorikomiKokiKoreshaJyohoProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
            RString 指定バイト数な文字列 = get指定バイト数な文字列(INDEX_62, result);
            setEntity(指定バイト数な文字列);
            if (INDEX_62 != バイト数) {
                取込後期高齢者情報Entity.setエラーコード(エラーコード_01);
                取込後期高齢者情報Entity.setエラー文言(コード文言_フォーマットエラー);
                取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
                文言設定flag = false;
            }
            エラーチェック処理_電算();

        } else if (ＩＦ種類_電算２.equals(processParameter.getIf種類())) {
            int バイト数 = 0;
            try {
                バイト数 = result.toString().getBytes(Encode.SJIS.getName()).length;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(InsTorikomiKokiKoreshaJyohoProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
            RString 指定バイト数な文字列 = get指定バイト数な文字列(INDEX_492, result);
            setEntityDensanNi(指定バイト数な文字列);
            if (INDEX_492 != バイト数) {
                取込後期高齢者情報Entity.setエラーコード(エラーコード_51);
                取込後期高齢者情報Entity.setエラー文言(コード文言_フォーマットエラー);
                取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
                文言設定flag = false;
            }

            エラーチェック処理_電算2();
        }
        取込後期高齢者情報Entity.set文言設定flag(文言設定flag);
        一時tableWriter.insert(取込後期高齢者情報Entity);
    }

    private RString get指定バイト数な文字列(int 指定バイト数, RString 判断文字列) {
        int 今バイト数 = 0;
        try {
            今バイト数 = 判断文字列.toString().getBytes(Encode.SJIS.getName()).length;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InsTorikomiKokiKoreshaJyohoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        RString 指定バイト数な文字列 = 判断文字列;
        if (今バイト数 < 指定バイト数) {
            for (int i = 今バイト数; i < 指定バイト数; i++) {
                指定バイト数な文字列 = 指定バイト数な文字列.concat(RString.HALF_SPACE);
            }
        } else {
            try {
                return new RString(new String(指定バイト数な文字列.toString().
                        getBytes(Encode.SJIS.getName()), 0, 指定バイト数, Encode.SJIS.getName()));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(InsTorikomiKokiKoreshaJyohoProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 指定バイト数な文字列;
    }

    private RString get指定位置な文字列(RString 指定な文字列, int 開始位置, int 終了位置) {
        try {
            return new RString(new String(指定な文字列.toString().
                    getBytes(Encode.SJIS.getName()), 開始位置, 終了位置, Encode.SJIS.getName()));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InsTorikomiKokiKoreshaJyohoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void エラーチェック処理_電算() {
        RString 市町村コード = 取込後期高齢者情報Entity.get市町村コード();
        if (is空白(市町村コード) || !Pattern.compile(正則表現_数値.toString()).matcher(市町村コード).matches()
                || (市町村コード.length() != INDEX_5 && 市町村コード.length() != INDEX_6)
                || (保険者区分_広域保険者.equals(processParameter.get保険者区分())
                && !is構成市町村マスタあり(市町村コード))) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_02);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_市町村コード);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }

        RString 住民コード = 取込後期高齢者情報Entity.get住民コード();
        if (住民コード.isEmpty() || !Pattern.compile(正則表現_数値.toString()).matcher(住民コード).matches()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_03);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_住民コード);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }

        RString 履歴番号 = 取込後期高齢者情報Entity.get履歴番号();
        if (!履歴番号_0001.equals(履歴番号)) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_04);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_履歴番号);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 被保険者番号 = 取込後期高齢者情報Entity.get後期高齢被保険者番号();
        if (!Pattern.compile(正則表現_半角空白.toString()).matcher(被保険者番号).matches()
                && !Pattern.compile(正則表現_数値.toString()).matcher(被保険者番号).matches()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_05);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_被保険者番号);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 保険者番号_市町村 = 取込後期高齢者情報Entity.get後期高齢保険者番号_市町村();
        if (!Pattern.compile(正則表現_半角空白.toString()).matcher(保険者番号_市町村).matches()
                && !Pattern.compile(正則表現_数値.toString()).matcher(保険者番号_市町村).matches()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_06);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_保険者番号_市町村);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }

        エラーチェック処理_電算用();
    }

    private void エラーチェック処理_電算用() {
        RString 保険者番号_広域 = 取込後期高齢者情報Entity.get後期高齢保険者番号_広域();
        if (!Pattern.compile(正則表現_半角空白.toString()).matcher(保険者番号_広域).matches()
                && !Pattern.compile(正則表現_数値.toString()).matcher(保険者番号_広域).matches()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_07);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_保険者番号_広域);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 資格取得日 = 取込後期高齢者情報Entity.get資格取得年月日();
        if (資格取得日 == null || !new FlexibleDate(資格取得日).isValid()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_08);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_資格取得日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 資格喪失日 = 取込後期高齢者情報Entity.get資格喪失年月日();
        if (!日付_99999999.equals(資格喪失日)
                && (資格喪失日 == null || !new FlexibleDate(資格喪失日).isValid())) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_09);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_資格喪失日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        if (!日付_99999999.equals(資格喪失日) && 資格喪失日 != null && new FlexibleDate(資格喪失日).isValid() && 資格取得日 != null
                && new FlexibleDate(資格取得日).isValid() && new FlexibleDate(資格喪失日).isBefore(new FlexibleDate(資格喪失日))) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_10);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(文言_資格取得日資格喪失日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void エラーチェック処理_電算2() {
        RString 個人区分コード = 取込後期高齢者情報Entity.get個人区分コード();
        if (!個人区分コード_1.equals(個人区分コード) && !個人区分コード_2.equals(個人区分コード)
                && !個人区分コード_3.equals(個人区分コード)) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_52);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_個人区分コード);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        if (個人区分コード_3.equals(個人区分コード)) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_53);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(文言_個人区分コード_住登外);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 個人番号 = 取込後期高齢者情報Entity.get住民コード();
        if (!Pattern.compile(正則表現_半角空白.toString()).matcher(個人番号).matches()
                && !Pattern.compile(正則表現_数値.toString()).matcher(個人番号).matches()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_54);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_個人番号);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 被保険者番号 = 取込後期高齢者情報Entity.get後期高齢被保険者番号();
        if (!Pattern.compile(正則表現_半角空白.toString()).matcher(被保険者番号).matches()
                && !Pattern.compile(正則表現_数値.toString()).matcher(被保険者番号).matches()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_55);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_被保険者番号);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        エラーチェック処理_電算２用部分();
        エラーチェック処理_電算２用部分1();
        RString 生年月日 = 取込後期高齢者情報Entity.get生年月日();
        if (生年月日 == null || 生年月日.isEmpty()
                || !new FlexibleDate(生年月日).isValid()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_63);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_生年月日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        エラーチェック処理_電算２用部分2();
        エラーチェック処理_電算２用部分3();
    }

    private void エラーチェック処理_電算２用部分() {
        RString 資格取得日 = 取込後期高齢者情報Entity.get資格取得年月日();
        if (資格取得日 != null && (!Pattern.compile(正則表現_半角空白
                .toString()).matcher(資格取得日).matches()
                && !new FlexibleDate(資格取得日).isValid())) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_57);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_資格取得日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }

        RString 資格喪失日 = 取込後期高齢者情報Entity.get資格喪失年月日();
        if (!日付_99999999.equals(資格喪失日)
                && (資格喪失日 == null || !new FlexibleDate(資格喪失日).isValid())) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_59);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_資格喪失日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        if (!日付_99999999.equals(資格喪失日) && 資格喪失日 != null && new FlexibleDate(資格喪失日).isValid() && 資格取得日 != null
                && new FlexibleDate(資格取得日).isValid() && new FlexibleDate(資格喪失日).isBefore(new FlexibleDate(資格喪失日))) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_68);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(文言_資格取得日資格喪失日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void エラーチェック処理_電算２用部分1() {
        List<RString> 取得事由List = new ArrayList<>();
        for (ShikakuShutokuJiyu データ作成 : ShikakuShutokuJiyu.values()) {
            取得事由List.add(データ作成.getコード());
        }
        RString 資格取得事由 = 取込後期高齢者情報Entity.get資格取得事由コード().substring(INDEX_0, INDEX_2);
        if (資格取得事由.isEmpty() && !取得事由List.contains(資格取得事由)) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_56);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_資格取得事由);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        List<RString> 喪失事由List = new ArrayList<>();
        for (ShikakuSoshitsuJiyu データ作成 : ShikakuSoshitsuJiyu.values()) {
            喪失事由List.add(データ作成.getコード());
        }
        RString 資格喪失事由 = 取込後期高齢者情報Entity.get資格喪失事由コード().substring(INDEX_0, INDEX_2);
        if (資格喪失事由.isEmpty() && !喪失事由List.contains(資格喪失事由)) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_58);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_資格喪失事由);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 氏名カナ = 取込後期高齢者情報Entity.getカナ氏名();
        if (!RStringUtil.is全角Only(氏名カナ)
                || Pattern.compile(正則表現_全角空白.toString()).matcher(氏名カナ).matches()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_62);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_氏名カナ);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void エラーチェック処理_電算２用部分2() {
        RString 保険者開始日 = 取込後期高齢者情報Entity.get保険者適用開始年月日();
        if (保険者開始日 != null && !保険者開始日.isEmpty()
                && (!Pattern.compile(正則表現_半角空白.toString()).matcher(保険者開始日).matches()
                && !new FlexibleDate(保険者開始日).isValid())) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_60);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_保険者開始日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 保険者終了日 = 取込後期高齢者情報Entity.get保険者適用終了年月日();
        if (保険者終了日 != null && !保険者終了日.isEmpty()
                && (!Pattern.compile(正則表現_半角空白.toString()).matcher(保険者開始日).matches()
                && !new FlexibleDate(保険者終了日).isValid())) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_61);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_保険者終了日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        if (保険者開始日 != null && new FlexibleDate(保険者開始日).isValid()
                && 保険者終了日 != null && new FlexibleDate(保険者終了日).isValid()
                && new FlexibleDate(保険者終了日)
                .isBefore(new FlexibleDate(保険者開始日))) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_69);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(文言_保険者開始日保険者終了日);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void エラーチェック処理_電算２用部分3() {
        RString 性別コード = 取込後期高齢者情報Entity.get性別コード();
        if (!性別コード_1.equals(性別コード) && !性別コード_2.equals(性別コード) && !性別コード_3.equals(性別コード)) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_64);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_性別コード);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 現住所 = 取込後期高齢者情報Entity.get住所();
        if (!RStringUtil.is全角Only(現住所)
                && !Pattern.compile(正則表現_半角空白.toString()).matcher(現住所).matches()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_65);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_現住所);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 市町村コード = 取込後期高齢者情報Entity.get市町村コード();
        if (is空白(市町村コード) || !Pattern.compile(正則表現_数値.toString()).matcher(市町村コード).matches()
                || (市町村コード.length() != INDEX_5 && 市町村コード.length() != INDEX_6)
                || (保険者区分_広域保険者.equals(processParameter.get保険者区分())
                && !is構成市町村マスタあり(市町村コード))) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_66);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_市町村コード);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
        RString 後期高齢保険者番号_市町村 = 取込後期高齢者情報Entity.get後期高齢保険者番号_市町村();
        if (is空白(市町村コード) || !Pattern.compile(正則表現_数値.toString()).matcher(後期高齢保険者番号_市町村).matches()) {
            取込後期高齢者情報Entity.setエラーコード(エラーコード_67);
            if (文言設定flag) {
                取込後期高齢者情報Entity.setエラー文言(コード文言_保険者番号);
                文言設定flag = false;
            }
            取込後期高齢者情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void setEntity(RString 指定な文字列) {
        取込後期高齢者情報Entity.set市町村コード(get指定位置な文字列(指定な文字列, INDEX_0, INDEX_6));
        取込後期高齢者情報Entity.set住民コード(get指定位置な文字列(指定な文字列, INDEX_6, INDEX_12));
        取込後期高齢者情報Entity.set履歴番号(get指定位置な文字列(指定な文字列, INDEX_18, INDEX_4));
        取込後期高齢者情報Entity.set後期高齢被保険者番号(get指定位置な文字列(指定な文字列, INDEX_22, INDEX_8));
        取込後期高齢者情報Entity.set資格取得年月日(get指定位置な文字列(指定な文字列, INDEX_30, INDEX_8));
        取込後期高齢者情報Entity.set資格喪失年月日(get指定位置な文字列(指定な文字列, INDEX_38, INDEX_8));
        取込後期高齢者情報Entity.set後期高齢保険者番号_市町村(get指定位置な文字列(指定な文字列, INDEX_46, INDEX_8));
        取込後期高齢者情報Entity.set後期高齢保険者番号_広域(get指定位置な文字列(指定な文字列, INDEX_54, INDEX_8));
    }

    private void setEntityDensanNi(RString 指定な文字列) {
        取込後期高齢者情報Entity.set個人区分コード(get指定位置な文字列(指定な文字列, INDEX_0, INDEX_1));
        取込後期高齢者情報Entity.set住民コード(住民コード取得(get指定位置な文字列(指定な文字列, INDEX_1, INDEX_16)));
        取込後期高齢者情報Entity.set後期高齢被保険者番号(get指定位置な文字列(指定な文字列, INDEX_17, INDEX_8));
        取込後期高齢者情報Entity.set資格取得事由コード(get指定位置な文字列(指定な文字列, INDEX_25, INDEX_3));
        取込後期高齢者情報Entity.set資格取得年月日(get指定位置な文字列(指定な文字列, INDEX_28, INDEX_8));
        取込後期高齢者情報Entity.set資格喪失事由コード(get指定位置な文字列(指定な文字列, INDEX_36, INDEX_3));
        RString 資格喪失年月日 = get指定位置な文字列(指定な文字列, INDEX_39, INDEX_8);
        if (is空白(資格喪失年月日)) {
            取込後期高齢者情報Entity.set資格喪失年月日(日付_99999999);
        } else {
            取込後期高齢者情報Entity.set資格喪失年月日(資格喪失年月日);
        }
        取込後期高齢者情報Entity.set保険者適用開始年月日(get指定位置な文字列(指定な文字列, INDEX_47, INDEX_8));
        取込後期高齢者情報Entity.set保険者適用終了年月日(get指定位置な文字列(指定な文字列, INDEX_55, INDEX_8));
        取込後期高齢者情報Entity.setカナ氏名(get指定位置な文字列(指定な文字列, INDEX_63, INDEX_40));
        取込後期高齢者情報Entity.set生年月日(get指定位置な文字列(指定な文字列, INDEX_103, INDEX_8));
        取込後期高齢者情報Entity.set性別コード(get指定位置な文字列(指定な文字列, INDEX_111, INDEX_1));
        取込後期高齢者情報Entity.set住所(get指定位置な文字列(指定な文字列, INDEX_128, INDEX_100));
        取込後期高齢者情報Entity.set市町村コード(get指定位置な文字列(指定な文字列, INDEX_322, INDEX_6));
        取込後期高齢者情報Entity.set後期高齢保険者番号_市町村(get指定位置な文字列(指定な文字列, INDEX_328, INDEX_8));
    }

    private boolean is空白(RString value) {
        RString 空白 = RString.EMPTY;
        for (int i = 0; i < value.length(); i++) {
            空白 = 空白.concat(RString.HALF_SPACE);
        }
        return 空白.equals(value);
    }

    private boolean is構成市町村マスタあり(RString 市町村コード) {
        for (LasdecCode lasdecCode : 市町村コードリスト) {
            if (市町村コード.equals(lasdecCode.value())) {
                return true;
            }
        }
        return false;
    }

    private RString 住民コード取得(RString 住民コード) {
        RString code = 住民コード.substring(INDEX_2, INDEX_10).trim();
        return LONG_RSTRING_ZERO.substring(code.length(), INDEX_15).concat(code);
    }
}
