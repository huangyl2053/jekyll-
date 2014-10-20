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
public class 課税判定_調査中 implements IKazeiHantei {

    @Override
    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput) {
        if (hokenryoDankaiInput.getSeigyoJoho().getShotokuChosachuDankaiShiyo() == null
                || hokenryoDankaiInput.getSeigyoJoho().getShotokuChosachuDankaiShiyo().isEmpty()) {
            return false;
        } else {
            return hokenryoDankaiInput.getSeigyoJoho().getShotokuChosachuDankaiShiyo().equals("使用する");
        }

    }

    @Override
    public String HokenryoDankaiShiyo(HokenryoDankaiInput hokenryoDankaiInput) {
        return hokenryoDankaiInput.getSeigyoJoho().getShotokuChosachuDankai();
    }

    @Override
    public void HokenryoDankaiShiyoShinai(HokenryoDankaiInput hokenryoDankaiInput) {
        if (hokenryoDankaiInput.getSeigyoJoho().getShotokuChosachuKazeiKubun() != null
                && !hokenryoDankaiInput.getSeigyoJoho().getShotokuChosachuKazeiKubun().isEmpty()) {
            hokenryoDankaiInput.getFukaKonkyo().setHonninKazeiKubun(hokenryoDankaiInput.getSeigyoJoho().getShotokuChosachuKazeiKubun());
            if (hokenryoDankaiInput.getFukaKonkyo().getHonninKazeiKubun().equals("課税")) {
                hokenryoDankaiInput.getFukaKonkyo().setSetaiKazeiKubun("課税");
            }
        }
    }
}
