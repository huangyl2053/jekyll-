/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 介護独自で、文字列で表した時間を扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class TimeString implements IValueObject<RString>, Comparable<TimeString> {

    private final RTime time;

    /**
     * 引数から時間を表す文字列を受け取り、インスタンスを生成します。<br/>
     * 時間を表す文字列はhhmmの形式に合っている必要があり、指定できる値は0000から2359までの間です。
     *
     * @param timeStr 時間を表す、hhmmの形式に対応した文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 引数が4桁の文字でないとき、引数が数字以外で構成されているとき
     * @throws RuntimeException 引数に渡された時間が、0000から2359以内ではないとき
     */
    public TimeString(RString timeStr) throws NullPointerException, IllegalArgumentException, RuntimeException {
        requireNonNull(timeStr, Messages.E00003.replace("時間を表す文字列", getClass().getName()).getMessage());
        if (!checkLength(timeStr, 4)) {
            throw new IllegalArgumentException(Messages.E00013.replace("時間を表す文字列", "4桁").getMessage());
        }

        int hour, minute;
        try {
            hour = Integer.parseInt(timeStr.substring(0, 2).toString());
            minute = Integer.parseInt(timeStr.substring(2, 4).toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.E00013.replace("時間を表す文字列が数字").getMessage());
        }

        time = RTime.of(hour, minute);
    }

    /**
     * 引数から時間を表す文字列を受け取り、インスタンスを生成します。<br/>
     * 時間を表す文字列はhhmmの形式に合っている必要があり、指定できる値は0000から2359までの間です。
     *
     * @param timeStr 時間を表す、hhmmの形式に対応した文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 引数が4桁の文字でないとき、引数が数字以外で構成されているとき
     * @throws RuntimeException 引数に渡された時間が、0000～2359以内ではないとき
     */
    public TimeString(String timeStr) throws NullPointerException, IllegalArgumentException {
        this(new RString(timeStr));
    }

    private boolean checkLength(RString timeStr, int 長さ) {
        return timeStr.length() == 長さ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.value().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ((TimeString) obj).value().equals(this.value());
    }

    @Override
    public RString value() {
        RString hourString = padToZero(Integer.toString(time.getHour()));
        RString minuteString = padToZero(Integer.toString(time.getMinute()));
        return hourString.concat(minuteString);
    }

    private RString padToZero(String str) {
        if (str.length() <= 1) {
            return new RString("0".concat(str));
        }
        return new RString(str);
    }

    @Override
    public int compareTo(TimeString 比較対象) {
        return this.value().compareTo(比較対象.value());
    }
}
