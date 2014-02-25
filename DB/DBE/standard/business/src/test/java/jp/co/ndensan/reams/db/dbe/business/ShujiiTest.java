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
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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

    private static final int AS_市町村コードがNULL = 0;
    private static final int AS_介護医療機関コードがNULL = 1;
    private static final int AS_介護医師コードがNULL = 2;
    private static final int AS_医療機関コードがNULL = 3;
    private static final int AS_医師識別番号がNULL = 4;
    private static final int AS_医師の状況がNULL = 5;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 市町村コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(AS_市町村コードがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医療機関コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(AS_介護医療機関コードがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医師コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(AS_介護医師コードがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 医療機関コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(AS_医療機関コードがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 医師識別番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(AS_医師識別番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 医師の状況がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujii(AS_医師の状況がNULL);
        }
    }

    private static IShujii createShujii(int flg) {
        return new Shujii(
                flg != AS_市町村コードがNULL ? any(ShichosonCode.class) : null,
                flg != AS_介護医療機関コードがNULL ? any(KaigoIryoKikanCode.class) : null,
                flg != AS_介護医師コードがNULL ? any(KaigoDoctorCode.class) : null,
                flg != AS_医療機関コードがNULL ? any(IIryoKikanCode.class) : null,
                flg != AS_医師識別番号がNULL ? any(RString.class) : null,
                flg != AS_医師の状況がNULL ? any(IshiJokyo.class) : null,
                any(YubinNo.class), any(AtenaJusho.class), any(TelNo.class), any(RString.class));
    }
}
