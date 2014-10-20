/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810
 */
public class 第4期 extends HokenryoDankaiHanteiHohoHozon {

    public 第4期(HokenryoDankaiInput hokenryoDankaiInput) {

        Decimal 基準年金収入1 = hokenryoDankaiInput.getSeigyoJoho().getKijunNenkinShunyu01();
        Decimal 基準年金収入2 = hokenryoDankaiInput.getSeigyoJoho().getKijunNenkinShunyu02();
        Decimal 基準年金収入3 = hokenryoDankaiInput.getSeigyoJoho().getKijunNenkinShunyu03();
        Decimal 基準所得段階1 = hokenryoDankaiInput.getSeigyoJoho().getKijunShotokuKingaku01();
        Decimal 基準所得段階2 = hokenryoDankaiInput.getSeigyoJoho().getKijunShotokuKingaku02();

        List<IHanteiHoho> 段階2 = new ArrayList<>();
        段階2.add(new 段階判定_世帯非課税());
        段階2.add(new 段階判定_本人非課税());
        段階2.add(new 段階判定_金額(new Decimal(0), 基準年金収入1));

        List<IHanteiHoho> 段階3 = new ArrayList<>();
        段階3.add(new 段階判定_世帯非課税());
        段階3.add(new 段階判定_本人非課税());
        段階3.add(new 段階判定_金額(基準年金収入1.add(1), 基準年金収入2));
        段階3.add(new 段階判定_特例対象());

        List<IHanteiHoho> 段階4 = new ArrayList<>();
        段階4.add(new 段階判定_世帯非課税());
        段階4.add(new 段階判定_本人非課税());
        段階4.add(new 段階判定_金額(基準年金収入2.add(1), new Decimal(-1)));        

        List<IHanteiHoho> 段階5 = new ArrayList<>();
        段階5.add(new 段階判定_世帯課税());
        段階5.add(new 段階判定_本人非課税());
        段階5.add(new 段階判定_金額(new Decimal(0), 基準年金収入3));
        段階5.add(new 段階判定_特例対象());

        List<IHanteiHoho> 段階6 = new ArrayList<>();
        段階6.add(new 段階判定_世帯課税());
        段階6.add(new 段階判定_本人非課税());
        段階6.add(new 段階判定_金額(基準年金収入3.add(1), new Decimal(-1)));

        List<IHanteiHoho> 段階7 = new ArrayList<>();
        段階7.add(new 段階判定_世帯課税());
        段階7.add(new 段階判定_本人課税());
        段階7.add(new 段階判定_金額(new Decimal(0), 基準所得段階1));

        List<IHanteiHoho> 段階8 = new ArrayList<>();
        段階8.add(new 段階判定_世帯課税());
        段階8.add(new 段階判定_本人課税());
        段階8.add(new 段階判定_金額(基準所得段階1.add(1), 基準所得段階2));

        List<IHanteiHoho> 段階9 = new ArrayList<>();
        段階9.add(new 段階判定_世帯課税());
        段階9.add(new 段階判定_本人課税());
        段階9.add(new 段階判定_金額(基準所得段階2.add(1), new Decimal(-1)));

        hanteiHoho.put("2", 段階2);
        hanteiHoho.put("3", 段階3);
        hanteiHoho.put("4", 段階4);
        hanteiHoho.put("5", 段階5);
        hanteiHoho.put("6", 段階6);
        hanteiHoho.put("7", 段階7);
        hanteiHoho.put("8", 段階8);
        hanteiHoho.put("9", 段階9);

    }

}
