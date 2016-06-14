/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.KazeiKubun;

/**
 *
 * @author N2810
 */
class DankaiHanteiSetaiHiKazei implements IHanteiHoho {

    @Override
    public boolean matches(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        if (!hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList().isEmpty()) {
            for (KazeiKubun kazeiKubun : hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList()) {
                if (KazeiKubun.非課税.getコード().equals(kazeiKubun.getコード())) {
                    return true;
                }
            }
        }
        return false;
    }

}
