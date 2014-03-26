/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaJisshibashoKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査の実施場所区分を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaJisshibashoKubunTest {

    private static final int AS_コードがNULL = 1;
    private static final int AS_名称がNULL = 2;
    private static final int AS_略称がNULL = 3;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaJisshibashoKubun(AS_コードがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 名称がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaJisshibashoKubun(AS_名称がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 略称がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaJisshibashoKubun(AS_名称がNULL);
        }
    }

    private static NinteichosaJisshibashoKubun createNinteichosaJisshibashoKubun(int flg) {
        return new NinteichosaJisshibashoKubun(
                flg == AS_コードがNULL ? null : new NinteichosaJisshibashoKubunCode(new RString("1")),
                flg == AS_名称がNULL ? null : new RString("名称"),
                flg == AS_略称がNULL ? null : new RString("略称"));
    }
}
