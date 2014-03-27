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

/**
 * HihokenshashoSaikofuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshashoSaikofuTest extends DbzTestBase {

    public static class get有無区分 extends DbzTestBase {

        @Test
        public void get有無区分は_コンストラクタ引数のHihokenshashoSaikofuKubunがnullのとき_なしを返す() {
            HihokenshashoSaikofu sut = new HihokenshashoSaikofu(null, null, null);
            assertThat(sut.get有無区分(), is(HihokenshashoSaikofuKubun.なし));
        }

        @Test
        public void get有無区分は_コンストラクタ引数のHihokenshashoSaikofuKubunがnullではないとき_同じ値を返す() {
            HihokenshashoSaikofuKubun kubun = HihokenshashoSaikofuKubun.あり;
            HihokenshashoSaikofu sut = new HihokenshashoSaikofu(kubun, null, null);
            assertThat(sut.get有無区分(), is(kubun));
        }
    }

    public static class Exists extends DbzTestBase {

        @Test
        public void existsは_コンストラクタ引数のHihokenshashoSaikofuKubunが_あり_のとき_trueを返す() {
            HihokenshashoSaikofuKubun kubun = HihokenshashoSaikofuKubun.あり;
            HihokenshashoSaikofu sut = new HihokenshashoSaikofu(kubun, null, null);
            assertThat(sut.exists(), is(true));
        }

        @Test
        public void existsは_コンストラクタ引数のHihokenshashoSaikofuKubunが_あり_でないとき_falseを返す() {
            HihokenshashoSaikofuKubun kubun = HihokenshashoSaikofuKubun.なし;
            HihokenshashoSaikofu sut = new HihokenshashoSaikofu(kubun, null, null);
            assertThat(sut.exists(), is(false));
        }
    }

    public static class GetReason extends DbzTestBase {

        @Test
        public void getReasonは_コンストラクタ引数のHihokenshashoSaikofuJiyuがnullのとき_なしを返す() {
            HihokenshashoSaikofu sut = new HihokenshashoSaikofu(null, null, null);
            assertThat(sut.getReason(), is(HihokenshashoSaikofuJiyu.なし));
        }

        @Test
        public void getReasonは_コンストラクタ引数のHihokenshashoSaikofuJiyuがnullでないとき_同じ値を返す() {
            HihokenshashoSaikofuJiyu reason = HihokenshashoSaikofuJiyu.その他;
            HihokenshashoSaikofu sut = new HihokenshashoSaikofu(null, reason, null);
            assertThat(sut.getReason(), is(reason));
        }
    }

    public static class getChohyoKofuRirekiID extends DbzTestBase {

        @Test
        public void get帳票交付履歴IDは_コンストラクタ引数のChohyoKofuRirekiIDと_同じ値を返す() {
            ChohyoKofuRirekiID id = new ChohyoKofuRirekiID(new RString(""));
            HihokenshashoSaikofu sut = new HihokenshashoSaikofu(null, null, id);
            assertThat(sut.getChohyoKofuRirekiID(), is(id));
        }
    }
}
