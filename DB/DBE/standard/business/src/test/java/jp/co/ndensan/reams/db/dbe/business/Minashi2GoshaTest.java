/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.business.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.model.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.model.IJusho;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * みなし2号者を表すクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class Minashi2GoshaTest {

    private static Minashi2Gosha sut;
    private static Minashi2GoshaDaicho daichoJoho;
    private static IKojin profile;

    @BeforeClass
    public static void setUpBeforeClass() {
        profile = mock(IKojin.class);
        daichoJoho = mock(Minashi2GoshaDaicho.class);
        sut = new Minashi2Gosha(daichoJoho, profile);
    }

    public static class constructorのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数のみなし2号台帳情報に_nullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Minashi2Gosha(null, profile);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 引数の個人情報に_nullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Minashi2Gosha(daichoJoho, null);
            fail();
        }

    }

    public static class みなし2号関連getterのテスト extends DbeTestBase {

        @Test
        public void get被保険者番号は_コンストラクタ引数のMinashi2GoshaDaichoが持つ被保険者番号と_同じ値を返す() {
            KaigoHihokenshaNo hihokenshaNo = new KaigoHihokenshaNo(new RString("0123456789"));
            when(daichoJoho.get被保険者番号()).thenReturn(hihokenshaNo);
            assertThat(sut.get被保険者番号(), is(hihokenshaNo));
        }

        @Test
        public void get識別コードは_コンストラクタ引数のMinashi2GoshaDaichoが持つ識別コードと_同じ値を返す() {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode("012345678900001");
            when(daichoJoho.get識別コード()).thenReturn(shikibetsuCode);
            assertThat(sut.get識別コード(), is(shikibetsuCode));
        }

        @Test
        public void getみなし2号被保険者区分コードは_コンストラクタ引数のMinashi2GoshaDaichoが持つみなし2号被保険者区分コードと_同じ値を返す() {
            HihokenshaKubun hihoKubun = new HihokenshaKubun(new Code("8"), new RString("みなし2号"));
            when(daichoJoho.get被保険者区分()).thenReturn(hihoKubun);
            assertThat(sut.get被保険者区分(), is(hihoKubun));
        }

        @Test
        public void get福祉被保険者番号は_コンストラクタ引数のMinashi2GoshaDaichoが持つ福祉被保険者番号と_同じ値を返す() {
            RString fukushiHihokenshaNo = new RString("0123456789");
            when(daichoJoho.get福祉被保険者番号()).thenReturn(fukushiHihokenshaNo);
            assertThat(sut.get福祉被保険者番号(), is(fukushiHihokenshaNo));
        }

        @Test
        public void get市町村コードは_コンストラクタ引数のMinashi2GoshaDaichoが持つ市町村コードと_同じ値を返す() {
            LasdecCode lasdecCode = new LasdecCode("012345");
            when(daichoJoho.get市町村コード()).thenReturn(lasdecCode);
            assertThat(sut.get市町村コード(), is(lasdecCode));
        }

        @Test
        public void get処理日時は_コンストラクタ引数のMinashi2GoshaDaichoが持つ処理日時と_同じ値を返す() {
            YMDHMS shoriDateTime = new YMDHMS("20071106010101");
            when(daichoJoho.get処理日時()).thenReturn(shoriDateTime);
            assertThat(sut.get処理日時(), is(shoriDateTime));
        }

        @Test
        public void get被保険者区分コードは_コンストラクタ引数のMinashi2GoshaDaichoが持つみなし2号被保険者区分コードと_同じ値を返す() {
            HihokenshaKubun hihoKubun = new HihokenshaKubun(new Code("8"), new RString("みなし2号"));
            when(daichoJoho.get被保険者区分()).thenReturn(hihoKubun);
            assertThat(sut.get被保険者区分(), is((HihokenshaKubun) hihoKubun));
        }

        @Test
        public void getみなし2号登録年月日は_コンストラクタ引数のMinashi2GoshaDaichoが持つみなし2号登録年月日と_同じ値を返す() {
            FlexibleDate torokuDate = new FlexibleDate("19990101");
            when(daichoJoho.getみなし2号登録年月日()).thenReturn(torokuDate);
            assertThat(sut.getみなし2号登録年月日(), is(torokuDate));
        }

        @Test
        public void getみなし2号解除年月日は_コンストラクタ引数のMinashi2GoshaDaichoが持つみなし2号解除年月日と_同じ値を返す() {
            FlexibleDate kaijoDate = new FlexibleDate("19991231");
            when(daichoJoho.getみなし2号解除年月日()).thenReturn(kaijoDate);
            assertThat(sut.getみなし2号解除年月日(), is(kaijoDate));
        }

    }

    public static class 個人関連getterのテスト extends DbeTestBase {

        @Test
        public void get氏名は_コンストラクタ引数のIKojinが持つ氏名と_同じ値を返す() {
            IName shimei = mock(IName.class);
            when(profile.get氏名()).thenReturn(shimei);
            assertThat(sut.get氏名(), is(shimei));
        }

        @Test
        public void get性別は_コンストラクタ引数のIKojinが持つ性別と_同じ値を返す() {
            Gender gender = Gender.MALE;
            when(profile.get性別()).thenReturn(gender);
            assertThat(sut.get性別(), is(gender));
        }

        @Test
        public void get生年月日は_コンストラクタ引数のIKojinが持つ生年月日と_同じ値を返す() {
            IDateOfBirth dataOfBirth = mock(IDateOfBirth.class);
            when(profile.get生年月日()).thenReturn(dataOfBirth);
            assertThat(sut.get生年月日(), is(dataOfBirth));
        }

        @Test
        public void get住所は_コンストラクタ引数のIKojinが持つ住所と_同じ値を返す() {
            IJusho jusho = mock(IJusho.class);
            when(profile.get住所()).thenReturn(jusho);
            assertThat(sut.get住所(), is(jusho));
        }

        @Test
        public void get世帯コードは_コンストラクタ引数のIKojinが持つ世帯コードと_同じ値を返す() {
            SetaiCode setaiCode = new SetaiCode("01234");
            when(profile.get世帯コード()).thenReturn(setaiCode);
            assertThat(sut.get世帯コード(), is(setaiCode));
        }

        @Test
        public void get個人番号は_コンストラクタ引数のIKojinが持つ個人番号と_同じ値を返す() {
            RString kojinNo = new RString("0123456789");
            when(profile.get個人番号()).thenReturn(new KojinNo(kojinNo));
            assertThat(sut.get個人番号(), is(kojinNo));
        }

        @Test
        public void get住民種別は_コンストラクタ引数のIKojinが持つ住民種別と_同じ値を返す() {
            JuminShubetsu juminShubetsu = JuminShubetsu.日本人;
            when(profile.get住民種別()).thenReturn(juminShubetsu);
            assertThat(sut.get住民種別(), is(juminShubetsu));
        }
    }

}
