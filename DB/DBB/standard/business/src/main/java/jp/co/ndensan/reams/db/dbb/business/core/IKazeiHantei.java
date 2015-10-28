/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public interface IKazeiHantei {

    boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput);

    RString hokenryoDankaiShiyo(HokenryoDankaiInput hokenryoDankaiInput);

    void hokenryoDankaiShiyoShinai(HokenryoDankaiInput hokenryoDankaiInput);
}
