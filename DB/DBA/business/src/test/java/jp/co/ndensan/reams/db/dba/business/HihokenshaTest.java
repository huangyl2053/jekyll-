/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.db.dba.definition.HihokenshaKubun;
import jp.co.ndensan.reams.db.dba.definition.ShikakuIdoKubun;
import jp.co.ndensan.reams.ur.urf.business.HokenShubetsu;
import jp.co.ndensan.reams.ur.urf.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urf.business._KaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * Hihokenshaクラスのテストクラスです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaTest {

    private static ShikakuIdoKubun 資格異動区分 = ShikakuIdoKubun.資格取得;
    private static HihokenshaKubun 被保険者区分 = HihokenshaKubun.第1号被保険者;

    public HihokenshaTest() {
    }

    public static IKaigoShikaku create介護保険資格() {
        return mock(_KaigoShikaku.class);
    }

    public static class コンストラクタ引数_IKigoShikaku関係のテスト {

        private Hihokensha sut;
        private IKaigoShikaku shikaku;

        @Before
        public void setUp() {
            shikaku = create介護保険資格();
            sut = new Hihokensha(shikaku, 資格異動区分, 被保険者区分);
        }

        @Test
        public void get被保険者番号は_コンストラクタ引数のIKaigoShikakuが保持する_被保険者番号を返す() {
            RString 被保険者番号 = new RString("0000000001");
            when(shikaku.get被保険者番号()).thenReturn(被保険者番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void get介護保険広域構成市町村コードは_コンストラクタ引数のIKaigoShikakuが保持する_介護保険広域構成市町村コードを返す() {
            RString 市町村コード = new RString("12345");
            when(shikaku.get介護保険広域構成市町村コード()).thenReturn(市町村コード);
            assertThat(sut.get介護保険広域構成市町村コード(), is(市町村コード));
        }

        @Test
        public void get一号該当日は_コンストラクタ引数のIKaigoShikakuが保持する_一号該当日を返す() {
            RDate 一号該当日 = new RDate("20131231");
            when(shikaku.get一号該当日()).thenReturn(一号該当日);
            assertThat(sut.get一号該当日(), is(一号該当日));
        }

        @Test
        public void get識別コードは_コンストラクタ引数のIKaigoShikakuが保持する_識別コードを返す() {
            IShikibetsuCode 識別コード = mock(_ShikibetsuCode.class);
            when(shikaku.get識別コード()).thenReturn(識別コード);
            assertThat(sut.get識別コード(), is(識別コード));
        }

        @Test
        public void get保険種別は_コンストラクタ引数のIKaigoShikakuが保持する_保険種別を返す() {
            when(shikaku.get保険種別()).thenReturn(HokenShubetsu.介護保険);
            assertThat(sut.get保険種別(), is(HokenShubetsu.介護保険));
        }

        @Test
        public void get資格取得届出年月日は_コンストラクタ引数のIKaigoShikakuが保持する_資格取得届出年月日を返す() {
            RDate 資格取得届出年月日 = new RDate("20140228");
            when(shikaku.get資格取得届出年月日()).thenReturn(資格取得届出年月日);
            assertThat(sut.get資格取得届出年月日(), is(資格取得届出年月日));
        }

        @Test
        public void get資格取得年月日は_コンストラクタ引数のIKaigoShikakuが保持する_資格取得年月日を返す() {
            RDate 資格取得年月日 = new RDate(2013, 3, 4);
            when(shikaku.get資格取得年月日()).thenReturn(資格取得年月日);
            assertThat(sut.get資格取得年月日(), is(資格取得年月日));
        }

        @Test
        public void get資格取得事由は_コンストラクタ引数のIKaigoShikakuが保持する_資格取得事由を返す() {
            RString 資格取得事由 = new RString("年齢到達");
            when(shikaku.get資格取得事由()).thenReturn(資格取得事由);
            assertThat(sut.get資格取得事由(), is(資格取得事由));
        }

        @Test
        public void get資格喪失届出年月日は_コンストラクタ引数のIKaigoShikakuが保持する_資格喪失届出年月日を返す() {
            RDate 資格喪失届出年月日 = new RDate("平成25年3月2日");
            when(shikaku.get資格喪失届出年月日()).thenReturn(資格喪失届出年月日);
            assertThat(sut.get資格喪失届出年月日(), is(資格喪失届出年月日));
        }

        @Test
        public void get資格喪失年月日は_コンストラクタ引数のIKaigoShikakuが保持する_資格喪失年月日を返す() {
            RDate 資格喪失年月日 = new RDate("364.1.07");
            when(shikaku.get資格喪失年月日()).thenReturn(資格喪失年月日);
            assertThat(sut.get資格喪失年月日(), is(資格喪失年月日));
        }

        @Test
        public void get資格喪失事由は_コンストラクタ引数のIKaigoShikakuが保持する_資格喪失事由を返す() {
            RString 資格喪失事由 = new RString("転出");
            when(shikaku.get資格喪失事由()).thenReturn(資格喪失事由);
            assertThat(sut.get資格喪失事由(), is(資格喪失事由));
        }

        @Test
        public void is資格あり_コンストラクタ引数のIKaigoShikakuのis資格ありと_同じ結果を返す() {
            RDate testDate = new RDate("364.1.07");
            Boolean is資格あり = true;
            when(shikaku.is資格あり(testDate)).thenReturn(is資格あり);
            assertThat(sut.is資格あり(testDate), is(is資格あり));
        }
    }

    public static class コンストラクタのテスト {

        private IKaigoShikaku 介護保険資格 = create介護保険資格();

        @Test(expected = NullPointerException.class)
        public void コンストラクタのIKaigoShikakuにnullを指定した時_NullPointerExceptionを返す() {
            Hihokensha sut = new Hihokensha(null, 資格異動区分, 被保険者区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタのShikakuIdoKubunにnullを指定した時_NullPointerExceptionを返す() {
            Hihokensha sut = new Hihokensha(介護保険資格, null, 被保険者区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタのHihokenshaKubunにnullを指定した時_NullPointerExceptionを返す() {
            Hihokensha sut = new Hihokensha(介護保険資格, 資格異動区分, null);
        }
    }

    public static class その他のコンストラクタ引数に関するテスト {

        private Hihokensha sut;
        private IKaigoShikaku shikaku;
        private ShikakuIdoKubun 資格異動区分 = ShikakuIdoKubun.資格取得;
        private HihokenshaKubun 被保険者区分 = HihokenshaKubun.第1号被保険者;

        @Before
        public void setUp() {
            shikaku = create介護保険資格();
            sut = new Hihokensha(shikaku, 資格異動区分, 被保険者区分);
        }

        @Test
        public void get資格異動区分は_コンストラクタ引数の_資格異動区分を返す() {
            assertThat(sut.get資格異動区分(), is(資格異動区分));
        }

        @Test
        public void get被保険者区分は_コンストラクタ引数の_被保険者区分を返す() {
            assertThat(sut.get被保険者区分(), is(被保険者区分));
        }
    }
}
