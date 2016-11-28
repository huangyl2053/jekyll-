/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 第5期というクラスです。
 *
 */
class Dai5Ki extends HokenryoDankaiHanteiHohoHozon {

    /**
     * 第5期
     *
     * @param hokenryoDankaiHanteiParameter
     */
    public Dai5Ki(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {

        Decimal 基準年金収入1 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunNenkinShunyu01();
        Decimal 基準年金収入2 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunNenkinShunyu02();
        Decimal 基準年金収入3 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunNenkinShunyu03();
        Decimal 基準所得段階1 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku01();
        Decimal 基準所得段階2 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku02();
        Decimal 基準所得段階3 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku03();

        List<IHanteiHoho> 段階2 = new ArrayList<>();
        段階2.add(new DankaiHanteiSetaiHiKazei());
        段階2.add(new DankaiHanteiHonninHiKazei());
        段階2.add(new DankaiHanteiKingaku(new Decimal(0), 基準年金収入1));

        List<IHanteiHoho> 段階3 = new ArrayList<>();
        段階3.add(new DankaiHanteiSetaiHiKazei());
        段階3.add(new DankaiHanteiHonninHiKazei());
        段階3.add(new DankaiHanteiKingaku(基準年金収入1.add(1), 基準年金収入2));
        段階3.add(new DankaiHanteiTokureiTaisho());

        List<IHanteiHoho> 段階4 = new ArrayList<>();
        段階4.add(new DankaiHanteiSetaiHiKazei());
        段階4.add(new DankaiHanteiHonninHiKazei());
        段階4.add(new DankaiHanteiKingaku(基準年金収入2.add(1), new Decimal(-1)));

        List<IHanteiHoho> 段階5 = new ArrayList<>();
        段階5.add(new DankaiHanteiSetaiKazei());
        段階5.add(new DankaiHanteiHonninHiKazei());
        段階5.add(new DankaiHanteiKingaku(new Decimal(0), 基準年金収入3));
        段階5.add(new DankaiHanteiTokureiTaisho());

        List<IHanteiHoho> 段階6 = new ArrayList<>();
        段階6.add(new DankaiHanteiSetaiKazei());
        段階6.add(new DankaiHanteiHonninKazei());
        段階6.add(new DankaiHanteiKingaku(new Decimal(0), 基準所得段階1));

        List<IHanteiHoho> 段階7 = new ArrayList<>();
        段階7.add(new DankaiHanteiSetaiKazei());
        段階7.add(new DankaiHanteiHonninKazei());
        段階7.add(new DankaiHanteiKingaku(基準所得段階1.add(1), 基準所得段階2));

        List<IHanteiHoho> 段階8 = new ArrayList<>();
        段階8.add(new DankaiHanteiSetaiKazei());
        段階8.add(new DankaiHanteiHonninKazei());
        段階8.add(new DankaiHanteiKingaku(基準所得段階2.add(1), 基準所得段階3));

        List<IHanteiHoho> 段階9 = new ArrayList<>();
        段階9.add(new DankaiHanteiSetaiKazei());
        段階9.add(new DankaiHanteiHonninKazei());
        段階9.add(new DankaiHanteiKingaku(基準所得段階3.add(1), new Decimal(-1)));

        getHanteiHoho().put(new RString("02"), 段階2);
        getHanteiHoho().put(new RString("03"), 段階3);
        getHanteiHoho().put(new RString("04"), 段階4);
        getHanteiHoho().put(new RString("05"), 段階5);
        getHanteiHoho().put(new RString("06"), 段階6);
        getHanteiHoho().put(new RString("07"), 段階7);
        getHanteiHoho().put(new RString("08"), 段階8);
        getHanteiHoho().put(new RString("09"), 段階9);

    }

}
