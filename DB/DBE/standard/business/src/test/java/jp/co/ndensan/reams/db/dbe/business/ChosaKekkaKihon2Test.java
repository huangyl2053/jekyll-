/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun2;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（基本調査第2群）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaKihon2Test {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 移乗がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    null,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 移動がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    null,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 嚥下がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    null,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 食事摂取がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    null,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 排尿がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    null,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 排便がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    null,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 口腔清潔がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    null,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 洗顔がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    null,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 整髪がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    null,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 上衣の着脱がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    null,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void ズボン等の着脱がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    null,
                    ChosaKekkaKubun2.GaishutsuHindo.週１回以上);
        }

        @Test(expected = NullPointerException.class)
        public void 外出頻度がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon2(
                    ChosaKekkaKubun2.Ijo.自立,
                    ChosaKekkaKubun2.Ido.全介助,
                    ChosaKekkaKubun2.Enge.できる,
                    ChosaKekkaKubun2.ShokujiSesshu.自立,
                    ChosaKekkaKubun2.Hainyo.一部介助,
                    ChosaKekkaKubun2.Haiben.見守り等,
                    ChosaKekkaKubun2.KokoSeiketsu.全介助,
                    ChosaKekkaKubun2.Sengan.自立,
                    ChosaKekkaKubun2.Seihatsu.一部介助,
                    ChosaKekkaKubun2.JoiChakudatsu.見守り等,
                    ChosaKekkaKubun2.ZubonChakudatsu.全介助,
                    null);
        }
    }
}
