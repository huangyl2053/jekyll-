/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public final class 保険料段階表記設定 {

    private 保険料段階表記設定() {

    }

    public static void set保険料段階表記(HokenryoDankaiInput hokenryoDankaiInput, HokenryoDankaiOutput hokenryoDankaiOutput) {

        Map<RString, HokenryoDankai> hokenryoDankaiMap = hokenryoDankaiOutput.createHokenryoDankaiMap();
        for (RString tsuki : hokenryoDankaiMap.keySet()) {

            HokenryoDankai hokenryoDankai = hokenryoDankaiMap.get(tsuki);

            hokenryoDankai.setHokenryoDankai(システム段階置換(hokenryoDankaiInput, hokenryoDankai.getHokenryoDankai()));

        }
    }

    private static RString システム段階置換(HokenryoDankaiInput hokenryoDankaiInput, RString dankai) {

        RString result;

        switch (dankai.toString()) {
            case "1":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki01();
                break;
            case "2":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki02();
                break;
            case "3":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki03();
                break;
            case "4":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki04();
                break;
            case "5":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki05();
                break;
            case "6":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki06();
                break;
            case "7":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki07();
                break;
            case "8":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki08();
                break;
            case "9":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki09();
                break;
            case "10":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki10();
                break;
            case "11":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki11();
                break;
            case "12":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki12();
                break;
            case "13":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki13();
                break;
            case "14":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki14();
                break;
            case "15":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki15();
                break;
            case "16":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki16();
                break;
            case "17":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki17();
                break;
            case "18":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki18();
                break;
            case "19":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki19();
                break;
            case "20":
                result = hokenryoDankaiInput.getSeigyoJoho().getHokenryoDankaiHyoki20();
                break;
            default:
                result = new RString("");
        }

        return result;
    }
}
