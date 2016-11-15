/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.InsTorikomiKokuhoJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.TorikomiKokuhoJyohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 * バッチ設計_DBC130010_国保資格異動情報取込（取込国保情報Tempに登録）
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
public class InsTorikomiKokuhoJyohoTempProcess extends BatchProcessBase<RString> {

    private RString filePath;
    private RString ファイル名称;
    private InsTorikomiKokuhoJyohoTempProcessParameter processParameter;
    @BatchWriter
    private IBatchTableWriter<TorikomiKokuhoJyohoEntity> torikomiKokuhoJyohoWriter;
    private boolean 文言設定flag;
    private TorikomiKokuhoJyohoEntity 取込国保情報Entity;
    private List<LasdecCode> 市町村コードリスト;
    private static final int 二 = 2;
    private static final int 四 = 4;
    private static final int 五 = 5;
    private static final int 六 = 6;
    private static final int 八 = 8;
    private static final int 十 = 10;
    private static final int 十二 = 12;
    private static final int 十四 = 14;
    private static final int 十五 = 15;
    private static final int 十六 = 16;
    private static final int 十八 = 18;
    private static final int 二十 = 20;
    private static final int 二十二 = 22;
    private static final int 二十八 = 28;
    private static final int 三十六 = 36;
    private static final int 三十八 = 38;
    private static final int 四十 = 40;
    private static final int 四十三 = 43;
    private static final int 四十四 = 44;
    private static final int 五十 = 50;
    private static final int 五十二 = 52;
    private static final int 六十 = 60;
    private static final int 六十八 = 68;
    private static final int 七十六 = 76;
    private static final int 八十 = 80;
    private static final int 八十四 = 84;
    private static final int 九十 = 90;
    private static final int 九十二 = 92;
    private static final int 一百一十二 = 112;
    private static final int 一百二十 = 120;
    private static final int 一百二十一 = 121;
    private static final int 一百七十一 = 171;
    private static final int 三百四十一 = 341;
    private static final RString 正則表現_数値 = new RString("[0-9]*");
    private static final RString 正則表現_半角空白 = new RString("[ ]*");
    private static final RString 正則表現_全角空白 = new RString("/[^uFF00-uFFFF]/g");
    private static final RString 保険者区分_単独保険者 = new RString("1");
    private static final RString 保険者区分_広域保険者 = new RString("2");
    private static final RString アンダーバー = new RString("_");
    private static final RString ファイル名称の拡張子 = new RString(".txt");
    private static final RString 処理枝番_単一時 = new RString("0000");
    private static final RString 処理枝番_広域時 = new RString("00");
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
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
    private static final RString エラーコード_11 = new RString("11");
    private static final RString エラーコード_52 = new RString("52");
    private static final RString エラーコード_53 = new RString("53");
    private static final RString エラーコード_54 = new RString("54");
    private static final RString エラーコード_55 = new RString("55");
    private static final RString エラーコード_56 = new RString("56");
    private static final RString エラーコード_57 = new RString("57");
    private static final RString エラーコード_58 = new RString("57");
    private static final RString エラーコード_59 = new RString("57");
    private static final RString エラーコード_60 = new RString("57");
    private static final RString エラーコード_61 = new RString("61");
    private static final RString エラーコード_62 = new RString("62");
    private static final RString エラーコード_63 = new RString("63");
    private static final RString エラーコード_64 = new RString("64");
    private static final RString エラーコード_65 = new RString("65");
    private static final RString エラーコード_66 = new RString("66");
    private static final RString エラーコード_67 = new RString("67");
    private static final RString コード文言_フォーマットエラー = new RString("フォーマットエラー");
    private static final RString コード文言_市町村コード = new RString("項目設定エラー：市町村コード");
    private static final RString コード文言_住民コード = new RString("項目設定エラー：住民コード");
    private static final RString コード文言_履歴番号 = new RString("項目設定エラー：履歴番号");
    private static final RString コード文言_国保番号 = new RString("項目設定エラー：国保番号");
    private static final RString コード文言_資格取得日 = new RString("項目設定エラー：資格取得日");
    private static final RString コード文言_資格喪失日 = new RString("項目設定エラー：資格喪失日");
    private static final RString コード文言_国保保険者番号 = new RString("項目設定エラー：国保保険者番号");
    private static final RString コード文言_国保保険証番号 = new RString("項目設定エラー：国保保険証番号");
    private static final RString コード文言_国保被保険者証番号 = new RString("項目設定エラー：国保被保険者証番号");
    private static final RString コード文言_国保個人番号 = new RString("項目設定エラー：国保個人番号");
    private static final RString コード文言_住基個人番号 = new RString("項目設定エラー：住基個人番号");
    private static final RString コード文言_国保世帯加入日 = new RString("項目設定エラー：国保世帯加入日");
    private static final RString コード文言_国保世帯離脱日 = new RString("項目設定エラー：国保世帯離脱日");
    private static final RString 文言_資格取得日資格喪失日 = new RString("項目設定エラー：資格取得日＞資格喪失日");
    private static final RString エラー区分_1 = new RString("1");
    private static final RString エラー区分_0 = new RString("0");
    private static final RString LONG_RSTRING_ZERO = new RString("000000000000000");
    private static final RString エラーコード_51 = new RString("51");
    private static final RString 履歴番号_0001 = new RString("0001");
    private static final RString 日付_99999999 = new RString("99999999");
    private static final RString 個人区分コード_1 = new RString("1");
    private static final RString 個人区分コード_2 = new RString("2");
    private static final RString 個人区分コード_3 = new RString("3");
    private static final RString コード文言_個人区分コード = new RString("項目設定エラー：個人区分コード");
    private static final RString 文言_個人区分コード_住登外 = new RString("（警告）個人区分コードが住登外です");
    private static final RString コード文言_国保退職該当日 = new RString("項目設定エラー：国保退職該当日");
    private static final RString コード文言_国保退職非該当日 = new RString("項目設定エラー：国保退職非該当日");
    private static final RString コード文言_氏名カナ = new RString("項目設定エラー：氏名カナ");
    private static final RString コード文言_生年月日 = new RString("項目設定エラー：生年月日");
    private static final RString コード文言_性別コード = new RString("項目設定エラー：性別コード");
    private static final RString コード文言_住所 = new RString("項目設定エラー：住所");
    private static final RString コード文言_住所方書 = new RString("項目設定エラー：住所方書");
    private static final RString 性別コード_1 = new RString("0");
    private static final RString 性別コード_2 = new RString("1");
    private static final RString 性別コード_3 = new RString("2");
    private static final RString TEMP_TABLE = new RString("tempTorikomiKokuhoJyoho");
    private static final RString DB = new RString("DB");
    private static final RString コロン = new RString(":");
    private static final RString 中黒 = new RString(".");
    private static final RString ハイフン = new RString("-");

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

