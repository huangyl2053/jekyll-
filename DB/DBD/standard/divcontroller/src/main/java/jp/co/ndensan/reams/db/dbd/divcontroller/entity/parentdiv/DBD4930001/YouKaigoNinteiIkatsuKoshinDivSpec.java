/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4930001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *要介護認定一括更新のバリデーションクラスです。
 * @reamsid_L DBD-2120-010 x_liuwei
 */
public enum YouKaigoNinteiIkatsuKoshinDivSpec implements IPredicate<YouKaigoNinteiIkatsuKoshinDiv>{
    /**
     * 認定日チェック。
     */
    認定日チェック {
        @Override
        public boolean apply(YouKaigoNinteiIkatsuKoshinDiv div) {
            if(div.getTxtNinteibi().isDisabled()){
                return true;
            }
            RDate inputDate = div.getTxtNinteibi().getValue();
            RDate currDate = RDate.getNowDate();
            currDate = currDate.plusDay(60);
            if(inputDate.isBeforeOrEquals(currDate)){
                return true;
            }
            return false;
        }
    }
    
    
}
