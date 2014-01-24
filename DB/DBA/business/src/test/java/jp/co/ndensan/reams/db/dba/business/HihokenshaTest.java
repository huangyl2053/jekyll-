/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.db.dba.definition.valueobject.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dba.definition.valueobject.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dba.definition.valueobject.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dba.definition.valueobject.SaikofuJiyu;
import jp.co.ndensan.reams.db.dba.definition.valueobject.HihokenshaKubun;
import jp.co.ndensan.reams.db.dba.business.helper.HihokenshaKubunMock;
import jp.co.ndensan.reams.db.dba.business.helper.JushochitokureiKaijoJiyuMock;
import jp.co.ndensan.reams.db.dba.business.helper.JushochitokureiTekiyoJiyuMock;
import jp.co.ndensan.reams.db.dba.business.helper.SaikofuJiyuMock;
import jp.co.ndensan.reams.db.dba.business.helper.ShikakuHenkoJiyuMock;
import jp.co.ndensan.reams.db.dba.business.helper.ShikakuShutokuJiyuMock;
import jp.co.ndensan.reams.db.dba.business.helper.ShikakuSoshitsuJiyuMock;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.business.HokenShubetsu;
import jp.co.ndensan.reams.ur.urf.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urf.business._KaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.IShikakuShutokuJiyu;
import jp.co.ndensan.reams.ur.urz.business.IShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 被保険者のテストクラスです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaTest extends TestBase {

    private static IKaigoShikaku 介護保険資格 = create介護保険資格();
    private static ShichosonCode 市町村コード = new ShichosonCode(new RString("11111"));
    private static ShikakuHenkoJiyu 資格変更事由 = ShikakuHenkoJiyuMock.getSpiedInstance();
    private static RDate 資格変更届出年月日 = new RDate("20120112");
    private static RDate 資格変更年月日 = new RDate("20120113");
    private static JushochitokureiTekiyoJiyu 住所地特例適用事由 = JushochitokureiTekiyoJiyuMock.getSpiedInstance();
    private static RDate 住所地特例適用届出年月日 = new RDate("20121212");
    private static RDate 住所地特例適用年月日 = new RDate("20121213");
    private static JushochitokureiKaijoJiyu 住所地特例解除事由 = JushochitokureiKaijoJiyuMock.getSpiedInstance();
    private static RDate 住所地特例解除届出年月日 = new RDate("20130112");
    private static RDate 住所地特例解除年月日 = new RDate("20130113");
    private static boolean 住所地特例有無 = false;
    private static boolean 広域内_住所地特例有無 = false;
    private static ShichosonCode 広域内住所地特例措置元_市町村コード = new ShichosonCode(new RString("11111"));
    private static boolean 再交付有無 = false;
    private static SaikofuJiyu 再交付事由 = SaikofuJiyuMock.getSpiedInstance();
    private static ShikakuIdoKubun 資格異動区分 = ShikakuIdoKubun.資格取得;
    private static HihokenshaKubun 被保険者区分 = HihokenshaKubunMock.getSpiedInstance();

    public HihokenshaTest() {
    }

    public static class コンストラクタのテスト extends TestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタ引数の介護保険資格にnullを指定した時_NullPointerExceptionを返す() {
            Hihokensha sut = new Hihokensha(null, 市町村コード, 資格異動区分, 被保険者区分,
                    null, null, null,
                    null, null, null,
                    null, null, null,
                    false, false, null, false, null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタ引数の市町村コードにnullを指定した時_NullPointerExceptionを返す() {
            Hihokensha sut = new Hihokensha(介護保険資格, null, 資格異動区分, 被保険者区分,
                    null, null, null,
                    null, null, null,
                    null, null, null,
                    false, false, null, false, null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタ引数の資格異動区分にnullを指定した時_NullPointerExceptionを返す() {
            Hihokensha sut = new Hihokensha(介護保険資格, 市町村コード, null, 被保険者区分,
                    null, null, null,
                    null, null, null,
                    null, null, null,
                    false, false, null, false, null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタ引数の被保険者区分にnullを指定した時_NullPointerExceptionを返す() {
            Hihokensha sut = new Hihokensha(介護保険資格, 市町村コード, 資格異動区分, null,
                    null, null, null,
                    null, null, null,
                    null, null, null,
                    false, false, null, false, null);
        }
    }

    public static class コンストラクタ引数_介護保険資格_関係のテスト extends TestBase {

        private Hihokensha sut;

        @Override
        public void setUp() {
            sut = create被保険者();
        }

        @Test
        public void get被保険者番号は_コンストラクタ引数のIKaigoShikakuが保持する_被保険者番号を返す() {
            RString 被保険者番号 = new RString("0000000001");
            when(介護保険資格.get被保険者番号()).thenReturn(被保険者番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void get介護保険広域構成市町村コードは_コンストラクタ引数のIKaigoShikakuが保持する_介護保険広域構成市町村コードを返す() {
            RString 市町村コード = new RString("12345");
            when(介護保険資格.get介護保険広域構成市町村コード()).thenReturn(市町村コード);
            assertThat(sut.get介護保険広域構成市町村コード(), is(市町村コード));
        }

        @Test
        public void get一号該当日は_コンストラクタ引数のIKaigoShikakuが保持する_一号該当日を返す() {
            RDate 一号該当日 = new RDate("20131231");
            when(介護保険資格.get一号該当日()).thenReturn(一号該当日);
            assertThat(sut.get一号該当日(), is(一号該当日));
        }

        @Test
        public void get識別コードは_コンストラクタ引数のIKaigoShikakuが保持する_識別コードを返す() {
            IShikibetsuCode 識別コード = mock(_ShikibetsuCode.class);
            when(介護保険資格.get識別コード()).thenReturn(識別コード);
            assertThat(sut.get識別コード(), is(識別コード));
        }

        @Test
        public void get保険種別は_コンストラクタ引数のIKaigoShikakuが保持する_保険種別を返す() {
            when(介護保険資格.get保険種別()).thenReturn(HokenShubetsu.介護保険);
            assertThat(sut.get保険種別(), is(HokenShubetsu.介護保険));
        }

        @Test
        public void get資格取得届出年月日は_コンストラクタ引数のIKaigoShikakuが保持する_資格取得届出年月日を返す() {
            RDate 資格取得届出年月日 = new RDate("20140228");
            when(介護保険資格.get資格取得届出年月日()).thenReturn(資格取得届出年月日);
            assertThat(sut.get資格取得届出年月日(), is(資格取得届出年月日));
        }

        @Test
        public void get資格取得年月日は_コンストラクタ引数のIKaigoShikakuが保持する_資格取得年月日を返す() {
            RDate 資格取得年月日 = new RDate(2013, 3, 4);
            when(介護保険資格.get資格取得年月日()).thenReturn(資格取得年月日);
            assertThat(sut.get資格取得年月日(), is(資格取得年月日));
        }

        @Test
        public void get資格取得事由は_コンストラクタ引数のIKaigoShikakuが保持する_資格取得事由を返す() {
            IShikakuShutokuJiyu 資格取得事由 = create資格取得事由();
            when(介護保険資格.get資格取得事由()).thenReturn(資格取得事由);
            assertThat(sut.get資格取得事由(), is(資格取得事由));
        }

        @Test
        public void get資格喪失届出年月日は_コンストラクタ引数のIKaigoShikakuが保持する_資格喪失届出年月日を返す() {
            RDate 資格喪失届出年月日 = new RDate("平成25年3月2日");
            when(介護保険資格.get資格喪失届出年月日()).thenReturn(資格喪失届出年月日);
            assertThat(sut.get資格喪失届出年月日(), is(資格喪失届出年月日));
        }

        @Test
        public void get資格喪失年月日は_コンストラクタ引数のIKaigoShikakuが保持する_資格喪失年月日を返す() {
            RDate 資格喪失年月日 = new RDate("364.1.07");
            when(介護保険資格.get資格喪失年月日()).thenReturn(資格喪失年月日);
            assertThat(sut.get資格喪失年月日(), is(資格喪失年月日));
        }

        @Test
        public void get資格喪失事由は_コンストラクタ引数のIKaigoShikakuが保持する_資格喪失事由を返す() {
            IShikakuSoshitsuJiyu 資格喪失事由 = create資格喪失事由();
            when(介護保険資格.get資格喪失事由()).thenReturn(資格喪失事由);
            assertThat(sut.get資格喪失事由(), is(資格喪失事由));
        }

        @Test
        public void is資格あり_コンストラクタ引数のIKaigoShikakuのis資格ありと_同じ結果を返す() {
            RDate testDate = new RDate("364.1.07");
            Boolean is資格あり = true;
            when(介護保険資格.is資格あり(testDate)).thenReturn(is資格あり);
            assertThat(sut.is資格あり(testDate), is(is資格あり));
        }
    }

    public static class その他のコンストラクタ引数に関するテスト extends TestBase {

        private Hihokensha sut;

        @Override
        public void setUp() {
            sut = create被保険者();
        }

        @Test
        public void get資格異動区分は_コンストラクタ引数の_資格異動区分を返す() {
            assertThat(sut.get資格異動区分(), is(資格異動区分));
        }

        @Test
        public void get被保険者区分は_コンストラクタ引数の_被保険者区分を返す() {
            assertThat(sut.get被保険者区分(), is(被保険者区分));
        }

        @Test
        public void get資格変更事由は_コンストラクタ引数の_資格変更事由を返す() {
            assertThat(sut.get資格変更事由(), is(資格変更事由));
        }

        @Test
        public void get資格変更届出年月日は_コンストラクタ引数の_資格変更届出年月日を返す() {
            assertThat(sut.get資格変更届出年月日(), is(資格変更届出年月日));
        }

        @Test
        public void get資格変更年月日は_コンストラクタ引数の_資格変更年月日を返す() {
            assertThat(sut.get資格変更年月日(), is(資格変更年月日));
        }

        @Test
        public void get住所地特例適用事由は_コンストラクタ引数の_住所地特例適用事由を返す() {
            assertThat(sut.get住所地特例適用事由(), is(住所地特例適用事由));
        }

        @Test
        public void get住所地特例適用届出年月日は_コンストラクタ引数の_住所地特例適用届出年月日を返す() {
            assertThat(sut.get住所地特例適用届出年月日(), is(住所地特例適用届出年月日));
        }

        @Test
        public void get住所地特例適用年月日は_コンストラクタ引数の_住所地特例適用年月日を返す() {
            assertThat(sut.get住所地特例適用年月日(), is(住所地特例適用年月日));
        }

        @Test
        public void get住所地特例解除事由は_コンストラクタ引数の_住所地特例解除事由を返す() {
            assertThat(sut.get住所地特例解除事由(), is(住所地特例解除事由));
        }

        @Test
        public void get住所地特例解除届出年月日は_コンストラクタ引数の_住所地特例解除届出年月日を返す() {
            assertThat(sut.get住所地特例解除届出年月日(), is(住所地特例解除届出年月日));
        }

        @Test
        public void get住所地特例解除年月日は_コンストラクタ引数の_住所地特例解除年月日を返す() {
            assertThat(sut.get住所地特例解除年月日(), is(住所地特例解除年月日));
        }

        @Test
        public void is住所地特例は_コンストラクタ引数の_住所地特例有無と同値を返す() {
            assertThat(sut.is住所地特例者(), is(住所地特例有無));
        }

        @Test
        public void is広域内住所地特例は_コンストラクタ引数の_広域内_住所地特例有無を返す() {
            assertThat(sut.is広域内住所地特者(), is(広域内_住所地特例有無));
        }

        @Test
        public void has被保険者証の再交付は_コンストラクタ引数の_再交付有無を返す() {
            assertThat(sut.has被保険者証の再交付(), is(再交付有無));
        }

        @Test
        public void get再交付事由は_コンストラクタ引数の_再交付事由を返す() {
            assertThat(sut.get再交付事由(), is(再交付事由));
        }

        @Test
        public void get市町村コードは_コンストラクタ引数の_市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void get広域内住所地特例措置元_市町村コードは_コンストラクタ引数の_広域内住所地特例措置元_市町村コードを返す() {
            assertThat(sut.get広域内住所地特例措置元_市町村コード(), is(広域内住所地特例措置元_市町村コード));
        }
    }

    private static Hihokensha create被保険者() {
        return new Hihokensha(介護保険資格, 市町村コード, 資格異動区分, 被保険者区分,
                資格変更事由, 資格変更届出年月日, 資格変更年月日,
                住所地特例適用事由, 住所地特例適用届出年月日, 住所地特例適用年月日,
                住所地特例解除事由, 住所地特例解除届出年月日, 住所地特例解除年月日,
                住所地特例有無, 広域内_住所地特例有無, 広域内住所地特例措置元_市町村コード, 再交付有無, 再交付事由);
    }

    private static IKaigoShikaku create介護保険資格() {
        return mock(_KaigoShikaku.class);
    }

    private static IShikakuShutokuJiyu create資格取得事由() {
        return ShikakuShutokuJiyuMock.createInstance();
    }

    private static IShikakuSoshitsuJiyu create資格喪失事由() {
        return ShikakuSoshitsuJiyuMock.createInstance();
    }
}
