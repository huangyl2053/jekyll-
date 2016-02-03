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
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 資格期間のクラス。
 */
public class ShikakuKikan {

    public void get資格期間(FlexibleYear 賦課年度, FlexibleDate 資格取得日, FlexibleDate 資格喪失日,
            FlexibleDate 資格期間開始日, FlexibleDate 資格期間終了日, int 月数) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(資格取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得日"));
        if (資格取得日.isBeforeOrEquals(new FlexibleDate(Integer.parseInt(賦課年度.seireki().getYear().toString()), 3, 31))
                || (資格喪失日 != null && 資格喪失日.isEmpty()
                && new FlexibleDate(Integer.parseInt(賦課年度.seireki().getYear().toString()), 4, 1).isBeforeOrEquals(資格喪失日))) {
            throw new IllegalArgumentException(UrErrorMessages.不正.toString());
        }

        RString 資格取得日の月 = 資格取得日.seireki().getMonth();
        RString 資格喪失日の月 = 資格喪失日.seireki().getMonth();

        if (資格取得日の月.equals(資格喪失日の月)) {
            資格期間開始日 = FlexibleDate.EMPTY;
            資格期間終了日 = FlexibleDate.EMPTY;
            月数 = 0;
        } else {

            if (new FlexibleDate(Integer.parseInt(賦課年度.seireki().getYear().toString()), 4, 1).isBefore(資格喪失日)) {
                資格期間開始日 = new FlexibleDate(Integer.parseInt(賦課年度.seireki().getYear().toString()), 4, 1);
            } else {
                資格期間開始日 = new FlexibleDate(Integer.parseInt(資格取得日.seireki().getYear().toString()),
                        Integer.parseInt(資格取得日.seireki().getMonth().toString()), 1);
            }

            if (資格喪失日 == null || 資格喪失日.isEmpty()) {
                資格期間終了日 = new FlexibleDate(Integer.parseInt(賦課年度.seireki().getYear().toString()), 3, 31);
            } else if (資格喪失日.isBeforeOrEquals(new FlexibleDate(Integer.parseInt(賦課年度.seireki().getYear().toString()), 3, 31))) {
                資格期間終了日 = new FlexibleDate(Integer.parseInt(賦課年度.seireki().getYear().toString()), 4, 1);
            } else {
                資格期間終了日 = get前月末日(資格喪失日);
            }
            // TODO 袁献輝　月数は実装なし。
            月数 = get月数(資格期間開始日, 資格期間終了日);
        }
    }

    private FlexibleDate get前月末日(FlexibleDate 資格喪失日) {
        FlexibleDate 月の前月末日 = null;
        int 月 = Integer.parseInt(資格喪失日.seireki().getMonth().toString());
        int 年 = Integer.parseInt(資格喪失日.seireki().getYear().toString());
        if (月 == 3) {
            if (年 / 4 == 0) {
                月の前月末日 = new FlexibleDate(Integer.parseInt(資格喪失日.seireki().getYear().toString()), 月 - 1, 29);
            } else {
                月の前月末日 = new FlexibleDate(Integer.parseInt(資格喪失日.seireki().getYear().toString()), 月 - 1, 28);
            }
        } else if (月 == 2) {
            月の前月末日 = new FlexibleDate(Integer.parseInt(資格喪失日.seireki().getYear().toString()), 月 - 1, 31);
        } else if (月 == 1) {
            月の前月末日 = new FlexibleDate(Integer.parseInt(資格喪失日.seireki().getYear().toString()) - 1, 12, 31);
        }
        return 月の前月末日;
    }

    private int get月数(FlexibleDate 資格期間開始日, FlexibleDate 資格期間終了日) {
        int 月数 = 0;

        return 月数;
    }
}
