/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * @author n8344
 */
public enum ShinsakaiIinJohoSpec implements IPredicate<ShinsakaiIinJohoTorokuDiv> {
    審査会委員開始日終了日の大小チェック {
                /**
                 * 審査会委員開始日終了日の大小チェック。
                 *
                 * @param div ShinsakaiIinJohoTorokuDiv
                 * @return 
                 */
                @Override
                public boolean apply(ShinsakaiIinJohoTorokuDiv div) {
                    return !div.getTxtShinsaIinYMDTo().getValue().isBefore(div.getTxtShinsaIinYMDFrom().getValue());
                }
            }
}
