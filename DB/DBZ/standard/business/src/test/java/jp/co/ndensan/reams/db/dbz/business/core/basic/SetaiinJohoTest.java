/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.jukikojin.IJukiKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.tsuzukigara.ITsuzukigaraList;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/**
 * {@link SetaiinJoho} のテストです。
 */
@RunWith(Enclosed.class)
public class SetaiinJohoTest {

    public SetaiinJohoTest() {
    }

    public static class IKojinへ変換できる {

        private IShikibetsuTaisho shikibetsuTaisho;
        private IKojin kojin;
        private SetaiinJoho sut;

        @Before
        public void setUp() {
            shikibetsuTaisho = Mockito.mock(IShikibetsuTaisho.class);
            kojin = Mockito.mock(IKojin.class);

            Mockito.when(shikibetsuTaisho.canBe個人()).thenReturn(true);
            Mockito.when(shikibetsuTaisho.to個人()).thenReturn(kojin);
        }

        @Test
        public void 住基個人へ変換できない場合_get住民票表示順は_0を返す() {
            Mockito.when(kojin.canBe住基個人()).thenReturn(false);
            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
            assertThat(sut.get住民票表示順(), is(0));
        }

        @Test
        public void 住基個人へ変換できる場合_get住民票表示順は_変換後の住基個人と同じ住民票表示順を返す() {
            Mockito.when(kojin.canBe住基個人()).thenReturn(true);

            IJukiKojin jukiKojin = Mockito.mock(IJukiKojin.class);
            Mockito.when(jukiKojin.get住民票表示順()).thenReturn(1);

            Mockito.when(kojin.to住基個人()).thenReturn(jukiKojin);

            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
            assertThat(sut.get住民票表示順(), is(1));
        }

        @Test
        public void get生年月日は_変換後のIKojinと同じ値を返す() {
            IDateOfBirth dob = Mockito.mock(IDateOfBirth.class);
            Mockito.when(dob.toFlexibleDate()).thenReturn(new FlexibleDate("20160430"));

            Mockito.when(kojin.get生年月日()).thenReturn(dob);

            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
            assertThat(sut.get生年月日(), is(new FlexibleDate("20160430")));
        }

        @Test
        public void get性別は_変換後のIKojinと同じ値を返す() {
            Mockito.when(kojin.get性別()).thenReturn(Gender.FEMALE);

            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
            assertThat(sut.get性別(), is(Gender.FEMALE));
        }

        @Test
        public void get続柄コードは_変換後のIKojinと同じ値を返す() {
            ITsuzukigaraList tl = Mockito.mock(ITsuzukigaraList.class);
            Mockito.when(tl.toTsuzukigaraCode()).thenReturn(new TsuzukigaraCode("1"));

            Mockito.when(kojin.get続柄コードリスト()).thenReturn(tl);

            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
            assertThat(sut.get続柄コード(), is(new TsuzukigaraCode("1").value()));
        }

        @Test
        public void get続柄は_変換後のIKojinと同じ値を返す() {
            Mockito.when(kojin.get続柄()).thenReturn(new RString("テスト"));

            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
            assertThat(sut.get続柄(), is(new RString("テスト")));
        }

        @Test
        public void get住民状態は_変換後のIKojinと同じ値を返す() {
            Mockito.when(kojin.get住民状態()).thenReturn(JuminJotai.住民);

            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
            assertThat(sut.get住民状態(), is(JuminJotai.住民));
        }

        @Test
        public void get住定異動年月日は_変換後のIKojinと同じ値を返す() {
            Mockito.when(kojin.get住定異動年月日()).thenReturn(new FlexibleDate("20160430"));

            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
            assertThat(sut.get住定異動年月日(), is(new FlexibleDate("20160430")));
        }

        @Test
        public void get世帯コードは_変換後のIKojinと同じ値を返す() {
            Mockito.when(kojin.get世帯コード()).thenReturn(new SetaiCode("20160430"));

            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
            assertThat(sut.get世帯コード(), is(new SetaiCode("20160430")));
        }

        @Test
        public void get本人区分は_コンストラクタの引数と同じ値を返す() {
            sut = new SetaiinJoho(shikibetsuTaisho, new RString("テスト"));
            assertThat(sut.get本人区分(), is(new RString("テスト")));
        }

        @Test
        public void get識別対象は_コンストラクタの引数と同じ値を返す() {
            sut = new SetaiinJoho(shikibetsuTaisho, new RString("テスト"));
            assertThat(sut.get識別対象(), is(shikibetsuTaisho));
        }
    }

    public static class IKojinへ変換できない {

        private IShikibetsuTaisho shikibetsuTaisho;
        private SetaiinJoho sut;

        @Before
        public void setUp() {
            shikibetsuTaisho = Mockito.mock(IShikibetsuTaisho.class);
            Mockito.when(shikibetsuTaisho.canBe個人()).thenReturn(false);
            sut = new SetaiinJoho(shikibetsuTaisho, RString.EMPTY);
        }

        @Test
        public void get住民票表示順は_0を返す() {
            assertThat(sut.get住民票表示順(), is(0));
        }

        @Test
        public void get生年月日は_FlexibleDate$EMPTYを返す() {
            assertThat(sut.get生年月日(), is(FlexibleDate.EMPTY));
        }

        @Test
        public void get性別は_Gender$未定義を返す() {
            assertThat(sut.get性別(), is(Gender.未定義));
        }

        @Test
        public void get続柄コードは_TsuzukigaraCode$EMPTYのコードと同じ値を返す() {
            assertThat(sut.get続柄コード(), is(TsuzukigaraCode.EMPTY.value()));
        }

        @Test
        public void get続柄は_RString$EMPTYを返す() {
            assertThat(sut.get続柄(), is(RString.EMPTY));
        }

        @Test
        public void get住民状態は_JuminJotai$未定義を返す() {
            assertThat(sut.get住民状態(), is(JuminJotai.未定義));
        }

        @Test
        public void get住定異動年月日は_FlexibleDate$EMPTYを返す() {
            assertThat(sut.get住定異動年月日(), is(FlexibleDate.EMPTY));
        }

        @Test
        public void get世帯コードは_SetaiCode$EMPTYを返す() {
            assertThat(sut.get世帯コード(), is(SetaiCode.EMPTY));
        }

        @Test
        public void get本人区分は_コンストラクタの引数と同じ値を返す() {
            sut = new SetaiinJoho(shikibetsuTaisho, new RString("テスト"));
            assertThat(sut.get本人区分(), is(new RString("テスト")));
        }

        @Test
        public void get識別対象は_コンストラクタの引数と同じ値を返す() {
            sut = new SetaiinJoho(shikibetsuTaisho, new RString("テスト"));
            assertThat(sut.get識別対象(), is(shikibetsuTaisho));
        }
    }
}
