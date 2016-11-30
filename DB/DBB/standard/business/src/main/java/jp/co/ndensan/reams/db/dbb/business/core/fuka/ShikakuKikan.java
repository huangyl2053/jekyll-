/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 資格期間を判定クラスです。
 *
 * @reamsid_L DBB-9040-040 wangxiaodong
 */
public class ShikakuKikan {

    private static final int 賦課年度末月 = 3;
    private static final int 賦課年度初月 = 4;
    private static final int 月の末日 = 31;
    private static final int 年の末月 = 12;

    /**
     * 賦課年度、資格取得日、資格喪失日　から、その年度内の資格期間(開始日、終了日、月数)を判定します。
     *
     * @param 賦課年度 賦課年度
     * @param 資格取得日 資格取得日
     * @param 資格喪失日 資格喪失日
     * @return 資格期間情報
     * @throws IllegalArgumentException
     */
    public ShikakuKikanJoho get資格期間(FlexibleYear 賦課年度, FlexibleDate 資格取得日, FlexibleDate 資格喪失日) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(資格取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得日"));

        FlexibleDate 賦課年度末日 = new FlexibleDate(賦課年度.getYearValue() + 1, 賦課年度末月, 月の末日);
        FlexibleDate 賦課年度初日 = new FlexibleDate(賦課年度.getYearValue(), 賦課年度初月, 1);

        if (賦課年度末日.isBefore(資格取得日) || (資格喪失日 != null && !資格喪失日.isEmpty()
                && 資格喪失日.isBefore(賦課年度初日))) {
            throw new IllegalArgumentException(UrErrorMessages.期間が不正.toString());
        }
        ShikakuKikanJoho 資格期間 = new ShikakuKikanJoho();
        if (資格喪失日 != null && !資格喪失日.isEmpty() && 資格取得日.getMonthValue() == 資格喪失日.getMonthValue()) {
            set資格期間(資格期間);
        } else {
            set資格期間開始日(資格取得日, 賦課年度初日, 資格期間);
            set資格期間終了日(資格喪失日, 賦課年度末日, 資格期間);
            資格期間.set月数(資格期間.get資格期間終了日().getBetweenMonths(資格期間.get資格期間開始日()) + 1);
        }
        return 資格期間;
    }

    private void set資格期間(ShikakuKikanJoho 資格期間) {

        資格期間.set資格期間開始日(FlexibleDate.EMPTY);
        資格期間.set資格期間終了日(FlexibleDate.EMPTY);
        資格期間.set月数(0);
    }

    private void set資格期間開始日(FlexibleDate 資格取得日, FlexibleDate 賦課年度初日, ShikakuKikanJoho 資格期間) {

        if (資格取得日.isBeforeOrEquals(賦課年度初日)) {
            資格期間.set資格期間開始日(賦課年度初日);
        } else {
            資格期間.set資格期間開始日(new FlexibleDate(資格取得日.getYearValue(), 資格取得日.getMonthValue(), 1));
        }
    }

    private void set資格期間終了日(FlexibleDate 資格喪失日, FlexibleDate 賦課年度末日, ShikakuKikanJoho 資格期間) {

        if ((資格喪失日 == null || 資格喪失日.isEmpty()) || 賦課年度末日.isBefore(資格喪失日)) {
            資格期間.set資格期間終了日(賦課年度末日);
        } else {
            資格期間.set資格期間終了日(get前月末日(資格喪失日));
        }
    }

    private FlexibleDate get前月末日(FlexibleDate 資格喪失日) {
        int 年 = 資格喪失日.getYearValue();
        int 月 = 資格喪失日.getMonthValue();

        if (資格喪失日.getMonthValue() == 1) {
            return new FlexibleDate(年 - 1, 年の末月, 月の末日);
        } else {
            return new FlexibleDate(年, 月 - 1,
                    new FlexibleDate(年, 月 - 1, 1).getYearMonth().getLastDay());
        }
    }
}
