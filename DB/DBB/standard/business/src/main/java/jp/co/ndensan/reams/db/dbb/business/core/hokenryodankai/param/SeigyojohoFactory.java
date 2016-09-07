/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param;

import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険料段階判定（機能見直し）パラメータ作成のクラスです。
 *
 * @reamsid_L DBB-9040-020 cuilin
 */
public class SeigyojohoFactory {

    /**
     * 制御情報作成メソッド
     *
     * @param hokenryoDankaiList HokenryoDankaiList
     * @param kijunNenkinShunyu01 Decimal
     * @param kijunNenkinShunyu02 Decimal
     * @param kijunNenkinShunyu03 Decimal
     * @param kijunShotokuKingaku01 Decimal
     * @param kijunShotokuKingaku02 Decimal
     * @param kijunShotokuKingaku03 Decimal
     * @param kijunShotokuKingaku04 Decimal
     * @param kijunShotokuKingaku05 Decimal
     * @param kijunShotokuKingaku06 Decimal
     * @param kijunShotokuKingaku07 Decimal
     * @param kijunShotokuKingaku08 Decimal
     * @param kijunShotokuKingaku09 Decimal
     * @param kijunShotokuKingaku10 Decimal
     * @param kijunShotokuKingaku11 Decimal
     * @param kijunShotokuKingaku12 Decimal
     * @param kijunShotokuKingaku13 Decimal
     * @param kijunShotokuKingaku14 Decimal
     * @param kijunShotokuKingaku15 Decimal
     * @param kazeisouShotokuDankai RString
     * @param usesMishinkokuDankai boolean
     * @param mishinkokuDankai RString
     * @param mishinkokuKazeiKubun KazeiKubun
     * @param usesShotokuChosachuDankai boolean
     * @param shotokuChosachuDankai RString
     * @param shotokuChosachuKazeiKubun KazeiKubun
     * @param usesKazeiTorikeshiDankai boolean
     * @param kazeiTorikeshiDankai RString
     * @param kazeiTorikeshiKazeiKubun KazeiKubun
     * @return 制御情報クラス SeigyoJoho
     */
    public SeigyoJoho createSeigyojoho(HokenryoDankaiList hokenryoDankaiList,
            Decimal kijunNenkinShunyu01,
            Decimal kijunNenkinShunyu02,
            Decimal kijunNenkinShunyu03,
            Decimal kijunShotokuKingaku01,
            Decimal kijunShotokuKingaku02,
            Decimal kijunShotokuKingaku03,
            Decimal kijunShotokuKingaku04,
            Decimal kijunShotokuKingaku05,
            Decimal kijunShotokuKingaku06,
            Decimal kijunShotokuKingaku07,
            Decimal kijunShotokuKingaku08,
            Decimal kijunShotokuKingaku09,
            Decimal kijunShotokuKingaku10,
            Decimal kijunShotokuKingaku11,
            Decimal kijunShotokuKingaku12,
            Decimal kijunShotokuKingaku13,
            Decimal kijunShotokuKingaku14,
            Decimal kijunShotokuKingaku15,
            RString kazeisouShotokuDankai,
            boolean usesMishinkokuDankai,
            RString mishinkokuDankai,
            KazeiKubun mishinkokuKazeiKubun,
            boolean usesShotokuChosachuDankai,
            RString shotokuChosachuDankai,
            KazeiKubun shotokuChosachuKazeiKubun,
            boolean usesKazeiTorikeshiDankai,
            RString kazeiTorikeshiDankai,
            KazeiKubun kazeiTorikeshiKazeiKubun) {
        SeigyoJoho seigyoJoho = new SeigyoJoho();

        seigyoJoho.setHokenryoDankaiList(hokenryoDankaiList);

        seigyoJoho.setKijunNenkinShunyu01(kijunNenkinShunyu01);
        seigyoJoho.setKijunNenkinShunyu02(kijunNenkinShunyu02);
        seigyoJoho.setKijunNenkinShunyu03(kijunNenkinShunyu03);

        seigyoJoho.setKijunShotokuKingaku01(kijunShotokuKingaku01);
        seigyoJoho.setKijunShotokuKingaku02(kijunShotokuKingaku02);
        seigyoJoho.setKijunShotokuKingaku03(kijunShotokuKingaku03);
        seigyoJoho.setKijunShotokuKingaku04(kijunShotokuKingaku04);
        seigyoJoho.setKijunShotokuKingaku05(kijunShotokuKingaku05);
        seigyoJoho.setKijunShotokuKingaku06(kijunShotokuKingaku06);
        seigyoJoho.setKijunShotokuKingaku07(kijunShotokuKingaku07);
        seigyoJoho.setKijunShotokuKingaku08(kijunShotokuKingaku08);
        seigyoJoho.setKijunShotokuKingaku09(kijunShotokuKingaku09);
        seigyoJoho.setKijunShotokuKingaku10(kijunShotokuKingaku10);
        seigyoJoho.setKijunShotokuKingaku11(kijunShotokuKingaku11);
        seigyoJoho.setKijunShotokuKingaku12(kijunShotokuKingaku12);
        seigyoJoho.setKijunShotokuKingaku13(kijunShotokuKingaku13);
        seigyoJoho.setKijunShotokuKingaku14(kijunShotokuKingaku14);
        seigyoJoho.setKijunShotokuKingaku15(kijunShotokuKingaku15);

        seigyoJoho.setKazeisouShotokuDankai(kazeisouShotokuDankai);

        seigyoJoho.setUsesMishinkokuDankai(usesMishinkokuDankai);
        seigyoJoho.setMishinkokuDankai(mishinkokuDankai);
        seigyoJoho.setMishinkokuKazeiKubun(mishinkokuKazeiKubun);

        seigyoJoho.setUsesShotokuChosachuDankai(usesShotokuChosachuDankai);
        seigyoJoho.setShotokuChosachuDankai(shotokuChosachuDankai);
        seigyoJoho.setShotokuChosachuKazeiKubun(shotokuChosachuKazeiKubun);

        seigyoJoho.setUsesKazeiTorikeshiDankai(usesKazeiTorikeshiDankai);
        seigyoJoho.setKazeiTorikeshiDankai(kazeiTorikeshiDankai);
        seigyoJoho.setKazeiTorikeshiKazeiKubun(kazeiTorikeshiKazeiKubun);

        return seigyoJoho;
    }
}
