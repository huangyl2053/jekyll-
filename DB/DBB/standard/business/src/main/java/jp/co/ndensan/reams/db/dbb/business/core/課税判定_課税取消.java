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
public class 課税判定_課税取消 implements IKazeiHantei {

    @Override
    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput) {
        if (hokenryoDankaiInput.getSeigyoJoho().getKazeiTorikeshiDankaiShiyo() == null
                || hokenryoDankaiInput.getSeigyoJoho().getKazeiTorikeshiDankaiShiyo().isEmpty()) {
            return false;
        } else {
            return hokenryoDankaiInput.getSeigyoJoho().getKazeiTorikeshiDankaiShiyo().equals("使用する");
        }
    }

    @Override
    public RString hokenryoDankaiShiyo(HokenryoDankaiInput hokenryoDankaiInput) {
        return hokenryoDankaiInput.getSeigyoJoho().getKazeiTorikeshiDankai();
    }

    @Override
    public void hokenryoDankaiShiyoShinai(HokenryoDankaiInput hokenryoDankaiInput) {
        if (hokenryoDankaiInput.getSeigyoJoho().getKazeiTorikeshiKazeiKubun() != null
                && !hokenryoDankaiInput.getSeigyoJoho().getKazeiTorikeshiKazeiKubun().isEmpty()) {
            hokenryoDankaiInput.getFukaKonkyo().setHonninKazeiKubun(hokenryoDankaiInput.getSeigyoJoho().getKazeiTorikeshiKazeiKubun());
            if (hokenryoDankaiInput.getFukaKonkyo().getHonninKazeiKubun().equals("課税")) {
                hokenryoDankaiInput.getFukaKonkyo().setSetaiKazeiKubun(new RString("課税"));
            }
        }
    }
}
