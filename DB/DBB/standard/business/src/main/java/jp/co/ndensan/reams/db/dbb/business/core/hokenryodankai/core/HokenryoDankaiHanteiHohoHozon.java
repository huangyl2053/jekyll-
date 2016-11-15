/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810
 */
public abstract class HokenryoDankaiHanteiHohoHozon {

    private final Map<RString, List<IHanteiHoho>> hanteiHoho = new LinkedHashMap<>();

    /**
     * 世帯非課税最大段階数取得
     *
     * @return RString
     */
    protected RString 世帯非課税最大段階数取得() {

        RString result = null;
        boolean setaihikazei;
        boolean honninhikazei;
        Decimal maekagen = new Decimal(0);
        Decimal maejogen = new Decimal(0);
        Decimal atokagen = new Decimal(0);

        //mapからkey(段階数)を取得
        for (RString hanteiDankai : hanteiHoho.keySet()) {

            //取得した段階の判定方法を取得
            List<IHanteiHoho> hanteihohoList = hanteiHoho.get(hanteiDankai);

            setaihikazei = false;
            honninhikazei = false;

            for (IHanteiHoho kakuhanteihoho : hanteihohoList) {
                if (kakuhanteihoho instanceof DankaiHanteiSetaiHiKazei) {
                    setaihikazei = true;
                } else if (kakuhanteihoho instanceof DankaiHanteiHonninHiKazei) {
                    honninhikazei = true;
                } else if (kakuhanteihoho instanceof DankaiHanteiKingaku) {
                    maekagen = DankaiHanteiKingaku.class.cast(kakuhanteihoho).getKagen();
                    maejogen = DankaiHanteiKingaku.class.cast(kakuhanteihoho).getJogen();
                }
            }
            if (setaihikazei && honninhikazei) {

                if (result == null || result.isEmpty()) {
                    result = hanteiDankai;
                    atokagen = maekagen;

                } else if (atokagen.compareTo(maejogen) < 0 || maejogen.compareTo(new Decimal(-1)) == 0) {
                    result = hanteiDankai;
                    atokagen = maekagen;

                }
            }
        }

        return result;
    }

    /**
     * 本人非課税最大段階数取得
     *
     * @return RString
     */
    protected RString 本人非課税最大段階数取得() {

        RString result = null;
        boolean setaihikazei;
        boolean honninhikazei;
        Decimal maekagen = new Decimal(0);
        Decimal maejogen = new Decimal(0);
        Decimal atokagen = new Decimal(0);

        //mapからkey(段階数)を取得
        for (RString hanteiDankai : hanteiHoho.keySet()) {

            //取得した段階の判定方法を取得
            List<IHanteiHoho> hanteihohoList = hanteiHoho.get(hanteiDankai);

            setaihikazei = false;
            honninhikazei = false;

            for (IHanteiHoho kakuhanteihoho : hanteihohoList) {
                if (kakuhanteihoho instanceof DankaiHanteiSetaiKazei) {
                    setaihikazei = true;
                } else if (kakuhanteihoho instanceof DankaiHanteiHonninHiKazei) {
                    honninhikazei = true;
                } else if (kakuhanteihoho instanceof DankaiHanteiKingaku) {
                    maekagen = DankaiHanteiKingaku.class.cast(kakuhanteihoho).getKagen();
                    maejogen = DankaiHanteiKingaku.class.cast(kakuhanteihoho).getJogen();
                }
            }
            if (setaihikazei && honninhikazei) {

                if (result == null || result.isEmpty()) {
                    result = hanteiDankai;
                    atokagen = maekagen;
                } else if (atokagen.compareTo(maejogen) < 0 || maejogen.compareTo(new Decimal(-1)) == 0) {
                    result = hanteiDankai;
                    atokagen = maekagen;
                }
            }
        }

        return result;
    }

    Map<RString, List<IHanteiHoho>> getHanteiHoho() {
        return hanteiHoho;
    }
}
