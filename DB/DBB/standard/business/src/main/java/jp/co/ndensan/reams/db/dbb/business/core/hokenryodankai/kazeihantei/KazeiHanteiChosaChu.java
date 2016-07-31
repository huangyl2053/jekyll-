/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.kazeihantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
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
        return ｈokenryoDankaiHanteiParameter.getSeigyoJoho().getShotokuChosachuDankai();
    }

    @Override
    public void hokenryoDankaiShiyoShinai(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        if (hokenryoDankaiHanteiParameter.getSeigyoJoho().getShotokuChosachuKazeiKubun() != null) {
            List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
            setaiinKazeiKubunList.add(hokenryoDankaiHanteiParameter.getSeigyoJoho().getShotokuChosachuKazeiKubun());
            hokenryoDankaiHanteiParameter.getFukaKonkyo().setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        }
    }
}
