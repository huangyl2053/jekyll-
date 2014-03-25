/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体有効期間開始年月日を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiYukoKikanKaishiYMD implements IValueObject<FlexibleDate>, Comparable<GogitaiYukoKikanKaishiYMD> {

    private final FlexibleDate 開始年月日;

    /**
     * 引数から合議体有効期間開始年月日を受け取り、インスタンスを生成します。
     *
     * @param 開始年月日 開始年月日
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public GogitaiYukoKikanKaishiYMD(FlexibleDate 開始年月日) throws NullPointerException {
        this.開始年月日 = requireNonNull(開始年月日, Messages.E00003.replace("開始年月日", getClass().getName()).getMessage());
    }

    /**
     * 引数から年月日を表す文字列を受け取り、インスタンスを生成します。
     *
     * @param 開始年月日 yyyyMMdd形式の年月日
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 8桁以上の文字列が渡されたとき
     */
    public GogitaiYukoKikanKaishiYMD(RString 開始年月日) throws IllegalArgumentException, NullPointerException {
        this(new FlexibleDate(開始年月日));
    }

    /**
     * 引数から年月日を表す文字列を受け取り、インスタンスを生成します。
     *
     * @param 開始年月日 yyyyMMdd形式の年月日
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 8桁以上の文字列が渡されたとき
     */
    public GogitaiYukoKikanKaishiYMD(String 開始年月日) throws IllegalArgumentException, NullPointerException {
        this(new FlexibleDate(開始年月日));
    }

    /**
     * 引数から年、月、日をそれぞれ表す数値を受け取り、インスタンスを生成します。
     *
     * @param year 年
     * @param month 月
     * @param day 日
     * @throws IllegalArgumentException 日付と判断できない数値が渡されたとき
     */
    public GogitaiYukoKikanKaishiYMD(int year, int month, int day) throws IllegalArgumentException {
        this(new FlexibleDate(year, month, day));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + 開始年月日.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((GogitaiYukoKikanKaishiYMD) 比較対象).value().equals(this.value());
    }

    @Override
    public FlexibleDate value() {
        return 開始年月日;
    }

    @Override
    public int compareTo(GogitaiYukoKikanKaishiYMD 比較対象) {
        return 開始年月日.compareTo(比較対象.value());
    }
}
