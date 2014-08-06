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
public class HokenryoDankaiHosei {

    public static String HokenryoDankaiHosei(HokenryoDankaiInput hokenryoDankaiInput, String hokenryodankai) {

        String hoseigoDankai = null;

        // 保険料段階判定方法保存クラスから対象賦課年度の判定方法を取得する
        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho
                = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);

        //世帯非課税・本人非課税の段階数の最大を取得する(保険料段階判定方法保存クラスから)
        String setaihikazeiMAX = hokenryoDankaiHanteiHoho.世帯非課税最大段階数取得();

        //引数と取得した最大値を比較する
        if (Integer.parseInt(hokenryodankai) <= Integer.parseInt(setaihikazeiMAX)) {
            //世帯課税で　引数＜取得値の場合、補正する
            //補正は世帯課税・本人非課税の最大の段階数を取得し、それを戻り値で返す
            hoseigoDankai = hokenryoDankaiHanteiHoho.本人非課税最大段階数取得();
        } else {
            //補正がない場合はそのまま引数を返す
            hoseigoDankai = hokenryodankai;
        }
        return hoseigoDankai;
    }
}
