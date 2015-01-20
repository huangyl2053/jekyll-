/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4EditData;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoA4CommonEditData;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.model.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
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
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.DateOfBirthEditorA4Base}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class DateOfBirthEditorA4BaseTest {

    private static IHihokenshashoA4CommonEditData target;
    private static DateOfBirthEditorA4Base sut;
    private static HihokenshashoModel model;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new DateOfBirthEditorA4Base(null);
            fail();
        }
    }

    public static class set生年月日 extends DbzTestBase {

        private RString dateOfBirthStr;
        private RString gengoStr;
        private RString nendoYyStr;
        private RString nendoYyyyStr;
        private RString monthStr;
        private RString dayStr;

        @Before
        public void setUp() {
            target = createTarget();

            dateOfBirthStr = new RString("19600107");
            gengoStr = new RString("昭和");
            nendoYyStr = new RString("35");
            nendoYyyyStr = new RString("1960");
            monthStr = new RString(" 1");
            dayStr = new RString(" 7");

        }

        @Test
        public void 生年月日が1960年01月07日の場合かつ_日本人の場合_UmareGに昭和が設定される() {
            model = createMockModel(dateOfBirthStr, Jinshu.日本人);
            sut = new DateOfBirthEditorA4Base(model);
            sut.set生年月日(target);
            assertThat(target.getUmareG(), is(gengoStr));
        }

        @Test
        public void 生年月日が1960年01月07日の場合かつ_外国人の場合_UmareGに何も設定されない() {
            model = createMockModel(dateOfBirthStr, Jinshu.外国人);
            sut = new DateOfBirthEditorA4Base(model);
            sut.set生年月日(target);
            assertThat(target.getUmareG(), is(nullValue()));
        }

        @Test
        public void 生年月日が1960年01月07日の場合かつ_日本人の場合_UmareYyに35が設定される() {
            model = createMockModel(dateOfBirthStr, Jinshu.日本人);
            sut = new DateOfBirthEditorA4Base(model);
            sut.set生年月日(target);
            assertThat(target.getUmareYy(), is(nendoYyStr));
        }

        @Test
        public void 生年月日が1960年01月07日の場合かつ_外国人の場合_UmareYyは何も設定されない() {
            model = createMockModel(dateOfBirthStr, Jinshu.外国人);
            sut = new DateOfBirthEditorA4Base(model);
            sut.set生年月日(target);
            assertThat(target.getUmareYy(), is(nullValue()));
        }

        @Test
        public void 生年月日が1960年01月07日の場合かつ_日本人の場合_UmareYyyyには何も設定されない() {
            model = createMockModel(dateOfBirthStr, Jinshu.日本人);
            sut = new DateOfBirthEditorA4Base(model);
            sut.set生年月日(target);
            assertThat(target.getUmareYyyy(), is(nullValue()));
        }

        @Test
        public void 生年月日が1960年01月07日の場合かつ_外国人の場合_UmareYyyyは1960が設定される() {
            model = createMockModel(dateOfBirthStr, Jinshu.外国人);
            sut = new DateOfBirthEditorA4Base(model);
            sut.set生年月日(target);
            assertThat(target.getUmareYyyy(), is(nendoYyyyStr));
        }

        @Test
        public void 生年月日が1960年01月07日の場合_UmareMmに_1が設定される() {
            sut = new DateOfBirthEditorA4Base(model);
            sut.set生年月日(target);
            assertThat(target.getUmareMm(), is(monthStr));
        }

        @Test
        public void 生年月日が1960年01月07日の場合_UmareDdに_7が設定される() {
            sut = new DateOfBirthEditorA4Base(model);
            sut.set生年月日(target);
            assertThat(target.getUmareDd(), is(dayStr));
        }

        private HihokenshashoModel createMockModel(RString dateOfBirthStr, Jinshu 人種) {
            IDateOfBirth dateOfBirth = mock(IDateOfBirth.class);
            when(dateOfBirth.toDate()).thenReturn(new RDate(dateOfBirthStr.toString()));
            IKojin kojin = mock(IKojin.class);
            when(kojin.get生年月日()).thenReturn(dateOfBirth);
            when(kojin.is日本人()).thenReturn(人種.value);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getKojinJoho()).thenReturn(kojin);
            return hihokenshashoModel;
        }

        private enum Jinshu {

            日本人(true),
            外国人(false);
            private final boolean value;

            private Jinshu(boolean value) {
                this.value = value;
            }
        }
    }

    private static IHihokenshashoA4CommonEditData createTarget() {
        HihokenshashoA4 a4 = new HihokenshashoA4();
        return new HihokenshashoA4EditData(a4);
    }

}
