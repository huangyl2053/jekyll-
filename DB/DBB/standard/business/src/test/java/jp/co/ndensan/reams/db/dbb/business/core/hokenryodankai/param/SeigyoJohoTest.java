/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 *
 */
public class SeigyoJohoTest {

    public static SeigyoJoho setCreateHokenryoDankaiHanteiHoho() {
        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        return seigyojoho;
    }

    public static SeigyoJoho setHokenryoDankaiHyokiSettei() {

        SeigyoJoho seigyojoho = new SeigyoJoho();

        List<HokenryoDankai> dankais = new ArrayList<>();
        DbT2013HokenryoDankaiEntity dankaiEntity01 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity01.setDankaiIndex(new RString("第1段階"));
        dankais.add(new HokenryoDankai(dankaiEntity01));

        DbT2013HokenryoDankaiEntity dankaiEntity02 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity02.setDankaiIndex(new RString("第2段階"));
        dankais.add(new HokenryoDankai(dankaiEntity02));

        DbT2013HokenryoDankaiEntity dankaiEntity03 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity03.setDankaiIndex(new RString("第3段階①"));
        dankais.add(new HokenryoDankai(dankaiEntity03));

        DbT2013HokenryoDankaiEntity dankaiEntity04 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity04.setDankaiIndex(new RString("第3段階②"));
        dankais.add(new HokenryoDankai(dankaiEntity04));

        DbT2013HokenryoDankaiEntity dankaiEntity05 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity05.setDankaiIndex(new RString("第4段階１"));
        dankais.add(new HokenryoDankai(dankaiEntity05));

        DbT2013HokenryoDankaiEntity dankaiEntity06 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity06.setDankaiIndex(new RString("第4段階２"));
        dankais.add(new HokenryoDankai(dankaiEntity06));

        DbT2013HokenryoDankaiEntity dankaiEntity07 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity07.setDankaiIndex(new RString("第5段階"));
        dankais.add(new HokenryoDankai(dankaiEntity07));

        DbT2013HokenryoDankaiEntity dankaiEntity08 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity08.setDankaiIndex(new RString("第6段階"));
        dankais.add(new HokenryoDankai(dankaiEntity08));

        DbT2013HokenryoDankaiEntity dankaiEntity09 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity09.setDankaiIndex(new RString("第7段階"));
        dankais.add(new HokenryoDankai(dankaiEntity09));

        DbT2013HokenryoDankaiEntity dankaiEntity10 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity10.setDankaiIndex(new RString("第8段階"));
        dankais.add(new HokenryoDankai(dankaiEntity10));

        DbT2013HokenryoDankaiEntity dankaiEntity11 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity11.setDankaiIndex(new RString("第9段階"));
        dankais.add(new HokenryoDankai(dankaiEntity11));

        DbT2013HokenryoDankaiEntity dankaiEntity12 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity12.setDankaiIndex(new RString("第10段階"));
        dankais.add(new HokenryoDankai(dankaiEntity12));

        DbT2013HokenryoDankaiEntity dankaiEntity13 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity13.setDankaiIndex(new RString("第11段階"));
        dankais.add(new HokenryoDankai(dankaiEntity13));

        DbT2013HokenryoDankaiEntity dankaiEntity14 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity14.setDankaiIndex(new RString("第12段階"));
        dankais.add(new HokenryoDankai(dankaiEntity14));

        DbT2013HokenryoDankaiEntity dankaiEntity15 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity15.setDankaiIndex(new RString("第13段階"));
        dankais.add(new HokenryoDankai(dankaiEntity15));

        DbT2013HokenryoDankaiEntity dankaiEntity16 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity16.setDankaiIndex(new RString("第14段階"));
        dankais.add(new HokenryoDankai(dankaiEntity16));

        DbT2013HokenryoDankaiEntity dankaiEntity17 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity17.setDankaiIndex(new RString("第15段階"));
        dankais.add(new HokenryoDankai(dankaiEntity17));

        DbT2013HokenryoDankaiEntity dankaiEntity18 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity18.setDankaiIndex(new RString("第16段階"));
        dankais.add(new HokenryoDankai(dankaiEntity18));

        DbT2013HokenryoDankaiEntity dankaiEntity19 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity19.setDankaiIndex(new RString("第17段階"));
        dankais.add(new HokenryoDankai(dankaiEntity19));

        DbT2013HokenryoDankaiEntity dankaiEntity20 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity20.setDankaiIndex(new RString("第18段階"));
        dankais.add(new HokenryoDankai(dankaiEntity20));

        HokenryoDankaiList hokenryoDankaiList = new HokenryoDankaiList(dankais);
        seigyojoho.setHokenryoDankaiList(hokenryoDankaiList);
        return seigyojoho;
    }

