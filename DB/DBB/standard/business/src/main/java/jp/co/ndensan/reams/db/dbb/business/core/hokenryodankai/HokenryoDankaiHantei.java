/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankaiHanteiCore;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankaiHanteiHohoHozon;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankaiHanteiHohoHozonFactory;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.kazeihantei.KazeiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public class HokenryoDankaiHantei {

    /**
     * determine月別保険料段階クラスです。
     *
     * @param hokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter
     * @return TsukibetsuHokenryoDankai
     */
    public TsukibetsuHokenryoDankai determine月別保険料段階(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {

        //課税判定
        KazeiHantei kazeiHantei = new KazeiHantei();
        RString kazeiHanteiResult = kazeiHantei.kazeiHantei(hokenryoDankaiHanteiParameter);

        //所得段階判定
        TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai;
        if (kazeiHanteiResult == null || kazeiHanteiResult.isEmpty()) {
            // 課税判定だけでは所得段階が確定しないので判定する
            HokenryoDankaiHanteiCore hokenryoDankaiHanteiCore = new HokenryoDankaiHanteiCore();

            // 賦課年度の所得段階判定方法を取得する
            HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho
                    = HokenryoDankaiHanteiHohoHozonFactory.createHokenryoDankaiHanteiHoho(hokenryoDankaiHanteiParameter);

            tsukibetsuHokenryoDankai = hokenryoDankaiHanteiCore.hokenryoDankaiHantei(hokenryoDankaiHanteiParameter, hokenryoDankaiHanteiHoho);

        } else {
            // 所得調査中などで所得段階が暫定的に決まっているので、それを返す
            tsukibetsuHokenryoDankai = new TsukibetsuHokenryoDankai(hokenryoDankaiHanteiParameter.getSeigyoJoho().getHokenryoDankaiList().getBy段階Index(kazeiHanteiResult).get段階区分());
        }

        return tsukibetsuHokenryoDankai;
    }

    /**
     * determine仮算定保険料段階クラスです。
     *
     * @param hokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter
     * @return TsukibetsuHokenryoDankai
     */
    public TsukibetsuHokenryoDankai determine仮算定保険料段階(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho
                = HokenryoDankaiHanteiHohoHozonFactory.createHokenryoDankaiHanteiHoho(hokenryoDankaiHanteiParameter);

        TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai
                = new HokenryoDankaiHanteiCore().hokenryoDankaiHantei(hokenryoDankaiHanteiParameter, hokenryoDankaiHanteiHoho);

        return tsukibetsuHokenryoDankai;
    }

}
