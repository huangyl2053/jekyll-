/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.Comparators;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.DateDuration;
import jp.co.ndensan.reams.uz.uza.lang.DayOfWeek;
import jp.co.ndensan.reams.uz.uza.lang.IDateDurationGettable;
import jp.co.ndensan.reams.uz.uza.lang.IDayDealable;
import jp.co.ndensan.reams.uz.uza.lang.IMonthDealable;
import jp.co.ndensan.reams.uz.uza.lang.IYearDealable;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 処理日時を表すドメインクラスです。
 *
 * @author N3327 三浦 凌
 */
public final class ShoriTimestamp implements IValueObject<YMDHMS>, Comparable<ShoriTimestamp>, IDbColumnMappable, Serializable,
        IDayDealable<ShoriTimestamp>, IMonthDealable<ShoriTimestamp>, IYearDealable<ShoriTimestamp>, IDateDurationGettable<ShoriTimestamp> {

    private final YMDHMS theValue;

    /**
     * 指定の値を持った{@link ShoriTimestamp}を生成します。
     *
     * @param value 値
     * @deprecated TypeHandlerとShoriTimestamp内部でのみ使用可能とします。
     */
    @Deprecated
    public ShoriTimestamp(YMDHMS value) {
        this.theValue = value;
    }

    /**
     * 指定の{@link YMDHMS}を保持する{@link ShoriTimestamp}を生成します。
     * 引数が{@code null}の時、{@code null}を保持します。
     *
     * @param yMDHMS {@link YMDHMS}
     * @return 指定の{@link YMDHMS}を保持する{@link ShoriTimestamp}
     */
    public static ShoriTimestamp of(YMDHMS yMDHMS) {
        return new ShoriTimestamp(yMDHMS);
    }

    /**
     * 指定の{@link RDateTime}から変換した{@link YMDHMS}を保持する{@link ShoriTimestamp}を生成します。
     * 引数が{@code null}の時、{@code null}を保持します。
     *
     * @param rDateTime {@link RDateTime}
     * @return
     * 指定の{@link RDateTime}から変換した{@link YMDHMS}を保持する{@link ShoriTimestamp}
     */
    public static ShoriTimestamp of(RDateTime rDateTime) {
        return new ShoriTimestamp(rDateTime == null ? null : toYMDHMS(rDateTime));
    }

    private static YMDHMS toYMDHMS(RDateTime rDateTime) {
        StringBuilder yMDHMS = new StringBuilder();
        yMDHMS.append(rDateTime.getDate().toDateString());
        yMDHMS.append(String.format("%1$02d", rDateTime.getHour()));
        yMDHMS.append(String.format("%1$02d", rDateTime.getMinute()));
        yMDHMS.append(String.format("%1$02d", rDateTime.getSecond()));
        return new YMDHMS(yMDHMS.toString());
    }

    /**
     * {@link RDateTime#now() RDateTime.now()}を{@link YMDHMS}へ変換した値を保持する{@link ShoriTimestamp}を生成します。
     *
     * @return
     * {@link RDateTime#now() RDateTime.now()}を{@link YMDHMS}へ変換した値を保持する{@link ShoriTimestamp}
     */
    public static ShoriTimestamp now() {
        return ShoriTimestamp.of(RDateTime.now());
    }

    @Override
    public YMDHMS value() {
        return this.theValue;
    }

    @Override
    public int compareTo(ShoriTimestamp o) {
        return Objects.compare(this.theValue, o.theValue, Comparators.naturalOrder());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShoriTimestamp)) {
            return false;
        }
        ShoriTimestamp other = (ShoriTimestamp) obj;
        return Objects.equals(this.theValue, other.theValue);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.theValue);
        return hash;
    }

    @Override
    public YMDHMS getColumnValue() {
        return this.theValue;
    }

    @Override
    public int getDayValue() {
        return this.theValue.getDayValue();
    }

    @Override
    public DayOfWeek getDayOfWeek() {
        return this.theValue.getDayOfWeek();
    }

    @Override
    public int getBetweenDays(ShoriTimestamp t) {
        return this.theValue.getBetweenDays(t.theValue);
    }

    @Override
    public ShoriTimestamp plusDay(int i) {
        return new ShoriTimestamp(this.theValue.plusDay(i));
    }

    @Override
    public ShoriTimestamp minusDay(int i) {
        return new ShoriTimestamp(this.theValue.minusDay(i));
    }

    @Override
    public int getMonthValue() {
        return this.theValue.getMonthValue();
    }

    @Override
    public int getLastDay() {
        return this.theValue.getLastDay();
    }

    @Override
    public int getBetweenMonths(ShoriTimestamp e) {
        return this.theValue.getBetweenMonths(e.theValue);
    }

    @Override
    public ShoriTimestamp plusMonth(int i) {
        return new ShoriTimestamp(this.theValue.plusMonth(i));
    }

    @Override
    public ShoriTimestamp minusMonth(int i) {
        return new ShoriTimestamp(this.theValue.minusMonth(i));
    }

    @Override
    public int getYearValue() {
        return this.theValue.getYearValue();
    }

    @Override
    public boolean isLeapYear() {
        return this.theValue.isLeapYear();
    }

    @Override
    public int getBetweenYears(ShoriTimestamp e) {
        return this.theValue.getBetweenYears(e.theValue);
    }

    @Override
    public ShoriTimestamp plusYear(int i) {
        return new ShoriTimestamp(this.theValue.plusYear(i));
    }

    @Override
    public ShoriTimestamp minusYear(int i) {
        return new ShoriTimestamp(this.theValue.minusYear(i));
    }

    @Override
    public DateDuration getBetweenDuration(ShoriTimestamp e) {
        return this.theValue.getBetweenDuration(e.theValue);
    }

    /**
     * 時間のint値を返します。
     *
     * @return 時間のint値
     */
    public int getHour() {
        return this.theValue.getRDateTime().getHour();
    }

    /**
     * 保持する値に指定の時間を加算した{@link ShoriTimestamp}を返します。
     *
     * @param hours 時間
     * @return 指定の時間を加算した{@link ShoriTimestamp}
     */
    public ShoriTimestamp plusHours(long hours) {
        return ShoriTimestamp.of(this.theValue.getRDateTime().plusHours(hours));
    }

    /**
     * 保持する値から指定の時間を引いた{@link ShoriTimestamp}を返します。
     *
     * @param hours 時間
     * @return 指定の時間を引いた{@link ShoriTimestamp}
     */
    public ShoriTimestamp minusHours(long hours) {
        return ShoriTimestamp.of(this.theValue.getRDateTime().minusHours(hours));
    }

    /**
     * 分のint値を返します。
     *
     * @return 分のint値
     */
    public int getMinute() {
        return this.theValue.getRDateTime().getMinute();
    }

    /**
     * 保持する値に指定の分を加算した{@link ShoriTimestamp}を返します。
     *
     * @param minutes 分
     * @return 指定の分を加算した{@link ShoriTimestamp}
     */
    public ShoriTimestamp plusMinutes(long minutes) {
        return ShoriTimestamp.of(this.theValue.getRDateTime().plusMinutes(minutes));
    }

    /**
     * 保持する値から指定の分を引いた{@link ShoriTimestamp}を返します。
     *
     * @param minutes 分
     * @return 指定の分を引いた{@link ShoriTimestamp}
     */
    public ShoriTimestamp minusMinutes(long minutes) {
        return ShoriTimestamp.of(this.theValue.getRDateTime().minusMinutes(minutes));
    }

    /**
     * 秒のint値を返します。
     *
     * @return 秒のint値
     */
    public int getSecond() {
        return this.theValue.getRDateTime().getSecond();
    }

    /**
     * 保持する値に指定の秒を加算した{@link ShoriTimestamp}を返します。
     *
     * @param seconds 秒
     * @return 指定の秒を加算した{@link ShoriTimestamp}
     */
    public ShoriTimestamp plusSeconds(long seconds) {
        return ShoriTimestamp.of(this.theValue.getRDateTime().plusSeconds(seconds));
    }

    /**
     * 保持する値から指定の秒を引いた{@link ShoriTimestamp}を返します。
     *
     * @param seconds 秒
     * @return 指定の秒を引いた{@link ShoriTimestamp}
     */
    public ShoriTimestamp minusSeconds(long seconds) {
        return ShoriTimestamp.of(this.theValue.getRDateTime().minusSeconds(seconds));
    }

    /**
     * 保持する値が{@code null}でない時{@code true}を返します。
     *
     * @return 保持する値が{@code null}でない時{@code true}
     */
    public boolean isPresent() {
        return this.theValue != null;
    }

    /**
     * 保持する{@link YMDHMS}の{@link YMDHMS#toString() toString()}と同じ値を返します。
     *
     * @return 保持する{@link YMDHMS}の{@link YMDHMS#toString() toString()}と同じ値
     */
    @Override
    public String toString() {
        return this.theValue.toString();
    }
}