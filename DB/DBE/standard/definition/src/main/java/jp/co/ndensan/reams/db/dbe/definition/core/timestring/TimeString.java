/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.timestring;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護独自で、文字列で表した時間を扱うクラスです。
 *
 */
public class TimeString implements IValueObject<RString>, Comparable<TimeString>, IDbColumnMappable, IValidatable {

    private final RTime time;
    private final RString time変換後文字列;
    private static final int TIME_STRING_LENGTH = 4;

    /**
     * コンストラクタです。<br/>
     * 時間を表す文字列はhhmmの形式に合っている必要があり、指定できる値は0000から2359までの間です。
     *
     * @param timeStr 時間を表す、hhmmの形式に対応した文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 引数が4桁の文字でないとき<br/>
     * 引数が数字以外で構成されているとき<br/>
     * 引数が0000～2359の範囲に収まっておらず、時間として判定できないとき
     */
    public TimeString(RString timeStr) throws NullPointerException {
        RString エラー出力 = new RString("時間を表す文字列");
        requireNonNull(timeStr, UrSystemErrorMessages.値がnull.getReplacedMessage(エラー出力.toString()));
        int hour, minute;
        try {
            int halfLenght = TIME_STRING_LENGTH / 2;
            hour = Integer.parseInt(timeStr.substring(0, halfLenght).toString());
            minute = Integer.parseInt(timeStr.substring(halfLenght, TIME_STRING_LENGTH).toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace(エラー出力.toString(), "数字").getMessage());
        }

        try {
            time = RTime.of(hour, minute);
        } catch (RuntimeException e) {
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

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link TimeString}が持つRStringについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new TimeStringValidator(this).validate();
    }

    /**
     * {@link TimeString}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のRStringについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param timeStr {@link RString}となるコード{@link RString}
     * @return {@link TimeString}
     * @throws IllegalArgumentException {@link TimeStringSpec}の仕様を満たさない場合
     */
    public static TimeString createCheckInstance(RString timeStr) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new TimeStringValidator(new TimeString(timeStr)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new TimeString(timeStr);
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

    @Override
    public RString getColumnValue() {
        return this.time変換後文字列;
    }

    @Override
    public String toString() {
        return this.time変換後文字列 == null ? "" : this.time変換後文字列.toString();
    }
}
