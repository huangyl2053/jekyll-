/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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

    private static final int AS_認定調査実施年月日がNULL = 1;
    private static final int AS_認定調査依頼区分がNULL = 2;
    private static final int AS_認定調査実施場所区分がNULL = 3;
    private static final int AS_認定調査区分がNULL = 4;
    private static final int AS_審査会優先振分区分がNULL = 5;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 認定調査実施年月日がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyoKihon(AS_認定調査実施年月日がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyoKihon(AS_認定調査依頼区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査実施場所区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyoKihon(AS_認定調査実施場所区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyoKihon(AS_認定調査区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 審査会優先振分区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyoKihon(AS_審査会優先振分区分がNULL);
        }
    }

    private static NinteichosaResultOfGaikyoKihon createNinteichosaResultGaikyoKihon(int flg) {
        return new NinteichosaResultOfGaikyoKihon(
                flg == AS_認定調査実施年月日がNULL ? null : any(FlexibleDate.class),
                flg == AS_認定調査依頼区分がNULL ? null : any(NinteichosaIraiKubunCode.class),
                flg == AS_認定調査実施場所区分がNULL ? null : any(NinteichosaJisshibashoKubun.class),
                flg == AS_認定調査区分がNULL ? null : any(NinteichosaKubun.class),
                flg == AS_審査会優先振分区分がNULL ? null : any(ShinsakaiFuriwakeKubun.class));
    }
}
