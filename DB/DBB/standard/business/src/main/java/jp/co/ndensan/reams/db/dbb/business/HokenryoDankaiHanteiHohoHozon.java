/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810
 */
abstract public class HokenryoDankaiHanteiHohoHozon {

    Map<String, List<IHanteiHoho>> hanteiHoho = new HashMap<>();

    protected String 世帯非課税最大段階数取得() {

        String result = null;
        boolean setaihikazei;
        boolean honninhikazei;
        Decimal maekagen = new Decimal(0);
        Decimal maejogen = new Decimal(0);
        Decimal atokagen = new Decimal(0);

        //mapからkey(段階数)を取得
        for (String hanteiDankai : hanteiHoho.keySet()) {

            //取得した段階の判定方法を取得
            List<IHanteiHoho> hanteihohoList = hanteiHoho.get(hanteiDankai);

            setaihikazei = false;
            honninhikazei = false;

            for (IHanteiHoho kakuhanteihoho : hanteihohoList) {
                if (kakuhanteihoho instanceof 段階判定_世帯非課税) {
                    setaihikazei = true;
                } else if (kakuhanteihoho instanceof 段階判定_本人非課税) {
                    honninhikazei = true;
                } else if (kakuhanteihoho instanceof 段階判定_金額) {
                    maekagen = 段階判定_金額.class.cast(kakuhanteihoho).getKagen();
                    maejogen = 段階判定_金額.class.cast(kakuhanteihoho).getJogen();
                }
            }
            if (setaihikazei && honninhikazei) {

                if (result == null || result.isEmpty()) {
                    result = hanteiDankai;
                    atokagen = maekagen;

                } else {
                    if (atokagen.compareTo(maejogen) < 0 || maejogen.compareTo(new Decimal(-1)) == 0) {
                        result = hanteiDankai;
                        atokagen = maekagen;

                    } else {
                    }
                }
            }
        }

        return result;
    }

    protected String 本人非課税最大段階数取得() {

        String result = null;
        boolean setaihikazei;
        boolean honninhikazei;
        Decimal maekagen = new Decimal(0);
        Decimal maejogen = new Decimal(0);
        Decimal atokagen = new Decimal(0);

        //mapからkey(段階数)を取得
        for (String hanteiDankai : hanteiHoho.keySet()) {

            //取得した段階の判定方法を取得
            List<IHanteiHoho> hanteihohoList = hanteiHoho.get(hanteiDankai);

            setaihikazei = false;
            honninhikazei = false;

            for (IHanteiHoho kakuhanteihoho : hanteihohoList) {
                if (kakuhanteihoho instanceof 段階判定_世帯課税) {
                    setaihikazei = true;
                } else if (kakuhanteihoho instanceof 段階判定_本人非課税) {
                    honninhikazei = true;
                } else if (kakuhanteihoho instanceof 段階判定_金額) {
                    maekagen = 段階判定_金額.class.cast(kakuhanteihoho).getKagen();
                    maejogen = 段階判定_金額.class.cast(kakuhanteihoho).getJogen();
                }
            }
            if (setaihikazei && honninhikazei) {

                if (result == null || result.isEmpty()) {
                    result = hanteiDankai;
                    atokagen = maekagen;
                } else {
                    if (atokagen.compareTo(maejogen) < 0 || maejogen.compareTo(new Decimal(-1)) == 0) {
                        result = hanteiDankai;
                        atokagen = maekagen;
                    } else {
                    }
                }
            }
        }

        return result;
    }
}