    public static SeigyoJoho setHokenryoDankaiHantei(int jyunban) {
        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        List<HokenryoDankai> dankais = new ArrayList<>();
        DbT2013HokenryoDankaiEntity dankaiEntity01 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity01.setDankaiIndex(new RString("第1段階"));
        dankais.add(new HokenryoDankai(dankaiEntity01));

        DbT2013HokenryoDankaiEntity dankaiEntity02 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity02.setDankaiIndex(new RString("第2段階"));
        dankais.add(new HokenryoDankai(dankaiEntity02));

        DbT2013HokenryoDankaiEntity dankaiEntity03 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity03.setDankaiIndex(new RString("第3段階①"));
        dankais.add(new HokenryoDankai(dankaiEntity03));

        DbT2013HokenryoDankaiEntity dankaiEntity04 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity04.setDankaiIndex(new RString("第3段階②"));
        dankais.add(new HokenryoDankai(dankaiEntity04));

        DbT2013HokenryoDankaiEntity dankaiEntity05 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity05.setDankaiIndex(new RString("第4段階１"));
        dankais.add(new HokenryoDankai(dankaiEntity05));

        DbT2013HokenryoDankaiEntity dankaiEntity06 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity06.setDankaiIndex(new RString("第4段階２"));
        dankais.add(new HokenryoDankai(dankaiEntity06));

        DbT2013HokenryoDankaiEntity dankaiEntity07 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity07.setDankaiIndex(new RString("第5段階"));
        dankais.add(new HokenryoDankai(dankaiEntity07));

        DbT2013HokenryoDankaiEntity dankaiEntity08 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity08.setDankaiIndex(new RString("第6段階"));
        dankais.add(new HokenryoDankai(dankaiEntity08));

        DbT2013HokenryoDankaiEntity dankaiEntity09 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity09.setDankaiIndex(new RString("第7段階"));
        dankais.add(new HokenryoDankai(dankaiEntity09));

        DbT2013HokenryoDankaiEntity dankaiEntity10 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity10.setDankaiIndex(new RString("第8段階"));
        dankais.add(new HokenryoDankai(dankaiEntity10));

        DbT2013HokenryoDankaiEntity dankaiEntity11 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity11.setDankaiIndex(new RString("第9段階"));
        dankais.add(new HokenryoDankai(dankaiEntity11));

        DbT2013HokenryoDankaiEntity dankaiEntity12 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity12.setDankaiIndex(new RString("第10段階"));
        dankais.add(new HokenryoDankai(dankaiEntity12));

        DbT2013HokenryoDankaiEntity dankaiEntity13 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity13.setDankaiIndex(new RString("第11段階"));
        dankais.add(new HokenryoDankai(dankaiEntity13));

        DbT2013HokenryoDankaiEntity dankaiEntity14 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity14.setDankaiIndex(new RString("第12段階"));
        dankais.add(new HokenryoDankai(dankaiEntity14));

        DbT2013HokenryoDankaiEntity dankaiEntity15 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity15.setDankaiIndex(new RString("第13段階"));
        dankais.add(new HokenryoDankai(dankaiEntity15));

        DbT2013HokenryoDankaiEntity dankaiEntity16 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity16.setDankaiIndex(new RString("第14段階"));
        dankais.add(new HokenryoDankai(dankaiEntity16));

        DbT2013HokenryoDankaiEntity dankaiEntity17 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity17.setDankaiIndex(new RString("第15段階"));
        dankais.add(new HokenryoDankai(dankaiEntity17));

        DbT2013HokenryoDankaiEntity dankaiEntity18 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity18.setDankaiIndex(new RString("第16段階"));
        dankais.add(new HokenryoDankai(dankaiEntity18));

        DbT2013HokenryoDankaiEntity dankaiEntity19 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity19.setDankaiIndex(new RString("第17段階"));
        dankais.add(new HokenryoDankai(dankaiEntity19));

        DbT2013HokenryoDankaiEntity dankaiEntity20 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity20.setDankaiIndex(new RString("第18段階"));
        dankais.add(new HokenryoDankai(dankaiEntity20));

        HokenryoDankaiList hokenryoDankaiList = new HokenryoDankaiList(dankais);
        seigyojoho.setHokenryoDankaiList(hokenryoDankaiList);

        if (1 == jyunban) {
            seigyojoho.setUsesMishinkokuDankai(true);
            seigyojoho.setMishinkokuDankai(new RString("3"));
        } else if (2 == jyunban) {
            seigyojoho.setUsesMishinkokuDankai(false);
            seigyojoho.setMishinkokuKazeiKubun(KazeiKubun.valueOf("課税"));
        }
        return seigyojoho;
    }

