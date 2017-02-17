/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 */
public final class NinteiShinseiKubunHoreiCalculator {

    private NinteiShinseiKubunHoreiCalculator() {
    }

    private static final int 更新申請可能日数 = 61;

    /**
     *
     * @param 申請時の申請区分
     * @param 前回二次判定
     * @param 前回有効期間終了日
     * @param 今回二次判定
     * @param 申請日
     * @return
     */
    @CheckForNull
    public static NinteiShinseiKubunHorei calculate(
            NinteiShinseiKubunShinsei 申請時の申請区分,
            YokaigoJotaiKubun09 前回二次判定,
            FlexibleDate 前回有効期間終了日,
            YokaigoJotaiKubun09 今回二次判定,
            FlexibleDate 申請日) {
        return (申請時の申請区分 == NinteiShinseiKubunShinsei.新規申請) ? get申請区分法令At新規申請(今回二次判定)
                : (申請時の申請区分 == NinteiShinseiKubunShinsei.更新申請) ? get申請区分法令At更新申請(前回二次判定, 今回二次判定)
                        : (申請時の申請区分 == NinteiShinseiKubunShinsei.区分変更申請) ? get申請区分法令At区分変更申請(前回二次判定, 今回二次判定, 申請日, 前回有効期間終了日)
                                : null;
    }

    private static NinteiShinseiKubunHorei get申請区分法令At区分変更申請(
            YokaigoJotaiKubun09 前回二次判定結果,
            YokaigoJotaiKubun09 今回二次判定結果,
            FlexibleDate 申請日,
            FlexibleDate 前回有効期間終了日) {
        if (前回二次判定結果 == null || 今回二次判定結果 == null) {
            return null;
        }
        if (前回二次判定結果 == 今回二次判定結果) {
            if (申請日.plusDay(更新申請可能日数).isBeforeOrEquals(前回有効期間終了日)) {
                return NinteiShinseiKubunHorei.区分変更申請;
            }
            return NinteiShinseiKubunHorei.更新申請;
        }
        if (前回二次判定結果.is要支援() && 今回二次判定結果.is要支援()) {
            return NinteiShinseiKubunHorei.区分変更申請;
        }
        if (前回二次判定結果.is要支援() && 今回二次判定結果.is要介護()) {
            return NinteiShinseiKubunHorei.新規申請;
        }
        if (前回二次判定結果.is要介護() && 今回二次判定結果.is要介護()) {
            return NinteiShinseiKubunHorei.区分変更申請;
        }
        if (前回二次判定結果.is要介護() && 今回二次判定結果.is要支援()) {
            return NinteiShinseiKubunHorei.新規申請;
        }
        return null;
    }

    private static NinteiShinseiKubunHorei get申請区分法令At更新申請(
            YokaigoJotaiKubun09 前回二次判定結果,
            YokaigoJotaiKubun09 今回二次判定結果) {
        if (前回二次判定結果 == null || 今回二次判定結果 == null) {
            return null;
        }
        if (前回二次判定結果.is要支援() && 今回二次判定結果.is要支援()) {
            return NinteiShinseiKubunHorei.更新申請;
        }
        if (前回二次判定結果.is要支援() && 今回二次判定結果.is要介護()) {
            return NinteiShinseiKubunHorei.新規申請;
        }
        if (前回二次判定結果.is要介護() && 今回二次判定結果.is要介護()) {
            return NinteiShinseiKubunHorei.更新申請;
        }
        if (前回二次判定結果.is要介護() && 今回二次判定結果.is要支援()) {
            return NinteiShinseiKubunHorei.新規申請;
        }
        return null;
    }

    private static NinteiShinseiKubunHorei get申請区分法令At新規申請(YokaigoJotaiKubun09 今回二次判定結果) {
        if (今回二次判定結果 == null) {
            return null;
        }
        return NinteiShinseiKubunHorei.新規申請;
    }
}
