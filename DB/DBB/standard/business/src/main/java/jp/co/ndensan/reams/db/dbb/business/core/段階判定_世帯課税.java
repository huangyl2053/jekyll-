/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.db.dbb.business.core.IHanteiHoho;
import jp.co.ndensan.reams.db.dbb.business.core.HokenryoDankaiInput;

/**
 *
 * @author N2810
 */
public class 段階判定_世帯課税 implements IHanteiHoho {

    @Override
    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput) {
        return hokenryoDankaiInput.getFukaKonkyo().getSetaiKazeiKubun().equals("課税");
    }

}