    public static SeigyoJoho setkazeiTaisho() {
        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        List<HokenryoDankai> dankais = new ArrayList<>();
        DbT2013HokenryoDankaiEntity dankaiEntity01 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity01.setDankaiIndex(new RString("第1段階"));
        dankais.add(new HokenryoDankai(dankaiEntity01));

        DbT2013HokenryoDankaiEntity dankaiEntity02 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity02.setDankaiIndex(new RString("第2段階"));
        dankais.add(new HokenryoDankai(dankaiEntity02));

        DbT2013HokenryoDankaiEntity dankaiEntity03 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity03.setDankaiIndex(new RString("第3段階①"));
        dankais.add(new HokenryoDankai(dankaiEntity03));

        DbT2013HokenryoDankaiEntity dankaiEntity04 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity04.setDankaiIndex(new RString("第3段階②"));
        dankais.add(new HokenryoDankai(dankaiEntity04));

        DbT2013HokenryoDankaiEntity dankaiEntity05 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity05.setDankaiIndex(new RString("第4段階"));
        dankais.add(new HokenryoDankai(dankaiEntity05));

        DbT2013HokenryoDankaiEntity dankaiEntity06 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity06.setDankaiIndex(new RString("第5段階"));
        dankais.add(new HokenryoDankai(dankaiEntity06));

        DbT2013HokenryoDankaiEntity dankaiEntity07 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity07.setDankaiIndex(new RString("第6段階"));
        dankais.add(new HokenryoDankai(dankaiEntity07));

        DbT2013HokenryoDankaiEntity dankaiEntity08 = new DbT2013HokenryoDankaiEntity();
        dankaiEntity08.setDankaiIndex(new RString("第7段階"));
        dankais.add(new HokenryoDankai(dankaiEntity08));

        HokenryoDankaiList hokenryoDankaiList = new HokenryoDankaiList(dankais);
        seigyojoho.setHokenryoDankaiList(hokenryoDankaiList);

        return seigyojoho;
    }

    public static SeigyoJoho setKazeiHantei(int jyunban) {
        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        if (1 == jyunban || 3 == jyunban || 5 == jyunban) {
            seigyojoho.setUsesMishinkokuDankai(true);
            seigyojoho.setMishinkokuDankai(new RString("5"));
        } else if (2 == jyunban || 4 == jyunban || 6 == jyunban) {
            seigyojoho.setUsesMishinkokuDankai(true);
            seigyojoho.setMishinkokuDankai(new RString("3"));
        } else if (9 == jyunban) {
            seigyojoho.setUsesMishinkokuDankai(false);
            seigyojoho.setMishinkokuKazeiKubun(KazeiKubun.valueOf("課税"));
        } else if (10 == jyunban || 11 == jyunban) {
            seigyojoho.setUsesShotokuChosachuDankai(false);
            seigyojoho.setShotokuChosachuKazeiKubun(KazeiKubun.valueOf("課税"));
        }
        return seigyojoho;
    }
}
