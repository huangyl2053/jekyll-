/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.jushochitokureitekiyo;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author LDNS chenty
 */
public enum JuchochiTokureiTekiyoSpec implements IPredicate<JushochitokureiTekiyo> {

    /**
     * 適用日が資格取得年月日より前
     */
    適用日が資格取得年月日より前 {
                @Override
                public boolean apply(JushochitokureiTekiyo nothing) {
                    FlexibleDate target = nothing.getNewestHihokenshaDaicho().get資格取得年月日();
                    if (target == null || target.isEmpty()) {
                        return false;
                    }
                    final FlexibleDate kaijoDate = nothing.getTekiyoDate();
                    return kaijoDate.isBefore(target);
                }
            },
    /**
     * 最新の資格変更年月日がNullでないこと
     */
    最新の資格変更年月日がNullでないこと {

                @Override
                public boolean apply(JushochitokureiTekiyo nothing) {
                    FlexibleDate target = nothing.getNewestHihokenshaDaicho().get資格変更年月日();
                    if (target == null || target.isEmpty()) {
                        return false;
                    }
                    final FlexibleDate kaijoDate = nothing.getTekiyoDate();
                    return kaijoDate.isBefore(target);
                }
            },
    /**
     * 最新の解除年月日がNullでないこと
     */
    最新の解除年月日がNullでないこと {

                @Override
                public boolean apply(JushochitokureiTekiyo nothing) {
                    FlexibleDate target = nothing.getNewestHihokenshaDaicho().get解除年月日();
                    if (target == null || target.isEmpty()) {
                        return false;
                    }
                    final FlexibleDate kaijoDate = nothing.getTekiyoDate();
                    return kaijoDate.isBefore(target);
                }
            },
}
