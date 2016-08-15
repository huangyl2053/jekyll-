/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.util;

import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 日時処理の共通クラスです。
 *
 * @reamsid_L DBB-1860-060 liuyang
 */
public final class DateConverter {

    private DateConverter() {
    }
    private static final int NUM_8 = 8;
    private static final int NUM_6 = 6;
    private static final int NUM_4 = 4;
    private static final RString 年 = new RString("年");
    private static final RString 月 = new RString("月");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");
    private static final RString FULLYEAR = new RString("0000");
    private static final RString FULLMONTH = new RString("00");
    private static final RString HALFMONTH = new RString("#0");

    /**
     * formatYearFullのメソドです。
     *
     * @param year RString
     * @return RString
     */
    public static RString formatYearFull(RString year) {
        if (RString.isNullOrEmpty(year) || year.trim().isEmpty()
                || year.trim().replace(月, RString.EMPTY).trim().isEmpty()) {
            return RString.EMPTY;
        }
        year = year.trim().replace(年, RString.EMPTY).trim();
        return new RString(new Decimal(year.toString()).toString(FULLYEAR.toString()));
    }

    /**
     * formatYearFullのメソドです。
     *
     * @param year Integer
     * @return RString
     */
    public static RString formatYearFull(Integer year) {
        if (year == null) {
            return RString.EMPTY;
        }
        return new RString(new Decimal(year).toString(FULLYEAR.toString()));
    }

    /**
     * "1"(月)-->"01" ,"10"(月)-->"10"<br/>
     *
     * @param month Integer
     * @return RString
     */
    public static RString formatMonthFull(RString month) {
        if (RString.isNullOrEmpty(month) || month.trim().isEmpty()
                || month.trim().replace(月, RString.EMPTY).trim().isEmpty()) {
            return RString.EMPTY;
        }
        month = month.trim().replace(月, RString.EMPTY).trim();
        return new RString(new Decimal(month.toString()).toString(FULLMONTH.toString()));
    }

    /**
     * 1(月)-->"01" ,10(月)-->"10"<br/>
     *
     * @param month Integer
     * @return RString
     */
    public static RString formatMonthFull(Integer month) {
        if (month == null) {
            return RString.EMPTY;
        }
        return new RString(new Decimal(month).toString(FULLMONTH.toString()));
    }

