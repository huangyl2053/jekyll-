/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4520011;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouFinder;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護支援専門員登録画面 のSpecです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public enum KaigoSienSenmonkaTorokuSpec implements IPredicate<KaigoSienSenmonkaTorokuDiv> {

    /**
     * 介護支援専門員番号の重複チェックです。
     */
    介護支援専門員番号の重複チェック {
                @Override
                public boolean apply(KaigoSienSenmonkaTorokuDiv div) {
                    return SpecHelper.is介護支援専門員番号の重複チェック(div);
                }
            };

    /**
     * {@link KaigoSienSenmonkaTorokuSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        public static boolean is介護支援専門員番号の重複チェック(KaigoSienSenmonkaTorokuDiv div) {
            RString 介護支援専門員番号 = div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninBango().getValue();
            KaigoShienSenmoninJouhouParameter param = new KaigoShienSenmoninJouhouParameter();
            param.set介護支援専門員番号(介護支援専門員番号);
            KaigoShienSenmoninJouhouFinder finder = KaigoShienSenmoninJouhouFinder.createInstance();
            return 0 == finder.get介護支援専門員番号の重複チェック(param);
        }
    }
}
