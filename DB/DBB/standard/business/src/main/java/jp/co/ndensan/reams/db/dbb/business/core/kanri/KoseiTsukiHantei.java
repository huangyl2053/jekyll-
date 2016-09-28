/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanri;

import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.SuitoSeiriTaishoNendo;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ZogakuGengakuKubun;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiHyoki;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.TsukiShorkiKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更正月判定のクラスです。
 *
 * @reamsid_L DBB-9020-050 sunhaidi
 */
public class KoseiTsukiHantei {

    private static final RString 開始日 = new RString("0301");
    private static final RString 終了日 = new RString("0531");

    /**
     * パラメータに渡された日付が該当する更正月、期を判定し返します。
     *
     * @param 指定日 年月日
     * @return 期月
     * @throws NullPointerException 入力.指定日 がnull の場合、NullPointerExceptionをスローする。
     */
    public Kitsuki find更正月(RDate 指定日) {

        Objects.requireNonNull(指定日);
        Tsuki 月 = get月(指定日);
        if (Tsuki.翌年度4月.equals(月)) {
            Kitsuki kitsuki = new FuchoKiUtil(new FlexibleYear(指定日.getYear().toDateString())).get期月リスト().get月の期(Tsuki.翌年度4月);
            if (kitsuki.isPresent()) {
                return kitsuki;
            } else {
                return new KanendoKiUtil(new FlexibleYear(指定日.getYear().toDateString()).plusYear(1)).get期月リスト().get月の期(Tsuki._4月);
            }

        } else {
            return new FuchoKiUtil(new FlexibleYear(指定日.getYear().toDateString())).get期月リスト().get月の期(月);
        }
    }

    /**
     * パラメータに渡された日付が該当する更正月、期を判定し返します。
     *
     * @param 指定日 年月日
     * @param 増額減額区分 増額減額区分
     * @return 期月
     * @throws NullPointerException 入力.年月日 または 増額減額区分 がnull の場合、NullPointerExceptionをスローする。
     */
    public Kitsuki find更正月(RDate 指定日, ZogakuGengakuKubun 増額減額区分) {
        Objects.requireNonNull(指定日);
        Objects.requireNonNull(増額減額区分);
        RDate 指定開始日 = new RDate(指定日.getYear().toString() + 開始日);
        RDate 指定終了日 = new RDate(指定日.getYear().toString() + 終了日);
        if (!(指定開始日.isBeforeOrEquals(指定日) && 指定日.isBeforeOrEquals(指定終了日))) {
            throw new IllegalArgumentException();
        }
        Kitsuki kitsuki = find更正月(指定日);
        if (!(Tsuki._3月.equals(kitsuki.get月()) || Tsuki._4月.equals(kitsuki.get月()) || Tsuki._5月.equals(kitsuki.get月()))) {
            throw new IllegalArgumentException();
        } else if (Tsuki._3月.equals(kitsuki.get月())) {
            return kitsuki;
        }
        SuitoSeiriTaishoNendo 出納整理対象年度 = new GennenZuijiHantei().get出納整理対象年度(kitsuki.get月());
        Tsuki 月 = kitsuki.get月();
        if (Tsuki._4月.equals(月)) {
            月 = Tsuki.翌年度4月;
        } else if (Tsuki._5月.equals(月)) {
            月 = Tsuki.翌年度5月;
        }
        if (SuitoSeiriTaishoNendo.現年度_増額減額.equals(出納整理対象年度)
                || (SuitoSeiriTaishoNendo.現年度_減額のみ.equals(出納整理対象年度)
                && ZogakuGengakuKubun.減額更正.equals(増額減額区分))) {
            RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            return new FuchoKiUtil(new FlexibleYear(調定年度).minusYear(1)).get期月リスト().get月の期(月);
        } else if ((SuitoSeiriTaishoNendo.現年度_減額のみ.equals(出納整理対象年度)
                && ZogakuGengakuKubun.増額更正.equals(増額減額区分))
                || SuitoSeiriTaishoNendo.過年度_増額減額.equals(出納整理対象年度)) {
            return new FuchoKiUtil().get期月リスト().get月の期(月);
        }

        return new Kitsuki(Tsuki._4月, RString.EMPTY, TsukiShorkiKubun.デフォルト, false, KitsukiHyoki.EMPTY);
    }

