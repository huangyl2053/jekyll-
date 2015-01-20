/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.GenderEditorA4Base;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4EditData;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoA4CommonEditData;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.GenderEditorA4Base}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GenderEditorA4BaseTest {

    private static IHihokenshashoA4CommonEditData target;
    private static GenderEditorA4Base sut;
    private static HihokenshashoModel model;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new GenderEditorA4Base(null);
            fail();
        }
    }

    public static class set性別 extends DbzTestBase {

        @Before
        public void setUp() {
            target = createTarget();
        }

        @Test
        public void 性同一障害考慮有りの場合_Seibetsuには何も設定されない() {
            model = createMockModel(Gender.MALE, seiDoitsuKoryo.有り);
            sut = new GenderEditorA4Base(model);
            sut.set性別(target);

            assertThat(target.getSeibetsu(), is(nullValue()));
        }

        @Test
        public void 性同一障害考慮無し_かつ性別が男の場合_Seibetsuには男が設定される() {
            model = createMockModel(Gender.MALE, seiDoitsuKoryo.無し);
            sut = new GenderEditorA4Base(model);
            sut.set性別(target);

            assertThat(target.getSeibetsu(), is(Gender.MALE.getCommonName()));
        }

        @Test
        public void 性同一障害考慮無し_かつ性別が女の場合_Seibetsuには女が設定される() {
            model = createMockModel(Gender.FEMALE, seiDoitsuKoryo.無し);
            sut = new GenderEditorA4Base(model);
            sut.set性別(target);

            assertThat(target.getSeibetsu(), is(Gender.FEMALE.getCommonName()));
        }

        private HihokenshashoModel createMockModel(Gender gender, seiDoitsuKoryo 考慮) {
            IKojin kojin = mock(IKojin.class);
            when(kojin.get性別()).thenReturn(gender);
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.is性同一障害用()).thenReturn(考慮.value);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getKojinJoho()).thenReturn(kojin);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }

    }

    private enum seiDoitsuKoryo {

        有り(true),
        無し(false);
        private final boolean value;

        private seiDoitsuKoryo(boolean value) {
            this.value = value;
        }
    }

    private static IHihokenshashoA4CommonEditData createTarget() {
        HihokenshashoA4 a4 = new HihokenshashoA4();
        return new HihokenshashoA4EditData(a4);
    }
}
