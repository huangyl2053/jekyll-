/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun1;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（基本調査第1群）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaKihon1Test {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 麻痺左上肢がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    null,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 麻痺右上肢がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    null,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 麻痺左下肢がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    null,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 麻痺右下肢がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    null,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 麻痺その他がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    null,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 拘縮肩関節がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    null,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 拘縮股関節がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    null,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 拘縮膝関節がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    null,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 拘縮その他がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    null,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 寝返りがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    null,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 起き上がりがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    null,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 座位保持がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    null,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 両足での立位がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    null,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 歩行がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    null,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 立ち上がりがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    null,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 片足での立位がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    null,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 洗身がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    null,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void つめ切りがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    null,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 視力がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    null,
                    ChosaKekkaKubun1.Choryoku.判断不能);
        }

        @Test(expected = NullPointerException.class)
        public void 聴力がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon1(
                    ChosaKekkaKubun1.MahiHidariJoshi.ない,
                    ChosaKekkaKubun1.MahiMigiJoshi.ある,
                    ChosaKekkaKubun1.MahiHidariKashi.ない,
                    ChosaKekkaKubun1.MahiMigiKashi.ある,
                    ChosaKekkaKubun1.MahiSonota.ない,
                    ChosaKekkaKubun1.KoshukuKata.ある,
                    ChosaKekkaKubun1.KoshukuMata.ない,
                    ChosaKekkaKubun1.KoshukuHiza.ある,
                    ChosaKekkaKubun1.KoshukuSonota.ない,
                    ChosaKekkaKubun1.Negaeri.できる,
                    ChosaKekkaKubun1.Okiagari.できない,
                    ChosaKekkaKubun1.Zaihoji.できる,
                    ChosaKekkaKubun1.RyoashiRitsui.できない,
                    ChosaKekkaKubun1.Hoko.できる,
                    ChosaKekkaKubun1.Tachiagari.できない,
                    ChosaKekkaKubun1.KataashiRitsui.できる,
                    ChosaKekkaKubun1.Senshin.自立,
                    ChosaKekkaKubun1.Tsumekiri.全介助,
                    ChosaKekkaKubun1.Shiryoku.普通,
                    null);
        }
    }
}
