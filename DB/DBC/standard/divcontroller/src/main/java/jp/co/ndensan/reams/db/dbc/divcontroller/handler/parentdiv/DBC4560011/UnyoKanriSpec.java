/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4560011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4560011.UnyoKanriDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * {@link UnyoKanriDiv}の仕様クラスです。 <br> {@link UnyoKanriDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-5820-010 tianshuai
 */
public enum UnyoKanriSpec implements IPredicate<UnyoKanriDiv> {

    /**
     * 変更内容がない。
     */
    変更内容がない {
                @Override
                public boolean apply(UnyoKanriDiv div) {
                    return SpecHelper.is変更内容がない(div);
                }
            };

    private static class SpecHelper {

        /**
         * 変更内容がないです。
         *
         * @param div UnyoKanriDiv
         */
        public static boolean is変更内容がない(UnyoKanriDiv div) {
            if (div.getHdnHonninMishinkokuKubun().equals(div.getDdlHonninMishinkokuKubun().getSelectedKey())
                    && div.getHdnHonninShutokuChosachuKubun().equals(div.getDdlHonninShutokuChosachuKubun().getSelectedKey())
                    && div.getHdnNenjiFutanWariaiShoriJotai().equals(div.getDdlNenjiFutanWariaiShoriJotai().getSelectedKey())) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
    }
}
