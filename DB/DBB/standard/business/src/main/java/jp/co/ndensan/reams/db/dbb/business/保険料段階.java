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
public class 保険料段階 {

    public HokenryoDankaiOutput HokenryoDankaiHantei(HokenryoDankaiInput hokenryoDankaiInput, HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho) {

        String dankaiResult = null;

        //mapからkey(段階数)を取得
        for (String hanteiDankai : hokenryoDankaiHanteiHoho.hanteiHoho.keySet()) {

            //取得した段階の判定方法を取得
            List<IHanteiHoho> hanteihohoList = hokenryoDankaiHanteiHoho.hanteiHoho.get(hanteiDankai);
            //hanteiResult = KakuDankaiHantei(hokenryoDankaiInput,hanteihohoList);

            if (各段階判定(hokenryoDankaiInput, hanteihohoList)) {
                dankaiResult = hanteiDankai;
                break;
            }
        }

        HokenryoDankaiOutput hokenryoDankaiOutput = 出力データ作成(hokenryoDankaiInput, dankaiResult);

        //生保等判定を行う
        List<I1段階判定> dai1dankaiHanteiList;
        dai1dankaiHanteiList = new ArrayList<>();
        dai1dankaiHanteiList.add(new 段階判定_生活保護());
        dai1dankaiHanteiList.add(new 段階判定_老齢年金());

        for (I1段階判定 dai1dankaiHantei : dai1dankaiHanteiList) {
            if (dai1dankaiHantei.isMatch(hokenryoDankaiInput)) {
                dai1dankaiHantei.Dai1dankaiSettei(hokenryoDankaiInput, hokenryoDankaiOutput);
                break;
            }
        }

        return hokenryoDankaiOutput;
    }

    private boolean 各段階判定(HokenryoDankaiInput hokenryoDankaiInput, List<IHanteiHoho> hanteihohoList) {

        boolean result = true;

        for (IHanteiHoho hantei : hanteihohoList) {
            if (hantei.isMatch(hokenryoDankaiInput)) {
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    protected static HokenryoDankaiOutput 出力データ作成(HokenryoDankaiInput hokenryoDankaiInput, String dankaiResult) {

        HokenryoDankaiOutput hokenryoDankaiOutput = new HokenryoDankaiOutput(dankaiResult);
        return hokenryoDankaiOutput;
    }
}
