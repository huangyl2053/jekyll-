/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public final class HokenryoDankaiHyokiSettei {

    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;
    private static final int INT11 = 11;
    private static final int INT12 = 12;
    private static final int INT13 = 13;
    private static final int INT14 = 14;
    private static final int INT15 = 15;
    private static final int INT16 = 16;
    private static final int INT17 = 17;
    private static final int INT18 = 18;
    private static final int INT19 = 19;
    private static final int INT20 = 20;

    private HokenryoDankaiHyokiSettei() {

    }

    /**
     * set保険料段階表記クラスです。
     *
     * @param hokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter
     * @param tsukibetsuHokenryoDankai tsukibetsuHokenryoDankai
     */
    public static void set保険料段階表記(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter,
            TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai) {

        Map<RString, HokenryoDankai> hokenryoDankaiMap = tsukibetsuHokenryoDankai.createHokenryoDankaiMap();
        Set<Map.Entry<RString, HokenryoDankai>> set = hokenryoDankaiMap.entrySet();
        Iterator<Map.Entry<RString, HokenryoDankai>> it = set.iterator();
        if (it.hasNext()) {
            Map.Entry<RString, HokenryoDankai> entry = it.next();
            RString key = entry.getKey();
            HokenryoDankai hokenryoDankai = hokenryoDankaiMap.get(key);

            hokenryoDankai.setHokenryoDankai(システム段階置換(hokenryoDankaiHanteiParameter, hokenryoDankai.getHokenryoDankai()));

        }
    }

    private static RString システム段階置換(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter, RString dankai) {

        RString result = new RString("");

        List<RString> hokenryoDankaiList = hokenryoDankaiHanteiParameter.getSeigyoJoho().getHokenryoDankaiList().to表記List();

        result = 置換first(result, dankai, hokenryoDankaiList);
        if (new RString("").equals(result)) {
            result = 置換second(result, dankai, hokenryoDankaiList);
        }

        return result;
    }

    private static RString 置換first(RString result, RString dankai, List<RString> hokenryoDankaiList) {
        switch (dankai.toString()) {
            case "1":
                result = hokenryoDankaiList.get(0);
                break;
            case "2":
                result = hokenryoDankaiList.get(1);
                break;
            case "3":
                result = hokenryoDankaiList.get(INT3);
                break;
            case "4":
                result = hokenryoDankaiList.get(INT4);
                break;
            case "5":
                result = hokenryoDankaiList.get(INT5);
                break;
            case "6":
                result = hokenryoDankaiList.get(INT6);
                break;
            case "7":
                result = hokenryoDankaiList.get(INT7);
                break;
            case "8":
                result = hokenryoDankaiList.get(INT8);
                break;
            case "9":
                result = hokenryoDankaiList.get(INT9);
                break;
            case "10":
                result = hokenryoDankaiList.get(INT10);
                break;
            default:
                result = new RString("");
        }
        return result;
    }

    private static RString 置換second(RString result, RString dankai, List<RString> hokenryoDankaiList) {
        switch (dankai.toString()) {
            case "11":
                result = hokenryoDankaiList.get(INT11);
                break;
            case "12":
                result = hokenryoDankaiList.get(INT12);
                break;
            case "13":
                result = hokenryoDankaiList.get(INT13);
                break;
            case "14":
                result = hokenryoDankaiList.get(INT14);
                break;
            case "15":
                result = hokenryoDankaiList.get(INT15);
                break;
            case "16":
                result = hokenryoDankaiList.get(INT16);
                break;
            case "17":
                result = hokenryoDankaiList.get(INT17);
                break;
            case "18":
                result = hokenryoDankaiList.get(INT18);
                break;
            case "19":
                result = hokenryoDankaiList.get(INT19);
                break;
            case "20":
                result = hokenryoDankaiList.get(INT20);
                break;
            default:
                result = new RString("");
        }
        return result;
    }
}
