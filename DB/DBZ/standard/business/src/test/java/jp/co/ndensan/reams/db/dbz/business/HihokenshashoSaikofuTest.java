/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChohyoKofuRirekiID;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Before;

/**
 * HihokenshashoSaikofuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshashoSaikofuTest extends DbzTestBase {

    public static class NONE extends DbzTestBase {

        HihokenshashoSaikofu sut = HihokenshashoSaikofu.NOTHING;

        @Test
        public void NONEの_get有無区分は_なしを返す() {
            assertThat(sut.get有無区分(), is(HihokenshashoSaikofuKubun.なし));
        }

        @Test
        public void NONEの_getReasonは_なしを返す() {
            assertThat(sut.getReason(), is(HihokenshashoSaikofuJiyu.なし));
        }

        @Test
        public void NONEの_get帳票交付履歴IDは_nullを返す() {
            assertThat(sut.getChohyoKofuRirekiID(), is(nullValue()));
        }
    }

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタ引数の_被保険者証再交付事由_がnullのとき_NullPointerExceptionをスローする() {
            HihokenshashoSaikofu sut = new HihokenshashoSaikofu(null, new ChohyoKofuRirekiID(RString.EMPTY));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタ引数の_帳票交付履歴ID_がnullのとき_NullPointerExceptionをスローする() {
            HihokenshashoSaikofu sut = new HihokenshashoSaikofu(HihokenshashoSaikofuJiyu.EMPTY, null);
        }
    }

    public static class createByConstructor extends DbzTestBase {

        private HihokenshashoSaikofuJiyu reason;
        private ChohyoKofuRirekiID id;
        HihokenshashoSaikofu sut;

        @Before
        public void setUp() {
            reason = HihokenshashoSaikofuJiyu.その他;
            id = new ChohyoKofuRirekiID(RString.EMPTY);
            sut = new HihokenshashoSaikofu(reason, id);
        }

        @Test
        public void コンストラクタから生成したとき_get有無区分は_ありを返す() {
            assertThat(sut.get有無区分(), is(HihokenshashoSaikofuKubun.あり));
        }

        @Test
        public void コンストラクタから生成したとき_existsは_trueを返す() {
            assertThat(sut.exists(), is(true));
        }

        @Test
        public void コンストラクタから生成したとき_get帳票交付履歴IDは_コンストラクタ引数のChohyoKofuRirekiIDと_同じ値を返す() {
            assertThat(sut.getChohyoKofuRirekiID(), is(id));
        }
    }
}
