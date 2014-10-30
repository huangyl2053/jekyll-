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
public class HokenryoDankaiHantei {

    public HokenryoDankaiOutput hokenryoDankaiHantei(HokenryoDankaiInput hokenryoDankaiInput) {

        //課税判定
        KazeiHantei kazeiHantei = new KazeiHantei();
        String kazeiHanteiResult = kazeiHantei.kazeiHantei(hokenryoDankaiInput);

        //所得段階判定
        HokenryoDankaiOutput hokenryoDankaiOutput;
        if (kazeiHanteiResult == null || kazeiHanteiResult.isEmpty()) {
            // 課税判定だけでは所得段階が確定しないので判定する
            保険料段階 hokenryoDankai = new 保険料段階();

            // 賦課年度の所得段階判定方法を取得する
            HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);

            hokenryoDankaiOutput = hokenryoDankai.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);

        } else {
            // 所得調査中などで所得段階が暫定的に決まっているので、それを返す
            hokenryoDankaiOutput = new HokenryoDankaiOutput(kazeiHanteiResult);
        }

        //所得段階表記設定
        保険料段階表記設定.保険料段階表記設定(hokenryoDankaiInput, hokenryoDankaiOutput);

        return hokenryoDankaiOutput;
    }
}
