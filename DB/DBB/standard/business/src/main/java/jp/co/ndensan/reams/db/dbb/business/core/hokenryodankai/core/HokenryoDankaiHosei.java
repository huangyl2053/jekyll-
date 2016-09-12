/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public final class HokenryoDankaiHosei {

    private HokenryoDankaiHosei() {

    }

    /**
     * hokenryoDankaiHoseiクラスです。
     *
     * @param hokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter
     * @param hokenryodankai hokenryodankai
     * @return RString RString
     */
    public static RString hokenryoDankaiHosei(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter, RString hokenryodankai) {

        RString hoseigoDankai = null;

        // 保険料段階判定方法保存クラスから対象賦課年度の判定方法を取得する
        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho
                = HokenryoDankaiHanteiHohoHozonFactory.createHokenryoDankaiHanteiHoho(hokenryoDankaiHanteiParameter);

        // 20160730 From LIANDI：ご提供のソースに、「hokenryoDankaiHanteiHoho」のnullチェックが漏れ、一時対応させて頂きます。
        if (hokenryoDankaiHanteiHoho == null) {
            return RString.EMPTY;
        }

        //世帯非課税・本人非課税の段階数の最大を取得する(保険料段階判定方法保存クラスから)
        RString setaihikazeiMAX = hokenryoDankaiHanteiHoho.世帯非課税最大段階数取得();

        //引数と取得した最大値を比較する
        if (Integer.parseInt(hokenryodankai.toString()) <= Integer.parseInt(setaihikazeiMAX.toString())) {
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
