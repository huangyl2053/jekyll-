/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.kazeihantei;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public interface IKazeiHantei {

    boolean isMatch(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter);

    RString hokenryoDankaiShiyo(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter);

    void hokenryoDankaiShiyoShinai(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter);
}
