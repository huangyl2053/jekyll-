/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1140011;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011.ShotokuJohoTorokuTotalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShotokuJohoTorokuTotalDiv}の仕様クラスです。
 *
 * {@link ShotokuJohoTorokuTotalDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBB-1750-010 zhangrui
 */
public enum ShotokuJohoTorokuSpec implements IPredicate<ShotokuJohoTorokuTotalDiv> {

    /**
     * 住民税非課税区分必須チェック
     */
    住民税非課税区分 {
                @Override
                public boolean apply(ShotokuJohoTorokuTotalDiv div) {
                    return SpecHelper.check住民税非課税区分(div);
                }
            },
    /**
     * 合計所得金額が125万以上必須チェック
     */
    合計所得金額 {
                @Override
                public boolean apply(ShotokuJohoTorokuTotalDiv div) {
                    return SpecHelper.check合計所得金額(div);
                }
            },
    /**
     * 生年月日必須チェック
     */
    生年月日 {
                @Override
                public boolean apply(ShotokuJohoTorokuTotalDiv div) {
                    return SpecHelper.check生年月日(div);
                }
            },
    /**
     * 激変緩和対象者となっていない人必須チェック
     */
    激変緩和対象者となっていない人 {
                @Override
                public boolean apply(ShotokuJohoTorokuTotalDiv div) {
                    return SpecHelper.check激変緩和対象者となっていない人(div);
                }
            },
    /**
     * 年金収入額必須チェック
     */
    年金収入額 {
                @Override
                public boolean apply(ShotokuJohoTorokuTotalDiv div) {
                    return SpecHelper.check年金収入額(div);
                }
            };

    private static class SpecHelper {

        private static final RString 激変緩和措置区分_対象者 = new RString("対象者");
        private static final RString 激変緩和措置区分_なし = new RString("なし");
        private static final RString 住民税非課税区分_課税 = new RString("課税");
        private static final Decimal 金額_125万 = new Decimal(1250000);
        private static final FlexibleDate 分割生年月日 = new FlexibleDate("19400102");

        /**
         * 確定するボタンを押下と、激変緩和措置区分が対象者、かつ、住民税非課税区分ドロプダウンリストの選択値が「課税以外」の場合、エラーとする
         *
         * @param div ShotokuJohoTorokuTotalDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check住民税非課税区分(ShotokuJohoTorokuTotalDiv div) {
            return !(div.getShotokuJohoToroku().getDdlGekihenKanwa().getSelectedValue().equals(激変緩和措置区分_対象者)
                    && !div.getShotokuJohoToroku().getDdlJuminzei().getSelectedValue().equals(住民税非課税区分_課税));
        }

        /**
         * 確定するボタンを押下と、激変緩和措置区分が対象者、かつ、合計所得金額が125万より大きい時、エラーとする
         *
         * @param div ShotokuJohoTorokuTotalDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check合計所得金額(ShotokuJohoTorokuTotalDiv div) {
            return !(div.getShotokuJohoToroku().getDdlGekihenKanwa().getSelectedValue().equals(激変緩和措置区分_対象者)
                    && (div.getShotokuJohoToroku().getTxtGokeiShotokuGaku().getValue().compareTo(金額_125万) > 0));
        }

        /**
         * 確定するボタンを押下と、激変緩和措置区分が対象者、かつ、生年月日が1940/01/02より大きい時、エラーとする
         *
         * @param div ShotokuJohoTorokuTotalDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check生年月日(ShotokuJohoTorokuTotalDiv div) {
            FlexibleDate 生年月日 = div.getAtenaInfo().getKaigoAtenaInfo().getShokaiData().getTxtSeinengappiYMD().getValue();
            return !(div.getShotokuJohoToroku().getDdlGekihenKanwa().getSelectedValue().equals(激変緩和措置区分_対象者)
                    && (分割生年月日.compareTo(生年月日) < 0));
        }

        /**
         * 確定するボタンを押下と、激変緩和措置区分が「なし」、かつ、住民税非課税区分ドロプダウンリストの選択値が「課税」、かつ、
         *
         * 画面．生年月日≦「19400102」、かつ、合計所得金額が125万円以下の場合、警告とする
         *
         * @param div ShotokuJohoTorokuTotalDiv
         * @return 「false」警告 「true」正常
         */
        public static boolean check激変緩和対象者となっていない人(ShotokuJohoTorokuTotalDiv div) {
            FlexibleDate 生年月日 = div.getAtenaInfo().getKaigoAtenaInfo().getShokaiData().getTxtSeinengappiYMD().getValue();
            return !(div.getShotokuJohoToroku().getDdlGekihenKanwa().getSelectedValue().equals(激変緩和措置区分_なし)
                    && div.getShotokuJohoToroku().getDdlJuminzei().getSelectedValue().equals(住民税非課税区分_課税)
                    && (分割生年月日.compareTo(生年月日) > 0)
                    && (div.getShotokuJohoToroku().getTxtGokeiShotokuGaku().getValue().compareTo(金額_125万) < 0));
        }

        /**
         * 確定するボタンを押下と、（年金所得額≠0、または、年金収入額≠０）、かつ、（年金所得額　≧　年金収入額）の場合、警告とする
         *
         * @param div ShotokuJohoTorokuTotalDiv
         * @return 「false」警告 「true」正常
         */
        public static boolean check年金収入額(ShotokuJohoTorokuTotalDiv div) {
            Decimal 年金所得額 = new Decimal(div.getShotokuJohoToroku().getTxtNenkinShotokuGaku().getText().toString());
            Decimal 年金収入額 = new Decimal(div.getShotokuJohoToroku().getTxtNenkinShunyuGaku().getText().toString());
            return !((!Decimal.ZERO.equals(年金所得額) || !Decimal.ZERO.equals(年金収入額)) && (年金所得額.compareTo(年金収入額) >= 0));
        }

    }

}
