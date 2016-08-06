/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0260011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260011.KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者訂正連絡票登録（対象者検索）の入力チェックSpecです。
 *
 * @reamsid_L DBC-1951-010 wangkanglei
 */
public enum KyodoIdoRenrakuhyoTaishoshaKensakuMainSpec implements IPredicate<KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv> {

    /**
     * 異動日と被保番号の関連チェックです。
     */
    異動日と被保番号の関連チェック {
                @Override
                public boolean apply(KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
                    return SpecHelper.is異動日と被保番号の関連チェック(div);
                }
            };

    private static class SpecHelper {

        public static boolean is異動日と被保番号の関連チェック(KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
            RString 被保険者番号 = div.getTxtSearchHihokenshaNo().getValue();
            RDate 異動日From = div.getTxtSearchIdoYMD().getFromValue();
            RDate 異動日To = div.getTxtSearchIdoYMD().getToValue();
            return !((被保険者番号 == null || 被保険者番号.isEmpty())
                    && 異動日From == null
                    && 異動日To == null);
        }
    }
}
