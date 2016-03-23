/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import java.util.HashSet;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ランクが4月_翌3月まで変更無いか
 *
 * @author n3336
 */
class RankHenkoNashi implements IHasuChoseiHantei {

    @Override
    public boolean judgeHasuu(NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter) {

        Map<RString, RString> map = nengakuHokenryoKeisanParameter.get年額賦課根拠().createRankMap();

        HashSet<RString> set = new HashSet<>();

        for (Map.Entry<RString, RString> e : map.entrySet()) {
            set.add(e.getValue());
        }

        boolean ランクが4月_翌3月まで変更無いか = false;
        if (set.size() > 1) {
            ランクが4月_翌3月まで変更無いか = true;
            return ランクが4月_翌3月まで変更無いか;
        }
        return ランクが4月_翌3月まで変更無いか;
    }

}
