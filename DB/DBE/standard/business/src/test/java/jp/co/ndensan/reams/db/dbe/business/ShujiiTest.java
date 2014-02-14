/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.IYubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 主治医の情報を表すクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 市町村コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(0);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医療機関コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(1);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医師コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(2);
        }

        @Test(expected = NullPointerException.class)
        public void 医療機関コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(3);
        }

        @Test(expected = NullPointerException.class)
        public void 医師識別番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(4);
        }

        @Test(expected = NullPointerException.class)
        public void 医師の状況がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(5);
        }
    }

    private static IShujii createShujii(int flg) {
        return new Shujii(
                flg != 0 ? any(ShichosonCode.class) : null,
                flg != 1 ? any(KaigoIryoKikanCode.class) : null,
                flg != 2 ? any(KaigoDoctorCode.class) : null,
                flg != 3 ? any(IIryoKikanCode.class) : null,
                flg != 4 ? any(RString.class) : null,
                flg != 5 ? any(IshiJokyo.class) : null,
                any(IYubinNo.class), any(IJusho.class), any(RString.class), any(RString.class));
    }
}
