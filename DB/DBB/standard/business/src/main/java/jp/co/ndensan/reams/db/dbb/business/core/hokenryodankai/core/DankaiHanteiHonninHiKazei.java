/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.KazeiKubunHonninKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;

/**
 * 段階判定_本人非課税というクラスです。
 *
 */
class DankaiHanteiHonninHiKazei implements IHanteiHoho {

    @Override
    public boolean matches(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        if (null == hokenryoDankaiHanteiParameter.getFukaKonkyo().getZennendoKazeiKubun()) {
            for (KazeiKubunHonninKubun kazeiKubunHonninKubun : hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList()) {
                if (HonninKubun.本人 == kazeiKubunHonninKubun.get本人区分()
                        && KazeiKubun.非課税 == kazeiKubunHonninKubun.get課税区分()) {
                    return true;
                }
            }
            return false;
        } else {
            return KazeiKubun.非課税 == hokenryoDankaiHanteiParameter.getFukaKonkyo().getZennendoKazeiKubun();
        }
    }

}
