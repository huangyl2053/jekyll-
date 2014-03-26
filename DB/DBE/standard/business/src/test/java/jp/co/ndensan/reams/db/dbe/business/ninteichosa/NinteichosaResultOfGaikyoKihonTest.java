/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査の調査結果（概況調査基本）を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultOfGaikyoKihonTest {

    private static final int AS_認定調査依頼区分がNULL = 1;
    private static final int AS_認定調査実施年月日がNULL = 2;
    private static final int AS_認定調査受領年月日がNULL = 3;
    private static final int AS_認定調査区分がNULL = 4;
    private static final int AS_認定調査員がNULL = 5;
    private static final int AS_認定調査実施場所区分がNULL = 6;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyoKihon(AS_認定調査依頼区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査実施年月日がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyoKihon(AS_認定調査実施年月日がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査受領年月日がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyoKihon(AS_認定調査受領年月日がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyoKihon(AS_認定調査区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査員がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyoKihon(AS_認定調査員がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査実施場所区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyoKihon(AS_認定調査実施場所区分がNULL);
        }
    }

    private static NinteichosaResultOfGaikyoKihon createNinteichosaResultOfGaikyoKihon(int flg) {
        return new NinteichosaResultOfGaikyoKihon(
                //                flg == AS_認定調査依頼区分がNULL ? null : any(NinteichosaIraiKubun.class), 1,
                //                flg == AS_認定調査実施年月日がNULL ? null : any(FlexibleDate.class),
                //                flg == AS_認定調査受領年月日がNULL ? null : any(FlexibleDate.class),
                //                flg == AS_認定調査区分がNULL ? null : any(NinteichosaKubun.class),
                //                flg == AS_認定調査員がNULL ? null : any(INinteiChosain.class),
                //                flg == AS_認定調査実施場所区分がNULL ? null : any(NinteichosaJisshibashoKubun.class));
                flg == AS_認定調査依頼区分がNULL ? null : NinteichosaIraiKubun.toValue(new RString("1")), 1,
                flg == AS_認定調査実施年月日がNULL ? null : new FlexibleDate("00000000"),
                flg == AS_認定調査受領年月日がNULL ? null : new FlexibleDate("00000000"),
                flg == AS_認定調査区分がNULL ? null : NinteichosaKubun.新規調査,
                flg == AS_認定調査員がNULL ? null : mock(INinteiChosain.class),
                flg == AS_認定調査実施場所区分がNULL ? null : mock(NinteichosaJisshibashoKubun.class));
    }
}
