/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1170001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1170001.ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 画面設計_DBBGM51001_所得照会状況一覧の仕様クラスです。
 *
 * @reamsid_L DBB-1700-010 zhangrui
 */
public enum ShotokuShokaiTaishoshaIchiranSpec implements IPredicate<ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv> {

    /**
     * 抽出基準年度必須チェック
     */
    抽出基準年度 {
                @Override
                public boolean apply(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
                    return SpecHelper.check抽出基準年度(div);
                }
            },
    /**
     * 抽出期間FROM年月日必須チェック
     */
    抽出期間FROM年月日 {
                @Override
                public boolean apply(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
                    return SpecHelper.check抽出期間FROM年月日(div);
                }
            },
    /**
     * 抽出期間FROM時分秒必須チェック
     */
    抽出期間FROM時分秒 {
                @Override
                public boolean apply(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
                    return SpecHelper.check抽出期間FROM時分秒(div);
                }
            },
    /**
     * 抽出期間TO年月日必須チェック
     */
    抽出期間TO年月日 {
                @Override
                public boolean apply(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
                    return SpecHelper.check抽出期間TO年月日(div);
                }
            },
    /**
     * 抽出期間TO時分秒必須チェック
     */
    抽出期間TO時分秒 {
                @Override
                public boolean apply(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
                    return SpecHelper.check抽出期間TO時分秒(div);
                }
            },
    /**
     * 日付関係チェック
     */
    日付関係 {
                @Override
                public boolean apply(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
                    return SpecHelper.check日付関係(div);
                }
            };

    private static class SpecHelper {

        /**
         * 抽出基準年度がEmptyの場合、エラー
         *
         * @param div ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check抽出基準年度(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
            return null != div.getTxtChushutsuKijunNendo().getDomain();
        }

        /**
         * 抽出期間（FROM）　年月日がEmptyの場合、エラー
         *
         * @param div ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check抽出期間FROM年月日(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
            return null != div.getTxtChushutsuStYMD().getValue();
        }

        /**
         * 抽出期間（FROM）　時分秒がEmptyの場合、エラー
         *
         * @param div ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check抽出期間FROM時分秒(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
            return null != div.getTxtChushutsuStTime().getValue();
        }

        /**
         * 抽出期間（TO）　年月日がEmptyの場合、エラー
         *
         * @param div ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check抽出期間TO年月日(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
            return null != div.getTxtChushutsuEdYMD().getValue();
        }

        /**
         * 抽出期間（TO）　時分秒がEmptyの場合、エラー
         *
         * @param div ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check抽出期間TO時分秒(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
            return null != div.getTxtChushutsuEdTime().getValue();
        }

        /**
         * 抽出期間（FROM）年月日 + 抽出期間（FROM）時分秒＞抽出期間（TO）年月日+抽出期間（TO）時分秒の場合、エラー
         *
         * @param div ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check日付関係(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
            RDate 期間FROM年月日 = div.getTxtChushutsuStYMD().getValue();
            RTime 期間FROM時分秒 = div.getTxtChushutsuStTime().getValue();
            RDate 期間TO年月日 = div.getTxtChushutsuEdYMD().getValue();
            RTime 期間TO時分秒 = div.getTxtChushutsuEdTime().getValue();
            if (null == 期間FROM年月日 || null == 期間FROM時分秒 || null == 期間TO年月日 || null == 期間TO時分秒) {
                return true;
            }
            RDateTime from = RDateTime.of(期間FROM年月日.getYearValue(), 期間FROM年月日.getMonthValue(), 期間FROM年月日.getDayValue(),
                    期間FROM時分秒.getHour(), 期間FROM時分秒.getMinute(), 期間FROM時分秒.getSecond());
            RDateTime to = RDateTime.of(期間TO年月日.getYearValue(), 期間TO年月日.getMonthValue(), 期間TO年月日.getDayValue(),
                    期間TO時分秒.getHour(), 期間TO時分秒.getMinute(), 期間TO時分秒.getSecond());
            return from.isBefore(to) || from.isEqual(to);
        }
    }

}
