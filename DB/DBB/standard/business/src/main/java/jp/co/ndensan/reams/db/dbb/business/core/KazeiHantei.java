/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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

    public RString kazeiHantei(HokenryoDankaiInput hokenryoDankaiInput) {

        RString hokenryoDankai = null;

        for (IKazeiHantei kazeihantei : kazeiHanteiList) {
            if (kazeihantei.isMatch(hokenryoDankaiInput)) {
                hokenryoDankai = kazeihantei.hokenryoDankaiShiyo(hokenryoDankaiInput);
                if (hokenryoDankaiInput.getFukaKonkyo().getSetaiKazeiKubun().equals("課税")) {
                    hokenryoDankai = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryoDankaiInput, hokenryoDankai);
                }
                break;
            } else {
                kazeihantei.hokenryoDankaiShiyoShinai(hokenryoDankaiInput);
            }
        }
        return hokenryoDankai;
    }
}
