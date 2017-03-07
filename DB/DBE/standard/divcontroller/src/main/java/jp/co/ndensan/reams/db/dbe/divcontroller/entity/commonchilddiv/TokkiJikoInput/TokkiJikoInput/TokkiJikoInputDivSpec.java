/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public enum TokkiJikoInputDivSpec implements IPredicate<TokkiJikoInputDiv> {
    
    特記事項日の非空チェック {
                /**
                 * 特記事項の非空チェックです。
                 *
                 * @param div TokkiJikoInputDiv
                 * @return true:特記事項が非空です、false:特記事項が空です。
                 */
                @Override
                public boolean apply(TokkiJikoInputDiv div) {
                    return !RString.isNullOrEmpty(div.getTokkiJikoNyuryoku().getTxtTokkiJiko().getValue());
                }
            }
}
