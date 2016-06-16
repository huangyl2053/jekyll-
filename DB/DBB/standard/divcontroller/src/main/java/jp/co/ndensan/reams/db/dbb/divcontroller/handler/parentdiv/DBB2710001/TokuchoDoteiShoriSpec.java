/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001.TokuchoDoteiShoriDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 画面設計_DBBGM81002_1_特徴対象者同定（一括）の仕様クラスです
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public enum TokuchoDoteiShoriSpec implements IPredicate<TokuchoDoteiShoriDiv> {

    /**
     * 処理続行不可
     */
    処理続行不可 {
                @Override
                public boolean apply(TokuchoDoteiShoriDiv div) {
                    return SpecHelper.check処理続行不可(div);
                }
            };

    private static class SpecHelper {

        /**
         * 処理対象月が未選択の場合、エラー
         *
         * @param div TokuchoSofuJohoSakuseiDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check処理続行不可(TokuchoDoteiShoriDiv div) {
            return false;
        }

    }
}
