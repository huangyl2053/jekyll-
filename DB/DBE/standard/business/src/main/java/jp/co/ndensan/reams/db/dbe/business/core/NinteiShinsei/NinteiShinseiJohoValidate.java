/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.NinteiShinsei;

import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.YokaigoNinteiShinseiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * @author N2006 立野 啓子
 */
public class NinteiShinseiJohoValidate {
    
    private static final int I = 60;

//申請区分（更新申請）のとき、申請日は前回有効終了日の60日前以降でなければならない
    public boolean validateShinseiKbn(RString shinseiKbn, RDate shinseiYMD, RString zenkaiYukoKikanEnd) {
        if (shinseiKbn.equalsIgnoreCase(YokaigoNinteiShinseiKubun.更新申請.getCode())) {
            if (zenkaiYukoKikanEnd.isEmpty()) {
                return true;
            }
            if (shinseiYMD.isBefore(new RDate(zenkaiYukoKikanEnd.toString()).minusDay(I))) {
                return true;
            }
        }
        return false;
    }

    //事業者
    public boolean validateJigyosha(RString jigyoshaCode, RString jigyoshaName) {
        if (jigyoshaCode.isEmpty() && jigyoshaName.isEmpty()) {
            return false;
        }
        if (jigyoshaCode.isEmpty() || jigyoshaName.isEmpty()) {
            return true;
        }
        return false;
    }

    //医療機関
    public boolean validateIryokikan(RString iryokikanCode, RString iryokikanName) {
        if (iryokikanCode.isEmpty() && iryokikanName.isEmpty()) {
            return false;
        }
        if (iryokikanCode.isEmpty() || iryokikanName.isEmpty()) {
            return true;
        }
        return false;
    }

    //主治医
    public boolean validateShujii(RString shujiiCode, RString shujiiName) {
        if (shujiiCode.isEmpty() && shujiiName.isEmpty()) {
            return false;
        }
        if (shujiiCode.isEmpty() || shujiiName.isEmpty()) {
            return true;
        }
        return false;
    }

}
