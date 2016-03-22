/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.kazeihantei;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public class KazeiHanteiChosaChu implements IKazeiHantei {

    @Override
    public boolean isMatch(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        return hokenryoDankaiHanteiParameter.getSeigyoJoho().isUsesShotokuChosachuDankai();
    }

    @Override
    public RString hokenryoDankaiShiyo(HokenryoDankaiHanteiParameter ｈokenryoDankaiHanteiParameter) {
        return ｈokenryoDankaiHanteiParameter.getSeigyoJoho().getShotokuChosachuDankai();
    }

    @Override
    public void hokenryoDankaiShiyoShinai(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        if (hokenryoDankaiHanteiParameter.getSeigyoJoho().getShotokuChosachuKazeiKubun() != null) {
            hokenryoDankaiHanteiParameter.getFukaKonkyo().setHonninKazeiKubun(
                    hokenryoDankaiHanteiParameter.getSeigyoJoho().getShotokuChosachuKazeiKubun());
            if (hokenryoDankaiHanteiParameter.getFukaKonkyo().getHonninKazeiKubun().equals(KazeiKubun.valueOf("課税"))) {
                hokenryoDankaiHanteiParameter.getFukaKonkyo().setSetaiKazeiKubun(KazeiKubun.valueOf("課税"));
            }
        }
    }
}