    /**
     * 引数で指定された日付を和暦年月日（前半角スペース埋め）に編集し返却します。<br />
     * 変換元：20141001<br />
     * 変換後：平26.10. 1 （年、月、日がそれぞれ一桁の場合、前半角スペース埋めする）
     *
     * @param targetValue 変換元となる日付
     * @return 変換後の日付
     */
    public static RString toWarekiHalf(RDate targetValue) {
        return targetValue.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).
                fillType(FillType.BLANK).
                width(Width.HALF).toDateString();
    }

    /**
     * 引数で指定された日付を西暦年月日に編集し、「/」で区切り返却します。<br />
     * 変換元：20141001<br />
     * 変換後：2014/10/01
     *
     * @param date 日付
     * @return RString 年月日
     */
    public static RString getSeireki(RDate date) {
        RString tmp = RString.EMPTY;
        if (date != null) {
            tmp = date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return tmp;
    }

    /**
     * 引数で指定された日付を西暦年月日に編集し、「/」で区切り返却します。<br />
     * 変換元：20141001<br />
     * 変換後：2014/10/01
     *
     * @param date 日付
     * @return RString 年月日
     */
    public static RString getSeireki(IDateOfBirth date) {
        RString tmp = RString.EMPTY;
        if (date != null && date.toFlexibleDate() != null) {
            tmp = date.toFlexibleDate().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return tmp;
    }

    /**
     * 共通ポリシー パターン1 <br/>
     * 引数で指定された日付を和暦年月日（前ゼロ埋め）に編集し返却します。<br />
     * 変換元：20141001<br />
     * 変換後：平26.10.01 （年、月、日がそれぞれ一桁の場合、前ゼロ埋めする）
     *
     * @param targetValue 変換元となる日付
     * @return 変換後の日付
     */
    public static RString toWarekiHalf_Zero(RDate targetValue) {
        if (targetValue == null) {
            return RString.EMPTY;
        }
        return targetValue.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).
                fillType(FillType.ZERO).
                width(Width.HALF).toDateString();
    }

    /**
     * 共通ポリシー パターン51 <br/>
     * 引数で指定された日付を和暦年月（前ゼロ埋め）に編集し返却します。<br />
     * 変換元：20140101<br />
     * 変換後：平26.01 （年、月がそれぞれ一桁の場合、前ゼロ埋めする）
     *
     * @param targetValue 変換元となる日付
     * @return 変換後の日付
     */
    public static RString toWarekiHalf_Zero(RYearMonth targetValue) {
        if (targetValue == null) {
            return RString.EMPTY;
        }
        return targetValue.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).
                fillType(FillType.ZERO).
                width(Width.HALF).toDateString();
    }

    /**
     * システム日付から帳票出力用の作成日時の形式に編集を行い返却します。<br />
     * ＧＧYY年MM月DD日hh時mm分ss秒 形式
     *
     * @return 帳票出力用作成日時
     */
    public static RString getSakuseiYMD() {
        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(RDate.getNowDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).
                width(Width.HALF).toDateString());

        RTime nowTime = RDate.getNowTime();
        sakuseiYMD.append(new RString(new Decimal(nowTime.getHour()).toString(HALFMONTH.toString())));
        sakuseiYMD.append(時);
        sakuseiYMD.append(new RString(new Decimal(nowTime.getMinute()).toString(HALFMONTH.toString())));
        sakuseiYMD.append(分);
        sakuseiYMD.append(new RString(new Decimal(nowTime.getSecond()).toString(HALFMONTH.toString())));
        sakuseiYMD.append(秒);

        return sakuseiYMD.toRString();
    }

    /**
     * 引数で指定された日付を和暦年月日（前半角スペース埋め）に編集し、「年」「月」「日」で区切り返却します。<br />
     * 変換元：20141001<br />
     * 変換後：平26年10月 1 日（年、月、日がそれぞれ一桁の場合、前半角スペース埋めする）
     *
     * @param date 日時
     * @return RString 帳票出力年月日
     */
    public static RString getWareki(RDate date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).getYear()
                    .concat(new RString("年")).concat(date.wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonthDay());
        }
        return wareki;
    }

    /**
     * 引数で指定された年を和暦年（前半角スペース埋め）に編集し、元年表記で返却します。<br />
     * 変換元：2014<br />
     * 変換後：平成26年度（年がそれぞれ一桁の場合、前半角スペース埋めする）
     *
     * @param date 年
     * @return RString 帳票出力年
     */
    public static RString getWarekiYear(RYear date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear()
                    .concat(new RString("年度"));
        }
        return wareki;
    }

    /**
     * 引数で指定された日付を和暦年月（前半角スペース埋め）に編集し、「年」「月」で区切り、元年表記で返却します。<br />
     * 変換元：20141001<br />
     * 変換後：平成26年10月 1 日（年、月、日がそれぞれ一桁の場合、前半角スペース埋めする）
     *
     * @param date 日時
     * @return RString 帳票出力年月日
     */
    public static RString getWarekiYM(RYearMonth date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear()
                    .concat(new RString("年")).concat(date.wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonth());
        }
        return wareki;
    }

    /**
     * 引数で指定された日付を和暦年月日（前半角スペース埋め）に編集し、「年」「月」「日」で区切り、元年表記で返却します。<br />
     * 変換元：20141001<br />
     * 変換後：平成26年10月 1 日（年、月、日がそれぞれ一桁の場合、前半角スペース埋めする）
     *
     * @param date 日時
     * @return RString 帳票出力年月日
     */
    public static RString getWarekiYMD(RDate date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear()
                    .concat(new RString("年")).concat(date.wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonthDay());
        }
        return wareki;
    }

    /**
     * 引数で指定された日付を和暦年月日（前半角スペース埋め）に編集し、「年」「月」「日」で区切り、元年表記で返却します。<br />
     * 変換元：20141001<br />
     * 変換後：平成26年10月 1 日（年、月、日がそれぞれ一桁の場合、前半角スペース埋めする）
     *
     * @param date 日時
     * @return RString 帳票出力年月日
     */
    public static RString getWarekiYmd(RDate date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.NONE).getYear()
                    .concat(new RString("年")).concat(date.wareki().separator(Separator.JAPANESE).fillType(FillType.NONE).getMonthDay());
        }
        return wareki;
    }

    /**
     * 引数で指定された日付を和暦年月日（前半角スペース埋め）に編集し、「年」「月」「日」（曜日）、元年表記で返却します。<br />
     * 変換元：20141001<br />
     * 変換後：平成26年10月 1 日（火）（年、月、日がそれぞれ一桁の場合、前半角スペース埋めする）
     *
     * @param date 日時
     * @return RString 帳票出力年月日
     */
    public static RString getWarekiYMDOfWeek(RDate date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear()
                    .concat(new RString("年")).concat(date.wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonthDay()
                            .concat(date.getDayOfWeek().getInFullParentheses()));
        }
        return wareki;
    }

    /**
     * 指定日付から和暦の形式に編集を行い返却します。<br />
     * ＧＧYY年MM月DD日hh時mm分 形式
     *
     * @return format後日時
     */
    public static RString getSakuseiYMDHM() {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        RDateTime datetime = RDate.getNowDateTime();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).
                width(Width.HALF).toDateString());

        sakuseiYMD.append(new RString(new Decimal(datetime.getHour()).toString(HALFMONTH.toString())));
        sakuseiYMD.append(時);
        sakuseiYMD.append(new RString(new Decimal(datetime.getMinute()).toString(HALFMONTH.toString())));
        sakuseiYMD.append(分);

        return sakuseiYMD.toRString();
    }

    /**
     * 指定日付から和暦の形式に編集を行い返却します。<br />
     * ＧＧYY年MM月DD日　hh時mm分 形式
     *
     * @return format後日時
     */
    public static RString getSakuseiYmdhm() {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        RDateTime datetime = RDate.getNowDateTime();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.FULL_SPACE);
        sakuseiYMD.append(new RString(new Decimal(datetime.getHour()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(時);
        sakuseiYMD.append(new RString(new Decimal(datetime.getMinute()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(分);
        return sakuseiYMD.toRString();
    }

    /**
     * 共通ポリシー　パターン259 ＋△＋共通ポリシー　パターン144 <br/>
     * 指定日付から和暦の形式に編集を行い返却します。<br />
     * ＧＧYY年MM月　hh時mm分 形式<br/>
     * 平成01年01月　12時00分 <br/>
     * ※ △：全角スペース
     *
     * @return format後日時
     */
    public static RString getSakuseiYmhm() {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        RDateTime datetime = RDate.getNowDateTime();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.FULL_SPACE);
        sakuseiYMD.append(new RString(new Decimal(datetime.getHour()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(時);
        sakuseiYMD.append(new RString(new Decimal(datetime.getMinute()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(分);
        return sakuseiYMD.toRString();
    }

    /**
     * パターン32 スラッシュ 1989/01/08の形式に編集を行い返却します。 <br/>
     * seireki() / Separator.SLASH/ fillType.ZERO
     *
     * @param date 年月日
     * @return パターン32 年月日
     */
    public static RString getDate32(RDate date) {
        if (date != null) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).width(Width.HALF).toDateString();
        }
        return RString.EMPTY;

    }

    /**
     * パターン82 スラッシュ 1989/01 <br/>
     * seireki() / Separator.SLASH/ fillType.ZERO
     *
     * @param date 年月 {@link RYearMonth}
     * @return パターン82 年月
     */
    public static RString getDate82(RYearMonth date) {
        if (date != null) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).width(Width.HALF).toDateString();
        }
        return RString.EMPTY;
    }

    /**
     * パターン31 ピリオド 1989.01.08　の形式に編集を行い返却します。
     *
     * @param date 年月日
     * @return パターン31
     */
    public static RString getDate31(RDate date) {
        if (date != null) {
            return date.seireki().separator(Separator.PERIOD).fillType(FillType.ZERO).width(Width.HALF).toDateString();
        }
        return RString.EMPTY;
    }

    /**
     * RString型(yyyymmdd)変換RDate型
     *
     * @param dateRstr dateRstr
     * @return RDate型
     */
    public static RDate getDate(RString dateRstr) {
        if (RString.isNullOrEmpty(dateRstr)) {
            return null;
        }
        int year = Integer.parseInt(dateRstr.substring(0, NUM_4).toString());
        int month = Integer.parseInt(dateRstr.substring(NUM_4, NUM_6).toString());
        int day = Integer.parseInt(dateRstr.substring(NUM_6, NUM_8).toString());
        return new RDate(year, month, day);
    }

    /**
     * 12:00:00（共通ポリシー　パターン141）
     *
     * @param time RTime
     * @return RString
     */
    public static RString getTime141(RTime time) {
        if (time == null) {
            return RString.EMPTY;
        }
        return time.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
    }

    /**
     * 1989/01/08（共通ポリシー パターン32）<br/>
     * 12:00:00（共通ポリシー　パターン141） <br/>
     *
     * @param dt RDateTime
     * @return RString
     */
    public static RString getDate1Time141(RDateTime dt) {
        if (dt == null || dt.getDate() == null || dt.getTime() == null) {
            return RString.EMPTY;
        }
        return toWarekiHalf_Zero(dt.getDate()).concat(RString.HALF_SPACE).concat(getTime141(dt.getTime()));
    }

    /**
     * 1989/01/08（共通ポリシー 基本形1）<br/>
     * 平元.01.08　平02.01.01<br/>
     *
     * @param date RDate
     * @return RString
     */
    public static RString getDate1(RDate date) {
        if (date == null || date.equals(RDate.MAX) || date.equals(RDate.MIN)) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString();
    }

    /**
     * 年月 平 1年 1月 平 2年 1月
     *
     * @param date RYearMonth
     * @return 共通ポリシーパターン256
     */
    public static RString getDate256(RYearMonth date) {
        if (date == null || date.equals(RYearMonth.MAX) || date.equals(RYearMonth.MIN)) {
            return RString.EMPTY;
        }
        return date.wareki().firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    /**
     * FlexibleDate => RDate
     *
     * @param fd FlexibleDate
     * @return RDate
     */
    public static RDate flexibleDateToRDate(FlexibleDate fd) {
        if (fd == null) {
            return null;
        }
        return new RDate(fd.getYearValue(), fd.getMonthValue(), fd.getDayValue());
    }
}
