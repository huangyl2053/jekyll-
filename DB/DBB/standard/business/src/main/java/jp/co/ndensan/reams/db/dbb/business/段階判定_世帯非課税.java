/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

/**
 *
 * @author N2810
 */
public class 段階判定_世帯非課税 implements IHanteiHoho {

    @Override
    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput) {
        return hokenryoDankaiInput.getFukaKonkyo().getSetaiKazeiKubun().equals("非課税");
    }

}
