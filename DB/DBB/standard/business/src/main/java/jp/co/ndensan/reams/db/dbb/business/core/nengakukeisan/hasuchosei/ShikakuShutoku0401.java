/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 資格取得日が4月1日か判定クラスです。
 *
 * @author n3336
 */
public class ShikakuShutoku0401 implements IHasuChoseiHantei {

    @Override
    public boolean judgeHasuu(NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter) {

        FlexibleDate 年度開始日 = new FlexibleDate(nengakuHokenryoKeisanParameter.get賦課年度() + "0401");
        FlexibleDate 年度終了日 = new FlexibleDate(String.valueOf(Integer.parseInt(String.valueOf(
                nengakuHokenryoKeisanParameter.get賦課年度())) + 1) + "0331");

        boolean 資格取得日が4月1日か判定;
        if (nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格取得日() == null) {
            資格取得日が4月1日か判定 = false;
            return 資格取得日が4月1日か判定;
        }

        FlexibleDate 資格取得日 = nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格取得日();
        if (!資格取得日.isBeforeOrEquals(年度開始日) && 資格取得日.isBeforeOrEquals(年度終了日)) {
            資格取得日が4月1日か判定 = true;
            return 資格取得日が4月1日か判定;
        }

        資格取得日が4月1日か判定 = false;
        return 資格取得日が4月1日か判定;

    }

}
