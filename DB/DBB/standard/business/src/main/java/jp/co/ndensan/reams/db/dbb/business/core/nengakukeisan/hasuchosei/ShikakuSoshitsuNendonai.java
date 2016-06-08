/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 資格喪失日が年度内に存在するか判定
 *
 * @author n3336
 */
class ShikakuSoshitsuNendonai implements IHasuChoseiHantei {

    @Override
    public boolean judgeHasuu(NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter) {

//        Calendar 資格喪失日 = Calendar.getInstance();
//        Calendar 年度開始日 = Calendar.getInstance();
//        Calendar 年度終了日 = Calendar.getInstance();
//
//        年度開始日.set(Integer.parseInt(nengakuHokenryoKeisanParameter.get賦課年度()), 4, 1);
//        年度終了日.set(Integer.parseInt(nengakuHokenryoKeisanParameter.get賦課年度()) + 1, 03, 31);
//
//        年度開始日.set(Calendar.MILLISECOND,0);
//        年度終了日.set(Calendar.MILLISECOND,0);
//
//        if( nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日() == null ){
//            return false;
//        }
//
//        資格喪失日.setTime(nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日());
//
//        if(資格喪失日.after(年度開始日) == true){
//            return true;
//        }
//        return false;
        if (nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日() == null) {
            return false;
        }

        FlexibleDate 年度開始日 = new FlexibleDate(nengakuHokenryoKeisanParameter.get賦課年度() + "0401");
        FlexibleDate 年度終了日 = new FlexibleDate(String.valueOf(Integer.parseInt(String.valueOf(
                nengakuHokenryoKeisanParameter.get賦課年度())) + 1) + "0331");

        boolean 資格喪失日が年度内に存在するか判定;
        if (nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日() == null) {
            資格喪失日が年度内に存在するか判定 = false;
            return 資格喪失日が年度内に存在するか判定;
        }

        if (!nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日().isBeforeOrEquals(年度開始日)
                && nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日().isBeforeOrEquals(年度終了日)) {
            資格喪失日が年度内に存在するか判定 = true;
            return 資格喪失日が年度内に存在するか判定;
        }
        資格喪失日が年度内に存在するか判定 = false;
        return 資格喪失日が年度内に存在するか判定;
    }
}
