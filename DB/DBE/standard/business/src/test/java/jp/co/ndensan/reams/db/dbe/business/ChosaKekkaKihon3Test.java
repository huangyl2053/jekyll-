/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun3;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（基本調査第3群）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaKihon3Test {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 意思の伝達がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon3(
                    null,
                    ChosaKekkaKubun3.Nikka.できない,
                    ChosaKekkaKubun3.Seinengappi.できる,
                    ChosaKekkaKubun3.TankiKioku.できない,
                    ChosaKekkaKubun3.Namae.できる,
                    ChosaKekkaKubun3.Kisetsu.できない,
                    ChosaKekkaKubun3.Basho.できる,
                    ChosaKekkaKubun3.Haikai.ない,
                    ChosaKekkaKubun3.Gaishutsu.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 毎日の日課を理解がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon3(
                    ChosaKekkaKubun3.IshiDentatsu.できる,
                    null,
                    ChosaKekkaKubun3.Seinengappi.できる,
                    ChosaKekkaKubun3.TankiKioku.できない,
                    ChosaKekkaKubun3.Namae.できる,
                    ChosaKekkaKubun3.Kisetsu.できない,
                    ChosaKekkaKubun3.Basho.できる,
                    ChosaKekkaKubun3.Haikai.ない,
                    ChosaKekkaKubun3.Gaishutsu.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 生年月日をいうがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon3(
                    ChosaKekkaKubun3.IshiDentatsu.できる,
                    ChosaKekkaKubun3.Nikka.できない,
                    null,
                    ChosaKekkaKubun3.TankiKioku.できない,
                    ChosaKekkaKubun3.Namae.できる,
                    ChosaKekkaKubun3.Kisetsu.できない,
                    ChosaKekkaKubun3.Basho.できる,
                    ChosaKekkaKubun3.Haikai.ない,
                    ChosaKekkaKubun3.Gaishutsu.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 短期記憶がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon3(
                    ChosaKekkaKubun3.IshiDentatsu.できる,
                    ChosaKekkaKubun3.Nikka.できない,
                    ChosaKekkaKubun3.Seinengappi.できる,
                    null,
                    ChosaKekkaKubun3.Namae.できる,
                    ChosaKekkaKubun3.Kisetsu.できない,
                    ChosaKekkaKubun3.Basho.できる,
                    ChosaKekkaKubun3.Haikai.ない,
                    ChosaKekkaKubun3.Gaishutsu.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 自分の名前をいうがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon3(
                    ChosaKekkaKubun3.IshiDentatsu.できる,
                    ChosaKekkaKubun3.Nikka.できない,
                    ChosaKekkaKubun3.Seinengappi.できる,
                    ChosaKekkaKubun3.TankiKioku.できない,
                    null,
                    ChosaKekkaKubun3.Kisetsu.できない,
                    ChosaKekkaKubun3.Basho.できる,
                    ChosaKekkaKubun3.Haikai.ない,
                    ChosaKekkaKubun3.Gaishutsu.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 今の季節を理解がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon3(
                    ChosaKekkaKubun3.IshiDentatsu.できる,
                    ChosaKekkaKubun3.Nikka.できない,
                    ChosaKekkaKubun3.Seinengappi.できる,
                    ChosaKekkaKubun3.TankiKioku.できない,
                    ChosaKekkaKubun3.Namae.できる,
                    null,
                    ChosaKekkaKubun3.Basho.できる,
                    ChosaKekkaKubun3.Haikai.ない,
                    ChosaKekkaKubun3.Gaishutsu.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 場所の理解がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon3(
                    ChosaKekkaKubun3.IshiDentatsu.できる,
                    ChosaKekkaKubun3.Nikka.できない,
                    ChosaKekkaKubun3.Seinengappi.できる,
                    ChosaKekkaKubun3.TankiKioku.できない,
                    ChosaKekkaKubun3.Namae.できる,
                    ChosaKekkaKubun3.Kisetsu.できない,
                    null,
                    ChosaKekkaKubun3.Haikai.ない,
                    ChosaKekkaKubun3.Gaishutsu.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 徘徊がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon3(
                    ChosaKekkaKubun3.IshiDentatsu.できる,
                    ChosaKekkaKubun3.Nikka.できない,
                    ChosaKekkaKubun3.Seinengappi.できる,
                    ChosaKekkaKubun3.TankiKioku.できない,
                    ChosaKekkaKubun3.Namae.できる,
                    ChosaKekkaKubun3.Kisetsu.できない,
                    ChosaKekkaKubun3.Basho.できる,
                    null,
                    ChosaKekkaKubun3.Gaishutsu.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 外出して戻れないがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon3(
                    ChosaKekkaKubun3.IshiDentatsu.できる,
                    ChosaKekkaKubun3.Nikka.できない,
                    ChosaKekkaKubun3.Seinengappi.できる,
                    ChosaKekkaKubun3.TankiKioku.できない,
                    ChosaKekkaKubun3.Namae.できる,
                    ChosaKekkaKubun3.Kisetsu.できない,
                    ChosaKekkaKubun3.Basho.できる,
                    ChosaKekkaKubun3.Haikai.ない,
                    null);
        }
    }
}