    /**
     * パラメータに渡された日付が該当する普徴過年度期の更正月、期を判定し、返します。
     *
     * @param 指定日 年月日
     * @return 期月
     * @throws NullPointerException 入力.指定日 がnull の場合、NullPointerExceptionをスローする。
     */
    public Kitsuki find過年度更正月(RDate 指定日) {
        Objects.requireNonNull(指定日);
        Tsuki 月 = get月(指定日);
        if (Tsuki.翌年度4月.equals(月)) {
            return new KanendoKiUtil(new FlexibleYear(指定日.getYear().toDateString()).plusYear(1)).get期月リスト().get月の期(Tsuki._4月);
        } else {
            return new KanendoKiUtil(new FlexibleYear(指定日.getYear().toDateString())).get期月リスト().get月の期(月);
        }
    }

    private Tsuki get月(RDate 指定日) {
        RString 更正月判定日数 = DbBusinessConfig.get(ConfigNameDBB.日付関連_更正月判定日数, 指定日, SubGyomuCode.DBB介護賦課);

        int dayValue = 指定日.getDayValue();
        int lastDay = 指定日.getLastDay();
        int 日数 = lastDay - dayValue + 1;
        Tsuki 月;
        int monthValue = 指定日.getMonthValue();
        if (Integer.parseInt(更正月判定日数.toString()) < 日数) {

            月 = Tsuki.toValue(new RString(String.valueOf(monthValue)).padLeft(new RString("0"), 2));
        } else {
            if (monthValue == Month.MARCH.getValue()) {
                月 = Tsuki.翌年度4月;
            } else {
                月 = Tsuki.toValue(new RString(String.valueOf(monthValue + 1)).padLeft(new RString("0"), 2));
            }
        }
        return 月;
    }

    /**
     * パラメータに渡された日付が該当する更正月、期を判定し返します。<BR>
     * 仮算定期間中の日付が渡された場合、本算定第１期の月・期を返します。
     *
     * @param 指定日 年月日
     * @return 期月
     * @throws NullPointerException 入力.指定日 がnull の場合、NullPointerExceptionをスローする。
     */
    public Kitsuki find更正月_本算定期(RDate 指定日) {
        Objects.requireNonNull(指定日);
        Kitsuki kitsuki = find更正月(指定日);
        RString 普徴期情報_仮算定期数 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_仮算定期数, 指定日, SubGyomuCode.DBB介護賦課);

        int 本算定第１期 = Integer.parseInt(普徴期情報_仮算定期数.toString()) + 1;
        List<Kitsuki> kitsukiList = new FuchoKiUtil(new FlexibleYear(指定日.getYear().toDateString())).get期月リスト().get期の月(本算定第１期);
        if (本算定第１期 <= kitsuki.get期AsInt()) {
            return kitsuki;
        } else if (!kitsukiList.isEmpty()) {
            return kitsukiList.get(0);
        }
        return new Kitsuki(Tsuki._4月, RString.EMPTY, TsukiShorkiKubun.デフォルト, false, KitsukiHyoki.EMPTY);
    }

    /**
     * パラメータに渡された日付が該当する特別徴収の更正月、期を判定し返します。
     *
     * @param 指定日 年月日
     * @return 期月
     * @throws NullPointerException 入力.指定日 がnull の場合、NullPointerExceptionをスローする。
     */
    public Kitsuki find特徴更正月(RDate 指定日) {
        Objects.requireNonNull(指定日);

        Tsuki tsuki = get月(指定日);
        if (Tsuki.翌年度4月.equals(tsuki) || Tsuki.翌年度5月.equals(tsuki)) {
            return new Kitsuki(Tsuki._4月, RString.EMPTY, TsukiShorkiKubun.デフォルト, false, KitsukiHyoki.EMPTY);
        } else {
            return new FuchoKiUtil(new FlexibleYear(指定日.getYear().toDateString())).get期月リスト().get月の期(tsuki);
        }
    }
}
