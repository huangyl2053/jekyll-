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
public class 課税判定_未申告 implements IKazeiHantei {

    @Override
    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput) {
        if (hokenryoDankaiInput.getSeigyoJoho().getMishinkokuDankaiShiyo() == null
                || hokenryoDankaiInput.getSeigyoJoho().getMishinkokuDankaiShiyo().isEmpty()) {
            return false;
        } else {
            return hokenryoDankaiInput.getSeigyoJoho().getMishinkokuDankaiShiyo().equals("使用する");
        }
    }

    @Override
    public String HokenryoDankaiShiyo(HokenryoDankaiInput hokenryoDankaiInput) {
        return hokenryoDankaiInput.getSeigyoJoho().getMishinkokuDankai();
    }

    @Override
    public void HokenryoDankaiShiyoShinai(HokenryoDankaiInput hokenryoDankaiInput) {
        if (hokenryoDankaiInput.getSeigyoJoho().getMishinkokuKazeiKubun() != null
                && !hokenryoDankaiInput.getSeigyoJoho().getMishinkokuKazeiKubun().isEmpty()) {
            hokenryoDankaiInput.getFukaKonkyo().setHonninKazeiKubun(hokenryoDankaiInput.getSeigyoJoho().getMishinkokuKazeiKubun());

            if (hokenryoDankaiInput.getFukaKonkyo().getHonninKazeiKubun().equals("課税")) {
                hokenryoDankaiInput.getFukaKonkyo().setSetaiKazeiKubun("課税");
            }

        }
    }
}
