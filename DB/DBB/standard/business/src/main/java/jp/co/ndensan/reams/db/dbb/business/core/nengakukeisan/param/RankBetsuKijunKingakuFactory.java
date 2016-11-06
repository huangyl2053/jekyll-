/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 年額保険料計算（機能見直し）パラメータランク別制御情報作成のクラスです。
 *
 * @reamsid_L DBB-9040-030 cuilin
 */
public class RankBetsuKijunKingakuFactory {

    /**
     * ランク別制御情報作成メソッドです。
     *
     * @param ランク基準金額1 Decimal
     * @param ランク基準金額2 Decimal
     * @param ランク基準金額3 Decimal
     * @param ランク基準金額4 Decimal
     * @param ランク基準金額5 Decimal
     * @param ランク基準金額6 Decimal
     * @param ランク基準金額7 Decimal
     * @param ランク基準金額8 Decimal
     * @param ランク基準金額9 Decimal
     * @param ランク基準金額10 Decimal
     * @param ランク基準金額11 Decimal
     * @param ランク基準金額12 Decimal
     * @param ランク基準金額13 Decimal
     * @param ランク基準金額14 Decimal
     * @param ランク基準金額15 Decimal
     * @param ランク基準金額16 Decimal
     * @param ランク基準金額17 Decimal
     * @param ランク基準金額18 Decimal
     * @param ランク基準金額19 Decimal
     * @param ランク基準金額20 Decimal
     * @return RankBetsuKijunKingaku
     */
    public RankBetsuKijunKingaku createRankBetsuKijunKingaku(Decimal ランク基準金額1,
            Decimal ランク基準金額2,
            Decimal ランク基準金額3,
            Decimal ランク基準金額4,
            Decimal ランク基準金額5,
            Decimal ランク基準金額6,
            Decimal ランク基準金額7,
            Decimal ランク基準金額8,
            Decimal ランク基準金額9,
            Decimal ランク基準金額10,
            Decimal ランク基準金額11,
            Decimal ランク基準金額12,
            Decimal ランク基準金額13,
            Decimal ランク基準金額14,
            Decimal ランク基準金額15,
            Decimal ランク基準金額16,
            Decimal ランク基準金額17,
            Decimal ランク基準金額18,
            Decimal ランク基準金額19,
            Decimal ランク基準金額20) {
        RankBetsuKijunKingaku rankBetsuKijunKingaku = new RankBetsuKijunKingaku();
        rankBetsuKijunKingaku.setランク基準金額1(ランク基準金額1);
        rankBetsuKijunKingaku.setランク基準金額2(ランク基準金額2);
        rankBetsuKijunKingaku.setランク基準金額3(ランク基準金額3);
        rankBetsuKijunKingaku.setランク基準金額4(ランク基準金額4);
        rankBetsuKijunKingaku.setランク基準金額5(ランク基準金額5);
        rankBetsuKijunKingaku.setランク基準金額6(ランク基準金額6);
        rankBetsuKijunKingaku.setランク基準金額7(ランク基準金額7);
        rankBetsuKijunKingaku.setランク基準金額8(ランク基準金額8);
        rankBetsuKijunKingaku.setランク基準金額9(ランク基準金額9);
        rankBetsuKijunKingaku.setランク基準金額10(ランク基準金額10);
        rankBetsuKijunKingaku.setランク基準金額11(ランク基準金額11);
        rankBetsuKijunKingaku.setランク基準金額12(ランク基準金額12);
        rankBetsuKijunKingaku.setランク基準金額13(ランク基準金額13);
        rankBetsuKijunKingaku.setランク基準金額14(ランク基準金額14);
        rankBetsuKijunKingaku.setランク基準金額15(ランク基準金額15);
        rankBetsuKijunKingaku.setランク基準金額16(ランク基準金額16);
        rankBetsuKijunKingaku.setランク基準金額17(ランク基準金額17);
        rankBetsuKijunKingaku.setランク基準金額18(ランク基準金額18);
        rankBetsuKijunKingaku.setランク基準金額19(ランク基準金額19);
        rankBetsuKijunKingaku.setランク基準金額20(ランク基準金額20);

        return rankBetsuKijunKingaku;
    }
}
