/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1211011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1211011.KogakuGassanShikyuKetteiTsuchishoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 画面設計_DBCMN63004_高額合算支給決定通知書（一括）のクラスです。
 *
 * @reamsid_L DBC-2300-010 wangxingpeng
 */
public enum KogakuGassanShikyuKetteiTsuchishoHandlerSpec implements IPredicate<KogakuGassanShikyuKetteiTsuchishoDiv> {

    /**
     * 受取年月チェック
     */
    受取年月チェック {
                @Override
                public boolean apply(KogakuGassanShikyuKetteiTsuchishoDiv div) {
                    return SpecHelper.is受取年月チェック(div);
                }
            },
    /**
     * 申請終了年月日チェック
     */
    申請終了年月日チェック {
                @Override
                public boolean apply(KogakuGassanShikyuKetteiTsuchishoDiv div) {
                    return SpecHelper.is申請終了年月日チェック(div);
                }
            },
    /**
     * 申請開始年月日_申請終了年月日チェック
     */
    申請開始年月日_申請終了年月日チェック {
                @Override
                public boolean apply(KogakuGassanShikyuKetteiTsuchishoDiv div) {
                    return SpecHelper.is申請開始年月日_申請終了年月日チェック(div);
                }
            },
    /**
     * 作成終了年月日チェック
     */
    作成終了年月日チェック {
                @Override
                public boolean apply(KogakuGassanShikyuKetteiTsuchishoDiv div) {
                    return SpecHelper.is作成終了年月日チェック(div);
                }
            },
    /**
     * 作成開始年月日_作成終了年月日チェック
     */
    作成開始年月日_作成終了年月日チェック {
                @Override
                public boolean apply(KogakuGassanShikyuKetteiTsuchishoDiv div) {
                    return SpecHelper.is作成開始年月日_作成終了年月日チェック(div);
                }
            },
    /**
     * 決定予定日
     */
    決定予定日 {
                @Override
                public boolean apply(KogakuGassanShikyuKetteiTsuchishoDiv div) {
                    return SpecHelper.is決定予定日(div);
                }
            };

    private static class SpecHelper {

        public static boolean is受取年月チェック(KogakuGassanShikyuKetteiTsuchishoDiv div) {
            RDate 受取年月 = div.getTxtUketoriYM().getValue();
            return 受取年月 != null;
        }

        public static boolean is申請終了年月日チェック(KogakuGassanShikyuKetteiTsuchishoDiv div) {
            RDate 申請終了年月日 = div.getTxtShinseiYMD().getToValue();
            return 申請終了年月日 != null;
        }

        public static boolean is申請開始年月日_申請終了年月日チェック(KogakuGassanShikyuKetteiTsuchishoDiv div) {
            RDate 申請開始年月日 = div.getTxtShinseiYMD().getFromValue();
            RDate 申請終了年月日 = div.getTxtShinseiYMD().getToValue();
            if (申請開始年月日 == null || 申請終了年月日 == null) {
                return true;
            }
            return !(申請終了年月日.isBefore(申請開始年月日));
        }

        public static boolean is作成終了年月日チェック(KogakuGassanShikyuKetteiTsuchishoDiv div) {
            RDate 作成終了年月日 = div.getTxtKetteiYMD().getToValue();
            return 作成終了年月日 != null;
        }

        public static boolean is作成開始年月日_作成終了年月日チェック(KogakuGassanShikyuKetteiTsuchishoDiv div) {
            RDate 作成開始年月日 = div.getTxtKetteiYMD().getFromValue();
            RDate 作成終了年月日 = div.getTxtKetteiYMD().getToValue();
            if (作成開始年月日 == null || 作成終了年月日 == null) {
                return true;
            }
            return !(作成終了年月日.isBefore(作成開始年月日));
        }

        public static boolean is決定予定日(KogakuGassanShikyuKetteiTsuchishoDiv div) {
            RDate 決定予定日 = div.getTxtKetteiymd().getValue();
            return 決定予定日 != null;
        }
    }
}
