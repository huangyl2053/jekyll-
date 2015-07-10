/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoB4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoB4UpperEditData;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoB4CommonEditData;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ua.uax.business.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.DateOfBirthEditorB4Base}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class DateOfBirthEditorB4BaseTest {

    private static IHihokenshashoB4CommonEditData target;
    private static DateOfBirthEditorB4Base sut;
    private static HihokenshashoModel model;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new DateOfBirthEditorB4Base(null);
            fail();
        }
    }

    @RunWith(Enclosed.class)
    public static class set生年月日 extends DbzTestBase {

        public static class 元号の塗りつぶし extends DbzTestBase {

            private RString dateOfBirthStr;
            private RString daubWord;

            @Before
            public void setUp() {
                target = createTarget();
                daubWord = new RString("**");

            }

            @Test
            public void 日本人かつ明治生まれの場合_UmareMeiji1には何も設定されない() {
                dateOfBirthStr = new RString("19000107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMeiji1(), is(nullValue()));
            }

            @Test
            public void 日本人かつ明治生まれの場合_UmareTaisho1に塗りつぶしの文字が設定される() {
                dateOfBirthStr = new RString("19000107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareTaisho1(), is(daubWord));
            }

            @Test
            public void 日本人かつ明治生まれの場合_UmareShowa1に塗りつぶしの文字が設定される() {
                dateOfBirthStr = new RString("19000107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareShowa1(), is(daubWord));
            }

            @Test
            public void 日本人かつ大正生まれの場合_UmareMeiji1に塗りつぶしの文字が設定される() {
                dateOfBirthStr = new RString("19200107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMeiji1(), is(daubWord));
            }

            @Test
            public void 日本人かつ大正生まれの場合_UmareTaisho1には何も設定されない() {
                dateOfBirthStr = new RString("19200107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareTaisho1(), is(nullValue()));
            }

            @Test
            public void 日本人かつ大正生まれの場合_UmareShowa1に塗りつぶしの文字が設定される() {
                dateOfBirthStr = new RString("19200107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareShowa1(), is(daubWord));
            }

            @Test
            public void 日本人かつ昭和生まれの場合_UmareMeiji1に塗りつぶしの文字が設定される() {
                dateOfBirthStr = new RString("19600107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMeiji1(), is(daubWord));
            }

            @Test
            public void 日本人かつ昭和生まれの場合_UmareTaisho1に塗りつぶしの文字が設定される() {
                dateOfBirthStr = new RString("19600107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareTaisho1(), is(daubWord));
            }

            @Test
            public void 日本人かつ昭和生まれの場合_UmareShowa1には何も設定されない() {
                dateOfBirthStr = new RString("19600107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareShowa1(), is(nullValue()));
            }

            @Test
            public void 外国人の場合_UmareMeiji1に塗りつぶしの文字が設定される() {
                dateOfBirthStr = new RString("19600107");
                model = createMockModel(dateOfBirthStr, Jinshu.外国人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMeiji1(), is(daubWord));
            }

            @Test
            public void 外国人の場合_UmareTaisho1に塗りつぶしの文字が設定される() {
                dateOfBirthStr = new RString("19600107");
                model = createMockModel(dateOfBirthStr, Jinshu.外国人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareTaisho1(), is(daubWord));
            }

            @Test
            public void 外国人の場合_UmareShowa1に塗りつぶしの文字が設定される() {
                dateOfBirthStr = new RString("19600107");
                model = createMockModel(dateOfBirthStr, Jinshu.外国人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareShowa1(), is(daubWord));
            }

            @Test
            public void 日本人かつ明治_大正_昭和いずれの時代の生まれでも無い場合_UmareMeiji1は何も設定されない() {
                dateOfBirthStr = new RString("20020107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMeiji1(), is(nullValue()));
            }

            @Test
            public void 日本人かつ明治_大正_昭和いずれの時代の生まれでも無い場合_UmareTaisho1は何も設定されない() {
                dateOfBirthStr = new RString("20020107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareTaisho1(), is(nullValue()));
            }

            @Test
            public void 日本人かつ明治_大正_昭和いずれの時代の生まれでも無い場合_UmareShowa1は何も設定されない() {
                dateOfBirthStr = new RString("20020107");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareShowa1(), is(nullValue()));
            }

        }

        public static class 年月日の設定 extends DbzTestBase {

            private RString dateOfBirthStr;
            private RString nendoYyStr;
            private RString nendoYyyyStr;
            private RString monthStr;
            private RString dayStr;

            @Before
            public void setUp() {
                target = createTarget();

                dateOfBirthStr = new RString("19600107");
                nendoYyStr = new RString("35");
                nendoYyyyStr = new RString("1960");
                monthStr = new RString(" 1");
                dayStr = new RString(" 7");

            }

            @Test
            public void 生年月日が1960年01月07日の場合かつ_日本人の場合_UmareYy1に35が設定される() {
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareYy1(), is(nendoYyStr));
            }

            @Test
            public void 生年月日が1960年01月07日の場合かつ_日本人の場合_UmareMm1に_1が設定される() {
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMm1(), is(monthStr));
            }

            @Test
            public void 生年月日が1960年01月07日の場合かつ_日本人の場合_UmareDd1に_7が設定される() {
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareDd1(), is(dayStr));
            }

            @Test
            public void 生年月日が1960年01月07日の場合かつ_日本人の場合_UmareYyyy1に何も設定されない() {
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareYyyy1(), is(nullValue()));
            }

            @Test
            public void 生年月日が1960年01月07日の場合かつ_日本人の場合_UmareMmS1に何も設定されない() {
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMmS1(), is(nullValue()));
            }

            @Test
            public void 生年月日が1960年01月07日の場合かつ_日本人の場合_UmareDdS1に何も設定されない() {
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareDdS1(), is(nullValue()));
            }

            @Test
            public void 生年月日が2002年01月07日の場合かつ_日本人の場合_UmareYy1に何も設定されない() {
                dateOfBirthStr = new RString("20020107");
                nendoYyStr = new RString("14");
                nendoYyyyStr = new RString("2002");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareYy1(), is(nullValue()));
            }

            @Test
            public void 生年月日が2002年01月07日の場合かつ_日本人の場合_UmareMm1に何も設定されない() {
                dateOfBirthStr = new RString("20020107");
                nendoYyStr = new RString("14");
                nendoYyyyStr = new RString("2002");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMm1(), is(nullValue()));
            }

            @Test
            public void 生年月日が2002年01月07日の場合かつ_日本人の場合_UmareDd1に何も設定されない() {
                dateOfBirthStr = new RString("20020107");
                nendoYyStr = new RString("14");
                nendoYyyyStr = new RString("2002");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareDd1(), is(nullValue()));
            }

            @Test
            public void 生年月日が2002年01月07日の場合かつ_日本人の場合_UmareYyyy1に2002が設定される() {
                dateOfBirthStr = new RString("20020107");
                nendoYyStr = new RString("14");
                nendoYyyyStr = new RString("2002");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareYyyy1(), is(nendoYyyyStr));
            }

            @Test
            public void 生年月日が2002年01月07日の場合かつ_日本人の場合_UmareMmS1に_1が設定される() {
                dateOfBirthStr = new RString("20020107");
                nendoYyStr = new RString("14");
                nendoYyyyStr = new RString("2002");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMmS1(), is(monthStr));
            }

            @Test
            public void 生年月日が2002年01月07日の場合かつ_日本人の場合_UmareDdS1に_7が設定される() {
                dateOfBirthStr = new RString("20020107");
                nendoYyStr = new RString("14");
                nendoYyyyStr = new RString("2002");
                model = createMockModel(dateOfBirthStr, Jinshu.日本人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareDdS1(), is(dayStr));
            }

            @Test
            public void 外国人の場合_UmareYy1に何も設定されない() {
                model = createMockModel(dateOfBirthStr, Jinshu.外国人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareYy1(), is(nullValue()));
            }

            @Test
            public void 外国人の場合_UmareMm1に何も設定されない() {
                model = createMockModel(dateOfBirthStr, Jinshu.外国人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMm1(), is(nullValue()));
            }

            @Test
            public void 外国人の場合_UmareDd1に何も設定されない() {
                model = createMockModel(dateOfBirthStr, Jinshu.外国人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareDd1(), is(nullValue()));
            }

            @Test
            public void 外国人の場合_UmareYyyy1に1960が設定される() {
                model = createMockModel(dateOfBirthStr, Jinshu.外国人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareYyyy1(), is(nendoYyyyStr));
            }

            @Test
            public void 外国人の場合_UmareMmS1に_1が設定される() {
                model = createMockModel(dateOfBirthStr, Jinshu.外国人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareMmS1(), is(monthStr));
            }

            @Test
            public void 外国人の場合_UmareDdS1に_7が設定される() {
                model = createMockModel(dateOfBirthStr, Jinshu.外国人);
                sut = new DateOfBirthEditorB4Base(model);
                sut.set生年月日(target);
                assertThat(target.getUmareDdS1(), is(dayStr));
            }
        }

        private static HihokenshashoModel createMockModel(RString dateOfBirthStr, Jinshu 人種) {
            IDateOfBirth dateOfBirth = mock(IDateOfBirth.class);
            when(dateOfBirth.toDate()).thenReturn(new RDate(dateOfBirthStr.toString()));
            IKojin kojin = mock(IKojin.class);
            when(kojin.get生年月日()).thenReturn(dateOfBirth);
            when(kojin.is日本人()).thenReturn(人種.value);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getKojinJoho()).thenReturn(kojin);
            return hihokenshashoModel;
        }

        private static enum Jinshu {

            日本人(true),
            外国人(false);
            private final boolean value;

            private Jinshu(boolean value) {
                this.value = value;
            }
        }
    }

    private static IHihokenshashoB4CommonEditData createTarget() {
        HihokenshashoB4 b4 = new HihokenshashoB4();
        return new HihokenshashoB4UpperEditData(b4);
    }
}
