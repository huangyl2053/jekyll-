/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 介護独自で、文字列で表した時間を扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class TimeString implements IValueObject<RString>, Comparable<TimeString> {

    private final RString timeStr;

    /**
     * 引数から時間を表す文字列を受け取り、インスタンスを生成します。<br/>
     * 時間を表す文字列はhhmmの形式に合っている必要があり、指定できる値は0000から2359までの間です。
     *
     * @param timeStr 時間を表す、hhmmの形式に対応した文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 引数に時間として表せない値が渡されたとき
     */
    public TimeString(RString timeStr) throws NullPointerException, IllegalArgumentException {
        requireNonNull(timeStr, Messages.E00003.replace("時間を表す文字列", getClass().getName()).getMessage());

        if (!is長さが一致(timeStr, 4)) {
            throw new IllegalArgumentException(Messages.E00009.replace("引数の文字列長", "4").getMessage());
        }

        if (has数字以外の文字(timeStr)) {
            throw new IllegalArgumentException(Messages.E00013.replace("引数", "0から9までの数字で構成された文字列").getMessage());
        }

        if (!is時間範囲が0000以上2359以内(timeStr)) {
            throw new IllegalArgumentException(Messages.E00013.replace("引数", "0000から2359の間").getMessage());
        }

        this.timeStr = timeStr;
    }

    /**
     * 引数から時間を表す文字列を受け取り、インスタンスを生成します。<br/>
     * 時間を表す文字列はhhmmの形式に合っている必要があり、指定できる値は0000から2359までの間です。
     *
     * @param timeStr 時間を表す、hhmmの形式に対応した文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 引数に時間として表せない値が渡されたとき
     */
    public TimeString(String timeStr) throws NullPointerException, IllegalArgumentException {
        this(new RString(timeStr));
    }

    private boolean is長さが一致(RString timeStr, int 長さ) {
        return timeStr.length() == 長さ;
    }

    private boolean has数字以外の文字(RString timeStr) {
        for (int i = 0; i < timeStr.length(); i++) {
            if (!is文字列が指定範囲内(new RString("0"), timeStr.stringAt(i), new RString("9"))) {
                return true;
            }
        }
        return false;
    }

    private boolean is時間範囲が0000以上2359以内(RString timeStr) {
        RString hour = timeStr.substring(0, 2);
        RString minute = timeStr.substring(2, 4);

        if (is文字列が指定範囲内(new RString("00"), hour, new RString("23"))) {
            if (is文字列が指定範囲内(new RString("00"), minute, new RString("59"))) {
                return true;
            }
        }
        return false;
    }

    private boolean is文字列が指定範囲内(RString from, RString check対象, RString to) {
        return (0 <= check対象.compareTo(from)) && (check対象.compareTo(to) <= 0);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + timeStr.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeString other = (TimeString) obj;
        if (!Objects.equals(this.timeStr, other.timeStr)) {
            return false;
        }
        return true;
    }

    @Override
    public RString value() {
        return timeStr;
    }

    @Override
    public int compareTo(TimeString 比較対象) {
        return timeStr.compareTo(比較対象.value());
    }
}
