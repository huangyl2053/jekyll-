/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2110001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110001.TokuchoSofuJohoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBBGM82001_1_特徴送付情報作成の仕様クラスです。
 *
 * @reamsid_L DBB-1840-010 zhangrui
 */
public enum TokuchoSofuJohoSakuseiSpec implements IPredicate<TokuchoSofuJohoSakuseiDiv> {

    /**
     * 処理対象月必須チェック
     */
    処理対象月 {
                @Override
                public boolean apply(TokuchoSofuJohoSakuseiDiv div) {
                    return SpecHelper.check処理対象月(div);
                }
            };

    private static class SpecHelper {

        private static final RString 対象月_1月 = new RString("1月");
        private static final RString 対象月_2月 = new RString("2月");
        private static final RString 対象月_3月 = new RString("3月");
        private static final RString 対象月_4月 = new RString("4月");
        private static final RString 対象月_5月 = new RString("5月");
        private static final RString 対象月_6月 = new RString("6月");
        private static final RString 対象月_7月 = new RString("7月");
        private static final RString 対象月_8月 = new RString("8月");
        private static final RString 対象月_9月 = new RString("9月");
        private static final RString 対象月_10月 = new RString("10月");
        private static final RString 対象月_11月 = new RString("11月");
        private static final RString 対象月_12月 = new RString("12月");

        /**
         * 処理対象月が未選択の場合、エラー
         *
         * @param div TokuchoSofuJohoSakuseiDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check処理対象月(TokuchoSofuJohoSakuseiDiv div) {
            return !RString.isNullOrEmpty(get処理対象月(div));
        }

        private static RString get処理対象月(TokuchoSofuJohoSakuseiDiv div) {
            RString 処理対象月 = RString.EMPTY;
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku01().isAllSelected()) {
                処理対象月 = 対象月_1月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku02().isAllSelected()) {
                処理対象月 = 対象月_2月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku03().isAllSelected()) {
                処理対象月 = 対象月_3月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku04().isAllSelected()) {
                処理対象月 = 対象月_4月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku05().isAllSelected()) {
                処理対象月 = 対象月_5月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku06().isAllSelected()) {
                処理対象月 = 対象月_6月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku07().isAllSelected()) {
                処理対象月 = 対象月_7月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku08().isAllSelected()) {
                処理対象月 = 対象月_8月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku09().isAllSelected()) {
                処理対象月 = 対象月_9月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku10().isAllSelected()) {
                処理対象月 = 対象月_10月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku11().isAllSelected()) {
                処理対象月 = 対象月_11月;
            }
            if (div.getTbldgTokuchoIdoJoho().getChkSentaku12().isAllSelected()) {
                処理対象月 = 対象月_12月;
            }
            return 処理対象月;
        }
    }
}