        市町村コードリスト = getMapper(IKokuhoShikakuIdoInMapper.class).get構成市町村マスタ();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath, Encode.SJIS);
    }

    @Override
    protected void createWriter() {
        torikomiKokuhoJyohoWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                TorikomiKokuhoJyohoEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(RString result) {
        取込国保情報Entity = new TorikomiKokuhoJyohoEntity();
        取込国保情報Entity.setエラー区分(エラー区分_0);
        if (ＩＦ種類_電算.equals(processParameter.getIf種類())) {
            int バイト数 = 0;
            try {
                バイト数 = result.toString().getBytes(Encode.SJIS.getName()).length;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(InsTorikomiKokuhoJyohoTempProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
            RString 指定バイト数な文字列 = get指定バイト数な文字列(九十, result);
            setEntity(指定バイト数な文字列);
            if (九十 == バイト数) {
                取込国保情報Entity.setエラーコード(エラーコード_01);
                取込国保情報Entity.setエラー文言(コード文言_フォーマットエラー);
                取込国保情報Entity.setエラー区分(エラー区分_1);
                文言設定flag = false;
            }
            エラーチェック処理_電算();

        } else if (ＩＦ種類_電算２.equals(processParameter.getIf種類())) {
            int バイト数 = 0;
            try {
                バイト数 = result.toString().getBytes(Encode.SJIS.getName()).length;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(InsTorikomiKokuhoJyohoTempProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
            RString 指定バイト数な文字列 = get指定バイト数な文字列(三百四十一, result);
            setEntityDensanNi(指定バイト数な文字列);
            if (三百四十一 == バイト数) {
                取込国保情報Entity.setエラーコード(エラーコード_51);
                取込国保情報Entity.setエラー文言(コード文言_フォーマットエラー);
                取込国保情報Entity.setエラー区分(エラー区分_1);
                文言設定flag = false;
            }

            エラーチェック処理_電算２();
        }
        取込国保情報Entity.set文言設定flag(文言設定flag);
        torikomiKokuhoJyohoWriter.insert(取込国保情報Entity);
    }

    private RString get指定バイト数な文字列(int 指定バイト数, RString 判断文字列) {
        int 今バイト数 = 0;
        try {
            今バイト数 = 判断文字列.toString().getBytes(Encode.SJIS.getName()).length;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InsTorikomiKokuhoJyohoTempProcess.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(InsTorikomiKokuhoJyohoTempProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 指定バイト数な文字列;
    }

    private RString get指定位置な文字列(RString 指定な文字列, int 開始位置, int 終了位置) {
        try {
            return new RString(new String(指定な文字列.toString().
                    getBytes(Encode.SJIS.getName()), 開始位置, 終了位置, Encode.SJIS.getName()));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InsTorikomiKokuhoJyohoTempProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void エラーチェック処理_電算() {
        RString 市町村コード = 取込国保情報Entity.get市町村コード();
        if (is空白(市町村コード) || !Pattern.compile(正則表現_数値.toString()).matcher(市町村コード).matches()
                || (市町村コード.length() != 五 && 市町村コード.length() != 六)
                || (保険者区分_広域保険者.equals(processParameter.get保険者区分())
                && !is構成市町村マスタあり(市町村コード))) {
            取込国保情報Entity.setエラーコード(エラーコード_02);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_市町村コード);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 住民コード = 取込国保情報Entity.getIN住民コード();
        if (is空白(住民コード) || !Pattern.compile(正則表現_数値.toString()).matcher(住民コード).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_03);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_住民コード);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 履歴番号 = 取込国保情報Entity.get履歴番号();
        if (!履歴番号_0001.equals(履歴番号)) {
            取込国保情報Entity.setエラーコード(エラーコード_04);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_履歴番号);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 国保番号 = 取込国保情報Entity.get国保番号();
        if (!Pattern.compile(正則表現_半角空白.toString()).matcher(国保番号).matches()
                && !Pattern.compile(正則表現_数値.toString()).matcher(国保番号).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_05);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保番号);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 国保保険者番号 = 取込国保情報Entity.get国保保険者番号();
        if (!Pattern.compile(正則表現_数値.toString()).matcher(国保保険者番号).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_08);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保保険者番号);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        エラーチェック処理_電算用();
    }

    private void エラーチェック処理_電算用() {
        RString 資格取得日 = 取込国保情報Entity.get国保資格取得年月日();
        if (!new FlexibleDate(資格取得日).isValid()) {
            取込国保情報Entity.setエラーコード(エラーコード_06);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_資格取得日);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 資格喪失日 = 取込国保情報Entity.get国保資格喪失年月日();
        if (!日付_99999999.equals(資格喪失日)
                && (!new FlexibleDate(資格喪失日).isValid())) {
            取込国保情報Entity.setエラーコード(エラーコード_07);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_資格喪失日);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 国保保険証番号 = 取込国保情報Entity.get国保保険証番号();
        if (!RStringUtil.is半角カナOnly(国保保険証番号)) {
            取込国保情報Entity.setエラーコード(エラーコード_09);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保保険証番号);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 国保個人番号 = 取込国保情報Entity.get国保個人番号();
        if (!Pattern.compile(正則表現_数値.toString()).matcher(国保個人番号).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_10);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保個人番号);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        if (!日付_99999999.equals(資格喪失日) && 資格喪失日 != null && !資格喪失日.isEmpty()
                && new FlexibleDate(資格喪失日).isValid() && 資格取得日 != null && !資格取得日.isEmpty()
                && new FlexibleDate(資格取得日).isValid() && new FlexibleDate(資格喪失日).isBefore(new FlexibleDate(資格喪失日))) {
            取込国保情報Entity.setエラーコード(エラーコード_11);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(文言_資格取得日資格喪失日);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void エラーチェック処理_電算２() {
        RString 国保保険者番号 = 取込国保情報Entity.get国保保険者番号();
        if (is空白(国保保険者番号) || !Pattern.compile(正則表現_数値.toString()).matcher(国保保険者番号).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_52);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保保険者番号);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 国保保険証番号 = 取込国保情報Entity.get国保保険証番号();
        if (is空白(国保保険証番号) || !RStringUtil.is半角カナOnly(国保保険証番号)) {
            取込国保情報Entity.setエラーコード(エラーコード_53);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保被保険者証番号);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 国保個人番号 = 取込国保情報Entity.get国保個人番号();
        if (!Pattern.compile(正則表現_数値.toString()).matcher(国保個人番号).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_54);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保個人番号);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 市町村コード = 取込国保情報Entity.get市町村コード();
        if (is空白(市町村コード) || !Pattern.compile(正則表現_数値.toString()).matcher(市町村コード).matches()
                || (市町村コード.length() != 五 && 市町村コード.length() != 六)
                || (保険者区分_広域保険者.equals(processParameter.get保険者区分())
                && !is構成市町村マスタあり(市町村コード))) {
            取込国保情報Entity.setエラーコード(エラーコード_55);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_市町村コード);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }
        エラーチェック処理_電算２用部分();
        エラーチェック処理_電算２用部分0();
        エラーチェック処理_電算２用部分1();
        エラーチェック処理_電算２用部分2();
    }

    private void エラーチェック処理_電算２用部分() {
        RString 個人区分コード = 取込国保情報Entity.get個人区分コード();
        if (!個人区分コード_1.equals(個人区分コード) && !個人区分コード_2.equals(個人区分コード) && !個人区分コード_3.equals(個人区分コード)) {
            取込国保情報Entity.setエラーコード(エラーコード_56);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_個人区分コード);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        if (個人区分コード_3.equals(個人区分コード)) {
            取込国保情報Entity.setエラーコード(エラーコード_57);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(文言_個人区分コード_住登外);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 住基個人番号 = 取込国保情報Entity.getIN住民コード();
        if (is空白(住基個人番号) && Pattern.compile(正則表現_数値.toString()).matcher(住基個人番号).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_58);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_住基個人番号);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void エラーチェック処理_電算２用部分0() {
        RString 国保世帯加入日 = 取込国保情報Entity.get国保資格取得年月日();
        if (!new FlexibleDate(国保世帯加入日).isValid()) {
            取込国保情報Entity.setエラーコード(エラーコード_59);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保世帯加入日);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 国保世帯離脱日 = 取込国保情報Entity.get国保資格喪失年月日();
        if (!日付_99999999.equals(国保世帯離脱日) && !new FlexibleDate(国保世帯加入日).isValid()) {
            取込国保情報Entity.setエラーコード(エラーコード_60);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保世帯離脱日);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 国保退職該当日 = 取込国保情報Entity.get国保退職該当日();
        if ((!Pattern.compile(正則表現_半角空白.toString()).matcher(国保退職該当日).matches()
                && !new FlexibleDate(国保退職該当日).isValid())) {
            取込国保情報Entity.setエラーコード(エラーコード_61);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保退職該当日);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void エラーチェック処理_電算２用部分1() {

        RString 国保退職非該当日 = 取込国保情報Entity.get国保退職非該当日();
        if ((!Pattern.compile(正則表現_半角空白.toString()).matcher(国保退職非該当日).matches()
                && !new FlexibleDate(国保退職非該当日).isValid())) {
            取込国保情報Entity.setエラーコード(エラーコード_62);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_国保退職非該当日);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 氏名カナ = 取込国保情報Entity.getカナ氏名();
        if (氏名カナ.trim().isEmpty()
                || Pattern.compile(正則表現_全角空白.toString()).matcher(氏名カナ).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_63);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_氏名カナ);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 生年月日 = 取込国保情報Entity.get生年月日();
        if (生年月日 == null || 生年月日.isEmpty()
                || !new FlexibleDate(生年月日).isValid()) {
            取込国保情報Entity.setエラーコード(エラーコード_64);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_生年月日);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void エラーチェック処理_電算２用部分2() {

        RString 性別コード = 取込国保情報Entity.get性別コード();
        if (!性別コード_1.equals(性別コード) && !性別コード_2.equals(性別コード) && !性別コード_3.equals(性別コード)) {
            取込国保情報Entity.setエラーコード(エラーコード_65);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_性別コード);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 住所 = 取込国保情報Entity.get住所();
        if (!RStringUtil.is全角Only(住所)
                && !Pattern.compile(正則表現_半角空白.toString()).matcher(住所).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_66);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_住所);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }

        RString 住所方書 = 取込国保情報Entity.get方書();
        if (!RStringUtil.is全角Only(住所方書)
                && !Pattern.compile(正則表現_半角空白.toString()).matcher(住所方書).matches()) {
            取込国保情報Entity.setエラーコード(エラーコード_67);
            if (文言設定flag) {
                取込国保情報Entity.setエラー文言(コード文言_住所方書);
                文言設定flag = false;
            }
            取込国保情報Entity.setエラー区分(エラー区分_1);
        }
    }

    private void setEntity(RString 指定な文字列) {
        取込国保情報Entity.set市町村コード(get指定位置な文字列(指定な文字列, 0, 六));
        取込国保情報Entity.setIN住民コード(get指定位置な文字列(指定な文字列, 六, 十二));
        取込国保情報Entity.set履歴番号(get指定位置な文字列(指定な文字列, 十八, 四));
        取込国保情報Entity.set国保番号(get指定位置な文字列(指定な文字列, 二十二, 十四));
        取込国保情報Entity.set国保資格取得年月日(get指定位置な文字列(指定な文字列, 三十六, 八));
        RString 国保資格喪失年月日 = get指定位置な文字列(指定な文字列, 四十四, 八);
        if (is空白(国保資格喪失年月日)) {
            取込国保情報Entity.set国保資格喪失年月日(日付_99999999);
        } else {
            取込国保情報Entity.set国保資格喪失年月日(国保資格喪失年月日);
        }
        取込国保情報Entity.set国保保険者番号(get指定位置な文字列(指定な文字列, 五十二, 八));
        取込国保情報Entity.set国保保険証番号(get指定位置な文字列(指定な文字列, 六十, 二十));
        取込国保情報Entity.set国保個人番号(get指定位置な文字列(指定な文字列, 八十, 十));
    }

    private void setEntityDensanNi(RString 指定な文字列) {
        取込国保情報Entity.set国保保険者番号(get指定位置な文字列(指定な文字列, 0, 八));
        取込国保情報Entity.set国保保険証番号(get指定位置な文字列(指定な文字列, 八, 二十));
        取込国保情報Entity.set国保個人番号(get指定位置な文字列(指定な文字列, 二十八, 十));
        取込国保情報Entity.set市町村コード(get指定位置な文字列(指定な文字列, 三十八, 五));
        取込国保情報Entity.set個人区分コード(get指定位置な文字列(指定な文字列, 四十三, 1));
        取込国保情報Entity.setIN住民コード(住民コード取得(get指定位置な文字列(指定な文字列, 四十四, 十六)));
        取込国保情報Entity.set国保資格取得年月日(get指定位置な文字列(指定な文字列, 六十, 八));
        RString 国保資格喪失年月日 = get指定位置な文字列(指定な文字列, 六十八, 八);
        if (is空白(国保資格喪失年月日)) {
            取込国保情報Entity.set国保資格喪失年月日(日付_99999999);
        } else {
            取込国保情報Entity.set国保資格喪失年月日(国保資格喪失年月日);
        }
        取込国保情報Entity.set国保退職該当日(get指定位置な文字列(指定な文字列, 七十六, 八));
        取込国保情報Entity.set国保退職非該当日(get指定位置な文字列(指定な文字列, 八十四, 八));
        取込国保情報Entity.setカナ氏名(get指定位置な文字列(指定な文字列, 九十二, 二十));
        取込国保情報Entity.set生年月日(get指定位置な文字列(指定な文字列, 一百一十二, 八));
        取込国保情報Entity.set性別コード(get指定位置な文字列(指定な文字列, 一百二十, 1));
        取込国保情報Entity.set住所(get指定位置な文字列(指定な文字列, 一百二十一, 四十));
        取込国保情報Entity.set方書(get指定位置な文字列(指定な文字列, 一百七十一, 五十));
    }

    private boolean is空白(RString value) {
        RString 空白 = RString.EMPTY;
        for (int i = 0; i < value.length(); i++) {
            空白 = 空白.concat(RString.HALF_SPACE);
        }

        return 空白.equals(value);
    }

    private boolean is構成市町村マスタあり(RString 市町村コード) {
        if (ＩＦ種類_電算２.equals(processParameter.getIf種類())) {
            for (LasdecCode lasdecCode : 市町村コードリスト) {
                if (市町村コード.equals(lasdecCode.value().substring(0, 四))) {
                    return true;
                }
            }
        }

        if (ＩＦ種類_電算.equals(processParameter.getIf種類())) {
            for (LasdecCode lasdecCode : 市町村コードリスト) {
                if (市町村コード.equals(lasdecCode.value())) {
                    return true;
                }
            }
        }

        return false;
    }

    private RString 住民コード取得(RString 住民コード) {
        RString code = 住民コード.substring(二, 十).trim();
        return LONG_RSTRING_ZERO.substring(code.length(), 十五).concat(code);
    }
}
