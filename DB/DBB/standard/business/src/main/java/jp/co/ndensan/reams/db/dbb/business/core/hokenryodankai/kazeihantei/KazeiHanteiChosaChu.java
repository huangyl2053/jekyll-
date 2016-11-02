/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.kazeihantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.KazeiKubunHonninKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public class KazeiHanteiChosaChu implements IKazeiHantei {

    @Override
    public boolean isMatch(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        return hokenryoDankaiHanteiParameter.getSeigyoJoho().isUsesShotokuChosachuDankai();
    }

    @Override
    public RString hokenryoDankaiShiyo(HokenryoDankaiHanteiParameter ｈokenryoDankaiHanteiParameter) {
        hokenryoDankaiShiyoShinai(ｈokenryoDankaiHanteiParameter);
        for (KazeiKubunHonninKubun kazeiKubunHonninKubun : ｈokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList()) {
            if (HonninKubun.本人 == kazeiKubunHonninKubun.get本人区分()
                    && KazeiKubun.所得調査中 == kazeiKubunHonninKubun.get課税区分()) {
                return ｈokenryoDankaiHanteiParameter.getSeigyoJoho().getMishinkokuDankai();
            }
        }
        return null;
    }

    @Override
    public void hokenryoDankaiShiyoShinai(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        if (hokenryoDankaiHanteiParameter.getSeigyoJoho().getMishinkokuKazeiKubun() != null) {
            List<KazeiKubunHonninKubun> setaiinKazeiKubunList = new ArrayList<>();
            for (KazeiKubunHonninKubun kazeiKubunHonninKubun : hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList()) {
                if (KazeiKubun.所得調査中 == kazeiKubunHonninKubun.get課税区分()) {
                    kazeiKubunHonninKubun.set課税区分(hokenryoDankaiHanteiParameter.getSeigyoJoho().getShotokuChosachuKazeiKubun());
                }
                setaiinKazeiKubunList.add(kazeiKubunHonninKubun);
            }
            hokenryoDankaiHanteiParameter.getFukaKonkyo().setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        }
    }
}
