/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * HasuChoseiFactoryクラスです。
 *
 * @author n3336
 */
public class HasuChoseiFactory {

    /**
     * 端数調整
     *
     * @param nengakuHokenryoKeisanParameter
     * @return IHasuChosei
     */
    public IHasuChosei getIncetance(NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter) {

        List<IHasuChoseiHantei> list = new ArrayList<>();
        list.add(new DankaiHenkoNashi());
        list.add(new RankHenkoNashi());
        list.add(new ShikakuShutoku0401());
        list.add(new ShikakuSoshitsuNendonai());

        boolean chousei = false;

        for (IHasuChoseiHantei list_hantei : list) {
            if (list_hantei.judgeHasuu(nengakuHokenryoKeisanParameter)) {
                chousei = true;
                break;
            }
        }

        if (!chousei) {
            return new HasuChoseiShinai();
        }

        IHasuChoseiHantei rankChange = new RankHenkoNashi();
        HasuChoseiHoho chouseiHouhou;
        Decimal choseiTanni;
        if (rankChange.judgeHasuu(nengakuHokenryoKeisanParameter)) {
            chouseiHouhou = nengakuHokenryoKeisanParameter.get年額制御情報().get端数調整方法_ランク用();
            choseiTanni = nengakuHokenryoKeisanParameter.get年額制御情報().get端数単位_ランク用();
        } else {
            chouseiHouhou = nengakuHokenryoKeisanParameter.get年額制御情報().get端数調整方法();
            choseiTanni = nengakuHokenryoKeisanParameter.get年額制御情報().get端数単位();
        }

        switch (String.valueOf(chouseiHouhou)) {
            case ("切り上げ"):
                return new HasuChoseiKriage(new RString(choseiTanni.toString()));

            case ("切捨て"):
                return new HasuChoseiKirisute(new RString(choseiTanni.toString()));

            case ("四捨五入"):
                return new HasuChoseiShishaGonyu(new RString(choseiTanni.toString()));

            default:
                return new HasuChoseiShinai();
        }

    }

}
