/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

/**
 *
 * @author N2810
 */
public interface IKazeiHantei {

    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput);

    public String HokenryoDankaiShiyo(HokenryoDankaiInput hokenryoDankaiInput);

    public void HokenryoDankaiShiyoShinai(HokenryoDankaiInput hokenryoDankaiInput);
}
