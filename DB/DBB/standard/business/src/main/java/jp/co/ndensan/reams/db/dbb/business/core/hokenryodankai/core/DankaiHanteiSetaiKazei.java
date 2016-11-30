/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.KazeiKubunHonninKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;

/**
 *
 * @author N2810
 */
class DankaiHanteiSetaiKazei implements IHanteiHoho {

    @Override
    public boolean matches(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        if (null == hokenryoDankaiHanteiParameter.getFukaKonkyo().getZennendoSetaiKazeiKubun()) {
            boolean flag = false;
            for (KazeiKubunHonninKubun kazeiKubunHonninKubun : hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList()) {
                if (!KazeiKubun.非課税.getコード().equals(kazeiKubunHonninKubun.get課税区分().getコード())) {
                    flag = true;
                }
            }
            return flag;
        } else {
            return !SetaiKazeiKubun.非課税.getコード().equals(hokenryoDankaiHanteiParameter.getFukaKonkyo().getZennendoSetaiKazeiKubun().getコード());
        }
    }

}
