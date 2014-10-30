/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author N2810
 */
public class KazeiHantei {

    private List<IKazeiHantei> kazeiHanteiList;

    public KazeiHantei() {
        kazeiHanteiList = new ArrayList<>();
        kazeiHanteiList.add(new 課税判定_調査中());
        kazeiHanteiList.add(new 課税判定_課税取消());
        kazeiHanteiList.add(new 課税判定_未申告());

    }

    public String kazeiHantei(HokenryoDankaiInput hokenryoDankaiInput) {

        String HokenryoDankai = null;

        for (IKazeiHantei kazeihantei : kazeiHanteiList) {
            if (kazeihantei.isMatch(hokenryoDankaiInput)) {
                HokenryoDankai = kazeihantei.HokenryoDankaiShiyo(hokenryoDankaiInput);
                if (hokenryoDankaiInput.getFukaKonkyo().getSetaiKazeiKubun().equals("課税")) {
                    HokenryoDankai = HokenryoDankaiHosei.HokenryoDankaiHosei(hokenryoDankaiInput, HokenryoDankai);
                }
                break;
            } else {
                kazeihantei.HokenryoDankaiShiyoShinai(hokenryoDankaiInput);
            }
        }
        return HokenryoDankai;
    }
}
