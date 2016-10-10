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
 * 第6期というクラスです。
 *
 */
public class Dai6Ki extends HokenryoDankaiHanteiHohoHozon {

    /**
     * 第6期
     *
     * @param hokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter
     */
    public Dai6Ki(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {

        Decimal 基準年金収入1 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunNenkinShunyu01();
        Decimal 基準年金収入2 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunNenkinShunyu02();
        Decimal 基準年金収入3 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunNenkinShunyu03();
        Decimal 基準所得段階1 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku01();
        Decimal 基準所得段階2 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku02();
        Decimal 基準所得段階3 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku03();
        Decimal 基準所得段階4 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku04();
        Decimal 基準所得段階5 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku05();
        Decimal 基準所得段階6 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku06();
        Decimal 基準所得段階7 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku07();
        Decimal 基準所得段階8 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku08();
        Decimal 基準所得段階9 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku09();
        Decimal 基準所得段階10 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku10();
        Decimal 基準所得段階11 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku11();
        Decimal 基準所得段階12 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku12();
        Decimal 基準所得段階13 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku13();
        Decimal 基準所得段階14 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku14();
        Decimal 基準所得段階15 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getKijunShotokuKingaku15();

        List<IHanteiHoho> 段階1 = new ArrayList<>();
        段階1.add(new DankaiHanteiSetaiHiKazei());
        段階1.add(new DankaiHanteiHonninHiKazei());
        段階1.add(new DankaiHanteiKingaku(new Decimal(0), 基準年金収入1));

        List<IHanteiHoho> 段階2 = new ArrayList<>();
        段階2.add(new DankaiHanteiSetaiHiKazei());
        段階2.add(new DankaiHanteiHonninHiKazei());
        段階2.add(new DankaiHanteiKingaku(基準年金収入1.add(1), 基準年金収入2));

        List<IHanteiHoho> 段階3 = new ArrayList<>();
        段階3.add(new DankaiHanteiSetaiHiKazei());
        段階3.add(new DankaiHanteiHonninHiKazei());
        段階3.add(new DankaiHanteiKingaku(基準年金収入2.add(1), new Decimal(-1)));

        List<IHanteiHoho> 段階4 = new ArrayList<>();
        段階4.add(new DankaiHanteiSetaiKazei());
        段階4.add(new DankaiHanteiHonninHiKazei());
        段階4.add(new DankaiHanteiKingaku(new Decimal(0), 基準年金収入3));

        List<IHanteiHoho> 段階5 = new ArrayList<>();
        段階5.add(new DankaiHanteiSetaiKazei());
        段階5.add(new DankaiHanteiHonninHiKazei());
        段階5.add(new DankaiHanteiKingaku(基準年金収入3.add(1), new Decimal(-1)));

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
        段階9.add(new DankaiHanteiKingaku(基準所得段階3.add(1), 基準所得段階4));

        List<IHanteiHoho> 段階10 = new ArrayList<>();
        段階10.add(new DankaiHanteiSetaiKazei());
        段階10.add(new DankaiHanteiHonninKazei());
        段階10.add(new DankaiHanteiKingaku(基準所得段階4.add(1), 基準所得段階5));

        List<IHanteiHoho> 段階11 = new ArrayList<>();
        段階11.add(new DankaiHanteiSetaiKazei());
        段階11.add(new DankaiHanteiHonninKazei());
        段階11.add(new DankaiHanteiKingaku(基準所得段階5.add(1), 基準所得段階6));

        List<IHanteiHoho> 段階12 = new ArrayList<>();
        段階12.add(new DankaiHanteiSetaiKazei());
        段階12.add(new DankaiHanteiHonninKazei());
        段階12.add(new DankaiHanteiKingaku(基準所得段階6.add(1), 基準所得段階7));

        List<IHanteiHoho> 段階13 = new ArrayList<>();
        段階13.add(new DankaiHanteiSetaiKazei());
        段階13.add(new DankaiHanteiHonninKazei());
        段階13.add(new DankaiHanteiKingaku(基準所得段階7.add(1), 基準所得段階8));

        List<IHanteiHoho> 段階14 = new ArrayList<>();
        段階14.add(new DankaiHanteiSetaiKazei());
        段階14.add(new DankaiHanteiHonninKazei());
        段階14.add(new DankaiHanteiKingaku(基準所得段階8.add(1), 基準所得段階9));

        List<IHanteiHoho> 段階15 = new ArrayList<>();
        段階15.add(new DankaiHanteiSetaiKazei());
        段階15.add(new DankaiHanteiHonninKazei());
        段階15.add(new DankaiHanteiKingaku(基準所得段階9.add(1), 基準所得段階10));

        List<IHanteiHoho> 段階16 = new ArrayList<>();
        段階16.add(new DankaiHanteiSetaiKazei());
        段階16.add(new DankaiHanteiHonninKazei());
        段階16.add(new DankaiHanteiKingaku(基準所得段階10.add(1), 基準所得段階11));

        List<IHanteiHoho> 段階17 = new ArrayList<>();
        段階17.add(new DankaiHanteiSetaiKazei());
        段階17.add(new DankaiHanteiHonninKazei());
        段階17.add(new DankaiHanteiKingaku(基準所得段階11.add(1), 基準所得段階12));

        List<IHanteiHoho> 段階18 = new ArrayList<>();
        段階18.add(new DankaiHanteiSetaiKazei());
        段階18.add(new DankaiHanteiHonninKazei());
        段階18.add(new DankaiHanteiKingaku(基準所得段階12.add(1), 基準所得段階13));

        List<IHanteiHoho> 段階19 = new ArrayList<>();
        段階19.add(new DankaiHanteiSetaiKazei());
        段階19.add(new DankaiHanteiHonninKazei());
        段階19.add(new DankaiHanteiKingaku(基準所得段階13.add(1), 基準所得段階14));

        List<IHanteiHoho> 段階20 = new ArrayList<>();
        段階20.add(new DankaiHanteiSetaiKazei());
        段階20.add(new DankaiHanteiHonninKazei());
        段階20.add(new DankaiHanteiKingaku(基準所得段階15.add(1), new Decimal(-1)));

        getHanteiHoho().put(new RString("1"), 段階1);
        getHanteiHoho().put(new RString("2"), 段階2);
        getHanteiHoho().put(new RString("3"), 段階3);
        getHanteiHoho().put(new RString("4"), 段階4);
        getHanteiHoho().put(new RString("5"), 段階5);
        getHanteiHoho().put(new RString("6"), 段階6);
        getHanteiHoho().put(new RString("7"), 段階7);
        getHanteiHoho().put(new RString("8"), 段階8);
        getHanteiHoho().put(new RString("9"), 段階9);
        getHanteiHoho().put(new RString("10"), 段階10);
        getHanteiHoho().put(new RString("11"), 段階11);
        getHanteiHoho().put(new RString("12"), 段階12);
        getHanteiHoho().put(new RString("13"), 段階13);
        getHanteiHoho().put(new RString("14"), 段階14);
        getHanteiHoho().put(new RString("15"), 段階15);
        getHanteiHoho().put(new RString("16"), 段階16);
        getHanteiHoho().put(new RString("17"), 段階17);
        getHanteiHoho().put(new RString("18"), 段階18);
        getHanteiHoho().put(new RString("19"), 段階19);
        getHanteiHoho().put(new RString("20"), 段階20);

    }

}
