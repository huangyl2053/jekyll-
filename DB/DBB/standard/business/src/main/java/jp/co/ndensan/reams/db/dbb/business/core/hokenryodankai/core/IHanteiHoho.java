/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;

/**
 *
 * @author N2810
 */
interface IHanteiHoho {

    boolean matches(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter);
}
