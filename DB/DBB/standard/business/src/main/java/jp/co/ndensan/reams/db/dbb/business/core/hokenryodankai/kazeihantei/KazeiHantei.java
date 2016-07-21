/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.kazeihantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankaiHosei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public class KazeiHantei {

    private final List<IKazeiHantei> kazeiHanteiList;

    /**
     * 課税判定
     */
    public KazeiHantei() {
        kazeiHanteiList = new ArrayList<>();
        kazeiHanteiList.add(new KazeiHanteiChosaChu());
        kazeiHanteiList.add(new KazeiHanteiKazeiTorikeshi());
        kazeiHanteiList.add(new KazeiHanteiMiShinkoku());

    }

    /**
     * 課税判定
     *
     * @param hokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter
     * @return 保険料段階
     */
    public RString kazeiHantei(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {

        RString hokenryoDankai = null;

        for (IKazeiHantei kazeihantei : kazeiHanteiList) {
            if (kazeihantei.isMatch(hokenryoDankaiHanteiParameter)) {
                hokenryoDankai = kazeihantei.hokenryoDankaiShiyo(hokenryoDankaiHanteiParameter);
                kazeiKubunHantei(hokenryoDankai, hokenryoDankaiHanteiParameter);
                break;
            } else {
                kazeihantei.hokenryoDankaiShiyoShinai(hokenryoDankaiHanteiParameter);
            }
        }
        return hokenryoDankai;
    }

    private RString kazeiKubunHantei(RString hokenryoDankai, HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        for (KazeiKubun kazeiKubun : hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList()) {
            if (KazeiKubun.課税.getコード().equals(kazeiKubun.getコード())) {
                hokenryoDankai = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryoDankaiHanteiParameter, hokenryoDankai);
            }
        }
        return hokenryoDankai;
    }
}
