/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
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
    private final RString time変換後文字列;
    private static final int TIME_STRING_LENGTH = 4;

    /**
     * 引数から時間を表す文字列を受け取り、インスタンスを生成します。<br/>
     * 時間を表す文字列はhhmmの形式に合っている必要があり、指定できる値は0000から2359までの間です。
     *
     * @param timeStr 時間を表す、hhmmの形式に対応した文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 引数が4桁の文字でないとき<br/>
     * 引数が数字以外で構成されているとき<br/>
     * 引数が0000～2359の範囲に収まっておらず、時間として判定できないとき
     */
    public TimeString(RString timeStr) throws NullPointerException, IllegalArgumentException {
        RString エラー出力 = new RString("時間を表す文字列");

        requireNonNull(timeStr, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(エラー出力.toString(), getClass().getName()));
        if (!checkLength(timeStr)) {
//            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace(エラー出力.toString(), "4桁").evaluate());
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace(エラー出力.toString(), "4桁").getMessage());
        }

        int hour, minute;
        try {
            int halfLenght = TIME_STRING_LENGTH / 2;
            hour = Integer.parseInt(timeStr.substring(0, halfLenght).toString());
            minute = Integer.parseInt(timeStr.substring(halfLenght, TIME_STRING_LENGTH).toString());
        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace(エラー出力.toString(), "数字").evaluate());
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace(エラー出力.toString(), "数字").getMessage());
        }

        try {
            time = RTime.of(hour, minute);
        } catch (RuntimeException e) {
//            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace(エラー出力.toString(), "0000～2359の間").evaluate());
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace(エラー出力.toString(), "0000～2359の間").getMessage());
        }

        RString hourString = padToZero(Integer.toString(time.getHour()));
        RString minuteString = padToZero(Integer.toString(time.getMinute()));
        time変換後文字列 = hourString.concat(minuteString);
    }

    /**
     * 引数から時間を表す文字列を受け取り、インスタンスを生成します。<br/>
     * 時間を表す文字列はhhmmの形式に合っている必要があり、指定できる値は0000から2359までの間です。
     *
     * @param timeStr 時間を表す、hhmmの形式に対応した文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 引数が4桁の文字でないとき、引数が数字以外で構成されているとき
     */
    public TimeString(String timeStr) throws NullPointerException, IllegalArgumentException {
        this(new RString(timeStr));
    }

    private boolean checkLength(RString timeStr) {
        return timeStr.length() == TIME_STRING_LENGTH;
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
        return time変換後文字列;
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

    /**
     * 自身の情報をRTime型の変換して返します。
     *
     * @return 時間
     */
    public RTime toRTime() {
        return time;
    }
}
