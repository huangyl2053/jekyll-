/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 期割額を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KiwarigakuTest {

    private static Kiwarigaku sut;
    private static final List<KiwarigakuMeisai> 期割額明細 = new ArrayList<>();
    private static final Decimal 特徴期別額合計 = new Decimal(1000);
    private static final Decimal 特徴納付額合計 = new Decimal(2000);
    private static final Decimal 普徴期別額合計 = new Decimal(3000);
    private static final Decimal 普徴納付額合計 = new Decimal(4000);

    public static class コンストラクタ extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 期割額明細がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new Kiwarigaku(null, 特徴期別額合計, 特徴納付額合計, 普徴期別額合計, 普徴納付額合計);
        }

        @Test(expected = NullPointerException.class)
        public void 特徴期別額合計がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new Kiwarigaku(期割額明細, null, 特徴納付額合計, 普徴期別額合計, 普徴納付額合計);
        }

        @Test(expected = NullPointerException.class)
        public void 特徴納付額合計がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new Kiwarigaku(期割額明細, 特徴期別額合計, null, 普徴期別額合計, 普徴納付額合計);
        }

        @Test(expected = NullPointerException.class)
        public void 普徴期別額合計がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new Kiwarigaku(期割額明細, 特徴期別額合計, 特徴納付額合計, null, 普徴納付額合計);
        }

        @Test(expected = NullPointerException.class)
        public void 普徴納付額合計がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new Kiwarigaku(期割額明細, 特徴期別額合計, 特徴納付額合計, 普徴期別額合計, null);
        }
    }
}
