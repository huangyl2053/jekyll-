/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public final class HokenryoDankaiHyokiSettei {

    private HokenryoDankaiHyokiSettei() {

    }

    public static void set保険料段階表記(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter,
            TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai) {

        Map<RString, HokenryoDankai> hokenryoDankaiMap = tsukibetsuHokenryoDankai.createHokenryoDankaiMap();
        for (RString tsuki : hokenryoDankaiMap.keySet()) {

            HokenryoDankai hokenryoDankai = hokenryoDankaiMap.get(tsuki);

            hokenryoDankai.setHokenryoDankai(システム段階置換(hokenryoDankaiHanteiParameter, hokenryoDankai.getHokenryoDankai()));

        }
    }

    private static RString システム段階置換(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter, RString dankai) {

        RString result;

        List<RString> HokenryoDankaiList = hokenryoDankaiHanteiParameter.getSeigyoJoho().getHokenryoDankaiList().to表記List();
        switch (dankai.toString()) {
            case "1":
                result = HokenryoDankaiList.get(0);
                break;
            case "2":
                result = HokenryoDankaiList.get(1);
                break;
            case "3":
                result = HokenryoDankaiList.get(3);
                break;
            case "4":
                result = HokenryoDankaiList.get(4);
                break;
            case "5":
                result = HokenryoDankaiList.get(5);
                break;
            case "6":
                result = HokenryoDankaiList.get(6);
                break;
            case "7":
                result = HokenryoDankaiList.get(7);
                break;
            case "8":
                result = HokenryoDankaiList.get(8);
                break;
            case "9":
                result = HokenryoDankaiList.get(9);
                break;
            case "10":
                result = HokenryoDankaiList.get(10);
                break;
            case "11":
                result = HokenryoDankaiList.get(11);
                break;
            case "12":
                result = HokenryoDankaiList.get(12);
                break;
            case "13":
                result = HokenryoDankaiList.get(13);
                break;
            case "14":
                result = HokenryoDankaiList.get(14);
                break;
            case "15":
                result = HokenryoDankaiList.get(15);
                break;
            case "16":
                result = HokenryoDankaiList.get(16);
                break;
            case "17":
                result = HokenryoDankaiList.get(17);
                break;
            case "18":
                result = HokenryoDankaiList.get(18);
                break;
            case "19":
                result = HokenryoDankaiList.get(19);
                break;
            case "20":
                result = HokenryoDankaiList.get(20);
                break;
            default:
                result = new RString("");
        }

        return result;
    }
}
