/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;

/**
 * 段階判定_本人非課税というクラスです。
 *
 */
class DankaiHanteiHonninHiKazei implements IHanteiHoho {

    @Override
    public boolean matches(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        if (!hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList().isEmpty()) {
            for (KazeiKubun honninKazeiKubun : hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList()) {
                if (KazeiKubun.非課税.getコード().equals(honninKazeiKubun.getコード())) {
                    return true;
                }
            }
        }
        return false;
    }

}
