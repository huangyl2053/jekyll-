/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.JuchochiTokureiKaijo;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author LDNS chenty
 */
public enum JuchochiTokureiKaijoSpec implements IPredicate<JushochitokureiKaijo> {

    解除日が資格取得年月日より前 {
                @Override
                public boolean apply(JushochitokureiKaijo NOTHING) {
                    FlexibleDate target = NOTHING.newestHihokenshaDaicho().get資格取得年月日();
                    if (target == null || target.isEmpty()) {
                        return false;
                    }
                    final FlexibleDate kaijoDate = NOTHING.kaijoDate();
                    return kaijoDate.isBefore(target);
                }
            },
    最新の資格変更年月日がNullでないこと {

                @Override
                public boolean apply(JushochitokureiKaijo NOTHING) {
                    FlexibleDate target = NOTHING.newestHihokenshaDaicho().get資格変更年月日();
                    if (target == null || target.isEmpty()) {
                        return false;
                    }
                    final FlexibleDate kaijoDate = NOTHING.kaijoDate();
                    return kaijoDate.isBefore(target);
                }
            },
    最新の適用年月日がNullでないこと {

                @Override
                public boolean apply(JushochitokureiKaijo NOTHING) {
                    FlexibleDate target = NOTHING.newestHihokenshaDaicho().get適用年月日();
                    if (target == null || target.isEmpty()) {
                        return false;
                    }
                    final FlexibleDate kaijoDate = NOTHING.kaijoDate();
                    return kaijoDate.isBefore(target);
                }
            },
}
