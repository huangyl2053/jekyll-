/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun5;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（基本調査第5群）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaKihon5Test {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 薬の内服がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon5(
                    null,
                    ChosaKekkaKubun5.KinsenKanri.全介助,
                    ChosaKekkaKubun5.IshiKettei.できる,
                    ChosaKekkaKubun5.ShudanFutekio.ない,
                    ChosaKekkaKubun5.Kaimono.自立,
                    ChosaKekkaKubun5.Chori.全介助);
        }

        @Test(expected = NullPointerException.class)
        public void 金銭の管理がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon5(
                    ChosaKekkaKubun5.Kusuri.自立,
                    null,
                    ChosaKekkaKubun5.IshiKettei.できる,
                    ChosaKekkaKubun5.ShudanFutekio.ない,
                    ChosaKekkaKubun5.Kaimono.自立,
                    ChosaKekkaKubun5.Chori.全介助);
        }

        @Test(expected = NullPointerException.class)
        public void 日常の意思決定がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon5(
                    ChosaKekkaKubun5.Kusuri.自立,
                    ChosaKekkaKubun5.KinsenKanri.全介助,
                    null,
                    ChosaKekkaKubun5.ShudanFutekio.ない,
                    ChosaKekkaKubun5.Kaimono.自立,
                    ChosaKekkaKubun5.Chori.全介助);
        }

        @Test(expected = NullPointerException.class)
        public void 集団への不適応がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon5(
                    ChosaKekkaKubun5.Kusuri.自立,
                    ChosaKekkaKubun5.KinsenKanri.全介助,
                    ChosaKekkaKubun5.IshiKettei.できる,
                    null,
                    ChosaKekkaKubun5.Kaimono.自立,
                    ChosaKekkaKubun5.Chori.全介助);
        }

        @Test(expected = NullPointerException.class)
        public void 買い物がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon5(
                    ChosaKekkaKubun5.Kusuri.自立,
                    ChosaKekkaKubun5.KinsenKanri.全介助,
                    ChosaKekkaKubun5.IshiKettei.できる,
                    ChosaKekkaKubun5.ShudanFutekio.ない,
                    null,
                    ChosaKekkaKubun5.Chori.全介助);
        }

        @Test(expected = NullPointerException.class)
        public void 簡単な調理がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon5(
                    ChosaKekkaKubun5.Kusuri.自立,
                    ChosaKekkaKubun5.KinsenKanri.全介助,
                    ChosaKekkaKubun5.IshiKettei.できる,
                    ChosaKekkaKubun5.ShudanFutekio.ない,
                    ChosaKekkaKubun5.Kaimono.自立,
                    null);
        }
    }
}
