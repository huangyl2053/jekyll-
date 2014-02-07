/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（概況調査基本）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaGaikyoKihonTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 認定調査実施年月日がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoKihon(
                    null,
                    ChosaIraiKubun.初回,
                    new RString("12345678"),
                    new RString("認定調査実施場所名称"),
                    ChosaKubun.新規調査,
                    new RString("概況特記事項"),
                    ShinsakaiFuriwakeKubun.希望無し);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoKihon(
                    new FlexibleDate("20140101"),
                    null,
                    new RString("12345678"),
                    new RString("認定調査実施場所名称"),
                    ChosaKubun.新規調査,
                    new RString("概況特記事項"),
                    ShinsakaiFuriwakeKubun.希望無し);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査実施場所コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoKihon(
                    new FlexibleDate("20140101"),
                    ChosaIraiKubun.初回,
                    null,
                    new RString("認定調査実施場所名称"),
                    ChosaKubun.新規調査,
                    new RString("概況特記事項"),
                    ShinsakaiFuriwakeKubun.希望無し);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査実施場所名称がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoKihon(
                    new FlexibleDate("20140101"),
                    ChosaIraiKubun.初回,
                    new RString("12345678"),
                    null,
                    ChosaKubun.新規調査,
                    new RString("概況特記事項"),
                    ShinsakaiFuriwakeKubun.希望無し);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoKihon(
                    new FlexibleDate("20140101"),
                    ChosaIraiKubun.初回,
                    new RString("12345678"),
                    new RString("認定調査実施場所名称"),
                    null,
                    new RString("概況特記事項"),
                    ShinsakaiFuriwakeKubun.希望無し);
        }

        @Test(expected = NullPointerException.class)
        public void 概況特記事項がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoKihon(
                    new FlexibleDate("20140101"),
                    ChosaIraiKubun.初回,
                    new RString("12345678"),
                    new RString("認定調査実施場所名称"),
                    ChosaKubun.新規調査,
                    null,
                    ShinsakaiFuriwakeKubun.希望無し);
        }

        @Test(expected = NullPointerException.class)
        public void 審査会優先振分区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoKihon(
                    new FlexibleDate("20140101"),
                    ChosaIraiKubun.初回,
                    new RString("12345678"),
                    new RString("認定調査実施場所名称"),
                    ChosaKubun.新規調査,
                    new RString("概況特記事項"),
                    null);
        }
    }
}
